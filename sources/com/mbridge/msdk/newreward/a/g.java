package com.mbridge.msdk.newreward.a;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.newreward.a.a.a;
import com.mbridge.msdk.newreward.a.a.b;
import com.mbridge.msdk.newreward.function.command.c;

public final class g extends a implements b {

    /* renamed from: b  reason: collision with root package name */
    a f14431b;

    public g(c cVar) {
        super(cVar);
    }

    public final void a(e eVar) {
        b bVar = new b(this.f14277a);
        this.f14431b = bVar;
        bVar.a(eVar);
    }

    public final void b(e eVar) {
        if (com.mbridge.msdk.e.b.a()) {
            this.f14277a.a((Object) eVar);
            return;
        }
        try {
            if (eVar.D().b().C() == 501) {
                this.f14277a.a((Object) eVar);
                return;
            }
            if (eVar.D().b().o() == 5002010) {
                this.f14277a.a((Object) eVar);
                return;
            }
            if (com.mbridge.msdk.foundation.same.b.a().a("new_bridge_reward_show")) {
                this.f14277a.a((Object) eVar, "NewShowReceiver");
            } else {
                this.f14277a.a((Object) eVar);
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
    }
}
