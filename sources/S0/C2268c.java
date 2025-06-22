package s0;

import j$.util.DesugarCollections;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: s0.c  reason: case insensitive filesystem */
public final class C2268c {

    /* renamed from: a  reason: collision with root package name */
    private final String f21702a;

    /* renamed from: b  reason: collision with root package name */
    private final Set f21703b;

    /* renamed from: c  reason: collision with root package name */
    private final Set f21704c;

    /* renamed from: d  reason: collision with root package name */
    private final int f21705d;

    /* renamed from: e  reason: collision with root package name */
    private final int f21706e;

    /* renamed from: f  reason: collision with root package name */
    private final h f21707f;

    /* renamed from: g  reason: collision with root package name */
    private final Set f21708g;

    public static /* synthetic */ Object a(Object obj, C2270e eVar) {
        return obj;
    }

    public static /* synthetic */ Object b(Object obj, C2270e eVar) {
        return obj;
    }

    public static b c(Class cls) {
        return new b(cls, new Class[0]);
    }

    public static b d(Class cls, Class... clsArr) {
        return new b(cls, clsArr);
    }

    public static b e(C2264F f4) {
        return new b(f4, new C2264F[0]);
    }

    public static b f(C2264F f4, C2264F... fArr) {
        return new b(f4, fArr);
    }

    public static C2268c l(Object obj, Class cls) {
        return m(cls).f(new C2266a(obj)).d();
    }

    public static b m(Class cls) {
        return c(cls).g();
    }

    public static C2268c q(Object obj, Class cls, Class... clsArr) {
        return d(cls, clsArr).f(new C2267b(obj)).d();
    }

    public Set g() {
        return this.f21704c;
    }

    public h h() {
        return this.f21707f;
    }

    public String i() {
        return this.f21702a;
    }

    public Set j() {
        return this.f21703b;
    }

    public Set k() {
        return this.f21708g;
    }

    public boolean n() {
        if (this.f21705d == 1) {
            return true;
        }
        return false;
    }

    public boolean o() {
        if (this.f21705d == 2) {
            return true;
        }
        return false;
    }

    public boolean p() {
        if (this.f21706e == 0) {
            return true;
        }
        return false;
    }

    public C2268c r(h hVar) {
        return new C2268c(this.f21702a, this.f21703b, this.f21704c, this.f21705d, this.f21706e, hVar, this.f21708g);
    }

    public String toString() {
        return "Component<" + Arrays.toString(this.f21703b.toArray()) + ">{" + this.f21705d + ", type=" + this.f21706e + ", deps=" + Arrays.toString(this.f21704c.toArray()) + "}";
    }

    /* renamed from: s0.c$b */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private String f21709a;

        /* renamed from: b  reason: collision with root package name */
        private final Set f21710b;

        /* renamed from: c  reason: collision with root package name */
        private final Set f21711c;

        /* renamed from: d  reason: collision with root package name */
        private int f21712d;

        /* renamed from: e  reason: collision with root package name */
        private int f21713e;

        /* renamed from: f  reason: collision with root package name */
        private h f21714f;

        /* renamed from: g  reason: collision with root package name */
        private final Set f21715g;

        /* access modifiers changed from: private */
        public b g() {
            this.f21713e = 1;
            return this;
        }

        private b i(int i4) {
            boolean z4;
            if (this.f21712d == 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            C2263E.d(z4, "Instantiation type has already been set.");
            this.f21712d = i4;
            return this;
        }

        private void j(C2264F f4) {
            C2263E.a(!this.f21710b.contains(f4), "Components are not allowed to depend on interfaces they themselves provide.");
        }

        public b b(r rVar) {
            C2263E.c(rVar, "Null dependency");
            j(rVar.c());
            this.f21711c.add(rVar);
            return this;
        }

        public b c() {
            return i(1);
        }

        public C2268c d() {
            boolean z4;
            if (this.f21714f != null) {
                z4 = true;
            } else {
                z4 = false;
            }
            C2263E.d(z4, "Missing required property: factory.");
            return new C2268c(this.f21709a, new HashSet(this.f21710b), new HashSet(this.f21711c), this.f21712d, this.f21713e, this.f21714f, this.f21715g);
        }

        public b e() {
            return i(2);
        }

        public b f(h hVar) {
            this.f21714f = (h) C2263E.c(hVar, "Null factory");
            return this;
        }

        public b h(String str) {
            this.f21709a = str;
            return this;
        }

        private b(Class cls, Class... clsArr) {
            this.f21709a = null;
            HashSet hashSet = new HashSet();
            this.f21710b = hashSet;
            this.f21711c = new HashSet();
            this.f21712d = 0;
            this.f21713e = 0;
            this.f21715g = new HashSet();
            C2263E.c(cls, "Null interface");
            hashSet.add(C2264F.b(cls));
            for (Class cls2 : clsArr) {
                C2263E.c(cls2, "Null interface");
                this.f21710b.add(C2264F.b(cls2));
            }
        }

        private b(C2264F f4, C2264F... fArr) {
            this.f21709a = null;
            HashSet hashSet = new HashSet();
            this.f21710b = hashSet;
            this.f21711c = new HashSet();
            this.f21712d = 0;
            this.f21713e = 0;
            this.f21715g = new HashSet();
            C2263E.c(f4, "Null interface");
            hashSet.add(f4);
            for (C2264F c5 : fArr) {
                C2263E.c(c5, "Null interface");
            }
            Collections.addAll(this.f21710b, fArr);
        }
    }

    private C2268c(String str, Set set, Set set2, int i4, int i5, h hVar, Set set3) {
        this.f21702a = str;
        this.f21703b = DesugarCollections.unmodifiableSet(set);
        this.f21704c = DesugarCollections.unmodifiableSet(set2);
        this.f21705d = i4;
        this.f21706e = i5;
        this.f21707f = hVar;
        this.f21708g = DesugarCollections.unmodifiableSet(set3);
    }
}
