package com.google.firebase.datatransport;

import I0.C1305a;
import I0.C1306b;
import I0.C1307c;
import I0.C1308d;
import I0.C1309e;
import Z0.h;
import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.google.firebase.components.ComponentRegistrar;
import java.util.Arrays;
import java.util.List;
import o.j;
import s0.C2264F;
import s0.C2268c;
import s0.r;

@Keep
public class TransportRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-transport";

    @NonNull
    public List<C2268c> getComponents() {
        Class<j> cls = j.class;
        Class<Context> cls2 = Context.class;
        return Arrays.asList(new C2268c[]{C2268c.c(cls).h(LIBRARY_NAME).b(r.k(cls2)).f(new C1307c()).d(), C2268c.e(C2264F.a(C1305a.class, cls)).b(r.k(cls2)).f(new C1308d()).d(), C2268c.e(C2264F.a(C1306b.class, cls)).b(r.k(cls2)).f(new C1309e()).d(), h.b(LIBRARY_NAME, "19.0.0")});
    }
}
