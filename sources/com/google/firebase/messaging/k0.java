package com.google.firebase.messaging;

import android.content.Intent;
import android.os.Binder;
import android.os.Process;
import android.util.Log;
import androidx.privacysandbox.ads.adservices.adid.h;
import com.google.firebase.messaging.n0;
import k0.C0937l;

class k0 extends Binder {

    /* renamed from: a  reason: collision with root package name */
    private final a f11405a;

    interface a {
        C0937l a(Intent intent);
    }

    k0(a aVar) {
        this.f11405a = aVar;
    }

    /* access modifiers changed from: package-private */
    public void b(n0.a aVar) {
        if (Binder.getCallingUid() == Process.myUid()) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "service received new intent via bind strategy");
            }
            this.f11405a.a(aVar.f11418a).b(new h(), new j0(aVar));
            return;
        }
        throw new SecurityException("Binding only allowed within app");
    }
}
