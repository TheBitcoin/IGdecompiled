package com.mbridge.msdk.video.module.a.a;

import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.video.module.b.b;
import com.mbridge.msdk.videocommon.b.c;
import com.mbridge.msdk.videocommon.download.a;

public class d extends k {
    public d(CampaignEx campaignEx, a aVar, c cVar, String str, String str2, com.mbridge.msdk.video.module.a.a aVar2, int i4, boolean z4) {
        super(campaignEx, aVar, cVar, str, str2, aVar2, i4, z4);
    }

    public void a(int i4, Object obj) {
        super.a(i4, obj);
        if (this.f16526a) {
            try {
                CampaignEx campaignEx = this.f16527b;
                if (campaignEx != null && campaignEx.getDynamicTempCode() == 5) {
                    b(obj.toString());
                }
            } catch (Exception unused) {
            }
            if (i4 == 105 || i4 == 106 || i4 == 113) {
                b.d(com.mbridge.msdk.foundation.controller.c.m().c(), this.f16527b);
                if (i4 != 105) {
                    String noticeUrl = this.f16527b.getNoticeUrl();
                    if (!TextUtils.isEmpty(noticeUrl)) {
                        if (!noticeUrl.contains(com.mbridge.msdk.foundation.same.a.f13139m)) {
                            noticeUrl = noticeUrl + "&" + com.mbridge.msdk.foundation.same.a.f13139m + "=2";
                        } else {
                            noticeUrl = noticeUrl.replace(com.mbridge.msdk.foundation.same.a.f13139m + "=" + Uri.parse(noticeUrl).getQueryParameter(com.mbridge.msdk.foundation.same.a.f13139m), com.mbridge.msdk.foundation.same.a.f13139m + "=2");
                        }
                    }
                    com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), this.f16527b, this.f16532g, noticeUrl, true, false, com.mbridge.msdk.click.a.a.f12016i);
                }
            } else if (i4 != 122) {
                switch (i4) {
                    case 109:
                        b(2);
                        a(2);
                        return;
                    case 110:
                        b(1);
                        a(1);
                        return;
                    case 111:
                        a(1);
                        return;
                    default:
                        return;
                }
            } else {
                a();
            }
        }
    }
}
