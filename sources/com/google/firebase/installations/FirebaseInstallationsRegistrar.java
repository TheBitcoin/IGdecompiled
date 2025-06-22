package com.google.firebase.installations;

import P0.h;
import P0.i;
import S0.e;
import S0.f;
import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import p0.C2194f;
import r0.C2213a;
import r0.C2214b;
import s0.C2264F;
import s0.C2268c;
import s0.C2270e;
import s0.r;
import t0.k;

@Keep
public class FirebaseInstallationsRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-installations";

    public static /* synthetic */ e a(C2270e eVar) {
        return new c((C2194f) eVar.a(C2194f.class), eVar.d(i.class), (ExecutorService) eVar.h(C2264F.a(C2213a.class, ExecutorService.class)), k.a((Executor) eVar.h(C2264F.a(C2214b.class, Executor.class))));
    }

    public List<C2268c> getComponents() {
        return Arrays.asList(new C2268c[]{C2268c.c(e.class).h(LIBRARY_NAME).b(r.k(C2194f.class)).b(r.i(i.class)).b(r.l(C2264F.a(C2213a.class, ExecutorService.class))).b(r.l(C2264F.a(C2214b.class, Executor.class))).f(new f()).d(), h.a(), Z0.h.b(LIBRARY_NAME, "18.0.0")});
    }
}
