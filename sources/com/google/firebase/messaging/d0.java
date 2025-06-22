package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

final class d0 {

    /* renamed from: d  reason: collision with root package name */
    private static WeakReference f11352d;

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f11353a;

    /* renamed from: b  reason: collision with root package name */
    private Z f11354b;

    /* renamed from: c  reason: collision with root package name */
    private final Executor f11355c;

    private d0(SharedPreferences sharedPreferences, Executor executor) {
        this.f11355c = executor;
        this.f11353a = sharedPreferences;
    }

    public static synchronized d0 a(Context context, Executor executor) {
        d0 d0Var;
        synchronized (d0.class) {
            try {
                WeakReference weakReference = f11352d;
                if (weakReference != null) {
                    d0Var = (d0) weakReference.get();
                } else {
                    d0Var = null;
                }
                if (d0Var == null) {
                    d0Var = new d0(context.getSharedPreferences("com.google.android.gms.appid", 0), executor);
                    d0Var.c();
                    f11352d = new WeakReference(d0Var);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return d0Var;
    }

    private synchronized void c() {
        this.f11354b = Z.c(this.f11353a, "topic_operation_queue", ",", this.f11355c);
    }

    /* access modifiers changed from: package-private */
    public synchronized c0 b() {
        return c0.a(this.f11354b.e());
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean d(c0 c0Var) {
        return this.f11354b.f(c0Var.e());
    }
}
