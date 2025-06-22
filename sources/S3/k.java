package s3;

import R2.n;
import R2.s;
import W2.b;
import d3.p;
import d3.q;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.coroutines.jvm.internal.l;
import o3.J;
import q3.d;
import q3.v;
import r3.C1035e;
import r3.C1036f;

public abstract class k {

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f4374a;

        /* renamed from: b  reason: collision with root package name */
        Object f4375b;

        /* renamed from: c  reason: collision with root package name */
        int f4376c;

        /* renamed from: d  reason: collision with root package name */
        int f4377d;

        /* renamed from: e  reason: collision with root package name */
        int f4378e;

        /* renamed from: f  reason: collision with root package name */
        private /* synthetic */ Object f4379f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ C1035e[] f4380g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ d3.a f4381h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ q f4382i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ C1036f f4383j;

        /* renamed from: s3.k$a$a  reason: collision with other inner class name */
        static final class C0047a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f4384a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1035e[] f4385b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ int f4386c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ AtomicInteger f4387d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ d f4388e;

            /* renamed from: s3.k$a$a$a  reason: collision with other inner class name */
            static final class C0048a implements C1036f {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ d f4389a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ int f4390b;

                /* renamed from: s3.k$a$a$a$a  reason: collision with other inner class name */
                static final class C0049a extends kotlin.coroutines.jvm.internal.d {

                    /* renamed from: a  reason: collision with root package name */
                    /* synthetic */ Object f4391a;

                    /* renamed from: b  reason: collision with root package name */
                    final /* synthetic */ C0048a f4392b;

                    /* renamed from: c  reason: collision with root package name */
                    int f4393c;

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    C0049a(C0048a aVar, V2.d dVar) {
                        super(dVar);
                        this.f4392b = aVar;
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.f4391a = obj;
                        this.f4393c |= Integer.MIN_VALUE;
                        return this.f4392b.emit((Object) null, this);
                    }
                }

                C0048a(d dVar, int i4) {
                    this.f4389a = dVar;
                    this.f4390b = i4;
                }

                /* JADX WARNING: Code restructure failed: missing block: B:15:0x004a, code lost:
                    if (r8.t(r2, r0) == r1) goto L_0x0055;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:17:0x0053, code lost:
                    if (o3.Y0.a(r0) != r1) goto L_0x0056;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:18:0x0055, code lost:
                    return r1;
                 */
                /* JADX WARNING: Removed duplicated region for block: B:14:0x0038  */
                /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final java.lang.Object emit(java.lang.Object r7, V2.d r8) {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof s3.k.a.C0047a.C0048a.C0049a
                        if (r0 == 0) goto L_0x0013
                        r0 = r8
                        s3.k$a$a$a$a r0 = (s3.k.a.C0047a.C0048a.C0049a) r0
                        int r1 = r0.f4393c
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L_0x0013
                        int r1 = r1 - r2
                        r0.f4393c = r1
                        goto L_0x0018
                    L_0x0013:
                        s3.k$a$a$a$a r0 = new s3.k$a$a$a$a
                        r0.<init>(r6, r8)
                    L_0x0018:
                        java.lang.Object r8 = r0.f4391a
                        java.lang.Object r1 = W2.b.c()
                        int r2 = r0.f4393c
                        r3 = 2
                        r4 = 1
                        if (r2 == 0) goto L_0x0038
                        if (r2 == r4) goto L_0x0034
                        if (r2 != r3) goto L_0x002c
                        R2.n.b(r8)
                        goto L_0x0056
                    L_0x002c:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L_0x0034:
                        R2.n.b(r8)
                        goto L_0x004d
                    L_0x0038:
                        R2.n.b(r8)
                        q3.d r8 = r6.f4389a
                        S2.D r2 = new S2.D
                        int r5 = r6.f4390b
                        r2.<init>(r5, r7)
                        r0.f4393c = r4
                        java.lang.Object r7 = r8.t(r2, r0)
                        if (r7 != r1) goto L_0x004d
                        goto L_0x0055
                    L_0x004d:
                        r0.f4393c = r3
                        java.lang.Object r7 = o3.Y0.a(r0)
                        if (r7 != r1) goto L_0x0056
                    L_0x0055:
                        return r1
                    L_0x0056:
                        R2.s r7 = R2.s.f8222a
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: s3.k.a.C0047a.C0048a.emit(java.lang.Object, V2.d):java.lang.Object");
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0047a(C1035e[] eVarArr, int i4, AtomicInteger atomicInteger, d dVar, V2.d dVar2) {
                super(2, dVar2);
                this.f4385b = eVarArr;
                this.f4386c = i4;
                this.f4387d = atomicInteger;
                this.f4388e = dVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new C0047a(this.f4385b, this.f4386c, this.f4387d, this.f4388e, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                Object c5 = b.c();
                int i4 = this.f4384a;
                if (i4 == 0) {
                    n.b(obj);
                    C1035e[] eVarArr = this.f4385b;
                    int i5 = this.f4386c;
                    C1035e eVar = eVarArr[i5];
                    C0048a aVar = new C0048a(this.f4388e, i5);
                    this.f4384a = 1;
                    if (eVar.collect(aVar, this) == c5) {
                        return c5;
                    }
                } else if (i4 == 1) {
                    try {
                        n.b(obj);
                    } catch (Throwable th) {
                        if (this.f4387d.decrementAndGet() == 0) {
                            v.a.a(this.f4388e, (Throwable) null, 1, (Object) null);
                        }
                        throw th;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (this.f4387d.decrementAndGet() == 0) {
                    v.a.a(this.f4388e, (Throwable) null, 1, (Object) null);
                }
                return s.f8222a;
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((C0047a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(C1035e[] eVarArr, d3.a aVar, q qVar, C1036f fVar, V2.d dVar) {
            super(2, dVar);
            this.f4380g = eVarArr;
            this.f4381h = aVar;
            this.f4382i = qVar;
            this.f4383j = fVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            a aVar = new a(this.f4380g, this.f4381h, this.f4382i, this.f4383j, dVar);
            aVar.f4379f = obj;
            return aVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0105, code lost:
            if (r10.invoke(r11, r9, r0) == r1) goto L_0x0127;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0125, code lost:
            if (r11.invoke(r12, r10, r0) == r1) goto L_0x0127;
         */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x00c0 A[LOOP:1: B:24:0x00c0->B:30:0x00e3, LOOP_START, PHI: r6 r10 
          PHI: (r6v3 int) = (r6v2 int), (r6v4 int) binds: [B:21:0x00bb, B:30:0x00e3] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r10v3 S2.D) = (r10v2 S2.D), (r10v16 S2.D) binds: [B:21:0x00bb, B:30:0x00e3] A[DONT_GENERATE, DONT_INLINE]] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r22) {
            /*
                r21 = this;
                r0 = r21
                java.lang.Object r1 = W2.b.c()
                int r2 = r0.f4378e
                r3 = 3
                r4 = 2
                r5 = 1
                if (r2 == 0) goto L_0x004e
                if (r2 == r5) goto L_0x0031
                if (r2 == r4) goto L_0x001c
                if (r2 != r3) goto L_0x0014
                goto L_0x001c
            L_0x0014:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L_0x001c:
                int r2 = r0.f4377d
                int r6 = r0.f4376c
                java.lang.Object r7 = r0.f4375b
                byte[] r7 = (byte[]) r7
                java.lang.Object r8 = r0.f4374a
                q3.d r8 = (q3.d) r8
                java.lang.Object r9 = r0.f4379f
                java.lang.Object[] r9 = (java.lang.Object[]) r9
                R2.n.b(r22)
                goto L_0x0128
            L_0x0031:
                int r2 = r0.f4377d
                int r6 = r0.f4376c
                java.lang.Object r7 = r0.f4375b
                byte[] r7 = (byte[]) r7
                java.lang.Object r8 = r0.f4374a
                q3.d r8 = (q3.d) r8
                java.lang.Object r9 = r0.f4379f
                java.lang.Object[] r9 = (java.lang.Object[]) r9
                R2.n.b(r22)
                r10 = r22
                q3.h r10 = (q3.h) r10
                java.lang.Object r10 = r10.k()
                goto L_0x00b5
            L_0x004e:
                R2.n.b(r22)
                java.lang.Object r2 = r0.f4379f
                r6 = r2
                o3.J r6 = (o3.J) r6
                r3.e[] r2 = r0.f4380g
                int r2 = r2.length
                if (r2 != 0) goto L_0x005e
                R2.s r1 = R2.s.f8222a
                return r1
            L_0x005e:
                java.lang.Object[] r7 = new java.lang.Object[r2]
                t3.F r8 = s3.s.f4400b
                r11 = 6
                r12 = 0
                r9 = 0
                r10 = 0
                S2.C1594h.k(r7, r8, r9, r10, r11, r12)
                r12 = r7
                r7 = 6
                r8 = 0
                q3.d r17 = q3.g.b(r2, r8, r8, r7, r8)
                java.util.concurrent.atomic.AtomicInteger r7 = new java.util.concurrent.atomic.AtomicInteger
                r7.<init>(r2)
                r19 = 0
                r15 = 0
            L_0x0078:
                if (r15 >= r2) goto L_0x0092
                s3.k$a$a r9 = new s3.k$a$a
                r3.e[] r14 = r0.f4380g
                r18 = 0
                r16 = r7
                r13 = r9
                r13.<init>(r14, r15, r16, r17, r18)
                r10 = 3
                r11 = 0
                r7 = 0
                r8 = 0
                o3.C1001s0 unused = o3.C0981i.d(r6, r7, r8, r9, r10, r11)
                int r15 = r15 + 1
                r7 = r16
                goto L_0x0078
            L_0x0092:
                byte[] r6 = new byte[r2]
                r7 = r12
                r8 = r17
            L_0x0097:
                int r9 = r19 + 1
                byte r9 = (byte) r9
                r0.f4379f = r7
                r0.f4374a = r8
                r0.f4375b = r6
                r0.f4376c = r2
                r0.f4377d = r9
                r0.f4378e = r5
                java.lang.Object r10 = r8.j(r0)
                if (r10 != r1) goto L_0x00ae
                goto L_0x0127
            L_0x00ae:
                r20 = r6
                r6 = r2
                r2 = r9
                r9 = r7
                r7 = r20
            L_0x00b5:
                java.lang.Object r10 = q3.h.f(r10)
                S2.D r10 = (S2.D) r10
                if (r10 != 0) goto L_0x00c0
                R2.s r1 = R2.s.f8222a
                return r1
            L_0x00c0:
                int r11 = r10.a()
                r12 = r9[r11]
                java.lang.Object r10 = r10.b()
                r9[r11] = r10
                t3.F r10 = s3.s.f4400b
                if (r12 != r10) goto L_0x00d2
                int r6 = r6 + -1
            L_0x00d2:
                byte r10 = r7[r11]
                if (r10 == r2) goto L_0x00e5
                byte r10 = (byte) r2
                r7[r11] = r10
                java.lang.Object r10 = r8.h()
                java.lang.Object r10 = q3.h.f(r10)
                S2.D r10 = (S2.D) r10
                if (r10 != 0) goto L_0x00c0
            L_0x00e5:
                if (r6 != 0) goto L_0x0128
                d3.a r10 = r0.f4381h
                java.lang.Object r10 = r10.invoke()
                java.lang.Object[] r10 = (java.lang.Object[]) r10
                if (r10 != 0) goto L_0x0108
                d3.q r10 = r0.f4382i
                r3.f r11 = r0.f4383j
                r0.f4379f = r9
                r0.f4374a = r8
                r0.f4375b = r7
                r0.f4376c = r6
                r0.f4377d = r2
                r0.f4378e = r4
                java.lang.Object r10 = r10.invoke(r11, r9, r0)
                if (r10 != r1) goto L_0x0128
                goto L_0x0127
            L_0x0108:
                r14 = 14
                r15 = 0
                r11 = 0
                r12 = 0
                r13 = 0
                S2.C1594h.g(r9, r10, r11, r12, r13, r14, r15)
                d3.q r11 = r0.f4382i
                r3.f r12 = r0.f4383j
                r0.f4379f = r9
                r0.f4374a = r8
                r0.f4375b = r7
                r0.f4376c = r6
                r0.f4377d = r2
                r0.f4378e = r3
                java.lang.Object r10 = r11.invoke(r12, r10, r0)
                if (r10 != r1) goto L_0x0128
            L_0x0127:
                return r1
            L_0x0128:
                r19 = r2
                r2 = r6
                r6 = r7
                r7 = r9
                goto L_0x0097
            */
            throw new UnsupportedOperationException("Method not decompiled: s3.k.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public static final Object a(C1036f fVar, C1035e[] eVarArr, d3.a aVar, q qVar, V2.d dVar) {
        Object a5 = n.a(new a(eVarArr, aVar, qVar, fVar, (V2.d) null), dVar);
        if (a5 == b.c()) {
            return a5;
        }
        return s.f8222a;
    }
}
