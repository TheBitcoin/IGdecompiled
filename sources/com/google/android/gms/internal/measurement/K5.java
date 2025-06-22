package com.google.android.gms.internal.measurement;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;

final class K5 extends L5 {
    K5() {
    }

    /* access modifiers changed from: package-private */
    public final int a(int i4, byte[] bArr, int i5, int i6) {
        while (r10 < i6 && bArr[r10] >= 0) {
            i5 = r10 + 1;
        }
        if (r10 >= i6) {
            return 0;
        }
        while (r10 < i6) {
            int i7 = r10 + 1;
            byte b5 = bArr[r10];
            if (b5 >= 0) {
                r10 = i7;
            } else if (b5 < -32) {
                if (i7 >= i6) {
                    return b5;
                }
                if (b5 >= -62) {
                    r10 += 2;
                    if (bArr[i7] > -65) {
                    }
                }
                return -1;
            } else if (b5 < -16) {
                if (i7 >= i6 - 1) {
                    return J5.c(bArr, i7, i6);
                }
                int i8 = r10 + 2;
                byte b6 = bArr[i7];
                if (b6 <= -65 && ((b5 != -32 || b6 >= -96) && (b5 != -19 || b6 < -96))) {
                    r10 += 3;
                    if (bArr[i8] > -65) {
                    }
                }
                return -1;
            } else if (i7 >= i6 - 2) {
                return J5.c(bArr, i7, i6);
            } else {
                int i9 = r10 + 2;
                byte b7 = bArr[i7];
                if (b7 <= -65 && (((b5 << 28) + (b7 + 112)) >> 30) == 0) {
                    int i10 = r10 + 3;
                    if (bArr[i9] <= -65) {
                        r10 += 4;
                        if (bArr[i10] > -65) {
                        }
                    }
                }
                return -1;
            }
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final int b(String str, byte[] bArr, int i4, int i5) {
        int i6;
        int i7;
        char charAt;
        int length = str.length();
        int i8 = i5 + i4;
        int i9 = 0;
        while (i9 < length && (i7 = i9 + i4) < i8 && (charAt = str.charAt(i9)) < 128) {
            bArr[i7] = (byte) charAt;
            i9++;
        }
        if (i9 == length) {
            return i4 + length;
        }
        int i10 = i4 + i9;
        while (i9 < length) {
            char charAt2 = str.charAt(i9);
            if (charAt2 < 128 && i10 < i8) {
                bArr[i10] = (byte) charAt2;
                i10++;
            } else if (charAt2 < 2048 && i10 <= i8 - 2) {
                int i11 = i10 + 1;
                bArr[i10] = (byte) ((charAt2 >>> 6) | 960);
                i10 += 2;
                bArr[i11] = (byte) ((charAt2 & '?') | 128);
            } else if ((charAt2 < 55296 || 57343 < charAt2) && i10 <= i8 - 3) {
                bArr[i10] = (byte) ((charAt2 >>> 12) | 480);
                int i12 = i10 + 2;
                bArr[i10 + 1] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i10 += 3;
                bArr[i12] = (byte) ((charAt2 & '?') | 128);
            } else if (i10 <= i8 - 4) {
                int i13 = i9 + 1;
                if (i13 != str.length()) {
                    char charAt3 = str.charAt(i13);
                    if (Character.isSurrogatePair(charAt2, charAt3)) {
                        int codePoint = Character.toCodePoint(charAt2, charAt3);
                        bArr[i10] = (byte) ((codePoint >>> 18) | PsExtractor.VIDEO_STREAM_MASK);
                        bArr[i10 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                        int i14 = i10 + 3;
                        bArr[i10 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                        i10 += 4;
                        bArr[i14] = (byte) ((codePoint & 63) | 128);
                        i9 = i13;
                    } else {
                        i9 = i13;
                    }
                }
                throw new N5(i9 - 1, length);
            } else if (55296 > charAt2 || charAt2 > 57343 || ((i6 = i9 + 1) != str.length() && Character.isSurrogatePair(charAt2, str.charAt(i6)))) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i10);
            } else {
                throw new N5(i9, length);
            }
            i9++;
        }
        return i10;
    }

    /* access modifiers changed from: package-private */
    public final String c(byte[] bArr, int i4, int i5) {
        if ((i4 | i5 | ((bArr.length - i4) - i5)) >= 0) {
            int i6 = i4 + i5;
            char[] cArr = new char[i5];
            int i7 = 0;
            while (r13 < i6) {
                byte b5 = bArr[r13];
                if (b5 < 0) {
                    break;
                }
                i4 = r13 + 1;
                I5.d(b5, cArr, i7);
                i7++;
            }
            int i8 = i7;
            while (r13 < i6) {
                int i9 = r13 + 1;
                byte b6 = bArr[r13];
                if (b6 >= 0) {
                    int i10 = i8 + 1;
                    I5.d(b6, cArr, i8);
                    while (i9 < i6) {
                        byte b7 = bArr[i9];
                        if (b7 < 0) {
                            break;
                        }
                        i9++;
                        I5.d(b7, cArr, i10);
                        i10++;
                    }
                    i8 = i10;
                    r13 = i9;
                } else if (b6 < -32) {
                    if (i9 < i6) {
                        r13 += 2;
                        I5.c(b6, bArr[i9], cArr, i8);
                        i8++;
                    } else {
                        throw B4.c();
                    }
                } else if (b6 < -16) {
                    if (i9 < i6 - 1) {
                        int i11 = r13 + 2;
                        r13 += 3;
                        I5.b(b6, bArr[i9], bArr[i11], cArr, i8);
                        i8++;
                    } else {
                        throw B4.c();
                    }
                } else if (i9 < i6 - 2) {
                    byte b8 = bArr[i9];
                    int i12 = r13 + 3;
                    byte b9 = bArr[r13 + 2];
                    r13 += 4;
                    byte b10 = bArr[i12];
                    I5.a(b6, b8, b9, b10, cArr, i8);
                    i8 += 2;
                } else {
                    throw B4.c();
                }
            }
            return new String(cArr, 0, i8);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i4), Integer.valueOf(i5)}));
    }
}
