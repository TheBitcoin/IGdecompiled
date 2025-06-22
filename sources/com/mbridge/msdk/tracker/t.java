package com.mbridge.msdk.tracker;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.leanback.preference.LeanbackPreferenceDialogFragment;
import java.util.HashMap;
import org.json.JSONObject;

public class t {

    /* renamed from: d  reason: collision with root package name */
    private static volatile t f15690d;

    /* renamed from: a  reason: collision with root package name */
    Handler f15691a = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                try {
                    t.this.c();
                    t.this.f15691a.removeMessages(1);
                    t.this.d();
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private m f15692b;

    /* renamed from: c  reason: collision with root package name */
    private w f15693c;

    /* renamed from: e  reason: collision with root package name */
    private volatile boolean f15694e = false;

    /* renamed from: f  reason: collision with root package name */
    private int f15695f = 30000;

    /* renamed from: g  reason: collision with root package name */
    private final HashMap<String, String> f15696g = new HashMap<>();

    private t() {
    }

    /* access modifiers changed from: private */
    public void d() {
        try {
            this.f15691a.sendEmptyMessageDelayed(1, (long) this.f15695f);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final synchronized void b() {
        if (!this.f15694e) {
            this.f15694e = true;
            d();
        }
    }

    public final void c() {
        m[] d5 = m.d();
        if (d5.length != 0) {
            try {
                for (m mVar : d5) {
                    String c5 = mVar.c();
                    if (!"monitor".equals(c5)) {
                        String b5 = mVar.b();
                        long[] h4 = mVar.h();
                        long j4 = h4[1];
                        if (j4 != 0) {
                            long j5 = h4[0];
                            if (this.f15696g.containsKey(c5)) {
                                if ((j5 + "").equals(this.f15696g.get(c5))) {
                                }
                            }
                            this.f15696g.put(c5, j5 + "");
                            if (this.f15692b != null) {
                                try {
                                    e eVar = new e("event_lib_monitor");
                                    eVar.b(1);
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put(LeanbackPreferenceDialogFragment.ARG_KEY, "m_report_rate");
                                    jSONObject.put("task_name", c5);
                                    jSONObject.put("task_count", j4);
                                    jSONObject.put("task_session_id", b5);
                                    jSONObject.put("task_ts", j5);
                                    eVar.a(jSONObject);
                                    this.f15692b.a(eVar);
                                } catch (Exception e5) {
                                    e5.printStackTrace();
                                }
                            }
                        }
                    }
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
    }

    public final void a(Context context, w wVar, int i4, JSONObject jSONObject) {
        this.f15693c = wVar;
        this.f15695f = i4;
        m a5 = m.a("monitor", context, wVar);
        this.f15692b = a5;
        if (a5 != null) {
            a5.a(jSONObject);
            this.f15692b.a();
        }
        b();
    }

    public static t a() {
        if (f15690d == null) {
            synchronized (t.class) {
                try {
                    if (f15690d == null) {
                        f15690d = new t();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f15690d;
    }
}
