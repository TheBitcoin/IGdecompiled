package com.mbridge.msdk.newreward.function.c.c;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.newreward.function.c.a.a;
import com.mbridge.msdk.newreward.function.c.a.b;
import java.util.ArrayList;

public final class k extends c {

    /* renamed from: c  reason: collision with root package name */
    private final v f14576c = new v(b(), c(), this);

    public k(b bVar, a aVar) {
        super(bVar, aVar);
    }

    /* access modifiers changed from: protected */
    public final boolean a_() {
        if (c() == null) {
            return false;
        }
        CampaignEx h4 = c().h();
        if (h4 == null || h4.getRewardTemplateMode() == null || TextUtils.isEmpty(h4.getRewardTemplateMode().e())) {
            return true;
        }
        ArrayList<Integer> rsIgnoreCheckRule = h4.getRsIgnoreCheckRule();
        if (rsIgnoreCheckRule != null && !rsIgnoreCheckRule.isEmpty()) {
            try {
                return rsIgnoreCheckRule.contains(1);
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public final int b_() {
        return 2;
    }

    public final String j() {
        CampaignEx h4;
        if (c() == null || (h4 = c().h()) == null || h4.getRewardTemplateMode() == null || TextUtils.isEmpty(h4.getRewardTemplateMode().e())) {
            return "";
        }
        return h4.getRewardTemplateMode().e();
    }

    public final q l() {
        return this.f14576c;
    }
}
