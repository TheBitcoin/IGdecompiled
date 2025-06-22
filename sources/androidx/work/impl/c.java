package androidx.work.impl;

import o0.C2172d;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Processor f1053a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2172d f1054b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ WorkerWrapper f1055c;

    public /* synthetic */ c(Processor processor, C2172d dVar, WorkerWrapper workerWrapper) {
        this.f1053a = processor;
        this.f1054b = dVar;
        this.f1055c = workerWrapper;
    }

    public final void run() {
        Processor.c(this.f1053a, this.f1054b, this.f1055c);
    }
}
