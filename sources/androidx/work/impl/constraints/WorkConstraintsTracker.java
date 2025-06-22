package androidx.work.impl.constraints;

import S2.C1601o;
import androidx.work.Logger;
import androidx.work.impl.constraints.controllers.BatteryChargingController;
import androidx.work.impl.constraints.controllers.BatteryNotLowController;
import androidx.work.impl.constraints.controllers.ConstraintController;
import androidx.work.impl.constraints.controllers.NetworkConnectedController;
import androidx.work.impl.constraints.controllers.NetworkMeteredController;
import androidx.work.impl.constraints.controllers.NetworkNotRoamingController;
import androidx.work.impl.constraints.controllers.NetworkUnmeteredController;
import androidx.work.impl.constraints.controllers.StorageNotLowController;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.m;
import r3.C1035e;
import r3.C1037g;

public final class WorkConstraintsTracker {
    private final List<ConstraintController<?>> controllers;

    public WorkConstraintsTracker(List<? extends ConstraintController<?>> list) {
        m.e(list, "controllers");
        this.controllers = list;
    }

    public final boolean areAllConstraintsMet(WorkSpec workSpec) {
        m.e(workSpec, "workSpec");
        ArrayList arrayList = new ArrayList();
        for (Object next : this.controllers) {
            if (((ConstraintController) next).isConstrained(workSpec)) {
                arrayList.add(next);
            }
        }
        if (!arrayList.isEmpty()) {
            Logger logger = Logger.get();
            String access$getTAG$p = WorkConstraintsTrackerKt.TAG;
            logger.debug(access$getTAG$p, "Work " + workSpec.id + " constrained by " + C1601o.O(arrayList, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, WorkConstraintsTracker$areAllConstraintsMet$1.INSTANCE, 31, (Object) null));
        }
        return arrayList.isEmpty();
    }

    public final C1035e track(WorkSpec workSpec) {
        m.e(workSpec, "spec");
        ArrayList arrayList = new ArrayList();
        for (Object next : this.controllers) {
            if (((ConstraintController) next).hasConstraint(workSpec)) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(C1601o.p(arrayList, 10));
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList.get(i4);
            i4++;
            arrayList2.add(((ConstraintController) obj).track());
        }
        return C1037g.k(new WorkConstraintsTracker$track$$inlined$combine$1((C1035e[]) C1601o.Z(arrayList2).toArray(new C1035e[0])));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WorkConstraintsTracker(Trackers trackers) {
        this((List<? extends ConstraintController<?>>) C1601o.k(new BatteryChargingController(trackers.getBatteryChargingTracker()), new BatteryNotLowController(trackers.getBatteryNotLowTracker()), new StorageNotLowController(trackers.getStorageNotLowTracker()), new NetworkConnectedController(trackers.getNetworkStateTracker()), new NetworkUnmeteredController(trackers.getNetworkStateTracker()), new NetworkNotRoamingController(trackers.getNetworkStateTracker()), new NetworkMeteredController(trackers.getNetworkStateTracker())));
        m.e(trackers, "trackers");
    }
}
