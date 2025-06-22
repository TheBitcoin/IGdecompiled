package com.mbridge.msdk.video.signal.a;

import android.app.Activity;
import com.mbridge.msdk.video.bt.a.d;
import com.mbridge.msdk.video.bt.module.MBridgeBTContainer;

public final class j extends c {

    /* renamed from: a  reason: collision with root package name */
    private Activity f16598a;

    /* renamed from: b  reason: collision with root package name */
    private MBridgeBTContainer f16599b;

    public j(Activity activity, MBridgeBTContainer mBridgeBTContainer) {
        this.f16598a = activity;
        this.f16599b = mBridgeBTContainer;
    }

    public final void click(int i4, String str) {
        super.click(i4, str);
        MBridgeBTContainer mBridgeBTContainer = this.f16599b;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.click(i4, str);
        }
    }

    public final void handlerH5Exception(int i4, String str) {
        super.handlerH5Exception(i4, str);
        MBridgeBTContainer mBridgeBTContainer = this.f16599b;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.handlerH5Exception(i4, str);
        }
    }

    public final void reactDeveloper(Object obj, String str) {
        super.reactDeveloper(obj, str);
        MBridgeBTContainer mBridgeBTContainer = this.f16599b;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.reactDeveloper(obj, str);
        }
    }

    public final void reportUrls(Object obj, String str) {
        super.reportUrls(obj, str);
        MBridgeBTContainer mBridgeBTContainer = this.f16599b;
        if (mBridgeBTContainer != null) {
            mBridgeBTContainer.reportUrls(obj, str);
        } else {
            d.c().b(obj, str);
        }
    }
}
