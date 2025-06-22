package s0;

import O0.c;
import R0.b;
import j$.util.DesugarCollections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: s0.G  reason: case insensitive filesystem */
final class C2265G implements C2270e {

    /* renamed from: a  reason: collision with root package name */
    private final Set f21691a;

    /* renamed from: b  reason: collision with root package name */
    private final Set f21692b;

    /* renamed from: c  reason: collision with root package name */
    private final Set f21693c;

    /* renamed from: d  reason: collision with root package name */
    private final Set f21694d;

    /* renamed from: e  reason: collision with root package name */
    private final Set f21695e;

    /* renamed from: f  reason: collision with root package name */
    private final Set f21696f;

    /* renamed from: g  reason: collision with root package name */
    private final C2270e f21697g;

    /* renamed from: s0.G$a */
    private static class a implements c {

        /* renamed from: a  reason: collision with root package name */
        private final Set f21698a;

        /* renamed from: b  reason: collision with root package name */
        private final c f21699b;

        public a(Set set, c cVar) {
            this.f21698a = set;
            this.f21699b = cVar;
        }
    }

    C2265G(C2268c cVar, C2270e eVar) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        for (r rVar : cVar.g()) {
            if (rVar.e()) {
                if (rVar.g()) {
                    hashSet4.add(rVar.c());
                } else {
                    hashSet.add(rVar.c());
                }
            } else if (rVar.d()) {
                hashSet3.add(rVar.c());
            } else if (rVar.g()) {
                hashSet5.add(rVar.c());
            } else {
                hashSet2.add(rVar.c());
            }
        }
        if (!cVar.k().isEmpty()) {
            hashSet.add(C2264F.b(c.class));
        }
        this.f21691a = DesugarCollections.unmodifiableSet(hashSet);
        this.f21692b = DesugarCollections.unmodifiableSet(hashSet2);
        this.f21693c = DesugarCollections.unmodifiableSet(hashSet3);
        this.f21694d = DesugarCollections.unmodifiableSet(hashSet4);
        this.f21695e = DesugarCollections.unmodifiableSet(hashSet5);
        this.f21696f = cVar.k();
        this.f21697g = eVar;
    }

    public Object a(Class cls) {
        if (this.f21691a.contains(C2264F.b(cls))) {
            Object a5 = this.f21697g.a(cls);
            if (!cls.equals(c.class)) {
                return a5;
            }
            return new a(this.f21696f, (c) a5);
        }
        throw new t(String.format("Attempting to request an undeclared dependency %s.", new Object[]{cls}));
    }

    public Set b(C2264F f4) {
        if (this.f21694d.contains(f4)) {
            return this.f21697g.b(f4);
        }
        throw new t(String.format("Attempting to request an undeclared dependency Set<%s>.", new Object[]{f4}));
    }

    public R0.a c(C2264F f4) {
        if (this.f21693c.contains(f4)) {
            return this.f21697g.c(f4);
        }
        throw new t(String.format("Attempting to request an undeclared dependency Deferred<%s>.", new Object[]{f4}));
    }

    public b d(Class cls) {
        return g(C2264F.b(cls));
    }

    public /* synthetic */ Set e(Class cls) {
        return C2269d.e(this, cls);
    }

    public b f(C2264F f4) {
        if (this.f21695e.contains(f4)) {
            return this.f21697g.f(f4);
        }
        throw new t(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", new Object[]{f4}));
    }

    public b g(C2264F f4) {
        if (this.f21692b.contains(f4)) {
            return this.f21697g.g(f4);
        }
        throw new t(String.format("Attempting to request an undeclared dependency Provider<%s>.", new Object[]{f4}));
    }

    public Object h(C2264F f4) {
        if (this.f21691a.contains(f4)) {
            return this.f21697g.h(f4);
        }
        throw new t(String.format("Attempting to request an undeclared dependency %s.", new Object[]{f4}));
    }

    public R0.a i(Class cls) {
        return c(C2264F.b(cls));
    }
}
