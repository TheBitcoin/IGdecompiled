package m0;

import j$.util.Objects;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.SortedSet;
import l0.h;

public abstract class r extends C2146n implements Set {

    /* renamed from: b  reason: collision with root package name */
    private transient C2147o f21148b;

    r() {
    }

    static int m(int i4) {
        int max = Math.max(i4, 2);
        boolean z4 = true;
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1) << 1;
            while (((double) highestOneBit) * 0.7d < ((double) max)) {
                highestOneBit <<= 1;
            }
            return highestOneBit;
        }
        if (max >= 1073741824) {
            z4 = false;
        }
        h.e(z4, "collection too large");
        return 1073741824;
    }

    private static r n(int i4, Object... objArr) {
        if (i4 == 0) {
            return r();
        }
        if (i4 != 1) {
            int m4 = m(i4);
            Object[] objArr2 = new Object[m4];
            int i5 = m4 - 1;
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < i4; i8++) {
                Object a5 = C2132F.a(objArr[i8], i8);
                int hashCode = a5.hashCode();
                int b5 = C2145m.b(hashCode);
                while (true) {
                    int i9 = b5 & i5;
                    Object obj = objArr2[i9];
                    if (obj == null) {
                        objArr[i7] = a5;
                        objArr2[i9] = a5;
                        i6 += hashCode;
                        i7++;
                        break;
                    } else if (obj.equals(a5)) {
                        break;
                    } else {
                        b5++;
                    }
                }
            }
            Arrays.fill(objArr, i7, i4, (Object) null);
            if (i7 == 1) {
                Object obj2 = objArr[0];
                Objects.requireNonNull(obj2);
                return new N(obj2);
            } else if (m(i7) < m4 / 2) {
                return n(i7, objArr);
            } else {
                if (v(i7, objArr.length)) {
                    objArr = Arrays.copyOf(objArr, i7);
                }
                return new K(objArr, i6, objArr2, i5, i7);
            }
        } else {
            Object obj3 = objArr[0];
            Objects.requireNonNull(obj3);
            return s(obj3);
        }
    }

    public static r o(Collection collection) {
        if ((collection instanceof r) && !(collection instanceof SortedSet)) {
            r rVar = (r) collection;
            if (!rVar.k()) {
                return rVar;
            }
        }
        Object[] array = collection.toArray();
        return n(array.length, array);
    }

    public static r r() {
        return K.f21070i;
    }

    public static r s(Object obj) {
        return new N(obj);
    }

    public static r t(Object obj, Object obj2, Object obj3) {
        return n(3, obj, obj2, obj3);
    }

    public static r u(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object... objArr) {
        boolean z4;
        if (objArr.length <= 2147483641) {
            z4 = true;
        } else {
            z4 = false;
        }
        h.e(z4, "the total number of elements must fit in an int");
        int length = objArr.length + 6;
        Object[] objArr2 = new Object[length];
        objArr2[0] = obj;
        objArr2[1] = obj2;
        objArr2[2] = obj3;
        objArr2[3] = obj4;
        objArr2[4] = obj5;
        objArr2[5] = obj6;
        System.arraycopy(objArr, 0, objArr2, 6, objArr.length);
        return n(length, objArr2);
    }

    private static boolean v(int i4, int i5) {
        if (i4 < (i5 >> 1) + (i5 >> 2)) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof r) || !q() || !((r) obj).q() || hashCode() == obj.hashCode()) {
            return M.a(this, obj);
        }
        return false;
    }

    public int hashCode() {
        return M.b(this);
    }

    public C2147o l() {
        C2147o oVar = this.f21148b;
        if (oVar != null) {
            return oVar;
        }
        C2147o p4 = p();
        this.f21148b = p4;
        return p4;
    }

    /* access modifiers changed from: package-private */
    public C2147o p() {
        return C2147o.l(toArray());
    }

    /* access modifiers changed from: package-private */
    public boolean q() {
        return false;
    }
}
