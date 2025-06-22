package androidx.activity;

import R2.s;
import androidx.annotation.GuardedBy;
import androidx.annotation.RestrictTo;
import d3.a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.m;

public final class FullyDrawnReporter {
    private final Executor executor;
    private final Object lock = new Object();
    @GuardedBy("lock")
    private final List<a> onReportCallbacks = new ArrayList();
    private final a reportFullyDrawn;
    @GuardedBy("lock")
    private boolean reportPosted;
    private final Runnable reportRunnable = new j(this);
    @GuardedBy("lock")
    private boolean reportedFullyDrawn;
    @GuardedBy("lock")
    private int reporterCount;

    public FullyDrawnReporter(Executor executor2, a aVar) {
        m.e(executor2, "executor");
        m.e(aVar, "reportFullyDrawn");
        this.executor = executor2;
        this.reportFullyDrawn = aVar;
    }

    private final void postWhenReportersAreDone() {
        if (!this.reportPosted && this.reporterCount == 0) {
            this.reportPosted = true;
            this.executor.execute(this.reportRunnable);
        }
    }

    /* access modifiers changed from: private */
    public static final void reportRunnable$lambda$2(FullyDrawnReporter fullyDrawnReporter) {
        m.e(fullyDrawnReporter, "this$0");
        synchronized (fullyDrawnReporter.lock) {
            try {
                fullyDrawnReporter.reportPosted = false;
                if (fullyDrawnReporter.reporterCount == 0 && !fullyDrawnReporter.reportedFullyDrawn) {
                    fullyDrawnReporter.reportFullyDrawn.invoke();
                    fullyDrawnReporter.fullyDrawnReported();
                }
                s sVar = s.f8222a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void addOnReportDrawnListener(a aVar) {
        boolean z4;
        m.e(aVar, "callback");
        synchronized (this.lock) {
            if (this.reportedFullyDrawn) {
                z4 = true;
            } else {
                this.onReportCallbacks.add(aVar);
                z4 = false;
            }
        }
        if (z4) {
            aVar.invoke();
        }
    }

    public final void addReporter() {
        synchronized (this.lock) {
            try {
                if (!this.reportedFullyDrawn) {
                    this.reporterCount++;
                }
                s sVar = s.f8222a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void fullyDrawnReported() {
        synchronized (this.lock) {
            try {
                this.reportedFullyDrawn = true;
                for (a invoke : this.onReportCallbacks) {
                    invoke.invoke();
                }
                this.onReportCallbacks.clear();
                s sVar = s.f8222a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean isFullyDrawnReported() {
        boolean z4;
        synchronized (this.lock) {
            z4 = this.reportedFullyDrawn;
        }
        return z4;
    }

    public final void removeOnReportDrawnListener(a aVar) {
        m.e(aVar, "callback");
        synchronized (this.lock) {
            this.onReportCallbacks.remove(aVar);
            s sVar = s.f8222a;
        }
    }

    public final void removeReporter() {
        int i4;
        synchronized (this.lock) {
            try {
                if (!this.reportedFullyDrawn && (i4 = this.reporterCount) > 0) {
                    this.reporterCount = i4 - 1;
                    postWhenReportersAreDone();
                }
                s sVar = s.f8222a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
