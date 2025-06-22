package t3;

import androidx.concurrent.futures.a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.m;

/* renamed from: t3.e  reason: case insensitive filesystem */
public abstract class C1055e {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f4490a;

    /* renamed from: b  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f4491b;
    private volatile Object _next;
    private volatile Object _prev;

    static {
        Class<C1055e> cls = C1055e.class;
        Class<Object> cls2 = Object.class;
        f4490a = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_next");
        f4491b = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_prev");
    }

    public C1055e(C1055e eVar) {
        this._prev = eVar;
    }

    private final C1055e c() {
        C1055e g4 = g();
        while (g4 != null && g4.h()) {
            g4 = (C1055e) f4491b.get(g4);
        }
        return g4;
    }

    private final C1055e d() {
        C1055e e5;
        C1055e e6 = e();
        m.b(e6);
        while (e6.h() && (e5 = e6.e()) != null) {
            e6 = e5;
        }
        return e6;
    }

    /* access modifiers changed from: private */
    public final Object f() {
        return f4490a.get(this);
    }

    public final void b() {
        f4491b.lazySet(this, (Object) null);
    }

    public final C1055e e() {
        Object a5 = f();
        if (a5 == C1054d.f4489a) {
            return null;
        }
        return (C1055e) a5;
    }

    public final C1055e g() {
        return (C1055e) f4491b.get(this);
    }

    public abstract boolean h();

    public final boolean i() {
        if (e() == null) {
            return true;
        }
        return false;
    }

    public final boolean j() {
        return a.a(f4490a, this, (Object) null, C1054d.f4489a);
    }

    public final void k() {
        Object obj;
        C1055e eVar;
        if (!i()) {
            while (true) {
                C1055e c5 = c();
                C1055e d5 = d();
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4491b;
                do {
                    obj = atomicReferenceFieldUpdater.get(d5);
                    if (((C1055e) obj) == null) {
                        eVar = null;
                    } else {
                        eVar = c5;
                    }
                } while (!a.a(atomicReferenceFieldUpdater, d5, obj, eVar));
                if (c5 != null) {
                    f4490a.set(c5, d5);
                }
                if ((!d5.h() || d5.i()) && (c5 == null || !c5.h())) {
                    return;
                }
            }
        }
    }

    public final boolean l(C1055e eVar) {
        return a.a(f4490a, this, (Object) null, eVar);
    }
}
