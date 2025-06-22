package com.mbridge.msdk.newreward.a.a;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.command.c;
import java.util.Map;

public final class b extends a {
    public b(c cVar) {
        super(cVar);
    }

    public final void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
        if (!(bVar == null || this.f14280c == null)) {
            try {
                if (bVar.i() == -1) {
                    this.f14280c.a(System.currentTimeMillis());
                }
                e eVar = this.f14280c;
                eVar.b(bVar.i() + "");
                com.mbridge.msdk.foundation.same.net.e.c a5 = com.mbridge.msdk.foundation.same.net.e.c.a();
                a5.a(this.f14280c.B() + "_" + this.f14280c.C() + "_" + this.f14280c.H() + "_" + this.f14280c.h(), bVar.i(), bVar.k(), System.currentTimeMillis());
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
            }
        }
        if (this.f14280c.d() || this.f14280c.e() || this.f14280c.f()) {
            a(this.f14279b, bVar);
        } else {
            a(bVar);
        }
    }

    public final void reqSuccessful(Object obj) {
        Map map = (Map) obj;
        a(((Integer) map.get("type")).intValue(), map.get("object"));
    }
}
