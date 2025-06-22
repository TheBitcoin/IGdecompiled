package androidx.work.impl.utils.taskexecutor;

import o3.C0986k0;
import o3.G;

public abstract /* synthetic */ class a {
    public static void a(TaskExecutor taskExecutor, Runnable runnable) {
        taskExecutor.getSerialTaskExecutor().execute(runnable);
    }

    public static G b(TaskExecutor taskExecutor) {
        return C0986k0.a(taskExecutor.getSerialTaskExecutor());
    }
}
