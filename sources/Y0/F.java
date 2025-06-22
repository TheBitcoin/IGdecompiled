package y0;

import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import v0.g;

public abstract class F {

    class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f22582a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AtomicLong f22583b;

        /* renamed from: y0.F$a$a  reason: collision with other inner class name */
        class C0273a extends C2415e {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Runnable f22584a;

            C0273a(Runnable runnable) {
                this.f22584a = runnable;
            }

            public void a() {
                this.f22584a.run();
            }
        }

        a(String str, AtomicLong atomicLong) {
            this.f22582a = str;
            this.f22583b = atomicLong;
        }

        public Thread newThread(Runnable runnable) {
            Thread newThread = Executors.defaultThreadFactory().newThread(new C0273a(runnable));
            newThread.setName(this.f22582a + this.f22583b.getAndIncrement());
            return newThread;
        }
    }

    class b extends C2415e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f22586a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ExecutorService f22587b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ long f22588c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ TimeUnit f22589d;

        b(String str, ExecutorService executorService, long j4, TimeUnit timeUnit) {
            this.f22586a = str;
            this.f22587b = executorService;
            this.f22588c = j4;
            this.f22589d = timeUnit;
        }

        public void a() {
            try {
                g f4 = g.f();
                f4.b("Executing shutdown hook for " + this.f22586a);
                this.f22587b.shutdown();
                if (!this.f22587b.awaitTermination(this.f22588c, this.f22589d)) {
                    g f5 = g.f();
                    f5.b(this.f22586a + " did not shut down in the allocated time. Requesting immediate shutdown.");
                    this.f22587b.shutdownNow();
                }
            } catch (InterruptedException unused) {
                g.f().b(String.format(Locale.US, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", new Object[]{this.f22586a}));
                this.f22587b.shutdownNow();
            }
        }
    }

    private static void a(String str, ExecutorService executorService) {
        b(str, executorService, 2, TimeUnit.SECONDS);
    }

    private static void b(String str, ExecutorService executorService, long j4, TimeUnit timeUnit) {
        Runtime runtime = Runtime.getRuntime();
        String str2 = str;
        b bVar = new b(str2, executorService, j4, timeUnit);
        runtime.addShutdownHook(new Thread(bVar, "Crashlytics Shutdown Hook for " + str2));
    }

    public static ExecutorService c(String str) {
        ExecutorService e5 = e(d(str), new ThreadPoolExecutor.DiscardPolicy());
        a(str, e5);
        return e5;
    }

    public static ThreadFactory d(String str) {
        return new a(str, new AtomicLong(1));
    }

    private static ExecutorService e(ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        return Executors.unconfigurableExecutorService(new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), threadFactory, rejectedExecutionHandler));
    }
}
