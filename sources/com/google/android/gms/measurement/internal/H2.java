package com.google.android.gms.measurement.internal;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.HashMap;
import java.util.concurrent.Callable;

public final /* synthetic */ class H2 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ I2 f2526a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f2527b;

    public /* synthetic */ H2(I2 i22, String str) {
        this.f2526a = i22;
        this.f2527b = str;
    }

    public final Object call() {
        I2 i22 = this.f2526a;
        String str = this.f2527b;
        C0744c2 M02 = i22.n().M0(str);
        HashMap hashMap = new HashMap();
        hashMap.put("platform", "android");
        hashMap.put(CampaignEx.JSON_KEY_PACKAGE_NAME, str);
        hashMap.put("gmp_version", 106000L);
        if (M02 != null) {
            String o4 = M02.o();
            if (o4 != null) {
                hashMap.put("app_version", o4);
            }
            hashMap.put("app_version_int", Long.valueOf(M02.U()));
            hashMap.put("dynamite_version", Long.valueOf(M02.v0()));
        }
        return hashMap;
    }
}
