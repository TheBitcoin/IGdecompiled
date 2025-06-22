package com.mbridge.msdk.newreward.function.command.receiver.tagreceiver;

import android.text.TextUtils;
import com.mbridge.apt_anotation.ReceiverAction;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.j;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.command.receiver.b;

@ReceiverAction(id = "PlayFrequenceReceiver", type = b.class)
public class PlayFrequenceReceiver implements b {

    /* renamed from: a  reason: collision with root package name */
    e f14821a;

    /* renamed from: b  reason: collision with root package name */
    CampaignEx f14822b;

    public final void a(Object obj) {
        if (obj instanceof e) {
            e eVar = (e) obj;
            this.f14821a = eVar;
            this.f14822b = eVar.U();
        }
        if (this.f14821a != null) {
            if (this.f14822b != null) {
                new Thread(new Runnable() {
                    public final void run() {
                        try {
                            if (PlayFrequenceReceiver.this.f14822b != null) {
                                j.a((f) g.a(c.m().c())).a(PlayFrequenceReceiver.this.f14822b.getId());
                            }
                        } catch (Throwable th) {
                            if (MBridgeConstans.DEBUG) {
                                th.printStackTrace();
                            }
                        }
                    }
                }).start();
            }
            CampaignEx campaignEx = this.f14822b;
            if (campaignEx != null) {
                try {
                    if (com.mbridge.msdk.foundation.same.a.b.f13165j != null && !TextUtils.isEmpty(campaignEx.getId())) {
                        com.mbridge.msdk.foundation.same.a.b.a(this.f14822b.getCampaignUnitId(), this.f14822b, "reward");
                    }
                } catch (Exception e5) {
                    if (MBridgeConstans.DEBUG) {
                        e5.printStackTrace();
                    }
                }
            }
        }
    }
}
