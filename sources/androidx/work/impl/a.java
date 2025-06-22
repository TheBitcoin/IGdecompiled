package androidx.work.impl;

import androidx.work.impl.model.WorkGenerationalId;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Processor f1043a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WorkGenerationalId f1044b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f1045c;

    public /* synthetic */ a(Processor processor, WorkGenerationalId workGenerationalId, boolean z4) {
        this.f1043a = processor;
        this.f1044b = workGenerationalId;
        this.f1045c = z4;
    }

    public final void run() {
        Processor.b(this.f1043a, this.f1044b, this.f1045c);
    }
}
