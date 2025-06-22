package com.mbridge.msdk.click;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.mbridge.msdk.click.a.a;
import com.mbridge.msdk.click.entity.JumpLoaderResult;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.e.b;

public final class d extends e {

    /* renamed from: a  reason: collision with root package name */
    JumpLoaderResult f12051a = null;

    /* renamed from: b  reason: collision with root package name */
    private int f12052b = 0;

    /* renamed from: c  reason: collision with root package name */
    private String f12053c = null;

    /* renamed from: d  reason: collision with root package name */
    private int f12054d;

    /* renamed from: e  reason: collision with root package name */
    private f f12055e = null;

    /* renamed from: f  reason: collision with root package name */
    private boolean f12056f = true;

    /* renamed from: g  reason: collision with root package name */
    private b f12057g;

    /* renamed from: h  reason: collision with root package name */
    private n f12058h;

    /* renamed from: i  reason: collision with root package name */
    private Handler f12059i = new Handler(Looper.getMainLooper());

    public d(Context context) {
        this.f12057g = new b(context);
        this.f12058h = new n(context);
    }

    public final void a(String str, CampaignEx campaignEx, f fVar, String str2, boolean z4, boolean z5, int i4) {
        String str3;
        boolean z6;
        this.f12053c = str2;
        this.f12055e = fVar;
        this.f12051a = null;
        int i5 = i4;
        this.f12054d = i5;
        boolean z7 = false;
        if (campaignEx != null) {
            if (CampaignEx.CLICKMODE_ON.equals(campaignEx.getClick_mode()) || "6".equals(campaignEx.getClick_mode())) {
                z7 = true;
            }
            str3 = campaignEx.getId();
            z6 = z7;
        } else {
            str3 = "";
            z6 = false;
        }
        String str4 = str2;
        this.f12058h.a(str4, fVar, z6, str3, str, campaignEx, z4, z5, i5);
    }

    public final void a(String str, CampaignEx campaignEx, f fVar) {
        this.f12053c = new String(campaignEx.getClickURL());
        this.f12055e = fVar;
        this.f12051a = null;
        this.f12058h.a(campaignEx.getClickURL(), fVar, CampaignEx.CLICKMODE_ON.equals(campaignEx.getClick_mode()) || "6".equals(campaignEx.getClick_mode()), campaignEx.getId(), str, campaignEx, true, false, a.f12017j);
    }

    public final void a() {
        this.f12056f = false;
    }
}
