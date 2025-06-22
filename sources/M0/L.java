package m0;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import l0.h;

final class L extends C2151t {

    /* renamed from: f  reason: collision with root package name */
    static final L f21076f = new L(C2147o.r(), G.c());

    /* renamed from: e  reason: collision with root package name */
    final transient C2147o f21077e;

    L(C2147o oVar, Comparator comparator) {
        super(comparator);
        this.f21077e = oVar;
    }

    private int U(Object obj) {
        return Collections.binarySearch(this.f21077e, obj, V());
    }

    /* access modifiers changed from: package-private */
    public C2151t G(Object obj, boolean z4) {
        return Q(0, R(obj, z4));
    }

    /* access modifiers changed from: package-private */
    public C2151t J(Object obj, boolean z4, Object obj2, boolean z5) {
        return M(obj, z4).G(obj2, z5);
    }

    /* access modifiers changed from: package-private */
    public C2151t M(Object obj, boolean z4) {
        return Q(T(obj, z4), size());
    }

    /* renamed from: P */
    public S descendingIterator() {
        return this.f21077e.v().iterator();
    }

    /* access modifiers changed from: package-private */
    public L Q(int i4, int i5) {
        if (i4 == 0 && i5 == size()) {
            return this;
        }
        if (i4 < i5) {
            return new L(this.f21077e.subList(i4, i5), this.f21150c);
        }
        return C2151t.D(this.f21150c);
    }

    /* access modifiers changed from: package-private */
    public int R(Object obj, boolean z4) {
        int binarySearch = Collections.binarySearch(this.f21077e, h.i(obj), comparator());
        if (binarySearch < 0) {
            return ~binarySearch;
        }
        if (z4) {
            return binarySearch + 1;
        }
        return binarySearch;
    }

    /* renamed from: S */
    public S iterator() {
        return this.f21077e.iterator();
    }

    /* access modifiers changed from: package-private */
    public int T(Object obj, boolean z4) {
        int binarySearch = Collections.binarySearch(this.f21077e, h.i(obj), comparator());
        if (binarySearch < 0) {
            return ~binarySearch;
        }
        if (z4) {
            return binarySearch;
        }
        return binarySearch + 1;
    }

    /* access modifiers changed from: package-private */
    public Comparator V() {
        return this.f21150c;
    }

    /* access modifiers changed from: package-private */
    public int c(Object[] objArr, int i4) {
        return this.f21077e.c(objArr, i4);
    }

    public Object ceiling(Object obj) {
        int T4 = T(obj, true);
        if (T4 == size()) {
            return null;
        }
        return this.f21077e.get(T4);
    }

    public boolean contains(Object obj) {
        if (obj != null) {
            try {
                if (U(obj) >= 0) {
                    return true;
                }
            } catch (ClassCastException unused) {
            }
        }
        return false;
    }

    public boolean containsAll(Collection collection) {
        if (collection instanceof C2129C) {
            collection = ((C2129C) collection).f();
        }
        if (!P.b(comparator(), collection) || collection.size() <= 1) {
            return super.containsAll(collection);
        }
        S S4 = iterator();
        Iterator it = collection.iterator();
        if (!S4.hasNext()) {
            return false;
        }
        Object next = it.next();
        Object next2 = S4.next();
        while (true) {
            try {
                int N4 = N(next2, next);
                if (N4 < 0) {
                    if (!S4.hasNext()) {
                        return false;
                    }
                    next2 = S4.next();
                } else if (N4 == 0) {
                    if (!it.hasNext()) {
                        return true;
                    }
                    next = it.next();
                } else if (N4 > 0) {
                    break;
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0034 A[Catch:{ ClassCastException | NoSuchElementException -> 0x0046 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            r0 = 1
            if (r6 != r5) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r6 instanceof java.util.Set
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            java.util.Set r6 = (java.util.Set) r6
            int r1 = r5.size()
            int r3 = r6.size()
            if (r1 == r3) goto L_0x0017
            return r2
        L_0x0017:
            boolean r1 = r5.isEmpty()
            if (r1 == 0) goto L_0x001e
            return r0
        L_0x001e:
            java.util.Comparator r1 = r5.f21150c
            boolean r1 = m0.P.b(r1, r6)
            if (r1 == 0) goto L_0x0047
            java.util.Iterator r6 = r6.iterator()
            m0.S r1 = r5.iterator()     // Catch:{ ClassCastException | NoSuchElementException -> 0x0046 }
        L_0x002e:
            boolean r3 = r1.hasNext()     // Catch:{ ClassCastException | NoSuchElementException -> 0x0046 }
            if (r3 == 0) goto L_0x0045
            java.lang.Object r3 = r1.next()     // Catch:{ ClassCastException | NoSuchElementException -> 0x0046 }
            java.lang.Object r4 = r6.next()     // Catch:{ ClassCastException | NoSuchElementException -> 0x0046 }
            if (r4 == 0) goto L_0x0044
            int r3 = r5.N(r3, r4)     // Catch:{ ClassCastException | NoSuchElementException -> 0x0046 }
            if (r3 == 0) goto L_0x002e
        L_0x0044:
            return r2
        L_0x0045:
            return r0
        L_0x0046:
            return r2
        L_0x0047:
            boolean r6 = r5.containsAll(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: m0.L.equals(java.lang.Object):boolean");
    }

    public Object first() {
        if (!isEmpty()) {
            return this.f21077e.get(0);
        }
        throw new NoSuchElementException();
    }

    public Object floor(Object obj) {
        int R4 = R(obj, true) - 1;
        if (R4 == -1) {
            return null;
        }
        return this.f21077e.get(R4);
    }

    /* access modifiers changed from: package-private */
    public Object[] g() {
        return this.f21077e.g();
    }

    /* access modifiers changed from: package-private */
    public int h() {
        return this.f21077e.h();
    }

    public Object higher(Object obj) {
        int T4 = T(obj, false);
        if (T4 == size()) {
            return null;
        }
        return this.f21077e.get(T4);
    }

    /* access modifiers changed from: package-private */
    public int j() {
        return this.f21077e.j();
    }

    /* access modifiers changed from: package-private */
    public boolean k() {
        return this.f21077e.k();
    }

    public Object last() {
        if (!isEmpty()) {
            return this.f21077e.get(size() - 1);
        }
        throw new NoSuchElementException();
    }

    public Object lower(Object obj) {
        int R4 = R(obj, false) - 1;
        if (R4 == -1) {
            return null;
        }
        return this.f21077e.get(R4);
    }

    public int size() {
        return this.f21077e.size();
    }

    /* access modifiers changed from: package-private */
    public C2151t z() {
        Comparator reverseOrder = Collections.reverseOrder(this.f21150c);
        if (isEmpty()) {
            return C2151t.D(reverseOrder);
        }
        return new L(this.f21077e.v(), reverseOrder);
    }
}
