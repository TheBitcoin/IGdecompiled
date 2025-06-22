package androidx.work.impl;

import androidx.work.WorkInfo;
import androidx.work.WorkerParameters;
import kotlin.jvm.internal.m;

public abstract /* synthetic */ class g {
    public static void a(WorkLauncher workLauncher, StartStopToken startStopToken) {
        m.e(startStopToken, "workSpecId");
        workLauncher.startWork(startStopToken, (WorkerParameters.RuntimeExtras) null);
    }

    public static void b(WorkLauncher workLauncher, StartStopToken startStopToken) {
        m.e(startStopToken, "workSpecId");
        workLauncher.stopWork(startStopToken, WorkInfo.STOP_REASON_UNKNOWN);
    }

    public static void c(WorkLauncher workLauncher, StartStopToken startStopToken, int i4) {
        m.e(startStopToken, "workSpecId");
        workLauncher.stopWork(startStopToken, i4);
    }
}
