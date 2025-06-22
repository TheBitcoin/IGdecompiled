package androidx.appcompat.widget;

import android.window.OnBackInvokedCallback;

public final /* synthetic */ class T implements OnBackInvokedCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Runnable f803a;

    public /* synthetic */ T(Runnable runnable) {
        this.f803a = runnable;
    }

    public final void onBackInvoked() {
        this.f803a.run();
    }
}
