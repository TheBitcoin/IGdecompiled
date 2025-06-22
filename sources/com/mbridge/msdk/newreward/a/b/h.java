package com.mbridge.msdk.newreward.a.b;

import android.content.Context;
import android.graphics.Bitmap;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.c.b;
import com.mbridge.msdk.foundation.same.c.c;
import java.io.IOException;
import java.util.List;

public final class h implements a {

    private static final class a implements c {

        /* renamed from: a  reason: collision with root package name */
        private final com.mbridge.msdk.newreward.function.c.a.a f14322a;

        /* renamed from: b  reason: collision with root package name */
        private final b f14323b;

        public a(com.mbridge.msdk.newreward.function.c.a.a aVar, b bVar) {
            this.f14322a = aVar;
            this.f14323b = bVar;
        }

        public final void onFailedLoad(String str, String str2) {
            if (this.f14323b != null && this.f14322a.i().y()) {
                this.f14323b.reqSuccessful(this.f14322a);
            }
        }

        public final void onSuccessLoad(Bitmap bitmap, String str) {
            if (this.f14323b != null && this.f14322a.i().y()) {
                this.f14323b.reqSuccessful(this.f14322a);
            }
        }
    }

    public final void a(Object obj, b bVar) throws IOException {
        List<CampaignEx.c.a> a5;
        com.mbridge.msdk.newreward.function.c.a.a aVar = (com.mbridge.msdk.newreward.function.c.a.a) obj;
        CampaignEx h4 = aVar.h();
        String imageUrl = h4.getImageUrl();
        Context c5 = com.mbridge.msdk.foundation.controller.c.m().c();
        b.a(c5).a(imageUrl, new a(aVar, bVar));
        b.a(c5).a(h4.getIconUrl(), new a(aVar, bVar));
        CampaignEx.c rewardTemplateMode = h4.getRewardTemplateMode();
        if (rewardTemplateMode != null && (a5 = rewardTemplateMode.a()) != null) {
            for (CampaignEx.c.a aVar2 : a5) {
                List<String> list = aVar2.f12964a;
                if (list != null) {
                    for (String a6 : list) {
                        b.a(c5).a(a6, new a(aVar, bVar));
                    }
                }
            }
        }
    }
}
