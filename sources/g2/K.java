package g2;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import org.json.JSONArray;
import org.json.JSONObject;

public final class K implements Parcelable {
    public static final a CREATOR = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private String f20399a;

    /* renamed from: b  reason: collision with root package name */
    private int f20400b;

    /* renamed from: c  reason: collision with root package name */
    private int f20401c;

    /* renamed from: d  reason: collision with root package name */
    private String f20402d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList f20403e;

    public static final class a implements Parcelable.Creator {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        /* renamed from: a */
        public K createFromParcel(Parcel parcel) {
            m.e(parcel, "parcel");
            return new K(parcel);
        }

        /* renamed from: b */
        public K[] newArray(int i4) {
            return new K[i4];
        }

        private a() {
        }
    }

    public K() {
    }

    public final void a(JSONObject jSONObject) {
        m.e(jSONObject, "jsonObject");
        if (!jSONObject.isNull("sha256")) {
            this.f20399a = jSONObject.optString("sha256");
        }
        if (!jSONObject.isNull("scans")) {
            this.f20400b = jSONObject.optInt("scans");
        }
        if (!jSONObject.isNull("positives")) {
            this.f20401c = jSONObject.optInt("positives");
        }
        if (!jSONObject.isNull("lastAnalysis")) {
            this.f20402d = jSONObject.optString("lastAnalysis");
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("infections");
        if (optJSONArray != null) {
            this.f20403e = new ArrayList();
            int length = optJSONArray.length();
            for (int i4 = 0; i4 < length; i4++) {
                C2064w wVar = new C2064w();
                wVar.a(optJSONArray.optJSONObject(i4));
                ArrayList arrayList = this.f20403e;
                m.b(arrayList);
                arrayList.add(wVar);
            }
        }
    }

    public final ArrayList b() {
        return this.f20403e;
    }

    public final String c() {
        return this.f20402d;
    }

    public final int d() {
        return this.f20401c;
    }

    public int describeContents() {
        return 0;
    }

    public final int e() {
        return this.f20400b;
    }

    public final String f() {
        return this.f20399a;
    }

    public void writeToParcel(Parcel parcel, int i4) {
        m.e(parcel, "parcel");
        parcel.writeString(this.f20399a);
        parcel.writeInt(this.f20400b);
        parcel.writeInt(this.f20401c);
        parcel.writeString(this.f20402d);
        parcel.writeList(this.f20403e);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public K(Parcel parcel) {
        this();
        m.e(parcel, "parcel");
        this.f20399a = parcel.readString();
        this.f20400b = parcel.readInt();
        this.f20401c = parcel.readInt();
        this.f20402d = parcel.readString();
        ArrayList arrayList = this.f20403e;
        if (arrayList == null || arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            this.f20403e = arrayList2;
            m.b(arrayList2);
            parcel.readList(arrayList2, C2064w.class.getClassLoader());
        }
    }
}
