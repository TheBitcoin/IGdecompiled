package androidx.work.impl.constraints.trackers;

import androidx.work.Logger;
import kotlin.jvm.internal.m;

public final class ConstraintTrackerKt {
    /* access modifiers changed from: private */
    public static final String TAG;

    static {
        String tagWithPrefix = Logger.tagWithPrefix("ConstraintTracker");
        m.d(tagWithPrefix, "tagWithPrefix(\"ConstraintTracker\")");
        TAG = tagWithPrefix;
    }
}
