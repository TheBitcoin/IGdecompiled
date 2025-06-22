package androidx.work.impl;

import androidx.work.WorkRequest;
import androidx.work.impl.utils.futures.SettableFuture;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SettableFuture f1074a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WorkManagerImpl f1075b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ WorkRequest f1076c;

    public /* synthetic */ j(SettableFuture settableFuture, WorkManagerImpl workManagerImpl, WorkRequest workRequest) {
        this.f1074a = settableFuture;
        this.f1075b = workManagerImpl;
        this.f1076c = workRequest;
    }

    public final void run() {
        WorkerUpdater.updateWorkImpl$lambda$3(this.f1074a, this.f1075b, this.f1076c);
    }
}
