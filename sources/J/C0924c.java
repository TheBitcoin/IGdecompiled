package j;

import androidx.work.impl.workers.ConstraintTrackingWorker;
import o0.C2172d;

/* renamed from: j.c  reason: case insensitive filesystem */
public final /* synthetic */ class C0924c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConstraintTrackingWorker f3433a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2172d f3434b;

    public /* synthetic */ C0924c(ConstraintTrackingWorker constraintTrackingWorker, C2172d dVar) {
        this.f3433a = constraintTrackingWorker;
        this.f3434b = dVar;
    }

    public final void run() {
        ConstraintTrackingWorker.setupAndRunConstraintTrackingWork$lambda$3(this.f3433a, this.f3434b);
    }
}
