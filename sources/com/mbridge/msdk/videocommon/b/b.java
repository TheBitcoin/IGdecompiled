package com.mbridge.msdk.videocommon.b;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private int f16954a;

    /* renamed from: b  reason: collision with root package name */
    private int f16955b;

    /* renamed from: c  reason: collision with root package name */
    private a f16956c;

    public b(int i4, int i5, a aVar) {
        this.f16954a = i4;
        this.f16955b = i5;
        this.f16956c = aVar;
    }

    public final int a() {
        return this.f16954a;
    }

    public final int b() {
        return this.f16955b;
    }

    public static List<b> a(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            ArrayList arrayList = new ArrayList();
            int i4 = 0;
            while (i4 < jSONArray.length()) {
                try {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i4);
                    int optInt = optJSONObject.optInt("id");
                    int optInt2 = optJSONObject.optInt("timeout");
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("params");
                    arrayList.add(new b(optInt, optInt2, optJSONObject2 != null ? a.a(optJSONObject2) : null));
                    i4++;
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
            return arrayList;
        }
        return null;
    }
}
