package M;

import J.C0303b;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;

public final class f0 extends Q {

    /* renamed from: g  reason: collision with root package name */
    public final IBinder f529g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ C0322c f530h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f0(C0322c cVar, int i4, IBinder iBinder, Bundle bundle) {
        super(cVar, i4, bundle);
        this.f530h = cVar;
        this.f529g = iBinder;
    }

    /* access modifiers changed from: protected */
    public final void f(C0303b bVar) {
        if (this.f530h.f479v != null) {
            this.f530h.f479v.i(bVar);
        }
        this.f530h.L(bVar);
    }

    /* access modifiers changed from: protected */
    public final boolean g() {
        try {
            IBinder iBinder = this.f529g;
            C0335p.l(iBinder);
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            if (!this.f530h.E().equals(interfaceDescriptor)) {
                String E4 = this.f530h.E();
                Log.w("GmsClient", "service descriptor mismatch: " + E4 + " vs. " + interfaceDescriptor);
                return false;
            }
            IInterface s4 = this.f530h.s(this.f529g);
            if (s4 == null || (!C0322c.g0(this.f530h, 2, 4, s4) && !C0322c.g0(this.f530h, 3, 4, s4))) {
                return false;
            }
            this.f530h.f483z = null;
            C0322c cVar = this.f530h;
            Bundle x4 = cVar.x();
            if (cVar.f478u == null) {
                return true;
            }
            this.f530h.f478u.k(x4);
            return true;
        } catch (RemoteException unused) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
    }
}
