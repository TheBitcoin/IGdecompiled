package com.mbridge.msdk.foundation.controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.MBridgeSDK;
import com.mbridge.msdk.b.a;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.j;
import com.mbridge.msdk.d.b;
import com.mbridge.msdk.foundation.controller.a;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.l;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.same.report.b.c;
import com.mbridge.msdk.foundation.same.report.h;
import com.mbridge.msdk.foundation.same.report.i;
import com.mbridge.msdk.foundation.tools.FastKV;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.f;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.out.MBridgeSDKFactory;
import java.util.List;
import java.util.Map;

public class d {

    /* renamed from: c  reason: collision with root package name */
    private static volatile d f12803c;

    /* renamed from: a  reason: collision with root package name */
    public final int f12804a = 2;

    /* renamed from: b  reason: collision with root package name */
    Handler f12805b = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            List list;
            List list2;
            try {
                int i4 = message.what;
                if (i4 == 2) {
                    Object obj = message.obj;
                    if ((obj instanceof List) && (list = (List) obj) != null && list.size() > 0) {
                        h hVar = new h(d.this.f12813k, 0);
                        for (int i5 = 0; i5 < list.size(); i5++) {
                            l lVar = (l) list.get(i5);
                            Boolean bool = Boolean.FALSE;
                            if (i5 == list.size() - 1) {
                                bool = Boolean.TRUE;
                            }
                            hVar.a(lVar, bool);
                        }
                    }
                } else if (i4 == 7) {
                    Object obj2 = message.obj;
                    if (obj2 != null && (obj2 instanceof List) && (list2 = (List) obj2) != null) {
                        list2.size();
                    }
                } else if (i4 == 9) {
                    g gVar = (g) message.obj;
                    com.mbridge.msdk.foundation.tools.h d5 = c.m().d();
                    if (d5 != null && d5.b() && gVar != null && gVar.L() == 1) {
                        com.mbridge.msdk.foundation.same.report.b.d.a(d.this.f12813k).b();
                    }
                    if (d5 != null && d5.a()) {
                        c.a();
                    }
                }
            } catch (Exception unused) {
                af.b("SDKController", "REPORT HANDLE ERROR!");
            }
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private int f12806d;

    /* renamed from: e  reason: collision with root package name */
    private Map<String, Object> f12807e;

    /* renamed from: f  reason: collision with root package name */
    private FastKV f12808f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f12809g = false;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public String f12810h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public String f12811i;

    /* renamed from: j  reason: collision with root package name */
    private String f12812j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public Context f12813k;

    /* renamed from: l  reason: collision with root package name */
    private String f12814l;

    /* renamed from: m  reason: collision with root package name */
    private a f12815m;

    /* renamed from: n  reason: collision with root package name */
    private String f12816n;

    private d() {
    }

    public static d a() {
        if (f12803c == null) {
            synchronized (d.class) {
                try {
                    if (f12803c == null) {
                        f12803c = new d();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f12803c;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0047 A[Catch:{ Exception -> 0x003c }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b() {
        /*
            r3 = this;
            android.content.Context r0 = r3.f12813k
            if (r0 == 0) goto L_0x0063
            android.os.Handler r0 = r3.f12805b
            if (r0 != 0) goto L_0x0009
            goto L_0x0063
        L_0x0009:
            com.mbridge.msdk.foundation.tools.ah r0 = com.mbridge.msdk.foundation.tools.ah.a()     // Catch:{ Exception -> 0x003c }
            java.lang.String r1 = "e_r_r_c_t_r_l"
            r2 = 0
            boolean r0 = r0.a((java.lang.String) r1, (boolean) r2)     // Catch:{ Exception -> 0x003c }
            if (r0 == 0) goto L_0x0018
            r0 = 5
            goto L_0x0019
        L_0x0018:
            r0 = 1
        L_0x0019:
            com.mbridge.msdk.foundation.same.report.c.a.a()     // Catch:{ Exception -> 0x003c }
            android.content.Context r1 = r3.f12813k     // Catch:{ Exception -> 0x003c }
            if (r1 != 0) goto L_0x0021
            goto L_0x003e
        L_0x0021:
            com.mbridge.msdk.foundation.db.g r2 = com.mbridge.msdk.foundation.db.g.a((android.content.Context) r1)     // Catch:{ Exception -> 0x003c }
            com.mbridge.msdk.foundation.db.l r2 = com.mbridge.msdk.foundation.db.l.a((com.mbridge.msdk.foundation.db.f) r2)     // Catch:{ Exception -> 0x003c }
            int r2 = r2.a()     // Catch:{ Exception -> 0x003c }
            if (r2 <= 0) goto L_0x003e
            com.mbridge.msdk.foundation.db.g r1 = com.mbridge.msdk.foundation.db.g.a((android.content.Context) r1)     // Catch:{ Exception -> 0x003c }
            com.mbridge.msdk.foundation.db.l r1 = com.mbridge.msdk.foundation.db.l.a((com.mbridge.msdk.foundation.db.f) r1)     // Catch:{ Exception -> 0x003c }
            java.util.List r0 = r1.a((int) r0)     // Catch:{ Exception -> 0x003c }
            goto L_0x003f
        L_0x003c:
            goto L_0x0058
        L_0x003e:
            r0 = 0
        L_0x003f:
            if (r0 == 0) goto L_0x0063
            int r1 = r0.size()     // Catch:{ Exception -> 0x003c }
            if (r1 <= 0) goto L_0x0063
            android.os.Handler r1 = r3.f12805b     // Catch:{ Exception -> 0x003c }
            android.os.Message r1 = r1.obtainMessage()     // Catch:{ Exception -> 0x003c }
            r2 = 2
            r1.what = r2     // Catch:{ Exception -> 0x003c }
            r1.obj = r0     // Catch:{ Exception -> 0x003c }
            android.os.Handler r0 = r3.f12805b     // Catch:{ Exception -> 0x003c }
            r0.sendMessage(r1)     // Catch:{ Exception -> 0x003c }
            return
        L_0x0058:
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r0 == 0) goto L_0x0063
            java.lang.String r0 = "SDKController"
            java.lang.String r1 = "report netstate error !"
            com.mbridge.msdk.foundation.tools.af.b(r0, r1)
        L_0x0063:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.controller.d.b():void");
    }

    public final void c() {
        Handler handler = this.f12805b;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
    }

    public final void a(Map map, final Context context) {
        String str;
        Object obj;
        if (context != null) {
            if (!TextUtils.isEmpty(MBridgeConstans.DEVELOPER_CUSTOM_PACKAGE)) {
                c.m().f(MBridgeConstans.DEVELOPER_CUSTOM_PACKAGE);
            } else if (map.containsKey(MBridgeConstans.KEY_MBRIDGE_CUSTOM_PACKAGE_NAME) && (obj = map.get(MBridgeConstans.KEY_MBRIDGE_CUSTOM_PACKAGE_NAME)) != null) {
                String str2 = (String) obj;
                if (!TextUtils.isEmpty(str2)) {
                    c.m().f(str2);
                }
            }
            if (map != null) {
                if (map.containsKey(MBridgeConstans.ID_MBRIDGE_APPID)) {
                    this.f12810h = (String) map.get(MBridgeConstans.ID_MBRIDGE_APPID);
                }
                if (map.containsKey(MBridgeConstans.ID_MBRIDGE_APPKEY)) {
                    this.f12811i = (String) map.get(MBridgeConstans.ID_MBRIDGE_APPKEY);
                }
                if (map.containsKey(MBridgeConstans.ID_MBRIDGE_WX_APPID)) {
                    this.f12816n = (String) map.get(MBridgeConstans.ID_MBRIDGE_WX_APPID);
                }
                if (map.containsKey(MBridgeConstans.PACKAGE_NAME_MANIFEST)) {
                    this.f12812j = (String) map.get(MBridgeConstans.PACKAGE_NAME_MANIFEST);
                }
                if (map.containsKey(MBridgeConstans.ID_MBRIDGE_STARTUPCRASH)) {
                    this.f12814l = (String) map.get(MBridgeConstans.ID_MBRIDGE_STARTUPCRASH);
                }
            }
            this.f12813k = context.getApplicationContext();
            c.m().b(this.f12813k);
            c.m().d(this.f12810h);
            c.m().e(this.f12811i);
            c.m().a(this.f12816n);
            c.m().c(this.f12812j);
            c.m().a((a.C0179a) new a.C0179a() {
            }, this.f12805b);
            try {
                com.mbridge.msdk.foundation.same.net.e.d.f().e();
            } catch (Throwable th) {
                af.b("SDKController", th.getMessage());
            }
            if (!this.f12809g) {
                ai.a(this.f12813k);
                Context applicationContext = this.f12813k.getApplicationContext();
                try {
                    if (this.f12808f == null) {
                        this.f12808f = new FastKV.Builder(e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG), z.a("H+tU+FeXHM==")).build();
                    }
                } catch (Exception unused) {
                    this.f12808f = null;
                } catch (Throwable th2) {
                    af.b("SDKController", th2.getMessage(), th2);
                }
                FastKV fastKV = this.f12808f;
                String str3 = "";
                if (fastKV != null) {
                    String string = fastKV.getString(z.a("H+tU+bfPhM=="), str3);
                    String string2 = this.f12808f.getString(z.a("H+tU+Fz8"), str3);
                    if (TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f13124V) && TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f13133g)) {
                        com.mbridge.msdk.foundation.same.a.f13124V = com.mbridge.msdk.foundation.a.a.a.a().a(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B);
                        com.mbridge.msdk.foundation.same.a.f13133g = com.mbridge.msdk.foundation.a.a.a.a().a("c");
                    }
                    if (!TextUtils.isEmpty(string) || !TextUtils.isEmpty(string2)) {
                        com.mbridge.msdk.foundation.same.a.f13124V = string;
                        com.mbridge.msdk.foundation.same.a.f13133g = string2;
                        com.mbridge.msdk.foundation.a.a.a.a().a(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, com.mbridge.msdk.foundation.same.a.f13124V);
                        com.mbridge.msdk.foundation.a.a.a.a().a("c", com.mbridge.msdk.foundation.same.a.f13133g);
                    } else if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f13124V) || !TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f13133g)) {
                        this.f12808f.putString(z.a("H+tU+bfPhM=="), com.mbridge.msdk.foundation.same.a.f13124V);
                        this.f12808f.putString(z.a("H+tU+Fz8"), com.mbridge.msdk.foundation.same.a.f13133g);
                    }
                } else {
                    SharedPreferences sharedPreferences = applicationContext.getSharedPreferences(z.a("H+tU+FeXHM=="), 0);
                    if (sharedPreferences != null) {
                        String string3 = sharedPreferences.getString(z.a("H+tU+bfPhM=="), str3);
                        String string4 = sharedPreferences.getString(z.a("H+tU+Fz8"), str3);
                        str3 = string3;
                        str = string4;
                    } else {
                        str = str3;
                    }
                    if (TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f13124V) && TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f13133g)) {
                        com.mbridge.msdk.foundation.same.a.f13124V = com.mbridge.msdk.foundation.a.a.a.a().a(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B);
                        com.mbridge.msdk.foundation.same.a.f13133g = com.mbridge.msdk.foundation.a.a.a.a().a("c");
                    }
                    if (!TextUtils.isEmpty(str3) || !TextUtils.isEmpty(str)) {
                        com.mbridge.msdk.foundation.same.a.f13124V = str3;
                        com.mbridge.msdk.foundation.same.a.f13133g = str;
                        com.mbridge.msdk.foundation.a.a.a.a().a(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, com.mbridge.msdk.foundation.same.a.f13124V);
                        com.mbridge.msdk.foundation.a.a.a.a().a("c", com.mbridge.msdk.foundation.same.a.f13133g);
                    } else if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f13124V) || !TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f13133g)) {
                        if (sharedPreferences != null) {
                            SharedPreferences.Editor edit = sharedPreferences.edit();
                            edit.putString(z.a("H+tU+bfPhM=="), com.mbridge.msdk.foundation.same.a.f13124V);
                            edit.putString(z.a("H+tU+Fz8"), com.mbridge.msdk.foundation.same.a.f13133g);
                            edit.apply();
                        }
                    }
                }
                try {
                    com.mbridge.msdk.foundation.same.f.a.b().execute(new Runnable() {
                        public final void run() {
                            Looper.prepare();
                            d.a(d.this);
                            d.b(d.this);
                            Looper.loop();
                        }
                    });
                    com.mbridge.msdk.foundation.same.f.a.b().execute(new Runnable() {
                        public final void run() {
                            d dVar = d.this;
                            d.a(dVar, dVar.f12810h);
                            if (!TextUtils.isEmpty(d.this.f12810h)) {
                                com.mbridge.msdk.foundation.a.a.a.a().a(MBridgeConstans.SDK_APP_ID, d.this.f12810h);
                            }
                            new h(d.this.f12813k).a();
                            d.this.b();
                        }
                    });
                    i.c();
                } catch (Exception unused2) {
                    af.b("SDKController", "get app setting failed");
                }
                this.f12809g = true;
                ab.g(context);
                long aA = (long) com.mbridge.msdk.c.h.a().a(this.f12810h).aA();
                if (aA != 1300) {
                    this.f12805b.postDelayed(new Runnable() {
                        public final void run() {
                            ab.e(context);
                        }
                    }, aA);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0070, code lost:
        r5 = com.mbridge.msdk.out.MBRewardVideoHandler.class;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void b(com.mbridge.msdk.foundation.controller.d r11) {
        /*
            r0 = 1
            r1 = 0
            r2 = 2
            com.mbridge.msdk.c.h r3 = com.mbridge.msdk.c.h.a()     // Catch:{ all -> 0x0094 }
            com.mbridge.msdk.foundation.controller.c r4 = com.mbridge.msdk.foundation.controller.c.m()     // Catch:{ all -> 0x0094 }
            java.lang.String r4 = r4.k()     // Catch:{ all -> 0x0094 }
            com.mbridge.msdk.c.g r3 = r3.b(r4)     // Catch:{ all -> 0x0094 }
            if (r3 == 0) goto L_0x009c
            java.util.List r3 = r3.n()     // Catch:{ all -> 0x0094 }
            if (r3 == 0) goto L_0x009c
            int r4 = r3.size()     // Catch:{ all -> 0x0094 }
            if (r4 <= 0) goto L_0x009c
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0094 }
        L_0x0025:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x0094 }
            if (r4 == 0) goto L_0x009c
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x0094 }
            com.mbridge.msdk.foundation.entity.a r4 = (com.mbridge.msdk.foundation.entity.a) r4     // Catch:{ all -> 0x0094 }
            int r5 = r4.a()     // Catch:{ all -> 0x0094 }
            r6 = 287(0x11f, float:4.02E-43)
            java.lang.String r7 = "loadFormSelfFilling"
            java.lang.String r8 = ""
            r9 = 0
            java.lang.Class<java.lang.String> r10 = java.lang.String.class
            if (r5 != r6) goto L_0x0068
            java.lang.Class<com.mbridge.msdk.interstitialvideo.out.MBInterstitialVideoHandler> r5 = com.mbridge.msdk.interstitialvideo.out.MBInterstitialVideoHandler.class
            android.content.Context r6 = r11.f12813k     // Catch:{ all -> 0x0094 }
            if (r6 == 0) goto L_0x0025
            java.lang.Class[] r6 = new java.lang.Class[r2]     // Catch:{ all -> 0x0094 }
            r6[r1] = r10     // Catch:{ all -> 0x0094 }
            r6[r0] = r10     // Catch:{ all -> 0x0094 }
            java.lang.reflect.Constructor r6 = r5.getConstructor(r6)     // Catch:{ all -> 0x0094 }
            java.lang.String r4 = r4.b()     // Catch:{ all -> 0x0094 }
            java.lang.Object[] r10 = new java.lang.Object[r2]     // Catch:{ all -> 0x0094 }
            r10[r1] = r8     // Catch:{ all -> 0x0094 }
            r10[r0] = r4     // Catch:{ all -> 0x0094 }
            java.lang.Object r4 = r6.newInstance(r10)     // Catch:{ all -> 0x0094 }
            if (r4 == 0) goto L_0x0025
            java.lang.reflect.Method r5 = r5.getMethod(r7, r9)     // Catch:{ all -> 0x0094 }
            r5.invoke(r4, r9)     // Catch:{ all -> 0x0094 }
            goto L_0x0025
        L_0x0068:
            int r5 = r4.a()     // Catch:{ all -> 0x0094 }
            r6 = 94
            if (r5 != r6) goto L_0x0025
            java.lang.Class<com.mbridge.msdk.out.MBRewardVideoHandler> r5 = com.mbridge.msdk.out.MBRewardVideoHandler.class
            java.lang.Class[] r6 = new java.lang.Class[r2]     // Catch:{ all -> 0x0094 }
            r6[r1] = r10     // Catch:{ all -> 0x0094 }
            r6[r0] = r10     // Catch:{ all -> 0x0094 }
            java.lang.reflect.Constructor r6 = r5.getConstructor(r6)     // Catch:{ all -> 0x0094 }
            java.lang.String r4 = r4.b()     // Catch:{ all -> 0x0094 }
            java.lang.Object[] r10 = new java.lang.Object[r2]     // Catch:{ all -> 0x0094 }
            r10[r1] = r8     // Catch:{ all -> 0x0094 }
            r10[r0] = r4     // Catch:{ all -> 0x0094 }
            java.lang.Object r4 = r6.newInstance(r10)     // Catch:{ all -> 0x0094 }
            if (r4 == 0) goto L_0x0025
            java.lang.reflect.Method r5 = r5.getMethod(r7, r9)     // Catch:{ all -> 0x0094 }
            r5.invoke(r4, r9)     // Catch:{ all -> 0x0094 }
            goto L_0x0025
        L_0x0094:
            r11 = move-exception
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r0 == 0) goto L_0x009c
            r11.printStackTrace()
        L_0x009c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.controller.d.b(com.mbridge.msdk.foundation.controller.d):void");
    }

    public final void a(Map<String, Object> map, int i4) {
        if (MBridgeSDKFactory.getMBridgeSDK().getStatus() != MBridgeSDK.PLUGIN_LOAD_STATUS.COMPLETED) {
            af.b("SDKController", "preloaad failed,sdk do not inited");
            return;
        }
        this.f12807e = map;
        this.f12806d = i4;
        c.m().k();
        if (map != null) {
            if (this.f12815m == null) {
                this.f12815m = new com.mbridge.msdk.b.a();
            }
            try {
                Map<String, Object> map2 = this.f12807e;
                if (map2 != null && map2.size() > 0 && this.f12807e.containsKey(MBridgeConstans.PROPERTIES_LAYOUT_TYPE)) {
                    int intValue = ((Integer) this.f12807e.get(MBridgeConstans.PROPERTIES_LAYOUT_TYPE)).intValue();
                    if (intValue == 0) {
                        Map<String, Object> map3 = this.f12807e;
                        int i5 = this.f12806d;
                        try {
                            Class<?> cls = Class.forName("com.mbridge.msdk.mbnative.f.a");
                            Object newInstance = cls.newInstance();
                            cls.getMethod("preload", new Class[]{Map.class, Integer.TYPE}).invoke(newInstance, new Object[]{map3, Integer.valueOf(i5)});
                        } catch (Exception unused) {
                        }
                    } else if (1 != intValue && 2 != intValue) {
                        af.b("SDKController", "unknow layout type in preload");
                    }
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    static /* synthetic */ void a(d dVar) {
        Class<b> cls = b.class;
        try {
            cls.getDeclaredMethod("start", (Class[]) null).invoke(cls.getMethod("getInstance", (Class[]) null).invoke((Object) null, (Object[]) null), (Object[]) null);
        } catch (Throwable th) {
            af.b("SDKController", th.getMessage(), th);
        }
    }

    static /* synthetic */ void a(d dVar, final String str) {
        if (com.mbridge.msdk.c.h.a() != null) {
            com.mbridge.msdk.c.h a5 = com.mbridge.msdk.c.h.a();
            if (a5 != null) {
                g b5 = a5.b(str);
                if (b5 != null) {
                    MBridgeConstans.OMID_JS_SERVICE_URL = b5.X();
                    MBridgeConstans.OMID_JS_H5_URL = b5.W();
                    if (!TextUtils.isEmpty(b5.B())) {
                        com.mbridge.msdk.foundation.same.net.e.d.f().f13318h = b5.B();
                        com.mbridge.msdk.foundation.same.net.e.d.f().b();
                    }
                    if (!TextUtils.isEmpty(b5.C())) {
                        com.mbridge.msdk.foundation.same.net.e.d.f().f13322l = b5.C();
                        com.mbridge.msdk.foundation.same.net.e.d.f().c();
                    }
                } else {
                    MBridgeConstans.OMID_JS_SERVICE_URL = com.mbridge.msdk.c.a.b.f11823b;
                    MBridgeConstans.OMID_JS_H5_URL = com.mbridge.msdk.c.a.b.f11822a;
                }
            }
            if (com.mbridge.msdk.c.h.a().d(str) && com.mbridge.msdk.c.h.a().a(str, 1, (String) null)) {
                if (com.mbridge.msdk.foundation.a.a.a.a().a("is_first_init", 0) == 0) {
                    try {
                        com.mbridge.msdk.foundation.a.a.a.a().b("is_first_init", 1);
                        if (TextUtils.isEmpty(f.c())) {
                            dVar.f12805b.postDelayed(new Runnable() {
                                public final void run() {
                                    new j().b(d.this.f12813k, str, d.this.f12811i);
                                }
                            }, 350);
                        } else {
                            new j().b(dVar.f12813k, str, dVar.f12811i);
                        }
                    } catch (Throwable unused) {
                        new j().b(dVar.f12813k, str, dVar.f12811i);
                    }
                } else {
                    new j().b(dVar.f12813k, str, dVar.f12811i);
                }
            }
        }
    }
}
