package I;

import android.os.Bundle;
import android.util.Log;
import java.io.IOException;
import k0.C0928c;
import k0.C0937l;

/* renamed from: I.e  reason: case insensitive filesystem */
public final /* synthetic */ class C0298e implements C0928c {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ C0298e f255a = new C0298e();

    private /* synthetic */ C0298e() {
    }

    public final Object a(C0937l lVar) {
        if (lVar.n()) {
            return (Bundle) lVar.j();
        }
        if (Log.isLoggable("Rpc", 3)) {
            Log.d("Rpc", "Error making request: ".concat(String.valueOf(lVar.i())));
        }
        throw new IOException("SERVICE_NOT_AVAILABLE", lVar.i());
    }
}
