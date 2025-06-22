package com.google.firebase.messaging;

import com.google.firebase.messaging.V;
import com.google.firebase.messaging.a0;
import k0.C0937l;

/* renamed from: com.google.firebase.messaging.y  reason: case insensitive filesystem */
public final /* synthetic */ class C1810y implements V.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f11430a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f11431b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ a0.a f11432c;

    public /* synthetic */ C1810y(FirebaseMessaging firebaseMessaging, String str, a0.a aVar) {
        this.f11430a = firebaseMessaging;
        this.f11431b = str;
        this.f11432c = aVar;
    }

    public final C0937l start() {
        return this.f11430a.f11237c.f().o(this.f11430a.f11241g, new C1811z(this.f11430a, this.f11431b, this.f11432c));
    }
}
