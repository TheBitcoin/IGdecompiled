package androidx.appcompat.app;

import android.window.OnBackInvokedCallback;

public final /* synthetic */ class q implements OnBackInvokedCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppCompatDelegateImpl f799a;

    public /* synthetic */ q(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.f799a = appCompatDelegateImpl;
    }

    public final void onBackInvoked() {
        this.f799a.onBackPressed();
    }
}
