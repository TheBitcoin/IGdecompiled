package com.squareup.picasso;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import com.squareup.picasso.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

class g {

    /* renamed from: a  reason: collision with root package name */
    final b f17243a;

    /* renamed from: b  reason: collision with root package name */
    final Context f17244b;

    /* renamed from: c  reason: collision with root package name */
    final ExecutorService f17245c;

    /* renamed from: d  reason: collision with root package name */
    final H1.c f17246d;

    /* renamed from: e  reason: collision with root package name */
    final Map f17247e = new LinkedHashMap();

    /* renamed from: f  reason: collision with root package name */
    final Map f17248f = new WeakHashMap();

    /* renamed from: g  reason: collision with root package name */
    final Map f17249g = new WeakHashMap();

    /* renamed from: h  reason: collision with root package name */
    final Set f17250h = new LinkedHashSet();

    /* renamed from: i  reason: collision with root package name */
    final Handler f17251i;

    /* renamed from: j  reason: collision with root package name */
    final Handler f17252j;

    /* renamed from: k  reason: collision with root package name */
    final H1.a f17253k;

    /* renamed from: l  reason: collision with root package name */
    final z f17254l;

    /* renamed from: m  reason: collision with root package name */
    final List f17255m;

    /* renamed from: n  reason: collision with root package name */
    final c f17256n;

    /* renamed from: o  reason: collision with root package name */
    final boolean f17257o;

    /* renamed from: p  reason: collision with root package name */
    boolean f17258p;

    private static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final g f17259a;

        /* renamed from: com.squareup.picasso.g$a$a  reason: collision with other inner class name */
        class C0211a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Message f17260a;

            C0211a(Message message) {
                this.f17260a = message;
            }

            public void run() {
                throw new AssertionError("Unknown handler message received: " + this.f17260a.what);
            }
        }

        a(Looper looper, g gVar) {
            super(looper);
            this.f17259a = gVar;
        }

        public void handleMessage(Message message) {
            boolean z4 = false;
            switch (message.what) {
                case 1:
                    this.f17259a.v((C1814a) message.obj);
                    return;
                case 2:
                    this.f17259a.o((C1814a) message.obj);
                    return;
                case 4:
                    this.f17259a.p((C1816c) message.obj);
                    return;
                case 5:
                    this.f17259a.u((C1816c) message.obj);
                    return;
                case 6:
                    this.f17259a.q((C1816c) message.obj, false);
                    return;
                case 7:
                    this.f17259a.n();
                    return;
                case 9:
                    this.f17259a.r((NetworkInfo) message.obj);
                    return;
                case 10:
                    g gVar = this.f17259a;
                    if (message.arg1 == 1) {
                        z4 = true;
                    }
                    gVar.m(z4);
                    return;
                case 11:
                    this.f17259a.s(message.obj);
                    return;
                case 12:
                    this.f17259a.t(message.obj);
                    return;
                default:
                    s.f17301o.post(new C0211a(message));
                    return;
            }
        }
    }

    static class b extends HandlerThread {
        b() {
            super("Picasso-Dispatcher", 10);
        }
    }

    static class c extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        private final g f17262a;

        c(g gVar) {
            this.f17262a = gVar;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
            if (this.f17262a.f17257o) {
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
            this.f17262a.f17244b.registerReceiver(this, intentFilter);
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                if ("android.intent.action.AIRPLANE_MODE".equals(action)) {
                    if (intent.hasExtra(MRAIDCommunicatorUtil.KEY_STATE)) {
                        this.f17262a.b(intent.getBooleanExtra(MRAIDCommunicatorUtil.KEY_STATE, false));
                    }
                } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                    this.f17262a.f(((ConnectivityManager) C.o(context, "connectivity")).getActiveNetworkInfo());
                }
            }
        }
    }

    g(Context context, ExecutorService executorService, Handler handler, H1.c cVar, H1.a aVar, z zVar) {
        b bVar = new b();
        this.f17243a = bVar;
        bVar.start();
        C.i(bVar.getLooper());
        this.f17244b = context;
        this.f17245c = executorService;
        this.f17251i = new a(bVar.getLooper(), this);
        this.f17246d = cVar;
        this.f17252j = handler;
        this.f17253k = aVar;
        this.f17254l = zVar;
        this.f17255m = new ArrayList(4);
        this.f17258p = C.q(context);
        this.f17257o = C.p(context, "android.permission.ACCESS_NETWORK_STATE");
        c cVar2 = new c(this);
        this.f17256n = cVar2;
        cVar2.a();
    }

    private void a(C1816c cVar) {
        if (!cVar.u()) {
            Bitmap bitmap = cVar.f17225m;
            if (bitmap != null) {
                bitmap.prepareToDraw();
            }
            this.f17255m.add(cVar);
            if (!this.f17251i.hasMessages(7)) {
                this.f17251i.sendEmptyMessageDelayed(7, 200);
            }
        }
    }

    private void i() {
        if (!this.f17248f.isEmpty()) {
            Iterator it = this.f17248f.values().iterator();
            while (it.hasNext()) {
                C1814a aVar = (C1814a) it.next();
                it.remove();
                if (aVar.g().f17315m) {
                    C.t("Dispatcher", "replaying", aVar.i().d());
                }
                w(aVar, false);
            }
        }
    }

    private void j(List list) {
        if (list != null && !list.isEmpty() && ((C1816c) list.get(0)).q().f17315m) {
            StringBuilder sb = new StringBuilder();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                C1816c cVar = (C1816c) it.next();
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(C.k(cVar));
            }
            C.t("Dispatcher", "delivered", sb.toString());
        }
    }

    private void k(C1814a aVar) {
        Object k4 = aVar.k();
        if (k4 != null) {
            aVar.f17202k = true;
            this.f17248f.put(k4, aVar);
        }
    }

    private void l(C1816c cVar) {
        C1814a h4 = cVar.h();
        if (h4 != null) {
            k(h4);
        }
        List i4 = cVar.i();
        if (i4 != null) {
            int size = i4.size();
            for (int i5 = 0; i5 < size; i5++) {
                k((C1814a) i4.get(i5));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(boolean z4) {
        Handler handler = this.f17251i;
        handler.sendMessage(handler.obtainMessage(10, z4 ? 1 : 0, 0));
    }

    /* access modifiers changed from: package-private */
    public void c(C1814a aVar) {
        Handler handler = this.f17251i;
        handler.sendMessage(handler.obtainMessage(2, aVar));
    }

    /* access modifiers changed from: package-private */
    public void d(C1816c cVar) {
        Handler handler = this.f17251i;
        handler.sendMessage(handler.obtainMessage(4, cVar));
    }

    /* access modifiers changed from: package-private */
    public void e(C1816c cVar) {
        Handler handler = this.f17251i;
        handler.sendMessage(handler.obtainMessage(6, cVar));
    }

    /* access modifiers changed from: package-private */
    public void f(NetworkInfo networkInfo) {
        Handler handler = this.f17251i;
        handler.sendMessage(handler.obtainMessage(9, networkInfo));
    }

    /* access modifiers changed from: package-private */
    public void g(C1816c cVar) {
        Handler handler = this.f17251i;
        handler.sendMessageDelayed(handler.obtainMessage(5, cVar), 500);
    }

    /* access modifiers changed from: package-private */
    public void h(C1814a aVar) {
        Handler handler = this.f17251i;
        handler.sendMessage(handler.obtainMessage(1, aVar));
    }

    /* access modifiers changed from: package-private */
    public void m(boolean z4) {
        this.f17258p = z4;
    }

    /* access modifiers changed from: package-private */
    public void n() {
        ArrayList arrayList = new ArrayList(this.f17255m);
        this.f17255m.clear();
        Handler handler = this.f17252j;
        handler.sendMessage(handler.obtainMessage(8, arrayList));
        j(arrayList);
    }

    /* access modifiers changed from: package-private */
    public void o(C1814a aVar) {
        String d5 = aVar.d();
        C1816c cVar = (C1816c) this.f17247e.get(d5);
        if (cVar != null) {
            cVar.f(aVar);
            if (cVar.c()) {
                this.f17247e.remove(d5);
                if (aVar.g().f17315m) {
                    C.t("Dispatcher", "canceled", aVar.i().d());
                }
            }
        }
        if (this.f17250h.contains(aVar.j())) {
            this.f17249g.remove(aVar.k());
            if (aVar.g().f17315m) {
                C.u("Dispatcher", "canceled", aVar.i().d(), "because paused request got canceled");
            }
        }
        C1814a aVar2 = (C1814a) this.f17248f.remove(aVar.k());
        if (aVar2 != null && aVar2.g().f17315m) {
            C.u("Dispatcher", "canceled", aVar2.i().d(), "from replaying");
        }
    }

    /* access modifiers changed from: package-private */
    public void p(C1816c cVar) {
        if (o.b(cVar.p())) {
            this.f17253k.b(cVar.n(), cVar.s());
        }
        this.f17247e.remove(cVar.n());
        a(cVar);
        if (cVar.q().f17315m) {
            C.u("Dispatcher", "batched", C.k(cVar), "for completion");
        }
    }

    /* access modifiers changed from: package-private */
    public void q(C1816c cVar, boolean z4) {
        String str;
        if (cVar.q().f17315m) {
            String k4 = C.k(cVar);
            StringBuilder sb = new StringBuilder();
            sb.append("for error");
            if (z4) {
                str = " (will replay)";
            } else {
                str = "";
            }
            sb.append(str);
            C.u("Dispatcher", "batched", k4, sb.toString());
        }
        this.f17247e.remove(cVar.n());
        a(cVar);
    }

    /* access modifiers changed from: package-private */
    public void r(NetworkInfo networkInfo) {
        ExecutorService executorService = this.f17245c;
        if (executorService instanceof u) {
            ((u) executorService).a(networkInfo);
        }
        if (networkInfo != null && networkInfo.isConnected()) {
            i();
        }
    }

    /* access modifiers changed from: package-private */
    public void s(Object obj) {
        boolean z4;
        if (this.f17250h.add(obj)) {
            Iterator it = this.f17247e.values().iterator();
            while (it.hasNext()) {
                C1816c cVar = (C1816c) it.next();
                boolean z5 = cVar.q().f17315m;
                C1814a h4 = cVar.h();
                List i4 = cVar.i();
                if (i4 == null || i4.isEmpty()) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                if (h4 != null || z4) {
                    if (h4 != null && h4.j().equals(obj)) {
                        cVar.f(h4);
                        this.f17249g.put(h4.k(), h4);
                        if (z5) {
                            C.u("Dispatcher", "paused", h4.f17193b.d(), "because tag '" + obj + "' was paused");
                        }
                    }
                    if (z4) {
                        for (int size = i4.size() - 1; size >= 0; size--) {
                            C1814a aVar = (C1814a) i4.get(size);
                            if (aVar.j().equals(obj)) {
                                cVar.f(aVar);
                                this.f17249g.put(aVar.k(), aVar);
                                if (z5) {
                                    C.u("Dispatcher", "paused", aVar.f17193b.d(), "because tag '" + obj + "' was paused");
                                }
                            }
                        }
                    }
                    if (cVar.c()) {
                        it.remove();
                        if (z5) {
                            C.u("Dispatcher", "canceled", C.k(cVar), "all actions paused");
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void t(Object obj) {
        if (this.f17250h.remove(obj)) {
            Iterator it = this.f17249g.values().iterator();
            ArrayList arrayList = null;
            while (it.hasNext()) {
                C1814a aVar = (C1814a) it.next();
                if (aVar.j().equals(obj)) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(aVar);
                    it.remove();
                }
            }
            if (arrayList != null) {
                Handler handler = this.f17252j;
                handler.sendMessage(handler.obtainMessage(13, arrayList));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void u(C1816c cVar) {
        NetworkInfo networkInfo;
        if (!cVar.u()) {
            boolean z4 = false;
            if (this.f17245c.isShutdown()) {
                q(cVar, false);
                return;
            }
            if (this.f17257o) {
                networkInfo = ((ConnectivityManager) C.o(this.f17244b, "connectivity")).getActiveNetworkInfo();
            } else {
                networkInfo = null;
            }
            if (cVar.w(this.f17258p, networkInfo)) {
                if (cVar.q().f17315m) {
                    C.t("Dispatcher", "retrying", C.k(cVar));
                }
                if (cVar.k() instanceof q.a) {
                    cVar.f17221i |= p.NO_CACHE.f17293a;
                }
                cVar.f17226n = this.f17245c.submit(cVar);
                return;
            }
            if (this.f17257o && cVar.x()) {
                z4 = true;
            }
            q(cVar, z4);
            if (z4) {
                l(cVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void v(C1814a aVar) {
        w(aVar, true);
    }

    /* access modifiers changed from: package-private */
    public void w(C1814a aVar, boolean z4) {
        if (this.f17250h.contains(aVar.j())) {
            this.f17249g.put(aVar.k(), aVar);
            if (aVar.g().f17315m) {
                String d5 = aVar.f17193b.d();
                C.u("Dispatcher", "paused", d5, "because tag '" + aVar.j() + "' is paused");
                return;
            }
            return;
        }
        C1816c cVar = (C1816c) this.f17247e.get(aVar.d());
        if (cVar != null) {
            cVar.b(aVar);
        } else if (!this.f17245c.isShutdown()) {
            C1816c g4 = C1816c.g(aVar.g(), this, this.f17253k, this.f17254l, aVar);
            g4.f17226n = this.f17245c.submit(g4);
            this.f17247e.put(aVar.d(), g4);
            if (z4) {
                this.f17248f.remove(aVar.k());
            }
            if (aVar.g().f17315m) {
                C.t("Dispatcher", "enqueued", aVar.f17193b.d());
            }
        } else if (aVar.g().f17315m) {
            C.u("Dispatcher", "ignored", aVar.f17193b.d(), "because shut down");
        }
    }
}
