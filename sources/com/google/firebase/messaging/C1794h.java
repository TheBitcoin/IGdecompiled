package com.google.firebase.messaging;

import android.content.Intent;
import k0.C0938m;

/* renamed from: com.google.firebase.messaging.h  reason: case insensitive filesystem */
public final /* synthetic */ class C1794h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C1795i f11386a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Intent f11387b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ C0938m f11388c;

    public /* synthetic */ C1794h(C1795i iVar, Intent intent, C0938m mVar) {
        this.f11386a = iVar;
        this.f11387b = intent;
        this.f11388c = mVar;
    }

    public final void run() {
        C1795i.a(this.f11386a, this.f11387b, this.f11388c);
    }
}
