package com.google.android.gms.common.api.internal;

import K.b;
import L.s;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import k0.C0938m;

abstract class u extends s {

    /* renamed from: b  reason: collision with root package name */
    protected final C0938m f1362b;

    public u(int i4, C0938m mVar) {
        super(i4);
        this.f1362b = mVar;
    }

    public final void a(Status status) {
        this.f1362b.d(new b(status));
    }

    public final void b(Exception exc) {
        this.f1362b.d(exc);
    }

    public final void c(n nVar) {
        try {
            h(nVar);
        } catch (DeadObjectException e5) {
            a(y.e(e5));
            throw e5;
        } catch (RemoteException e6) {
            a(y.e(e6));
        } catch (RuntimeException e7) {
            this.f1362b.d(e7);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void h(n nVar);
}
