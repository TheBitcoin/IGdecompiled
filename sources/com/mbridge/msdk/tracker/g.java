package com.mbridge.msdk.tracker;

import java.util.concurrent.atomic.AtomicLong;

final class g implements l {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final c f15451a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final r f15452b;

    /* renamed from: c  reason: collision with root package name */
    private final j f15453c;

    /* renamed from: d  reason: collision with root package name */
    private final AtomicLong f15454d = new AtomicLong(0);

    /* renamed from: e  reason: collision with root package name */
    private final long[] f15455e = new long[2];
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public volatile i f15456f;

    public g(c cVar, r rVar, j jVar) {
        this.f15451a = cVar;
        this.f15452b = rVar;
        this.f15453c = jVar;
    }

    public final void b(final e eVar) {
        this.f15453c.b(new Runnable() {
            private void a(i iVar, int i4) {
                while (i4 > 0) {
                    if (g.this.f15451a.a(iVar) > 0) {
                        g.this.f15452b.c();
                        g.this.f15452b.d();
                        g.this.f15452b.a(eVar);
                        return;
                    }
                    i4--;
                }
                i unused = g.this.f15456f = iVar;
            }

            public final void run() {
                i iVar = new i(eVar);
                iVar.a(1);
                iVar.b(0);
                iVar.a(System.currentTimeMillis() + eVar.h());
                if (g.this.f15456f != null) {
                    a(g.this.f15456f, 5);
                    i unused = g.this.f15456f = null;
                }
                a(iVar, 5);
            }
        });
    }

    public final void a(e eVar) {
        long incrementAndGet = this.f15454d.incrementAndGet();
        this.f15455e[0] = System.currentTimeMillis();
        this.f15455e[1] = incrementAndGet;
    }

    public final long[] a() {
        long[] jArr = this.f15455e;
        return jArr.length == 0 ? new long[]{0, 0} : jArr;
    }
}
