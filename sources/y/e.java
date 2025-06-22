package Y;

import D.g;
import K.f;
import M.C0323d;
import M.C0326g;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;

public final class e extends C0326g {

    /* renamed from: I  reason: collision with root package name */
    private final g f653I;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(Context context, Looper looper, C0323d dVar, g gVar, f.a aVar, f.b bVar) {
        super(context, looper, 68, dVar, aVar, bVar);
        D.f fVar = new D.f(gVar == null ? g.f196d : gVar);
        fVar.a(b.a());
        this.f653I = new g(fVar);
    }

    /* access modifiers changed from: protected */
    public final Bundle A() {
        return this.f653I.a();
    }

    /* access modifiers changed from: protected */
    public final String E() {
        return "com.google.android.gms.auth.api.credentials.internal.ICredentialsService";
    }

    /* access modifiers changed from: protected */
    public final String F() {
        return "com.google.android.gms.auth.api.credentials.service.START";
    }

    public final int l() {
        return 12800000;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ IInterface s(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
        if (queryLocalInterface instanceof f) {
            return (f) queryLocalInterface;
        }
        return new f(iBinder);
    }
}
