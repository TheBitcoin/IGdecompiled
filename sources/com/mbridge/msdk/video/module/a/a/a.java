package com.mbridge.msdk.video.module.a.a;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.click.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;

public class a extends f {

    /* renamed from: a  reason: collision with root package name */
    private Activity f16513a;

    /* renamed from: b  reason: collision with root package name */
    private CampaignEx f16514b;

    public a(Activity activity, CampaignEx campaignEx) {
        this.f16513a = activity;
        this.f16514b = campaignEx;
    }

    public void a(int i4, Object obj) {
        super.a(i4, obj);
        if (i4 == 106 && this.f16513a != null && this.f16514b != null) {
            try {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                String a5 = c.a(this.f16514b.getClickURL(), "-999", "-999");
                if (!TextUtils.isEmpty(a5)) {
                    intent.setData(Uri.parse(a5));
                    this.f16513a.startActivity(intent);
                }
            } catch (Throwable th) {
                af.b("NotifyListener", th.getMessage(), th);
            }
            this.f16513a.finish();
        }
    }
}
