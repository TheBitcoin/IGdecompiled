package androidx.core.app;

import android.app.Activity;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Activity f836a;

    public /* synthetic */ a(Activity activity) {
        this.f836a = activity;
    }

    public final void run() {
        ActivityCompat.a(this.f836a);
    }
}
