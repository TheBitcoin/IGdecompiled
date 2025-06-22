package com.mbridge.msdk.click;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.out.NativeListener;
import com.mbridge.msdk.scheme.applet.AppletSchemeCallBack;
import com.mbridge.msdk.scheme.applet.AppletsModel;

public final class g extends AppletSchemeCallBack {

    /* renamed from: a  reason: collision with root package name */
    private final NativeListener.NativeTrackingListener f12078a;

    /* renamed from: b  reason: collision with root package name */
    private final CampaignEx f12079b;

    /* renamed from: c  reason: collision with root package name */
    private final AppletsModel f12080c;

    /* renamed from: d  reason: collision with root package name */
    private final a f12081d;

    public g(NativeListener.NativeTrackingListener nativeTrackingListener, CampaignEx campaignEx, AppletsModel appletsModel, a aVar) {
        this.f12078a = nativeTrackingListener;
        this.f12079b = campaignEx;
        this.f12080c = appletsModel;
        this.f12081d = aVar;
    }

    /* access modifiers changed from: protected */
    public final void onRequestFailed(int i4, String str, String str2) {
        CampaignEx campaignEx = this.f12079b;
        if (campaignEx != null && this.f12080c != null) {
            try {
                NativeListener.NativeTrackingListener nativeTrackingListener = this.f12078a;
                if (nativeTrackingListener != null) {
                    try {
                        nativeTrackingListener.onFinishRedirection(campaignEx, campaignEx.getClickURL());
                    } catch (Exception e5) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("DefaultAppletSchemeCallBack", e5.getMessage());
                        }
                    }
                }
                this.f12080c.setUserClick(false);
                this.f12080c.setRequestingFinish();
                this.f12079b.setClickURL(str2);
                a aVar = this.f12081d;
                if (aVar != null) {
                    try {
                        aVar.a(this.f12079b);
                    } catch (Exception e6) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("DefaultAppletSchemeCallBack", e6.getMessage());
                        }
                    }
                }
            } catch (Exception e7) {
                if (MBridgeConstans.DEBUG) {
                    af.b("DefaultAppletSchemeCallBack", e7.getMessage());
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void onRequestStart() {
    }

    /* access modifiers changed from: protected */
    public final void onRequestSuccess(String str) {
        CampaignEx campaignEx = this.f12079b;
        if (campaignEx != null && this.f12080c != null) {
            try {
                NativeListener.NativeTrackingListener nativeTrackingListener = this.f12078a;
                if (nativeTrackingListener != null) {
                    try {
                        nativeTrackingListener.onFinishRedirection(campaignEx, campaignEx.getClickURL());
                    } catch (Exception e5) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("DefaultAppletSchemeCallBack", e5.getMessage());
                        }
                    }
                }
                this.f12080c.setUserClick(false);
                this.f12080c.setRequestingFinish();
                this.f12079b.setDeepLinkUrl(str);
                a aVar = this.f12081d;
                if (aVar != null) {
                    try {
                        aVar.a(this.f12079b);
                    } catch (Exception e6) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("DefaultAppletSchemeCallBack", e6.getMessage());
                        }
                    }
                }
            } catch (Exception e7) {
                if (MBridgeConstans.DEBUG) {
                    af.b("DefaultAppletSchemeCallBack", e7.getMessage());
                }
            }
        }
    }
}
