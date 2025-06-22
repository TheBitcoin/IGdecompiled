package com.google.firebase.messaging;

import android.content.Context;
import k0.C0938m;

public final /* synthetic */ class N implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f11260a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f11261b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ C0938m f11262c;

    public /* synthetic */ N(Context context, boolean z4, C0938m mVar) {
        this.f11260a = context;
        this.f11261b = z4;
        this.f11262c = mVar;
    }

    public final void run() {
        O.a(this.f11260a, this.f11261b, this.f11262c);
    }
}
