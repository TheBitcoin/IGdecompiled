package com.mbridge.msdk.newreward.a.c;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.af;
import java.util.HashMap;
import java.util.Map;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f14354a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, c> f14355b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private Handler f14356c;

    /* renamed from: com.mbridge.msdk.newreward.a.c.a$a  reason: collision with other inner class name */
    public interface C0192a {
        void a(String str, long j4);
    }

    private static final class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final String f14357a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final long f14358b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public boolean f14359c;

        public b(String str, long j4) {
            this.f14357a = str;
            this.f14358b = j4;
        }
    }

    public static class c implements Runnable {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final b f14360a;

        /* renamed from: b  reason: collision with root package name */
        private final C0192a f14361b;

        public c(b bVar, C0192a aVar) {
            this.f14360a = bVar;
            this.f14361b = aVar;
        }

        public final void run() {
            C0192a aVar;
            if (MBridgeConstans.DEBUG) {
                af.a("MBridgeTimer", "TimerTask run taskID: " + this.f14360a.f14357a + " isStop: " + this.f14360a.f14359c);
            }
            if (!this.f14360a.f14359c && (aVar = this.f14361b) != null) {
                try {
                    aVar.a(this.f14360a.f14357a, this.f14360a.f14358b);
                } catch (Exception unused) {
                }
            }
        }
    }

    public a() {
        HandlerThread handlerThread = new HandlerThread("MBridgeTimerThread");
        handlerThread.start();
        this.f14356c = new Handler(handlerThread.getLooper());
    }

    public static a a() {
        if (f14354a == null) {
            synchronized (a.class) {
                try {
                    if (f14354a == null) {
                        f14354a = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f14354a;
    }

    public final void a(String str, long j4, C0192a aVar) {
        if (!TextUtils.isEmpty(str)) {
            if (MBridgeConstans.DEBUG) {
                af.a("MBridgeTimer", "startTimer taskID: " + str + " timeout: " + j4);
            }
            if (!this.f14355b.containsKey(str)) {
                c cVar = new c(new b(str, j4), aVar);
                this.f14355b.put(str, cVar);
                this.f14356c.postDelayed(cVar, j4);
            }
        }
    }

    public final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            c remove = this.f14355b.remove(str);
            if (MBridgeConstans.DEBUG) {
                af.a("MBridgeTimer", "stopTimer taskID: " + str);
            }
            if (remove != null) {
                boolean unused = remove.f14360a.f14359c = true;
                this.f14356c.removeCallbacks(remove);
            }
        }
    }
}
