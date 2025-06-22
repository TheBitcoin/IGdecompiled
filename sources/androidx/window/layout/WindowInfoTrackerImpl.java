package androidx.window.layout;

import V2.d;
import android.app.Activity;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import r3.C1035e;
import r3.C1037g;

public final class WindowInfoTrackerImpl implements WindowInfoTracker {
    private static final int BUFFER_CAPACITY = 10;
    public static final Companion Companion = new Companion((C2103g) null);
    /* access modifiers changed from: private */
    public final WindowBackend windowBackend;
    private final WindowMetricsCalculator windowMetricsCalculator;

    public static final class Companion {
        public /* synthetic */ Companion(C2103g gVar) {
            this();
        }

        private Companion() {
        }
    }

    public WindowInfoTrackerImpl(WindowMetricsCalculator windowMetricsCalculator2, WindowBackend windowBackend2) {
        m.e(windowMetricsCalculator2, "windowMetricsCalculator");
        m.e(windowBackend2, "windowBackend");
        this.windowMetricsCalculator = windowMetricsCalculator2;
        this.windowBackend = windowBackend2;
    }

    public C1035e windowLayoutInfo(Activity activity) {
        m.e(activity, "activity");
        return C1037g.r(new WindowInfoTrackerImpl$windowLayoutInfo$1(this, activity, (d) null));
    }
}
