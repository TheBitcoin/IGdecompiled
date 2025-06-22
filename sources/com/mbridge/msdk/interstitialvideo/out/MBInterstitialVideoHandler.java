package com.mbridge.msdk.interstitialvideo.out;

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
import com.mbridge.msdk.reward.b.a;
import com.mbridge.msdk.videocommon.listener.InterVideoOutListener;

@Deprecated
public class MBInterstitialVideoHandler {

    /* renamed from: a  reason: collision with root package name */
    private String f13814a;

    /* renamed from: b  reason: collision with root package name */
    private a f13815b;

    /* renamed from: c  reason: collision with root package name */
    private String f13816c;

    /* renamed from: d  reason: collision with root package name */
    private String f13817d;

    /* renamed from: e  reason: collision with root package name */
    private String f13818e;

    /* renamed from: f  reason: collision with root package name */
    private String f13819f;

    /* renamed from: g  reason: collision with root package name */
    private String f13820g;

    /* renamed from: h  reason: collision with root package name */
    private d f13821h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f13822i = false;

    /* renamed from: j  reason: collision with root package name */
    private InterstitialVideoListener f13823j;

    /* renamed from: k  reason: collision with root package name */
    private int f13824k = 2;

    /* renamed from: l  reason: collision with root package name */
    private boolean f13825l = false;

    /* renamed from: m  reason: collision with root package name */
    private boolean f13826m = false;

    /* renamed from: n  reason: collision with root package name */
    private boolean f13827n = false;

    /* renamed from: o  reason: collision with root package name */
    private boolean f13828o = false;

    /* renamed from: p  reason: collision with root package name */
    private int f13829p;

    /* renamed from: q  reason: collision with root package name */
    private int f13830q;

    /* renamed from: r  reason: collision with root package name */
    private int f13831r;

    public MBInterstitialVideoHandler(Context context, String str, String str2) {
        if (c.m().c() == null && context != null) {
            c.m().b(context);
        }
        String e5 = ak.e(str2);
        if (!TextUtils.isEmpty(e5)) {
            ak.b(str2, e5);
        }
        this.f13814a = str;
        this.f13816c = str2;
    }

    private void a(String str, String str2) {
        try {
            if (this.f13815b == null) {
                a aVar = new a();
                this.f13815b = aVar;
                aVar.a(true);
                this.f13815b.b(str, str2);
                h.a().e(str2);
            }
        } catch (Throwable th) {
            af.b("MBRewardVideoHandler", th.getMessage(), th);
        }
    }

    private void b(String str, String str2) {
        if (this.f13821h == null) {
            String str3 = "";
            if (TextUtils.isEmpty(str)) {
                str = str3;
            }
            if (!TextUtils.isEmpty(str2)) {
                str3 = str2;
            }
            this.f13821h = new d(287, str, str3, false);
            h.a().e(str2);
        }
    }

    public void clearVideoCache() {
        if (!this.f13822i) {
            try {
                if (this.f13815b != null) {
                    ad.b();
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    public String getCreativeIdWithUnitId() {
        if (this.f13822i) {
            d dVar = this.f13821h;
            if (dVar != null) {
                return dVar.c();
            }
            return "";
        }
        a aVar = this.f13815b;
        if (aVar != null) {
            return aVar.d();
        }
        return "";
    }

    public String getRequestId() {
        if (this.f13822i) {
            d dVar = this.f13821h;
            if (dVar != null) {
                return dVar.b();
            }
            return "";
        }
        a aVar = this.f13815b;
        if (aVar != null) {
            return aVar.a();
        }
        return "";
    }

    public boolean isReady() {
        if (this.f13822i) {
            d dVar = this.f13821h;
            if (dVar != null) {
                return dVar.a(true);
            }
            return false;
        }
        a aVar = this.f13815b;
        if (aVar != null) {
            return aVar.d(true);
        }
        return false;
    }

    public void load() {
        boolean a5 = b.a().a("new_bridge_reward_video");
        this.f13822i = a5;
        if (a5) {
            b();
            d dVar = this.f13821h;
            if (dVar != null) {
                dVar.a(true, "");
                return;
            }
            return;
        }
        a();
        if (this.f13815b != null) {
            this.f13815b.a(true, com.mbridge.msdk.foundation.same.report.d.d.a().a(0, 287, this.f13816c, true, 2));
        }
    }

    public void loadFormSelfFilling() {
        boolean a5 = b.a().a("new_bridge_reward_video");
        this.f13822i = a5;
        if (a5) {
            b();
            d dVar = this.f13821h;
            if (dVar != null) {
                dVar.a(false, "");
                return;
            }
            return;
        }
        a();
        if (this.f13815b != null) {
            this.f13815b.a(false, com.mbridge.msdk.foundation.same.report.d.d.a().a(0, 287, this.f13816c, true, 1));
        }
    }

    public void playVideoMute(int i4) {
        this.f13824k = i4;
        if (this.f13822i) {
            d dVar = this.f13821h;
            if (dVar != null) {
                dVar.a(i4);
                return;
            }
            return;
        }
        a aVar = this.f13815b;
        if (aVar != null) {
            aVar.a(i4);
        }
    }

    public void setAlertDialogText(String str, String str2, String str3, String str4) {
        this.f13817d = str;
        this.f13818e = str2;
        this.f13819f = str3;
        this.f13820g = str4;
        this.f13827n = true;
        this.f13828o = true;
    }

    public void setIVRewardEnable(int i4, int i5) {
        this.f13829p = i4;
        this.f13830q = i5;
        this.f13831r = com.mbridge.msdk.foundation.same.a.f13113K;
    }

    public void setInterstitialVideoListener(InterstitialVideoListener interstitialVideoListener) {
        this.f13823j = interstitialVideoListener;
        this.f13826m = true;
        this.f13825l = true;
    }

    @Deprecated
    public void setRewardVideoListener(InterstitialVideoListener interstitialVideoListener) {
        this.f13823j = interstitialVideoListener;
        this.f13826m = true;
        this.f13825l = true;
    }

    public void show() {
        if (this.f13822i) {
            b();
            d dVar = this.f13821h;
            if (dVar != null) {
                dVar.a("", "", "");
                return;
            }
            return;
        }
        a();
        if (this.f13815b != null) {
            this.f13815b.a((String) null, (String) null, (String) null, com.mbridge.msdk.foundation.same.report.d.d.a().a(0, 287, this.f13816c, false, -1));
        }
    }

    private void b() {
        if (this.f13821h == null) {
            b(this.f13814a, this.f13816c);
        }
        if (this.f13825l) {
            this.f13821h.a((RewardVideoListener) new InterstitialVideoListenerWrapper(this.f13823j));
            this.f13825l = false;
        }
        if (this.f13828o) {
            MBridgeGlobalCommon.setAlertDialogText(this.f13816c, this.f13817d, this.f13818e, this.f13819f, this.f13820g);
            this.f13828o = false;
        }
        d dVar = this.f13821h;
        if (dVar != null) {
            dVar.a(this.f13829p, this.f13831r, this.f13830q);
            this.f13821h.a(this.f13824k);
        }
    }

    public void setIVRewardEnable(int i4, double d5) {
        this.f13829p = i4;
        this.f13830q = (int) (d5 * 100.0d);
        this.f13831r = com.mbridge.msdk.foundation.same.a.f13112J;
    }

    private void a() {
        if (this.f13815b == null) {
            a(this.f13814a, this.f13816c);
        }
        if (this.f13826m) {
            this.f13815b.a((InterVideoOutListener) new com.mbridge.msdk.interstitialvideo.a.a(this.f13823j, this.f13816c, false));
            this.f13826m = false;
        }
        if (this.f13827n) {
            this.f13815b.a(this.f13817d, this.f13818e, this.f13819f, this.f13820g);
            this.f13827n = false;
        }
        a aVar = this.f13815b;
        if (aVar != null) {
            aVar.a(this.f13829p, this.f13831r, this.f13830q);
            this.f13815b.a(this.f13824k);
        }
    }

    public MBInterstitialVideoHandler(String str, String str2) {
        this.f13816c = str2;
        this.f13814a = str;
    }
}
