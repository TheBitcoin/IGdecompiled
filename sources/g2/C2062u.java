package g2;

import android.os.Parcel;
import android.os.Parcelable;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.util.ArrayList;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: g2.u  reason: case insensitive filesystem */
public final class C2062u implements Parcelable {
    public static Parcelable.Creator<C2062u> CREATOR = new a();

    /* renamed from: c  reason: collision with root package name */
    public static final b f20772c = new b((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private String f20773a;

    /* renamed from: b  reason: collision with root package name */
    private String f20774b;

    /* renamed from: g2.u$a */
    public static final class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public C2062u createFromParcel(Parcel parcel) {
            m.e(parcel, "source");
            return new C2062u(parcel);
        }

        /* renamed from: b */
        public C2062u[] newArray(int i4) {
            return new C2062u[i4];
        }
    }

    /* renamed from: g2.u$b */
    public static final class b {
        public /* synthetic */ b(C2103g gVar) {
            this();
        }

        public final ArrayList a(JSONObject jSONObject) {
            int i4;
            m.e(jSONObject, "jsonObject");
            ArrayList arrayList = new ArrayList();
            try {
                if (!jSONObject.isNull("success")) {
                    i4 = jSONObject.optInt("success", 0);
                } else {
                    i4 = 1;
                }
                JSONArray optJSONArray = jSONObject.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
                if (i4 == 1 && optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i5 = 0; i5 < length; i5++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i5);
                        C2062u uVar = new C2062u();
                        m.b(optJSONObject);
                        uVar.c(optJSONObject);
                        arrayList.add(uVar);
                    }
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            return arrayList;
        }

        private b() {
        }
    }

    public C2062u(Parcel parcel) {
        m.e(parcel, "source");
        this.f20773a = parcel.readString();
        this.f20774b = parcel.readString();
    }

    public final String a() {
        return this.f20774b;
    }

    public final String b() {
        return this.f20773a;
    }

    public final void c(JSONObject jSONObject) {
        m.e(jSONObject, "jsonObject");
        try {
            if (!jSONObject.isNull("question")) {
                this.f20773a = jSONObject.optString("question");
            }
            if (!jSONObject.isNull("answer")) {
                this.f20774b = jSONObject.optString("answer");
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public int describeContents() {
        return hashCode();
    }

    public void writeToParcel(Parcel parcel, int i4) {
        m.e(parcel, "parcel");
        parcel.writeString(this.f20773a);
        parcel.writeString(this.f20774b);
    }

    public C2062u() {
    }
}
