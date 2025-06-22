package b2;

import R2.n;
import android.content.Context;
import d3.p;
import f2.N;
import f2.O;
import f2.P;
import f2.T;
import java.util.ArrayList;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.z;
import o3.C1001s0;
import o3.J;
import o3.L;
import o3.Y;

public final class s {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f9515a;

    /* renamed from: b  reason: collision with root package name */
    private final J f9516b;

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9517a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ s f9518b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ long f9519c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ N f9520d;

        /* renamed from: b2.s$a$a  reason: collision with other inner class name */
        static final class C0158a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9521a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ N f9522b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0158a(N n4, V2.d dVar) {
                super(2, dVar);
                this.f9522b = n4;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new C0158a(this.f9522b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9521a == 0) {
                    n.b(obj);
                    this.f9522b.d();
                    return R2.s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((C0158a) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
            }
        }

        static final class b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9523a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ N f9524b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(N n4, V2.d dVar) {
                super(2, dVar);
                this.f9524b = n4;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new b(this.f9524b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9523a == 0) {
                    n.b(obj);
                    this.f9524b.a();
                    return R2.s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((b) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
            }
        }

        static final class c extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9525a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ N f9526b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(N n4, V2.d dVar) {
                super(2, dVar);
                this.f9526b = n4;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new c(this.f9526b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9525a == 0) {
                    n.b(obj);
                    this.f9526b.a();
                    return R2.s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((c) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(s sVar, long j4, N n4, V2.d dVar) {
            super(2, dVar);
            this.f9518b = sVar;
            this.f9519c = j4;
            this.f9520d = n4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new a(this.f9518b, this.f9519c, this.f9520d, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x006c, code lost:
            if (o3.C0977g.g(r8, r1, r7) == r0) goto L_0x0096;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0080, code lost:
            if (o3.C0977g.g(r8, r1, r7) == r0) goto L_0x0096;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0094, code lost:
            if (o3.C0977g.g(r8, r1, r7) == r0) goto L_0x0096;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r7.f9517a
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L_0x001f
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
                goto L_0x0097
            L_0x001f:
                R2.n.b(r8)
                u2.L r8 = new u2.L
                b2.s r1 = r7.f9518b
                android.content.Context r1 = r1.f9515a
                r8.<init>(r1)
                long r5 = r7.f9519c
                g2.L r8 = r8.b(r5)
                boolean r1 = r8.b()
                r5 = 0
                if (r1 != 0) goto L_0x0083
                java.lang.String r1 = r8.d()
                if (r1 == 0) goto L_0x0083
                int r1 = r1.length()
                if (r1 != 0) goto L_0x0047
                goto L_0x0083
            L_0x0047:
                org.json.JSONObject r1 = new org.json.JSONObject
                java.lang.String r8 = r8.d()
                kotlin.jvm.internal.m.b(r8)
                r1.<init>(r8)
                java.lang.String r8 = "success"
                int r8 = r1.optInt(r8)
                if (r8 != r4) goto L_0x006f
                o3.E0 r8 = o3.Y.c()
                b2.s$a$a r1 = new b2.s$a$a
                f2.N r2 = r7.f9520d
                r1.<init>(r2, r5)
                r7.f9517a = r4
                java.lang.Object r8 = o3.C0977g.g(r8, r1, r7)
                if (r8 != r0) goto L_0x0097
                goto L_0x0096
            L_0x006f:
                o3.E0 r8 = o3.Y.c()
                b2.s$a$b r1 = new b2.s$a$b
                f2.N r2 = r7.f9520d
                r1.<init>(r2, r5)
                r7.f9517a = r3
                java.lang.Object r8 = o3.C0977g.g(r8, r1, r7)
                if (r8 != r0) goto L_0x0097
                goto L_0x0096
            L_0x0083:
                o3.E0 r8 = o3.Y.c()
                b2.s$a$c r1 = new b2.s$a$c
                f2.N r3 = r7.f9520d
                r1.<init>(r3, r5)
                r7.f9517a = r2
                java.lang.Object r8 = o3.C0977g.g(r8, r1, r7)
                if (r8 != r0) goto L_0x0097
            L_0x0096:
                return r0
            L_0x0097:
                R2.s r8 = R2.s.f8222a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: b2.s.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((a) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9527a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ s f9528b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ long f9529c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ O f9530d;

        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9531a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ O f9532b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(O o4, V2.d dVar) {
                super(2, dVar);
                this.f9532b = o4;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f9532b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9531a == 0) {
                    n.b(obj);
                    this.f9532b.f();
                    return R2.s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
            }
        }

        /* renamed from: b2.s$b$b  reason: collision with other inner class name */
        static final class C0159b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9533a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ O f9534b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0159b(O o4, V2.d dVar) {
                super(2, dVar);
                this.f9534b = o4;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new C0159b(this.f9534b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9533a == 0) {
                    n.b(obj);
                    this.f9534b.a();
                    return R2.s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((C0159b) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
            }
        }

        static final class c extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9535a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ O f9536b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(O o4, V2.d dVar) {
                super(2, dVar);
                this.f9536b = o4;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new c(this.f9536b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9535a == 0) {
                    n.b(obj);
                    this.f9536b.a();
                    return R2.s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((c) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(s sVar, long j4, O o4, V2.d dVar) {
            super(2, dVar);
            this.f9528b = sVar;
            this.f9529c = j4;
            this.f9530d = o4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new b(this.f9528b, this.f9529c, this.f9530d, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x006c, code lost:
            if (o3.C0977g.g(r8, r1, r7) == r0) goto L_0x0096;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0080, code lost:
            if (o3.C0977g.g(r8, r1, r7) == r0) goto L_0x0096;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0094, code lost:
            if (o3.C0977g.g(r8, r1, r7) == r0) goto L_0x0096;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r7.f9527a
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L_0x001f
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
                goto L_0x0097
            L_0x001f:
                R2.n.b(r8)
                u2.L r8 = new u2.L
                b2.s r1 = r7.f9528b
                android.content.Context r1 = r1.f9515a
                r8.<init>(r1)
                long r5 = r7.f9529c
                g2.L r8 = r8.W0(r5)
                boolean r1 = r8.b()
                r5 = 0
                if (r1 != 0) goto L_0x0083
                java.lang.String r1 = r8.d()
                if (r1 == 0) goto L_0x0083
                int r1 = r1.length()
                if (r1 != 0) goto L_0x0047
                goto L_0x0083
            L_0x0047:
                org.json.JSONObject r1 = new org.json.JSONObject
                java.lang.String r8 = r8.d()
                kotlin.jvm.internal.m.b(r8)
                r1.<init>(r8)
                java.lang.String r8 = "success"
                int r8 = r1.optInt(r8)
                if (r8 != r4) goto L_0x006f
                o3.E0 r8 = o3.Y.c()
                b2.s$b$a r1 = new b2.s$b$a
                f2.O r2 = r7.f9530d
                r1.<init>(r2, r5)
                r7.f9527a = r4
                java.lang.Object r8 = o3.C0977g.g(r8, r1, r7)
                if (r8 != r0) goto L_0x0097
                goto L_0x0096
            L_0x006f:
                o3.E0 r8 = o3.Y.c()
                b2.s$b$b r1 = new b2.s$b$b
                f2.O r2 = r7.f9530d
                r1.<init>(r2, r5)
                r7.f9527a = r3
                java.lang.Object r8 = o3.C0977g.g(r8, r1, r7)
                if (r8 != r0) goto L_0x0097
                goto L_0x0096
            L_0x0083:
                o3.E0 r8 = o3.Y.c()
                b2.s$b$c r1 = new b2.s$b$c
                f2.O r3 = r7.f9530d
                r1.<init>(r3, r5)
                r7.f9527a = r2
                java.lang.Object r8 = o3.C0977g.g(r8, r1, r7)
                if (r8 != r0) goto L_0x0097
            L_0x0096:
                return r0
            L_0x0097:
                R2.s r8 = R2.s.f8222a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: b2.s.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
        }
    }

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9537a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ s f9538b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f9539c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f9540d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ T f9541e;

        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9542a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ T f9543b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ ArrayList f9544c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ z f9545d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(T t4, ArrayList arrayList, z zVar, V2.d dVar) {
                super(2, dVar);
                this.f9543b = t4;
                this.f9544c = arrayList;
                this.f9545d = zVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f9543b, this.f9544c, this.f9545d, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9542a == 0) {
                    n.b(obj);
                    this.f9543b.c(this.f9544c, this.f9545d.f20985a);
                    return R2.s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
            }
        }

        static final class b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9546a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ T f9547b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(T t4, V2.d dVar) {
                super(2, dVar);
                this.f9547b = t4;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new b(this.f9547b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9546a == 0) {
                    n.b(obj);
                    this.f9547b.a();
                    return R2.s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((b) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(s sVar, int i4, int i5, T t4, V2.d dVar) {
            super(2, dVar);
            this.f9538b = sVar;
            this.f9539c = i4;
            this.f9540d = i5;
            this.f9541e = t4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new c(this.f9538b, this.f9539c, this.f9540d, this.f9541e, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:25:0x00a7, code lost:
            if (o3.C0977g.g(r13, r5, r12) == r0) goto L_0x00bd;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x00bb, code lost:
            if (o3.C0977g.g(r13, r1, r12) == r0) goto L_0x00bd;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                r12 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r12.f9537a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x001c
                if (r1 == r3) goto L_0x0017
                if (r1 != r2) goto L_0x000f
                goto L_0x0017
            L_0x000f:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L_0x0017:
                R2.n.b(r13)
                goto L_0x00be
            L_0x001c:
                R2.n.b(r13)
                u2.L r13 = new u2.L
                b2.s r1 = r12.f9538b
                android.content.Context r1 = r1.f9515a
                r13.<init>(r1)
                int r1 = r12.f9539c
                int r4 = r12.f9540d
                g2.L r13 = r13.I(r1, r4)
                boolean r1 = r13.b()
                r4 = 0
                if (r1 != 0) goto L_0x00aa
                kotlin.jvm.internal.z r1 = new kotlin.jvm.internal.z
                r1.<init>()
                r1.f20985a = r3
                java.util.ArrayList r2 = new java.util.ArrayList
                r2.<init>()
                java.lang.String r5 = r13.d()
                if (r5 == 0) goto L_0x0096
                int r5 = r5.length()
                if (r5 != 0) goto L_0x0052
                goto L_0x0096
            L_0x0052:
                org.json.JSONObject r5 = new org.json.JSONObject
                java.lang.String r13 = r13.d()
                kotlin.jvm.internal.m.b(r13)
                r5.<init>(r13)
                java.lang.String r13 = "data"
                org.json.JSONObject r13 = r5.optJSONObject(r13)
                if (r13 == 0) goto L_0x0096
                java.lang.String r5 = "items"
                org.json.JSONArray r5 = r13.optJSONArray(r5)
                r6 = 0
                if (r5 == 0) goto L_0x008b
                int r7 = r5.length()
                r8 = 0
            L_0x0074:
                if (r8 >= r7) goto L_0x008b
                g2.W$a r9 = g2.W.f20497j
                org.json.JSONObject r10 = r5.optJSONObject(r8)
                java.lang.String r11 = "optJSONObject(...)"
                kotlin.jvm.internal.m.d(r10, r11)
                g2.W r9 = r9.a(r10)
                r2.add(r9)
                int r8 = r8 + 1
                goto L_0x0074
            L_0x008b:
                java.lang.String r5 = "isPrivate"
                int r13 = r13.optInt(r5)
                if (r13 != r3) goto L_0x0094
                r6 = 1
            L_0x0094:
                r1.f20985a = r6
            L_0x0096:
                o3.E0 r13 = o3.Y.c()
                b2.s$c$a r5 = new b2.s$c$a
                f2.T r6 = r12.f9541e
                r5.<init>(r6, r2, r1, r4)
                r12.f9537a = r3
                java.lang.Object r13 = o3.C0977g.g(r13, r5, r12)
                if (r13 != r0) goto L_0x00be
                goto L_0x00bd
            L_0x00aa:
                o3.E0 r13 = o3.Y.c()
                b2.s$c$b r1 = new b2.s$c$b
                f2.T r3 = r12.f9541e
                r1.<init>(r3, r4)
                r12.f9537a = r2
                java.lang.Object r13 = o3.C0977g.g(r13, r1, r12)
                if (r13 != r0) goto L_0x00be
            L_0x00bd:
                return r0
            L_0x00be:
                R2.s r13 = R2.s.f8222a
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: b2.s.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((c) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9548a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ s f9549b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f9550c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f9551d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f9552e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ T f9553f;

        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9554a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ T f9555b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ ArrayList f9556c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(T t4, ArrayList arrayList, V2.d dVar) {
                super(2, dVar);
                this.f9555b = t4;
                this.f9556c = arrayList;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f9555b, this.f9556c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9554a == 0) {
                    n.b(obj);
                    this.f9555b.c(this.f9556c, false);
                    return R2.s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
            }
        }

        static final class b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9557a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ T f9558b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(T t4, V2.d dVar) {
                super(2, dVar);
                this.f9558b = t4;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new b(this.f9558b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9557a == 0) {
                    n.b(obj);
                    this.f9558b.a();
                    return R2.s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((b) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(s sVar, String str, int i4, int i5, T t4, V2.d dVar) {
            super(2, dVar);
            this.f9549b = sVar;
            this.f9550c = str;
            this.f9551d = i4;
            this.f9552e = i5;
            this.f9553f = t4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new d(this.f9549b, this.f9550c, this.f9551d, this.f9552e, this.f9553f, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x008e, code lost:
            if (o3.C0977g.g(r1, r2, r9) == r0) goto L_0x00a4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x00a2, code lost:
            if (o3.C0977g.g(r10, r1, r9) == r0) goto L_0x00a4;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r9.f9548a
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
                goto L_0x00a5
            L_0x001c:
                R2.n.b(r10)
                java.util.ArrayList r10 = new java.util.ArrayList
                r10.<init>()
                u2.L r1 = new u2.L
                b2.s r4 = r9.f9549b
                android.content.Context r4 = r4.f9515a
                r1.<init>(r4)
                java.lang.String r4 = r9.f9550c
                int r5 = r9.f9551d
                int r6 = r9.f9552e
                g2.L r1 = r1.Y(r4, r5, r6)
                boolean r4 = r1.b()
                r5 = 0
                if (r4 != 0) goto L_0x0091
                java.lang.String r4 = r1.d()
                if (r4 == 0) goto L_0x0091
                int r4 = r4.length()
                if (r4 != 0) goto L_0x004d
                goto L_0x0091
            L_0x004d:
                org.json.JSONObject r2 = new org.json.JSONObject
                java.lang.String r1 = r1.d()
                kotlin.jvm.internal.m.b(r1)
                r2.<init>(r1)
                java.lang.String r1 = "data"
                org.json.JSONArray r1 = r2.optJSONArray(r1)
                if (r1 == 0) goto L_0x00a5
                int r2 = r1.length()
                r4 = 0
            L_0x0066:
                if (r4 >= r2) goto L_0x007d
                g2.W$a r6 = g2.W.f20497j
                org.json.JSONObject r7 = r1.optJSONObject(r4)
                java.lang.String r8 = "optJSONObject(...)"
                kotlin.jvm.internal.m.d(r7, r8)
                g2.W r6 = r6.a(r7)
                r10.add(r6)
                int r4 = r4 + 1
                goto L_0x0066
            L_0x007d:
                o3.E0 r1 = o3.Y.c()
                b2.s$d$a r2 = new b2.s$d$a
                f2.T r4 = r9.f9553f
                r2.<init>(r4, r10, r5)
                r9.f9548a = r3
                java.lang.Object r10 = o3.C0977g.g(r1, r2, r9)
                if (r10 != r0) goto L_0x00a5
                goto L_0x00a4
            L_0x0091:
                o3.E0 r10 = o3.Y.c()
                b2.s$d$b r1 = new b2.s$d$b
                f2.T r3 = r9.f9553f
                r1.<init>(r3, r5)
                r9.f9548a = r2
                java.lang.Object r10 = o3.C0977g.g(r10, r1, r9)
                if (r10 != r0) goto L_0x00a5
            L_0x00a4:
                return r0
            L_0x00a5:
                R2.s r10 = R2.s.f8222a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: b2.s.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((d) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
        }
    }

    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9559a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ s f9560b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ P f9561c;

        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9562a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ P f9563b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(P p4, V2.d dVar) {
                super(2, dVar);
                this.f9563b = p4;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f9563b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9562a == 0) {
                    n.b(obj);
                    this.f9563b.g();
                    return R2.s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
            }
        }

        static final class b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9564a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ P f9565b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(P p4, V2.d dVar) {
                super(2, dVar);
                this.f9565b = p4;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new b(this.f9565b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9564a == 0) {
                    n.b(obj);
                    this.f9565b.b();
                    return R2.s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((b) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(s sVar, P p4, V2.d dVar) {
            super(2, dVar);
            this.f9560b = sVar;
            this.f9561c = p4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new e(this.f9560b, this.f9561c, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0052, code lost:
            if (o3.C0977g.g(r6, r1, r5) == r0) goto L_0x0068;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0066, code lost:
            if (o3.C0977g.g(r6, r1, r5) == r0) goto L_0x0068;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r5.f9559a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x001b
                if (r1 == r3) goto L_0x0017
                if (r1 != r2) goto L_0x000f
                goto L_0x0017
            L_0x000f:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L_0x0017:
                R2.n.b(r6)
                goto L_0x0069
            L_0x001b:
                R2.n.b(r6)
                u2.L r6 = new u2.L
                b2.s r1 = r5.f9560b
                android.content.Context r1 = r1.f9515a
                r6.<init>(r1)
                g2.L r6 = r6.c1()
                boolean r1 = r6.b()
                r4 = 0
                if (r1 != 0) goto L_0x0055
                java.lang.String r6 = r6.d()
                if (r6 == 0) goto L_0x0055
                int r6 = r6.length()
                if (r6 != 0) goto L_0x0041
                goto L_0x0055
            L_0x0041:
                o3.E0 r6 = o3.Y.c()
                b2.s$e$a r1 = new b2.s$e$a
                f2.P r2 = r5.f9561c
                r1.<init>(r2, r4)
                r5.f9559a = r3
                java.lang.Object r6 = o3.C0977g.g(r6, r1, r5)
                if (r6 != r0) goto L_0x0069
                goto L_0x0068
            L_0x0055:
                o3.E0 r6 = o3.Y.c()
                b2.s$e$b r1 = new b2.s$e$b
                f2.P r3 = r5.f9561c
                r1.<init>(r3, r4)
                r5.f9559a = r2
                java.lang.Object r6 = o3.C0977g.g(r6, r1, r5)
                if (r6 != r0) goto L_0x0069
            L_0x0068:
                return r0
            L_0x0069:
                R2.s r6 = R2.s.f8222a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: b2.s.e.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((e) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
        }
    }

    static final class f extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9566a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ s f9567b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ P f9568c;

        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9569a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ P f9570b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(P p4, V2.d dVar) {
                super(2, dVar);
                this.f9570b = p4;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f9570b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9569a == 0) {
                    n.b(obj);
                    this.f9570b.b();
                    return R2.s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
            }
        }

        static final class b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f9571a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ P f9572b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(P p4, V2.d dVar) {
                super(2, dVar);
                this.f9572b = p4;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new b(this.f9572b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f9571a == 0) {
                    n.b(obj);
                    this.f9572b.g();
                    return R2.s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((b) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(s sVar, P p4, V2.d dVar) {
            super(2, dVar);
            this.f9567b = sVar;
            this.f9568c = p4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new f(this.f9567b, this.f9568c, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0052, code lost:
            if (o3.C0977g.g(r6, r1, r5) == r0) goto L_0x0068;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0066, code lost:
            if (o3.C0977g.g(r6, r1, r5) == r0) goto L_0x0068;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r5.f9566a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x001b
                if (r1 == r3) goto L_0x0017
                if (r1 != r2) goto L_0x000f
                goto L_0x0017
            L_0x000f:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L_0x0017:
                R2.n.b(r6)
                goto L_0x0069
            L_0x001b:
                R2.n.b(r6)
                u2.L r6 = new u2.L
                b2.s r1 = r5.f9567b
                android.content.Context r1 = r1.f9515a
                r6.<init>(r1)
                g2.L r6 = r6.d1()
                boolean r1 = r6.b()
                r4 = 0
                if (r1 != 0) goto L_0x0055
                java.lang.String r6 = r6.d()
                if (r6 == 0) goto L_0x0055
                int r6 = r6.length()
                if (r6 != 0) goto L_0x0041
                goto L_0x0055
            L_0x0041:
                o3.E0 r6 = o3.Y.c()
                b2.s$f$a r1 = new b2.s$f$a
                f2.P r2 = r5.f9568c
                r1.<init>(r2, r4)
                r5.f9566a = r3
                java.lang.Object r6 = o3.C0977g.g(r6, r1, r5)
                if (r6 != r0) goto L_0x0069
                goto L_0x0068
            L_0x0055:
                o3.E0 r6 = o3.Y.c()
                b2.s$f$b r1 = new b2.s$f$b
                f2.P r3 = r5.f9568c
                r1.<init>(r3, r4)
                r5.f9566a = r2
                java.lang.Object r6 = o3.C0977g.g(r6, r1, r5)
                if (r6 != r0) goto L_0x0069
            L_0x0068:
                return r0
            L_0x0069:
                R2.s r6 = R2.s.f8222a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: b2.s.f.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((f) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
        }
    }

    public s(Context context, J j4) {
        m.e(context, "context");
        m.e(j4, "scope");
        this.f9515a = context;
        this.f9516b = j4;
    }

    public final void b(long j4, N n4) {
        m.e(n4, "listener");
        C1001s0 unused = C0981i.d(this.f9516b, Y.b(), (L) null, new a(this, j4, n4, (V2.d) null), 2, (Object) null);
    }

    public final void c(long j4, O o4) {
        m.e(o4, "listener");
        C1001s0 unused = C0981i.d(this.f9516b, Y.b(), (L) null, new b(this, j4, o4, (V2.d) null), 2, (Object) null);
    }

    public final void d(int i4, int i5, T t4) {
        m.e(t4, "listener");
        C1001s0 unused = C0981i.d(this.f9516b, Y.b(), (L) null, new c(this, i4, i5, t4, (V2.d) null), 2, (Object) null);
    }

    public final void e(String str, int i4, int i5, T t4) {
        m.e(str, "userID");
        m.e(t4, "listener");
        C1001s0 unused = C0981i.d(this.f9516b, Y.b(), (L) null, new d(this, str, i4, i5, t4, (V2.d) null), 2, (Object) null);
    }

    public final void f(P p4) {
        m.e(p4, "listener");
        C1001s0 unused = C0981i.d(this.f9516b, Y.b(), (L) null, new e(this, p4, (V2.d) null), 2, (Object) null);
    }

    public final void g(P p4) {
        m.e(p4, "listener");
        C1001s0 unused = C0981i.d(this.f9516b, Y.b(), (L) null, new f(this, p4, (V2.d) null), 2, (Object) null);
    }
}
