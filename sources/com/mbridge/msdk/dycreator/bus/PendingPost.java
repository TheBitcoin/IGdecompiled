package com.mbridge.msdk.dycreator.bus;

import java.util.ArrayList;
import java.util.List;

final class PendingPost {

    /* renamed from: d  reason: collision with root package name */
    private static final List<PendingPost> f12614d = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    Object f12615a;

    /* renamed from: b  reason: collision with root package name */
    Subscription f12616b;

    /* renamed from: c  reason: collision with root package name */
    PendingPost f12617c;

    private PendingPost(Object obj, Subscription subscription) {
        this.f12615a = obj;
        this.f12616b = subscription;
    }

    static PendingPost a(Subscription subscription, Object obj) {
        List<PendingPost> list = f12614d;
        synchronized (list) {
            try {
                int size = list.size();
                if (size <= 0) {
                    return new PendingPost(obj, subscription);
                }
                PendingPost remove = list.remove(size - 1);
                remove.f12615a = obj;
                remove.f12616b = subscription;
                remove.f12617c = null;
                return remove;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    static void a(PendingPost pendingPost) {
        pendingPost.f12615a = null;
        pendingPost.f12616b = null;
        pendingPost.f12617c = null;
        List<PendingPost> list = f12614d;
        synchronized (list) {
            try {
                if (list.size() < 10000) {
                    list.add(pendingPost);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
