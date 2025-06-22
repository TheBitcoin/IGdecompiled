package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.a;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.db.BatchReportDao;
import com.mbridge.msdk.foundation.same.net.e.d;
import com.mbridge.msdk.foundation.same.report.e.b;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.tracker.m;
import com.mbridge.msdk.tracker.o;
import com.mbridge.msdk.tracker.v;
import com.mbridge.msdk.tracker.w;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public final class e {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f13451a = "e";

    /* renamed from: b  reason: collision with root package name */
    private static String f13452b = "roas";

    /* renamed from: c  reason: collision with root package name */
    private static volatile e f13453c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public AtomicInteger f13454d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public BatchReportDao f13455e;

    /* renamed from: f  reason: collision with root package name */
    private int f13456f = 1;

    /* renamed from: g  reason: collision with root package name */
    private long f13457g = 0;

    /* renamed from: h  reason: collision with root package name */
    private String f13458h = d.f().f13290F;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public volatile int f13459i = 0;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public boolean f13460j = false;

    /* renamed from: k  reason: collision with root package name */
    private Executor f13461k = Executors.newSingleThreadExecutor();
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public Handler f13462l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public Stack<Long> f13463m;

    /* renamed from: n  reason: collision with root package name */
    private m f13464n;

    private e() {
        a q4;
        boolean z4;
        o oVar;
        String str;
        g b5 = h.a().b(c.m().k());
        if (!(b5 == null || (q4 = b5.q()) == null)) {
            this.f13456f = q4.a();
            this.f13457g = ((long) q4.c()) * 1000;
            this.f13458h = d.f().f13290F;
            this.f13459i = q4.b();
            if (q4.d() == 1) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.f13460j = z4;
            if (z4 && this.f13459i != 1) {
                int a5 = ah.a().a("bcp", "type", ah.a().a("t_r_t", 1));
                if (!(a5 == 0 || a5 == 1)) {
                    a5 = 0;
                }
                w.a a6 = new w.a().a((com.mbridge.msdk.tracker.d) new d()).a((v) new m());
                if (a5 == 1) {
                    oVar = new o(new l((byte) 2), d.f().f13321k, d.f().f13325o);
                } else {
                    oVar = new o(new com.mbridge.msdk.tracker.network.toolbox.h(), d.f().f13290F, 0);
                }
                this.f13464n = m.a(f13452b, c.m().c(), a6.a(a5, oVar).e(ah.a().a("t_m_e_t", 604800000)).a(ah.a().a("t_m_e_s", 50)).d(ah.a().a("t_m_r_c", 50)).b(ah.a().a("t_m_t", (int) DefaultLoadControl.DEFAULT_MIN_BUFFER_MS)).c(ah.a().a("t_m_r_t_s", 1)).a());
                JSONObject a7 = c.a();
                try {
                    if (ab.w(c.m().c())) {
                        str = "pad";
                    } else {
                        str = "phone";
                    }
                    a7.put("device_type", str);
                    if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_OTHER)) {
                        a7.put(com.mbridge.msdk.foundation.same.net.f.e.f13345g, ab.n());
                    }
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
                this.f13464n.a(a7);
                this.f13464n.a();
            }
        }
        String str2 = f13451a;
        af.a(str2, "初始化批量上报： " + this.f13458h + " " + this.f13456f + " " + this.f13457g + " " + this.f13459i);
        this.f13454d = new AtomicInteger(0);
        this.f13463m = new Stack<>();
        this.f13455e = BatchReportDao.getInstance(c.m().c());
        HandlerThread handlerThread = new HandlerThread("mb_revenue_batch_report_thread");
        handlerThread.start();
        this.f13462l = new Handler(handlerThread.getLooper()) {
            public final void handleMessage(Message message) {
                int i4 = message.what;
                int i5 = 0;
                if (i4 == 1) {
                    Bundle data = message.getData();
                    if (e.this.f13462l != null && e.this.f13455e != null && data != null) {
                        e.this.f13462l.removeMessages(2);
                        long currentTimeMillis = System.currentTimeMillis();
                        ArrayList<BatchReportMessage> batchReportMessages = e.this.f13455e.getBatchReportMessages(currentTimeMillis, 2);
                        e.a(e.this, (ArrayList) batchReportMessages, currentTimeMillis);
                        e.this.f13454d.set(0);
                        String c5 = e.f13451a;
                        StringBuilder sb = new StringBuilder();
                        sb.append("超时上报触发了，需要上报的数据： ");
                        if (batchReportMessages != null) {
                            i5 = batchReportMessages.size();
                        }
                        sb.append(i5);
                        af.a(c5, sb.toString());
                    }
                } else if (i4 == 2) {
                    Bundle data2 = message.getData();
                    if (e.this.f13462l != null && e.this.f13455e != null && data2 != null) {
                        e.this.f13462l.removeMessages(1);
                        long j4 = data2.getLong("last_report_time");
                        ArrayList<BatchReportMessage> batchReportMessages2 = e.this.f13455e.getBatchReportMessages(j4, 2);
                        e.a(e.this, (ArrayList) batchReportMessages2, j4);
                        String c6 = e.f13451a;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("队列上报触发了，需要上报的数据： ");
                        if (batchReportMessages2 != null) {
                            i5 = batchReportMessages2.size();
                        }
                        sb2.append(i5);
                        af.a(c6, sb2.toString());
                    }
                } else if (i4 == 3) {
                    Bundle data3 = message.getData();
                    if (data3 != null) {
                        e.b(e.this, data3.getParcelableArrayList("report_message"), data3.getLong("last_report_time"));
                    }
                } else if (i4 == 4) {
                    Bundle data4 = message.getData();
                    if (e.this.f13462l != null && e.this.f13455e != null && data4 != null && e.this.f13460j) {
                        e.this.f13462l.removeMessages(4);
                        ArrayList<BatchReportMessage> batchReportMessages3 = e.this.f13455e.getBatchReportMessages(System.currentTimeMillis(), 2);
                        if (batchReportMessages3 != null && batchReportMessages3.size() > 0) {
                            for (int i6 = 0; i6 < batchReportMessages3.size(); i6++) {
                                BatchReportMessage batchReportMessage = batchReportMessages3.get(i6);
                                e.a(e.this, batchReportMessage.getReportMessage(), batchReportMessage.getTimestamp());
                            }
                        }
                        String c7 = e.f13451a;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("切换上报lib，需要上报的数据： ");
                        if (batchReportMessages3 != null) {
                            i5 = batchReportMessages3.size();
                        }
                        sb3.append(i5);
                        af.a(c7, sb3.toString());
                    }
                }
            }
        };
    }

    private JSONObject b(String str) {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(str)) {
            try {
                for (String split : str.split("&")) {
                    String[] split2 = split.split("=");
                    if (split2.length == 2) {
                        jSONObject.put(split2[0], split2[1]);
                    }
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
        return jSONObject;
    }

    /* access modifiers changed from: private */
    public void a(int i4, String str) {
        com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
        eVar.a(MRAIDCommunicatorUtil.KEY_STATE, Integer.valueOf(i4));
        if (i4 == 2) {
            eVar.a("reason", str);
        }
        com.mbridge.msdk.foundation.same.report.d.c cVar = new com.mbridge.msdk.foundation.same.report.d.c();
        cVar.a("m_ad_rev_s_s", eVar);
        com.mbridge.msdk.foundation.same.report.d.d.a().a("m_ad_rev_s_s", cVar);
    }

    public static synchronized e a() {
        e eVar;
        synchronized (e.class) {
            try {
                if (f13453c == null) {
                    f13453c = new e();
                }
                eVar = f13453c;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return eVar;
    }

    public final void b() {
        Handler handler = this.f13462l;
        if (handler != null && !handler.hasMessages(1) && this.f13459i != 1 && !this.f13460j) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            this.f13462l.sendMessageDelayed(obtain, 5000);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(final java.lang.String r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            int r0 = r2.f13459i     // Catch:{ all -> 0x0018 }
            r1 = 1
            if (r0 != r1) goto L_0x0008
            monitor-exit(r2)
            return
        L_0x0008:
            com.mbridge.msdk.foundation.same.report.e$3 r0 = new com.mbridge.msdk.foundation.same.report.e$3     // Catch:{ all -> 0x0018 }
            r0.<init>(r3)     // Catch:{ all -> 0x0018 }
            com.mbridge.msdk.foundation.controller.d.a()     // Catch:{ all -> 0x0018 }
            java.util.concurrent.Executor r3 = r2.f13461k     // Catch:{ all -> 0x0018 }
            if (r3 == 0) goto L_0x001a
            r3.execute(r0)     // Catch:{ all -> 0x0018 }
            goto L_0x001d
        L_0x0018:
            r3 = move-exception
            goto L_0x001f
        L_0x001a:
            r0.run()     // Catch:{ all -> 0x0018 }
        L_0x001d:
            monitor-exit(r2)
            return
        L_0x001f:
            monitor-exit(r2)     // Catch:{ all -> 0x0018 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.report.e.a(java.lang.String):void");
    }

    static /* synthetic */ void b(e eVar, final ArrayList arrayList, final long j4) {
        if (arrayList == null || arrayList.size() <= 0) {
            af.a(f13451a, "需要上报的数据条数： 0");
            return;
        }
        String str = f13451a;
        af.a(str, "需要上报的数据条数： " + arrayList.size());
        Context c5 = c.m().c();
        if (c5 != null) {
            com.mbridge.msdk.foundation.same.net.f.e a5 = i.a(c5);
            a5.a(MBridgeConstans.APP_ID, c.m().k());
            a5.a("m_sdk", "msdk");
            a5.a("lqswt", String.valueOf(1));
            a5.a("device_type", ab.w(c5) ? "pad" : "phone");
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_OTHER)) {
                a5.a(com.mbridge.msdk.foundation.same.net.f.e.f13345g, ab.n());
            }
            StringBuilder sb = new StringBuilder();
            int size = arrayList.size();
            int i4 = 0;
            while (i4 < size) {
                try {
                    BatchReportMessage batchReportMessage = (BatchReportMessage) arrayList.get(i4);
                    if (batchReportMessage != null) {
                        sb.append(batchReportMessage.getReportMessage() + "&ts=" + batchReportMessage.getTimestamp());
                        if (i4 >= 0 && i4 < size - 1) {
                            sb.append("\n");
                        }
                    }
                    i4++;
                } catch (Throwable th) {
                    af.b(f13451a, th.getMessage());
                }
            }
            try {
                String encode = URLEncoder.encode(sb.toString(), "utf-8");
                a5.a(DataSchemeDataSource.SCHEME_DATA, encode);
                String str2 = f13451a;
                af.a(str2, "需要批量上报的数据： " + encode);
                com.mbridge.msdk.foundation.same.report.e.a aVar = new com.mbridge.msdk.foundation.same.report.e.a(c.m().c());
                eVar.a(0, "");
                aVar.post(0, eVar.f13458h, a5, new b() {
                    public final void a(String str) {
                        af.a(e.f13451a, "批量上报成功");
                        e.this.a(1, "");
                        try {
                            if (e.this.f13455e != null) {
                                e.this.f13455e.deleteBatchReportMessagesByTimestamp(j4);
                            }
                        } catch (Exception e5) {
                            af.b(e.f13451a, e5.getMessage());
                        }
                        synchronized (e.this.f13463m) {
                            e.this.f13463m.clear();
                        }
                    }

                    public final void b(String str) {
                        Stack stack;
                        String c5 = e.f13451a;
                        af.a(c5, "批量上报失败： " + str);
                        e.this.a(2, str);
                        synchronized (e.this.f13463m) {
                            try {
                                e.this.f13463m.add(Long.valueOf(j4));
                                if (e.this.f13455e != null) {
                                    e.this.f13455e.updateMessagesReportState(arrayList);
                                }
                                if (e.this.f13463m.size() >= 5) {
                                    af.a(e.f13451a, "批量上报失败，上报失败的数据超过阈值");
                                    try {
                                        e.this.f13463m.pop();
                                        long longValue = ((Long) e.this.f13463m.pop()).longValue();
                                        e.this.f13463m.clear();
                                        if (e.this.f13455e != null) {
                                            e.this.f13455e.deleteBatchReportMessagesByTimestamp(longValue);
                                        }
                                        stack = e.this.f13463m;
                                    } catch (Exception e5) {
                                        af.b(e.f13451a, e5.getMessage());
                                        stack = e.this.f13463m;
                                    }
                                    stack.clear();
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                }, "roas", ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS);
            } catch (Exception e5) {
                af.b(f13451a, e5.getMessage());
            }
        }
    }

    static /* synthetic */ void a(e eVar, ArrayList arrayList, long j4) {
        if (arrayList != null && arrayList.size() > 0) {
            Message obtain = Message.obtain();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("report_message", arrayList);
            bundle.putLong("last_report_time", j4);
            obtain.setData(bundle);
            obtain.what = 3;
            eVar.f13462l.sendMessage(obtain);
        }
    }

    static /* synthetic */ void a(e eVar, String str, long j4) {
        if (eVar.f13464n != null) {
            com.mbridge.msdk.tracker.e eVar2 = new com.mbridge.msdk.tracker.e("roas");
            eVar2.a(true);
            if (j4 != 0) {
                eVar2.a(j4);
            }
            eVar2.b(1);
            try {
                eVar2.a(eVar.b(str));
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            eVar.f13464n.a(eVar2);
        }
    }

    static /* synthetic */ void a(e eVar, String str) {
        eVar.f13455e.addReportMessage(str, 2);
        Handler handler = eVar.f13462l;
        if (handler != null && !handler.hasMessages(1)) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            eVar.f13462l.sendMessageDelayed(obtain, eVar.f13457g);
        }
        if (eVar.f13454d.incrementAndGet() >= eVar.f13456f && eVar.f13462l != null) {
            Message obtain2 = Message.obtain();
            Bundle bundle = new Bundle();
            bundle.putLong("last_report_time", System.currentTimeMillis());
            obtain2.setData(bundle);
            obtain2.what = 2;
            eVar.f13462l.sendMessage(obtain2);
            eVar.f13454d.set(0);
        }
    }
}
