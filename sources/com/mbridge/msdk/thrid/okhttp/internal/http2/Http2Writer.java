package com.mbridge.msdk.thrid.okhttp.internal.http2;

import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.thrid.okhttp.internal.http2.Hpack;
import com.mbridge.msdk.thrid.okio.Buffer;
import com.mbridge.msdk.thrid.okio.BufferedSink;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

final class Http2Writer implements Closeable, AutoCloseable {
    private static final Logger logger = Logger.getLogger(Http2.class.getName());
    private final boolean client;
    private boolean closed;
    private final Buffer hpackBuffer;
    final Hpack.Writer hpackWriter;
    private int maxFrameSize = 16384;
    private final BufferedSink sink;

    Http2Writer(BufferedSink bufferedSink, boolean z4) {
        this.sink = bufferedSink;
        this.client = z4;
        Buffer buffer = new Buffer();
        this.hpackBuffer = buffer;
        this.hpackWriter = new Hpack.Writer(buffer);
    }

    private void writeContinuationFrames(int i4, long j4) throws IOException {
        byte b5;
        while (j4 > 0) {
            int min = (int) Math.min((long) this.maxFrameSize, j4);
            long j5 = (long) min;
            j4 -= j5;
            if (j4 == 0) {
                b5 = 4;
            } else {
                b5 = 0;
            }
            frameHeader(i4, min, (byte) 9, b5);
            this.sink.write(this.hpackBuffer, j5);
        }
    }

    private static void writeMedium(BufferedSink bufferedSink, int i4) throws IOException {
        bufferedSink.writeByte((i4 >>> 16) & 255);
        bufferedSink.writeByte((i4 >>> 8) & 255);
        bufferedSink.writeByte(i4 & 255);
    }

    public synchronized void applyAndAckSettings(Settings settings) throws IOException {
        try {
            if (!this.closed) {
                this.maxFrameSize = settings.getMaxFrameSize(this.maxFrameSize);
                if (settings.getHeaderTableSize() != -1) {
                    this.hpackWriter.setHeaderTableSizeSetting(settings.getHeaderTableSize());
                }
                frameHeader(0, 0, (byte) 4, (byte) 1);
                this.sink.flush();
            } else {
                throw new IOException("closed");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void close() throws IOException {
        this.closed = true;
        this.sink.close();
    }

    public synchronized void connectionPreface() throws IOException {
        try {
            if (this.closed) {
                throw new IOException("closed");
            } else if (this.client) {
                Logger logger2 = logger;
                if (logger2.isLoggable(Level.FINE)) {
                    logger2.fine(Util.format(">> CONNECTION %s", Http2.CONNECTION_PREFACE.hex()));
                }
                this.sink.write(Http2.CONNECTION_PREFACE.toByteArray());
                this.sink.flush();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void data(boolean z4, int i4, Buffer buffer, int i5) throws IOException {
        byte b5;
        if (!this.closed) {
            if (z4) {
                b5 = (byte) 1;
            } else {
                b5 = 0;
            }
            dataFrame(i4, b5, buffer, i5);
        } else {
            throw new IOException("closed");
        }
    }

    /* access modifiers changed from: package-private */
    public void dataFrame(int i4, byte b5, Buffer buffer, int i5) throws IOException {
        frameHeader(i4, i5, (byte) 0, b5);
        if (i5 > 0) {
            this.sink.write(buffer, (long) i5);
        }
    }

    public synchronized void flush() throws IOException {
        if (!this.closed) {
            this.sink.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public void frameHeader(int i4, int i5, byte b5, byte b6) throws IOException {
        Logger logger2 = logger;
        if (logger2.isLoggable(Level.FINE)) {
            logger2.fine(Http2.frameLog(false, i4, i5, b5, b6));
        }
        int i6 = this.maxFrameSize;
        if (i5 > i6) {
            throw Http2.illegalArgument("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i6), Integer.valueOf(i5));
        } else if ((Integer.MIN_VALUE & i4) == 0) {
            writeMedium(this.sink, i5);
            this.sink.writeByte(b5 & 255);
            this.sink.writeByte(b6 & 255);
            this.sink.writeInt(i4 & Integer.MAX_VALUE);
        } else {
            throw Http2.illegalArgument("reserved bit set: %s", Integer.valueOf(i4));
        }
    }

    public synchronized void goAway(int i4, ErrorCode errorCode, byte[] bArr) throws IOException {
        try {
            if (this.closed) {
                throw new IOException("closed");
            } else if (errorCode.httpCode != -1) {
                frameHeader(0, bArr.length + 8, (byte) 7, (byte) 0);
                this.sink.writeInt(i4);
                this.sink.writeInt(errorCode.httpCode);
                if (bArr.length > 0) {
                    this.sink.write(bArr);
                }
                this.sink.flush();
            } else {
                throw Http2.illegalArgument("errorCode.httpCode == -1", new Object[0]);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void headers(int i4, List<Header> list) throws IOException {
        if (!this.closed) {
            headers(false, i4, list);
        } else {
            throw new IOException("closed");
        }
    }

    public int maxDataLength() {
        return this.maxFrameSize;
    }

    public synchronized void ping(boolean z4, int i4, int i5) throws IOException {
        if (!this.closed) {
            frameHeader(0, 8, (byte) 6, z4 ? (byte) 1 : 0);
            this.sink.writeInt(i4);
            this.sink.writeInt(i5);
            this.sink.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void pushPromise(int i4, int i5, List<Header> list) throws IOException {
        byte b5;
        if (!this.closed) {
            this.hpackWriter.writeHeaders(list);
            long size = this.hpackBuffer.size();
            int min = (int) Math.min((long) (this.maxFrameSize - 4), size);
            long j4 = (long) min;
            int i6 = (size > j4 ? 1 : (size == j4 ? 0 : -1));
            if (i6 == 0) {
                b5 = 4;
            } else {
                b5 = 0;
            }
            frameHeader(i4, min + 4, (byte) 5, b5);
            this.sink.writeInt(i5 & Integer.MAX_VALUE);
            this.sink.write(this.hpackBuffer, j4);
            if (i6 > 0) {
                writeContinuationFrames(i4, size - j4);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void rstStream(int i4, ErrorCode errorCode) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        } else if (errorCode.httpCode != -1) {
            frameHeader(i4, 4, (byte) 3, (byte) 0);
            this.sink.writeInt(errorCode.httpCode);
            this.sink.flush();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public synchronized void settings(Settings settings) throws IOException {
        int i4;
        try {
            if (!this.closed) {
                frameHeader(0, settings.size() * 6, (byte) 4, (byte) 0);
                for (int i5 = 0; i5 < 10; i5++) {
                    if (settings.isSet(i5)) {
                        if (i5 == 4) {
                            i4 = 3;
                        } else if (i5 == 7) {
                            i4 = 4;
                        } else {
                            i4 = i5;
                        }
                        this.sink.writeShort(i4);
                        this.sink.writeInt(settings.get(i5));
                    }
                }
                this.sink.flush();
            } else {
                throw new IOException("closed");
            }
        } finally {
        }
    }

    public synchronized void synReply(boolean z4, int i4, List<Header> list) throws IOException {
        if (!this.closed) {
            headers(z4, i4, list);
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void synStream(boolean z4, int i4, int i5, List<Header> list) throws IOException {
        if (!this.closed) {
            headers(z4, i4, list);
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void windowUpdate(int i4, long j4) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        } else if (j4 == 0 || j4 > 2147483647L) {
            throw Http2.illegalArgument("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j4));
        } else {
            frameHeader(i4, 4, (byte) 8, (byte) 0);
            this.sink.writeInt((int) j4);
            this.sink.flush();
        }
    }

    /* access modifiers changed from: package-private */
    public void headers(boolean z4, int i4, List<Header> list) throws IOException {
        if (!this.closed) {
            this.hpackWriter.writeHeaders(list);
            long size = this.hpackBuffer.size();
            int min = (int) Math.min((long) this.maxFrameSize, size);
            long j4 = (long) min;
            int i5 = (size > j4 ? 1 : (size == j4 ? 0 : -1));
            byte b5 = i5 == 0 ? (byte) 4 : 0;
            if (z4) {
                b5 = (byte) (b5 | 1);
            }
            frameHeader(i4, min, (byte) 1, b5);
            this.sink.write(this.hpackBuffer, j4);
            if (i5 > 0) {
                writeContinuationFrames(i4, size - j4);
                return;
            }
            return;
        }
        throw new IOException("closed");
    }
}
