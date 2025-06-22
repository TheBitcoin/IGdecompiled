package androidx.work.impl;

import o0.C2172d;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WorkerWrapper f1082a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2172d f1083b;

    public /* synthetic */ l(WorkerWrapper workerWrapper, C2172d dVar) {
        this.f1082a = workerWrapper;
        this.f1083b = dVar;
    }

    public final void run() {
        WorkerWrapper.a(this.f1082a, this.f1083b);
    }
}
