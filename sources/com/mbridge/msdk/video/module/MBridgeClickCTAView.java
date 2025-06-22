package com.mbridge.msdk.video.module;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.i;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.video.dynview.e.h;
import com.mbridge.msdk.video.dynview.j.c;
import com.mbridge.msdk.video.module.a.a.e;
import com.mbridge.msdk.video.signal.factory.b;
import org.json.JSONException;
import org.json.JSONObject;

public class MBridgeClickCTAView extends MBridgeClickCTAViewDiff {
    public a ctaClickCallBack;

    /* renamed from: m  reason: collision with root package name */
    private ViewGroup f16250m;

    /* renamed from: n  reason: collision with root package name */
    private ImageView f16251n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f16252o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public TextView f16253p;

    /* renamed from: q  reason: collision with root package name */
    private String f16254q;

    /* renamed from: r  reason: collision with root package name */
    private float f16255r;

    /* renamed from: s  reason: collision with root package name */
    private float f16256s;

    /* renamed from: t  reason: collision with root package name */
    private int f16257t;

    /* renamed from: u  reason: collision with root package name */
    private ObjectAnimator f16258u;

    public interface a {
        void ctaClick();
    }

    public MBridgeClickCTAView(Context context) {
        super(context);
    }

    /* access modifiers changed from: private */
    public boolean b() {
        this.f16250m = (ViewGroup) findViewById(findID("mbridge_viewgroup_ctaroot"));
        this.f16251n = (ImageView) findViewById(findID("mbridge_iv_appicon"));
        this.f16252o = (TextView) findViewById(findID("mbridge_tv_title"));
        TextView textView = (TextView) findViewById(findID("mbridge_tv_install"));
        this.ctaTv = textView;
        return isNotNULL(this.f16250m, this.f16251n, this.f16252o, textView);
    }

    public void init(Context context) {
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ObjectAnimator objectAnimator = this.f16258u;
        if (objectAnimator != null) {
            try {
                objectAnimator.start();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ObjectAnimator objectAnimator = this.f16258u;
        if (objectAnimator != null) {
            try {
                objectAnimator.cancel();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.f16255r = motionEvent.getRawX();
        this.f16256s = motionEvent.getRawY();
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void onSelfConfigurationChanged(Configuration configuration) {
        super.onSelfConfigurationChanged(configuration);
        this.f16257t = configuration.orientation;
    }

    public void preLoadData(b bVar) {
        CampaignEx campaignEx = this.f16239b;
        if (campaignEx != null) {
            if (campaignEx.isDynamicView()) {
                com.mbridge.msdk.video.dynview.b.a().a(new c().b((View) this, this.f16239b), new h() {
                    public final void viewInflaterFail(com.mbridge.msdk.video.dynview.c.a aVar) {
                        af.b(MBridgeBaseView.TAG, "errorMsg:" + aVar.b());
                    }

                    public final void viewInflaterSuccess(com.mbridge.msdk.video.dynview.a aVar) {
                        if (aVar != null) {
                            this.addView(aVar.a());
                            MBridgeClickCTAView mBridgeClickCTAView = MBridgeClickCTAView.this;
                            mBridgeClickCTAView.f16242e = mBridgeClickCTAView.b();
                            MBridgeClickCTAView mBridgeClickCTAView2 = MBridgeClickCTAView.this;
                            TextView unused = mBridgeClickCTAView2.f16253p = (TextView) mBridgeClickCTAView2.findViewById(mBridgeClickCTAView2.findID("mbridge_tv_desc"));
                            MBridgeClickCTAView.this.c();
                        }
                    }
                });
            } else {
                int findLayout = findLayout("mbridge_reward_clickable_cta");
                if (findLayout >= 0) {
                    this.f16240c.inflate(findLayout, this);
                    this.f16242e = b();
                    c();
                    setWrapContent();
                }
            }
            if (this.f16242e) {
                if (com.mbridge.msdk.e.b.a()) {
                    setChinaCTAData();
                }
                this.ctaTv.setText(this.f16239b.getAdCall());
                if (!TextUtils.isEmpty(this.f16239b.getIconUrl())) {
                    com.mbridge.msdk.foundation.same.c.b.a(this.f16238a.getApplicationContext()).a(this.f16239b.getIconUrl(), new e(this.f16251n, this.f16239b, this.f16254q) {
                        public final void onFailedLoad(String str, String str2) {
                            super.onFailedLoad(str, str2);
                            MBridgeClickCTAView.this.a();
                        }
                    });
                } else {
                    a();
                }
                if (this.f16252o != null && !TextUtils.isEmpty(this.f16239b.getAppName())) {
                    this.f16252o.setText(this.f16239b.getAppName());
                }
                if (this.f16253p != null && !TextUtils.isEmpty(this.f16239b.getAppDesc())) {
                    this.f16253p.setText(this.f16239b.getAppDesc());
                }
            }
        }
    }

    public void setCtaClickCallBack(a aVar) {
        this.ctaClickCallBack = aVar;
    }

    public void setObjectAnimator(ObjectAnimator objectAnimator) {
        this.f16258u = objectAnimator;
    }

    public void setUnitId(String str) {
        this.f16254q = str;
    }

    public MBridgeClickCTAView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public final void c() {
        super.c();
        if (this.f16242e) {
            CampaignEx campaignEx = this.f16239b;
            if (campaignEx != null && campaignEx.isDynamicView()) {
                setOnClickListener(new com.mbridge.msdk.widget.a() {
                    /* access modifiers changed from: protected */
                    public final void onNoDoubleClick(View view) {
                        MBridgeClickCTAView mBridgeClickCTAView = MBridgeClickCTAView.this;
                        a aVar = mBridgeClickCTAView.ctaClickCallBack;
                        if (aVar != null) {
                            aVar.ctaClick();
                        } else {
                            MBridgeClickCTAView.b(mBridgeClickCTAView);
                        }
                    }
                });
            }
            this.ctaTv.setOnClickListener(new com.mbridge.msdk.widget.a() {
                /* access modifiers changed from: protected */
                public final void onNoDoubleClick(View view) {
                    MBridgeClickCTAView mBridgeClickCTAView = MBridgeClickCTAView.this;
                    a aVar = mBridgeClickCTAView.ctaClickCallBack;
                    if (aVar != null) {
                        aVar.ctaClick();
                    } else {
                        MBridgeClickCTAView.b(mBridgeClickCTAView);
                    }
                }
            });
            ImageView imageView = this.f16251n;
            if (imageView != null) {
                imageView.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public void a() {
        ImageView imageView = this.f16251n;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    static /* synthetic */ void b(MBridgeClickCTAView mBridgeClickCTAView) {
        JSONObject jSONObject;
        CampaignEx campaignEx = mBridgeClickCTAView.f16239b;
        if (campaignEx != null && campaignEx.isDynamicView()) {
            try {
                CampaignEx.c rewardTemplateMode = mBridgeClickCTAView.f16239b.getRewardTemplateMode();
                String str = "";
                if (rewardTemplateMode != null) {
                    str = rewardTemplateMode.f() + str;
                }
                i.a(com.mbridge.msdk.foundation.controller.c.m().c(), "cta_click", mBridgeClickCTAView.f16239b.getCampaignUnitId(), mBridgeClickCTAView.f16239b.isBidCampaign(), mBridgeClickCTAView.f16239b.getRequestId(), mBridgeClickCTAView.f16239b.getRequestIdNotice(), mBridgeClickCTAView.f16239b.getId(), str);
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
        JSONObject jSONObject2 = null;
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put(com.mbridge.msdk.foundation.same.a.f13136j, mBridgeClickCTAView.a(0));
            } catch (JSONException e6) {
                e = e6;
                jSONObject2 = jSONObject;
            }
        } catch (JSONException e7) {
            e = e7;
            e.printStackTrace();
            jSONObject = jSONObject2;
            mBridgeClickCTAView.f16239b.setTriggerClickSource(1);
            mBridgeClickCTAView.f16239b.setClickTempSource(1);
            mBridgeClickCTAView.notifyListener.a(105, jSONObject);
        }
        mBridgeClickCTAView.f16239b.setTriggerClickSource(1);
        mBridgeClickCTAView.f16239b.setClickTempSource(1);
        mBridgeClickCTAView.notifyListener.a(105, jSONObject);
    }
}
