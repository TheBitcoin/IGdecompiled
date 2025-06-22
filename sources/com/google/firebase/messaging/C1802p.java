package com.google.firebase.messaging;

import android.content.Intent;

/* renamed from: com.google.firebase.messaging.p  reason: case insensitive filesystem */
public final /* synthetic */ class C1802p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C1803q f11420a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Intent f11421b;

    public /* synthetic */ C1802p(C1803q qVar, Intent intent) {
        this.f11420a = qVar;
        this.f11421b = intent;
    }

    public final void run() {
        this.f11420a.b(this.f11421b);
    }
}
