package r3;

import R2.n;
import R2.s;
import V2.d;
import V2.g;
import d3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import o3.C0977g;
import o3.C1001s0;
import o3.J;
import o3.L;

abstract /* synthetic */ class r {

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f4291a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ D f4292b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C1035e f4293c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ s f4294d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Object f4295e;

        /* renamed from: r3.r$a$a  reason: collision with other inner class name */
        static final class C0043a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f4296a;

            /* renamed from: b  reason: collision with root package name */
            /* synthetic */ int f4297b;

            C0043a(d dVar) {
                super(2, dVar);
            }

            public final d create(Object obj, d dVar) {
                C0043a aVar = new C0043a(dVar);
                aVar.f4297b = ((Number) obj).intValue();
                return aVar;
            }

            public final Object i(int i4, d dVar) {
                return ((C0043a) create(Integer.valueOf(i4), dVar)).invokeSuspend(s.f8222a);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return i(((Number) obj).intValue(), (d) obj2);
            }

            public final Object invokeSuspend(Object obj) {
                boolean z4;
                W2.b.c();
                if (this.f4296a == 0) {
                    n.b(obj);
                    if (this.f4297b > 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    return kotlin.coroutines.jvm.internal.b.a(z4);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        static final class b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f4298a;

            /* renamed from: b  reason: collision with root package name */
            /* synthetic */ Object f4299b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ C1035e f4300c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ s f4301d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ Object f4302e;

            /* renamed from: r3.r$a$b$a  reason: collision with other inner class name */
            public /* synthetic */ class C0044a {

                /* renamed from: a  reason: collision with root package name */
                public static final /* synthetic */ int[] f4303a;

                /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
                /* JADX WARNING: Failed to process nested try/catch */
                /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
                /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
                static {
                    /*
                        r3.B[] r0 = r3.B.values()
                        int r0 = r0.length
                        int[] r0 = new int[r0]
                        r3.B r1 = r3.B.START     // Catch:{ NoSuchFieldError -> 0x0010 }
                        int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                        r2 = 1
                        r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                    L_0x0010:
                        r3.B r1 = r3.B.STOP     // Catch:{ NoSuchFieldError -> 0x0019 }
                        int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                        r2 = 2
                        r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                    L_0x0019:
                        r3.B r1 = r3.B.STOP_AND_RESET_REPLAY_CACHE     // Catch:{ NoSuchFieldError -> 0x0022 }
                        int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                        r2 = 3
                        r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
                    L_0x0022:
                        f4303a = r0
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: r3.r.a.b.C0044a.<clinit>():void");
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(C1035e eVar, s sVar, Object obj, d dVar) {
                super(2, dVar);
                this.f4300c = eVar;
                this.f4301d = sVar;
                this.f4302e = obj;
            }

            public final d create(Object obj, d dVar) {
                b bVar = new b(this.f4300c, this.f4301d, this.f4302e, dVar);
                bVar.f4299b = obj;
                return bVar;
            }

            /* renamed from: i */
            public final Object invoke(B b5, d dVar) {
                return ((b) create(b5, dVar)).invokeSuspend(s.f8222a);
            }

            public final Object invokeSuspend(Object obj) {
                Object c5 = W2.b.c();
                int i4 = this.f4298a;
                if (i4 == 0) {
                    n.b(obj);
                    int i5 = C0044a.f4303a[((B) this.f4299b).ordinal()];
                    if (i5 == 1) {
                        C1035e eVar = this.f4300c;
                        s sVar = this.f4301d;
                        this.f4298a = 1;
                        if (eVar.collect(sVar, this) == c5) {
                            return c5;
                        }
                    } else if (i5 == 3) {
                        Object obj2 = this.f4302e;
                        if (obj2 == z.f4329a) {
                            this.f4301d.d();
                        } else {
                            this.f4301d.f(obj2);
                        }
                    }
                } else if (i4 == 1) {
                    n.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return s.f8222a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(D d5, C1035e eVar, s sVar, Object obj, d dVar) {
            super(2, dVar);
            this.f4292b = d5;
            this.f4293c = eVar;
            this.f4294d = sVar;
            this.f4295e = obj;
        }

        public final d create(Object obj, d dVar) {
            return new a(this.f4292b, this.f4293c, this.f4294d, this.f4295e, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x003c, code lost:
            if (r8.collect(r1, r7) == r0) goto L_0x008c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0059, code lost:
            if (r3.C1037g.q(r8, r1, r7) == r0) goto L_0x008c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0066, code lost:
            if (r8.collect(r1, r7) == r0) goto L_0x008c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x008a, code lost:
            if (r3.C1037g.i(r8, r1, r7) == r0) goto L_0x008c;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r7.f4291a
                r2 = 4
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L_0x0025
                if (r1 == r5) goto L_0x0021
                if (r1 == r4) goto L_0x001d
                if (r1 == r3) goto L_0x0021
                if (r1 != r2) goto L_0x0015
                goto L_0x0021
            L_0x0015:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L_0x001d:
                R2.n.b(r8)
                goto L_0x005c
            L_0x0021:
                R2.n.b(r8)
                goto L_0x008d
            L_0x0025:
                R2.n.b(r8)
                r3.D r8 = r7.f4292b
                r3.D$a r1 = r3.D.f4148a
                r3.D r6 = r1.a()
                if (r8 != r6) goto L_0x003f
                r3.e r8 = r7.f4293c
                r3.s r1 = r7.f4294d
                r7.f4291a = r5
                java.lang.Object r8 = r8.collect(r1, r7)
                if (r8 != r0) goto L_0x008d
                goto L_0x008c
            L_0x003f:
                r3.D r8 = r7.f4292b
                r3.D r1 = r1.b()
                r5 = 0
                if (r8 != r1) goto L_0x0069
                r3.s r8 = r7.f4294d
                r3.I r8 = r8.g()
                r3.r$a$a r1 = new r3.r$a$a
                r1.<init>(r5)
                r7.f4291a = r4
                java.lang.Object r8 = r3.C1037g.q(r8, r1, r7)
                if (r8 != r0) goto L_0x005c
                goto L_0x008c
            L_0x005c:
                r3.e r8 = r7.f4293c
                r3.s r1 = r7.f4294d
                r7.f4291a = r3
                java.lang.Object r8 = r8.collect(r1, r7)
                if (r8 != r0) goto L_0x008d
                goto L_0x008c
            L_0x0069:
                r3.D r8 = r7.f4292b
                r3.s r1 = r7.f4294d
                r3.I r1 = r1.g()
                r3.e r8 = r8.a(r1)
                r3.e r8 = r3.C1037g.k(r8)
                r3.r$a$b r1 = new r3.r$a$b
                r3.e r3 = r7.f4293c
                r3.s r4 = r7.f4294d
                java.lang.Object r6 = r7.f4295e
                r1.<init>(r3, r4, r6, r5)
                r7.f4291a = r2
                java.lang.Object r8 = r3.C1037g.i(r8, r1, r7)
                if (r8 != r0) goto L_0x008d
            L_0x008c:
                return r0
            L_0x008d:
                R2.s r8 = R2.s.f8222a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: r3.r.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, d dVar) {
            return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public static final I a(t tVar) {
        return new v(tVar, (C1001s0) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002d, code lost:
        if (r3 == 0) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000f, code lost:
        r1 = (s3.e) r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final r3.C b(r3.C1035e r7, int r8) {
        /*
            q3.d$a r0 = q3.d.f4087l0
            int r0 = r0.a()
            int r0 = j3.e.a(r8, r0)
            int r0 = r0 - r8
            boolean r1 = r7 instanceof s3.e
            if (r1 == 0) goto L_0x003c
            r1 = r7
            s3.e r1 = (s3.e) r1
            r3.e r2 = r1.j()
            if (r2 == 0) goto L_0x003c
            r3.C r7 = new r3.C
            int r3 = r1.f4342b
            r4 = -3
            if (r3 == r4) goto L_0x0026
            r4 = -2
            if (r3 == r4) goto L_0x0026
            if (r3 == 0) goto L_0x0026
            r0 = r3
            goto L_0x0034
        L_0x0026:
            q3.a r4 = r1.f4343c
            q3.a r5 = q3.a.SUSPEND
            r6 = 0
            if (r4 != r5) goto L_0x0031
            if (r3 != 0) goto L_0x0034
        L_0x002f:
            r0 = 0
            goto L_0x0034
        L_0x0031:
            if (r8 != 0) goto L_0x002f
            r0 = 1
        L_0x0034:
            q3.a r8 = r1.f4343c
            V2.g r1 = r1.f4341a
            r7.<init>(r2, r0, r8, r1)
            return r7
        L_0x003c:
            r3.C r8 = new r3.C
            q3.a r1 = q3.a.SUSPEND
            V2.h r2 = V2.h.f8445a
            r8.<init>(r7, r0, r1, r2)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: r3.r.b(r3.e, int):r3.C");
    }

    private static final C1001s0 c(J j4, g gVar, C1035e eVar, s sVar, D d5, Object obj) {
        L l4;
        if (m.a(d5, D.f4148a.a())) {
            l4 = L.DEFAULT;
        } else {
            l4 = L.UNDISPATCHED;
        }
        return C0977g.c(j4, gVar, l4, new a(d5, eVar, sVar, obj, (d) null));
    }

    public static final x d(C1035e eVar, J j4, D d5, int i4) {
        C b5 = b(eVar, i4);
        s a5 = z.a(i4, b5.f4145b, b5.f4146c);
        return new u(a5, c(j4, b5.f4147d, b5.f4144a, a5, d5, z.f4329a));
    }
}
