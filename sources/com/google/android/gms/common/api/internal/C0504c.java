package com.google.android.gms.common.api.internal;

import J.C0303b;
import J.C0308g;
import K.e;
import L.C0318b;
import L.k;
import L.n;
import L.t;
import M.C0327h;
import M.C0332m;
import M.C0336q;
import M.C0338t;
import M.C0339u;
import M.C0340v;
import M.G;
import M.r;
import R.h;
import Z.i;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.media.a;
import android.util.Log;
import androidx.collection.ArraySet;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkRequest;
import com.google.android.gms.common.api.Status;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import k0.C0937l;
import k0.C0938m;

/* renamed from: com.google.android.gms.common.api.internal.c  reason: case insensitive filesystem */
public class C0504c implements Handler.Callback {

    /* renamed from: p  reason: collision with root package name */
    public static final Status f1289p = new Status(4, "Sign-out occurred while this API call was in progress.");
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public static final Status f1290q = new Status(4, "The user must be signed in to make this API call.");
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public static final Object f1291r = new Object();

    /* renamed from: s  reason: collision with root package name */
    private static C0504c f1292s;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public long f1293a = WorkRequest.MIN_BACKOFF_MILLIS;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public boolean f1294b = false;

    /* renamed from: c  reason: collision with root package name */
    private C0338t f1295c;

    /* renamed from: d  reason: collision with root package name */
    private C0340v f1296d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final Context f1297e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final C0308g f1298f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final G f1299g;

    /* renamed from: h  reason: collision with root package name */
    private final AtomicInteger f1300h = new AtomicInteger(1);

    /* renamed from: i  reason: collision with root package name */
    private final AtomicInteger f1301i = new AtomicInteger(0);
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final Map f1302j = new ConcurrentHashMap(5, 0.75f, 1);
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public h f1303k = null;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public final Set f1304l = new ArraySet();

    /* renamed from: m  reason: collision with root package name */
    private final Set f1305m = new ArraySet();
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public final Handler f1306n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public volatile boolean f1307o = true;

    private C0504c(Context context, Looper looper, C0308g gVar) {
        this.f1297e = context;
        i iVar = new i(looper, this);
        this.f1306n = iVar;
        this.f1298f = gVar;
        this.f1299g = new G(gVar);
        if (h.a(context)) {
            this.f1307o = false;
        }
        iVar.sendMessage(iVar.obtainMessage(6));
    }

    public static void a() {
        synchronized (f1291r) {
            try {
                C0504c cVar = f1292s;
                if (cVar != null) {
                    cVar.f1301i.incrementAndGet();
                    Handler handler = cVar.f1306n;
                    handler.sendMessageAtFrontOfQueue(handler.obtainMessage(10));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    public static Status g(C0318b bVar, C0303b bVar2) {
        String b5 = bVar.b();
        String valueOf = String.valueOf(bVar2);
        return new Status(bVar2, "API: " + b5 + " is not available on this device. Connection failed with: " + valueOf);
    }

    private final n h(e eVar) {
        Map map = this.f1302j;
        C0318b g4 = eVar.g();
        n nVar = (n) map.get(g4);
        if (nVar == null) {
            nVar = new n(this, eVar);
            this.f1302j.put(g4, nVar);
        }
        if (nVar.a()) {
            this.f1305m.add(g4);
        }
        nVar.E();
        return nVar;
    }

    private final C0340v i() {
        if (this.f1296d == null) {
            this.f1296d = C0339u.a(this.f1297e);
        }
        return this.f1296d;
    }

    private final void j() {
        C0338t tVar = this.f1295c;
        if (tVar != null) {
            if (tVar.c() > 0 || e()) {
                i().a(tVar);
            }
            this.f1295c = null;
        }
    }

    private final void k(C0938m mVar, int i4, e eVar) {
        r b5;
        if (i4 != 0 && (b5 = r.b(this, i4, eVar.g())) != null) {
            C0937l a5 = mVar.a();
            Handler handler = this.f1306n;
            handler.getClass();
            a5.b(new n(handler), b5);
        }
    }

    public static C0504c u(Context context) {
        C0504c cVar;
        synchronized (f1291r) {
            try {
                if (f1292s == null) {
                    f1292s = new C0504c(context.getApplicationContext(), C0327h.b().getLooper(), C0308g.n());
                }
                cVar = f1292s;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }

    public final void A(e eVar, int i4, C0503b bVar) {
        this.f1306n.sendMessage(this.f1306n.obtainMessage(4, new t(new v(i4, bVar), this.f1301i.get(), eVar)));
    }

    public final void B(e eVar, int i4, C0505d dVar, C0938m mVar, k kVar) {
        k(mVar, dVar.d(), eVar);
        this.f1306n.sendMessage(this.f1306n.obtainMessage(4, new t(new w(i4, dVar, mVar, kVar), this.f1301i.get(), eVar)));
    }

    /* access modifiers changed from: package-private */
    public final void C(C0332m mVar, int i4, long j4, int i5) {
        this.f1306n.sendMessage(this.f1306n.obtainMessage(18, new s(mVar, i4, j4, i5)));
    }

    public final void D(C0303b bVar, int i4) {
        if (!f(bVar, i4)) {
            Handler handler = this.f1306n;
            handler.sendMessage(handler.obtainMessage(5, i4, 0, bVar));
        }
    }

    public final void E() {
        Handler handler = this.f1306n;
        handler.sendMessage(handler.obtainMessage(3));
    }

    public final void F(e eVar) {
        Handler handler = this.f1306n;
        handler.sendMessage(handler.obtainMessage(7, eVar));
    }

    public final void b(h hVar) {
        synchronized (f1291r) {
            try {
                if (this.f1303k != hVar) {
                    this.f1303k = hVar;
                    this.f1304l.clear();
                }
                this.f1304l.addAll(hVar.t());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void c(h hVar) {
        synchronized (f1291r) {
            try {
                if (this.f1303k == hVar) {
                    this.f1303k = null;
                    this.f1304l.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean e() {
        if (this.f1294b) {
            return false;
        }
        r a5 = C0336q.b().a();
        if (a5 != null && !a5.h()) {
            return false;
        }
        int a6 = this.f1299g.a(this.f1297e, 203400000);
        if (a6 == -1 || a6 == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean f(C0303b bVar, int i4) {
        return this.f1298f.x(this.f1297e, bVar, i4);
    }

    public final boolean handleMessage(Message message) {
        int i4 = message.what;
        long j4 = PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS;
        n nVar = null;
        switch (i4) {
            case 1:
                if (true == ((Boolean) message.obj).booleanValue()) {
                    j4 = WorkRequest.MIN_BACKOFF_MILLIS;
                }
                this.f1293a = j4;
                this.f1306n.removeMessages(12);
                for (C0318b obtainMessage : this.f1302j.keySet()) {
                    Handler handler = this.f1306n;
                    handler.sendMessageDelayed(handler.obtainMessage(12, obtainMessage), this.f1293a);
                }
                break;
            case 2:
                a.a(message.obj);
                throw null;
            case 3:
                for (n nVar2 : this.f1302j.values()) {
                    nVar2.D();
                    nVar2.E();
                }
                break;
            case 4:
            case 8:
            case 13:
                t tVar = (t) message.obj;
                n nVar3 = (n) this.f1302j.get(tVar.f405c.g());
                if (nVar3 == null) {
                    nVar3 = h(tVar.f405c);
                }
                if (nVar3.a() && this.f1301i.get() != tVar.f404b) {
                    tVar.f403a.a(f1289p);
                    nVar3.K();
                    break;
                } else {
                    nVar3.F(tVar.f403a);
                    break;
                }
            case 5:
                int i5 = message.arg1;
                C0303b bVar = (C0303b) message.obj;
                Iterator it = this.f1302j.values().iterator();
                while (true) {
                    if (it.hasNext()) {
                        n nVar4 = (n) it.next();
                        if (nVar4.s() == i5) {
                            nVar = nVar4;
                        }
                    }
                }
                if (nVar != null) {
                    if (bVar.c() != 13) {
                        nVar.e(g(nVar.f1331k, bVar));
                        break;
                    } else {
                        String e5 = this.f1298f.e(bVar.c());
                        String g4 = bVar.g();
                        nVar.e(new Status(17, "Error resolution was canceled by the user, original error message: " + e5 + ": " + g4));
                        break;
                    }
                } else {
                    Log.wtf("GoogleApiManager", "Could not find API instance " + i5 + " while trying to fail enqueued calls.", new Exception());
                    break;
                }
            case 6:
                if (this.f1297e.getApplicationContext() instanceof Application) {
                    C0502a.c((Application) this.f1297e.getApplicationContext());
                    C0502a.b().a(new i(this));
                    if (!C0502a.b().e(true)) {
                        this.f1293a = PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS;
                        break;
                    }
                }
                break;
            case 7:
                h((e) message.obj);
                break;
            case 9:
                if (this.f1302j.containsKey(message.obj)) {
                    ((n) this.f1302j.get(message.obj)).J();
                    break;
                }
                break;
            case 10:
                for (C0318b remove : this.f1305m) {
                    n nVar5 = (n) this.f1302j.remove(remove);
                    if (nVar5 != null) {
                        nVar5.K();
                    }
                }
                this.f1305m.clear();
                break;
            case 11:
                if (this.f1302j.containsKey(message.obj)) {
                    ((n) this.f1302j.get(message.obj)).L();
                    break;
                }
                break;
            case 12:
                if (this.f1302j.containsKey(message.obj)) {
                    ((n) this.f1302j.get(message.obj)).b();
                    break;
                }
                break;
            case 14:
                a.a(message.obj);
                throw null;
            case 15:
                o oVar = (o) message.obj;
                if (this.f1302j.containsKey(oVar.f1342a)) {
                    n.B((n) this.f1302j.get(oVar.f1342a), oVar);
                    break;
                }
                break;
            case 16:
                o oVar2 = (o) message.obj;
                if (this.f1302j.containsKey(oVar2.f1342a)) {
                    n.C((n) this.f1302j.get(oVar2.f1342a), oVar2);
                    break;
                }
                break;
            case 17:
                j();
                break;
            case 18:
                s sVar = (s) message.obj;
                if (sVar.f1359c != 0) {
                    C0338t tVar2 = this.f1295c;
                    if (tVar2 != null) {
                        List g5 = tVar2.g();
                        if (tVar2.c() != sVar.f1358b || (g5 != null && g5.size() >= sVar.f1360d)) {
                            this.f1306n.removeMessages(17);
                            j();
                        } else {
                            this.f1295c.h(sVar.f1357a);
                        }
                    }
                    if (this.f1295c == null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(sVar.f1357a);
                        this.f1295c = new C0338t(sVar.f1358b, arrayList);
                        Handler handler2 = this.f1306n;
                        handler2.sendMessageDelayed(handler2.obtainMessage(17), sVar.f1359c);
                        break;
                    }
                } else {
                    i().a(new C0338t(sVar.f1358b, Arrays.asList(new C0332m[]{sVar.f1357a})));
                    break;
                }
                break;
            case 19:
                this.f1294b = false;
                break;
            default:
                Log.w("GoogleApiManager", "Unknown message id: " + i4);
                return false;
        }
        return true;
    }

    public final int l() {
        return this.f1300h.getAndIncrement();
    }

    /* access modifiers changed from: package-private */
    public final n t(C0318b bVar) {
        return (n) this.f1302j.get(bVar);
    }
}
