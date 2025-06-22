package androidx.work;

import android.os.Build;
import androidx.annotation.IntRange;
import androidx.annotation.RestrictTo;
import androidx.core.util.Consumer;
import androidx.work.impl.DefaultRunnableScheduler;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public final class Configuration {
    public static final Companion Companion = new Companion((C2103g) null);
    public static final int MIN_SCHEDULER_LIMIT = 20;
    private final Clock clock;
    private final int contentUriTriggerWorkersLimit;
    private final String defaultProcessName;
    private final Executor executor;
    private final Consumer<Throwable> initializationExceptionHandler;
    private final InputMergerFactory inputMergerFactory;
    private final boolean isUsingDefaultTaskExecutor;
    private final int maxJobSchedulerId;
    private final int maxSchedulerLimit;
    private final int minJobSchedulerId;
    private final int minimumLoggingLevel;
    private final RunnableScheduler runnableScheduler;
    private final Consumer<Throwable> schedulingExceptionHandler;
    private final Executor taskExecutor;
    private final WorkerFactory workerFactory;

    public static final class Companion {
        public /* synthetic */ Companion(C2103g gVar) {
            this();
        }

        private Companion() {
        }
    }

    public interface Provider {
        Configuration getWorkManagerConfiguration();
    }

    public Configuration(Builder builder) {
        int i4;
        m.e(builder, "builder");
        Executor executor$work_runtime_release = builder.getExecutor$work_runtime_release();
        boolean z4 = false;
        this.executor = executor$work_runtime_release == null ? ConfigurationKt.createDefaultExecutor(false) : executor$work_runtime_release;
        this.isUsingDefaultTaskExecutor = builder.getTaskExecutor$work_runtime_release() == null ? true : z4;
        Executor taskExecutor$work_runtime_release = builder.getTaskExecutor$work_runtime_release();
        this.taskExecutor = taskExecutor$work_runtime_release == null ? ConfigurationKt.createDefaultExecutor(true) : taskExecutor$work_runtime_release;
        Clock clock$work_runtime_release = builder.getClock$work_runtime_release();
        this.clock = clock$work_runtime_release == null ? new SystemClock() : clock$work_runtime_release;
        WorkerFactory workerFactory$work_runtime_release = builder.getWorkerFactory$work_runtime_release();
        if (workerFactory$work_runtime_release == null) {
            workerFactory$work_runtime_release = WorkerFactory.getDefaultWorkerFactory();
            m.d(workerFactory$work_runtime_release, "getDefaultWorkerFactory()");
        }
        this.workerFactory = workerFactory$work_runtime_release;
        InputMergerFactory inputMergerFactory$work_runtime_release = builder.getInputMergerFactory$work_runtime_release();
        this.inputMergerFactory = inputMergerFactory$work_runtime_release == null ? NoOpInputMergerFactory.INSTANCE : inputMergerFactory$work_runtime_release;
        RunnableScheduler runnableScheduler$work_runtime_release = builder.getRunnableScheduler$work_runtime_release();
        this.runnableScheduler = runnableScheduler$work_runtime_release == null ? new DefaultRunnableScheduler() : runnableScheduler$work_runtime_release;
        this.minimumLoggingLevel = builder.getLoggingLevel$work_runtime_release();
        this.minJobSchedulerId = builder.getMinJobSchedulerId$work_runtime_release();
        this.maxJobSchedulerId = builder.getMaxJobSchedulerId$work_runtime_release();
        if (Build.VERSION.SDK_INT == 23) {
            i4 = builder.getMaxSchedulerLimit$work_runtime_release() / 2;
        } else {
            i4 = builder.getMaxSchedulerLimit$work_runtime_release();
        }
        this.maxSchedulerLimit = i4;
        this.initializationExceptionHandler = builder.getInitializationExceptionHandler$work_runtime_release();
        this.schedulingExceptionHandler = builder.getSchedulingExceptionHandler$work_runtime_release();
        this.defaultProcessName = builder.getDefaultProcessName$work_runtime_release();
        this.contentUriTriggerWorkersLimit = builder.getContentUriTriggerWorkersLimit$work_runtime_release();
    }

    public final Clock getClock() {
        return this.clock;
    }

    public final int getContentUriTriggerWorkersLimit() {
        return this.contentUriTriggerWorkersLimit;
    }

    public final String getDefaultProcessName() {
        return this.defaultProcessName;
    }

    public final Executor getExecutor() {
        return this.executor;
    }

    public final Consumer<Throwable> getInitializationExceptionHandler() {
        return this.initializationExceptionHandler;
    }

    public final InputMergerFactory getInputMergerFactory() {
        return this.inputMergerFactory;
    }

    public final int getMaxJobSchedulerId() {
        return this.maxJobSchedulerId;
    }

    @IntRange(from = 20, to = 50)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final int getMaxSchedulerLimit() {
        return this.maxSchedulerLimit;
    }

    public final int getMinJobSchedulerId() {
        return this.minJobSchedulerId;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final int getMinimumLoggingLevel() {
        return this.minimumLoggingLevel;
    }

    public final RunnableScheduler getRunnableScheduler() {
        return this.runnableScheduler;
    }

    public final Consumer<Throwable> getSchedulingExceptionHandler() {
        return this.schedulingExceptionHandler;
    }

    public final Executor getTaskExecutor() {
        return this.taskExecutor;
    }

    public final WorkerFactory getWorkerFactory() {
        return this.workerFactory;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final boolean isUsingDefaultTaskExecutor() {
        return this.isUsingDefaultTaskExecutor;
    }

    public static final class Builder {
        private Clock clock;
        private int contentUriTriggerWorkersLimit = ConfigurationKt.getDEFAULT_CONTENT_URI_TRIGGERS_WORKERS_LIMIT();
        private String defaultProcessName;
        private Executor executor;
        private Consumer<Throwable> initializationExceptionHandler;
        private InputMergerFactory inputMergerFactory;
        private int loggingLevel = 4;
        private int maxJobSchedulerId = Integer.MAX_VALUE;
        private int maxSchedulerLimit = 20;
        private int minJobSchedulerId;
        private RunnableScheduler runnableScheduler;
        private Consumer<Throwable> schedulingExceptionHandler;
        private Executor taskExecutor;
        private WorkerFactory workerFactory;

        public Builder() {
        }

        public final Configuration build() {
            return new Configuration(this);
        }

        public final Clock getClock$work_runtime_release() {
            return this.clock;
        }

        public final int getContentUriTriggerWorkersLimit$work_runtime_release() {
            return this.contentUriTriggerWorkersLimit;
        }

        public final String getDefaultProcessName$work_runtime_release() {
            return this.defaultProcessName;
        }

        public final Executor getExecutor$work_runtime_release() {
            return this.executor;
        }

        public final Consumer<Throwable> getInitializationExceptionHandler$work_runtime_release() {
            return this.initializationExceptionHandler;
        }

        public final InputMergerFactory getInputMergerFactory$work_runtime_release() {
            return this.inputMergerFactory;
        }

        public final int getLoggingLevel$work_runtime_release() {
            return this.loggingLevel;
        }

        public final int getMaxJobSchedulerId$work_runtime_release() {
            return this.maxJobSchedulerId;
        }

        public final int getMaxSchedulerLimit$work_runtime_release() {
            return this.maxSchedulerLimit;
        }

        public final int getMinJobSchedulerId$work_runtime_release() {
            return this.minJobSchedulerId;
        }

        public final RunnableScheduler getRunnableScheduler$work_runtime_release() {
            return this.runnableScheduler;
        }

        public final Consumer<Throwable> getSchedulingExceptionHandler$work_runtime_release() {
            return this.schedulingExceptionHandler;
        }

        public final Executor getTaskExecutor$work_runtime_release() {
            return this.taskExecutor;
        }

        public final WorkerFactory getWorkerFactory$work_runtime_release() {
            return this.workerFactory;
        }

        public final Builder setClock(Clock clock2) {
            m.e(clock2, "clock");
            this.clock = clock2;
            return this;
        }

        public final void setClock$work_runtime_release(Clock clock2) {
            this.clock = clock2;
        }

        public final Builder setContentUriTriggerWorkersLimit(int i4) {
            this.contentUriTriggerWorkersLimit = Math.max(i4, 0);
            return this;
        }

        public final void setContentUriTriggerWorkersLimit$work_runtime_release(int i4) {
            this.contentUriTriggerWorkersLimit = i4;
        }

        public final Builder setDefaultProcessName(String str) {
            m.e(str, "processName");
            this.defaultProcessName = str;
            return this;
        }

        public final void setDefaultProcessName$work_runtime_release(String str) {
            this.defaultProcessName = str;
        }

        public final Builder setExecutor(Executor executor2) {
            m.e(executor2, "executor");
            this.executor = executor2;
            return this;
        }

        public final void setExecutor$work_runtime_release(Executor executor2) {
            this.executor = executor2;
        }

        public final Builder setInitializationExceptionHandler(Consumer<Throwable> consumer) {
            m.e(consumer, "exceptionHandler");
            this.initializationExceptionHandler = consumer;
            return this;
        }

        public final void setInitializationExceptionHandler$work_runtime_release(Consumer<Throwable> consumer) {
            this.initializationExceptionHandler = consumer;
        }

        public final Builder setInputMergerFactory(InputMergerFactory inputMergerFactory2) {
            m.e(inputMergerFactory2, "inputMergerFactory");
            this.inputMergerFactory = inputMergerFactory2;
            return this;
        }

        public final void setInputMergerFactory$work_runtime_release(InputMergerFactory inputMergerFactory2) {
            this.inputMergerFactory = inputMergerFactory2;
        }

        public final Builder setJobSchedulerJobIdRange(int i4, int i5) {
            if (i5 - i4 >= 1000) {
                this.minJobSchedulerId = i4;
                this.maxJobSchedulerId = i5;
                return this;
            }
            throw new IllegalArgumentException("WorkManager needs a range of at least 1000 job ids.");
        }

        public final void setLoggingLevel$work_runtime_release(int i4) {
            this.loggingLevel = i4;
        }

        public final void setMaxJobSchedulerId$work_runtime_release(int i4) {
            this.maxJobSchedulerId = i4;
        }

        public final Builder setMaxSchedulerLimit(int i4) {
            if (i4 >= 20) {
                this.maxSchedulerLimit = Math.min(i4, 50);
                return this;
            }
            throw new IllegalArgumentException("WorkManager needs to be able to schedule at least 20 jobs in JobScheduler.");
        }

        public final void setMaxSchedulerLimit$work_runtime_release(int i4) {
            this.maxSchedulerLimit = i4;
        }

        public final void setMinJobSchedulerId$work_runtime_release(int i4) {
            this.minJobSchedulerId = i4;
        }

        public final Builder setMinimumLoggingLevel(int i4) {
            this.loggingLevel = i4;
            return this;
        }

        public final Builder setRunnableScheduler(RunnableScheduler runnableScheduler2) {
            m.e(runnableScheduler2, "runnableScheduler");
            this.runnableScheduler = runnableScheduler2;
            return this;
        }

        public final void setRunnableScheduler$work_runtime_release(RunnableScheduler runnableScheduler2) {
            this.runnableScheduler = runnableScheduler2;
        }

        public final Builder setSchedulingExceptionHandler(Consumer<Throwable> consumer) {
            m.e(consumer, "schedulingExceptionHandler");
            this.schedulingExceptionHandler = consumer;
            return this;
        }

        public final void setSchedulingExceptionHandler$work_runtime_release(Consumer<Throwable> consumer) {
            this.schedulingExceptionHandler = consumer;
        }

        public final Builder setTaskExecutor(Executor executor2) {
            m.e(executor2, "taskExecutor");
            this.taskExecutor = executor2;
            return this;
        }

        public final void setTaskExecutor$work_runtime_release(Executor executor2) {
            this.taskExecutor = executor2;
        }

        public final Builder setWorkerFactory(WorkerFactory workerFactory2) {
            m.e(workerFactory2, "workerFactory");
            this.workerFactory = workerFactory2;
            return this;
        }

        public final void setWorkerFactory$work_runtime_release(WorkerFactory workerFactory2) {
            this.workerFactory = workerFactory2;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder(Configuration configuration) {
            m.e(configuration, "configuration");
            this.executor = configuration.getExecutor();
            this.workerFactory = configuration.getWorkerFactory();
            this.inputMergerFactory = configuration.getInputMergerFactory();
            this.taskExecutor = configuration.getTaskExecutor();
            this.clock = configuration.getClock();
            this.loggingLevel = configuration.getMinimumLoggingLevel();
            this.minJobSchedulerId = configuration.getMinJobSchedulerId();
            this.maxJobSchedulerId = configuration.getMaxJobSchedulerId();
            this.maxSchedulerLimit = configuration.getMaxSchedulerLimit();
            this.runnableScheduler = configuration.getRunnableScheduler();
            this.initializationExceptionHandler = configuration.getInitializationExceptionHandler();
            this.schedulingExceptionHandler = configuration.getSchedulingExceptionHandler();
            this.defaultProcessName = configuration.getDefaultProcessName();
        }
    }
}
