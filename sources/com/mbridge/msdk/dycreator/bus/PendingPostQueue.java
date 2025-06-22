package com.mbridge.msdk.dycreator.bus;

final class PendingPostQueue {

    /* renamed from: a  reason: collision with root package name */
    private PendingPost f12618a;

    /* renamed from: b  reason: collision with root package name */
    private PendingPost f12619b;

    PendingPostQueue() {
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(PendingPost pendingPost) {
        if (pendingPost != null) {
            try {
                PendingPost pendingPost2 = this.f12619b;
                if (pendingPost2 != null) {
                    pendingPost2.f12617c = pendingPost;
                    this.f12619b = pendingPost;
                } else if (this.f12618a == null) {
                    this.f12619b = pendingPost;
                    this.f12618a = pendingPost;
                } else {
                    throw new IllegalStateException("Head present, but no tail");
                }
                notifyAll();
            } catch (Throwable th) {
                throw th;
            }
        } else {
            throw new NullPointerException("null cannot be enqueued");
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized PendingPost a() {
        PendingPost pendingPost;
        pendingPost = this.f12618a;
        if (pendingPost != null) {
            PendingPost pendingPost2 = pendingPost.f12617c;
            this.f12618a = pendingPost2;
            if (pendingPost2 == null) {
                this.f12619b = null;
            }
        }
        return pendingPost;
    }

    /* access modifiers changed from: package-private */
    public final synchronized PendingPost a(int i4) throws InterruptedException {
        try {
            if (this.f12618a == null) {
                wait((long) i4);
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return a();
    }
}
