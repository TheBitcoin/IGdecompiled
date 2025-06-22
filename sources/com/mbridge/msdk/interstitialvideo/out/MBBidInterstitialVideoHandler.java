package com.mbridge.msdk.interstitialvideo.out;

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
import com.mbridge.msdk.reward.b.a;
import com.mbridge.msdk.videocommon.listener.InterVideoOutListener;

@Deprecated
public class MBBidInterstitialVideoHandler {

    /* renamed from: a  reason: collision with root package name */
    private a f13796a;

    /* renamed from: b  reason: collision with root package name */
    private String f13797b;

    /* renamed from: c  reason: collision with root package name */
    private String f13798c;

    /* renamed from: d  reason: collision with root package name */
    private String f13799d;

    /* renamed from: e  reason: collision with root package name */
    private String f13800e;

    /* renamed from: f  reason: collision with root package name */
    private String f13801f;

    /* renamed from: g  reason: collision with root package name */
    private String f13802g;

    /* renamed from: h  reason: collision with root package name */
    private d f13803h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f13804i = false;

    /* renamed from: j  reason: collision with root package name */
    private InterstitialVideoListener f13805j;

    /* renamed from: k  reason: collision with root package name */
    private int f13806k = 2;

    /* renamed from: l  reason: collision with root package name */
    private boolean f13807l = false;

    /* renamed from: m  reason: collision with root package name */
    private boolean f13808m = false;

    /* renamed from: n  reason: collision with root package name */
    private boolean f13809n = false;

    /* renamed from: o  reason: collision with root package name */
    private boolean f13810o = false;

    /* renamed from: p  reason: collision with root package name */
    private int f13811p;

    /* renamed from: q  reason: collision with root package name */
    private int f13812q;

    /* renamed from: r  reason: collision with root package name */
    private int f13813r;

    public MBBidInterstitialVideoHandler(Context context, String str, String str2) {
        if (c.m().c() == null && context != null) {
            c.m().b(context);
        }
        String e5 = ak.e(str2);
        if (!TextUtils.isEmpty(e5)) {
            ak.b(str2, e5);
        }
        this.f13797b = str2;
        this.f13798c = str;
    }

    private void a(String str, String str2) {
        try {
            if (this.f13796a == null) {
                a aVar = new a();
                this.f13796a = aVar;
                aVar.a(true);
                this.f13796a.b(true);
                this.f13796a.b(str, str2);
            }
        } catch (Throwable th) {
            af.b("MBBidRewardVideoHandler", th.getMessage(), th);
        }
    }

    private void b(String str, String str2) {
        if (this.f13803h == null) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            this.f13803h = new d(287, str, str2, true);
        }
    }

    public void clearVideoCache() {
        if (!this.f13804i) {
            try {
                if (this.f13796a != null) {
                    ad.b();
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    public String getCreativeIdWithUnitId() {
        if (this.f13804i) {
            d dVar = this.f13803h;
            if (dVar != null) {
                return dVar.c();
            }
            return "";
        }
        a aVar = this.f13796a;
        if (aVar != null) {
            return aVar.d();
        }
        return "";
    }

    public String getRequestId() {
        if (this.f13804i) {
            d dVar = this.f13803h;
            if (dVar != null) {
                return dVar.b();
            }
            return "";
        }
        a aVar = this.f13796a;
        if (aVar != null) {
            return aVar.a();
        }
        return "";
    }

    public boolean isBidReady() {
        if (this.f13804i) {
            d dVar = this.f13803h;
            if (dVar != null) {
                return dVar.a(true);
            }
            return false;
        }
        a aVar = this.f13796a;
        if (aVar != null) {
            return aVar.d(true);
        }
        return false;
    }

    public void loadFormSelfFilling() {
        boolean a5 = b.a().a("new_bridge_reward_video");
        this.f13804i = a5;
        if (a5) {
            b();
            d dVar = this.f13803h;
            if (dVar != null) {
                dVar.a(false, "");
                return;
            }
            return;
        }
        a();
        if (this.f13796a != null) {
            this.f13796a.a(false, com.mbridge.msdk.foundation.same.report.d.d.a().a(1, 287, this.f13797b, true, 1));
        }
    }

    public void loadFromBid(String str) {
        boolean a5 = b.a().a("new_bridge_reward_video");
        this.f13804i = a5;
        if (a5) {
            b();
            d dVar = this.f13803h;
            if (dVar != null) {
                dVar.a(true, str);
                return;
            }
            return;
        }
        a();
        if (this.f13796a != null) {
            this.f13796a.a(true, str, com.mbridge.msdk.foundation.same.report.d.d.a().a(1, 287, this.f13797b, true, 2));
        }
    }

    public void playVideoMute(int i4) {
        this.f13806k = i4;
        if (this.f13804i) {
            d dVar = this.f13803h;
            if (dVar != null) {
                dVar.a(i4);
                return;
            }
            return;
        }
        a aVar = this.f13796a;
        if (aVar != null) {
            aVar.a(i4);
        }
    }

    public void setAlertDialogText(String str, String str2, String str3, String str4) {
        this.f13799d = str;
        this.f13800e = str2;
        this.f13801f = str3;
        this.f13802g = str4;
        this.f13809n = true;
        this.f13810o = true;
    }

    public void setIVRewardEnable(int i4, int i5) {
        this.f13811p = i4;
        this.f13812q = i5;
        this.f13813r = com.mbridge.msdk.foundation.same.a.f13113K;
    }

    public void setInterstitialVideoListener(InterstitialVideoListener interstitialVideoListener) {
        this.f13805j = interstitialVideoListener;
        this.f13808m = true;
        this.f13807l = true;
    }

    @Deprecated
    public void setRewardVideoListener(InterstitialVideoListener interstitialVideoListener) {
        this.f13805j = interstitialVideoListener;
        this.f13808m = true;
        this.f13807l = true;
    }

    public void showFromBid() {
        if (this.f13804i) {
            b();
            d dVar = this.f13803h;
            if (dVar != null) {
                dVar.a("", "", "");
                return;
            }
            return;
        }
        a();
        if (this.f13796a != null) {
            this.f13796a.a((String) null, (String) null, (String) null, com.mbridge.msdk.foundation.same.report.d.d.a().a(1, 287, this.f13797b, false, -1));
        }
    }

    private void b() {
        if (this.f13803h == null) {
            b(this.f13798c, this.f13797b);
        }
        if (this.f13807l) {
            d dVar = this.f13803h;
            if (dVar != null) {
                dVar.a((RewardVideoListener) new InterstitialVideoListenerWrapper(this.f13805j));
            }
            this.f13807l = false;
        }
        if (this.f13810o) {
            MBridgeGlobalCommon.setAlertDialogText(this.f13797b, this.f13799d, this.f13800e, this.f13801f, this.f13802g);
            this.f13810o = false;
        }
        d dVar2 = this.f13803h;
        if (dVar2 != null) {
            dVar2.a(this.f13811p, this.f13813r, this.f13812q);
            this.f13803h.a(this.f13806k);
        }
    }

    public void setIVRewardEnable(int i4, double d5) {
        this.f13811p = i4;
        this.f13812q = (int) (d5 * 100.0d);
        this.f13813r = com.mbridge.msdk.foundation.same.a.f13112J;
    }

    private void a() {
        if (this.f13796a == null) {
            a(this.f13798c, this.f13797b);
        }
        if (this.f13808m) {
            a aVar = this.f13796a;
            if (aVar != null) {
                aVar.a((InterVideoOutListener) new com.mbridge.msdk.interstitialvideo.a.a(this.f13805j, this.f13797b, true));
            }
            this.f13808m = false;
        }
        if (this.f13809n) {
            a aVar2 = this.f13796a;
            if (aVar2 != null) {
                aVar2.a(this.f13799d, this.f13800e, this.f13801f, this.f13802g);
            }
            this.f13809n = false;
        }
        a aVar3 = this.f13796a;
        if (aVar3 != null) {
            aVar3.a(this.f13811p, this.f13813r, this.f13812q);
            this.f13796a.a(this.f13806k);
        }
    }

    public MBBidInterstitialVideoHandler(String str, String str2) {
        this.f13797b = str2;
        this.f13798c = str;
    }
}
