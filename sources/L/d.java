package L;

import M.C0335p;
import android.app.Activity;
import androidx.fragment.app.FragmentActivity;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private final Object f397a;

    public d(Activity activity) {
        C0335p.m(activity, "Activity must not be null");
        this.f397a = activity;
    }

    public final Activity a() {
        return (Activity) this.f397a;
    }

    public final FragmentActivity b() {
        return (FragmentActivity) this.f397a;
    }

    public final boolean c() {
        return this.f397a instanceof Activity;
    }

    public final boolean d() {
        return this.f397a instanceof FragmentActivity;
    }
}
