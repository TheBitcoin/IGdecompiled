package com.mbridge.msdk.dycreator.viewmodel;

import com.mbridge.msdk.dycreator.binding.response.SplashResData;
import com.mbridge.msdk.dycreator.bus.EventBus;
import com.mbridge.msdk.dycreator.f.a;
import com.mbridge.msdk.dycreator.g.c;
import com.mbridge.msdk.dycreator.g.d;
import com.mbridge.msdk.dycreator.g.f;
import com.mbridge.msdk.dycreator.g.h;
import com.mbridge.msdk.dycreator.wrapper.DyOption;
import com.mbridge.msdk.dycreator.wrapper.DynamicViewBackListener;

public class MBRewardViewVModel implements BaseViewModel {

    /* renamed from: a  reason: collision with root package name */
    private d f12651a;

    /* renamed from: b  reason: collision with root package name */
    private c f12652b;

    /* renamed from: c  reason: collision with root package name */
    private f f12653c;

    /* renamed from: d  reason: collision with root package name */
    private h f12654d;

    /* renamed from: e  reason: collision with root package name */
    private DynamicViewBackListener f12655e;

    /* renamed from: f  reason: collision with root package name */
    private DyOption f12656f;

    public MBRewardViewVModel(DyOption dyOption) {
        this.f12656f = dyOption;
        EventBus.getDefault().register(this);
    }

    public void onEventMainThread(SplashResData splashResData) {
        DynamicViewBackListener dynamicViewBackListener = this.f12655e;
        if (dynamicViewBackListener != null) {
            dynamicViewBackListener.viewClicked(splashResData);
        }
    }

    public void setClickSubject(c cVar) {
        if (cVar != null) {
            this.f12652b = cVar;
        }
    }

    public void setConcreteSubject(d dVar) {
        if (dVar != null) {
            this.f12651a = dVar;
        }
    }

    public void setDynamicViewBackListener(DynamicViewBackListener dynamicViewBackListener) {
        if (dynamicViewBackListener != null) {
            this.f12655e = dynamicViewBackListener;
        }
    }

    public void setEffectSubject(f fVar) {
        if (fVar != null) {
            this.f12653c = fVar;
        }
    }

    public void setModelDataAndBind() {
        a aVar = new a(this.f12656f);
        d dVar = this.f12651a;
        if (dVar != null) {
            dVar.a(aVar);
        }
        c cVar = this.f12652b;
        if (cVar != null) {
            cVar.a(aVar);
        }
        f fVar = this.f12653c;
        if (fVar != null) {
            fVar.a(aVar);
        }
        h hVar = this.f12654d;
        if (hVar != null) {
            hVar.a(aVar);
        }
    }

    public void setReportSubject(h hVar) {
        if (hVar != null) {
            this.f12654d = hVar;
        }
    }
}
