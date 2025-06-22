package com.mbridge.msdk.video.module.a.a;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.videocommon.b.c;
import com.mbridge.msdk.videocommon.download.a;

public final class h extends k {
    public h(CampaignEx campaignEx, a aVar, c cVar, String str, String str2, com.mbridge.msdk.video.module.a.a aVar2, int i4, boolean z4) {
        super(campaignEx, aVar, cVar, str, str2, aVar2, i4, z4);
    }

    public final void a(int i4, Object obj) {
        if (i4 == 100) {
            g();
            f();
            e();
            a(2);
        } else if (i4 == 109) {
            b(2);
        } else if (i4 == 122) {
            a();
        } else if (i4 != 129) {
            String str = "";
            if (i4 == 118) {
                if (obj != null && (obj instanceof String)) {
                    str = (String) obj;
                }
                a(3, str);
            } else if (i4 == 119) {
                if (obj != null && (obj instanceof String)) {
                    str = (String) obj;
                }
                a(4, str);
            }
        } else {
            CampaignEx campaignEx = this.f16527b;
            if (campaignEx != null && campaignEx.getPlayable_ads_without_video() == 2) {
                g();
                f();
                e();
                a(1);
            }
        }
        super.a(i4, obj);
    }
}
