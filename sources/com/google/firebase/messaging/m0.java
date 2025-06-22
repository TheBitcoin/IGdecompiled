package com.google.firebase.messaging;

import java.util.concurrent.ScheduledFuture;
import k0.C0931f;
import k0.C0937l;

public final /* synthetic */ class m0 implements C0931f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ScheduledFuture f11407a;

    public /* synthetic */ m0(ScheduledFuture scheduledFuture) {
        this.f11407a = scheduledFuture;
    }

    public final void a(C0937l lVar) {
        this.f11407a.cancel(false);
    }
}
