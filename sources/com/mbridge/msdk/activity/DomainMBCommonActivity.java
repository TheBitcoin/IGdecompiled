package com.mbridge.msdk.activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.aj;
import com.mbridge.msdk.foundation.tools.at;
import com.mbridge.msdk.foundation.webview.BrowserView;
import com.mbridge.msdk.foundation.webview.b;
import com.mbridge.msdk.out.NativeListener;

public class DomainMBCommonActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    String f11799a = "";

    /* renamed from: b  reason: collision with root package name */
    private final BrowserView.a f11800b = new BrowserView.a() {
        public final void a(WebView webView, int i4, String str, String str2) {
        }

        public final boolean b(WebView webView, String str) {
            af.b("MBCommonActivity", "shouldOverrideUrlLoading  " + str);
            if (aj.a.b(str) && aj.a.a(DomainMBCommonActivity.this, str, (NativeListener.NativeTrackingListener) null)) {
                DomainMBCommonActivity.this.finish();
            }
            return DomainMBCommonActivity.this.a(webView, str);
        }

        public final void c(WebView webView, String str) {
            af.b("MBCommonActivity", "onPageFinished  " + str);
        }

        public final void a(WebView webView, String str) {
        }

        public final void a() {
            DomainMBCommonActivity.this.finish();
        }

        public final void a(WebView webView, String str, Bitmap bitmap) {
            af.b("MBCommonActivity", "onPageStarted  " + str);
        }
    };
    protected BrowserView browserView;

    /* renamed from: c  reason: collision with root package name */
    private CampaignEx f11801c;

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        try {
            requestWindowFeature(1);
        } catch (Throwable th) {
            af.b("MBCommonActivity", th.getMessage());
        }
        if (c.m().c() == null) {
            c.m().b(getApplicationContext());
        }
        c.m().a((Context) this);
        String stringExtra = getIntent().getStringExtra("url");
        this.f11799a = stringExtra;
        if (!TextUtils.isEmpty(stringExtra)) {
            this.f11801c = (CampaignEx) getIntent().getSerializableExtra("mvcommon");
            if (b.f13765a.containsKey(this.f11799a)) {
                BrowserView browserView2 = b.f13765a.get(this.f11799a);
                this.browserView = browserView2;
                if (browserView2 != null) {
                    browserView2.setListener(this.f11800b);
                }
            } else {
                BrowserView browserView3 = new BrowserView((Context) this, this.f11801c);
                this.browserView = browserView3;
                browserView3.setListener(this.f11800b);
                this.browserView.loadUrl(this.f11799a);
            }
            BrowserView browserView4 = this.browserView;
            if (browserView4 != null) {
                at.a(browserView4);
                setContentView(this.browserView);
                return;
            }
            return;
        }
        Toast.makeText(this, "Error: no data", 0).show();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00da A[Catch:{ all -> 0x0098, all -> 0x0048 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00e3 A[Catch:{ all -> 0x0098, all -> 0x0048 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(android.webkit.WebView r11, java.lang.String r12) {
        /*
            r10 = this;
            java.lang.String r0 = "intent"
            java.lang.String r1 = "https"
            java.lang.String r2 = "http"
            java.lang.String r3 = "MBCommonActivity"
            r4 = 0
            boolean r5 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x0048 }
            if (r5 == 0) goto L_0x0010
            return r4
        L_0x0010:
            android.net.Uri r5 = android.net.Uri.parse(r12)     // Catch:{ all -> 0x0048 }
            java.lang.String r6 = r5.getScheme()     // Catch:{ all -> 0x0048 }
            boolean r6 = r6.equals(r2)     // Catch:{ all -> 0x0048 }
            if (r6 != 0) goto L_0x00f9
            java.lang.String r6 = r5.getScheme()     // Catch:{ all -> 0x0048 }
            boolean r6 = r6.equals(r1)     // Catch:{ all -> 0x0048 }
            if (r6 == 0) goto L_0x002a
            goto L_0x00f9
        L_0x002a:
            java.lang.String r6 = r5.getScheme()     // Catch:{ all -> 0x0048 }
            boolean r6 = r6.equals(r0)     // Catch:{ all -> 0x0048 }
            r7 = 22
            java.lang.String r8 = "android-app"
            r9 = 1
            if (r6 != 0) goto L_0x004b
            java.lang.String r6 = r5.getScheme()     // Catch:{ all -> 0x0048 }
            boolean r6 = r6.equals(r8)     // Catch:{ all -> 0x0048 }
            if (r6 == 0) goto L_0x00d4
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0048 }
            if (r6 < r7) goto L_0x00d4
            goto L_0x004b
        L_0x0048:
            r11 = move-exception
            goto L_0x00fa
        L_0x004b:
            java.lang.String r6 = r5.getScheme()     // Catch:{ all -> 0x0048 }
            boolean r0 = r6.equals(r0)     // Catch:{ all -> 0x0048 }
            r6 = 0
            if (r0 == 0) goto L_0x005b
            android.content.Intent r0 = android.content.Intent.parseUri(r12, r9)     // Catch:{ all -> 0x0048 }
            goto L_0x0070
        L_0x005b:
            java.lang.String r0 = r5.getScheme()     // Catch:{ all -> 0x0048 }
            boolean r0 = r0.equals(r8)     // Catch:{ all -> 0x0048 }
            if (r0 == 0) goto L_0x006f
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0048 }
            if (r0 < r7) goto L_0x006f
            r0 = 2
            android.content.Intent r0 = android.content.Intent.parseUri(r12, r0)     // Catch:{ all -> 0x0048 }
            goto L_0x0070
        L_0x006f:
            r0 = r6
        L_0x0070:
            if (r0 == 0) goto L_0x0078
            r0.setComponent(r6)     // Catch:{ all -> 0x0048 }
            r0.setSelector(r6)     // Catch:{ all -> 0x0048 }
        L_0x0078:
            java.lang.String r5 = r0.getPackage()     // Catch:{ all -> 0x0098 }
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0098 }
            if (r6 != 0) goto L_0x00a0
            android.content.pm.PackageManager r6 = r10.getPackageManager()     // Catch:{ all -> 0x0098 }
            android.content.Intent r5 = r6.getLaunchIntentForPackage(r5)     // Catch:{ all -> 0x0098 }
            if (r5 == 0) goto L_0x00a0
            r5 = 268435456(0x10000000, float:2.5243549E-29)
            r0.setFlags(r5)     // Catch:{ all -> 0x0098 }
            r10.startActivityForResult(r0, r4)     // Catch:{ all -> 0x0098 }
            r10.finish()     // Catch:{ all -> 0x0098 }
            return r9
        L_0x0098:
            r5 = move-exception
            java.lang.String r5 = r5.getMessage()     // Catch:{ all -> 0x0048 }
            com.mbridge.msdk.foundation.tools.af.b(r3, r5)     // Catch:{ all -> 0x0048 }
        L_0x00a0:
            java.lang.String r5 = "browser_fallback_url"
            java.lang.String r0 = r0.getStringExtra(r5)     // Catch:{ all -> 0x00c7 }
            boolean r5 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x00c7 }
            if (r5 != 0) goto L_0x00d4
            android.net.Uri r5 = android.net.Uri.parse(r12)     // Catch:{ all -> 0x00c7 }
            java.lang.String r6 = r5.getScheme()     // Catch:{ all -> 0x00c7 }
            boolean r6 = r6.equals(r2)     // Catch:{ all -> 0x00c7 }
            if (r6 != 0) goto L_0x00c9
            java.lang.String r5 = r5.getScheme()     // Catch:{ all -> 0x00c7 }
            boolean r5 = r5.equals(r1)     // Catch:{ all -> 0x00c7 }
            if (r5 == 0) goto L_0x00c5
            goto L_0x00c9
        L_0x00c5:
            r12 = r0
            goto L_0x00d4
        L_0x00c7:
            r11 = move-exception
            goto L_0x00cd
        L_0x00c9:
            r11.loadUrl(r0)     // Catch:{ all -> 0x00c7 }
            return r4
        L_0x00cd:
            java.lang.String r11 = r11.getMessage()     // Catch:{ all -> 0x0048 }
            com.mbridge.msdk.foundation.tools.af.b(r3, r11)     // Catch:{ all -> 0x0048 }
        L_0x00d4:
            boolean r11 = com.mbridge.msdk.click.c.e(r10, r12)     // Catch:{ all -> 0x0048 }
            if (r11 == 0) goto L_0x00e3
            java.lang.String r11 = "openDeepLink"
            com.mbridge.msdk.foundation.tools.af.b(r3, r11)     // Catch:{ all -> 0x0048 }
            r10.finish()     // Catch:{ all -> 0x0048 }
            return r9
        L_0x00e3:
            boolean r11 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x0048 }
            if (r11 != 0) goto L_0x00f9
            boolean r11 = r12.startsWith(r2)     // Catch:{ all -> 0x0048 }
            if (r11 != 0) goto L_0x00f5
            boolean r11 = r12.startsWith(r1)     // Catch:{ all -> 0x0048 }
            if (r11 == 0) goto L_0x00f6
        L_0x00f5:
            r4 = 1
        L_0x00f6:
            r11 = r4 ^ 1
            return r11
        L_0x00f9:
            return r4
        L_0x00fa:
            java.lang.String r11 = r11.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r3, r11)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.activity.DomainMBCommonActivity.a(android.webkit.WebView, java.lang.String):boolean");
    }
}
