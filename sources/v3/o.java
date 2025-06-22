package V3;

import A2.a;
import kotlin.jvm.internal.m;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    public final String f24219a;

    /* renamed from: b  reason: collision with root package name */
    public final String f24220b;

    public o(String str, String str2) {
        m.e(str, "label");
        m.e(str2, "link");
        this.f24219a = str;
        this.f24220b = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        if (m.a(this.f24219a, oVar.f24219a) && m.a(this.f24220b, oVar.f24220b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f24220b.hashCode() + (this.f24219a.hashCode() * 31);
    }

    public String toString() {
        StringBuilder a5 = a.a("PublisherCustomLink(label=");
        a5.append(this.f24219a);
        a5.append(", link=");
        a5.append(this.f24220b);
        a5.append(')');
        return a5.toString();
    }
}
