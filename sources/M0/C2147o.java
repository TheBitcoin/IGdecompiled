package m0;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import l0.h;
import m0.C2146n;

/* renamed from: m0.o  reason: case insensitive filesystem */
public abstract class C2147o extends C2146n implements List, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final T f21125b = new b(I.f21052e, 0);

    /* renamed from: m0.o$a */
    public static final class a extends C2146n.a {
        public a() {
            this(4);
        }

        public a e(Object... objArr) {
            super.b(objArr);
            return this;
        }

        public C2147o f() {
            this.f21124c = true;
            return C2147o.m(this.f21122a, this.f21123b);
        }

        a(int i4) {
            super(i4);
        }
    }

    /* renamed from: m0.o$b */
    static class b extends C2133a {

        /* renamed from: c  reason: collision with root package name */
        private final C2147o f21126c;

        b(C2147o oVar, int i4) {
            super(oVar.size(), i4);
            this.f21126c = oVar;
        }

        /* access modifiers changed from: protected */
        public Object a(int i4) {
            return this.f21126c.get(i4);
        }
    }

    /* renamed from: m0.o$c */
    private static class c extends C2147o {

        /* renamed from: c  reason: collision with root package name */
        private final transient C2147o f21127c;

        c(C2147o oVar) {
            this.f21127c = oVar;
        }

        private int C(int i4) {
            return size() - i4;
        }

        private int z(int i4) {
            return (size() - 1) - i4;
        }

        public boolean contains(Object obj) {
            return this.f21127c.contains(obj);
        }

        public Object get(int i4) {
            h.g(i4, size());
            return this.f21127c.get(z(i4));
        }

        public int indexOf(Object obj) {
            int lastIndexOf = this.f21127c.lastIndexOf(obj);
            if (lastIndexOf >= 0) {
                return z(lastIndexOf);
            }
            return -1;
        }

        public /* bridge */ /* synthetic */ Iterator iterator() {
            return C2147o.super.iterator();
        }

        /* access modifiers changed from: package-private */
        public boolean k() {
            return this.f21127c.k();
        }

        public int lastIndexOf(Object obj) {
            int indexOf = this.f21127c.indexOf(obj);
            if (indexOf >= 0) {
                return z(indexOf);
            }
            return -1;
        }

        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return C2147o.super.listIterator();
        }

        public int size() {
            return this.f21127c.size();
        }

        public C2147o v() {
            return this.f21127c;
        }

        /* renamed from: x */
        public C2147o subList(int i4, int i5) {
            h.m(i4, i5, size());
            return this.f21127c.subList(C(i5), C(i4)).v();
        }

        public /* bridge */ /* synthetic */ ListIterator listIterator(int i4) {
            return C2147o.super.listIterator(i4);
        }
    }

    /* renamed from: m0.o$d */
    class d extends C2147o {

        /* renamed from: c  reason: collision with root package name */
        final transient int f21128c;

        /* renamed from: d  reason: collision with root package name */
        final transient int f21129d;

        d(int i4, int i5) {
            this.f21128c = i4;
            this.f21129d = i5;
        }

        /* access modifiers changed from: package-private */
        public Object[] g() {
            return C2147o.this.g();
        }

        public Object get(int i4) {
            h.g(i4, this.f21129d);
            return C2147o.this.get(i4 + this.f21128c);
        }

        /* access modifiers changed from: package-private */
        public int h() {
            return C2147o.this.j() + this.f21128c + this.f21129d;
        }

        public /* bridge */ /* synthetic */ Iterator iterator() {
            return C2147o.super.iterator();
        }

        /* access modifiers changed from: package-private */
        public int j() {
            return C2147o.this.j() + this.f21128c;
        }

        /* access modifiers changed from: package-private */
        public boolean k() {
            return true;
        }

        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return C2147o.super.listIterator();
        }

        public int size() {
            return this.f21129d;
        }

        /* renamed from: x */
        public C2147o subList(int i4, int i5) {
            h.m(i4, i5, this.f21129d);
            C2147o oVar = C2147o.this;
            int i6 = this.f21128c;
            return oVar.subList(i4 + i6, i5 + i6);
        }

        public /* bridge */ /* synthetic */ ListIterator listIterator(int i4) {
            return C2147o.super.listIterator(i4);
        }
    }

    C2147o() {
    }

    static C2147o l(Object[] objArr) {
        return m(objArr, objArr.length);
    }

    static C2147o m(Object[] objArr, int i4) {
        if (i4 == 0) {
            return r();
        }
        return new I(objArr, i4);
    }

    private static C2147o n(Object... objArr) {
        return l(C2132F.b(objArr));
    }

    public static C2147o r() {
        return I.f21052e;
    }

    public static C2147o s(Object obj, Object obj2) {
        return n(obj, obj2);
    }

    public static C2147o t(Object obj, Object obj2, Object obj3) {
        return n(obj, obj2, obj3);
    }

    public static C2147o u(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        return n(obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    public static C2147o w(Comparator comparator, Iterable iterable) {
        h.i(comparator);
        Object[] b5 = v.b(iterable);
        C2132F.b(b5);
        Arrays.sort(b5, comparator);
        return l(b5);
    }

    public final void add(int i4, Object obj) {
        throw new UnsupportedOperationException();
    }

    public final boolean addAll(int i4, Collection collection) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public int c(Object[] objArr, int i4) {
        int size = size();
        for (int i5 = 0; i5 < size; i5++) {
            objArr[i4 + i5] = get(i5);
        }
        return i4 + size;
    }

    public boolean contains(Object obj) {
        if (indexOf(obj) >= 0) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        return x.a(this, obj);
    }

    public int hashCode() {
        int size = size();
        int i4 = 1;
        for (int i5 = 0; i5 < size; i5++) {
            i4 = ~(~((i4 * 31) + get(i5).hashCode()));
        }
        return i4;
    }

    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return x.b(this, obj);
    }

    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return x.d(this, obj);
    }

    /* renamed from: o */
    public S iterator() {
        return listIterator();
    }

    /* renamed from: p */
    public T listIterator() {
        return listIterator(0);
    }

    /* renamed from: q */
    public T listIterator(int i4) {
        h.k(i4, size());
        if (isEmpty()) {
            return f21125b;
        }
        return new b(this, i4);
    }

    public final Object remove(int i4) {
        throw new UnsupportedOperationException();
    }

    public final Object set(int i4, Object obj) {
        throw new UnsupportedOperationException();
    }

    public C2147o v() {
        if (size() <= 1) {
            return this;
        }
        return new c(this);
    }

    /* renamed from: x */
    public C2147o subList(int i4, int i5) {
        h.m(i4, i5, size());
        int i6 = i5 - i4;
        if (i6 == size()) {
            return this;
        }
        if (i6 == 0) {
            return r();
        }
        return y(i4, i5);
    }

    /* access modifiers changed from: package-private */
    public C2147o y(int i4, int i5) {
        return new d(i4, i5 - i4);
    }
}
