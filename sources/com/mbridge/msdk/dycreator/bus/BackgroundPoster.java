package com.mbridge.msdk.dycreator.bus;

import android.util.Log;

final class BackgroundPoster implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final PendingPostQueue f12587a = new PendingPostQueue();

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f12588b;

    /* renamed from: c  reason: collision with root package name */
    private final EventBus f12589c;

    BackgroundPoster(EventBus eventBus) {
        this.f12589c = eventBus;
    }

    public final void enqueue(Subscription subscription, Object obj) {
        PendingPost a5 = PendingPost.a(subscription, obj);
        synchronized (this) {
            try {
                this.f12587a.a(a5);
                if (!this.f12588b) {
                    this.f12588b = true;
                    EventBus.f12590a.execute(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void run() {
        while (true) {
            try {
                PendingPost a5 = this.f12587a.a(1000);
                if (a5 == null) {
                    synchronized (this) {
                        a5 = this.f12587a.a();
                        if (a5 == null) {
                            this.f12588b = false;
                            this.f12588b = false;
                            return;
                        }
                    }
                }
                this.f12589c.a(a5);
            } catch (InterruptedException e5) {
                try {
                    Log.w("Event", Thread.currentThread().getName() + " was interruppted", e5);
                    this.f12588b = false;
                    return;
                } catch (Throwable th) {
                    this.f12588b = false;
                    throw th;
                }
            }
        }
    }
}
