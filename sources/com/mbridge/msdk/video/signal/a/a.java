package com.mbridge.msdk.video.signal.a;

import android.app.Activity;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.NativeListener;
import com.mbridge.msdk.video.signal.a;
import com.mbridge.msdk.video.signal.d;
import com.mbridge.msdk.videocommon.d.c;
import q1.C2205a;
import q1.C2206b;
import r1.C2216b;

public abstract class a implements d {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f16576a = false;

    /* renamed from: b  reason: collision with root package name */
    protected boolean f16577b = false;

    /* renamed from: c  reason: collision with root package name */
    protected int f16578c = 0;

    /* renamed from: d  reason: collision with root package name */
    protected int f16579d = 0;

    /* renamed from: e  reason: collision with root package name */
    protected int f16580e = 0;

    /* renamed from: f  reason: collision with root package name */
    protected int f16581f = 0;

    /* renamed from: g  reason: collision with root package name */
    protected int f16582g = 0;

    /* renamed from: h  reason: collision with root package name */
    protected int f16583h = 1;

    /* renamed from: i  reason: collision with root package name */
    protected int f16584i = -1;

    /* renamed from: j  reason: collision with root package name */
    protected String f16585j;

    /* renamed from: k  reason: collision with root package name */
    protected c f16586k;

    /* renamed from: l  reason: collision with root package name */
    protected com.mbridge.msdk.click.a f16587l;

    /* renamed from: m  reason: collision with root package name */
    public a.C0206a f16588m = new C0207a();

    /* renamed from: n  reason: collision with root package name */
    protected int f16589n = 2;

    /* renamed from: o  reason: collision with root package name */
    private C2206b f16590o = null;

    /* renamed from: p  reason: collision with root package name */
    private C2216b f16591p = null;

    /* renamed from: q  reason: collision with root package name */
    private C2205a f16592q = null;

    /* renamed from: com.mbridge.msdk.video.signal.a.a$a  reason: collision with other inner class name */
    public static class C0207a implements a.C0206a {
        public void a() {
            af.a("DefaultJSCommon", "onInitSuccess");
        }

        public void b() {
            af.a("DefaultJSCommon", "videoLocationReady");
        }

        public void onDismissLoading(Campaign campaign) {
            af.a("DefaultJSCommon", "onDismissLoading,campaign:" + campaign);
        }

        public void onDownloadFinish(Campaign campaign) {
            af.a("DefaultJSCommon", "onDownloadFinish,campaign:" + campaign);
        }

        public void onDownloadProgress(int i4) {
            af.a("DefaultJSCommon", "onDownloadProgress,progress:" + i4);
        }

        public void onDownloadStart(Campaign campaign) {
            af.a("DefaultJSCommon", "onDownloadStart,campaign:" + campaign);
        }

        public void onFinishRedirection(Campaign campaign, String str) {
            af.a("DefaultJSCommon", "onFinishRedirection,campaign:" + campaign + ",url:" + str);
        }

        public boolean onInterceptDefaultLoadingDialog() {
            af.a("DefaultJSCommon", "onInterceptDefaultLoadingDialog");
            return false;
        }

        public void onRedirectionFailed(Campaign campaign, String str) {
            af.a("DefaultJSCommon", "onFinishRedirection,campaign:" + campaign + ",url:" + str);
        }

        public void onShowLoading(Campaign campaign) {
            af.a("DefaultJSCommon", "onShowLoading,campaign:" + campaign);
        }

        public void onStartRedirection(Campaign campaign, String str) {
            af.a("DefaultJSCommon", "onStartRedirection,campaign:" + campaign + ",url:" + str);
        }

        public void a(boolean z4) {
            af.a("DefaultJSCommon", "onStartInstall");
        }

        public void a(int i4, String str) {
            af.a("DefaultJSCommon", "onH5Error,code:" + i4 + "，msg:" + str);
        }
    }

    public final void a(C2206b bVar) {
        this.f16590o = bVar;
    }

    public final void b(int i4) {
        this.f16579d = i4;
    }

    public final void c(int i4) {
        this.f16578c = i4;
    }

    public void click(int i4, String str) {
        af.a("DefaultJSCommon", "click:type" + i4 + ",pt:" + str);
    }

    public final void d(int i4) {
        this.f16580e = i4;
    }

    public final void e(int i4) {
        this.f16582g = i4;
    }

    public void f() {
    }

    public final int g() {
        return this.f16584i;
    }

    public final void h(int i4) {
        af.a("DefaultJSCommon", "setAlertDialogRole " + i4);
        this.f16583h = i4;
    }

    public void handlerH5Exception(int i4, String str) {
        af.a("DefaultJSCommon", "handlerH5Exception,code=" + i4 + ",msg:" + str);
    }

    public String i() {
        af.a("DefaultJSCommon", "getNotchArea");
        return null;
    }

    public final C2206b j() {
        return this.f16590o;
    }

    public final C2216b k() {
        return this.f16591p;
    }

    public final C2205a l() {
        return this.f16592q;
    }

    public final int m() {
        if (this.f16578c == 0 && this.f16577b) {
            this.f16578c = 1;
        }
        return this.f16578c;
    }

    public final int n() {
        if (this.f16579d == 0 && this.f16577b) {
            this.f16579d = 1;
        }
        return this.f16579d;
    }

    public final int o() {
        if (this.f16580e == 0 && this.f16577b) {
            this.f16580e = 1;
        }
        return this.f16580e;
    }

    public final boolean p() {
        return this.f16577b;
    }

    public static class b implements a.C0206a {

        /* renamed from: a  reason: collision with root package name */
        private d f16593a;

        /* renamed from: b  reason: collision with root package name */
        private a.C0206a f16594b;

        public b(d dVar, a.C0206a aVar) {
            this.f16593a = dVar;
            this.f16594b = aVar;
        }

        public final void a() {
            a.C0206a aVar = this.f16594b;
            if (aVar != null) {
                aVar.a();
            }
        }

        public final void b() {
            a.C0206a aVar = this.f16594b;
            if (aVar != null) {
                aVar.b();
            }
        }

        public final void onDismissLoading(Campaign campaign) {
            a.C0206a aVar = this.f16594b;
            if (aVar != null) {
                aVar.onDismissLoading(campaign);
            }
        }

        public final void onDownloadFinish(Campaign campaign) {
            a.C0206a aVar = this.f16594b;
            if (aVar != null) {
                aVar.onDownloadFinish(campaign);
            }
        }

        public final void onDownloadProgress(int i4) {
            a.C0206a aVar = this.f16594b;
            if (aVar != null) {
                aVar.onDownloadProgress(i4);
            }
        }

        public final void onDownloadStart(Campaign campaign) {
            a.C0206a aVar = this.f16594b;
            if (aVar != null) {
                aVar.onDownloadStart(campaign);
            }
        }

        public final void onFinishRedirection(Campaign campaign, String str) {
            a.C0206a aVar = this.f16594b;
            if (aVar != null) {
                aVar.onFinishRedirection(campaign, str);
            }
            d dVar = this.f16593a;
            if (dVar != null) {
                dVar.d();
            }
        }

        public final boolean onInterceptDefaultLoadingDialog() {
            a.C0206a aVar = this.f16594b;
            if (aVar == null || !aVar.onInterceptDefaultLoadingDialog()) {
                return false;
            }
            return true;
        }

        public final void onRedirectionFailed(Campaign campaign, String str) {
            a.C0206a aVar = this.f16594b;
            if (aVar != null) {
                aVar.onRedirectionFailed(campaign, str);
            }
            d dVar = this.f16593a;
            if (dVar != null) {
                dVar.d();
            }
        }

        public final void onShowLoading(Campaign campaign) {
            a.C0206a aVar = this.f16594b;
            if (aVar != null) {
                aVar.onShowLoading(campaign);
            }
        }

        public final void onStartRedirection(Campaign campaign, String str) {
            a.C0206a aVar = this.f16594b;
            if (aVar != null) {
                aVar.onStartRedirection(campaign, str);
            }
        }

        public final void a(boolean z4) {
            a.C0206a aVar = this.f16594b;
            if (aVar != null) {
                aVar.a(z4);
            }
        }

        public final void a(int i4, String str) {
            a.C0206a aVar = this.f16594b;
            if (aVar != null) {
                aVar.a(i4, str);
            }
        }
    }

    public final void a(C2216b bVar) {
        this.f16591p = bVar;
    }

    public final boolean b() {
        return this.f16576a;
    }

    public String c() {
        af.a("DefaultJSCommon", "init");
        return "{}";
    }

    public void d() {
        af.a("DefaultJSCommon", "finish");
    }

    public final void e() {
        af.a("DefaultJSCommon", "release");
        com.mbridge.msdk.click.a aVar = this.f16587l;
        if (aVar != null) {
            aVar.a(false);
            this.f16587l.a((NativeListener.NativeTrackingListener) null);
            this.f16587l.a();
        }
    }

    public final void f(int i4) {
        this.f16584i = i4;
    }

    public String g(int i4) {
        af.a("DefaultJSCommon", "getSDKInfo");
        return "{}";
    }

    public final void a(C2205a aVar) {
        this.f16592q = aVar;
    }

    public final void b(boolean z4) {
        this.f16576a = z4;
    }

    public final int h() {
        af.a("DefaultJSCommon", "getAlertDialogRole " + this.f16583h);
        return this.f16583h;
    }

    public final void a(int i4) {
        this.f16589n = i4;
    }

    public void b(String str) {
        af.a("DefaultJSCommon", "setNotchArea");
    }

    public final int a() {
        return this.f16582g;
    }

    public final void a(boolean z4) {
        af.a("DefaultJSCommon", "setIsShowingTransparent:" + z4);
        this.f16577b = z4;
    }

    public final void a(String str) {
        af.a("DefaultJSCommon", "setUnitId:" + str);
        this.f16585j = str;
    }

    public final void a(a.C0206a aVar) {
        af.a("DefaultJSCommon", "setTrackingListener:" + aVar);
        this.f16588m = aVar;
    }

    public final void a(c cVar) {
        af.a("DefaultJSCommon", "setSetting:" + cVar);
        this.f16586k = cVar;
    }

    public void a(int i4, String str) {
        af.a("DefaultJSCommon", "statistics,type:" + i4 + ",json:" + str);
    }

    public void a(Activity activity) {
        af.a("DefaultJSCommon", "setActivity ");
    }
}
