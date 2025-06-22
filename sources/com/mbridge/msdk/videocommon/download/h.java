package com.mbridge.msdk.videocommon.download;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import java.util.concurrent.atomic.AtomicBoolean;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    private AtomicBoolean f17105a;

    /* renamed from: b  reason: collision with root package name */
    private AtomicBoolean f17106b;

    private static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final h f17107a = new h();
    }

    public static h a() {
        return a.f17107a;
    }

    public final boolean b(int i4) {
        if (MBridgeConstans.DEBUG) {
            af.c("RewardVideoRefactorManager", "isRewardVideoRefactor adType: " + i4 + ", key: REWARD_VIDEO_REFACTOR_FOR_CAMPAIGN_REQUEST");
        }
        if (i4 != 94 && i4 != 287) {
            return false;
        }
        AtomicBoolean atomicBoolean = this.f17106b;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        try {
            this.f17106b = new AtomicBoolean(ah.a().a("r_v_r_f_c_r", false));
        } catch (Exception e5) {
            this.f17106b = new AtomicBoolean(false);
            if (MBridgeConstans.DEBUG) {
                af.b("RewardVideoRefactorManager", "isRewardVideoRefactor error: " + e5.getMessage());
            }
        }
        return this.f17106b.get();
    }

    private h() {
    }

    public final boolean a(int i4) {
        if (MBridgeConstans.DEBUG) {
            af.c("RewardVideoRefactorManager", "isRewardVideoRefactor adType: " + i4 + ", key: REWARD_VIDEO_REFACTOR_FOR_LOAD");
        }
        if (i4 != 94 && i4 != 287) {
            return false;
        }
        AtomicBoolean atomicBoolean = this.f17105a;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        try {
            this.f17105a = new AtomicBoolean(ah.a().a("r_v_r_f_l", false));
        } catch (Exception e5) {
            this.f17105a = new AtomicBoolean(false);
            if (MBridgeConstans.DEBUG) {
                af.b("RewardVideoRefactorManager", "isRewardVideoRefactor error: " + e5.getMessage());
            }
        }
        return this.f17105a.get();
    }

    public final int a(String str, int i4) {
        try {
            return ah.a().a(str, i4);
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                af.b("RewardVideoRefactorManager", "getRewardVideoCampaignRequestTimeout error: " + e5.getMessage());
            }
            return i4;
        }
    }
}
