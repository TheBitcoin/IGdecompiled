package androidx.work.impl.constraints.controllers;

import V2.d;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkSpec;
import kotlin.jvm.internal.m;
import r3.C1035e;
import r3.C1037g;

public abstract class ConstraintController<T> {
    /* access modifiers changed from: private */
    public final ConstraintTracker<T> tracker;

    public ConstraintController(ConstraintTracker<T> constraintTracker) {
        m.e(constraintTracker, "tracker");
        this.tracker = constraintTracker;
    }

    public static /* synthetic */ void getReason$annotations() {
    }

    public abstract int getReason();

    public abstract boolean hasConstraint(WorkSpec workSpec);

    public final boolean isConstrained(WorkSpec workSpec) {
        m.e(workSpec, "workSpec");
        return hasConstraint(workSpec) && isConstrained(this.tracker.readSystemState());
    }

    public abstract boolean isConstrained(T t4);

    public final C1035e track() {
        return C1037g.d(new ConstraintController$track$1(this, (d) null));
    }
}
