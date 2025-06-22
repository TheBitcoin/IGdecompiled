package Y0;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private static final a f8818a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile a f8819b;

    /* renamed from: Y0.b$b  reason: collision with other inner class name */
    private static class C0127b implements a {
        private C0127b() {
        }

        public ExecutorService a(ThreadFactory threadFactory, c cVar) {
            return b(1, threadFactory, cVar);
        }

        public ExecutorService b(int i4, ThreadFactory threadFactory, c cVar) {
            int i5 = i4;
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i5, i4, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactory);
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            return Executors.unconfigurableExecutorService(threadPoolExecutor);
        }
    }

    static {
        C0127b bVar = new C0127b();
        f8818a = bVar;
        f8819b = bVar;
    }

    public static a a() {
        return f8819b;
    }
}
