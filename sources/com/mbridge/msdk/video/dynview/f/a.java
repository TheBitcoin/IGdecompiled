package com.mbridge.msdk.video.dynview.f;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.preference.LeanbackPreferenceDialogFragment;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.click.i;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.aj;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.out.Campaign;
import org.json.JSONObject;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f16030a = "com.mbridge.msdk.video.dynview.f.a";

    public static void a(CampaignEx campaignEx, Context context, String str, String str2, String str3) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(LeanbackPreferenceDialogFragment.ARG_KEY, "2000091");
                    jSONObject.put("network_type", ab.m(context));
                    jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                    if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f13124V)) {
                        jSONObject.put(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, com.mbridge.msdk.foundation.same.a.f13124V);
                    }
                    if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f13133g)) {
                        jSONObject.put("c", com.mbridge.msdk.foundation.same.a.f13133g);
                    }
                    jSONObject.put(CampaignEx.JSON_KEY_HB, 0);
                    jSONObject.put("rid_n", str3);
                    jSONObject.put("reason", str);
                    if (!(campaignEx == null || campaignEx.getRewardTemplateMode() == null)) {
                        jSONObject.put("dyview", ak.b(campaignEx.getRewardTemplateMode().e()));
                    }
                    d.a().a(jSONObject);
                }
            } catch (Throwable th) {
                af.b(f16030a, th.getMessage());
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(com.mbridge.msdk.foundation.entity.CampaignUnit r9, int r10, int r11, java.lang.String r12) {
        /*
            if (r9 == 0) goto L_0x00b2
            java.util.ArrayList r0 = r9.getAds()
            if (r0 == 0) goto L_0x00b2
            java.util.ArrayList r0 = r9.getAds()
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x00b2
            java.util.ArrayList r0 = r9.getAds()
            java.lang.Object r0 = r0.get(r10)
            if (r0 == 0) goto L_0x00b2
            if (r11 != 0) goto L_0x002e
            java.util.ArrayList r0 = r9.getAds()
            java.lang.Object r0 = r0.get(r10)
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = (com.mbridge.msdk.foundation.entity.CampaignEx) r0
            boolean r0 = r0.mMoreOfferImpShow
            if (r0 == 0) goto L_0x002e
            goto L_0x00b2
        L_0x002e:
            java.util.ArrayList r0 = r9.getAds()
            java.lang.Object r0 = r0.get(r10)
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = (com.mbridge.msdk.foundation.entity.CampaignEx) r0
            java.lang.String r0 = r0.getendcard_url()
            java.lang.String r1 = "mof_testuid"
            java.lang.String r0 = com.mbridge.msdk.foundation.tools.aq.a(r0, r1)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x005c
            java.util.ArrayList r0 = r9.getAds()
            java.lang.Object r0 = r0.get(r10)
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = (com.mbridge.msdk.foundation.entity.CampaignEx) r0
            java.lang.String r0 = r0.getendcard_url()
            java.lang.String r1 = "mof_uid"
            java.lang.String r0 = com.mbridge.msdk.foundation.tools.aq.a(r0, r1)
        L_0x005c:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x0064
            r4 = r12
            goto L_0x0065
        L_0x0064:
            r4 = r0
        L_0x0065:
            if (r11 == 0) goto L_0x0083
            r12 = 1
            if (r11 == r12) goto L_0x0070
            java.lang.String r11 = ""
            r12 = 0
            r5 = r11
            r8 = 0
            goto L_0x0094
        L_0x0070:
            int r12 = com.mbridge.msdk.click.a.a.f12015h
            java.util.ArrayList r11 = r9.getAds()
            java.lang.Object r11 = r11.get(r10)
            com.mbridge.msdk.foundation.entity.CampaignEx r11 = (com.mbridge.msdk.foundation.entity.CampaignEx) r11
            java.lang.String r11 = r11.getOnlyImpressionURL()
        L_0x0080:
            r5 = r11
            r8 = r12
            goto L_0x0094
        L_0x0083:
            int r12 = com.mbridge.msdk.click.a.a.f12014g
            java.util.ArrayList r11 = r9.getAds()
            java.lang.Object r11 = r11.get(r10)
            com.mbridge.msdk.foundation.entity.CampaignEx r11 = (com.mbridge.msdk.foundation.entity.CampaignEx) r11
            java.lang.String r11 = r11.getImpressionURL()
            goto L_0x0080
        L_0x0094:
            boolean r11 = android.text.TextUtils.isEmpty(r5)
            if (r11 != 0) goto L_0x00b2
            com.mbridge.msdk.foundation.controller.c r11 = com.mbridge.msdk.foundation.controller.c.m()
            android.content.Context r2 = r11.c()
            java.util.ArrayList r9 = r9.getAds()
            java.lang.Object r9 = r9.get(r10)
            r3 = r9
            com.mbridge.msdk.foundation.entity.CampaignEx r3 = (com.mbridge.msdk.foundation.entity.CampaignEx) r3
            r6 = 0
            r7 = 1
            com.mbridge.msdk.click.a.a((android.content.Context) r2, (com.mbridge.msdk.foundation.entity.CampaignEx) r3, (java.lang.String) r4, (java.lang.String) r5, (boolean) r6, (boolean) r7, (int) r8)
        L_0x00b2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.dynview.f.a.a(com.mbridge.msdk.foundation.entity.CampaignUnit, int, int, java.lang.String):void");
    }

    public static void a(Context context, CampaignEx campaignEx, String str, View view) {
        CampaignEx campaignEx2;
        Context context2;
        if (context != null && campaignEx != null) {
            if (campaignEx.getNativeVideoTracking() == null || campaignEx.getNativeVideoTracking().l() == null) {
                context2 = context;
                campaignEx2 = campaignEx;
            } else {
                context2 = context;
                campaignEx2 = campaignEx;
                com.mbridge.msdk.click.a.a(context2, campaignEx2, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().l(), false, false);
            }
            com.mbridge.msdk.click.a aVar = new com.mbridge.msdk.click.a(context2, str);
            if (view instanceof ViewGroup) {
                final ViewGroup viewGroup = (ViewGroup) view;
                aVar.a((i) new i() {
                    public final void onFinishRedirection(Campaign campaign, String str) {
                        if (campaign != null) {
                            aj.a(campaign, viewGroup);
                        }
                    }

                    public final void onRedirectionFailed(Campaign campaign, String str) {
                        if (campaign != null) {
                            aj.a(campaign, viewGroup);
                        }
                    }

                    public final void onStartRedirection(Campaign campaign, String str) {
                        if (campaign != null) {
                            aj.b(campaign, viewGroup);
                        }
                    }
                });
            }
            aVar.a(campaignEx2);
        }
    }
}
