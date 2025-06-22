package com.mbridge.msdk.foundation.tools;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public final class y {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f13696a;

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f13697b;

    static {
        char[] charArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        f13696a = charArray;
        int[] iArr = new int[256];
        f13697b = iArr;
        Arrays.fill(iArr, -1);
        int length = charArray.length;
        for (int i4 = 0; i4 < length; i4++) {
            f13697b[f13696a[i4]] = i4;
        }
        f13697b[61] = 0;
    }

    public static String a(String str) {
        byte[] bArr;
        int i4;
        int i5;
        int i6;
        int i7;
        String str2 = str;
        int length = str2.length();
        if (length == 0) {
            bArr = new byte[0];
        } else {
            int i8 = length - 1;
            int i9 = 0;
            while (i4 < i8 && f13697b[str2.charAt(i4) & 255] < 0) {
                i9 = i4 + 1;
            }
            while (i8 > 0 && f13697b[str2.charAt(i8) & 255] < 0) {
                i8--;
            }
            if (str2.charAt(i8) != '=') {
                i5 = 0;
            } else if (str2.charAt(i8 - 1) == '=') {
                i5 = 2;
            } else {
                i5 = 1;
            }
            int i10 = (i8 - i4) + 1;
            if (length > 76) {
                if (str2.charAt(76) == 13) {
                    i7 = i10 / 78;
                } else {
                    i7 = 0;
                }
                i6 = i7 << 1;
            } else {
                i6 = 0;
            }
            int i11 = (((i10 - i6) * 6) >> 3) - i5;
            byte[] bArr2 = new byte[i11];
            int i12 = (i11 / 3) * 3;
            int i13 = 0;
            int i14 = 0;
            while (i13 < i12) {
                int[] iArr = f13697b;
                int i15 = i4 + 4;
                int i16 = iArr[str2.charAt(i4 + 3)] | (iArr[str2.charAt(i4 + 1)] << 12) | (iArr[str2.charAt(i4)] << 18) | (iArr[str2.charAt(i4 + 2)] << 6);
                bArr2[i13] = (byte) (i16 >> 16);
                int i17 = i13 + 2;
                bArr2[i13 + 1] = (byte) (i16 >> 8);
                i13 += 3;
                bArr2[i17] = (byte) i16;
                if (i6 <= 0 || (i14 = i14 + 1) != 19) {
                    i4 = i15;
                } else {
                    i4 += 6;
                    i14 = 0;
                }
            }
            if (i13 < i11) {
                int i18 = 0;
                int i19 = 0;
                while (i4 <= i8 - i5) {
                    i18 |= f13697b[str2.charAt(i4)] << (18 - (i19 * 6));
                    i19++;
                    i4++;
                }
                int i20 = 16;
                while (i13 < i11) {
                    bArr2[i13] = (byte) (i18 >> i20);
                    i20 -= 8;
                    i13++;
                }
            }
            bArr = bArr2;
        }
        if (bArr.length == 0) {
            return "";
        }
        return new String(bArr, StandardCharsets.UTF_8);
    }
}
