package com.google.android.gms.common.api.internal;

import J.C0303b;
import J.C0305d;
import K.a;
import K.e;
import K.f;
import K.k;
import L.C0318b;
import L.o;
import L.s;
import L.x;
import M.C0333n;
import M.C0335p;
import R.b;
import android.app.PendingIntent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.work.PeriodicWorkRequest;
import com.google.android.gms.common.api.Status;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import k0.C0938m;

public final class n implements f.a, f.b {

    /* renamed from: a  reason: collision with root package name */
    private final Queue f1329a = new LinkedList();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final a.f f1330b;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public final C0318b f1331k;

    /* renamed from: l  reason: collision with root package name */
    private final g f1332l;

    /* renamed from: m  reason: collision with root package name */
    private final Set f1333m = new HashSet();

    /* renamed from: n  reason: collision with root package name */
    private final Map f1334n = new HashMap();

    /* renamed from: o  reason: collision with root package name */
    private final int f1335o;

    /* renamed from: p  reason: collision with root package name */
    private final x f1336p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public boolean f1337q;

    /* renamed from: r  reason: collision with root package name */
    private final List f1338r = new ArrayList();

    /* renamed from: s  reason: collision with root package name */
    private C0303b f1339s = null;

    /* renamed from: t  reason: collision with root package name */
    private int f1340t = 0;

    /* renamed from: u  reason: collision with root package name */
    final /* synthetic */ C0504c f1341u;

    public n(C0504c cVar, e eVar) {
        this.f1341u = cVar;
        a.f m4 = eVar.m(cVar.f1306n.getLooper(), this);
        this.f1330b = m4;
        this.f1331k = eVar.g();
        this.f1332l = new g();
        this.f1335o = eVar.l();
        if (m4.o()) {
            this.f1336p = eVar.n(cVar.f1297e, cVar.f1306n);
        } else {
            this.f1336p = null;
        }
    }

    static /* bridge */ /* synthetic */ void B(n nVar, o oVar) {
        if (!nVar.f1338r.contains(oVar) || nVar.f1337q) {
            return;
        }
        if (!nVar.f1330b.j()) {
            nVar.E();
        } else {
            nVar.g();
        }
    }

    static /* bridge */ /* synthetic */ void C(n nVar, o oVar) {
        C0305d[] g4;
        if (nVar.f1338r.remove(oVar)) {
            nVar.f1341u.f1306n.removeMessages(15, oVar);
            nVar.f1341u.f1306n.removeMessages(16, oVar);
            C0305d a5 = oVar.f1343b;
            ArrayList arrayList = new ArrayList(nVar.f1329a.size());
            for (y yVar : nVar.f1329a) {
                if ((yVar instanceof s) && (g4 = ((s) yVar).g(nVar)) != null && b.b(g4, a5)) {
                    arrayList.add(yVar);
                }
            }
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                y yVar2 = (y) arrayList.get(i4);
                nVar.f1329a.remove(yVar2);
                yVar2.b(new k(a5));
            }
        }
    }

    private final C0305d c(C0305d[] dVarArr) {
        if (!(dVarArr == null || dVarArr.length == 0)) {
            C0305d[] m4 = this.f1330b.m();
            if (m4 == null) {
                m4 = new C0305d[0];
            }
            ArrayMap arrayMap = new ArrayMap(m4.length);
            for (C0305d dVar : m4) {
                arrayMap.put(dVar.c(), Long.valueOf(dVar.g()));
            }
            for (C0305d dVar2 : dVarArr) {
                Long l4 = (Long) arrayMap.get(dVar2.c());
                if (l4 == null || l4.longValue() < dVar2.g()) {
                    return dVar2;
                }
            }
        }
        return null;
    }

    private final void d(C0303b bVar) {
        Iterator it = this.f1333m.iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            if (C0333n.a(bVar, C0303b.f322e)) {
                this.f1330b.g();
            }
            throw null;
        }
        this.f1333m.clear();
    }

    /* access modifiers changed from: private */
    public final void e(Status status) {
        C0335p.d(this.f1341u.f1306n);
        f(status, (Exception) null, false);
    }

    private final void f(Status status, Exception exc, boolean z4) {
        boolean z5;
        C0335p.d(this.f1341u.f1306n);
        boolean z6 = true;
        if (status != null) {
            z5 = false;
        } else {
            z5 = true;
        }
        if (exc != null) {
            z6 = false;
        }
        if (z5 != z6) {
            Iterator it = this.f1329a.iterator();
            while (it.hasNext()) {
                y yVar = (y) it.next();
                if (!z4 || yVar.f1367a == 2) {
                    if (status != null) {
                        yVar.a(status);
                    } else {
                        yVar.b(exc);
                    }
                    it.remove();
                }
            }
            return;
        }
        throw new IllegalArgumentException("Status XOR exception should be null");
    }

    private final void g() {
        ArrayList arrayList = new ArrayList(this.f1329a);
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            y yVar = (y) arrayList.get(i4);
            if (this.f1330b.j()) {
                if (p(yVar)) {
                    this.f1329a.remove(yVar);
                }
                i4++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void j() {
        D();
        d(C0303b.f322e);
        o();
        Iterator it = this.f1334n.values().iterator();
        if (!it.hasNext()) {
            g();
            m();
            return;
        }
        android.support.v4.media.a.a(it.next());
        throw null;
    }

    /* access modifiers changed from: private */
    public final void l(int i4) {
        D();
        this.f1337q = true;
        this.f1332l.e(i4, this.f1330b.n());
        C0318b bVar = this.f1331k;
        C0504c cVar = this.f1341u;
        cVar.f1306n.sendMessageDelayed(Message.obtain(cVar.f1306n, 9, bVar), 5000);
        C0318b bVar2 = this.f1331k;
        C0504c cVar2 = this.f1341u;
        cVar2.f1306n.sendMessageDelayed(Message.obtain(cVar2.f1306n, 11, bVar2), 120000);
        this.f1341u.f1299g.c();
        Iterator it = this.f1334n.values().iterator();
        if (it.hasNext()) {
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    private final void m() {
        this.f1341u.f1306n.removeMessages(12, this.f1331k);
        C0318b bVar = this.f1331k;
        C0504c cVar = this.f1341u;
        cVar.f1306n.sendMessageDelayed(cVar.f1306n.obtainMessage(12, bVar), this.f1341u.f1293a);
    }

    private final void n(y yVar) {
        yVar.d(this.f1332l, a());
        try {
            yVar.c(this);
        } catch (DeadObjectException unused) {
            h(1);
            this.f1330b.d("DeadObjectException thrown while running ApiCallRunner.");
        }
    }

    private final void o() {
        if (this.f1337q) {
            C0504c cVar = this.f1341u;
            cVar.f1306n.removeMessages(11, this.f1331k);
            C0504c cVar2 = this.f1341u;
            cVar2.f1306n.removeMessages(9, this.f1331k);
            this.f1337q = false;
        }
    }

    private final boolean p(y yVar) {
        if (!(yVar instanceof s)) {
            n(yVar);
            return true;
        }
        s sVar = (s) yVar;
        C0305d c5 = c(sVar.g(this));
        if (c5 == null) {
            n(yVar);
            return true;
        }
        String name = this.f1330b.getClass().getName();
        String c6 = c5.c();
        long g4 = c5.g();
        Log.w("GoogleApiManager", name + " could not execute call because it requires feature (" + c6 + ", " + g4 + ").");
        if (!this.f1341u.f1307o || !sVar.f(this)) {
            sVar.b(new k(c5));
            return true;
        }
        o oVar = new o(this.f1331k, c5, (o) null);
        int indexOf = this.f1338r.indexOf(oVar);
        if (indexOf >= 0) {
            o oVar2 = (o) this.f1338r.get(indexOf);
            this.f1341u.f1306n.removeMessages(15, oVar2);
            C0504c cVar = this.f1341u;
            cVar.f1306n.sendMessageDelayed(Message.obtain(cVar.f1306n, 15, oVar2), 5000);
            return false;
        }
        this.f1338r.add(oVar);
        C0504c cVar2 = this.f1341u;
        cVar2.f1306n.sendMessageDelayed(Message.obtain(cVar2.f1306n, 15, oVar), 5000);
        C0504c cVar3 = this.f1341u;
        cVar3.f1306n.sendMessageDelayed(Message.obtain(cVar3.f1306n, 16, oVar), 120000);
        C0303b bVar = new C0303b(2, (PendingIntent) null);
        if (q(bVar)) {
            return false;
        }
        this.f1341u.f(bVar, this.f1335o);
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002a, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean q(J.C0303b r4) {
        /*
            r3 = this;
            java.lang.Object r0 = com.google.android.gms.common.api.internal.C0504c.f1291r
            monitor-enter(r0)
            com.google.android.gms.common.api.internal.c r1 = r3.f1341u     // Catch:{ all -> 0x0027 }
            com.google.android.gms.common.api.internal.h r2 = r1.f1303k     // Catch:{ all -> 0x0027 }
            if (r2 == 0) goto L_0x0029
            java.util.Set r1 = r1.f1304l     // Catch:{ all -> 0x0027 }
            L.b r2 = r3.f1331k     // Catch:{ all -> 0x0027 }
            boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x0027 }
            if (r1 == 0) goto L_0x0029
            com.google.android.gms.common.api.internal.c r1 = r3.f1341u     // Catch:{ all -> 0x0027 }
            com.google.android.gms.common.api.internal.h r1 = r1.f1303k     // Catch:{ all -> 0x0027 }
            int r2 = r3.f1335o     // Catch:{ all -> 0x0027 }
            r1.s(r4, r2)     // Catch:{ all -> 0x0027 }
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            r4 = 1
            return r4
        L_0x0027:
            r4 = move-exception
            goto L_0x002c
        L_0x0029:
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            r4 = 0
            return r4
        L_0x002c:
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.n.q(J.b):boolean");
    }

    private final boolean r(boolean z4) {
        C0335p.d(this.f1341u.f1306n);
        if (!this.f1330b.j() || !this.f1334n.isEmpty()) {
            return false;
        }
        if (!this.f1332l.g()) {
            this.f1330b.d("Timing out service connection.");
            return true;
        } else if (!z4) {
            return false;
        } else {
            m();
            return false;
        }
    }

    public final void D() {
        C0335p.d(this.f1341u.f1306n);
        this.f1339s = null;
    }

    public final void E() {
        C0335p.d(this.f1341u.f1306n);
        if (!this.f1330b.j() && !this.f1330b.f()) {
            try {
                C0504c cVar = this.f1341u;
                int b5 = cVar.f1299g.b(cVar.f1297e, this.f1330b);
                if (b5 != 0) {
                    C0303b bVar = new C0303b(b5, (PendingIntent) null);
                    String name = this.f1330b.getClass().getName();
                    String obj = bVar.toString();
                    Log.w("GoogleApiManager", "The service for " + name + " is not available: " + obj);
                    H(bVar, (Exception) null);
                    return;
                }
                C0504c cVar2 = this.f1341u;
                a.f fVar = this.f1330b;
                q qVar = new q(cVar2, fVar, this.f1331k);
                if (fVar.o()) {
                    ((x) C0335p.l(this.f1336p)).o0(qVar);
                }
                try {
                    this.f1330b.i(qVar);
                } catch (SecurityException e5) {
                    H(new C0303b(10), e5);
                }
            } catch (IllegalStateException e6) {
                H(new C0303b(10), e6);
            }
        }
    }

    public final void F(y yVar) {
        C0335p.d(this.f1341u.f1306n);
        if (!this.f1330b.j()) {
            this.f1329a.add(yVar);
            C0303b bVar = this.f1339s;
            if (bVar == null || !bVar.j()) {
                E();
            } else {
                H(this.f1339s, (Exception) null);
            }
        } else if (p(yVar)) {
            m();
        } else {
            this.f1329a.add(yVar);
        }
    }

    /* access modifiers changed from: package-private */
    public final void G() {
        this.f1340t++;
    }

    public final void H(C0303b bVar, Exception exc) {
        C0335p.d(this.f1341u.f1306n);
        x xVar = this.f1336p;
        if (xVar != null) {
            xVar.p0();
        }
        D();
        this.f1341u.f1299g.c();
        d(bVar);
        if ((this.f1330b instanceof O.e) && bVar.c() != 24) {
            this.f1341u.f1294b = true;
            C0504c cVar = this.f1341u;
            cVar.f1306n.sendMessageDelayed(cVar.f1306n.obtainMessage(19), PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS);
        }
        if (bVar.c() == 4) {
            e(C0504c.f1290q);
        } else if (this.f1329a.isEmpty()) {
            this.f1339s = bVar;
        } else if (exc != null) {
            C0335p.d(this.f1341u.f1306n);
            f((Status) null, exc, false);
        } else if (this.f1341u.f1307o) {
            f(C0504c.g(this.f1331k, bVar), (Exception) null, true);
            if (!this.f1329a.isEmpty() && !q(bVar) && !this.f1341u.f(bVar, this.f1335o)) {
                if (bVar.c() == 18) {
                    this.f1337q = true;
                }
                if (this.f1337q) {
                    C0504c cVar2 = this.f1341u;
                    cVar2.f1306n.sendMessageDelayed(Message.obtain(cVar2.f1306n, 9, this.f1331k), 5000);
                    return;
                }
                e(C0504c.g(this.f1331k, bVar));
            }
        } else {
            e(C0504c.g(this.f1331k, bVar));
        }
    }

    public final void I(C0303b bVar) {
        C0335p.d(this.f1341u.f1306n);
        a.f fVar = this.f1330b;
        String name = fVar.getClass().getName();
        String valueOf = String.valueOf(bVar);
        fVar.d("onSignInFailed for " + name + " with " + valueOf);
        H(bVar, (Exception) null);
    }

    public final void J() {
        C0335p.d(this.f1341u.f1306n);
        if (this.f1337q) {
            E();
        }
    }

    public final void K() {
        C0335p.d(this.f1341u.f1306n);
        e(C0504c.f1289p);
        this.f1332l.f();
        for (L.f fVar : (L.f[]) this.f1334n.keySet().toArray(new L.f[0])) {
            F(new x((L.f) null, new C0938m()));
        }
        d(new C0303b(4));
        if (this.f1330b.j()) {
            this.f1330b.h(new m(this));
        }
    }

    public final void L() {
        Status status;
        C0335p.d(this.f1341u.f1306n);
        if (this.f1337q) {
            o();
            C0504c cVar = this.f1341u;
            if (cVar.f1298f.g(cVar.f1297e) == 18) {
                status = new Status(21, "Connection timed out waiting for Google Play services update to complete.");
            } else {
                status = new Status(22, "API failed to connect while resuming due to an unknown error.");
            }
            e(status);
            this.f1330b.d("Timing out connection while resuming.");
        }
    }

    public final boolean a() {
        return this.f1330b.o();
    }

    public final boolean b() {
        return r(true);
    }

    public final void h(int i4) {
        if (Looper.myLooper() == this.f1341u.f1306n.getLooper()) {
            l(i4);
        } else {
            this.f1341u.f1306n.post(new k(this, i4));
        }
    }

    public final void i(C0303b bVar) {
        H(bVar, (Exception) null);
    }

    public final void k(Bundle bundle) {
        if (Looper.myLooper() == this.f1341u.f1306n.getLooper()) {
            j();
        } else {
            this.f1341u.f1306n.post(new j(this));
        }
    }

    public final int s() {
        return this.f1335o;
    }

    /* access modifiers changed from: package-private */
    public final int t() {
        return this.f1340t;
    }

    public final a.f v() {
        return this.f1330b;
    }

    public final Map x() {
        return this.f1334n;
    }
}
