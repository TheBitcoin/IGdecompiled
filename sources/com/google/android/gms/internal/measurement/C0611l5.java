package com.google.android.gms.internal.measurement;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* renamed from: com.google.android.gms.internal.measurement.l5  reason: case insensitive filesystem */
final class C0611l5 {

    /* renamed from: c  reason: collision with root package name */
    private static final C0611l5 f1988c = new C0611l5();

    /* renamed from: a  reason: collision with root package name */
    private final C0629n5 f1989a = new M4();

    /* renamed from: b  reason: collision with root package name */
    private final ConcurrentMap f1990b = new ConcurrentHashMap();

    private C0611l5() {
    }

    public static C0611l5 a() {
        return f1988c;
    }

    public final C0638o5 b(Class cls) {
        C0684u4.f(cls, "messageType");
        C0638o5 o5Var = (C0638o5) this.f1990b.get(cls);
        if (o5Var == null) {
            o5Var = this.f1989a.a(cls);
            C0684u4.f(cls, "messageType");
            C0684u4.f(o5Var, "schema");
            C0638o5 o5Var2 = (C0638o5) this.f1990b.putIfAbsent(cls, o5Var);
            if (o5Var2 != null) {
                return o5Var2;
            }
        }
        return o5Var;
    }

    public final C0638o5 c(Object obj) {
        return b(obj.getClass());
    }
}
