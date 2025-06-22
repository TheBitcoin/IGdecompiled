package com.mbridge.msdk.video.module;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.video.module.a.a;
import com.mbridge.msdk.video.module.a.a.f;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class MBridgeBaseView extends RelativeLayout {
    public static final String TAG = "MBridgeBaseView";

    /* renamed from: a  reason: collision with root package name */
    protected Context f16238a;

    /* renamed from: b  reason: collision with root package name */
    protected CampaignEx f16239b;

    /* renamed from: c  reason: collision with root package name */
    protected LayoutInflater f16240c;

    /* renamed from: d  reason: collision with root package name */
    protected int f16241d;

    /* renamed from: e  reason: collision with root package name */
    protected boolean f16242e;

    /* renamed from: f  reason: collision with root package name */
    protected float f16243f;

    /* renamed from: g  reason: collision with root package name */
    protected float f16244g;

    /* renamed from: h  reason: collision with root package name */
    protected boolean f16245h;

    /* renamed from: i  reason: collision with root package name */
    protected int f16246i;

    /* renamed from: j  reason: collision with root package name */
    protected boolean f16247j;

    /* renamed from: k  reason: collision with root package name */
    protected int f16248k;

    /* renamed from: l  reason: collision with root package name */
    protected int f16249l;
    public a notifyListener;

    public MBridgeBaseView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: protected */
    public final JSONObject a(int i4) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(com.mbridge.msdk.foundation.same.a.f13134h, ak.b(c.m().c(), this.f16243f));
                jSONObject2.put(com.mbridge.msdk.foundation.same.a.f13135i, ak.b(c.m().c(), this.f16244g));
                jSONObject2.put(com.mbridge.msdk.foundation.same.a.f13139m, i4);
                try {
                    this.f16241d = getContext().getResources().getConfiguration().orientation;
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
                jSONObject2.put(com.mbridge.msdk.foundation.same.a.f13137k, this.f16241d);
                jSONObject2.put(com.mbridge.msdk.foundation.same.a.f13138l, (double) ak.d(getContext()));
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

    /* access modifiers changed from: protected */
    public void c() {
    }

    /* access modifiers changed from: protected */
    public final String d() {
        return a(0).toString();
    }

    public void defaultShow() {
        af.a(TAG, "defaultShow");
    }

    public int filterFindViewId(boolean z4, String str) {
        if (z4) {
            return findDyID(str);
        }
        return findID(str);
    }

    public int findColor(String str) {
        return x.a(this.f16238a.getApplicationContext(), str, "color");
    }

    public int findDrawable(String str) {
        return x.a(this.f16238a.getApplicationContext(), str, "drawable");
    }

    public int findDyID(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.hashCode();
        }
        return -1;
    }

    public int findID(String str) {
        return x.a(this.f16238a.getApplicationContext(), str, "id");
    }

    public int findLayout(String str) {
        return x.a(this.f16238a.getApplicationContext(), str, TtmlNode.TAG_LAYOUT);
    }

    public CampaignEx getCampaign() {
        return this.f16239b;
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

    public abstract void init(Context context);

    public boolean isLandscape() {
        if (this.f16238a.getResources().getConfiguration().orientation == 2) {
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
        this.f16241d = configuration.orientation;
        super.onConfigurationChanged(configuration);
        Log.d(TAG, "onConfigurationChanged:" + configuration.orientation);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.f16243f = motionEvent.getRawX();
        this.f16244g = motionEvent.getRawY();
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void onSelfConfigurationChanged(Configuration configuration) {
        this.f16241d = configuration.orientation;
        Log.d(TAG, "onSelfConfigurationChanged:" + configuration.orientation);
    }

    public void setCampaign(CampaignEx campaignEx) {
        this.f16239b = campaignEx;
    }

    public void setLayoutCenter(int i4, int i5) {
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
        }
    }

    public void setLayoutParam(int i4, int i5, int i6, int i7) {
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

    public void setNotifyListener(a aVar) {
        this.notifyListener = aVar;
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

    public MBridgeBaseView(Context context, AttributeSet attributeSet, boolean z4, int i4, boolean z5, int i5, int i6) {
        super(context, attributeSet);
        this.f16241d = 1;
        this.notifyListener = new f();
        this.f16242e = false;
        this.f16248k = 1;
        this.f16249l = 0;
        this.f16238a = context;
        this.f16240c = LayoutInflater.from(context);
        this.f16245h = z4;
        this.f16246i = i4;
        this.f16247j = z5;
        this.f16248k = i5;
        this.f16249l = i6;
        init(context);
    }

    public MBridgeBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16241d = 1;
        this.notifyListener = new f();
        this.f16242e = false;
        this.f16248k = 1;
        this.f16249l = 0;
        this.f16238a = context;
        this.f16240c = LayoutInflater.from(context);
        init(context);
    }
}
