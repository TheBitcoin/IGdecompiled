package com.mbridge.msdk.activity;

import android.os.Build;
import android.os.Bundle;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.webview.BrowserView;
import com.mbridge.msdk.foundation.webview.b;

public class MBCommonActivity extends DomainMBCommonActivity {

    /* renamed from: d  reason: collision with root package name */
    public static final /* synthetic */ int f11808d = 0;

    /* renamed from: b  reason: collision with root package name */
    private boolean f11809b = false;

    public void finish() {
        BrowserView browserView = this.browserView;
        if (browserView != null) {
            browserView.setListener((BrowserView.a) null);
            this.browserView.destroy();
        }
        BrowserView remove = b.f13765a.remove(this.f11799a);
        if (remove != null) {
            remove.setListener((BrowserView.a) null);
            remove.destroy();
        }
        this.f11809b = true;
        super.finish();
    }

    public void onCreate(Bundle bundle) {
        if (Build.VERSION.SDK_INT != 26) {
            setRequestedOrientation(1);
        }
        super.onCreate(bundle);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (!this.f11809b) {
            BrowserView browserView = this.browserView;
            if (browserView != null) {
                browserView.setListener((BrowserView.a) null);
                this.browserView.destroy();
            }
            BrowserView remove = b.f13765a.remove(this.f11799a);
            if (remove != null) {
                remove.setListener((BrowserView.a) null);
                remove.destroy();
            }
        }
    }

    public void testfun() {
        af.b("ASDFA", "DSFASDFADSFADSFADS");
    }
}
