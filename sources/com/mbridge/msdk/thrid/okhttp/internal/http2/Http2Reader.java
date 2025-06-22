package com.mbridge.msdk.thrid.okhttp.internal.http2;

import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.thrid.okhttp.internal.http2.Hpack;
import com.mbridge.msdk.thrid.okio.Buffer;
import com.mbridge.msdk.thrid.okio.BufferedSource;
import com.mbridge.msdk.thrid.okio.ByteString;
import com.mbridge.msdk.thrid.okio.Source;
import com.mbridge.msdk.thrid.okio.Timeout;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

final class Http2Reader implements Closeable, AutoCloseable {
    static final Logger logger = Logger.getLogger(Http2.class.getName());
    private final boolean client;
    private final ContinuationSource continuation;
    final Hpack.Reader hpackReader;
    private final BufferedSource source;

    static final class ContinuationSource implements Source, AutoCloseable {
        byte flags;
        int left;
        int length;
        short padding;
        private final BufferedSource source;
        int streamId;

        ContinuationSource(BufferedSource bufferedSource) {
            this.source = bufferedSource;
        }

        private void readContinuationHeader() throws IOException {
            int i4 = this.streamId;
            int readMedium = Http2Reader.readMedium(this.source);
            this.left = readMedium;
            this.length = readMedium;
            byte readByte = (byte) (this.source.readByte() & 255);
            this.flags = (byte) (this.source.readByte() & 255);
            Logger logger = Http2Reader.logger;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(Http2.frameLog(true, this.streamId, this.length, readByte, this.flags));
            }
            int readInt = this.source.readInt() & Integer.MAX_VALUE;
            this.streamId = readInt;
            if (readByte != 9) {
                throw Http2.ioException("%s != TYPE_CONTINUATION", Byte.valueOf(readByte));
            } else if (readInt != i4) {
                throw Http2.ioException("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }

        public void close() throws IOException {
        }

        public long read(Buffer buffer, long j4) throws IOException {
            while (true) {
                int i4 = this.left;
                if (i4 == 0) {
                    this.source.skip((long) this.padding);
                    this.padding = 0;
                    if ((this.flags & 4) != 0) {
                        return -1;
                    }
                    readContinuationHeader();
                } else {
                    long read = this.source.read(buffer, Math.min(j4, (long) i4));
                    if (read == -1) {
                        return -1;
                    }
                    this.left = (int) (((long) this.left) - read);
                    return read;
                }
            }
        }

        public Timeout timeout() {
            return this.source.timeout();
        }
    }

    interface Handler {
        void ackSettings();

        void alternateService(int i4, String str, ByteString byteString, String str2, int i5, long j4);

        void data(boolean z4, int i4, BufferedSource bufferedSource, int i5) throws IOException;

        void goAway(int i4, ErrorCode errorCode, ByteString byteString);

        void headers(boolean z4, int i4, int i5, List<Header> list);

        void ping(boolean z4, int i4, int i5);

        void priority(int i4, int i5, int i6, boolean z4);

        void pushPromise(int i4, int i5, List<Header> list) throws IOException;

        void rstStream(int i4, ErrorCode errorCode);

        void settings(boolean z4, Settings settings);

        void windowUpdate(int i4, long j4);
    }

    Http2Reader(BufferedSource bufferedSource, boolean z4) {
        this.source = bufferedSource;
        this.client = z4;
        ContinuationSource continuationSource = new ContinuationSource(bufferedSource);
        this.continuation = continuationSource;
        this.hpackReader = new Hpack.Reader(4096, continuationSource);
    }

    static int lengthWithoutPadding(int i4, byte b5, short s4) throws IOException {
        if ((b5 & 8) != 0) {
            i4--;
        }
        if (s4 <= i4) {
            return (short) (i4 - s4);
        }
        throw Http2.ioException("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s4), Integer.valueOf(i4));
    }

    private void readData(Handler handler, int i4, byte b5, int i5) throws IOException {
        boolean z4;
        short s4 = 0;
        if (i5 != 0) {
            if ((b5 & 1) != 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            if ((b5 & 32) == 0) {
                if ((b5 & 8) != 0) {
                    s4 = (short) (this.source.readByte() & 255);
                }
                handler.data(z4, i5, this.source, lengthWithoutPadding(i4, b5, s4));
                this.source.skip((long) s4);
                return;
            }
            throw Http2.ioException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        throw Http2.ioException("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
    }

    private void readGoAway(Handler handler, int i4, byte b5, int i5) throws IOException {
        if (i4 < 8) {
            throw Http2.ioException("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i4));
        } else if (i5 == 0) {
            int readInt = this.source.readInt();
            int readInt2 = this.source.readInt();
            int i6 = i4 - 8;
            ErrorCode fromHttp2 = ErrorCode.fromHttp2(readInt2);
            if (fromHttp2 != null) {
                ByteString byteString = ByteString.EMPTY;
                if (i6 > 0) {
                    byteString = this.source.readByteString((long) i6);
                }
                handler.goAway(readInt, fromHttp2, byteString);
                return;
            }
            throw Http2.ioException("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(readInt2));
        } else {
            throw Http2.ioException("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
    }

    private List<Header> readHeaderBlock(int i4, short s4, byte b5, int i5) throws IOException {
        ContinuationSource continuationSource = this.continuation;
        continuationSource.left = i4;
        continuationSource.length = i4;
        continuationSource.padding = s4;
        continuationSource.flags = b5;
        continuationSource.streamId = i5;
        this.hpackReader.readHeaders();
        return this.hpackReader.getAndResetHeaderList();
    }

    private void readHeaders(Handler handler, int i4, byte b5, int i5) throws IOException {
        boolean z4;
        short s4 = 0;
        if (i5 != 0) {
            if ((b5 & 1) != 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            if ((b5 & 8) != 0) {
                s4 = (short) (this.source.readByte() & 255);
            }
            if ((b5 & 32) != 0) {
                readPriority(handler, i5);
                i4 -= 5;
            }
            handler.headers(z4, i5, -1, readHeaderBlock(lengthWithoutPadding(i4, b5, s4), s4, b5, i5));
            return;
        }
        throw Http2.ioException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
    }

    static int readMedium(BufferedSource bufferedSource) throws IOException {
        return (bufferedSource.readByte() & 255) | ((bufferedSource.readByte() & 255) << 16) | ((bufferedSource.readByte() & 255) << 8);
    }

    private void readPing(Handler handler, int i4, byte b5, int i5) throws IOException {
        boolean z4 = true;
        if (i4 != 8) {
            throw Http2.ioException("TYPE_PING length != 8: %s", Integer.valueOf(i4));
        } else if (i5 == 0) {
            int readInt = this.source.readInt();
            int readInt2 = this.source.readInt();
            if ((b5 & 1) == 0) {
                z4 = false;
            }
            handler.ping(z4, readInt, readInt2);
        } else {
            throw Http2.ioException("TYPE_PING streamId != 0", new Object[0]);
        }
    }

    private void readPriority(Handler handler, int i4, byte b5, int i5) throws IOException {
        if (i4 != 5) {
            throw Http2.ioException("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i4));
        } else if (i5 != 0) {
            readPriority(handler, i5);
        } else {
            throw Http2.ioException("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
    }

    private void readPushPromise(Handler handler, int i4, byte b5, int i5) throws IOException {
        short s4 = 0;
        if (i5 != 0) {
            if ((b5 & 8) != 0) {
                s4 = (short) (this.source.readByte() & 255);
            }
            handler.pushPromise(i5, this.source.readInt() & Integer.MAX_VALUE, readHeaderBlock(lengthWithoutPadding(i4 - 4, b5, s4), s4, b5, i5));
            return;
        }
        throw Http2.ioException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
    }

    private void readRstStream(Handler handler, int i4, byte b5, int i5) throws IOException {
        if (i4 != 4) {
            throw Http2.ioException("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i4));
        } else if (i5 != 0) {
            int readInt = this.source.readInt();
            ErrorCode fromHttp2 = ErrorCode.fromHttp2(readInt);
            if (fromHttp2 != null) {
                handler.rstStream(i5, fromHttp2);
                return;
            }
            throw Http2.ioException("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(readInt));
        } else {
            throw Http2.ioException("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
    }

    private void readSettings(Handler handler, int i4, byte b5, int i5) throws IOException {
        if (i5 != 0) {
            throw Http2.ioException("TYPE_SETTINGS streamId != 0", new Object[0]);
        } else if ((b5 & 1) != 0) {
            if (i4 == 0) {
                handler.ackSettings();
                return;
            }
            throw Http2.ioException("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
        } else if (i4 % 6 == 0) {
            Settings settings = new Settings();
            for (int i6 = 0; i6 < i4; i6 += 6) {
                short readShort = this.source.readShort() & 65535;
                int readInt = this.source.readInt();
                if (readShort != 2) {
                    if (readShort == 3) {
                        readShort = 4;
                    } else if (readShort != 4) {
                        if (readShort == 5 && (readInt < 16384 || readInt > 16777215)) {
                            throw Http2.ioException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(readInt));
                        }
                    } else if (readInt >= 0) {
                        readShort = 7;
                    } else {
                        throw Http2.ioException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                    }
                } else if (!(readInt == 0 || readInt == 1)) {
                    throw Http2.ioException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                }
                settings.set(readShort, readInt);
            }
            handler.settings(false, settings);
        } else {
            throw Http2.ioException("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i4));
        }
    }

    private void readWindowUpdate(Handler handler, int i4, byte b5, int i5) throws IOException {
        if (i4 == 4) {
            long readInt = ((long) this.source.readInt()) & 2147483647L;
            if (readInt != 0) {
                handler.windowUpdate(i5, readInt);
            } else {
                throw Http2.ioException("windowSizeIncrement was 0", Long.valueOf(readInt));
            }
        } else {
            throw Http2.ioException("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i4));
        }
    }

    public void close() throws IOException {
        this.source.close();
    }

    public boolean nextFrame(boolean z4, Handler handler) throws IOException {
        try {
            this.source.require(9);
            int readMedium = readMedium(this.source);
            if (readMedium < 0 || readMedium > 16384) {
                throw Http2.ioException("FRAME_SIZE_ERROR: %s", Integer.valueOf(readMedium));
            }
            byte readByte = (byte) (this.source.readByte() & 255);
            if (!z4 || readByte == 4) {
                byte readByte2 = (byte) (this.source.readByte() & 255);
                int readInt = this.source.readInt() & Integer.MAX_VALUE;
                Logger logger2 = logger;
                if (logger2.isLoggable(Level.FINE)) {
                    logger2.fine(Http2.frameLog(true, readInt, readMedium, readByte, readByte2));
                }
                switch (readByte) {
                    case 0:
                        readData(handler, readMedium, readByte2, readInt);
                        break;
                    case 1:
                        readHeaders(handler, readMedium, readByte2, readInt);
                        break;
                    case 2:
                        readPriority(handler, readMedium, readByte2, readInt);
                        break;
                    case 3:
                        readRstStream(handler, readMedium, readByte2, readInt);
                        break;
                    case 4:
                        readSettings(handler, readMedium, readByte2, readInt);
                        break;
                    case 5:
                        readPushPromise(handler, readMedium, readByte2, readInt);
                        break;
                    case 6:
                        readPing(handler, readMedium, readByte2, readInt);
                        break;
                    case 7:
                        readGoAway(handler, readMedium, readByte2, readInt);
                        break;
                    case 8:
                        readWindowUpdate(handler, readMedium, readByte2, readInt);
                        break;
                    default:
                        this.source.skip((long) readMedium);
                        break;
                }
                return true;
            }
            throw Http2.ioException("Expected a SETTINGS frame but was %s", Byte.valueOf(readByte));
        } catch (IOException unused) {
            return false;
        }
    }

    public void readConnectionPreface(Handler handler) throws IOException {
        if (!this.client) {
            BufferedSource bufferedSource = this.source;
            ByteString byteString = Http2.CONNECTION_PREFACE;
            ByteString readByteString = bufferedSource.readByteString((long) byteString.size());
            Logger logger2 = logger;
            if (logger2.isLoggable(Level.FINE)) {
                logger2.fine(Util.format("<< CONNECTION %s", readByteString.hex()));
            }
            if (!byteString.equals(readByteString)) {
                throw Http2.ioException("Expected a connection header but was %s", readByteString.utf8());
            }
        } else if (!nextFrame(true, handler)) {
            throw Http2.ioException("Required SETTINGS preface not received", new Object[0]);
        }
    }

    private void readPriority(Handler handler, int i4) throws IOException {
        int readInt = this.source.readInt();
        handler.priority(i4, readInt & Integer.MAX_VALUE, (this.source.readByte() & 255) + 1, (Integer.MIN_VALUE & readInt) != 0);
    }
}
