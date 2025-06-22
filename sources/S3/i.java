package s3;

import R2.n;
import R2.s;
import V2.d;
import V2.g;
import V2.h;
import W2.b;
import d3.p;
import d3.q;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.C2103g;
import o3.J;
import o3.K;
import r3.C1035e;
import r3.C1036f;

public final class i extends g {
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final q f4355e;

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f4356a;

        /* renamed from: b  reason: collision with root package name */
        private /* synthetic */ Object f4357b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ i f4358c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C1036f f4359d;

        /* renamed from: s3.i$a$a  reason: collision with other inner class name */
        static final class C0045a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C f4360a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ J f4361b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ i f4362c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ C1036f f4363d;

            /* renamed from: s3.i$a$a$a  reason: collision with other inner class name */
            static final class C0046a extends l implements p {

                /* renamed from: a  reason: collision with root package name */
                int f4364a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ i f4365b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ C1036f f4366c;

                /* renamed from: d  reason: collision with root package name */
                final /* synthetic */ Object f4367d;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                C0046a(i iVar, C1036f fVar, Object obj, d dVar) {
                    super(2, dVar);
                    this.f4365b = iVar;
                    this.f4366c = fVar;
                    this.f4367d = obj;
                }

                public final d create(Object obj, d dVar) {
                    return new C0046a(this.f4365b, this.f4366c, this.f4367d, dVar);
                }

                public final Object invokeSuspend(Object obj) {
                    Object c5 = W2.b.c();
                    int i4 = this.f4364a;
                    if (i4 == 0) {
                        n.b(obj);
                        q r4 = this.f4365b.f4355e;
                        C1036f fVar = this.f4366c;
                        Object obj2 = this.f4367d;
                        this.f4364a = 1;
                        if (r4.invoke(fVar, obj2, this) == c5) {
                            return c5;
                        }
                    } else if (i4 == 1) {
                        n.b(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    return s.f8222a;
                }

                public final Object invoke(J j4, d dVar) {
                    return ((C0046a) create(j4, dVar)).invokeSuspend(s.f8222a);
                }
            }

            /* renamed from: s3.i$a$a$b */
            static final class b extends kotlin.coroutines.jvm.internal.d {

                /* renamed from: a  reason: collision with root package name */
                Object f4368a;

                /* renamed from: b  reason: collision with root package name */
                Object f4369b;

                /* renamed from: c  reason: collision with root package name */
                Object f4370c;

                /* renamed from: d  reason: collision with root package name */
                /* synthetic */ Object f4371d;

                /* renamed from: e  reason: collision with root package name */
                final /* synthetic */ C0045a f4372e;

                /* renamed from: f  reason: collision with root package name */
                int f4373f;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                b(C0045a aVar, d dVar) {
                    super(dVar);
                    this.f4372e = aVar;
                }

                public final Object invokeSuspend(Object obj) {
                    this.f4371d = obj;
                    this.f4373f |= Integer.MIN_VALUE;
                    return this.f4372e.emit((Object) null, this);
                }
            }

            C0045a(C c5, J j4, i iVar, C1036f fVar) {
                this.f4360a = c5;
                this.f4361b = j4;
                this.f4362c = iVar;
                this.f4363d = fVar;
            }

            /* JADX WARNING: Removed duplicated region for block: B:12:0x003b  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(java.lang.Object r8, V2.d r9) {
                /*
                    r7 = this;
                    boolean r0 = r9 instanceof s3.i.a.C0045a.b
                    if (r0 == 0) goto L_0x0013
                    r0 = r9
                    s3.i$a$a$b r0 = (s3.i.a.C0045a.b) r0
                    int r1 = r0.f4373f
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.f4373f = r1
                    goto L_0x0018
                L_0x0013:
                    s3.i$a$a$b r0 = new s3.i$a$a$b
                    r0.<init>(r7, r9)
                L_0x0018:
                    java.lang.Object r9 = r0.f4371d
                    java.lang.Object r1 = W2.b.c()
                    int r2 = r0.f4373f
                    r3 = 1
                    if (r2 == 0) goto L_0x003b
                    if (r2 != r3) goto L_0x0033
                    java.lang.Object r8 = r0.f4370c
                    o3.s0 r8 = (o3.C1001s0) r8
                    java.lang.Object r8 = r0.f4369b
                    java.lang.Object r0 = r0.f4368a
                    s3.i$a$a r0 = (s3.i.a.C0045a) r0
                    R2.n.b(r9)
                    goto L_0x005e
                L_0x0033:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r9)
                    throw r8
                L_0x003b:
                    R2.n.b(r9)
                    kotlin.jvm.internal.C r9 = r7.f4360a
                    java.lang.Object r9 = r9.f20968a
                    o3.s0 r9 = (o3.C1001s0) r9
                    if (r9 == 0) goto L_0x005d
                    s3.j r2 = new s3.j
                    r2.<init>()
                    r9.a(r2)
                    r0.f4368a = r7
                    r0.f4369b = r8
                    r0.f4370c = r9
                    r0.f4373f = r3
                    java.lang.Object r9 = r9.g(r0)
                    if (r9 != r1) goto L_0x005d
                    return r1
                L_0x005d:
                    r0 = r7
                L_0x005e:
                    kotlin.jvm.internal.C r9 = r0.f4360a
                    o3.J r1 = r0.f4361b
                    o3.L r3 = o3.L.UNDISPATCHED
                    s3.i$a$a$a r4 = new s3.i$a$a$a
                    s3.i r2 = r0.f4362c
                    r3.f r0 = r0.f4363d
                    r5 = 0
                    r4.<init>(r2, r0, r8, r5)
                    r5 = 1
                    r6 = 0
                    r2 = 0
                    o3.s0 r8 = o3.C0981i.d(r1, r2, r3, r4, r5, r6)
                    r9.f20968a = r8
                    R2.s r8 = R2.s.f8222a
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: s3.i.a.C0045a.emit(java.lang.Object, V2.d):java.lang.Object");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(i iVar, C1036f fVar, d dVar) {
            super(2, dVar);
            this.f4358c = iVar;
            this.f4359d = fVar;
        }

        public final d create(Object obj, d dVar) {
            a aVar = new a(this.f4358c, this.f4359d, dVar);
            aVar.f4357b = obj;
            return aVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = b.c();
            int i4 = this.f4356a;
            if (i4 == 0) {
                n.b(obj);
                C c6 = new C();
                i iVar = this.f4358c;
                C1035e eVar = iVar.f4351d;
                C0045a aVar = new C0045a(c6, (J) this.f4357b, iVar, this.f4359d);
                this.f4356a = 1;
                if (eVar.collect(aVar, this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }

        public final Object invoke(J j4, d dVar) {
            return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i(q qVar, C1035e eVar, g gVar, int i4, q3.a aVar, int i5, C2103g gVar2) {
        this(qVar, eVar, (i5 & 4) != 0 ? h.f8445a : gVar, (i5 & 8) != 0 ? -2 : i4, (i5 & 16) != 0 ? q3.a.SUSPEND : aVar);
    }

    /* access modifiers changed from: protected */
    public e i(g gVar, int i4, q3.a aVar) {
        return new i(this.f4355e, this.f4351d, gVar, i4, aVar);
    }

    /* access modifiers changed from: protected */
    public Object q(C1036f fVar, d dVar) {
        Object d5 = K.d(new a(this, fVar, (d) null), dVar);
        if (d5 == b.c()) {
            return d5;
        }
        return s.f8222a;
    }

    public i(q qVar, C1035e eVar, g gVar, int i4, q3.a aVar) {
        super(eVar, gVar, i4, aVar);
        this.f4355e = qVar;
    }
}
