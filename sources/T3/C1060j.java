package t3;

import R2.s;
import V2.d;
import V2.g;
import androidx.concurrent.futures.a;
import d3.l;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.jvm.internal.e;
import kotlin.jvm.internal.m;
import o3.B;
import o3.C0970c0;
import o3.C0989m;
import o3.C0991n;
import o3.E;
import o3.G;
import o3.N;
import o3.S0;
import o3.W;

/* renamed from: t3.j  reason: case insensitive filesystem */
public final class C1060j extends W implements e, d {

    /* renamed from: h  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f4495h = AtomicReferenceFieldUpdater.newUpdater(C1060j.class, Object.class, "_reusableCancellableContinuation");
    private volatile Object _reusableCancellableContinuation;

    /* renamed from: d  reason: collision with root package name */
    public final G f4496d;

    /* renamed from: e  reason: collision with root package name */
    public final d f4497e;

    /* renamed from: f  reason: collision with root package name */
    public Object f4498f = C1061k.f4500a;

    /* renamed from: g  reason: collision with root package name */
    public final Object f4499g = J.b(getContext());

    public C1060j(G g4, d dVar) {
        super(-1);
        this.f4496d = g4;
        this.f4497e = dVar;
    }

    private final C0991n n() {
        Object obj = f4495h.get(this);
        if (obj instanceof C0991n) {
            return (C0991n) obj;
        }
        return null;
    }

    public void a(Object obj, Throwable th) {
        if (obj instanceof B) {
            ((B) obj).f3639b.invoke(th);
        }
    }

    public e getCallerFrame() {
        d dVar = this.f4497e;
        if (dVar instanceof e) {
            return (e) dVar;
        }
        return null;
    }

    public g getContext() {
        return this.f4497e.getContext();
    }

    public Object j() {
        Object obj = this.f4498f;
        this.f4498f = C1061k.f4500a;
        return obj;
    }

    public final void k() {
        do {
        } while (f4495h.get(this) == C1061k.f4501b);
    }

    public final C0991n l() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4495h;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                f4495h.set(this, C1061k.f4501b);
                return null;
            } else if (obj instanceof C0991n) {
                if (a.a(f4495h, this, obj, C1061k.f4501b)) {
                    return (C0991n) obj;
                }
            } else if (obj != C1061k.f4501b && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
    }

    public final void m(g gVar, Object obj) {
        this.f4498f = obj;
        this.f3680c = 1;
        this.f4496d.dispatchYield(gVar, this);
    }

    public final boolean o() {
        if (f4495h.get(this) != null) {
            return true;
        }
        return false;
    }

    public final boolean p(Throwable th) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4495h;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            F f4 = C1061k.f4501b;
            if (m.a(obj, f4)) {
                if (a.a(f4495h, this, f4, th)) {
                    return true;
                }
            } else if (obj instanceof Throwable) {
                return true;
            } else {
                if (a.a(f4495h, this, obj, (Object) null)) {
                    return false;
                }
            }
        }
    }

    public final void r() {
        k();
        C0991n n4 = n();
        if (n4 != null) {
            n4.p();
        }
    }

    public void resumeWith(Object obj) {
        g context;
        Object c5;
        g context2 = this.f4497e.getContext();
        Object d5 = E.d(obj, (l) null, 1, (Object) null);
        if (this.f4496d.isDispatchNeeded(context2)) {
            this.f4498f = d5;
            this.f3680c = 0;
            this.f4496d.dispatch(context2, this);
            return;
        }
        C0970c0 b5 = S0.f3672a.b();
        if (b5.L()) {
            this.f4498f = d5;
            this.f3680c = 0;
            b5.H(this);
            return;
        }
        b5.J(true);
        try {
            context = getContext();
            c5 = J.c(context, this.f4499g);
            this.f4497e.resumeWith(obj);
            s sVar = s.f8222a;
            J.a(context, c5);
            do {
            } while (b5.O());
        } catch (Throwable th) {
            b5.D(true);
            throw th;
        }
        b5.D(true);
    }

    public final Throwable s(C0989m mVar) {
        F f4;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4495h;
        do {
            Object obj = atomicReferenceFieldUpdater.get(this);
            f4 = C1061k.f4501b;
            if (obj != f4) {
                if (!(obj instanceof Throwable)) {
                    throw new IllegalStateException(("Inconsistent state " + obj).toString());
                } else if (a.a(f4495h, this, obj, (Object) null)) {
                    return (Throwable) obj;
                } else {
                    throw new IllegalArgumentException("Failed requirement.");
                }
            }
        } while (!a.a(f4495h, this, f4, mVar));
        return null;
    }

    public String toString() {
        return "DispatchedContinuation[" + this.f4496d + ", " + N.c(this.f4497e) + ']';
    }

    public d f() {
        return this;
    }
}
