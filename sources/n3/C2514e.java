package N3;

import O3.C2535a;
import S2.C1594h;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.work.WorkRequest;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.io.Closeable;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import kotlin.jvm.internal.m;
import m3.d;

/* renamed from: N3.e  reason: case insensitive filesystem */
public final class C2514e implements C2516g, C2515f, Cloneable, ByteChannel, AutoCloseable {

    /* renamed from: a  reason: collision with root package name */
    public U f23694a;

    /* renamed from: b  reason: collision with root package name */
    private long f23695b;

    /* renamed from: N3.e$a */
    public static final class a implements Closeable, AutoCloseable {

        /* renamed from: a  reason: collision with root package name */
        public C2514e f23696a;

        /* renamed from: b  reason: collision with root package name */
        private U f23697b;

        /* renamed from: c  reason: collision with root package name */
        public long f23698c = -1;

        /* renamed from: d  reason: collision with root package name */
        public byte[] f23699d;

        /* renamed from: e  reason: collision with root package name */
        public int f23700e = -1;

        /* renamed from: f  reason: collision with root package name */
        public int f23701f = -1;

        public final void a(U u4) {
            this.f23697b = u4;
        }

        public void close() {
            if (this.f23696a != null) {
                this.f23696a = null;
                a((U) null);
                this.f23698c = -1;
                this.f23699d = null;
                this.f23700e = -1;
                this.f23701f = -1;
                return;
            }
            throw new IllegalStateException("not attached to a buffer");
        }
    }

    /* renamed from: N3.e$c */
    public static final class c extends OutputStream implements AutoCloseable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2514e f23703a;

        c(C2514e eVar) {
            this.f23703a = eVar;
        }

        public String toString() {
            return this.f23703a + ".outputStream()";
        }

        public void write(int i4) {
            this.f23703a.writeByte(i4);
        }

        public void write(byte[] bArr, int i4, int i5) {
            m.e(bArr, DataSchemeDataSource.SCHEME_DATA);
            this.f23703a.write(bArr, i4, i5);
        }

        public void close() {
        }

        public void flush() {
        }
    }

    public final long A() {
        return this.f23695b;
    }

    public final C2517h D() {
        if (A() <= 2147483647L) {
            return E((int) A());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + A()).toString());
    }

    public final C2517h E(int i4) {
        if (i4 == 0) {
            return C2517h.f23705e;
        }
        C2511b.b(A(), 0, (long) i4);
        U u4 = this.f23694a;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i6 < i4) {
            m.b(u4);
            int i8 = u4.f23653c;
            int i9 = u4.f23652b;
            if (i8 != i9) {
                i6 += i8 - i9;
                i7++;
                u4 = u4.f23656f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        byte[][] bArr = new byte[i7][];
        int[] iArr = new int[(i7 * 2)];
        U u5 = this.f23694a;
        int i10 = 0;
        while (i5 < i4) {
            m.b(u5);
            bArr[i10] = u5.f23651a;
            i5 += u5.f23653c - u5.f23652b;
            iArr[i10] = Math.min(i5, i4);
            iArr[i10 + i7] = u5.f23652b;
            u5.f23654d = true;
            i10++;
            u5 = u5.f23656f;
        }
        return new W(bArr, iArr);
    }

    public final U F(int i4) {
        if (i4 < 1 || i4 > 8192) {
            throw new IllegalArgumentException("unexpected capacity");
        }
        U u4 = this.f23694a;
        if (u4 == null) {
            U c5 = V.c();
            this.f23694a = c5;
            c5.f23657g = c5;
            c5.f23656f = c5;
            return c5;
        }
        m.b(u4);
        U u5 = u4.f23657g;
        m.b(u5);
        if (u5.f23653c + i4 > 8192 || !u5.f23655e) {
            return u5.c(V.c());
        }
        return u5;
    }

    public C2514e G(C2517h hVar) {
        m.e(hVar, "byteString");
        hVar.N(this, 0, hVar.G());
        return this;
    }

    /* renamed from: H */
    public C2514e write(byte[] bArr) {
        m.e(bArr, "source");
        return write(bArr, 0, bArr.length);
    }

    /* renamed from: I */
    public C2514e write(byte[] bArr, int i4, int i5) {
        m.e(bArr, "source");
        long j4 = (long) i5;
        C2511b.b((long) bArr.length, (long) i4, j4);
        int i6 = i5 + i4;
        while (i4 < i6) {
            U F4 = F(1);
            int min = Math.min(i6 - i4, 8192 - F4.f23653c);
            int i7 = i4 + min;
            C1594h.d(bArr, F4.f23651a, F4.f23653c, i4, i7);
            F4.f23653c += min;
            i4 = i7;
        }
        z(A() + j4);
        return this;
    }

    public long J(Z z4) {
        m.e(z4, "source");
        long j4 = 0;
        while (true) {
            long e5 = z4.e(this, 8192);
            if (e5 == -1) {
                return j4;
            }
            j4 += e5;
        }
    }

    /* renamed from: K */
    public C2514e writeByte(int i4) {
        U F4 = F(1);
        byte[] bArr = F4.f23651a;
        int i5 = F4.f23653c;
        F4.f23653c = i5 + 1;
        bArr[i5] = (byte) i4;
        z(A() + 1);
        return this;
    }

    /* renamed from: L */
    public C2514e writeDecimalLong(long j4) {
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
        if (j4 < 100000000) {
            if (j4 < WorkRequest.MIN_BACKOFF_MILLIS) {
                if (j4 < 100) {
                    if (j4 >= 10) {
                        i5 = 2;
                    }
                } else if (j4 < 1000) {
                    i5 = 3;
                } else {
                    i5 = 4;
                }
            } else if (j4 < 1000000) {
                if (j4 < 100000) {
                    i5 = 5;
                } else {
                    i5 = 6;
                }
            } else if (j4 < 10000000) {
                i5 = 7;
            } else {
                i5 = 8;
            }
        } else if (j4 < 1000000000000L) {
            if (j4 < 10000000000L) {
                if (j4 < C.NANOS_PER_SECOND) {
                    i5 = 9;
                } else {
                    i5 = 10;
                }
            } else if (j4 < 100000000000L) {
                i5 = 11;
            } else {
                i5 = 12;
            }
        } else if (j4 < 1000000000000000L) {
            if (j4 < 10000000000000L) {
                i5 = 13;
            } else if (j4 < 100000000000000L) {
                i5 = 14;
            } else {
                i5 = 15;
            }
        } else if (j4 < 100000000000000000L) {
            if (j4 < 10000000000000000L) {
                i5 = 16;
            } else {
                i5 = 17;
            }
        } else if (j4 < 1000000000000000000L) {
            i5 = 18;
        } else {
            i5 = 19;
        }
        if (z4) {
            i5++;
        }
        U F4 = F(i5);
        byte[] bArr = F4.f23651a;
        int i6 = F4.f23653c + i5;
        while (j4 != 0) {
            long j5 = (long) 10;
            i6--;
            bArr[i6] = C2535a.a()[(int) (j4 % j5)];
            j4 /= j5;
        }
        if (z4) {
            bArr[i6 - 1] = 45;
        }
        F4.f23653c += i5;
        z(A() + ((long) i5));
        return this;
    }

    /* renamed from: M */
    public C2514e writeHexadecimalUnsignedLong(long j4) {
        if (j4 == 0) {
            return writeByte(48);
        }
        long j5 = (j4 >>> 1) | j4;
        long j6 = j5 | (j5 >>> 2);
        long j7 = j6 | (j6 >>> 4);
        long j8 = j7 | (j7 >>> 8);
        long j9 = j8 | (j8 >>> 16);
        long j10 = j9 | (j9 >>> 32);
        long j11 = j10 - ((j10 >>> 1) & 6148914691236517205L);
        long j12 = ((j11 >>> 2) & 3689348814741910323L) + (j11 & 3689348814741910323L);
        long j13 = ((j12 >>> 4) + j12) & 1085102592571150095L;
        long j14 = j13 + (j13 >>> 8);
        long j15 = j14 + (j14 >>> 16);
        int i4 = (int) ((((j15 & 63) + ((j15 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        U F4 = F(i4);
        byte[] bArr = F4.f23651a;
        int i5 = F4.f23653c;
        for (int i6 = (i5 + i4) - 1; i6 >= i5; i6--) {
            bArr[i6] = C2535a.a()[(int) (15 & j4)];
            j4 >>>= 4;
        }
        F4.f23653c += i4;
        z(A() + ((long) i4));
        return this;
    }

    /* renamed from: N */
    public C2514e writeInt(int i4) {
        U F4 = F(4);
        byte[] bArr = F4.f23651a;
        int i5 = F4.f23653c;
        bArr[i5] = (byte) ((i4 >>> 24) & 255);
        bArr[i5 + 1] = (byte) ((i4 >>> 16) & 255);
        bArr[i5 + 2] = (byte) ((i4 >>> 8) & 255);
        bArr[i5 + 3] = (byte) (i4 & 255);
        F4.f23653c = i5 + 4;
        z(A() + 4);
        return this;
    }

    /* renamed from: O */
    public C2514e writeShort(int i4) {
        U F4 = F(2);
        byte[] bArr = F4.f23651a;
        int i5 = F4.f23653c;
        bArr[i5] = (byte) ((i4 >>> 8) & 255);
        bArr[i5 + 1] = (byte) (i4 & 255);
        F4.f23653c = i5 + 2;
        z(A() + 2);
        return this;
    }

    public C2514e P(String str, int i4, int i5, Charset charset) {
        m.e(str, TypedValues.Custom.S_STRING);
        m.e(charset, "charset");
        if (i4 < 0) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i4).toString());
        } else if (i5 < i4) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i5 + " < " + i4).toString());
        } else if (i5 > str.length()) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i5 + " > " + str.length()).toString());
        } else if (m.a(charset, d.f21160b)) {
            return R(str, i4, i5);
        } else {
            String substring = str.substring(i4, i5);
            m.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            byte[] bytes = substring.getBytes(charset);
            m.d(bytes, "this as java.lang.String).getBytes(charset)");
            return write(bytes, 0, bytes.length);
        }
    }

    /* renamed from: Q */
    public C2514e writeUtf8(String str) {
        m.e(str, TypedValues.Custom.S_STRING);
        return R(str, 0, str.length());
    }

    public C2514e R(String str, int i4, int i5) {
        char c5;
        char charAt;
        m.e(str, TypedValues.Custom.S_STRING);
        if (i4 < 0) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i4).toString());
        } else if (i5 < i4) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i5 + " < " + i4).toString());
        } else if (i5 <= str.length()) {
            while (i4 < i5) {
                char charAt2 = str.charAt(i4);
                if (charAt2 < 128) {
                    U F4 = F(1);
                    byte[] bArr = F4.f23651a;
                    int i6 = F4.f23653c - i4;
                    int min = Math.min(i5, 8192 - i6);
                    int i7 = i4 + 1;
                    bArr[i4 + i6] = (byte) charAt2;
                    while (true) {
                        i4 = i7;
                        if (i4 >= min || (charAt = str.charAt(i4)) >= 128) {
                            int i8 = F4.f23653c;
                            int i9 = (i6 + i4) - i8;
                            F4.f23653c = i8 + i9;
                            z(A() + ((long) i9));
                        } else {
                            i7 = i4 + 1;
                            bArr[i4 + i6] = (byte) charAt;
                        }
                    }
                    int i82 = F4.f23653c;
                    int i92 = (i6 + i4) - i82;
                    F4.f23653c = i82 + i92;
                    z(A() + ((long) i92));
                } else {
                    if (charAt2 < 2048) {
                        U F5 = F(2);
                        byte[] bArr2 = F5.f23651a;
                        int i10 = F5.f23653c;
                        bArr2[i10] = (byte) ((charAt2 >> 6) | PsExtractor.AUDIO_STREAM);
                        bArr2[i10 + 1] = (byte) ((charAt2 & '?') | 128);
                        F5.f23653c = i10 + 2;
                        z(A() + 2);
                    } else if (charAt2 < 55296 || charAt2 > 57343) {
                        U F6 = F(3);
                        byte[] bArr3 = F6.f23651a;
                        int i11 = F6.f23653c;
                        bArr3[i11] = (byte) ((charAt2 >> 12) | 224);
                        bArr3[i11 + 1] = (byte) ((63 & (charAt2 >> 6)) | 128);
                        bArr3[i11 + 2] = (byte) ((charAt2 & '?') | 128);
                        F6.f23653c = i11 + 3;
                        z(A() + 3);
                    } else {
                        int i12 = i4 + 1;
                        if (i12 < i5) {
                            c5 = str.charAt(i12);
                        } else {
                            c5 = 0;
                        }
                        if (charAt2 > 56319 || 56320 > c5 || c5 >= 57344) {
                            writeByte(63);
                            i4 = i12;
                        } else {
                            int i13 = (((charAt2 & 1023) << 10) | (c5 & 1023)) + 0;
                            U F7 = F(4);
                            byte[] bArr4 = F7.f23651a;
                            int i14 = F7.f23653c;
                            bArr4[i14] = (byte) ((i13 >> 18) | PsExtractor.VIDEO_STREAM_MASK);
                            bArr4[i14 + 1] = (byte) (((i13 >> 12) & 63) | 128);
                            bArr4[i14 + 2] = (byte) (((i13 >> 6) & 63) | 128);
                            bArr4[i14 + 3] = (byte) ((i13 & 63) | 128);
                            F7.f23653c = i14 + 4;
                            z(A() + 4);
                            i4 += 2;
                        }
                    }
                    i4++;
                }
            }
            return this;
        } else {
            throw new IllegalArgumentException(("endIndex > string.length: " + i5 + " > " + str.length()).toString());
        }
    }

    public C2514e S(int i4) {
        if (i4 < 128) {
            writeByte(i4);
            return this;
        } else if (i4 < 2048) {
            U F4 = F(2);
            byte[] bArr = F4.f23651a;
            int i5 = F4.f23653c;
            bArr[i5] = (byte) ((i4 >> 6) | PsExtractor.AUDIO_STREAM);
            bArr[i5 + 1] = (byte) ((i4 & 63) | 128);
            F4.f23653c = i5 + 2;
            z(A() + 2);
            return this;
        } else if (55296 <= i4 && i4 < 57344) {
            writeByte(63);
            return this;
        } else if (i4 < 65536) {
            U F5 = F(3);
            byte[] bArr2 = F5.f23651a;
            int i6 = F5.f23653c;
            bArr2[i6] = (byte) ((i4 >> 12) | 224);
            bArr2[i6 + 1] = (byte) (((i4 >> 6) & 63) | 128);
            bArr2[i6 + 2] = (byte) ((i4 & 63) | 128);
            F5.f23653c = i6 + 3;
            z(A() + 3);
            return this;
        } else if (i4 <= 1114111) {
            U F6 = F(4);
            byte[] bArr3 = F6.f23651a;
            int i7 = F6.f23653c;
            bArr3[i7] = (byte) ((i4 >> 18) | PsExtractor.VIDEO_STREAM_MASK);
            bArr3[i7 + 1] = (byte) (((i4 >> 12) & 63) | 128);
            bArr3[i7 + 2] = (byte) (((i4 >> 6) & 63) | 128);
            bArr3[i7 + 3] = (byte) ((i4 & 63) | 128);
            F6.f23653c = i7 + 4;
            z(A() + 4);
            return this;
        } else {
            throw new IllegalArgumentException("Unexpected code point: 0x" + C2511b.i(i4));
        }
    }

    public final void a() {
        skip(A());
    }

    /* renamed from: d */
    public C2514e clone() {
        return i();
    }

    public long e(C2514e eVar, long j4) {
        m.e(eVar, "sink");
        if (j4 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j4).toString());
        } else if (A() == 0) {
            return -1;
        } else {
            if (j4 > A()) {
                j4 = A();
            }
            eVar.m(this, j4);
            return j4;
        }
    }

    /* JADX WARNING: type inference failed for: r19v0, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = 1
            if (r0 != r1) goto L_0x0008
            return r2
        L_0x0008:
            boolean r3 = r1 instanceof N3.C2514e
            r4 = 0
            if (r3 != 0) goto L_0x000e
            return r4
        L_0x000e:
            long r5 = r0.A()
            N3.e r1 = (N3.C2514e) r1
            long r7 = r1.A()
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x001d
            return r4
        L_0x001d:
            long r5 = r0.A()
            r7 = 0
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 != 0) goto L_0x0028
            return r2
        L_0x0028:
            N3.U r3 = r0.f23694a
            kotlin.jvm.internal.m.b(r3)
            N3.U r1 = r1.f23694a
            kotlin.jvm.internal.m.b(r1)
            int r5 = r3.f23652b
            int r6 = r1.f23652b
            r9 = r7
        L_0x0037:
            long r11 = r0.A()
            int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r13 >= 0) goto L_0x007e
            int r11 = r3.f23653c
            int r11 = r11 - r5
            int r12 = r1.f23653c
            int r12 = r12 - r6
            int r11 = java.lang.Math.min(r11, r12)
            long r11 = (long) r11
            r13 = r7
        L_0x004b:
            int r15 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r15 >= 0) goto L_0x0066
            byte[] r15 = r3.f23651a
            int r16 = r5 + 1
            byte r5 = r15[r5]
            byte[] r15 = r1.f23651a
            int r17 = r6 + 1
            byte r6 = r15[r6]
            if (r5 == r6) goto L_0x005e
            return r4
        L_0x005e:
            r5 = 1
            long r13 = r13 + r5
            r5 = r16
            r6 = r17
            goto L_0x004b
        L_0x0066:
            int r13 = r3.f23653c
            if (r5 != r13) goto L_0x0071
            N3.U r3 = r3.f23656f
            kotlin.jvm.internal.m.b(r3)
            int r5 = r3.f23652b
        L_0x0071:
            int r13 = r1.f23653c
            if (r6 != r13) goto L_0x007c
            N3.U r1 = r1.f23656f
            kotlin.jvm.internal.m.b(r1)
            int r6 = r1.f23652b
        L_0x007c:
            long r9 = r9 + r11
            goto L_0x0037
        L_0x007e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: N3.C2514e.equals(java.lang.Object):boolean");
    }

    public boolean exhausted() {
        if (this.f23695b == 0) {
            return true;
        }
        return false;
    }

    public final long g() {
        long A4 = A();
        if (A4 == 0) {
            return 0;
        }
        U u4 = this.f23694a;
        m.b(u4);
        U u5 = u4.f23657g;
        m.b(u5);
        int i4 = u5.f23653c;
        if (i4 >= 8192 || !u5.f23655e) {
            return A4;
        }
        return A4 - ((long) (i4 - u5.f23652b));
    }

    public int hashCode() {
        U u4 = this.f23694a;
        if (u4 == null) {
            return 0;
        }
        int i4 = 1;
        do {
            int i5 = u4.f23653c;
            for (int i6 = u4.f23652b; i6 < i5; i6++) {
                i4 = (i4 * 31) + u4.f23651a[i6];
            }
            u4 = u4.f23656f;
            m.b(u4);
        } while (u4 != this.f23694a);
        return i4;
    }

    public final C2514e i() {
        C2514e eVar = new C2514e();
        if (A() == 0) {
            return eVar;
        }
        U u4 = this.f23694a;
        m.b(u4);
        U d5 = u4.d();
        eVar.f23694a = d5;
        d5.f23657g = d5;
        d5.f23656f = d5;
        for (U u5 = u4.f23656f; u5 != u4; u5 = u5.f23656f) {
            U u6 = d5.f23657g;
            m.b(u6);
            m.b(u5);
            u6.c(u5.d());
        }
        eVar.z(A());
        return eVar;
    }

    public long indexOf(byte b5, long j4, long j5) {
        U u4;
        long j6;
        int i4;
        long j7 = 0;
        if (0 > j4 || j4 > j5) {
            throw new IllegalArgumentException(("size=" + A() + " fromIndex=" + j4 + " toIndex=" + j5).toString());
        }
        if (j5 > A()) {
            j5 = A();
        }
        if (j4 == j5 || (u4 = this.f23694a) == null) {
            return -1;
        }
        if (A() - j4 < j4) {
            j6 = A();
            while (j6 > j4) {
                u4 = u4.f23657g;
                m.b(u4);
                j6 -= (long) (u4.f23653c - u4.f23652b);
            }
            while (j6 < j5) {
                byte[] bArr = u4.f23651a;
                int min = (int) Math.min((long) u4.f23653c, (((long) u4.f23652b) + j5) - j6);
                i4 = (int) ((((long) u4.f23652b) + j4) - j6);
                while (i4 < min) {
                    if (bArr[i4] != b5) {
                        i4++;
                    }
                }
                j6 += (long) (u4.f23653c - u4.f23652b);
                u4 = u4.f23656f;
                m.b(u4);
                j4 = j6;
            }
            return -1;
        }
        while (true) {
            long j8 = ((long) (u4.f23653c - u4.f23652b)) + j7;
            if (j8 > j4) {
                break;
            }
            u4 = u4.f23656f;
            m.b(u4);
            j7 = j8;
        }
        while (j6 < j5) {
            byte[] bArr2 = u4.f23651a;
            int min2 = (int) Math.min((long) u4.f23653c, (((long) u4.f23652b) + j5) - j6);
            int i5 = (int) ((((long) u4.f23652b) + j4) - j6);
            while (i4 < min2) {
                if (bArr2[i4] != b5) {
                    i5 = i4 + 1;
                }
            }
            j7 = j6 + ((long) (u4.f23653c - u4.f23652b));
            u4 = u4.f23656f;
            m.b(u4);
            j4 = j7;
        }
        return -1;
        return ((long) (i4 - u4.f23652b)) + j6;
    }

    public InputStream inputStream() {
        return new b(this);
    }

    public boolean isOpen() {
        return true;
    }

    public final C2514e k(C2514e eVar, long j4, long j5) {
        m.e(eVar, "out");
        long j6 = j4;
        long j7 = j5;
        C2511b.b(A(), j6, j7);
        if (j7 != 0) {
            eVar.z(eVar.A() + j7);
            U u4 = this.f23694a;
            while (true) {
                m.b(u4);
                int i4 = u4.f23653c;
                int i5 = u4.f23652b;
                if (j6 < ((long) (i4 - i5))) {
                    break;
                }
                j6 -= (long) (i4 - i5);
                u4 = u4.f23656f;
            }
            U u5 = u4;
            long j8 = j7;
            while (j8 > 0) {
                m.b(u5);
                U d5 = u5.d();
                int i6 = d5.f23652b + ((int) j6);
                d5.f23652b = i6;
                d5.f23653c = Math.min(i6 + ((int) j8), d5.f23653c);
                U u6 = eVar.f23694a;
                if (u6 == null) {
                    d5.f23657g = d5;
                    d5.f23656f = d5;
                    eVar.f23694a = d5;
                } else {
                    m.b(u6);
                    U u7 = u6.f23657g;
                    m.b(u7);
                    u7.c(d5);
                }
                j8 -= (long) (d5.f23653c - d5.f23652b);
                u5 = u5.f23656f;
                j6 = 0;
            }
        }
        return this;
    }

    public void m(C2514e eVar, long j4) {
        U u4;
        int i4;
        m.e(eVar, "source");
        if (eVar != this) {
            C2511b.b(eVar.A(), 0, j4);
            while (j4 > 0) {
                U u5 = eVar.f23694a;
                m.b(u5);
                int i5 = u5.f23653c;
                U u6 = eVar.f23694a;
                m.b(u6);
                if (j4 < ((long) (i5 - u6.f23652b))) {
                    U u7 = this.f23694a;
                    if (u7 != null) {
                        m.b(u7);
                        u4 = u7.f23657g;
                    } else {
                        u4 = null;
                    }
                    if (u4 != null && u4.f23655e) {
                        long j5 = ((long) u4.f23653c) + j4;
                        if (u4.f23654d) {
                            i4 = 0;
                        } else {
                            i4 = u4.f23652b;
                        }
                        if (j5 - ((long) i4) <= 8192) {
                            U u8 = eVar.f23694a;
                            m.b(u8);
                            u8.f(u4, (int) j4);
                            eVar.z(eVar.A() - j4);
                            z(A() + j4);
                            return;
                        }
                    }
                    U u9 = eVar.f23694a;
                    m.b(u9);
                    eVar.f23694a = u9.e((int) j4);
                }
                U u10 = eVar.f23694a;
                m.b(u10);
                long j6 = (long) (u10.f23653c - u10.f23652b);
                eVar.f23694a = u10.b();
                U u11 = this.f23694a;
                if (u11 == null) {
                    this.f23694a = u10;
                    u10.f23657g = u10;
                    u10.f23656f = u10;
                } else {
                    m.b(u11);
                    U u12 = u11.f23657g;
                    m.b(u12);
                    u12.c(u10).a();
                }
                eVar.z(eVar.A() - j6);
                z(A() + j6);
                j4 -= j6;
            }
            return;
        }
        throw new IllegalArgumentException("source == this");
    }

    public final byte n(long j4) {
        long j5 = j4;
        C2511b.b(A(), j5, 1);
        U u4 = this.f23694a;
        if (u4 == null) {
            m.b((Object) null);
            throw null;
        } else if (A() - j5 < j5) {
            long A4 = A();
            while (A4 > j5) {
                u4 = u4.f23657g;
                m.b(u4);
                A4 -= (long) (u4.f23653c - u4.f23652b);
            }
            m.b(u4);
            return u4.f23651a[(int) ((((long) u4.f23652b) + j5) - A4)];
        } else {
            long j6 = 0;
            while (true) {
                long j7 = ((long) (u4.f23653c - u4.f23652b)) + j6;
                if (j7 <= j5) {
                    u4 = u4.f23656f;
                    m.b(u4);
                    j6 = j7;
                } else {
                    m.b(u4);
                    return u4.f23651a[(int) ((((long) u4.f23652b) + j5) - j6)];
                }
            }
        }
    }

    public long o(C2517h hVar) {
        m.e(hVar, "targetBytes");
        return p(hVar, 0);
    }

    public OutputStream outputStream() {
        return new c(this);
    }

    public long p(C2517h hVar, long j4) {
        long j5;
        int i4;
        int i5;
        int i6;
        m.e(hVar, "targetBytes");
        long j6 = 0;
        if (j4 >= 0) {
            U u4 = this.f23694a;
            if (u4 == null) {
                return -1;
            }
            if (A() - j4 < j4) {
                j5 = A();
                while (j5 > j4) {
                    u4 = u4.f23657g;
                    m.b(u4);
                    j5 -= (long) (u4.f23653c - u4.f23652b);
                }
                if (hVar.G() == 2) {
                    byte h4 = hVar.h(0);
                    byte h5 = hVar.h(1);
                    while (j5 < A()) {
                        byte[] bArr = u4.f23651a;
                        i5 = (int) ((((long) u4.f23652b) + j4) - j5);
                        int i7 = u4.f23653c;
                        while (i5 < i7) {
                            byte b5 = bArr[i5];
                            if (!(b5 == h4 || b5 == h5)) {
                                i5++;
                            }
                        }
                        j5 += (long) (u4.f23653c - u4.f23652b);
                        u4 = u4.f23656f;
                        m.b(u4);
                        j4 = j5;
                    }
                } else {
                    byte[] q4 = hVar.q();
                    while (j5 < A()) {
                        byte[] bArr2 = u4.f23651a;
                        i4 = (int) ((((long) u4.f23652b) + j4) - j5);
                        int i8 = u4.f23653c;
                        while (i4 < i8) {
                            byte b6 = bArr2[i4];
                            for (byte b7 : q4) {
                                if (b6 == b7) {
                                    i6 = u4.f23652b;
                                    return ((long) (i5 - i6)) + j5;
                                }
                            }
                            i4++;
                        }
                        j5 += (long) (u4.f23653c - u4.f23652b);
                        u4 = u4.f23656f;
                        m.b(u4);
                        j4 = j5;
                    }
                }
                return -1;
            }
            while (true) {
                long j7 = ((long) (u4.f23653c - u4.f23652b)) + j6;
                if (j7 > j4) {
                    break;
                }
                u4 = u4.f23656f;
                m.b(u4);
                j6 = j7;
            }
            if (hVar.G() == 2) {
                byte h6 = hVar.h(0);
                byte h7 = hVar.h(1);
                while (j5 < A()) {
                    byte[] bArr3 = u4.f23651a;
                    int i9 = (int) ((((long) u4.f23652b) + j4) - j5);
                    int i10 = u4.f23653c;
                    while (i5 < i10) {
                        byte b8 = bArr3[i5];
                        if (!(b8 == h6 || b8 == h7)) {
                            i9 = i5 + 1;
                        }
                    }
                    j6 = j5 + ((long) (u4.f23653c - u4.f23652b));
                    u4 = u4.f23656f;
                    m.b(u4);
                    j4 = j6;
                }
            } else {
                byte[] q5 = hVar.q();
                while (j5 < A()) {
                    byte[] bArr4 = u4.f23651a;
                    int i11 = (int) ((((long) u4.f23652b) + j4) - j5);
                    int i12 = u4.f23653c;
                    while (i4 < i12) {
                        byte b9 = bArr4[i4];
                        for (byte b10 : q5) {
                            if (b9 == b10) {
                                i6 = u4.f23652b;
                                return ((long) (i5 - i6)) + j5;
                            }
                        }
                        i11 = i4 + 1;
                    }
                    j6 = j5 + ((long) (u4.f23653c - u4.f23652b));
                    u4 = u4.f23656f;
                    m.b(u4);
                    j4 = j6;
                }
            }
            return -1;
            i6 = u4.f23652b;
            return ((long) (i5 - i6)) + j5;
        }
        throw new IllegalArgumentException(("fromIndex < 0: " + j4).toString());
    }

    public boolean r(long j4, C2517h hVar, int i4, int i5) {
        m.e(hVar, "bytes");
        if (j4 < 0 || i4 < 0 || i5 < 0 || A() - j4 < ((long) i5) || hVar.G() - i4 < i5) {
            return false;
        }
        for (int i6 = 0; i6 < i5; i6++) {
            if (n(((long) i6) + j4) != hVar.h(i4 + i6)) {
                return false;
            }
        }
        return true;
    }

    public int read(ByteBuffer byteBuffer) {
        m.e(byteBuffer, "sink");
        U u4 = this.f23694a;
        if (u4 == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), u4.f23653c - u4.f23652b);
        byteBuffer.put(u4.f23651a, u4.f23652b, min);
        int i4 = u4.f23652b + min;
        u4.f23652b = i4;
        this.f23695b -= (long) min;
        if (i4 == u4.f23653c) {
            this.f23694a = u4.b();
            V.b(u4);
        }
        return min;
    }

    public byte readByte() {
        if (A() != 0) {
            U u4 = this.f23694a;
            m.b(u4);
            int i4 = u4.f23652b;
            int i5 = u4.f23653c;
            int i6 = i4 + 1;
            byte b5 = u4.f23651a[i4];
            z(A() - 1);
            if (i6 == i5) {
                this.f23694a = u4.b();
                V.b(u4);
                return b5;
            }
            u4.f23652b = i6;
            return b5;
        }
        throw new EOFException();
    }

    public byte[] readByteArray() {
        return readByteArray(A());
    }

    public C2517h readByteString(long j4) {
        if (j4 < 0 || j4 > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + j4).toString());
        } else if (A() < j4) {
            throw new EOFException();
        } else if (j4 < 4096) {
            return new C2517h(readByteArray(j4));
        } else {
            C2517h E4 = E((int) j4);
            skip(j4);
            return E4;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ae, code lost:
        if (r2 == false) goto L_0x00b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00b0, code lost:
        r14 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00b2, code lost:
        r14 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b3, code lost:
        if (r1 >= r14) goto L_0x00ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00bb, code lost:
        if (A() == r17) goto L_0x00e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00bd, code lost:
        if (r2 == false) goto L_0x00c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00bf, code lost:
        r1 = "Expected a digit";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00c2, code lost:
        r1 = "Expected a digit or '-'";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00e7, code lost:
        throw new java.lang.NumberFormatException(r1 + " but was 0x" + N3.C2511b.h(n(r17)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00ed, code lost:
        throw new java.io.EOFException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00ee, code lost:
        if (r2 == false) goto L_0x00f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00f0, code lost:
        return r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00f2, code lost:
        return -r8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long readDecimalLong() {
        /*
            r19 = this;
            r0 = r19
            long r1 = r0.A()
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x00f3
            r1 = 0
            r5 = -7
            r8 = r3
            r6 = r5
            r2 = 0
            r5 = 0
        L_0x0013:
            N3.U r10 = r0.f23694a
            kotlin.jvm.internal.m.b(r10)
            byte[] r11 = r10.f23651a
            int r12 = r10.f23652b
            int r13 = r10.f23653c
        L_0x001e:
            if (r12 >= r13) goto L_0x008a
            byte r15 = r11[r12]
            r14 = 48
            if (r15 < r14) goto L_0x0075
            r14 = 57
            if (r15 > r14) goto L_0x0075
            int r14 = 48 - r15
            r16 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r18 = (r8 > r16 ? 1 : (r8 == r16 ? 0 : -1))
            if (r18 < 0) goto L_0x0048
            if (r18 != 0) goto L_0x003f
            r17 = r3
            long r3 = (long) r14
            int r16 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r16 >= 0) goto L_0x0041
            goto L_0x0048
        L_0x003f:
            r17 = r3
        L_0x0041:
            r3 = 10
            long r8 = r8 * r3
            long r3 = (long) r14
            long r8 = r8 + r3
            goto L_0x0081
        L_0x0048:
            N3.e r1 = new N3.e
            r1.<init>()
            N3.e r1 = r1.writeDecimalLong(r8)
            N3.e r1 = r1.writeByte(r15)
            if (r2 != 0) goto L_0x005a
            r1.readByte()
        L_0x005a:
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
        L_0x0075:
            r17 = r3
            r3 = 45
            if (r15 != r3) goto L_0x0088
            if (r1 != 0) goto L_0x0088
            r2 = 1
            long r6 = r6 - r2
            r2 = 1
        L_0x0081:
            int r12 = r12 + 1
            int r1 = r1 + 1
            r3 = r17
            goto L_0x001e
        L_0x0088:
            r5 = 1
            goto L_0x008c
        L_0x008a:
            r17 = r3
        L_0x008c:
            if (r12 != r13) goto L_0x0098
            N3.U r3 = r10.b()
            r0.f23694a = r3
            N3.V.b(r10)
            goto L_0x009a
        L_0x0098:
            r10.f23652b = r12
        L_0x009a:
            if (r5 != 0) goto L_0x00a5
            N3.U r3 = r0.f23694a
            if (r3 != 0) goto L_0x00a1
            goto L_0x00a5
        L_0x00a1:
            r3 = r17
            goto L_0x0013
        L_0x00a5:
            long r3 = r0.A()
            long r5 = (long) r1
            long r3 = r3 - r5
            r0.z(r3)
            if (r2 == 0) goto L_0x00b2
            r14 = 2
            goto L_0x00b3
        L_0x00b2:
            r14 = 1
        L_0x00b3:
            if (r1 >= r14) goto L_0x00ee
            long r3 = r0.A()
            int r1 = (r3 > r17 ? 1 : (r3 == r17 ? 0 : -1))
            if (r1 == 0) goto L_0x00e8
            if (r2 == 0) goto L_0x00c2
            java.lang.String r1 = "Expected a digit"
            goto L_0x00c4
        L_0x00c2:
            java.lang.String r1 = "Expected a digit or '-'"
        L_0x00c4:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            java.lang.String r1 = " but was 0x"
            r3.append(r1)
            r4 = r17
            byte r1 = r0.n(r4)
            java.lang.String r1 = N3.C2511b.h(r1)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L_0x00e8:
            java.io.EOFException r1 = new java.io.EOFException
            r1.<init>()
            throw r1
        L_0x00ee:
            if (r2 == 0) goto L_0x00f1
            return r8
        L_0x00f1:
            long r1 = -r8
            return r1
        L_0x00f3:
            java.io.EOFException r1 = new java.io.EOFException
            r1.<init>()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: N3.C2514e.readDecimalLong():long");
    }

    public void readFully(byte[] bArr) {
        m.e(bArr, "sink");
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

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0093, code lost:
        if (r8 != r9) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0095, code lost:
        r15.f23694a = r6.b();
        N3.V.b(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x009f, code lost:
        r6.f23652b = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a1, code lost:
        if (r1 != false) goto L_0x00a7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0078 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long readHexadecimalUnsignedLong() {
        /*
            r15 = this;
            long r0 = r15.A()
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x00b1
            r0 = 0
            r4 = r2
            r1 = 0
        L_0x000d:
            N3.U r6 = r15.f23694a
            kotlin.jvm.internal.m.b(r6)
            byte[] r7 = r6.f23651a
            int r8 = r6.f23652b
            int r9 = r6.f23653c
        L_0x0018:
            if (r8 >= r9) goto L_0x0093
            byte r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L_0x0027
            r11 = 57
            if (r10 > r11) goto L_0x0027
            int r11 = r10 + -48
            goto L_0x003c
        L_0x0027:
            r11 = 97
            if (r10 < r11) goto L_0x0032
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L_0x0032
            int r11 = r10 + -87
            goto L_0x003c
        L_0x0032:
            r11 = 65
            if (r10 < r11) goto L_0x0074
            r11 = 70
            if (r10 > r11) goto L_0x0074
            int r11 = r10 + -55
        L_0x003c:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L_0x004c
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L_0x0018
        L_0x004c:
            N3.e r0 = new N3.e
            r0.<init>()
            N3.e r0 = r0.writeHexadecimalUnsignedLong(r4)
            N3.e r0 = r0.writeByte(r10)
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
        L_0x0074:
            if (r0 == 0) goto L_0x0078
            r1 = 1
            goto L_0x0093
        L_0x0078:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = N3.C2511b.h(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0093:
            if (r8 != r9) goto L_0x009f
            N3.U r7 = r6.b()
            r15.f23694a = r7
            N3.V.b(r6)
            goto L_0x00a1
        L_0x009f:
            r6.f23652b = r8
        L_0x00a1:
            if (r1 != 0) goto L_0x00a7
            N3.U r6 = r15.f23694a
            if (r6 != 0) goto L_0x000d
        L_0x00a7:
            long r1 = r15.A()
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.z(r1)
            return r4
        L_0x00b1:
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: N3.C2514e.readHexadecimalUnsignedLong():long");
    }

    public int readInt() {
        if (A() >= 4) {
            U u4 = this.f23694a;
            m.b(u4);
            int i4 = u4.f23652b;
            int i5 = u4.f23653c;
            if (((long) (i5 - i4)) < 4) {
                return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
            }
            byte[] bArr = u4.f23651a;
            byte b5 = ((bArr[i4 + 1] & 255) << 16) | ((bArr[i4] & 255) << 24);
            int i6 = i4 + 3;
            int i7 = i4 + 4;
            byte b6 = (bArr[i6] & 255) | b5 | ((bArr[i4 + 2] & 255) << 8);
            z(A() - 4);
            if (i7 == i5) {
                this.f23694a = u4.b();
                V.b(u4);
                return b6;
            }
            u4.f23652b = i7;
            return b6;
        }
        throw new EOFException();
    }

    public int readIntLe() {
        return C2511b.e(readInt());
    }

    public long readLong() {
        if (A() >= 8) {
            U u4 = this.f23694a;
            m.b(u4);
            int i4 = u4.f23652b;
            int i5 = u4.f23653c;
            if (((long) (i5 - i4)) < 8) {
                return ((((long) readInt()) & 4294967295L) << 32) | (4294967295L & ((long) readInt()));
            }
            byte[] bArr = u4.f23651a;
            long j4 = ((((long) bArr[i4 + 3]) & 255) << 32) | ((((long) bArr[i4]) & 255) << 56) | ((((long) bArr[i4 + 1]) & 255) << 48) | ((((long) bArr[i4 + 2]) & 255) << 40);
            int i6 = i4 + 7;
            int i7 = i4 + 8;
            long j5 = j4 | ((((long) bArr[i4 + 4]) & 255) << 24) | ((((long) bArr[i4 + 5]) & 255) << 16) | ((((long) bArr[i4 + 6]) & 255) << 8) | (((long) bArr[i6]) & 255);
            z(A() - 8);
            if (i7 == i5) {
                this.f23694a = u4.b();
                V.b(u4);
                return j5;
            }
            u4.f23652b = i7;
            return j5;
        }
        throw new EOFException();
    }

    public long readLongLe() {
        return C2511b.f(readLong());
    }

    public short readShort() {
        if (A() >= 2) {
            U u4 = this.f23694a;
            m.b(u4);
            int i4 = u4.f23652b;
            int i5 = u4.f23653c;
            if (i5 - i4 < 2) {
                return (short) (((readByte() & 255) << 8) | (readByte() & 255));
            }
            byte[] bArr = u4.f23651a;
            int i6 = i4 + 1;
            int i7 = i4 + 2;
            byte b5 = (bArr[i6] & 255) | ((bArr[i4] & 255) << 8);
            z(A() - 2);
            if (i7 == i5) {
                this.f23694a = u4.b();
                V.b(u4);
            } else {
                u4.f23652b = i7;
            }
            return (short) b5;
        }
        throw new EOFException();
    }

    public short readShortLe() {
        return C2511b.g(readShort());
    }

    public String readString(long j4, Charset charset) {
        m.e(charset, "charset");
        int i4 = (j4 > 0 ? 1 : (j4 == 0 ? 0 : -1));
        if (i4 < 0 || j4 > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + j4).toString());
        } else if (this.f23695b < j4) {
            throw new EOFException();
        } else if (i4 == 0) {
            return "";
        } else {
            U u4 = this.f23694a;
            m.b(u4);
            int i5 = u4.f23652b;
            if (((long) i5) + j4 > ((long) u4.f23653c)) {
                return new String(readByteArray(j4), charset);
            }
            int i6 = (int) j4;
            String str = new String(u4.f23651a, i5, i6, charset);
            int i7 = u4.f23652b + i6;
            u4.f23652b = i7;
            this.f23695b -= j4;
            if (i7 == u4.f23653c) {
                this.f23694a = u4.b();
                V.b(u4);
            }
            return str;
        }
    }

    public String readUtf8() {
        return readString(this.f23695b, d.f21160b);
    }

    public String readUtf8LineStrict() {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    public void require(long j4) {
        if (this.f23695b < j4) {
            throw new EOFException();
        }
    }

    public boolean s(long j4, C2517h hVar) {
        m.e(hVar, "bytes");
        return r(j4, hVar, 0, hVar.G());
    }

    public void skip(long j4) {
        while (j4 > 0) {
            U u4 = this.f23694a;
            if (u4 != null) {
                int min = (int) Math.min(j4, (long) (u4.f23653c - u4.f23652b));
                long j5 = (long) min;
                z(A() - j5);
                j4 -= j5;
                int i4 = u4.f23652b + min;
                u4.f23652b = i4;
                if (i4 == u4.f23653c) {
                    this.f23694a = u4.b();
                    V.b(u4);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    public a0 timeout() {
        return a0.f23669e;
    }

    public String toString() {
        return D().toString();
    }

    public C2517h x() {
        return readByteString(A());
    }

    public final void z(long j4) {
        this.f23695b = j4;
    }

    /* renamed from: N3.e$b */
    public static final class b extends InputStream implements AutoCloseable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2514e f23702a;

        b(C2514e eVar) {
            this.f23702a = eVar;
        }

        public int available() {
            return (int) Math.min(this.f23702a.A(), (long) Integer.MAX_VALUE);
        }

        public int read() {
            if (this.f23702a.A() > 0) {
                return this.f23702a.readByte() & 255;
            }
            return -1;
        }

        public String toString() {
            return this.f23702a + ".inputStream()";
        }

        public int read(byte[] bArr, int i4, int i5) {
            m.e(bArr, "sink");
            return this.f23702a.read(bArr, i4, i5);
        }

        public void close() {
        }
    }

    public byte[] readByteArray(long j4) {
        if (j4 < 0 || j4 > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + j4).toString());
        } else if (A() >= j4) {
            byte[] bArr = new byte[((int) j4)];
            readFully(bArr);
            return bArr;
        } else {
            throw new EOFException();
        }
    }

    public String readUtf8(long j4) {
        return readString(j4, d.f21160b);
    }

    public String readUtf8LineStrict(long j4) {
        if (j4 >= 0) {
            long j5 = Long.MAX_VALUE;
            if (j4 != Long.MAX_VALUE) {
                j5 = j4 + 1;
            }
            long j6 = j5;
            long indexOf = indexOf((byte) 10, 0, j6);
            if (indexOf != -1) {
                return C2535a.b(this, indexOf);
            }
            if (j6 < A() && n(j6 - 1) == 13 && n(j6) == 10) {
                return C2535a.b(this, j6);
            }
            C2514e eVar = new C2514e();
            k(eVar, 0, Math.min((long) 32, A()));
            throw new EOFException("\\n not found: limit=" + Math.min(A(), j4) + " content=" + eVar.x().m() + 8230);
        }
        throw new IllegalArgumentException(("limit < 0: " + j4).toString());
    }

    public int write(ByteBuffer byteBuffer) {
        m.e(byteBuffer, "source");
        int remaining = byteBuffer.remaining();
        int i4 = remaining;
        while (i4 > 0) {
            U F4 = F(1);
            int min = Math.min(i4, 8192 - F4.f23653c);
            byteBuffer.get(F4.f23651a, F4.f23653c, min);
            i4 -= min;
            F4.f23653c += min;
        }
        this.f23695b += (long) remaining;
        return remaining;
    }

    public int read(byte[] bArr, int i4, int i5) {
        m.e(bArr, "sink");
        C2511b.b((long) bArr.length, (long) i4, (long) i5);
        U u4 = this.f23694a;
        if (u4 == null) {
            return -1;
        }
        int min = Math.min(i5, u4.f23653c - u4.f23652b);
        byte[] bArr2 = u4.f23651a;
        int i6 = u4.f23652b;
        C1594h.d(bArr2, bArr, i4, i6, i6 + min);
        u4.f23652b += min;
        z(A() - ((long) min));
        if (u4.f23652b == u4.f23653c) {
            this.f23694a = u4.b();
            V.b(u4);
        }
        return min;
    }

    public C2514e buffer() {
        return this;
    }

    public void close() {
    }

    public void flush() {
    }

    public C2514e h() {
        return this;
    }

    /* renamed from: l */
    public C2514e emitCompleteSegments() {
        return this;
    }
}
