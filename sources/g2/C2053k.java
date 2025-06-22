package g2;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.util.ArrayList;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: g2.k  reason: case insensitive filesystem */
public final class C2053k implements Parcelable {
    public static Parcelable.Creator<C2053k> CREATOR = new a();

    /* renamed from: g  reason: collision with root package name */
    public static final b f20690g = new b((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private int f20691a;

    /* renamed from: b  reason: collision with root package name */
    private String f20692b;

    /* renamed from: c  reason: collision with root package name */
    private String f20693c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f20694d;

    /* renamed from: e  reason: collision with root package name */
    private int f20695e;

    /* renamed from: f  reason: collision with root package name */
    private int f20696f;

    /* renamed from: g2.k$a */
    public static final class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public C2053k createFromParcel(Parcel parcel) {
            m.e(parcel, "source");
            return new C2053k(parcel);
        }

        /* renamed from: b */
        public C2053k[] newArray(int i4) {
            return new C2053k[i4];
        }
    }

    /* renamed from: g2.k$b */
    public static final class b {
        public /* synthetic */ b(C2103g gVar) {
            this();
        }

        public static /* synthetic */ ArrayList b(b bVar, String str, int i4, int i5, Object obj) {
            if ((i5 & 2) != 0) {
                i4 = 0;
            }
            return bVar.a(str, i4);
        }

        public final ArrayList a(String str, int i4) {
            m.e(str, "json");
            return c(new JSONObject(str), i4);
        }

        public final ArrayList c(JSONObject jSONObject, int i4) {
            m.e(jSONObject, "jsonObject");
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i5 = 0; i5 < length; i5++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i5);
                    C2053k kVar = new C2053k(0, (String) null, (String) null, 7, (C2103g) null);
                    m.b(optJSONObject);
                    kVar.l(optJSONObject, i4);
                    arrayList.add(kVar);
                }
            }
            return arrayList;
        }

        public final ArrayList d(String str) {
            m.e(str, "json");
            return e(new JSONObject(str));
        }

        public final ArrayList e(JSONObject jSONObject) {
            m.e(jSONObject, "jsonObject");
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i4 = 0; i4 < length; i4++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
                    C2053k kVar = new C2053k(0, (String) null, (String) null, 7, (C2103g) null);
                    m.b(optJSONObject);
                    kVar.m(optJSONObject);
                    arrayList.add(kVar);
                }
            }
            return arrayList;
        }

        private b() {
        }
    }

    public C2053k(int i4, String str, String str2) {
        this.f20691a = i4;
        this.f20692b = str;
        this.f20693c = str2;
    }

    public final String a() {
        return this.f20693c;
    }

    public final int b() {
        return this.f20691a;
    }

    public final int c() {
        int i4 = this.f20691a;
        if (i4 == 648 || i4 == 567 || i4 == 563) {
            return 12;
        }
        return 20;
    }

    public final String d() {
        return this.f20692b;
    }

    public int describeContents() {
        return hashCode();
    }

    public final int e() {
        return this.f20695e;
    }

    public final int f() {
        int i4;
        if (!(this.f20695e != 523 || (i4 = this.f20691a) == 568 || i4 == 593 || i4 == 645)) {
            switch (i4) {
                case 558:
                case 559:
                case 560:
                case 562:
                    return 5;
                case 561:
                    break;
                default:
                    switch (i4) {
                        case 564:
                        case 565:
                        case 566:
                            return 5;
                        default:
                            return 6;
                    }
            }
        }
        return 1;
    }

    public final boolean g() {
        if (this.f20695e != 0) {
            return true;
        }
        return false;
    }

    public final boolean h() {
        return this.f20694d;
    }

    public final int i() {
        return this.f20696f;
    }

    public final boolean j() {
        int i4 = this.f20691a;
        if (i4 == -3 || i4 == -2) {
            return false;
        }
        return true;
    }

    public final void k(JSONObject jSONObject) {
        m.e(jSONObject, "jsonObjectData");
        if (!jSONObject.isNull(RewardPlus.NAME)) {
            this.f20692b = jSONObject.optString(RewardPlus.NAME);
        }
        if (!jSONObject.isNull("id")) {
            this.f20691a = jSONObject.optInt("id");
        }
        if (!jSONObject.isNull("isGame")) {
            this.f20696f = jSONObject.optInt("isGame");
        }
    }

    public final void l(JSONObject jSONObject, int i4) {
        m.e(jSONObject, "jsonObjectData");
        if (!jSONObject.isNull(RewardPlus.NAME)) {
            this.f20692b = jSONObject.optString(RewardPlus.NAME);
        }
        if (!jSONObject.isNull("id")) {
            this.f20691a = jSONObject.optInt("id");
        }
        this.f20695e = i4;
    }

    public final void m(JSONObject jSONObject) {
        m.e(jSONObject, "jsonObjectData");
        if (!jSONObject.isNull("id")) {
            this.f20691a = jSONObject.optInt("id");
        }
        if (!jSONObject.isNull(RewardPlus.NAME)) {
            this.f20692b = jSONObject.optString(RewardPlus.NAME);
        } else if (!jSONObject.isNull("value")) {
            this.f20692b = jSONObject.optString("value");
        }
        if (!jSONObject.isNull("description")) {
            this.f20693c = jSONObject.optString("description");
        }
        this.f20694d = true;
    }

    public final void n(Bundle bundle) {
        m.e(bundle, "arg");
        this.f20691a = bundle.getInt("id");
        this.f20692b = bundle.getString(RewardPlus.NAME);
        this.f20693c = bundle.getString("description");
        this.f20694d = bundle.getBoolean("isFloating");
        this.f20695e = bundle.getInt("parentCategoryId");
        this.f20696f = bundle.getInt("isGame");
    }

    public final Bundle o() {
        Bundle bundle = new Bundle();
        bundle.putInt("id", this.f20691a);
        bundle.putString(RewardPlus.NAME, this.f20692b);
        bundle.putString("description", this.f20693c);
        bundle.putBoolean("isFloating", this.f20694d);
        bundle.putInt("parentCategoryId", this.f20695e);
        bundle.putInt("isGame", this.f20696f);
        return bundle;
    }

    public final void p(String str) {
        this.f20693c = str;
    }

    public final void q(boolean z4) {
        this.f20694d = z4;
    }

    public final void r(int i4) {
        this.f20691a = i4;
    }

    public final void s(String str) {
        this.f20692b = str;
    }

    public final void t(int i4) {
        this.f20695e = i4;
    }

    public void writeToParcel(Parcel parcel, int i4) {
        m.e(parcel, "parcel");
        parcel.writeInt(this.f20691a);
        parcel.writeString(this.f20692b);
        parcel.writeString(this.f20693c);
        parcel.writeBooleanArray(new boolean[]{this.f20694d});
        parcel.writeInt(this.f20695e);
        parcel.writeInt(this.f20696f);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C2053k(int i4, String str, String str2, int i5, C2103g gVar) {
        this((i5 & 1) != 0 ? 0 : i4, (i5 & 2) != 0 ? null : str, (i5 & 4) != 0 ? null : str2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public C2053k(Parcel parcel) {
        this(0, (String) null, (String) null, 7, (C2103g) null);
        m.e(parcel, "source");
        this.f20691a = parcel.readInt();
        this.f20692b = parcel.readString();
        this.f20693c = parcel.readString();
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.f20694d = zArr[0];
        this.f20695e = parcel.readInt();
        this.f20696f = parcel.readInt();
    }
}
