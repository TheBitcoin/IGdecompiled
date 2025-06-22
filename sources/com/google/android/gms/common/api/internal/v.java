package com.google.android.gms.common.api.internal;

import M.C0335p;
import android.util.Log;
import com.google.android.gms.common.api.Status;

public final class v extends y {

    /* renamed from: b  reason: collision with root package name */
    protected final C0503b f1363b;

    public v(int i4, C0503b bVar) {
        super(i4);
        this.f1363b = (C0503b) C0335p.m(bVar, "Null methods are not runnable.");
    }

    public final void a(Status status) {
        try {
            this.f1363b.o(status);
        } catch (IllegalStateException e5) {
            Log.w("ApiCallRunner", "Exception reporting failure", e5);
        }
    }

    public final void b(Exception exc) {
        String simpleName = exc.getClass().getSimpleName();
        String localizedMessage = exc.getLocalizedMessage();
        try {
            this.f1363b.o(new Status(10, simpleName + ": " + localizedMessage));
        } catch (IllegalStateException e5) {
            Log.w("ApiCallRunner", "Exception reporting failure", e5);
        }
    }

    public final void c(n nVar) {
        try {
            this.f1363b.m(nVar.v());
        } catch (RuntimeException e5) {
            b(e5);
        }
    }

    public final void d(g gVar, boolean z4) {
        gVar.c(this.f1363b, z4);
    }
}
