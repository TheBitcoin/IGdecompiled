package m0;

import j$.util.Objects;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import n0.C2156a;

/* renamed from: m0.i  reason: case insensitive filesystem */
class C2141i extends AbstractMap implements Serializable {
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public static final Object f21096j = new Object();

    /* renamed from: a  reason: collision with root package name */
    private transient Object f21097a;

    /* renamed from: b  reason: collision with root package name */
    transient int[] f21098b;

    /* renamed from: c  reason: collision with root package name */
    transient Object[] f21099c;

    /* renamed from: d  reason: collision with root package name */
    transient Object[] f21100d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public transient int f21101e;

    /* renamed from: f  reason: collision with root package name */
    private transient int f21102f;

    /* renamed from: g  reason: collision with root package name */
    private transient Set f21103g;

    /* renamed from: h  reason: collision with root package name */
    private transient Set f21104h;

    /* renamed from: i  reason: collision with root package name */
    private transient Collection f21105i;

    /* renamed from: m0.i$a */
    class a extends e {
        a() {
            super(C2141i.this, (a) null);
        }

        /* access modifiers changed from: package-private */
        public Object b(int i4) {
            return C2141i.this.H(i4);
        }
    }

    /* renamed from: m0.i$b */
    class b extends e {
        b() {
            super(C2141i.this, (a) null);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public Map.Entry b(int i4) {
            return new g(i4);
        }
    }

    /* renamed from: m0.i$c */
    class c extends e {
        c() {
            super(C2141i.this, (a) null);
        }

        /* access modifiers changed from: package-private */
        public Object b(int i4) {
            return C2141i.this.X(i4);
        }
    }

    /* renamed from: m0.i$d */
    class d extends AbstractSet {
        d() {
        }

        public void clear() {
            C2141i.this.clear();
        }

        public boolean contains(Object obj) {
            Map x4 = C2141i.this.x();
            if (x4 != null) {
                return x4.entrySet().contains(obj);
            }
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                int j4 = C2141i.this.E(entry.getKey());
                if (j4 == -1 || !l0.f.a(C2141i.this.X(j4), entry.getValue())) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public Iterator iterator() {
            return C2141i.this.z();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0021, code lost:
            r4 = m0.C2141i.l(r9.f21109a);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean remove(java.lang.Object r10) {
            /*
                r9 = this;
                m0.i r0 = m0.C2141i.this
                java.util.Map r0 = r0.x()
                if (r0 == 0) goto L_0x0011
                java.util.Set r0 = r0.entrySet()
                boolean r10 = r0.remove(r10)
                return r10
            L_0x0011:
                boolean r0 = r10 instanceof java.util.Map.Entry
                r1 = 0
                if (r0 == 0) goto L_0x0060
                java.util.Map$Entry r10 = (java.util.Map.Entry) r10
                m0.i r0 = m0.C2141i.this
                boolean r0 = r0.K()
                if (r0 == 0) goto L_0x0021
                return r1
            L_0x0021:
                m0.i r0 = m0.C2141i.this
                int r4 = r0.C()
                java.lang.Object r2 = r10.getKey()
                java.lang.Object r3 = r10.getValue()
                m0.i r10 = m0.C2141i.this
                java.lang.Object r5 = r10.O()
                m0.i r10 = m0.C2141i.this
                int[] r6 = r10.M()
                m0.i r10 = m0.C2141i.this
                java.lang.Object[] r7 = r10.N()
                m0.i r10 = m0.C2141i.this
                java.lang.Object[] r8 = r10.P()
                int r10 = m0.C2142j.f(r2, r3, r4, r5, r6, r7, r8)
                r0 = -1
                if (r10 != r0) goto L_0x004f
                return r1
            L_0x004f:
                m0.i r0 = m0.C2141i.this
                r0.J(r10, r4)
                m0.i r10 = m0.C2141i.this
                m0.C2141i.e(r10)
                m0.i r10 = m0.C2141i.this
                r10.D()
                r10 = 1
                return r10
            L_0x0060:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: m0.C2141i.d.remove(java.lang.Object):boolean");
        }

        public int size() {
            return C2141i.this.size();
        }
    }

    /* renamed from: m0.i$f */
    class f extends AbstractSet {
        f() {
        }

        public void clear() {
            C2141i.this.clear();
        }

        public boolean contains(Object obj) {
            return C2141i.this.containsKey(obj);
        }

        public Iterator iterator() {
            return C2141i.this.I();
        }

        public boolean remove(Object obj) {
            Map x4 = C2141i.this.x();
            if (x4 != null) {
                return x4.keySet().remove(obj);
            }
            if (C2141i.this.L(obj) != C2141i.f21096j) {
                return true;
            }
            return false;
        }

        public int size() {
            return C2141i.this.size();
        }
    }

    /* renamed from: m0.i$g */
    final class g extends C2135c {

        /* renamed from: a  reason: collision with root package name */
        private final Object f21115a;

        /* renamed from: b  reason: collision with root package name */
        private int f21116b;

        g(int i4) {
            this.f21115a = C2141i.this.H(i4);
            this.f21116b = i4;
        }

        private void a() {
            int i4 = this.f21116b;
            if (i4 == -1 || i4 >= C2141i.this.size() || !l0.f.a(this.f21115a, C2141i.this.H(this.f21116b))) {
                this.f21116b = C2141i.this.E(this.f21115a);
            }
        }

        public Object getKey() {
            return this.f21115a;
        }

        public Object getValue() {
            Map x4 = C2141i.this.x();
            if (x4 != null) {
                return C2131E.a(x4.get(this.f21115a));
            }
            a();
            int i4 = this.f21116b;
            if (i4 == -1) {
                return C2131E.b();
            }
            return C2141i.this.X(i4);
        }

        public Object setValue(Object obj) {
            Map x4 = C2141i.this.x();
            if (x4 != null) {
                return C2131E.a(x4.put(this.f21115a, obj));
            }
            a();
            int i4 = this.f21116b;
            if (i4 == -1) {
                C2141i.this.put(this.f21115a, obj);
                return C2131E.b();
            }
            Object k4 = C2141i.this.X(i4);
            C2141i.this.W(this.f21116b, obj);
            return k4;
        }
    }

    /* renamed from: m0.i$h */
    class h extends AbstractCollection {
        h() {
        }

        public void clear() {
            C2141i.this.clear();
        }

        public Iterator iterator() {
            return C2141i.this.Y();
        }

        public int size() {
            return C2141i.this.size();
        }
    }

    C2141i() {
        F(3);
    }

    /* access modifiers changed from: private */
    public int C() {
        return (1 << (this.f21101e & 31)) - 1;
    }

    /* access modifiers changed from: private */
    public int E(Object obj) {
        if (K()) {
            return -1;
        }
        int c5 = C2145m.c(obj);
        int C4 = C();
        int h4 = C2142j.h(O(), c5 & C4);
        if (h4 == 0) {
            return -1;
        }
        int b5 = C2142j.b(c5, C4);
        do {
            int i4 = h4 - 1;
            int y4 = y(i4);
            if (C2142j.b(y4, C4) == b5 && l0.f.a(obj, H(i4))) {
                return i4;
            }
            h4 = C2142j.c(y4, C4);
        } while (h4 != 0);
        return -1;
    }

    /* access modifiers changed from: private */
    public Object H(int i4) {
        return N()[i4];
    }

    /* access modifiers changed from: private */
    public Object L(Object obj) {
        if (K()) {
            return f21096j;
        }
        int C4 = C();
        int f4 = C2142j.f(obj, (Object) null, C4, O(), M(), N(), (Object[]) null);
        if (f4 == -1) {
            return f21096j;
        }
        Object X4 = X(f4);
        J(f4, C4);
        this.f21102f--;
        D();
        return X4;
    }

    /* access modifiers changed from: private */
    public int[] M() {
        int[] iArr = this.f21098b;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    /* access modifiers changed from: private */
    public Object[] N() {
        Object[] objArr = this.f21099c;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    /* access modifiers changed from: private */
    public Object O() {
        Object obj = this.f21097a;
        Objects.requireNonNull(obj);
        return obj;
    }

    /* access modifiers changed from: private */
    public Object[] P() {
        Object[] objArr = this.f21100d;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    private void R(int i4) {
        int min;
        int length = M().length;
        if (i4 > length && (min = Math.min(1073741823, (Math.max(1, length >>> 1) + length) | 1)) != length) {
            Q(min);
        }
    }

    private int S(int i4, int i5, int i6, int i7) {
        Object a5 = C2142j.a(i5);
        int i8 = i5 - 1;
        if (i7 != 0) {
            C2142j.i(a5, i6 & i8, i7 + 1);
        }
        Object O4 = O();
        int[] M4 = M();
        for (int i9 = 0; i9 <= i4; i9++) {
            int h4 = C2142j.h(O4, i9);
            while (h4 != 0) {
                int i10 = h4 - 1;
                int i11 = M4[i10];
                int b5 = C2142j.b(i11, i4) | i9;
                int i12 = b5 & i8;
                int h5 = C2142j.h(a5, i12);
                C2142j.i(a5, i12, h4);
                M4[i10] = C2142j.d(b5, h5, i8);
                h4 = C2142j.c(i11, i4);
            }
        }
        this.f21097a = a5;
        U(i8);
        return i8;
    }

    private void T(int i4, int i5) {
        M()[i4] = i5;
    }

    private void U(int i4) {
        this.f21101e = C2142j.d(this.f21101e, 32 - Integer.numberOfLeadingZeros(i4), 31);
    }

    private void V(int i4, Object obj) {
        N()[i4] = obj;
    }

    /* access modifiers changed from: private */
    public void W(int i4, Object obj) {
        P()[i4] = obj;
    }

    /* access modifiers changed from: private */
    public Object X(int i4) {
        return P()[i4];
    }

    static /* synthetic */ int e(C2141i iVar) {
        int i4 = iVar.f21102f;
        iVar.f21102f = i4 - 1;
        return i4;
    }

    public static C2141i s() {
        return new C2141i();
    }

    private int y(int i4) {
        return M()[i4];
    }

    /* access modifiers changed from: package-private */
    public int A() {
        if (isEmpty()) {
            return -1;
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int B(int i4) {
        int i5 = i4 + 1;
        if (i5 < this.f21102f) {
            return i5;
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public void D() {
        this.f21101e += 32;
    }

    /* access modifiers changed from: package-private */
    public void F(int i4) {
        boolean z4;
        if (i4 >= 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        l0.h.e(z4, "Expected size must be >= 0");
        this.f21101e = C2156a.a(i4, 1, 1073741823);
    }

    /* access modifiers changed from: package-private */
    public void G(int i4, Object obj, Object obj2, int i5, int i6) {
        T(i4, C2142j.d(i5, 0, i6));
        V(i4, obj);
        W(i4, obj2);
    }

    /* access modifiers changed from: package-private */
    public Iterator I() {
        Map x4 = x();
        if (x4 != null) {
            return x4.keySet().iterator();
        }
        return new a();
    }

    /* access modifiers changed from: package-private */
    public void J(int i4, int i5) {
        Object O4 = O();
        int[] M4 = M();
        Object[] N4 = N();
        Object[] P4 = P();
        int size = size();
        int i6 = size - 1;
        if (i4 < i6) {
            Object obj = N4[i6];
            N4[i4] = obj;
            P4[i4] = P4[i6];
            N4[i6] = null;
            P4[i6] = null;
            M4[i4] = M4[i6];
            M4[i6] = 0;
            int c5 = C2145m.c(obj) & i5;
            int h4 = C2142j.h(O4, c5);
            if (h4 == size) {
                C2142j.i(O4, c5, i4 + 1);
                return;
            }
            while (true) {
                int i7 = h4 - 1;
                int i8 = M4[i7];
                int c6 = C2142j.c(i8, i5);
                if (c6 == size) {
                    M4[i7] = C2142j.d(i8, i4 + 1, i5);
                    return;
                }
                h4 = c6;
            }
        } else {
            N4[i4] = null;
            P4[i4] = null;
            M4[i4] = 0;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean K() {
        if (this.f21097a == null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void Q(int i4) {
        this.f21098b = Arrays.copyOf(M(), i4);
        this.f21099c = Arrays.copyOf(N(), i4);
        this.f21100d = Arrays.copyOf(P(), i4);
    }

    /* access modifiers changed from: package-private */
    public Iterator Y() {
        Map x4 = x();
        if (x4 != null) {
            return x4.values().iterator();
        }
        return new c();
    }

    public void clear() {
        if (!K()) {
            D();
            Map x4 = x();
            if (x4 != null) {
                this.f21101e = C2156a.a(size(), 3, 1073741823);
                x4.clear();
                this.f21097a = null;
                this.f21102f = 0;
                return;
            }
            Arrays.fill(N(), 0, this.f21102f, (Object) null);
            Arrays.fill(P(), 0, this.f21102f, (Object) null);
            C2142j.g(O());
            Arrays.fill(M(), 0, this.f21102f, 0);
            this.f21102f = 0;
        }
    }

    public boolean containsKey(Object obj) {
        Map x4 = x();
        if (x4 != null) {
            return x4.containsKey(obj);
        }
        if (E(obj) != -1) {
            return true;
        }
        return false;
    }

    public boolean containsValue(Object obj) {
        Map x4 = x();
        if (x4 != null) {
            return x4.containsValue(obj);
        }
        for (int i4 = 0; i4 < this.f21102f; i4++) {
            if (l0.f.a(obj, X(i4))) {
                return true;
            }
        }
        return false;
    }

    public Set entrySet() {
        Set set = this.f21104h;
        if (set != null) {
            return set;
        }
        Set t4 = t();
        this.f21104h = t4;
        return t4;
    }

    public Object get(Object obj) {
        Map x4 = x();
        if (x4 != null) {
            return x4.get(obj);
        }
        int E4 = E(obj);
        if (E4 == -1) {
            return null;
        }
        o(E4);
        return X(E4);
    }

    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public Set keySet() {
        Set set = this.f21103g;
        if (set != null) {
            return set;
        }
        Set v4 = v();
        this.f21103g = v4;
        return v4;
    }

    /* access modifiers changed from: package-private */
    public int p(int i4, int i5) {
        return i4 - 1;
    }

    public Object put(Object obj, Object obj2) {
        if (K()) {
            q();
        }
        Map x4 = x();
        if (x4 != null) {
            return x4.put(obj, obj2);
        }
        int[] M4 = M();
        Object[] N4 = N();
        Object[] P4 = P();
        int i4 = this.f21102f;
        int i5 = i4 + 1;
        int c5 = C2145m.c(obj);
        int C4 = C();
        int i6 = c5 & C4;
        int h4 = C2142j.h(O(), i6);
        if (h4 != 0) {
            int b5 = C2142j.b(c5, C4);
            int i7 = 0;
            while (true) {
                int i8 = h4 - 1;
                int i9 = M4[i8];
                if (C2142j.b(i9, C4) != b5 || !l0.f.a(obj, N4[i8])) {
                    int c6 = C2142j.c(i9, C4);
                    i7++;
                    if (c6 != 0) {
                        Object obj3 = obj2;
                        Object obj4 = obj;
                        obj = obj4;
                        obj2 = obj3;
                        h4 = c6;
                    } else if (i7 >= 9) {
                        return r().put(obj, obj2);
                    } else {
                        if (i5 > C4) {
                            C4 = S(C4, C2142j.e(C4), c5, i4);
                        } else {
                            M4[i8] = C2142j.d(i9, i5, C4);
                        }
                    }
                } else {
                    Object obj5 = P4[i8];
                    P4[i8] = obj2;
                    o(i8);
                    return obj5;
                }
            }
        } else if (i5 > C4) {
            C4 = S(C4, C2142j.e(C4), c5, i4);
        } else {
            C2142j.i(O(), i6, i5);
        }
        int i10 = C4;
        R(i5);
        G(i4, obj, obj2, c5, i10);
        this.f21102f = i5;
        D();
        return null;
    }

    /* access modifiers changed from: package-private */
    public int q() {
        l0.h.o(K(), "Arrays already allocated");
        int i4 = this.f21101e;
        int j4 = C2142j.j(i4);
        this.f21097a = C2142j.a(j4);
        U(j4 - 1);
        this.f21098b = new int[i4];
        this.f21099c = new Object[i4];
        this.f21100d = new Object[i4];
        return i4;
    }

    /* access modifiers changed from: package-private */
    public Map r() {
        Map u4 = u(C() + 1);
        int A4 = A();
        while (A4 >= 0) {
            u4.put(H(A4), X(A4));
            A4 = B(A4);
        }
        this.f21097a = u4;
        this.f21098b = null;
        this.f21099c = null;
        this.f21100d = null;
        D();
        return u4;
    }

    public Object remove(Object obj) {
        Map x4 = x();
        if (x4 != null) {
            return x4.remove(obj);
        }
        Object L4 = L(obj);
        if (L4 == f21096j) {
            return null;
        }
        return L4;
    }

    public int size() {
        Map x4 = x();
        if (x4 != null) {
            return x4.size();
        }
        return this.f21102f;
    }

    /* access modifiers changed from: package-private */
    public Set t() {
        return new d();
    }

    /* access modifiers changed from: package-private */
    public Map u(int i4) {
        return new LinkedHashMap(i4, 1.0f);
    }

    /* access modifiers changed from: package-private */
    public Set v() {
        return new f();
    }

    public Collection values() {
        Collection collection = this.f21105i;
        if (collection != null) {
            return collection;
        }
        Collection w4 = w();
        this.f21105i = w4;
        return w4;
    }

    /* access modifiers changed from: package-private */
    public Collection w() {
        return new h();
    }

    /* access modifiers changed from: package-private */
    public Map x() {
        Object obj = this.f21097a;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public Iterator z() {
        Map x4 = x();
        if (x4 != null) {
            return x4.entrySet().iterator();
        }
        return new b();
    }

    /* renamed from: m0.i$e */
    private abstract class e implements Iterator {

        /* renamed from: a  reason: collision with root package name */
        int f21110a;

        /* renamed from: b  reason: collision with root package name */
        int f21111b;

        /* renamed from: c  reason: collision with root package name */
        int f21112c;

        private e() {
            this.f21110a = C2141i.this.f21101e;
            this.f21111b = C2141i.this.A();
            this.f21112c = -1;
        }

        private void a() {
            if (C2141i.this.f21101e != this.f21110a) {
                throw new ConcurrentModificationException();
            }
        }

        /* access modifiers changed from: package-private */
        public abstract Object b(int i4);

        /* access modifiers changed from: package-private */
        public void c() {
            this.f21110a += 32;
        }

        public boolean hasNext() {
            if (this.f21111b >= 0) {
                return true;
            }
            return false;
        }

        public Object next() {
            a();
            if (hasNext()) {
                int i4 = this.f21111b;
                this.f21112c = i4;
                Object b5 = b(i4);
                this.f21111b = C2141i.this.B(this.f21111b);
                return b5;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            boolean z4;
            a();
            if (this.f21112c >= 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            C2139g.c(z4);
            c();
            C2141i iVar = C2141i.this;
            iVar.remove(iVar.H(this.f21112c));
            this.f21111b = C2141i.this.p(this.f21111b, this.f21112c);
            this.f21112c = -1;
        }

        /* synthetic */ e(C2141i iVar, a aVar) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    public void o(int i4) {
    }
}
