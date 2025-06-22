package com.mbridge.msdk.newreward.player.presenter;

import android.view.View;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d.a;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.newreward.function.e.f;
import com.mbridge.msdk.newreward.function.g.e;
import com.mbridge.msdk.newreward.player.iview.ICusTemplateView;
import com.mbridge.msdk.newreward.player.iview.IPlayTempleView;
import com.mbridge.msdk.video.module.MBridgeClickCTAView;
import com.mbridge.msdk.video.signal.factory.b;
import java.lang.reflect.Proxy;

public class PlayPresenter902 extends PlayTemplePresenter {
    ICusTemplateView iTemplateView;
    int iaTp;
    int interactiveType;
    MBridgeClickCTAView mClickCTAView;
    f settingModel;
    String templateUrl;

    public PlayPresenter902(IPlayTempleView iPlayTempleView) {
        super(iPlayTempleView);
        this.iTemplateView = (ICusTemplateView) Proxy.newProxyInstance(iPlayTempleView.getClass().getClassLoader(), new Class[]{ICusTemplateView.class}, new e(iPlayTempleView, this.adapterModel, this.commandManager));
        f x4 = this.adapterModel.x();
        this.settingModel = x4;
        this.interactiveType = x4.b().g();
        CampaignEx campaignEx = this.campaignEx;
        if (campaignEx != null) {
            this.templateUrl = campaignEx.getRewardTemplateMode().e();
        }
        this.iaTp = ak.a(this.templateUrl, "ia_tp", -5);
    }

    private void addCTAView() {
        if (this.mClickCTAView == null) {
            MBridgeClickCTAView mBridgeClickCTAView = new MBridgeClickCTAView(this.context);
            this.mClickCTAView = mBridgeClickCTAView;
            mBridgeClickCTAView.setCampaign(this.campaignEx);
            this.mClickCTAView.setUnitId(this.adapterModel.H());
            this.mClickCTAView.preLoadData((b) null);
            this.mClickCTAView.setCtaClickCallBack(new MBridgeClickCTAView.a() {
                public void ctaClick() {
                    CampaignEx campaignEx = PlayPresenter902.this.campaignEx;
                    if (campaignEx != null) {
                        campaignEx.setClickTempSource(a.f13395g);
                        PlayPresenter902.this.campaignEx.setTriggerClickSource(a.f13401m);
                    }
                    PlayPresenter902 playPresenter902 = PlayPresenter902.this;
                    playPresenter902.playTempleModel.onAdClick(playPresenter902.mBridgeIds);
                    PlayPresenter902 playPresenter9022 = PlayPresenter902.this;
                    playPresenter9022.playTempleModel.eventClickUrl(playPresenter9022.redirectModel);
                    PlayPresenter902 playPresenter9023 = PlayPresenter902.this;
                    playPresenter9023.playTempleModel.eventTrackingForClick(playPresenter9023.redirectModel);
                }
            });
        }
        int i4 = this.iaTp;
        if (i4 != -5) {
            if (i4 != -3) {
                if (i4 == -1) {
                    if (this.iTemplateView.getCTAViewState() != 0) {
                        this.iTemplateView.addCTAViewToLayout(this.mClickCTAView, 0);
                        this.rootParentView.postDelayed(new Runnable() {
                            public void run() {
                                PlayPresenter902 playPresenter902 = PlayPresenter902.this;
                                playPresenter902.iTemplateView.addCTAViewToLayout(playPresenter902.mClickCTAView, 8);
                            }
                        }, 3000);
                    } else {
                        this.iTemplateView.addCTAViewToLayout(this.mClickCTAView, 8);
                    }
                }
                if (this.iaTp >= 0) {
                    this.iTemplateView.addCTAViewToLayout(this.mClickCTAView, 0);
                }
            }
        } else if (this.iTemplateView.getCTAViewState() != 0) {
            this.iTemplateView.addCTAViewToLayout(this.mClickCTAView, 0);
            this.rootParentView.postDelayed(new Runnable() {
                public void run() {
                    PlayPresenter902 playPresenter902 = PlayPresenter902.this;
                    playPresenter902.iTemplateView.addCTAViewToLayout(playPresenter902.mClickCTAView, 8);
                }
            }, 3000);
        } else {
            this.iTemplateView.addCTAViewToLayout(this.mClickCTAView, 8);
        }
    }

    public void click(View view) {
        super.click(view);
        addCTAView();
    }

    public void onPlayProgress(int i4, int i5) {
        super.onPlayProgress(i4, i5);
        int i6 = this.iaTp;
        if (i6 != -5) {
            this.interactiveType = i6;
        }
        int i7 = this.interactiveType;
        if (i7 != -1 && i4 == i7) {
            addCTAView();
        }
    }

    public void onPlayStarted(int i4) {
        super.onPlayStarted(i4);
        if (this.iaTp == 0 || this.interactiveType == 0) {
            addCTAView();
        }
    }
}
