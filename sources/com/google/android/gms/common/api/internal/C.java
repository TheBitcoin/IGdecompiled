package com.google.android.gms.common.api.internal;

import J.C0303b;
import J.C0308g;
import L.e;
import Z.i;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.atomic.AtomicReference;

public abstract class C extends LifecycleCallback implements DialogInterface.OnCancelListener {

    /* renamed from: b  reason: collision with root package name */
    protected volatile boolean f1277b;

    /* renamed from: c  reason: collision with root package name */
    protected final AtomicReference f1278c = new AtomicReference((Object) null);

    /* renamed from: d  reason: collision with root package name */
    private final Handler f1279d = new i(Looper.getMainLooper());

    /* renamed from: e  reason: collision with root package name */
    protected final C0308g f1280e;

    C(e eVar, C0308g gVar) {
        super(eVar);
        this.f1280e = gVar;
    }

    /* access modifiers changed from: private */
    public final void l(C0303b bVar, int i4) {
        this.f1278c.set((Object) null);
        m(bVar, i4);
    }

    /* access modifiers changed from: private */
    public final void o() {
        this.f1278c.set((Object) null);
        n();
    }

    private static final int p(z zVar) {
        if (zVar == null) {
            return -1;
        }
        return zVar.a();
    }

    public final void e(int i4, int i5, Intent intent) {
        z zVar = (z) this.f1278c.get();
        if (i4 != 1) {
            if (i4 == 2) {
                int g4 = this.f1280e.g(b());
                if (g4 == 0) {
                    o();
                    return;
                } else if (zVar == null) {
                    return;
                } else {
                    if (zVar.b().c() == 18 && g4 == 18) {
                        return;
                    }
                }
            }
        } else if (i5 == -1) {
            o();
            return;
        } else if (i5 == 0) {
            if (zVar != null) {
                int i6 = 13;
                if (intent != null) {
                    i6 = intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13);
                }
                l(new C0303b(i6, (PendingIntent) null, zVar.b().toString()), p(zVar));
                return;
            }
            return;
        }
        if (zVar != null) {
            l(zVar.b(), zVar.a());
        }
    }

    public final void f(Bundle bundle) {
        z zVar;
        super.f(bundle);
        if (bundle != null) {
            AtomicReference atomicReference = this.f1278c;
            if (bundle.getBoolean("resolving_error", false)) {
                zVar = new z(new C0303b(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1));
            } else {
                zVar = null;
            }
            atomicReference.set(zVar);
        }
    }

    public final void i(Bundle bundle) {
        super.i(bundle);
        z zVar = (z) this.f1278c.get();
        if (zVar != null) {
            bundle.putBoolean("resolving_error", true);
            bundle.putInt("failed_client_id", zVar.a());
            bundle.putInt("failed_status", zVar.b().c());
            bundle.putParcelable("failed_resolution", zVar.b().h());
        }
    }

    public void j() {
        super.j();
        this.f1277b = true;
    }

    public void k() {
        super.k();
        this.f1277b = false;
    }

    /* access modifiers changed from: protected */
    public abstract void m(C0303b bVar, int i4);

    /* access modifiers changed from: protected */
    public abstract void n();

    public final void onCancel(DialogInterface dialogInterface) {
        l(new C0303b(13, (PendingIntent) null), p((z) this.f1278c.get()));
    }

    public final void s(C0303b bVar, int i4) {
        AtomicReference atomicReference;
        z zVar = new z(bVar, i4);
        do {
            atomicReference = this.f1278c;
            if (androidx.lifecycle.i.a(atomicReference, (Object) null, zVar)) {
                this.f1279d.post(new B(this, zVar));
                return;
            }
        } while (atomicReference.get() == null);
    }
}
