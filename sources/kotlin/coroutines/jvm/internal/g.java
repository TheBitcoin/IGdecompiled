package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Field;
import kotlin.jvm.internal.m;

public abstract class g {
    private static final void a(int i4, int i5) {
        if (i5 > i4) {
            throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + i4 + ", got " + i5 + ". Please update the Kotlin standard library.").toString());
        }
    }

    private static final f b(a aVar) {
        return (f) aVar.getClass().getAnnotation(f.class);
    }

    private static final int c(a aVar) {
        Integer num;
        int i4;
        try {
            Field declaredField = aVar.getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(aVar);
            if (obj instanceof Integer) {
                num = (Integer) obj;
            } else {
                num = null;
            }
            if (num != null) {
                i4 = num.intValue();
            } else {
                i4 = 0;
            }
            return i4 - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static final StackTraceElement d(a aVar) {
        int i4;
        String str;
        m.e(aVar, "<this>");
        f b5 = b(aVar);
        if (b5 == null) {
            return null;
        }
        a(1, b5.v());
        int c5 = c(aVar);
        if (c5 < 0) {
            i4 = -1;
        } else {
            i4 = b5.l()[c5];
        }
        String b6 = i.f20960a.b(aVar);
        if (b6 == null) {
            str = b5.c();
        } else {
            str = b6 + '/' + b5.c();
        }
        return new StackTraceElement(str, b5.m(), b5.f(), i4);
    }
}
