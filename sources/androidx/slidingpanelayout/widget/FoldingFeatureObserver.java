package androidx.slidingpanelayout.widget;

import V2.d;
import V2.g;
import android.app.Activity;
import androidx.window.layout.DisplayFeature;
import androidx.window.layout.FoldingFeature;
import androidx.window.layout.WindowInfoTracker;
import androidx.window.layout.WindowLayoutInfo;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.m;
import o3.C0986k0;
import o3.C1001s0;
import o3.K;
import o3.L;

public final class FoldingFeatureObserver {
    private final Executor executor;
    private C1001s0 job;
    /* access modifiers changed from: private */
    public OnFoldingFeatureChangeListener onFoldingFeatureChangeListener;
    /* access modifiers changed from: private */
    public final WindowInfoTracker windowInfoTracker;

    public interface OnFoldingFeatureChangeListener {
        void onFoldingFeatureChange(FoldingFeature foldingFeature);
    }

    public FoldingFeatureObserver(WindowInfoTracker windowInfoTracker2, Executor executor2) {
        m.e(windowInfoTracker2, "windowInfoTracker");
        m.e(executor2, "executor");
        this.windowInfoTracker = windowInfoTracker2;
        this.executor = executor2;
    }

    /* access modifiers changed from: private */
    public final FoldingFeature getFoldingFeature(WindowLayoutInfo windowLayoutInfo) {
        Object obj;
        Iterator it = windowLayoutInfo.getDisplayFeatures().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((DisplayFeature) obj) instanceof FoldingFeature) {
                break;
            }
        }
        if (obj instanceof FoldingFeature) {
            return (FoldingFeature) obj;
        }
        return null;
    }

    public final void registerLayoutStateChangeCallback(Activity activity) {
        m.e(activity, "activity");
        C1001s0 s0Var = this.job;
        if (s0Var != null) {
            C1001s0.a.a(s0Var, (CancellationException) null, 1, (Object) null);
        }
        this.job = C0981i.d(K.a(C0986k0.a(this.executor)), (g) null, (L) null, new FoldingFeatureObserver$registerLayoutStateChangeCallback$1(this, activity, (d) null), 3, (Object) null);
    }

    public final void setOnFoldingFeatureChangeListener(OnFoldingFeatureChangeListener onFoldingFeatureChangeListener2) {
        m.e(onFoldingFeatureChangeListener2, "onFoldingFeatureChangeListener");
        this.onFoldingFeatureChangeListener = onFoldingFeatureChangeListener2;
    }

    public final void unregisterLayoutStateChangeCallback() {
        C1001s0 s0Var = this.job;
        if (s0Var != null) {
            C1001s0.a.a(s0Var, (CancellationException) null, 1, (Object) null);
        }
    }
}
