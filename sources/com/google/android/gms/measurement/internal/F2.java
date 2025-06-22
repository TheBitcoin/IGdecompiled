package com.google.android.gms.measurement.internal;

import Q.b;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.C0534d0;
import com.google.android.gms.internal.measurement.R6;

final class F2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ C0534d0 f2373a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ ServiceConnection f2374b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ G2 f2375c;

    F2(G2 g22, C0534d0 d0Var, ServiceConnection serviceConnection) {
        this.f2373a = d0Var;
        this.f2374b = serviceConnection;
        this.f2375c = g22;
    }

    public final void run() {
        boolean z4;
        G2 g22 = this.f2375c;
        E2 e22 = g22.f2522b;
        String a5 = g22.f2521a;
        C0534d0 d0Var = this.f2373a;
        ServiceConnection serviceConnection = this.f2374b;
        Bundle a6 = e22.a(a5, d0Var);
        e22.f2370a.f().k();
        e22.f2370a.Q();
        if (a6 != null) {
            long j4 = a6.getLong("install_begin_timestamp_seconds", 0) * 1000;
            if (j4 == 0) {
                e22.f2370a.a().L().a("Service response is missing Install Referrer install timestamp");
            } else {
                String string = a6.getString("install_referrer");
                if (string == null || string.isEmpty()) {
                    e22.f2370a.a().G().a("No referrer defined in Install Referrer response");
                } else {
                    e22.f2370a.a().K().b("InstallReferrer API result", string);
                    if (!R6.a() || !e22.f2370a.w().q(G.f2447V0)) {
                        z4 = false;
                    } else {
                        z4 = true;
                    }
                    d6 L4 = e22.f2370a.L();
                    Bundle z5 = L4.z(Uri.parse("?" + string), z4);
                    if (z5 == null) {
                        e22.f2370a.a().G().a("No campaign params defined in Install Referrer result");
                    } else {
                        if (!z4) {
                            String string2 = z5.getString("medium");
                            if (string2 != null && !"(not set)".equalsIgnoreCase(string2) && !"organic".equalsIgnoreCase(string2)) {
                                long j5 = a6.getLong("referrer_click_timestamp_seconds", 0) * 1000;
                                if (j5 == 0) {
                                    e22.f2370a.a().G().a("Install Referrer is missing click timestamp for ad campaign");
                                } else {
                                    z5.putLong("click_timestamp", j5);
                                }
                            }
                        } else if (z5.containsKey("gclid") || z5.containsKey("gbraid")) {
                            long j6 = a6.getLong("referrer_click_timestamp_server_seconds", 0) * 1000;
                            if (j6 > 0) {
                                z5.putLong("click_timestamp", j6);
                            }
                        }
                        if (j4 == e22.f2370a.F().f3323h.a()) {
                            e22.f2370a.a().K().a("Logging Install Referrer campaign from module while it may have already been logged.");
                        }
                        if (e22.f2370a.m()) {
                            e22.f2370a.F().f3323h.b(j4);
                            e22.f2370a.a().K().b("Logging Install Referrer campaign from gmscore with ", "referrer API v2");
                            z5.putString("_cis", "referrer API v2");
                            e22.f2370a.H().i0("auto", "_cmp", z5, a5);
                        }
                    }
                }
            }
        }
        if (serviceConnection != null) {
            b.b().c(e22.f2370a.A(), serviceConnection);
        }
    }
}
