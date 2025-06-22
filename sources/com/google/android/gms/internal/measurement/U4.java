package com.google.android.gms.internal.measurement;

import android.support.v4.media.a;
import java.util.Iterator;
import java.util.Map;

final class U4 implements R4 {
    U4() {
    }

    public final P4 a(Object obj) {
        a.a(obj);
        throw new NoSuchMethodError();
    }

    public final Map b(Object obj) {
        return (S4) obj;
    }

    public final Map c(Object obj) {
        return (S4) obj;
    }

    public final Object d(Object obj) {
        return S4.b().d();
    }

    public final Object e(Object obj, Object obj2) {
        S4 s4 = (S4) obj;
        S4 s42 = (S4) obj2;
        if (!s42.isEmpty()) {
            if (!s4.f()) {
                s4 = s4.d();
            }
            s4.c(s42);
        }
        return s4;
    }

    public final boolean f(Object obj) {
        if (!((S4) obj).f()) {
            return true;
        }
        return false;
    }

    public final Object g(Object obj) {
        ((S4) obj).e();
        return obj;
    }

    public final int h(int i4, Object obj, Object obj2) {
        S4 s4 = (S4) obj;
        a.a(obj2);
        if (s4.isEmpty()) {
            return 0;
        }
        Iterator it = s4.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
