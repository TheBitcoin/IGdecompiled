package com.google.android.gms.common.api.internal;

import J.C0303b;
import M.C0329j;
import android.util.Log;

final class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C0303b f1344a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ q f1345b;

    p(q qVar, C0303b bVar) {
        this.f1345b = qVar;
        this.f1344a = bVar;
    }

    public final void run() {
        q qVar = this.f1345b;
        n nVar = (n) qVar.f1351f.f1302j.get(qVar.f1347b);
        if (nVar != null) {
            if (this.f1344a.k()) {
                this.f1345b.f1350e = true;
                if (this.f1345b.f1346a.o()) {
                    this.f1345b.i();
                    return;
                }
                try {
                    q qVar2 = this.f1345b;
                    qVar2.f1346a.e((C0329j) null, qVar2.f1346a.c());
                } catch (SecurityException e5) {
                    Log.e("GoogleApiManager", "Failed to get service from broker. ", e5);
                    this.f1345b.f1346a.d("Failed to get service from broker.");
                    nVar.H(new C0303b(10), (Exception) null);
                }
            } else {
                nVar.H(this.f1344a, (Exception) null);
            }
        }
    }
}
