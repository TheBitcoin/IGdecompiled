package com.google.android.gms.common.api.internal;

import K.a;
import K.f;
import K.j;
import M.C0335p;
import android.app.PendingIntent;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.common.api.internal.b  reason: case insensitive filesystem */
public abstract class C0503b extends BasePendingResult {

    /* renamed from: n  reason: collision with root package name */
    private final a.c f1287n;

    /* renamed from: o  reason: collision with root package name */
    private final a f1288o;

    protected C0503b(a aVar, f fVar) {
        super((f) C0335p.m(fVar, "GoogleApiClient must not be null"));
        C0335p.m(aVar, "Api must not be null");
        this.f1287n = aVar.b();
        this.f1288o = aVar;
    }

    private void n(RemoteException remoteException) {
        o(new Status(8, remoteException.getLocalizedMessage(), (PendingIntent) null));
    }

    /* access modifiers changed from: protected */
    public abstract void k(a.b bVar);

    public final void m(a.b bVar) {
        try {
            k(bVar);
        } catch (DeadObjectException e5) {
            n(e5);
            throw e5;
        } catch (RemoteException e6) {
            n(e6);
        }
    }

    public final void o(Status status) {
        C0335p.b(!status.k(), "Failed result must not be success");
        j c5 = c(status);
        f(c5);
        l(c5);
    }

    /* access modifiers changed from: protected */
    public void l(j jVar) {
    }
}
