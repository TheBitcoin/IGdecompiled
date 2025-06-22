package com.mbridge.msdk.dycreator.bus;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

final class HandlerPoster extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private final PendingPostQueue f12610a = new PendingPostQueue();

    /* renamed from: b  reason: collision with root package name */
    private final int f12611b;

    /* renamed from: c  reason: collision with root package name */
    private final EventBus f12612c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f12613d;

    HandlerPoster(EventBus eventBus, Looper looper, int i4) {
        super(looper);
        this.f12612c = eventBus;
        this.f12611b = i4;
    }

    /* access modifiers changed from: package-private */
    public final void a(Subscription subscription, Object obj) {
        PendingPost a5 = PendingPost.a(subscription, obj);
        synchronized (this) {
            try {
                this.f12610a.a(a5);
                if (!this.f12613d) {
                    this.f12613d = true;
                    if (!sendMessage(obtainMessage())) {
                        throw new EventBusException("Could not send handler message");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void handleMessage(Message message) {
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            do {
                PendingPost a5 = this.f12610a.a();
                if (a5 == null) {
                    synchronized (this) {
                        a5 = this.f12610a.a();
                        if (a5 == null) {
                            this.f12613d = false;
                            return;
                        }
                    }
                }
                this.f12612c.a(a5);
            } while (SystemClock.uptimeMillis() - uptimeMillis < ((long) this.f12611b));
            if (sendMessage(obtainMessage())) {
                this.f12613d = true;
                return;
            }
            throw new EventBusException("Could not send handler message");
        } catch (Throwable th) {
            this.f12613d = false;
            throw th;
        }
    }
}
