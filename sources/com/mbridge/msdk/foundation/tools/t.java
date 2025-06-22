package com.mbridge.msdk.foundation.tools;

import com.mbridge.msdk.MBridgeConstans;
import java.util.concurrent.Executor;

public final class t implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private Runnable f13685a;

    /* renamed from: b  reason: collision with root package name */
    private Runnable f13686b;

    public final synchronized void execute(Runnable runnable) {
        try {
            if (this.f13685a == null) {
                this.f13685a = a(runnable);
                r.a().execute(this.f13685a);
            } else if (this.f13686b == null) {
                this.f13686b = a(runnable);
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    private Runnable a(final Runnable runnable) {
        return new Runnable() {
            public final void run() {
                try {
                    runnable.run();
                } catch (Exception e5) {
                    if (MBridgeConstans.DEBUG) {
                        af.b("LimitExecutor", e5.getMessage());
                    }
                } finally {
                    t.this.a();
                }
            }
        };
    }

    /* access modifiers changed from: private */
    public synchronized void a() {
        Runnable runnable = this.f13686b;
        this.f13685a = runnable;
        this.f13686b = null;
        if (runnable != null) {
            r.a().execute(this.f13685a);
        }
    }
}
