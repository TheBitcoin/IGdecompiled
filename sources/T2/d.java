package T2;

import S2.C1588b;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public final class d implements Map, Serializable, e3.a {

    /* renamed from: n  reason: collision with root package name */
    public static final a f8335n = new a((C2103g) null);
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public static final d f8336o;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Object[] f8337a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Object[] f8338b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int[] f8339c;

    /* renamed from: d  reason: collision with root package name */
    private int[] f8340d;

    /* renamed from: e  reason: collision with root package name */
    private int f8341e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public int f8342f;

    /* renamed from: g  reason: collision with root package name */
    private int f8343g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public int f8344h;

    /* renamed from: i  reason: collision with root package name */
    private int f8345i;

    /* renamed from: j  reason: collision with root package name */
    private f f8346j;

    /* renamed from: k  reason: collision with root package name */
    private g f8347k;

    /* renamed from: l  reason: collision with root package name */
    private e f8348l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f8349m;

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        /* access modifiers changed from: private */
        public final int c(int i4) {
            return Integer.highestOneBit(j3.e.a(i4, 1) * 3);
        }

        /* access modifiers changed from: private */
        public final int d(int i4) {
            return Integer.numberOfLeadingZeros(i4) + 1;
        }

        public final d e() {
            return d.f8336o;
        }

        private a() {
        }
    }

    public static final class b extends C0112d implements Iterator, e3.a {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(d dVar) {
            super(dVar);
            m.e(dVar, "map");
        }

        /* renamed from: i */
        public c next() {
            a();
            if (b() < d().f8342f) {
                int b5 = b();
                f(b5 + 1);
                h(b5);
                c cVar = new c(d(), c());
                e();
                return cVar;
            }
            throw new NoSuchElementException();
        }

        public final void j(StringBuilder sb) {
            m.e(sb, "sb");
            if (b() < d().f8342f) {
                int b5 = b();
                f(b5 + 1);
                h(b5);
                Object obj = d().f8337a[c()];
                if (obj == d()) {
                    sb.append("(this Map)");
                } else {
                    sb.append(obj);
                }
                sb.append('=');
                Object[] h4 = d().f8338b;
                m.b(h4);
                Object obj2 = h4[c()];
                if (obj2 == d()) {
                    sb.append("(this Map)");
                } else {
                    sb.append(obj2);
                }
                e();
                return;
            }
            throw new NoSuchElementException();
        }

        public final int k() {
            int i4;
            if (b() < d().f8342f) {
                int b5 = b();
                f(b5 + 1);
                h(b5);
                Object obj = d().f8337a[c()];
                int i5 = 0;
                if (obj != null) {
                    i4 = obj.hashCode();
                } else {
                    i4 = 0;
                }
                Object[] h4 = d().f8338b;
                m.b(h4);
                Object obj2 = h4[c()];
                if (obj2 != null) {
                    i5 = obj2.hashCode();
                }
                int i6 = i4 ^ i5;
                e();
                return i6;
            }
            throw new NoSuchElementException();
        }
    }

    public static final class c implements Map.Entry, e3.a {

        /* renamed from: a  reason: collision with root package name */
        private final d f8350a;

        /* renamed from: b  reason: collision with root package name */
        private final int f8351b;

        public c(d dVar, int i4) {
            m.e(dVar, "map");
            this.f8350a = dVar;
            this.f8351b = i4;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (!m.a(entry.getKey(), getKey()) || !m.a(entry.getValue(), getValue())) {
                return false;
            }
            return true;
        }

        public Object getKey() {
            return this.f8350a.f8337a[this.f8351b];
        }

        public Object getValue() {
            Object[] h4 = this.f8350a.f8338b;
            m.b(h4);
            return h4[this.f8351b];
        }

        public int hashCode() {
            int i4;
            Object key = getKey();
            int i5 = 0;
            if (key != null) {
                i4 = key.hashCode();
            } else {
                i4 = 0;
            }
            Object value = getValue();
            if (value != null) {
                i5 = value.hashCode();
            }
            return i4 ^ i5;
        }

        public Object setValue(Object obj) {
            this.f8350a.m();
            Object[] a5 = this.f8350a.k();
            int i4 = this.f8351b;
            Object obj2 = a5[i4];
            a5[i4] = obj;
            return obj2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getKey());
            sb.append('=');
            sb.append(getValue());
            return sb.toString();
        }
    }

    /* renamed from: T2.d$d  reason: collision with other inner class name */
    public static class C0112d {

        /* renamed from: a  reason: collision with root package name */
        private final d f8352a;

        /* renamed from: b  reason: collision with root package name */
        private int f8353b;

        /* renamed from: c  reason: collision with root package name */
        private int f8354c = -1;

        /* renamed from: d  reason: collision with root package name */
        private int f8355d;

        public C0112d(d dVar) {
            m.e(dVar, "map");
            this.f8352a = dVar;
            this.f8355d = dVar.f8344h;
            e();
        }

        public final void a() {
            if (this.f8352a.f8344h != this.f8355d) {
                throw new ConcurrentModificationException();
            }
        }

        public final int b() {
            return this.f8353b;
        }

        public final int c() {
            return this.f8354c;
        }

        public final d d() {
            return this.f8352a;
        }

        public final void e() {
            while (this.f8353b < this.f8352a.f8342f) {
                int[] f4 = this.f8352a.f8339c;
                int i4 = this.f8353b;
                if (f4[i4] < 0) {
                    this.f8353b = i4 + 1;
                } else {
                    return;
                }
            }
        }

        public final void f(int i4) {
            this.f8353b = i4;
        }

        public final void h(int i4) {
            this.f8354c = i4;
        }

        public final boolean hasNext() {
            if (this.f8353b < this.f8352a.f8342f) {
                return true;
            }
            return false;
        }

        public final void remove() {
            a();
            if (this.f8354c != -1) {
                this.f8352a.m();
                this.f8352a.K(this.f8354c);
                this.f8354c = -1;
                this.f8355d = this.f8352a.f8344h;
                return;
            }
            throw new IllegalStateException("Call next() before removing element from the iterator.");
        }
    }

    public static final class e extends C0112d implements Iterator, e3.a {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(d dVar) {
            super(dVar);
            m.e(dVar, "map");
        }

        public Object next() {
            a();
            if (b() < d().f8342f) {
                int b5 = b();
                f(b5 + 1);
                h(b5);
                Object obj = d().f8337a[c()];
                e();
                return obj;
            }
            throw new NoSuchElementException();
        }
    }

    public static final class f extends C0112d implements Iterator, e3.a {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(d dVar) {
            super(dVar);
            m.e(dVar, "map");
        }

        public Object next() {
            a();
            if (b() < d().f8342f) {
                int b5 = b();
                f(b5 + 1);
                h(b5);
                Object[] h4 = d().f8338b;
                m.b(h4);
                Object obj = h4[c()];
                e();
                return obj;
            }
            throw new NoSuchElementException();
        }
    }

    static {
        d dVar = new d(0);
        dVar.f8349m = true;
        f8336o = dVar;
    }

    private d(Object[] objArr, Object[] objArr2, int[] iArr, int[] iArr2, int i4, int i5) {
        this.f8337a = objArr;
        this.f8338b = objArr2;
        this.f8339c = iArr;
        this.f8340d = iArr2;
        this.f8341e = i4;
        this.f8342f = i5;
        this.f8343g = f8335n.d(y());
    }

    private final int C(Object obj) {
        int i4;
        if (obj != null) {
            i4 = obj.hashCode();
        } else {
            i4 = 0;
        }
        return (i4 * -1640531527) >>> this.f8343g;
    }

    private final boolean E(Collection collection) {
        boolean z4 = false;
        if (collection.isEmpty()) {
            return false;
        }
        s(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (F((Map.Entry) it.next())) {
                z4 = true;
            }
        }
        return z4;
    }

    private final boolean F(Map.Entry entry) {
        int j4 = j(entry.getKey());
        Object[] k4 = k();
        if (j4 >= 0) {
            k4[j4] = entry.getValue();
            return true;
        }
        int i4 = (-j4) - 1;
        if (m.a(entry.getValue(), k4[i4])) {
            return false;
        }
        k4[i4] = entry.getValue();
        return true;
    }

    private final boolean G(int i4) {
        int C4 = C(this.f8337a[i4]);
        int i5 = this.f8341e;
        while (true) {
            int[] iArr = this.f8340d;
            if (iArr[C4] == 0) {
                iArr[C4] = i4 + 1;
                this.f8339c[i4] = C4;
                return true;
            }
            i5--;
            if (i5 < 0) {
                return false;
            }
            int i6 = C4 - 1;
            if (C4 == 0) {
                C4 = y() - 1;
            } else {
                C4 = i6;
            }
        }
    }

    private final void H() {
        this.f8344h++;
    }

    private final void I(int i4) {
        H();
        int i5 = 0;
        if (this.f8342f > size()) {
            n(false);
        }
        this.f8340d = new int[i4];
        this.f8343g = f8335n.d(i4);
        while (i5 < this.f8342f) {
            int i6 = i5 + 1;
            if (G(i5)) {
                i5 = i6;
            } else {
                throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
            }
        }
    }

    /* access modifiers changed from: private */
    public final void K(int i4) {
        c.f(this.f8337a, i4);
        Object[] objArr = this.f8338b;
        if (objArr != null) {
            c.f(objArr, i4);
        }
        L(this.f8339c[i4]);
        this.f8339c[i4] = -1;
        this.f8345i = size() - 1;
        H();
    }

    private final void L(int i4) {
        int c5 = j3.e.c(this.f8341e * 2, y() / 2);
        int i5 = 0;
        int i6 = i4;
        do {
            int i7 = i4 - 1;
            if (i4 == 0) {
                i4 = y() - 1;
            } else {
                i4 = i7;
            }
            i5++;
            if (i5 > this.f8341e) {
                this.f8340d[i6] = 0;
                return;
            }
            int[] iArr = this.f8340d;
            int i8 = iArr[i4];
            if (i8 == 0) {
                iArr[i6] = 0;
                return;
            }
            if (i8 < 0) {
                iArr[i6] = -1;
            } else {
                int i9 = i8 - 1;
                if (((C(this.f8337a[i9]) - i4) & (y() - 1)) >= i5) {
                    this.f8340d[i6] = i8;
                    this.f8339c[i9] = i6;
                }
                c5--;
            }
            i6 = i4;
            i5 = 0;
            c5--;
        } while (c5 >= 0);
        this.f8340d[i6] = -1;
    }

    private final boolean O(int i4) {
        int w4 = w();
        int i5 = this.f8342f;
        int i6 = w4 - i5;
        int size = i5 - size();
        if (i6 >= i4 || i6 + size < i4 || size < w() / 4) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public final Object[] k() {
        Object[] objArr = this.f8338b;
        if (objArr != null) {
            return objArr;
        }
        Object[] d5 = c.d(w());
        this.f8338b = d5;
        return d5;
    }

    private final void n(boolean z4) {
        int i4;
        Object[] objArr = this.f8338b;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            i4 = this.f8342f;
            if (i5 >= i4) {
                break;
            }
            int[] iArr = this.f8339c;
            int i7 = iArr[i5];
            if (i7 >= 0) {
                Object[] objArr2 = this.f8337a;
                objArr2[i6] = objArr2[i5];
                if (objArr != null) {
                    objArr[i6] = objArr[i5];
                }
                if (z4) {
                    iArr[i6] = i7;
                    this.f8340d[i7] = i6 + 1;
                }
                i6++;
            }
            i5++;
        }
        c.g(this.f8337a, i6, i4);
        if (objArr != null) {
            c.g(objArr, i6, this.f8342f);
        }
        this.f8342f = i6;
    }

    private final boolean q(Map map) {
        if (size() != map.size() || !o(map.entrySet())) {
            return false;
        }
        return true;
    }

    private final void r(int i4) {
        Object[] objArr;
        if (i4 < 0) {
            throw new OutOfMemoryError();
        } else if (i4 > w()) {
            int e5 = C1588b.f8237a.e(w(), i4);
            this.f8337a = c.e(this.f8337a, e5);
            Object[] objArr2 = this.f8338b;
            if (objArr2 != null) {
                objArr = c.e(objArr2, e5);
            } else {
                objArr = null;
            }
            this.f8338b = objArr;
            int[] copyOf = Arrays.copyOf(this.f8339c, e5);
            m.d(copyOf, "copyOf(...)");
            this.f8339c = copyOf;
            int a5 = f8335n.c(e5);
            if (a5 > y()) {
                I(a5);
            }
        }
    }

    private final void s(int i4) {
        if (O(i4)) {
            n(true);
        } else {
            r(this.f8342f + i4);
        }
    }

    private final int u(Object obj) {
        int C4 = C(obj);
        int i4 = this.f8341e;
        while (true) {
            int i5 = this.f8340d[C4];
            if (i5 == 0) {
                return -1;
            }
            if (i5 > 0) {
                int i6 = i5 - 1;
                if (m.a(this.f8337a[i6], obj)) {
                    return i6;
                }
            }
            i4--;
            if (i4 < 0) {
                return -1;
            }
            int i7 = C4 - 1;
            if (C4 == 0) {
                C4 = y() - 1;
            } else {
                C4 = i7;
            }
        }
    }

    private final int v(Object obj) {
        int i4 = this.f8342f;
        while (true) {
            i4--;
            if (i4 < 0) {
                return -1;
            }
            if (this.f8339c[i4] >= 0) {
                Object[] objArr = this.f8338b;
                m.b(objArr);
                if (m.a(objArr[i4], obj)) {
                    return i4;
                }
            }
        }
    }

    private final int y() {
        return this.f8340d.length;
    }

    public int A() {
        return this.f8345i;
    }

    public Collection B() {
        g gVar = this.f8347k;
        if (gVar != null) {
            return gVar;
        }
        g gVar2 = new g(this);
        this.f8347k = gVar2;
        return gVar2;
    }

    public final e D() {
        return new e(this);
    }

    public final boolean J(Map.Entry entry) {
        m.e(entry, "entry");
        m();
        int u4 = u(entry.getKey());
        if (u4 < 0) {
            return false;
        }
        Object[] objArr = this.f8338b;
        m.b(objArr);
        if (!m.a(objArr[u4], entry.getValue())) {
            return false;
        }
        K(u4);
        return true;
    }

    public final boolean M(Object obj) {
        m();
        int u4 = u(obj);
        if (u4 < 0) {
            return false;
        }
        K(u4);
        return true;
    }

    public final boolean N(Object obj) {
        m();
        int v4 = v(obj);
        if (v4 < 0) {
            return false;
        }
        K(v4);
        return true;
    }

    public final f P() {
        return new f(this);
    }

    public void clear() {
        m();
        int i4 = this.f8342f - 1;
        if (i4 >= 0) {
            int i5 = 0;
            while (true) {
                int[] iArr = this.f8339c;
                int i6 = iArr[i5];
                if (i6 >= 0) {
                    this.f8340d[i6] = 0;
                    iArr[i5] = -1;
                }
                if (i5 == i4) {
                    break;
                }
                i5++;
            }
        }
        c.g(this.f8337a, 0, this.f8342f);
        Object[] objArr = this.f8338b;
        if (objArr != null) {
            c.g(objArr, 0, this.f8342f);
        }
        this.f8345i = 0;
        this.f8342f = 0;
        H();
    }

    public boolean containsKey(Object obj) {
        if (u(obj) >= 0) {
            return true;
        }
        return false;
    }

    public boolean containsValue(Object obj) {
        if (v(obj) >= 0) {
            return true;
        }
        return false;
    }

    public final /* bridge */ Set entrySet() {
        return x();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map) || !q((Map) obj)) {
            return false;
        }
        return true;
    }

    public Object get(Object obj) {
        int u4 = u(obj);
        if (u4 < 0) {
            return null;
        }
        Object[] objArr = this.f8338b;
        m.b(objArr);
        return objArr[u4];
    }

    public int hashCode() {
        b t4 = t();
        int i4 = 0;
        while (t4.hasNext()) {
            i4 += t4.k();
        }
        return i4;
    }

    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public final int j(Object obj) {
        m();
        while (true) {
            int C4 = C(obj);
            int c5 = j3.e.c(this.f8341e * 2, y() / 2);
            int i4 = 0;
            while (true) {
                int i5 = this.f8340d[C4];
                if (i5 <= 0) {
                    if (this.f8342f >= w()) {
                        s(1);
                    } else {
                        int i6 = this.f8342f;
                        int i7 = i6 + 1;
                        this.f8342f = i7;
                        this.f8337a[i6] = obj;
                        this.f8339c[i6] = C4;
                        this.f8340d[C4] = i7;
                        this.f8345i = size() + 1;
                        H();
                        if (i4 > this.f8341e) {
                            this.f8341e = i4;
                        }
                        return i6;
                    }
                } else if (m.a(this.f8337a[i5 - 1], obj)) {
                    return -i5;
                } else {
                    i4++;
                    if (i4 > c5) {
                        I(y() * 2);
                        break;
                    }
                    int i8 = C4 - 1;
                    if (C4 == 0) {
                        C4 = y() - 1;
                    } else {
                        C4 = i8;
                    }
                }
            }
        }
    }

    public final /* bridge */ Set keySet() {
        return z();
    }

    public final Map l() {
        m();
        this.f8349m = true;
        if (size() > 0) {
            return this;
        }
        d dVar = f8336o;
        m.c(dVar, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.builders.MapBuilder, V of kotlin.collections.builders.MapBuilder>");
        return dVar;
    }

    public final void m() {
        if (this.f8349m) {
            throw new UnsupportedOperationException();
        }
    }

    public final boolean o(Collection collection) {
        m.e(collection, "m");
        for (Object next : collection) {
            if (next != null) {
                try {
                    if (!p((Map.Entry) next)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    public final boolean p(Map.Entry entry) {
        m.e(entry, "entry");
        int u4 = u(entry.getKey());
        if (u4 < 0) {
            return false;
        }
        Object[] objArr = this.f8338b;
        m.b(objArr);
        return m.a(objArr[u4], entry.getValue());
    }

    public Object put(Object obj, Object obj2) {
        m();
        int j4 = j(obj);
        Object[] k4 = k();
        if (j4 < 0) {
            int i4 = (-j4) - 1;
            Object obj3 = k4[i4];
            k4[i4] = obj2;
            return obj3;
        }
        k4[j4] = obj2;
        return null;
    }

    public void putAll(Map map) {
        m.e(map, TypedValues.TransitionType.S_FROM);
        m();
        E(map.entrySet());
    }

    public Object remove(Object obj) {
        m();
        int u4 = u(obj);
        if (u4 < 0) {
            return null;
        }
        Object[] objArr = this.f8338b;
        m.b(objArr);
        Object obj2 = objArr[u4];
        K(u4);
        return obj2;
    }

    public final /* bridge */ int size() {
        return A();
    }

    public final b t() {
        return new b(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((size() * 3) + 2);
        sb.append("{");
        b t4 = t();
        int i4 = 0;
        while (t4.hasNext()) {
            if (i4 > 0) {
                sb.append(", ");
            }
            t4.j(sb);
            i4++;
        }
        sb.append("}");
        String sb2 = sb.toString();
        m.d(sb2, "toString(...)");
        return sb2;
    }

    public final /* bridge */ Collection values() {
        return B();
    }

    public final int w() {
        return this.f8337a.length;
    }

    public Set x() {
        e eVar = this.f8348l;
        if (eVar != null) {
            return eVar;
        }
        e eVar2 = new e(this);
        this.f8348l = eVar2;
        return eVar2;
    }

    public Set z() {
        f fVar = this.f8346j;
        if (fVar != null) {
            return fVar;
        }
        f fVar2 = new f(this);
        this.f8346j = fVar2;
        return fVar2;
    }

    public d() {
        this(8);
    }

    public d(int i4) {
        this(c.d(i4), (Object[]) null, new int[i4], new int[f8335n.c(i4)], 2, 0);
    }
}
