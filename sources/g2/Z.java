package g2;

import android.os.Parcel;
import android.os.Parcelable;
import com.uptodown.UptodownApp;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import org.json.JSONObject;

public final class Z implements Parcelable {
    public static Parcelable.Creator<Z> CREATOR = new a();

    /* renamed from: c  reason: collision with root package name */
    public static final b f20518c = new b((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private String f20519a;

    /* renamed from: b  reason: collision with root package name */
    private String f20520b;

    public static final class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public Z createFromParcel(Parcel parcel) {
            m.e(parcel, "source");
            return new Z(parcel);
        }

        /* renamed from: b */
        public Z[] newArray(int i4) {
            return new Z[i4];
        }
    }

    public static final class b {
        public /* synthetic */ b(C2103g gVar) {
            this();
        }

        public final Z a(JSONObject jSONObject) {
            m.e(jSONObject, "jsonObjectVideo");
            Z z4 = new Z();
            if (!jSONObject.isNull("youtubeID")) {
                z4.c(jSONObject.optString("youtubeID"));
            }
            if (!jSONObject.isNull("image")) {
                z4.d(jSONObject.optString("image"));
            }
            return z4;
        }

        private b() {
        }
    }

    public Z() {
    }

    public final String a() {
        return this.f20519a;
    }

    public final String b() {
        if (this.f20520b == null) {
            return null;
        }
        return this.f20520b + UptodownApp.f17422D.o() + ":webp";
    }

    public final void c(String str) {
        this.f20519a = str;
    }

    public final void d(String str) {
        this.f20520b = str;
    }

    public int describeContents() {
        return hashCode();
    }

    public void writeToParcel(Parcel parcel, int i4) {
        m.e(parcel, "parcel");
        parcel.writeString(this.f20519a);
        parcel.writeString(this.f20520b);
    }

    public Z(Parcel parcel) {
        m.e(parcel, "source");
        this.f20519a = parcel.readString();
        this.f20520b = parcel.readString();
    }
}
