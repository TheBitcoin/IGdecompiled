package com.mbridge.msdk.foundation.same.net.f;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.foundation.same.net.a.a;
import com.mbridge.msdk.foundation.same.net.c;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import org.json.JSONObject;

public abstract class d extends c<JSONObject> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f13338a = "d";

    private void a(com.mbridge.msdk.foundation.same.net.d<JSONObject> dVar) {
        T t4 = dVar.f13256c;
        if (t4 == null) {
            a("response result is null");
            return;
        }
        int optInt = ((JSONObject) t4).optInt(NotificationCompat.CATEGORY_STATUS, -9999);
        if (optInt == -9999) {
            a((JSONObject) dVar.f13256c);
        } else if (optInt == 1 || optInt == 200) {
            a(((JSONObject) dVar.f13256c).optJSONObject(DataSchemeDataSource.SCHEME_DATA));
        } else {
            String optString = ((JSONObject) dVar.f13256c).optString(NotificationCompat.CATEGORY_MESSAGE);
            if (TextUtils.isEmpty(optString)) {
                optString = "error message is null";
            }
            a(optString);
        }
    }

    public abstract void a(String str);

    public abstract void a(JSONObject jSONObject);

    public void onError(a aVar) {
        String str = f13338a;
        af.b(str, "errorCode = " + aVar.f13249a);
        a(com.mbridge.msdk.foundation.same.net.e.a.a(aVar));
    }

    public void onSuccess(com.mbridge.msdk.foundation.same.net.d<JSONObject> dVar) {
        if (dVar == null) {
            a("response is null");
            return;
        }
        super.onSuccess(dVar);
        com.mbridge.msdk.foundation.same.net.d.a aVar = dVar.f13255b;
        if (aVar == null) {
            a(dVar);
        } else if (aVar.f13260d == 204) {
            a(new JSONObject());
        } else {
            a(dVar);
        }
    }
}
