package com.mbridge.msdk.dycreator.binding.response;

import com.mbridge.msdk.dycreator.binding.response.base.BaseRespData;
import com.mbridge.msdk.dycreator.f.a.a;
import com.mbridge.msdk.dycreator.listener.action.EAction;

public class SplashResData extends BaseRespData {

    /* renamed from: a  reason: collision with root package name */
    private a f12572a;

    /* renamed from: b  reason: collision with root package name */
    private EAction f12573b;

    public a getBaseViewData() {
        return this.f12572a;
    }

    public EAction geteAction() {
        return this.f12573b;
    }

    public void setBaseViewData(a aVar) {
        this.f12572a = aVar;
    }

    public void seteAction(EAction eAction) {
        this.f12573b = eAction;
    }
}
