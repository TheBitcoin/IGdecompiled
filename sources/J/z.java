package J;

import M.C0335p;
import M.S;
import M.v0;
import U.a;
import U.b;
import android.os.RemoteException;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

abstract class z extends v0 {

    /* renamed from: a  reason: collision with root package name */
    private final int f359a;

    protected z(byte[] bArr) {
        boolean z4;
        if (bArr.length == 25) {
            z4 = true;
        } else {
            z4 = false;
        }
        C0335p.a(z4);
        this.f359a = Arrays.hashCode(bArr);
    }

    protected static byte[] k(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e5) {
            throw new AssertionError(e5);
        }
    }

    public final a C() {
        return b.l0(l0());
    }

    public final int b() {
        return this.f359a;
    }

    public final boolean equals(Object obj) {
        a C4;
        if (obj != null && (obj instanceof S)) {
            try {
                S s4 = (S) obj;
                if (s4.b() != this.f359a || (C4 = s4.C()) == null) {
                    return false;
                }
                return Arrays.equals(l0(), (byte[]) b.k(C4));
            } catch (RemoteException e5) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e5);
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f359a;
    }

    /* access modifiers changed from: package-private */
    public abstract byte[] l0();
}
