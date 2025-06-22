package com.mbridge.msdk.newinterstitial.out;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.same.b;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.newout.RewardVideoListener;
import com.mbridge.msdk.newreward.b.d;
import com.mbridge.msdk.newreward.function.common.MBridgeGlobalCommon;
import com.mbridge.msdk.out.BaseExtraInterfaceForHandler;
import com.mbridge.msdk.reward.b.a;
import com.mbridge.msdk.videocommon.listener.InterVideoOutListener;
import org.json.JSONObject;

public class MBBidNewInterstitialHandler implements BaseExtraInterfaceForHandler {

    /* renamed from: a  reason: collision with root package name */
    private final String f14214a;

    /* renamed from: b  reason: collision with root package name */
    private String f14215b;

    /* renamed from: c  reason: collision with root package name */
    private String f14216c;

    /* renamed from: d  reason: collision with root package name */
    private String f14217d;

    /* renamed from: e  reason: collision with root package name */
    private String f14218e;

    /* renamed from: f  reason: collision with root package name */
    private a f14219f;

    /* renamed from: g  reason: collision with root package name */
    private String f14220g;

    /* renamed from: h  reason: collision with root package name */
    private d f14221h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f14222i = false;

    /* renamed from: j  reason: collision with root package name */
    private NewInterstitialListener f14223j;

    /* renamed from: k  reason: collision with root package name */
    private int f14224k = 2;

    /* renamed from: l  reason: collision with root package name */
    private boolean f14225l = false;

    /* renamed from: m  reason: collision with root package name */
    private boolean f14226m = false;

    /* renamed from: n  reason: collision with root package name */
    private boolean f14227n = false;

    /* renamed from: o  reason: collision with root package name */
    private boolean f14228o = false;

    /* renamed from: p  reason: collision with root package name */
    private int f14229p;

    /* renamed from: q  reason: collision with root package name */
    private int f14230q;

    /* renamed from: r  reason: collision with root package name */
    private int f14231r;

    public MBBidNewInterstitialHandler(Context context, String str, String str2) {
        if (c.m().c() == null && context != null) {
            c.m().b(context);
        }
        String e5 = ak.e(str2);
        if (!TextUtils.isEmpty(e5)) {
            ak.b(str2, e5);
        }
        this.f14214a = str;
        this.f14220g = str2;
    }

    private void a(String str, String str2) {
        try {
            if (this.f14219f == null) {
                a aVar = new a();
                this.f14219f = aVar;
                aVar.a(true);
                this.f14219f.b(true);
                this.f14219f.b(str, str2);
            }
        } catch (Throwable th) {
            af.b("MBBidNewInterstitialHandler", th.getMessage(), th);
        }
    }

    private void b(String str, String str2) {
        if (this.f14221h == null) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            this.f14221h = new d(287, str, str2, true);
        }
    }

    public void clearVideoCache() {
        if (!this.f14222i) {
            try {
                if (this.f14219f != null) {
                    ad.b();
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    public String getCreativeIdWithUnitId() {
        if (this.f14222i) {
            d dVar = this.f14221h;
            if (dVar != null) {
                return dVar.c();
            }
            return "";
        }
        a aVar = this.f14219f;
        if (aVar != null) {
            return aVar.d();
        }
        return "";
    }

    public String getRequestId() {
        if (this.f14222i) {
            d dVar = this.f14221h;
            if (dVar != null) {
                return dVar.b();
            }
            return "";
        }
        a aVar = this.f14219f;
        if (aVar != null) {
            return aVar.a();
        }
        return "";
    }

    public boolean isBidReady() {
        if (this.f14222i) {
            d dVar = this.f14221h;
            if (dVar != null) {
                return dVar.a(true);
            }
            return false;
        }
        a aVar = this.f14219f;
        if (aVar != null) {
            return aVar.d(true);
        }
        return false;
    }

    public void loadFormSelfFilling() {
        boolean a5 = b.a().a("new_bridge_reward_video");
        this.f14222i = a5;
        if (a5) {
            b();
            d dVar = this.f14221h;
            if (dVar != null) {
                dVar.a(false, "");
                return;
            }
            return;
        }
        a();
        if (this.f14219f != null) {
            this.f14219f.a(false, com.mbridge.msdk.foundation.same.report.d.d.a().a(1, 287, this.f14220g, true, 1));
        }
    }

    public void loadFromBid(String str) {
        boolean a5 = b.a().a("new_bridge_reward_video");
        this.f14222i = a5;
        if (a5) {
            b();
            d dVar = this.f14221h;
            if (dVar != null) {
                dVar.a(true, str);
                return;
            }
            return;
        }
        a();
        if (this.f14219f != null) {
            this.f14219f.a(true, str, com.mbridge.msdk.foundation.same.report.d.d.a().a(1, 287, this.f14220g, true, 2));
        }
    }

    public void playVideoMute(int i4) {
        this.f14224k = i4;
        if (this.f14222i) {
            d dVar = this.f14221h;
            if (dVar != null) {
                dVar.a(i4);
                return;
            }
            return;
        }
        a aVar = this.f14219f;
        if (aVar != null) {
            aVar.a(i4);
        }
    }

    public void setAlertDialogText(String str, String str2, String str3, String str4) {
        this.f14216c = str;
        this.f14215b = str2;
        this.f14217d = str3;
        this.f14218e = str4;
        this.f14227n = true;
        this.f14228o = true;
    }

    public void setExtraInfo(JSONObject jSONObject) {
        c.m().a(this.f14220g, jSONObject);
    }

    public void setIVRewardEnable(int i4, int i5) {
        this.f14229p = i4;
        this.f14230q = i5;
        this.f14231r = com.mbridge.msdk.foundation.same.a.f13113K;
    }

    public void setInterstitialVideoListener(NewInterstitialListener newInterstitialListener) {
        this.f14223j = newInterstitialListener;
        this.f14225l = true;
        this.f14226m = true;
    }

    @Deprecated
    public void setRewardVideoListener(NewInterstitialListener newInterstitialListener) {
        this.f14223j = newInterstitialListener;
        this.f14225l = true;
        this.f14226m = true;
    }

    public void showFromBid() {
        if (this.f14222i) {
            b();
            d dVar = this.f14221h;
            if (dVar != null) {
                dVar.a("", "", "");
                return;
            }
            return;
        }
        a();
        if (this.f14219f != null) {
            this.f14219f.a((String) null, (String) null, (String) null, com.mbridge.msdk.foundation.same.report.d.d.a().a(1, 287, this.f14220g, false, -1));
        }
    }

    private void b() {
        if (this.f14221h == null) {
            b(this.f14214a, this.f14220g);
        }
        if (this.f14225l) {
            d dVar = this.f14221h;
            if (dVar != null) {
                dVar.a((RewardVideoListener) new NewInterstitialListenerWrapper(this.f14223j));
            }
            this.f14225l = false;
        }
        if (this.f14228o) {
            MBridgeGlobalCommon.setAlertDialogText(this.f14220g, this.f14216c, this.f14215b, this.f14217d, this.f14218e);
            this.f14228o = false;
        }
        d dVar2 = this.f14221h;
        if (dVar2 != null) {
            dVar2.a(this.f14224k);
            this.f14221h.a(this.f14229p, this.f14231r, this.f14230q);
        }
    }

    public void setIVRewardEnable(int i4, double d5) {
        this.f14229p = i4;
        this.f14230q = (int) (d5 * 100.0d);
        this.f14231r = com.mbridge.msdk.foundation.same.a.f13112J;
    }

    private void a() {
        if (this.f14219f == null) {
            a(this.f14214a, this.f14220g);
        }
        if (this.f14226m) {
            a aVar = this.f14219f;
            if (aVar != null) {
                aVar.a((InterVideoOutListener) new com.mbridge.msdk.newinterstitial.a.a(this.f14223j, this.f14220g, true));
            }
            this.f14226m = false;
        }
        if (this.f14227n) {
            a aVar2 = this.f14219f;
            if (aVar2 != null) {
                aVar2.a(this.f14216c, this.f14215b, this.f14217d, this.f14218e);
            }
            this.f14227n = false;
        }
        a aVar3 = this.f14219f;
        if (aVar3 != null) {
            aVar3.a(this.f14224k);
            this.f14219f.a(this.f14229p, this.f14231r, this.f14230q);
        }
    }

    public MBBidNewInterstitialHandler(String str, String str2) {
        this.f14214a = str;
        this.f14220g = str2;
    }
}
