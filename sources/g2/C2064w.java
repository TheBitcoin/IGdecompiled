package g2;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import org.json.JSONObject;

/* renamed from: g2.w  reason: case insensitive filesystem */
public final class C2064w implements Parcelable {
    public static final a CREATOR = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private String f20779a;

    /* renamed from: b  reason: collision with root package name */
    private String f20780b;

    /* renamed from: g2.w$a */
    public static final class a implements Parcelable.Creator {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        /* renamed from: a */
        public C2064w createFromParcel(Parcel parcel) {
            m.e(parcel, "parcel");
            return new C2064w(parcel);
        }

        /* renamed from: b */
        public C2064w[] newArray(int i4) {
            return new C2064w[i4];
        }

        private a() {
        }
    }

    public C2064w() {
    }

    public final void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (!jSONObject.isNull("antivirusName")) {
                this.f20779a = jSONObject.optString("antivirusName");
            }
            if (!jSONObject.isNull("virusName")) {
                this.f20780b = jSONObject.optString("virusName");
            }
        }
    }

    public final String b() {
        return this.f20779a;
    }

    public final String c() {
        return this.f20780b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i4) {
        m.e(parcel, "parcel");
        parcel.writeString(this.f20779a);
        parcel.writeString(this.f20780b);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public C2064w(Parcel parcel) {
        this();
        m.e(parcel, "parcel");
        this.f20779a = parcel.readString();
        this.f20780b = parcel.readString();
    }
}
