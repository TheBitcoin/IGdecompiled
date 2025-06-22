package androidx.work.impl.constraints;

import V2.d;
import V2.g;
import androidx.work.Logger;
import androidx.work.impl.model.WorkSpec;
import kotlin.jvm.internal.m;
import o3.C1001s0;
import o3.C1012y;
import o3.G;
import o3.K;
import o3.L;

public final class WorkConstraintsTrackerKt {
    /* access modifiers changed from: private */
    public static final String TAG;

    static {
        String tagWithPrefix = Logger.tagWithPrefix("WorkConstraintsTracker");
        m.d(tagWithPrefix, "tagWithPrefix(\"WorkConstraintsTracker\")");
        TAG = tagWithPrefix;
    }

    public static final C1001s0 listen(WorkConstraintsTracker workConstraintsTracker, WorkSpec workSpec, G g4, OnConstraintsStateChangedListener onConstraintsStateChangedListener) {
        m.e(workConstraintsTracker, "<this>");
        m.e(workSpec, "spec");
        m.e(g4, "dispatcher");
        m.e(onConstraintsStateChangedListener, "listener");
        C1012y b5 = C1013y0.b((C1001s0) null, 1, (Object) null);
        C1001s0 unused = C0981i.d(K.a(g4.plus(b5)), (g) null, (L) null, new WorkConstraintsTrackerKt$listen$1(workConstraintsTracker, workSpec, onConstraintsStateChangedListener, (d) null), 3, (Object) null);
        return b5;
    }
}
