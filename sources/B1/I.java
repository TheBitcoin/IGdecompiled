package b1;

import R2.s;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import kotlin.jvm.internal.m;

public final class I implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    public static final I f8965a = new I();

    /* renamed from: b  reason: collision with root package name */
    private static boolean f8966b;

    /* renamed from: c  reason: collision with root package name */
    private static E f8967c;

    private I() {
    }

    public final void a(E e5) {
        f8967c = e5;
        if (e5 != null && f8966b) {
            f8966b = false;
            e5.k();
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        m.e(activity, "activity");
    }

    public void onActivityDestroyed(Activity activity) {
        m.e(activity, "activity");
    }

    public void onActivityPaused(Activity activity) {
        m.e(activity, "activity");
        E e5 = f8967c;
        if (e5 != null) {
            e5.h();
        }
    }

    public void onActivityResumed(Activity activity) {
        s sVar;
        m.e(activity, "activity");
        E e5 = f8967c;
        if (e5 != null) {
            e5.k();
            sVar = s.f8222a;
        } else {
            sVar = null;
        }
        if (sVar == null) {
            f8966b = true;
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        m.e(activity, "activity");
        m.e(bundle, "outState");
    }

    public void onActivityStarted(Activity activity) {
        m.e(activity, "activity");
    }

    public void onActivityStopped(Activity activity) {
        m.e(activity, "activity");
    }
}
