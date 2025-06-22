package t3;

import kotlin.jvm.internal.m;

public abstract class D {
    public static final C b(Object obj) {
        if (obj != C1054d.f4489a) {
            m.c(obj, "null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
            return (C) obj;
        }
        throw new IllegalStateException("Does not contain segment");
    }

    public static final boolean c(Object obj) {
        if (obj == C1054d.f4489a) {
            return true;
        }
        return false;
    }

    public static Object a(Object obj) {
        return obj;
    }
}
