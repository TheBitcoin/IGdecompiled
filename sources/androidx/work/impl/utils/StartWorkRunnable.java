package androidx.work.impl.utils;

import androidx.annotation.RestrictTo;
import androidx.work.WorkerParameters;
import androidx.work.impl.Processor;
import androidx.work.impl.StartStopToken;
import kotlin.jvm.internal.m;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class StartWorkRunnable implements Runnable {
    private final Processor processor;
    private final WorkerParameters.RuntimeExtras runtimeExtras;
    private final StartStopToken startStopToken;

    public StartWorkRunnable(Processor processor2, StartStopToken startStopToken2, WorkerParameters.RuntimeExtras runtimeExtras2) {
        m.e(processor2, "processor");
        m.e(startStopToken2, "startStopToken");
        this.processor = processor2;
        this.startStopToken = startStopToken2;
        this.runtimeExtras = runtimeExtras2;
    }

    public void run() {
        this.processor.startWork(this.startStopToken, this.runtimeExtras);
    }
}
