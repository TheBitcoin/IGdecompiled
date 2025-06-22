package b4;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.m;

public final class b implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    public WeakReference f24460a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f24461b;

    public b(a aVar) {
        this.f24461b = aVar;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        m.e(activity, "activity");
    }

    public void onActivityDestroyed(Activity activity) {
        m.e(activity, "activity");
    }

    public void onActivityPaused(Activity activity) {
        m.e(activity, "activity");
    }

    public void onActivityResumed(Activity activity) {
        m.e(activity, "activity");
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        m.e(activity, "activity");
        m.e(bundle, "outState");
    }

    public void onActivityStarted(Activity activity) {
        m.e(activity, "activity");
        WeakReference weakReference = this.f24460a;
        if (weakReference == null || !m.a((Activity) weakReference.get(), activity)) {
            if (!c.f24462a) {
                this.f24461b.a();
                c.f24462a = true;
            }
            this.f24460a = new WeakReference(activity);
        }
    }

    public void onActivityStopped(Activity activity) {
        Activity activity2;
        m.e(activity, "activity");
        WeakReference weakReference = this.f24460a;
        if (weakReference == null) {
            activity2 = null;
        } else {
            activity2 = (Activity) weakReference.get();
        }
        if (m.a(activity2, activity)) {
            if (c.f24462a) {
                this.f24461b.b();
                c.f24462a = false;
            }
            this.f24460a = null;
        }
    }
}
