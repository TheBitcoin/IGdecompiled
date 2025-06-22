package com.mbridge.msdk.foundation.tools;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import java.util.HashMap;
import java.util.Map;

public final class ag {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f13562a;

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f13563b = new byte[128];

    /* renamed from: c  reason: collision with root package name */
    private static Map<Character, Character> f13564c;

    /* renamed from: d  reason: collision with root package name */
    private static char[] f13565d;

    static {
        char[] cArr = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
        f13562a = cArr;
        HashMap hashMap = new HashMap();
        f13564c = hashMap;
        hashMap.put('A', 'v');
        f13564c.put('B', 'S');
        f13564c.put('C', 'o');
        f13564c.put('D', 'a');
        f13564c.put('E', 'j');
        f13564c.put('F', 'c');
        f13564c.put('G', '7');
        f13564c.put('H', 'd');
        f13564c.put('I', 'R');
        f13564c.put('J', 'z');
        f13564c.put('K', 'p');
        f13564c.put('L', 'W');
        f13564c.put('M', 'i');
        f13564c.put('N', 'f');
        f13564c.put('O', 'G');
        f13564c.put('P', 'y');
        f13564c.put('Q', 'N');
        f13564c.put('R', 'x');
        f13564c.put('S', 'Z');
        f13564c.put('T', 'n');
        f13564c.put('U', 'V');
        f13564c.put('V', '5');
        f13564c.put('W', 'k');
        f13564c.put('X', '+');
        f13564c.put('Y', 'D');
        f13564c.put('Z', 'H');
        f13564c.put('a', 'L');
        f13564c.put('b', 'Y');
        f13564c.put('c', 'h');
        f13564c.put('d', 'J');
        f13564c.put('e', '4');
        f13564c.put('f', '6');
        f13564c.put('g', 'l');
        f13564c.put('h', 't');
        f13564c.put('i', '0');
        f13564c.put('j', 'U');
        f13564c.put('k', '3');
        f13564c.put('l', 'Q');
        f13564c.put('m', 'r');
        f13564c.put('n', 'g');
        f13564c.put('o', 'E');
        f13564c.put('p', 'u');
        f13564c.put('q', 'q');
        f13564c.put('r', '8');
        f13564c.put('s', 's');
        f13564c.put('t', 'w');
        f13564c.put('u', '/');
        f13564c.put('v', 'X');
        f13564c.put('w', 'M');
        f13564c.put('x', 'e');
        f13564c.put('y', 'B');
        f13564c.put('z', 'A');
        f13564c.put('0', 'T');
        f13564c.put('1', '2');
        f13564c.put('2', 'F');
        f13564c.put('3', 'b');
        f13564c.put('4', '9');
        f13564c.put('5', 'P');
        f13564c.put('6', '1');
        f13564c.put(55, 'O');
        f13564c.put('8', 'I');
        f13564c.put('9', 'K');
        f13564c.put('+', 'm');
        f13564c.put('/', 67);
        f13565d = new char[cArr.length];
        int i4 = 0;
        int i5 = 0;
        while (true) {
            char[] cArr2 = f13562a;
            if (i5 >= cArr2.length) {
                break;
            }
            f13565d[i5] = f13564c.get(Character.valueOf(cArr2[i5])).charValue();
            i5++;
        }
        int i6 = 0;
        while (true) {
            byte[] bArr = f13563b;
            if (i6 >= bArr.length) {
                break;
            }
            bArr[i6] = Byte.MAX_VALUE;
            i6++;
        }
        while (true) {
            char[] cArr3 = f13565d;
            if (i4 < cArr3.length) {
                f13563b[cArr3[i4]] = (byte) i4;
                i4++;
            } else {
                return;
            }
        }
    }

    private static int a(char[] cArr, byte[] bArr, int i4) {
        try {
            char c5 = cArr[3];
            char c6 = c5 == '=' ? (char) 2 : 3;
            char c7 = cArr[2];
            if (c7 == '=') {
                c6 = 1;
            }
            byte[] bArr2 = f13563b;
            byte b5 = bArr2[cArr[0]];
            byte b6 = bArr2[cArr[1]];
            byte b7 = bArr2[c7];
            byte b8 = bArr2[c5];
            if (c6 == 1) {
                bArr[i4] = (byte) (((b6 >> 4) & 3) | ((b5 << 2) & 252));
                return 1;
            } else if (c6 == 2) {
                bArr[i4] = (byte) ((3 & (b6 >> 4)) | ((b5 << 2) & 252));
                bArr[i4 + 1] = (byte) (((b6 << 4) & PsExtractor.VIDEO_STREAM_MASK) | ((b7 >> 2) & 15));
                return 2;
            } else if (c6 == 3) {
                bArr[i4] = (byte) (((b5 << 2) & 252) | ((b6 >> 4) & 3));
                bArr[i4 + 1] = (byte) (((b6 << 4) & PsExtractor.VIDEO_STREAM_MASK) | ((b7 >> 2) & 15));
                bArr[i4 + 2] = (byte) (((b7 << 6) & 192) | (b8 & 63));
                return 3;
            } else {
                throw new RuntimeException("Internal Error");
            }
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String b(String str) {
        byte[] bytes = str.getBytes();
        return a(bytes, 0, bytes.length);
    }

    private static byte[] c(String str) {
        int i4;
        try {
            int length = str.length();
            int i5 = 259;
            if (length < 259) {
                i5 = length;
            }
            char[] cArr = new char[i5];
            int i6 = ((length >> 2) * 3) + 3;
            byte[] bArr = new byte[i6];
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            while (i7 < length) {
                int i10 = i7 + 256;
                if (i10 <= length) {
                    str.getChars(i7, i10, cArr, i9);
                    i4 = i9 + 256;
                } else {
                    str.getChars(i7, length, cArr, i9);
                    i4 = (length - i7) + i9;
                }
                int i11 = i9;
                while (i9 < i4) {
                    char c5 = cArr[i9];
                    if (c5 != '=') {
                        byte[] bArr2 = f13563b;
                        if (c5 < bArr2.length) {
                            if (bArr2[c5] == Byte.MAX_VALUE) {
                            }
                        }
                        i9++;
                    }
                    int i12 = i11 + 1;
                    cArr[i11] = c5;
                    if (i12 == 4) {
                        i8 += a(cArr, bArr, i8);
                        i11 = 0;
                    } else {
                        i11 = i12;
                    }
                    i9++;
                }
                i7 = i10;
                i9 = i11;
            }
            if (i8 == i6) {
                return bArr;
            }
            byte[] bArr3 = new byte[i8];
            System.arraycopy(bArr, 0, bArr3, 0, i8);
            return bArr3;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a(String str) {
        byte[] c5 = c(str);
        if (c5 == null || c5.length <= 0) {
            return null;
        }
        return new String(c5);
    }

    private static String a(byte[] bArr, int i4, int i5) {
        if (i5 <= 0) {
            return "";
        }
        try {
            char[] cArr = new char[(((i5 / 3) << 2) + 4)];
            int i6 = 0;
            while (i5 >= 3) {
                int i7 = ((bArr[i4] & 255) << 16) + ((bArr[i4 + 1] & 255) << 8) + (bArr[i4 + 2] & 255);
                char[] cArr2 = f13565d;
                cArr[i6] = cArr2[i7 >> 18];
                cArr[i6 + 1] = cArr2[(i7 >> 12) & 63];
                int i8 = i6 + 3;
                cArr[i6 + 2] = cArr2[(i7 >> 6) & 63];
                i6 += 4;
                cArr[i8] = cArr2[i7 & 63];
                i4 += 3;
                i5 -= 3;
            }
            if (i5 == 1) {
                byte b5 = bArr[i4] & 255;
                char[] cArr3 = f13565d;
                cArr[i6] = cArr3[b5 >> 2];
                cArr[i6 + 1] = cArr3[(b5 << 4) & 63];
                int i9 = i6 + 3;
                cArr[i6 + 2] = '=';
                i6 += 4;
                cArr[i9] = '=';
            } else if (i5 == 2) {
                int i10 = ((bArr[i4] & 255) << 8) + (bArr[i4 + 1] & 255);
                char[] cArr4 = f13565d;
                cArr[i6] = cArr4[i10 >> 10];
                cArr[i6 + 1] = cArr4[(i10 >> 4) & 63];
                int i11 = i6 + 3;
                cArr[i6 + 2] = cArr4[(i10 << 2) & 63];
                i6 += 4;
                cArr[i11] = '=';
            }
            return new String(cArr, 0, i6);
        } catch (Exception unused) {
            return null;
        }
    }
}
