package d1;

import R2.s;
import V2.g;
import android.net.Uri;
import b1.C1619b;
import d3.p;
import java.net.URL;
import java.util.Map;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import o3.C0977g;
import o3.J;

public final class d implements C1875a {

    /* renamed from: d  reason: collision with root package name */
    public static final a f19546d = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private final C1619b f19547a;

    /* renamed from: b  reason: collision with root package name */
    private final g f19548b;

    /* renamed from: c  reason: collision with root package name */
    private final String f19549c;

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19550a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f19551b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Map f19552c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ p f19553d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ p f19554e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(d dVar, Map map, p pVar, p pVar2, V2.d dVar2) {
            super(2, dVar2);
            this.f19551b = dVar;
            this.f19552c = map;
            this.f19553d = pVar;
            this.f19554e = pVar2;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new b(this.f19551b, this.f19552c, this.f19553d, this.f19554e, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:27:0x00cb, code lost:
            if (r8.invoke(r1, r7) == r0) goto L_0x00e2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x00e0, code lost:
            if (r1.invoke(r3, r7) != r0) goto L_0x00e3;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r7.f19550a
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L_0x0026
                if (r1 == r4) goto L_0x001e
                if (r1 == r3) goto L_0x001e
                if (r1 != r2) goto L_0x0016
                R2.n.b(r8)
                goto L_0x00e3
            L_0x0016:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L_0x001e:
                R2.n.b(r8)     // Catch:{ Exception -> 0x0023 }
                goto L_0x00e3
            L_0x0023:
                r8 = move-exception
                goto L_0x00ce
            L_0x0026:
                R2.n.b(r8)
                d1.d r8 = r7.f19551b     // Catch:{ Exception -> 0x0023 }
                java.net.URL r8 = r8.c()     // Catch:{ Exception -> 0x0023 }
                java.net.URLConnection r8 = r8.openConnection()     // Catch:{ Exception -> 0x0023 }
                java.lang.String r1 = "null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection"
                kotlin.jvm.internal.m.c(r8, r1)     // Catch:{ Exception -> 0x0023 }
                javax.net.ssl.HttpsURLConnection r8 = (javax.net.ssl.HttpsURLConnection) r8     // Catch:{ Exception -> 0x0023 }
                java.lang.String r1 = "GET"
                r8.setRequestMethod(r1)     // Catch:{ Exception -> 0x0023 }
                java.lang.String r1 = "Accept"
                java.lang.String r5 = "application/json"
                r8.setRequestProperty(r1, r5)     // Catch:{ Exception -> 0x0023 }
                java.util.Map r1 = r7.f19552c     // Catch:{ Exception -> 0x0023 }
                java.util.Set r1 = r1.entrySet()     // Catch:{ Exception -> 0x0023 }
                java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x0023 }
            L_0x0050:
                boolean r5 = r1.hasNext()     // Catch:{ Exception -> 0x0023 }
                if (r5 == 0) goto L_0x006c
                java.lang.Object r5 = r1.next()     // Catch:{ Exception -> 0x0023 }
                java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch:{ Exception -> 0x0023 }
                java.lang.Object r6 = r5.getKey()     // Catch:{ Exception -> 0x0023 }
                java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x0023 }
                java.lang.Object r5 = r5.getValue()     // Catch:{ Exception -> 0x0023 }
                java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0023 }
                r8.setRequestProperty(r6, r5)     // Catch:{ Exception -> 0x0023 }
                goto L_0x0050
            L_0x006c:
                int r1 = r8.getResponseCode()     // Catch:{ Exception -> 0x0023 }
                r5 = 200(0xc8, float:2.8E-43)
                if (r1 != r5) goto L_0x00b2
                java.io.InputStream r8 = r8.getInputStream()     // Catch:{ Exception -> 0x0023 }
                java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0023 }
                java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0023 }
                r3.<init>(r8)     // Catch:{ Exception -> 0x0023 }
                r1.<init>(r3)     // Catch:{ Exception -> 0x0023 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0023 }
                r3.<init>()     // Catch:{ Exception -> 0x0023 }
                kotlin.jvm.internal.C r5 = new kotlin.jvm.internal.C     // Catch:{ Exception -> 0x0023 }
                r5.<init>()     // Catch:{ Exception -> 0x0023 }
            L_0x008c:
                java.lang.String r6 = r1.readLine()     // Catch:{ Exception -> 0x0023 }
                r5.f20968a = r6     // Catch:{ Exception -> 0x0023 }
                if (r6 == 0) goto L_0x0098
                r3.append(r6)     // Catch:{ Exception -> 0x0023 }
                goto L_0x008c
            L_0x0098:
                r1.close()     // Catch:{ Exception -> 0x0023 }
                r8.close()     // Catch:{ Exception -> 0x0023 }
                org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ Exception -> 0x0023 }
                java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x0023 }
                r8.<init>(r1)     // Catch:{ Exception -> 0x0023 }
                d3.p r1 = r7.f19553d     // Catch:{ Exception -> 0x0023 }
                r7.f19550a = r4     // Catch:{ Exception -> 0x0023 }
                java.lang.Object r8 = r1.invoke(r8, r7)     // Catch:{ Exception -> 0x0023 }
                if (r8 != r0) goto L_0x00e3
                goto L_0x00e2
            L_0x00b2:
                d3.p r8 = r7.f19554e     // Catch:{ Exception -> 0x0023 }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0023 }
                r4.<init>()     // Catch:{ Exception -> 0x0023 }
                java.lang.String r5 = "Bad response code: "
                r4.append(r5)     // Catch:{ Exception -> 0x0023 }
                r4.append(r1)     // Catch:{ Exception -> 0x0023 }
                java.lang.String r1 = r4.toString()     // Catch:{ Exception -> 0x0023 }
                r7.f19550a = r3     // Catch:{ Exception -> 0x0023 }
                java.lang.Object r8 = r8.invoke(r1, r7)     // Catch:{ Exception -> 0x0023 }
                if (r8 != r0) goto L_0x00e3
                goto L_0x00e2
            L_0x00ce:
                d3.p r1 = r7.f19554e
                java.lang.String r3 = r8.getMessage()
                if (r3 != 0) goto L_0x00da
                java.lang.String r3 = r8.toString()
            L_0x00da:
                r7.f19550a = r2
                java.lang.Object r8 = r1.invoke(r3, r7)
                if (r8 != r0) goto L_0x00e3
            L_0x00e2:
                return r0
            L_0x00e3:
                R2.s r8 = R2.s.f8222a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: d1.d.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public d(C1619b bVar, g gVar, String str) {
        m.e(bVar, "appInfo");
        m.e(gVar, "blockingDispatcher");
        m.e(str, "baseUrl");
        this.f19547a = bVar;
        this.f19548b = gVar;
        this.f19549c = str;
    }

    /* access modifiers changed from: private */
    public final URL c() {
        return new URL(new Uri.Builder().scheme("https").authority(this.f19549c).appendPath("spi").appendPath("v2").appendPath("platforms").appendPath("android").appendPath("gmp").appendPath(this.f19547a.b()).appendPath("settings").appendQueryParameter("build_version", this.f19547a.a().a()).appendQueryParameter("display_version", this.f19547a.a().f()).build().toString());
    }

    public Object a(Map map, p pVar, p pVar2, V2.d dVar) {
        Object g4 = C0977g.g(this.f19548b, new b(this, map, pVar, pVar2, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(C1619b bVar, g gVar, String str, int i4, C2103g gVar2) {
        this(bVar, gVar, (i4 & 4) != 0 ? "firebase-settings.crashlytics.com" : str);
    }
}
