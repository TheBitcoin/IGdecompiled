package androidx.work.impl.constraints.trackers;

import androidx.work.Logger;
import kotlin.jvm.internal.m;

public final class BatteryChargingTrackerKt {
    /* access modifiers changed from: private */
    public static final String TAG;

    static {
        String tagWithPrefix = Logger.tagWithPrefix("BatteryChrgTracker");
        m.d(tagWithPrefix, "tagWithPrefix(\"BatteryChrgTracker\")");
        TAG = tagWithPrefix;
    }
}
