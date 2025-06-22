package com.mbridge.msdk.foundation.same.f;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static ThreadPoolExecutor f13236a;

    /* renamed from: b  reason: collision with root package name */
    private static ThreadPoolExecutor f13237b;

    /* renamed from: c  reason: collision with root package name */
    private static Handler f13238c;

    /* renamed from: d  reason: collision with root package name */
    private static ThreadPoolExecutor f13239d;

    /* renamed from: e  reason: collision with root package name */
    private static ThreadPoolExecutor f13240e;

    /* renamed from: f  reason: collision with root package name */
    private static ThreadPoolExecutor f13241f;

    /* renamed from: com.mbridge.msdk.foundation.same.f.a$a  reason: collision with other inner class name */
    private static class C0182a extends Handler {
        public C0182a() {
            super(Looper.getMainLooper());
        }

        public final void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
        }
    }

    public static ThreadPoolExecutor a() {
        if (f13237b == null) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 5, 10, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(10), new ThreadFactory() {
                public final Thread newThread(@NonNull Runnable runnable) {
                    Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
                    newThread.setName("BitmapThreadPool");
                    return newThread;
                }
            }, new ThreadPoolExecutor.DiscardPolicy());
            f13237b = threadPoolExecutor;
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        }
        return f13237b;
    }

    public static ThreadPoolExecutor b() {
        if (f13236a == null) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 25, 10, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(100), new ThreadFactory() {
                public final Thread newThread(@NonNull Runnable runnable) {
                    Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
                    newThread.setName("CommonThreadPool");
                    return newThread;
                }
            }, new ThreadPoolExecutor.DiscardPolicy());
            f13236a = threadPoolExecutor;
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        }
        return f13236a;
    }

    public static Handler c() {
        if (f13238c == null) {
            f13238c = new C0182a();
        }
        return f13238c;
    }

    public static ThreadPoolExecutor d() {
        if (f13239d == null) {
            f13239d = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(1), new ThreadFactory() {
                public final Thread newThread(@NonNull Runnable runnable) {
                    Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
                    newThread.setName("NwtThreadPool");
                    return newThread;
                }
            }, new ThreadPoolExecutor.DiscardPolicy());
        }
        return f13239d;
    }

    public static ThreadPoolExecutor e() {
        if (f13240e == null) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 15, 10, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(100), new ThreadFactory() {
                public final Thread newThread(@NonNull Runnable runnable) {
                    Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
                    newThread.setName("ReportThreadPool");
                    return newThread;
                }
            }, new ThreadPoolExecutor.DiscardPolicy());
            f13240e = threadPoolExecutor;
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        }
        return f13240e;
    }

    public static ThreadPoolExecutor f() {
        if (f13241f == null) {
            AnonymousClass5 r8 = new ThreadFactory() {
                public final Thread newThread(@NonNull Runnable runnable) {
                    Thread thread = new Thread(runnable);
                    thread.setName("rv-load-tread");
                    return thread;
                }
            };
            int availableProcessors = Runtime.getRuntime().availableProcessors();
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(availableProcessors, availableProcessors * 2, 10, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(30), r8, new ThreadPoolExecutor.DiscardPolicy());
            f13241f = threadPoolExecutor;
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        }
        return f13241f;
    }
}
