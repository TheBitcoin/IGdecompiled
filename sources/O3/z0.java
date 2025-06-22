package o3;

import kotlin.jvm.internal.m;

public abstract class z0 extends C implements Z, C0992n0 {

    /* renamed from: d  reason: collision with root package name */
    public A0 f3736d;

    public F0 b() {
        return null;
    }

    public void dispose() {
        s().z0(this);
    }

    public boolean isActive() {
        return true;
    }

    public final A0 s() {
        A0 a02 = this.f3736d;
        if (a02 != null) {
            return a02;
        }
        m.u("job");
        return null;
    }

    public final void t(A0 a02) {
        this.f3736d = a02;
    }

    public String toString() {
        return N.a(this) + '@' + N.b(this) + "[job@" + N.b(s()) + ']';
    }
}
