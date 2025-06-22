package com.mbridge.msdk.thrid.okio;

import androidx.annotation.Nullable;
import androidx.work.WorkRequest;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel, AutoCloseable {
    private static final byte[] DIGITS = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    static final int REPLACEMENT_CHARACTER = 65533;
    @Nullable
    Segment head;
    long size;

    public static final class UnsafeCursor implements Closeable, AutoCloseable {
        public Buffer buffer;
        public byte[] data;
        public int end = -1;
        public long offset = -1;
        public boolean readWrite;
        private Segment segment;
        public int start = -1;

        public void close() {
            if (this.buffer != null) {
                this.buffer = null;
                this.segment = null;
                this.offset = -1;
                this.data = null;
                this.start = -1;
                this.end = -1;
                return;
            }
            throw new IllegalStateException("not attached to a buffer");
        }

        public final long expandBuffer(int i4) {
            if (i4 <= 0) {
                throw new IllegalArgumentException("minByteCount <= 0: " + i4);
            } else if (i4 <= 8192) {
                Buffer buffer2 = this.buffer;
                if (buffer2 == null) {
                    throw new IllegalStateException("not attached to a buffer");
                } else if (this.readWrite) {
                    long j4 = buffer2.size;
                    Segment writableSegment = buffer2.writableSegment(i4);
                    int i5 = 8192 - writableSegment.limit;
                    writableSegment.limit = 8192;
                    long j5 = (long) i5;
                    this.buffer.size = j4 + j5;
                    this.segment = writableSegment;
                    this.offset = j4;
                    this.data = writableSegment.data;
                    this.start = 8192 - i5;
                    this.end = 8192;
                    return j5;
                } else {
                    throw new IllegalStateException("expandBuffer() only permitted for read/write buffers");
                }
            } else {
                throw new IllegalArgumentException("minByteCount > Segment.SIZE: " + i4);
            }
        }

        public final int next() {
            long j4 = this.offset;
            if (j4 == this.buffer.size) {
                throw new IllegalStateException();
            } else if (j4 == -1) {
                return seek(0);
            } else {
                return seek(j4 + ((long) (this.end - this.start)));
            }
        }

        public final long resizeBuffer(long j4) {
            Buffer buffer2 = this.buffer;
            if (buffer2 == null) {
                throw new IllegalStateException("not attached to a buffer");
            } else if (this.readWrite) {
                long j5 = buffer2.size;
                int i4 = (j4 > j5 ? 1 : (j4 == j5 ? 0 : -1));
                if (i4 <= 0) {
                    if (j4 >= 0) {
                        long j6 = j5 - j4;
                        while (true) {
                            if (j6 <= 0) {
                                break;
                            }
                            Buffer buffer3 = this.buffer;
                            Segment segment2 = buffer3.head.prev;
                            int i5 = segment2.limit;
                            long j7 = (long) (i5 - segment2.pos);
                            if (j7 > j6) {
                                segment2.limit = (int) (((long) i5) - j6);
                                break;
                            }
                            buffer3.head = segment2.pop();
                            SegmentPool.recycle(segment2);
                            j6 -= j7;
                        }
                        this.segment = null;
                        this.offset = j4;
                        this.data = null;
                        this.start = -1;
                        this.end = -1;
                    } else {
                        throw new IllegalArgumentException("newSize < 0: " + j4);
                    }
                } else if (i4 > 0) {
                    long j8 = j4 - j5;
                    boolean z4 = true;
                    while (j8 > 0) {
                        Segment writableSegment = this.buffer.writableSegment(1);
                        int min = (int) Math.min(j8, (long) (8192 - writableSegment.limit));
                        int i6 = writableSegment.limit + min;
                        writableSegment.limit = i6;
                        j8 -= (long) min;
                        if (z4) {
                            this.segment = writableSegment;
                            this.offset = j5;
                            this.data = writableSegment.data;
                            this.start = i6 - min;
                            this.end = i6;
                            z4 = false;
                        }
                    }
                }
                this.buffer.size = j4;
                return j5;
            } else {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
            }
        }

        public final int seek(long j4) {
            int i4 = (j4 > -1 ? 1 : (j4 == -1 ? 0 : -1));
            if (i4 >= 0) {
                Buffer buffer2 = this.buffer;
                long j5 = buffer2.size;
                if (j4 <= j5) {
                    if (i4 == 0 || j4 == j5) {
                        this.segment = null;
                        this.offset = j4;
                        this.data = null;
                        this.start = -1;
                        this.end = -1;
                        return -1;
                    }
                    Segment segment2 = buffer2.head;
                    Segment segment3 = this.segment;
                    long j6 = 0;
                    if (segment3 != null) {
                        long j7 = this.offset - ((long) (this.start - segment3.pos));
                        if (j7 > j4) {
                            Segment segment4 = segment3;
                            segment3 = segment2;
                            segment2 = segment4;
                            j5 = j7;
                        } else {
                            j6 = j7;
                        }
                    } else {
                        segment3 = segment2;
                    }
                    if (j5 - j4 > j4 - j6) {
                        while (true) {
                            int i5 = segment3.limit;
                            int i6 = segment3.pos;
                            if (j4 < ((long) (i5 - i6)) + j6) {
                                break;
                            }
                            j6 += (long) (i5 - i6);
                            segment3 = segment3.next;
                        }
                    } else {
                        while (j5 > j4) {
                            segment2 = segment2.prev;
                            j5 -= (long) (segment2.limit - segment2.pos);
                        }
                        segment3 = segment2;
                        j6 = j5;
                    }
                    if (this.readWrite && segment3.shared) {
                        Segment unsharedCopy = segment3.unsharedCopy();
                        Buffer buffer3 = this.buffer;
                        if (buffer3.head == segment3) {
                            buffer3.head = unsharedCopy;
                        }
                        segment3 = segment3.push(unsharedCopy);
                        segment3.prev.pop();
                    }
                    this.segment = segment3;
                    this.offset = j4;
                    this.data = segment3.data;
                    int i7 = segment3.pos + ((int) (j4 - j6));
                    this.start = i7;
                    int i8 = segment3.limit;
                    this.end = i8;
                    return i8 - i7;
                }
            }
            throw new ArrayIndexOutOfBoundsException(String.format("offset=%s > size=%s", new Object[]{Long.valueOf(j4), Long.valueOf(this.buffer.size)}));
        }
    }

    private ByteString digest(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            Segment segment = this.head;
            if (segment != null) {
                byte[] bArr = segment.data;
                int i4 = segment.pos;
                instance.update(bArr, i4, segment.limit - i4);
                Segment segment2 = this.head;
                while (true) {
                    segment2 = segment2.next;
                    if (segment2 == this.head) {
                        break;
                    }
                    byte[] bArr2 = segment2.data;
                    int i5 = segment2.pos;
                    instance.update(bArr2, i5, segment2.limit - i5);
                }
            }
            return ByteString.of(instance.digest());
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    private ByteString hmac(String str, ByteString byteString) {
        try {
            Mac instance = Mac.getInstance(str);
            instance.init(new SecretKeySpec(byteString.toByteArray(), str));
            Segment segment = this.head;
            if (segment != null) {
                byte[] bArr = segment.data;
                int i4 = segment.pos;
                instance.update(bArr, i4, segment.limit - i4);
                Segment segment2 = this.head;
                while (true) {
                    segment2 = segment2.next;
                    if (segment2 == this.head) {
                        break;
                    }
                    byte[] bArr2 = segment2.data;
                    int i5 = segment2.pos;
                    instance.update(bArr2, i5, segment2.limit - i5);
                }
            }
            return ByteString.of(instance.doFinal());
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        } catch (InvalidKeyException e5) {
            throw new IllegalArgumentException(e5);
        }
    }

    public Buffer buffer() {
        return this;
    }

    public final void clear() {
        try {
            skip(this.size);
        } catch (EOFException e5) {
            throw new AssertionError(e5);
        }
    }

    public void close() {
    }

    public final long completeSegmentByteCount() {
        long j4 = this.size;
        if (j4 == 0) {
            return 0;
        }
        Segment segment = this.head.prev;
        int i4 = segment.limit;
        if (i4 >= 8192 || !segment.owner) {
            return j4;
        }
        return j4 - ((long) (i4 - segment.pos));
    }

    public final Buffer copyTo(OutputStream outputStream) throws IOException {
        return copyTo(outputStream, 0, this.size);
    }

    public BufferedSink emit() {
        return this;
    }

    public Buffer emitCompleteSegments() {
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Buffer)) {
            return false;
        }
        Buffer buffer = (Buffer) obj;
        long j4 = this.size;
        if (j4 != buffer.size) {
            return false;
        }
        long j5 = 0;
        if (j4 == 0) {
            return true;
        }
        Segment segment = this.head;
        Segment segment2 = buffer.head;
        int i4 = segment.pos;
        int i5 = segment2.pos;
        while (j5 < this.size) {
            long min = (long) Math.min(segment.limit - i4, segment2.limit - i5);
            int i6 = 0;
            while (((long) i6) < min) {
                int i7 = i4 + 1;
                int i8 = i5 + 1;
                if (segment.data[i4] != segment2.data[i5]) {
                    return false;
                }
                i6++;
                i4 = i7;
                i5 = i8;
            }
            if (i4 == segment.limit) {
                segment = segment.next;
                i4 = segment.pos;
            }
            if (i5 == segment2.limit) {
                segment2 = segment2.next;
                i5 = segment2.pos;
            }
            j5 += min;
        }
        return true;
    }

    public boolean exhausted() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    public void flush() {
    }

    public final byte getByte(long j4) {
        int i4;
        long j5 = j4;
        Util.checkOffsetAndCount(this.size, j5, 1);
        long j6 = this.size;
        if (j6 - j5 > j5) {
            Segment segment = this.head;
            while (true) {
                int i5 = segment.limit;
                int i6 = segment.pos;
                long j7 = (long) (i5 - i6);
                if (j5 < j7) {
                    return segment.data[i6 + ((int) j5)];
                }
                j5 -= j7;
                segment = segment.next;
            }
        } else {
            long j8 = j5 - j6;
            Segment segment2 = this.head;
            do {
                segment2 = segment2.prev;
                int i7 = segment2.limit;
                i4 = segment2.pos;
                j8 += (long) (i7 - i4);
            } while (j8 < 0);
            return segment2.data[i4 + ((int) j8)];
        }
    }

    public int hashCode() {
        Segment segment = this.head;
        if (segment == null) {
            return 0;
        }
        int i4 = 1;
        do {
            int i5 = segment.limit;
            for (int i6 = segment.pos; i6 < i5; i6++) {
                i4 = (i4 * 31) + segment.data[i6];
            }
            segment = segment.next;
        } while (segment != this.head);
        return i4;
    }

    public final ByteString hmacSha1(ByteString byteString) {
        return hmac("HmacSHA1", byteString);
    }

    public final ByteString hmacSha256(ByteString byteString) {
        return hmac("HmacSHA256", byteString);
    }

    public final ByteString hmacSha512(ByteString byteString) {
        return hmac("HmacSHA512", byteString);
    }

    public long indexOf(byte b5) {
        return indexOf(b5, 0, Long.MAX_VALUE);
    }

    public long indexOfElement(ByteString byteString) {
        return indexOfElement(byteString, 0);
    }

    public InputStream inputStream() {
        return new AutoCloseable() {
            public int available() {
                return (int) Math.min(Buffer.this.size, 2147483647L);
            }

            public void close() {
            }

            public int read() {
                Buffer buffer = Buffer.this;
                if (buffer.size > 0) {
                    return buffer.readByte() & 255;
                }
                return -1;
            }

            public String toString() {
                return Buffer.this + ".inputStream()";
            }

            public int read(byte[] bArr, int i4, int i5) {
                return Buffer.this.read(bArr, i4, i5);
            }
        };
    }

    public boolean isOpen() {
        return true;
    }

    public final ByteString md5() {
        return digest(SameMD5.TAG);
    }

    public OutputStream outputStream() {
        return new AutoCloseable() {
            public void close() {
            }

            public void flush() {
            }

            public String toString() {
                return Buffer.this + ".outputStream()";
            }

            public void write(int i4) {
                Buffer.this.writeByte((int) (byte) i4);
            }

            public void write(byte[] bArr, int i4, int i5) {
                Buffer.this.write(bArr, i4, i5);
            }
        };
    }

    public boolean rangeEquals(long j4, ByteString byteString) {
        return rangeEquals(j4, byteString, 0, byteString.size());
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public long readAll(Sink sink) throws IOException {
        long j4 = this.size;
        if (j4 > 0) {
            sink.write(this, j4);
        }
        return j4;
    }

    public final UnsafeCursor readAndWriteUnsafe() {
        return readAndWriteUnsafe(new UnsafeCursor());
    }

    public byte readByte() {
        long j4 = this.size;
        if (j4 != 0) {
            Segment segment = this.head;
            int i4 = segment.pos;
            int i5 = segment.limit;
            int i6 = i4 + 1;
            byte b5 = segment.data[i4];
            this.size = j4 - 1;
            if (i6 == i5) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
                return b5;
            }
            segment.pos = i6;
            return b5;
        }
        throw new IllegalStateException("size == 0");
    }

    public byte[] readByteArray() {
        try {
            return readByteArray(this.size);
        } catch (EOFException e5) {
            throw new AssertionError(e5);
        }
    }

    public ByteString readByteString() {
        return new ByteString(readByteArray());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004c, code lost:
        if (r2 != false) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004e, code lost:
        r1.readByte();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006b, code lost:
        throw new java.lang.NumberFormatException("Number too large: " + r1.readUtf8());
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x009b A[EDGE_INSN: B:49:0x009b->B:29:0x009b ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x001b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long readDecimalLong() {
        /*
            r17 = this;
            r0 = r17
            long r1 = r0.size
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x00ba
            r1 = 0
            r5 = -7
            r6 = r5
            r2 = 0
            r4 = r3
            r3 = 0
        L_0x0011:
            com.mbridge.msdk.thrid.okio.Segment r8 = r0.head
            byte[] r9 = r8.data
            int r10 = r8.pos
            int r11 = r8.limit
        L_0x0019:
            if (r10 >= r11) goto L_0x009b
            byte r12 = r9[r10]
            r13 = 48
            if (r12 < r13) goto L_0x006c
            r13 = 57
            if (r12 > r13) goto L_0x006c
            int r13 = 48 - r12
            r14 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r16 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
            if (r16 < 0) goto L_0x003f
            if (r16 != 0) goto L_0x0038
            long r14 = (long) r13
            int r16 = (r14 > r6 ? 1 : (r14 == r6 ? 0 : -1))
            if (r16 >= 0) goto L_0x0038
            goto L_0x003f
        L_0x0038:
            r14 = 10
            long r4 = r4 * r14
            long r12 = (long) r13
            long r4 = r4 + r12
            goto L_0x0077
        L_0x003f:
            com.mbridge.msdk.thrid.okio.Buffer r1 = new com.mbridge.msdk.thrid.okio.Buffer
            r1.<init>()
            com.mbridge.msdk.thrid.okio.Buffer r1 = r1.writeDecimalLong((long) r4)
            com.mbridge.msdk.thrid.okio.Buffer r1 = r1.writeByte((int) r12)
            if (r2 != 0) goto L_0x0051
            r1.readByte()
        L_0x0051:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Number too large: "
            r3.append(r4)
            java.lang.String r1 = r1.readUtf8()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L_0x006c:
            r13 = 45
            r14 = 1
            if (r12 != r13) goto L_0x007c
            if (r1 != 0) goto L_0x007c
            r12 = 1
            long r6 = r6 - r12
            r2 = 1
        L_0x0077:
            int r10 = r10 + 1
            int r1 = r1 + 1
            goto L_0x0019
        L_0x007c:
            if (r1 == 0) goto L_0x0080
            r3 = 1
            goto L_0x009b
        L_0x0080:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Expected leading [0-9] or '-' character but was 0x"
            r2.append(r3)
            java.lang.String r3 = java.lang.Integer.toHexString(r12)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x009b:
            if (r10 != r11) goto L_0x00a7
            com.mbridge.msdk.thrid.okio.Segment r9 = r8.pop()
            r0.head = r9
            com.mbridge.msdk.thrid.okio.SegmentPool.recycle(r8)
            goto L_0x00a9
        L_0x00a7:
            r8.pos = r10
        L_0x00a9:
            if (r3 != 0) goto L_0x00af
            com.mbridge.msdk.thrid.okio.Segment r8 = r0.head
            if (r8 != 0) goto L_0x0011
        L_0x00af:
            long r6 = r0.size
            long r8 = (long) r1
            long r6 = r6 - r8
            r0.size = r6
            if (r2 == 0) goto L_0x00b8
            return r4
        L_0x00b8:
            long r1 = -r4
            return r1
        L_0x00ba:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "size == 0"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okio.Buffer.readDecimalLong():long");
    }

    public final Buffer readFrom(InputStream inputStream) throws IOException {
        readFrom(inputStream, Long.MAX_VALUE, true);
        return this;
    }

    public void readFully(Buffer buffer, long j4) throws EOFException {
        long j5 = this.size;
        if (j5 >= j4) {
            buffer.write(this, j4);
        } else {
            buffer.write(this, j5);
            throw new EOFException();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x008e, code lost:
        if (r8 != r9) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0090, code lost:
        r15.head = r6.pop();
        com.mbridge.msdk.thrid.okio.SegmentPool.recycle(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x009a, code lost:
        r6.pos = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009c, code lost:
        if (r1 != false) goto L_0x00a2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0073 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long readHexadecimalUnsignedLong() {
        /*
            r15 = this;
            long r0 = r15.size
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x00a9
            r0 = 0
            r4 = r2
            r1 = 0
        L_0x000b:
            com.mbridge.msdk.thrid.okio.Segment r6 = r15.head
            byte[] r7 = r6.data
            int r8 = r6.pos
            int r9 = r6.limit
        L_0x0013:
            if (r8 >= r9) goto L_0x008e
            byte r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L_0x0022
            r11 = 57
            if (r10 > r11) goto L_0x0022
            int r11 = r10 + -48
            goto L_0x0037
        L_0x0022:
            r11 = 97
            if (r10 < r11) goto L_0x002d
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L_0x002d
            int r11 = r10 + -87
            goto L_0x0037
        L_0x002d:
            r11 = 65
            if (r10 < r11) goto L_0x006f
            r11 = 70
            if (r10 > r11) goto L_0x006f
            int r11 = r10 + -55
        L_0x0037:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L_0x0047
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L_0x0013
        L_0x0047:
            com.mbridge.msdk.thrid.okio.Buffer r0 = new com.mbridge.msdk.thrid.okio.Buffer
            r0.<init>()
            com.mbridge.msdk.thrid.okio.Buffer r0 = r0.writeHexadecimalUnsignedLong((long) r4)
            com.mbridge.msdk.thrid.okio.Buffer r0 = r0.writeByte((int) r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.readUtf8()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x006f:
            if (r0 == 0) goto L_0x0073
            r1 = 1
            goto L_0x008e
        L_0x0073:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x008e:
            if (r8 != r9) goto L_0x009a
            com.mbridge.msdk.thrid.okio.Segment r7 = r6.pop()
            r15.head = r7
            com.mbridge.msdk.thrid.okio.SegmentPool.recycle(r6)
            goto L_0x009c
        L_0x009a:
            r6.pos = r8
        L_0x009c:
            if (r1 != 0) goto L_0x00a2
            com.mbridge.msdk.thrid.okio.Segment r6 = r15.head
            if (r6 != 0) goto L_0x000b
        L_0x00a2:
            long r1 = r15.size
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.size = r1
            return r4
        L_0x00a9:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okio.Buffer.readHexadecimalUnsignedLong():long");
    }

    public int readInt() {
        long j4 = this.size;
        if (j4 >= 4) {
            Segment segment = this.head;
            int i4 = segment.pos;
            int i5 = segment.limit;
            if (i5 - i4 < 4) {
                return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
            }
            byte[] bArr = segment.data;
            byte b5 = ((bArr[i4 + 1] & 255) << 16) | ((bArr[i4] & 255) << 24);
            int i6 = i4 + 3;
            int i7 = i4 + 4;
            byte b6 = (bArr[i6] & 255) | b5 | ((bArr[i4 + 2] & 255) << 8);
            this.size = j4 - 4;
            if (i7 == i5) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
                return b6;
            }
            segment.pos = i7;
            return b6;
        }
        throw new IllegalStateException("size < 4: " + this.size);
    }

    public int readIntLe() {
        return Util.reverseBytesInt(readInt());
    }

    public long readLong() {
        long j4 = this.size;
        if (j4 >= 8) {
            Segment segment = this.head;
            int i4 = segment.pos;
            int i5 = segment.limit;
            if (i5 - i4 < 8) {
                return ((((long) readInt()) & 4294967295L) << 32) | (4294967295L & ((long) readInt()));
            }
            byte[] bArr = segment.data;
            long j5 = ((((long) bArr[i4 + 1]) & 255) << 48) | ((((long) bArr[i4]) & 255) << 56) | ((((long) bArr[i4 + 2]) & 255) << 40) | ((((long) bArr[i4 + 3]) & 255) << 32) | ((((long) bArr[i4 + 4]) & 255) << 24);
            int i6 = i4 + 7;
            int i7 = i4 + 8;
            long j6 = j5 | ((((long) bArr[i4 + 5]) & 255) << 16) | ((((long) bArr[i4 + 6]) & 255) << 8) | (((long) bArr[i6]) & 255);
            this.size = j4 - 8;
            if (i7 == i5) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
                return j6;
            }
            segment.pos = i7;
            return j6;
        }
        throw new IllegalStateException("size < 8: " + this.size);
    }

    public long readLongLe() {
        return Util.reverseBytesLong(readLong());
    }

    public short readShort() {
        long j4 = this.size;
        if (j4 >= 2) {
            Segment segment = this.head;
            int i4 = segment.pos;
            int i5 = segment.limit;
            if (i5 - i4 < 2) {
                return (short) (((readByte() & 255) << 8) | (readByte() & 255));
            }
            byte[] bArr = segment.data;
            int i6 = i4 + 1;
            int i7 = i4 + 2;
            byte b5 = (bArr[i6] & 255) | ((bArr[i4] & 255) << 8);
            this.size = j4 - 2;
            if (i7 == i5) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i7;
            }
            return (short) b5;
        }
        throw new IllegalStateException("size < 2: " + this.size);
    }

    public short readShortLe() {
        return Util.reverseBytesShort(readShort());
    }

    public String readString(Charset charset) {
        try {
            return readString(this.size, charset);
        } catch (EOFException e5) {
            throw new AssertionError(e5);
        }
    }

    public final UnsafeCursor readUnsafe() {
        return readUnsafe(new UnsafeCursor());
    }

    public String readUtf8() {
        try {
            return readString(this.size, Util.UTF_8);
        } catch (EOFException e5) {
            throw new AssertionError(e5);
        }
    }

    public int readUtf8CodePoint() throws EOFException {
        byte b5;
        int i4;
        byte b6;
        if (this.size != 0) {
            byte b7 = getByte(0);
            int i5 = 1;
            if ((b7 & 128) == 0) {
                b6 = b7 & Byte.MAX_VALUE;
                i4 = 1;
                b5 = 0;
            } else if ((b7 & 224) == 192) {
                b6 = b7 & 31;
                i4 = 2;
                b5 = 128;
            } else if ((b7 & 240) == 224) {
                b6 = b7 & 15;
                i4 = 3;
                b5 = 2048;
            } else if ((b7 & 248) == 240) {
                b6 = b7 & 7;
                i4 = 4;
                b5 = 65536;
            } else {
                skip(1);
                return REPLACEMENT_CHARACTER;
            }
            long j4 = (long) i4;
            if (this.size >= j4) {
                while (i5 < i4) {
                    long j5 = (long) i5;
                    byte b8 = getByte(j5);
                    if ((b8 & 192) == 128) {
                        b6 = (b6 << 6) | (b8 & 63);
                        i5++;
                    } else {
                        skip(j5);
                        return REPLACEMENT_CHARACTER;
                    }
                }
                skip(j4);
                if (b6 > 1114111) {
                    return REPLACEMENT_CHARACTER;
                }
                if ((b6 < 55296 || b6 > 57343) && b6 >= b5) {
                    return b6;
                }
                return REPLACEMENT_CHARACTER;
            }
            throw new EOFException("size < " + i4 + ": " + this.size + " (to read code point prefixed 0x" + Integer.toHexString(b7) + ")");
        }
        throw new EOFException();
    }

    @Nullable
    public String readUtf8Line() throws EOFException {
        long indexOf = indexOf((byte) 10);
        if (indexOf != -1) {
            return readUtf8Line(indexOf);
        }
        long j4 = this.size;
        if (j4 != 0) {
            return readUtf8(j4);
        }
        return null;
    }

    public String readUtf8LineStrict() throws EOFException {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    public boolean request(long j4) {
        if (this.size >= j4) {
            return true;
        }
        return false;
    }

    public void require(long j4) throws EOFException {
        if (this.size < j4) {
            throw new EOFException();
        }
    }

    /* access modifiers changed from: package-private */
    public List<Integer> segmentSizes() {
        if (this.head == null) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        Segment segment = this.head;
        arrayList.add(Integer.valueOf(segment.limit - segment.pos));
        Segment segment2 = this.head;
        while (true) {
            segment2 = segment2.next;
            if (segment2 == this.head) {
                return arrayList;
            }
            arrayList.add(Integer.valueOf(segment2.limit - segment2.pos));
        }
    }

    public int select(Options options) {
        int selectPrefix = selectPrefix(options, false);
        if (selectPrefix == -1) {
            return -1;
        }
        try {
            skip((long) options.byteStrings[selectPrefix].size());
            return selectPrefix;
        } catch (EOFException unused) {
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0055, code lost:
        if (r19 == false) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0057, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int selectPrefix(com.mbridge.msdk.thrid.okio.Options r18, boolean r19) {
        /*
            r17 = this;
            r0 = r18
            r1 = r17
            com.mbridge.msdk.thrid.okio.Segment r2 = r1.head
            r3 = -2
            if (r2 != 0) goto L_0x0013
            if (r19 == 0) goto L_0x000c
            return r3
        L_0x000c:
            com.mbridge.msdk.thrid.okio.ByteString r2 = com.mbridge.msdk.thrid.okio.ByteString.EMPTY
            int r0 = r0.indexOf(r2)
            return r0
        L_0x0013:
            byte[] r4 = r2.data
            int r5 = r2.pos
            int r6 = r2.limit
            int[] r0 = r0.trie
            r7 = 0
            r8 = -1
            r10 = r2
            r9 = 0
            r11 = -1
        L_0x0020:
            int r12 = r9 + 1
            r13 = r0[r9]
            int r9 = r9 + 2
            r12 = r0[r12]
            if (r12 == r8) goto L_0x002b
            r11 = r12
        L_0x002b:
            if (r10 != 0) goto L_0x002e
            goto L_0x0055
        L_0x002e:
            r12 = 0
            if (r13 >= 0) goto L_0x0071
            int r13 = r13 * -1
            int r14 = r9 + r13
        L_0x0035:
            int r13 = r5 + 1
            byte r5 = r4[r5]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r15 = r9 + 1
            r9 = r0[r9]
            if (r5 == r9) goto L_0x0042
            goto L_0x007b
        L_0x0042:
            if (r15 != r14) goto L_0x0046
            r5 = 1
            goto L_0x0047
        L_0x0046:
            r5 = 0
        L_0x0047:
            if (r13 != r6) goto L_0x0061
            com.mbridge.msdk.thrid.okio.Segment r4 = r10.next
            int r6 = r4.pos
            byte[] r9 = r4.data
            int r10 = r4.limit
            if (r4 != r2) goto L_0x005b
            if (r5 != 0) goto L_0x0058
        L_0x0055:
            if (r19 == 0) goto L_0x007b
            return r3
        L_0x0058:
            r4 = r9
            r9 = r12
            goto L_0x0064
        L_0x005b:
            r16 = r9
            r9 = r4
            r4 = r16
            goto L_0x0064
        L_0x0061:
            r9 = r10
            r10 = r6
            r6 = r13
        L_0x0064:
            if (r5 == 0) goto L_0x006c
            r5 = r0[r15]
            r3 = r6
            r6 = r10
            r10 = r9
            goto L_0x0092
        L_0x006c:
            r5 = r6
            r6 = r10
            r10 = r9
            r9 = r15
            goto L_0x0035
        L_0x0071:
            int r14 = r5 + 1
            byte r5 = r4[r5]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r15 = r9 + r13
        L_0x0079:
            if (r9 != r15) goto L_0x007c
        L_0x007b:
            return r11
        L_0x007c:
            r3 = r0[r9]
            if (r5 != r3) goto L_0x0099
            int r9 = r9 + r13
            r5 = r0[r9]
            if (r14 != r6) goto L_0x0091
            com.mbridge.msdk.thrid.okio.Segment r10 = r10.next
            int r3 = r10.pos
            byte[] r4 = r10.data
            int r6 = r10.limit
            if (r10 != r2) goto L_0x0092
            r10 = r12
            goto L_0x0092
        L_0x0091:
            r3 = r14
        L_0x0092:
            if (r5 < 0) goto L_0x0095
            return r5
        L_0x0095:
            int r9 = -r5
            r5 = r3
            r3 = -2
            goto L_0x0020
        L_0x0099:
            int r9 = r9 + 1
            r3 = -2
            goto L_0x0079
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okio.Buffer.selectPrefix(com.mbridge.msdk.thrid.okio.Options, boolean):int");
    }

    public final ByteString sha1() {
        return digest("SHA-1");
    }

    public final ByteString sha256() {
        return digest("SHA-256");
    }

    public final ByteString sha512() {
        return digest("SHA-512");
    }

    public final long size() {
        return this.size;
    }

    public void skip(long j4) throws EOFException {
        while (j4 > 0) {
            Segment segment = this.head;
            if (segment != null) {
                int min = (int) Math.min(j4, (long) (segment.limit - segment.pos));
                long j5 = (long) min;
                this.size -= j5;
                j4 -= j5;
                Segment segment2 = this.head;
                int i4 = segment2.pos + min;
                segment2.pos = i4;
                if (i4 == segment2.limit) {
                    this.head = segment2.pop();
                    SegmentPool.recycle(segment2);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    public final ByteString snapshot() {
        long j4 = this.size;
        if (j4 <= 2147483647L) {
            return snapshot((int) j4);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.size);
    }

    public Timeout timeout() {
        return Timeout.NONE;
    }

    public String toString() {
        return snapshot().toString();
    }

    /* access modifiers changed from: package-private */
    public Segment writableSegment(int i4) {
        if (i4 < 1 || i4 > 8192) {
            throw new IllegalArgumentException();
        }
        Segment segment = this.head;
        if (segment == null) {
            Segment take = SegmentPool.take();
            this.head = take;
            take.prev = take;
            take.next = take;
            return take;
        }
        Segment segment2 = segment.prev;
        if (segment2.limit + i4 > 8192 || !segment2.owner) {
            return segment2.push(SegmentPool.take());
        }
        return segment2;
    }

    public long writeAll(Source source) throws IOException {
        if (source != null) {
            long j4 = 0;
            while (true) {
                long read = source.read(this, 8192);
                if (read == -1) {
                    return j4;
                }
                j4 += read;
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    public final Buffer writeTo(OutputStream outputStream) throws IOException {
        return writeTo(outputStream, this.size);
    }

    public Buffer clone() {
        Buffer buffer = new Buffer();
        if (this.size == 0) {
            return buffer;
        }
        Segment sharedCopy = this.head.sharedCopy();
        buffer.head = sharedCopy;
        sharedCopy.prev = sharedCopy;
        sharedCopy.next = sharedCopy;
        Segment segment = this.head;
        while (true) {
            segment = segment.next;
            if (segment != this.head) {
                buffer.head.prev.push(segment.sharedCopy());
            } else {
                buffer.size = this.size;
                return buffer;
            }
        }
    }

    public final Buffer copyTo(OutputStream outputStream, long j4, long j5) throws IOException {
        if (outputStream != null) {
            long j6 = j4;
            long j7 = j5;
            Util.checkOffsetAndCount(this.size, j6, j7);
            if (j7 != 0) {
                Segment segment = this.head;
                while (true) {
                    int i4 = segment.limit;
                    int i5 = segment.pos;
                    if (j6 < ((long) (i4 - i5))) {
                        break;
                    }
                    j6 -= (long) (i4 - i5);
                    segment = segment.next;
                }
                Segment segment2 = segment;
                long j8 = j7;
                while (j8 > 0) {
                    int i6 = (int) (((long) segment2.pos) + j6);
                    int min = (int) Math.min((long) (segment2.limit - i6), j8);
                    outputStream.write(segment2.data, i6, min);
                    j8 -= (long) min;
                    segment2 = segment2.next;
                    j6 = 0;
                }
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    public long indexOf(byte b5, long j4) {
        return indexOf(b5, j4, Long.MAX_VALUE);
    }

    public long indexOfElement(ByteString byteString, long j4) {
        int i4;
        int i5;
        long j5 = 0;
        if (j4 >= 0) {
            Segment segment = this.head;
            if (segment == null) {
                return -1;
            }
            long j6 = this.size;
            if (j6 - j4 < j4) {
                while (j6 > j4) {
                    segment = segment.prev;
                    j6 -= (long) (segment.limit - segment.pos);
                }
            } else {
                while (true) {
                    long j7 = ((long) (segment.limit - segment.pos)) + j5;
                    if (j7 >= j4) {
                        break;
                    }
                    segment = segment.next;
                    j5 = j7;
                }
                j6 = j5;
            }
            if (byteString.size() == 2) {
                byte b5 = byteString.getByte(0);
                byte b6 = byteString.getByte(1);
                while (j6 < this.size) {
                    byte[] bArr = segment.data;
                    i4 = (int) ((((long) segment.pos) + j4) - j6);
                    int i6 = segment.limit;
                    while (i4 < i6) {
                        byte b7 = bArr[i4];
                        if (b7 == b5 || b7 == b6) {
                            i5 = segment.pos;
                        } else {
                            i4++;
                        }
                    }
                    j6 += (long) (segment.limit - segment.pos);
                    segment = segment.next;
                    j4 = j6;
                }
                return -1;
            }
            byte[] internalArray = byteString.internalArray();
            while (j6 < this.size) {
                byte[] bArr2 = segment.data;
                int i7 = (int) ((((long) segment.pos) + j4) - j6);
                int i8 = segment.limit;
                while (i4 < i8) {
                    byte b8 = bArr2[i4];
                    int length = internalArray.length;
                    int i9 = 0;
                    while (i9 < length) {
                        if (b8 == internalArray[i9]) {
                            i5 = segment.pos;
                        } else {
                            i9++;
                        }
                    }
                    i7 = i4 + 1;
                }
                j6 += (long) (segment.limit - segment.pos);
                segment = segment.next;
                j4 = j6;
            }
            return -1;
            return ((long) (i4 - i5)) + j6;
        }
        throw new IllegalArgumentException("fromIndex < 0");
    }

    public boolean rangeEquals(long j4, ByteString byteString, int i4, int i5) {
        if (j4 < 0 || i4 < 0 || i5 < 0 || this.size - j4 < ((long) i5) || byteString.size() - i4 < i5) {
            return false;
        }
        for (int i6 = 0; i6 < i5; i6++) {
            if (getByte(((long) i6) + j4) != byteString.getByte(i4 + i6)) {
                return false;
            }
        }
        return true;
    }

    public int read(byte[] bArr, int i4, int i5) {
        Util.checkOffsetAndCount((long) bArr.length, (long) i4, (long) i5);
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(i5, segment.limit - segment.pos);
        System.arraycopy(segment.data, segment.pos, bArr, i4, min);
        int i6 = segment.pos + min;
        segment.pos = i6;
        this.size -= (long) min;
        if (i6 == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    public final UnsafeCursor readAndWriteUnsafe(UnsafeCursor unsafeCursor) {
        if (unsafeCursor.buffer == null) {
            unsafeCursor.buffer = this;
            unsafeCursor.readWrite = true;
            return unsafeCursor;
        }
        throw new IllegalStateException("already attached to a buffer");
    }

    public ByteString readByteString(long j4) throws EOFException {
        return new ByteString(readByteArray(j4));
    }

    public final Buffer readFrom(InputStream inputStream, long j4) throws IOException {
        if (j4 >= 0) {
            readFrom(inputStream, j4, false);
            return this;
        }
        throw new IllegalArgumentException("byteCount < 0: " + j4);
    }

    public final UnsafeCursor readUnsafe(UnsafeCursor unsafeCursor) {
        if (unsafeCursor.buffer == null) {
            unsafeCursor.buffer = this;
            unsafeCursor.readWrite = false;
            return unsafeCursor;
        }
        throw new IllegalStateException("already attached to a buffer");
    }

    public String readUtf8LineStrict(long j4) throws EOFException {
        if (j4 >= 0) {
            long j5 = Long.MAX_VALUE;
            if (j4 != Long.MAX_VALUE) {
                j5 = j4 + 1;
            }
            long j6 = j5;
            long indexOf = indexOf((byte) 10, 0, j6);
            if (indexOf != -1) {
                return readUtf8Line(indexOf);
            }
            if (j6 < size() && getByte(j6 - 1) == 13 && getByte(j6) == 10) {
                return readUtf8Line(j6);
            }
            Buffer buffer = new Buffer();
            copyTo(buffer, 0, Math.min(32, size()));
            throw new EOFException("\\n not found: limit=" + Math.min(size(), j4) + " content=" + buffer.readByteString().hex() + 8230);
        }
        throw new IllegalArgumentException("limit < 0: " + j4);
    }

    public Buffer writeByte(int i4) {
        Segment writableSegment = writableSegment(1);
        byte[] bArr = writableSegment.data;
        int i5 = writableSegment.limit;
        writableSegment.limit = i5 + 1;
        bArr[i5] = (byte) i4;
        this.size++;
        return this;
    }

    public Buffer writeDecimalLong(long j4) {
        boolean z4;
        int i4 = (j4 > 0 ? 1 : (j4 == 0 ? 0 : -1));
        if (i4 == 0) {
            return writeByte(48);
        }
        int i5 = 1;
        if (i4 < 0) {
            j4 = -j4;
            if (j4 < 0) {
                return writeUtf8("-9223372036854775808");
            }
            z4 = true;
        } else {
            z4 = false;
        }
        if (j4 >= 100000000) {
            i5 = j4 < 1000000000000L ? j4 < 10000000000L ? j4 < C.NANOS_PER_SECOND ? 9 : 10 : j4 < 100000000000L ? 11 : 12 : j4 < 1000000000000000L ? j4 < 10000000000000L ? 13 : j4 < 100000000000000L ? 14 : 15 : j4 < 100000000000000000L ? j4 < 10000000000000000L ? 16 : 17 : j4 < 1000000000000000000L ? 18 : 19;
        } else if (j4 >= WorkRequest.MIN_BACKOFF_MILLIS) {
            i5 = j4 < 1000000 ? j4 < 100000 ? 5 : 6 : j4 < 10000000 ? 7 : 8;
        } else if (j4 >= 100) {
            i5 = j4 < 1000 ? 3 : 4;
        } else if (j4 >= 10) {
            i5 = 2;
        }
        if (z4) {
            i5++;
        }
        Segment writableSegment = writableSegment(i5);
        byte[] bArr = writableSegment.data;
        int i6 = writableSegment.limit + i5;
        while (j4 != 0) {
            i6--;
            bArr[i6] = DIGITS[(int) (j4 % 10)];
            j4 /= 10;
        }
        if (z4) {
            bArr[i6 - 1] = 45;
        }
        writableSegment.limit += i5;
        this.size += (long) i5;
        return this;
    }

    public Buffer writeHexadecimalUnsignedLong(long j4) {
        if (j4 == 0) {
            return writeByte(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j4)) / 4) + 1;
        Segment writableSegment = writableSegment(numberOfTrailingZeros);
        byte[] bArr = writableSegment.data;
        int i4 = writableSegment.limit;
        for (int i5 = (i4 + numberOfTrailingZeros) - 1; i5 >= i4; i5--) {
            bArr[i5] = DIGITS[(int) (15 & j4)];
            j4 >>>= 4;
        }
        writableSegment.limit += numberOfTrailingZeros;
        this.size += (long) numberOfTrailingZeros;
        return this;
    }

    public Buffer writeInt(int i4) {
        Segment writableSegment = writableSegment(4);
        byte[] bArr = writableSegment.data;
        int i5 = writableSegment.limit;
        bArr[i5] = (byte) ((i4 >>> 24) & 255);
        bArr[i5 + 1] = (byte) ((i4 >>> 16) & 255);
        bArr[i5 + 2] = (byte) ((i4 >>> 8) & 255);
        bArr[i5 + 3] = (byte) (i4 & 255);
        writableSegment.limit = i5 + 4;
        this.size += 4;
        return this;
    }

    public Buffer writeIntLe(int i4) {
        return writeInt(Util.reverseBytesInt(i4));
    }

    public Buffer writeLong(long j4) {
        Segment writableSegment = writableSegment(8);
        byte[] bArr = writableSegment.data;
        int i4 = writableSegment.limit;
        bArr[i4] = (byte) ((int) ((j4 >>> 56) & 255));
        bArr[i4 + 1] = (byte) ((int) ((j4 >>> 48) & 255));
        bArr[i4 + 2] = (byte) ((int) ((j4 >>> 40) & 255));
        bArr[i4 + 3] = (byte) ((int) ((j4 >>> 32) & 255));
        bArr[i4 + 4] = (byte) ((int) ((j4 >>> 24) & 255));
        bArr[i4 + 5] = (byte) ((int) ((j4 >>> 16) & 255));
        bArr[i4 + 6] = (byte) ((int) ((j4 >>> 8) & 255));
        bArr[i4 + 7] = (byte) ((int) (j4 & 255));
        writableSegment.limit = i4 + 8;
        this.size += 8;
        return this;
    }

    public Buffer writeLongLe(long j4) {
        return writeLong(Util.reverseBytesLong(j4));
    }

    public Buffer writeShort(int i4) {
        Segment writableSegment = writableSegment(2);
        byte[] bArr = writableSegment.data;
        int i5 = writableSegment.limit;
        bArr[i5] = (byte) ((i4 >>> 8) & 255);
        bArr[i5 + 1] = (byte) (i4 & 255);
        writableSegment.limit = i5 + 2;
        this.size += 2;
        return this;
    }

    public Buffer writeShortLe(int i4) {
        return writeShort((int) Util.reverseBytesShort((short) i4));
    }

    public final Buffer writeTo(OutputStream outputStream, long j4) throws IOException {
        if (outputStream != null) {
            long j5 = j4;
            Util.checkOffsetAndCount(this.size, 0, j5);
            Segment segment = this.head;
            long j6 = j5;
            while (j6 > 0) {
                int min = (int) Math.min(j6, (long) (segment.limit - segment.pos));
                outputStream.write(segment.data, segment.pos, min);
                int i4 = segment.pos + min;
                segment.pos = i4;
                long j7 = (long) min;
                this.size -= j7;
                j6 -= j7;
                if (i4 == segment.limit) {
                    Segment pop = segment.pop();
                    this.head = pop;
                    SegmentPool.recycle(segment);
                    segment = pop;
                }
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    public Buffer writeUtf8CodePoint(int i4) {
        if (i4 < 128) {
            writeByte(i4);
            return this;
        } else if (i4 < 2048) {
            writeByte((i4 >> 6) | PsExtractor.AUDIO_STREAM);
            writeByte((i4 & 63) | 128);
            return this;
        } else if (i4 < 65536) {
            if (i4 < 55296 || i4 > 57343) {
                writeByte((i4 >> 12) | 224);
                writeByte(((i4 >> 6) & 63) | 128);
                writeByte((i4 & 63) | 128);
                return this;
            }
            writeByte(63);
            return this;
        } else if (i4 <= 1114111) {
            writeByte((i4 >> 18) | PsExtractor.VIDEO_STREAM_MASK);
            writeByte(((i4 >> 12) & 63) | 128);
            writeByte(((i4 >> 6) & 63) | 128);
            writeByte((i4 & 63) | 128);
            return this;
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i4));
        }
    }

    public long indexOf(byte b5, long j4, long j5) {
        Segment segment;
        long j6 = 0;
        if (j4 < 0 || j5 < j4) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(this.size), Long.valueOf(j4), Long.valueOf(j5)}));
        }
        long j7 = this.size;
        long j8 = j5 > j7 ? j7 : j5;
        if (j4 == j8 || (segment = this.head) == null) {
            return -1;
        }
        if (j7 - j4 < j4) {
            while (j7 > j4) {
                segment = segment.prev;
                j7 -= (long) (segment.limit - segment.pos);
            }
        } else {
            while (true) {
                long j9 = ((long) (segment.limit - segment.pos)) + j6;
                if (j9 >= j4) {
                    break;
                }
                segment = segment.next;
                j6 = j9;
            }
            j7 = j6;
        }
        long j10 = j4;
        while (j7 < j8) {
            byte[] bArr = segment.data;
            int min = (int) Math.min((long) segment.limit, (((long) segment.pos) + j8) - j7);
            for (int i4 = (int) ((((long) segment.pos) + j10) - j7); i4 < min; i4++) {
                if (bArr[i4] == b5) {
                    return ((long) (i4 - segment.pos)) + j7;
                }
            }
            byte b6 = b5;
            j7 += (long) (segment.limit - segment.pos);
            segment = segment.next;
            j10 = j7;
        }
        return -1;
    }

    public byte[] readByteArray(long j4) throws EOFException {
        long j5 = j4;
        Util.checkOffsetAndCount(this.size, 0, j5);
        if (j5 <= 2147483647L) {
            byte[] bArr = new byte[((int) j5)];
            readFully(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j5);
    }

    public String readString(long j4, Charset charset) throws EOFException {
        long j5 = j4;
        Util.checkOffsetAndCount(this.size, 0, j5);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j5 > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j5);
        } else if (j5 == 0) {
            return "";
        } else {
            Segment segment = this.head;
            int i4 = segment.pos;
            if (((long) i4) + j5 > ((long) segment.limit)) {
                return new String(readByteArray(j5), charset);
            }
            String str = new String(segment.data, i4, (int) j5, charset);
            int i5 = (int) (((long) segment.pos) + j5);
            segment.pos = i5;
            this.size -= j5;
            if (i5 == segment.limit) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            }
            return str;
        }
    }

    public String readUtf8(long j4) throws EOFException {
        return readString(j4, Util.UTF_8);
    }

    public Buffer writeString(String str, Charset charset) {
        return writeString(str, 0, str.length(), charset);
    }

    public Buffer writeUtf8(String str) {
        return writeUtf8(str, 0, str.length());
    }

    private void readFrom(InputStream inputStream, long j4, boolean z4) throws IOException {
        if (inputStream != null) {
            while (true) {
                if (j4 > 0 || z4) {
                    Segment writableSegment = writableSegment(1);
                    int read = inputStream.read(writableSegment.data, writableSegment.limit, (int) Math.min(j4, (long) (8192 - writableSegment.limit)));
                    if (read != -1) {
                        writableSegment.limit += read;
                        long j5 = (long) read;
                        this.size += j5;
                        j4 -= j5;
                    } else if (!z4) {
                        throw new EOFException();
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException("in == null");
        }
    }

    /* access modifiers changed from: package-private */
    public String readUtf8Line(long j4) throws EOFException {
        if (j4 > 0) {
            long j5 = j4 - 1;
            if (getByte(j5) == 13) {
                String readUtf8 = readUtf8(j5);
                skip(2);
                return readUtf8;
            }
        }
        String readUtf82 = readUtf8(j4);
        skip(1);
        return readUtf82;
    }

    public final ByteString snapshot(int i4) {
        if (i4 == 0) {
            return ByteString.EMPTY;
        }
        return new SegmentedByteString(this, i4);
    }

    public Buffer write(ByteString byteString) {
        if (byteString != null) {
            byteString.write(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    public Buffer writeString(String str, int i4, int i5, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i4 < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i4);
        } else if (i5 < i4) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i5 + " < " + i4);
        } else if (i5 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i5 + " > " + str.length());
        } else if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (charset.equals(Util.UTF_8)) {
            return writeUtf8(str, i4, i5);
        } else {
            byte[] bytes = str.substring(i4, i5).getBytes(charset);
            return write(bytes, 0, bytes.length);
        }
    }

    public Buffer writeUtf8(String str, int i4, int i5) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i4 < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i4);
        } else if (i5 < i4) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i5 + " < " + i4);
        } else if (i5 <= str.length()) {
            while (i4 < i5) {
                char charAt = str.charAt(i4);
                if (charAt < 128) {
                    Segment writableSegment = writableSegment(1);
                    byte[] bArr = writableSegment.data;
                    int i6 = writableSegment.limit - i4;
                    int min = Math.min(i5, 8192 - i6);
                    int i7 = i4 + 1;
                    bArr[i4 + i6] = (byte) charAt;
                    while (i7 < min) {
                        char charAt2 = str.charAt(i7);
                        if (charAt2 >= 128) {
                            break;
                        }
                        bArr[i7 + i6] = (byte) charAt2;
                        i7++;
                    }
                    int i8 = writableSegment.limit;
                    int i9 = (i6 + i7) - i8;
                    writableSegment.limit = i8 + i9;
                    this.size += (long) i9;
                    i4 = i7;
                } else {
                    if (charAt < 2048) {
                        writeByte((charAt >> 6) | PsExtractor.AUDIO_STREAM);
                        writeByte((int) (charAt & '?') | 128);
                    } else if (charAt < 55296 || charAt > 57343) {
                        writeByte((charAt >> 12) | 224);
                        writeByte(((charAt >> 6) & 63) | 128);
                        writeByte((int) (charAt & '?') | 128);
                    } else {
                        int i10 = i4 + 1;
                        char charAt3 = i10 < i5 ? str.charAt(i10) : 0;
                        if (charAt > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                            writeByte(63);
                            i4 = i10;
                        } else {
                            int i11 = (((charAt & 10239) << 10) | (9215 & charAt3)) + 0;
                            writeByte((i11 >> 18) | PsExtractor.VIDEO_STREAM_MASK);
                            writeByte(((i11 >> 12) & 63) | 128);
                            writeByte(((i11 >> 6) & 63) | 128);
                            writeByte((i11 & 63) | 128);
                            i4 += 2;
                        }
                    }
                    i4++;
                }
            }
            return this;
        } else {
            throw new IllegalArgumentException("endIndex > string.length: " + i5 + " > " + str.length());
        }
    }

    private boolean rangeEquals(Segment segment, int i4, ByteString byteString, int i5, int i6) {
        int i7 = segment.limit;
        byte[] bArr = segment.data;
        while (i5 < i6) {
            if (i4 == i7) {
                segment = segment.next;
                byte[] bArr2 = segment.data;
                int i8 = segment.pos;
                bArr = bArr2;
                i4 = i8;
                i7 = segment.limit;
            }
            if (bArr[i4] != byteString.getByte(i5)) {
                return false;
            }
            i4++;
            i5++;
        }
        return true;
    }

    public void readFully(byte[] bArr) throws EOFException {
        int i4 = 0;
        while (i4 < bArr.length) {
            int read = read(bArr, i4, bArr.length - i4);
            if (read != -1) {
                i4 += read;
            } else {
                throw new EOFException();
            }
        }
    }

    public Buffer write(byte[] bArr) {
        if (bArr != null) {
            return write(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    public Buffer write(byte[] bArr, int i4, int i5) {
        if (bArr != null) {
            long j4 = (long) i5;
            Util.checkOffsetAndCount((long) bArr.length, (long) i4, j4);
            int i6 = i5 + i4;
            while (i4 < i6) {
                Segment writableSegment = writableSegment(1);
                int min = Math.min(i6 - i4, 8192 - writableSegment.limit);
                System.arraycopy(bArr, i4, writableSegment.data, writableSegment.limit, min);
                i4 += min;
                writableSegment.limit += min;
            }
            this.size += j4;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public final Buffer copyTo(Buffer buffer, long j4, long j5) {
        if (buffer != null) {
            long j6 = j4;
            long j7 = j5;
            Util.checkOffsetAndCount(this.size, j6, j7);
            if (j7 != 0) {
                buffer.size += j7;
                Segment segment = this.head;
                while (true) {
                    int i4 = segment.limit;
                    int i5 = segment.pos;
                    if (j6 < ((long) (i4 - i5))) {
                        break;
                    }
                    j6 -= (long) (i4 - i5);
                    segment = segment.next;
                }
                Segment segment2 = segment;
                long j8 = j7;
                while (j8 > 0) {
                    Segment sharedCopy = segment2.sharedCopy();
                    int i6 = (int) (((long) sharedCopy.pos) + j6);
                    sharedCopy.pos = i6;
                    sharedCopy.limit = Math.min(i6 + ((int) j8), sharedCopy.limit);
                    Segment segment3 = buffer.head;
                    if (segment3 == null) {
                        sharedCopy.prev = sharedCopy;
                        sharedCopy.next = sharedCopy;
                        buffer.head = sharedCopy;
                    } else {
                        segment3.prev.push(sharedCopy);
                    }
                    j8 -= (long) (sharedCopy.limit - sharedCopy.pos);
                    segment2 = segment2.next;
                    j6 = 0;
                }
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    public int read(ByteBuffer byteBuffer) throws IOException {
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), segment.limit - segment.pos);
        byteBuffer.put(segment.data, segment.pos, min);
        int i4 = segment.pos + min;
        segment.pos = i4;
        this.size -= (long) min;
        if (i4 == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            int i4 = remaining;
            while (i4 > 0) {
                Segment writableSegment = writableSegment(1);
                int min = Math.min(i4, 8192 - writableSegment.limit);
                byteBuffer.get(writableSegment.data, writableSegment.limit, min);
                i4 -= min;
                writableSegment.limit += min;
            }
            this.size += (long) remaining;
            return remaining;
        }
        throw new IllegalArgumentException("source == null");
    }

    public long indexOf(ByteString byteString) throws IOException {
        return indexOf(byteString, 0);
    }

    public long indexOf(ByteString byteString, long j4) throws IOException {
        Buffer buffer = this;
        if (byteString.size() != 0) {
            long j5 = 0;
            if (j4 >= 0) {
                Segment segment = buffer.head;
                long j6 = -1;
                if (segment == null) {
                    return -1;
                }
                long j7 = buffer.size;
                if (j7 - j4 < j4) {
                    while (j7 > j4) {
                        segment = segment.prev;
                        j7 -= (long) (segment.limit - segment.pos);
                    }
                } else {
                    while (true) {
                        long j8 = ((long) (segment.limit - segment.pos)) + j5;
                        if (j8 >= j4) {
                            break;
                        }
                        segment = segment.next;
                        j5 = j8;
                    }
                    j7 = j5;
                }
                ByteString byteString2 = byteString;
                byte b5 = byteString2.getByte(0);
                long j9 = j7;
                int size2 = byteString2.size();
                long j10 = (buffer.size - ((long) size2)) + 1;
                Segment segment2 = segment;
                long j11 = j4;
                while (j9 < j10) {
                    byte[] bArr = segment2.data;
                    long j12 = j6;
                    int min = (int) Math.min((long) segment2.limit, (((long) segment2.pos) + j10) - j9);
                    int i4 = (int) ((((long) segment2.pos) + j11) - j9);
                    while (i4 < min) {
                        if (bArr[i4] == b5 && buffer.rangeEquals(segment2, i4 + 1, byteString, 1, size2)) {
                            return ((long) (i4 - segment2.pos)) + j9;
                        }
                        i4++;
                        buffer = this;
                        ByteString byteString3 = byteString;
                    }
                    j9 += (long) (segment2.limit - segment2.pos);
                    segment2 = segment2.next;
                    buffer = this;
                    ByteString byteString4 = byteString;
                    j11 = j9;
                    j6 = j12;
                }
                return j6;
            }
            throw new IllegalArgumentException("fromIndex < 0");
        }
        throw new IllegalArgumentException("bytes is empty");
    }

    public long read(Buffer buffer, long j4) {
        if (buffer == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j4 >= 0) {
            long j5 = this.size;
            if (j5 == 0) {
                return -1;
            }
            if (j4 > j5) {
                j4 = j5;
            }
            buffer.write(this, j4);
            return j4;
        } else {
            throw new IllegalArgumentException("byteCount < 0: " + j4);
        }
    }

    public BufferedSink write(Source source, long j4) throws IOException {
        while (j4 > 0) {
            long read = source.read(this, j4);
            if (read != -1) {
                j4 -= read;
            } else {
                throw new EOFException();
            }
        }
        return this;
    }

    public void write(Buffer buffer, long j4) {
        if (buffer == null) {
            throw new IllegalArgumentException("source == null");
        } else if (buffer != this) {
            Util.checkOffsetAndCount(buffer.size, 0, j4);
            while (j4 > 0) {
                Segment segment = buffer.head;
                if (j4 < ((long) (segment.limit - segment.pos))) {
                    Segment segment2 = this.head;
                    Segment segment3 = segment2 != null ? segment2.prev : null;
                    if (segment3 != null && segment3.owner) {
                        if ((((long) segment3.limit) + j4) - ((long) (segment3.shared ? 0 : segment3.pos)) <= 8192) {
                            segment.writeTo(segment3, (int) j4);
                            buffer.size -= j4;
                            this.size += j4;
                            return;
                        }
                    }
                    buffer.head = segment.split((int) j4);
                }
                Segment segment4 = buffer.head;
                long j5 = (long) (segment4.limit - segment4.pos);
                buffer.head = segment4.pop();
                Segment segment5 = this.head;
                if (segment5 == null) {
                    this.head = segment4;
                    segment4.prev = segment4;
                    segment4.next = segment4;
                } else {
                    segment5.prev.push(segment4).compact();
                }
                buffer.size -= j5;
                this.size += j5;
                j4 -= j5;
            }
        } else {
            throw new IllegalArgumentException("source == this");
        }
    }
}
