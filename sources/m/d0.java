package M;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

public final class d0 extends T {

    /* renamed from: a  reason: collision with root package name */
    private C0322c f503a;

    /* renamed from: b  reason: collision with root package name */
    private final int f504b;

    public d0(C0322c cVar, int i4) {
        this.f503a = cVar;
        this.f504b = i4;
    }

    public final void D(int i4, Bundle bundle) {
        Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }

    public final void E(int i4, IBinder iBinder, h0 h0Var) {
        C0322c cVar = this.f503a;
        C0335p.m(cVar, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
        C0335p.l(h0Var);
        C0322c.c0(cVar, h0Var);
        P(i4, iBinder, h0Var.f540a);
    }

    public final void P(int i4, IBinder iBinder, Bundle bundle) {
        C0335p.m(this.f503a, "onPostInitComplete can be called only once per call to getRemoteService");
        this.f503a.N(i4, iBinder, bundle, this.f504b);
        this.f503a = null;
    }
}
