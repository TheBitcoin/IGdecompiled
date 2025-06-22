package com.google.firebase.messaging;

import I0.C1306b;
import O0.d;
import Q0.a;
import S0.e;
import Z0.h;
import Z0.i;
import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import java.util.Arrays;
import java.util.List;
import o.j;
import p0.C2194f;
import s0.C2264F;
import s0.C2268c;
import s0.r;

@Keep
public class FirebaseMessagingRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-fcm";

    @Keep
    public List<C2268c> getComponents() {
        C2264F a5 = C2264F.a(C1306b.class, j.class);
        return Arrays.asList(new C2268c[]{C2268c.c(FirebaseMessaging.class).h(LIBRARY_NAME).b(r.k(C2194f.class)).b(r.h(a.class)).b(r.i(i.class)).b(r.i(P0.j.class)).b(r.k(e.class)).b(r.j(a5)).b(r.k(d.class)).f(new B(a5)).c().d(), h.b(LIBRARY_NAME, "24.1.0")});
    }
}
