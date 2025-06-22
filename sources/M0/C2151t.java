package m0;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.NavigableSet;
import l0.h;

/* renamed from: m0.t  reason: case insensitive filesystem */
public abstract class C2151t extends u implements NavigableSet, O {

    /* renamed from: c  reason: collision with root package name */
    final transient Comparator f21150c;

    /* renamed from: d  reason: collision with root package name */
    transient C2151t f21151d;

    C2151t(Comparator comparator) {
        this.f21150c = comparator;
    }

    static L D(Comparator comparator) {
        if (G.c().equals(comparator)) {
            return L.f21076f;
        }
        return new L(C2147o.r(), comparator);
    }

    static int O(Comparator comparator, Object obj, Object obj2) {
        return comparator.compare(obj, obj2);
    }

    static C2151t w(Comparator comparator, int i4, Object... objArr) {
        if (i4 == 0) {
            return D(comparator);
        }
        C2132F.c(objArr, i4);
        Arrays.sort(objArr, 0, i4, comparator);
        int i5 = 1;
        for (int i6 = 1; i6 < i4; i6++) {
            Object obj = objArr[i6];
            if (comparator.compare(obj, objArr[i5 - 1]) != 0) {
                objArr[i5] = obj;
                i5++;
            }
        }
        Arrays.fill(objArr, i5, i4, (Object) null);
        if (i5 < objArr.length / 2) {
            objArr = Arrays.copyOf(objArr, i5);
        }
        return new L(C2147o.m(objArr, i5), comparator);
    }

    public static C2151t x(Comparator comparator, Iterable iterable) {
        h.i(comparator);
        if (P.b(comparator, iterable) && (iterable instanceof C2151t)) {
            C2151t tVar = (C2151t) iterable;
            if (!tVar.k()) {
                return tVar;
            }
        }
        Object[] b5 = v.b(iterable);
        return w(comparator, b5.length, b5);
    }

    public static C2151t y(Comparator comparator, Collection collection) {
        return x(comparator, collection);
    }

    /* renamed from: C */
    public C2151t descendingSet() {
        C2151t tVar = this.f21151d;
        if (tVar != null) {
            return tVar;
        }
        C2151t z4 = z();
        this.f21151d = z4;
        z4.f21151d = this;
        return z4;
    }

    /* renamed from: E */
    public C2151t headSet(Object obj) {
        return headSet(obj, false);
    }

    /* renamed from: F */
    public C2151t headSet(Object obj, boolean z4) {
        return G(h.i(obj), z4);
    }

    /* access modifiers changed from: package-private */
    public abstract C2151t G(Object obj, boolean z4);

    /* renamed from: H */
    public C2151t subSet(Object obj, Object obj2) {
        return subSet(obj, true, obj2, false);
    }

    /* renamed from: I */
    public C2151t subSet(Object obj, boolean z4, Object obj2, boolean z5) {
        boolean z6;
        h.i(obj);
        h.i(obj2);
        if (this.f21150c.compare(obj, obj2) <= 0) {
            z6 = true;
        } else {
            z6 = false;
        }
        h.d(z6);
        return J(obj, z4, obj2, z5);
    }

    /* access modifiers changed from: package-private */
    public abstract C2151t J(Object obj, boolean z4, Object obj2, boolean z5);

    /* renamed from: K */
    public C2151t tailSet(Object obj) {
        return tailSet(obj, true);
    }

    /* renamed from: L */
    public C2151t tailSet(Object obj, boolean z4) {
        return M(h.i(obj), z4);
    }

    /* access modifiers changed from: package-private */
    public abstract C2151t M(Object obj, boolean z4);

    /* access modifiers changed from: package-private */
    public int N(Object obj, Object obj2) {
        return O(this.f21150c, obj, obj2);
    }

    public Comparator comparator() {
        return this.f21150c;
    }

    public final Object pollFirst() {
        throw new UnsupportedOperationException();
    }

    public final Object pollLast() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public abstract C2151t z();
}
