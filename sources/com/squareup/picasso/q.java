package com.squareup.picasso;

import D3.C2450A;
import D3.C2456d;
import D3.x;
import D3.z;
import H1.c;
import N3.Z;
import android.net.NetworkInfo;
import com.squareup.picasso.s;
import com.squareup.picasso.x;
import java.io.IOException;

class q extends x {

    /* renamed from: a  reason: collision with root package name */
    private final c f17294a;

    /* renamed from: b  reason: collision with root package name */
    private final z f17295b;

    static class a extends IOException {
        a(String str) {
            super(str);
        }
    }

    static final class b extends IOException {

        /* renamed from: a  reason: collision with root package name */
        final int f17296a;

        /* renamed from: b  reason: collision with root package name */
        final int f17297b;

        b(int i4, int i5) {
            super("HTTP " + i4);
            this.f17296a = i4;
            this.f17297b = i5;
        }
    }

    q(c cVar, z zVar) {
        this.f17294a = cVar;
        this.f17295b = zVar;
    }

    private static x j(v vVar, int i4) {
        C2456d dVar;
        if (i4 == 0) {
            dVar = null;
        } else if (p.a(i4)) {
            dVar = C2456d.f22917o;
        } else {
            C2456d.a aVar = new C2456d.a();
            if (!p.b(i4)) {
                aVar.c();
            }
            if (!p.c(i4)) {
                aVar.d();
            }
            dVar = aVar.a();
        }
        x.a h4 = new x.a().h(vVar.f17353d.toString());
        if (dVar != null) {
            h4.b(dVar);
        }
        return h4.a();
    }

    public boolean c(v vVar) {
        String scheme = vVar.f17353d.getScheme();
        if ("http".equals(scheme) || "https".equals(scheme)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return 2;
    }

    public x.a f(v vVar, int i4) {
        s.e eVar;
        z a5 = this.f17294a.a(j(vVar, i4));
        C2450A a6 = a5.a();
        if (a5.p()) {
            if (a5.g() == null) {
                eVar = s.e.NETWORK;
            } else {
                eVar = s.e.DISK;
            }
            if (eVar == s.e.DISK && a6.a() == 0) {
                a6.close();
                throw new a("Received response with 0 content-length header.");
            }
            if (eVar == s.e.NETWORK && a6.a() > 0) {
                this.f17295b.f(a6.a());
            }
            return new x.a((Z) a6.i(), eVar);
        }
        a6.close();
        throw new b(a5.i(), vVar.f17352c);
    }

    /* access modifiers changed from: package-private */
    public boolean h(boolean z4, NetworkInfo networkInfo) {
        if (networkInfo == null || networkInfo.isConnected()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean i() {
        return true;
    }
}
