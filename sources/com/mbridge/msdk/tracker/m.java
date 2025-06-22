package com.mbridge.msdk.tracker;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class m {

    /* renamed from: b  reason: collision with root package name */
    private static final ConcurrentHashMap<String, m> f15490b = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final k f15491a;

    private m(String str, Context context, w wVar) {
        k kVar = new k(str, this);
        this.f15491a = kVar;
        kVar.a(context);
        kVar.a(wVar);
    }

    public static m[] d() {
        ConcurrentHashMap<String, m> concurrentHashMap = f15490b;
        m[] mVarArr = new m[concurrentHashMap.size()];
        try {
            int i4 = 0;
            for (Map.Entry<String, m> value : concurrentHashMap.entrySet()) {
                mVarArr[i4] = (m) value.getValue();
                i4++;
            }
        } catch (Exception e5) {
            if (a.f15435a) {
                Log.e("TrackManager", "getAllTrackManager error", e5);
            }
        }
        return mVarArr;
    }

    public final String b() {
        return this.f15491a.b();
    }

    public final String c() {
        return this.f15491a.c();
    }

    public final boolean e() {
        return !this.f15491a.r();
    }

    public final void f() {
        try {
            this.f15491a.i().a(new Runnable() {
                public final void run() {
                    try {
                        t.a().c();
                        m.this.f15491a.o().b();
                    } catch (Exception e5) {
                        if (a.f15435a) {
                            Log.e("TrackManager", "flush error", e5);
                        }
                    }
                }
            });
        } catch (Exception e5) {
            if (a.f15435a) {
                Log.e("TrackManager", "flush error", e5);
            }
        }
    }

    public final JSONObject g() {
        return this.f15491a.f();
    }

    public final long[] h() {
        return this.f15491a.h().a();
    }

    public final void i() {
        this.f15491a.s();
    }

    private boolean b(e eVar) {
        try {
            return c(eVar);
        } catch (Exception unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public boolean c(e eVar) {
        if (y.a((Object) eVar) || TextUtils.isEmpty(eVar.a())) {
            return false;
        }
        return this.f15491a.a(eVar);
    }

    public static m a(String str, Context context, w wVar) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ConcurrentHashMap<String, m> concurrentHashMap = f15490b;
        m mVar = concurrentHashMap.get(str);
        if (!y.a((Object) mVar)) {
            return mVar;
        }
        m mVar2 = new m(str, context, wVar);
        concurrentHashMap.put(str, mVar2);
        return mVar2;
    }

    public final String a() {
        if (!e()) {
            return this.f15491a.a();
        }
        if (a.f15435a) {
            Log.e("TrackManager", "MBridgeTrackManager is already running");
        }
        return this.f15491a.b();
    }

    public final void a(JSONObject jSONObject) {
        this.f15491a.a(jSONObject);
    }

    public final boolean a(String str) {
        return b(new e(str));
    }

    public final void a(final e eVar) {
        if (!this.f15491a.r()) {
            try {
                this.f15491a.i().a(new Runnable() {
                    public final void run() {
                        if (m.this.c(eVar)) {
                            m.this.f15491a.h().a(eVar);
                            eVar.c((long) m.this.f15491a.d().f15708f);
                            JSONObject d5 = eVar.d();
                            if (d5 != null) {
                                try {
                                    d5.put("session_id", m.this.b());
                                    long[] h4 = m.this.h();
                                    d5.put("track_time", h4[0]);
                                    d5.put("track_count", h4[1]);
                                } catch (JSONException e5) {
                                    e5.printStackTrace();
                                }
                                eVar.a(d5);
                            }
                            m.this.f15491a.h().b(eVar);
                        }
                    }
                });
            } catch (Exception e5) {
                if (a.f15435a) {
                    Log.e("TrackManager", "trackEvent error", e5);
                }
            }
        } else if (a.f15435a) {
            Log.d("TrackManager", "SDK is shutdown, track event will not be processed");
        }
    }
}
