package com.mbridge.msdk.foundation.controller;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.foundation.controller.authoritycontroller.b;
import com.mbridge.msdk.foundation.controller.authoritycontroller.c;
import com.mbridge.msdk.foundation.same.report.i;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.an;
import com.mbridge.msdk.foundation.tools.f;
import com.mbridge.msdk.foundation.tools.h;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f12766a = c.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public static HashMap<String, String> f12767b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    protected String f12768c;

    /* renamed from: d  reason: collision with root package name */
    protected Context f12769d;

    /* renamed from: e  reason: collision with root package name */
    protected String f12770e;

    /* renamed from: f  reason: collision with root package name */
    private final h f12771f = new h();

    /* renamed from: g  reason: collision with root package name */
    private WeakReference<Activity> f12772g;

    /* renamed from: h  reason: collision with root package name */
    private String f12773h;

    /* renamed from: i  reason: collision with root package name */
    private int f12774i;

    /* renamed from: j  reason: collision with root package name */
    private JSONObject f12775j = new JSONObject();

    /* renamed from: k  reason: collision with root package name */
    private boolean f12776k = false;

    /* renamed from: l  reason: collision with root package name */
    private String f12777l;

    /* renamed from: m  reason: collision with root package name */
    private String f12778m;

    /* renamed from: n  reason: collision with root package name */
    private int f12779n;

    /* renamed from: o  reason: collision with root package name */
    private ConcurrentHashMap<String, String> f12780o = new ConcurrentHashMap<>();

    /* renamed from: p  reason: collision with root package name */
    private WeakReference<Context> f12781p;

    /* renamed from: q  reason: collision with root package name */
    private JSONObject f12782q;

    /* renamed from: r  reason: collision with root package name */
    private int f12783r = 0;

    /* renamed from: s  reason: collision with root package name */
    private String f12784s;

    /* renamed from: com.mbridge.msdk.foundation.controller.a$a  reason: collision with other inner class name */
    public interface C0179a {
    }

    public final WeakReference<Activity> a() {
        return this.f12772g;
    }

    /* access modifiers changed from: protected */
    public abstract void a(C0179a aVar);

    public final String b() {
        if (!TextUtils.isEmpty(this.f12777l)) {
            return this.f12777l;
        }
        Context context = this.f12769d;
        if (context != null) {
            return (String) an.a(context, "sp_appKey", "");
        }
        return null;
    }

    public final Context c() {
        return this.f12769d;
    }

    public final h d() {
        return this.f12771f;
    }

    public final Context e() {
        WeakReference<Context> weakReference = this.f12781p;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public final int f() {
        return this.f12774i;
    }

    public final String g() {
        try {
            if (!TextUtils.isEmpty(this.f12770e)) {
                return this.f12770e;
            }
            Context context = this.f12769d;
            if (context == null) {
                return null;
            }
            String packageName = context.getPackageName();
            this.f12770e = packageName;
            return packageName;
        } catch (Exception e5) {
            e5.printStackTrace();
            return null;
        }
    }

    public final String h() {
        if (!TextUtils.isEmpty(this.f12778m)) {
            return this.f12778m;
        }
        Context context = this.f12769d;
        if (context != null) {
            return (String) an.a(context, "sp_wx_appKey", "");
        }
        return null;
    }

    public final JSONObject i() {
        return this.f12782q;
    }

    public final int j() {
        return this.f12783r;
    }

    public final String k() {
        try {
            if (!TextUtils.isEmpty(this.f12768c)) {
                return this.f12768c;
            }
            Context context = this.f12769d;
            if (context != null) {
                return (String) an.a(context, "sp_appId", "");
            }
            return "";
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final String l() {
        if (!TextUtils.isEmpty(this.f12784s)) {
            return this.f12784s;
        }
        try {
            String md5 = SameMD5.getMD5(c.m().k() + c.m().b());
            this.f12784s = md5;
            return md5;
        } catch (Exception unused) {
            return "";
        }
    }

    public final void a(WeakReference<Activity> weakReference) {
        this.f12772g = weakReference;
    }

    public final void c(int i4) {
        this.f12783r = i4;
    }

    public final void d(String str) {
        Context context;
        try {
            this.f12768c = str;
            if (!TextUtils.isEmpty(str) && (context = this.f12769d) != null) {
                an.b(context, "sp_appId", str);
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final void e(String str) {
        Context context;
        try {
            this.f12777l = str;
            if (!TextUtils.isEmpty(str) && (context = this.f12769d) != null) {
                an.b(context, "sp_appKey", str);
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final void f(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f12770e = str;
        }
    }

    public final void a(Context context) {
        if (context instanceof Activity) {
            this.f12781p = new WeakReference<>(context);
        }
    }

    public final void c(String str) {
        Context context;
        try {
            this.f12773h = str;
            if (!TextUtils.isEmpty(str) && (context = this.f12769d) != null) {
                an.b(context, "applicationIds", str);
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final void a(int i4) {
        this.f12774i = i4;
    }

    public final void b(int i4) {
        this.f12779n = i4;
    }

    public final void a(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.f12778m = str;
                Context context = this.f12769d;
                if (context != null) {
                    an.b(context, "sp_wx_appKey", str);
                }
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final void b(String str) {
        try {
            if (this.f12780o != null && !TextUtils.isEmpty(str)) {
                if (this.f12780o.containsKey(str)) {
                    this.f12780o.remove(str);
                }
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final void b(Context context) {
        this.f12769d = context;
    }

    public final BitmapDrawable a(String str, int i4) {
        ConcurrentHashMap<String, String> concurrentHashMap;
        if (TextUtils.isEmpty(str) || (concurrentHashMap = this.f12780o) == null || !concurrentHashMap.containsKey(str) || !ah.a().a("w_m_r_l", true)) {
            return null;
        }
        String str2 = this.f12780o.get(str);
        BitmapDrawable n4 = ak.n(str2);
        i.a(str, i4, TextUtils.isEmpty(str2) ? 2 : 1, TextUtils.isEmpty(str2) ? "get watermark failed" : n4 != null ? "" : "str to bitmap failed", n4 == null ? 2 : 1, str2);
        return n4;
    }

    public final void a(JSONObject jSONObject) {
        this.f12782q = jSONObject;
    }

    public final void a(final C0179a aVar, final Handler handler) {
        if (!this.f12776k) {
            try {
                if (b.a() && c.j().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                    Object a5 = an.a(this.f12769d, MBridgeConstans.SP_GA_ID, "");
                    Object a6 = an.a(this.f12769d, MBridgeConstans.SP_GA_ID_LIMIT, 0);
                    if (a5 instanceof String) {
                        String str = (String) a5;
                        if (!TextUtils.isEmpty(str)) {
                            f.a(str);
                        } else {
                            f.c();
                        }
                        if (a6 instanceof Integer) {
                            f.a(((Integer) a6).intValue());
                        }
                    }
                }
            } catch (Exception e5) {
                af.b(f12766a, e5.getMessage());
            }
            try {
                JSONObject jSONObject = new JSONObject();
                this.f12782q = jSONObject;
                jSONObject.put("webgl", 0);
            } catch (JSONException e6) {
                af.b(f12766a, e6.getMessage());
            }
            new Thread(new Runnable() {
                public final void run() {
                    int i4;
                    try {
                        ab.p(a.this.f12769d);
                        a.this.a(aVar);
                        a aVar = a.this;
                        com.mbridge.msdk.c.h.a(aVar.f12769d, aVar.f12768c);
                    } catch (Exception e5) {
                        af.b(a.f12766a, e5.getMessage());
                    }
                    if (c.j().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                        try {
                            if (a.this.f12769d.getPackageManager().getApplicationInfo("com.android.vending", 0).enabled) {
                                i4 = 1;
                            } else {
                                i4 = 2;
                            }
                            ab.c(i4);
                        } catch (PackageManager.NameNotFoundException unused) {
                            ab.c(0);
                        } catch (Throwable th) {
                            af.b(a.f12766a, th.getMessage());
                        }
                    }
                    try {
                        g b5 = com.mbridge.msdk.c.h.a().b(c.m().k());
                        if (b5 == null) {
                            com.mbridge.msdk.c.h.a();
                            b5 = com.mbridge.msdk.c.i.a();
                        }
                        Message obtain = Message.obtain();
                        obtain.obj = b5;
                        obtain.what = 9;
                        handler.sendMessage(obtain);
                    } catch (Exception e6) {
                        af.b(a.f12766a, e6.getMessage());
                    }
                }
            }).start();
        }
    }

    public final void a(String str, JSONObject jSONObject) {
        if (ah.a().a("w_m_r_l", true)) {
            try {
                if (this.f12775j == null) {
                    this.f12775j = jSONObject;
                } else if (jSONObject != null) {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        this.f12775j.put(next, jSONObject.get(next));
                    }
                }
                if (this.f12775j.has(MBridgeConstans.EXTRA_KEY_WM)) {
                    if (this.f12780o == null) {
                        this.f12780o = new ConcurrentHashMap<>();
                    }
                    this.f12780o.put(str, this.f12775j.getString(MBridgeConstans.EXTRA_KEY_WM));
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }
}
