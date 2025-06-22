package S2;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.lang.reflect.Array;
import kotlin.jvm.internal.m;

/* renamed from: S2.i  reason: case insensitive filesystem */
abstract class C1595i {
    public static final Object[] a(Object[] objArr, int i4) {
        m.e(objArr, TypedValues.Custom.S_REFERENCE);
        Object newInstance = Array.newInstance(objArr.getClass().getComponentType(), i4);
        m.c(newInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
        return (Object[]) newInstance;
    }

    public static final void b(int i4, int i5) {
        if (i4 > i5) {
            throw new IndexOutOfBoundsException("toIndex (" + i4 + ") is greater than size (" + i5 + ").");
        }
    }
}
