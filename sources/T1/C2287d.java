package t1;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

/* renamed from: t1.d  reason: case insensitive filesystem */
public class C2287d implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    private boolean f21793a;

    /* renamed from: b  reason: collision with root package name */
    protected boolean f21794b;

    /* renamed from: c  reason: collision with root package name */
    private a f21795c;

    /* renamed from: t1.d$a */
    public interface a {
        void a(boolean z4);
    }

    private void c(boolean z4) {
        if (this.f21794b != z4) {
            this.f21794b = z4;
            if (this.f21793a) {
                f(z4);
                a aVar = this.f21795c;
                if (aVar != null) {
                    aVar.a(z4);
                }
            }
        }
    }

    private boolean d() {
        if (e().importance != 100 && !h()) {
            return false;
        }
        return true;
    }

    public void a(Context context) {
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(this);
        }
    }

    public void b(a aVar) {
        this.f21795c = aVar;
    }

    /* access modifiers changed from: package-private */
    public ActivityManager.RunningAppProcessInfo e() {
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(runningAppProcessInfo);
        return runningAppProcessInfo;
    }

    public boolean g() {
        return this.f21794b;
    }

    /* access modifiers changed from: protected */
    public boolean h() {
        return false;
    }

    public void i() {
        this.f21793a = true;
        boolean d5 = d();
        this.f21794b = d5;
        f(d5);
    }

    public void j() {
        this.f21793a = false;
        this.f21795c = null;
    }

    public void onActivityStarted(Activity activity) {
        c(true);
    }

    public void onActivityStopped(Activity activity) {
        c(d());
    }

    /* access modifiers changed from: protected */
    public void f(boolean z4) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
