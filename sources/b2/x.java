package b2;

import R2.n;
import R2.s;
import android.content.Context;
import d3.p;
import f2.N;
import f2.O;
import f2.Q;
import f2.T;
import java.util.ArrayList;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import o3.C0977g;
import o3.C1001s0;
import o3.J;
import o3.L;
import o3.Y;

public final class x {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f9597a;

    /* renamed from: b  reason: collision with root package name */
    private final J f9598b;

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9599a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x f9600b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ long f9601c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ N f9602d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(x xVar, long j4, N n4, V2.d dVar) {
            super(2, dVar);
            this.f9600b = xVar;
            this.f9601c = j4;
            this.f9602d = n4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new a(this.f9600b, this.f9601c, this.f9602d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f9599a;
            if (i4 == 0) {
                n.b(obj);
                x xVar = this.f9600b;
                long j4 = this.f9601c;
                N n4 = this.f9602d;
                this.f9599a = 1;
                if (xVar.f(j4, n4, this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9603a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x f9604b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ long f9605c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ N f9606d;

        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9607a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ N f9608b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(N n4, V2.d dVar) {
                super(2, dVar);
                this.f9608b = n4;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f9608b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9607a == 0) {
                    n.b(obj);
                    this.f9608b.d();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* renamed from: b2.x$b$b  reason: collision with other inner class name */
        static final class C0160b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9609a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ N f9610b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0160b(N n4, V2.d dVar) {
                super(2, dVar);
                this.f9610b = n4;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new C0160b(this.f9610b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9609a == 0) {
                    n.b(obj);
                    this.f9610b.a();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((C0160b) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        static final class c extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9611a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ N f9612b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(N n4, V2.d dVar) {
                super(2, dVar);
                this.f9612b = n4;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new c(this.f9612b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9611a == 0) {
                    n.b(obj);
                    this.f9612b.a();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((c) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(x xVar, long j4, N n4, V2.d dVar) {
            super(2, dVar);
            this.f9604b = xVar;
            this.f9605c = j4;
            this.f9606d = n4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new b(this.f9604b, this.f9605c, this.f9606d, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x005f, code lost:
            if (o3.C0977g.g(r8, r1, r7) == r0) goto L_0x0089;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0073, code lost:
            if (o3.C0977g.g(r8, r1, r7) == r0) goto L_0x0089;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0087, code lost:
            if (o3.C0977g.g(r8, r1, r7) == r0) goto L_0x0089;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r7.f9603a
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L_0x001e
                if (r1 == r4) goto L_0x001a
                if (r1 == r3) goto L_0x001a
                if (r1 != r2) goto L_0x0012
                goto L_0x001a
            L_0x0012:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L_0x001a:
                R2.n.b(r8)
                goto L_0x008a
            L_0x001e:
                R2.n.b(r8)
                u2.L r8 = new u2.L
                b2.x r1 = r7.f9604b
                android.content.Context r1 = r1.f9597a
                r8.<init>(r1)
                long r5 = r7.f9605c
                g2.L r8 = r8.k1(r5)
                boolean r1 = r8.b()
                r5 = 0
                if (r1 != 0) goto L_0x0076
                org.json.JSONObject r1 = r8.e()
                if (r1 == 0) goto L_0x0076
                org.json.JSONObject r8 = r8.e()
                kotlin.jvm.internal.m.b(r8)
                java.lang.String r1 = "success"
                int r8 = r8.optInt(r1)
                if (r8 != r4) goto L_0x0062
                o3.E0 r8 = o3.Y.c()
                b2.x$b$a r1 = new b2.x$b$a
                f2.N r2 = r7.f9606d
                r1.<init>(r2, r5)
                r7.f9603a = r4
                java.lang.Object r8 = o3.C0977g.g(r8, r1, r7)
                if (r8 != r0) goto L_0x008a
                goto L_0x0089
            L_0x0062:
                o3.E0 r8 = o3.Y.c()
                b2.x$b$b r1 = new b2.x$b$b
                f2.N r2 = r7.f9606d
                r1.<init>(r2, r5)
                r7.f9603a = r3
                java.lang.Object r8 = o3.C0977g.g(r8, r1, r7)
                if (r8 != r0) goto L_0x008a
                goto L_0x0089
            L_0x0076:
                o3.E0 r8 = o3.Y.c()
                b2.x$b$c r1 = new b2.x$b$c
                f2.N r3 = r7.f9606d
                r1.<init>(r3, r5)
                r7.f9603a = r2
                java.lang.Object r8 = o3.C0977g.g(r8, r1, r7)
                if (r8 != r0) goto L_0x008a
            L_0x0089:
                return r0
            L_0x008a:
                R2.s r8 = R2.s.f8222a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: b2.x.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9613a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x f9614b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ long f9615c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ O f9616d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(x xVar, long j4, O o4, V2.d dVar) {
            super(2, dVar);
            this.f9614b = xVar;
            this.f9615c = j4;
            this.f9616d = o4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new c(this.f9614b, this.f9615c, this.f9616d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f9613a;
            if (i4 == 0) {
                n.b(obj);
                x xVar = this.f9614b;
                long j4 = this.f9615c;
                O o4 = this.f9616d;
                this.f9613a = 1;
                if (xVar.h(j4, o4, this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((c) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9617a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x f9618b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ long f9619c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ O f9620d;

        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9621a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ O f9622b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(O o4, V2.d dVar) {
                super(2, dVar);
                this.f9622b = o4;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f9622b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9621a == 0) {
                    n.b(obj);
                    this.f9622b.f();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        static final class b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9623a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ O f9624b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(O o4, V2.d dVar) {
                super(2, dVar);
                this.f9624b = o4;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new b(this.f9624b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9623a == 0) {
                    n.b(obj);
                    this.f9624b.a();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        static final class c extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9625a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ O f9626b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(O o4, V2.d dVar) {
                super(2, dVar);
                this.f9626b = o4;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new c(this.f9626b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9625a == 0) {
                    n.b(obj);
                    this.f9626b.a();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((c) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(x xVar, long j4, O o4, V2.d dVar) {
            super(2, dVar);
            this.f9618b = xVar;
            this.f9619c = j4;
            this.f9620d = o4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new d(this.f9618b, this.f9619c, this.f9620d, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x005f, code lost:
            if (o3.C0977g.g(r8, r1, r7) == r0) goto L_0x0089;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0073, code lost:
            if (o3.C0977g.g(r8, r1, r7) == r0) goto L_0x0089;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0087, code lost:
            if (o3.C0977g.g(r8, r1, r7) == r0) goto L_0x0089;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r7.f9617a
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L_0x001e
                if (r1 == r4) goto L_0x001a
                if (r1 == r3) goto L_0x001a
                if (r1 != r2) goto L_0x0012
                goto L_0x001a
            L_0x0012:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L_0x001a:
                R2.n.b(r8)
                goto L_0x008a
            L_0x001e:
                R2.n.b(r8)
                u2.L r8 = new u2.L
                b2.x r1 = r7.f9618b
                android.content.Context r1 = r1.f9597a
                r8.<init>(r1)
                long r5 = r7.f9619c
                g2.L r8 = r8.l1(r5)
                boolean r1 = r8.b()
                r5 = 0
                if (r1 != 0) goto L_0x0076
                org.json.JSONObject r1 = r8.e()
                if (r1 == 0) goto L_0x0076
                org.json.JSONObject r8 = r8.e()
                kotlin.jvm.internal.m.b(r8)
                java.lang.String r1 = "success"
                int r8 = r8.optInt(r1)
                if (r8 != r4) goto L_0x0062
                o3.E0 r8 = o3.Y.c()
                b2.x$d$a r1 = new b2.x$d$a
                f2.O r2 = r7.f9620d
                r1.<init>(r2, r5)
                r7.f9617a = r4
                java.lang.Object r8 = o3.C0977g.g(r8, r1, r7)
                if (r8 != r0) goto L_0x008a
                goto L_0x0089
            L_0x0062:
                o3.E0 r8 = o3.Y.c()
                b2.x$d$b r1 = new b2.x$d$b
                f2.O r2 = r7.f9620d
                r1.<init>(r2, r5)
                r7.f9617a = r3
                java.lang.Object r8 = o3.C0977g.g(r8, r1, r7)
                if (r8 != r0) goto L_0x008a
                goto L_0x0089
            L_0x0076:
                o3.E0 r8 = o3.Y.c()
                b2.x$d$c r1 = new b2.x$d$c
                f2.O r3 = r7.f9620d
                r1.<init>(r3, r5)
                r7.f9617a = r2
                java.lang.Object r8 = o3.C0977g.g(r8, r1, r7)
                if (r8 != r0) goto L_0x008a
            L_0x0089:
                return r0
            L_0x008a:
                R2.s r8 = R2.s.f8222a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: b2.x.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((d) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9627a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x f9628b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Q f9629c;

        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9630a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Q f9631b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ ArrayList f9632c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(Q q4, ArrayList arrayList, V2.d dVar) {
                super(2, dVar);
                this.f9631b = q4;
                this.f9632c = arrayList;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f9631b, this.f9632c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9630a == 0) {
                    n.b(obj);
                    this.f9631b.e(this.f9632c);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        static final class b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9633a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Q f9634b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(Q q4, V2.d dVar) {
                super(2, dVar);
                this.f9634b = q4;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new b(this.f9634b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9633a == 0) {
                    n.b(obj);
                    this.f9634b.a();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(x xVar, Q q4, V2.d dVar) {
            super(2, dVar);
            this.f9628b = xVar;
            this.f9629c = q4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new e(this.f9628b, this.f9629c, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x007e, code lost:
            if (o3.C0977g.g(r11, r2, r10) == r0) goto L_0x0094;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0092, code lost:
            if (o3.C0977g.g(r11, r1, r10) == r0) goto L_0x0094;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r10.f9627a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x001c
                if (r1 == r3) goto L_0x0017
                if (r1 != r2) goto L_0x000f
                goto L_0x0017
            L_0x000f:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L_0x0017:
                R2.n.b(r11)
                goto L_0x0095
            L_0x001c:
                R2.n.b(r11)
                u2.L r11 = new u2.L
                b2.x r1 = r10.f9628b
                android.content.Context r1 = r1.f9597a
                r11.<init>(r1)
                r1 = 20
                r4 = 0
                g2.L r11 = r11.S(r1, r4)
                boolean r1 = r11.b()
                r5 = 0
                if (r1 != 0) goto L_0x0081
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>()
                org.json.JSONObject r6 = r11.e()
                if (r6 == 0) goto L_0x006d
                org.json.JSONObject r11 = r11.e()
                kotlin.jvm.internal.m.b(r11)
                java.lang.String r6 = "data"
                org.json.JSONArray r11 = r11.optJSONArray(r6)
                if (r11 == 0) goto L_0x006d
                int r6 = r11.length()
            L_0x0056:
                if (r4 >= r6) goto L_0x006d
                g2.h$b r7 = g2.C2050h.f20600F0
                org.json.JSONObject r8 = r11.optJSONObject(r4)
                java.lang.String r9 = "optJSONObject(...)"
                kotlin.jvm.internal.m.d(r8, r9)
                g2.h r7 = g2.C2050h.b.b(r7, r8, r5, r2, r5)
                r1.add(r7)
                int r4 = r4 + 1
                goto L_0x0056
            L_0x006d:
                o3.E0 r11 = o3.Y.c()
                b2.x$e$a r2 = new b2.x$e$a
                f2.Q r4 = r10.f9629c
                r2.<init>(r4, r1, r5)
                r10.f9627a = r3
                java.lang.Object r11 = o3.C0977g.g(r11, r2, r10)
                if (r11 != r0) goto L_0x0095
                goto L_0x0094
            L_0x0081:
                o3.E0 r11 = o3.Y.c()
                b2.x$e$b r1 = new b2.x$e$b
                f2.Q r3 = r10.f9629c
                r1.<init>(r3, r5)
                r10.f9627a = r2
                java.lang.Object r11 = o3.C0977g.g(r11, r1, r10)
                if (r11 != r0) goto L_0x0095
            L_0x0094:
                return r0
            L_0x0095:
                R2.s r11 = R2.s.f8222a
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: b2.x.e.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((e) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class f extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9635a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x f9636b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f9637c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f9638d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ T f9639e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(x xVar, int i4, int i5, T t4, V2.d dVar) {
            super(2, dVar);
            this.f9636b = xVar;
            this.f9637c = i4;
            this.f9638d = i5;
            this.f9639e = t4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new f(this.f9636b, this.f9637c, this.f9638d, this.f9639e, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f9635a;
            if (i4 == 0) {
                n.b(obj);
                x xVar = this.f9636b;
                int i5 = this.f9637c;
                int i6 = this.f9638d;
                T t4 = this.f9639e;
                this.f9635a = 1;
                if (xVar.k(i5, i6, t4, this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((f) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class g extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9640a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x f9641b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f9642c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f9643d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ T f9644e;

        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9645a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ T f9646b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ ArrayList f9647c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(T t4, ArrayList arrayList, V2.d dVar) {
                super(2, dVar);
                this.f9646b = t4;
                this.f9647c = arrayList;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f9646b, this.f9647c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9645a == 0) {
                    n.b(obj);
                    this.f9646b.c(this.f9647c, false);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        static final class b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9648a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ T f9649b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(T t4, V2.d dVar) {
                super(2, dVar);
                this.f9649b = t4;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new b(this.f9649b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9648a == 0) {
                    n.b(obj);
                    this.f9649b.a();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(x xVar, int i4, int i5, T t4, V2.d dVar) {
            super(2, dVar);
            this.f9641b = xVar;
            this.f9642c = i4;
            this.f9643d = i5;
            this.f9644e = t4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new g(this.f9641b, this.f9642c, this.f9643d, this.f9644e, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0080, code lost:
            if (o3.C0977g.g(r10, r2, r9) == r0) goto L_0x0096;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0094, code lost:
            if (o3.C0977g.g(r10, r1, r9) == r0) goto L_0x0096;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r9.f9640a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x001c
                if (r1 == r3) goto L_0x0017
                if (r1 != r2) goto L_0x000f
                goto L_0x0017
            L_0x000f:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L_0x0017:
                R2.n.b(r10)
                goto L_0x0097
            L_0x001c:
                R2.n.b(r10)
                u2.L r10 = new u2.L
                b2.x r1 = r9.f9641b
                android.content.Context r1 = r1.f9597a
                r10.<init>(r1)
                int r1 = r9.f9642c
                int r4 = r9.f9643d
                g2.L r10 = r10.C0(r1, r4)
                boolean r1 = r10.b()
                r4 = 0
                if (r1 != 0) goto L_0x0083
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>()
                org.json.JSONObject r2 = r10.e()
                if (r2 == 0) goto L_0x006f
                org.json.JSONObject r10 = r10.e()
                kotlin.jvm.internal.m.b(r10)
                java.lang.String r2 = "data"
                org.json.JSONArray r10 = r10.optJSONArray(r2)
                if (r10 == 0) goto L_0x006f
                int r2 = r10.length()
                r5 = 0
            L_0x0058:
                if (r5 >= r2) goto L_0x006f
                g2.W$a r6 = g2.W.f20497j
                org.json.JSONObject r7 = r10.optJSONObject(r5)
                java.lang.String r8 = "optJSONObject(...)"
                kotlin.jvm.internal.m.d(r7, r8)
                g2.W r6 = r6.a(r7)
                r1.add(r6)
                int r5 = r5 + 1
                goto L_0x0058
            L_0x006f:
                o3.E0 r10 = o3.Y.c()
                b2.x$g$a r2 = new b2.x$g$a
                f2.T r5 = r9.f9644e
                r2.<init>(r5, r1, r4)
                r9.f9640a = r3
                java.lang.Object r10 = o3.C0977g.g(r10, r2, r9)
                if (r10 != r0) goto L_0x0097
                goto L_0x0096
            L_0x0083:
                o3.E0 r10 = o3.Y.c()
                b2.x$g$b r1 = new b2.x$g$b
                f2.T r3 = r9.f9644e
                r1.<init>(r3, r4)
                r9.f9640a = r2
                java.lang.Object r10 = o3.C0977g.g(r10, r1, r9)
                if (r10 != r0) goto L_0x0097
            L_0x0096:
                return r0
            L_0x0097:
                R2.s r10 = R2.s.f8222a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: b2.x.g.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((g) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public x(Context context, J j4) {
        m.e(context, "context");
        m.e(j4, "scope");
        this.f9597a = context;
        this.f9598b = j4;
    }

    /* access modifiers changed from: private */
    public final Object f(long j4, N n4, V2.d dVar) {
        Object g4 = C0977g.g(Y.b(), new b(this, j4, n4, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public final Object h(long j4, O o4, V2.d dVar) {
        Object g4 = C0977g.g(Y.b(), new d(this, j4, o4, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public final Object k(int i4, int i5, T t4, V2.d dVar) {
        Object g4 = C0977g.g(Y.b(), new g(this, i4, i5, t4, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    public final void e(long j4, N n4) {
        m.e(n4, "listener");
        C1001s0 unused = C0981i.d(this.f9598b, (V2.g) null, (L) null, new a(this, j4, n4, (V2.d) null), 3, (Object) null);
    }

    public final void g(long j4, O o4) {
        m.e(o4, "listener");
        C1001s0 unused = C0981i.d(this.f9598b, (V2.g) null, (L) null, new c(this, j4, o4, (V2.d) null), 3, (Object) null);
    }

    public final void i(Q q4) {
        m.e(q4, "listener");
        C1001s0 unused = C0981i.d(this.f9598b, Y.b(), (L) null, new e(this, q4, (V2.d) null), 2, (Object) null);
    }

    public final void j(int i4, int i5, T t4) {
        m.e(t4, "listener");
        C1001s0 unused = C0981i.d(this.f9598b, (V2.g) null, (L) null, new f(this, i4, i5, t4, (V2.d) null), 3, (Object) null);
    }
}
