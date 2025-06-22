package com.mbridge.msdk.foundation.tools;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.j;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.same.broadcast.NetWorkChangeReceiver;
import org.json.JSONObject;

public final class v {

    /* renamed from: a  reason: collision with root package name */
    IntentFilter f13689a;

    /* renamed from: b  reason: collision with root package name */
    private JSONObject f13690b;

    /* renamed from: c  reason: collision with root package name */
    private j f13691c;

    /* renamed from: d  reason: collision with root package name */
    private long f13692d;

    /* renamed from: e  reason: collision with root package name */
    private final BroadcastReceiver f13693e;

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final v f13694a = new v();
    }

    public static v a() {
        return a.f13694a;
    }

    public final String b() {
        long j4;
        try {
            if (this.f13690b == null) {
                this.f13690b = new JSONObject();
            }
            if (this.f13690b.length() < 2) {
                try {
                    this.f13690b.put("KEY_INFO", (String) c.a(c.m().c(), "KEY_INFO", ""));
                } catch (Exception e5) {
                    af.b("NetAddressManager", e5.getMessage());
                }
                try {
                    this.f13690b.put("KEY_TIME", ((Long) c.a(c.m().c(), "KEY_TIME", 0L)).longValue());
                } catch (Exception e6) {
                    af.b("NetAddressManager", e6.getMessage());
                }
            }
            String optString = this.f13690b.optString("KEY_INFO");
            if (TextUtils.isEmpty(optString)) {
                return "";
            }
            g a5 = h.a().a(c.m().k());
            if (a5 != null) {
                j4 = a5.c();
            } else {
                j4 = 3600;
            }
            if (System.currentTimeMillis() - this.f13690b.optLong("KEY_TIME") > j4 * 1000) {
                return "";
            }
            return optString;
        } catch (Exception e7) {
            af.b("NetAddressManager", e7.getMessage());
            return "";
        }
    }

    public final void c() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f13692d > 3000) {
            if (this.f13691c == null) {
                this.f13691c = new j();
            }
            this.f13691c.a(c.m().c(), c.m().k(), c.m().b());
            this.f13692d = currentTimeMillis;
        }
    }

    public final void d() {
        Context c5;
        try {
            if (h.a().a(c.m().k()).a() == 1 && (c5 = c.m().c()) != null) {
                IntentFilter intentFilter = new IntentFilter();
                this.f13689a = intentFilter;
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                c5.registerReceiver(this.f13693e, this.f13689a);
            }
        } catch (Exception e5) {
            af.b("NetAddressManager", e5.getMessage());
        }
    }

    public final void e() {
        Context c5 = c.m().c();
        if (c5 != null) {
            try {
                c5.unregisterReceiver(this.f13693e);
            } catch (Exception e5) {
                af.b("NetAddressManager", e5.getMessage());
            }
        }
    }

    private v() {
        this.f13690b = new JSONObject();
        this.f13693e = new NetWorkChangeReceiver();
        IntentFilter intentFilter = new IntentFilter();
        this.f13689a = intentFilter;
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    }

    public final void a(String str) {
        if (this.f13690b == null) {
            this.f13690b = new JSONObject();
        }
        try {
            if (!this.f13690b.optString("KEY_INFO", "").equals(str)) {
                this.f13690b.put("KEY_INFO", str);
                c.b(c.m().c(), "KEY_INFO", str);
            }
        } catch (Exception e5) {
            af.b("NetAddressManager", e5.getMessage());
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                long currentTimeMillis = System.currentTimeMillis();
                this.f13690b.put("KEY_TIME", currentTimeMillis);
                c.b(c.m().c(), "KEY_TIME", Long.valueOf(currentTimeMillis));
            }
        } catch (Exception e6) {
            af.b("NetAddressManager", e6.getMessage());
        }
    }
}
