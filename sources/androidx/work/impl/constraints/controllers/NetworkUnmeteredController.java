package androidx.work.impl.constraints.controllers;

import android.os.Build;
import androidx.work.NetworkType;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkSpec;
import kotlin.jvm.internal.m;

public final class NetworkUnmeteredController extends ConstraintController<NetworkState> {
    private final int reason = 7;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NetworkUnmeteredController(ConstraintTracker<NetworkState> constraintTracker) {
        super(constraintTracker);
        m.e(constraintTracker, "tracker");
    }

    public int getReason() {
        return this.reason;
    }

    public boolean hasConstraint(WorkSpec workSpec) {
        m.e(workSpec, "workSpec");
        NetworkType requiredNetworkType = workSpec.constraints.getRequiredNetworkType();
        if (requiredNetworkType == NetworkType.UNMETERED) {
            return true;
        }
        if (Build.VERSION.SDK_INT < 30 || requiredNetworkType != NetworkType.TEMPORARILY_UNMETERED) {
            return false;
        }
        return true;
    }

    public boolean isConstrained(NetworkState networkState) {
        m.e(networkState, "value");
        return !networkState.isConnected() || networkState.isMetered();
    }
}
