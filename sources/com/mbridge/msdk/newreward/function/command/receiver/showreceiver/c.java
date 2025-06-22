package com.mbridge.msdk.newreward.function.command.receiver.showreceiver;

import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeBaitClickView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d.a;
import com.mbridge.msdk.foundation.tools.aq;
import com.mbridge.msdk.newreward.function.command.f;
import com.mbridge.msdk.newreward.function.command.receiver.e;
import com.mbridge.msdk.newreward.player.imodel.IECModel;
import com.mbridge.msdk.newreward.player.imodel.IPlayModel;
import com.mbridge.msdk.newreward.player.redirect.RedirectModel;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.shake.b;
import java.util.Map;

public final class c implements e {

    /* renamed from: a  reason: collision with root package name */
    CampaignEx f14783a;

    /* renamed from: b  reason: collision with root package name */
    IECModel f14784b;

    /* renamed from: c  reason: collision with root package name */
    IPlayModel f14785c;

    /* renamed from: d  reason: collision with root package name */
    RedirectModel f14786d;

    /* renamed from: e  reason: collision with root package name */
    b f14787e;

    /* renamed from: f  reason: collision with root package name */
    f f14788f;

    /* renamed from: g  reason: collision with root package name */
    MBridgeIds f14789g;

    /* renamed from: h  reason: collision with root package name */
    int f14790h;

    /* renamed from: com.mbridge.msdk.newreward.function.command.receiver.showreceiver.c$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f14794a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.mbridge.msdk.newreward.function.command.f[] r0 = com.mbridge.msdk.newreward.function.command.f.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f14794a = r0
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.ADD_SHAKE_VIEW     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f14794a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mbridge.msdk.newreward.function.command.f r1 = com.mbridge.msdk.newreward.function.command.f.ADD_BAIT_CLICK     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.command.receiver.showreceiver.c.AnonymousClass4.<clinit>():void");
        }
    }

    public c(f fVar) {
        this.f14788f = fVar;
    }

    public final Object a(Object obj) {
        Map map = (Map) obj;
        try {
            this.f14783a = (CampaignEx) map.get("campaign");
            if (map.get("template_model") instanceof IECModel) {
                this.f14790h = 2;
                this.f14784b = (IECModel) map.get("template_model");
            } else if (map.get("template_model") instanceof IPlayModel) {
                this.f14790h = 1;
                this.f14785c = (IPlayModel) map.get("template_model");
            }
            this.f14786d = (RedirectModel) map.get("template_redirect_model");
            this.f14789g = (MBridgeIds) map.get("mbridge_ids");
            int i4 = AnonymousClass4.f14794a[this.f14788f.ordinal()];
            if (i4 == 1) {
                return a();
            }
            if (i4 != 2) {
                return null;
            }
            return a(map);
        } catch (Exception e5) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            e5.printStackTrace();
            return null;
        }
    }

    private View a(Map map) {
        if (this.f14783a == null) {
            return null;
        }
        View view = (View) map.get("bait_click_view");
        String str = "";
        try {
            int i4 = this.f14790h;
            int i5 = 1;
            if (i4 != 1) {
                if (i4 == 2) {
                    str = this.f14783a.getendcard_url();
                    if (TextUtils.isEmpty(str)) {
                        str = this.f14783a.getEndScreenUrl();
                    }
                }
            } else if (this.f14783a.getRewardTemplateMode() != null) {
                str = this.f14783a.getRewardTemplateMode().e();
            }
            String a5 = aq.a(str, "bait_click");
            if (TextUtils.isEmpty(a5)) {
                return null;
            }
            try {
                i5 = Integer.parseInt(a5);
            } catch (Throwable th) {
                if (MBridgeConstans.DEBUG) {
                    th.printStackTrace();
                }
            }
            if (!(TextUtils.isEmpty(a5) || i5 == 0 || view == null)) {
                view.setVisibility(0);
                ((MBridgeBaitClickView) view).init(1342177280, i5);
                if (this.f14783a.getEcTemplateId() == 1302) {
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setShape(0);
                    gradientDrawable.setColor(1342177280);
                    gradientDrawable.setStroke(0, SupportMenu.CATEGORY_MASK);
                    gradientDrawable.setCornerRadius(25.0f);
                    view.setBackground(gradientDrawable);
                }
                ((MBridgeBaitClickView) view).startAnimation();
                view.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        CampaignEx campaignEx = c.this.f14783a;
                        if (campaignEx != null) {
                            campaignEx.setClickTempSource(a.f13396h);
                            c.this.f14783a.setTriggerClickSource(a.f13402n);
                        }
                        c cVar = c.this;
                        if (cVar.f14790h == 2) {
                            cVar.f14784b.eventClickUrl(cVar.f14786d);
                            c cVar2 = c.this;
                            cVar2.f14784b.eventTrackingForClick(cVar2.f14786d);
                            c cVar3 = c.this;
                            cVar3.f14784b.onAdClick(cVar3.f14789g);
                            return;
                        }
                        cVar.f14785c.eventClickUrl(cVar.f14786d);
                        c cVar4 = c.this;
                        cVar4.f14785c.eventTrackingForClick(cVar4.f14786d);
                        c cVar5 = c.this;
                        cVar5.f14785c.onAdClick(cVar5.f14789g);
                    }
                });
            }
            return view;
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0094  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.view.View a() {
        /*
            r5 = this;
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r5.f14783a
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            java.lang.String r0 = r0.getendcard_url()     // Catch:{ all -> 0x0017 }
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0017 }
            if (r2 == 0) goto L_0x001a
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r5.f14783a     // Catch:{ all -> 0x0017 }
            java.lang.String r0 = r0.getEndScreenUrl()     // Catch:{ all -> 0x0017 }
            goto L_0x001a
        L_0x0017:
            r0 = move-exception
            goto L_0x0090
        L_0x001a:
            java.lang.String r2 = "shake_show"
            java.lang.String r2 = com.mbridge.msdk.foundation.tools.aq.a(r0, r2)     // Catch:{ all -> 0x0017 }
            java.lang.String r3 = "shake_strength"
            java.lang.String r3 = com.mbridge.msdk.foundation.tools.aq.a(r0, r3)     // Catch:{ all -> 0x0017 }
            java.lang.String r4 = "shake_time"
            java.lang.String r0 = com.mbridge.msdk.foundation.tools.aq.a(r0, r4)     // Catch:{ all -> 0x0017 }
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0017 }
            if (r4 != 0) goto L_0x008f
            java.lang.String r4 = "1"
            boolean r2 = r2.equals(r4)     // Catch:{ all -> 0x0017 }
            if (r2 == 0) goto L_0x008f
            com.mbridge.msdk.shake.MBShakeView r2 = new com.mbridge.msdk.shake.MBShakeView     // Catch:{ all -> 0x0017 }
            com.mbridge.msdk.foundation.controller.c r4 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ all -> 0x0017 }
            android.content.Context r4 = r4.c()     // Catch:{ all -> 0x0017 }
            r2.<init>(r4)     // Catch:{ all -> 0x0017 }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r5.f14783a     // Catch:{ all -> 0x006a }
            java.lang.String r1 = r1.getAdCall()     // Catch:{ all -> 0x006a }
            r4 = 1
            r2.initView(r1, r4)     // Catch:{ all -> 0x006a }
            com.mbridge.msdk.newreward.function.command.receiver.showreceiver.c$2 r1 = new com.mbridge.msdk.newreward.function.command.receiver.showreceiver.c$2     // Catch:{ all -> 0x006a }
            r1.<init>()     // Catch:{ all -> 0x006a }
            r2.setOnClickListener(r1)     // Catch:{ all -> 0x006a }
            boolean r1 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x006a }
            r4 = 10
            if (r1 != 0) goto L_0x006d
            int r1 = java.lang.Integer.parseInt(r3)     // Catch:{ all -> 0x006a }
            if (r1 > 0) goto L_0x0068
            goto L_0x006d
        L_0x0068:
            r4 = r1
            goto L_0x006d
        L_0x006a:
            r0 = move-exception
            r1 = r2
            goto L_0x0090
        L_0x006d:
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x006a }
            r3 = 5000(0x1388, float:7.006E-42)
            if (r1 != 0) goto L_0x007e
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ all -> 0x006a }
            if (r0 > 0) goto L_0x007c
            goto L_0x007e
        L_0x007c:
            int r3 = r0 * 1000
        L_0x007e:
            com.mbridge.msdk.newreward.function.command.receiver.showreceiver.c$3 r0 = new com.mbridge.msdk.newreward.function.command.receiver.showreceiver.c$3     // Catch:{ all -> 0x006a }
            r0.<init>(r4, r3)     // Catch:{ all -> 0x006a }
            r5.f14787e = r0     // Catch:{ all -> 0x006a }
            com.mbridge.msdk.shake.a r0 = com.mbridge.msdk.shake.a.a()     // Catch:{ all -> 0x006a }
            com.mbridge.msdk.shake.b r1 = r5.f14787e     // Catch:{ all -> 0x006a }
            r0.a(r1)     // Catch:{ all -> 0x006a }
            return r2
        L_0x008f:
            return r1
        L_0x0090:
            boolean r2 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r2 == 0) goto L_0x0097
            r0.printStackTrace()
        L_0x0097:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.command.receiver.showreceiver.c.a():android.view.View");
    }
}
