package T2;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.m;

public abstract class c {
    public static final Object[] d(int i4) {
        if (i4 >= 0) {
            return new Object[i4];
        }
        throw new IllegalArgumentException("capacity must be non-negative.");
    }

    public static final Object[] e(Object[] objArr, int i4) {
        m.e(objArr, "<this>");
        Object[] copyOf = Arrays.copyOf(objArr, i4);
        m.d(copyOf, "copyOf(...)");
        return copyOf;
    }

    public static final void f(Object[] objArr, int i4) {
        m.e(objArr, "<this>");
        objArr[i4] = null;
    }

    public static final void g(Object[] objArr, int i4, int i5) {
        m.e(objArr, "<this>");
        while (i4 < i5) {
            f(objArr, i4);
            i4++;
        }
    }

    /* access modifiers changed from: private */
    public static final boolean h(Object[] objArr, int i4, int i5, List list) {
        if (i5 != list.size()) {
            return false;
        }
        for (int i6 = 0; i6 < i5; i6++) {
            if (!m.a(objArr[i4 + i6], list.get(i6))) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static final int i(Object[] objArr, int i4, int i5) {
        int i6;
        int i7 = 1;
        for (int i8 = 0; i8 < i5; i8++) {
            Object obj = objArr[i4 + i8];
            int i9 = i7 * 31;
            if (obj != null) {
                i6 = obj.hashCode();
            } else {
                i6 = 0;
            }
            i7 = i9 + i6;
        }
        return i7;
    }

    /* access modifiers changed from: private */
    public static final String j(Object[] objArr, int i4, int i5, Collection collection) {
        StringBuilder sb = new StringBuilder((i5 * 3) + 2);
        sb.append("[");
        for (int i6 = 0; i6 < i5; i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            Collection collection2 = objArr[i4 + i6];
            if (collection2 == collection) {
                sb.append("(this Collection)");
            } else {
                sb.append(collection2);
            }
        }
        sb.append("]");
        String sb2 = sb.toString();
        m.d(sb2, "toString(...)");
        return sb2;
    }
}
