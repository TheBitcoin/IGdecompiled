package com.google.firebase.messaging;

import k0.C0938m;

/* renamed from: com.google.firebase.messaging.w  reason: case insensitive filesystem */
public final /* synthetic */ class C1808w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f11427a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C0938m f11428b;

    public /* synthetic */ C1808w(FirebaseMessaging firebaseMessaging, C0938m mVar) {
        this.f11427a = firebaseMessaging;
        this.f11428b = mVar;
    }

    public final void run() {
        FirebaseMessaging.c(this.f11427a, this.f11428b);
    }
}
