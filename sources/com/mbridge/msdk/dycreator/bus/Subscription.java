package com.mbridge.msdk.dycreator.bus;

final class Subscription {

    /* renamed from: a  reason: collision with root package name */
    final Object f12626a;

    /* renamed from: b  reason: collision with root package name */
    final SubscriberMethod f12627b;

    Subscription(Object obj, SubscriberMethod subscriberMethod) {
        this.f12626a = obj;
        this.f12627b = subscriberMethod;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Subscription) {
            Subscription subscription = (Subscription) obj;
            if (this.f12626a != subscription.f12626a || !this.f12627b.equals(subscription.f12627b)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f12626a.hashCode() + this.f12627b.f12623d.hashCode();
    }
}
