package m0;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import l0.h;

public abstract class M {

    class a extends b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Set f21078a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Set f21079b;

        /* renamed from: m0.M$a$a  reason: collision with other inner class name */
        class C0261a extends C2134b {

            /* renamed from: c  reason: collision with root package name */
            final Iterator f21080c;

            /* renamed from: d  reason: collision with root package name */
            final Iterator f21081d;

            C0261a() {
                this.f21080c = a.this.f21078a.iterator();
                this.f21081d = a.this.f21079b.iterator();
            }

            /* access modifiers changed from: protected */
            public Object a() {
                if (this.f21080c.hasNext()) {
                    return this.f21080c.next();
                }
                while (this.f21081d.hasNext()) {
                    Object next = this.f21081d.next();
                    if (!a.this.f21078a.contains(next)) {
                        return next;
                    }
                }
                return b();
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Set set, Set set2) {
            super((a) null);
            this.f21078a = set;
            this.f21079b = set2;
        }

        /* renamed from: c */
        public S iterator() {
            return new C0261a();
        }

        public boolean contains(Object obj) {
            if (this.f21078a.contains(obj) || this.f21079b.contains(obj)) {
                return true;
            }
            return false;
        }

        public boolean isEmpty() {
            if (!this.f21078a.isEmpty() || !this.f21079b.isEmpty()) {
                return false;
            }
            return true;
        }

        public int size() {
            int size = this.f21078a.size();
            for (Object contains : this.f21079b) {
                if (!this.f21078a.contains(contains)) {
                    size++;
                }
            }
            return size;
        }
    }

    public static abstract class b extends AbstractSet {
        /* synthetic */ b(a aVar) {
            this();
        }

        public final boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        public final boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        public abstract S c();

        public final void clear() {
            throw new UnsupportedOperationException();
        }

        public final boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        public final boolean removeAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        public final boolean retainAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        private b() {
        }
    }

    static boolean a(Set set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() != set2.size() || !set.containsAll(set2)) {
                    return false;
                }
                return true;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    static int b(Set set) {
        int i4;
        int i5 = 0;
        for (Object next : set) {
            if (next != null) {
                i4 = next.hashCode();
            } else {
                i4 = 0;
            }
            i5 = ~(~(i5 + i4));
        }
        return i5;
    }

    public static b c(Set set, Set set2) {
        h.j(set, "set1");
        h.j(set2, "set2");
        return new a(set, set2);
    }
}
