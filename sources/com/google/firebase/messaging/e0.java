package com.google.firebase.messaging;

import android.content.Context;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;

public final /* synthetic */ class e0 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f11357a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ScheduledExecutorService f11358b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f11359c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ I f11360d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ D f11361e;

    public /* synthetic */ e0(Context context, ScheduledExecutorService scheduledExecutorService, FirebaseMessaging firebaseMessaging, I i4, D d5) {
        this.f11357a = context;
        this.f11358b = scheduledExecutorService;
        this.f11359c = firebaseMessaging;
        this.f11360d = i4;
        this.f11361e = d5;
    }

    public final Object call() {
        return f0.a(this.f11357a, this.f11358b, this.f11359c, this.f11360d, this.f11361e);
    }
}
