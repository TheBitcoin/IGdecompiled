package com.mbridge.msdk.newreward.function.c.c;

import com.mbridge.msdk.newreward.function.c.a.a;
import com.mbridge.msdk.newreward.function.c.a.b;

public final class z extends q {

    /* renamed from: a  reason: collision with root package name */
    private final b f14617a;

    /* renamed from: b  reason: collision with root package name */
    private final a f14618b;

    /* renamed from: c  reason: collision with root package name */
    private final c f14619c;

    public z(b bVar, a aVar, c cVar) {
        this.f14617a = bVar;
        this.f14618b = aVar;
        this.f14619c = cVar;
        cVar.b(true);
        cVar.a(false);
    }

    public final void a(int i4, x xVar) {
        if (xVar != null) {
            xVar.a(this.f14617a, this.f14618b, this);
            xVar.b(this.f14617a, this.f14618b, this);
        }
    }
}
