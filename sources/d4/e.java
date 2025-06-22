package d4;

import E2.t;
import android.os.Parcel;
import android.os.Parcelable;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import kotlin.jvm.internal.m;

public final class e implements Parcelable {
    public static final a CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public final String f24534a;

    /* renamed from: b  reason: collision with root package name */
    public final String f24535b;

    /* renamed from: c  reason: collision with root package name */
    public final String f24536c;

    /* renamed from: d  reason: collision with root package name */
    public final String f24537d;

    /* renamed from: e  reason: collision with root package name */
    public final String f24538e;

    public static final class a implements Parcelable.Creator {
        public Object createFromParcel(Parcel parcel) {
            String str;
            m.e(parcel, "parcel");
            m.e(parcel, "parcel");
            String readString = parcel.readString();
            if (readString == null) {
                readString = "";
            }
            String readString2 = parcel.readString();
            if (readString2 == null) {
                readString2 = "";
            }
            String readString3 = parcel.readString();
            if (readString3 == null) {
                readString3 = "";
            }
            String readString4 = parcel.readString();
            if (readString4 == null) {
                readString4 = "";
            }
            String readString5 = parcel.readString();
            if (readString5 == null) {
                str = "";
            } else {
                str = readString5;
            }
            return new e(readString, readString2, readString3, readString4, str);
        }

        public Object[] newArray(int i4) {
            return new e[i4];
        }
    }

    public e(String str, String str2, String str3, String str4, String str5) {
        m.e(str, RewardPlus.NAME);
        m.e(str2, "type");
        m.e(str3, "maxAge");
        m.e(str4, "domain");
        m.e(str5, "purposes");
        this.f24534a = str;
        this.f24535b = str2;
        this.f24536c = str3;
        this.f24537d = str4;
        this.f24538e = str5;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (m.a(this.f24534a, eVar.f24534a) && m.a(this.f24535b, eVar.f24535b) && m.a(this.f24536c, eVar.f24536c) && m.a(this.f24537d, eVar.f24537d) && m.a(this.f24538e, eVar.f24538e)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f24538e.hashCode() + t.a(this.f24537d, t.a(this.f24536c, t.a(this.f24535b, this.f24534a.hashCode() * 31, 31), 31), 31);
    }

    public String toString() {
        StringBuilder a5 = A2.a.a("DisclosureInfo(name=");
        a5.append(this.f24534a);
        a5.append(", type=");
        a5.append(this.f24535b);
        a5.append(", maxAge=");
        a5.append(this.f24536c);
        a5.append(", domain=");
        a5.append(this.f24537d);
        a5.append(", purposes=");
        a5.append(this.f24538e);
        a5.append(')');
        return a5.toString();
    }

    public void writeToParcel(Parcel parcel, int i4) {
        m.e(parcel, "parcel");
        parcel.writeString(this.f24534a);
        parcel.writeString(this.f24535b);
        parcel.writeString(this.f24536c);
        parcel.writeString(this.f24537d);
        parcel.writeString(this.f24538e);
    }
}
