package com.mbridge.msdk.c;

import org.json.JSONObject;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private int f11942a = 1;

    /* renamed from: b  reason: collision with root package name */
    private int f11943b = 1;

    /* renamed from: c  reason: collision with root package name */
    private int f11944c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f11945d = 30;

    /* renamed from: e  reason: collision with root package name */
    private int f11946e = 0;

    /* renamed from: f  reason: collision with root package name */
    private String f11947f;

    /* renamed from: g  reason: collision with root package name */
    private String f11948g;

    /* renamed from: h  reason: collision with root package name */
    private int f11949h;

    /* renamed from: i  reason: collision with root package name */
    private int f11950i = 0;

    public static d a(String str) {
        d dVar;
        Exception e5;
        try {
            JSONObject jSONObject = new JSONObject(str);
            dVar = new d();
            try {
                dVar.f11947f = jSONObject.optString("h_d", com.mbridge.msdk.foundation.same.net.e.d.f().f13315e);
                dVar.f11948g = jSONObject.optString("t_d", com.mbridge.msdk.foundation.same.net.e.d.f().f13320j);
                dVar.f11949h = jSONObject.optInt("t_p", com.mbridge.msdk.foundation.same.net.e.d.f().f13324n);
                dVar.f11950i = jSONObject.optInt("type", 1);
                dVar.f11945d = jSONObject.optInt("d_t", 30);
                dVar.f11944c = jSONObject.optInt("d_a", 0);
                return dVar;
            } catch (Exception e6) {
                e5 = e6;
                e5.printStackTrace();
                return dVar;
            }
        } catch (Exception e7) {
            e5 = e7;
            dVar = null;
            e5.printStackTrace();
            return dVar;
        }
    }

    public final int b() {
        return this.f11945d;
    }

    public final String c() {
        return this.f11947f;
    }

    public final String d() {
        return this.f11948g;
    }

    public final int e() {
        return this.f11949h;
    }

    public final int a() {
        return this.f11944c;
    }
}
