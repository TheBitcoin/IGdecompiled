package g2;

import android.os.Parcel;
import android.os.Parcelable;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.ArrayList;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import org.json.JSONArray;
import org.json.JSONObject;

public final class X implements Parcelable {
    public static Parcelable.Creator<X> CREATOR = new a();

    /* renamed from: g  reason: collision with root package name */
    public static final b f20507g = new b((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private long f20508a;

    /* renamed from: b  reason: collision with root package name */
    private String f20509b;

    /* renamed from: c  reason: collision with root package name */
    private int f20510c;

    /* renamed from: d  reason: collision with root package name */
    private int f20511d;

    /* renamed from: e  reason: collision with root package name */
    private int f20512e;

    /* renamed from: f  reason: collision with root package name */
    private int f20513f;

    public static final class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public X createFromParcel(Parcel parcel) {
            m.e(parcel, "source");
            return new X(parcel);
        }

        /* renamed from: b */
        public X[] newArray(int i4) {
            return new X[i4];
        }
    }

    public static final class b {
        public /* synthetic */ b(C2103g gVar) {
            this();
        }

        public final X a(JSONObject jSONObject) {
            m.e(jSONObject, "jsonObject");
            X x4 = new X();
            if (!jSONObject.isNull("id")) {
                x4.i(jSONObject.optLong("id"));
            }
            if (!jSONObject.isNull(RewardPlus.NAME)) {
                x4.l(jSONObject.optString(RewardPlus.NAME));
            }
            if (!jSONObject.isNull("isInstalled")) {
                x4.j(jSONObject.optInt("isInstalled"));
            }
            if (!jSONObject.isNull("isCompatible")) {
                x4.g(jSONObject.optInt("isCompatible"));
            }
            if (!jSONObject.isNull("isCurrentDevice")) {
                x4.h(jSONObject.optInt("isCurrentDevice"));
            }
            if (!jSONObject.isNull("isLinked")) {
                x4.k(jSONObject.optInt("isLinked"));
            }
            return x4;
        }

        public final ArrayList b(JSONArray jSONArray) {
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

    public X() {
    }

    public final long a() {
        return this.f20508a;
    }

    public final String b() {
        return this.f20509b;
    }

    public final int c() {
        return this.f20512e;
    }

    public final int d() {
        return this.f20510c;
    }

    public int describeContents() {
        return hashCode();
    }

    public final int e() {
        return this.f20511d;
    }

    public final int f() {
        return this.f20513f;
    }

    public final void g(int i4) {
        this.f20512e = i4;
    }

    public final void h(int i4) {
        this.f20510c = i4;
    }

    public final void i(long j4) {
        this.f20508a = j4;
    }

    public final void j(int i4) {
        this.f20511d = i4;
    }

    public final void k(int i4) {
        this.f20513f = i4;
    }

    public final void l(String str) {
        this.f20509b = str;
    }

    public void writeToParcel(Parcel parcel, int i4) {
        m.e(parcel, "parcel");
        parcel.writeLong(this.f20508a);
        parcel.writeString(this.f20509b);
        parcel.writeInt(this.f20511d);
        parcel.writeInt(this.f20512e);
        parcel.writeInt(this.f20510c);
        parcel.writeInt(this.f20513f);
    }

    public X(Parcel parcel) {
        m.e(parcel, "source");
        this.f20508a = parcel.readLong();
        this.f20509b = parcel.readString();
        this.f20511d = parcel.readInt();
        this.f20512e = parcel.readInt();
        this.f20510c = parcel.readInt();
        this.f20513f = parcel.readInt();
    }
}
