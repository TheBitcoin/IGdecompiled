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

@Deprecated
public class MBBidInterstitialVideoHandler implements BaseExtraInterfaceForHandler {

    /* renamed from: a  reason: collision with root package name */
    private String f14197a;

    /* renamed from: b  reason: collision with root package name */
    private String f14198b;

    /* renamed from: c  reason: collision with root package name */
    private String f14199c;

    /* renamed from: d  reason: collision with root package name */
    private String f14200d;

    /* renamed from: e  reason: collision with root package name */
    private String f14201e;

    /* renamed from: f  reason: collision with root package name */
    private a f14202f;

    /* renamed from: g  reason: collision with root package name */
    private d f14203g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f14204h = false;

    /* renamed from: i  reason: collision with root package name */
    private NewInterstitialListener f14205i;

    /* renamed from: j  reason: collision with root package name */
    private int f14206j = 2;

    /* renamed from: k  reason: collision with root package name */
    private boolean f14207k = false;

    /* renamed from: l  reason: collision with root package name */
    private boolean f14208l = false;

    /* renamed from: m  reason: collision with root package name */
    private boolean f14209m = false;
    public String mUnitId;

    /* renamed from: n  reason: collision with root package name */
    private boolean f14210n = false;

    /* renamed from: o  reason: collision with root package name */
    private int f14211o;

    /* renamed from: p  reason: collision with root package name */
    private int f14212p;

    /* renamed from: q  reason: collision with root package name */
    private int f14213q;

    public MBBidInterstitialVideoHandler(Context context, String str, String str2) {
        if (c.m().c() == null && context != null) {
            c.m().b(context);
        }
        String e5 = ak.e(str2);
        if (!TextUtils.isEmpty(e5)) {
            ak.b(str2, e5);
        }
        this.mUnitId = str2;
        this.f14197a = str;
    }

    private void a(String str, String str2) {
        try {
            if (this.f14202f == null) {
                a aVar = new a();
                this.f14202f = aVar;
                aVar.a(true);
                this.f14202f.b(true);
                this.f14202f.b(str, str2);
            }
        } catch (Throwable th) {
            af.b("MBBidInterstitialVideoHandler", th.getMessage(), th);
        }
    }

    private void b(String str, String str2) {
        if (this.f14203g == null) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            this.f14203g = new d(287, str, str2, true);
        }
    }

    private void c() {
        if (this.f14203g == null) {
            b(this.f14197a, this.mUnitId);
        }
        d();
    }

    private void d() {
        if (this.f14207k) {
            d dVar = this.f14203g;
            if (dVar != null) {
                dVar.a((RewardVideoListener) new NewInterstitialListenerWrapper(this.f14205i));
            }
            this.f14207k = false;
        }
        if (this.f14210n) {
            MBridgeGlobalCommon.setAlertDialogText(this.mUnitId, this.f14199c, this.f14198b, this.f14200d, this.f14201e);
            this.f14210n = false;
        }
        d dVar2 = this.f14203g;
        if (dVar2 != null) {
            dVar2.a(this.f14211o, this.f14213q, this.f14212p);
            this.f14203g.a(this.f14206j);
        }
    }

    public void clearVideoCache() {
        if (!this.f14204h) {
            try {
                if (this.f14202f != null) {
                    ad.b();
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    public String getCreativeIdWithUnitId() {
        if (this.f14204h) {
            d dVar = this.f14203g;
            if (dVar != null) {
                return dVar.c();
            }
            return "";
        }
        a aVar = this.f14202f;
        if (aVar != null) {
            return aVar.d();
        }
        return "";
    }

    public String getRequestId() {
        if (this.f14204h) {
            d dVar = this.f14203g;
            if (dVar != null) {
                return dVar.b();
            }
            return "";
        }
        a aVar = this.f14202f;
        if (aVar != null) {
            return aVar.a();
        }
        return "";
    }

    public boolean isBidReady() {
        if (this.f14204h) {
            d dVar = this.f14203g;
            if (dVar != null) {
                return dVar.a(true);
            }
            return false;
        }
        a aVar = this.f14202f;
        if (aVar != null) {
            return aVar.d(true);
        }
        return false;
    }

    public void loadFormSelfFilling() {
        boolean a5 = b.a().a("new_bridge_reward_video");
        this.f14204h = a5;
        if (a5) {
            c();
            d dVar = this.f14203g;
            if (dVar != null) {
                dVar.a(false, "");
                return;
            }
            return;
        }
        a();
        if (this.f14202f != null) {
            this.f14202f.a(false, com.mbridge.msdk.foundation.same.report.d.d.a().a(1, 287, this.mUnitId, true, 1));
        }
    }

    public void loadFromBid(String str) {
        boolean a5 = b.a().a("new_bridge_reward_video");
        this.f14204h = a5;
        if (a5) {
            c();
            d dVar = this.f14203g;
            if (dVar != null) {
                dVar.a(true, str);
                return;
            }
            return;
        }
        a();
        if (this.f14202f != null) {
            this.f14202f.a(true, str, com.mbridge.msdk.foundation.same.report.d.d.a().a(1, 287, this.mUnitId, true, 2));
        }
    }

    public void playVideoMute(int i4) {
        this.f14206j = i4;
        if (this.f14204h) {
            d dVar = this.f14203g;
            if (dVar != null) {
                dVar.a(i4);
                return;
            }
            return;
        }
        a aVar = this.f14202f;
        if (aVar != null) {
            aVar.a(i4);
        }
    }

    public void setAlertDialogText(String str, String str2, String str3, String str4) {
        this.f14199c = str;
        this.f14198b = str2;
        this.f14200d = str3;
        this.f14201e = str4;
        this.f14210n = true;
        this.f14209m = true;
    }

    public void setExtraInfo(JSONObject jSONObject) {
        c.m().a(this.mUnitId, jSONObject);
    }

    public void setIVRewardEnable(int i4, int i5) {
        this.f14211o = i4;
        this.f14212p = i5;
        this.f14213q = com.mbridge.msdk.foundation.same.a.f13113K;
    }

    public void setInterstitialVideoListener(NewInterstitialListener newInterstitialListener) {
        this.f14205i = newInterstitialListener;
        this.f14207k = true;
        this.f14208l = true;
    }

    @Deprecated
    public void setRewardVideoListener(NewInterstitialListener newInterstitialListener) {
        this.f14205i = newInterstitialListener;
        this.f14207k = true;
        this.f14208l = true;
    }

    public void showFromBid() {
        if (this.f14204h) {
            c();
            d dVar = this.f14203g;
            if (dVar != null) {
                dVar.a("", "", "");
                return;
            }
            return;
        }
        a();
        if (this.f14202f != null) {
            this.f14202f.a((String) null, (String) null, (String) null, com.mbridge.msdk.foundation.same.report.d.d.a().a(1, 287, this.mUnitId, false, -1));
        }
    }

    private void b() {
        if (this.f14208l) {
            a aVar = this.f14202f;
            if (aVar != null) {
                aVar.a((InterVideoOutListener) new com.mbridge.msdk.newinterstitial.a.a(this.f14205i));
            }
            this.f14208l = false;
        }
        if (this.f14209m) {
            a aVar2 = this.f14202f;
            if (aVar2 != null) {
                aVar2.a(this.f14199c, this.f14198b, this.f14200d, this.f14201e);
            }
            this.f14209m = false;
        }
        a aVar3 = this.f14202f;
        if (aVar3 != null) {
            aVar3.a(this.f14211o, this.f14213q, this.f14212p);
            this.f14202f.a(this.f14206j);
        }
    }

    public void setIVRewardEnable(int i4, double d5) {
        this.f14211o = i4;
        this.f14212p = (int) (d5 * 100.0d);
        this.f14213q = com.mbridge.msdk.foundation.same.a.f13112J;
    }

    private void a() {
        if (this.f14202f == null) {
            a(this.f14197a, this.mUnitId);
        }
        b();
    }

    public MBBidInterstitialVideoHandler(String str, String str2) {
        this.mUnitId = str2;
        this.f14197a = str;
    }
}
