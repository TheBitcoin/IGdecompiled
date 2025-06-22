package S2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import kotlin.jvm.internal.m;

/* renamed from: S2.k  reason: case insensitive filesystem */
abstract class C1597k extends C1596j {
    public static List c(Object[] objArr) {
        m.e(objArr, "<this>");
        List a5 = C1599m.a(objArr);
        m.d(a5, "asList(...)");
        return a5;
    }

    public static byte[] d(byte[] bArr, byte[] bArr2, int i4, int i5, int i6) {
        m.e(bArr, "<this>");
        m.e(bArr2, "destination");
        System.arraycopy(bArr, i5, bArr2, i4, i6 - i5);
        return bArr2;
    }

    public static Object[] e(Object[] objArr, Object[] objArr2, int i4, int i5, int i6) {
        m.e(objArr, "<this>");
        m.e(objArr2, "destination");
        System.arraycopy(objArr, i5, objArr2, i4, i6 - i5);
        return objArr2;
    }

    public static /* synthetic */ byte[] f(byte[] bArr, byte[] bArr2, int i4, int i5, int i6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i4 = 0;
        }
        if ((i7 & 4) != 0) {
            i5 = 0;
        }
        if ((i7 & 8) != 0) {
            i6 = bArr.length;
        }
        return d(bArr, bArr2, i4, i5, i6);
    }

    public static /* synthetic */ Object[] g(Object[] objArr, Object[] objArr2, int i4, int i5, int i6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i4 = 0;
        }
        if ((i7 & 4) != 0) {
            i5 = 0;
        }
        if ((i7 & 8) != 0) {
            i6 = objArr.length;
        }
        return e(objArr, objArr2, i4, i5, i6);
    }

    public static byte[] h(byte[] bArr, int i4, int i5) {
        m.e(bArr, "<this>");
        C1595i.b(i5, bArr.length);
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i4, i5);
        m.d(copyOfRange, "copyOfRange(...)");
        return copyOfRange;
    }

    public static Object[] i(Object[] objArr, int i4, int i5) {
        m.e(objArr, "<this>");
        C1595i.b(i5, objArr.length);
        Object[] copyOfRange = Arrays.copyOfRange(objArr, i4, i5);
        m.d(copyOfRange, "copyOfRange(...)");
        return copyOfRange;
    }

    public static final void j(Object[] objArr, Object obj, int i4, int i5) {
        m.e(objArr, "<this>");
        Arrays.fill(objArr, i4, i5, obj);
    }

    public static /* synthetic */ void k(Object[] objArr, Object obj, int i4, int i5, int i6, Object obj2) {
        if ((i6 & 2) != 0) {
            i4 = 0;
        }
        if ((i6 & 4) != 0) {
            i5 = objArr.length;
        }
        j(objArr, obj, i4, i5);
    }

    public static final void l(Object[] objArr) {
        m.e(objArr, "<this>");
        if (objArr.length > 1) {
            Arrays.sort(objArr);
        }
    }

    public static final void m(Object[] objArr, Comparator comparator) {
        m.e(objArr, "<this>");
        m.e(comparator, "comparator");
        if (objArr.length > 1) {
            Arrays.sort(objArr, comparator);
        }
    }
}
