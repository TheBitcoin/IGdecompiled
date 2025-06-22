package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import java.util.concurrent.Callable;

/* renamed from: com.google.firebase.messaging.j  reason: case insensitive filesystem */
public final /* synthetic */ class C1796j implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f11399a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Intent f11400b;

    public /* synthetic */ C1796j(Context context, Intent intent) {
        this.f11399a = context;
        this.f11400b = intent;
    }

    public final Object call() {
        return Integer.valueOf(X.b().g(this.f11399a, this.f11400b));
    }
}
