package r3;

import R2.s;
import d3.p;
import kotlin.jvm.internal.z;

abstract /* synthetic */ class o {

    public static final class a implements C1035e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1035e f4246a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ p f4247b;

        public a(C1035e eVar, p pVar) {
            this.f4246a = eVar;
            this.f4247b = pVar;
        }

        public Object collect(C1036f fVar, V2.d dVar) {
            Object collect = this.f4246a.collect(new b(new z(), fVar, this.f4247b), dVar);
            if (collect == W2.b.c()) {
                return collect;
            }
            return s.f8222a;
        }
    }

    static final class b implements C1036f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ z f4248a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1036f f4249b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ p f4250c;

        static final class a extends kotlin.coroutines.jvm.internal.d {

            /* renamed from: a  reason: collision with root package name */
            Object f4251a;

            /* renamed from: b  reason: collision with root package name */
            Object f4252b;

            /* renamed from: c  reason: collision with root package name */
            /* synthetic */ Object f4253c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ b f4254d;

            /* renamed from: e  reason: collision with root package name */
            int f4255e;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(b bVar, V2.d dVar) {
                super(dVar);
                this.f4254d = bVar;
            }

            public final Object invokeSuspend(Object obj) {
                this.f4253c = obj;
                this.f4255e |= Integer.MIN_VALUE;
                return this.f4254d.emit((Object) null, this);
            }
        }

        b(z zVar, C1036f fVar, p pVar) {
            this.f4248a = zVar;
            this.f4249b = fVar;
            this.f4250c = pVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0056, code lost:
            if (r8.emit(r7, r0) == r1) goto L_0x0087;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0085, code lost:
            if (r8.emit(r7, r0) == r1) goto L_0x0087;
         */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0045  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x0074  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x008b  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object emit(java.lang.Object r7, V2.d r8) {
            /*
                r6 = this;
                boolean r0 = r8 instanceof r3.o.b.a
                if (r0 == 0) goto L_0x0013
                r0 = r8
                r3.o$b$a r0 = (r3.o.b.a) r0
                int r1 = r0.f4255e
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.f4255e = r1
                goto L_0x0018
            L_0x0013:
                r3.o$b$a r0 = new r3.o$b$a
                r0.<init>(r6, r8)
            L_0x0018:
                java.lang.Object r8 = r0.f4253c
                java.lang.Object r1 = W2.b.c()
                int r2 = r0.f4255e
                r3 = 3
                r4 = 2
                r5 = 1
                if (r2 == 0) goto L_0x0045
                if (r2 == r5) goto L_0x0041
                if (r2 == r4) goto L_0x0037
                if (r2 != r3) goto L_0x002f
                R2.n.b(r8)
                goto L_0x0088
            L_0x002f:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L_0x0037:
                java.lang.Object r7 = r0.f4252b
                java.lang.Object r2 = r0.f4251a
                r3.o$b r2 = (r3.o.b) r2
                R2.n.b(r8)
                goto L_0x006c
            L_0x0041:
                R2.n.b(r8)
                goto L_0x0059
            L_0x0045:
                R2.n.b(r8)
                kotlin.jvm.internal.z r8 = r6.f4248a
                boolean r8 = r8.f20985a
                if (r8 == 0) goto L_0x005c
                r3.f r8 = r6.f4249b
                r0.f4255e = r5
                java.lang.Object r7 = r8.emit(r7, r0)
                if (r7 != r1) goto L_0x0059
                goto L_0x0087
            L_0x0059:
                R2.s r7 = R2.s.f8222a
                return r7
            L_0x005c:
                d3.p r8 = r6.f4250c
                r0.f4251a = r6
                r0.f4252b = r7
                r0.f4255e = r4
                java.lang.Object r8 = r8.invoke(r7, r0)
                if (r8 != r1) goto L_0x006b
                goto L_0x0087
            L_0x006b:
                r2 = r6
            L_0x006c:
                java.lang.Boolean r8 = (java.lang.Boolean) r8
                boolean r8 = r8.booleanValue()
                if (r8 != 0) goto L_0x008b
                kotlin.jvm.internal.z r8 = r2.f4248a
                r8.f20985a = r5
                r3.f r8 = r2.f4249b
                r2 = 0
                r0.f4251a = r2
                r0.f4252b = r2
                r0.f4255e = r3
                java.lang.Object r7 = r8.emit(r7, r0)
                if (r7 != r1) goto L_0x0088
            L_0x0087:
                return r1
            L_0x0088:
                R2.s r7 = R2.s.f8222a
                return r7
            L_0x008b:
                R2.s r7 = R2.s.f8222a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: r3.o.b.emit(java.lang.Object, V2.d):java.lang.Object");
        }
    }

    public static final class c implements C1035e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1035e f4256a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ p f4257b;

        public static final class a extends kotlin.coroutines.jvm.internal.d {

            /* renamed from: a  reason: collision with root package name */
            /* synthetic */ Object f4258a;

            /* renamed from: b  reason: collision with root package name */
            int f4259b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ c f4260c;

            /* renamed from: d  reason: collision with root package name */
            Object f4261d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(c cVar, V2.d dVar) {
                super(dVar);
                this.f4260c = cVar;
            }

            public final Object invokeSuspend(Object obj) {
                this.f4258a = obj;
                this.f4259b |= Integer.MIN_VALUE;
                return this.f4260c.collect((C1036f) null, this);
            }
        }

        public c(C1035e eVar, p pVar) {
            this.f4256a = eVar;
            this.f4257b = pVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object collect(r3.C1036f r6, V2.d r7) {
            /*
                r5 = this;
                boolean r0 = r7 instanceof r3.o.c.a
                if (r0 == 0) goto L_0x0013
                r0 = r7
                r3.o$c$a r0 = (r3.o.c.a) r0
                int r1 = r0.f4259b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.f4259b = r1
                goto L_0x0018
            L_0x0013:
                r3.o$c$a r0 = new r3.o$c$a
                r0.<init>(r5, r7)
            L_0x0018:
                java.lang.Object r7 = r0.f4258a
                java.lang.Object r1 = W2.b.c()
                int r2 = r0.f4259b
                r3 = 1
                if (r2 == 0) goto L_0x0037
                if (r2 != r3) goto L_0x002f
                java.lang.Object r6 = r0.f4261d
                r3.o$d r6 = (r3.o.d) r6
                R2.n.b(r7)     // Catch:{ a -> 0x002d }
                goto L_0x0053
            L_0x002d:
                r7 = move-exception
                goto L_0x0050
            L_0x002f:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L_0x0037:
                R2.n.b(r7)
                r3.e r7 = r5.f4256a
                r3.o$d r2 = new r3.o$d
                d3.p r4 = r5.f4257b
                r2.<init>(r4, r6)
                r0.f4261d = r2     // Catch:{ a -> 0x004e }
                r0.f4259b = r3     // Catch:{ a -> 0x004e }
                java.lang.Object r6 = r7.collect(r2, r0)     // Catch:{ a -> 0x004e }
                if (r6 != r1) goto L_0x0053
                return r1
            L_0x004e:
                r7 = move-exception
                r6 = r2
            L_0x0050:
                s3.o.a(r7, r6)
            L_0x0053:
                R2.s r6 = R2.s.f8222a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: r3.o.c.collect(r3.f, V2.d):java.lang.Object");
        }
    }

    public static final class d implements C1036f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ p f4262a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1036f f4263b;

        public static final class a extends kotlin.coroutines.jvm.internal.d {

            /* renamed from: a  reason: collision with root package name */
            Object f4264a;

            /* renamed from: b  reason: collision with root package name */
            /* synthetic */ Object f4265b;

            /* renamed from: c  reason: collision with root package name */
            int f4266c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ d f4267d;

            /* renamed from: e  reason: collision with root package name */
            Object f4268e;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(d dVar, V2.d dVar2) {
                super(dVar2);
                this.f4267d = dVar;
            }

            public final Object invokeSuspend(Object obj) {
                this.f4265b = obj;
                this.f4266c |= Integer.MIN_VALUE;
                return this.f4267d.emit((Object) null, this);
            }
        }

        public d(p pVar, C1036f fVar) {
            this.f4262a = pVar;
            this.f4263b = fVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0078, code lost:
            if (r2.emit(r9, r0) == r1) goto L_0x007a;
         */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0046  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x006b  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x007b  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x007e  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0081  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object emit(java.lang.Object r8, V2.d r9) {
            /*
                r7 = this;
                boolean r0 = r9 instanceof r3.o.d.a
                if (r0 == 0) goto L_0x0013
                r0 = r9
                r3.o$d$a r0 = (r3.o.d.a) r0
                int r1 = r0.f4266c
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.f4266c = r1
                goto L_0x0018
            L_0x0013:
                r3.o$d$a r0 = new r3.o$d$a
                r0.<init>(r7, r9)
            L_0x0018:
                java.lang.Object r9 = r0.f4265b
                java.lang.Object r1 = W2.b.c()
                int r2 = r0.f4266c
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L_0x0046
                if (r2 == r4) goto L_0x0038
                if (r2 != r3) goto L_0x0030
                java.lang.Object r8 = r0.f4264a
                r3.o$d r8 = (r3.o.d) r8
                R2.n.b(r9)
                goto L_0x007c
            L_0x0030:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L_0x0038:
                java.lang.Object r8 = r0.f4268e
                java.lang.Object r2 = r0.f4264a
                r3.o$d r2 = (r3.o.d) r2
                R2.n.b(r9)
                r6 = r9
                r9 = r8
                r8 = r2
                r2 = r6
                goto L_0x0063
            L_0x0046:
                R2.n.b(r9)
                d3.p r9 = r7.f4262a
                r0.f4264a = r7
                r0.f4268e = r8
                r0.f4266c = r4
                r2 = 6
                kotlin.jvm.internal.l.c(r2)
                java.lang.Object r9 = r9.invoke(r8, r0)
                r2 = 7
                kotlin.jvm.internal.l.c(r2)
                if (r9 != r1) goto L_0x0060
                goto L_0x007a
            L_0x0060:
                r2 = r9
                r9 = r8
                r8 = r7
            L_0x0063:
                java.lang.Boolean r2 = (java.lang.Boolean) r2
                boolean r2 = r2.booleanValue()
                if (r2 == 0) goto L_0x007b
                r3.f r2 = r8.f4263b
                r0.f4264a = r8
                r5 = 0
                r0.f4268e = r5
                r0.f4266c = r3
                java.lang.Object r9 = r2.emit(r9, r0)
                if (r9 != r1) goto L_0x007c
            L_0x007a:
                return r1
            L_0x007b:
                r4 = 0
            L_0x007c:
                if (r4 == 0) goto L_0x0081
                R2.s r8 = R2.s.f8222a
                return r8
            L_0x0081:
                s3.a r9 = new s3.a
                r9.<init>(r8)
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: r3.o.d.emit(java.lang.Object, V2.d):java.lang.Object");
        }
    }

    public static final C1035e a(C1035e eVar, p pVar) {
        return new a(eVar, pVar);
    }

    public static final C1035e b(C1035e eVar, p pVar) {
        return new c(eVar, pVar);
    }
}
