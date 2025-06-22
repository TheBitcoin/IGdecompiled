package androidx.work.impl.utils.taskexecutor;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.impl.utils.SerialExecutorImpl;
import java.util.concurrent.Executor;
import o3.C0986k0;
import o3.G;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class WorkManagerTaskExecutor implements TaskExecutor {
    private final SerialExecutorImpl mBackgroundExecutor;
    private final Executor mMainThreadExecutor = new Executor() {
        public void execute(@NonNull Runnable runnable) {
            WorkManagerTaskExecutor.this.mMainThreadHandler.post(runnable);
        }
    };
    final Handler mMainThreadHandler = new Handler(Looper.getMainLooper());
    private final G mTaskDispatcher;

    public WorkManagerTaskExecutor(@NonNull Executor executor) {
        SerialExecutorImpl serialExecutorImpl = new SerialExecutorImpl(executor);
        this.mBackgroundExecutor = serialExecutorImpl;
        this.mTaskDispatcher = C0986k0.a(serialExecutorImpl);
    }

    public /* synthetic */ void executeOnTaskThread(Runnable runnable) {
        a.a(this, runnable);
    }

    @NonNull
    public Executor getMainThreadExecutor() {
        return this.mMainThreadExecutor;
    }

    @NonNull
    public G getTaskCoroutineDispatcher() {
        return this.mTaskDispatcher;
    }

    @NonNull
    public SerialExecutorImpl getSerialTaskExecutor() {
        return this.mBackgroundExecutor;
    }
}
