package T2;

import S2.C1588b;
import S2.C1590d;
import S2.C1594h;
import S2.C1601o;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public final class b extends C1590d implements List, RandomAccess, Serializable, e3.b {

    /* renamed from: d  reason: collision with root package name */
    private static final C0111b f8317d = new C0111b((C2103g) null);

    /* renamed from: e  reason: collision with root package name */
    private static final b f8318e;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Object[] f8319a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int f8320b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f8321c;

    public static final class a extends C1590d implements List, RandomAccess, Serializable, e3.b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public Object[] f8322a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final int f8323b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public int f8324c;

        /* renamed from: d  reason: collision with root package name */
        private final a f8325d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public final b f8326e;

        /* renamed from: T2.b$a$a  reason: collision with other inner class name */
        private static final class C0110a implements ListIterator, e3.a {

            /* renamed from: a  reason: collision with root package name */
            private final a f8327a;

            /* renamed from: b  reason: collision with root package name */
            private int f8328b;

            /* renamed from: c  reason: collision with root package name */
            private int f8329c = -1;

            /* renamed from: d  reason: collision with root package name */
            private int f8330d;

            public C0110a(a aVar, int i4) {
                m.e(aVar, "list");
                this.f8327a = aVar;
                this.f8328b = i4;
                this.f8330d = aVar.modCount;
            }

            private final void a() {
                if (this.f8327a.f8326e.modCount != this.f8330d) {
                    throw new ConcurrentModificationException();
                }
            }

            public void add(Object obj) {
                a();
                a aVar = this.f8327a;
                int i4 = this.f8328b;
                this.f8328b = i4 + 1;
                aVar.add(i4, obj);
                this.f8329c = -1;
                this.f8330d = this.f8327a.modCount;
            }

            public boolean hasNext() {
                if (this.f8328b < this.f8327a.f8324c) {
                    return true;
                }
                return false;
            }

            public boolean hasPrevious() {
                if (this.f8328b > 0) {
                    return true;
                }
                return false;
            }

            public Object next() {
                a();
                if (this.f8328b < this.f8327a.f8324c) {
                    int i4 = this.f8328b;
                    this.f8328b = i4 + 1;
                    this.f8329c = i4;
                    return this.f8327a.f8322a[this.f8327a.f8323b + this.f8329c];
                }
                throw new NoSuchElementException();
            }

            public int nextIndex() {
                return this.f8328b;
            }

            public Object previous() {
                a();
                int i4 = this.f8328b;
                if (i4 > 0) {
                    int i5 = i4 - 1;
                    this.f8328b = i5;
                    this.f8329c = i5;
                    return this.f8327a.f8322a[this.f8327a.f8323b + this.f8329c];
                }
                throw new NoSuchElementException();
            }

            public int previousIndex() {
                return this.f8328b - 1;
            }

            public void remove() {
                a();
                int i4 = this.f8329c;
                if (i4 != -1) {
                    this.f8327a.remove(i4);
                    this.f8328b = this.f8329c;
                    this.f8329c = -1;
                    this.f8330d = this.f8327a.modCount;
                    return;
                }
                throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
            }

            public void set(Object obj) {
                a();
                int i4 = this.f8329c;
                if (i4 != -1) {
                    this.f8327a.set(i4, obj);
                    return;
                }
                throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
            }
        }

        public a(Object[] objArr, int i4, int i5, a aVar, b bVar) {
            m.e(objArr, "backing");
            m.e(bVar, "root");
            this.f8322a = objArr;
            this.f8323b = i4;
            this.f8324c = i5;
            this.f8325d = aVar;
            this.f8326e = bVar;
            this.modCount = bVar.modCount;
        }

        private final void o(int i4, Collection collection, int i5) {
            u();
            a aVar = this.f8325d;
            if (aVar != null) {
                aVar.o(i4, collection, i5);
            } else {
                this.f8326e.s(i4, collection, i5);
            }
            this.f8322a = this.f8326e.f8319a;
            this.f8324c += i5;
        }

        private final void p(int i4, Object obj) {
            u();
            a aVar = this.f8325d;
            if (aVar != null) {
                aVar.p(i4, obj);
            } else {
                this.f8326e.t(i4, obj);
            }
            this.f8322a = this.f8326e.f8319a;
            this.f8324c++;
        }

        private final void q() {
            if (this.f8326e.modCount != this.modCount) {
                throw new ConcurrentModificationException();
            }
        }

        private final void r() {
            if (t()) {
                throw new UnsupportedOperationException();
            }
        }

        private final boolean s(List list) {
            return c.h(this.f8322a, this.f8323b, this.f8324c, list);
        }

        private final boolean t() {
            return this.f8326e.f8321c;
        }

        private final void u() {
            this.modCount++;
        }

        private final Object v(int i4) {
            Object obj;
            u();
            a aVar = this.f8325d;
            if (aVar != null) {
                obj = aVar.v(i4);
            } else {
                obj = this.f8326e.D(i4);
            }
            this.f8324c--;
            return obj;
        }

        private final void w(int i4, int i5) {
            if (i5 > 0) {
                u();
            }
            a aVar = this.f8325d;
            if (aVar != null) {
                aVar.w(i4, i5);
            } else {
                this.f8326e.E(i4, i5);
            }
            this.f8324c -= i5;
        }

        private final int x(int i4, int i5, Collection collection, boolean z4) {
            int i6;
            a aVar = this.f8325d;
            if (aVar != null) {
                i6 = aVar.x(i4, i5, collection, z4);
            } else {
                i6 = this.f8326e.F(i4, i5, collection, z4);
            }
            if (i6 > 0) {
                u();
            }
            this.f8324c -= i6;
            return i6;
        }

        public boolean add(Object obj) {
            r();
            q();
            p(this.f8323b + this.f8324c, obj);
            return true;
        }

        public boolean addAll(Collection collection) {
            m.e(collection, "elements");
            r();
            q();
            int size = collection.size();
            o(this.f8323b + this.f8324c, collection, size);
            return size > 0;
        }

        public int c() {
            q();
            return this.f8324c;
        }

        public void clear() {
            r();
            q();
            w(this.f8323b, this.f8324c);
        }

        public boolean equals(Object obj) {
            q();
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof List) || !s((List) obj)) {
                return false;
            }
            return true;
        }

        public Object get(int i4) {
            q();
            C1588b.f8237a.b(i4, this.f8324c);
            return this.f8322a[this.f8323b + i4];
        }

        public Object h(int i4) {
            r();
            q();
            C1588b.f8237a.b(i4, this.f8324c);
            return v(this.f8323b + i4);
        }

        public int hashCode() {
            q();
            return c.i(this.f8322a, this.f8323b, this.f8324c);
        }

        public int indexOf(Object obj) {
            q();
            for (int i4 = 0; i4 < this.f8324c; i4++) {
                if (m.a(this.f8322a[this.f8323b + i4], obj)) {
                    return i4;
                }
            }
            return -1;
        }

        public boolean isEmpty() {
            q();
            if (this.f8324c == 0) {
                return true;
            }
            return false;
        }

        public Iterator iterator() {
            return listIterator(0);
        }

        public int lastIndexOf(Object obj) {
            q();
            for (int i4 = this.f8324c - 1; i4 >= 0; i4--) {
                if (m.a(this.f8322a[this.f8323b + i4], obj)) {
                    return i4;
                }
            }
            return -1;
        }

        public ListIterator listIterator() {
            return listIterator(0);
        }

        public boolean remove(Object obj) {
            r();
            q();
            int indexOf = indexOf(obj);
            if (indexOf >= 0) {
                remove(indexOf);
            }
            if (indexOf >= 0) {
                return true;
            }
            return false;
        }

        public boolean removeAll(Collection collection) {
            m.e(collection, "elements");
            r();
            q();
            if (x(this.f8323b, this.f8324c, collection, false) > 0) {
                return true;
            }
            return false;
        }

        public boolean retainAll(Collection collection) {
            m.e(collection, "elements");
            r();
            q();
            if (x(this.f8323b, this.f8324c, collection, true) > 0) {
                return true;
            }
            return false;
        }

        public Object set(int i4, Object obj) {
            r();
            q();
            C1588b.f8237a.b(i4, this.f8324c);
            Object[] objArr = this.f8322a;
            int i5 = this.f8323b;
            Object obj2 = objArr[i5 + i4];
            objArr[i5 + i4] = obj;
            return obj2;
        }

        public List subList(int i4, int i5) {
            C1588b.f8237a.d(i4, i5, this.f8324c);
            return new a(this.f8322a, this.f8323b + i4, i5 - i4, this, this.f8326e);
        }

        public Object[] toArray(Object[] objArr) {
            m.e(objArr, "array");
            q();
            int length = objArr.length;
            int i4 = this.f8324c;
            if (length < i4) {
                Object[] objArr2 = this.f8322a;
                int i5 = this.f8323b;
                Object[] copyOfRange = Arrays.copyOfRange(objArr2, i5, i4 + i5, objArr.getClass());
                m.d(copyOfRange, "copyOfRange(...)");
                return copyOfRange;
            }
            Object[] objArr3 = this.f8322a;
            int i6 = this.f8323b;
            C1594h.e(objArr3, objArr, 0, i6, i4 + i6);
            return C1601o.f(this.f8324c, objArr);
        }

        public String toString() {
            q();
            return c.j(this.f8322a, this.f8323b, this.f8324c, this);
        }

        public ListIterator listIterator(int i4) {
            q();
            C1588b.f8237a.c(i4, this.f8324c);
            return new C0110a(this, i4);
        }

        public void add(int i4, Object obj) {
            r();
            q();
            C1588b.f8237a.c(i4, this.f8324c);
            p(this.f8323b + i4, obj);
        }

        public boolean addAll(int i4, Collection collection) {
            m.e(collection, "elements");
            r();
            q();
            C1588b.f8237a.c(i4, this.f8324c);
            int size = collection.size();
            o(this.f8323b + i4, collection, size);
            return size > 0;
        }

        public Object[] toArray() {
            q();
            Object[] objArr = this.f8322a;
            int i4 = this.f8323b;
            return C1594h.i(objArr, i4, this.f8324c + i4);
        }
    }

    /* renamed from: T2.b$b  reason: collision with other inner class name */
    private static final class C0111b {
        public /* synthetic */ C0111b(C2103g gVar) {
            this();
        }

        private C0111b() {
        }
    }

    private static final class c implements ListIterator, e3.a {

        /* renamed from: a  reason: collision with root package name */
        private final b f8331a;

        /* renamed from: b  reason: collision with root package name */
        private int f8332b;

        /* renamed from: c  reason: collision with root package name */
        private int f8333c = -1;

        /* renamed from: d  reason: collision with root package name */
        private int f8334d;

        public c(b bVar, int i4) {
            m.e(bVar, "list");
            this.f8331a = bVar;
            this.f8332b = i4;
            this.f8334d = bVar.modCount;
        }

        private final void a() {
            if (this.f8331a.modCount != this.f8334d) {
                throw new ConcurrentModificationException();
            }
        }

        public void add(Object obj) {
            a();
            b bVar = this.f8331a;
            int i4 = this.f8332b;
            this.f8332b = i4 + 1;
            bVar.add(i4, obj);
            this.f8333c = -1;
            this.f8334d = this.f8331a.modCount;
        }

        public boolean hasNext() {
            if (this.f8332b < this.f8331a.f8320b) {
                return true;
            }
            return false;
        }

        public boolean hasPrevious() {
            if (this.f8332b > 0) {
                return true;
            }
            return false;
        }

        public Object next() {
            a();
            if (this.f8332b < this.f8331a.f8320b) {
                int i4 = this.f8332b;
                this.f8332b = i4 + 1;
                this.f8333c = i4;
                return this.f8331a.f8319a[this.f8333c];
            }
            throw new NoSuchElementException();
        }

        public int nextIndex() {
            return this.f8332b;
        }

        public Object previous() {
            a();
            int i4 = this.f8332b;
            if (i4 > 0) {
                int i5 = i4 - 1;
                this.f8332b = i5;
                this.f8333c = i5;
                return this.f8331a.f8319a[this.f8333c];
            }
            throw new NoSuchElementException();
        }

        public int previousIndex() {
            return this.f8332b - 1;
        }

        public void remove() {
            a();
            int i4 = this.f8333c;
            if (i4 != -1) {
                this.f8331a.remove(i4);
                this.f8332b = this.f8333c;
                this.f8333c = -1;
                this.f8334d = this.f8331a.modCount;
                return;
            }
            throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
        }

        public void set(Object obj) {
            a();
            int i4 = this.f8333c;
            if (i4 != -1) {
                this.f8331a.set(i4, obj);
                return;
            }
            throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
        }
    }

    static {
        b bVar = new b(0);
        bVar.f8321c = true;
        f8318e = bVar;
    }

    public b(int i4) {
        this.f8319a = c.d(i4);
    }

    private final void C() {
        this.modCount++;
    }

    /* access modifiers changed from: private */
    public final Object D(int i4) {
        C();
        Object[] objArr = this.f8319a;
        Object obj = objArr[i4];
        C1594h.e(objArr, objArr, i4, i4 + 1, this.f8320b);
        c.f(this.f8319a, this.f8320b - 1);
        this.f8320b--;
        return obj;
    }

    /* access modifiers changed from: private */
    public final void E(int i4, int i5) {
        if (i5 > 0) {
            C();
        }
        Object[] objArr = this.f8319a;
        C1594h.e(objArr, objArr, i4, i4 + i5, this.f8320b);
        Object[] objArr2 = this.f8319a;
        int i6 = this.f8320b;
        c.g(objArr2, i6 - i5, i6);
        this.f8320b -= i5;
    }

    /* access modifiers changed from: private */
    public final int F(int i4, int i5, Collection collection, boolean z4) {
        int i6 = 0;
        int i7 = 0;
        while (i6 < i5) {
            int i8 = i4 + i6;
            if (collection.contains(this.f8319a[i8]) == z4) {
                Object[] objArr = this.f8319a;
                i6++;
                objArr[i7 + i4] = objArr[i8];
                i7++;
            } else {
                i6++;
            }
        }
        int i9 = i5 - i7;
        Object[] objArr2 = this.f8319a;
        C1594h.e(objArr2, objArr2, i4 + i7, i5 + i4, this.f8320b);
        Object[] objArr3 = this.f8319a;
        int i10 = this.f8320b;
        c.g(objArr3, i10 - i9, i10);
        if (i9 > 0) {
            C();
        }
        this.f8320b -= i9;
        return i9;
    }

    /* access modifiers changed from: private */
    public final void s(int i4, Collection collection, int i5) {
        C();
        z(i4, i5);
        Iterator it = collection.iterator();
        for (int i6 = 0; i6 < i5; i6++) {
            this.f8319a[i4 + i6] = it.next();
        }
    }

    /* access modifiers changed from: private */
    public final void t(int i4, Object obj) {
        C();
        z(i4, 1);
        this.f8319a[i4] = obj;
    }

    private final void v() {
        if (this.f8321c) {
            throw new UnsupportedOperationException();
        }
    }

    private final boolean w(List list) {
        return c.h(this.f8319a, 0, this.f8320b, list);
    }

    private final void x(int i4) {
        if (i4 >= 0) {
            Object[] objArr = this.f8319a;
            if (i4 > objArr.length) {
                this.f8319a = c.e(this.f8319a, C1588b.f8237a.e(objArr.length, i4));
                return;
            }
            return;
        }
        throw new OutOfMemoryError();
    }

    private final void y(int i4) {
        x(this.f8320b + i4);
    }

    private final void z(int i4, int i5) {
        y(i5);
        Object[] objArr = this.f8319a;
        C1594h.e(objArr, objArr, i4 + i5, i4, this.f8320b);
        this.f8320b += i5;
    }

    public boolean add(Object obj) {
        v();
        t(this.f8320b, obj);
        return true;
    }

    public boolean addAll(Collection collection) {
        m.e(collection, "elements");
        v();
        int size = collection.size();
        s(this.f8320b, collection, size);
        return size > 0;
    }

    public int c() {
        return this.f8320b;
    }

    public void clear() {
        v();
        E(0, this.f8320b);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List) || !w((List) obj)) {
            return false;
        }
        return true;
    }

    public Object get(int i4) {
        C1588b.f8237a.b(i4, this.f8320b);
        return this.f8319a[i4];
    }

    public Object h(int i4) {
        v();
        C1588b.f8237a.b(i4, this.f8320b);
        return D(i4);
    }

    public int hashCode() {
        return c.i(this.f8319a, 0, this.f8320b);
    }

    public int indexOf(Object obj) {
        for (int i4 = 0; i4 < this.f8320b; i4++) {
            if (m.a(this.f8319a[i4], obj)) {
                return i4;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        if (this.f8320b == 0) {
            return true;
        }
        return false;
    }

    public Iterator iterator() {
        return listIterator(0);
    }

    public int lastIndexOf(Object obj) {
        for (int i4 = this.f8320b - 1; i4 >= 0; i4--) {
            if (m.a(this.f8319a[i4], obj)) {
                return i4;
            }
        }
        return -1;
    }

    public ListIterator listIterator() {
        return listIterator(0);
    }

    public boolean remove(Object obj) {
        v();
        int indexOf = indexOf(obj);
        if (indexOf >= 0) {
            remove(indexOf);
        }
        if (indexOf >= 0) {
            return true;
        }
        return false;
    }

    public boolean removeAll(Collection collection) {
        m.e(collection, "elements");
        v();
        if (F(0, this.f8320b, collection, false) > 0) {
            return true;
        }
        return false;
    }

    public boolean retainAll(Collection collection) {
        m.e(collection, "elements");
        v();
        if (F(0, this.f8320b, collection, true) > 0) {
            return true;
        }
        return false;
    }

    public Object set(int i4, Object obj) {
        v();
        C1588b.f8237a.b(i4, this.f8320b);
        Object[] objArr = this.f8319a;
        Object obj2 = objArr[i4];
        objArr[i4] = obj;
        return obj2;
    }

    public List subList(int i4, int i5) {
        C1588b.f8237a.d(i4, i5, this.f8320b);
        return new a(this.f8319a, i4, i5 - i4, (a) null, this);
    }

    public Object[] toArray(Object[] objArr) {
        m.e(objArr, "array");
        int length = objArr.length;
        int i4 = this.f8320b;
        if (length < i4) {
            Object[] copyOfRange = Arrays.copyOfRange(this.f8319a, 0, i4, objArr.getClass());
            m.d(copyOfRange, "copyOfRange(...)");
            return copyOfRange;
        }
        C1594h.e(this.f8319a, objArr, 0, 0, i4);
        return C1601o.f(this.f8320b, objArr);
    }

    public String toString() {
        return c.j(this.f8319a, 0, this.f8320b, this);
    }

    public final List u() {
        v();
        this.f8321c = true;
        if (this.f8320b > 0) {
            return this;
        }
        return f8318e;
    }

    public ListIterator listIterator(int i4) {
        C1588b.f8237a.c(i4, this.f8320b);
        return new c(this, i4);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(int i4, int i5, C2103g gVar) {
        this((i5 & 1) != 0 ? 10 : i4);
    }

    public void add(int i4, Object obj) {
        v();
        C1588b.f8237a.c(i4, this.f8320b);
        t(i4, obj);
    }

    public boolean addAll(int i4, Collection collection) {
        m.e(collection, "elements");
        v();
        C1588b.f8237a.c(i4, this.f8320b);
        int size = collection.size();
        s(i4, collection, size);
        return size > 0;
    }

    public Object[] toArray() {
        return C1594h.i(this.f8319a, 0, this.f8320b);
    }
}
