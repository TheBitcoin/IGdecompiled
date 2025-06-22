package com.mbridge.msdk.click.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.f;
import com.mbridge.msdk.foundation.tools.aq;
import j$.util.concurrent.ConcurrentHashMap;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f12008a = "mtg_retry_report=1";

    /* renamed from: b  reason: collision with root package name */
    public static int f12009b = 10000;

    /* renamed from: c  reason: collision with root package name */
    public static int f12010c = 3;

    /* renamed from: d  reason: collision with root package name */
    public static int f12011d = 50;

    /* renamed from: e  reason: collision with root package name */
    public static int f12012e = 600000;

    /* renamed from: f  reason: collision with root package name */
    public static int f12013f = 0;

    /* renamed from: g  reason: collision with root package name */
    public static int f12014g = 1;

    /* renamed from: h  reason: collision with root package name */
    public static int f12015h = 2;

    /* renamed from: i  reason: collision with root package name */
    public static int f12016i = 3;

    /* renamed from: j  reason: collision with root package name */
    public static int f12017j = 4;

    /* renamed from: k  reason: collision with root package name */
    public static int f12018k = 5;

    /* renamed from: l  reason: collision with root package name */
    private static String f12019l = "RetryReportControl";

    /* renamed from: o  reason: collision with root package name */
    private static int f12020o;

    /* renamed from: p  reason: collision with root package name */
    private static int f12021p;

    /* renamed from: m  reason: collision with root package name */
    private ConcurrentHashMap<String, b> f12022m;

    /* renamed from: n  reason: collision with root package name */
    private c f12023n;

    /* renamed from: q  reason: collision with root package name */
    private BroadcastReceiver f12024q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public final Handler f12025r;

    /* renamed from: com.mbridge.msdk.click.a.a$a  reason: collision with other inner class name */
    private static class C0174a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static a f12027a = new a();
    }

    private static class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        public final void handleMessage(@NonNull Message message) {
            int i4 = message.what;
            if (i4 == 1) {
                Object obj = message.obj;
                if (obj instanceof String) {
                    a.a().a((String) obj, b.f12028a);
                }
            } else if (i4 == 2) {
                a.a(a.a());
            }
        }
    }

    private a() {
        this.f12022m = new ConcurrentHashMap<>();
        this.f12023n = new c(f12011d);
        this.f12025r = new b(Looper.getMainLooper());
        g a5 = h.a().a(c.m().k());
        f12010c = a5.ag();
        f12009b = a5.ai() * 1000;
        f12012e = a5.aj() * 1000;
        f12020o = a5.af();
        f12021p = a5.ah();
        try {
            if (this.f12024q == null) {
                this.f12024q = new BroadcastReceiver() {
                    public final void onReceive(Context context, Intent intent) {
                        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                            a.this.f12025r.sendEmptyMessage(2);
                        }
                    }
                };
                Context c5 = c.m().c();
                if (c5 != null) {
                    c5.registerReceiver(this.f12024q, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                }
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public static a a() {
        return C0174a.f12027a;
    }

    private boolean b(int i4) {
        return i4 == f12014g || i4 == f12015h;
    }

    private void a(b bVar) {
        String str;
        String str2;
        try {
            CampaignEx f4 = bVar.f();
            if (f4 != null) {
                String requestId = f4.getRequestId();
                str = f4.getRequestIdNotice();
                str2 = requestId;
            } else {
                str2 = "";
                str = str2;
            }
            a(c.m().c(), bVar.i().toString(), bVar.g(), str2, str, bVar.d());
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    private static void a(Context context, String str, String str2, String str3, String str4, int i4) {
        f.a().a(context, str, str2, str3, str4, i4);
    }

    private void a(String str) {
        Message obtainMessage = this.f12025r.obtainMessage();
        obtainMessage.what = 1;
        obtainMessage.obj = str;
        this.f12025r.sendMessageDelayed(obtainMessage, (long) f12009b);
    }

    /* access modifiers changed from: private */
    public void a(String str, int i4) {
        String str2;
        c cVar = this.f12023n;
        if (cVar != null) {
            b a5 = cVar.a(str);
            this.f12023n.b(str);
            if (a5 == null) {
                b bVar = this.f12022m.get(str);
                if (bVar != null && System.currentTimeMillis() <= bVar.j() + ((long) f12012e) && bVar.h() < f12010c && i4 != b.f12029b) {
                    a(str);
                }
            } else if (System.currentTimeMillis() <= a5.j() + ((long) f12012e)) {
                a5.a(i4);
                this.f12022m.put(str, a5);
                if (aq.c(str) == 0) {
                    str2 = str + "?" + f12008a;
                } else {
                    str2 = str + "&" + f12008a;
                }
                com.mbridge.msdk.click.a.a(c.m().c(), a5.f(), a5.e(), str2, a5.a(), a5.b(), a5.d());
            } else if (i4 != b.f12029b) {
                a(a5);
            }
        }
    }

    private boolean a(int i4) {
        return i4 == f12017j || i4 == f12016i;
    }

    public final void a(String str, String str2, CampaignEx campaignEx, String str3, boolean z4, boolean z5, int i4) {
        if ((a(i4) || b(i4) || i4 == f12018k) && !TextUtils.isEmpty(str)) {
            String replace = str.replace("?" + f12008a, "");
            String replace2 = replace.replace("&" + f12008a, "");
            if (this.f12022m == null) {
                this.f12022m = new ConcurrentHashMap<>();
            }
            b remove = this.f12022m.remove(replace2);
            if (remove == null) {
                remove = new b(str, str2);
                remove.b(i4);
                remove.a(z4);
                remove.b(z5);
                remove.a(campaignEx);
                remove.a(str3);
            } else if (remove.c() != b.f12029b) {
                remove.b(str2);
            }
            if ((!a(i4) || f12020o == 0) && ((!b(i4) || f12021p == 0) && i4 != f12018k)) {
                a(remove);
            } else if (System.currentTimeMillis() < remove.j() + ((long) f12012e)) {
                if (this.f12023n == null) {
                    this.f12023n = new c(f12011d);
                }
                this.f12023n.a(replace2, remove);
                if (remove.c() != b.f12028a) {
                    return;
                }
                if (remove.h() <= f12010c) {
                    a(replace2);
                } else {
                    a(remove);
                }
            } else if (remove.c() == b.f12028a) {
                a(remove);
            }
        }
    }

    static /* synthetic */ void a(a aVar) {
        c cVar = aVar.f12023n;
        if (cVar != null) {
            for (String a5 : cVar.a()) {
                aVar.a(a5, b.f12029b);
            }
        }
    }
}
