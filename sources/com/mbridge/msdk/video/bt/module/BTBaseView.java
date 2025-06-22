package com.mbridge.msdk.video.bt.module;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.a;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.video.bt.a.d;
import com.mbridge.msdk.videocommon.d.c;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class BTBaseView extends FrameLayout {
    public static final String TAG = "BTBaseView";

    /* renamed from: n  reason: collision with root package name */
    protected static int f15762n = 0;

    /* renamed from: o  reason: collision with root package name */
    protected static int f15763o = 1;

    /* renamed from: a  reason: collision with root package name */
    protected Context f15764a;

    /* renamed from: b  reason: collision with root package name */
    protected CampaignEx f15765b;

    /* renamed from: c  reason: collision with root package name */
    protected String f15766c;

    /* renamed from: d  reason: collision with root package name */
    protected String f15767d;

    /* renamed from: e  reason: collision with root package name */
    protected c f15768e;

    /* renamed from: f  reason: collision with root package name */
    protected LayoutInflater f15769f;

    /* renamed from: g  reason: collision with root package name */
    protected int f15770g;

    /* renamed from: h  reason: collision with root package name */
    protected boolean f15771h;

    /* renamed from: i  reason: collision with root package name */
    protected float f15772i;

    /* renamed from: j  reason: collision with root package name */
    protected float f15773j;

    /* renamed from: k  reason: collision with root package name */
    protected Rect f15774k;

    /* renamed from: l  reason: collision with root package name */
    protected int f15775l;

    /* renamed from: m  reason: collision with root package name */
    protected int f15776m;

    public BTBaseView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: protected */
    public void a() {
    }

    public void defaultShow() {
        af.a(TAG, "defaultShow");
    }

    public int findColor(String str) {
        return x.a(this.f15764a.getApplicationContext(), str, "color");
    }

    public int findDrawable(String str) {
        return x.a(this.f15764a.getApplicationContext(), str, "drawable");
    }

    public int findID(String str) {
        return x.a(this.f15764a.getApplicationContext(), str, "id");
    }

    public int findLayout(String str) {
        return x.a(this.f15764a.getApplicationContext(), str, TtmlNode.TAG_LAYOUT);
    }

    public CampaignEx getCampaign() {
        return this.f15765b;
    }

    public String getInstanceId() {
        return this.f15767d;
    }

    public FrameLayout.LayoutParams getParentFrameLayoutParams() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            return (FrameLayout.LayoutParams) layoutParams;
        }
        return null;
    }

    public LinearLayout.LayoutParams getParentLinearLayoutParams() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return (LinearLayout.LayoutParams) layoutParams;
        }
        return null;
    }

    public RelativeLayout.LayoutParams getParentRelativeLayoutParams() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            return (RelativeLayout.LayoutParams) layoutParams;
        }
        return null;
    }

    public Rect getRect() {
        return this.f15774k;
    }

    public String getUnitId() {
        return this.f15766c;
    }

    public int getViewHeight() {
        return this.f15776m;
    }

    public int getViewWidth() {
        return this.f15775l;
    }

    public abstract void init(Context context);

    public boolean isLandscape() {
        if (this.f15764a.getResources().getConfiguration().orientation == 2) {
            return true;
        }
        return false;
    }

    public boolean isNotNULL(View... viewArr) {
        if (viewArr == null) {
            return false;
        }
        int length = viewArr.length;
        int i4 = 0;
        boolean z4 = false;
        while (i4 < length) {
            if (viewArr[i4] == null) {
                return false;
            }
            i4++;
            z4 = true;
        }
        return z4;
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.f15770g = configuration.orientation;
        super.onConfigurationChanged(configuration);
    }

    public abstract void onDestory();

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.f15772i = motionEvent.getRawX();
        this.f15773j = motionEvent.getRawY();
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void onSelfConfigurationChanged(Configuration configuration) {
        this.f15770g = configuration.orientation;
    }

    public void setCampaign(CampaignEx campaignEx) {
        this.f15765b = campaignEx;
    }

    public void setInstanceId(String str) {
        this.f15767d = str;
    }

    public void setLayout(int i4, int i5) {
        this.f15775l = i4;
        this.f15776m = i5;
    }

    public void setLayoutCenter(int i4, int i5) {
        FrameLayout.LayoutParams parentFrameLayoutParams = getParentFrameLayoutParams();
        RelativeLayout.LayoutParams parentRelativeLayoutParams = getParentRelativeLayoutParams();
        LinearLayout.LayoutParams parentLinearLayoutParams = getParentLinearLayoutParams();
        if (parentRelativeLayoutParams != null) {
            parentRelativeLayoutParams.addRule(13);
            if (i4 != -999) {
                parentRelativeLayoutParams.width = i4;
            }
            if (i5 != -999) {
                parentRelativeLayoutParams.height = i5;
            }
            setLayoutParams(parentRelativeLayoutParams);
        } else if (parentLinearLayoutParams != null) {
            parentLinearLayoutParams.gravity = 17;
            if (i4 != -999) {
                parentLinearLayoutParams.width = i4;
            }
            if (i5 != -999) {
                parentLinearLayoutParams.height = i5;
            }
            setLayoutParams(parentLinearLayoutParams);
        } else if (parentFrameLayoutParams != null) {
            parentFrameLayoutParams.gravity = 17;
            if (i4 != -999) {
                parentFrameLayoutParams.width = i4;
            }
            if (i5 != -999) {
                parentFrameLayoutParams.height = i5;
            }
            setLayoutParams(parentFrameLayoutParams);
        }
    }

    public void setLayoutParam(int i4, int i5, int i6, int i7) {
        FrameLayout.LayoutParams parentFrameLayoutParams = getParentFrameLayoutParams();
        RelativeLayout.LayoutParams parentRelativeLayoutParams = getParentRelativeLayoutParams();
        LinearLayout.LayoutParams parentLinearLayoutParams = getParentLinearLayoutParams();
        if (parentRelativeLayoutParams != null) {
            parentRelativeLayoutParams.topMargin = i5;
            parentRelativeLayoutParams.leftMargin = i4;
            if (i6 != -999) {
                parentRelativeLayoutParams.width = i6;
            }
            if (i7 != -999) {
                parentRelativeLayoutParams.height = i7;
            }
            setLayoutParams(parentRelativeLayoutParams);
        } else if (parentLinearLayoutParams != null) {
            parentLinearLayoutParams.topMargin = i5;
            parentLinearLayoutParams.leftMargin = i4;
            if (i6 != -999) {
                parentLinearLayoutParams.width = i6;
            }
            if (i7 != -999) {
                parentLinearLayoutParams.height = i7;
            }
            setLayoutParams(parentLinearLayoutParams);
        } else if (parentFrameLayoutParams != null) {
            parentFrameLayoutParams.topMargin = i5;
            parentFrameLayoutParams.leftMargin = i4;
            if (i6 != -999) {
                parentFrameLayoutParams.width = i6;
            }
            if (i7 != -999) {
                parentFrameLayoutParams.height = i7;
            }
            setLayoutParams(parentFrameLayoutParams);
        }
    }

    public void setMatchParent() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            return;
        }
        layoutParams.height = -1;
        layoutParams.width = -1;
    }

    public void setRect(Rect rect) {
        this.f15774k = rect;
    }

    public void setRewardUnitSetting(c cVar) {
        this.f15768e = cVar;
    }

    public void setUnitId(String str) {
        this.f15766c = str;
    }

    public void setWrapContent() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            return;
        }
        layoutParams.height = -2;
        layoutParams.width = -2;
    }

    public BTBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15767d = "";
        this.f15770g = 1;
        this.f15771h = false;
        this.f15764a = context;
        this.f15769f = LayoutInflater.from(context);
        init(context);
    }

    /* access modifiers changed from: protected */
    public final JSONObject a(int i4) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(a.f13134h, ak.b(com.mbridge.msdk.foundation.controller.c.m().c(), this.f15772i));
                jSONObject2.put(a.f13135i, ak.b(com.mbridge.msdk.foundation.controller.c.m().c(), this.f15773j));
                jSONObject2.put(a.f13139m, i4);
                try {
                    this.f15770g = getContext().getResources().getConfiguration().orientation;
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
                jSONObject2.put(a.f13137k, this.f15770g);
                jSONObject2.put(a.f13138l, (double) ak.d(getContext()));
                return jSONObject2;
            } catch (JSONException e6) {
                e = e6;
                jSONObject = jSONObject2;
                e.printStackTrace();
                return jSONObject;
            }
        } catch (JSONException e7) {
            e = e7;
            e.printStackTrace();
            return jSONObject;
        }
    }

    protected static void a(WebView webView, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", f15762n);
            jSONObject.put("id", str2);
            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, new JSONObject());
            g.a().a(webView, str, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e5) {
            d.c().a(webView, e5.getMessage());
            af.a(TAG, e5.getMessage());
        }
    }
}
