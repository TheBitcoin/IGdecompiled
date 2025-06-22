package com.mbridge.msdk.c;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public int f11951a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap<String, f> f11952b;

    static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final e f11953a = new e();
    }

    public static e a() {
        return a.f11953a;
    }

    public final void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (this.f11952b == null) {
                    this.f11952b = new HashMap<>();
                }
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    String string = jSONObject.getString(next);
                    f fVar = new f();
                    fVar.a(next);
                    fVar.b(string);
                    this.f11952b.put(next, fVar);
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    private e() {
        this.f11951a = 6;
        this.f11952b = new HashMap<>();
    }

    public final int a(String str) {
        HashMap<String, f> hashMap;
        f fVar;
        if (TextUtils.isEmpty(str) || (hashMap = this.f11952b) == null || !hashMap.containsKey(str) || (fVar = this.f11952b.get(str)) == null) {
            return 0;
        }
        int i4 = fVar.b() ? 1 : fVar.a() >= this.f11951a ? 2 : 0;
        fVar.a(false);
        return i4;
    }
}
