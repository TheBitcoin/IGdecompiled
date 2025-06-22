package com.mbridge.msdk.foundation.tools;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import java.nio.charset.StandardCharsets;

public final class q {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f13680a;

    /* renamed from: b  reason: collision with root package name */
    public int f13681b;

    /* renamed from: c  reason: collision with root package name */
    private char[] f13682c;

    public q(int i4) {
        this(new byte[i4], 0);
    }

    public static int a(String str) {
        int length = str.length();
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            int i6 = i4 + 1;
            char charAt = str.charAt(i4);
            if (charAt < 128) {
                i5++;
            } else if (charAt < 2048) {
                i5 += 2;
            } else if (charAt < 55296 || charAt > 57343) {
                i5 += 3;
            } else {
                i4 += 2;
                i5 += 4;
            }
            i4 = i6;
        }
        return i5;
    }

    private long c(int i4) {
        byte[] bArr = this.f13680a;
        long j4 = (((long) bArr[i4]) & 255) | ((((long) bArr[i4 + 1]) & 255) << 8) | ((((long) bArr[i4 + 2]) & 255) << 16) | ((((long) bArr[i4 + 3]) & 255) << 24) | ((((long) bArr[i4 + 4]) & 255) << 32);
        int i5 = i4 + 6;
        return (((long) bArr[i4 + 7]) << 56) | j4 | ((((long) bArr[i4 + 5]) & 255) << 40) | ((255 & ((long) bArr[i5])) << 48);
    }

    public final long b() {
        long c5 = c(this.f13681b);
        this.f13681b += 8;
        return c5;
    }

    public final short d() {
        byte[] bArr = this.f13680a;
        int i4 = this.f13681b;
        int i5 = i4 + 1;
        this.f13681b = i5;
        this.f13681b = i4 + 2;
        return (short) ((bArr[i5] << 8) | (bArr[i4] & 255));
    }

    public q(byte[] bArr, int i4) {
        this.f13682c = null;
        this.f13680a = bArr;
        this.f13681b = i4;
    }

    public final int c() {
        byte[] bArr = this.f13680a;
        int i4 = this.f13681b;
        int i5 = i4 + 1;
        this.f13681b = i5;
        int i6 = i4 + 2;
        this.f13681b = i6;
        byte b5 = ((bArr[i5] & 255) << 8) | (bArr[i4] & 255);
        int i7 = i4 + 3;
        this.f13681b = i7;
        this.f13681b = i4 + 4;
        return (bArr[i7] << 24) | b5 | ((bArr[i6] & 255) << 16);
    }

    public final byte a() {
        byte[] bArr = this.f13680a;
        int i4 = this.f13681b;
        this.f13681b = i4 + 1;
        return bArr[i4];
    }

    public final void b(int i4) {
        byte[] bArr = this.f13680a;
        int i5 = this.f13681b;
        int i6 = i5 + 1;
        this.f13681b = i6;
        bArr[i5] = (byte) i4;
        int i7 = i5 + 2;
        this.f13681b = i7;
        bArr[i6] = (byte) (i4 >> 8);
        int i8 = i5 + 3;
        this.f13681b = i8;
        bArr[i7] = (byte) (i4 >> 16);
        this.f13681b = i5 + 4;
        bArr[i8] = (byte) (i4 >> 24);
    }

    /* access modifiers changed from: package-private */
    public final long a(int i4, int i5) {
        long j4 = 0;
        if (i5 <= 0) {
            return 0;
        }
        int i6 = i5 >> 3;
        int i7 = i5 & 7;
        int i8 = 0;
        int i9 = i4;
        for (int i10 = 0; i10 < i6; i10++) {
            j4 ^= c(i9);
            i9 += 8;
        }
        int i11 = i7 << 3;
        while (i8 < i11) {
            j4 ^= (((long) this.f13680a[i9]) & 255) << i8;
            i8 += 8;
            i9++;
        }
        int i12 = (i4 & 7) << 3;
        return (j4 >>> (64 - i12)) | (j4 << i12);
    }

    public q(byte[] bArr) {
        this(bArr, 0);
    }

    public final String a(int i4) {
        String str;
        if (i4 < 0) {
            return null;
        }
        if (i4 == 0) {
            return "";
        }
        if (i4 > 2048) {
            str = new String(this.f13680a, this.f13681b, i4, StandardCharsets.UTF_8);
        } else {
            char[] cArr = this.f13682c;
            if (cArr == null) {
                if (i4 <= 256) {
                    this.f13682c = new char[256];
                } else {
                    this.f13682c = new char[2048];
                }
            } else if (cArr.length < i4) {
                this.f13682c = new char[2048];
            }
            char[] cArr2 = this.f13682c;
            byte[] bArr = this.f13680a;
            int i5 = this.f13681b;
            int i6 = i5 + i4;
            int i7 = 0;
            while (i5 < i6) {
                int i8 = i5 + 1;
                byte b5 = bArr[i5];
                if (b5 > 0) {
                    cArr2[i7] = (char) b5;
                    i7++;
                    i5 = i8;
                } else if (b5 < -32) {
                    i5 += 2;
                    cArr2[i7] = (char) ((bArr[i8] & 63) | ((b5 & 31) << 6));
                    i7++;
                } else if (b5 < -16) {
                    int i9 = i5 + 2;
                    i5 += 3;
                    cArr2[i7] = (char) (((bArr[i8] & 63) << 6) | ((b5 & 15) << 12) | (bArr[i9] & 63));
                    i7++;
                } else {
                    byte b6 = bArr[i8];
                    int i10 = i5 + 3;
                    byte b7 = bArr[i5 + 2];
                    i5 += 4;
                    byte b8 = ((b6 & 63) << 12) | ((b5 & 7) << 18) | ((b7 & 63) << 6) | (bArr[i10] & 63);
                    int i11 = i7 + 1;
                    cArr2[i7] = (char) ((b8 >>> 10) + 55232);
                    i7 += 2;
                    cArr2[i11] = (char) ((b8 & 1023) + 56320);
                }
            }
            if (i5 <= i6) {
                str = new String(cArr2, 0, i7);
            } else {
                throw new IllegalArgumentException("Invalid String");
            }
        }
        this.f13681b += i4;
        return str;
    }

    public final void b(int i4, int i5) {
        byte[] bArr = this.f13680a;
        bArr[i4] = (byte) i5;
        bArr[i4 + 1] = (byte) (i5 >> 8);
        bArr[i4 + 2] = (byte) (i5 >> 16);
        bArr[i4 + 3] = (byte) (i5 >> 24);
    }

    public final void b(String str) {
        if (str != null && !str.isEmpty()) {
            byte[] bArr = this.f13680a;
            int i4 = this.f13681b;
            int length = str.length();
            int i5 = 0;
            while (i5 < length) {
                int i6 = i5 + 1;
                char charAt = str.charAt(i5);
                if (charAt < 128) {
                    bArr[i4] = (byte) charAt;
                    i4++;
                } else if (charAt < 2048) {
                    int i7 = i4 + 1;
                    bArr[i4] = (byte) ((charAt >>> 6) | PsExtractor.AUDIO_STREAM);
                    i4 += 2;
                    bArr[i7] = (byte) ((charAt & '?') | 128);
                } else if (charAt < 55296 || charAt > 57343) {
                    bArr[i4] = (byte) ((charAt >>> 12) | 224);
                    int i8 = i4 + 2;
                    bArr[i4 + 1] = (byte) (((charAt >>> 6) & 63) | 128);
                    i4 += 3;
                    bArr[i8] = (byte) ((charAt & '?') | 128);
                } else {
                    i5 += 2;
                    int charAt2 = ((charAt << 10) + str.charAt(i6)) - 56613888;
                    bArr[i4] = (byte) ((charAt2 >>> 18) | PsExtractor.VIDEO_STREAM_MASK);
                    bArr[i4 + 1] = (byte) (((charAt2 >>> 12) & 63) | 128);
                    int i9 = i4 + 3;
                    bArr[i4 + 2] = (byte) (((charAt2 >>> 6) & 63) | 128);
                    i4 += 4;
                    bArr[i9] = (byte) ((charAt2 & 63) | 128);
                }
                i5 = i6;
            }
            this.f13681b = i4;
        }
    }

    public final void a(byte b5) {
        byte[] bArr = this.f13680a;
        int i4 = this.f13681b;
        this.f13681b = i4 + 1;
        bArr[i4] = b5;
    }

    public final void a(byte[] bArr) {
        int length = bArr.length;
        if (length > 0) {
            System.arraycopy(bArr, 0, this.f13680a, this.f13681b, length);
            this.f13681b += length;
        }
    }

    public final void a(long j4) {
        a(this.f13681b, j4);
        this.f13681b += 8;
    }

    public final void a(int i4, long j4) {
        byte[] bArr = this.f13680a;
        bArr[i4] = (byte) ((int) j4);
        bArr[i4 + 1] = (byte) ((int) (j4 >> 8));
        bArr[i4 + 2] = (byte) ((int) (j4 >> 16));
        bArr[i4 + 3] = (byte) ((int) (j4 >> 24));
        bArr[i4 + 4] = (byte) ((int) (j4 >> 32));
        bArr[i4 + 5] = (byte) ((int) (j4 >> 40));
        bArr[i4 + 6] = (byte) ((int) (j4 >> 48));
        bArr[i4 + 7] = (byte) ((int) (j4 >> 56));
    }

    public final void a(short s4) {
        byte[] bArr = this.f13680a;
        int i4 = this.f13681b;
        int i5 = i4 + 1;
        this.f13681b = i5;
        bArr[i4] = (byte) s4;
        this.f13681b = i4 + 2;
        bArr[i5] = (byte) (s4 >> 8);
    }
}
