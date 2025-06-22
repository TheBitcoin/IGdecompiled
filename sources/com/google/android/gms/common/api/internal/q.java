package com.google.android.gms.common.api.internal;

import J.C0303b;
import K.a;
import L.C0318b;
import L.w;
import M.C0322c;
import M.C0329j;
import android.util.Log;
import java.util.Set;

final class q implements C0322c.C0003c, w {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final a.f f1346a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final C0318b f1347b;

    /* renamed from: c  reason: collision with root package name */
    private C0329j f1348c = null;

    /* renamed from: d  reason: collision with root package name */
    private Set f1349d = null;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f1350e = false;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ C0504c f1351f;

    public q(C0504c cVar, a.f fVar, C0318b bVar) {
        this.f1351f = cVar;
        this.f1346a = fVar;
        this.f1347b = bVar;
    }

    /* access modifiers changed from: private */
    public final void i() {
        C0329j jVar;
        if (this.f1350e && (jVar = this.f1348c) != null) {
            this.f1346a.e(jVar, this.f1349d);
        }
    }

    public final void a(C0303b bVar) {
        this.f1351f.f1306n.post(new p(this, bVar));
    }

    public final void b(C0303b bVar) {
        n nVar = (n) this.f1351f.f1302j.get(this.f1347b);
        if (nVar != null) {
            nVar.I(bVar);
        }
    }

    public final void c(C0329j jVar, Set set) {
        if (jVar == null || set == null) {
            Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
            b(new C0303b(4));
            return;
        }
        this.f1348c = jVar;
        this.f1349d = set;
        i();
    }

    public final void d(int i4) {
        n nVar = (n) this.f1351f.f1302j.get(this.f1347b);
        if (nVar == null) {
            return;
        }
        if (nVar.f1337q) {
            nVar.I(new C0303b(17));
        } else {
            nVar.h(i4);
        }
    }
}
