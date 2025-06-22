package androidx.appcompat.app;

import androidx.appcompat.app.AppCompatDelegate;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppCompatDelegate.SerialExecutor f797a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f798b;

    public /* synthetic */ c(AppCompatDelegate.SerialExecutor serialExecutor, Runnable runnable) {
        this.f797a = serialExecutor;
        this.f798b = runnable;
    }

    public final void run() {
        AppCompatDelegate.SerialExecutor.a(this.f797a, this.f798b);
    }
}
