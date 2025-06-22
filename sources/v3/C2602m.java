package V3;

import A2.a;
import kotlin.jvm.internal.m;

/* renamed from: V3.m  reason: case insensitive filesystem */
public final class C2602m {

    /* renamed from: a  reason: collision with root package name */
    public final String f24207a;

    /* renamed from: b  reason: collision with root package name */
    public final String f24208b;

    public C2602m(String str, String str2) {
        m.e(str, "disclosureLabel");
        m.e(str2, "backLabel");
        this.f24207a = str;
        this.f24208b = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2602m)) {
            return false;
        }
        C2602m mVar = (C2602m) obj;
        if (m.a(this.f24207a, mVar.f24207a) && m.a(this.f24208b, mVar.f24208b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f24208b.hashCode() + (this.f24207a.hashCode() * 31);
    }

    public String toString() {
        StringBuilder a5 = a.a("PartnersDisclosureLabels(disclosureLabel=");
        a5.append(this.f24207a);
        a5.append(", backLabel=");
        a5.append(this.f24208b);
        a5.append(')');
        return a5.toString();
    }
}
