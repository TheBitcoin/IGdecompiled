package I;

import android.util.Log;
import java.io.IOException;
import k0.C0938m;

/* renamed from: I.g  reason: case insensitive filesystem */
public final /* synthetic */ class C0300g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0938m f257a;

    public /* synthetic */ C0300g(C0938m mVar) {
        this.f257a = mVar;
    }

    public final void run() {
        if (this.f257a.d(new IOException("TIMEOUT"))) {
            Log.w("Rpc", "No response");
        }
    }
}
