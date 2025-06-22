package g2;

import android.os.Parcel;
import android.os.Parcelable;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.util.ArrayList;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: g2.C  reason: case insensitive filesystem */
public final class C2035C implements Parcelable {
    public static Parcelable.Creator<C2035C> CREATOR = new a();

    /* renamed from: i  reason: collision with root package name */
    public static final b f20340i = new b((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private String f20341a;

    /* renamed from: b  reason: collision with root package name */
    private long f20342b = -1;

    /* renamed from: c  reason: collision with root package name */
    private String f20343c;

    /* renamed from: d  reason: collision with root package name */
    private long f20344d = -1;

    /* renamed from: e  reason: collision with root package name */
    private String f20345e;

    /* renamed from: f  reason: collision with root package name */
    private String f20346f;

    /* renamed from: g  reason: collision with root package name */
    private String f20347g;

    /* renamed from: h  reason: collision with root package name */
    private ArrayList f20348h;

    /* renamed from: g2.C$a */
    public static final class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public C2035C createFromParcel(Parcel parcel) {
            m.e(parcel, "source");
            return new C2035C(parcel);
        }

        /* renamed from: b */
        public C2035C[] newArray(int i4) {
            return new C2035C[i4];
        }
    }

    /* renamed from: g2.C$b */
    public static final class b {
        public /* synthetic */ b(C2103g gVar) {
            this();
        }

        public final ArrayList a(JSONObject jSONObject) {
            int i4;
            JSONArray jSONArray;
            JSONObject jSONObject2 = jSONObject;
            m.e(jSONObject2, "jsonObject");
            ArrayList arrayList = null;
            try {
                if (!jSONObject2.isNull("success")) {
                    i4 = jSONObject2.optInt("success", 0);
                } else {
                    i4 = 1;
                }
                JSONArray optJSONArray = jSONObject2.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
                if (i4 != 1 || optJSONArray == null) {
                    return null;
                }
                ArrayList arrayList2 = new ArrayList();
                try {
                    int length = optJSONArray.length();
                    int i5 = 0;
                    while (i5 < length) {
                        C2035C c5 = new C2035C();
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i5);
                        if (!optJSONObject.isNull("fileID")) {
                            c5.i(optJSONObject.optString("fileID"));
                        }
                        if (!optJSONObject.isNull("version")) {
                            c5.p(optJSONObject.optString("version"));
                        }
                        if (!optJSONObject.isNull("versionCode")) {
                            c5.o(optJSONObject.optLong("versionCode"));
                        }
                        if (!optJSONObject.isNull("sizeInBytes")) {
                            c5.n(optJSONObject.optLong("sizeInBytes"));
                        }
                        if (!optJSONObject.isNull("minSDKVersion")) {
                            c5.l(optJSONObject.optString("minSDKVersion"));
                        }
                        if (!optJSONObject.isNull("lastUpdate")) {
                            c5.k(optJSONObject.optString("lastUpdate"));
                        }
                        if (!optJSONObject.isNull("fileType")) {
                            c5.j(optJSONObject.optString("fileType"));
                        }
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray("requiredFeatures");
                        if (optJSONArray2 != null) {
                            c5.m(new ArrayList());
                            int length2 = optJSONArray2.length();
                            int i6 = 0;
                            while (i6 < length2) {
                                ArrayList e5 = c5.e();
                                if (e5 != null) {
                                    jSONArray = optJSONArray;
                                    e5.add(optJSONArray2.optString(i6));
                                } else {
                                    jSONArray = optJSONArray;
                                }
                                i6++;
                                optJSONArray = jSONArray;
                            }
                        }
                        JSONArray jSONArray2 = optJSONArray;
                        arrayList2.add(c5);
                        i5++;
                        optJSONArray = jSONArray2;
                    }
                    return arrayList2;
                } catch (Exception e6) {
                    e = e6;
                    arrayList = arrayList2;
                    e.printStackTrace();
                    return arrayList;
                }
            } catch (Exception e7) {
                e = e7;
                e.printStackTrace();
                return arrayList;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x000d, code lost:
            r1 = com.uptodown.activities.preferences.a.f18818a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void b(android.content.Context r5, g2.C2048f r6, android.os.Bundle r7) {
            /*
                r4 = this;
                java.lang.String r0 = "context"
                kotlin.jvm.internal.m.e(r5, r0)
                java.lang.String r0 = "bundleParamsInstalled"
                kotlin.jvm.internal.m.e(r7, r0)
                r0 = 0
                if (r6 == 0) goto L_0x0049
                com.uptodown.activities.preferences.a$a r1 = com.uptodown.activities.preferences.a.f18818a
                java.lang.String r2 = r1.d(r5)
                if (r2 == 0) goto L_0x0049
                u2.t$a r3 = u2.t.f21927u
                u2.t r3 = r3.a(r5)
                r3.a()
                g2.s r2 = r3.e0(r2)
                if (r2 == 0) goto L_0x0046
                r0 = 1
                r6.N(r0)
                g2.f$c r2 = g2.C2048f.c.UPDATED
                r6.c0(r2)
                r3.o1(r6)
                java.lang.String r6 = r6.o()
                kotlin.jvm.internal.m.b(r6)
                r3.R(r6)
                u2.w r6 = new u2.w
                r6.<init>()
                r6.b(r5)
                r6 = 0
                r1.t0(r5, r6)
            L_0x0046:
                r3.i()
            L_0x0049:
                java.lang.String r5 = "rollback"
                r7.putInt(r5, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: g2.C2035C.b.b(android.content.Context, g2.f, android.os.Bundle):void");
        }

        private b() {
        }
    }

    public C2035C() {
    }

    public final String a() {
        return this.f20347g;
    }

    public final String b() {
        return this.f20346f;
    }

    public final String c() {
        return this.f20343c;
    }

    public final String d() {
        return this.f20345e;
    }

    public int describeContents() {
        return hashCode();
    }

    public final ArrayList e() {
        return this.f20348h;
    }

    public final long f() {
        return this.f20342b;
    }

    public final long g() {
        return this.f20344d;
    }

    public final String h() {
        return this.f20341a;
    }

    public final void i(String str) {
        this.f20347g = str;
    }

    public final void j(String str) {
        this.f20346f = str;
    }

    public final void k(String str) {
        this.f20343c = str;
    }

    public final void l(String str) {
        this.f20345e = str;
    }

    public final void m(ArrayList arrayList) {
        this.f20348h = arrayList;
    }

    public final void n(long j4) {
        this.f20342b = j4;
    }

    public final void o(long j4) {
        this.f20344d = j4;
    }

    public final void p(String str) {
        this.f20341a = str;
    }

    public void writeToParcel(Parcel parcel, int i4) {
        m.e(parcel, "parcel");
        parcel.writeString(this.f20341a);
        parcel.writeString(this.f20343c);
        parcel.writeLong(this.f20344d);
        parcel.writeString(this.f20345e);
        parcel.writeString(this.f20346f);
        parcel.writeString(this.f20347g);
        parcel.writeLong(this.f20342b);
    }

    public C2035C(Parcel parcel) {
        m.e(parcel, "source");
        this.f20341a = parcel.readString();
        this.f20343c = parcel.readString();
        this.f20344d = parcel.readLong();
        this.f20345e = parcel.readString();
        this.f20346f = parcel.readString();
        this.f20347g = parcel.readString();
        this.f20342b = parcel.readLong();
    }
}
