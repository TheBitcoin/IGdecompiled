package X;

import D.c;
import J.C0313l;
import L.C0319c;
import L.h;
import M.C0323d;
import M.C0326g;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.text.TextUtils;

public final class b extends C0326g {

    /* renamed from: I  reason: collision with root package name */
    private final Bundle f649I = new Bundle();

    public b(Context context, Looper looper, C0323d dVar, c cVar, C0319c cVar2, h hVar) {
        super(context, looper, 16, dVar, cVar2, hVar);
    }

    /* access modifiers changed from: protected */
    public final Bundle A() {
        return this.f649I;
    }

    /* access modifiers changed from: protected */
    public final String E() {
        return "com.google.android.gms.auth.api.internal.IAuthService";
    }

    /* access modifiers changed from: protected */
    public final String F() {
        return "com.google.android.gms.auth.service.START";
    }

    public final boolean S() {
        return true;
    }

    public final int l() {
        return C0313l.f342a;
    }

    public final boolean o() {
        C0323d j02 = j0();
        if (TextUtils.isEmpty(j02.b()) || j02.e(D.b.f190a).isEmpty()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ IInterface s(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.internal.IAuthService");
        if (queryLocalInterface instanceof c) {
            return (c) queryLocalInterface;
        }
        return new c(iBinder);
    }
}
