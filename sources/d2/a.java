package D2;

import android.os.Parcel;
import android.os.Parcelable;
import d4.e;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.m;

public final class a implements Parcelable {
    public static final C0079a CREATOR = new C0079a();

    /* renamed from: a  reason: collision with root package name */
    public final List f6288a;

    /* renamed from: D2.a$a  reason: collision with other inner class name */
    public static final class C0079a implements Parcelable.Creator {
        public Object createFromParcel(Parcel parcel) {
            m.e(parcel, "parcel");
            m.e(parcel, "parcel");
            ArrayList arrayList = new ArrayList();
            parcel.readList(arrayList, e.class.getClassLoader());
            return new a(arrayList);
        }

        public Object[] newArray(int i4) {
            return new a[i4];
        }
    }

    public a(List list) {
        m.e(list, "disclosures");
        this.f6288a = list;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof a) && m.a(this.f6288a, ((a) obj).f6288a)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f6288a.hashCode();
    }

    public String toString() {
        StringBuilder a5 = A2.a.a("PartnersDisclosureArgs(disclosures=");
        a5.append(this.f6288a);
        a5.append(')');
        return a5.toString();
    }

    public void writeToParcel(Parcel parcel, int i4) {
        m.e(parcel, "parcel");
        parcel.writeList(new ArrayList());
    }
}
