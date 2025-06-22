package com.mbridge.msdk.video.module.a.a;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import com.mbridge.msdk.video.signal.factory.IJSFactory;
import com.mbridge.msdk.video.signal.g;
import com.mbridge.msdk.video.signal.j;
import com.mbridge.msdk.videocommon.b.c;
import com.mbridge.msdk.videocommon.download.a;

public final class n extends o {

    /* renamed from: l  reason: collision with root package name */
    private IJSFactory f16556l;

    /* renamed from: m  reason: collision with root package name */
    private int f16557m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f16558n = false;

    /* renamed from: o  reason: collision with root package name */
    private boolean f16559o = false;

    /* renamed from: p  reason: collision with root package name */
    private int f16560p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f16561q = false;

    /* renamed from: r  reason: collision with root package name */
    private MBridgeVideoView.a f16562r;

    public n(IJSFactory iJSFactory, CampaignEx campaignEx, c cVar, a aVar, String str, String str2, int i4, int i5, com.mbridge.msdk.video.module.a.a aVar2, int i6, boolean z4, int i7) {
        super(campaignEx, cVar, aVar, str, str2, aVar2, i6, z4);
        boolean z5;
        this.f16556l = iJSFactory;
        this.f16557m = i4;
        if (i5 == 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        this.f16558n = z5;
        this.f16560p = i7;
        if (iJSFactory == null) {
            this.f16526a = false;
        }
    }

    public final void a(int i4, Object obj) {
        Integer num;
        int i5;
        int i6 = i4;
        Object obj2 = obj;
        if (this.f16526a) {
            String str = "";
            if (i6 != 1) {
                if (i6 != 2) {
                    if (i6 != 5) {
                        int i7 = 6;
                        if (i6 != 6) {
                            if (i6 != 8) {
                                if (i6 != 20) {
                                    if (i6 != 114) {
                                        if (i6 != 116) {
                                            switch (i6) {
                                                case 10:
                                                    this.f16561q = true;
                                                    this.f16556l.getJSNotifyProxy().a(0);
                                                    break;
                                                case 11:
                                                case 12:
                                                    this.f16556l.getJSVideoModule().videoOperate(3);
                                                    if (this.f16527b.getVideo_end_type() == 3) {
                                                        this.f16556l.getJSVideoModule().setVisible(0);
                                                    } else if (this.f16527b.getAdSpaceT() != 2) {
                                                        this.f16556l.getJSVideoModule().setVisible(8);
                                                    }
                                                    if (i6 == 12) {
                                                        h();
                                                        i5 = 2;
                                                    } else {
                                                        i5 = 1;
                                                    }
                                                    this.f16556l.getJSNotifyProxy().a(i5);
                                                    if (this.f16556l.getJSCommon().g() == 2) {
                                                        this.f16556l.getJSVideoModule().setVisible(0);
                                                        j jSVideoModule = this.f16556l.getJSVideoModule();
                                                        this.f16556l.getJSContainerModule().showMiniCard(jSVideoModule.getBorderViewTop(), jSVideoModule.getBorderViewLeft(), jSVideoModule.getBorderViewWidth(), jSVideoModule.getBorderViewHeight(), jSVideoModule.getBorderViewRadius());
                                                    } else if (i6 == 12) {
                                                        if (this.f16560p == 1) {
                                                            if (this.f16527b.getAdSpaceT() != 2) {
                                                                this.f16556l.getJSContainerModule().showEndcard(this.f16527b.getVideo_end_type());
                                                            } else {
                                                                this.f16556l.getJSContainerModule().showVideoEndCover();
                                                            }
                                                        }
                                                    } else if (this.f16527b.getAdSpaceT() != 2) {
                                                        this.f16556l.getJSContainerModule().showEndcard(this.f16527b.getVideo_end_type());
                                                    } else {
                                                        this.f16556l.getJSContainerModule().showVideoEndCover();
                                                    }
                                                    this.f16556l.getJSVideoModule().dismissAllAlert();
                                                    if (i6 == 12 && !this.f16561q && this.f16560p == 1) {
                                                        h();
                                                        g();
                                                        f();
                                                        e();
                                                        if (ah.a().a("i_l_s_t_r_i", false) && !this.f16559o) {
                                                            this.f16559o = true;
                                                            MBridgeVideoView.a aVar = this.f16562r;
                                                            if (aVar != null) {
                                                                aVar.a();
                                                                break;
                                                            }
                                                        }
                                                    }
                                                    break;
                                                case 13:
                                                    if (!this.f16556l.getJSVideoModule().isH5Canvas()) {
                                                        this.f16556l.getJSVideoModule().closeVideoOperate(0, 2);
                                                    }
                                                    this.f16556l.getJSNotifyProxy().a(-1);
                                                    break;
                                                case 14:
                                                    if (!this.f16558n) {
                                                        this.f16556l.getJSVideoModule().closeVideoOperate(0, 1);
                                                        break;
                                                    }
                                                    break;
                                                case 15:
                                                    if (obj2 != null && (obj2 instanceof MBridgeVideoView.b)) {
                                                        this.f16558n = true;
                                                        this.f16556l.getJSNotifyProxy().a((MBridgeVideoView.b) obj2);
                                                        break;
                                                    }
                                                default:
                                                    switch (i6) {
                                                        case 123:
                                                        case 124:
                                                            g jSNotifyProxy = this.f16556l.getJSNotifyProxy();
                                                            if (i6 == 123) {
                                                                i7 = 7;
                                                            }
                                                            jSNotifyProxy.a(i7, str);
                                                            break;
                                                        case 125:
                                                            this.f16556l.getJSContainerModule().hideAlertWebview();
                                                            break;
                                                    }
                                            }
                                        } else {
                                            j jSVideoModule2 = this.f16556l.getJSVideoModule();
                                            this.f16556l.getJSContainerModule().configurationChanged(jSVideoModule2.getBorderViewWidth(), jSVideoModule2.getBorderViewHeight(), jSVideoModule2.getBorderViewRadius());
                                        }
                                    } else if (this.f16556l.getJSCommon().g() == 2) {
                                        j jSVideoModule3 = this.f16556l.getJSVideoModule();
                                        this.f16556l.getJSContainerModule().showMiniCard(jSVideoModule3.getBorderViewTop(), jSVideoModule3.getBorderViewLeft(), jSVideoModule3.getBorderViewWidth(), jSVideoModule3.getBorderViewHeight(), jSVideoModule3.getBorderViewRadius());
                                    }
                                } else if (ah.a().a("i_l_s_t_r_i", false) && (obj2 instanceof MBridgeVideoView.a)) {
                                    this.f16562r = (MBridgeVideoView.a) obj2;
                                }
                            } else if (!this.f16556l.getJSContainerModule().showAlertWebView()) {
                                this.f16556l.getJSVideoModule().showAlertView();
                            } else {
                                this.f16556l.getJSVideoModule().alertWebViewShowed();
                            }
                        }
                    } else if (obj2 != null && (obj2 instanceof Integer)) {
                        if (((Integer) obj2).intValue() == 1) {
                            num = 2;
                        } else {
                            num = 1;
                        }
                        this.f16556l.getJSVideoModule().soundOperate(num.intValue(), -1);
                        g jSNotifyProxy2 = this.f16556l.getJSNotifyProxy();
                        jSNotifyProxy2.a(5, num + str);
                    }
                }
                this.f16556l.getJSVideoModule().dismissAllAlert();
                if (i6 == 2) {
                    this.f16556l.getJSNotifyProxy().a(2, str);
                }
                this.f16556l.getJSVideoModule().videoOperate(3);
                int i8 = 16;
                if (this.f16556l.getJSCommon().g() != 2) {
                    if (this.f16527b.getVideo_end_type() != 3) {
                        this.f16556l.getJSVideoModule().setVisible(8);
                    } else {
                        this.f16556l.getJSVideoModule().setVisible(0);
                    }
                    if (this.f16557m == 2 && !this.f16556l.getJSContainerModule().endCardShowing() && this.f16527b.getAdSpaceT() != 2) {
                        this.f16556l.getJSContainerModule().showEndcard(this.f16527b.getVideo_end_type());
                        i8 = i6;
                    }
                }
                this.f16556l.getJSNotifyProxy().a(1);
                i6 = i8;
            } else if (!this.f16556l.getJSContainerModule().endCardShowing()) {
                g jSNotifyProxy3 = this.f16556l.getJSNotifyProxy();
                if (obj2 != null) {
                    str = obj2.toString();
                }
                jSNotifyProxy3.a(1, str);
            }
        }
        super.a(i6, obj2);
    }
}
