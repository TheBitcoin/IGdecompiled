package com.mbridge.msdk.dycreator.f;

import com.mbridge.msdk.dycreator.wrapper.DyOption;
import com.mbridge.msdk.foundation.entity.CampaignEx;

public final class a implements com.mbridge.msdk.dycreator.f.a.a {

    /* renamed from: a  reason: collision with root package name */
    private DyOption f12641a;

    /* renamed from: b  reason: collision with root package name */
    private CampaignEx f12642b;

    public a(DyOption dyOption) {
        this.f12641a = dyOption;
        this.f12642b = dyOption.getCampaignEx();
    }

    public final CampaignEx getBindData() {
        return this.f12642b;
    }

    public final DyOption getEffectData() {
        return this.f12641a;
    }
}
