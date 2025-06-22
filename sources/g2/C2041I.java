package g2;

import android.database.Cursor;
import kotlin.jvm.internal.m;
import org.json.JSONObject;

/* renamed from: g2.I  reason: case insensitive filesystem */
public final class C2041I {

    /* renamed from: a  reason: collision with root package name */
    private int f20375a = -1;

    /* renamed from: b  reason: collision with root package name */
    private long f20376b = -1;

    /* renamed from: c  reason: collision with root package name */
    private String f20377c;

    /* renamed from: d  reason: collision with root package name */
    private int f20378d = -1;

    public final long a() {
        return this.f20376b;
    }

    public final int b() {
        return this.f20378d;
    }

    public final String c() {
        return this.f20377c;
    }

    public final void d(JSONObject jSONObject) {
        m.e(jSONObject, "jsonObject");
        this.f20376b = jSONObject.optLong("appID");
        this.f20377c = jSONObject.optString("sourceDevice");
    }

    public final void e(Cursor cursor) {
        m.e(cursor, "c");
        this.f20375a = cursor.getInt(0);
        this.f20376b = cursor.getLong(1);
        this.f20377c = cursor.getString(2);
        this.f20378d = cursor.getInt(3);
    }

    public final void f(int i4) {
        this.f20378d = i4;
    }

    public String toString() {
        return "{id=" + this.f20375a + ", appId=" + this.f20376b + ", deviceName=" + this.f20377c + ", downloadId=" + this.f20378d + '}';
    }
}
