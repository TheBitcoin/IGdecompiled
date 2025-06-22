package u2;

import R2.s;
import V2.d;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.b;
import d3.p;
import g2.L;
import g2.U;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.m;
import o3.C0977g;
import o3.J;
import o3.Y;

/* renamed from: u2.A  reason: case insensitive filesystem */
public final class C2311A {

    /* renamed from: a  reason: collision with root package name */
    private U f21870a;

    /* renamed from: b  reason: collision with root package name */
    private String f21871b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f21872c;

    /* renamed from: u2.A$a */
    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21873a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f21874b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C f21875c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f21876d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f21877e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ C2311A f21878f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Context context, C c5, String str, String str2, C2311A a5, d dVar) {
            super(2, dVar);
            this.f21874b = context;
            this.f21875c = c5;
            this.f21876d = str;
            this.f21877e = str2;
            this.f21878f = a5;
        }

        public final d create(Object obj, d dVar) {
            return new a(this.f21874b, this.f21875c, this.f21876d, this.f21877e, this.f21878f, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:26:0x00da, code lost:
            if (r0.length() > 0) goto L_0x00dc;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x011d, code lost:
            if (r0.length() > 0) goto L_0x00dc;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0140, code lost:
            if (r1.length() > 0) goto L_0x0142;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                W2.b.c()
                int r0 = r4.f21873a
                if (r0 != 0) goto L_0x0152
                R2.n.b(r5)
                r5 = 2131952002(0x7f130182, float:1.9540434E38)
                u2.L r0 = new u2.L     // Catch:{ JSONException -> 0x0077 }
                android.content.Context r1 = r4.f21874b     // Catch:{ JSONException -> 0x0077 }
                r0.<init>(r1)     // Catch:{ JSONException -> 0x0077 }
                kotlin.jvm.internal.C r1 = r4.f21875c     // Catch:{ JSONException -> 0x0077 }
                java.lang.String r2 = r4.f21876d     // Catch:{ JSONException -> 0x0077 }
                java.lang.String r3 = r4.f21877e     // Catch:{ JSONException -> 0x0077 }
                g2.L r0 = r0.g1(r2, r3)     // Catch:{ JSONException -> 0x0077 }
                r1.f20968a = r0     // Catch:{ JSONException -> 0x0077 }
                kotlin.jvm.internal.C r0 = r4.f21875c     // Catch:{ JSONException -> 0x0077 }
                java.lang.Object r0 = r0.f20968a     // Catch:{ JSONException -> 0x0077 }
                kotlin.jvm.internal.m.b(r0)     // Catch:{ JSONException -> 0x0077 }
                g2.L r0 = (g2.L) r0     // Catch:{ JSONException -> 0x0077 }
                org.json.JSONObject r0 = r0.e()     // Catch:{ JSONException -> 0x0077 }
                if (r0 == 0) goto L_0x00af
                kotlin.jvm.internal.C r0 = r4.f21875c     // Catch:{ JSONException -> 0x0077 }
                java.lang.Object r0 = r0.f20968a     // Catch:{ JSONException -> 0x0077 }
                kotlin.jvm.internal.m.b(r0)     // Catch:{ JSONException -> 0x0077 }
                g2.L r0 = (g2.L) r0     // Catch:{ JSONException -> 0x0077 }
                org.json.JSONObject r0 = r0.e()     // Catch:{ JSONException -> 0x0077 }
                kotlin.jvm.internal.m.b(r0)     // Catch:{ JSONException -> 0x0077 }
                java.lang.String r1 = "data"
                org.json.JSONObject r1 = r0.optJSONObject(r1)     // Catch:{ JSONException -> 0x0077 }
                java.lang.String r2 = "success"
                int r2 = r0.optInt(r2)     // Catch:{ JSONException -> 0x0077 }
                r3 = 1
                if (r2 != r3) goto L_0x0094
                if (r1 == 0) goto L_0x0094
                u2.A r0 = r4.f21878f     // Catch:{ JSONException -> 0x0077 }
                g2.U r0 = r0.c()     // Catch:{ JSONException -> 0x0077 }
                kotlin.jvm.internal.m.b(r0)     // Catch:{ JSONException -> 0x0077 }
                android.content.Context r2 = r4.f21874b     // Catch:{ JSONException -> 0x0077 }
                r0.e(r2, r1)     // Catch:{ JSONException -> 0x0077 }
                android.content.Context r2 = r4.f21874b     // Catch:{ JSONException -> 0x0077 }
                r0.p(r2)     // Catch:{ JSONException -> 0x0077 }
                com.uptodown.activities.preferences.a$a r0 = com.uptodown.activities.preferences.a.f18818a     // Catch:{ JSONException -> 0x0077 }
                android.content.Context r2 = r4.f21874b     // Catch:{ JSONException -> 0x0077 }
                java.lang.String r0 = r0.J(r2)     // Catch:{ JSONException -> 0x0077 }
                if (r0 == 0) goto L_0x0079
                int r0 = r0.length()     // Catch:{ JSONException -> 0x0077 }
                if (r0 != 0) goto L_0x00bd
                goto L_0x0079
            L_0x0074:
                r0 = move-exception
                goto L_0x0123
            L_0x0077:
                r0 = move-exception
                goto L_0x00ec
            L_0x0079:
                u2.A r0 = r4.f21878f     // Catch:{ JSONException -> 0x0077 }
                android.content.Context r2 = r4.f21874b     // Catch:{ JSONException -> 0x0077 }
                kotlin.jvm.internal.C r3 = r4.f21875c     // Catch:{ JSONException -> 0x0077 }
                java.lang.Object r3 = r3.f20968a     // Catch:{ JSONException -> 0x0077 }
                kotlin.jvm.internal.m.b(r3)     // Catch:{ JSONException -> 0x0077 }
                g2.L r3 = (g2.L) r3     // Catch:{ JSONException -> 0x0077 }
                java.lang.String r1 = r3.g(r1)     // Catch:{ JSONException -> 0x0077 }
                kotlin.jvm.internal.C r3 = r4.f21875c     // Catch:{ JSONException -> 0x0077 }
                java.lang.Object r3 = r3.f20968a     // Catch:{ JSONException -> 0x0077 }
                g2.L r3 = (g2.L) r3     // Catch:{ JSONException -> 0x0077 }
                r0.h(r2, r1, r3)     // Catch:{ JSONException -> 0x0077 }
                goto L_0x00bd
            L_0x0094:
                u2.A r1 = r4.f21878f     // Catch:{ JSONException -> 0x0077 }
                android.content.Context r2 = r4.f21874b     // Catch:{ JSONException -> 0x0077 }
                kotlin.jvm.internal.C r3 = r4.f21875c     // Catch:{ JSONException -> 0x0077 }
                java.lang.Object r3 = r3.f20968a     // Catch:{ JSONException -> 0x0077 }
                kotlin.jvm.internal.m.b(r3)     // Catch:{ JSONException -> 0x0077 }
                g2.L r3 = (g2.L) r3     // Catch:{ JSONException -> 0x0077 }
                java.lang.String r0 = r3.g(r0)     // Catch:{ JSONException -> 0x0077 }
                kotlin.jvm.internal.C r3 = r4.f21875c     // Catch:{ JSONException -> 0x0077 }
                java.lang.Object r3 = r3.f20968a     // Catch:{ JSONException -> 0x0077 }
                g2.L r3 = (g2.L) r3     // Catch:{ JSONException -> 0x0077 }
                r1.h(r2, r0, r3)     // Catch:{ JSONException -> 0x0077 }
                goto L_0x00bd
            L_0x00af:
                u2.A r0 = r4.f21878f     // Catch:{ JSONException -> 0x0077 }
                android.content.Context r1 = r4.f21874b     // Catch:{ JSONException -> 0x0077 }
                kotlin.jvm.internal.C r2 = r4.f21875c     // Catch:{ JSONException -> 0x0077 }
                java.lang.Object r2 = r2.f20968a     // Catch:{ JSONException -> 0x0077 }
                g2.L r2 = (g2.L) r2     // Catch:{ JSONException -> 0x0077 }
                r3 = 0
                r0.h(r1, r3, r2)     // Catch:{ JSONException -> 0x0077 }
            L_0x00bd:
                u2.A r0 = r4.f21878f
                boolean r0 = r0.e()
                if (r0 == 0) goto L_0x0120
                u2.A r0 = r4.f21878f
                java.lang.String r0 = r0.b()
                if (r0 == 0) goto L_0x00dc
                u2.A r0 = r4.f21878f
                java.lang.String r0 = r0.b()
                kotlin.jvm.internal.m.b(r0)
                int r0 = r0.length()
                if (r0 <= 0) goto L_0x0120
            L_0x00dc:
                u2.A r0 = r4.f21878f
                android.content.Context r1 = r4.f21874b
                android.content.res.Resources r1 = r1.getResources()
                java.lang.String r5 = r1.getString(r5)
                r0.i(r5)
                goto L_0x0120
            L_0x00ec:
                r0.printStackTrace()     // Catch:{ all -> 0x0074 }
                u2.A r1 = r4.f21878f     // Catch:{ all -> 0x0074 }
                android.content.Context r2 = r4.f21874b     // Catch:{ all -> 0x0074 }
                java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0074 }
                kotlin.jvm.internal.C r3 = r4.f21875c     // Catch:{ all -> 0x0074 }
                java.lang.Object r3 = r3.f20968a     // Catch:{ all -> 0x0074 }
                g2.L r3 = (g2.L) r3     // Catch:{ all -> 0x0074 }
                r1.h(r2, r0, r3)     // Catch:{ all -> 0x0074 }
                u2.A r0 = r4.f21878f
                boolean r0 = r0.e()
                if (r0 == 0) goto L_0x0120
                u2.A r0 = r4.f21878f
                java.lang.String r0 = r0.b()
                if (r0 == 0) goto L_0x00dc
                u2.A r0 = r4.f21878f
                java.lang.String r0 = r0.b()
                kotlin.jvm.internal.m.b(r0)
                int r0 = r0.length()
                if (r0 <= 0) goto L_0x0120
                goto L_0x00dc
            L_0x0120:
                R2.s r5 = R2.s.f8222a
                return r5
            L_0x0123:
                u2.A r1 = r4.f21878f
                boolean r1 = r1.e()
                if (r1 == 0) goto L_0x0151
                u2.A r1 = r4.f21878f
                java.lang.String r1 = r1.b()
                if (r1 == 0) goto L_0x0142
                u2.A r1 = r4.f21878f
                java.lang.String r1 = r1.b()
                kotlin.jvm.internal.m.b(r1)
                int r1 = r1.length()
                if (r1 <= 0) goto L_0x0151
            L_0x0142:
                u2.A r1 = r4.f21878f
                android.content.Context r2 = r4.f21874b
                android.content.res.Resources r2 = r2.getResources()
                java.lang.String r5 = r2.getString(r5)
                r1.i(r5)
            L_0x0151:
                throw r0
            L_0x0152:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: u2.C2311A.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, d dVar) {
            return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* access modifiers changed from: private */
    public final void h(Context context, String str, L l4) {
        this.f21872c = true;
        U.f20468m.b(context);
        this.f21870a = null;
        if (str != null) {
            this.f21871b = str;
        }
        Bundle bundle = new Bundle();
        bundle.putString("type", "fail");
        bundle.putString("loginSource", "google");
        if (l4 != null) {
            bundle.putString("responseCode", String.valueOf(l4.f()));
            if (l4.c() != null) {
                String c5 = l4.c();
                m.b(c5);
                bundle.putString("exception", c5);
            }
        }
        new x(context).d("login", bundle);
    }

    public final String b() {
        return this.f21871b;
    }

    public final U c() {
        return this.f21870a;
    }

    public final b d(Context context) {
        m.e(context, "context");
        GoogleSignInOptions a5 = new GoogleSignInOptions.a(GoogleSignInOptions.f1202l).b().d("699621046070-qajra0rrsahiqmumvkg7fagujfd78tm8.apps.googleusercontent.com").a();
        m.d(a5, "build(...)");
        b a6 = com.google.android.gms.auth.api.signin.a.a(context, a5);
        m.d(a6, "getClient(...)");
        return a6;
    }

    public final boolean e() {
        return this.f21872c;
    }

    public final void f(Context context) {
        m.e(context, "context");
        new C2311A().d(context).s();
    }

    public final Object g(String str, String str2, Context context, d dVar) {
        this.f21870a = new U();
        Context context2 = context;
        Object g4 = C0977g.g(Y.b(), new a(context2, new C(), str, str2, this, (d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    public final void i(String str) {
        this.f21871b = str;
    }
}
