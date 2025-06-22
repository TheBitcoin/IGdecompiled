package b1;

import kotlin.jvm.internal.m;

/* renamed from: b1.f  reason: case insensitive filesystem */
public final class C1623f {

    /* renamed from: a  reason: collision with root package name */
    private final C1621d f9025a;

    /* renamed from: b  reason: collision with root package name */
    private final C1621d f9026b;

    /* renamed from: c  reason: collision with root package name */
    private final double f9027c;

    public C1623f(C1621d dVar, C1621d dVar2, double d5) {
        m.e(dVar, "performance");
        m.e(dVar2, "crashlytics");
        this.f9025a = dVar;
        this.f9026b = dVar2;
        this.f9027c = d5;
    }

    public final C1621d a() {
        return this.f9026b;
    }

    public final C1621d b() {
        return this.f9025a;
    }

    public final double c() {
        return this.f9027c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1623f)) {
            return false;
        }
        C1623f fVar = (C1623f) obj;
        if (this.f9025a == fVar.f9025a && this.f9026b == fVar.f9026b && Double.compare(this.f9027c, fVar.f9027c) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.f9025a.hashCode() * 31) + this.f9026b.hashCode()) * 31) + Double.doubleToLongBits(this.f9027c);
    }

    public String toString() {
        return "DataCollectionStatus(performance=" + this.f9025a + ", crashlytics=" + this.f9026b + ", sessionSamplingRate=" + this.f9027c + ')';
    }
}
