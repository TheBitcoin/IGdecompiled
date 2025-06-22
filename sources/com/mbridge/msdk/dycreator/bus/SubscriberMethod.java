package com.mbridge.msdk.dycreator.bus;

import java.lang.reflect.Method;

final class SubscriberMethod {

    /* renamed from: a  reason: collision with root package name */
    final Method f12620a;

    /* renamed from: b  reason: collision with root package name */
    final ThreadMode f12621b;

    /* renamed from: c  reason: collision with root package name */
    final Class<?> f12622c;

    /* renamed from: d  reason: collision with root package name */
    String f12623d;

    SubscriberMethod(Method method, ThreadMode threadMode, Class<?> cls) {
        this.f12620a = method;
        this.f12621b = threadMode;
        this.f12622c = cls;
    }

    private synchronized void a() {
        if (this.f12623d == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(this.f12620a.getDeclaringClass().getName());
            sb.append('#');
            sb.append(this.f12620a.getName());
            sb.append('(');
            sb.append(this.f12622c.getName());
            this.f12623d = sb.toString();
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof SubscriberMethod)) {
            return false;
        }
        a();
        return this.f12623d.equals(((SubscriberMethod) obj).f12623d);
    }

    public final int hashCode() {
        return this.f12620a.hashCode();
    }
}
