package com.mbridge.msdk.mbbanner.common.communication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import androidx.leanback.preference.LeanbackPreferenceDialogFragment;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.k;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.j;
import com.mbridge.msdk.foundation.db.n;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.m;
import com.mbridge.msdk.foundation.same.a.b;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.aj;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.mbsignalcommon.communication.c;
import com.mbridge.msdk.mbsignalcommon.communication.d;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends c {

    /* renamed from: b  reason: collision with root package name */
    private WeakReference<Context> f13987b;

    /* renamed from: c  reason: collision with root package name */
    private List<CampaignEx> f13988c;

    /* renamed from: d  reason: collision with root package name */
    private String f13989d;

    /* renamed from: e  reason: collision with root package name */
    private String f13990e;

    /* renamed from: f  reason: collision with root package name */
    private int f13991f;

    /* renamed from: g  reason: collision with root package name */
    private com.mbridge.msdk.mbbanner.common.b.a f13992g;

    /* renamed from: h  reason: collision with root package name */
    private BannerExpandDialog f13993h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f13994i = false;

    public a(Context context, String str, String str2) {
        this.f13989d = str;
        this.f13990e = str2;
        this.f13987b = new WeakReference<>(context);
    }

    public final void a(com.mbridge.msdk.mbbanner.common.b.a aVar) {
        if (aVar != null) {
            this.f13992g = aVar;
        }
    }

    public final void b(Object obj, String str) {
        CampaignEx campaignEx;
        af.b("BannerSignalCommunicationImpl", CampaignEx.JSON_NATIVE_VIDEO_CLICK);
        try {
            List<CampaignEx> list = this.f13988c;
            if (list != null) {
                if (list == null || list.size() <= 0) {
                    campaignEx = null;
                } else {
                    campaignEx = this.f13988c.get(0);
                }
                if (!TextUtils.isEmpty(str)) {
                    JSONObject campaignToJsonObject = CampaignEx.campaignToJsonObject(campaignEx);
                    JSONObject jSONObject = new JSONObject(str).getJSONObject("pt");
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        campaignToJsonObject.put(next, jSONObject.getString(next));
                    }
                    CampaignEx parseCampaignWithBackData = CampaignEx.parseCampaignWithBackData(campaignToJsonObject);
                    String optString = campaignToJsonObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
                    if (!TextUtils.isEmpty(optString)) {
                        parseCampaignWithBackData.setCampaignUnitId(optString);
                    }
                    campaignEx = parseCampaignWithBackData;
                    com.mbridge.msdk.mbbanner.common.b.a aVar = this.f13992g;
                    if (aVar != null) {
                        aVar.a(campaignEx);
                    }
                }
            }
        } catch (JSONException e5) {
            e5.printStackTrace();
        } catch (Throwable th) {
            af.b("BannerSignalCommunicationImpl", CampaignEx.JSON_NATIVE_VIDEO_CLICK, th);
        }
    }

    public final void c(Object obj, String str) {
        if (obj != null) {
            try {
                int optInt = new JSONObject(str).optInt("isReady", 1);
                g.a().a(obj, d.a(0));
                com.mbridge.msdk.mbbanner.common.b.a aVar = this.f13992g;
                if (aVar != null) {
                    aVar.b(optInt);
                }
            } catch (Throwable th) {
                af.b("BannerSignalCommunicationImpl", "readyStatus", th);
            }
        }
    }

    public final void close() {
        af.b("BannerSignalCommunicationImpl", CampaignEx.JSON_NATIVE_VIDEO_CLOSE);
        try {
            com.mbridge.msdk.mbbanner.common.b.a aVar = this.f13992g;
            if (aVar != null) {
                aVar.a();
            }
        } catch (Throwable th) {
            af.b("BannerSignalCommunicationImpl", CampaignEx.JSON_NATIVE_VIDEO_CLOSE, th);
        }
    }

    public final void d(Object obj, String str) {
        af.b("BannerSignalCommunicationImpl", "toggleCloseBtn");
        try {
            if (!TextUtils.isEmpty(str)) {
                int optInt = new JSONObject(str).optInt(MRAIDCommunicatorUtil.KEY_STATE);
                com.mbridge.msdk.mbbanner.common.b.a aVar = this.f13992g;
                if (aVar != null) {
                    aVar.a(optInt);
                }
            }
        } catch (Throwable th) {
            af.b("BannerSignalCommunicationImpl", "toggleCloseBtn", th);
        }
    }

    public final void e(Object obj, String str) {
        af.b("BannerSignalCommunicationImpl", "triggerCloseBtn");
        try {
            if (!TextUtils.isEmpty(str)) {
                String optString = new JSONObject(str).optString(MRAIDCommunicatorUtil.KEY_STATE);
                com.mbridge.msdk.mbbanner.common.b.a aVar = this.f13992g;
                if (aVar != null) {
                    aVar.a(optString);
                }
                g.a().a(obj, d.a(0));
            }
        } catch (Throwable th) {
            af.b("BannerSignalCommunicationImpl", "triggerCloseBtn", th);
            g.a().a(obj, d.a(-1));
        }
    }

    public final void expand(String str, boolean z4) {
        Context context;
        String str2 = "";
        try {
            if (getMraidCampaign() != null) {
                if (TextUtils.isEmpty(getMraidCampaign().getBannerHtml())) {
                    str2 = getMraidCampaign().getBannerUrl();
                } else {
                    str2 = "file:////" + getMraidCampaign().getBannerHtml();
                }
            }
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(str)) {
                str2 = str;
            }
            bundle.putString("url", str2);
            bundle.putBoolean("shouldUseCustomClose", z4);
            WeakReference<Context> weakReference = this.f13987b;
            if (!(weakReference == null || (context = weakReference.get()) == null)) {
                BannerExpandDialog bannerExpandDialog = this.f13993h;
                if (bannerExpandDialog == null || !bannerExpandDialog.isShowing()) {
                    BannerExpandDialog bannerExpandDialog2 = new BannerExpandDialog(context, bundle, this.f13992g);
                    this.f13993h = bannerExpandDialog2;
                    bannerExpandDialog2.setCampaignList(this.f13990e, this.f13988c);
                    this.f13993h.show();
                } else {
                    return;
                }
            }
            com.mbridge.msdk.mbbanner.common.b.a aVar = this.f13992g;
            if (aVar != null) {
                aVar.a(true);
            }
            String str3 = this.f13990e;
            CampaignEx mraidCampaign = getMraidCampaign();
            JSONObject jSONObject = new JSONObject();
            if (mraidCampaign.isBidCampaign()) {
                jSONObject.put(CampaignEx.JSON_KEY_HB, 1);
            }
            jSONObject.put(LeanbackPreferenceDialogFragment.ARG_KEY, "2000070");
            jSONObject.put("rid_n", mraidCampaign.getRequestIdNotice());
            jSONObject.put("rid", mraidCampaign.getRequestId());
            jSONObject.put("cid", mraidCampaign.getId());
            jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str3);
            jSONObject.put(CampaignEx.JSON_KEY_CLICK_URL, str);
            jSONObject.put("network_type", String.valueOf(ab.m(com.mbridge.msdk.foundation.controller.c.m().c())));
            com.mbridge.msdk.foundation.same.report.d.d.a().a(jSONObject);
        } catch (Exception e5) {
            af.b("BannerReport", e5.getMessage());
        } catch (Throwable th) {
            af.b("BannerSignalCommunicationImpl", "expand", th);
        }
    }

    public final CampaignEx getMraidCampaign() {
        List<CampaignEx> list = this.f13988c;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.f13988c.get(0);
    }

    public final void i(Object obj, String str) {
        af.a("BannerSignalCommunicationImpl", "sendImpressions:" + str);
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONArray jSONArray = new JSONArray(str);
                final ArrayList arrayList = new ArrayList();
                for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                    String string = jSONArray.getString(i4);
                    for (CampaignEx next : this.f13988c) {
                        if (next.getId().equals(string)) {
                            b.a(this.f13990e, next, "banner");
                            arrayList.add(string);
                        }
                    }
                }
                com.mbridge.msdk.foundation.same.f.a.b().execute(new Runnable() {
                    public final void run() {
                        try {
                            j a5 = j.a((f) com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().c()));
                            ArrayList arrayList = arrayList;
                            int size = arrayList.size();
                            int i4 = 0;
                            while (i4 < size) {
                                Object obj = arrayList.get(i4);
                                i4++;
                                a5.a((String) obj);
                            }
                        } catch (Exception e5) {
                            af.b("BannerSignalCommunicationImpl", e5.getMessage());
                        }
                    }
                });
            }
        } catch (Throwable th) {
            af.b("BannerSignalCommunicationImpl", "sendImpressions", th);
        }
    }

    public final void j(Object obj, String str) {
        if (TextUtils.isEmpty(str)) {
            d.a(obj, "params is empty");
            return;
        }
        try {
            a(obj, new JSONObject(str));
        } catch (Throwable th) {
            af.a("BannerSignalCommunicationImpl", th.getMessage());
        }
    }

    public final void k(Object obj, String str) {
        boolean z4;
        boolean z5;
        Object obj2 = obj;
        String str2 = str;
        af.a("BannerSignalCommunicationImpl", "reportUrls:" + str2);
        if (TextUtils.isEmpty(str2)) {
            d.a(obj2, "params is null");
        } else if (!TextUtils.isEmpty(str2)) {
            try {
                JSONArray jSONArray = new JSONArray(str2);
                for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i4);
                    int optInt = jSONObject.optInt("type");
                    String optString = jSONObject.optString("url");
                    String a5 = ak.a(optString, "&tun=", ab.q() + "");
                    int optInt2 = jSONObject.optInt("report");
                    CampaignEx campaignEx = null;
                    if (optInt2 == 0) {
                        Context c5 = com.mbridge.msdk.foundation.controller.c.m().c();
                        List<CampaignEx> list = this.f13988c;
                        if (list != null) {
                            campaignEx = list.get(0);
                        }
                        CampaignEx campaignEx2 = campaignEx;
                        if (optInt != 0) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        com.mbridge.msdk.click.a.a(c5, campaignEx2, "", a5, false, z5);
                    } else {
                        Context c6 = com.mbridge.msdk.foundation.controller.c.m().c();
                        List<CampaignEx> list2 = this.f13988c;
                        if (list2 != null) {
                            campaignEx = list2.get(0);
                        }
                        CampaignEx campaignEx3 = campaignEx;
                        if (optInt != 0) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        com.mbridge.msdk.click.a.a(c6, campaignEx3, "", a5, false, z4, optInt2);
                    }
                }
                g.a().a(obj2, d.a(0));
            } catch (Throwable th) {
                af.b("BannerSignalCommunicationImpl", "reportUrls", th);
            }
        }
    }

    public final void open(String str) {
        af.b("BannerSignalCommunicationImpl", "open");
        try {
            af.b("BannerSignalCommunicationImpl", str);
            if (this.f13988c.size() > 1) {
                com.mbridge.msdk.foundation.controller.c.m().c().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                str = null;
            }
            com.mbridge.msdk.mbbanner.common.b.a aVar = this.f13992g;
            if (aVar != null) {
                aVar.a(true, str);
            }
        } catch (Throwable th) {
            af.b("BannerSignalCommunicationImpl", "open", th);
        }
    }

    public final void unload() {
        close();
    }

    public final void useCustomClose(boolean z4) {
        int i4;
        if (z4) {
            i4 = 2;
        } else {
            i4 = 1;
        }
        try {
            com.mbridge.msdk.mbbanner.common.b.a aVar = this.f13992g;
            if (aVar != null) {
                aVar.a(i4);
            }
        } catch (Throwable th) {
            af.b("BannerSignalCommunicationImpl", "useCustomClose", th);
        }
    }

    public final void a(List<CampaignEx> list) {
        this.f13988c = list;
    }

    public final void a(int i4) {
        this.f13991f = i4;
    }

    public final void a() {
        if (this.f13992g != null) {
            this.f13992g = null;
        }
        if (this.f13993h != null) {
            this.f13993h = null;
        }
    }

    public final void a(Object obj, String str) {
        af.b("BannerSignalCommunicationImpl", "BANNER INIT INVOKE");
        try {
            JSONObject jSONObject = new JSONObject();
            com.mbridge.msdk.foundation.tools.j jVar = new com.mbridge.msdk.foundation.tools.j(com.mbridge.msdk.foundation.controller.c.m().c());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("dev_close_state", this.f13991f);
            jSONObject.put("sdkSetting", jSONObject2);
            jSONObject.put("device", jVar.a());
            jSONObject.put("campaignList", CampaignEx.parseCamplistToJson(this.f13988c));
            k d5 = h.a().d(com.mbridge.msdk.foundation.controller.c.m().k(), this.f13990e);
            if (d5 == null) {
                d5 = k.d(this.f13990e);
            }
            if (!TextUtils.isEmpty(this.f13989d)) {
                d5.a(this.f13989d);
            }
            jSONObject.put("unitSetting", d5.x());
            String g4 = h.a().g(com.mbridge.msdk.foundation.controller.c.m().k());
            if (!TextUtils.isEmpty(g4)) {
                jSONObject.put("appSetting", new JSONObject(g4));
            }
            jSONObject.put("sdk_info", com.mbridge.msdk.mbsignalcommon.base.d.f14038a);
            af.b("BannerSignalCommunicationImpl", "init" + jSONObject.toString());
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            af.b("BannerSignalCommunicationImpl", "init", th);
        }
    }

    private static void a(Object obj, JSONObject jSONObject) {
        String str;
        int i4;
        String str2;
        Object obj2 = obj;
        JSONObject jSONObject2 = jSONObject;
        String str3 = "";
        JSONObject jSONObject3 = new JSONObject();
        int i5 = 1;
        if (jSONObject2 == null) {
            try {
                jSONObject3.put("code", 1);
                jSONObject3.put("message", "params is null");
                g.a().a(obj2, Base64.encodeToString(jSONObject3.toString().getBytes(), 2));
            } catch (JSONException e5) {
                af.a("BannerSignalCommunicationImpl", e5.getMessage());
            }
        } else {
            try {
                jSONObject3.put("code", 0);
                jSONObject3.put("message", str3);
                JSONArray jSONArray = jSONObject2.getJSONArray("resource");
                if (jSONArray == null || jSONArray.length() <= 0) {
                    try {
                        jSONObject3.put("code", 1);
                        jSONObject3.put("message", "resource is null");
                        g.a().a(obj2, Base64.encodeToString(jSONObject3.toString().getBytes(), 2));
                    } catch (JSONException e6) {
                        af.a("BannerSignalCommunicationImpl", e6.getMessage());
                    }
                } else {
                    JSONArray jSONArray2 = new JSONArray();
                    int length = jSONArray.length();
                    int i6 = 0;
                    while (i6 < length) {
                        JSONObject jSONObject4 = jSONArray.getJSONObject(i6);
                        String optString = jSONObject4.optString("ref", str3);
                        int i7 = jSONObject4.getInt("type");
                        JSONObject jSONObject5 = new JSONObject();
                        JSONArray jSONArray3 = jSONArray;
                        if (i7 == i5) {
                            if (!TextUtils.isEmpty(optString)) {
                                JSONObject jSONObject6 = new JSONObject();
                                m a5 = n.a((f) com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().c())).a(optString);
                                if (a5 != null) {
                                    m mVar = a5;
                                    af.a("BannerSignalCommunicationImpl", "VideoBean not null");
                                    jSONObject6.put("type", 1);
                                    i4 = length;
                                    jSONObject6.put("videoDataLength", mVar.d());
                                    String e7 = mVar.e();
                                    if (TextUtils.isEmpty(e7)) {
                                        af.a("BannerSignalCommunicationImpl", "VideoPath null");
                                        jSONObject6.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, str3);
                                        jSONObject6.put("path4Web", str3);
                                        str = str3;
                                    } else {
                                        str = str3;
                                        af.a("BannerSignalCommunicationImpl", "VideoPath not null");
                                        jSONObject6.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, e7);
                                        jSONObject6.put("path4Web", e7);
                                    }
                                    if (mVar.b() == 5) {
                                        jSONObject6.put("downloaded", 1);
                                    } else {
                                        jSONObject6.put("downloaded", 0);
                                    }
                                    jSONObject5.put(optString, jSONObject6);
                                    jSONArray2.put(jSONObject5);
                                } else {
                                    str = str3;
                                    i4 = length;
                                    af.a("BannerSignalCommunicationImpl", "VideoBean null");
                                }
                                i6++;
                                jSONArray = jSONArray3;
                                length = i4;
                                str3 = str;
                                i5 = 1;
                            }
                        }
                        str = str3;
                        i4 = length;
                        if (i7 == 2 && !TextUtils.isEmpty(optString)) {
                            JSONObject jSONObject7 = new JSONObject();
                            jSONObject7.put("type", 2);
                            jSONObject7.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, H5DownLoadManager.getInstance().getResAddress(optString) == null ? str : H5DownLoadManager.getInstance().getH5ResAddress(optString));
                            jSONObject5.put(optString, jSONObject7);
                            jSONArray2.put(jSONObject5);
                            i6++;
                            jSONArray = jSONArray3;
                            length = i4;
                            str3 = str;
                            i5 = 1;
                        } else if (i7 != 3 || TextUtils.isEmpty(optString)) {
                            if (i7 == 4 && !TextUtils.isEmpty(optString)) {
                                JSONObject jSONObject8 = new JSONObject();
                                jSONObject8.put("type", 4);
                                jSONObject8.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, aj.a(optString) == null ? str : aj.a(optString));
                                jSONObject5.put(optString, jSONObject8);
                                jSONArray2.put(jSONObject5);
                            }
                            i6++;
                            jSONArray = jSONArray3;
                            length = i4;
                            str3 = str;
                            i5 = 1;
                        } else {
                            File file = new File(optString);
                            if (file.exists() && file.isFile() && file.canRead()) {
                                af.a("BannerSignalCommunicationImpl", "getFileInfo Mraid file " + optString);
                                str2 = "file:////" + optString;
                                JSONObject jSONObject9 = new JSONObject();
                                jSONObject9.put("type", 3);
                                jSONObject9.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, str2);
                                jSONObject5.put(optString, jSONObject9);
                                jSONArray2.put(jSONObject5);
                                i6++;
                                jSONArray = jSONArray3;
                                length = i4;
                                str3 = str;
                                i5 = 1;
                            }
                            str2 = str;
                            JSONObject jSONObject92 = new JSONObject();
                            jSONObject92.put("type", 3);
                            jSONObject92.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, str2);
                            jSONObject5.put(optString, jSONObject92);
                            jSONArray2.put(jSONObject5);
                            i6++;
                            jSONArray = jSONArray3;
                            length = i4;
                            str3 = str;
                            i5 = 1;
                        }
                    }
                    jSONObject3.put("resource", jSONArray2);
                    g.a().a(obj2, Base64.encodeToString(jSONObject3.toString().getBytes(), 2));
                }
            } catch (Throwable th) {
                try {
                    jSONObject3.put("code", 1);
                    jSONObject3.put("message", th.getLocalizedMessage());
                    g.a().a(obj2, Base64.encodeToString(jSONObject3.toString().getBytes(), 2));
                } catch (JSONException e8) {
                    af.a("BannerSignalCommunicationImpl", e8.getMessage());
                }
            }
        }
    }
}
