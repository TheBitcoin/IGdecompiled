package com.mbridge.msdk.newinterstitial.out;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.c.h;
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

public class MBNewInterstitialHandler implements BaseExtraInterfaceForHandler {

    /* renamed from: a  reason: collision with root package name */
    private String f14232a;

    /* renamed from: b  reason: collision with root package name */
    private String f14233b;

    /* renamed from: c  reason: collision with root package name */
    private String f14234c;

    /* renamed from: d  reason: collision with root package name */
    private String f14235d;

    /* renamed from: e  reason: collision with root package name */
    private String f14236e;

    /* renamed from: f  reason: collision with root package name */
    private a f14237f;

    /* renamed from: g  reason: collision with root package name */
    private String f14238g;

    /* renamed from: h  reason: collision with root package name */
    private d f14239h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f14240i = false;

    /* renamed from: j  reason: collision with root package name */
    private NewInterstitialListener f14241j;

    /* renamed from: k  reason: collision with root package name */
    private int f14242k = 2;

    /* renamed from: l  reason: collision with root package name */
    private boolean f14243l = false;

    /* renamed from: m  reason: collision with root package name */
    private boolean f14244m = false;

    /* renamed from: n  reason: collision with root package name */
    private boolean f14245n = false;

    /* renamed from: o  reason: collision with root package name */
    private boolean f14246o = false;

    /* renamed from: p  reason: collision with root package name */
    private int f14247p;

    /* renamed from: q  reason: collision with root package name */
    private int f14248q;

    /* renamed from: r  reason: collision with root package name */
    private int f14249r;

    public MBNewInterstitialHandler(Context context, String str, String str2) {
        if (c.m().c() == null && context != null) {
            c.m().b(context);
        }
        String e5 = ak.e(str2);
        if (!TextUtils.isEmpty(e5)) {
            ak.b(str2, e5);
        }
        this.f14232a = str;
        this.f14238g = str2;
    }

    private void a(String str, String str2) {
        try {
            if (this.f14237f == null) {
                a aVar = new a();
                this.f14237f = aVar;
                aVar.a(true);
                this.f14237f.b(str, str2);
                h.a().e(str2);
            }
        } catch (Throwable th) {
            af.b("MBRewardVideoHandler", th.getMessage(), th);
        }
    }

    private void b(String str, String str2) {
        if (this.f14239h == null) {
            String str3 = "";
            if (TextUtils.isEmpty(str)) {
                str = str3;
            }
            if (!TextUtils.isEmpty(str2)) {
                str3 = str2;
            }
            this.f14239h = new d(287, str, str3, false);
            h.a().e(str2);
        }
    }

    public void clearVideoCache() {
        if (!this.f14240i) {
            try {
                if (this.f14237f != null) {
                    ad.b();
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    public String getCreativeIdWithUnitId() {
        if (this.f14240i) {
            d dVar = this.f14239h;
            if (dVar != null) {
                return dVar.c();
            }
            return "";
        }
        a aVar = this.f14237f;
        if (aVar != null) {
            return aVar.d();
        }
        return "";
    }

    public String getRequestId() {
        if (this.f14240i) {
            d dVar = this.f14239h;
            if (dVar != null) {
                return dVar.b();
            }
            return "";
        }
        a aVar = this.f14237f;
        if (aVar != null) {
            return aVar.a();
        }
        return "";
    }

    public boolean isReady() {
        if (this.f14240i) {
            d dVar = this.f14239h;
            if (dVar != null) {
                return dVar.a(true);
            }
            return false;
        }
        a aVar = this.f14237f;
        if (aVar != null) {
            return aVar.d(true);
        }
        return false;
    }

    public void load() {
        boolean a5 = b.a().a("new_bridge_reward_video");
        this.f14240i = a5;
        if (a5) {
            b();
            d dVar = this.f14239h;
            if (dVar != null) {
                dVar.a(true, "");
                return;
            }
            return;
        }
        a();
        if (this.f14237f != null) {
            this.f14237f.a(true, com.mbridge.msdk.foundation.same.report.d.d.a().a(0, 287, this.f14238g, true, 2));
        }
    }

    public void loadFormSelfFilling() {
        boolean a5 = b.a().a("new_bridge_reward_video");
        this.f14240i = a5;
        if (a5) {
            b();
            d dVar = this.f14239h;
            if (dVar != null) {
                dVar.a(false, "");
                return;
            }
            return;
        }
        a();
        if (this.f14237f != null) {
            this.f14237f.a(false, com.mbridge.msdk.foundation.same.report.d.d.a().a(0, 287, this.f14238g, true, 1));
        }
    }

    public void playVideoMute(int i4) {
        this.f14242k = i4;
        if (this.f14240i) {
            d dVar = this.f14239h;
            if (dVar != null) {
                dVar.a(i4);
                return;
            }
            return;
        }
        a aVar = this.f14237f;
        if (aVar != null) {
            aVar.a(i4);
        }
    }

    public void setAlertDialogText(String str, String str2, String str3, String str4) {
        this.f14233b = str;
        this.f14234c = str2;
        this.f14235d = str3;
        this.f14236e = str4;
        this.f14245n = true;
        this.f14246o = true;
    }

    public void setExtraInfo(JSONObject jSONObject) {
        c.m().a(this.f14238g, jSONObject);
    }

    public void setIVRewardEnable(int i4, int i5) {
        this.f14247p = i4;
        this.f14248q = i5;
        this.f14249r = com.mbridge.msdk.foundation.same.a.f13113K;
    }

    public void setInterstitialVideoListener(NewInterstitialListener newInterstitialListener) {
        this.f14241j = newInterstitialListener;
        this.f14243l = true;
        this.f14244m = true;
    }

    @Deprecated
    public void setRewardVideoListener(NewInterstitialListener newInterstitialListener) {
        this.f14241j = newInterstitialListener;
        this.f14243l = true;
        this.f14244m = true;
    }

    public void show() {
        if (this.f14240i) {
            b();
            d dVar = this.f14239h;
            if (dVar != null) {
                dVar.a("", "", "");
                return;
            }
            return;
        }
        a();
        if (this.f14237f != null) {
            this.f14237f.a((String) null, (String) null, (String) null, com.mbridge.msdk.foundation.same.report.d.d.a().a(0, 287, this.f14238g, false, -1));
        }
    }

    private void b() {
        if (this.f14239h == null) {
            b(this.f14232a, this.f14238g);
        }
        if (this.f14243l) {
            d dVar = this.f14239h;
            if (dVar != null) {
                dVar.a((RewardVideoListener) new NewInterstitialListenerWrapper(this.f14241j));
            }
            this.f14243l = false;
        }
        if (this.f14246o) {
            MBridgeGlobalCommon.setAlertDialogText(this.f14238g, this.f14233b, this.f14234c, this.f14235d, this.f14236e);
            this.f14246o = false;
        }
        d dVar2 = this.f14239h;
        if (dVar2 != null) {
            dVar2.a(this.f14247p, this.f14249r, this.f14248q);
            this.f14239h.a(this.f14242k);
        }
    }

    public void setIVRewardEnable(int i4, double d5) {
        this.f14247p = i4;
        this.f14248q = (int) (d5 * 100.0d);
        this.f14249r = com.mbridge.msdk.foundation.same.a.f13112J;
    }

    private void a() {
        if (this.f14237f == null) {
            a(this.f14232a, this.f14238g);
        }
        if (this.f14244m) {
            a aVar = this.f14237f;
            if (aVar != null) {
                aVar.a((InterVideoOutListener) new com.mbridge.msdk.newinterstitial.a.a(this.f14241j, this.f14238g, false));
            }
            this.f14244m = false;
        }
        if (this.f14245n) {
            a aVar2 = this.f14237f;
            if (aVar2 != null) {
                aVar2.a(this.f14233b, this.f14234c, this.f14235d, this.f14236e);
            }
            this.f14245n = false;
        }
        a aVar3 = this.f14237f;
        if (aVar3 != null) {
            aVar3.a(this.f14247p, this.f14249r, this.f14248q);
            this.f14237f.a(this.f14242k);
        }
    }

    public MBNewInterstitialHandler(String str, String str2) {
        this.f14232a = str;
        this.f14238g = str2;
    }
}
