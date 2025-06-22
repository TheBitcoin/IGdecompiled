package com.google.firebase.messaging;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import androidx.privacysandbox.ads.adservices.adid.h;
import com.google.firebase.messaging.k0;
import java.util.concurrent.ExecutorService;
import k0.C0937l;
import k0.C0938m;
import k0.C0940o;

/* renamed from: com.google.firebase.messaging.i  reason: case insensitive filesystem */
public abstract class C1795i extends Service {

    /* renamed from: a  reason: collision with root package name */
    final ExecutorService f11390a = C1801o.d();

    /* renamed from: b  reason: collision with root package name */
    private Binder f11391b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f11392c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private int f11393d;

    /* renamed from: e  reason: collision with root package name */
    private int f11394e = 0;

    /* renamed from: com.google.firebase.messaging.i$a */
    class a implements k0.a {
        a() {
        }

        public C0937l a(Intent intent) {
            return C1795i.this.h(intent);
        }
    }

    public static /* synthetic */ void a(C1795i iVar, Intent intent, C0938m mVar) {
        iVar.getClass();
        try {
            iVar.f(intent);
        } finally {
            mVar.c((Object) null);
        }
    }

    /* access modifiers changed from: private */
    public void d(Intent intent) {
        if (intent != null) {
            i0.c(intent);
        }
        synchronized (this.f11392c) {
            try {
                int i4 = this.f11394e - 1;
                this.f11394e = i4;
                if (i4 == 0) {
                    i(this.f11393d);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    public C0937l h(Intent intent) {
        if (g(intent)) {
            return C0940o.e((Object) null);
        }
        C0938m mVar = new C0938m();
        this.f11390a.execute(new C1794h(this, intent, mVar));
        return mVar.a();
    }

    /* access modifiers changed from: protected */
    public abstract Intent e(Intent intent);

    public abstract void f(Intent intent);

    public boolean g(Intent intent) {
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean i(int i4) {
        return stopSelfResult(i4);
    }

    public final synchronized IBinder onBind(Intent intent) {
        try {
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                Log.d("EnhancedIntentService", "Service received bind request");
            }
            if (this.f11391b == null) {
                this.f11391b = new k0(new a());
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this.f11391b;
    }

    public void onDestroy() {
        this.f11390a.shutdown();
        super.onDestroy();
    }

    public final int onStartCommand(Intent intent, int i4, int i5) {
        synchronized (this.f11392c) {
            this.f11393d = i5;
            this.f11394e++;
        }
        Intent e5 = e(intent);
        if (e5 == null) {
            d(intent);
            return 2;
        }
        C0937l h4 = h(e5);
        if (h4.m()) {
            d(intent);
            return 2;
        }
        h4.b(new h(), new C1793g(this, intent));
        return 3;
    }
}
