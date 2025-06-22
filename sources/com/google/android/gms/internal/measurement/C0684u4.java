package com.google.android.gms.internal.measurement;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* renamed from: com.google.android.gms.internal.measurement.u4  reason: case insensitive filesystem */
public abstract class C0684u4 {

    /* renamed from: a  reason: collision with root package name */
    static final Charset f2196a = Charset.forName(C.UTF8_NAME);

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f2197b;

    static {
        Charset.forName(C.ASCII_NAME);
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        f2197b = bArr;
        ByteBuffer.wrap(bArr);
        W3.c(bArr, 0, bArr.length, false);
    }

    static int a(int i4, byte[] bArr, int i5, int i6) {
        for (int i7 = i5; i7 < i5 + i6; i7++) {
            i4 = (i4 * 31) + bArr[i7];
        }
        return i4;
    }

    public static int b(long j4) {
        return (int) (j4 ^ (j4 >>> 32));
    }

    public static int c(boolean z4) {
        return z4 ? 1231 : 1237;
    }

    public static int d(byte[] bArr) {
        int length = bArr.length;
        int a5 = a(length, bArr, 0, length);
        if (a5 == 0) {
            return 1;
        }
        return a5;
    }

    static Object e(Object obj) {
        obj.getClass();
        return obj;
    }

    static Object f(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }

    static boolean g(Z4 z4) {
        return false;
    }
}
