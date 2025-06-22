package com.mbridge.msdk.tracker;

import android.util.Log;

final class p implements l {

    /* renamed from: a  reason: collision with root package name */
    private final g f15672a;

    public p(g gVar) {
        this.f15672a = gVar;
    }

    public final void a(e eVar) {
        if (!y.a((Object) this.f15672a)) {
            this.f15672a.a(eVar);
        }
    }

    public final void b(e eVar) {
        if (!y.a((Object) this.f15672a)) {
            try {
                h i4 = eVar.i();
                if (y.b((Object) i4)) {
                    eVar.a(i4.a(eVar));
                }
                this.f15672a.b(eVar);
            } catch (Exception e5) {
                if (a.f15435a) {
                    Log.e("TrackManager", "process event error", e5);
                }
            }
        }
    }

    public final long[] a() {
        if (y.a((Object) this.f15672a)) {
            return new long[]{0, 0};
        }
        return this.f15672a.a();
    }
}
