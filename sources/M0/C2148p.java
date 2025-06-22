package m0;

import j$.util.Map;
import j$.util.Objects;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import m0.C2146n;

/* renamed from: m0.p  reason: case insensitive filesystem */
public abstract class C2148p implements Map, Serializable, j$.util.Map {

    /* renamed from: d  reason: collision with root package name */
    static final Map.Entry[] f21131d = new Map.Entry[0];

    /* renamed from: a  reason: collision with root package name */
    private transient r f21132a;

    /* renamed from: b  reason: collision with root package name */
    private transient r f21133b;

    /* renamed from: c  reason: collision with root package name */
    private transient C2146n f21134c;

    /* renamed from: m0.p$a */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        Comparator f21135a;

        /* renamed from: b  reason: collision with root package name */
        Object[] f21136b;

        /* renamed from: c  reason: collision with root package name */
        int f21137c = 0;

        /* renamed from: d  reason: collision with root package name */
        boolean f21138d = false;

        /* renamed from: e  reason: collision with root package name */
        C0263a f21139e;

        /* renamed from: m0.p$a$a  reason: collision with other inner class name */
        static final class C0263a {

            /* renamed from: a  reason: collision with root package name */
            private final Object f21140a;

            /* renamed from: b  reason: collision with root package name */
            private final Object f21141b;

            /* renamed from: c  reason: collision with root package name */
            private final Object f21142c;

            C0263a(Object obj, Object obj2, Object obj3) {
                this.f21140a = obj;
                this.f21141b = obj2;
                this.f21142c = obj3;
            }

            /* access modifiers changed from: package-private */
            public IllegalArgumentException a() {
                String valueOf = String.valueOf(this.f21140a);
                String valueOf2 = String.valueOf(this.f21141b);
                String valueOf3 = String.valueOf(this.f21140a);
                String valueOf4 = String.valueOf(this.f21142c);
                StringBuilder sb = new StringBuilder(valueOf.length() + 39 + valueOf2.length() + valueOf3.length() + valueOf4.length());
                sb.append("Multiple entries with same key: ");
                sb.append(valueOf);
                sb.append("=");
                sb.append(valueOf2);
                sb.append(" and ");
                sb.append(valueOf3);
                sb.append("=");
                sb.append(valueOf4);
                return new IllegalArgumentException(sb.toString());
            }
        }

        a(int i4) {
            this.f21136b = new Object[(i4 * 2)];
        }

        private C2148p a(boolean z4) {
            Object[] objArr;
            C0263a aVar;
            C0263a aVar2;
            if (!z4 || (aVar2 = this.f21139e) == null) {
                int i4 = this.f21137c;
                if (this.f21135a == null) {
                    objArr = this.f21136b;
                } else {
                    if (this.f21138d) {
                        this.f21136b = Arrays.copyOf(this.f21136b, i4 * 2);
                    }
                    objArr = this.f21136b;
                    if (!z4) {
                        objArr = d(objArr, this.f21137c);
                        if (objArr.length < this.f21136b.length) {
                            i4 = objArr.length >>> 1;
                        }
                    }
                    f(objArr, i4, this.f21135a);
                }
                this.f21138d = true;
                J i5 = J.i(i4, objArr, this);
                if (!z4 || (aVar = this.f21139e) == null) {
                    return i5;
                }
                throw aVar.a();
            }
            throw aVar2.a();
        }

        private void c(int i4) {
            int i5 = i4 * 2;
            Object[] objArr = this.f21136b;
            if (i5 > objArr.length) {
                this.f21136b = Arrays.copyOf(objArr, C2146n.b.a(objArr.length, i5));
                this.f21138d = false;
            }
        }

        private Object[] d(Object[] objArr, int i4) {
            HashSet hashSet = new HashSet();
            BitSet bitSet = new BitSet();
            for (int i5 = i4 - 1; i5 >= 0; i5--) {
                Object obj = objArr[i5 * 2];
                Objects.requireNonNull(obj);
                if (!hashSet.add(obj)) {
                    bitSet.set(i5);
                }
            }
            if (bitSet.isEmpty()) {
                return objArr;
            }
            Object[] objArr2 = new Object[((i4 - bitSet.cardinality()) * 2)];
            int i6 = 0;
            int i7 = 0;
            while (i6 < i4 * 2) {
                if (bitSet.get(i6 >>> 1)) {
                    i6 += 2;
                } else {
                    int i8 = i7 + 1;
                    int i9 = i6 + 1;
                    Object obj2 = objArr[i6];
                    Objects.requireNonNull(obj2);
                    objArr2[i7] = obj2;
                    i7 += 2;
                    i6 += 2;
                    Object obj3 = objArr[i9];
                    Objects.requireNonNull(obj3);
                    objArr2[i8] = obj3;
                }
            }
            return objArr2;
        }

        static void f(Object[] objArr, int i4, Comparator comparator) {
            Map.Entry[] entryArr = new Map.Entry[i4];
            for (int i5 = 0; i5 < i4; i5++) {
                int i6 = i5 * 2;
                Object obj = objArr[i6];
                Objects.requireNonNull(obj);
                Object obj2 = objArr[i6 + 1];
                Objects.requireNonNull(obj2);
                entryArr[i5] = new AbstractMap.SimpleImmutableEntry(obj, obj2);
            }
            Arrays.sort(entryArr, 0, i4, G.a(comparator).e(z.d()));
            for (int i7 = 0; i7 < i4; i7++) {
                int i8 = i7 * 2;
                objArr[i8] = entryArr[i7].getKey();
                objArr[i8 + 1] = entryArr[i7].getValue();
            }
        }

        public C2148p b() {
            return a(true);
        }

        public a e(Object obj, Object obj2) {
            c(this.f21137c + 1);
            C2139g.a(obj, obj2);
            Object[] objArr = this.f21136b;
            int i4 = this.f21137c;
            objArr[i4 * 2] = obj;
            objArr[(i4 * 2) + 1] = obj2;
            this.f21137c = i4 + 1;
            return this;
        }
    }

    C2148p() {
    }

    public static C2148p f() {
        return J.f21055h;
    }

    /* access modifiers changed from: package-private */
    public abstract r a();

    /* access modifiers changed from: package-private */
    public abstract r b();

    /* access modifiers changed from: package-private */
    public abstract C2146n c();

    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
        return Map.CC.$default$compute(this, obj, biFunction);
    }

    public /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
        return Map.CC.$default$computeIfAbsent(this, obj, function);
    }

    public /* synthetic */ Object computeIfPresent(Object obj, BiFunction biFunction) {
        return Map.CC.$default$computeIfPresent(this, obj, biFunction);
    }

    public boolean containsKey(Object obj) {
        if (get(obj) != null) {
            return true;
        }
        return false;
    }

    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    /* renamed from: d */
    public r entrySet() {
        r rVar = this.f21132a;
        if (rVar != null) {
            return rVar;
        }
        r a5 = a();
        this.f21132a = a5;
        return a5;
    }

    /* renamed from: e */
    public r keySet() {
        r rVar = this.f21133b;
        if (rVar != null) {
            return rVar;
        }
        r b5 = b();
        this.f21133b = b5;
        return b5;
    }

    public boolean equals(Object obj) {
        return z.a(this, obj);
    }

    public /* synthetic */ void forEach(BiConsumer biConsumer) {
        Map.CC.$default$forEach(this, biConsumer);
    }

    public abstract Object get(Object obj);

    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        if (obj3 != null) {
            return obj3;
        }
        return obj2;
    }

    /* renamed from: h */
    public C2146n values() {
        C2146n nVar = this.f21134c;
        if (nVar != null) {
            return nVar;
        }
        C2146n c5 = c();
        this.f21134c = c5;
        return c5;
    }

    public int hashCode() {
        return M.b(entrySet());
    }

    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        return Map.CC.$default$merge(this, obj, obj2, biFunction);
    }

    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    public final void putAll(java.util.Map map) {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
        return Map.CC.$default$putIfAbsent(this, obj, obj2);
    }

    public /* synthetic */ boolean remove(Object obj, Object obj2) {
        return Map.CC.$default$remove(this, obj, obj2);
    }

    public /* synthetic */ Object replace(Object obj, Object obj2) {
        return Map.CC.$default$replace(this, obj, obj2);
    }

    public /* synthetic */ void replaceAll(BiFunction biFunction) {
        Map.CC.$default$replaceAll(this, biFunction);
    }

    public String toString() {
        return z.c(this);
    }

    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ boolean replace(Object obj, Object obj2, Object obj3) {
        return Map.CC.$default$replace(this, obj, obj2, obj3);
    }
}
