package com.mbridge.msdk.tracker.network;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

public final class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final BlockingQueue<u<?>> f15549a;

    /* renamed from: b  reason: collision with root package name */
    private final n f15550b;

    /* renamed from: c  reason: collision with root package name */
    private final b f15551c;

    /* renamed from: d  reason: collision with root package name */
    private final x f15552d;

    /* renamed from: e  reason: collision with root package name */
    private volatile boolean f15553e = false;

    public o(BlockingQueue<u<?>> blockingQueue, n nVar, b bVar, x xVar) {
        this.f15549a = blockingQueue;
        this.f15550b = nVar;
        this.f15551c = bVar;
        this.f15552d = xVar;
    }

    public final void run() {
        Process.setThreadPriority(10);
        while (true) {
            u take = this.f15549a.take();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            take.b(3);
            try {
                if (take.n()) {
                    take.c("network-discard-cancelled");
                    take.y();
                } else {
                    TrafficStats.setThreadStatsTag(take.j());
                    r a5 = this.f15550b.a(take);
                    if (!a5.f15604e || !take.x()) {
                        w a6 = take.a(a5);
                        if (take.r() && a6.f15666b != null) {
                            this.f15551c.a(take.l(), a6.f15666b);
                        }
                        take.w();
                        this.f15552d.a((u<?>) take, (w<?>) a6);
                        take.a((w<?>) a6);
                    } else {
                        take.c("not-modified");
                        take.y();
                    }
                }
            } catch (ad e5) {
                e5.a(SystemClock.elapsedRealtime() - elapsedRealtime);
                this.f15552d.a((u<?>) take, e5);
                take.y();
            } catch (Exception e6) {
                ae.a(e6, "Unhandled exception %s", e6.toString());
                ac acVar = new ac((Throwable) e6);
                acVar.a(SystemClock.elapsedRealtime() - elapsedRealtime);
                this.f15552d.a((u<?>) take, (ad) acVar);
                take.y();
            }
            try {
                take.b(4);
            } catch (InterruptedException unused) {
                if (this.f15553e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                ae.c("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            } catch (Throwable th) {
                take.b(4);
                throw th;
            }
        }
    }
}
