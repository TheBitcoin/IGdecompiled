package q3;

import R2.m;
import R2.n;
import R2.s;
import d3.l;
import d3.p;
import d3.q;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.jvm.internal.h;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.G;
import kotlin.jvm.internal.m;
import o3.C0989m;
import o3.C0991n;
import o3.C0995p;
import o3.W0;
import t3.C;
import t3.C1054d;
import t3.C1055e;
import t3.C1062l;
import t3.D;
import t3.E;
import t3.F;
import t3.Q;
import t3.x;

public class b implements d {
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final AtomicLongFieldUpdater f4039d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final AtomicLongFieldUpdater f4040e;

    /* renamed from: f  reason: collision with root package name */
    private static final AtomicLongFieldUpdater f4041f;

    /* renamed from: g  reason: collision with root package name */
    private static final AtomicLongFieldUpdater f4042g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f4043h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f4044i;

    /* renamed from: j  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f4045j;

    /* renamed from: k  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f4046k;

    /* renamed from: l  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f4047l;
    private volatile Object _closeCause;

    /* renamed from: a  reason: collision with root package name */
    private final int f4048a;

    /* renamed from: b  reason: collision with root package name */
    public final l f4049b;
    private volatile long bufferEnd;
    private volatile Object bufferEndSegment;

    /* renamed from: c  reason: collision with root package name */
    private final q f4050c;
    private volatile Object closeHandler;
    private volatile long completedExpandBuffersAndPauseFlag;
    private volatile Object receiveSegment;
    private volatile long receivers;
    private volatile Object sendSegment;
    private volatile long sendersAndCloseStatus;

    private final class a implements f, W0 {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public Object f4051a = c.f4082p;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public C0991n f4052b;

        public a() {
        }

        private final Object f(j jVar, int i4, long j4, V2.d dVar) {
            Boolean a5;
            j jVar2;
            b bVar = b.this;
            C0991n b5 = C0995p.b(W2.b.b(dVar));
            try {
                this.f4052b = b5;
                j jVar3 = jVar;
                int i5 = i4;
                long j5 = j4;
                try {
                    Object w4 = bVar.H0(jVar3, i5, j5, this);
                    if (w4 == c.f4079m) {
                        bVar.q0(this, jVar3, i5);
                    } else {
                        l lVar = null;
                        if (w4 == c.f4081o) {
                            if (j5 < bVar.S()) {
                                jVar3.b();
                            }
                            j jVar4 = (j) b.f4044i.get(bVar);
                            while (true) {
                                if (bVar.Z()) {
                                    h();
                                    break;
                                }
                                long andIncrement = b.f4040e.getAndIncrement(bVar);
                                int i6 = c.f4068b;
                                long j6 = andIncrement / ((long) i6);
                                int i7 = (int) (andIncrement % ((long) i6));
                                if (jVar4.f4463c != j6) {
                                    jVar2 = bVar.L(j6, jVar4);
                                    if (jVar2 == null) {
                                    }
                                } else {
                                    jVar2 = jVar4;
                                }
                                int i8 = i7;
                                Object w5 = bVar.H0(jVar2, i8, andIncrement, this);
                                if (w5 == c.f4079m) {
                                    bVar.q0(this, jVar2, i8);
                                    break;
                                } else if (w5 == c.f4081o) {
                                    if (andIncrement < bVar.S()) {
                                        jVar2.b();
                                    }
                                    jVar4 = jVar2;
                                } else if (w5 != c.f4080n) {
                                    jVar2.b();
                                    this.f4051a = w5;
                                    this.f4052b = null;
                                    a5 = kotlin.coroutines.jvm.internal.b.a(true);
                                    l lVar2 = bVar.f4049b;
                                    if (lVar2 != null) {
                                        lVar = x.a(lVar2, w5, b5.getContext());
                                    }
                                } else {
                                    throw new IllegalStateException("unexpected");
                                }
                            }
                        } else {
                            jVar3.b();
                            this.f4051a = w4;
                            this.f4052b = null;
                            a5 = kotlin.coroutines.jvm.internal.b.a(true);
                            l lVar3 = bVar.f4049b;
                            if (lVar3 != null) {
                                lVar = x.a(lVar3, w4, b5.getContext());
                            }
                        }
                        b5.c(a5, lVar);
                    }
                    Object v4 = b5.v();
                    if (v4 == W2.b.c()) {
                        h.c(dVar);
                    }
                    return v4;
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    b5.J();
                    throw th2;
                }
            } catch (Throwable th3) {
                th = th3;
                Throwable th22 = th;
                b5.J();
                throw th22;
            }
        }

        private final boolean g() {
            this.f4051a = c.z();
            Throwable O4 = b.this.O();
            if (O4 == null) {
                return false;
            }
            throw E.a(O4);
        }

        /* access modifiers changed from: private */
        public final void h() {
            C0991n nVar = this.f4052b;
            m.b(nVar);
            this.f4052b = null;
            this.f4051a = c.z();
            Throwable O4 = b.this.O();
            if (O4 == null) {
                m.a aVar = R2.m.f8216a;
                nVar.resumeWith(R2.m.a(Boolean.FALSE));
                return;
            }
            m.a aVar2 = R2.m.f8216a;
            nVar.resumeWith(R2.m.a(n.a(O4)));
        }

        public Object a(V2.d dVar) {
            b bVar = b.this;
            j jVar = (j) b.f4044i.get(bVar);
            while (!bVar.Z()) {
                long andIncrement = b.f4040e.getAndIncrement(bVar);
                int i4 = c.f4068b;
                long j4 = andIncrement / ((long) i4);
                int i5 = (int) (andIncrement % ((long) i4));
                if (jVar.f4463c != j4) {
                    j b5 = bVar.L(j4, jVar);
                    if (b5 == null) {
                        continue;
                    } else {
                        jVar = b5;
                    }
                }
                Object w4 = bVar.H0(jVar, i5, andIncrement, (Object) null);
                if (w4 == c.f4079m) {
                    throw new IllegalStateException("unreachable");
                } else if (w4 == c.f4081o) {
                    if (andIncrement < bVar.S()) {
                        jVar.b();
                    }
                } else if (w4 == c.f4080n) {
                    long j5 = andIncrement;
                    return f(jVar, i5, j5, dVar);
                } else {
                    jVar.b();
                    this.f4051a = w4;
                    return kotlin.coroutines.jvm.internal.b.a(true);
                }
            }
            return kotlin.coroutines.jvm.internal.b.a(g());
        }

        public void d(C c5, int i4) {
            C0991n nVar = this.f4052b;
            if (nVar != null) {
                nVar.d(c5, i4);
            }
        }

        public final boolean i(Object obj) {
            C0991n nVar = this.f4052b;
            kotlin.jvm.internal.m.b(nVar);
            l lVar = null;
            this.f4052b = null;
            this.f4051a = obj;
            Boolean bool = Boolean.TRUE;
            l lVar2 = b.this.f4049b;
            if (lVar2 != null) {
                lVar = x.a(lVar2, obj, nVar.getContext());
            }
            return c.B(nVar, bool, lVar);
        }

        public final void j() {
            C0991n nVar = this.f4052b;
            kotlin.jvm.internal.m.b(nVar);
            this.f4052b = null;
            this.f4051a = c.z();
            Throwable O4 = b.this.O();
            if (O4 == null) {
                m.a aVar = R2.m.f8216a;
                nVar.resumeWith(R2.m.a(Boolean.FALSE));
                return;
            }
            m.a aVar2 = R2.m.f8216a;
            nVar.resumeWith(R2.m.a(n.a(O4)));
        }

        public Object next() {
            Object obj = this.f4051a;
            if (obj != c.f4082p) {
                this.f4051a = c.f4082p;
                if (obj != c.z()) {
                    return obj;
                }
                throw E.a(b.this.P());
            }
            throw new IllegalStateException("`hasNext()` has not been invoked");
        }
    }

    /* renamed from: q3.b$b  reason: collision with other inner class name */
    static final class C0036b extends kotlin.jvm.internal.n implements q {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f4054a;

        /* renamed from: q3.b$b$a */
        static final class a extends kotlin.jvm.internal.n implements l {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Object f4055a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ b f4056b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(Object obj, b bVar, w3.a aVar) {
                super(1);
                this.f4055a = obj;
                this.f4056b = bVar;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return s.f8222a;
            }

            public final void invoke(Throwable th) {
                if (this.f4055a != c.z()) {
                    l lVar = this.f4056b.f4049b;
                    throw null;
                }
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0036b(b bVar) {
            super(3);
            this.f4054a = bVar;
        }

        public final l a(w3.a aVar, Object obj, Object obj2) {
            return new a(obj2, this.f4054a, aVar);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            android.support.v4.media.a.a(obj);
            return a((w3.a) null, obj2, obj3);
        }
    }

    static final class c extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f4057a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f4058b;

        /* renamed from: c  reason: collision with root package name */
        int f4059c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(b bVar, V2.d dVar) {
            super(dVar);
            this.f4058b = bVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f4057a = obj;
            this.f4059c |= Integer.MIN_VALUE;
            Object t02 = b.t0(this.f4058b, this);
            if (t02 == W2.b.c()) {
                return t02;
            }
            return h.b(t02);
        }
    }

    static final class d extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f4060a;

        /* renamed from: b  reason: collision with root package name */
        Object f4061b;

        /* renamed from: c  reason: collision with root package name */
        int f4062c;

        /* renamed from: d  reason: collision with root package name */
        long f4063d;

        /* renamed from: e  reason: collision with root package name */
        /* synthetic */ Object f4064e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ b f4065f;

        /* renamed from: g  reason: collision with root package name */
        int f4066g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(b bVar, V2.d dVar) {
            super(dVar);
            this.f4065f = bVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f4064e = obj;
            this.f4066g |= Integer.MIN_VALUE;
            Object v4 = this.f4065f.u0((j) null, 0, 0, this);
            if (v4 == W2.b.c()) {
                return v4;
            }
            return h.b(v4);
        }
    }

    static {
        Class<b> cls = b.class;
        f4039d = AtomicLongFieldUpdater.newUpdater(cls, "sendersAndCloseStatus");
        f4040e = AtomicLongFieldUpdater.newUpdater(cls, "receivers");
        f4041f = AtomicLongFieldUpdater.newUpdater(cls, "bufferEnd");
        f4042g = AtomicLongFieldUpdater.newUpdater(cls, "completedExpandBuffersAndPauseFlag");
        Class<Object> cls2 = Object.class;
        f4043h = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "sendSegment");
        f4044i = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "receiveSegment");
        f4045j = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "bufferEndSegment");
        f4046k = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_closeCause");
        f4047l = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "closeHandler");
    }

    public b(int i4, l lVar) {
        C0036b bVar;
        this.f4048a = i4;
        this.f4049b = lVar;
        if (i4 >= 0) {
            this.bufferEnd = c.A(i4);
            this.completedExpandBuffersAndPauseFlag = N();
            j jVar = new j(0, (j) null, this, 3);
            this.sendSegment = jVar;
            this.receiveSegment = jVar;
            if (d0()) {
                jVar = c.f4067a;
                kotlin.jvm.internal.m.c(jVar, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
            }
            this.bufferEndSegment = jVar;
            if (lVar != null) {
                bVar = new C0036b(this);
            } else {
                bVar = null;
            }
            this.f4050c = bVar;
            this._closeCause = c.f4085s;
            return;
        }
        throw new IllegalArgumentException(("Invalid channel capacity: " + i4 + ", should be >=0").toString());
    }

    private final void A(j jVar, long j4) {
        Object b5 = C1062l.b((Object) null, 1, (C2103g) null);
        loop0:
        while (jVar != null) {
            for (int i4 = c.f4068b - 1; -1 < i4; i4--) {
                if ((jVar.f4463c * ((long) c.f4068b)) + ((long) i4) < j4) {
                    break loop0;
                }
                while (true) {
                    Object w4 = jVar.w(i4);
                    if (w4 == null || w4 == c.f4071e) {
                        if (jVar.r(i4, w4, c.z())) {
                            jVar.p();
                            break;
                        }
                    } else if (w4 instanceof w) {
                        if (jVar.r(i4, w4, c.z())) {
                            b5 = C1062l.c(b5, ((w) w4).f4109a);
                            jVar.x(i4, true);
                            break;
                        }
                    } else if (!(w4 instanceof W0)) {
                        break;
                    } else if (jVar.r(i4, w4, c.z())) {
                        b5 = C1062l.c(b5, w4);
                        jVar.x(i4, true);
                        break;
                    }
                }
            }
            jVar = (j) jVar.g();
        }
        if (b5 == null) {
            return;
        }
        if (!(b5 instanceof ArrayList)) {
            x0((W0) b5);
            return;
        }
        kotlin.jvm.internal.m.c(b5, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
        ArrayList arrayList = (ArrayList) b5;
        for (int size = arrayList.size() - 1; -1 < size; size--) {
            x0((W0) arrayList.get(size));
        }
    }

    static /* synthetic */ Object A0(b bVar, Object obj, V2.d dVar) {
        j jVar;
        j jVar2 = (j) f4043h.get(bVar);
        while (true) {
            long andIncrement = f4039d.getAndIncrement(bVar);
            long j4 = andIncrement & 1152921504606846975L;
            boolean l4 = bVar.b0(andIncrement);
            int i4 = c.f4068b;
            long j5 = j4 / ((long) i4);
            int i5 = (int) (j4 % ((long) i4));
            if (jVar2.f4463c != j5) {
                j c5 = bVar.M(j5, jVar2);
                if (c5 != null) {
                    jVar = c5;
                } else if (l4) {
                    Object m02 = bVar.m0(obj, dVar);
                    if (m02 == W2.b.c()) {
                        return m02;
                    }
                }
            } else {
                jVar = jVar2;
            }
            b bVar2 = bVar;
            Object obj2 = obj;
            int x4 = bVar2.J0(jVar, i5, obj2, j4, (Object) null, l4);
            if (x4 == 0) {
                jVar.b();
                break;
            } else if (x4 == 1) {
                break;
            } else if (x4 == 2) {
                V2.d dVar2 = dVar;
                if (l4) {
                    jVar.p();
                    Object m03 = bVar2.m0(obj2, dVar2);
                    if (m03 == W2.b.c()) {
                        return m03;
                    }
                }
            } else if (x4 == 3) {
                Object B02 = bVar2.B0(jVar, i5, obj2, j4, dVar);
                if (B02 == W2.b.c()) {
                    return B02;
                }
            } else if (x4 != 4) {
                if (x4 == 5) {
                    jVar.b();
                }
                bVar = bVar2;
                jVar2 = jVar;
                obj = obj2;
            } else {
                if (j4 < bVar2.Q()) {
                    jVar.b();
                }
                Object m04 = bVar2.m0(obj2, dVar);
                if (m04 == W2.b.c()) {
                    return m04;
                }
            }
        }
        return s.f8222a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0072 A[Catch:{ all -> 0x0064 }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x010c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00bb A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Object B0(q3.j r17, int r18, java.lang.Object r19, long r20, V2.d r22) {
        /*
            r16 = this;
            V2.d r0 = W2.b.b(r22)
            o3.n r7 = o3.C0995p.b(r0)
            r8 = 0
            r1 = r16
            r2 = r17
            r3 = r18
            r4 = r19
            r5 = r20
            int r0 = r1.J0(r2, r3, r4, r5, r7, r8)     // Catch:{ all -> 0x0064 }
            if (r0 == 0) goto L_0x00eb
            r9 = 1
            if (r0 == r9) goto L_0x00e2
            r10 = 2
            if (r0 == r10) goto L_0x00da
            r11 = 4
            if (r0 == r11) goto L_0x00ce
            java.lang.String r12 = "unexpected"
            r13 = 5
            if (r0 != r13) goto L_0x00c7
            r17.b()     // Catch:{ all -> 0x0064 }
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = f4043h     // Catch:{ all -> 0x0064 }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x0064 }
            q3.j r0 = (q3.j) r0     // Catch:{ all -> 0x0064 }
        L_0x0034:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = f4039d     // Catch:{ all -> 0x0064 }
            long r2 = r2.getAndIncrement(r1)     // Catch:{ all -> 0x0064 }
            r5 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r5 = r5 & r2
            boolean r8 = r1.b0(r2)     // Catch:{ all -> 0x0064 }
            int r2 = q3.c.f4068b     // Catch:{ all -> 0x0064 }
            long r14 = (long) r2     // Catch:{ all -> 0x0064 }
            long r14 = r5 / r14
            long r2 = (long) r2     // Catch:{ all -> 0x0064 }
            long r2 = r5 % r2
            int r3 = (int) r2     // Catch:{ all -> 0x0064 }
            r20 = r12
            long r11 = r0.f4463c     // Catch:{ all -> 0x0064 }
            int r2 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
            if (r2 == 0) goto L_0x006b
            q3.j r2 = r1.M(r14, r0)     // Catch:{ all -> 0x0064 }
            if (r2 != 0) goto L_0x006c
            if (r8 == 0) goto L_0x0067
        L_0x005f:
            r1.n0(r4, r7)     // Catch:{ all -> 0x0064 }
            goto L_0x00f9
        L_0x0064:
            r0 = move-exception
            goto L_0x0110
        L_0x0067:
            r12 = r20
        L_0x0069:
            r11 = 4
            goto L_0x0034
        L_0x006b:
            r2 = r0
        L_0x006c:
            int r0 = r1.J0(r2, r3, r4, r5, r7, r8)     // Catch:{ all -> 0x0064 }
            if (r0 == 0) goto L_0x00bb
            if (r0 == r9) goto L_0x00af
            if (r0 == r10) goto L_0x009a
            r3 = 3
            if (r0 == r3) goto L_0x0092
            r3 = 4
            if (r0 == r3) goto L_0x0086
            if (r0 == r13) goto L_0x007f
            goto L_0x0082
        L_0x007f:
            r2.b()     // Catch:{ all -> 0x0064 }
        L_0x0082:
            r12 = r20
            r0 = r2
            goto L_0x0069
        L_0x0086:
            long r8 = r1.Q()     // Catch:{ all -> 0x0064 }
            int r0 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r0 >= 0) goto L_0x005f
            r2.b()     // Catch:{ all -> 0x0064 }
            goto L_0x005f
        L_0x0092:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0064 }
            r2 = r20
            r0.<init>(r2)     // Catch:{ all -> 0x0064 }
            throw r0     // Catch:{ all -> 0x0064 }
        L_0x009a:
            if (r8 == 0) goto L_0x00a0
            r2.p()     // Catch:{ all -> 0x0064 }
            goto L_0x005f
        L_0x00a0:
            boolean r0 = b.l.a(r7)     // Catch:{ all -> 0x0064 }
            if (r0 == 0) goto L_0x00a8
            r0 = r7
            goto L_0x00a9
        L_0x00a8:
            r0 = 0
        L_0x00a9:
            if (r0 == 0) goto L_0x00f9
            r1.r0(r0, r2, r3)     // Catch:{ all -> 0x0064 }
            goto L_0x00f9
        L_0x00af:
            R2.m$a r0 = R2.m.f8216a     // Catch:{ all -> 0x0064 }
            R2.s r0 = R2.s.f8222a     // Catch:{ all -> 0x0064 }
            java.lang.Object r0 = R2.m.a(r0)     // Catch:{ all -> 0x0064 }
        L_0x00b7:
            r7.resumeWith(r0)     // Catch:{ all -> 0x0064 }
            goto L_0x00f9
        L_0x00bb:
            r2.b()     // Catch:{ all -> 0x0064 }
            R2.m$a r0 = R2.m.f8216a     // Catch:{ all -> 0x0064 }
            R2.s r0 = R2.s.f8222a     // Catch:{ all -> 0x0064 }
            java.lang.Object r0 = R2.m.a(r0)     // Catch:{ all -> 0x0064 }
            goto L_0x00b7
        L_0x00c7:
            r2 = r12
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0064 }
            r0.<init>(r2)     // Catch:{ all -> 0x0064 }
            throw r0     // Catch:{ all -> 0x0064 }
        L_0x00ce:
            long r2 = r1.Q()     // Catch:{ all -> 0x0064 }
            int r0 = (r20 > r2 ? 1 : (r20 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x005f
            r17.b()     // Catch:{ all -> 0x0064 }
            goto L_0x005f
        L_0x00da:
            r2 = r17
            r3 = r18
            r1.r0(r7, r2, r3)     // Catch:{ all -> 0x0064 }
            goto L_0x00f9
        L_0x00e2:
            R2.m$a r0 = R2.m.f8216a     // Catch:{ all -> 0x0064 }
            R2.s r0 = R2.s.f8222a     // Catch:{ all -> 0x0064 }
            java.lang.Object r0 = R2.m.a(r0)     // Catch:{ all -> 0x0064 }
            goto L_0x00b7
        L_0x00eb:
            r2 = r17
            r2.b()     // Catch:{ all -> 0x0064 }
            R2.m$a r0 = R2.m.f8216a     // Catch:{ all -> 0x0064 }
            R2.s r0 = R2.s.f8222a     // Catch:{ all -> 0x0064 }
            java.lang.Object r0 = R2.m.a(r0)     // Catch:{ all -> 0x0064 }
            goto L_0x00b7
        L_0x00f9:
            java.lang.Object r0 = r7.v()
            java.lang.Object r2 = W2.b.c()
            if (r0 != r2) goto L_0x0106
            kotlin.coroutines.jvm.internal.h.c(r22)
        L_0x0106:
            java.lang.Object r2 = W2.b.c()
            if (r0 != r2) goto L_0x010d
            return r0
        L_0x010d:
            R2.s r0 = R2.s.f8222a
            return r0
        L_0x0110:
            r7.J()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: q3.b.B0(q3.j, int, java.lang.Object, long, V2.d):java.lang.Object");
    }

    private final boolean C0(long j4) {
        if (b0(j4)) {
            return false;
        }
        return !y(j4 & 1152921504606846975L);
    }

    private final j D() {
        j jVar = f4045j.get(this);
        j jVar2 = (j) f4043h.get(this);
        if (jVar2.f4463c > ((j) jVar).f4463c) {
            jVar = jVar2;
        }
        j jVar3 = (j) f4044i.get(this);
        if (jVar3.f4463c > ((j) jVar).f4463c) {
            jVar = jVar3;
        }
        return (j) C1054d.b((C1055e) jVar);
    }

    private final boolean D0(Object obj, Object obj2) {
        l lVar = null;
        if (obj instanceof t) {
            kotlin.jvm.internal.m.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
            t tVar = (t) obj;
            C0991n nVar = tVar.f4108a;
            h b5 = h.b(h.f4091b.c(obj2));
            l lVar2 = this.f4049b;
            if (lVar2 != null) {
                lVar = x.a(lVar2, obj2, tVar.f4108a.getContext());
            }
            return c.B(nVar, b5, lVar);
        } else if (obj instanceof a) {
            kotlin.jvm.internal.m.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
            return ((a) obj).i(obj2);
        } else if (obj instanceof C0989m) {
            kotlin.jvm.internal.m.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
            C0989m mVar = (C0989m) obj;
            l lVar3 = this.f4049b;
            if (lVar3 != null) {
                lVar = x.a(lVar3, obj2, mVar.getContext());
            }
            return c.B(mVar, obj2, lVar);
        } else {
            throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
        }
    }

    private final boolean E0(Object obj, j jVar, int i4) {
        if (obj instanceof C0989m) {
            kotlin.jvm.internal.m.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            return c.C((C0989m) obj, s.f8222a, (l) null, 2, (Object) null);
        }
        throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
    }

    private final void F(long j4) {
        w0(G(j4));
    }

    private final boolean F0(j jVar, int i4, long j4) {
        Object w4 = jVar.w(i4);
        if (!(w4 instanceof W0) || j4 < f4040e.get(this) || !jVar.r(i4, w4, c.f4073g)) {
            return G0(jVar, i4, j4);
        }
        if (E0(w4, jVar, i4)) {
            jVar.A(i4, c.f4070d);
            return true;
        }
        jVar.A(i4, c.f4076j);
        jVar.x(i4, false);
        return false;
    }

    private final j G(long j4) {
        j D4 = D();
        if (c0()) {
            long e02 = e0(D4);
            if (e02 != -1) {
                I(e02);
            }
        }
        A(D4, j4);
        return D4;
    }

    private final boolean G0(j jVar, int i4, long j4) {
        while (true) {
            Object w4 = jVar.w(i4);
            if (w4 instanceof W0) {
                if (j4 < f4040e.get(this)) {
                    if (jVar.r(i4, w4, new w((W0) w4))) {
                        return true;
                    }
                } else if (jVar.r(i4, w4, c.f4073g)) {
                    if (E0(w4, jVar, i4)) {
                        jVar.A(i4, c.f4070d);
                        return true;
                    }
                    jVar.A(i4, c.f4076j);
                    jVar.x(i4, false);
                    return false;
                }
            } else if (w4 == c.f4076j) {
                return false;
            } else {
                if (w4 == null) {
                    if (jVar.r(i4, w4, c.f4071e)) {
                        return true;
                    }
                } else if (w4 == c.f4070d || w4 == c.f4074h || w4 == c.f4075i || w4 == c.f4077k || w4 == c.z()) {
                    return true;
                } else {
                    if (w4 != c.f4072f) {
                        throw new IllegalStateException(("Unexpected cell state: " + w4).toString());
                    }
                }
            }
        }
        return true;
    }

    private final void H() {
        C();
    }

    /* access modifiers changed from: private */
    public final Object H0(j jVar, int i4, long j4, Object obj) {
        Object w4 = jVar.w(i4);
        if (w4 == null) {
            if (j4 >= (f4039d.get(this) & 1152921504606846975L)) {
                if (obj == null) {
                    return c.f4080n;
                }
                if (jVar.r(i4, w4, obj)) {
                    J();
                    return c.f4079m;
                }
            }
        } else if (w4 == c.f4070d && jVar.r(i4, w4, c.f4075i)) {
            J();
            return jVar.y(i4);
        }
        return I0(jVar, i4, j4, obj);
    }

    private final Object I0(j jVar, int i4, long j4, Object obj) {
        while (true) {
            Object w4 = jVar.w(i4);
            if (w4 == null || w4 == c.f4071e) {
                if (j4 < (f4039d.get(this) & 1152921504606846975L)) {
                    if (jVar.r(i4, w4, c.f4074h)) {
                        J();
                        return c.f4081o;
                    }
                } else if (obj == null) {
                    return c.f4080n;
                } else {
                    if (jVar.r(i4, w4, obj)) {
                        J();
                        return c.f4079m;
                    }
                }
            } else if (w4 == c.f4070d) {
                if (jVar.r(i4, w4, c.f4075i)) {
                    J();
                    return jVar.y(i4);
                }
            } else if (w4 == c.f4076j) {
                return c.f4081o;
            } else {
                if (w4 == c.f4074h) {
                    return c.f4081o;
                }
                if (w4 == c.z()) {
                    J();
                    return c.f4081o;
                } else if (w4 != c.f4073g && jVar.r(i4, w4, c.f4072f)) {
                    boolean z4 = w4 instanceof w;
                    if (z4) {
                        w4 = ((w) w4).f4109a;
                    }
                    if (E0(w4, jVar, i4)) {
                        jVar.A(i4, c.f4075i);
                        J();
                        return jVar.y(i4);
                    }
                    jVar.A(i4, c.f4076j);
                    jVar.x(i4, false);
                    if (z4) {
                        J();
                    }
                    return c.f4081o;
                }
            }
        }
    }

    private final void J() {
        if (!d0()) {
            j jVar = (j) f4045j.get(this);
            while (true) {
                long andIncrement = f4041f.getAndIncrement(this);
                int i4 = c.f4068b;
                long j4 = andIncrement / ((long) i4);
                if (S() <= andIncrement) {
                    if (jVar.f4463c < j4 && jVar.e() != null) {
                        i0(j4, jVar);
                    }
                    V(this, 0, 1, (Object) null);
                    return;
                }
                if (jVar.f4463c != j4) {
                    j K4 = K(j4, jVar, andIncrement);
                    if (K4 == null) {
                        continue;
                    } else {
                        jVar = K4;
                    }
                }
                if (F0(jVar, (int) (andIncrement % ((long) i4)), andIncrement)) {
                    V(this, 0, 1, (Object) null);
                    return;
                }
                V(this, 0, 1, (Object) null);
            }
        }
    }

    /* access modifiers changed from: private */
    public final int J0(j jVar, int i4, Object obj, long j4, Object obj2, boolean z4) {
        jVar.B(i4, obj);
        if (z4) {
            int K02 = K0(jVar, i4, obj, j4, obj2, z4);
            return K02;
        }
        boolean z5 = z4;
        Object obj3 = obj2;
        long j5 = j4;
        Object obj4 = obj;
        Object w4 = jVar.w(i4);
        if (w4 == null) {
            if (y(j5)) {
                if (jVar.r(i4, (Object) null, c.f4070d)) {
                    return 1;
                }
            } else if (obj3 == null) {
                return 3;
            } else {
                if (jVar.r(i4, (Object) null, obj3)) {
                    return 2;
                }
            }
        } else if (w4 instanceof W0) {
            jVar.s(i4);
            if (D0(w4, obj4)) {
                jVar.A(i4, c.f4075i);
                o0();
                return 0;
            } else if (jVar.t(i4, c.f4077k) == c.f4077k) {
                return 5;
            } else {
                jVar.x(i4, true);
                return 5;
            }
        }
        return K0(jVar, i4, obj4, j5, obj3, z5);
    }

    private final j K(long j4, j jVar, long j5) {
        Object c5;
        long j6 = j4;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4045j;
        p pVar = (p) c.y();
        j jVar2 = jVar;
        loop0:
        while (true) {
            c5 = C1054d.c(jVar2, j6, pVar);
            if (D.c(c5)) {
                break;
            }
            C b5 = D.b(c5);
            while (true) {
                C c6 = (C) atomicReferenceFieldUpdater.get(this);
                if (c6.f4463c >= b5.f4463c) {
                    break loop0;
                } else if (b5.q()) {
                    if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, c6, b5)) {
                        if (c6.m()) {
                            c6.k();
                        }
                    } else if (b5.m()) {
                        b5.k();
                    }
                }
            }
        }
        if (D.c(c5)) {
            H();
            i0(j4, jVar);
            V(this, 0, 1, (Object) null);
            return null;
        }
        j jVar3 = (j) D.b(c5);
        long j7 = jVar3.f4463c;
        if (j7 <= j6) {
            return jVar3;
        }
        int i4 = c.f4068b;
        if (f4041f.compareAndSet(this, j5 + 1, j7 * ((long) i4))) {
            U((jVar3.f4463c * ((long) i4)) - j5);
        } else {
            V(this, 0, 1, (Object) null);
        }
        return null;
    }

    private final int K0(j jVar, int i4, Object obj, long j4, Object obj2, boolean z4) {
        while (true) {
            Object w4 = jVar.w(i4);
            if (w4 == null) {
                if (!y(j4) || z4) {
                    if (z4) {
                        if (jVar.r(i4, (Object) null, c.f4076j)) {
                            jVar.x(i4, false);
                            return 4;
                        }
                    } else if (obj2 == null) {
                        return 3;
                    } else {
                        if (jVar.r(i4, (Object) null, obj2)) {
                            return 2;
                        }
                    }
                } else if (jVar.r(i4, (Object) null, c.f4070d)) {
                    return 1;
                }
            } else if (w4 == c.f4071e) {
                if (jVar.r(i4, w4, c.f4070d)) {
                    return 1;
                }
            } else if (w4 == c.f4077k) {
                jVar.s(i4);
                return 5;
            } else if (w4 == c.f4074h) {
                jVar.s(i4);
                return 5;
            } else if (w4 == c.z()) {
                jVar.s(i4);
                H();
                return 4;
            } else {
                jVar.s(i4);
                if (w4 instanceof w) {
                    w4 = ((w) w4).f4109a;
                }
                if (D0(w4, obj)) {
                    jVar.A(i4, c.f4075i);
                    o0();
                    return 0;
                }
                if (jVar.t(i4, c.f4077k) != c.f4077k) {
                    jVar.x(i4, true);
                }
                return 5;
            }
        }
    }

    /* access modifiers changed from: private */
    public final j L(long j4, j jVar) {
        Object c5;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4044i;
        p pVar = (p) c.y();
        loop0:
        while (true) {
            c5 = C1054d.c(jVar, j4, pVar);
            if (D.c(c5)) {
                break;
            }
            C b5 = D.b(c5);
            while (true) {
                C c6 = (C) atomicReferenceFieldUpdater.get(this);
                if (c6.f4463c >= b5.f4463c) {
                    break loop0;
                } else if (b5.q()) {
                    if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, c6, b5)) {
                        if (c6.m()) {
                            c6.k();
                        }
                    } else if (b5.m()) {
                        b5.k();
                    }
                }
            }
        }
        if (D.c(c5)) {
            H();
            if (jVar.f4463c * ((long) c.f4068b) < S()) {
                jVar.b();
            }
            return null;
        }
        j jVar2 = (j) D.b(c5);
        if (!d0() && j4 <= N() / ((long) c.f4068b)) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f4045j;
            while (true) {
                C c7 = (C) atomicReferenceFieldUpdater2.get(this);
                if (c7.f4463c >= jVar2.f4463c || !jVar2.q()) {
                    break;
                } else if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater2, this, c7, jVar2)) {
                    if (c7.m()) {
                        c7.k();
                    }
                } else if (jVar2.m()) {
                    jVar2.k();
                }
            }
        }
        long j5 = jVar2.f4463c;
        if (j5 <= j4) {
            return jVar2;
        }
        int i4 = c.f4068b;
        L0(j5 * ((long) i4));
        if (jVar2.f4463c * ((long) i4) < S()) {
            jVar2.b();
        }
        return null;
    }

    private final void L0(long j4) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f4040e;
        while (true) {
            long j5 = atomicLongFieldUpdater.get(this);
            if (j5 < j4) {
                long j6 = j4;
                if (!f4040e.compareAndSet(this, j5, j6)) {
                    j4 = j6;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public final j M(long j4, j jVar) {
        Object c5;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4043h;
        p pVar = (p) c.y();
        loop0:
        while (true) {
            c5 = C1054d.c(jVar, j4, pVar);
            if (D.c(c5)) {
                break;
            }
            C b5 = D.b(c5);
            while (true) {
                C c6 = (C) atomicReferenceFieldUpdater.get(this);
                if (c6.f4463c >= b5.f4463c) {
                    break loop0;
                } else if (b5.q()) {
                    if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, c6, b5)) {
                        if (c6.m()) {
                            c6.k();
                        }
                    } else if (b5.m()) {
                        b5.k();
                    }
                }
            }
        }
        if (D.c(c5)) {
            H();
            if (jVar.f4463c * ((long) c.f4068b) < Q()) {
                jVar.b();
            }
            return null;
        }
        j jVar2 = (j) D.b(c5);
        long j5 = jVar2.f4463c;
        if (j5 <= j4) {
            return jVar2;
        }
        int i4 = c.f4068b;
        M0(j5 * ((long) i4));
        if (jVar2.f4463c * ((long) i4) < Q()) {
            jVar2.b();
        }
        return null;
    }

    private final void M0(long j4) {
        long j5;
        long j6;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f4039d;
        do {
            j5 = atomicLongFieldUpdater.get(this);
            j6 = 1152921504606846975L & j5;
            if (j6 < j4) {
            } else {
                return;
            }
        } while (!f4039d.compareAndSet(this, j5, c.w(j6, (int) (j5 >> 60))));
    }

    private final long N() {
        return f4041f.get(this);
    }

    /* access modifiers changed from: private */
    public final Throwable P() {
        Throwable O4 = O();
        if (O4 == null) {
            return new n("Channel was closed");
        }
        return O4;
    }

    private final void U(long j4) {
        if ((f4042g.addAndGet(this, j4) & 4611686018427387904L) != 0) {
            do {
            } while ((f4042g.get(this) & 4611686018427387904L) != 0);
        }
    }

    static /* synthetic */ void V(b bVar, long j4, int i4, Object obj) {
        if (obj == null) {
            if ((i4 & 1) != 0) {
                j4 = 1;
            }
            bVar.U(j4);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incCompletedExpandBufferAttempts");
    }

    private final void W() {
        Object obj;
        F f4;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4047l;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                f4 = c.f4083q;
            } else {
                f4 = c.f4084r;
            }
        } while (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, obj, f4));
        if (obj != null) {
            l lVar = (l) G.b(obj, 1);
            ((l) obj).invoke(O());
        }
    }

    private final boolean X(j jVar, int i4, long j4) {
        Object w4;
        do {
            w4 = jVar.w(i4);
            if (w4 != null && w4 != c.f4071e) {
                if (w4 == c.f4070d) {
                    return true;
                }
                if (w4 == c.f4076j || w4 == c.z() || w4 == c.f4075i || w4 == c.f4074h) {
                    return false;
                }
                if (w4 == c.f4073g) {
                    return true;
                }
                if (w4 != c.f4072f && j4 == Q()) {
                    return true;
                }
                return false;
            }
        } while (!jVar.r(i4, w4, c.f4074h));
        J();
        return false;
    }

    private final boolean Y(long j4, boolean z4) {
        int i4 = (int) (j4 >> 60);
        if (i4 == 0 || i4 == 1) {
            return false;
        }
        if (i4 == 2) {
            G(j4 & 1152921504606846975L);
            if (!z4 || !T()) {
                return true;
            }
            return false;
        } else if (i4 == 3) {
            F(j4 & 1152921504606846975L);
            return true;
        } else {
            throw new IllegalStateException(("unexpected close status: " + i4).toString());
        }
    }

    private final boolean a0(long j4) {
        return Y(j4, true);
    }

    /* access modifiers changed from: private */
    public final boolean b0(long j4) {
        return Y(j4, false);
    }

    private final boolean d0() {
        long N4 = N();
        if (N4 == 0 || N4 == Long.MAX_VALUE) {
            return true;
        }
        return false;
    }

    private final long e0(j jVar) {
        do {
            int i4 = c.f4068b;
            while (true) {
                i4--;
                if (-1 < i4) {
                    long j4 = (jVar.f4463c * ((long) c.f4068b)) + ((long) i4);
                    if (j4 < Q()) {
                        return -1;
                    }
                    while (true) {
                        Object w4 = jVar.w(i4);
                        if (w4 == null || w4 == c.f4071e) {
                            if (jVar.r(i4, w4, c.z())) {
                                jVar.p();
                                break;
                            }
                        } else if (w4 == c.f4070d) {
                            return j4;
                        }
                    }
                } else {
                    jVar = (j) jVar.g();
                }
            }
        } while (jVar != null);
        return -1;
    }

    private final void f0() {
        long j4;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f4039d;
        do {
            j4 = atomicLongFieldUpdater.get(this);
            if (((int) (j4 >> 60)) != 0) {
                return;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j4, c.w(1152921504606846975L & j4, 1)));
    }

    private final void g0() {
        long j4;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f4039d;
        do {
            j4 = atomicLongFieldUpdater.get(this);
        } while (!atomicLongFieldUpdater.compareAndSet(this, j4, c.w(1152921504606846975L & j4, 3)));
    }

    private final void h0() {
        long j4;
        long b5;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f4039d;
        do {
            j4 = atomicLongFieldUpdater.get(this);
            int i4 = (int) (j4 >> 60);
            if (i4 == 0) {
                b5 = c.w(1152921504606846975L & j4, 2);
            } else if (i4 == 1) {
                b5 = c.w(1152921504606846975L & j4, 3);
            } else {
                return;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j4, b5));
    }

    private final void i0(long j4, j jVar) {
        j jVar2;
        j jVar3;
        while (jVar.f4463c < j4 && (jVar3 = (j) jVar.e()) != null) {
            jVar = jVar3;
        }
        while (true) {
            if (!jVar.h() || (jVar2 = (j) jVar.e()) == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4045j;
                while (true) {
                    C c5 = (C) atomicReferenceFieldUpdater.get(this);
                    if (c5.f4463c < jVar.f4463c) {
                        if (!jVar.q()) {
                            continue;
                            break;
                        } else if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, c5, jVar)) {
                            if (c5.m()) {
                                c5.k();
                                return;
                            }
                            return;
                        } else if (jVar.m()) {
                            jVar.k();
                        }
                    } else {
                        return;
                    }
                }
            } else {
                jVar = jVar2;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void k0(C0989m mVar) {
        m.a aVar = R2.m.f8216a;
        mVar.resumeWith(R2.m.a(h.b(h.f4091b.a(O()))));
    }

    /* access modifiers changed from: private */
    public final void l0(C0989m mVar) {
        m.a aVar = R2.m.f8216a;
        mVar.resumeWith(R2.m.a(n.a(P())));
    }

    private final Object m0(Object obj, V2.d dVar) {
        Q d5;
        C0991n nVar = new C0991n(W2.b.b(dVar), 1);
        nVar.z();
        l lVar = this.f4049b;
        if (lVar == null || (d5 = x.d(lVar, obj, (Q) null, 2, (Object) null)) == null) {
            Throwable R4 = R();
            m.a aVar = R2.m.f8216a;
            nVar.resumeWith(R2.m.a(n.a(R4)));
        } else {
            R2.a.a(d5, R());
            m.a aVar2 = R2.m.f8216a;
            nVar.resumeWith(R2.m.a(n.a(d5)));
        }
        Object v4 = nVar.v();
        if (v4 == W2.b.c()) {
            h.c(dVar);
        }
        if (v4 == W2.b.c()) {
            return v4;
        }
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public final void n0(Object obj, C0989m mVar) {
        l lVar = this.f4049b;
        if (lVar != null) {
            x.b(lVar, obj, mVar.getContext());
        }
        Throwable R4 = R();
        m.a aVar = R2.m.f8216a;
        mVar.resumeWith(R2.m.a(n.a(R4)));
    }

    /* access modifiers changed from: private */
    public final void q0(W0 w02, j jVar, int i4) {
        p0();
        w02.d(jVar, i4);
    }

    /* access modifiers changed from: private */
    public final void r0(W0 w02, j jVar, int i4) {
        w02.d(jVar, i4 + c.f4068b);
    }

    static /* synthetic */ Object s0(b bVar, V2.d dVar) {
        j jVar;
        j jVar2 = (j) f4044i.get(bVar);
        while (!bVar.Z()) {
            long andIncrement = f4040e.getAndIncrement(bVar);
            int i4 = c.f4068b;
            long j4 = andIncrement / ((long) i4);
            int i5 = (int) (andIncrement % ((long) i4));
            if (jVar2.f4463c != j4) {
                j b5 = bVar.L(j4, jVar2);
                if (b5 == null) {
                    continue;
                } else {
                    jVar = b5;
                }
            } else {
                jVar = jVar2;
            }
            b bVar2 = bVar;
            Object w4 = bVar2.H0(jVar, i5, andIncrement, (Object) null);
            if (w4 == c.f4079m) {
                throw new IllegalStateException("unexpected");
            } else if (w4 == c.f4081o) {
                if (andIncrement < bVar2.S()) {
                    jVar.b();
                }
                bVar = bVar2;
                jVar2 = jVar;
            } else if (w4 == c.f4080n) {
                return bVar2.v0(jVar, i5, andIncrement, dVar);
            } else {
                jVar.b();
                return w4;
            }
        }
        throw E.a(bVar.P());
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object t0(q3.b r13, V2.d r14) {
        /*
            boolean r0 = r14 instanceof q3.b.c
            if (r0 == 0) goto L_0x0014
            r0 = r14
            q3.b$c r0 = (q3.b.c) r0
            int r1 = r0.f4059c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0014
            int r1 = r1 - r2
            r0.f4059c = r1
        L_0x0012:
            r6 = r0
            goto L_0x001a
        L_0x0014:
            q3.b$c r0 = new q3.b$c
            r0.<init>(r13, r14)
            goto L_0x0012
        L_0x001a:
            java.lang.Object r14 = r6.f4057a
            java.lang.Object r0 = W2.b.c()
            int r1 = r6.f4059c
            r2 = 1
            if (r1 == 0) goto L_0x0039
            if (r1 != r2) goto L_0x0031
            R2.n.b(r14)
            q3.h r14 = (q3.h) r14
            java.lang.Object r13 = r14.k()
            return r13
        L_0x0031:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x0039:
            R2.n.b(r14)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r14 = f4044i
            java.lang.Object r14 = r14.get(r13)
            q3.j r14 = (q3.j) r14
        L_0x0046:
            boolean r1 = r13.Z()
            if (r1 == 0) goto L_0x0057
            q3.h$b r14 = q3.h.f4091b
            java.lang.Throwable r13 = r13.O()
            java.lang.Object r13 = r14.a(r13)
            return r13
        L_0x0057:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = f4040e
            long r4 = r1.getAndIncrement(r13)
            int r1 = q3.c.f4068b
            long r7 = (long) r1
            long r7 = r4 / r7
            long r9 = (long) r1
            long r9 = r4 % r9
            int r3 = (int) r9
            long r9 = r14.f4463c
            int r1 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r1 == 0) goto L_0x0077
            q3.j r1 = r13.L(r7, r14)
            if (r1 != 0) goto L_0x0075
            goto L_0x0046
        L_0x0075:
            r8 = r1
            goto L_0x0078
        L_0x0077:
            r8 = r14
        L_0x0078:
            r12 = 0
            r7 = r13
            r9 = r3
            r10 = r4
            java.lang.Object r13 = r7.H0(r8, r9, r10, r12)
            r1 = r7
            t3.F r14 = q3.c.f4079m
            if (r13 == r14) goto L_0x00b6
            t3.F r14 = q3.c.f4081o
            if (r13 != r14) goto L_0x009b
            long r13 = r1.S()
            int r3 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r3 >= 0) goto L_0x0098
            r8.b()
        L_0x0098:
            r13 = r1
            r14 = r8
            goto L_0x0046
        L_0x009b:
            t3.F r14 = q3.c.f4080n
            if (r13 != r14) goto L_0x00ac
            r6.f4059c = r2
            r2 = r8
            java.lang.Object r13 = r1.u0(r2, r3, r4, r6)
            if (r13 != r0) goto L_0x00ab
            return r0
        L_0x00ab:
            return r13
        L_0x00ac:
            r8.b()
            q3.h$b r14 = q3.h.f4091b
            java.lang.Object r13 = r14.c(r13)
            return r13
        L_0x00b6:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "unexpected"
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: q3.b.t0(q3.b, V2.d):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object u0(q3.j r11, int r12, long r13, V2.d r15) {
        /*
            r10 = this;
            boolean r0 = r15 instanceof q3.b.d
            if (r0 == 0) goto L_0x0013
            r0 = r15
            q3.b$d r0 = (q3.b.d) r0
            int r1 = r0.f4066g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f4066g = r1
            goto L_0x0018
        L_0x0013:
            q3.b$d r0 = new q3.b$d
            r0.<init>(r10, r15)
        L_0x0018:
            java.lang.Object r15 = r0.f4064e
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.f4066g
            r3 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r11 = r0.f4061b
            q3.j r11 = (q3.j) r11
            java.lang.Object r11 = r0.f4060a
            q3.b r11 = (q3.b) r11
            R2.n.b(r15)
            r2 = r10
            goto L_0x0132
        L_0x0033:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x003b:
            R2.n.b(r15)
            r0.f4060a = r10
            r0.f4061b = r11
            r0.f4062c = r12
            r0.f4063d = r13
            r0.f4066g = r3
            V2.d r15 = W2.b.b(r0)
            o3.n r15 = o3.C0995p.b(r15)
            q3.t r7 = new q3.t     // Catch:{ all -> 0x0139 }
            java.lang.String r2 = "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuationImpl<kotlinx.coroutines.channels.ChannelResult<E of kotlinx.coroutines.channels.BufferedChannel.receiveCatchingOnNoWaiterSuspend_GKJJFZk$lambda$35>>"
            kotlin.jvm.internal.m.c(r15, r2)     // Catch:{ all -> 0x0139 }
            r7.<init>(r15)     // Catch:{ all -> 0x0139 }
            r2 = r10
            r3 = r11
            r4 = r12
            r5 = r13
            java.lang.Object r11 = r2.H0(r3, r4, r5, r7)     // Catch:{ all -> 0x006d }
            t3.F r12 = q3.c.f4079m     // Catch:{ all -> 0x006d }
            if (r11 != r12) goto L_0x0071
            r10.q0(r7, r3, r4)     // Catch:{ all -> 0x006d }
            goto L_0x0122
        L_0x006d:
            r0 = move-exception
        L_0x006e:
            r11 = r0
            goto L_0x013d
        L_0x0071:
            t3.F r12 = q3.c.f4081o     // Catch:{ all -> 0x006d }
            r13 = 0
            if (r11 != r12) goto L_0x0108
            long r11 = r10.S()     // Catch:{ all -> 0x006d }
            int r14 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r14 >= 0) goto L_0x0083
            r3.b()     // Catch:{ all -> 0x006d }
        L_0x0083:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r11 = f4044i     // Catch:{ all -> 0x006d }
            java.lang.Object r11 = r11.get(r10)     // Catch:{ all -> 0x006d }
            q3.j r11 = (q3.j) r11     // Catch:{ all -> 0x006d }
        L_0x008d:
            boolean r12 = r10.Z()     // Catch:{ all -> 0x006d }
            if (r12 == 0) goto L_0x0098
            r10.k0(r15)     // Catch:{ all -> 0x006d }
            goto L_0x0122
        L_0x0098:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r12 = f4040e     // Catch:{ all -> 0x006d }
            long r5 = r12.getAndIncrement(r10)     // Catch:{ all -> 0x006d }
            int r12 = q3.c.f4068b     // Catch:{ all -> 0x006d }
            long r3 = (long) r12     // Catch:{ all -> 0x006d }
            long r3 = r5 / r3
            long r8 = (long) r12     // Catch:{ all -> 0x006d }
            long r8 = r5 % r8
            int r12 = (int) r8     // Catch:{ all -> 0x006d }
            long r8 = r11.f4463c     // Catch:{ all -> 0x006d }
            int r14 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r14 == 0) goto L_0x00b9
            q3.j r14 = r10.L(r3, r11)     // Catch:{ all -> 0x006d }
            if (r14 != 0) goto L_0x00b6
            goto L_0x008d
        L_0x00b6:
            r3 = r14
        L_0x00b7:
            r4 = r12
            goto L_0x00bb
        L_0x00b9:
            r3 = r11
            goto L_0x00b7
        L_0x00bb:
            java.lang.Object r11 = r2.H0(r3, r4, r5, r7)     // Catch:{ all -> 0x006d }
            r14 = r3
            t3.F r12 = q3.c.f4079m     // Catch:{ all -> 0x006d }
            if (r11 != r12) goto L_0x00ca
            r10.q0(r7, r14, r4)     // Catch:{ all -> 0x006d }
            goto L_0x0122
        L_0x00ca:
            t3.F r12 = q3.c.f4081o     // Catch:{ all -> 0x006d }
            if (r11 != r12) goto L_0x00dd
            long r11 = r10.S()     // Catch:{ all -> 0x006d }
            int r3 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r3 >= 0) goto L_0x00db
            r14.b()     // Catch:{ all -> 0x006d }
        L_0x00db:
            r11 = r14
            goto L_0x008d
        L_0x00dd:
            t3.F r12 = q3.c.f4080n     // Catch:{ all -> 0x006d }
            if (r11 == r12) goto L_0x0100
            r14.b()     // Catch:{ all -> 0x006d }
            q3.h$b r12 = q3.h.f4091b     // Catch:{ all -> 0x006d }
            java.lang.Object r12 = r12.c(r11)     // Catch:{ all -> 0x006d }
            q3.h r12 = q3.h.b(r12)     // Catch:{ all -> 0x006d }
            d3.l r14 = r2.f4049b     // Catch:{ all -> 0x006d }
            if (r14 == 0) goto L_0x00fc
            V2.g r13 = r15.getContext()     // Catch:{ all -> 0x006d }
            d3.l r13 = t3.x.a(r14, r11, r13)     // Catch:{ all -> 0x006d }
        L_0x00fc:
            r15.c(r12, r13)     // Catch:{ all -> 0x006d }
            goto L_0x0122
        L_0x0100:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException     // Catch:{ all -> 0x006d }
            java.lang.String r12 = "unexpected"
            r11.<init>(r12)     // Catch:{ all -> 0x006d }
            throw r11     // Catch:{ all -> 0x006d }
        L_0x0108:
            r3.b()     // Catch:{ all -> 0x006d }
            q3.h$b r12 = q3.h.f4091b     // Catch:{ all -> 0x006d }
            java.lang.Object r12 = r12.c(r11)     // Catch:{ all -> 0x006d }
            q3.h r12 = q3.h.b(r12)     // Catch:{ all -> 0x006d }
            d3.l r14 = r2.f4049b     // Catch:{ all -> 0x006d }
            if (r14 == 0) goto L_0x00fc
            V2.g r13 = r15.getContext()     // Catch:{ all -> 0x006d }
            d3.l r13 = t3.x.a(r14, r11, r13)     // Catch:{ all -> 0x006d }
            goto L_0x00fc
        L_0x0122:
            java.lang.Object r15 = r15.v()
            java.lang.Object r11 = W2.b.c()
            if (r15 != r11) goto L_0x012f
            kotlin.coroutines.jvm.internal.h.c(r0)
        L_0x012f:
            if (r15 != r1) goto L_0x0132
            return r1
        L_0x0132:
            q3.h r15 = (q3.h) r15
            java.lang.Object r11 = r15.k()
            return r11
        L_0x0139:
            r0 = move-exception
            r2 = r10
            goto L_0x006e
        L_0x013d:
            r15.J()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: q3.b.u0(q3.j, int, long, V2.d):java.lang.Object");
    }

    /* JADX WARNING: type inference failed for: r12v1 */
    /* JADX WARNING: type inference failed for: r12v4, types: [d3.l] */
    /* JADX WARNING: type inference failed for: r12v5, types: [o3.W0] */
    /* JADX WARNING: type inference failed for: r12v6 */
    /* JADX WARNING: type inference failed for: r12v9 */
    /* JADX WARNING: type inference failed for: r12v10 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Object v0(q3.j r10, int r11, long r12, V2.d r14) {
        /*
            r9 = this;
            V2.d r0 = W2.b.b(r14)
            o3.n r6 = o3.C0995p.b(r0)
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r12
            java.lang.Object r10 = r1.H0(r2, r3, r4, r6)     // Catch:{ all -> 0x001b }
            t3.F r11 = q3.c.f4079m     // Catch:{ all -> 0x001b }
            if (r10 != r11) goto L_0x001f
            r9.q0(r6, r2, r3)     // Catch:{ all -> 0x001b }
            goto L_0x00c5
        L_0x001b:
            r0 = move-exception
            r10 = r0
            goto L_0x00d3
        L_0x001f:
            t3.F r11 = q3.c.f4081o     // Catch:{ all -> 0x001b }
            r12 = 0
            if (r10 != r11) goto L_0x00b5
            long r10 = r9.S()     // Catch:{ all -> 0x001b }
            int r13 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r13 >= 0) goto L_0x0031
            r2.b()     // Catch:{ all -> 0x001b }
        L_0x0031:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r10 = f4044i     // Catch:{ all -> 0x001b }
            java.lang.Object r10 = r10.get(r9)     // Catch:{ all -> 0x001b }
            q3.j r10 = (q3.j) r10     // Catch:{ all -> 0x001b }
        L_0x003b:
            boolean r11 = r9.Z()     // Catch:{ all -> 0x001b }
            if (r11 == 0) goto L_0x0046
            r9.l0(r6)     // Catch:{ all -> 0x001b }
            goto L_0x00c5
        L_0x0046:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r11 = f4040e     // Catch:{ all -> 0x001b }
            long r4 = r11.getAndIncrement(r9)     // Catch:{ all -> 0x001b }
            int r11 = q3.c.f4068b     // Catch:{ all -> 0x001b }
            long r2 = (long) r11     // Catch:{ all -> 0x001b }
            long r2 = r4 / r2
            long r7 = (long) r11     // Catch:{ all -> 0x001b }
            long r7 = r4 % r7
            int r11 = (int) r7     // Catch:{ all -> 0x001b }
            long r7 = r10.f4463c     // Catch:{ all -> 0x001b }
            int r13 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r13 == 0) goto L_0x0067
            q3.j r13 = r9.L(r2, r10)     // Catch:{ all -> 0x001b }
            if (r13 != 0) goto L_0x0064
            goto L_0x003b
        L_0x0064:
            r2 = r13
        L_0x0065:
            r3 = r11
            goto L_0x0069
        L_0x0067:
            r2 = r10
            goto L_0x0065
        L_0x0069:
            java.lang.Object r10 = r1.H0(r2, r3, r4, r6)     // Catch:{ all -> 0x001b }
            r13 = r2
            t3.F r11 = q3.c.f4079m     // Catch:{ all -> 0x001b }
            if (r10 != r11) goto L_0x0081
            boolean r10 = b.l.a(r6)     // Catch:{ all -> 0x001b }
            if (r10 == 0) goto L_0x007b
            r12 = r6
        L_0x007b:
            if (r12 == 0) goto L_0x00c5
            r9.q0(r12, r13, r3)     // Catch:{ all -> 0x001b }
            goto L_0x00c5
        L_0x0081:
            t3.F r11 = q3.c.f4081o     // Catch:{ all -> 0x001b }
            if (r10 != r11) goto L_0x0094
            long r10 = r9.S()     // Catch:{ all -> 0x001b }
            int r0 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r0 >= 0) goto L_0x0092
            r13.b()     // Catch:{ all -> 0x001b }
        L_0x0092:
            r10 = r13
            goto L_0x003b
        L_0x0094:
            t3.F r11 = q3.c.f4080n     // Catch:{ all -> 0x001b }
            if (r10 == r11) goto L_0x00ad
            r13.b()     // Catch:{ all -> 0x001b }
            d3.l r11 = r1.f4049b     // Catch:{ all -> 0x001b }
            if (r11 == 0) goto L_0x00a9
            V2.g r12 = r6.getContext()     // Catch:{ all -> 0x001b }
            d3.l r12 = t3.x.a(r11, r10, r12)     // Catch:{ all -> 0x001b }
        L_0x00a9:
            r6.c(r10, r12)     // Catch:{ all -> 0x001b }
            goto L_0x00c5
        L_0x00ad:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x001b }
            java.lang.String r11 = "unexpected"
            r10.<init>(r11)     // Catch:{ all -> 0x001b }
            throw r10     // Catch:{ all -> 0x001b }
        L_0x00b5:
            r2.b()     // Catch:{ all -> 0x001b }
            d3.l r11 = r1.f4049b     // Catch:{ all -> 0x001b }
            if (r11 == 0) goto L_0x00a9
            V2.g r12 = r6.getContext()     // Catch:{ all -> 0x001b }
            d3.l r12 = t3.x.a(r11, r10, r12)     // Catch:{ all -> 0x001b }
            goto L_0x00a9
        L_0x00c5:
            java.lang.Object r10 = r6.v()
            java.lang.Object r11 = W2.b.c()
            if (r10 != r11) goto L_0x00d2
            kotlin.coroutines.jvm.internal.h.c(r14)
        L_0x00d2:
            return r10
        L_0x00d3:
            r6.J()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: q3.b.v0(q3.j, int, long, V2.d):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00b4, code lost:
        r13 = (q3.j) r13.g();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void w0(q3.j r13) {
        /*
            r12 = this;
            d3.l r0 = r12.f4049b
            r1 = 0
            r2 = 1
            java.lang.Object r3 = t3.C1062l.b(r1, r2, r1)
        L_0x0008:
            int r4 = q3.c.f4068b
            int r4 = r4 - r2
        L_0x000b:
            r5 = -1
            if (r5 >= r4) goto L_0x00b4
            long r6 = r13.f4463c
            int r8 = q3.c.f4068b
            long r8 = (long) r8
            long r6 = r6 * r8
            long r8 = (long) r4
            long r6 = r6 + r8
        L_0x0017:
            java.lang.Object r8 = r13.w(r4)
            t3.F r9 = q3.c.f4075i
            if (r8 == r9) goto L_0x00bc
            t3.F r9 = q3.c.f4070d
            if (r8 != r9) goto L_0x0049
            long r9 = r12.Q()
            int r11 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r11 < 0) goto L_0x00bc
            t3.F r9 = q3.c.z()
            boolean r8 = r13.r(r4, r8, r9)
            if (r8 == 0) goto L_0x0017
            if (r0 == 0) goto L_0x0041
            java.lang.Object r5 = r13.v(r4)
            t3.Q r1 = t3.x.c(r0, r5, r1)
        L_0x0041:
            r13.s(r4)
            r13.p()
            goto L_0x00b0
        L_0x0049:
            t3.F r9 = q3.c.f4071e
            if (r8 == r9) goto L_0x00a3
            if (r8 != 0) goto L_0x0052
            goto L_0x00a3
        L_0x0052:
            boolean r9 = r8 instanceof o3.W0
            if (r9 != 0) goto L_0x006f
            boolean r9 = r8 instanceof q3.w
            if (r9 == 0) goto L_0x005b
            goto L_0x006f
        L_0x005b:
            t3.F r9 = q3.c.f4073g
            if (r8 == r9) goto L_0x00bc
            t3.F r9 = q3.c.f4072f
            if (r8 != r9) goto L_0x0068
            goto L_0x00bc
        L_0x0068:
            t3.F r9 = q3.c.f4073g
            if (r8 == r9) goto L_0x0017
            goto L_0x00b0
        L_0x006f:
            long r9 = r12.Q()
            int r11 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r11 < 0) goto L_0x00bc
            boolean r9 = r8 instanceof q3.w
            if (r9 == 0) goto L_0x0081
            r9 = r8
            q3.w r9 = (q3.w) r9
            o3.W0 r9 = r9.f4109a
            goto L_0x0084
        L_0x0081:
            r9 = r8
            o3.W0 r9 = (o3.W0) r9
        L_0x0084:
            t3.F r10 = q3.c.z()
            boolean r8 = r13.r(r4, r8, r10)
            if (r8 == 0) goto L_0x0017
            if (r0 == 0) goto L_0x0098
            java.lang.Object r5 = r13.v(r4)
            t3.Q r1 = t3.x.c(r0, r5, r1)
        L_0x0098:
            java.lang.Object r3 = t3.C1062l.c(r3, r9)
            r13.s(r4)
            r13.p()
            goto L_0x00b0
        L_0x00a3:
            t3.F r9 = q3.c.z()
            boolean r8 = r13.r(r4, r8, r9)
            if (r8 == 0) goto L_0x0017
            r13.p()
        L_0x00b0:
            int r4 = r4 + -1
            goto L_0x000b
        L_0x00b4:
            t3.e r13 = r13.g()
            q3.j r13 = (q3.j) r13
            if (r13 != 0) goto L_0x0008
        L_0x00bc:
            if (r3 == 0) goto L_0x00e2
            boolean r13 = r3 instanceof java.util.ArrayList
            if (r13 != 0) goto L_0x00c8
            o3.W0 r3 = (o3.W0) r3
            r12.y0(r3)
            goto L_0x00e2
        L_0x00c8:
            java.lang.String r13 = "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }"
            kotlin.jvm.internal.m.c(r3, r13)
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            int r13 = r3.size()
            int r13 = r13 - r2
        L_0x00d4:
            if (r5 >= r13) goto L_0x00e2
            java.lang.Object r0 = r3.get(r13)
            o3.W0 r0 = (o3.W0) r0
            r12.y0(r0)
            int r13 = r13 + -1
            goto L_0x00d4
        L_0x00e2:
            if (r1 != 0) goto L_0x00e5
            return
        L_0x00e5:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: q3.b.w0(q3.j):void");
    }

    private final void x0(W0 w02) {
        z0(w02, true);
    }

    private final boolean y(long j4) {
        if (j4 < N() || j4 < Q() + ((long) this.f4048a)) {
            return true;
        }
        return false;
    }

    private final void y0(W0 w02) {
        z0(w02, false);
    }

    private final void z0(W0 w02, boolean z4) {
        Throwable th;
        if (w02 instanceof C0989m) {
            V2.d dVar = (V2.d) w02;
            m.a aVar = R2.m.f8216a;
            if (z4) {
                th = P();
            } else {
                th = R();
            }
            dVar.resumeWith(R2.m.a(n.a(th)));
        } else if (w02 instanceof t) {
            C0991n nVar = ((t) w02).f4108a;
            m.a aVar2 = R2.m.f8216a;
            nVar.resumeWith(R2.m.a(h.b(h.f4091b.a(O()))));
        } else if (w02 instanceof a) {
            ((a) w02).j();
        } else {
            throw new IllegalStateException(("Unexpected waiter: " + w02).toString());
        }
    }

    public Object B(Object obj) {
        j jVar;
        long j4;
        b bVar;
        W0 w02;
        if (C0(f4039d.get(this))) {
            return h.f4091b.b();
        }
        F j5 = c.f4076j;
        j jVar2 = (j) f4043h.get(this);
        while (true) {
            long andIncrement = f4039d.getAndIncrement(this);
            long j6 = 1152921504606846975L & andIncrement;
            boolean l4 = b0(andIncrement);
            int i4 = c.f4068b;
            long j7 = j6 / ((long) i4);
            int i5 = (int) (j6 % ((long) i4));
            if (jVar2.f4463c != j7) {
                jVar = M(j7, jVar2);
                if (jVar != null) {
                    bVar = this;
                    j4 = j6;
                } else if (l4) {
                    return h.f4091b.a(R());
                }
            } else {
                jVar = jVar2;
                j4 = j6;
                bVar = this;
            }
            Object obj2 = obj;
            int x4 = bVar.J0(jVar, i5, obj2, j4, j5, l4);
            j jVar3 = jVar;
            b bVar2 = bVar;
            jVar2 = jVar3;
            if (x4 == 0) {
                jVar2.b();
                return h.f4091b.c(s.f8222a);
            } else if (x4 == 1) {
                return h.f4091b.c(s.f8222a);
            } else {
                if (x4 != 2) {
                    if (x4 == 3) {
                        throw new IllegalStateException("unexpected");
                    } else if (x4 != 4) {
                        if (x4 == 5) {
                            jVar2.b();
                        }
                        obj = obj2;
                    } else {
                        if (j4 < Q()) {
                            jVar2.b();
                        }
                        return h.f4091b.a(R());
                    }
                } else if (l4) {
                    jVar2.p();
                    return h.f4091b.a(R());
                } else {
                    if (j5 instanceof W0) {
                        w02 = (W0) j5;
                    } else {
                        w02 = null;
                    }
                    if (w02 != null) {
                        r0(w02, jVar2, i5);
                    }
                    jVar2.p();
                    return h.f4091b.b();
                }
            }
        }
    }

    public boolean C() {
        return b0(f4039d.get(this));
    }

    /* access modifiers changed from: protected */
    public boolean E(Throwable th, boolean z4) {
        if (z4) {
            f0();
        }
        boolean a5 = androidx.concurrent.futures.a.a(f4046k, this, c.f4085s, th);
        if (z4) {
            g0();
        } else {
            h0();
        }
        H();
        j0();
        if (a5) {
            W();
        }
        return a5;
    }

    /* access modifiers changed from: protected */
    public final void I(long j4) {
        Q d5;
        j jVar = (j) f4044i.get(this);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f4040e;
            long j5 = atomicLongFieldUpdater.get(this);
            if (j4 >= Math.max(((long) this.f4048a) + j5, N())) {
                if (atomicLongFieldUpdater.compareAndSet(this, j5, 1 + j5)) {
                    int i4 = c.f4068b;
                    long j6 = j5 / ((long) i4);
                    int i5 = (int) (j5 % ((long) i4));
                    if (jVar.f4463c != j6) {
                        j L4 = L(j6, jVar);
                        if (L4 == null) {
                            continue;
                        } else {
                            jVar = L4;
                        }
                    }
                    long j7 = j5;
                    j jVar2 = jVar;
                    Object H02 = H0(jVar2, i5, j7, (Object) null);
                    if (H02 != c.f4081o) {
                        jVar2.b();
                        l lVar = this.f4049b;
                        if (!(lVar == null || (d5 = x.d(lVar, H02, (Q) null, 2, (Object) null)) == null)) {
                            throw d5;
                        }
                    } else if (j7 < S()) {
                        jVar2.b();
                    }
                    jVar = jVar2;
                }
            } else {
                return;
            }
        }
    }

    public final void N0(long j4) {
        b bVar;
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        boolean z4;
        b bVar2 = this;
        if (!bVar2.d0()) {
            while (bVar2.N() <= j4) {
                bVar2 = this;
            }
            int g4 = c.f4069c;
            int i4 = 0;
            while (i4 < g4) {
                long N4 = bVar2.N();
                if (N4 != (4611686018427387903L & f4042g.get(bVar2)) || N4 != bVar2.N()) {
                    i4++;
                } else {
                    return;
                }
            }
            AtomicLongFieldUpdater atomicLongFieldUpdater2 = f4042g;
            while (true) {
                long j5 = atomicLongFieldUpdater2.get(bVar);
                if (atomicLongFieldUpdater2.compareAndSet(bVar, j5, c.v(j5 & 4611686018427387903L, true))) {
                    break;
                }
                bVar2 = this;
            }
            while (true) {
                long N5 = bVar.N();
                atomicLongFieldUpdater = f4042g;
                long j6 = N5;
                long j7 = atomicLongFieldUpdater.get(bVar);
                long j8 = j7 & 4611686018427387903L;
                if ((4611686018427387904L & j7) != 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (j6 == j8 && j6 == bVar.N()) {
                    break;
                } else if (!z4) {
                    bVar = this;
                    atomicLongFieldUpdater.compareAndSet(bVar, j7, c.v(j8, true));
                } else {
                    bVar = this;
                }
            }
            while (true) {
                long j9 = atomicLongFieldUpdater.get(bVar);
                if (!atomicLongFieldUpdater.compareAndSet(bVar, j9, c.v(j9 & 4611686018427387903L, false))) {
                    bVar = this;
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final Throwable O() {
        return (Throwable) f4046k.get(this);
    }

    public final long Q() {
        return f4040e.get(this);
    }

    /* access modifiers changed from: protected */
    public final Throwable R() {
        Throwable O4 = O();
        if (O4 == null) {
            return new o("Channel was closed");
        }
        return O4;
    }

    public final long S() {
        return f4039d.get(this) & 1152921504606846975L;
    }

    public final boolean T() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4044i;
            j jVar = (j) atomicReferenceFieldUpdater.get(this);
            long Q4 = Q();
            if (S() <= Q4) {
                return false;
            }
            int i4 = c.f4068b;
            long j4 = Q4 / ((long) i4);
            if (jVar.f4463c == j4 || (jVar = L(j4, jVar)) != null) {
                jVar.b();
                if (X(jVar, (int) (Q4 % ((long) i4)), Q4)) {
                    return true;
                }
                f4040e.compareAndSet(this, Q4, Q4 + 1);
            } else if (((j) atomicReferenceFieldUpdater.get(this)).f4463c < j4) {
                return false;
            }
        }
    }

    public boolean Z() {
        return a0(f4039d.get(this));
    }

    public final void a(CancellationException cancellationException) {
        z(cancellationException);
    }

    /* access modifiers changed from: protected */
    public boolean c0() {
        return false;
    }

    public void f(l lVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4047l;
        if (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, (Object) null, lVar)) {
            do {
                Object obj = atomicReferenceFieldUpdater.get(this);
                if (obj != c.f4083q) {
                    if (obj == c.f4084r) {
                        throw new IllegalStateException("Another handler was already registered and successfully invoked");
                    }
                    throw new IllegalStateException(("Another handler is already registered: " + obj).toString());
                }
            } while (!androidx.concurrent.futures.a.a(f4047l, this, c.f4083q, c.f4084r));
            lVar.invoke(O());
        }
    }

    public Object h() {
        j jVar;
        W0 w02;
        long j4 = f4040e.get(this);
        long j5 = f4039d.get(this);
        if (a0(j5)) {
            return h.f4091b.a(O());
        }
        if (j4 >= (j5 & 1152921504606846975L)) {
            return h.f4091b.b();
        }
        F i4 = c.f4077k;
        j jVar2 = (j) f4044i.get(this);
        while (!Z()) {
            long andIncrement = f4040e.getAndIncrement(this);
            int i5 = c.f4068b;
            long j6 = andIncrement / ((long) i5);
            int i6 = (int) (andIncrement % ((long) i5));
            if (jVar2.f4463c != j6) {
                jVar = L(j6, jVar2);
                if (jVar == null) {
                    continue;
                }
            } else {
                jVar = jVar2;
            }
            int i7 = i6;
            Object w4 = H0(jVar, i7, andIncrement, i4);
            if (w4 == c.f4079m) {
                if (i4 instanceof W0) {
                    w02 = (W0) i4;
                } else {
                    w02 = null;
                }
                if (w02 != null) {
                    q0(w02, jVar, i7);
                }
                N0(andIncrement);
                jVar.p();
                return h.f4091b.b();
            } else if (w4 == c.f4081o) {
                if (andIncrement < S()) {
                    jVar.b();
                }
                jVar2 = jVar;
            } else if (w4 != c.f4080n) {
                jVar.b();
                return h.f4091b.c(w4);
            } else {
                throw new IllegalStateException("unexpected");
            }
        }
        return h.f4091b.a(O());
    }

    public f iterator() {
        return new a();
    }

    public Object j(V2.d dVar) {
        return t0(this, dVar);
    }

    public Object m(V2.d dVar) {
        return s0(this, dVar);
    }

    public boolean s(Throwable th) {
        return E(th, false);
    }

    public Object t(Object obj, V2.d dVar) {
        return A0(this, obj, dVar);
    }

    /* JADX WARNING: type inference failed for: r2v10, types: [t3.e] */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01c2, code lost:
        r3 = r3.e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01cb, code lost:
        if (r3 != null) goto L_0x01ec;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r17 = this;
            r0 = r17
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = f4039d
            long r2 = r2.get(r0)
            r4 = 60
            long r2 = r2 >> r4
            int r3 = (int) r2
            r2 = 3
            r4 = 2
            if (r3 == r4) goto L_0x001e
            if (r3 == r2) goto L_0x0018
            goto L_0x0023
        L_0x0018:
            java.lang.String r3 = "cancelled,"
            r1.append(r3)
            goto L_0x0023
        L_0x001e:
            java.lang.String r3 = "closed,"
            r1.append(r3)
        L_0x0023:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "capacity="
            r3.append(r5)
            int r5 = r0.f4048a
            r3.append(r5)
            r5 = 44
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            r1.append(r3)
            java.lang.String r3 = "data=["
            r1.append(r3)
            q3.j[] r2 = new q3.j[r2]
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = f4044i
            java.lang.Object r3 = r3.get(r0)
            r6 = 0
            r2[r6] = r3
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = f4043h
            java.lang.Object r3 = r3.get(r0)
            r7 = 1
            r2[r7] = r3
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = f4045j
            java.lang.Object r3 = r3.get(r0)
            r2[r4] = r3
            java.util.List r2 = S2.C1601o.k(r2)
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Iterator r2 = r2.iterator()
        L_0x006e:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0085
            java.lang.Object r4 = r2.next()
            r8 = r4
            q3.j r8 = (q3.j) r8
            q3.j r9 = q3.c.f4067a
            if (r8 == r9) goto L_0x006e
            r3.add(r4)
            goto L_0x006e
        L_0x0085:
            java.util.Iterator r2 = r3.iterator()
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x01f0
            java.lang.Object r3 = r2.next()
            boolean r4 = r2.hasNext()
            if (r4 != 0) goto L_0x009a
            goto L_0x00b4
        L_0x009a:
            r4 = r3
            q3.j r4 = (q3.j) r4
            long r8 = r4.f4463c
        L_0x009f:
            java.lang.Object r4 = r2.next()
            r10 = r4
            q3.j r10 = (q3.j) r10
            long r10 = r10.f4463c
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 <= 0) goto L_0x00ae
            r3 = r4
            r8 = r10
        L_0x00ae:
            boolean r4 = r2.hasNext()
            if (r4 != 0) goto L_0x009f
        L_0x00b4:
            q3.j r3 = (q3.j) r3
            long r10 = r0.Q()
            long r12 = r0.S()
        L_0x00be:
            int r2 = q3.c.f4068b
            r4 = 0
        L_0x00c1:
            if (r4 >= r2) goto L_0x01c2
            long r8 = r3.f4463c
            int r14 = q3.c.f4068b
            long r14 = (long) r14
            long r8 = r8 * r14
            long r14 = (long) r4
            long r8 = r8 + r14
            int r14 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r14 < 0) goto L_0x00d9
            int r15 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r15 >= 0) goto L_0x00d5
            goto L_0x00d9
        L_0x00d5:
            r16 = 1
            goto L_0x01cd
        L_0x00d9:
            java.lang.Object r15 = r3.w(r4)
            java.lang.Object r6 = r3.v(r4)
            r16 = 1
            boolean r7 = r15 instanceof o3.C0989m
            if (r7 == 0) goto L_0x00fd
            int r7 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r7 >= 0) goto L_0x00f1
            if (r14 < 0) goto L_0x00f1
            java.lang.String r7 = "receive"
            goto L_0x0188
        L_0x00f1:
            if (r14 >= 0) goto L_0x00f9
            if (r7 < 0) goto L_0x00f9
            java.lang.String r7 = "send"
            goto L_0x0188
        L_0x00f9:
            java.lang.String r7 = "cont"
            goto L_0x0188
        L_0x00fd:
            boolean r7 = r15 instanceof q3.t
            if (r7 == 0) goto L_0x0105
            java.lang.String r7 = "receiveCatching"
            goto L_0x0188
        L_0x0105:
            boolean r7 = r15 instanceof q3.w
            if (r7 == 0) goto L_0x0121
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "EB("
            r7.append(r8)
            r7.append(r15)
            r8 = 41
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            goto L_0x0188
        L_0x0121:
            t3.F r7 = q3.c.f4072f
            boolean r7 = kotlin.jvm.internal.m.a(r15, r7)
            if (r7 == 0) goto L_0x012d
            r7 = 1
            goto L_0x0135
        L_0x012d:
            t3.F r7 = q3.c.f4073g
            boolean r7 = kotlin.jvm.internal.m.a(r15, r7)
        L_0x0135:
            if (r7 == 0) goto L_0x013a
            java.lang.String r7 = "resuming_sender"
            goto L_0x0188
        L_0x013a:
            if (r15 != 0) goto L_0x013e
            r7 = 1
            goto L_0x0146
        L_0x013e:
            t3.F r7 = q3.c.f4071e
            boolean r7 = kotlin.jvm.internal.m.a(r15, r7)
        L_0x0146:
            if (r7 == 0) goto L_0x014a
            r7 = 1
            goto L_0x0152
        L_0x014a:
            t3.F r7 = q3.c.f4075i
            boolean r7 = kotlin.jvm.internal.m.a(r15, r7)
        L_0x0152:
            if (r7 == 0) goto L_0x0156
            r7 = 1
            goto L_0x015e
        L_0x0156:
            t3.F r7 = q3.c.f4074h
            boolean r7 = kotlin.jvm.internal.m.a(r15, r7)
        L_0x015e:
            if (r7 == 0) goto L_0x0162
            r7 = 1
            goto L_0x016a
        L_0x0162:
            t3.F r7 = q3.c.f4077k
            boolean r7 = kotlin.jvm.internal.m.a(r15, r7)
        L_0x016a:
            if (r7 == 0) goto L_0x016e
            r7 = 1
            goto L_0x0176
        L_0x016e:
            t3.F r7 = q3.c.f4076j
            boolean r7 = kotlin.jvm.internal.m.a(r15, r7)
        L_0x0176:
            if (r7 == 0) goto L_0x017a
            r7 = 1
            goto L_0x0182
        L_0x017a:
            t3.F r7 = q3.c.z()
            boolean r7 = kotlin.jvm.internal.m.a(r15, r7)
        L_0x0182:
            if (r7 != 0) goto L_0x01bc
            java.lang.String r7 = r15.toString()
        L_0x0188:
            if (r6 == 0) goto L_0x01aa
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r9 = 40
            r8.append(r9)
            r8.append(r7)
            r8.append(r5)
            r8.append(r6)
            java.lang.String r6 = "),"
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            r1.append(r6)
            goto L_0x01bc
        L_0x01aa:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r7)
            r6.append(r5)
            java.lang.String r6 = r6.toString()
            r1.append(r6)
        L_0x01bc:
            int r4 = r4 + 1
            r6 = 0
            r7 = 1
            goto L_0x00c1
        L_0x01c2:
            r16 = 1
            t3.e r2 = r3.e()
            r3 = r2
            q3.j r3 = (q3.j) r3
            if (r3 != 0) goto L_0x01ec
        L_0x01cd:
            char r2 = m3.m.x0(r1)
            if (r2 != r5) goto L_0x01e2
            int r2 = r1.length()
            int r2 = r2 + -1
            java.lang.StringBuilder r2 = r1.deleteCharAt(r2)
            java.lang.String r3 = "this.deleteCharAt(index)"
            kotlin.jvm.internal.m.d(r2, r3)
        L_0x01e2:
            java.lang.String r2 = "]"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            return r1
        L_0x01ec:
            r6 = 0
            r7 = 1
            goto L_0x00be
        L_0x01f0:
            java.util.NoSuchElementException r1 = new java.util.NoSuchElementException
            r1.<init>()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: q3.b.toString():java.lang.String");
    }

    public boolean z(Throwable th) {
        if (th == null) {
            th = new CancellationException("Channel was cancelled");
        }
        return E(th, true);
    }

    /* access modifiers changed from: protected */
    public void j0() {
    }

    /* access modifiers changed from: protected */
    public void o0() {
    }

    /* access modifiers changed from: protected */
    public void p0() {
    }
}
