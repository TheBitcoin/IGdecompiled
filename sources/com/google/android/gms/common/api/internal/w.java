package com.google.android.gms.common.api.internal;

import J.C0305d;
import L.k;
import L.s;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import k0.C0938m;

public final class w extends s {

    /* renamed from: b  reason: collision with root package name */
    private final C0505d f1364b;

    /* renamed from: c  reason: collision with root package name */
    private final C0938m f1365c;

    /* renamed from: d  reason: collision with root package name */
    private final k f1366d;

    public w(int i4, C0505d dVar, C0938m mVar, k kVar) {
        super(i4);
        this.f1365c = mVar;
        this.f1364b = dVar;
        this.f1366d = kVar;
        if (i4 == 2 && dVar.c()) {
            throw new IllegalArgumentException("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
        }
    }

    public final void a(Status status) {
        this.f1365c.d(this.f1366d.a(status));
    }

    public final void b(Exception exc) {
        this.f1365c.d(exc);
    }

    public final void c(n nVar) {
        try {
            this.f1364b.b(nVar.v(), this.f1365c);
        } catch (DeadObjectException e5) {
            throw e5;
        } catch (RemoteException e6) {
            a(y.e(e6));
        } catch (RuntimeException e7) {
            this.f1365c.d(e7);
        }
    }

    public final void d(g gVar, boolean z4) {
        gVar.d(this.f1365c, z4);
    }

    public final boolean f(n nVar) {
        return this.f1364b.c();
    }

    public final C0305d[] g(n nVar) {
        return this.f1364b.e();
    }
}
