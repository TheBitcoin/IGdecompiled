package j$.time.format;

import j$.time.ZoneId;
import j$.time.chrono.C1117b;
import j$.time.chrono.l;
import j$.time.temporal.n;
import j$.time.temporal.q;
import j$.time.temporal.r;
import j$.time.temporal.u;

public final class o implements n {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C1117b f4962a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f4963b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ l f4964c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ZoneId f4965d;

    public final /* synthetic */ int k(q qVar) {
        return r.a(this, qVar);
    }

    public o(C1117b bVar, n nVar, l lVar, ZoneId zoneId) {
        this.f4962a = bVar;
        this.f4963b = nVar;
        this.f4964c = lVar;
        this.f4965d = zoneId;
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [j$.time.temporal.n, java.lang.Object] */
    public final boolean f(q qVar) {
        C1117b bVar = this.f4962a;
        if (bVar == null || !qVar.t()) {
            return this.f4963b.f(qVar);
        }
        return bVar.f(qVar);
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [j$.time.temporal.n, java.lang.Object] */
    public final u n(q qVar) {
        C1117b bVar = this.f4962a;
        if (bVar == null || !qVar.t()) {
            return this.f4963b.n(qVar);
        }
        return bVar.n(qVar);
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [j$.time.temporal.n, java.lang.Object] */
    public final long t(q qVar) {
        C1117b bVar = this.f4962a;
        if (bVar == null || !qVar.t()) {
            return this.f4963b.t(qVar);
        }
        return bVar.t(qVar);
    }

    /* JADX WARNING: type inference failed for: r0v3, types: [j$.time.temporal.n, java.lang.Object] */
    public final Object p(a aVar) {
        if (aVar == r.f5033b) {
            return this.f4964c;
        }
        if (aVar == r.f5032a) {
            return this.f4965d;
        }
        if (aVar == r.f5034c) {
            return this.f4963b.p(aVar);
        }
        return aVar.a(this);
    }

    public final String toString() {
        String str;
        String str2 = "";
        l lVar = this.f4964c;
        if (lVar != null) {
            str = " with chronology " + lVar;
        } else {
            str = str2;
        }
        ZoneId zoneId = this.f4965d;
        if (zoneId != null) {
            str2 = " with zone " + zoneId;
        }
        return this.f4963b + str + str2;
    }
}
