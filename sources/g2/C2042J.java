package g2;

import R2.n;
import R2.s;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Spanned;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
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

/* renamed from: g2.J  reason: case insensitive filesystem */
public final class C2042J implements Parcelable {
    public static Parcelable.Creator<C2042J> CREATOR = new a();

    /* renamed from: l  reason: collision with root package name */
    public static final b f20379l = new b((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private long f20380a;

    /* renamed from: b  reason: collision with root package name */
    private String f20381b;

    /* renamed from: c  reason: collision with root package name */
    private String f20382c;

    /* renamed from: d  reason: collision with root package name */
    private String f20383d;

    /* renamed from: e  reason: collision with root package name */
    private long f20384e;

    /* renamed from: f  reason: collision with root package name */
    private String f20385f;

    /* renamed from: g  reason: collision with root package name */
    private String f20386g;

    /* renamed from: h  reason: collision with root package name */
    private int f20387h;

    /* renamed from: i  reason: collision with root package name */
    private int f20388i;

    /* renamed from: j  reason: collision with root package name */
    private int f20389j;

    /* renamed from: k  reason: collision with root package name */
    private String f20390k;

    /* renamed from: g2.J$a */
    public static final class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public C2042J createFromParcel(Parcel parcel) {
            m.e(parcel, "source");
            return new C2042J(parcel);
        }

        /* renamed from: b */
        public C2042J[] newArray(int i4) {
            return new C2042J[i4];
        }
    }

    /* renamed from: g2.J$b */
    public static final class b {

        /* renamed from: g2.J$b$a */
        static final class a extends d {

            /* renamed from: a  reason: collision with root package name */
            Object f20391a;

            /* renamed from: b  reason: collision with root package name */
            /* synthetic */ Object f20392b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ b f20393c;

            /* renamed from: d  reason: collision with root package name */
            int f20394d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(b bVar, V2.d dVar) {
                super(dVar);
                this.f20393c = bVar;
            }

            public final Object invokeSuspend(Object obj) {
                this.f20392b = obj;
                this.f20394d |= Integer.MIN_VALUE;
                return this.f20393c.b((C2042J) null, (Context) null, this);
            }
        }

        /* renamed from: g2.J$b$b  reason: collision with other inner class name */
        static final class C0247b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f20395a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Context f20396b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ C2042J f20397c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ A f20398d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0247b(Context context, C2042J j4, A a5, V2.d dVar) {
                super(2, dVar);
                this.f20396b = context;
                this.f20397c = j4;
                this.f20398d = a5;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new C0247b(this.f20396b, this.f20397c, this.f20398d, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f20395a == 0) {
                    n.b(obj);
                    L G02 = new L(this.f20396b).G0(this.f20397c.c());
                    if (!G02.b() && G02.e() != null) {
                        JSONObject e5 = G02.e();
                        m.b(e5);
                        if (!e5.isNull("success")) {
                            this.f20398d.f20966a = e5.optInt("success");
                        }
                        if (this.f20398d.f20966a == 1) {
                            this.f20397c.n(this.f20397c.d() + 1);
                        }
                    }
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((C0247b) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        public /* synthetic */ b(C2103g gVar) {
            this();
        }

        public final C2042J a(JSONObject jSONObject) {
            m.e(jSONObject, "jsonObject");
            C2042J j4 = new C2042J();
            if (!jSONObject.isNull("id")) {
                j4.m(jSONObject.optLong("id"));
            }
            if (!jSONObject.isNull("userName")) {
                j4.s(jSONObject.optString("userName"));
                if (!jSONObject.isNull("userAvatar")) {
                    j4.l(jSONObject.optString("userAvatar"));
                }
                if (!jSONObject.isNull("userID")) {
                    j4.r(jSONObject.optString("userID"));
                }
            }
            if (!jSONObject.isNull(MimeTypes.BASE_TYPE_TEXT)) {
                j4.o(jSONObject.optString(MimeTypes.BASE_TYPE_TEXT));
            }
            if (!jSONObject.isNull("timeAgo")) {
                j4.p(jSONObject.optString("timeAgo"));
            }
            if (!jSONObject.isNull("likes")) {
                j4.n(jSONObject.optInt("likes"));
            }
            if (!jSONObject.isNull("isAuthorVerified")) {
                j4.k(jSONObject.optInt("isAuthorVerified"));
            }
            if (!jSONObject.isNull("isTurbo")) {
                j4.q(jSONObject.optInt("isTurbo"));
            }
            if (!jSONObject.isNull("usernameFormat")) {
                j4.t(jSONObject.optString("usernameFormat"));
            }
            return j4;
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object b(g2.C2042J r7, android.content.Context r8, V2.d r9) {
            /*
                r6 = this;
                boolean r0 = r9 instanceof g2.C2042J.b.a
                if (r0 == 0) goto L_0x0013
                r0 = r9
                g2.J$b$a r0 = (g2.C2042J.b.a) r0
                int r1 = r0.f20394d
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.f20394d = r1
                goto L_0x0018
            L_0x0013:
                g2.J$b$a r0 = new g2.J$b$a
                r0.<init>(r6, r9)
            L_0x0018:
                java.lang.Object r9 = r0.f20392b
                java.lang.Object r1 = W2.b.c()
                int r2 = r0.f20394d
                r3 = 1
                if (r2 == 0) goto L_0x0035
                if (r2 != r3) goto L_0x002d
                java.lang.Object r7 = r0.f20391a
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
                long r4 = r7.c()
                r9.b(r4)
                kotlin.jvm.internal.A r9 = new kotlin.jvm.internal.A
                r9.<init>()
                o3.G r2 = o3.Y.b()
                g2.J$b$b r4 = new g2.J$b$b
                r5 = 0
                r4.<init>(r8, r7, r9, r5)
                r0.f20391a = r9
                r0.f20394d = r3
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
            throw new UnsupportedOperationException("Method not decompiled: g2.C2042J.b.b(g2.J, android.content.Context, V2.d):java.lang.Object");
        }

        public final ArrayList c(JSONArray jSONArray) {
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

        private b() {
        }
    }

    public C2042J() {
    }

    public final int a() {
        return this.f20388i;
    }

    public final String b() {
        return this.f20383d;
    }

    public final long c() {
        return this.f20380a;
    }

    public final int d() {
        return this.f20387h;
    }

    public int describeContents() {
        return hashCode();
    }

    public final Spanned e() {
        String str = this.f20385f;
        if (str == null) {
            return null;
        }
        F f4 = F.f21886a;
        m.b(str);
        return f4.d(m3.m.w(str, "\n", "<br />", false, 4, (Object) null));
    }

    public final String f() {
        return this.f20386g;
    }

    public final String g() {
        return this.f20382c;
    }

    public final String h() {
        return this.f20381b;
    }

    public final String i() {
        return this.f20390k;
    }

    public final boolean j() {
        if (this.f20389j == 1) {
            return true;
        }
        return false;
    }

    public final void k(int i4) {
        this.f20388i = i4;
    }

    public final void l(String str) {
        this.f20383d = str;
    }

    public final void m(long j4) {
        this.f20380a = j4;
    }

    public final void n(int i4) {
        this.f20387h = i4;
    }

    public final void o(String str) {
        this.f20385f = str;
    }

    public final void p(String str) {
        this.f20386g = str;
    }

    public final void q(int i4) {
        this.f20389j = i4;
    }

    public final void r(String str) {
        this.f20382c = str;
    }

    public final void s(String str) {
        this.f20381b = str;
    }

    public final void t(String str) {
        this.f20390k = str;
    }

    public void writeToParcel(Parcel parcel, int i4) {
        m.e(parcel, "parcel");
        parcel.writeLong(this.f20380a);
        parcel.writeLong(this.f20384e);
        parcel.writeString(this.f20381b);
        parcel.writeString(this.f20382c);
        parcel.writeString(this.f20383d);
        parcel.writeString(this.f20385f);
        parcel.writeString(this.f20386g);
        parcel.writeInt(this.f20387h);
        parcel.writeInt(this.f20388i);
        parcel.writeInt(this.f20389j);
        parcel.writeString(this.f20390k);
    }

    public C2042J(Parcel parcel) {
        m.e(parcel, "source");
        this.f20380a = parcel.readLong();
        this.f20384e = parcel.readLong();
        this.f20381b = parcel.readString();
        this.f20382c = parcel.readString();
        this.f20383d = parcel.readString();
        this.f20385f = parcel.readString();
        this.f20386g = parcel.readString();
        this.f20387h = parcel.readInt();
        this.f20388i = parcel.readInt();
        this.f20389j = parcel.readInt();
        this.f20390k = parcel.readString();
    }
}
