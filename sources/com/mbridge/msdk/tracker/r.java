package com.mbridge.msdk.tracker;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.mbridge.msdk.e.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

final class r {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final c f15673a;

    /* renamed from: b  reason: collision with root package name */
    private final int f15674b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final int f15675c;

    /* renamed from: d  reason: collision with root package name */
    private final int f15676d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final k f15677e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final AtomicInteger f15678f = new AtomicInteger(0);
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final AtomicInteger f15679g = new AtomicInteger(0);

    /* renamed from: h  reason: collision with root package name */
    private final Object f15680h = new Object();

    /* renamed from: i  reason: collision with root package name */
    private Handler f15681i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f15682j = true;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public long f15683k = 0;

    /* renamed from: l  reason: collision with root package name */
    private volatile boolean f15684l = false;

    /* renamed from: m  reason: collision with root package name */
    private volatile boolean f15685m = false;

    private static final class b extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final r f15688a;

        public b(Looper looper, r rVar) {
            super(looper);
            this.f15688a = rVar;
        }

        private void a(String str) {
            Log.d("TrackManager", this.f15688a.f15677e.c() + " " + str + this.f15688a.f15679g.addAndGet(0) + " 数据库记录数：" + this.f15688a.f15673a.a());
        }

        private void b() {
            try {
                removeMessages(1);
                removeMessages(6);
                removeMessages(2);
                removeMessages(3);
            } catch (Exception e5) {
                if (a.f15435a) {
                    Log.e("TrackManager", this.f15688a.f15677e.c() + " removeMessages failed ", e5);
                }
            }
            if (!this.f15688a.f()) {
                try {
                    sendMessageDelayed(Message.obtain(this, 1), y.a(this.f15688a.f15678f.get(), this.f15688a.f15683k, (long) this.f15688a.f15675c));
                } catch (Exception e6) {
                    if (a.f15435a) {
                        Log.e("TrackManager", this.f15688a.f15677e.c() + " sendMessageDelayed failed ", e6);
                    }
                }
            }
        }

        public final void dispatchMessage(Message message) {
            e eVar;
            super.dispatchMessage(message);
            int i4 = message.what;
            if (i4 == 2 || i4 == 3) {
                b();
                if (a.f15435a) {
                    a("触发上报（report result）当前 Event 数量：");
                }
                a();
            } else if (i4 == 5) {
                if (a.f15435a) {
                    a("触发删除 当前 Event 数量：");
                }
                r.a(this.f15688a);
                sendMessageDelayed(Message.obtain(this, 5), 120000);
            } else if (i4 == 6) {
                Object obj = message.obj;
                if (obj instanceof e) {
                    eVar = (e) obj;
                } else {
                    eVar = null;
                }
                if (a.f15435a && !y.a((Object) eVar)) {
                    a(String.format("收到 Event( %s )，当前 Event 数量：", new Object[]{eVar.a()}));
                }
                if ((y.b((Object) eVar) && eVar.c() == 1) || this.f15688a.e()) {
                    b();
                    if (a.f15435a) {
                        a("触发上报（notice check）当前 Event 数量：");
                    }
                    a();
                }
            } else if (i4 != 7) {
                b();
                if (a.f15435a) {
                    a("触发上报（timer）当前 Event 数量：");
                }
                a();
            } else {
                this.f15688a.c();
                b();
                if (a.f15435a) {
                    a("触发上报（flush）当前 Event 数量：");
                }
                a();
            }
        }

        private synchronized void a() {
            try {
                r.e(this.f15688a);
            } catch (Exception e5) {
                if (a.f15435a) {
                    Log.e("TrackManager", this.f15688a.f15677e.c() + " report failed ", e5);
                }
            }
        }
    }

    public r(k kVar) {
        this.f15673a = kVar.g();
        this.f15674b = kVar.l();
        this.f15675c = kVar.m();
        this.f15676d = kVar.n();
        this.f15677e = kVar;
    }

    /* access modifiers changed from: protected */
    public final boolean e() {
        return this.f15679g.addAndGet(0) >= this.f15674b;
    }

    static /* synthetic */ void e(r rVar) {
        if (rVar.f15677e.t()) {
            List<i> a5 = rVar.f15673a.a(rVar.f15674b);
            if (!y.a((List<?>) a5)) {
                rVar.f15673a.a(a5);
                int size = a5.size();
                rVar.f15679g.addAndGet(-size);
                boolean z4 = false;
                if (a.f15435a) {
                    Log.d("TrackManager", rVar.f15677e.c() + " report: 上报的数量 = " + size + " 当前剩余事件数 = " + rVar.f15679g.addAndGet(0) + " 数据库中剩余事件数 = " + rVar.f15673a.a());
                }
                try {
                    z4 = rVar.f15677e.p();
                } catch (IllegalStateException e5) {
                    if (a.f15435a) {
                        Log.e("TrackManager", rVar.f15677e.c() + " report environment check failed ", e5);
                    }
                }
                if (z4) {
                    n q4 = rVar.f15677e.q();
                    q4.a(new a(rVar.f15681i, rVar));
                    Map<String, String> hashMap = new HashMap<>();
                    try {
                        hashMap = rVar.f15677e.j().a(rVar.f15677e.k(), a5, rVar.f15677e.f());
                    } catch (Exception e6) {
                        if (a.f15435a) {
                            Log.e("TrackManager", rVar.f15677e.c() + " report decorate request params failed ", e6);
                        }
                    }
                    q4.a(new s(a5), hashMap, y.b(a5));
                } else if (a.f15435a) {
                    Log.e("TrackManager", rVar.f15677e.c() + " report 失败，请检查 TrackConfig 配置是否正确");
                }
            } else if (a.f15435a) {
                Log.d("TrackManager", rVar.f15677e.c() + " report: 没有可以上报的数据");
            }
        }
    }

    public final void a() {
        HandlerThread handlerThread = new HandlerThread("report_timer");
        handlerThread.start();
        b bVar = new b(handlerThread.getLooper(), this);
        this.f15681i = bVar;
        bVar.sendMessageDelayed(Message.obtain(bVar, 5), 5000);
        Handler handler = this.f15681i;
        handler.sendMessageDelayed(Message.obtain(handler, 1), (long) this.f15675c);
        this.f15682j = false;
    }

    public final void b() {
        this.f15681i.removeMessages(1);
        Handler handler = this.f15681i;
        handler.sendMessage(Message.obtain(handler, 7));
    }

    public final void c() {
        synchronized (this.f15680h) {
            try {
                if (!this.f15684l) {
                    this.f15684l = true;
                    this.f15673a.c();
                }
                if (!this.f15685m) {
                    this.f15685m = true;
                    this.f15679g.addAndGet(this.f15673a.a());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d() {
        this.f15679g.incrementAndGet();
    }

    /* access modifiers changed from: package-private */
    public final boolean f() {
        return this.f15682j;
    }

    static /* synthetic */ void b(r rVar, List list) {
        if (!y.a((List<?>) list)) {
            Iterator it = list.iterator();
            int i4 = 0;
            while (it.hasNext()) {
                i iVar = (i) it.next();
                if (!y.a((Object) iVar)) {
                    boolean z4 = true;
                    boolean z5 = !iVar.b() && iVar.d() >= rVar.f15676d;
                    if (iVar.a() || iVar.g() >= System.currentTimeMillis()) {
                        z4 = false;
                    }
                    if (z5 || z4) {
                        iVar.b(-1);
                    } else {
                        iVar.a(iVar.d() + (y.a(rVar.f15677e.e()) ? 1 : 0));
                        iVar.b(3);
                        i4++;
                    }
                }
            }
            rVar.f15673a.c((List<i>) list);
            rVar.f15679g.addAndGet(i4);
        }
    }

    private static final class a implements q {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f15686a;

        /* renamed from: b  reason: collision with root package name */
        private final r f15687b;

        public a(Handler handler, r rVar) {
            this.f15686a = handler;
            this.f15687b = rVar;
        }

        public final void a(s sVar) {
            r.a(this.f15687b, (List) sVar.a());
            this.f15687b.f15678f.set(0);
            long unused = this.f15687b.f15683k = 0;
            if (this.f15687b.e()) {
                Handler handler = this.f15686a;
                handler.sendMessage(Message.obtain(handler, 2));
            }
            if (a.f15435a) {
                Log.d("TrackManager", this.f15687b.f15677e.c() + " report success " + sVar.a().size() + " 剩余事件数：" + this.f15687b.f15679g.addAndGet(0) + " 个，数据库记录数：" + this.f15687b.f15673a.a() + " 个");
            }
        }

        public final void a(s sVar, int i4, String str) {
            r.b(this.f15687b, sVar.a());
            long unused = this.f15687b.f15683k = System.currentTimeMillis();
            int j4 = this.f15687b.f15678f.getAndIncrement();
            if (j4 <= 10) {
                Handler handler = this.f15686a;
                handler.sendMessageDelayed(Message.obtain(handler, 3), ((long) j4) * 1000);
            }
            if (a.f15435a) {
                Log.d("TrackManager", this.f15687b.f15677e.c() + " report failed " + sVar.a().size() + " 剩余事件数：" + this.f15687b.f15679g.addAndGet(0) + " 个，数据库记录数：" + this.f15687b.f15673a.a() + " 个 连续失败次数： " + j4);
            }
        }
    }

    public final void a(e eVar) {
        Handler handler = this.f15681i;
        handler.sendMessage(Message.obtain(handler, 6, eVar));
    }

    static /* synthetic */ void a(r rVar) {
        if (!a.f15435a || !e.f12712b) {
            int b5 = rVar.f15673a.b();
            if (a.f15435a) {
                Log.d("TrackManager", rVar.f15677e.c() + " 删除无效数据的数量 = " + b5 + " 当前剩余事件数 = " + rVar.f15679g.addAndGet(0) + " 数据库中剩余事件数 = " + rVar.f15673a.a());
            }
        }
    }

    static /* synthetic */ void a(r rVar, List list) {
        if (!y.a((List<?>) list)) {
            rVar.f15673a.b((List<i>) list);
        }
    }
}
