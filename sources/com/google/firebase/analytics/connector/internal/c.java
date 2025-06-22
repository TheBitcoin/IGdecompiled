package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import e0.a;

final class c implements a.C0029a {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ d f11111a;

    public c(d dVar) {
        this.f11111a = dVar;
    }

    public final void a(String str, String str2, Bundle bundle, long j4) {
        if (this.f11111a.f11112a.contains(str2)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("events", a.a(str2));
            this.f11111a.f11113b.a(2, bundle2);
        }
    }
}
