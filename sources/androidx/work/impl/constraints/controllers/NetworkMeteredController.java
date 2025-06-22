package androidx.work.impl.constraints.controllers;

import android.os.Build;
import androidx.work.Logger;
import androidx.work.NetworkType;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkSpec;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public final class NetworkMeteredController extends ConstraintController<NetworkState> {
    public static final Companion Companion = new Companion((C2103g) null);
    private static final String TAG;
    private final int reason = 7;

    public static final class Companion {
        public /* synthetic */ Companion(C2103g gVar) {
            this();
        }

        private Companion() {
        }
    }

    static {
        String tagWithPrefix = Logger.tagWithPrefix("NetworkMeteredCtrlr");
        m.d(tagWithPrefix, "tagWithPrefix(\"NetworkMeteredCtrlr\")");
        TAG = tagWithPrefix;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NetworkMeteredController(ConstraintTracker<NetworkState> constraintTracker) {
        super(constraintTracker);
        m.e(constraintTracker, "tracker");
    }

    public int getReason() {
        return this.reason;
    }

    public boolean hasConstraint(WorkSpec workSpec) {
        m.e(workSpec, "workSpec");
        if (workSpec.constraints.getRequiredNetworkType() == NetworkType.METERED) {
            return true;
        }
        return false;
    }

    public boolean isConstrained(NetworkState networkState) {
        m.e(networkState, "value");
        if (Build.VERSION.SDK_INT >= 26) {
            return !networkState.isConnected() || !networkState.isMetered();
        }
        Logger.get().debug(TAG, "Metered network constraint is not supported before API 26, only checking for connected state.");
        return !networkState.isConnected();
    }
}
