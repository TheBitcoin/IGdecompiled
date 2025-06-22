package j;

import androidx.work.impl.workers.ConstraintTrackingWorker;

/* renamed from: j.a  reason: case insensitive filesystem */
public final /* synthetic */ class C0922a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConstraintTrackingWorker f3431a;

    public /* synthetic */ C0922a(ConstraintTrackingWorker constraintTrackingWorker) {
        this.f3431a = constraintTrackingWorker;
    }

    public final void run() {
        ConstraintTrackingWorker.startWork$lambda$0(this.f3431a);
    }
}
