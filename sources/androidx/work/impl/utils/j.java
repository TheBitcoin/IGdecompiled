package androidx.work.impl.utils;

import androidx.work.impl.utils.futures.SettableFuture;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WorkForegroundRunnable f1088a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SettableFuture f1089b;

    public /* synthetic */ j(WorkForegroundRunnable workForegroundRunnable, SettableFuture settableFuture) {
        this.f1088a = workForegroundRunnable;
        this.f1089b = settableFuture;
    }

    public final void run() {
        WorkForegroundRunnable.a(this.f1088a, this.f1089b);
    }
}
