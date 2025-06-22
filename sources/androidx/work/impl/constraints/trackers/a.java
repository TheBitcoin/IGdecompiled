package androidx.work.impl.constraints.trackers;

import java.util.List;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f1056a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ConstraintTracker f1057b;

    public /* synthetic */ a(List list, ConstraintTracker constraintTracker) {
        this.f1056a = list;
        this.f1057b = constraintTracker;
    }

    public final void run() {
        ConstraintTracker._set_state_$lambda$4$lambda$3(this.f1056a, this.f1057b);
    }
}
