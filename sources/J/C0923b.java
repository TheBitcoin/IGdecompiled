package j;

import androidx.work.impl.workers.ConstraintTrackingWorker;
import o3.C1001s0;

/* renamed from: j.b  reason: case insensitive filesystem */
public final /* synthetic */ class C0923b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C1001s0 f3432a;

    public /* synthetic */ C0923b(C1001s0 s0Var) {
        this.f3432a = s0Var;
    }

    public final void run() {
        ConstraintTrackingWorker.setupAndRunConstraintTrackingWork$lambda$1(this.f3432a);
    }
}
