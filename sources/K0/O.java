package k0;

import M.C0335p;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

final class O extends C0937l {

    /* renamed from: a  reason: collision with root package name */
    private final Object f3486a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final K f3487b = new K();

    /* renamed from: c  reason: collision with root package name */
    private boolean f3488c;

    /* renamed from: d  reason: collision with root package name */
    private volatile boolean f3489d;

    /* renamed from: e  reason: collision with root package name */
    private Object f3490e;

    /* renamed from: f  reason: collision with root package name */
    private Exception f3491f;

    O() {
    }

    private final void v() {
        C0335p.p(this.f3488c, "Task is not yet complete");
    }

    private final void w() {
        if (this.f3489d) {
            throw new CancellationException("Task is already canceled.");
        }
    }

    private final void x() {
        if (this.f3488c) {
            throw C0929d.a(this);
        }
    }

    private final void y() {
        synchronized (this.f3486a) {
            try {
                if (this.f3488c) {
                    this.f3487b.b(this);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public final C0937l a(Executor executor, C0930e eVar) {
        this.f3487b.a(new A(executor, eVar));
        y();
        return this;
    }

    public final C0937l b(Executor executor, C0931f fVar) {
        this.f3487b.a(new C(executor, fVar));
        y();
        return this;
    }

    public final C0937l c(C0931f fVar) {
        this.f3487b.a(new C(C0939n.f3496a, fVar));
        y();
        return this;
    }

    public final C0937l d(Executor executor, C0932g gVar) {
        this.f3487b.a(new E(executor, gVar));
        y();
        return this;
    }

    public final C0937l e(C0932g gVar) {
        d(C0939n.f3496a, gVar);
        return this;
    }

    public final C0937l f(Executor executor, C0933h hVar) {
        this.f3487b.a(new G(executor, hVar));
        y();
        return this;
    }

    public final C0937l g(Executor executor, C0928c cVar) {
        O o4 = new O();
        this.f3487b.a(new w(executor, cVar, o4));
        y();
        return o4;
    }

    public final C0937l h(Executor executor, C0928c cVar) {
        O o4 = new O();
        this.f3487b.a(new y(executor, cVar, o4));
        y();
        return o4;
    }

    public final Exception i() {
        Exception exc;
        synchronized (this.f3486a) {
            exc = this.f3491f;
        }
        return exc;
    }

    public final Object j() {
        Object obj;
        synchronized (this.f3486a) {
            try {
                v();
                w();
                Exception exc = this.f3491f;
                if (exc == null) {
                    obj = this.f3490e;
                } else {
                    throw new C0935j(exc);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    public final Object k(Class cls) {
        Object obj;
        synchronized (this.f3486a) {
            try {
                v();
                w();
                if (!cls.isInstance(this.f3491f)) {
                    Exception exc = this.f3491f;
                    if (exc == null) {
                        obj = this.f3490e;
                    } else {
                        throw new C0935j(exc);
                    }
                } else {
                    throw ((Throwable) cls.cast(this.f3491f));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    public final boolean l() {
        return this.f3489d;
    }

    public final boolean m() {
        boolean z4;
        synchronized (this.f3486a) {
            z4 = this.f3488c;
        }
        return z4;
    }

    public final boolean n() {
        boolean z4;
        synchronized (this.f3486a) {
            try {
                z4 = false;
                if (this.f3488c && !this.f3489d && this.f3491f == null) {
                    z4 = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z4;
    }

    public final C0937l o(Executor executor, C0936k kVar) {
        O o4 = new O();
        this.f3487b.a(new I(executor, kVar, o4));
        y();
        return o4;
    }

    public final C0937l p(C0936k kVar) {
        Executor executor = C0939n.f3496a;
        O o4 = new O();
        this.f3487b.a(new I(executor, kVar, o4));
        y();
        return o4;
    }

    public final void q(Exception exc) {
        C0335p.m(exc, "Exception must not be null");
        synchronized (this.f3486a) {
            x();
            this.f3488c = true;
            this.f3491f = exc;
        }
        this.f3487b.b(this);
    }

    public final void r(Object obj) {
        synchronized (this.f3486a) {
            x();
            this.f3488c = true;
            this.f3490e = obj;
        }
        this.f3487b.b(this);
    }

    public final boolean s() {
        synchronized (this.f3486a) {
            try {
                if (this.f3488c) {
                    return false;
                }
                this.f3488c = true;
                this.f3489d = true;
                this.f3487b.b(this);
                return true;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public final boolean t(Exception exc) {
        C0335p.m(exc, "Exception must not be null");
        synchronized (this.f3486a) {
            try {
                if (this.f3488c) {
                    return false;
                }
                this.f3488c = true;
                this.f3491f = exc;
                this.f3487b.b(this);
                return true;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public final boolean u(Object obj) {
        synchronized (this.f3486a) {
            try {
                if (this.f3488c) {
                    return false;
                }
                this.f3488c = true;
                this.f3490e = obj;
                this.f3487b.b(this);
                return true;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }
}
