package androidx.work.impl;

import androidx.work.WorkerParameters;
import androidx.work.impl.utils.StartWorkRunnable;
import androidx.work.impl.utils.StopWorkRunnable;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import kotlin.jvm.internal.m;

public final class WorkLauncherImpl implements WorkLauncher {
    private final Processor processor;
    private final TaskExecutor workTaskExecutor;

    public WorkLauncherImpl(Processor processor2, TaskExecutor taskExecutor) {
        m.e(processor2, "processor");
        m.e(taskExecutor, "workTaskExecutor");
        this.processor = processor2;
        this.workTaskExecutor = taskExecutor;
    }

    public final Processor getProcessor() {
        return this.processor;
    }

    public final TaskExecutor getWorkTaskExecutor() {
        return this.workTaskExecutor;
    }

    public /* synthetic */ void startWork(StartStopToken startStopToken) {
        g.a(this, startStopToken);
    }

    public /* synthetic */ void stopWork(StartStopToken startStopToken) {
        g.b(this, startStopToken);
    }

    public /* synthetic */ void stopWorkWithReason(StartStopToken startStopToken, int i4) {
        g.c(this, startStopToken, i4);
    }

    public void startWork(StartStopToken startStopToken, WorkerParameters.RuntimeExtras runtimeExtras) {
        m.e(startStopToken, "workSpecId");
        this.workTaskExecutor.executeOnTaskThread(new StartWorkRunnable(this.processor, startStopToken, runtimeExtras));
    }

    public void stopWork(StartStopToken startStopToken, int i4) {
        m.e(startStopToken, "workSpecId");
        this.workTaskExecutor.executeOnTaskThread(new StopWorkRunnable(this.processor, startStopToken, false, i4));
    }
}
