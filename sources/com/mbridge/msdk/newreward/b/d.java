package com.mbridge.msdk.newreward.b;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.same.a;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newout.RewardVideoListener;
import com.mbridge.msdk.newreward.a.c;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.a.g;
import com.mbridge.msdk.newreward.function.c.a.b;
import com.mbridge.msdk.newreward.function.command.f;
import com.mbridge.msdk.newreward.function.common.MBridgeDailyPlayModel;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.RewardInfo;

public final class d extends a implements RewardVideoListener, c {

    /* renamed from: d  reason: collision with root package name */
    RewardVideoListener f14442d;

    /* renamed from: e  reason: collision with root package name */
    private int f14443e = 2;

    /* renamed from: f  reason: collision with root package name */
    private boolean f14444f = false;

    /* renamed from: g  reason: collision with root package name */
    private int f14445g;

    /* renamed from: h  reason: collision with root package name */
    private int f14446h;

    /* renamed from: i  reason: collision with root package name */
    private int f14447i;

    public d(int i4, String str, String str2, boolean z4) {
        super(i4, str, str2, z4);
        if (i4 == 287) {
            this.f14443e = a.f13126X;
        } else {
            this.f14443e = a.f13125W;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        this.f14433b.a(this.f14432a, this.f14434c);
    }

    public final String b() {
        e b5;
        com.mbridge.msdk.newreward.function.e.a D4;
        b b6;
        c cVar = this.f14433b;
        if (cVar == null || (b5 = cVar.b()) == null || (D4 = b5.D()) == null || (b6 = D4.b()) == null) {
            return "";
        }
        String f4 = b6.f();
        if (TextUtils.isEmpty(f4)) {
            return "";
        }
        return f4;
    }

    public final String c() {
        e b5;
        com.mbridge.msdk.newreward.function.e.a D4;
        b b6;
        c cVar = this.f14433b;
        if (cVar == null || (b5 = cVar.b()) == null || (D4 = b5.D()) == null || (b6 = D4.b()) == null) {
            return "";
        }
        return com.mbridge.msdk.foundation.same.c.a(b6.E());
    }

    public final void onAdClose(MBridgeIds mBridgeIds, RewardInfo rewardInfo) {
        RewardVideoListener rewardVideoListener = this.f14442d;
        if (rewardVideoListener != null) {
            rewardVideoListener.onAdClose(mBridgeIds, rewardInfo);
        }
    }

    public final void onAdCloseWithIVReward(MBridgeIds mBridgeIds, boolean z4, int i4) {
        RewardVideoListener rewardVideoListener = this.f14442d;
        if (rewardVideoListener != null) {
            rewardVideoListener.onAdCloseWithIVReward(mBridgeIds, z4, i4);
        }
    }

    public final void onAdShow(MBridgeIds mBridgeIds) {
        try {
            ((MBridgeDailyPlayModel) this.f14432a.a((Object) null, f.CREATE_DAILY)).insertDailyCap();
        } catch (Exception e5) {
            af.b("RewardVideoController", "updateDailyShowCap error:" + e5.getMessage());
        }
        RewardVideoListener rewardVideoListener = this.f14442d;
        if (rewardVideoListener != null) {
            rewardVideoListener.onAdShow(mBridgeIds);
        }
    }

    public final void onEndcardShow(MBridgeIds mBridgeIds) {
        RewardVideoListener rewardVideoListener = this.f14442d;
        if (rewardVideoListener != null) {
            rewardVideoListener.onEndcardShow(mBridgeIds);
        }
    }

    public final void onLoadSuccess(MBridgeIds mBridgeIds) {
        RewardVideoListener rewardVideoListener = this.f14442d;
        if (rewardVideoListener != null) {
            rewardVideoListener.onLoadSuccess(mBridgeIds);
        }
    }

    public final void onShowFail(MBridgeIds mBridgeIds, String str) {
        RewardVideoListener rewardVideoListener = this.f14442d;
        if (rewardVideoListener != null) {
            rewardVideoListener.onShowFail(mBridgeIds, str);
        }
    }

    public final void onVideoAdClicked(MBridgeIds mBridgeIds) {
        RewardVideoListener rewardVideoListener = this.f14442d;
        if (rewardVideoListener != null) {
            rewardVideoListener.onVideoAdClicked(mBridgeIds);
        }
    }

    public final void onVideoComplete(MBridgeIds mBridgeIds) {
        RewardVideoListener rewardVideoListener = this.f14442d;
        if (rewardVideoListener != null) {
            rewardVideoListener.onVideoComplete(mBridgeIds);
        }
    }

    public final void onVideoLoadFail(MBridgeIds mBridgeIds, String str) {
        RewardVideoListener rewardVideoListener = this.f14442d;
        if (rewardVideoListener != null) {
            rewardVideoListener.onVideoLoadFail(mBridgeIds, str);
        }
    }

    public final void onVideoLoadSuccess(MBridgeIds mBridgeIds) {
        RewardVideoListener rewardVideoListener = this.f14442d;
        if (rewardVideoListener != null) {
            rewardVideoListener.onVideoLoadSuccess(mBridgeIds);
        }
    }

    public final void a(boolean z4, String str) {
        g gVar = new g(this.f14432a);
        String str2 = str;
        e eVar = new e(z4, this.f14434c.e(), str2, this.f14434c.c(), this.f14434c.f());
        eVar.e(this.f14434c.d());
        eVar.e(this.f14443e);
        eVar.d(com.mbridge.msdk.foundation.controller.c.m().k());
        eVar.d(this.f14434c.f() ? 2 : 1);
        eVar.f(com.mbridge.msdk.newreward.function.h.d.a(str2));
        eVar.e(this.f14444f);
        eVar.a(this.f14445g, this.f14446h, this.f14447i);
        this.f14433b.a(eVar, gVar);
    }

    public final void b(boolean z4) {
        this.f14444f = z4;
    }

    public final void a(String str, String str2, String str3) {
        com.mbridge.msdk.newreward.a.f fVar = new com.mbridge.msdk.newreward.a.f();
        fVar.a(str2);
        fVar.b(str3);
        this.f14433b.a(fVar);
    }

    public final boolean a(boolean z4) {
        return this.f14433b.a(z4);
    }

    public final void a(int i4) {
        this.f14443e = i4;
        c cVar = this.f14433b;
        if (cVar != null) {
            for (e e5 : cVar.a()) {
                e5.e(i4);
            }
        }
    }

    public final void a(int i4, int i5, int i6) {
        this.f14445g = i4;
        this.f14446h = i5;
        if (i5 == a.f13113K) {
            this.f14447i = i6 < 0 ? 5 : i6;
        }
        if (i5 == a.f13112J) {
            this.f14447i = i6 < 0 ? 80 : i6;
        }
        com.mbridge.msdk.newreward.function.h.c.a(this.f14434c.c(), i4, i5, i6);
    }

    public final void a(RewardVideoListener rewardVideoListener) {
        this.f14442d = rewardVideoListener;
        this.f14433b.a((Object) this);
    }
}
