package androidx.work.impl.constraints.trackers;

import R2.s;
import S2.C1601o;
import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.jvm.internal.m;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class ConstraintTracker<T> {
    private final Context appContext;
    private T currentState;
    private final LinkedHashSet<ConstraintListener<T>> listeners = new LinkedHashSet<>();
    private final Object lock = new Object();
    private final TaskExecutor taskExecutor;

    protected ConstraintTracker(Context context, TaskExecutor taskExecutor2) {
        m.e(context, "context");
        m.e(taskExecutor2, "taskExecutor");
        this.taskExecutor = taskExecutor2;
        Context applicationContext = context.getApplicationContext();
        m.d(applicationContext, "context.applicationContext");
        this.appContext = applicationContext;
    }

    /* access modifiers changed from: private */
    public static final void _set_state_$lambda$4$lambda$3(List list, ConstraintTracker constraintTracker) {
        m.e(list, "$listenersList");
        m.e(constraintTracker, "this$0");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((ConstraintListener) it.next()).onConstraintChanged(constraintTracker.currentState);
        }
    }

    public final void addListener(ConstraintListener<T> constraintListener) {
        m.e(constraintListener, "listener");
        synchronized (this.lock) {
            try {
                if (this.listeners.add(constraintListener)) {
                    if (this.listeners.size() == 1) {
                        this.currentState = readSystemState();
                        Logger logger = Logger.get();
                        String access$getTAG$p = ConstraintTrackerKt.TAG;
                        logger.debug(access$getTAG$p, getClass().getSimpleName() + ": initial state = " + this.currentState);
                        startTracking();
                    }
                    constraintListener.onConstraintChanged(this.currentState);
                }
                s sVar = s.f8222a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final Context getAppContext() {
        return this.appContext;
    }

    public final T getState() {
        T t4 = this.currentState;
        if (t4 == null) {
            return readSystemState();
        }
        return t4;
    }

    public abstract T readSystemState();

    public final void removeListener(ConstraintListener<T> constraintListener) {
        m.e(constraintListener, "listener");
        synchronized (this.lock) {
            try {
                if (this.listeners.remove(constraintListener) && this.listeners.isEmpty()) {
                    stopTracking();
                }
                s sVar = s.f8222a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void setState(T t4) {
        synchronized (this.lock) {
            T t5 = this.currentState;
            if (t5 == null || !m.a(t5, t4)) {
                this.currentState = t4;
                this.taskExecutor.getMainThreadExecutor().execute(new a(C1601o.Z(this.listeners), this));
                s sVar = s.f8222a;
            }
        }
    }

    public abstract void startTracking();

    public abstract void stopTracking();
}
