package N3;

import N3.C2514e;
import O3.C2536b;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.jvm.internal.m;

/* renamed from: N3.b  reason: case insensitive filesystem */
public abstract class C2511b {

    /* renamed from: a  reason: collision with root package name */
    private static final C2514e.a f23673a = new C2514e.a();

    /* renamed from: b  reason: collision with root package name */
    private static final int f23674b = -1234567890;

    public static final boolean a(byte[] bArr, int i4, byte[] bArr2, int i5, int i6) {
        m.e(bArr, "a");
        m.e(bArr2, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B);
        for (int i7 = 0; i7 < i6; i7++) {
            if (bArr[i7 + i4] != bArr2[i7 + i5]) {
                return false;
            }
        }
        return true;
    }

    public static final void b(long j4, long j5, long j6) {
        if ((j5 | j6) < 0 || j5 > j4 || j4 - j5 < j6) {
            throw new ArrayIndexOutOfBoundsException("size=" + j4 + " offset=" + j5 + " byteCount=" + j6);
        }
    }

    public static final int c() {
        return f23674b;
    }

    public static final int d(C2517h hVar, int i4) {
        m.e(hVar, "<this>");
        if (i4 == f23674b) {
            return hVar.G();
        }
        return i4;
    }

    public static final int e(int i4) {
        return ((i4 & 255) << 24) | ((-16777216 & i4) >>> 24) | ((16711680 & i4) >>> 8) | ((65280 & i4) << 8);
    }

    public static final long f(long j4) {
        return ((j4 & 255) << 56) | ((-72057594037927936L & j4) >>> 56) | ((71776119061217280L & j4) >>> 40) | ((280375465082880L & j4) >>> 24) | ((1095216660480L & j4) >>> 8) | ((4278190080L & j4) << 8) | ((16711680 & j4) << 24) | ((65280 & j4) << 40);
    }

    public static final short g(short s4) {
        return (short) (((s4 & 255) << 8) | ((65280 & s4) >>> 8));
    }

    public static final String h(byte b5) {
        return m3.m.k(new char[]{C2536b.f()[(b5 >> 4) & 15], C2536b.f()[b5 & 15]});
    }

    public static final String i(int i4) {
        int i5 = 0;
        if (i4 == 0) {
            return "0";
        }
        char[] cArr = {C2536b.f()[(i4 >> 28) & 15], C2536b.f()[(i4 >> 24) & 15], C2536b.f()[(i4 >> 20) & 15], C2536b.f()[(i4 >> 16) & 15], C2536b.f()[(i4 >> 12) & 15], C2536b.f()[(i4 >> 8) & 15], C2536b.f()[(i4 >> 4) & 15], C2536b.f()[i4 & 15]};
        while (i5 < 8 && cArr[i5] == '0') {
            i5++;
        }
        return m3.m.l(cArr, i5, 8);
    }
}
