package com.mbridge.msdk.foundation.same.net;

import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.foundation.entity.h;
import com.mbridge.msdk.foundation.same.net.a.a;
import com.mbridge.msdk.foundation.same.report.a.b;
import com.mbridge.msdk.foundation.tools.af;
import org.json.JSONObject;

public class c<T> implements b<T> {
    public int adType = 0;
    private b mRequestTime = null;
    public String placementId = "";
    private long startTime;
    public String unitId = "";

    public void calcRequestTime(long j4) {
        b bVar = new b(new h());
        this.mRequestTime = bVar;
        bVar.b(this.unitId);
        this.mRequestTime.b(1);
        b bVar2 = this.mRequestTime;
        bVar2.a((j4 - this.startTime) + "");
    }

    public void onCancel() {
    }

    public void onError(a aVar) {
    }

    public void onFinish() {
    }

    public void onNetworking() {
    }

    public void onPreExecute() {
        this.startTime = System.currentTimeMillis();
    }

    public void onProgressChange(long j4, long j5) {
    }

    public void onRetry() {
    }

    public void onSuccess(d<T> dVar) {
        try {
            String str = com.mbridge.msdk.foundation.controller.c.m().k() + "_" + this.placementId + "_" + this.unitId + "_" + this.adType;
            com.mbridge.msdk.c.h.a();
            af.b("Listener", dVar.f13256c + " " + str);
            T t4 = dVar.f13256c;
            if (t4 instanceof JSONObject) {
                com.mbridge.msdk.foundation.same.net.e.c.a().a(str, ((JSONObject) t4).optInt(NotificationCompat.CATEGORY_STATUS), ((JSONObject) dVar.f13256c).toString(), System.currentTimeMillis());
            }
            if (dVar.f13256c instanceof String) {
                com.mbridge.msdk.foundation.same.net.e.c.a().a(str, new JSONObject((String) dVar.f13256c).optInt(NotificationCompat.CATEGORY_STATUS), (String) dVar.f13256c, System.currentTimeMillis());
            }
        } catch (Exception e5) {
            af.b("Listener", e5.getMessage());
        }
    }

    public void saveHbState(int i4) {
        b bVar = this.mRequestTime;
        if (bVar != null) {
            bVar.c(i4);
        }
    }

    public void saveRequestTime(int i4) {
        b bVar = this.mRequestTime;
        if (bVar != null) {
            bVar.a(i4);
            this.mRequestTime.a();
        }
    }

    public void setAdType(int i4) {
        this.adType = i4;
    }

    public void setPlacementId(String str) {
        this.placementId = str;
    }

    public void setUnitId(String str) {
        this.unitId = str;
    }
}
