package androidx.work.impl;

import androidx.work.WorkRequest;
import d3.a;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WorkManagerImpl f1077a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f1078b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ OperationImpl f1079c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ a f1080d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ WorkRequest f1081e;

    public /* synthetic */ k(WorkManagerImpl workManagerImpl, String str, OperationImpl operationImpl, a aVar, WorkRequest workRequest) {
        this.f1077a = workManagerImpl;
        this.f1078b = str;
        this.f1079c = operationImpl;
        this.f1080d = aVar;
        this.f1081e = workRequest;
    }

    public final void run() {
        WorkerUpdater.enqueueUniquelyNamedPeriodic$lambda$4(this.f1077a, this.f1078b, this.f1079c, this.f1080d, this.f1081e);
    }
}
