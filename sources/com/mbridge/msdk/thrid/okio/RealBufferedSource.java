package com.mbridge.msdk.thrid.okio;

import androidx.annotation.Nullable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

final class RealBufferedSource implements BufferedSource, AutoCloseable {
    public final Buffer buffer = new Buffer();
    boolean closed;
    public final Source source;

    RealBufferedSource(Source source2) {
        if (source2 != null) {
            this.source = source2;
            return;
        }
        throw new NullPointerException("source == null");
    }

    public Buffer buffer() {
        return this.buffer;
    }

    public void close() throws IOException {
        if (!this.closed) {
            this.closed = true;
            this.source.close();
            this.buffer.clear();
        }
    }

    public boolean exhausted() throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        } else if (!this.buffer.exhausted() || this.source.read(this.buffer, 8192) != -1) {
            return false;
        } else {
            return true;
        }
    }

    public long indexOf(byte b5) throws IOException {
        return indexOf(b5, 0, Long.MAX_VALUE);
    }

    public long indexOfElement(ByteString byteString) throws IOException {
        return indexOfElement(byteString, 0);
    }

    public InputStream inputStream() {
        return new AutoCloseable() {
            public int available() throws IOException {
                RealBufferedSource realBufferedSource = RealBufferedSource.this;
                if (!realBufferedSource.closed) {
                    return (int) Math.min(realBufferedSource.buffer.size, 2147483647L);
                }
                throw new IOException("closed");
            }

            public void close() throws IOException {
                RealBufferedSource.this.close();
            }

            public int read() throws IOException {
                RealBufferedSource realBufferedSource = RealBufferedSource.this;
                if (!realBufferedSource.closed) {
                    Buffer buffer = realBufferedSource.buffer;
                    if (buffer.size == 0 && realBufferedSource.source.read(buffer, 8192) == -1) {
                        return -1;
                    }
                    return RealBufferedSource.this.buffer.readByte() & 255;
                }
                throw new IOException("closed");
            }

            public String toString() {
                return RealBufferedSource.this + ".inputStream()";
            }

            public int read(byte[] bArr, int i4, int i5) throws IOException {
                if (!RealBufferedSource.this.closed) {
                    Util.checkOffsetAndCount((long) bArr.length, (long) i4, (long) i5);
                    RealBufferedSource realBufferedSource = RealBufferedSource.this;
                    Buffer buffer = realBufferedSource.buffer;
                    if (buffer.size == 0 && realBufferedSource.source.read(buffer, 8192) == -1) {
                        return -1;
                    }
                    return RealBufferedSource.this.buffer.read(bArr, i4, i5);
                }
                throw new IOException("closed");
            }
        };
    }

    public boolean isOpen() {
        return !this.closed;
    }

    public boolean rangeEquals(long j4, ByteString byteString) throws IOException {
        return rangeEquals(j4, byteString, 0, byteString.size());
    }

    public long read(Buffer buffer2, long j4) throws IOException {
        if (buffer2 == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j4 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j4);
        } else if (!this.closed) {
            Buffer buffer3 = this.buffer;
            if (buffer3.size == 0 && this.source.read(buffer3, 8192) == -1) {
                return -1;
            }
            return this.buffer.read(buffer2, Math.min(j4, this.buffer.size));
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public long readAll(Sink sink) throws IOException {
        if (sink != null) {
            long j4 = 0;
            while (this.source.read(this.buffer, 8192) != -1) {
                long completeSegmentByteCount = this.buffer.completeSegmentByteCount();
                if (completeSegmentByteCount > 0) {
                    j4 += completeSegmentByteCount;
                    sink.write(this.buffer, completeSegmentByteCount);
                }
            }
            if (this.buffer.size() <= 0) {
                return j4;
            }
            long size = j4 + this.buffer.size();
            Buffer buffer2 = this.buffer;
            sink.write(buffer2, buffer2.size());
            return size;
        }
        throw new IllegalArgumentException("sink == null");
    }

    public byte readByte() throws IOException {
        require(1);
        return this.buffer.readByte();
    }

    public byte[] readByteArray() throws IOException {
        this.buffer.writeAll(this.source);
        return this.buffer.readByteArray();
    }

    public ByteString readByteString() throws IOException {
        this.buffer.writeAll(this.source);
        return this.buffer.readByteString();
    }

    public long readDecimalLong() throws IOException {
        require(1);
        int i4 = 0;
        while (true) {
            int i5 = i4 + 1;
            if (!request((long) i5)) {
                break;
            }
            byte b5 = this.buffer.getByte((long) i4);
            if ((b5 >= 48 && b5 <= 57) || (i4 == 0 && b5 == 45)) {
                i4 = i5;
            } else if (i4 == 0) {
                throw new NumberFormatException(String.format("Expected leading [0-9] or '-' character but was %#x", new Object[]{Byte.valueOf(b5)}));
            }
        }
        return this.buffer.readDecimalLong();
    }

    public void readFully(byte[] bArr) throws IOException {
        try {
            require((long) bArr.length);
            this.buffer.readFully(bArr);
        } catch (EOFException e5) {
            int i4 = 0;
            while (true) {
                Buffer buffer2 = this.buffer;
                long j4 = buffer2.size;
                if (j4 > 0) {
                    int read = buffer2.read(bArr, i4, (int) j4);
                    if (read != -1) {
                        i4 += read;
                    } else {
                        throw new AssertionError();
                    }
                } else {
                    throw e5;
                }
            }
        }
    }

    public long readHexadecimalUnsignedLong() throws IOException {
        require(1);
        int i4 = 0;
        while (true) {
            int i5 = i4 + 1;
            if (!request((long) i5)) {
                break;
            }
            byte b5 = this.buffer.getByte((long) i4);
            if ((b5 >= 48 && b5 <= 57) || ((b5 >= 97 && b5 <= 102) || (b5 >= 65 && b5 <= 70))) {
                i4 = i5;
            } else if (i4 == 0) {
                throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", new Object[]{Byte.valueOf(b5)}));
            }
        }
        return this.buffer.readHexadecimalUnsignedLong();
    }

    public int readInt() throws IOException {
        require(4);
        return this.buffer.readInt();
    }

    public int readIntLe() throws IOException {
        require(4);
        return this.buffer.readIntLe();
    }

    public long readLong() throws IOException {
        require(8);
        return this.buffer.readLong();
    }

    public long readLongLe() throws IOException {
        require(8);
        return this.buffer.readLongLe();
    }

    public short readShort() throws IOException {
        require(2);
        return this.buffer.readShort();
    }

    public short readShortLe() throws IOException {
        require(2);
        return this.buffer.readShortLe();
    }

    public String readString(Charset charset) throws IOException {
        if (charset != null) {
            this.buffer.writeAll(this.source);
            return this.buffer.readString(charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    public String readUtf8() throws IOException {
        this.buffer.writeAll(this.source);
        return this.buffer.readUtf8();
    }

    public int readUtf8CodePoint() throws IOException {
        require(1);
        byte b5 = this.buffer.getByte(0);
        if ((b5 & 224) == 192) {
            require(2);
        } else if ((b5 & 240) == 224) {
            require(3);
        } else if ((b5 & 248) == 240) {
            require(4);
        }
        return this.buffer.readUtf8CodePoint();
    }

    @Nullable
    public String readUtf8Line() throws IOException {
        long indexOf = indexOf((byte) 10);
        if (indexOf != -1) {
            return this.buffer.readUtf8Line(indexOf);
        }
        long j4 = this.buffer.size;
        if (j4 != 0) {
            return readUtf8(j4);
        }
        return null;
    }

    public String readUtf8LineStrict() throws IOException {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    public boolean request(long j4) throws IOException {
        Buffer buffer2;
        if (j4 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j4);
        } else if (!this.closed) {
            do {
                buffer2 = this.buffer;
                if (buffer2.size >= j4) {
                    return true;
                }
            } while (this.source.read(buffer2, 8192) != -1);
            return false;
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public void require(long j4) throws IOException {
        if (!request(j4)) {
            throw new EOFException();
        }
    }

    public int select(Options options) throws IOException {
        if (!this.closed) {
            do {
                int selectPrefix = this.buffer.selectPrefix(options, true);
                if (selectPrefix == -1) {
                    return -1;
                }
                if (selectPrefix != -2) {
                    this.buffer.skip((long) options.byteStrings[selectPrefix].size());
                    return selectPrefix;
                }
            } while (this.source.read(this.buffer, 8192) != -1);
            return -1;
        }
        throw new IllegalStateException("closed");
    }

    public void skip(long j4) throws IOException {
        if (!this.closed) {
            while (j4 > 0) {
                Buffer buffer2 = this.buffer;
                if (buffer2.size == 0 && this.source.read(buffer2, 8192) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j4, this.buffer.size());
                this.buffer.skip(min);
                j4 -= min;
            }
            return;
        }
        throw new IllegalStateException("closed");
    }

    public Timeout timeout() {
        return this.source.timeout();
    }

    public String toString() {
        return "buffer(" + this.source + ")";
    }

    public long indexOf(byte b5, long j4) throws IOException {
        return indexOf(b5, j4, Long.MAX_VALUE);
    }

    public long indexOfElement(ByteString byteString, long j4) throws IOException {
        if (!this.closed) {
            while (true) {
                long indexOfElement = this.buffer.indexOfElement(byteString, j4);
                if (indexOfElement != -1) {
                    return indexOfElement;
                }
                Buffer buffer2 = this.buffer;
                long j5 = buffer2.size;
                if (this.source.read(buffer2, 8192) == -1) {
                    return -1;
                }
                j4 = Math.max(j4, j5);
            }
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public boolean rangeEquals(long j4, ByteString byteString, int i4, int i5) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        } else if (j4 < 0 || i4 < 0 || i5 < 0 || byteString.size() - i4 < i5) {
            return false;
        } else {
            for (int i6 = 0; i6 < i5; i6++) {
                long j5 = ((long) i6) + j4;
                if (!request(1 + j5) || this.buffer.getByte(j5) != byteString.getByte(i4 + i6)) {
                    return false;
                }
            }
            return true;
        }
    }

    public String readUtf8LineStrict(long j4) throws IOException {
        if (j4 >= 0) {
            long j5 = j4 == Long.MAX_VALUE ? Long.MAX_VALUE : j4 + 1;
            long indexOf = indexOf((byte) 10, 0, j5);
            if (indexOf != -1) {
                return this.buffer.readUtf8Line(indexOf);
            }
            if (j5 < Long.MAX_VALUE && request(j5) && this.buffer.getByte(j5 - 1) == 13 && request(1 + j5) && this.buffer.getByte(j5) == 10) {
                return this.buffer.readUtf8Line(j5);
            }
            Buffer buffer2 = new Buffer();
            Buffer buffer3 = this.buffer;
            buffer3.copyTo(buffer2, 0, Math.min(32, buffer3.size()));
            throw new EOFException("\\n not found: limit=" + Math.min(this.buffer.size(), j4) + " content=" + buffer2.readByteString().hex() + 8230);
        }
        throw new IllegalArgumentException("limit < 0: " + j4);
    }

    public long indexOf(byte b5, long j4, long j5) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        } else if (j4 < 0 || j5 < j4) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(j4), Long.valueOf(j5)}));
        } else {
            long j6 = j4;
            while (j6 < j5) {
                byte b6 = b5;
                long j7 = j5;
                long indexOf = this.buffer.indexOf(b6, j6, j7);
                if (indexOf == -1) {
                    Buffer buffer2 = this.buffer;
                    long j8 = buffer2.size;
                    if (j8 >= j7 || this.source.read(buffer2, 8192) == -1) {
                        break;
                    }
                    j6 = Math.max(j6, j8);
                    b5 = b6;
                    j5 = j7;
                } else {
                    return indexOf;
                }
            }
            return -1;
        }
    }

    public byte[] readByteArray(long j4) throws IOException {
        require(j4);
        return this.buffer.readByteArray(j4);
    }

    public ByteString readByteString(long j4) throws IOException {
        require(j4);
        return this.buffer.readByteString(j4);
    }

    public String readUtf8(long j4) throws IOException {
        require(j4);
        return this.buffer.readUtf8(j4);
    }

    public String readString(long j4, Charset charset) throws IOException {
        require(j4);
        if (charset != null) {
            return this.buffer.readString(j4, charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    public void readFully(Buffer buffer2, long j4) throws IOException {
        try {
            require(j4);
            this.buffer.readFully(buffer2, j4);
        } catch (EOFException e5) {
            buffer2.writeAll(this.buffer);
            throw e5;
        }
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i4, int i5) throws IOException {
        long j4 = (long) i5;
        Util.checkOffsetAndCount((long) bArr.length, (long) i4, j4);
        Buffer buffer2 = this.buffer;
        if (buffer2.size == 0 && this.source.read(buffer2, 8192) == -1) {
            return -1;
        }
        return this.buffer.read(bArr, i4, (int) Math.min(j4, this.buffer.size));
    }

    public long indexOf(ByteString byteString) throws IOException {
        return indexOf(byteString, 0);
    }

    public long indexOf(ByteString byteString, long j4) throws IOException {
        if (!this.closed) {
            while (true) {
                long indexOf = this.buffer.indexOf(byteString, j4);
                if (indexOf != -1) {
                    return indexOf;
                }
                Buffer buffer2 = this.buffer;
                long j5 = buffer2.size;
                if (this.source.read(buffer2, 8192) == -1) {
                    return -1;
                }
                j4 = Math.max(j4, (j5 - ((long) byteString.size())) + 1);
            }
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public int read(ByteBuffer byteBuffer) throws IOException {
        Buffer buffer2 = this.buffer;
        if (buffer2.size == 0 && this.source.read(buffer2, 8192) == -1) {
            return -1;
        }
        return this.buffer.read(byteBuffer);
    }
}
