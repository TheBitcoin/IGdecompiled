package d1;

import R2.h;
import R2.s;
import V2.g;
import android.util.Log;
import androidx.datastore.core.DataStore;
import b1.C1619b;
import d3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import m3.j;
import n3.a;
import org.json.JSONObject;
import x3.c;

/* renamed from: d1.c  reason: case insensitive filesystem */
public final class C1877c implements h {

    /* renamed from: g  reason: collision with root package name */
    private static final a f19526g = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private final g f19527a;

    /* renamed from: b  reason: collision with root package name */
    private final S0.e f19528b;

    /* renamed from: c  reason: collision with root package name */
    private final C1619b f19529c;

    /* renamed from: d  reason: collision with root package name */
    private final C1875a f19530d;

    /* renamed from: e  reason: collision with root package name */
    private final R2.g f19531e;

    /* renamed from: f  reason: collision with root package name */
    private final x3.a f19532f = c.b(false, 1, (Object) null);

    /* renamed from: d1.c$a */
    private static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    /* renamed from: d1.c$b */
    static final class b extends n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DataStore f19533a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(DataStore dataStore) {
            super(0);
            this.f19533a = dataStore;
        }

        /* renamed from: a */
        public final g invoke() {
            return new g(this.f19533a);
        }
    }

    /* renamed from: d1.c$c  reason: collision with other inner class name */
    static final class C0242c extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f19534a;

        /* renamed from: b  reason: collision with root package name */
        Object f19535b;

        /* renamed from: c  reason: collision with root package name */
        /* synthetic */ Object f19536c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C1877c f19537d;

        /* renamed from: e  reason: collision with root package name */
        int f19538e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0242c(C1877c cVar, V2.d dVar) {
            super(dVar);
            this.f19537d = cVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f19536c = obj;
            this.f19538e |= Integer.MIN_VALUE;
            return this.f19537d.b(this);
        }
    }

    /* renamed from: d1.c$d */
    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f19539a;

        /* renamed from: b  reason: collision with root package name */
        Object f19540b;

        /* renamed from: c  reason: collision with root package name */
        int f19541c;

        /* renamed from: d  reason: collision with root package name */
        /* synthetic */ Object f19542d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ C1877c f19543e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(C1877c cVar, V2.d dVar) {
            super(2, dVar);
            this.f19543e = cVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            d dVar2 = new d(this.f19543e, dVar);
            dVar2.f19542d = obj;
            return dVar2;
        }

        /* renamed from: i */
        public final Object invoke(JSONObject jSONObject, V2.d dVar) {
            return ((d) create(jSONObject, dVar)).invokeSuspend(s.f8222a);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:38:0x00f1, code lost:
            r8 = r1;
            r1 = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x00fa, code lost:
            if (((java.lang.Integer) r8.f20968a) == null) goto L_0x0117;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x00fc, code lost:
            r12.f19542d = r1;
            r12.f19539a = r0;
            r12.f19540b = null;
            r12.f19541c = 2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0113, code lost:
            if (d1.C1877c.e(r12.f19543e).m((java.lang.Integer) r8.f20968a, r12) != r4) goto L_0x0117;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x011b, code lost:
            if (((java.lang.Double) r1.f20968a) == null) goto L_0x0137;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x011d, code lost:
            r12.f19542d = r0;
            r12.f19539a = null;
            r12.f19540b = null;
            r12.f19541c = 3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0134, code lost:
            if (d1.C1877c.e(r12.f19543e).i((java.lang.Double) r1.f20968a, r12) != r4) goto L_0x0137;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x013b, code lost:
            if (((java.lang.Integer) r0.f20968a) == null) goto L_0x015a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x013d, code lost:
            r12.f19542d = null;
            r12.f19539a = null;
            r12.f19540b = null;
            r12.f19541c = 4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x0154, code lost:
            if (d1.C1877c.e(r12.f19543e).j((java.lang.Integer) r0.f20968a, r12) != r4) goto L_0x0157;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x0157, code lost:
            r13 = R2.s.f8222a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x015a, code lost:
            r13 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x015b, code lost:
            if (r13 != null) goto L_0x017a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x015d, code lost:
            r13 = d1.C1877c.e(r12.f19543e);
            r0 = kotlin.coroutines.jvm.internal.b.b(86400);
            r12.f19542d = null;
            r12.f19539a = null;
            r12.f19540b = null;
            r12.f19541c = 5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x0177, code lost:
            if (r13.j(r0, r12) != r4) goto L_0x017a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x017a, code lost:
            r13 = d1.C1877c.e(r12.f19543e);
            r0 = kotlin.coroutines.jvm.internal.b.c(java.lang.System.currentTimeMillis());
            r12.f19542d = null;
            r12.f19539a = null;
            r12.f19540b = null;
            r12.f19541c = 6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x0195, code lost:
            if (r13.k(r0, r12) != r4) goto L_0x0198;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x0197, code lost:
            return r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x019a, code lost:
            return R2.s.f8222a;
         */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x00d7  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x00f4  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                r12 = this;
                java.lang.String r0 = "cache_duration"
                java.lang.String r1 = "session_timeout_seconds"
                java.lang.String r2 = "sampling_rate"
                java.lang.String r3 = "sessions_enabled"
                java.lang.Object r4 = W2.b.c()
                int r5 = r12.f19541c
                r6 = 0
                switch(r5) {
                    case 0: goto L_0x0050;
                    case 1: goto L_0x003f;
                    case 2: goto L_0x0032;
                    case 3: goto L_0x0029;
                    case 4: goto L_0x0024;
                    case 5: goto L_0x001f;
                    case 6: goto L_0x001a;
                    default: goto L_0x0012;
                }
            L_0x0012:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L_0x001a:
                R2.n.b(r13)
                goto L_0x0198
            L_0x001f:
                R2.n.b(r13)
                goto L_0x017a
            L_0x0024:
                R2.n.b(r13)
                goto L_0x0157
            L_0x0029:
                java.lang.Object r0 = r12.f19542d
                kotlin.jvm.internal.C r0 = (kotlin.jvm.internal.C) r0
                R2.n.b(r13)
                goto L_0x0137
            L_0x0032:
                java.lang.Object r0 = r12.f19539a
                kotlin.jvm.internal.C r0 = (kotlin.jvm.internal.C) r0
                java.lang.Object r1 = r12.f19542d
                kotlin.jvm.internal.C r1 = (kotlin.jvm.internal.C) r1
                R2.n.b(r13)
                goto L_0x0117
            L_0x003f:
                java.lang.Object r0 = r12.f19540b
                kotlin.jvm.internal.C r0 = (kotlin.jvm.internal.C) r0
                java.lang.Object r1 = r12.f19539a
                kotlin.jvm.internal.C r1 = (kotlin.jvm.internal.C) r1
                java.lang.Object r2 = r12.f19542d
                kotlin.jvm.internal.C r2 = (kotlin.jvm.internal.C) r2
                R2.n.b(r13)
                goto L_0x00f1
            L_0x0050:
                R2.n.b(r13)
                java.lang.Object r13 = r12.f19542d
                org.json.JSONObject r13 = (org.json.JSONObject) r13
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r7 = "Fetched settings: "
                r5.append(r7)
                r5.append(r13)
                java.lang.String r5 = r5.toString()
                java.lang.String r7 = "SessionConfigFetcher"
                android.util.Log.d(r7, r5)
                kotlin.jvm.internal.C r5 = new kotlin.jvm.internal.C
                r5.<init>()
                kotlin.jvm.internal.C r8 = new kotlin.jvm.internal.C
                r8.<init>()
                kotlin.jvm.internal.C r9 = new kotlin.jvm.internal.C
                r9.<init>()
                java.lang.String r10 = "app_quality"
                boolean r11 = r13.has(r10)
                if (r11 == 0) goto L_0x00d4
                java.lang.Object r13 = r13.get(r10)
                java.lang.String r10 = "null cannot be cast to non-null type org.json.JSONObject"
                kotlin.jvm.internal.m.c(r13, r10)
                org.json.JSONObject r13 = (org.json.JSONObject) r13
                boolean r10 = r13.has(r3)     // Catch:{ JSONException -> 0x009c }
                if (r10 == 0) goto L_0x009f
                java.lang.Object r3 = r13.get(r3)     // Catch:{ JSONException -> 0x009c }
                java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ JSONException -> 0x009c }
                goto L_0x00a0
            L_0x009c:
                r13 = move-exception
                r3 = r6
                goto L_0x00ce
            L_0x009f:
                r3 = r6
            L_0x00a0:
                boolean r10 = r13.has(r2)     // Catch:{ JSONException -> 0x00af }
                if (r10 == 0) goto L_0x00b1
                java.lang.Object r2 = r13.get(r2)     // Catch:{ JSONException -> 0x00af }
                java.lang.Double r2 = (java.lang.Double) r2     // Catch:{ JSONException -> 0x00af }
                r5.f20968a = r2     // Catch:{ JSONException -> 0x00af }
                goto L_0x00b1
            L_0x00af:
                r13 = move-exception
                goto L_0x00ce
            L_0x00b1:
                boolean r2 = r13.has(r1)     // Catch:{ JSONException -> 0x00af }
                if (r2 == 0) goto L_0x00bf
                java.lang.Object r1 = r13.get(r1)     // Catch:{ JSONException -> 0x00af }
                java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ JSONException -> 0x00af }
                r8.f20968a = r1     // Catch:{ JSONException -> 0x00af }
            L_0x00bf:
                boolean r1 = r13.has(r0)     // Catch:{ JSONException -> 0x00af }
                if (r1 == 0) goto L_0x00d5
                java.lang.Object r13 = r13.get(r0)     // Catch:{ JSONException -> 0x00af }
                java.lang.Integer r13 = (java.lang.Integer) r13     // Catch:{ JSONException -> 0x00af }
                r9.f20968a = r13     // Catch:{ JSONException -> 0x00af }
                goto L_0x00d5
            L_0x00ce:
                java.lang.String r0 = "Error parsing the configs remotely fetched: "
                android.util.Log.e(r7, r0, r13)
                goto L_0x00d5
            L_0x00d4:
                r3 = r6
            L_0x00d5:
                if (r3 == 0) goto L_0x00f4
                d1.c r13 = r12.f19543e
                d1.g r13 = r13.f()
                r12.f19542d = r5
                r12.f19539a = r8
                r12.f19540b = r9
                r0 = 1
                r12.f19541c = r0
                java.lang.Object r13 = r13.n(r3, r12)
                if (r13 != r4) goto L_0x00ee
                goto L_0x0197
            L_0x00ee:
                r2 = r5
                r1 = r8
                r0 = r9
            L_0x00f1:
                r8 = r1
                r1 = r2
                goto L_0x00f6
            L_0x00f4:
                r1 = r5
                r0 = r9
            L_0x00f6:
                java.lang.Object r13 = r8.f20968a
                java.lang.Integer r13 = (java.lang.Integer) r13
                if (r13 == 0) goto L_0x0117
                d1.c r13 = r12.f19543e
                d1.g r13 = r13.f()
                java.lang.Object r2 = r8.f20968a
                java.lang.Integer r2 = (java.lang.Integer) r2
                r12.f19542d = r1
                r12.f19539a = r0
                r12.f19540b = r6
                r3 = 2
                r12.f19541c = r3
                java.lang.Object r13 = r13.m(r2, r12)
                if (r13 != r4) goto L_0x0117
                goto L_0x0197
            L_0x0117:
                java.lang.Object r13 = r1.f20968a
                java.lang.Double r13 = (java.lang.Double) r13
                if (r13 == 0) goto L_0x0137
                d1.c r13 = r12.f19543e
                d1.g r13 = r13.f()
                java.lang.Object r1 = r1.f20968a
                java.lang.Double r1 = (java.lang.Double) r1
                r12.f19542d = r0
                r12.f19539a = r6
                r12.f19540b = r6
                r2 = 3
                r12.f19541c = r2
                java.lang.Object r13 = r13.i(r1, r12)
                if (r13 != r4) goto L_0x0137
                goto L_0x0197
            L_0x0137:
                java.lang.Object r13 = r0.f20968a
                java.lang.Integer r13 = (java.lang.Integer) r13
                if (r13 == 0) goto L_0x015a
                d1.c r13 = r12.f19543e
                d1.g r13 = r13.f()
                java.lang.Object r0 = r0.f20968a
                java.lang.Integer r0 = (java.lang.Integer) r0
                r12.f19542d = r6
                r12.f19539a = r6
                r12.f19540b = r6
                r1 = 4
                r12.f19541c = r1
                java.lang.Object r13 = r13.j(r0, r12)
                if (r13 != r4) goto L_0x0157
                goto L_0x0197
            L_0x0157:
                R2.s r13 = R2.s.f8222a
                goto L_0x015b
            L_0x015a:
                r13 = r6
            L_0x015b:
                if (r13 != 0) goto L_0x017a
                d1.c r13 = r12.f19543e
                d1.g r13 = r13.f()
                r0 = 86400(0x15180, float:1.21072E-40)
                java.lang.Integer r0 = kotlin.coroutines.jvm.internal.b.b(r0)
                r12.f19542d = r6
                r12.f19539a = r6
                r12.f19540b = r6
                r1 = 5
                r12.f19541c = r1
                java.lang.Object r13 = r13.j(r0, r12)
                if (r13 != r4) goto L_0x017a
                goto L_0x0197
            L_0x017a:
                d1.c r13 = r12.f19543e
                d1.g r13 = r13.f()
                long r0 = java.lang.System.currentTimeMillis()
                java.lang.Long r0 = kotlin.coroutines.jvm.internal.b.c(r0)
                r12.f19542d = r6
                r12.f19539a = r6
                r12.f19540b = r6
                r1 = 6
                r12.f19541c = r1
                java.lang.Object r13 = r13.k(r0, r12)
                if (r13 != r4) goto L_0x0198
            L_0x0197:
                return r4
            L_0x0198:
                R2.s r13 = R2.s.f8222a
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: d1.C1877c.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* renamed from: d1.c$e */
    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19544a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f19545b;

        e(V2.d dVar) {
            super(2, dVar);
        }

        public final V2.d create(Object obj, V2.d dVar) {
            e eVar = new e(dVar);
            eVar.f19545b = obj;
            return eVar;
        }

        /* renamed from: i */
        public final Object invoke(String str, V2.d dVar) {
            return ((e) create(str, dVar)).invokeSuspend(s.f8222a);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f19544a == 0) {
                R2.n.b(obj);
                Log.e("SessionConfigFetcher", "Error failing to fetch the remote configs: " + ((String) this.f19545b));
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public C1877c(g gVar, S0.e eVar, C1619b bVar, C1875a aVar, DataStore dataStore) {
        m.e(gVar, "backgroundDispatcher");
        m.e(eVar, "firebaseInstallationsApi");
        m.e(bVar, "appInfo");
        m.e(aVar, "configsFetcher");
        m.e(dataStore, "dataStore");
        this.f19527a = gVar;
        this.f19528b = eVar;
        this.f19529c = bVar;
        this.f19530d = aVar;
        this.f19531e = h.a(new b(dataStore));
    }

    /* access modifiers changed from: private */
    public final g f() {
        return (g) this.f19531e.getValue();
    }

    private final String g(String str) {
        return new j("/").g(str, "");
    }

    public Boolean a() {
        return f().g();
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0097 A[Catch:{ all -> 0x0053 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a2 A[SYNTHETIC, Splitter:B:38:0x00a2] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c2 A[Catch:{ all -> 0x0053 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object b(V2.d r18) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            boolean r6 = r0 instanceof d1.C1877c.C0242c
            if (r6 == 0) goto L_0x001b
            r6 = r0
            d1.c$c r6 = (d1.C1877c.C0242c) r6
            int r7 = r6.f19538e
            r8 = -2147483648(0xffffffff80000000, float:-0.0)
            r9 = r7 & r8
            if (r9 == 0) goto L_0x001b
            int r7 = r7 - r8
            r6.f19538e = r7
            goto L_0x0020
        L_0x001b:
            d1.c$c r6 = new d1.c$c
            r6.<init>(r1, r0)
        L_0x0020:
            java.lang.Object r0 = r6.f19536c
            java.lang.Object r7 = W2.b.c()
            int r8 = r6.f19538e
            java.lang.String r9 = "SessionConfigFetcher"
            r10 = 0
            if (r8 == 0) goto L_0x0063
            if (r8 == r5) goto L_0x0057
            if (r8 == r4) goto L_0x0047
            if (r8 != r3) goto L_0x003f
            java.lang.Object r2 = r6.f19534a
            x3.a r2 = (x3.a) r2
            R2.n.b(r0)     // Catch:{ all -> 0x003c }
            goto L_0x0159
        L_0x003c:
            r0 = move-exception
            goto L_0x0161
        L_0x003f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0047:
            java.lang.Object r8 = r6.f19535b
            x3.a r8 = (x3.a) r8
            java.lang.Object r11 = r6.f19534a
            d1.c r11 = (d1.C1877c) r11
            R2.n.b(r0)     // Catch:{ all -> 0x0053 }
            goto L_0x00b4
        L_0x0053:
            r0 = move-exception
            r2 = r8
            goto L_0x0161
        L_0x0057:
            java.lang.Object r8 = r6.f19535b
            x3.a r8 = (x3.a) r8
            java.lang.Object r11 = r6.f19534a
            d1.c r11 = (d1.C1877c) r11
            R2.n.b(r0)
            goto L_0x008d
        L_0x0063:
            R2.n.b(r0)
            x3.a r0 = r1.f19532f
            boolean r0 = r0.b()
            if (r0 != 0) goto L_0x007b
            d1.g r0 = r1.f()
            boolean r0 = r0.d()
            if (r0 != 0) goto L_0x007b
            R2.s r0 = R2.s.f8222a
            return r0
        L_0x007b:
            x3.a r0 = r1.f19532f
            r6.f19534a = r1
            r6.f19535b = r0
            r6.f19538e = r5
            java.lang.Object r8 = r0.c(r10, r6)
            if (r8 != r7) goto L_0x008b
            goto L_0x0157
        L_0x008b:
            r8 = r0
            r11 = r1
        L_0x008d:
            d1.g r0 = r11.f()     // Catch:{ all -> 0x0053 }
            boolean r0 = r0.d()     // Catch:{ all -> 0x0053 }
            if (r0 != 0) goto L_0x00a2
            java.lang.String r0 = "Remote settings cache not expired. Using cached values."
            android.util.Log.d(r9, r0)     // Catch:{ all -> 0x0053 }
            R2.s r0 = R2.s.f8222a     // Catch:{ all -> 0x0053 }
            r8.d(r10)
            return r0
        L_0x00a2:
            b1.t$a r0 = b1.t.f9043c     // Catch:{ all -> 0x0053 }
            S0.e r12 = r11.f19528b     // Catch:{ all -> 0x0053 }
            r6.f19534a = r11     // Catch:{ all -> 0x0053 }
            r6.f19535b = r8     // Catch:{ all -> 0x0053 }
            r6.f19538e = r4     // Catch:{ all -> 0x0053 }
            java.lang.Object r0 = r0.a(r12, r6)     // Catch:{ all -> 0x0053 }
            if (r0 != r7) goto L_0x00b4
            goto L_0x0157
        L_0x00b4:
            b1.t r0 = (b1.t) r0     // Catch:{ all -> 0x0053 }
            java.lang.String r0 = r0.b()     // Catch:{ all -> 0x0053 }
            java.lang.String r12 = ""
            boolean r12 = kotlin.jvm.internal.m.a(r0, r12)     // Catch:{ all -> 0x0053 }
            if (r12 == 0) goto L_0x00cd
            java.lang.String r0 = "Error getting Firebase Installation ID. Skipping this Session Event."
            android.util.Log.w(r9, r0)     // Catch:{ all -> 0x0053 }
            R2.s r0 = R2.s.f8222a     // Catch:{ all -> 0x0053 }
            r8.d(r10)
            return r0
        L_0x00cd:
            java.lang.String r12 = "X-Crashlytics-Installation-ID"
            R2.l r0 = R2.p.a(r12, r0)     // Catch:{ all -> 0x0053 }
            java.lang.String r12 = "X-Crashlytics-Device-Model"
            kotlin.jvm.internal.F r13 = kotlin.jvm.internal.F.f20971a     // Catch:{ all -> 0x0053 }
            java.lang.String r13 = "%s/%s"
            java.lang.Object[] r14 = new java.lang.Object[r4]     // Catch:{ all -> 0x0053 }
            java.lang.String r15 = android.os.Build.MANUFACTURER     // Catch:{ all -> 0x0053 }
            r14[r2] = r15     // Catch:{ all -> 0x0053 }
            java.lang.String r15 = android.os.Build.MODEL     // Catch:{ all -> 0x0053 }
            r14[r5] = r15     // Catch:{ all -> 0x0053 }
            java.lang.Object[] r14 = java.util.Arrays.copyOf(r14, r4)     // Catch:{ all -> 0x0053 }
            java.lang.String r13 = java.lang.String.format(r13, r14)     // Catch:{ all -> 0x0053 }
            java.lang.String r14 = "format(format, *args)"
            kotlin.jvm.internal.m.d(r13, r14)     // Catch:{ all -> 0x0053 }
            java.lang.String r13 = r11.g(r13)     // Catch:{ all -> 0x0053 }
            R2.l r12 = R2.p.a(r12, r13)     // Catch:{ all -> 0x0053 }
            java.lang.String r13 = "X-Crashlytics-OS-Build-Version"
            java.lang.String r14 = android.os.Build.VERSION.INCREMENTAL     // Catch:{ all -> 0x0053 }
            java.lang.String r15 = "INCREMENTAL"
            kotlin.jvm.internal.m.d(r14, r15)     // Catch:{ all -> 0x0053 }
            java.lang.String r14 = r11.g(r14)     // Catch:{ all -> 0x0053 }
            R2.l r13 = R2.p.a(r13, r14)     // Catch:{ all -> 0x0053 }
            java.lang.String r14 = "X-Crashlytics-OS-Display-Version"
            java.lang.String r15 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x0053 }
            r16 = 0
            java.lang.String r2 = "RELEASE"
            kotlin.jvm.internal.m.d(r15, r2)     // Catch:{ all -> 0x0053 }
            java.lang.String r2 = r11.g(r15)     // Catch:{ all -> 0x0053 }
            R2.l r2 = R2.p.a(r14, r2)     // Catch:{ all -> 0x0053 }
            java.lang.String r14 = "X-Crashlytics-API-Client-Version"
            b1.b r15 = r11.f19529c     // Catch:{ all -> 0x0053 }
            java.lang.String r15 = r15.f()     // Catch:{ all -> 0x0053 }
            R2.l r14 = R2.p.a(r14, r15)     // Catch:{ all -> 0x0053 }
            r15 = 5
            R2.l[] r15 = new R2.l[r15]     // Catch:{ all -> 0x0053 }
            r15[r16] = r0     // Catch:{ all -> 0x0053 }
            r15[r5] = r12     // Catch:{ all -> 0x0053 }
            r15[r4] = r13     // Catch:{ all -> 0x0053 }
            r15[r3] = r2     // Catch:{ all -> 0x0053 }
            r0 = 4
            r15[r0] = r14     // Catch:{ all -> 0x0053 }
            java.util.Map r0 = S2.H.j(r15)     // Catch:{ all -> 0x0053 }
            java.lang.String r2 = "Fetching settings from server."
            android.util.Log.d(r9, r2)     // Catch:{ all -> 0x0053 }
            d1.a r2 = r11.f19530d     // Catch:{ all -> 0x0053 }
            d1.c$d r4 = new d1.c$d     // Catch:{ all -> 0x0053 }
            r4.<init>(r11, r10)     // Catch:{ all -> 0x0053 }
            d1.c$e r5 = new d1.c$e     // Catch:{ all -> 0x0053 }
            r5.<init>(r10)     // Catch:{ all -> 0x0053 }
            r6.f19534a = r8     // Catch:{ all -> 0x0053 }
            r6.f19535b = r10     // Catch:{ all -> 0x0053 }
            r6.f19538e = r3     // Catch:{ all -> 0x0053 }
            java.lang.Object r0 = r2.a(r0, r4, r5, r6)     // Catch:{ all -> 0x0053 }
            if (r0 != r7) goto L_0x0158
        L_0x0157:
            return r7
        L_0x0158:
            r2 = r8
        L_0x0159:
            R2.s r0 = R2.s.f8222a     // Catch:{ all -> 0x003c }
            r2.d(r10)
            R2.s r0 = R2.s.f8222a
            return r0
        L_0x0161:
            r2.d(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: d1.C1877c.b(V2.d):java.lang.Object");
    }

    public n3.a c() {
        Integer e5 = f().e();
        if (e5 == null) {
            return null;
        }
        a.C0266a aVar = n3.a.f21358b;
        return n3.a.c(n3.c.h(e5.intValue(), n3.d.SECONDS));
    }

    public Double d() {
        return f().f();
    }
}
