package com.google.android.gms.measurement.internal;

import M.C0335p;
import android.os.Process;
import androidx.work.WorkRequest;
import java.util.concurrent.BlockingQueue;

final class T2 extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private final Object f2749a;

    /* renamed from: b  reason: collision with root package name */
    private final BlockingQueue f2750b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2751c = false;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ P2 f2752d;

    public T2(P2 p22, String str, BlockingQueue blockingQueue) {
        this.f2752d = p22;
        C0335p.l(str);
        C0335p.l(blockingQueue);
        this.f2749a = new Object();
        this.f2750b = blockingQueue;
        setName(str);
    }

    private final void b(InterruptedException interruptedException) {
        C0835p2 L4 = this.f2752d.a().L();
        String name = getName();
        L4.b(name + " was interrupted", interruptedException);
    }

    private final void c() {
        synchronized (this.f2752d.f2681i) {
            try {
                if (!this.f2751c) {
                    this.f2752d.f2682j.release();
                    this.f2752d.f2681i.notifyAll();
                    if (this == this.f2752d.f2675c) {
                        this.f2752d.f2675c = null;
                    } else if (this == this.f2752d.f2676d) {
                        this.f2752d.f2676d = null;
                    } else {
                        this.f2752d.a().G().a("Current scheduler thread is neither worker nor network");
                    }
                    this.f2751c = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void a() {
        synchronized (this.f2749a) {
            this.f2749a.notifyAll();
        }
    }

    public final void run() {
        int i4;
        boolean z4 = false;
        while (!z4) {
            try {
                this.f2752d.f2682j.acquire();
                z4 = true;
            } catch (InterruptedException e5) {
                b(e5);
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                Q2 q22 = (Q2) this.f2750b.poll();
                if (q22 != null) {
                    if (q22.f2693b) {
                        i4 = threadPriority;
                    } else {
                        i4 = 10;
                    }
                    Process.setThreadPriority(i4);
                    q22.run();
                } else {
                    synchronized (this.f2749a) {
                        if (this.f2750b.peek() == null && !this.f2752d.f2683k) {
                            try {
                                this.f2749a.wait(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
                            } catch (InterruptedException e6) {
                                b(e6);
                            }
                        }
                    }
                    synchronized (this.f2752d.f2681i) {
                        if (this.f2750b.peek() == null) {
                            c();
                            c();
                            return;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            c();
            throw th;
        }
    }
}
