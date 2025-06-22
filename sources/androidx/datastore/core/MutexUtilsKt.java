package androidx.datastore.core;

import d3.l;
import kotlin.jvm.internal.m;
import x3.a;

public final class MutexUtilsKt {
    public static final <R> R withTryLock(a aVar, Object obj, l lVar) {
        m.e(aVar, "<this>");
        m.e(lVar, "block");
        boolean a5 = aVar.a(obj);
        try {
            return lVar.invoke(Boolean.valueOf(a5));
        } finally {
            kotlin.jvm.internal.l.b(1);
            if (a5) {
                aVar.d(obj);
            }
            kotlin.jvm.internal.l.a(1);
        }
    }

    public static /* synthetic */ Object withTryLock$default(a aVar, Object obj, l lVar, int i4, Object obj2) {
        if ((i4 & 1) != 0) {
            obj = null;
        }
        m.e(aVar, "<this>");
        m.e(lVar, "block");
        boolean a5 = aVar.a(obj);
        try {
            return lVar.invoke(Boolean.valueOf(a5));
        } finally {
            kotlin.jvm.internal.l.b(1);
            if (a5) {
                aVar.d(obj);
            }
            kotlin.jvm.internal.l.a(1);
        }
    }
}
