package com.mbridge.msdk.foundation.same.c;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static ThreadPoolExecutor f13218a;

    public static ThreadPoolExecutor a() {
        if (f13218a == null) {
            int availableProcessors = Runtime.getRuntime().availableProcessors();
            f13218a = new ThreadPoolExecutor(availableProcessors, availableProcessors, 10, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new ThreadFactory() {
                public final Thread newThread(Runnable runnable) {
                    Thread thread = new Thread(runnable);
                    thread.setName("mb-image-loader-thread");
                    return thread;
                }
            }, new ThreadPoolExecutor.DiscardPolicy());
        }
        f13218a.allowCoreThreadTimeOut(true);
        return f13218a;
    }
}
