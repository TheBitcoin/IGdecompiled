package g2;

import R2.n;
import R2.s;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Spanned;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.uptodown.activities.preferences.a;
import d3.p;
import java.util.ArrayList;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.A;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import o3.J;
import org.json.JSONArray;
import org.json.JSONObject;
import u2.F;
import u2.L;

public final class N implements Parcelable {
    public static Parcelable.Creator<N> CREATOR = new a();

    /* renamed from: o  reason: collision with root package name */
    public static final b f20413o = new b((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private long f20414a;

    /* renamed from: b  reason: collision with root package name */
    private String f20415b;

    /* renamed from: c  reason: collision with root package name */
    private String f20416c;

    /* renamed from: d  reason: collision with root package name */
    private String f20417d;

    /* renamed from: e  reason: collision with root package name */
    private long f20418e;

    /* renamed from: f  reason: collision with root package name */
    private String f20419f;

    /* renamed from: g  reason: collision with root package name */
    private int f20420g;

    /* renamed from: h  reason: collision with root package name */
    private int f20421h;

    /* renamed from: i  reason: collision with root package name */
    private String f20422i;

    /* renamed from: j  reason: collision with root package name */
    private int f20423j;

    /* renamed from: k  reason: collision with root package name */
    private int f20424k;

    /* renamed from: l  reason: collision with root package name */
    private String f20425l;

    /* renamed from: m  reason: collision with root package name */
    private int f20426m;

    /* renamed from: n  reason: collision with root package name */
    private String f20427n;

    public static final class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public N createFromParcel(Parcel parcel) {
            m.e(parcel, "source");
            return new N(parcel);
        }

        /* renamed from: b */
        public N[] newArray(int i4) {
            return new N[i4];
        }
    }

    public static final class b {

        static final class a extends d {

            /* renamed from: a  reason: collision with root package name */
            Object f20428a;

            /* renamed from: b  reason: collision with root package name */
            /* synthetic */ Object f20429b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ b f20430c;

            /* renamed from: d  reason: collision with root package name */
            int f20431d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(b bVar, V2.d dVar) {
                super(dVar);
                this.f20430c = bVar;
            }

            public final Object invokeSuspend(Object obj) {
                this.f20429b = obj;
                this.f20431d |= Integer.MIN_VALUE;
                return this.f20430c.c((N) null, (Context) null, this);
            }
        }

        /* renamed from: g2.N$b$b  reason: collision with other inner class name */
        static final class C0248b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f20432a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Context f20433b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ N f20434c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ A f20435d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0248b(Context context, N n4, A a5, V2.d dVar) {
                super(2, dVar);
                this.f20433b = context;
                this.f20434c = n4;
                this.f20435d = a5;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new C0248b(this.f20433b, this.f20434c, this.f20435d, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f20432a == 0) {
                    n.b(obj);
                    L H02 = new L(this.f20433b).H0(this.f20434c.f());
                    if (!H02.b() && H02.e() != null) {
                        JSONObject e5 = H02.e();
                        m.b(e5);
                        if (!e5.isNull("success")) {
                            this.f20435d.f20966a = e5.optInt("success");
                        }
                        if (this.f20435d.f20966a == 1) {
                            int g4 = this.f20434c.g();
                            this.f20434c.v(g4 + 1);
                            kotlin.coroutines.jvm.internal.b.b(g4);
                        } else {
                            F.f21886a.m(this.f20434c.f());
                        }
                    }
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((C0248b) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        public /* synthetic */ b(C2103g gVar) {
            this();
        }

        public final N a(JSONObject jSONObject) {
            m.e(jSONObject, "jsonObject");
            N n4 = new N();
            if (!jSONObject.isNull("id")) {
                n4.u(jSONObject.optLong("id"));
            }
            if (!jSONObject.isNull("userID")) {
                n4.A(jSONObject.optString("userID"));
                if (!jSONObject.isNull("userName")) {
                    n4.B(jSONObject.optString("userName"));
                }
                if (!jSONObject.isNull("userAvatar")) {
                    n4.t(jSONObject.optString("userAvatar"));
                }
            }
            if (!jSONObject.isNull(MimeTypes.BASE_TYPE_TEXT)) {
                n4.x(jSONObject.optString(MimeTypes.BASE_TYPE_TEXT));
            }
            if (!jSONObject.isNull(CampaignEx.JSON_KEY_STAR)) {
                n4.w(jSONObject.optInt(CampaignEx.JSON_KEY_STAR));
            }
            if (!jSONObject.isNull("totalAnswers")) {
                n4.p(jSONObject.optInt("totalAnswers"));
            }
            if (!jSONObject.isNull("timeAgo")) {
                n4.y(jSONObject.optString("timeAgo"));
            }
            if (!jSONObject.isNull("likes")) {
                n4.v(jSONObject.optInt("likes"));
            }
            if (!jSONObject.isNull("isAuthorVerified")) {
                n4.s(jSONObject.optInt("isAuthorVerified"));
            }
            if (!jSONObject.isNull("isTurbo")) {
                n4.z(jSONObject.optInt("isTurbo"));
            }
            if (!jSONObject.isNull("usernameFormat")) {
                n4.C(jSONObject.optString("usernameFormat"));
            }
            return n4;
        }

        public final boolean b(Context context, String str) {
            if (context != null) {
                a.C0236a aVar = com.uptodown.activities.preferences.a.f18818a;
                String s4 = aVar.s(context);
                String t4 = aVar.t(context);
                if (t4 == null) {
                    t4 = "0";
                }
                if (str == null || !m3.m.p(str, s4, true) || System.currentTimeMillis() - Long.parseLong(t4) >= 600000) {
                    return false;
                }
                return true;
            }
            return false;
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object c(g2.N r7, android.content.Context r8, V2.d r9) {
            /*
                r6 = this;
                boolean r0 = r9 instanceof g2.N.b.a
                if (r0 == 0) goto L_0x0013
                r0 = r9
                g2.N$b$a r0 = (g2.N.b.a) r0
                int r1 = r0.f20431d
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.f20431d = r1
                goto L_0x0018
            L_0x0013:
                g2.N$b$a r0 = new g2.N$b$a
                r0.<init>(r6, r9)
            L_0x0018:
                java.lang.Object r9 = r0.f20429b
                java.lang.Object r1 = W2.b.c()
                int r2 = r0.f20431d
                r3 = 1
                if (r2 == 0) goto L_0x0035
                if (r2 != r3) goto L_0x002d
                java.lang.Object r7 = r0.f20428a
                kotlin.jvm.internal.A r7 = (kotlin.jvm.internal.A) r7
                R2.n.b(r9)
                goto L_0x005c
            L_0x002d:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L_0x0035:
                R2.n.b(r9)
                u2.F r9 = u2.F.f21886a
                long r4 = r7.f()
                r9.c(r4)
                kotlin.jvm.internal.A r9 = new kotlin.jvm.internal.A
                r9.<init>()
                o3.G r2 = o3.Y.b()
                g2.N$b$b r4 = new g2.N$b$b
                r5 = 0
                r4.<init>(r8, r7, r9, r5)
                r0.f20428a = r9
                r0.f20431d = r3
                java.lang.Object r7 = o3.C0977g.g(r2, r4, r0)
                if (r7 != r1) goto L_0x005b
                return r1
            L_0x005b:
                r7 = r9
            L_0x005c:
                int r7 = r7.f20966a
                java.lang.Integer r7 = kotlin.coroutines.jvm.internal.b.b(r7)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: g2.N.b.c(g2.N, android.content.Context, V2.d):java.lang.Object");
        }

        public final void d(N n4, JSONObject jSONObject) {
            m.e(n4, "<this>");
            m.e(jSONObject, "jsonObject");
            if (!jSONObject.isNull(CampaignEx.JSON_KEY_STAR)) {
                n4.w(jSONObject.optInt(CampaignEx.JSON_KEY_STAR));
            }
            if (!jSONObject.isNull(MimeTypes.BASE_TYPE_TEXT)) {
                n4.x(jSONObject.optString(MimeTypes.BASE_TYPE_TEXT));
            }
        }

        public final ArrayList e(JSONArray jSONArray) {
            m.e(jSONArray, "jsonArray");
            ArrayList arrayList = new ArrayList();
            try {
                int length = jSONArray.length();
                for (int i4 = 0; i4 < length; i4++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i4);
                    m.d(optJSONObject, "optJSONObject(...)");
                    arrayList.add(a(optJSONObject));
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            return arrayList;
        }

        public final void f(Context context, String str, String str2) {
            if (context != null) {
                if (!(str == null || str.length() == 0)) {
                    com.uptodown.activities.preferences.a.f18818a.P0(context, str);
                }
                if (str2 != null && str2.length() != 0) {
                    com.uptodown.activities.preferences.a.f18818a.Q0(context, str2);
                }
            }
        }

        public final N g(JSONObject jSONObject) {
            m.e(jSONObject, "jsonObject");
            N n4 = new N();
            if (!jSONObject.isNull("id")) {
                n4.u(jSONObject.optLong("id"));
            }
            if (!jSONObject.isNull("appName")) {
                n4.r(jSONObject.optString("appName"));
            }
            if (!jSONObject.isNull("appID")) {
                n4.q(jSONObject.optLong("appID"));
            }
            if (!jSONObject.isNull("appIcon")) {
                n4.t(jSONObject.optString("appIcon"));
            }
            if (!jSONObject.isNull(MimeTypes.BASE_TYPE_TEXT)) {
                n4.x(jSONObject.optString(MimeTypes.BASE_TYPE_TEXT));
            }
            if (!jSONObject.isNull("rate")) {
                n4.w(jSONObject.optInt("rate"));
            }
            if (!jSONObject.isNull("publishedDate")) {
                n4.y(jSONObject.optString("publishedDate"));
            }
            if (!jSONObject.isNull("likes")) {
                n4.v(jSONObject.optInt("likes"));
            }
            if (!jSONObject.isNull("isTurbo")) {
                n4.z(jSONObject.optInt("isTurbo"));
            }
            if (!jSONObject.isNull("usernameFormat")) {
                n4.C(jSONObject.optString("usernameFormat"));
            }
            if (!jSONObject.isNull("totalAnswers")) {
                n4.p(jSONObject.optInt("totalAnswers"));
            }
            return n4;
        }

        private b() {
        }
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final N f20436a;

        /* renamed from: b  reason: collision with root package name */
        private final int f20437b;

        public c(N n4, int i4) {
            m.e(n4, "review");
            this.f20436a = n4;
            this.f20437b = i4;
        }

        public final N a() {
            return this.f20436a;
        }

        public final int b() {
            return this.f20437b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (m.a(this.f20436a, cVar.f20436a) && this.f20437b == cVar.f20437b) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.f20436a.hashCode() * 31) + this.f20437b;
        }

        public String toString() {
            return "ReviewLikeData(review=" + this.f20436a + ", reviewLikedSuccessfully=" + this.f20437b + ')';
        }
    }

    public N() {
    }

    public final void A(String str) {
        this.f20415b = str;
    }

    public final void B(String str) {
        this.f20416c = str;
    }

    public final void C(String str) {
        this.f20427n = str;
    }

    public final int a() {
        return this.f20421h;
    }

    public final long b() {
        return this.f20418e;
    }

    public final String c() {
        return this.f20425l;
    }

    public final int d() {
        return this.f20424k;
    }

    public int describeContents() {
        return hashCode();
    }

    public final String e() {
        return this.f20417d;
    }

    public final long f() {
        return this.f20414a;
    }

    public final int g() {
        return this.f20423j;
    }

    public final int h() {
        return this.f20420g;
    }

    public final String i() {
        return this.f20419f;
    }

    public final Spanned j() {
        String str = this.f20419f;
        if (str == null) {
            return null;
        }
        F f4 = F.f21886a;
        m.b(str);
        return f4.d(m3.m.w(str, "\n", "<br />", false, 4, (Object) null));
    }

    public final String k() {
        return this.f20422i;
    }

    public final String l() {
        return this.f20415b;
    }

    public final String m() {
        return this.f20416c;
    }

    public final String n() {
        return this.f20427n;
    }

    public final boolean o() {
        if (this.f20426m == 1) {
            return true;
        }
        return false;
    }

    public final void p(int i4) {
        this.f20421h = i4;
    }

    public final void q(long j4) {
        this.f20418e = j4;
    }

    public final void r(String str) {
        this.f20425l = str;
    }

    public final void s(int i4) {
        this.f20424k = i4;
    }

    public final void t(String str) {
        this.f20417d = str;
    }

    public final void u(long j4) {
        this.f20414a = j4;
    }

    public final void v(int i4) {
        this.f20423j = i4;
    }

    public final void w(int i4) {
        this.f20420g = i4;
    }

    public void writeToParcel(Parcel parcel, int i4) {
        m.e(parcel, "parcel");
        parcel.writeLong(this.f20414a);
        parcel.writeLong(this.f20418e);
        parcel.writeString(this.f20416c);
        parcel.writeString(this.f20415b);
        parcel.writeString(this.f20417d);
        parcel.writeString(this.f20419f);
        parcel.writeInt(this.f20420g);
        parcel.writeInt(this.f20421h);
        parcel.writeString(this.f20422i);
        parcel.writeInt(this.f20423j);
        parcel.writeInt(this.f20424k);
        parcel.writeString(this.f20425l);
        parcel.writeInt(this.f20426m);
        parcel.writeString(this.f20427n);
    }

    public final void x(String str) {
        this.f20419f = str;
    }

    public final void y(String str) {
        this.f20422i = str;
    }

    public final void z(int i4) {
        this.f20426m = i4;
    }

    public N(Parcel parcel) {
        m.e(parcel, "source");
        this.f20414a = parcel.readLong();
        this.f20418e = parcel.readLong();
        this.f20416c = parcel.readString();
        this.f20415b = parcel.readString();
        this.f20417d = parcel.readString();
        this.f20419f = parcel.readString();
        this.f20420g = parcel.readInt();
        this.f20421h = parcel.readInt();
        this.f20422i = parcel.readString();
        this.f20423j = parcel.readInt();
        this.f20424k = parcel.readInt();
        this.f20425l = parcel.readString();
        this.f20426m = parcel.readInt();
        this.f20427n = parcel.readString();
    }
}
