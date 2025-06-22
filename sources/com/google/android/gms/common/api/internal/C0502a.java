package com.google.android.gms.common.api.internal;

import R.k;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.google.android.gms.common.api.internal.a  reason: case insensitive filesystem */
public final class C0502a implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    /* renamed from: e  reason: collision with root package name */
    private static final C0502a f1282e = new C0502a();

    /* renamed from: a  reason: collision with root package name */
    private final AtomicBoolean f1283a = new AtomicBoolean();

    /* renamed from: b  reason: collision with root package name */
    private final AtomicBoolean f1284b = new AtomicBoolean();

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList f1285c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private boolean f1286d = false;

    /* renamed from: com.google.android.gms.common.api.internal.a$a  reason: collision with other inner class name */
    public interface C0023a {
        void a(boolean z4);
    }

    private C0502a() {
    }

    public static C0502a b() {
        return f1282e;
    }

    public static void c(Application application) {
        C0502a aVar = f1282e;
        synchronized (aVar) {
            try {
                if (!aVar.f1286d) {
                    application.registerActivityLifecycleCallbacks(aVar);
                    application.registerComponentCallbacks(aVar);
                    aVar.f1286d = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void f(boolean z4) {
        synchronized (f1282e) {
            try {
                ArrayList arrayList = this.f1285c;
                int size = arrayList.size();
                int i4 = 0;
                while (i4 < size) {
                    Object obj = arrayList.get(i4);
                    i4++;
                    ((C0023a) obj).a(z4);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(C0023a aVar) {
        synchronized (f1282e) {
            this.f1285c.add(aVar);
        }
    }

    public boolean d() {
        return this.f1283a.get();
    }

    public boolean e(boolean z4) {
        if (!this.f1284b.get()) {
            if (!k.b()) {
                return z4;
            }
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (!this.f1284b.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                this.f1283a.set(true);
            }
        }
        return d();
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        AtomicBoolean atomicBoolean = this.f1284b;
        boolean compareAndSet = this.f1283a.compareAndSet(true, false);
        atomicBoolean.set(true);
        if (compareAndSet) {
            f(false);
        }
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityResumed(Activity activity) {
        AtomicBoolean atomicBoolean = this.f1284b;
        boolean compareAndSet = this.f1283a.compareAndSet(true, false);
        atomicBoolean.set(true);
        if (compareAndSet) {
            f(false);
        }
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final void onLowMemory() {
    }

    public final void onTrimMemory(int i4) {
        if (i4 == 20 && this.f1283a.compareAndSet(false, true)) {
            this.f1284b.set(true);
            f(true);
        }
    }
}
