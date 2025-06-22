package com.mbridge.msdk.video.module.a.a;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.video.module.MBridgeContainerView;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import com.mbridge.msdk.videocommon.b.c;
import com.mbridge.msdk.videocommon.download.a;

public final class b extends d {

    /* renamed from: k  reason: collision with root package name */
    private MBridgeVideoView f16515k;

    /* renamed from: l  reason: collision with root package name */
    private MBridgeContainerView f16516l;

    public b(MBridgeVideoView mBridgeVideoView, MBridgeContainerView mBridgeContainerView, CampaignEx campaignEx, c cVar, a aVar, String str, String str2, com.mbridge.msdk.video.module.a.a aVar2, int i4, boolean z4) {
        super(campaignEx, aVar, cVar, str, str2, aVar2, i4, z4);
        this.f16515k = mBridgeVideoView;
        this.f16516l = mBridgeContainerView;
        if (mBridgeVideoView == null || mBridgeContainerView == null) {
            this.f16526a = false;
        }
    }

    public final void a(int i4, Object obj) {
        if (this.f16526a) {
            if (i4 == 8) {
                MBridgeContainerView mBridgeContainerView = this.f16516l;
                if (mBridgeContainerView == null) {
                    MBridgeVideoView mBridgeVideoView = this.f16515k;
                    if (mBridgeVideoView != null) {
                        mBridgeVideoView.showAlertView();
                    }
                } else if (!mBridgeContainerView.showAlertWebView()) {
                    MBridgeVideoView mBridgeVideoView2 = this.f16515k;
                    if (mBridgeVideoView2 != null) {
                        mBridgeVideoView2.showAlertView();
                    }
                } else {
                    MBridgeVideoView mBridgeVideoView3 = this.f16515k;
                    if (mBridgeVideoView3 != null) {
                        mBridgeVideoView3.alertWebViewShowed();
                    }
                }
            } else if (i4 == 107) {
                this.f16516l.showVideoClickView(-1);
                this.f16515k.setCover(false);
                this.f16515k.setMiniEndCardState(false);
                this.f16515k.videoOperate(1);
            } else if (i4 == 112) {
                this.f16515k.setCover(true);
                this.f16515k.setMiniEndCardState(true);
                this.f16515k.videoOperate(2);
            } else if (i4 == 115) {
                this.f16516l.resizeMiniCard(this.f16515k.getBorderViewWidth(), this.f16515k.getBorderViewHeight(), this.f16515k.getBorderViewRadius());
            }
        }
        super.a(i4, obj);
    }
}
