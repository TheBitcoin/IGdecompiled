package com.mbridge.msdk.video.module;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.a;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.video.module.a.a.j;
import com.mbridge.msdk.video.signal.factory.b;
import org.json.JSONException;
import org.json.JSONObject;

public class MBridgeVideoEndCoverView extends MBridgeBaseView {

    /* renamed from: m  reason: collision with root package name */
    private final String f16415m = "MBridgeVideoEndCoverView";

    /* renamed from: n  reason: collision with root package name */
    private View f16416n;

    /* renamed from: o  reason: collision with root package name */
    private ImageView f16417o;

    /* renamed from: p  reason: collision with root package name */
    private ImageView f16418p;

    /* renamed from: q  reason: collision with root package name */
    private TextView f16419q;

    /* renamed from: r  reason: collision with root package name */
    private TextView f16420r;

    /* renamed from: s  reason: collision with root package name */
    private TextView f16421s;

    /* renamed from: t  reason: collision with root package name */
    private b f16422t;

    public MBridgeVideoEndCoverView(Context context) {
        super(context);
    }

    private boolean a(View view) {
        if (view == null) {
            return true;
        }
        try {
            this.f16417o = (ImageView) view.findViewById(findID("mbridge_vec_iv_icon"));
            this.f16418p = (ImageView) view.findViewById(findID("mbridge_vec_iv_close"));
            this.f16419q = (TextView) view.findViewById(findID("mbridge_vec_tv_title"));
            this.f16420r = (TextView) view.findViewById(findID("mbridge_vec_tv_desc"));
            this.f16421s = (TextView) view.findViewById(findID("mbridge_vec_btn"));
            return true;
        } catch (Throwable th) {
            af.b("MBridgeVideoEndCoverView", th.getMessage());
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public final void c() {
        super.c();
        this.f16418p.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                MBridgeVideoEndCoverView.this.notifyListener.a(104, "");
            }
        });
        this.f16417o.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                MBridgeVideoEndCoverView.this.a();
            }
        });
        this.f16421s.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                MBridgeVideoEndCoverView.this.a();
            }
        });
    }

    public void init(Context context) {
        int findLayout = findLayout("mbridge_reward_videoend_cover");
        if (findLayout >= 0) {
            View inflate = this.f16240c.inflate(findLayout, (ViewGroup) null);
            this.f16416n = inflate;
            if (inflate != null) {
                this.f16242e = a(inflate);
                addView(this.f16416n, -1, -1);
                c();
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.f16243f = motionEvent.getRawX();
        this.f16244g = motionEvent.getRawY();
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void onSelfConfigurationChanged(Configuration configuration) {
        super.onSelfConfigurationChanged(configuration);
        this.f16241d = configuration.orientation;
        removeView(this.f16416n);
        View view = this.f16416n;
        if (view == null) {
            init(this.f16238a);
            preLoadData(this.f16422t);
            return;
        }
        if (view.getParent() != null) {
            ((ViewGroup) this.f16416n.getParent()).removeView(this.f16416n);
        }
        addView(this.f16416n);
        a(this.f16416n);
        c();
    }

    public void preLoadData(b bVar) {
        ImageView imageView;
        this.f16422t = bVar;
        try {
            CampaignEx campaignEx = this.f16239b;
            if (campaignEx != null && this.f16242e && campaignEx != null) {
                if (!TextUtils.isEmpty(campaignEx.getIconUrl()) && (imageView = this.f16417o) != null) {
                    com.mbridge.msdk.foundation.same.c.b.a(this.f16238a.getApplicationContext()).a(this.f16239b.getIconUrl(), new j(imageView, ak.a(c.m().c(), 8.0f)));
                }
                TextView textView = this.f16419q;
                if (textView != null) {
                    textView.setText(this.f16239b.getAppName());
                }
                TextView textView2 = this.f16421s;
                if (textView2 != null) {
                    textView2.setText(this.f16239b.getAdCall());
                }
                TextView textView3 = this.f16420r;
                if (textView3 != null) {
                    textView3.setText(this.f16239b.getAppDesc());
                }
            }
        } catch (Throwable th) {
            af.a("MBridgeVideoEndCoverView", th.getMessage());
        }
    }

    public MBridgeVideoEndCoverView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public final void a() {
        JSONObject jSONObject;
        JSONException e5;
        JSONObject jSONObject2;
        JSONException e6;
        try {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(a.f13134h, ak.b(c.m().c(), this.f16243f));
                    jSONObject2.put(a.f13135i, ak.b(c.m().c(), this.f16244g));
                    jSONObject2.put(a.f13139m, 0);
                    try {
                        this.f16241d = getContext().getResources().getConfiguration().orientation;
                    } catch (Exception e7) {
                        e7.printStackTrace();
                    }
                    jSONObject2.put(a.f13137k, this.f16241d);
                    jSONObject2.put(a.f13138l, (double) ak.d(getContext()));
                } catch (JSONException e8) {
                    e6 = e8;
                    af.b("MBridgeVideoEndCoverView", e6.getMessage());
                    jSONObject = new JSONObject();
                    jSONObject.put(a.f13136j, jSONObject2);
                    this.notifyListener.a(105, jSONObject);
                }
            } catch (JSONException e9) {
                JSONException jSONException = e9;
                jSONObject2 = jSONObject3;
                e6 = jSONException;
                af.b("MBridgeVideoEndCoverView", e6.getMessage());
                jSONObject = new JSONObject();
                jSONObject.put(a.f13136j, jSONObject2);
                this.notifyListener.a(105, jSONObject);
            }
            jSONObject = new JSONObject();
            try {
                jSONObject.put(a.f13136j, jSONObject2);
            } catch (JSONException e10) {
                e5 = e10;
            }
        } catch (JSONException e11) {
            JSONException jSONException2 = e11;
            jSONObject = null;
            e5 = jSONException2;
            e5.printStackTrace();
            this.notifyListener.a(105, jSONObject);
        }
        this.notifyListener.a(105, jSONObject);
    }
}
