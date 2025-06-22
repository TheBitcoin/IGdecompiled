package com.google.android.gms.measurement.internal;

import J.C0313l;
import M.C0322c;
import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import f0.C0917f;

/* renamed from: com.google.android.gms.measurement.internal.j2  reason: case insensitive filesystem */
public final class C0793j2 extends C0322c {
    public C0793j2(Context context, Looper looper, C0322c.a aVar, C0322c.b bVar) {
        super(context, looper, 93, aVar, bVar, (String) null);
    }

    /* access modifiers changed from: protected */
    public final String E() {
        return "com.google.android.gms.measurement.internal.IMeasurementService";
    }

    /* access modifiers changed from: protected */
    public final String F() {
        return "com.google.android.gms.measurement.START";
    }

    public final int l() {
        return C0313l.f342a;
    }

    public final /* synthetic */ IInterface s(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
        if (queryLocalInterface instanceof C0917f) {
            return (C0917f) queryLocalInterface;
        }
        return new C0758e2(iBinder);
    }
}
