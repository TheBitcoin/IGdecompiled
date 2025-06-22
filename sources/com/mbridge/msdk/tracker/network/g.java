package com.mbridge.msdk.tracker.network;

import android.os.Handler;
import java.util.concurrent.Executor;

public final class g implements x {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f15530a;

    private static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final u f15533a;

        /* renamed from: b  reason: collision with root package name */
        private final w f15534b;

        /* renamed from: c  reason: collision with root package name */
        private final Runnable f15535c;

        public a(u uVar, w wVar, Runnable runnable) {
            this.f15533a = uVar;
            this.f15534b = wVar;
            this.f15535c = runnable;
        }

        public final void run() {
            if (this.f15533a.n()) {
                this.f15533a.c("canceled-at-delivery");
                return;
            }
            w wVar = this.f15534b;
            ad adVar = wVar.f15667c;
            if (adVar == null) {
                this.f15533a.a(wVar.f15665a);
            } else {
                this.f15533a.b(adVar);
            }
            if (!this.f15534b.f15668d) {
                this.f15533a.c("done");
            }
            Runnable runnable = this.f15535c;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public g(final Handler handler) {
        this.f15530a = new Executor() {
            public final void execute(Runnable runnable) {
                handler.post(runnable);
            }
        };
    }

    public final void a(u<?> uVar, ad adVar) {
        this.f15530a.execute(new a(uVar, w.a(adVar), (Runnable) null));
    }

    public g(Executor executor) {
        this.f15530a = executor;
    }

    public final void a(u<?> uVar, w<?> wVar) {
        uVar.w();
        this.f15530a.execute(new a(uVar, wVar, (Runnable) null));
    }
}
