package com.mbridge.msdk.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.d.a;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.c.b;
import com.mbridge.msdk.foundation.same.net.e.d;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.out.Campaign;

public class MBAdChoice extends MBImageView {

    /* renamed from: a  reason: collision with root package name */
    private final Context f17147a;

    /* renamed from: b  reason: collision with root package name */
    private String f17148b = "";

    /* renamed from: c  reason: collision with root package name */
    private String f17149c = "";

    /* renamed from: d  reason: collision with root package name */
    private String f17150d = "";

    /* renamed from: e  reason: collision with root package name */
    private CampaignEx f17151e;

    /* renamed from: f  reason: collision with root package name */
    private a f17152f;

    public MBAdChoice(Context context) {
        super(context);
        this.f17147a = context;
        a();
    }

    private void a() {
        setScaleType(ImageView.ScaleType.FIT_CENTER);
        setClickable(true);
    }

    public boolean performClick() {
        if (this.f17152f == null) {
            this.f17152f = new a() {
                public final void close() {
                }

                public final void showed() {
                }

                public final void summit(String str) {
                }
            };
        }
        ak.a(this.f17151e, this.f17152f, 4, "");
        return true;
    }

    public void setCampaign(Campaign campaign) {
        boolean z4;
        if (campaign instanceof CampaignEx) {
            CampaignEx campaignEx = (CampaignEx) campaign;
            this.f17151e = campaignEx;
            g b5 = h.a().b(c.m().k());
            this.f17151e = campaignEx;
            if (campaignEx != null) {
                String privacyUrl = campaignEx.getPrivacyUrl();
                this.f17149c = privacyUrl;
                if (TextUtils.isEmpty(privacyUrl)) {
                    CampaignEx.a adchoice = campaignEx.getAdchoice();
                    if (adchoice != null) {
                        this.f17149c = adchoice.c();
                    }
                    if (TextUtils.isEmpty(this.f17149c) && b5 != null) {
                        this.f17149c = b5.j();
                    }
                    if (TextUtils.isEmpty(this.f17149c)) {
                        this.f17149c = d.f().f13316f;
                    }
                }
            } else if (b5 != null) {
                this.f17149c = b5.j();
            }
            this.f17151e = campaignEx;
            if (campaignEx != null) {
                CampaignEx.a adchoice2 = campaignEx.getAdchoice();
                if (adchoice2 != null) {
                    this.f17148b = adchoice2.b();
                }
                if (TextUtils.isEmpty(this.f17148b) && b5 != null) {
                    this.f17148b = b5.i();
                }
            } else if (b5 != null) {
                this.f17148b = b5.i();
            }
            this.f17151e = campaignEx;
            if (campaignEx != null) {
                CampaignEx.a adchoice3 = campaignEx.getAdchoice();
                if (adchoice3 != null) {
                    this.f17150d = adchoice3.d();
                }
                if (TextUtils.isEmpty(this.f17150d) && b5 != null) {
                    this.f17150d = b5.k();
                }
            } else if (b5 != null) {
                this.f17150d = b5.k();
            }
            if (TextUtils.isEmpty(this.f17148b) || TextUtils.isEmpty(this.f17149c) || TextUtils.isEmpty(this.f17150d)) {
                z4 = false;
            } else {
                z4 = true;
            }
            setImageUrl(this.f17148b);
            if (z4 && this.f17147a != null) {
                b.a(c.m().c()).a(this.f17148b, new com.mbridge.msdk.foundation.same.c.c() {
                    public final void onFailedLoad(String str, String str2) {
                    }

                    public final void onSuccessLoad(Bitmap bitmap, String str) {
                        MBAdChoice.this.setImageBitmap(bitmap);
                    }
                });
                return;
            }
            return;
        }
        this.f17151e = null;
    }

    public void setFeedbackDialogEventListener(a aVar) {
        this.f17152f = aVar;
    }

    public MBAdChoice(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17147a = context;
        a();
    }

    public MBAdChoice(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f17147a = context;
        a();
    }
}
