package N3;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.m;

/* renamed from: N3.n  reason: case insensitive filesystem */
public class C2523n extends a0 {

    /* renamed from: f  reason: collision with root package name */
    private a0 f23733f;

    public C2523n(a0 a0Var) {
        m.e(a0Var, "delegate");
        this.f23733f = a0Var;
    }

    public a0 a() {
        return this.f23733f.a();
    }

    public a0 b() {
        return this.f23733f.b();
    }

    public long c() {
        return this.f23733f.c();
    }

    public a0 d(long j4) {
        return this.f23733f.d(j4);
    }

    public boolean e() {
        return this.f23733f.e();
    }

    public void f() {
        this.f23733f.f();
    }

    public a0 g(long j4, TimeUnit timeUnit) {
        m.e(timeUnit, "unit");
        return this.f23733f.g(j4, timeUnit);
    }

    public final a0 i() {
        return this.f23733f;
    }

    public final C2523n j(a0 a0Var) {
        m.e(a0Var, "delegate");
        this.f23733f = a0Var;
        return this;
    }
}
