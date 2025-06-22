package S2;

import j3.e;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

/* renamed from: S2.g  reason: case insensitive filesystem */
public final class C1593g extends C1590d {

    /* renamed from: d  reason: collision with root package name */
    public static final a f8246d = new a((C2103g) null);

    /* renamed from: e  reason: collision with root package name */
    private static final Object[] f8247e = new Object[0];

    /* renamed from: a  reason: collision with root package name */
    private int f8248a;

    /* renamed from: b  reason: collision with root package name */
    private Object[] f8249b = f8247e;

    /* renamed from: c  reason: collision with root package name */
    private int f8250c;

    /* renamed from: S2.g$a */
    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    private final void l(int i4, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.f8249b.length;
        while (i4 < length && it.hasNext()) {
            this.f8249b[i4] = it.next();
            i4++;
        }
        int i5 = this.f8248a;
        for (int i6 = 0; i6 < i5 && it.hasNext(); i6++) {
            this.f8249b[i6] = it.next();
        }
        this.f8250c = size() + collection.size();
    }

    private final void m(int i4) {
        Object[] objArr = new Object[i4];
        Object[] objArr2 = this.f8249b;
        C1597k.e(objArr2, objArr, 0, this.f8248a, objArr2.length);
        Object[] objArr3 = this.f8249b;
        int length = objArr3.length;
        int i5 = this.f8248a;
        C1597k.e(objArr3, objArr, length - i5, 0, i5);
        this.f8248a = 0;
        this.f8249b = objArr;
    }

    private final int n(int i4) {
        if (i4 == 0) {
            return C1598l.t(this.f8249b);
        }
        return i4 - 1;
    }

    private final void o(int i4) {
        if (i4 >= 0) {
            Object[] objArr = this.f8249b;
            if (i4 > objArr.length) {
                if (objArr == f8247e) {
                    this.f8249b = new Object[e.a(i4, 10)];
                } else {
                    m(C1588b.f8237a.e(objArr.length, i4));
                }
            }
        } else {
            throw new IllegalStateException("Deque is too big.");
        }
    }

    private final int p(int i4) {
        if (i4 == C1598l.t(this.f8249b)) {
            return 0;
        }
        return i4 + 1;
    }

    private final int q(int i4) {
        if (i4 < 0) {
            return i4 + this.f8249b.length;
        }
        return i4;
    }

    private final void r(int i4, int i5) {
        if (i4 < i5) {
            C1597k.j(this.f8249b, (Object) null, i4, i5);
            return;
        }
        Object[] objArr = this.f8249b;
        C1597k.j(objArr, (Object) null, i4, objArr.length);
        C1597k.j(this.f8249b, (Object) null, 0, i5);
    }

    private final int s(int i4) {
        Object[] objArr = this.f8249b;
        if (i4 >= objArr.length) {
            return i4 - objArr.length;
        }
        return i4;
    }

    private final void t() {
        this.modCount++;
    }

    private final void x(int i4, int i5) {
        int s4 = s(this.f8248a + (i4 - 1));
        int s5 = s(this.f8248a + (i5 - 1));
        while (i4 > 0) {
            int i6 = s4 + 1;
            int min = Math.min(i4, Math.min(i6, s5 + 1));
            Object[] objArr = this.f8249b;
            int i7 = s5 - min;
            int i8 = s4 - min;
            C1597k.e(objArr, objArr, i7 + 1, i8 + 1, i6);
            s4 = q(i8);
            s5 = q(i7);
            i4 -= min;
        }
    }

    private final void y(int i4, int i5) {
        int s4 = s(this.f8248a + i5);
        int s5 = s(this.f8248a + i4);
        int size = size();
        while (true) {
            size -= i5;
            if (size > 0) {
                Object[] objArr = this.f8249b;
                i5 = Math.min(size, Math.min(objArr.length - s4, objArr.length - s5));
                Object[] objArr2 = this.f8249b;
                int i6 = s4 + i5;
                C1597k.e(objArr2, objArr2, s5, s4, i6);
                s4 = s(i6);
                s5 = s(s5 + i5);
            } else {
                return;
            }
        }
    }

    public boolean add(Object obj) {
        k(obj);
        return true;
    }

    public boolean addAll(Collection collection) {
        m.e(collection, "elements");
        if (collection.isEmpty()) {
            return false;
        }
        t();
        o(size() + collection.size());
        l(s(this.f8248a + size()), collection);
        return true;
    }

    public int c() {
        return this.f8250c;
    }

    public void clear() {
        if (!isEmpty()) {
            t();
            r(this.f8248a, s(this.f8248a + size()));
        }
        this.f8248a = 0;
        this.f8250c = 0;
    }

    public boolean contains(Object obj) {
        if (indexOf(obj) != -1) {
            return true;
        }
        return false;
    }

    public Object get(int i4) {
        C1588b.f8237a.b(i4, size());
        return this.f8249b[s(this.f8248a + i4)];
    }

    public Object h(int i4) {
        C1588b.f8237a.b(i4, size());
        if (i4 == C1603q.j(this)) {
            return w();
        }
        if (i4 == 0) {
            return u();
        }
        t();
        int s4 = s(this.f8248a + i4);
        Object obj = this.f8249b[s4];
        if (i4 < (size() >> 1)) {
            int i5 = this.f8248a;
            if (s4 >= i5) {
                Object[] objArr = this.f8249b;
                C1597k.e(objArr, objArr, i5 + 1, i5, s4);
            } else {
                Object[] objArr2 = this.f8249b;
                C1597k.e(objArr2, objArr2, 1, 0, s4);
                Object[] objArr3 = this.f8249b;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i6 = this.f8248a;
                C1597k.e(objArr3, objArr3, i6 + 1, i6, objArr3.length - 1);
            }
            Object[] objArr4 = this.f8249b;
            int i7 = this.f8248a;
            objArr4[i7] = null;
            this.f8248a = p(i7);
        } else {
            int s5 = s(this.f8248a + C1603q.j(this));
            if (s4 <= s5) {
                Object[] objArr5 = this.f8249b;
                C1597k.e(objArr5, objArr5, s4, s4 + 1, s5 + 1);
            } else {
                Object[] objArr6 = this.f8249b;
                C1597k.e(objArr6, objArr6, s4, s4 + 1, objArr6.length);
                Object[] objArr7 = this.f8249b;
                objArr7[objArr7.length - 1] = objArr7[0];
                C1597k.e(objArr7, objArr7, 0, 1, s5 + 1);
            }
            this.f8249b[s5] = null;
        }
        this.f8250c = size() - 1;
        return obj;
    }

    public int indexOf(Object obj) {
        int i4;
        int s4 = s(this.f8248a + size());
        int i5 = this.f8248a;
        if (i5 < s4) {
            while (i5 < s4) {
                if (m.a(obj, this.f8249b[i5])) {
                    i4 = this.f8248a;
                } else {
                    i5++;
                }
            }
            return -1;
        } else if (i5 < s4) {
            return -1;
        } else {
            int length = this.f8249b.length;
            while (true) {
                if (i5 >= length) {
                    int i6 = 0;
                    while (i6 < s4) {
                        if (m.a(obj, this.f8249b[i6])) {
                            i5 = i6 + this.f8249b.length;
                            i4 = this.f8248a;
                        } else {
                            i6++;
                        }
                    }
                    return -1;
                } else if (m.a(obj, this.f8249b[i5])) {
                    i4 = this.f8248a;
                    break;
                } else {
                    i5++;
                }
            }
        }
        return i5 - i4;
    }

    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public final void j(Object obj) {
        t();
        o(size() + 1);
        int n4 = n(this.f8248a);
        this.f8248a = n4;
        this.f8249b[n4] = obj;
        this.f8250c = size() + 1;
    }

    public final void k(Object obj) {
        t();
        o(size() + 1);
        this.f8249b[s(this.f8248a + size())] = obj;
        this.f8250c = size() + 1;
    }

    public int lastIndexOf(Object obj) {
        int i4;
        int i5;
        int s4 = s(this.f8248a + size());
        int i6 = this.f8248a;
        if (i6 < s4) {
            i4 = s4 - 1;
            if (i6 <= i4) {
                while (!m.a(obj, this.f8249b[i4])) {
                    if (i4 != i6) {
                        i4--;
                    }
                }
                i5 = this.f8248a;
            }
            return -1;
        }
        if (i6 > s4) {
            int i7 = s4 - 1;
            while (true) {
                if (-1 >= i7) {
                    int t4 = C1598l.t(this.f8249b);
                    int i8 = this.f8248a;
                    if (i8 <= t4) {
                        while (!m.a(obj, this.f8249b[i4])) {
                            if (i4 != i8) {
                                t4 = i4 - 1;
                            }
                        }
                        i5 = this.f8248a;
                    }
                } else if (m.a(obj, this.f8249b[i7])) {
                    i4 = i7 + this.f8249b.length;
                    i5 = this.f8248a;
                    break;
                } else {
                    i7--;
                }
            }
        }
        return -1;
        return i4 - i5;
    }

    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v3, types: [int] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean removeAll(java.util.Collection r12) {
        /*
            r11 = this;
            java.lang.String r0 = "elements"
            kotlin.jvm.internal.m.e(r12, r0)
            boolean r0 = r11.isEmpty()
            r1 = 0
            if (r0 != 0) goto L_0x0091
            java.lang.Object[] r0 = r11.f8249b
            int r0 = r0.length
            if (r0 != 0) goto L_0x0013
            goto L_0x0091
        L_0x0013:
            int r0 = r11.f8248a
            int r2 = r11.size()
            int r0 = r0 + r2
            int r0 = r11.s(r0)
            int r2 = r11.f8248a
            r3 = 0
            r4 = 1
            if (r2 >= r0) goto L_0x0043
            r5 = r2
        L_0x0025:
            if (r2 >= r0) goto L_0x003d
            java.lang.Object[] r6 = r11.f8249b
            r6 = r6[r2]
            boolean r7 = r12.contains(r6)
            if (r7 != 0) goto L_0x0039
            java.lang.Object[] r7 = r11.f8249b
            int r8 = r5 + 1
            r7[r5] = r6
            r5 = r8
            goto L_0x003a
        L_0x0039:
            r1 = 1
        L_0x003a:
            int r2 = r2 + 1
            goto L_0x0025
        L_0x003d:
            java.lang.Object[] r12 = r11.f8249b
            S2.C1597k.j(r12, r3, r5, r0)
            goto L_0x0083
        L_0x0043:
            java.lang.Object[] r5 = r11.f8249b
            int r5 = r5.length
            r6 = r2
            r7 = 0
        L_0x0048:
            if (r2 >= r5) goto L_0x0062
            java.lang.Object[] r8 = r11.f8249b
            r9 = r8[r2]
            r8[r2] = r3
            boolean r8 = r12.contains(r9)
            if (r8 != 0) goto L_0x005e
            java.lang.Object[] r8 = r11.f8249b
            int r10 = r6 + 1
            r8[r6] = r9
            r6 = r10
            goto L_0x005f
        L_0x005e:
            r7 = 1
        L_0x005f:
            int r2 = r2 + 1
            goto L_0x0048
        L_0x0062:
            int r2 = r11.s(r6)
            r5 = r2
        L_0x0067:
            if (r1 >= r0) goto L_0x0082
            java.lang.Object[] r2 = r11.f8249b
            r6 = r2[r1]
            r2[r1] = r3
            boolean r2 = r12.contains(r6)
            if (r2 != 0) goto L_0x007e
            java.lang.Object[] r2 = r11.f8249b
            r2[r5] = r6
            int r5 = r11.p(r5)
            goto L_0x007f
        L_0x007e:
            r7 = 1
        L_0x007f:
            int r1 = r1 + 1
            goto L_0x0067
        L_0x0082:
            r1 = r7
        L_0x0083:
            if (r1 == 0) goto L_0x0091
            r11.t()
            int r12 = r11.f8248a
            int r5 = r5 - r12
            int r12 = r11.q(r5)
            r11.f8250c = r12
        L_0x0091:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: S2.C1593g.removeAll(java.util.Collection):boolean");
    }

    /* access modifiers changed from: protected */
    public void removeRange(int i4, int i5) {
        C1588b.f8237a.d(i4, i5, size());
        int i6 = i5 - i4;
        if (i6 != 0) {
            if (i6 == size()) {
                clear();
            } else if (i6 == 1) {
                remove(i4);
            } else {
                t();
                if (i4 < size() - i5) {
                    x(i4, i5);
                    int s4 = s(this.f8248a + i6);
                    r(this.f8248a, s4);
                    this.f8248a = s4;
                } else {
                    y(i4, i5);
                    int s5 = s(this.f8248a + size());
                    r(q(s5 - i6), s5);
                }
                this.f8250c = size() - i6;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v3, types: [int] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean retainAll(java.util.Collection r12) {
        /*
            r11 = this;
            java.lang.String r0 = "elements"
            kotlin.jvm.internal.m.e(r12, r0)
            boolean r0 = r11.isEmpty()
            r1 = 0
            if (r0 != 0) goto L_0x0091
            java.lang.Object[] r0 = r11.f8249b
            int r0 = r0.length
            if (r0 != 0) goto L_0x0013
            goto L_0x0091
        L_0x0013:
            int r0 = r11.f8248a
            int r2 = r11.size()
            int r0 = r0 + r2
            int r0 = r11.s(r0)
            int r2 = r11.f8248a
            r3 = 0
            r4 = 1
            if (r2 >= r0) goto L_0x0043
            r5 = r2
        L_0x0025:
            if (r2 >= r0) goto L_0x003d
            java.lang.Object[] r6 = r11.f8249b
            r6 = r6[r2]
            boolean r7 = r12.contains(r6)
            if (r7 == 0) goto L_0x0039
            java.lang.Object[] r7 = r11.f8249b
            int r8 = r5 + 1
            r7[r5] = r6
            r5 = r8
            goto L_0x003a
        L_0x0039:
            r1 = 1
        L_0x003a:
            int r2 = r2 + 1
            goto L_0x0025
        L_0x003d:
            java.lang.Object[] r12 = r11.f8249b
            S2.C1597k.j(r12, r3, r5, r0)
            goto L_0x0083
        L_0x0043:
            java.lang.Object[] r5 = r11.f8249b
            int r5 = r5.length
            r6 = r2
            r7 = 0
        L_0x0048:
            if (r2 >= r5) goto L_0x0062
            java.lang.Object[] r8 = r11.f8249b
            r9 = r8[r2]
            r8[r2] = r3
            boolean r8 = r12.contains(r9)
            if (r8 == 0) goto L_0x005e
            java.lang.Object[] r8 = r11.f8249b
            int r10 = r6 + 1
            r8[r6] = r9
            r6 = r10
            goto L_0x005f
        L_0x005e:
            r7 = 1
        L_0x005f:
            int r2 = r2 + 1
            goto L_0x0048
        L_0x0062:
            int r2 = r11.s(r6)
            r5 = r2
        L_0x0067:
            if (r1 >= r0) goto L_0x0082
            java.lang.Object[] r2 = r11.f8249b
            r6 = r2[r1]
            r2[r1] = r3
            boolean r2 = r12.contains(r6)
            if (r2 == 0) goto L_0x007e
            java.lang.Object[] r2 = r11.f8249b
            r2[r5] = r6
            int r5 = r11.p(r5)
            goto L_0x007f
        L_0x007e:
            r7 = 1
        L_0x007f:
            int r1 = r1 + 1
            goto L_0x0067
        L_0x0082:
            r1 = r7
        L_0x0083:
            if (r1 == 0) goto L_0x0091
            r11.t()
            int r12 = r11.f8248a
            int r5 = r5 - r12
            int r12 = r11.q(r5)
            r11.f8250c = r12
        L_0x0091:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: S2.C1593g.retainAll(java.util.Collection):boolean");
    }

    public Object set(int i4, Object obj) {
        C1588b.f8237a.b(i4, size());
        int s4 = s(this.f8248a + i4);
        Object[] objArr = this.f8249b;
        Object obj2 = objArr[s4];
        objArr[s4] = obj;
        return obj2;
    }

    public Object[] toArray(Object[] objArr) {
        m.e(objArr, "array");
        if (objArr.length < size()) {
            objArr = C1595i.a(objArr, size());
        }
        Object[] objArr2 = objArr;
        int s4 = s(this.f8248a + size());
        int i4 = this.f8248a;
        if (i4 < s4) {
            C1597k.g(this.f8249b, objArr2, 0, i4, s4, 2, (Object) null);
        } else if (!isEmpty()) {
            Object[] objArr3 = this.f8249b;
            C1597k.e(objArr3, objArr2, 0, this.f8248a, objArr3.length);
            Object[] objArr4 = this.f8249b;
            C1597k.e(objArr4, objArr2, objArr4.length - this.f8248a, 0, s4);
        }
        return C1602p.f(size(), objArr2);
    }

    public final Object u() {
        if (!isEmpty()) {
            t();
            Object[] objArr = this.f8249b;
            int i4 = this.f8248a;
            Object obj = objArr[i4];
            objArr[i4] = null;
            this.f8248a = p(i4);
            this.f8250c = size() - 1;
            return obj;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final Object v() {
        if (isEmpty()) {
            return null;
        }
        return u();
    }

    public final Object w() {
        if (!isEmpty()) {
            t();
            int s4 = s(this.f8248a + C1603q.j(this));
            Object[] objArr = this.f8249b;
            Object obj = objArr[s4];
            objArr[s4] = null;
            this.f8250c = size() - 1;
            return obj;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public void add(int i4, Object obj) {
        C1588b.f8237a.c(i4, size());
        if (i4 == size()) {
            k(obj);
        } else if (i4 == 0) {
            j(obj);
        } else {
            t();
            o(size() + 1);
            int s4 = s(this.f8248a + i4);
            if (i4 < ((size() + 1) >> 1)) {
                int n4 = n(s4);
                int n5 = n(this.f8248a);
                int i5 = this.f8248a;
                if (n4 >= i5) {
                    Object[] objArr = this.f8249b;
                    objArr[n5] = objArr[i5];
                    C1597k.e(objArr, objArr, i5, i5 + 1, n4 + 1);
                } else {
                    Object[] objArr2 = this.f8249b;
                    C1597k.e(objArr2, objArr2, i5 - 1, i5, objArr2.length);
                    Object[] objArr3 = this.f8249b;
                    objArr3[objArr3.length - 1] = objArr3[0];
                    C1597k.e(objArr3, objArr3, 0, 1, n4 + 1);
                }
                this.f8249b[n4] = obj;
                this.f8248a = n5;
            } else {
                int s5 = s(this.f8248a + size());
                if (s4 < s5) {
                    Object[] objArr4 = this.f8249b;
                    C1597k.e(objArr4, objArr4, s4 + 1, s4, s5);
                } else {
                    Object[] objArr5 = this.f8249b;
                    C1597k.e(objArr5, objArr5, 1, 0, s5);
                    Object[] objArr6 = this.f8249b;
                    objArr6[0] = objArr6[objArr6.length - 1];
                    C1597k.e(objArr6, objArr6, s4 + 1, s4, objArr6.length - 1);
                }
                this.f8249b[s4] = obj;
            }
            this.f8250c = size() + 1;
        }
    }

    public boolean addAll(int i4, Collection collection) {
        m.e(collection, "elements");
        C1588b.f8237a.c(i4, size());
        if (collection.isEmpty()) {
            return false;
        }
        if (i4 == size()) {
            return addAll(collection);
        }
        t();
        o(size() + collection.size());
        int s4 = s(this.f8248a + size());
        int s5 = s(this.f8248a + i4);
        int size = collection.size();
        if (i4 < ((size() + 1) >> 1)) {
            int i5 = this.f8248a;
            int i6 = i5 - size;
            if (s5 < i5) {
                Object[] objArr = this.f8249b;
                C1597k.e(objArr, objArr, i6, i5, objArr.length);
                if (size >= s5) {
                    Object[] objArr2 = this.f8249b;
                    C1597k.e(objArr2, objArr2, objArr2.length - size, 0, s5);
                } else {
                    Object[] objArr3 = this.f8249b;
                    C1597k.e(objArr3, objArr3, objArr3.length - size, 0, size);
                    Object[] objArr4 = this.f8249b;
                    C1597k.e(objArr4, objArr4, 0, size, s5);
                }
            } else if (i6 >= 0) {
                Object[] objArr5 = this.f8249b;
                C1597k.e(objArr5, objArr5, i6, i5, s5);
            } else {
                Object[] objArr6 = this.f8249b;
                i6 += objArr6.length;
                int i7 = s5 - i5;
                int length = objArr6.length - i6;
                if (length >= i7) {
                    C1597k.e(objArr6, objArr6, i6, i5, s5);
                } else {
                    C1597k.e(objArr6, objArr6, i6, i5, i5 + length);
                    Object[] objArr7 = this.f8249b;
                    C1597k.e(objArr7, objArr7, 0, this.f8248a + length, s5);
                }
            }
            this.f8248a = i6;
            l(q(s5 - size), collection);
        } else {
            int i8 = s5 + size;
            if (s5 < s4) {
                int i9 = size + s4;
                Object[] objArr8 = this.f8249b;
                if (i9 <= objArr8.length) {
                    C1597k.e(objArr8, objArr8, i8, s5, s4);
                } else if (i8 >= objArr8.length) {
                    C1597k.e(objArr8, objArr8, i8 - objArr8.length, s5, s4);
                } else {
                    int length2 = s4 - (i9 - objArr8.length);
                    C1597k.e(objArr8, objArr8, 0, length2, s4);
                    Object[] objArr9 = this.f8249b;
                    C1597k.e(objArr9, objArr9, i8, s5, length2);
                }
            } else {
                Object[] objArr10 = this.f8249b;
                C1597k.e(objArr10, objArr10, size, 0, s4);
                Object[] objArr11 = this.f8249b;
                if (i8 >= objArr11.length) {
                    C1597k.e(objArr11, objArr11, i8 - objArr11.length, s5, objArr11.length);
                } else {
                    C1597k.e(objArr11, objArr11, 0, objArr11.length - size, objArr11.length);
                    Object[] objArr12 = this.f8249b;
                    C1597k.e(objArr12, objArr12, i8, s5, objArr12.length - size);
                }
            }
            l(s5, collection);
        }
        return true;
    }

    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
