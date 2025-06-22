package t3;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.t;
import o3.N;

/* renamed from: t3.q  reason: case insensitive filesystem */
public class C1067q {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f4511a;

    /* renamed from: b  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f4512b;

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f4513c;
    private volatile Object _next = this;
    private volatile Object _prev = this;
    private volatile Object _removedRef;

    /* renamed from: t3.q$a */
    public static abstract class a extends C1052b {

        /* renamed from: b  reason: collision with root package name */
        public final C1067q f4514b;

        /* renamed from: c  reason: collision with root package name */
        public C1067q f4515c;

        public a(C1067q qVar) {
            this.f4514b = qVar;
        }

        /* renamed from: e */
        public void b(C1067q qVar, Object obj) {
            boolean z4;
            C1067q qVar2;
            if (obj == null) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z4) {
                qVar2 = this.f4514b;
            } else {
                qVar2 = this.f4515c;
            }
            if (qVar2 != null && androidx.concurrent.futures.a.a(C1067q.f4511a, qVar, this, qVar2) && z4) {
                C1067q qVar3 = this.f4514b;
                C1067q qVar4 = this.f4515c;
                m.b(qVar4);
                qVar3.i(qVar4);
            }
        }
    }

    /* renamed from: t3.q$b */
    /* synthetic */ class b extends t {
        b(Object obj) {
            super(obj, N.class, "classSimpleName", "getClassSimpleName(Ljava/lang/Object;)Ljava/lang/String;", 1);
        }

        public Object get() {
            return N.a(this.receiver);
        }
    }

    static {
        Class<C1067q> cls = C1067q.class;
        Class<Object> cls2 = Object.class;
        f4511a = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_next");
        f4512b = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_prev");
        f4513c = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_removedRef");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: t3.q} */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0041, code lost:
        if (androidx.concurrent.futures.a.a(r4, r3, r2, ((t3.z) r5).f4531a) != false) goto L_0x0044;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final t3.C1067q f(t3.y r9) {
        /*
            r8 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = f4512b
            java.lang.Object r0 = r0.get(r8)
            t3.q r0 = (t3.C1067q) r0
            r1 = 0
            r2 = r0
        L_0x000a:
            r3 = r1
        L_0x000b:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = f4511a
            java.lang.Object r5 = r4.get(r2)
            if (r5 != r8) goto L_0x001f
            if (r0 != r2) goto L_0x0016
            goto L_0x0028
        L_0x0016:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = f4512b
            boolean r0 = androidx.concurrent.futures.a.a(r1, r8, r0, r2)
            if (r0 != 0) goto L_0x0028
            goto L_0x0000
        L_0x001f:
            boolean r6 = r8.m()
            if (r6 == 0) goto L_0x0026
            return r1
        L_0x0026:
            if (r5 != r9) goto L_0x0029
        L_0x0028:
            return r2
        L_0x0029:
            boolean r6 = r5 instanceof t3.y
            if (r6 == 0) goto L_0x0033
            t3.y r5 = (t3.y) r5
            r5.a(r2)
            goto L_0x0000
        L_0x0033:
            boolean r6 = r5 instanceof t3.z
            if (r6 == 0) goto L_0x004f
            if (r3 == 0) goto L_0x0046
            t3.z r5 = (t3.z) r5
            t3.q r5 = r5.f4531a
            boolean r2 = androidx.concurrent.futures.a.a(r4, r3, r2, r5)
            if (r2 != 0) goto L_0x0044
            goto L_0x0000
        L_0x0044:
            r2 = r3
            goto L_0x000a
        L_0x0046:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = f4512b
            java.lang.Object r2 = r4.get(r2)
            t3.q r2 = (t3.C1067q) r2
            goto L_0x000b
        L_0x004f:
            java.lang.String r3 = "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }"
            kotlin.jvm.internal.m.c(r5, r3)
            r3 = r5
            t3.q r3 = (t3.C1067q) r3
            r7 = r3
            r3 = r2
            r2 = r7
            goto L_0x000b
        */
        throw new UnsupportedOperationException("Method not decompiled: t3.C1067q.f(t3.y):t3.q");
    }

    private final C1067q g(C1067q qVar) {
        while (qVar.m()) {
            qVar = (C1067q) f4512b.get(qVar);
        }
        return qVar;
    }

    /* access modifiers changed from: private */
    public final void i(C1067q qVar) {
        C1067q qVar2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4512b;
        do {
            qVar2 = (C1067q) atomicReferenceFieldUpdater.get(qVar);
            if (j() != qVar) {
                return;
            }
        } while (!androidx.concurrent.futures.a.a(f4512b, qVar, qVar2, this));
        if (m()) {
            qVar.f((y) null);
        }
    }

    private final z p() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4513c;
        z zVar = (z) atomicReferenceFieldUpdater.get(this);
        if (zVar != null) {
            return zVar;
        }
        z zVar2 = new z(this);
        atomicReferenceFieldUpdater.lazySet(this, zVar2);
        return zVar2;
    }

    public final boolean e(C1067q qVar) {
        f4512b.lazySet(qVar, this);
        f4511a.lazySet(qVar, this);
        while (j() == this) {
            if (androidx.concurrent.futures.a.a(f4511a, this, this, qVar)) {
                qVar.i(this);
                return true;
            }
        }
        return false;
    }

    public final Object j() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4511a;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof y)) {
                return obj;
            }
            ((y) obj).a(this);
        }
    }

    public final C1067q k() {
        return C1066p.b(j());
    }

    public final C1067q l() {
        C1067q f4 = f((y) null);
        if (f4 == null) {
            return g((C1067q) f4512b.get(this));
        }
        return f4;
    }

    public boolean m() {
        return j() instanceof z;
    }

    public boolean n() {
        if (o() == null) {
            return true;
        }
        return false;
    }

    public final C1067q o() {
        Object j4;
        C1067q qVar;
        do {
            j4 = j();
            if (j4 instanceof z) {
                return ((z) j4).f4531a;
            }
            if (j4 == this) {
                return (C1067q) j4;
            }
            m.c(j4, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
            qVar = (C1067q) j4;
        } while (!androidx.concurrent.futures.a.a(f4511a, this, j4, qVar.p()));
        qVar.f((y) null);
        return null;
    }

    public final int q(C1067q qVar, C1067q qVar2, a aVar) {
        f4512b.lazySet(qVar, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4511a;
        atomicReferenceFieldUpdater.lazySet(qVar, qVar2);
        aVar.f4515c = qVar2;
        if (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, qVar2, aVar)) {
            return 0;
        }
        if (aVar.a(this) == null) {
            return 1;
        }
        return 2;
    }

    public String toString() {
        return new b(this) + '@' + N.b(this);
    }
}
