package r3;

import V2.g;
import d3.q;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.m;
import o3.C1001s0;

abstract /* synthetic */ class n {

    public static final class a implements C1035e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1035e f4230a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ q f4231b;

        /* renamed from: r3.n$a$a  reason: collision with other inner class name */
        public static final class C0042a extends d {

            /* renamed from: a  reason: collision with root package name */
            /* synthetic */ Object f4232a;

            /* renamed from: b  reason: collision with root package name */
            int f4233b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ a f4234c;

            /* renamed from: d  reason: collision with root package name */
            Object f4235d;

            /* renamed from: e  reason: collision with root package name */
            Object f4236e;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0042a(a aVar, V2.d dVar) {
                super(dVar);
                this.f4234c = aVar;
            }

            public final Object invokeSuspend(Object obj) {
                this.f4232a = obj;
                this.f4233b |= Integer.MIN_VALUE;
                return this.f4234c.collect((C1036f) null, this);
            }
        }

        public a(C1035e eVar, q qVar) {
            this.f4230a = eVar;
            this.f4231b = qVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:20:0x006c, code lost:
            if (r6 == r1) goto L_0x006e;
         */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0040  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0057  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object collect(r3.C1036f r6, V2.d r7) {
            /*
                r5 = this;
                boolean r0 = r7 instanceof r3.n.a.C0042a
                if (r0 == 0) goto L_0x0013
                r0 = r7
                r3.n$a$a r0 = (r3.n.a.C0042a) r0
                int r1 = r0.f4233b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.f4233b = r1
                goto L_0x0018
            L_0x0013:
                r3.n$a$a r0 = new r3.n$a$a
                r0.<init>(r5, r7)
            L_0x0018:
                java.lang.Object r7 = r0.f4232a
                java.lang.Object r1 = W2.b.c()
                int r2 = r0.f4233b
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L_0x0040
                if (r2 == r4) goto L_0x0034
                if (r2 != r3) goto L_0x002c
                R2.n.b(r7)
                goto L_0x006f
            L_0x002c:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L_0x0034:
                java.lang.Object r6 = r0.f4236e
                r3.f r6 = (r3.C1036f) r6
                java.lang.Object r2 = r0.f4235d
                r3.n$a r2 = (r3.n.a) r2
                R2.n.b(r7)
                goto L_0x0053
            L_0x0040:
                R2.n.b(r7)
                r3.e r7 = r5.f4230a
                r0.f4235d = r5
                r0.f4236e = r6
                r0.f4233b = r4
                java.lang.Object r7 = r3.C1037g.f(r7, r6, r0)
                if (r7 != r1) goto L_0x0052
                goto L_0x006e
            L_0x0052:
                r2 = r5
            L_0x0053:
                java.lang.Throwable r7 = (java.lang.Throwable) r7
                if (r7 == 0) goto L_0x006f
                d3.q r2 = r2.f4231b
                r4 = 0
                r0.f4235d = r4
                r0.f4236e = r4
                r0.f4233b = r3
                r3 = 6
                kotlin.jvm.internal.l.c(r3)
                java.lang.Object r6 = r2.invoke(r6, r7, r0)
                r7 = 7
                kotlin.jvm.internal.l.c(r7)
                if (r6 != r1) goto L_0x006f
            L_0x006e:
                return r1
            L_0x006f:
                R2.s r6 = R2.s.f8222a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: r3.n.a.collect(r3.f, V2.d):java.lang.Object");
        }
    }

    static final class b extends d {

        /* renamed from: a  reason: collision with root package name */
        Object f4237a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f4238b;

        /* renamed from: c  reason: collision with root package name */
        int f4239c;

        b(V2.d dVar) {
            super(dVar);
        }

        public final Object invokeSuspend(Object obj) {
            this.f4238b = obj;
            this.f4239c |= Integer.MIN_VALUE;
            return C1037g.f((C1035e) null, (C1036f) null, this);
        }
    }

    static final class c implements C1036f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1036f f4240a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C f4241b;

        static final class a extends d {

            /* renamed from: a  reason: collision with root package name */
            Object f4242a;

            /* renamed from: b  reason: collision with root package name */
            /* synthetic */ Object f4243b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ c f4244c;

            /* renamed from: d  reason: collision with root package name */
            int f4245d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(c cVar, V2.d dVar) {
                super(dVar);
                this.f4244c = cVar;
            }

            public final Object invokeSuspend(Object obj) {
                this.f4243b = obj;
                this.f4245d |= Integer.MIN_VALUE;
                return this.f4244c.emit((Object) null, this);
            }
        }

        c(C1036f fVar, C c5) {
            this.f4240a = fVar;
            this.f4241b = c5;
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object emit(java.lang.Object r5, V2.d r6) {
            /*
                r4 = this;
                boolean r0 = r6 instanceof r3.n.c.a
                if (r0 == 0) goto L_0x0013
                r0 = r6
                r3.n$c$a r0 = (r3.n.c.a) r0
                int r1 = r0.f4245d
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.f4245d = r1
                goto L_0x0018
            L_0x0013:
                r3.n$c$a r0 = new r3.n$c$a
                r0.<init>(r4, r6)
            L_0x0018:
                java.lang.Object r6 = r0.f4243b
                java.lang.Object r1 = W2.b.c()
                int r2 = r0.f4245d
                r3 = 1
                if (r2 == 0) goto L_0x0037
                if (r2 != r3) goto L_0x002f
                java.lang.Object r5 = r0.f4242a
                r3.n$c r5 = (r3.n.c) r5
                R2.n.b(r6)     // Catch:{ all -> 0x002d }
                goto L_0x0047
            L_0x002d:
                r6 = move-exception
                goto L_0x004c
            L_0x002f:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L_0x0037:
                R2.n.b(r6)
                r3.f r6 = r4.f4240a     // Catch:{ all -> 0x004a }
                r0.f4242a = r4     // Catch:{ all -> 0x004a }
                r0.f4245d = r3     // Catch:{ all -> 0x004a }
                java.lang.Object r5 = r6.emit(r5, r0)     // Catch:{ all -> 0x004a }
                if (r5 != r1) goto L_0x0047
                return r1
            L_0x0047:
                R2.s r5 = R2.s.f8222a
                return r5
            L_0x004a:
                r6 = move-exception
                r5 = r4
            L_0x004c:
                kotlin.jvm.internal.C r5 = r5.f4241b
                r5.f20968a = r6
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: r3.n.c.emit(java.lang.Object, V2.d):java.lang.Object");
        }
    }

    public static final C1035e a(C1035e eVar, q qVar) {
        return new a(eVar, qVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object b(r3.C1035e r4, r3.C1036f r5, V2.d r6) {
        /*
            boolean r0 = r6 instanceof r3.n.b
            if (r0 == 0) goto L_0x0013
            r0 = r6
            r3.n$b r0 = (r3.n.b) r0
            int r1 = r0.f4239c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f4239c = r1
            goto L_0x0018
        L_0x0013:
            r3.n$b r0 = new r3.n$b
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.f4238b
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.f4239c
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r4 = r0.f4237a
            kotlin.jvm.internal.C r4 = (kotlin.jvm.internal.C) r4
            R2.n.b(r6)     // Catch:{ all -> 0x002d }
            goto L_0x004f
        L_0x002d:
            r5 = move-exception
            goto L_0x0053
        L_0x002f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0037:
            R2.n.b(r6)
            kotlin.jvm.internal.C r6 = new kotlin.jvm.internal.C
            r6.<init>()
            r3.n$c r2 = new r3.n$c     // Catch:{ all -> 0x0051 }
            r2.<init>(r5, r6)     // Catch:{ all -> 0x0051 }
            r0.f4237a = r6     // Catch:{ all -> 0x0051 }
            r0.f4239c = r3     // Catch:{ all -> 0x0051 }
            java.lang.Object r4 = r4.collect(r2, r0)     // Catch:{ all -> 0x0051 }
            if (r4 != r1) goto L_0x004f
            return r1
        L_0x004f:
            r4 = 0
            return r4
        L_0x0051:
            r5 = move-exception
            r4 = r6
        L_0x0053:
            java.lang.Object r4 = r4.f20968a
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            boolean r6 = d(r5, r4)
            if (r6 != 0) goto L_0x0076
            V2.g r6 = r0.getContext()
            boolean r6 = c(r5, r6)
            if (r6 != 0) goto L_0x0076
            if (r4 != 0) goto L_0x006a
            return r5
        L_0x006a:
            boolean r6 = r5 instanceof java.util.concurrent.CancellationException
            if (r6 == 0) goto L_0x0072
            R2.a.a(r4, r5)
            throw r4
        L_0x0072:
            R2.a.a(r5, r4)
            throw r5
        L_0x0076:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: r3.n.b(r3.e, r3.f, V2.d):java.lang.Object");
    }

    private static final boolean c(Throwable th, g gVar) {
        C1001s0 s0Var = (C1001s0) gVar.get(C1001s0.f3726k0);
        if (s0Var == null || !s0Var.isCancelled()) {
            return false;
        }
        return d(th, s0Var.l());
    }

    private static final boolean d(Throwable th, Throwable th2) {
        if (th2 == null || !m.a(th2, th)) {
            return false;
        }
        return true;
    }
}
