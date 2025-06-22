package com.mbridge.msdk.foundation.same.report.b;

import android.annotation.TargetApi;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;

public class b extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f13366a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Handler f13367b = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    private volatile a f13368c;

    /* renamed from: d  reason: collision with root package name */
    private a f13369d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public int f13370e = DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS;

    private class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private long f13372b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public boolean f13373c;

        /* renamed from: d  reason: collision with root package name */
        private long f13374d;

        private a() {
            this.f13372b = SystemClock.uptimeMillis();
        }

        /* access modifiers changed from: package-private */
        public final void b() {
            this.f13373c = false;
            this.f13374d = SystemClock.uptimeMillis();
            b.this.f13367b.postAtFrontOfQueue(this);
        }

        public final void run() {
            synchronized (b.this) {
                this.f13373c = true;
                this.f13372b = SystemClock.uptimeMillis();
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean a() {
            return !this.f13373c || this.f13372b - this.f13374d >= ((long) b.this.f13370e);
        }
    }

    private b() {
        super("AnrMonitor-Thread");
    }

    @TargetApi(16)
    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            if (isInterrupted() || (this.f13368c != null && !this.f13368c.f13373c)) {
                try {
                    Thread.sleep((long) this.f13370e);
                } catch (Exception unused) {
                }
            } else {
                synchronized (this) {
                    try {
                        if (this.f13368c == null) {
                            this.f13368c = new a();
                        }
                        this.f13368c.b();
                        long j4 = (long) this.f13370e;
                        long uptimeMillis = SystemClock.uptimeMillis();
                        while (j4 > 0) {
                            wait(j4);
                            j4 = ((long) this.f13370e) - (SystemClock.uptimeMillis() - uptimeMillis);
                        }
                        if (!this.f13368c.a()) {
                            a aVar = this.f13369d;
                            if (aVar != null) {
                                aVar.a();
                            }
                        } else if (!Debug.isDebuggerConnected() && !Debug.waitingForDebugger() && this.f13369d != null) {
                            StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
                            this.f13369d.a(c.a(stackTrace), stackTrace);
                        }
                    } catch (InterruptedException e5) {
                        Log.w("AnrMonitor", e5.toString());
                    } catch (Throwable th) {
                        while (true) {
                            throw th;
                        }
                    }
                }
            }
        }
    }

    public static b a() {
        if (f13366a == null) {
            synchronized (b.class) {
                try {
                    if (f13366a == null) {
                        f13366a = new b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f13366a;
    }

    public final b a(int i4, a aVar) {
        this.f13370e = i4;
        this.f13369d = aVar;
        return this;
    }
}
