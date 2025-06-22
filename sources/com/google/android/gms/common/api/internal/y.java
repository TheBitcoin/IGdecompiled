package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

public abstract class y {

    /* renamed from: a  reason: collision with root package name */
    public final int f1367a;

    public y(int i4) {
        this.f1367a = i4;
    }

    static /* bridge */ /* synthetic */ Status e(RemoteException remoteException) {
        return new Status(19, remoteException.getClass().getSimpleName() + ": " + remoteException.getLocalizedMessage());
    }

    public abstract void a(Status status);

    public abstract void b(Exception exc);

    public abstract void c(n nVar);

    public abstract void d(g gVar, boolean z4);
}
