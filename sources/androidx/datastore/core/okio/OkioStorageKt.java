package androidx.datastore.core.okio;

import N3.Q;
import androidx.datastore.core.InterProcessCoordinator;
import androidx.datastore.core.InterProcessCoordinatorKt;
import com.mbridge.msdk.MBridgeConstans;
import kotlin.jvm.internal.m;

public final class OkioStorageKt {
    public static final InterProcessCoordinator createSingleProcessCoordinator(Q q4) {
        m.e(q4, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
        return InterProcessCoordinatorKt.createSingleProcessCoordinator(q4.h().toString());
    }
}
