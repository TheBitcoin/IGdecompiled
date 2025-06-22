package com.mbridge.msdk.newreward.player.presenter;

import android.view.View;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d.a;
import com.mbridge.msdk.newreward.function.e.f;
import com.mbridge.msdk.newreward.function.g.e;
import com.mbridge.msdk.newreward.player.iview.ICusTemplateView;
import com.mbridge.msdk.newreward.player.iview.IPlayTempleView;
import com.mbridge.msdk.video.module.MBridgeClickCTAView;
import com.mbridge.msdk.video.signal.factory.b;
import java.lang.reflect.Proxy;

public class PlayPresenter202 extends PlayTemplePresenter {
    ICusTemplateView iTemplateView;
    int interactiveType;
    MBridgeClickCTAView mClickCTAView;
    f settingModel;

    public PlayPresenter202(IPlayTempleView iPlayTempleView) {
        super(iPlayTempleView);
        this.iTemplateView = (ICusTemplateView) Proxy.newProxyInstance(iPlayTempleView.getClass().getClassLoader(), new Class[]{ICusTemplateView.class}, new e(iPlayTempleView, this.adapterModel, this.commandManager));
        f x4 = this.adapterModel.x();
        this.settingModel = x4;
        this.interactiveType = x4.b().g();
    }

    private void addCTAView() {
        if (this.interactiveType >= -1) {
            if (this.mClickCTAView == null) {
                MBridgeClickCTAView mBridgeClickCTAView = new MBridgeClickCTAView(this.context);
                this.mClickCTAView = mBridgeClickCTAView;
                mBridgeClickCTAView.setCampaign(this.campaignEx);
                this.mClickCTAView.setUnitId(this.adapterModel.H());
                this.mClickCTAView.preLoadData((b) null);
                this.mClickCTAView.setCtaClickCallBack(new MBridgeClickCTAView.a() {
                    public void ctaClick() {
                        CampaignEx campaignEx = PlayPresenter202.this.campaignEx;
                        if (campaignEx != null) {
                            campaignEx.setClickTempSource(a.f13395g);
                            PlayPresenter202.this.campaignEx.setTriggerClickSource(a.f13401m);
                        }
                        PlayPresenter202 playPresenter202 = PlayPresenter202.this;
                        playPresenter202.playTempleModel.onAdClick(playPresenter202.mBridgeIds);
                        PlayPresenter202 playPresenter2022 = PlayPresenter202.this;
                        playPresenter2022.playTempleModel.eventClickUrl(playPresenter2022.redirectModel);
                        PlayPresenter202 playPresenter2023 = PlayPresenter202.this;
                        playPresenter2023.playTempleModel.eventTrackingForClick(playPresenter2023.redirectModel);
                    }
                });
            }
            int i4 = this.interactiveType;
            if (i4 >= 0) {
                this.iTemplateView.addCTAViewToLayout(this.mClickCTAView, 0);
            } else if (i4 != -1) {
            } else {
                if (this.iTemplateView.getCTAViewState() != 0) {
                    this.iTemplateView.addCTAViewToLayout(this.mClickCTAView, 0);
                    this.rootParentView.postDelayed(new Runnable() {
                        public void run() {
                            PlayPresenter202 playPresenter202 = PlayPresenter202.this;
                            playPresenter202.iTemplateView.addCTAViewToLayout(playPresenter202.mClickCTAView, 8);
                        }
                    }, 3000);
                    return;
                }
                this.iTemplateView.addCTAViewToLayout(this.mClickCTAView, 8);
            }
        }
    }

    public void click(View view) {
        super.click(view);
        if (view.getId() == filterFindViewId(this.is_dy, "mbridge_vfpv")) {
            addCTAView();
        }
    }

    public void onPlayProgress(int i4, int i5) {
        super.onPlayProgress(i4, i5);
        int i6 = this.interactiveType;
        if (i6 != -1 && i4 == i6) {
            addCTAView();
        }
    }

    public void onPlayStarted(int i4) {
        super.onPlayStarted(i4);
        if (this.interactiveType == 0) {
            addCTAView();
        }
    }
}
