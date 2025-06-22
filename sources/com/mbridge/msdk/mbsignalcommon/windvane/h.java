package com.mbridge.msdk.mbsignalcommon.windvane;

import android.content.Context;

public abstract class h {

    /* renamed from: b  reason: collision with root package name */
    protected Context f14173b;

    /* renamed from: c  reason: collision with root package name */
    protected Object f14174c;

    /* renamed from: d  reason: collision with root package name */
    protected WindVaneWebView f14175d;

    public void initialize(Context context, WindVaneWebView windVaneWebView) {
        this.f14173b = context;
        this.f14175d = windVaneWebView;
    }

    public void initialize(Object obj, WindVaneWebView windVaneWebView) {
        this.f14174c = obj;
        this.f14175d = windVaneWebView;
    }
}
