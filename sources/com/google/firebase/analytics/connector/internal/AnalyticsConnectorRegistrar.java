package com.google.firebase.analytics.connector.internal;

import O0.d;
import Z0.h;
import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.google.firebase.components.ComponentRegistrar;
import java.util.Arrays;
import java.util.List;
import p0.C2194f;
import q0.C2204a;
import s0.C2268c;
import s0.r;

@Keep
public class AnalyticsConnectorRegistrar implements ComponentRegistrar {
    @SuppressLint({"MissingPermission"})
    @Keep
    @NonNull
    public List<C2268c> getComponents() {
        return Arrays.asList(new C2268c[]{C2268c.c(C2204a.class).b(r.k(C2194f.class)).b(r.k(Context.class)).b(r.k(d.class)).f(new b()).e().d(), h.b("fire-analytics", "22.1.2")});
    }
}
