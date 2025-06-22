package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

public final class C {

    /* renamed from: a  reason: collision with root package name */
    private final C0705x1 f1411a;

    /* renamed from: b  reason: collision with root package name */
    private Z2 f1412b;

    /* renamed from: c  reason: collision with root package name */
    C0533d f1413c;

    /* renamed from: d  reason: collision with root package name */
    private final C0515b f1414d;

    public C() {
        this(new C0705x1());
    }

    public final C0533d a() {
        return this.f1413c;
    }

    public final void b(B2 b22) {
        C0623n nVar;
        try {
            this.f1412b = this.f1411a.f2248b.d();
            if (!(this.f1411a.a(this.f1412b, (C2[]) b22.I().toArray(new C2[0])) instanceof C0605l)) {
                for (A2 a22 : b22.G().I()) {
                    List I4 = a22.I();
                    String H4 = a22.H();
                    Iterator it = I4.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            C0663s a5 = this.f1411a.a(this.f1412b, (C2) it.next());
                            if (a5 instanceof r) {
                                Z2 z22 = this.f1412b;
                                if (!z22.g(H4)) {
                                    nVar = null;
                                } else {
                                    C0663s c5 = z22.c(H4);
                                    if (c5 instanceof C0623n) {
                                        nVar = (C0623n) c5;
                                    } else {
                                        throw new IllegalStateException("Invalid function name: " + H4);
                                    }
                                }
                                if (nVar != null) {
                                    nVar.a(this.f1412b, Collections.singletonList(a5));
                                } else {
                                    throw new IllegalStateException("Rule function is undefined: " + H4);
                                }
                            } else {
                                throw new IllegalArgumentException("Invalid rule definition");
                            }
                        }
                    }
                }
                return;
            }
            throw new IllegalStateException("Program loading failed");
        } catch (Throwable th) {
            throw new C0543e0(th);
        }
    }

    public final void c(String str, Callable callable) {
        this.f1411a.b(str, callable);
    }

    public final boolean d(C0542e eVar) {
        try {
            this.f1413c.b(eVar);
            this.f1411a.f2249c.h("runtime.counter", new C0596k(Double.valueOf(0.0d)));
            this.f1414d.b(this.f1412b.d(), this.f1413c);
            if (g() || f()) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            throw new C0543e0(th);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ C0623n e() {
        return new K7(this.f1414d);
    }

    public final boolean f() {
        if (!this.f1413c.f().isEmpty()) {
            return true;
        }
        return false;
    }

    public final boolean g() {
        if (!this.f1413c.d().equals(this.f1413c.a())) {
            return true;
        }
        return false;
    }

    private C(C0705x1 x1Var) {
        this.f1411a = x1Var;
        this.f1412b = x1Var.f2248b.d();
        this.f1413c = new C0533d();
        this.f1414d = new C0515b();
        x1Var.b("internal.registerCallback", new C0506a(this));
        x1Var.b("internal.eventLogger", new F0(this));
    }
}
