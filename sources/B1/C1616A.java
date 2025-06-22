package b1;

import kotlin.jvm.internal.m;

/* renamed from: b1.A  reason: case insensitive filesystem */
public final class C1616A {

    /* renamed from: a  reason: collision with root package name */
    private final C1627j f8918a;

    /* renamed from: b  reason: collision with root package name */
    private final D f8919b;

    /* renamed from: c  reason: collision with root package name */
    private final C1619b f8920c;

    public C1616A(C1627j jVar, D d5, C1619b bVar) {
        m.e(jVar, "eventType");
        m.e(d5, "sessionData");
        m.e(bVar, "applicationInfo");
        this.f8918a = jVar;
        this.f8919b = d5;
        this.f8920c = bVar;
    }

    public final C1619b a() {
        return this.f8920c;
    }

    public final C1627j b() {
        return this.f8918a;
    }

    public final D c() {
        return this.f8919b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1616A)) {
            return false;
        }
        C1616A a5 = (C1616A) obj;
        if (this.f8918a == a5.f8918a && m.a(this.f8919b, a5.f8919b) && m.a(this.f8920c, a5.f8920c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.f8918a.hashCode() * 31) + this.f8919b.hashCode()) * 31) + this.f8920c.hashCode();
    }

    public String toString() {
        return "SessionEvent(eventType=" + this.f8918a + ", sessionData=" + this.f8919b + ", applicationInfo=" + this.f8920c + ')';
    }
}
