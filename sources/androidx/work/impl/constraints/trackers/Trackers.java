package androidx.work.impl.constraints.trackers;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class Trackers {
    private final ConstraintTracker<Boolean> batteryChargingTracker;
    private final BatteryNotLowTracker batteryNotLowTracker;
    private final ConstraintTracker<NetworkState> networkStateTracker;
    private final ConstraintTracker<Boolean> storageNotLowTracker;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Trackers(Context context, TaskExecutor taskExecutor) {
        this(context, taskExecutor, (ConstraintTracker) null, (BatteryNotLowTracker) null, (ConstraintTracker) null, (ConstraintTracker) null, 60, (C2103g) null);
        m.e(context, "context");
        m.e(taskExecutor, "taskExecutor");
    }

    public final ConstraintTracker<Boolean> getBatteryChargingTracker() {
        return this.batteryChargingTracker;
    }

    public final BatteryNotLowTracker getBatteryNotLowTracker() {
        return this.batteryNotLowTracker;
    }

    public final ConstraintTracker<NetworkState> getNetworkStateTracker() {
        return this.networkStateTracker;
    }

    public final ConstraintTracker<Boolean> getStorageNotLowTracker() {
        return this.storageNotLowTracker;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Trackers(Context context, TaskExecutor taskExecutor, ConstraintTracker<Boolean> constraintTracker) {
        this(context, taskExecutor, constraintTracker, (BatteryNotLowTracker) null, (ConstraintTracker) null, (ConstraintTracker) null, 56, (C2103g) null);
        m.e(context, "context");
        m.e(taskExecutor, "taskExecutor");
        m.e(constraintTracker, "batteryChargingTracker");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Trackers(Context context, TaskExecutor taskExecutor, ConstraintTracker<Boolean> constraintTracker, BatteryNotLowTracker batteryNotLowTracker2) {
        this(context, taskExecutor, constraintTracker, batteryNotLowTracker2, (ConstraintTracker) null, (ConstraintTracker) null, 48, (C2103g) null);
        m.e(context, "context");
        m.e(taskExecutor, "taskExecutor");
        m.e(constraintTracker, "batteryChargingTracker");
        m.e(batteryNotLowTracker2, "batteryNotLowTracker");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Trackers(Context context, TaskExecutor taskExecutor, ConstraintTracker<Boolean> constraintTracker, BatteryNotLowTracker batteryNotLowTracker2, ConstraintTracker<NetworkState> constraintTracker2) {
        this(context, taskExecutor, constraintTracker, batteryNotLowTracker2, constraintTracker2, (ConstraintTracker) null, 32, (C2103g) null);
        m.e(context, "context");
        m.e(taskExecutor, "taskExecutor");
        m.e(constraintTracker, "batteryChargingTracker");
        m.e(batteryNotLowTracker2, "batteryNotLowTracker");
        m.e(constraintTracker2, "networkStateTracker");
    }

    public Trackers(Context context, TaskExecutor taskExecutor, ConstraintTracker<Boolean> constraintTracker, BatteryNotLowTracker batteryNotLowTracker2, ConstraintTracker<NetworkState> constraintTracker2, ConstraintTracker<Boolean> constraintTracker3) {
        m.e(context, "context");
        m.e(taskExecutor, "taskExecutor");
        m.e(constraintTracker, "batteryChargingTracker");
        m.e(batteryNotLowTracker2, "batteryNotLowTracker");
        m.e(constraintTracker2, "networkStateTracker");
        m.e(constraintTracker3, "storageNotLowTracker");
        this.batteryChargingTracker = constraintTracker;
        this.batteryNotLowTracker = batteryNotLowTracker2;
        this.networkStateTracker = constraintTracker2;
        this.storageNotLowTracker = constraintTracker3;
    }

    public /* synthetic */ Trackers(Context context, TaskExecutor taskExecutor, ConstraintTracker constraintTracker, BatteryNotLowTracker batteryNotLowTracker2, ConstraintTracker constraintTracker2, ConstraintTracker constraintTracker3, int i4, C2103g gVar) {
        BatteryChargingTracker batteryChargingTracker2;
        BatteryNotLowTracker batteryNotLowTracker3;
        ConstraintTracker<NetworkState> constraintTracker4;
        StorageNotLowTracker storageNotLowTracker2;
        TaskExecutor taskExecutor2;
        Context context2;
        Trackers trackers;
        if ((i4 & 4) != 0) {
            Context applicationContext = context.getApplicationContext();
            m.d(applicationContext, "context.applicationContext");
            batteryChargingTracker2 = new BatteryChargingTracker(applicationContext, taskExecutor);
        } else {
            batteryChargingTracker2 = constraintTracker;
        }
        if ((i4 & 8) != 0) {
            Context applicationContext2 = context.getApplicationContext();
            m.d(applicationContext2, "context.applicationContext");
            batteryNotLowTracker3 = new BatteryNotLowTracker(applicationContext2, taskExecutor);
        } else {
            batteryNotLowTracker3 = batteryNotLowTracker2;
        }
        if ((i4 & 16) != 0) {
            Context applicationContext3 = context.getApplicationContext();
            m.d(applicationContext3, "context.applicationContext");
            constraintTracker4 = NetworkStateTrackerKt.NetworkStateTracker(applicationContext3, taskExecutor);
        } else {
            constraintTracker4 = constraintTracker2;
        }
        if ((i4 & 32) != 0) {
            Context applicationContext4 = context.getApplicationContext();
            m.d(applicationContext4, "context.applicationContext");
            storageNotLowTracker2 = new StorageNotLowTracker(applicationContext4, taskExecutor);
            context2 = context;
            taskExecutor2 = taskExecutor;
            trackers = this;
        } else {
            storageNotLowTracker2 = constraintTracker3;
            trackers = this;
            context2 = context;
            taskExecutor2 = taskExecutor;
        }
        new Trackers(context2, taskExecutor2, batteryChargingTracker2, batteryNotLowTracker3, constraintTracker4, storageNotLowTracker2);
    }
}
