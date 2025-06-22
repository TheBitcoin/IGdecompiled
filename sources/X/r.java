package x;

import A.a;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import o.C0962c;
import q.h;
import q.i;
import q.p;
import r.C1022e;
import r.C1023f;
import r.C1024g;
import r.C1030m;
import t.C1046a;
import t.C1048c;
import u.C1068a;
import y.C1093c;
import y.C1094d;
import y.C1101k;
import z.C1115b;

public class r {

    /* renamed from: a  reason: collision with root package name */
    private final Context f4654a;

    /* renamed from: b  reason: collision with root package name */
    private final C1022e f4655b;

    /* renamed from: c  reason: collision with root package name */
    private final C1094d f4656c;

    /* renamed from: d  reason: collision with root package name */
    private final x f4657d;

    /* renamed from: e  reason: collision with root package name */
    private final Executor f4658e;

    /* renamed from: f  reason: collision with root package name */
    private final C1115b f4659f;

    /* renamed from: g  reason: collision with root package name */
    private final a f4660g;

    /* renamed from: h  reason: collision with root package name */
    private final a f4661h;

    /* renamed from: i  reason: collision with root package name */
    private final C1093c f4662i;

    public r(Context context, C1022e eVar, C1094d dVar, x xVar, Executor executor, C1115b bVar, a aVar, a aVar2, C1093c cVar) {
        this.f4654a = context;
        this.f4655b = eVar;
        this.f4656c = dVar;
        this.f4657d = xVar;
        this.f4658e = executor;
        this.f4659f = bVar;
        this.f4660g = aVar;
        this.f4661h = aVar2;
        this.f4662i = cVar;
    }

    public static /* synthetic */ Object b(r rVar, Iterable iterable, p pVar, long j4) {
        rVar.f4656c.y(iterable);
        rVar.f4656c.t(pVar, rVar.f4660g.a() + j4);
        return null;
    }

    public static /* synthetic */ Object h(r rVar, Map map) {
        rVar.getClass();
        for (Map.Entry entry : map.entrySet()) {
            rVar.f4662i.a((long) ((Integer) entry.getValue()).intValue(), C1048c.b.INVALID_PAYLOD, (String) entry.getKey());
        }
        return null;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:10|11|12|13) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r3.f4657d.b(r4, r5 + 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0033, code lost:
        r6.run();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0036, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0037, code lost:
        r6.run();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003a, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0023, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x002c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void i(x.r r3, q.p r4, int r5, java.lang.Runnable r6) {
        /*
            r3.getClass()
            z.b r0 = r3.f4659f     // Catch:{ a -> 0x002c }
            y.d r1 = r3.f4656c     // Catch:{ a -> 0x002c }
            j$.util.Objects.requireNonNull(r1)     // Catch:{ a -> 0x002c }
            x.i r2 = new x.i     // Catch:{ a -> 0x002c }
            r2.<init>(r1)     // Catch:{ a -> 0x002c }
            r0.i(r2)     // Catch:{ a -> 0x002c }
            boolean r0 = r3.k()     // Catch:{ a -> 0x002c }
            if (r0 != 0) goto L_0x0025
            z.b r0 = r3.f4659f     // Catch:{ a -> 0x002c }
            x.j r1 = new x.j     // Catch:{ a -> 0x002c }
            r1.<init>(r3, r4, r5)     // Catch:{ a -> 0x002c }
            r0.i(r1)     // Catch:{ a -> 0x002c }
            goto L_0x0028
        L_0x0023:
            r3 = move-exception
            goto L_0x0037
        L_0x0025:
            r3.l(r4, r5)     // Catch:{ a -> 0x002c }
        L_0x0028:
            r6.run()
            return
        L_0x002c:
            x.x r3 = r3.f4657d     // Catch:{ all -> 0x0023 }
            int r5 = r5 + 1
            r3.b(r4, r5)     // Catch:{ all -> 0x0023 }
            r6.run()
            return
        L_0x0037:
            r6.run()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: x.r.i(x.r, q.p, int, java.lang.Runnable):void");
    }

    public i j(C1030m mVar) {
        C1115b bVar = this.f4659f;
        C1093c cVar = this.f4662i;
        Objects.requireNonNull(cVar);
        return mVar.b(i.a().i(this.f4660g.a()).o(this.f4661h.a()).n("GDT_CLIENT_METRICS").h(new h(C0962c.b("proto"), ((C1046a) bVar.i(new h(cVar))).f())).d());
    }

    /* access modifiers changed from: package-private */
    public boolean k() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f4654a.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    public C1024g l(p pVar, int i4) {
        C1024g a5;
        C1030m mVar = this.f4655b.get(pVar.b());
        C1024g e5 = C1024g.e(0);
        long j4 = 0;
        while (((Boolean) this.f4659f.i(new k(this, pVar))).booleanValue()) {
            Iterable<C1101k> iterable = (Iterable) this.f4659f.i(new l(this, pVar));
            if (!iterable.iterator().hasNext()) {
                return e5;
            }
            if (mVar == null) {
                C1068a.b("Uploader", "Unknown backend for %s, deleting event batch for it...", pVar);
                a5 = C1024g.a();
            } else {
                ArrayList arrayList = new ArrayList();
                for (C1101k b5 : iterable) {
                    arrayList.add(b5.b());
                }
                if (pVar.e()) {
                    arrayList.add(j(mVar));
                }
                a5 = mVar.a(C1023f.a().b(arrayList).c(pVar.c()).a());
            }
            e5 = a5;
            if (e5.c() == C1024g.a.TRANSIENT_ERROR) {
                p pVar2 = pVar;
                this.f4659f.i(new m(this, iterable, pVar2, j4));
                this.f4657d.a(pVar2, i4 + 1, true);
                return e5;
            }
            p pVar3 = pVar;
            this.f4659f.i(new n(this, iterable));
            if (e5.c() == C1024g.a.OK) {
                long max = Math.max(j4, e5.b());
                if (pVar3.e()) {
                    this.f4659f.i(new o(this));
                }
                j4 = max;
            } else if (e5.c() == C1024g.a.INVALID_PAYLOAD) {
                HashMap hashMap = new HashMap();
                for (C1101k b6 : iterable) {
                    String n4 = b6.b().n();
                    if (!hashMap.containsKey(n4)) {
                        hashMap.put(n4, 1);
                    } else {
                        hashMap.put(n4, Integer.valueOf(((Integer) hashMap.get(n4)).intValue() + 1));
                    }
                }
                this.f4659f.i(new p(this, hashMap));
            }
            pVar = pVar3;
        }
        this.f4659f.i(new q(this, pVar, j4));
        return e5;
    }

    public void m(p pVar, int i4, Runnable runnable) {
        this.f4658e.execute(new g(this, pVar, i4, runnable));
    }
}
