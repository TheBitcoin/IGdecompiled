package g2;

import android.content.Context;
import b2.u;
import com.uptodown.activities.preferences.a;
import kotlin.jvm.internal.m;
import u2.C2313C;

public final class P {

    /* renamed from: a  reason: collision with root package name */
    private final String f20443a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f20444b;

    /* renamed from: c  reason: collision with root package name */
    private final String f20445c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f20446d;

    /* renamed from: e  reason: collision with root package name */
    private final String f20447e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f20448f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f20449g;

    /* renamed from: h  reason: collision with root package name */
    private int f20450h = 671;

    public P(Context context) {
        m.e(context, "context");
        a.C0236a aVar = a.f18818a;
        this.f20443a = aVar.p(context);
        this.f20444b = C2313C.f21882a.a(context);
        this.f20445c = aVar.z(context);
        this.f20446d = aVar.Z(context);
        this.f20447e = aVar.m(context);
        this.f20448f = aVar.P(context);
        this.f20449g = aVar.W(context);
    }

    public final boolean a(String str, String str2) {
        if ((str != null || str2 != null) && (str == null || !m3.m.p(str, str2, true))) {
            return false;
        }
        return true;
    }

    public final boolean b(P p4) {
        if (p4 == null || !a(p4.f20443a, this.f20443a) || p4.f20444b != this.f20444b || p4.f20446d != this.f20446d || !m3.m.p(p4.f20445c, this.f20445c, true) || !m.a(p4.f20447e, this.f20447e) || p4.f20448f != this.f20448f || p4.f20449g != this.f20449g) {
            return false;
        }
        return true;
    }

    public final String c() {
        return this.f20445c;
    }

    public final String d() {
        return this.f20443a;
    }

    public final int e() {
        return this.f20450h;
    }

    public final boolean f() {
        return this.f20448f;
    }

    public final String g() {
        return this.f20447e;
    }

    public final boolean h() {
        return this.f20449g;
    }

    public final boolean i() {
        return this.f20444b;
    }

    public final boolean j() {
        return this.f20446d;
    }

    public final void k(Context context, r rVar) {
        m.e(context, "context");
        m.e(rVar, "device");
        new u(context, rVar, this);
    }
}
