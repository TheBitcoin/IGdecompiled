package com.mbridge.msdk.newreward.function.c.c;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.newreward.function.c.a.a;
import com.mbridge.msdk.newreward.function.c.a.b;

public final class g extends b {

    /* renamed from: b  reason: collision with root package name */
    private final u f14574b = new u(b(), c(), this);

    public g(b bVar, a aVar) {
        super(bVar, aVar);
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
        return this.f14574b;
    }
}
