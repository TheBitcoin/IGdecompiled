package com.mbridge.msdk.video.module.a.a;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.video.signal.factory.IJSFactory;
import com.mbridge.msdk.video.signal.j;
import com.mbridge.msdk.videocommon.download.a;

public final class c extends d {

    /* renamed from: k  reason: collision with root package name */
    private IJSFactory f16517k;

    public c(IJSFactory iJSFactory, CampaignEx campaignEx, com.mbridge.msdk.videocommon.b.c cVar, a aVar, String str, String str2, com.mbridge.msdk.video.module.a.a aVar2, int i4, boolean z4) {
        super(campaignEx, aVar, cVar, str, str2, aVar2, i4, z4);
        this.f16517k = iJSFactory;
        if (iJSFactory == null) {
            this.f16526a = false;
        }
    }

    public final void a(int i4, Object obj) {
        if (this.f16526a) {
            if (i4 != 8) {
                if (i4 == 105) {
                    this.f16517k.getJSNotifyProxy().a(3, obj.toString());
                    i4 = -1;
                } else if (i4 == 107) {
                    this.f16517k.getJSContainerModule().showVideoClickView(-1);
                    this.f16517k.getJSVideoModule().setCover(false);
                    this.f16517k.getJSVideoModule().setMiniEndCardState(false);
                    this.f16517k.getJSVideoModule().videoOperate(1);
                } else if (i4 == 112) {
                    this.f16517k.getJSVideoModule().setCover(true);
                    this.f16517k.getJSVideoModule().setMiniEndCardState(true);
                    this.f16517k.getJSVideoModule().videoOperate(2);
                } else if (i4 == 115) {
                    j jSVideoModule = this.f16517k.getJSVideoModule();
                    this.f16517k.getJSContainerModule().resizeMiniCard(jSVideoModule.getBorderViewWidth(), jSVideoModule.getBorderViewHeight(), jSVideoModule.getBorderViewRadius());
                }
            } else if (!this.f16517k.getJSContainerModule().showAlertWebView()) {
                this.f16517k.getJSVideoModule().showAlertView();
            } else {
                this.f16517k.getJSVideoModule().alertWebViewShowed();
            }
        }
        super.a(i4, obj);
    }
}
