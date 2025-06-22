package r3;

import d3.p;
import d3.q;
import kotlin.coroutines.jvm.internal.d;

/* renamed from: r3.m  reason: case insensitive filesystem */
abstract /* synthetic */ class C1043m {

    /* renamed from: r3.m$a */
    static final class a extends d {

        /* renamed from: a  reason: collision with root package name */
        Object f4212a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f4213b;

        /* renamed from: c  reason: collision with root package name */
        int f4214c;

        a(V2.d dVar) {
            super(dVar);
        }

        public final Object invokeSuspend(Object obj) {
            this.f4213b = obj;
            this.f4214c |= Integer.MIN_VALUE;
            return C1043m.c((C1036f) null, (q) null, (Throwable) null, this);
        }
    }

    /* renamed from: r3.m$b */
    public static final class b implements C1035e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1035e f4215a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ q f4216b;

        /* renamed from: r3.m$b$a */
        public static final class a extends d {

            /* renamed from: a  reason: collision with root package name */
            /* synthetic */ Object f4217a;

            /* renamed from: b  reason: collision with root package name */
            int f4218b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ b f4219c;

            /* renamed from: d  reason: collision with root package name */
            Object f4220d;

            /* renamed from: e  reason: collision with root package name */
            Object f4221e;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(b bVar, V2.d dVar) {
                super(dVar);
                this.f4219c = bVar;
            }

            public final Object invokeSuspend(Object obj) {
                this.f4217a = obj;
                this.f4218b |= Integer.MIN_VALUE;
                return this.f4219c.collect((C1036f) null, this);
            }
        }

        public b(C1035e eVar, q qVar) {
            this.f4215a = eVar;
            this.f4216b = qVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:41:0x00aa, code lost:
            if (r3.C1043m.a(r10, r2, r9, r0) != r1) goto L_0x00ad;
         */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0055  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x0088  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object collect(r3.C1036f r9, V2.d r10) {
            /*
                r8 = this;
                boolean r0 = r10 instanceof r3.C1043m.b.a
                if (r0 == 0) goto L_0x0013
                r0 = r10
                r3.m$b$a r0 = (r3.C1043m.b.a) r0
                int r1 = r0.f4218b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.f4218b = r1
                goto L_0x0018
            L_0x0013:
                r3.m$b$a r0 = new r3.m$b$a
                r0.<init>(r8, r10)
            L_0x0018:
                java.lang.Object r10 = r0.f4217a
                java.lang.Object r1 = W2.b.c()
                int r2 = r0.f4218b
                r3 = 3
                r4 = 2
                r5 = 1
                r6 = 0
                if (r2 == 0) goto L_0x0055
                if (r2 == r5) goto L_0x0047
                if (r2 == r4) goto L_0x003e
                if (r2 != r3) goto L_0x0036
                java.lang.Object r9 = r0.f4220d
                s3.t r9 = (s3.t) r9
                R2.n.b(r10)     // Catch:{ all -> 0x0034 }
                goto L_0x0089
            L_0x0034:
                r10 = move-exception
                goto L_0x0093
            L_0x0036:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L_0x003e:
                java.lang.Object r9 = r0.f4220d
                java.lang.Throwable r9 = (java.lang.Throwable) r9
                R2.n.b(r10)
                goto L_0x00ad
            L_0x0047:
                java.lang.Object r9 = r0.f4221e
                r3.f r9 = (r3.C1036f) r9
                java.lang.Object r2 = r0.f4220d
                r3.m$b r2 = (r3.C1043m.b) r2
                R2.n.b(r10)     // Catch:{ all -> 0x0053 }
                goto L_0x0068
            L_0x0053:
                r9 = move-exception
                goto L_0x0099
            L_0x0055:
                R2.n.b(r10)
                r3.e r10 = r8.f4215a     // Catch:{ all -> 0x0097 }
                r0.f4220d = r8     // Catch:{ all -> 0x0097 }
                r0.f4221e = r9     // Catch:{ all -> 0x0097 }
                r0.f4218b = r5     // Catch:{ all -> 0x0097 }
                java.lang.Object r10 = r10.collect(r9, r0)     // Catch:{ all -> 0x0097 }
                if (r10 != r1) goto L_0x0067
                goto L_0x00ac
            L_0x0067:
                r2 = r8
            L_0x0068:
                s3.t r10 = new s3.t
                V2.g r4 = r0.getContext()
                r10.<init>(r9, r4)
                d3.q r9 = r2.f4216b     // Catch:{ all -> 0x008f }
                r0.f4220d = r10     // Catch:{ all -> 0x008f }
                r0.f4221e = r6     // Catch:{ all -> 0x008f }
                r0.f4218b = r3     // Catch:{ all -> 0x008f }
                r2 = 6
                kotlin.jvm.internal.l.c(r2)     // Catch:{ all -> 0x008f }
                java.lang.Object r9 = r9.invoke(r10, r6, r0)     // Catch:{ all -> 0x008f }
                r0 = 7
                kotlin.jvm.internal.l.c(r0)     // Catch:{ all -> 0x008f }
                if (r9 != r1) goto L_0x0088
                goto L_0x00ac
            L_0x0088:
                r9 = r10
            L_0x0089:
                r9.releaseIntercepted()
                R2.s r9 = R2.s.f8222a
                return r9
            L_0x008f:
                r9 = move-exception
                r7 = r10
                r10 = r9
                r9 = r7
            L_0x0093:
                r9.releaseIntercepted()
                throw r10
            L_0x0097:
                r9 = move-exception
                r2 = r8
            L_0x0099:
                r3.M r10 = new r3.M
                r10.<init>(r9)
                d3.q r2 = r2.f4216b
                r0.f4220d = r9
                r0.f4221e = r6
                r0.f4218b = r4
                java.lang.Object r10 = r3.C1043m.c(r10, r2, r9, r0)
                if (r10 != r1) goto L_0x00ad
            L_0x00ac:
                return r1
            L_0x00ad:
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: r3.C1043m.b.collect(r3.f, V2.d):java.lang.Object");
        }
    }

    /* renamed from: r3.m$c */
    public static final class c implements C1035e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ p f4222a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1035e f4223b;

        /* renamed from: r3.m$c$a */
        public static final class a extends d {

            /* renamed from: a  reason: collision with root package name */
            /* synthetic */ Object f4224a;

            /* renamed from: b  reason: collision with root package name */
            int f4225b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ c f4226c;

            /* renamed from: d  reason: collision with root package name */
            Object f4227d;

            /* renamed from: e  reason: collision with root package name */
            Object f4228e;

            /* renamed from: f  reason: collision with root package name */
            Object f4229f;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(c cVar, V2.d dVar) {
                super(dVar);
                this.f4226c = cVar;
            }

            public final Object invokeSuspend(Object obj) {
                this.f4224a = obj;
                this.f4225b |= Integer.MIN_VALUE;
                return this.f4226c.collect((C1036f) null, this);
            }
        }

        public c(p pVar, C1035e eVar) {
            this.f4222a = pVar;
            this.f4223b = eVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0080, code lost:
            if (r7.collect(r2, r0) != r1) goto L_0x0083;
         */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0046  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object collect(r3.C1036f r7, V2.d r8) {
            /*
                r6 = this;
                boolean r0 = r8 instanceof r3.C1043m.c.a
                if (r0 == 0) goto L_0x0013
                r0 = r8
                r3.m$c$a r0 = (r3.C1043m.c.a) r0
                int r1 = r0.f4225b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.f4225b = r1
                goto L_0x0018
            L_0x0013:
                r3.m$c$a r0 = new r3.m$c$a
                r0.<init>(r6, r8)
            L_0x0018:
                java.lang.Object r8 = r0.f4224a
                java.lang.Object r1 = W2.b.c()
                int r2 = r0.f4225b
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L_0x0046
                if (r2 == r4) goto L_0x0034
                if (r2 != r3) goto L_0x002c
                R2.n.b(r8)
                goto L_0x0083
            L_0x002c:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L_0x0034:
                java.lang.Object r7 = r0.f4229f
                s3.t r7 = (s3.t) r7
                java.lang.Object r2 = r0.f4228e
                r3.f r2 = (r3.C1036f) r2
                java.lang.Object r4 = r0.f4227d
                r3.m$c r4 = (r3.C1043m.c) r4
                R2.n.b(r8)     // Catch:{ all -> 0x0044 }
                goto L_0x006e
            L_0x0044:
                r8 = move-exception
                goto L_0x008a
            L_0x0046:
                R2.n.b(r8)
                s3.t r8 = new s3.t
                V2.g r2 = r0.getContext()
                r8.<init>(r7, r2)
                d3.p r2 = r6.f4222a     // Catch:{ all -> 0x0086 }
                r0.f4227d = r6     // Catch:{ all -> 0x0086 }
                r0.f4228e = r7     // Catch:{ all -> 0x0086 }
                r0.f4229f = r8     // Catch:{ all -> 0x0086 }
                r0.f4225b = r4     // Catch:{ all -> 0x0086 }
                r4 = 6
                kotlin.jvm.internal.l.c(r4)     // Catch:{ all -> 0x0086 }
                java.lang.Object r2 = r2.invoke(r8, r0)     // Catch:{ all -> 0x0086 }
                r4 = 7
                kotlin.jvm.internal.l.c(r4)     // Catch:{ all -> 0x0086 }
                if (r2 != r1) goto L_0x006b
                goto L_0x0082
            L_0x006b:
                r4 = r6
                r2 = r7
                r7 = r8
            L_0x006e:
                r7.releaseIntercepted()
                r3.e r7 = r4.f4223b
                r8 = 0
                r0.f4227d = r8
                r0.f4228e = r8
                r0.f4229f = r8
                r0.f4225b = r3
                java.lang.Object r7 = r7.collect(r2, r0)
                if (r7 != r1) goto L_0x0083
            L_0x0082:
                return r1
            L_0x0083:
                R2.s r7 = R2.s.f8222a
                return r7
            L_0x0086:
                r7 = move-exception
                r5 = r8
                r8 = r7
                r7 = r5
            L_0x008a:
                r7.releaseIntercepted()
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: r3.C1043m.c.collect(r3.f, V2.d):java.lang.Object");
        }
    }

    public static final void b(C1036f fVar) {
        if (fVar instanceof M) {
            throw ((M) fVar).f4181a;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.lang.Throwable} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object c(r3.C1036f r4, d3.q r5, java.lang.Throwable r6, V2.d r7) {
        /*
            boolean r0 = r7 instanceof r3.C1043m.a
            if (r0 == 0) goto L_0x0013
            r0 = r7
            r3.m$a r0 = (r3.C1043m.a) r0
            int r1 = r0.f4214c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f4214c = r1
            goto L_0x0018
        L_0x0013:
            r3.m$a r0 = new r3.m$a
            r0.<init>(r7)
        L_0x0018:
            java.lang.Object r7 = r0.f4213b
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.f4214c
            r3 = 1
            if (r2 == 0) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            java.lang.Object r4 = r0.f4212a
            r6 = r4
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            R2.n.b(r7)     // Catch:{ all -> 0x002e }
            goto L_0x0046
        L_0x002e:
            r4 = move-exception
            goto L_0x0049
        L_0x0030:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0038:
            R2.n.b(r7)
            r0.f4212a = r6     // Catch:{ all -> 0x002e }
            r0.f4214c = r3     // Catch:{ all -> 0x002e }
            java.lang.Object r4 = r5.invoke(r4, r6, r0)     // Catch:{ all -> 0x002e }
            if (r4 != r1) goto L_0x0046
            return r1
        L_0x0046:
            R2.s r4 = R2.s.f8222a
            return r4
        L_0x0049:
            if (r6 == 0) goto L_0x0050
            if (r6 == r4) goto L_0x0050
            R2.a.a(r4, r6)
        L_0x0050:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: r3.C1043m.c(r3.f, d3.q, java.lang.Throwable, V2.d):java.lang.Object");
    }

    public static final C1035e d(C1035e eVar, q qVar) {
        return new b(eVar, qVar);
    }

    public static final C1035e e(C1035e eVar, p pVar) {
        return new c(pVar, eVar);
    }
}
