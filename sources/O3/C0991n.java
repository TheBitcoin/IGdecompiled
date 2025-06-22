package o3;

import V2.d;
import V2.g;
import W2.b;
import androidx.concurrent.futures.a;
import b.l;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.jvm.internal.e;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import o3.C1001s0;
import t3.C;
import t3.C1060j;
import t3.F;

/* renamed from: o3.n  reason: case insensitive filesystem */
public class C0991n extends W implements C0989m, e, W0 {

    /* renamed from: f  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f3713f;

    /* renamed from: g  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f3714g;

    /* renamed from: h  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f3715h;
    private volatile int _decisionAndIndex = 536870911;
    private volatile Object _parentHandle;
    private volatile Object _state = C0971d.f3693a;

    /* renamed from: d  reason: collision with root package name */
    private final d f3716d;

    /* renamed from: e  reason: collision with root package name */
    private final g f3717e;

    static {
        Class<C0991n> cls = C0991n.class;
        f3713f = AtomicIntegerFieldUpdater.newUpdater(cls, "_decisionAndIndex");
        Class<Object> cls2 = Object.class;
        f3714g = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_state");
        f3715h = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_parentHandle");
    }

    public C0991n(d dVar, int i4) {
        super(i4);
        this.f3716d = dVar;
        this.f3717e = dVar.getContext();
    }

    private final Z A() {
        C1001s0 s0Var = (C1001s0) getContext().get(C1001s0.f3726k0);
        if (s0Var == null) {
            return null;
        }
        Z d5 = C1001s0.a.d(s0Var, true, false, new r(this), 2, (Object) null);
        a.a(f3715h, this, (Object) null, d5);
        return d5;
    }

    private final void B(Object obj) {
        boolean z4;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3714g;
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (!(obj2 instanceof C0971d)) {
                if (obj2 instanceof C0985k) {
                    z4 = true;
                } else {
                    z4 = obj2 instanceof C;
                }
                if (z4) {
                    G(obj, obj2);
                } else if (obj2 instanceof A) {
                    A a5 = (A) obj2;
                    if (!a5.b()) {
                        G(obj, obj2);
                    }
                    if (obj2 instanceof C0997q) {
                        boolean a6 = l.a(obj2);
                        Throwable th = null;
                        if (!a6) {
                            a5 = null;
                        }
                        if (a5 != null) {
                            th = a5.f3624a;
                        }
                        if (obj instanceof C0985k) {
                            l((C0985k) obj, th);
                            return;
                        }
                        m.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>");
                        n((C) obj, th);
                        return;
                    }
                    return;
                } else if (obj2 instanceof C1014z) {
                    C1014z zVar = (C1014z) obj2;
                    if (zVar.f3732b != null) {
                        G(obj, obj2);
                    }
                    if (!(obj instanceof C)) {
                        m.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                        C0985k kVar = (C0985k) obj;
                        if (zVar.c()) {
                            l(kVar, zVar.f3735e);
                            return;
                        }
                        if (a.a(f3714g, this, obj2, C1014z.b(zVar, (Object) null, kVar, (d3.l) null, (Object) null, (Throwable) null, 29, (Object) null))) {
                            return;
                        }
                    } else {
                        return;
                    }
                } else if (!(obj instanceof C)) {
                    m.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                    if (a.a(f3714g, this, obj2, new C1014z(obj2, (C0985k) obj, (d3.l) null, (Object) null, (Throwable) null, 28, (C2103g) null))) {
                        return;
                    }
                } else {
                    return;
                }
            } else if (a.a(f3714g, this, obj2, obj)) {
                return;
            }
        }
    }

    private final boolean E() {
        if (!X.c(this.f3680c)) {
            return false;
        }
        d dVar = this.f3716d;
        m.c(dVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        if (((C1060j) dVar).o()) {
            return true;
        }
        return false;
    }

    private final C0985k F(d3.l lVar) {
        if (lVar instanceof C0985k) {
            return (C0985k) lVar;
        }
        return new C0996p0(lVar);
    }

    private final void G(Object obj, Object obj2) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + obj + ", already has " + obj2).toString());
    }

    private final void L(Object obj, int i4, d3.l lVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3714g;
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof I0) {
                Object obj3 = obj;
                int i5 = i4;
                d3.l lVar2 = lVar;
                if (a.a(f3714g, this, obj2, N((I0) obj2, obj3, i5, lVar2, (Object) null))) {
                    r();
                    s(i5);
                    return;
                }
                obj = obj3;
                i4 = i5;
                lVar = lVar2;
            } else {
                Object obj4 = obj;
                d3.l lVar3 = lVar;
                if (obj2 instanceof C0997q) {
                    C0997q qVar = (C0997q) obj2;
                    if (qVar.c()) {
                        if (lVar3 != null) {
                            m(lVar3, qVar.f3624a);
                            return;
                        }
                        return;
                    }
                }
                k(obj4);
                throw new R2.d();
            }
        }
    }

    static /* synthetic */ void M(C0991n nVar, Object obj, int i4, d3.l lVar, int i5, Object obj2) {
        if (obj2 == null) {
            if ((i5 & 4) != 0) {
                lVar = null;
            }
            nVar.L(obj, i4, lVar);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
    }

    private final Object N(I0 i02, Object obj, int i4, d3.l lVar, Object obj2) {
        C0985k kVar;
        if (obj instanceof A) {
            return obj;
        }
        if ((!X.b(i4) && obj2 == null) || (lVar == null && !(i02 instanceof C0985k) && obj2 == null)) {
            return obj;
        }
        if (i02 instanceof C0985k) {
            kVar = (C0985k) i02;
        } else {
            kVar = null;
        }
        return new C1014z(obj, kVar, lVar, obj2, (Throwable) null, 16, (C2103g) null);
    }

    private final boolean O() {
        int i4;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f3713f;
        do {
            i4 = atomicIntegerFieldUpdater.get(this);
            int i5 = i4 >> 29;
            if (i5 != 0) {
                if (i5 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed");
            }
        } while (!f3713f.compareAndSet(this, i4, 1073741824 + (536870911 & i4)));
        return true;
    }

    private final F P(Object obj, Object obj2, d3.l lVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3714g;
        while (true) {
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (obj3 instanceof I0) {
                Object obj4 = obj;
                Object obj5 = obj2;
                d3.l lVar2 = lVar;
                if (a.a(f3714g, this, obj3, N((I0) obj3, obj4, this.f3680c, lVar2, obj5))) {
                    r();
                    return C0993o.f3718a;
                }
                obj = obj4;
                lVar = lVar2;
                obj2 = obj5;
            } else {
                Object obj6 = obj2;
                if (!(obj3 instanceof C1014z) || obj6 == null || ((C1014z) obj3).f3734d != obj6) {
                    return null;
                }
                return C0993o.f3718a;
            }
        }
    }

    private final boolean Q() {
        int i4;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f3713f;
        do {
            i4 = atomicIntegerFieldUpdater.get(this);
            int i5 = i4 >> 29;
            if (i5 != 0) {
                if (i5 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended");
            }
        } while (!f3713f.compareAndSet(this, i4, 536870912 + (536870911 & i4)));
        return true;
    }

    private final Void k(Object obj) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
    }

    private final void n(C c5, Throwable th) {
        int i4 = f3713f.get(this) & 536870911;
        if (i4 != 536870911) {
            try {
                c5.o(i4, th, getContext());
            } catch (Throwable th2) {
                g context = getContext();
                I.a(context, new D("Exception in invokeOnCancellation handler for " + this, th2));
            }
        } else {
            throw new IllegalStateException("The index for Segment.onCancellation(..) is broken");
        }
    }

    private final boolean o(Throwable th) {
        if (!E()) {
            return false;
        }
        d dVar = this.f3716d;
        m.c(dVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        return ((C1060j) dVar).p(th);
    }

    private final void r() {
        if (!E()) {
            p();
        }
    }

    private final void s(int i4) {
        if (!O()) {
            X.a(this, i4);
        }
    }

    private final Z u() {
        return (Z) f3715h.get(this);
    }

    private final String x() {
        Object w4 = w();
        if (w4 instanceof I0) {
            return "Active";
        }
        if (w4 instanceof C0997q) {
            return "Cancelled";
        }
        return "Completed";
    }

    public boolean C() {
        return !(w() instanceof I0);
    }

    public void D(Object obj) {
        s(this.f3680c);
    }

    /* access modifiers changed from: protected */
    public String H() {
        return "CancellableContinuation";
    }

    public final void I(Throwable th) {
        if (!o(th)) {
            y(th);
            r();
        }
    }

    public final void J() {
        C1060j jVar;
        Throwable s4;
        d dVar = this.f3716d;
        if (dVar instanceof C1060j) {
            jVar = (C1060j) dVar;
        } else {
            jVar = null;
        }
        if (jVar != null && (s4 = jVar.s(this)) != null) {
            p();
            y(s4);
        }
    }

    public final boolean K() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3714g;
        Object obj = atomicReferenceFieldUpdater.get(this);
        if (!(obj instanceof C1014z) || ((C1014z) obj).f3734d == null) {
            f3713f.set(this, 536870911);
            atomicReferenceFieldUpdater.set(this, C0971d.f3693a);
            return true;
        }
        p();
        return false;
    }

    public void a(Object obj, Throwable th) {
        Throwable th2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3714g;
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof I0) {
                throw new IllegalStateException("Not completed");
            } else if (!(obj2 instanceof A)) {
                if (obj2 instanceof C1014z) {
                    C1014z zVar = (C1014z) obj2;
                    if (!zVar.c()) {
                        Throwable th3 = th;
                        th2 = th3;
                        if (a.a(f3714g, this, obj2, C1014z.b(zVar, (Object) null, (C0985k) null, (d3.l) null, (Object) null, th3, 15, (Object) null))) {
                            zVar.d(this, th2);
                            return;
                        }
                    } else {
                        throw new IllegalStateException("Must be called at most once");
                    }
                } else {
                    th2 = th;
                    if (a.a(f3714g, this, obj2, new C1014z(obj2, (C0985k) null, (d3.l) null, (Object) null, th2, 14, (C2103g) null))) {
                        return;
                    }
                }
                th = th2;
            } else {
                return;
            }
        }
    }

    public Object b(Object obj, Object obj2, d3.l lVar) {
        return P(obj, obj2, lVar);
    }

    public void c(Object obj, d3.l lVar) {
        L(obj, this.f3680c, lVar);
    }

    public void d(C c5, int i4) {
        int i5;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f3713f;
        do {
            i5 = atomicIntegerFieldUpdater.get(this);
            if ((i5 & 536870911) != 536870911) {
                throw new IllegalStateException("invokeOnCancellation should be called at most once");
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i5, ((i5 >> 29) << 29) + i4));
        B(c5);
    }

    public void e(G g4, Object obj) {
        C1060j jVar;
        int i4;
        d dVar = this.f3716d;
        G g5 = null;
        if (dVar instanceof C1060j) {
            jVar = (C1060j) dVar;
        } else {
            jVar = null;
        }
        if (jVar != null) {
            g5 = jVar.f4496d;
        }
        if (g5 == g4) {
            i4 = 4;
        } else {
            i4 = this.f3680c;
        }
        M(this, obj, i4, (d3.l) null, 4, (Object) null);
    }

    public final d f() {
        return this.f3716d;
    }

    public Throwable g(Object obj) {
        Throwable g4 = super.g(obj);
        if (g4 != null) {
            return g4;
        }
        return null;
    }

    public e getCallerFrame() {
        d dVar = this.f3716d;
        if (dVar instanceof e) {
            return (e) dVar;
        }
        return null;
    }

    public g getContext() {
        return this.f3717e;
    }

    public Object h(Object obj) {
        if (obj instanceof C1014z) {
            return ((C1014z) obj).f3731a;
        }
        return obj;
    }

    public Object j() {
        return w();
    }

    public final void l(C0985k kVar, Throwable th) {
        try {
            kVar.a(th);
        } catch (Throwable th2) {
            g context = getContext();
            I.a(context, new D("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void m(d3.l lVar, Throwable th) {
        try {
            lVar.invoke(th);
        } catch (Throwable th2) {
            g context = getContext();
            I.a(context, new D("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    public final void p() {
        Z u4 = u();
        if (u4 != null) {
            u4.dispose();
            f3715h.set(this, H0.f3657a);
        }
    }

    public void q(d3.l lVar) {
        B(F(lVar));
    }

    public void resumeWith(Object obj) {
        M(this, E.c(obj, this), this.f3680c, (d3.l) null, 4, (Object) null);
    }

    public Throwable t(C1001s0 s0Var) {
        return s0Var.l();
    }

    public String toString() {
        return H() + '(' + N.c(this.f3716d) + "){" + x() + "}@" + N.b(this);
    }

    public final Object v() {
        C1001s0 s0Var;
        boolean E4 = E();
        if (Q()) {
            if (u() == null) {
                A();
            }
            if (E4) {
                J();
            }
            return b.c();
        }
        if (E4) {
            J();
        }
        Object w4 = w();
        if (w4 instanceof A) {
            throw ((A) w4).f3624a;
        } else if (!X.b(this.f3680c) || (s0Var = (C1001s0) getContext().get(C1001s0.f3726k0)) == null || s0Var.isActive()) {
            return h(w4);
        } else {
            CancellationException l4 = s0Var.l();
            a(w4, l4);
            throw l4;
        }
    }

    public final Object w() {
        return f3714g.get(this);
    }

    public boolean y(Throwable th) {
        Object obj;
        boolean z4;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3714g;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
            z4 = false;
            if (!(obj instanceof I0)) {
                return false;
            }
            if ((obj instanceof C0985k) || (obj instanceof C)) {
                z4 = true;
            }
        } while (!a.a(f3714g, this, obj, new C0997q(this, th, z4)));
        I0 i02 = (I0) obj;
        if (i02 instanceof C0985k) {
            l((C0985k) obj, th);
        } else if (i02 instanceof C) {
            n((C) obj, th);
        }
        r();
        s(this.f3680c);
        return true;
    }

    public void z() {
        Z A4 = A();
        if (A4 != null && C()) {
            A4.dispose();
            f3715h.set(this, H0.f3657a);
        }
    }
}
