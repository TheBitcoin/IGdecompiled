package com.mbridge.msdk.video.dynview.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.same.report.d.e;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.video.bt.module.b.f;
import com.mbridge.msdk.video.dynview.e.b;
import com.mbridge.msdk.video.dynview.e.c;
import com.mbridge.msdk.video.dynview.e.h;
import com.mbridge.msdk.video.dynview.moffer.a;
import com.mbridge.msdk.video.module.MBridgeBaseView;
import com.mbridge.msdk.widget.FeedBackButton;
import java.util.HashMap;
import java.util.List;

public class MBridgeOrderCampView extends MBridgeBaseView {
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public MBridgeOrderCampView f16211m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public List<CampaignEx> f16212n;

    /* renamed from: o  reason: collision with root package name */
    private int f16213o;

    /* renamed from: p  reason: collision with root package name */
    private int f16214p;

    /* renamed from: q  reason: collision with root package name */
    private int f16215q;

    /* renamed from: r  reason: collision with root package name */
    private int f16216r;

    /* renamed from: s  reason: collision with root package name */
    private String f16217s;

    /* renamed from: t  reason: collision with root package name */
    private FeedBackButton f16218t;

    /* renamed from: u  reason: collision with root package name */
    private ImageView f16219u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public boolean f16220v = false;

    /* renamed from: w  reason: collision with root package name */
    private c f16221w = new c() {
        public final void a(CampaignEx campaignEx, int i4) {
            if (campaignEx != null) {
                try {
                    MBridgeOrderCampView.this.setCampaign(campaignEx);
                    campaignEx.setClickTempSource(2);
                    campaignEx.setTriggerClickSource(2);
                    MBridgeOrderCampView.a(MBridgeOrderCampView.this, campaignEx, 0, i4);
                } catch (Exception e5) {
                    af.b(MBridgeBaseView.TAG, e5.getMessage());
                }
            }
        }

        public final void a() {
            MBridgeOrderCampView.a(MBridgeOrderCampView.this);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public b f16222x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f16223y = false;

    public MBridgeOrderCampView(Context context) {
        super(context);
    }

    static /* synthetic */ void a(MBridgeOrderCampView mBridgeOrderCampView) {
        try {
            e eVar = new e();
            eVar.a("type", 2);
            d.a().a("2000152", eVar);
            d.a().a("2000134", mBridgeOrderCampView.f16239b);
        } catch (Throwable th) {
            af.a(MBridgeBaseView.TAG, th.getMessage());
        }
        try {
            a.a().b();
        } catch (Exception e5) {
            af.b(MBridgeBaseView.TAG, e5.getMessage());
        }
        com.mbridge.msdk.video.module.a.a aVar = mBridgeOrderCampView.notifyListener;
        if (aVar != null) {
            aVar.a(104, "");
        }
    }

    public void createView(final ViewGroup viewGroup) {
        if (this.f16212n == null) {
            b bVar = this.f16222x;
            if (bVar != null) {
                bVar.b();
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("order_view_callback", this.f16221w);
        com.mbridge.msdk.video.dynview.b.a().a(new com.mbridge.msdk.video.dynview.j.c().b(com.mbridge.msdk.foundation.controller.c.m().c(), this.f16212n), new h() {
            public final void viewInflaterFail(com.mbridge.msdk.video.dynview.c.a aVar) {
                try {
                    f.a(com.mbridge.msdk.foundation.controller.c.m().c(), (List<CampaignEx>) MBridgeOrderCampView.this.f16212n, ((CampaignEx) MBridgeOrderCampView.this.f16212n.get(0)).getCampaignUnitId(), aVar.b());
                    if (MBridgeOrderCampView.this.f16222x != null) {
                        MBridgeOrderCampView.this.f16222x.b();
                    }
                } catch (Exception e5) {
                    af.b(MBridgeBaseView.TAG, e5.getMessage());
                }
            }

            public final void viewInflaterSuccess(com.mbridge.msdk.video.dynview.a aVar) {
                if (aVar != null) {
                    try {
                        MBridgeOrderCampView.this.f16211m.addView(aVar.a());
                        boolean unused = MBridgeOrderCampView.this.f16220v = aVar.c();
                        viewGroup.removeAllViews();
                        viewGroup.addView(MBridgeOrderCampView.this.f16211m);
                        f.a(com.mbridge.msdk.foundation.controller.c.m().c(), (List<CampaignEx>) MBridgeOrderCampView.this.f16212n, ((CampaignEx) MBridgeOrderCampView.this.f16212n.get(0)).getCampaignUnitId());
                        MBridgeOrderCampView.this.setViewStatus();
                        if (MBridgeOrderCampView.this.f16222x != null) {
                            MBridgeOrderCampView.this.f16222x.a();
                        }
                    } catch (Exception e5) {
                        af.b(MBridgeBaseView.TAG, e5.getMessage());
                    }
                }
            }
        }, hashMap);
    }

    public void init(Context context) {
        this.f16211m = this;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x002f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onAttachedToWindow() {
        /*
            r5 = this;
            super.onAttachedToWindow()
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r0 = r5.f16212n
            if (r0 != 0) goto L_0x0008
            goto L_0x0032
        L_0x0008:
            r0 = 0
        L_0x0009:
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r1 = r5.f16212n
            int r1 = r1.size()
            if (r0 >= r1) goto L_0x0032
            r1 = 0
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x001f }
            r2.<init>()     // Catch:{ JSONException -> 0x001f }
            java.lang.String r1 = "camp_position"
            r2.put(r1, r0)     // Catch:{ JSONException -> 0x001d }
            goto L_0x0026
        L_0x001d:
            r1 = move-exception
            goto L_0x0023
        L_0x001f:
            r2 = move-exception
            r4 = r2
            r2 = r1
            r1 = r4
        L_0x0023:
            r1.printStackTrace()
        L_0x0026:
            com.mbridge.msdk.video.module.a.a r1 = r5.notifyListener
            if (r1 == 0) goto L_0x002f
            r3 = 110(0x6e, float:1.54E-43)
            r1.a(r3, r2)
        L_0x002f:
            int r0 = r0 + 1
            goto L_0x0009
        L_0x0032:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.dynview.widget.MBridgeOrderCampView.onAttachedToWindow():void");
    }

    public void setCampOrderViewBuildCallback(b bVar) {
        this.f16222x = bVar;
    }

    public void setCampaignExes(List<CampaignEx> list) {
        this.f16212n = list;
    }

    public void setNotchPadding(int i4, int i5, int i6, int i7) {
        this.f16213o = i4;
        this.f16214p = i5;
        this.f16215q = i6;
        this.f16216r = i7;
        setViewStatus();
    }

    public void setRewarded(boolean z4) {
        this.f16223y = z4;
    }

    public void setViewStatus() {
        MBridgeOrderCampView mBridgeOrderCampView = this.f16211m;
        if (mBridgeOrderCampView != null && this.f16223y) {
            RelativeLayout relativeLayout = (RelativeLayout) mBridgeOrderCampView.findViewById(filterFindViewId(this.f16220v, "mbridge_native_order_camp_controller"));
            this.f16218t = (FeedBackButton) this.f16211m.findViewById(filterFindViewId(this.f16220v, "mbridge_native_order_camp_feed_btn"));
            this.f16219u = (ImageView) this.f16211m.findViewById(filterFindViewId(this.f16220v, "mbridge_iv_link"));
            if (relativeLayout != null) {
                relativeLayout.setPadding(this.f16213o, this.f16215q, this.f16214p, this.f16216r);
            }
            if (this.f16218t != null) {
                try {
                    List<CampaignEx> list = this.f16212n;
                    if (list != null) {
                        if (list.get(0) != null) {
                            this.f16217s = this.f16212n.get(0).getCampaignUnitId();
                            this.f16239b = this.f16212n.get(0);
                            com.mbridge.msdk.foundation.d.b a5 = com.mbridge.msdk.foundation.d.b.a();
                            a5.a(this.f16217s + "_" + 2, this.f16239b);
                            if (this.f16218t != null) {
                                if (com.mbridge.msdk.foundation.d.b.a().b()) {
                                    com.mbridge.msdk.foundation.d.b a6 = com.mbridge.msdk.foundation.d.b.a();
                                    a6.a(this.f16217s + "_" + 2, (com.mbridge.msdk.foundation.d.a) new com.mbridge.msdk.foundation.d.a() {
                                        public final void close() {
                                        }

                                        public final void showed() {
                                        }

                                        public final void summit(String str) {
                                        }
                                    });
                                    com.mbridge.msdk.foundation.d.b a7 = com.mbridge.msdk.foundation.d.b.a();
                                    a7.a(this.f16217s + "_" + 2, this.f16218t);
                                } else {
                                    this.f16218t.setVisibility(8);
                                }
                            }
                        }
                    }
                    FeedBackButton feedBackButton = this.f16218t;
                    if (feedBackButton != null) {
                        feedBackButton.setVisibility(8);
                    }
                } catch (Exception e5) {
                    af.b(MBridgeBaseView.TAG, e5.getMessage());
                }
            }
            ImageView imageView = this.f16219u;
            if (imageView != null && imageView != null) {
                try {
                    g b5 = com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
                    if (b5 != null) {
                        final String j4 = b5.j();
                        if (TextUtils.isEmpty(j4)) {
                            this.f16219u.setVisibility(8);
                        }
                        this.f16219u.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                com.mbridge.msdk.click.c.f(MBridgeOrderCampView.this.f16238a, j4);
                            }
                        });
                        return;
                    }
                    this.f16219u.setVisibility(8);
                } catch (Exception e6) {
                    af.b(MBridgeBaseView.TAG, e6.getMessage());
                }
            }
        }
    }

    public void startAlphaAnimation() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(500);
        this.f16211m.startAnimation(alphaAnimation);
    }

    public void startTranslateAnimation() {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 1.0f, 2, 0.0f, 2, 0.0f, 2, 0.0f);
        translateAnimation.setDuration(500);
        this.f16211m.startAnimation(translateAnimation);
    }

    public MBridgeOrderCampView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.mbridge.msdk.video.dynview.widget.MBridgeOrderCampView r8, com.mbridge.msdk.foundation.entity.CampaignEx r9, int r10, int r11) {
        /*
            if (r9 == 0) goto L_0x0062
            boolean r0 = r9.isDynamicView()
            if (r0 == 0) goto L_0x0062
            com.mbridge.msdk.foundation.entity.CampaignEx$c r0 = r9.getRewardTemplateMode()     // Catch:{ Exception -> 0x0025 }
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x0023
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0025 }
            r2.<init>()     // Catch:{ Exception -> 0x0025 }
            int r0 = r0.f()     // Catch:{ Exception -> 0x0025 }
            r2.append(r0)     // Catch:{ Exception -> 0x0025 }
            r2.append(r1)     // Catch:{ Exception -> 0x0025 }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x0025 }
        L_0x0023:
            r7 = r1
            goto L_0x0028
        L_0x0025:
            r0 = move-exception
            r9 = r0
            goto L_0x0059
        L_0x0028:
            com.mbridge.msdk.foundation.controller.c r0 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ Exception -> 0x0025 }
            android.content.Context r0 = r0.c()     // Catch:{ Exception -> 0x0025 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0025 }
            r1.<init>()     // Catch:{ Exception -> 0x0025 }
            java.lang.String r2 = "order_view_click"
            r1.append(r2)     // Catch:{ Exception -> 0x0025 }
            r1.append(r7)     // Catch:{ Exception -> 0x0025 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0025 }
            java.lang.String r2 = r9.getCampaignUnitId()     // Catch:{ Exception -> 0x0025 }
            boolean r3 = r9.isBidCampaign()     // Catch:{ Exception -> 0x0025 }
            java.lang.String r4 = r9.getRequestId()     // Catch:{ Exception -> 0x0025 }
            java.lang.String r5 = r9.getRequestIdNotice()     // Catch:{ Exception -> 0x0025 }
            java.lang.String r6 = r9.getId()     // Catch:{ Exception -> 0x0025 }
            com.mbridge.msdk.foundation.same.report.i.a(r0, r1, r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0025 }
            goto L_0x0062
        L_0x0059:
            java.lang.String r0 = "MBridgeBaseView"
            java.lang.String r9 = r9.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r0, r9)
        L_0x0062:
            r9 = 0
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x007a }
            r1.<init>()     // Catch:{ JSONException -> 0x007a }
            java.lang.String r9 = com.mbridge.msdk.foundation.same.a.f13136j     // Catch:{ JSONException -> 0x0077 }
            org.json.JSONObject r10 = r8.a(r10)     // Catch:{ JSONException -> 0x0077 }
            r1.put(r9, r10)     // Catch:{ JSONException -> 0x0077 }
            java.lang.String r9 = "camp_position"
            r1.put(r9, r11)     // Catch:{ JSONException -> 0x0077 }
            goto L_0x0081
        L_0x0077:
            r0 = move-exception
            r9 = r0
            goto L_0x007e
        L_0x007a:
            r0 = move-exception
            r10 = r0
            r1 = r9
            r9 = r10
        L_0x007e:
            r9.printStackTrace()
        L_0x0081:
            com.mbridge.msdk.video.module.a.a r8 = r8.notifyListener
            if (r8 == 0) goto L_0x008a
            r9 = 105(0x69, float:1.47E-43)
            r8.a(r9, r1)
        L_0x008a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.dynview.widget.MBridgeOrderCampView.a(com.mbridge.msdk.video.dynview.widget.MBridgeOrderCampView, com.mbridge.msdk.foundation.entity.CampaignEx, int, int):void");
    }
}
