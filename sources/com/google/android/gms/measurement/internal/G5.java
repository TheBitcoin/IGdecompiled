package com.google.android.gms.measurement.internal;

import R.d;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.T1;
import com.google.android.gms.internal.measurement.r7;
import f0.C;
import java.util.HashMap;

public final class G5 extends F5 {
    G5(H5 h5) {
        super(h5);
    }

    private final String t(String str) {
        String R4 = o().R(str);
        if (TextUtils.isEmpty(R4)) {
            return (String) G.f2503r.a((Object) null);
        }
        Uri parse = Uri.parse((String) G.f2503r.a((Object) null));
        Uri.Builder buildUpon = parse.buildUpon();
        String authority = parse.getAuthority();
        buildUpon.authority(R4 + "." + authority);
        return buildUpon.build().toString();
    }

    public final /* bridge */ /* synthetic */ Context A() {
        return super.A();
    }

    public final /* bridge */ /* synthetic */ d B() {
        return super.B();
    }

    public final /* bridge */ /* synthetic */ C0741c C() {
        return super.C();
    }

    public final /* bridge */ /* synthetic */ C0821n2 a() {
        return super.a();
    }

    public final /* bridge */ /* synthetic */ C0769g b() {
        return super.b();
    }

    public final /* bridge */ /* synthetic */ C0887x c() {
        return super.c();
    }

    public final /* bridge */ /* synthetic */ C0779h2 d() {
        return super.d();
    }

    public final /* bridge */ /* synthetic */ C0904z2 e() {
        return super.e();
    }

    public final /* bridge */ /* synthetic */ P2 f() {
        return super.f();
    }

    public final /* bridge */ /* synthetic */ d6 g() {
        return super.g();
    }

    public final /* bridge */ /* synthetic */ void i() {
        super.i();
    }

    public final /* bridge */ /* synthetic */ void j() {
        super.j();
    }

    public final /* bridge */ /* synthetic */ void k() {
        super.k();
    }

    public final /* bridge */ /* synthetic */ Z5 l() {
        return super.l();
    }

    public final /* bridge */ /* synthetic */ h6 m() {
        return super.m();
    }

    public final /* bridge */ /* synthetic */ C0797k n() {
        return super.n();
    }

    public final /* bridge */ /* synthetic */ I2 o() {
        return super.o();
    }

    public final /* bridge */ /* synthetic */ C0796j5 p() {
        return super.p();
    }

    public final /* bridge */ /* synthetic */ G5 q() {
        return super.q();
    }

    public final I5 r(String str) {
        C0744c2 M02;
        String str2;
        if (r7.a() && b().q(G.f2518y0)) {
            g();
            if (d6.H0(str)) {
                a().K().a("sgtm feature flag enabled.");
                C0744c2 M03 = n().M0(str);
                if (M03 == null) {
                    return new I5(t(str), C.GOOGLE_ANALYTICS);
                }
                String m4 = M03.m();
                T1 L4 = o().L(str);
                if (L4 == null || (M02 = n().M0(str)) == null || ((!L4.Y() || L4.P().j() != 100) && !g().E0(str, M02.v()) && (!b().q(G.f2405A0) ? TextUtils.isEmpty(m4) || m4.hashCode() % 100 >= L4.P().j() : TextUtils.isEmpty(m4) || Math.abs(m4.hashCode() % 100) >= L4.P().j()))) {
                    return new I5(t(str), C.GOOGLE_ANALYTICS);
                }
                I5 i5 = null;
                if (M03.C()) {
                    a().K().a("sgtm upload enabled in manifest.");
                    T1 L5 = o().L(M03.l());
                    if (L5 != null && L5.Y()) {
                        String J4 = L5.P().J();
                        if (!TextUtils.isEmpty(J4)) {
                            String I4 = L5.P().I();
                            C0835p2 K4 = a().K();
                            if (TextUtils.isEmpty(I4)) {
                                str2 = "Y";
                            } else {
                                str2 = "N";
                            }
                            K4.c("sgtm configured with upload_url, server_info", J4, str2);
                            if (TextUtils.isEmpty(I4)) {
                                i5 = new I5(J4, C.SGTM);
                            } else {
                                HashMap hashMap = new HashMap();
                                hashMap.put("x-sgtm-server-info", I4);
                                if (!TextUtils.isEmpty(M03.v())) {
                                    hashMap.put("x-gtm-server-preview", M03.v());
                                }
                                i5 = new I5(J4, hashMap, C.SGTM);
                            }
                        }
                    }
                }
                if (i5 != null) {
                    return i5;
                }
            }
        }
        return new I5(t(str), C.GOOGLE_ANALYTICS);
    }

    public final String s(C0744c2 c2Var) {
        Uri.Builder builder = new Uri.Builder();
        String q4 = c2Var.q();
        if (TextUtils.isEmpty(q4)) {
            q4 = c2Var.j();
        }
        Uri.Builder encodedAuthority = builder.scheme((String) G.f2471f.a((Object) null)).encodedAuthority((String) G.f2474g.a((Object) null));
        encodedAuthority.path("config/app/" + q4).appendQueryParameter("platform", "android").appendQueryParameter("gmp_version", "106000").appendQueryParameter("runtime_version", "0");
        return builder.build().toString();
    }
}
