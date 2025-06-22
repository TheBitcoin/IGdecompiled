package com.mbridge.msdk.dycreator.viewmodel;

import com.mbridge.msdk.dycreator.binding.response.SplashResData;
import com.mbridge.msdk.dycreator.bus.EventBus;
import com.mbridge.msdk.dycreator.g.c;
import com.mbridge.msdk.dycreator.g.d;
import com.mbridge.msdk.dycreator.g.f;
import com.mbridge.msdk.dycreator.g.h;
import com.mbridge.msdk.dycreator.wrapper.DynamicViewBackListener;

public class MBCommonViewVModel implements BaseViewModel {

    /* renamed from: a  reason: collision with root package name */
    private d f12646a;

    /* renamed from: b  reason: collision with root package name */
    private c f12647b;

    /* renamed from: c  reason: collision with root package name */
    private f f12648c;

    /* renamed from: d  reason: collision with root package name */
    private h f12649d;

    /* renamed from: e  reason: collision with root package name */
    private DynamicViewBackListener f12650e;

    public MBCommonViewVModel() {
        EventBus.getDefault().register(this);
    }

    public void onEventMainThread(SplashResData splashResData) {
        DynamicViewBackListener dynamicViewBackListener = this.f12650e;
        if (dynamicViewBackListener != null) {
            dynamicViewBackListener.viewClicked(splashResData);
        }
    }

    public void setClickSubject(c cVar) {
        if (cVar != null) {
            this.f12647b = cVar;
        }
    }

    public void setConcreteSubject(d dVar) {
        if (dVar != null) {
            this.f12646a = dVar;
        }
    }

    public void setDynamicViewBackListener(DynamicViewBackListener dynamicViewBackListener) {
        if (dynamicViewBackListener != null) {
            this.f12650e = dynamicViewBackListener;
        }
    }

    public void setEffectSubject(f fVar) {
        if (fVar != null) {
            this.f12648c = fVar;
        }
    }

    public void setModelDataAndBind() {
    }

    public void setReportSubject(h hVar) {
        if (hVar != null) {
            this.f12649d = hVar;
        }
    }
}
