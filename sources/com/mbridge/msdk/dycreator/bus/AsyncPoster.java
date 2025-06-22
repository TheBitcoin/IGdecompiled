package com.mbridge.msdk.dycreator.bus;

class AsyncPoster implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final PendingPostQueue f12585a = new PendingPostQueue();

    /* renamed from: b  reason: collision with root package name */
    private final EventBus f12586b;

    AsyncPoster(EventBus eventBus) {
        this.f12586b = eventBus;
    }

    public void enqueue(Subscription subscription, Object obj) {
        this.f12585a.a(PendingPost.a(subscription, obj));
        EventBus.f12590a.execute(this);
    }

    public void run() {
        PendingPost a5 = this.f12585a.a();
        if (a5 != null) {
            this.f12586b.a(a5);
            return;
        }
        throw new IllegalStateException("No pending post available");
    }
}
