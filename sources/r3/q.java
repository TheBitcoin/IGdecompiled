package r3;

import d3.p;
import kotlin.jvm.internal.C;

abstract /* synthetic */ class q {

    public static final class a implements C1036f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C f4274a;

        public a(C c5) {
            this.f4274a = c5;
        }

        public Object emit(Object obj, V2.d dVar) {
            this.f4274a.f20968a = obj;
            throw new s3.a(this);
        }
    }

    public static final class b implements C1036f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ p f4275a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C f4276b;

        public static final class a extends kotlin.coroutines.jvm.internal.d {

            /* renamed from: a  reason: collision with root package name */
            Object f4277a;

            /* renamed from: b  reason: collision with root package name */
            /* synthetic */ Object f4278b;

            /* renamed from: c  reason: collision with root package name */
            int f4279c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ b f4280d;

            /* renamed from: e  reason: collision with root package name */
            Object f4281e;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(b bVar, V2.d dVar) {
                super(dVar);
                this.f4280d = bVar;
            }

            public final Object invokeSuspend(Object obj) {
                this.f4278b = obj;
                this.f4279c |= Integer.MIN_VALUE;
                return this.f4280d.emit((Object) null, this);
            }
        }

        public b(p pVar, C c5) {
            this.f4275a = pVar;
            this.f4276b = c5;
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x005a  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x005d  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object emit(java.lang.Object r5, V2.d r6) {
            /*
                r4 = this;
                boolean r0 = r6 instanceof r3.q.b.a
                if (r0 == 0) goto L_0x0013
                r0 = r6
                r3.q$b$a r0 = (r3.q.b.a) r0
                int r1 = r0.f4279c
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.f4279c = r1
                goto L_0x0018
            L_0x0013:
                r3.q$b$a r0 = new r3.q$b$a
                r0.<init>(r4, r6)
            L_0x0018:
                java.lang.Object r6 = r0.f4278b
                java.lang.Object r1 = W2.b.c()
                int r2 = r0.f4279c
                r3 = 1
                if (r2 == 0) goto L_0x0037
                if (r2 != r3) goto L_0x002f
                java.lang.Object r5 = r0.f4281e
                java.lang.Object r0 = r0.f4277a
                r3.q$b r0 = (r3.q.b) r0
                R2.n.b(r6)
                goto L_0x0052
            L_0x002f:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L_0x0037:
                R2.n.b(r6)
                d3.p r6 = r4.f4275a
                r0.f4277a = r4
                r0.f4281e = r5
                r0.f4279c = r3
                r2 = 6
                kotlin.jvm.internal.l.c(r2)
                java.lang.Object r6 = r6.invoke(r5, r0)
                r0 = 7
                kotlin.jvm.internal.l.c(r0)
                if (r6 != r1) goto L_0x0051
                return r1
            L_0x0051:
                r0 = r4
            L_0x0052:
                java.lang.Boolean r6 = (java.lang.Boolean) r6
                boolean r6 = r6.booleanValue()
                if (r6 != 0) goto L_0x005d
                R2.s r5 = R2.s.f8222a
                return r5
            L_0x005d:
                kotlin.jvm.internal.C r6 = r0.f4276b
                r6.f20968a = r5
                s3.a r5 = new s3.a
                r5.<init>(r0)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: r3.q.b.emit(java.lang.Object, V2.d):java.lang.Object");
        }
    }

    static final class c extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f4282a;

        /* renamed from: b  reason: collision with root package name */
        Object f4283b;

        /* renamed from: c  reason: collision with root package name */
        /* synthetic */ Object f4284c;

        /* renamed from: d  reason: collision with root package name */
        int f4285d;

        c(V2.d dVar) {
            super(dVar);
        }

        public final Object invokeSuspend(Object obj) {
            this.f4284c = obj;
            this.f4285d |= Integer.MIN_VALUE;
            return C1037g.p((C1035e) null, this);
        }
    }

    static final class d extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f4286a;

        /* renamed from: b  reason: collision with root package name */
        Object f4287b;

        /* renamed from: c  reason: collision with root package name */
        Object f4288c;

        /* renamed from: d  reason: collision with root package name */
        /* synthetic */ Object f4289d;

        /* renamed from: e  reason: collision with root package name */
        int f4290e;

        d(V2.d dVar) {
            super(dVar);
        }

        public final Object invokeSuspend(Object obj) {
            this.f4289d = obj;
            this.f4290e |= Integer.MIN_VALUE;
            return C1037g.q((C1035e) null, (p) null, this);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0068 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object a(r3.C1035e r4, V2.d r5) {
        /*
            boolean r0 = r5 instanceof r3.q.c
            if (r0 == 0) goto L_0x0013
            r0 = r5
            r3.q$c r0 = (r3.q.c) r0
            int r1 = r0.f4285d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f4285d = r1
            goto L_0x0018
        L_0x0013:
            r3.q$c r0 = new r3.q$c
            r0.<init>(r5)
        L_0x0018:
            java.lang.Object r5 = r0.f4284c
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.f4285d
            r3 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r4 = r0.f4283b
            r3.q$a r4 = (r3.q.a) r4
            java.lang.Object r0 = r0.f4282a
            kotlin.jvm.internal.C r0 = (kotlin.jvm.internal.C) r0
            R2.n.b(r5)     // Catch:{ a -> 0x0031 }
            goto L_0x0062
        L_0x0031:
            r5 = move-exception
            goto L_0x005f
        L_0x0033:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x003b:
            R2.n.b(r5)
            kotlin.jvm.internal.C r5 = new kotlin.jvm.internal.C
            r5.<init>()
            t3.F r2 = s3.s.f4399a
            r5.f20968a = r2
            r3.q$a r2 = new r3.q$a
            r2.<init>(r5)
            r0.f4282a = r5     // Catch:{ a -> 0x005b }
            r0.f4283b = r2     // Catch:{ a -> 0x005b }
            r0.f4285d = r3     // Catch:{ a -> 0x005b }
            java.lang.Object r4 = r4.collect(r2, r0)     // Catch:{ a -> 0x005b }
            if (r4 != r1) goto L_0x0059
            return r1
        L_0x0059:
            r0 = r5
            goto L_0x0062
        L_0x005b:
            r4 = move-exception
            r0 = r5
            r5 = r4
            r4 = r2
        L_0x005f:
            s3.o.a(r5, r4)
        L_0x0062:
            java.lang.Object r4 = r0.f20968a
            t3.F r5 = s3.s.f4399a
            if (r4 == r5) goto L_0x0069
            return r4
        L_0x0069:
            java.util.NoSuchElementException r4 = new java.util.NoSuchElementException
            java.lang.String r5 = "Expected at least one element"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: r3.q.a(r3.e, V2.d):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0070 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object b(r3.C1035e r4, d3.p r5, V2.d r6) {
        /*
            boolean r0 = r6 instanceof r3.q.d
            if (r0 == 0) goto L_0x0013
            r0 = r6
            r3.q$d r0 = (r3.q.d) r0
            int r1 = r0.f4290e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f4290e = r1
            goto L_0x0018
        L_0x0013:
            r3.q$d r0 = new r3.q$d
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.f4289d
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.f4290e
            r3 = 1
            if (r2 == 0) goto L_0x003f
            if (r2 != r3) goto L_0x0037
            java.lang.Object r4 = r0.f4288c
            r3.q$b r4 = (r3.q.b) r4
            java.lang.Object r5 = r0.f4287b
            kotlin.jvm.internal.C r5 = (kotlin.jvm.internal.C) r5
            java.lang.Object r0 = r0.f4286a
            d3.p r0 = (d3.p) r0
            R2.n.b(r6)     // Catch:{ a -> 0x0035 }
            goto L_0x006a
        L_0x0035:
            r6 = move-exception
            goto L_0x0067
        L_0x0037:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x003f:
            R2.n.b(r6)
            kotlin.jvm.internal.C r6 = new kotlin.jvm.internal.C
            r6.<init>()
            t3.F r2 = s3.s.f4399a
            r6.f20968a = r2
            r3.q$b r2 = new r3.q$b
            r2.<init>(r5, r6)
            r0.f4286a = r5     // Catch:{ a -> 0x0062 }
            r0.f4287b = r6     // Catch:{ a -> 0x0062 }
            r0.f4288c = r2     // Catch:{ a -> 0x0062 }
            r0.f4290e = r3     // Catch:{ a -> 0x0062 }
            java.lang.Object r4 = r4.collect(r2, r0)     // Catch:{ a -> 0x0062 }
            if (r4 != r1) goto L_0x005f
            return r1
        L_0x005f:
            r0 = r5
            r5 = r6
            goto L_0x006a
        L_0x0062:
            r4 = move-exception
            r0 = r5
            r5 = r6
            r6 = r4
            r4 = r2
        L_0x0067:
            s3.o.a(r6, r4)
        L_0x006a:
            java.lang.Object r4 = r5.f20968a
            t3.F r5 = s3.s.f4399a
            if (r4 == r5) goto L_0x0071
            return r4
        L_0x0071:
            java.util.NoSuchElementException r4 = new java.util.NoSuchElementException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Expected at least one element matching the predicate "
            r5.append(r6)
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: r3.q.b(r3.e, d3.p, V2.d):java.lang.Object");
    }
}
