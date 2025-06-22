package com.mbridge.msdk.video.module.a.a;

import android.os.Handler;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.dycreator.baseview.cusview.SoundImageView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.video.bt.module.b.f;
import com.mbridge.msdk.video.module.MBridgeContainerView;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import com.mbridge.msdk.videocommon.b.c;
import com.mbridge.msdk.videocommon.download.a;
import java.util.Timer;
import java.util.TimerTask;

public final class m extends o {
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public MBridgeVideoView f16543l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public MBridgeContainerView f16544m;

    /* renamed from: n  reason: collision with root package name */
    private int f16545n;

    /* renamed from: o  reason: collision with root package name */
    private Timer f16546o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public Handler f16547p = new Handler();

    /* renamed from: q  reason: collision with root package name */
    private boolean f16548q = false;

    /* renamed from: r  reason: collision with root package name */
    private boolean f16549r = false;

    /* renamed from: s  reason: collision with root package name */
    private boolean f16550s = false;

    /* renamed from: t  reason: collision with root package name */
    private int f16551t;

    /* renamed from: u  reason: collision with root package name */
    private int f16552u;

    /* renamed from: v  reason: collision with root package name */
    private MBridgeVideoView.a f16553v;

    public m(MBridgeVideoView mBridgeVideoView, MBridgeContainerView mBridgeContainerView, CampaignEx campaignEx, c cVar, a aVar, String str, String str2, int i4, int i5, com.mbridge.msdk.video.module.a.a aVar2, int i6, boolean z4, int i7) {
        super(campaignEx, cVar, aVar, str, str2, aVar2, i6, z4);
        boolean z5;
        this.f16543l = mBridgeVideoView;
        this.f16544m = mBridgeContainerView;
        this.f16552u = i4;
        this.f16545n = i5;
        this.f16551t = i7;
        if (mBridgeVideoView != null) {
            if (mBridgeVideoView.getVideoSkipTime() == 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            this.f16548q = z5;
        }
        if (mBridgeVideoView == null || mBridgeContainerView == null) {
            this.f16526a = false;
        }
    }

    private void i() {
        try {
            Timer timer = this.f16546o;
            if (timer != null) {
                timer.cancel();
                this.f16546o = null;
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void j() {
        /*
            r4 = this;
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r4.f16527b
            if (r0 == 0) goto L_0x0070
            int r0 = r0.getDynamicTempCode()
            r1 = 5
            if (r0 != r1) goto L_0x0070
            com.mbridge.msdk.video.module.MBridgeVideoView r0 = r4.f16543l
            if (r0 == 0) goto L_0x005c
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r0 = r0.mCampOrderViewData
            if (r0 == 0) goto L_0x005c
            r0 = 0
            r1 = 0
        L_0x0015:
            com.mbridge.msdk.video.module.MBridgeVideoView r2 = r4.f16543l
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r2 = r2.mCampOrderViewData
            int r2 = r2.size()
            if (r1 >= r2) goto L_0x0045
            com.mbridge.msdk.video.module.MBridgeVideoView r2 = r4.f16543l
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r2 = r2.mCampOrderViewData
            java.lang.Object r2 = r2.get(r1)
            if (r2 == 0) goto L_0x0042
            com.mbridge.msdk.video.module.MBridgeVideoView r2 = r4.f16543l
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r2 = r2.mCampOrderViewData
            java.lang.Object r2 = r2.get(r1)
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = (com.mbridge.msdk.foundation.entity.CampaignEx) r2
            java.lang.String r2 = r2.getId()
            com.mbridge.msdk.foundation.entity.CampaignEx r3 = r4.f16527b
            java.lang.String r3 = r3.getId()
            if (r2 != r3) goto L_0x0042
            int r0 = r1 + -1
            goto L_0x0045
        L_0x0042:
            int r1 = r1 + 1
            goto L_0x0015
        L_0x0045:
            if (r0 < 0) goto L_0x005c
            com.mbridge.msdk.video.module.MBridgeVideoView r1 = r4.f16543l
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r1 = r1.mCampOrderViewData
            java.lang.Object r1 = r1.get(r0)
            if (r1 == 0) goto L_0x005c
            com.mbridge.msdk.video.module.MBridgeVideoView r1 = r4.f16543l
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r1 = r1.mCampOrderViewData
            java.lang.Object r0 = r1.get(r0)
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = (com.mbridge.msdk.foundation.entity.CampaignEx) r0
            goto L_0x005d
        L_0x005c:
            r0 = 0
        L_0x005d:
            if (r0 == 0) goto L_0x0070
            com.mbridge.msdk.video.module.MBridgeVideoView r1 = r4.f16543l
            if (r1 == 0) goto L_0x0066
            r1.setCampaign(r0)
        L_0x0066:
            com.mbridge.msdk.video.module.MBridgeContainerView r1 = r4.f16544m
            if (r1 == 0) goto L_0x006d
            r1.setCampaign(r0)
        L_0x006d:
            r4.a((com.mbridge.msdk.foundation.entity.CampaignEx) r0)
        L_0x0070:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.module.a.a.m.j():void");
    }

    public final void a(int i4, Object obj) {
        Integer num;
        int i5;
        CampaignEx campaignEx;
        if (this.f16526a) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 5) {
                        if (i4 != 6) {
                            if (i4 == 8) {
                                MBridgeContainerView mBridgeContainerView = this.f16544m;
                                if (mBridgeContainerView == null) {
                                    MBridgeVideoView mBridgeVideoView = this.f16543l;
                                    if (mBridgeVideoView != null) {
                                        mBridgeVideoView.showAlertView();
                                    }
                                } else if (!mBridgeContainerView.showAlertWebView()) {
                                    MBridgeVideoView mBridgeVideoView2 = this.f16543l;
                                    if (mBridgeVideoView2 != null) {
                                        mBridgeVideoView2.showAlertView();
                                    }
                                } else {
                                    MBridgeVideoView mBridgeVideoView3 = this.f16543l;
                                    if (mBridgeVideoView3 != null) {
                                        mBridgeVideoView3.alertWebViewShowed();
                                    }
                                }
                            } else if (i4 != 20) {
                                switch (i4) {
                                    case 10:
                                        this.f16549r = true;
                                        this.f16543l.soundOperate(0, 2);
                                        this.f16543l.progressOperate(0, 2);
                                        break;
                                    case 11:
                                        this.f16543l.videoOperate(3);
                                        this.f16543l.dismissAllAlert();
                                        CampaignEx campaignEx2 = this.f16527b;
                                        if (campaignEx2 == null || campaignEx2.getVideo_end_type() == 3 || this.f16527b.getRewardTemplateMode() == null || this.f16527b.getRewardTemplateMode().f() == 5002010) {
                                            this.f16543l.setVisibility(0);
                                        } else if (this.f16527b.getAdSpaceT() != 2) {
                                            this.f16543l.setVisibility(8);
                                        }
                                        CampaignEx campaignEx3 = this.f16527b;
                                        if (campaignEx3 != null && campaignEx3.getDynamicTempCode() == 5) {
                                            MBridgeVideoView mBridgeVideoView4 = this.f16543l;
                                            if (mBridgeVideoView4.mCurrPlayNum == mBridgeVideoView4.mCampaignSize) {
                                                MBridgeContainerView mBridgeContainerView2 = this.f16544m;
                                                if (mBridgeContainerView2 != null) {
                                                    mBridgeContainerView2.setRewardStatus(true);
                                                    this.f16544m.showOrderCampView();
                                                    break;
                                                }
                                            }
                                        }
                                        CampaignEx campaignEx4 = this.f16527b;
                                        if (campaignEx4 == null || campaignEx4.getRewardTemplateMode() == null || this.f16527b.getRewardTemplateMode().f() != 5002010) {
                                            if (this.f16527b.getAdSpaceT() != 2) {
                                                this.f16544m.showEndcard(this.f16527b.getVideo_end_type());
                                                break;
                                            } else {
                                                this.f16544m.showVideoEndCover();
                                                break;
                                            }
                                        }
                                        break;
                                    case 12:
                                        h();
                                        this.f16543l.videoOperate(3);
                                        this.f16543l.dismissAllAlert();
                                        if (this.f16527b.getVideo_end_type() != 3) {
                                            this.f16543l.setVisibility(8);
                                        } else {
                                            this.f16543l.setVisibility(0);
                                        }
                                        if (this.f16549r || this.f16551t != 0) {
                                            if (this.f16527b.isDynamicView() && this.f16527b.getDynamicTempCode() == 5 && TextUtils.isEmpty(this.f16527b.getendcard_url())) {
                                                j();
                                                this.f16551t = 0;
                                            }
                                            if (!this.f16549r && this.f16551t == 1) {
                                                g();
                                                f();
                                                e();
                                                if (ah.a().a("i_l_s_t_r_i", false) && !this.f16550s) {
                                                    this.f16550s = true;
                                                    MBridgeVideoView.a aVar = this.f16553v;
                                                    if (aVar != null) {
                                                        aVar.a();
                                                    }
                                                }
                                            }
                                            if (this.f16527b.getAdSpaceT() == 2) {
                                                this.f16544m.showVideoEndCover();
                                                break;
                                            } else {
                                                this.f16544m.showEndcard(this.f16527b.getVideo_end_type());
                                                break;
                                            }
                                        }
                                    case 13:
                                        this.f16543l.closeVideoOperate(0, 2);
                                        break;
                                    case 14:
                                        if (!this.f16548q) {
                                            this.f16543l.closeVideoOperate(0, 1);
                                            break;
                                        }
                                        break;
                                    case 15:
                                        if (obj != null && (obj instanceof MBridgeVideoView.b)) {
                                            MBridgeVideoView.b bVar = (MBridgeVideoView.b) obj;
                                            int videoInteractiveType = this.f16544m.getVideoInteractiveType();
                                            if (this.f16527b.getAdSpaceT() == 2) {
                                                SoundImageView soundImageView = this.f16543l.mSoundImageView;
                                                if (soundImageView != null && (soundImageView.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
                                                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f16543l.mSoundImageView.getLayoutParams();
                                                    layoutParams.setMargins(ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 5.0f), 0, 0, ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 85.0f));
                                                    this.f16543l.mSoundImageView.setLayoutParams(layoutParams);
                                                }
                                                TextView textView = this.f16543l.tvFlag;
                                                if (textView != null && (textView.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
                                                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f16543l.tvFlag.getLayoutParams();
                                                    layoutParams2.setMargins(ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 5.0f), 0, 0, ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 85.0f));
                                                    this.f16543l.tvFlag.setVisibility(0);
                                                    this.f16543l.tvFlag.setLayoutParams(layoutParams2);
                                                }
                                                this.f16544m.showVideoClickView(1);
                                            } else if (videoInteractiveType >= 0 && bVar.f16494a >= videoInteractiveType) {
                                                this.f16544m.showVideoClickView(1);
                                                this.f16543l.soundOperate(0, 1);
                                            }
                                            this.f16548q = bVar.f16496c;
                                            if (this.f16527b.getDynamicTempCode() != 5) {
                                                int i6 = this.f16545n;
                                                if (((i6 >= 0 && ((i5 = bVar.f16494a) >= i6 || i5 == bVar.f16495b)) || (this.f16527b.getVideoCompleteTime() > 0 && (bVar.f16494a > this.f16527b.getVideoCompleteTime() || bVar.f16494a == bVar.f16495b))) && !this.f16548q) {
                                                    this.f16543l.closeVideoOperate(0, 2);
                                                    this.f16548q = true;
                                                    break;
                                                }
                                            } else {
                                                int i7 = bVar.f16494a;
                                                int i8 = bVar.f16495b;
                                                if (!(this.f16548q || this.f16543l == null || (campaignEx = this.f16527b) == null)) {
                                                    int i9 = this.f16545n;
                                                    int i10 = (i9 < 0 || i7 < i9) ? 1 : 2;
                                                    if (i10 != 2 && (campaignEx.getVideoCompleteTime() != 0 ? i7 > this.f16527b.getVideoCompleteTime() : this.f16543l.mCurrPlayNum > 1)) {
                                                        i10 = 2;
                                                    }
                                                    if (i10 != 2 && this.f16543l.mCurrPlayNum > 1 && i7 == i8) {
                                                        i10 = 2;
                                                    }
                                                    if (i10 == 2) {
                                                        this.f16543l.closeVideoOperate(0, i10);
                                                        this.f16548q = true;
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                        break;
                                }
                            } else if (ah.a().a("i_l_s_t_r_i", false) && (obj instanceof MBridgeVideoView.a)) {
                                this.f16553v = (MBridgeVideoView.a) obj;
                            }
                        }
                    } else if (obj != null && (obj instanceof Integer)) {
                        if (((Integer) obj).intValue() == 1) {
                            num = 2;
                        } else {
                            num = 1;
                        }
                        this.f16543l.soundOperate(num.intValue(), -1);
                    }
                }
                this.f16543l.dismissAllAlert();
                this.f16543l.videoOperate(3);
                CampaignEx campaignEx5 = this.f16527b;
                if (campaignEx5 != null && campaignEx5.isDynamicView() && this.f16527b.getDynamicTempCode() == 5) {
                    if (this.f16544m != null) {
                        MBridgeVideoView mBridgeVideoView5 = this.f16543l;
                        if (mBridgeVideoView5.mCurrPlayNum == mBridgeVideoView5.mCampaignSize) {
                            if (this.f16527b.getAdSpaceT() != 2) {
                                this.f16544m.setRewardStatus(true);
                                this.f16544m.showOrderCampView();
                            }
                            i4 = 16;
                        }
                    }
                    f.a(this.f16527b, this.f16532g, this.f16543l.mCurrentPlayProgressTime);
                }
                if (this.f16552u == 2 && !this.f16544m.endCardShowing() && this.f16527b.getAdSpaceT() != 2) {
                    this.f16544m.showEndcard(this.f16527b.getVideo_end_type());
                }
                i4 = 16;
            } else if (!this.f16544m.endCardShowing()) {
                int videoInteractiveType2 = this.f16544m.getVideoInteractiveType();
                if (videoInteractiveType2 != -2) {
                    if (videoInteractiveType2 == -1) {
                        if (this.f16544m.isLast()) {
                            this.f16544m.showVideoClickView(1);
                            this.f16543l.soundOperate(0, 1);
                            try {
                                i();
                                this.f16546o = new Timer();
                                this.f16546o.schedule(new TimerTask() {
                                    public final void run() {
                                        try {
                                            m.this.f16547p.post(new Runnable() {
                                                public final void run() {
                                                    m.this.f16544m.showVideoClickView(-1);
                                                    m.this.f16543l.soundOperate(0, 2);
                                                }
                                            });
                                        } catch (Throwable th) {
                                            if (MBridgeConstans.DEBUG) {
                                                th.printStackTrace();
                                            }
                                        }
                                    }
                                }, 3000);
                            } catch (Exception e5) {
                                e5.printStackTrace();
                            }
                        } else {
                            this.f16544m.showVideoClickView(-1);
                            this.f16543l.soundOperate(0, 2);
                            i();
                        }
                    }
                } else if (this.f16544m.miniCardLoaded()) {
                    this.f16544m.showVideoClickView(2);
                }
            }
        }
        super.a(i4, obj);
    }
}
