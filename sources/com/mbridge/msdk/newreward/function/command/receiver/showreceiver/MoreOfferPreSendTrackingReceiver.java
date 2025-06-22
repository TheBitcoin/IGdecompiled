package com.mbridge.msdk.newreward.function.command.receiver.showreceiver;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.mbridge.apt_anotation.ReceiverAction;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aq;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.command.c;
import com.mbridge.msdk.newreward.function.command.d;
import com.mbridge.msdk.newreward.function.command.receiver.b;
import com.mbridge.msdk.newreward.player.model.MoreOfferModel;
import com.mbridge.msdk.newreward.player.redirect.MoreOfferRedirectModel;
import java.util.List;
import org.json.JSONObject;

@ReceiverAction(id = "MoreOfferPreSendTrackingReceiver", type = b.class)
public class MoreOfferPreSendTrackingReceiver implements b {

    /* renamed from: a  reason: collision with root package name */
    private e f14773a;

    /* renamed from: b  reason: collision with root package name */
    private CampaignEx f14774b;

    /* renamed from: c  reason: collision with root package name */
    private List<CampaignEx> f14775c;

    /* renamed from: d  reason: collision with root package name */
    private int f14776d;

    /* renamed from: e  reason: collision with root package name */
    private int f14777e;

    /* renamed from: f  reason: collision with root package name */
    private c f14778f;

    /* renamed from: g  reason: collision with root package name */
    private MoreOfferModel f14779g;

    /* renamed from: h  reason: collision with root package name */
    private MoreOfferRedirectModel f14780h;

    /* renamed from: i  reason: collision with root package name */
    private List<Integer> f14781i;

    public final void a(Object obj) {
        e eVar = (e) obj;
        this.f14773a = eVar;
        if (eVar != null) {
            this.f14774b = eVar.U();
            try {
                JSONObject jSONObject = new JSONObject(this.f14774b.getMoreOfferJsonData()).getJSONObject(CampaignEx.ENDCARD_URL);
                if (jSONObject != null) {
                    if (jSONObject.has(MBridgeConstans.DYNAMIC_VIEW_MORE_OFFER_ADMFTM)) {
                        this.f14776d = jSONObject.getInt(MBridgeConstans.DYNAMIC_VIEW_MORE_OFFER_ADMFTM);
                    }
                    if (jSONObject.has(MBridgeConstans.DYNAMIC_VIEW_MORE_OFFER_ADMF)) {
                        this.f14777e = jSONObject.getInt(MBridgeConstans.DYNAMIC_VIEW_MORE_OFFER_ADMF);
                    }
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
            try {
                c b5 = d.a().b();
                this.f14778f = b5;
                this.f14779g = new MoreOfferModel(b5);
                if (this.f14773a.E() != null) {
                    this.f14781i = this.f14773a.E().f14899a;
                }
                MoreOfferRedirectModel moreOfferRedirectModel = new MoreOfferRedirectModel();
                this.f14780h = moreOfferRedirectModel;
                moreOfferRedirectModel.setContext(com.mbridge.msdk.foundation.controller.c.m().c());
                this.f14780h.setSettingModel(this.f14773a.x());
                if (!(this.f14773a.E() == null || this.f14773a.E().b() == null)) {
                    this.f14775c = this.f14773a.E().b().E();
                }
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        MoreOfferPreSendTrackingReceiver.this.a();
                    }
                });
            } catch (Exception e6) {
                if (MBridgeConstans.DEBUG) {
                    e6.printStackTrace();
                }
            }
        }
    }

    public final void a() {
        if (this.f14776d == 1) {
            try {
                int min = Math.min(this.f14777e, this.f14775c.size());
                for (int i4 = 0; i4 < min; i4++) {
                    this.f14780h.setItemPositionId(i4);
                    if (!this.f14781i.contains(Integer.valueOf(i4))) {
                        this.f14781i.add(Integer.valueOf(i4));
                        if (!(this.f14773a == null || this.f14780h == null)) {
                            String str = "117361";
                            try {
                                CampaignEx campaignEx = this.f14775c.get(i4);
                                String str2 = "";
                                if (campaignEx != null) {
                                    this.f14780h.setCampaignEx(campaignEx);
                                    str2 = aq.a(campaignEx.getendcard_url(), "mof_testuid");
                                    if (TextUtils.isEmpty(str2)) {
                                        str2 = aq.a(campaignEx.getendcard_url(), "mof_uid");
                                    }
                                }
                                if (!TextUtils.isEmpty(str2)) {
                                    str = str2;
                                }
                                this.f14780h.setUnitId(str);
                            } catch (Exception e5) {
                                if (MBridgeConstans.DEBUG) {
                                    e5.printStackTrace();
                                }
                            }
                        }
                        if (i4 == 0) {
                            this.f14779g.eventOnlyImpression(this.f14780h);
                        }
                        this.f14779g.eventImpression(this.f14780h);
                    }
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
    }
}
