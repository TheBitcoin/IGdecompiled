package g2;

import S2.C1601o;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.privacysandbox.ads.adservices.adselection.u;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.ArrayList;
import java.util.Comparator;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import org.json.JSONArray;
import org.json.JSONObject;

public final class V implements Parcelable {
    public static Parcelable.Creator<V> CREATOR = new a();

    /* renamed from: l  reason: collision with root package name */
    public static final b f20481l = new b((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private long f20482a;

    /* renamed from: b  reason: collision with root package name */
    private String f20483b;

    /* renamed from: c  reason: collision with root package name */
    private String f20484c;

    /* renamed from: d  reason: collision with root package name */
    private String f20485d;

    /* renamed from: e  reason: collision with root package name */
    private String f20486e;

    /* renamed from: f  reason: collision with root package name */
    private int f20487f;

    /* renamed from: g  reason: collision with root package name */
    private String f20488g;

    /* renamed from: h  reason: collision with root package name */
    private long f20489h;

    /* renamed from: i  reason: collision with root package name */
    private int f20490i;

    /* renamed from: j  reason: collision with root package name */
    private final ArrayList f20491j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    private final ArrayList f20492k = new ArrayList();

    public static final class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public V createFromParcel(Parcel parcel) {
            m.e(parcel, "source");
            return new V(parcel);
        }

        /* renamed from: b */
        public V[] newArray(int i4) {
            return new V[i4];
        }
    }

    public static final class b {

        public static final class a implements Comparator {
            public final int compare(Object obj, Object obj2) {
                return U2.a.a(Long.valueOf(((c) obj2).b()), Long.valueOf(((c) obj).b()));
            }
        }

        /* renamed from: g2.V$b$b  reason: collision with other inner class name */
        public static final class C0249b implements Comparator {
            public final int compare(Object obj, Object obj2) {
                return U2.a.a(Long.valueOf(((c) obj2).b()), Long.valueOf(((c) obj).b()));
            }
        }

        public /* synthetic */ b(C2103g gVar) {
            this();
        }

        private final c d(JSONObject jSONObject) {
            String str;
            String str2;
            long j4;
            String str3 = null;
            if (!jSONObject.isNull(RewardPlus.NAME)) {
                str = jSONObject.optString(RewardPlus.NAME);
            } else {
                str = null;
            }
            if (!jSONObject.isNull("packagename")) {
                str2 = jSONObject.optString("packagename");
            } else {
                str2 = null;
            }
            if (!jSONObject.isNull("lastUpdate")) {
                j4 = jSONObject.optLong("lastUpdate");
            } else {
                j4 = -1;
            }
            long j5 = j4;
            if (!jSONObject.isNull(RewardPlus.ICON)) {
                str3 = jSONObject.optString(RewardPlus.ICON);
            }
            return new c(str, str2, j5, str3);
        }

        public final V a(JSONObject jSONObject) {
            m.e(jSONObject, "jsonObject");
            V v4 = new V();
            if (!jSONObject.isNull("id")) {
                v4.m(jSONObject.optLong("id"));
            }
            if (!jSONObject.isNull("identifier")) {
                v4.n(jSONObject.optString("identifier"));
            }
            if (!jSONObject.isNull(RewardPlus.NAME)) {
                v4.q(jSONObject.optString(RewardPlus.NAME));
            }
            if (!jSONObject.isNull("platformID")) {
                v4.s(jSONObject.optInt("platformID"));
                int j4 = v4.j();
                if (j4 == 1) {
                    v4.r("Windows");
                } else if (j4 == 3) {
                    v4.r("Mac");
                } else if (j4 == 13) {
                    v4.r("Android");
                } else if (j4 == 14) {
                    v4.r("iOS");
                }
            }
            if (!jSONObject.isNull("lastUpdate")) {
                v4.o(jSONObject.optLong("lastUpdate"));
            }
            return v4;
        }

        public final V b(V v4, JSONObject jSONObject) {
            m.e(v4, "<this>");
            m.e(jSONObject, "jsonObject");
            if (!jSONObject.isNull("brand")) {
                v4.l(jSONObject.optString("brand"));
            }
            if (!jSONObject.isNull("model")) {
                v4.p(jSONObject.optString("model"));
            }
            if (!jSONObject.isNull("securityPositivesCount")) {
                v4.t(jSONObject.optInt("securityPositivesCount"));
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("installedApps");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i4 = 0; i4 < length; i4++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
                    m.d(optJSONObject, "optJSONObject(...)");
                    v4.d().add(d(optJSONObject));
                }
                ArrayList d5 = v4.d();
                if (d5.size() > 1) {
                    C1601o.t(d5, new a());
                }
            }
            JSONArray jSONArray = jSONObject.getJSONArray("nonInstalledApps");
            if (!jSONObject.isNull("nonInstalledApps")) {
                int length2 = jSONArray.length();
                for (int i5 = 0; i5 < length2; i5++) {
                    JSONObject optJSONObject2 = jSONArray.optJSONObject(i5);
                    m.d(optJSONObject2, "optJSONObject(...)");
                    v4.h().add(d(optJSONObject2));
                }
                ArrayList h4 = v4.h();
                if (h4.size() > 1) {
                    C1601o.t(h4, new C0249b());
                }
            }
            return v4;
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

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final String f20493a;

        /* renamed from: b  reason: collision with root package name */
        private final String f20494b;

        /* renamed from: c  reason: collision with root package name */
        private final long f20495c;

        /* renamed from: d  reason: collision with root package name */
        private final String f20496d;

        public c(String str, String str2, long j4, String str3) {
            this.f20493a = str;
            this.f20494b = str2;
            this.f20495c = j4;
            this.f20496d = str3;
        }

        public final String a() {
            return this.f20496d;
        }

        public final long b() {
            return this.f20495c;
        }

        public final String c() {
            return this.f20493a;
        }

        public final String d() {
            return this.f20494b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (m.a(this.f20493a, cVar.f20493a) && m.a(this.f20494b, cVar.f20494b) && this.f20495c == cVar.f20495c && m.a(this.f20496d, cVar.f20496d)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i4;
            int i5;
            String str = this.f20493a;
            int i6 = 0;
            if (str == null) {
                i4 = 0;
            } else {
                i4 = str.hashCode();
            }
            int i7 = i4 * 31;
            String str2 = this.f20494b;
            if (str2 == null) {
                i5 = 0;
            } else {
                i5 = str2.hashCode();
            }
            int a5 = (((i7 + i5) * 31) + u.a(this.f20495c)) * 31;
            String str3 = this.f20496d;
            if (str3 != null) {
                i6 = str3.hashCode();
            }
            return a5 + i6;
        }

        public String toString() {
            return "UserDeviceApp(name=" + this.f20493a + ", packagename=" + this.f20494b + ", lastUpdate=" + this.f20495c + ", icon=" + this.f20496d + ')';
        }
    }

    public V() {
    }

    public final String a() {
        return this.f20485d;
    }

    public final long b() {
        return this.f20482a;
    }

    public final String c() {
        return this.f20483b;
    }

    public final ArrayList d() {
        return this.f20491j;
    }

    public int describeContents() {
        return hashCode();
    }

    public final long e() {
        return this.f20489h;
    }

    public final String f() {
        return this.f20486e;
    }

    public final String g() {
        return this.f20484c;
    }

    public final ArrayList h() {
        return this.f20492k;
    }

    public final String i() {
        return this.f20488g;
    }

    public final int j() {
        return this.f20487f;
    }

    public final int k() {
        return this.f20490i;
    }

    public final void l(String str) {
        this.f20485d = str;
    }

    public final void m(long j4) {
        this.f20482a = j4;
    }

    public final void n(String str) {
        this.f20483b = str;
    }

    public final void o(long j4) {
        this.f20489h = j4;
    }

    public final void p(String str) {
        this.f20486e = str;
    }

    public final void q(String str) {
        this.f20484c = str;
    }

    public final void r(String str) {
        this.f20488g = str;
    }

    public final void s(int i4) {
        this.f20487f = i4;
    }

    public final void t(int i4) {
        this.f20490i = i4;
    }

    public void writeToParcel(Parcel parcel, int i4) {
        m.e(parcel, "parcel");
        parcel.writeLong(this.f20482a);
        parcel.writeString(this.f20483b);
        parcel.writeString(this.f20484c);
        parcel.writeString(this.f20485d);
        parcel.writeString(this.f20486e);
        parcel.writeInt(this.f20487f);
        parcel.writeString(this.f20488g);
        parcel.writeLong(this.f20489h);
        parcel.writeInt(this.f20490i);
    }

    public V(Parcel parcel) {
        m.e(parcel, "source");
        this.f20482a = parcel.readLong();
        this.f20483b = parcel.readString();
        this.f20484c = parcel.readString();
        this.f20485d = parcel.readString();
        this.f20486e = parcel.readString();
        this.f20487f = parcel.readInt();
        this.f20488g = parcel.readString();
        this.f20489h = parcel.readLong();
        this.f20490i = parcel.readInt();
    }
}
