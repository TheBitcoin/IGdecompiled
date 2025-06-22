package g2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.work.WorkManager;
import com.uptodown.UptodownApp;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import org.json.JSONObject;
import u2.C2311A;

public final class U implements Parcelable {
    public static Parcelable.Creator<U> CREATOR = new a();

    /* renamed from: m  reason: collision with root package name */
    public static final b f20468m = new b((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private String f20469a;

    /* renamed from: b  reason: collision with root package name */
    private String f20470b;

    /* renamed from: c  reason: collision with root package name */
    private String f20471c;

    /* renamed from: d  reason: collision with root package name */
    private String f20472d;

    /* renamed from: e  reason: collision with root package name */
    private String f20473e;

    /* renamed from: f  reason: collision with root package name */
    private long f20474f = -1;

    /* renamed from: g  reason: collision with root package name */
    private String f20475g = "type0";

    /* renamed from: h  reason: collision with root package name */
    private String f20476h;

    /* renamed from: i  reason: collision with root package name */
    private int f20477i;

    /* renamed from: j  reason: collision with root package name */
    private String f20478j;

    /* renamed from: k  reason: collision with root package name */
    private String f20479k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f20480l;

    public static final class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public U createFromParcel(Parcel parcel) {
            m.e(parcel, "source");
            return new U(parcel);
        }

        /* renamed from: b */
        public U[] newArray(int i4) {
            return new U[i4];
        }
    }

    public static final class b {
        public /* synthetic */ b(C2103g gVar) {
            this();
        }

        public final void a(Context context) {
            m.e(context, "context");
            b(context);
            com.uptodown.activities.preferences.a.f18818a.n1(context, (String) null);
            UptodownApp.a aVar = UptodownApp.f17422D;
            if (aVar.U("PreRegisterWorker", context)) {
                WorkManager.getInstance(context).cancelAllWorkByTag("PreRegisterWorker");
            }
            if (aVar.U("GetUserDataWorker", context)) {
                WorkManager.getInstance(context).cancelAllWorkByTag("GetUserDataWorker");
            }
            C2039G.f20367f.a(context);
            new C2311A().f(context);
        }

        public final void b(Context context) {
            m.e(context, "context");
            SharedPreferences.Editor edit = context.getSharedPreferences("SharedPreferencesUser", 0).edit();
            edit.remove("user_id");
            edit.remove("user_email");
            edit.remove("user_name");
            edit.remove("user_picture");
            edit.remove("registered_timestamp");
            edit.remove("is_turbo");
            edit.remove("username_format");
            edit.remove("background_image");
            edit.apply();
            com.uptodown.activities.preferences.a.f18818a.p1(context, false);
        }

        public final String c(String str) {
            if (str == null) {
                return null;
            }
            return str + UptodownApp.f17422D.q() + ":webp";
        }

        public final String d(String str) {
            if (str == null) {
                return null;
            }
            return str + UptodownApp.f17422D.j() + ":webp";
        }

        public final U e(Context context) {
            U u4;
            m.e(context, "context");
            SharedPreferences sharedPreferences = context.getSharedPreferences("SharedPreferencesUser", 0);
            if (sharedPreferences.contains("user_id")) {
                u4 = new U();
                u4.t(sharedPreferences.getString("user_id", (String) null));
            } else {
                u4 = null;
            }
            if (sharedPreferences.contains("user_email")) {
                if (u4 == null) {
                    u4 = new U();
                }
                u4.s(sharedPreferences.getString("user_email", (String) null));
            }
            if (sharedPreferences.contains("user_name")) {
                if (u4 == null) {
                    u4 = new U();
                }
                u4.u(sharedPreferences.getString("user_name", (String) null));
            }
            if (u4 != null) {
                if (sharedPreferences.contains("user_picture")) {
                    u4.q(sharedPreferences.getString("user_picture", (String) null));
                }
                if (sharedPreferences.contains("registered_timestamp")) {
                    u4.v(sharedPreferences.getLong("registered_timestamp", -1));
                }
                if (sharedPreferences.contains("is_turbo")) {
                    u4.w(sharedPreferences.getString("is_turbo", (String) null));
                }
                if (sharedPreferences.contains("username_format")) {
                    u4.x(sharedPreferences.getString("username_format", "type0"));
                }
                if (sharedPreferences.contains("background_image")) {
                    u4.r(sharedPreferences.getString("background_image", (String) null));
                }
            }
            return u4;
        }

        private b() {
        }
    }

    public U() {
    }

    public final String a() {
        return this.f20471c;
    }

    public final String b() {
        if (this.f20471c == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String str = this.f20471c;
        m.b(str);
        sb.append(str);
        sb.append(UptodownApp.f17422D.i());
        sb.append(":webp");
        return sb.toString();
    }

    public final String c() {
        return f20468m.d(this.f20471c);
    }

    public final String d() {
        return this.f20476h;
    }

    public int describeContents() {
        return hashCode();
    }

    public final void e(Context context, JSONObject jSONObject) {
        m.e(context, "context");
        m.e(jSONObject, "jsonObject");
        JSONObject optJSONObject = jSONObject.optJSONObject("udata");
        if (optJSONObject != null) {
            if (!optJSONObject.isNull("id")) {
                this.f20469a = optJSONObject.optString("id");
            }
            if (!optJSONObject.isNull("username")) {
                this.f20472d = optJSONObject.optString("username");
            }
            if (!optJSONObject.isNull("avatar")) {
                this.f20471c = optJSONObject.optString("avatar");
            }
            if (!optJSONObject.isNull("registeredTimestamp")) {
                this.f20474f = optJSONObject.optLong("registeredTimestamp");
            }
            if (!optJSONObject.isNull("usernameFormat")) {
                this.f20475g = optJSONObject.optString("usernameFormat");
            }
            if (!optJSONObject.isNull("backgroundImage")) {
                this.f20476h = optJSONObject.optString("backgroundImage");
            }
        }
        if (!jSONObject.isNull("utoken")) {
            com.uptodown.activities.preferences.a.f18818a.n1(context, jSONObject.optString("utoken"));
        } else {
            f20468m.b(context);
        }
        if (!jSONObject.isNull("turboToken")) {
            this.f20479k = jSONObject.optString("turboToken");
        }
    }

    public final String f() {
        return this.f20470b;
    }

    public final String g() {
        return this.f20469a;
    }

    public final String h() {
        return this.f20472d;
    }

    public final String i() {
        return this.f20478j;
    }

    public final int j() {
        return this.f20477i;
    }

    public final void k(JSONObject jSONObject) {
        m.e(jSONObject, "jsonObject");
        if (!jSONObject.isNull("userID")) {
            this.f20469a = jSONObject.optString("userID");
        }
        if (!jSONObject.isNull("username")) {
            this.f20472d = jSONObject.optString("username");
        }
        if (!jSONObject.isNull("registeredTimeAgo")) {
            this.f20478j = jSONObject.optString("registeredTimeAgo");
        }
        if (!jSONObject.isNull("avatar")) {
            this.f20471c = jSONObject.optString("avatar");
        }
        if (!jSONObject.isNull("isTurbo")) {
            boolean z4 = true;
            if (jSONObject.optInt("isTurbo") != 1) {
                z4 = false;
            }
            this.f20480l = z4;
        }
        if (!jSONObject.isNull("usernameFormat")) {
            this.f20475g = jSONObject.optString("usernameFormat");
        }
        if (!jSONObject.isNull("reviewsCount")) {
            this.f20477i = jSONObject.optInt("reviewsCount");
        }
        if (!jSONObject.isNull("backgroundImage")) {
            this.f20476h = jSONObject.optString("backgroundImage");
        }
    }

    public final String l() {
        return this.f20475g;
    }

    public final boolean m(Context context) {
        m.e(context, "context");
        if (com.uptodown.activities.preferences.a.f18818a.J(context) != null) {
            return true;
        }
        return false;
    }

    public final boolean n() {
        String str = this.f20479k;
        if ((str == null || str.length() == 0) && !this.f20480l) {
            return false;
        }
        return true;
    }

    public final boolean o() {
        return this.f20480l;
    }

    public final void p(Context context) {
        m.e(context, "context");
        SharedPreferences.Editor edit = context.getSharedPreferences("SharedPreferencesUser", 0).edit();
        edit.putString("user_id", this.f20469a);
        edit.putString("user_email", this.f20470b);
        edit.putString("user_picture", this.f20471c);
        edit.putString("user_name", this.f20472d);
        edit.putLong("registered_timestamp", this.f20474f);
        edit.putString("is_turbo", this.f20479k);
        edit.putString("username_format", this.f20475g);
        edit.putString("background_image", this.f20476h);
        edit.apply();
    }

    public final void q(String str) {
        this.f20471c = str;
    }

    public final void r(String str) {
        this.f20476h = str;
    }

    public final void s(String str) {
        this.f20470b = str;
    }

    public final void t(String str) {
        this.f20469a = str;
    }

    public final void u(String str) {
        this.f20472d = str;
    }

    public final void v(long j4) {
        this.f20474f = j4;
    }

    public final void w(String str) {
        this.f20479k = str;
    }

    public void writeToParcel(Parcel parcel, int i4) {
        m.e(parcel, "parcel");
        parcel.writeString(this.f20469a);
        parcel.writeString(this.f20470b);
        parcel.writeString(this.f20471c);
        parcel.writeString(this.f20472d);
        parcel.writeString(this.f20473e);
        parcel.writeString(this.f20479k);
        parcel.writeString(this.f20475g);
        parcel.writeLong(this.f20474f);
        parcel.writeString(this.f20476h);
        if (this.f20480l) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.f20477i);
        parcel.writeString(this.f20478j);
    }

    public final void x(String str) {
        this.f20475g = str;
    }

    public U(Parcel parcel) {
        m.e(parcel, "source");
        this.f20469a = parcel.readString();
        this.f20470b = parcel.readString();
        this.f20471c = parcel.readString();
        this.f20472d = parcel.readString();
        this.f20473e = parcel.readString();
        this.f20479k = parcel.readString();
        this.f20475g = parcel.readString();
        this.f20474f = parcel.readLong();
        this.f20476h = parcel.readString();
        this.f20480l = parcel.readInt() != 1 ? false : true;
        this.f20477i = parcel.readInt();
        this.f20478j = parcel.readString();
    }
}
