package r3;

import V2.g;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.jvm.internal.d;
import s3.b;
import s3.p;
import s3.s;
import t3.F;

final class J extends b implements t, C1035e, p {

    /* renamed from: f  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f4168f = AtomicReferenceFieldUpdater.newUpdater(J.class, Object.class, "_state");
    private volatile Object _state;

    /* renamed from: e  reason: collision with root package name */
    private int f4169e;

    static final class a extends d {

        /* renamed from: a  reason: collision with root package name */
        Object f4170a;

        /* renamed from: b  reason: collision with root package name */
        Object f4171b;

        /* renamed from: c  reason: collision with root package name */
        Object f4172c;

        /* renamed from: d  reason: collision with root package name */
        Object f4173d;

        /* renamed from: e  reason: collision with root package name */
        Object f4174e;

        /* renamed from: f  reason: collision with root package name */
        /* synthetic */ Object f4175f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ J f4176g;

        /* renamed from: h  reason: collision with root package name */
        int f4177h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(J j4, V2.d dVar) {
            super(dVar);
            this.f4176g = j4;
        }

        public final Object invokeSuspend(Object obj) {
            this.f4175f = obj;
            this.f4177h |= Integer.MIN_VALUE;
            return this.f4176g.collect((C1036f) null, this);
        }
    }

    public J(Object obj) {
        this._state = obj;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0030, code lost:
        r8 = (r3.L[]) r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0032, code lost:
        if (r8 == null) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0034, code lost:
        r1 = r8.length;
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0036, code lost:
        if (r2 >= r1) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0038, code lost:
        r4 = r8[r2];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003a, code lost:
        if (r4 == null) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x003c, code lost:
        r4.g();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x003f, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0041, code lost:
        monitor-enter(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r8 = r6.f4169e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0044, code lost:
        if (r8 != r7) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0046, code lost:
        r6.f4169e = r7 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0049, code lost:
        monitor-exit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x004a, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        r7 = m();
        r1 = R2.s.f8222a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0053, code lost:
        monitor-exit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0054, code lost:
        r5 = r8;
        r8 = r7;
        r7 = r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean p(java.lang.Object r7, java.lang.Object r8) {
        /*
            r6 = this;
            r0 = 1
            monitor-enter(r6)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = f4168f     // Catch:{ all -> 0x0013 }
            java.lang.Object r2 = r1.get(r6)     // Catch:{ all -> 0x0013 }
            r3 = 0
            if (r7 == 0) goto L_0x0015
            boolean r7 = kotlin.jvm.internal.m.a(r2, r7)     // Catch:{ all -> 0x0013 }
            if (r7 != 0) goto L_0x0015
            monitor-exit(r6)
            return r3
        L_0x0013:
            r7 = move-exception
            goto L_0x0060
        L_0x0015:
            boolean r7 = kotlin.jvm.internal.m.a(r2, r8)     // Catch:{ all -> 0x0013 }
            if (r7 == 0) goto L_0x001d
            monitor-exit(r6)
            return r0
        L_0x001d:
            r1.set(r6, r8)     // Catch:{ all -> 0x0013 }
            int r7 = r6.f4169e     // Catch:{ all -> 0x0013 }
            r8 = r7 & 1
            if (r8 != 0) goto L_0x005a
            int r7 = r7 + r0
            r6.f4169e = r7     // Catch:{ all -> 0x0013 }
            s3.d[] r8 = r6.m()     // Catch:{ all -> 0x0013 }
            R2.s r1 = R2.s.f8222a     // Catch:{ all -> 0x0013 }
            monitor-exit(r6)
        L_0x0030:
            r3.L[] r8 = (r3.L[]) r8
            if (r8 == 0) goto L_0x0041
            int r1 = r8.length
            r2 = 0
        L_0x0036:
            if (r2 >= r1) goto L_0x0041
            r4 = r8[r2]
            if (r4 == 0) goto L_0x003f
            r4.g()
        L_0x003f:
            int r2 = r2 + r0
            goto L_0x0036
        L_0x0041:
            monitor-enter(r6)
            int r8 = r6.f4169e     // Catch:{ all -> 0x004b }
            if (r8 != r7) goto L_0x004d
            int r7 = r7 + r0
            r6.f4169e = r7     // Catch:{ all -> 0x004b }
            monitor-exit(r6)
            return r0
        L_0x004b:
            r7 = move-exception
            goto L_0x0058
        L_0x004d:
            s3.d[] r7 = r6.m()     // Catch:{ all -> 0x004b }
            R2.s r1 = R2.s.f8222a     // Catch:{ all -> 0x004b }
            monitor-exit(r6)
            r5 = r8
            r8 = r7
            r7 = r5
            goto L_0x0030
        L_0x0058:
            monitor-exit(r6)
            throw r7
        L_0x005a:
            int r7 = r7 + 2
            r6.f4169e = r7     // Catch:{ all -> 0x0013 }
            monitor-exit(r6)
            return r0
        L_0x0060:
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: r3.J.p(java.lang.Object, java.lang.Object):boolean");
    }

    public boolean a(Object obj, Object obj2) {
        if (obj == null) {
            obj = s.f4399a;
        }
        if (obj2 == null) {
            obj2 = s.f4399a;
        }
        return p(obj, obj2);
    }

    public C1035e b(g gVar, int i4, q3.a aVar) {
        return K.d(this, gVar, i4, aVar);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: r3.L} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: r3.J} */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00d3, code lost:
        if (r6.e(r0) == r1) goto L_0x00d5;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0097 A[Catch:{ all -> 0x0042 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a6 A[Catch:{ all -> 0x0042 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a8 A[Catch:{ all -> 0x0042 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00bb A[Catch:{ all -> 0x0042 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00bc A[Catch:{ all -> 0x0042 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c3 A[Catch:{ all -> 0x0042 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object collect(r3.C1036f r11, V2.d r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof r3.J.a
            if (r0 == 0) goto L_0x0013
            r0 = r12
            r3.J$a r0 = (r3.J.a) r0
            int r1 = r0.f4177h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f4177h = r1
            goto L_0x0018
        L_0x0013:
            r3.J$a r0 = new r3.J$a
            r0.<init>(r10, r12)
        L_0x0018:
            java.lang.Object r12 = r0.f4175f
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.f4177h
            r3 = 0
            r4 = 3
            r5 = 2
            if (r2 == 0) goto L_0x0075
            r11 = 1
            if (r2 == r11) goto L_0x0063
            if (r2 == r5) goto L_0x004d
            if (r2 != r4) goto L_0x0045
            java.lang.Object r11 = r0.f4174e
            java.lang.Object r2 = r0.f4173d
            o3.s0 r2 = (o3.C1001s0) r2
            java.lang.Object r6 = r0.f4172c
            r3.L r6 = (r3.L) r6
            java.lang.Object r7 = r0.f4171b
            r3.f r7 = (r3.C1036f) r7
            java.lang.Object r8 = r0.f4170a
            r3.J r8 = (r3.J) r8
            R2.n.b(r12)     // Catch:{ all -> 0x0042 }
            goto L_0x008f
        L_0x0042:
            r11 = move-exception
            goto L_0x00d6
        L_0x0045:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x004d:
            java.lang.Object r11 = r0.f4174e
            java.lang.Object r2 = r0.f4173d
            o3.s0 r2 = (o3.C1001s0) r2
            java.lang.Object r6 = r0.f4172c
            r3.L r6 = (r3.L) r6
            java.lang.Object r7 = r0.f4171b
            r3.f r7 = (r3.C1036f) r7
            java.lang.Object r8 = r0.f4170a
            r3.J r8 = (r3.J) r8
            R2.n.b(r12)     // Catch:{ all -> 0x0042 }
            goto L_0x00bd
        L_0x0063:
            java.lang.Object r11 = r0.f4172c
            r6 = r11
            r3.L r6 = (r3.L) r6
            java.lang.Object r11 = r0.f4171b
            r3.f r11 = (r3.C1036f) r11
            java.lang.Object r2 = r0.f4170a
            r8 = r2
            r3.J r8 = (r3.J) r8
            R2.n.b(r12)     // Catch:{ all -> 0x0042 }
            goto L_0x0080
        L_0x0075:
            R2.n.b(r12)
            s3.d r12 = r10.h()
            r3.L r12 = (r3.L) r12
            r8 = r10
            r6 = r12
        L_0x0080:
            V2.g r12 = r0.getContext()     // Catch:{ all -> 0x0042 }
            o3.s0$b r2 = o3.C1001s0.f3726k0     // Catch:{ all -> 0x0042 }
            V2.g$b r12 = r12.get(r2)     // Catch:{ all -> 0x0042 }
            o3.s0 r12 = (o3.C1001s0) r12     // Catch:{ all -> 0x0042 }
            r7 = r11
            r2 = r12
            r11 = r3
        L_0x008f:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r12 = f4168f     // Catch:{ all -> 0x0042 }
            java.lang.Object r12 = r12.get(r8)     // Catch:{ all -> 0x0042 }
            if (r2 == 0) goto L_0x009a
            o3.C1009w0.g(r2)     // Catch:{ all -> 0x0042 }
        L_0x009a:
            if (r11 == 0) goto L_0x00a2
            boolean r9 = kotlin.jvm.internal.m.a(r11, r12)     // Catch:{ all -> 0x0042 }
            if (r9 != 0) goto L_0x00bd
        L_0x00a2:
            t3.F r11 = s3.s.f4399a     // Catch:{ all -> 0x0042 }
            if (r12 != r11) goto L_0x00a8
            r11 = r3
            goto L_0x00a9
        L_0x00a8:
            r11 = r12
        L_0x00a9:
            r0.f4170a = r8     // Catch:{ all -> 0x0042 }
            r0.f4171b = r7     // Catch:{ all -> 0x0042 }
            r0.f4172c = r6     // Catch:{ all -> 0x0042 }
            r0.f4173d = r2     // Catch:{ all -> 0x0042 }
            r0.f4174e = r12     // Catch:{ all -> 0x0042 }
            r0.f4177h = r5     // Catch:{ all -> 0x0042 }
            java.lang.Object r11 = r7.emit(r11, r0)     // Catch:{ all -> 0x0042 }
            if (r11 != r1) goto L_0x00bc
            goto L_0x00d5
        L_0x00bc:
            r11 = r12
        L_0x00bd:
            boolean r12 = r6.h()     // Catch:{ all -> 0x0042 }
            if (r12 != 0) goto L_0x008f
            r0.f4170a = r8     // Catch:{ all -> 0x0042 }
            r0.f4171b = r7     // Catch:{ all -> 0x0042 }
            r0.f4172c = r6     // Catch:{ all -> 0x0042 }
            r0.f4173d = r2     // Catch:{ all -> 0x0042 }
            r0.f4174e = r11     // Catch:{ all -> 0x0042 }
            r0.f4177h = r4     // Catch:{ all -> 0x0042 }
            java.lang.Object r12 = r6.e(r0)     // Catch:{ all -> 0x0042 }
            if (r12 != r1) goto L_0x008f
        L_0x00d5:
            return r1
        L_0x00d6:
            r8.k(r6)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: r3.J.collect(r3.f, V2.d):java.lang.Object");
    }

    public void d() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    public Object emit(Object obj, V2.d dVar) {
        setValue(obj);
        return R2.s.f8222a;
    }

    public boolean f(Object obj) {
        setValue(obj);
        return true;
    }

    public Object getValue() {
        F f4 = s.f4399a;
        Object obj = f4168f.get(this);
        if (obj == f4) {
            return null;
        }
        return obj;
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public L i() {
        return new L();
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public L[] j(int i4) {
        return new L[i4];
    }

    public void setValue(Object obj) {
        if (obj == null) {
            obj = s.f4399a;
        }
        p((Object) null, obj);
    }
}
