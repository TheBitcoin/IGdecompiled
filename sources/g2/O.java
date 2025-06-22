package g2;

import android.os.Parcel;
import android.os.Parcelable;
import com.uptodown.UptodownApp;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import org.json.JSONObject;

public final class O implements Parcelable {
    public static Parcelable.Creator<O> CREATOR = new a();

    /* renamed from: e  reason: collision with root package name */
    public static final b f20438e = new b((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private String f20439a;

    /* renamed from: b  reason: collision with root package name */
    private int f20440b;

    /* renamed from: c  reason: collision with root package name */
    private int f20441c;

    /* renamed from: d  reason: collision with root package name */
    private int f20442d;

    public static final class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public O createFromParcel(Parcel parcel) {
            m.e(parcel, "source");
            return new O(parcel);
        }

        /* renamed from: b */
        public O[] newArray(int i4) {
            return new O[i4];
        }
    }

    public static final class b {
        public /* synthetic */ b(C2103g gVar) {
            this();
        }

        public final O a(JSONObject jSONObject) {
            m.e(jSONObject, "jsonObjectScreenshot");
            O o4 = new O();
            if (!jSONObject.isNull("screenshotURL")) {
                o4.g(jSONObject.optString("screenshotURL"));
            }
            if (!jSONObject.isNull("isVertical")) {
                o4.h(jSONObject.optInt("isVertical"));
            }
            if (!jSONObject.isNull("featured")) {
                o4.f(jSONObject.optInt("featured"));
            }
            return o4;
        }

        public final O b(JSONObject jSONObject) {
            m.e(jSONObject, "jsonObjectScreenshot");
            O o4 = new O();
            if (!jSONObject.isNull("screenshotURL")) {
                o4.g(jSONObject.optString("screenshotURL"));
            }
            if (!jSONObject.isNull("isVertical")) {
                o4.h(jSONObject.optInt("isVertical"));
            }
            return o4;
        }

        private b() {
        }
    }

    public O() {
    }

    public final int a() {
        return this.f20441c;
    }

    public final int b() {
        return this.f20440b;
    }

    public final String c() {
        return this.f20439a;
    }

    public final String d() {
        if (this.f20439a == null) {
            return null;
        }
        return this.f20439a + UptodownApp.f17422D.A() + ":webp";
    }

    public int describeContents() {
        return hashCode();
    }

    public final String e() {
        if (this.f20439a == null) {
            return null;
        }
        return this.f20439a + UptodownApp.f17422D.z() + ":webp";
    }

    public final void f(int i4) {
        this.f20441c = i4;
    }

    public final void g(String str) {
        this.f20439a = str;
    }

    public final void h(int i4) {
        this.f20442d = i4;
    }

    public void writeToParcel(Parcel parcel, int i4) {
        m.e(parcel, "dest");
        parcel.writeString(this.f20439a);
        parcel.writeInt(this.f20440b);
        parcel.writeInt(this.f20441c);
        parcel.writeInt(this.f20442d);
    }

    public O(Parcel parcel) {
        m.e(parcel, "source");
        this.f20439a = parcel.readString();
        this.f20440b = parcel.readInt();
        this.f20441c = parcel.readInt();
        this.f20442d = parcel.readInt();
    }
}
