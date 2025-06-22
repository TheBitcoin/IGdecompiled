package com.google.android.gms.common.api.internal;

import K.b;
import com.google.android.gms.common.api.Status;
import j$.util.DesugarCollections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import k0.C0938m;

public final class g {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Map f1319a = DesugarCollections.synchronizedMap(new WeakHashMap());
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Map f1320b = DesugarCollections.synchronizedMap(new WeakHashMap());

    private final void h(boolean z4, Status status) {
        HashMap hashMap;
        HashMap hashMap2;
        synchronized (this.f1319a) {
            hashMap = new HashMap(this.f1319a);
        }
        synchronized (this.f1320b) {
            hashMap2 = new HashMap(this.f1320b);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            if (z4 || ((Boolean) entry.getValue()).booleanValue()) {
                ((BasePendingResult) entry.getKey()).d(status);
            }
        }
        for (Map.Entry entry2 : hashMap2.entrySet()) {
            if (z4 || ((Boolean) entry2.getValue()).booleanValue()) {
                ((C0938m) entry2.getKey()).d(new b(status));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void c(BasePendingResult basePendingResult, boolean z4) {
        this.f1319a.put(basePendingResult, Boolean.valueOf(z4));
        basePendingResult.a(new e(this, basePendingResult));
    }

    /* access modifiers changed from: package-private */
    public final void d(C0938m mVar, boolean z4) {
        this.f1320b.put(mVar, Boolean.valueOf(z4));
        mVar.a().c(new f(this, mVar));
    }

    /* access modifiers changed from: package-private */
    public final void e(int i4, String str) {
        StringBuilder sb = new StringBuilder("The connection to Google Play services was lost");
        if (i4 == 1) {
            sb.append(" due to service disconnection.");
        } else if (i4 == 3) {
            sb.append(" due to dead object exception.");
        }
        if (str != null) {
            sb.append(" Last reason for disconnect: ");
            sb.append(str);
        }
        h(true, new Status(20, sb.toString()));
    }

    public final void f() {
        h(false, C0504c.f1289p);
    }

    /* access modifiers changed from: package-private */
    public final boolean g() {
        if (!this.f1319a.isEmpty() || !this.f1320b.isEmpty()) {
            return true;
        }
        return false;
    }
}
