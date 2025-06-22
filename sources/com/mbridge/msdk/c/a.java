package com.mbridge.msdk.c;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.foundation.same.net.e.d;
import org.json.JSONObject;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private int f11814a = 1;

    /* renamed from: b  reason: collision with root package name */
    private int f11815b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f11816c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f11817d = 0;

    /* renamed from: e  reason: collision with root package name */
    private String f11818e;

    /* renamed from: f  reason: collision with root package name */
    private String f11819f;

    /* renamed from: g  reason: collision with root package name */
    private int f11820g;

    /* renamed from: h  reason: collision with root package name */
    private int f11821h = 0;

    public static a a(String str) {
        a aVar;
        Exception e5;
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar = new a();
            try {
                aVar.f11818e = jSONObject.optString("http_domain", d.f().f13317g);
                aVar.f11819f = jSONObject.optString("tcp_domain", d.f().f13321k);
                aVar.f11820g = jSONObject.optInt("tcp_port", d.f().f13325o);
                aVar.f11821h = jSONObject.optInt("type", 0);
                int i4 = 1;
                int optInt = jSONObject.optInt("batch_size", 1);
                if (optInt >= 1) {
                    i4 = optInt;
                }
                aVar.f11814a = i4;
                aVar.f11816c = jSONObject.optInt(TypedValues.TransitionType.S_DURATION, 0);
                aVar.f11815b = jSONObject.optInt("disable", 0);
                aVar.f11817d = jSONObject.optInt("e_t_l", 0);
                return aVar;
            } catch (Exception e6) {
                e5 = e6;
                e5.printStackTrace();
                return aVar;
            }
        } catch (Exception e7) {
            e5 = e7;
            aVar = null;
            e5.printStackTrace();
            return aVar;
        }
    }

    public final int b() {
        return this.f11815b;
    }

    public final int c() {
        return this.f11816c;
    }

    public final int d() {
        return this.f11817d;
    }

    public final String e() {
        return this.f11818e;
    }

    public final String f() {
        return this.f11819f;
    }

    public final int g() {
        return this.f11820g;
    }

    public final int h() {
        return this.f11821h;
    }

    public final int a() {
        return this.f11814a;
    }
}
