package com.google.android.gms.internal.measurement;

abstract class I5 {
    static /* synthetic */ void a(byte b5, byte b6, byte b7, byte b8, char[] cArr, int i4) {
        if (e(b6) || (((b5 << 28) + (b6 + 112)) >> 30) != 0 || e(b7) || e(b8)) {
            throw B4.c();
        }
        byte b9 = ((b5 & 7) << 18) | ((b6 & 63) << 12) | ((b7 & 63) << 6) | (b8 & 63);
        cArr[i4] = (char) ((b9 >>> 10) + 55232);
        cArr[i4 + 1] = (char) ((b9 & 1023) + 56320);
    }

    static /* synthetic */ void b(byte b5, byte b6, byte b7, char[] cArr, int i4) {
        if (e(b6) || ((b5 == -32 && b6 < -96) || ((b5 == -19 && b6 >= -96) || e(b7)))) {
            throw B4.c();
        }
        cArr[i4] = (char) (((b5 & 15) << 12) | ((b6 & 63) << 6) | (b7 & 63));
    }

    static /* synthetic */ void c(byte b5, byte b6, char[] cArr, int i4) {
        if (b5 < -62 || e(b6)) {
            throw B4.c();
        }
        cArr[i4] = (char) (((b5 & 31) << 6) | (b6 & 63));
    }

    static /* synthetic */ void d(byte b5, char[] cArr, int i4) {
        cArr[i4] = (char) b5;
    }

    private static boolean e(byte b5) {
        return b5 > -65;
    }
}
