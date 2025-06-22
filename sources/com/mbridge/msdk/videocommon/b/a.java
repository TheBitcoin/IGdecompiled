package com.mbridge.msdk.videocommon.b;

import org.json.JSONObject;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private String f16952a;

    /* renamed from: b  reason: collision with root package name */
    private String f16953b;

    private a(String str, String str2) {
        this.f16952a = str;
        this.f16953b = str2;
    }

    public static a a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return new a(jSONObject.optString("appId"), jSONObject.optString("placementId"));
        } catch (Exception e5) {
            e5.printStackTrace();
            return null;
        }
    }
}
