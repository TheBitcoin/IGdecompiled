package V3;

import A2.a;
import A3.k;
import E2.t;
import java.util.List;
import kotlin.jvm.internal.m;

/* renamed from: V3.f  reason: case insensitive filesystem */
public final class C2595f {

    /* renamed from: a  reason: collision with root package name */
    public final String f24130a;

    /* renamed from: b  reason: collision with root package name */
    public final String f24131b;

    /* renamed from: c  reason: collision with root package name */
    public final int f24132c;

    /* renamed from: d  reason: collision with root package name */
    public final String f24133d;

    /* renamed from: e  reason: collision with root package name */
    public final List f24134e;

    public C2595f(String str, String str2, int i4, String str3, List list) {
        m.e(str, "identifier");
        m.e(str2, "type");
        m.e(str3, "domain");
        m.e(list, "purposes");
        this.f24130a = str;
        this.f24131b = str2;
        this.f24132c = i4;
        this.f24133d = str3;
        this.f24134e = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2595f)) {
            return false;
        }
        C2595f fVar = (C2595f) obj;
        if (m.a(this.f24130a, fVar.f24130a) && m.a(this.f24131b, fVar.f24131b) && this.f24132c == fVar.f24132c && m.a(this.f24133d, fVar.f24133d) && m.a(this.f24134e, fVar.f24134e)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f24134e.hashCode() + t.a(this.f24133d, k.a(this.f24132c, t.a(this.f24131b, this.f24130a.hashCode() * 31, 31), 31), 31);
    }

    public String toString() {
        StringBuilder a5 = a.a("Disclosure(identifier=");
        a5.append(this.f24130a);
        a5.append(", type=");
        a5.append(this.f24131b);
        a5.append(", maxAgeSeconds=");
        a5.append(this.f24132c);
        a5.append(", domain=");
        a5.append(this.f24133d);
        a5.append(", purposes=");
        a5.append(this.f24134e);
        a5.append(')');
        return a5.toString();
    }
}
