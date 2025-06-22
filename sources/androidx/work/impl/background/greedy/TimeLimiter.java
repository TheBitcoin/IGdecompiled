package androidx.work.impl.background.greedy;

import androidx.work.RunnableScheduler;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.WorkLauncher;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public final class TimeLimiter {
    private final WorkLauncher launcher;
    private final Object lock;
    private final RunnableScheduler runnableScheduler;
    private final long timeoutMs;
    private final Map<StartStopToken, Runnable> tracked;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TimeLimiter(RunnableScheduler runnableScheduler2, WorkLauncher workLauncher) {
        this(runnableScheduler2, workLauncher, 0, 4, (C2103g) null);
        m.e(runnableScheduler2, "runnableScheduler");
        m.e(workLauncher, "launcher");
    }

    /* access modifiers changed from: private */
    public static final void track$lambda$0(TimeLimiter timeLimiter, StartStopToken startStopToken) {
        m.e(timeLimiter, "this$0");
        m.e(startStopToken, "$token");
        timeLimiter.launcher.stopWork(startStopToken, 3);
    }

    public final void cancel(StartStopToken startStopToken) {
        Runnable remove;
        m.e(startStopToken, "token");
        synchronized (this.lock) {
            remove = this.tracked.remove(startStopToken);
        }
        if (remove != null) {
            this.runnableScheduler.cancel(remove);
        }
    }

    public final void track(StartStopToken startStopToken) {
        m.e(startStopToken, "token");
        a aVar = new a(this, startStopToken);
        synchronized (this.lock) {
            Runnable put = this.tracked.put(startStopToken, aVar);
        }
        this.runnableScheduler.scheduleWithDelay(this.timeoutMs, aVar);
    }

    public TimeLimiter(RunnableScheduler runnableScheduler2, WorkLauncher workLauncher, long j4) {
        m.e(runnableScheduler2, "runnableScheduler");
        m.e(workLauncher, "launcher");
        this.runnableScheduler = runnableScheduler2;
        this.launcher = workLauncher;
        this.timeoutMs = j4;
        this.lock = new Object();
        this.tracked = new LinkedHashMap();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TimeLimiter(RunnableScheduler runnableScheduler2, WorkLauncher workLauncher, long j4, int i4, C2103g gVar) {
        this(runnableScheduler2, workLauncher, (i4 & 4) != 0 ? TimeUnit.MINUTES.toMillis(90) : j4);
    }
}
