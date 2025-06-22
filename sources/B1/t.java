package b1;

import S0.e;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.C2103g;

public final class t {

    /* renamed from: c  reason: collision with root package name */
    public static final a f9043c = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private final String f9044a;

    /* renamed from: b  reason: collision with root package name */
    private final String f9045b;

    public static final class a {

        /* renamed from: b1.t$a$a  reason: collision with other inner class name */
        static final class C0135a extends d {

            /* renamed from: a  reason: collision with root package name */
            Object f9046a;

            /* renamed from: b  reason: collision with root package name */
            /* synthetic */ Object f9047b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ a f9048c;

            /* renamed from: d  reason: collision with root package name */
            int f9049d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0135a(a aVar, V2.d dVar) {
                super(dVar);
                this.f9048c = aVar;
            }

            public final Object invokeSuspend(Object obj) {
                this.f9047b = obj;
                this.f9049d |= Integer.MIN_VALUE;
                return this.f9048c.a((e) null, this);
            }
        }

        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0087, code lost:
            if (r10 != r1) goto L_0x008a;
         */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0048  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object a(S0.e r9, V2.d r10) {
            /*
                r8 = this;
                boolean r0 = r10 instanceof b1.t.a.C0135a
                if (r0 == 0) goto L_0x0013
                r0 = r10
                b1.t$a$a r0 = (b1.t.a.C0135a) r0
                int r1 = r0.f9049d
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.f9049d = r1
                goto L_0x0018
            L_0x0013:
                b1.t$a$a r0 = new b1.t$a$a
                r0.<init>(r8, r10)
            L_0x0018:
                java.lang.Object r10 = r0.f9047b
                java.lang.Object r1 = W2.b.c()
                int r2 = r0.f9049d
                java.lang.String r3 = ""
                java.lang.String r4 = "InstallationId"
                r5 = 2
                r6 = 1
                if (r2 == 0) goto L_0x0048
                if (r2 == r6) goto L_0x003e
                if (r2 != r5) goto L_0x0036
                java.lang.Object r9 = r0.f9046a
                java.lang.String r9 = (java.lang.String) r9
                R2.n.b(r10)     // Catch:{ Exception -> 0x0034 }
                goto L_0x008a
            L_0x0034:
                r10 = move-exception
                goto L_0x0093
            L_0x0036:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L_0x003e:
                java.lang.Object r9 = r0.f9046a
                S0.e r9 = (S0.e) r9
                R2.n.b(r10)     // Catch:{ Exception -> 0x0046 }
                goto L_0x0060
            L_0x0046:
                r10 = move-exception
                goto L_0x006f
            L_0x0048:
                R2.n.b(r10)
                r10 = 0
                k0.l r10 = r9.a(r10)     // Catch:{ Exception -> 0x0046 }
                java.lang.String r2 = "firebaseInstallations.getToken(false)"
                kotlin.jvm.internal.m.d(r10, r2)     // Catch:{ Exception -> 0x0046 }
                r0.f9046a = r9     // Catch:{ Exception -> 0x0046 }
                r0.f9049d = r6     // Catch:{ Exception -> 0x0046 }
                java.lang.Object r10 = y3.b.a(r10, r0)     // Catch:{ Exception -> 0x0046 }
                if (r10 != r1) goto L_0x0060
                goto L_0x0089
            L_0x0060:
                com.google.firebase.installations.g r10 = (com.google.firebase.installations.g) r10     // Catch:{ Exception -> 0x0046 }
                java.lang.String r10 = r10.b()     // Catch:{ Exception -> 0x0046 }
                java.lang.String r2 = "{\n          firebaseInst…).await().token\n        }"
                kotlin.jvm.internal.m.d(r10, r2)     // Catch:{ Exception -> 0x0046 }
                r7 = r10
                r10 = r9
                r9 = r7
                goto L_0x0076
            L_0x006f:
                java.lang.String r2 = "Error getting authentication token."
                android.util.Log.w(r4, r2, r10)
                r10 = r9
                r9 = r3
            L_0x0076:
                k0.l r10 = r10.getId()     // Catch:{ Exception -> 0x0034 }
                java.lang.String r2 = "firebaseInstallations.id"
                kotlin.jvm.internal.m.d(r10, r2)     // Catch:{ Exception -> 0x0034 }
                r0.f9046a = r9     // Catch:{ Exception -> 0x0034 }
                r0.f9049d = r5     // Catch:{ Exception -> 0x0034 }
                java.lang.Object r10 = y3.b.a(r10, r0)     // Catch:{ Exception -> 0x0034 }
                if (r10 != r1) goto L_0x008a
            L_0x0089:
                return r1
            L_0x008a:
                java.lang.String r0 = "{\n          firebaseInst…ions.id.await()\n        }"
                kotlin.jvm.internal.m.d(r10, r0)     // Catch:{ Exception -> 0x0034 }
                java.lang.String r10 = (java.lang.String) r10     // Catch:{ Exception -> 0x0034 }
                r3 = r10
                goto L_0x0098
            L_0x0093:
                java.lang.String r0 = "Error getting Firebase installation id ."
                android.util.Log.w(r4, r0, r10)
            L_0x0098:
                b1.t r10 = new b1.t
                r0 = 0
                r10.<init>(r3, r9, r0)
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: b1.t.a.a(S0.e, V2.d):java.lang.Object");
        }

        private a() {
        }
    }

    public /* synthetic */ t(String str, String str2, C2103g gVar) {
        this(str, str2);
    }

    public final String a() {
        return this.f9045b;
    }

    public final String b() {
        return this.f9044a;
    }

    private t(String str, String str2) {
        this.f9044a = str;
        this.f9045b = str2;
    }
}
