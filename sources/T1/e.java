package T1;

import W1.C1610f;
import android.os.Build;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.io.File;
import kotlin.jvm.internal.m;
import org.json.JSONException;
import org.json.JSONObject;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private File f8296a;

    /* renamed from: b  reason: collision with root package name */
    private String f8297b;

    /* renamed from: c  reason: collision with root package name */
    private String f8298c;

    /* renamed from: d  reason: collision with root package name */
    private String f8299d;

    /* renamed from: e  reason: collision with root package name */
    private long f8300e;

    /* renamed from: f  reason: collision with root package name */
    private String f8301f;

    private final void b(JSONObject jSONObject) {
        try {
            if (!jSONObject.isNull(RewardPlus.NAME)) {
                this.f8297b = jSONObject.getString(RewardPlus.NAME);
            }
            if (!jSONObject.isNull("sha256")) {
                this.f8298c = jSONObject.getString("sha256");
            }
            if (!jSONObject.isNull(RewardPlus.ICON)) {
                this.f8299d = jSONObject.getString(RewardPlus.ICON);
            }
            if (!jSONObject.isNull("size")) {
                this.f8300e = jSONObject.getLong("size");
            }
            if (!jSONObject.isNull("senderDeviceName")) {
                this.f8301f = jSONObject.getString("senderDeviceName");
            }
        } catch (JSONException e5) {
            e5.printStackTrace();
        }
    }

    public final void a(File file) {
        m.e(file, "f");
        this.f8296a = file;
        this.f8297b = file.getName();
        this.f8298c = C1610f.f8672a.e(file.getAbsolutePath());
        this.f8300e = file.length();
        this.f8301f = Build.MANUFACTURER + ' ' + Build.MODEL;
    }

    public final void c(String str) {
        m.e(str, "json");
        b(new JSONObject(str));
    }

    public final File d() {
        return this.f8296a;
    }

    public final String e() {
        return this.f8297b;
    }

    public final String f() {
        return this.f8301f;
    }

    public final String g() {
        return this.f8298c;
    }

    public final long h() {
        return this.f8300e;
    }

    public final String i() {
        try {
            JSONObject jSONObject = new JSONObject();
            String str = this.f8297b;
            if (str != null) {
                jSONObject.put(RewardPlus.NAME, str);
            }
            String str2 = this.f8298c;
            if (str2 != null) {
                jSONObject.put("sha256", str2);
            }
            String str3 = this.f8299d;
            if (str3 != null) {
                jSONObject.put(RewardPlus.ICON, str3);
            }
            long j4 = this.f8300e;
            if (j4 > 0) {
                jSONObject.put("size", j4);
            }
            String str4 = this.f8301f;
            if (str4 != null) {
                jSONObject.put("senderDeviceName", str4);
            }
            return jSONObject.toString(2);
        } catch (JSONException e5) {
            e5.printStackTrace();
            return null;
        }
    }
}
