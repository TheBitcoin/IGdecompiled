package androidx.work.impl.constraints.controllers;

import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkSpec;
import kotlin.jvm.internal.m;

public final class StorageNotLowController extends ConstraintController<Boolean> {
    private final int reason = 9;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StorageNotLowController(ConstraintTracker<Boolean> constraintTracker) {
        super(constraintTracker);
        m.e(constraintTracker, "tracker");
    }

    public int getReason() {
        return this.reason;
    }

    public boolean hasConstraint(WorkSpec workSpec) {
        m.e(workSpec, "workSpec");
        return workSpec.constraints.requiresStorageNotLow();
    }

    public boolean isConstrained(boolean z4) {
        return !z4;
    }

    public /* bridge */ /* synthetic */ boolean isConstrained(Object obj) {
        return isConstrained(((Boolean) obj).booleanValue());
    }
}
