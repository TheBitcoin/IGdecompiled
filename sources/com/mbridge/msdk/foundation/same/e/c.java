package com.mbridge.msdk.foundation.same.e;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static volatile ThreadPoolExecutor f13235a;

    private static int a(int i4, String str) {
        try {
            int a5 = ah.a().a(str, i4);
            if (a5 <= 0) {
                return i4;
            }
            return a5;
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                af.b("CommonTaskLoaderThreadPool", e5.getMessage());
            }
        }
    }

    public static ThreadPoolExecutor a() {
        if (f13235a == null) {
            int a5 = a(10, "c_t_l_t_p_c");
            int a6 = a(50, "c_t_l_t_p_m");
            int a7 = a(5, "c_t_l_t_p_t");
            int i4 = a6 < a5 ? a5 : a6;
            try {
                if (MBridgeConstans.DEBUG) {
                    af.a("CommonTaskLoaderThreadPool", "create ThreadPoolExecutor for core " + a5 + " max " + i4 + " timeout " + a7);
                }
                long j4 = (long) a7;
                if (j4 <= 0) {
                    j4 = 1;
                }
                f13235a = new ThreadPoolExecutor(a5, i4, j4, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadFactory() {
                    public final Thread newThread(Runnable runnable) {
                        Thread thread = new Thread(runnable);
                        thread.setName("mb-task-loader-thread");
                        return thread;
                    }
                }, new ThreadPoolExecutor.DiscardPolicy());
                f13235a.allowCoreThreadTimeOut(true);
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b("CommonTaskLoaderThreadPool", "create ThreadPoolExecutor failed ", e5);
                }
            }
        }
        if (f13235a == null) {
            int availableProcessors = (Runtime.getRuntime().availableProcessors() * 2) + 1;
            f13235a = new ThreadPoolExecutor(availableProcessors, availableProcessors, 10, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new ThreadFactory() {
                public final Thread newThread(Runnable runnable) {
                    Thread thread = new Thread(runnable);
                    thread.setName("mb-task-loader-thread");
                    return thread;
                }
            }, new ThreadPoolExecutor.DiscardPolicy());
            f13235a.allowCoreThreadTimeOut(true);
        }
        return f13235a;
    }
}
