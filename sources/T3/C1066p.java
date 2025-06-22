package t3;

import kotlin.jvm.internal.m;

/* renamed from: t3.p  reason: case insensitive filesystem */
public abstract class C1066p {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f4510a = new F("CONDITION_FALSE");

    public static final Object a() {
        return f4510a;
    }

    public static final C1067q b(Object obj) {
        z zVar;
        C1067q qVar;
        if (obj instanceof z) {
            zVar = (z) obj;
        } else {
            zVar = null;
        }
        if (zVar != null && (qVar = zVar.f4531a) != null) {
            return qVar;
        }
        m.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        return (C1067q) obj;
    }
}
