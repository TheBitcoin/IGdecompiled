package com.mbridge.msdk.newreward.function.c.c;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.newreward.function.c.a.a;
import com.mbridge.msdk.newreward.function.c.a.b;

public final class l extends a<String> {
    public l(b bVar, a aVar) {
        super(bVar, aVar);
    }

    public final int b_() {
        return 5;
    }

    /* renamed from: g */
    public final String a() {
        CampaignEx h4;
        if (c() == null || (h4 = c().h()) == null || TextUtils.isEmpty(h4.getMraid())) {
            return "";
        }
        return h4.getMraid();
    }

    public final boolean h() {
        return true;
    }

    public final String j() {
        return "";
    }

    public final boolean k() {
        return true;
    }

    public final q l() {
        return new w(b(), c(), this);
    }
}
