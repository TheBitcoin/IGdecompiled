package com.google.firebase.messaging;

/* renamed from: com.google.firebase.messaging.t  reason: case insensitive filesystem */
public final /* synthetic */ class C1805t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f11424a;

    public /* synthetic */ C1805t(FirebaseMessaging firebaseMessaging) {
        this.f11424a = firebaseMessaging;
    }

    public final void run() {
        FirebaseMessaging.b(this.f11424a);
    }
}
