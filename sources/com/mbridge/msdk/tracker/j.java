package com.mbridge.msdk.tracker;

import android.util.Log;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class j {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f15468a;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f15469b;

    private static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final Runnable f15472a;

        public a(Runnable runnable) {
            this.f15472a = runnable;
        }

        public final void run() {
            if (!y.a((Object) this.f15472a)) {
                try {
                    this.f15472a.run();
                } catch (Exception e5) {
                    if (a.f15435a) {
                        Log.e("TrackManager", "execute error", e5);
                    }
                }
            }
        }
    }

    public j() {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.f15468a = new ThreadPoolExecutor(1, 1, 0, timeUnit, new LinkedBlockingQueue(), new ThreadFactory() {
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "MBridgeTrackThread");
            }
        }, new ThreadPoolExecutor.DiscardPolicy());
        this.f15469b = new ThreadPoolExecutor(1, 1, 0, timeUnit, new LinkedBlockingQueue(), new ThreadFactory() {
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "MBridgeTrackDatabaseThread");
            }
        }, new ThreadPoolExecutor.DiscardPolicy());
    }

    public final void a(Runnable runnable) {
        this.f15468a.execute(new a(runnable));
    }

    public final void b(Runnable runnable) {
        this.f15469b.execute(new a(runnable));
    }
}
