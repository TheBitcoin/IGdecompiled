package com.mbridge.msdk.foundation.webview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import com.mbridge.msdk.activity.MBCommonActivity;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.i;
import com.mbridge.msdk.click.entity.JumpLoaderResult;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.aj;
import com.mbridge.msdk.foundation.webview.BrowserView;
import com.mbridge.msdk.out.BaseTrackingListener;
import com.mbridge.msdk.out.NativeListener;
import java.util.ArrayList;
import java.util.List;

public class a implements BrowserView.a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static String f13742a = "a";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int f13743b = 10000;

    /* renamed from: c  reason: collision with root package name */
    private boolean f13744c = true;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f13745d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f13746e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public BaseTrackingListener f13747f;

    /* renamed from: g  reason: collision with root package name */
    private BrowserView f13748g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public CampaignEx f13749h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public com.mbridge.msdk.click.a f13750i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public Context f13751j;

    /* renamed from: k  reason: collision with root package name */
    private Handler f13752k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public JumpLoaderResult f13753l = null;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public boolean f13754m = false;

    /* renamed from: n  reason: collision with root package name */
    private final Runnable f13755n = new Runnable() {
        public final void run() {
            String b5 = a.f13742a;
            af.b(b5, "webview js！超时上限：" + a.this.f13743b + "ms");
            if (!(a.this.f13750i == null || a.this.f13753l == null)) {
                a.this.f13753l.setSuccess(false);
                a.this.f13753l.setUrl(a.this.f13745d);
                a.this.f13753l.setType(2);
                a.this.f13753l.setExceptionMsg("linktype 8 time out");
                a.this.f13750i.a(a.this.f13753l, a.this.f13749h, 1, false);
            }
            a aVar = a.this;
            if (aVar.d((WebView) null, aVar.f13745d) && !a.this.f13754m) {
                boolean unused = a.this.f13754m = true;
                a aVar2 = a.this;
                aVar2.a(aVar2.f13751j, a.this.f13745d, a.this.f13749h);
            }
            if (a.this.f13747f != null) {
                a.this.f13747f.onFinishRedirection(a.this.f13749h, a.this.f13745d);
            }
        }
    };

    /* renamed from: o  reason: collision with root package name */
    private long f13756o;

    public a(Context context, CampaignEx campaignEx, com.mbridge.msdk.click.a aVar, BrowserView browserView, BaseTrackingListener baseTrackingListener) {
        this.f13751j = context;
        this.f13749h = campaignEx;
        this.f13748g = browserView;
        this.f13747f = baseTrackingListener;
        this.f13752k = new Handler(Looper.getMainLooper());
        g b5 = h.a().b(c.m().k());
        if (b5 == null) {
            h.a();
            b5 = i.a();
        }
        this.f13750i = aVar;
        this.f13753l = new JumpLoaderResult();
        this.f13743b = (int) b5.ar();
    }

    public final void a() {
    }

    /* access modifiers changed from: private */
    public boolean d(WebView webView, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            Uri parse = Uri.parse(str);
            if (!parse.getScheme().equals("http")) {
                if (!parse.getScheme().equals("https")) {
                    if (parse.getScheme().equals("intent")) {
                        Intent parseUri = Intent.parseUri(str, 1);
                        String str2 = parseUri.getPackage();
                        if (!TextUtils.isEmpty(str2) && this.f13751j.getPackageManager().getLaunchIntentForPackage(str2) != null) {
                            return false;
                        }
                        try {
                            String stringExtra = parseUri.getStringExtra("browser_fallback_url");
                            if (!TextUtils.isEmpty(stringExtra)) {
                                Uri parse2 = Uri.parse(str);
                                if (parse2.getScheme().equals("http") || parse2.getScheme().equals("https")) {
                                    return true;
                                }
                                str = stringExtra;
                            }
                        } catch (Throwable th) {
                            af.b(f13742a, th.getMessage());
                        }
                    }
                    if (com.mbridge.msdk.click.c.e(this.f13751j, str)) {
                        af.b(f13742a, "openDeepLink");
                        return false;
                    }
                }
            }
            return true;
        } catch (Throwable th2) {
            af.b(f13742a, th2.getMessage());
            return true;
        }
    }

    private boolean e(WebView webView, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Uri parse = Uri.parse(str);
            if (!parse.getScheme().equals("http")) {
                if (!parse.getScheme().equals("https")) {
                    if (parse.getScheme().equals("intent")) {
                        Intent parseUri = Intent.parseUri(str, 1);
                        String str2 = parseUri.getPackage();
                        if (!TextUtils.isEmpty(str2) && this.f13751j.getPackageManager().getLaunchIntentForPackage(str2) != null) {
                            parseUri.setFlags(268435456);
                            this.f13751j.startActivity(parseUri);
                            this.f13754m = true;
                            return true;
                        }
                        try {
                            String stringExtra = parseUri.getStringExtra("browser_fallback_url");
                            if (!TextUtils.isEmpty(stringExtra)) {
                                Uri parse2 = Uri.parse(str);
                                if (!parse2.getScheme().equals("http")) {
                                    if (!parse2.getScheme().equals("https")) {
                                        str = stringExtra;
                                    }
                                }
                                webView.loadUrl(stringExtra);
                                return false;
                            }
                        } catch (Throwable th) {
                            af.b(f13742a, th.getMessage());
                        }
                    }
                    if (com.mbridge.msdk.click.c.e(this.f13751j, str)) {
                        af.b(f13742a, "openDeepLink");
                        this.f13754m = true;
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable th2) {
            af.b(f13742a, th2.getMessage());
            return false;
        }
    }

    public final void c(WebView webView, final String str) {
        String str2 = f13742a;
        af.b(str2, "onPageFinished1  " + str);
        if (this.f13744c) {
            this.f13756o = 0;
            this.f13744c = false;
            com.mbridge.msdk.foundation.same.f.a.e().execute(new Runnable() {
                public final void run() {
                    if (a.this.f13747f != null) {
                        a.this.f13747f.onFinishRedirection(a.this.f13749h, str);
                    }
                    if (a.this.f13750i != null && a.this.f13753l != null) {
                        a.this.f13753l.setSuccess(true);
                        a.this.f13753l.setUrl(str);
                        a.this.f13753l.setType(2);
                        a.this.f13750i.a(a.this.f13753l, a.this.f13749h, 1, true);
                    }
                }
            });
            if (!TextUtils.isEmpty(str)) {
                c();
                Uri parse = Uri.parse(str);
                if ((parse.getScheme().equals("http") || parse.getScheme().equals("https")) && !this.f13754m) {
                    this.f13754m = true;
                    a(this.f13751j, str, this.f13749h);
                }
            }
        }
    }

    public final boolean b(WebView webView, final String str) {
        String str2 = f13742a;
        af.b(str2, "shouldOverrideUrlLoading1  " + str);
        this.f13744c = false;
        if (aj.a.b(str) && aj.a.a(this.f13751j, str, (NativeListener.NativeTrackingListener) null)) {
            this.f13754m = true;
        }
        boolean e5 = e(webView, str);
        if (e5) {
            this.f13756o = 0;
            this.f13744c = false;
            c();
            com.mbridge.msdk.foundation.same.f.a.e().execute(new Runnable() {
                public final void run() {
                    if (!(a.this.f13750i == null || a.this.f13753l == null)) {
                        a.this.f13753l.setSuccess(true);
                        a.this.f13753l.setUrl(str);
                        a.this.f13753l.setType(2);
                        a.this.f13750i.a(a.this.f13753l, a.this.f13749h, 1, true);
                    }
                    if (a.this.f13747f != null) {
                        a.this.f13747f.onFinishRedirection(a.this.f13749h, str);
                    }
                }
            });
        }
        return e5;
    }

    public final void a(WebView webView, String str) {
        if (this.f13756o == 0) {
            this.f13756o = System.currentTimeMillis();
            if (!this.f13746e) {
                this.f13746e = true;
                d();
            }
        }
        this.f13745d = str;
        this.f13744c = true;
    }

    public final void a(WebView webView, String str, Bitmap bitmap) {
        if (this.f13756o == 0) {
            this.f13756o = System.currentTimeMillis();
            if (!this.f13746e) {
                this.f13746e = true;
                d();
            }
            this.f13754m = false;
        }
        this.f13745d = str;
        this.f13744c = true;
    }

    private void c() {
        this.f13752k.removeCallbacks(this.f13755n);
    }

    private void d() {
        this.f13752k.postDelayed(this.f13755n, (long) this.f13743b);
    }

    public final void a(WebView webView, int i4, final String str, final String str2) {
        af.d(f13742a, str);
        c();
        com.mbridge.msdk.foundation.same.f.a.e().execute(new Runnable() {
            public final void run() {
                if (a.this.f13747f != null) {
                    a.this.f13747f.onFinishRedirection(a.this.f13749h, str2);
                }
                if (a.this.f13750i != null && a.this.f13753l != null) {
                    a.this.f13753l.setSuccess(false);
                    a.this.f13753l.setUrl(str2);
                    a.this.f13753l.setType(2);
                    a.this.f13753l.setExceptionMsg(str);
                    a.this.f13750i.a(a.this.f13753l, a.this.f13749h, 1, true);
                }
            }
        });
        if (d(webView, str2) && !this.f13754m) {
            this.f13754m = true;
            a(this.f13751j, str2, this.f13749h);
        }
    }

    /* access modifiers changed from: private */
    public void a(Context context, String str, CampaignEx campaignEx) {
        if (context != null) {
            if (campaignEx != null) {
                campaignEx.getCurrentLocalRid();
            }
            try {
                int i4 = MBCommonActivity.f11808d;
                Intent intent = new Intent(context, MBCommonActivity.class);
                if (!TextUtils.isEmpty(str)) {
                    b.f13765a.put(str, this.f13748g);
                    if (aj.a.a(str)) {
                        str = "https://play.google.com/store/apps/details?id=" + str.replace("market://details?id=", "");
                    }
                    intent.putExtra("url", str);
                    af.c("url", "webview url = " + str);
                    intent.setFlags(805306368);
                    intent.putExtra("mvcommon", campaignEx);
                    context.startActivity(intent);
                }
            } catch (Exception unused) {
                aj.a(context, str, this.f13747f, campaignEx, (List<String>) new ArrayList());
            }
        }
    }
}
