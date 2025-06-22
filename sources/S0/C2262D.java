package s0;

import R0.a;
import R0.b;

/* renamed from: s0.D  reason: case insensitive filesystem */
class C2262D implements b, a {

    /* renamed from: c  reason: collision with root package name */
    private static final a.C0097a f21685c = new C2259A();

    /* renamed from: d  reason: collision with root package name */
    private static final b f21686d = new C2260B();

    /* renamed from: a  reason: collision with root package name */
    private a.C0097a f21687a;

    /* renamed from: b  reason: collision with root package name */
    private volatile b f21688b;

    private C2262D(a.C0097a aVar, b bVar) {
        this.f21687a = aVar;
        this.f21688b = bVar;
    }

    public static /* synthetic */ Object b() {
        return null;
    }

    public static /* synthetic */ void c(a.C0097a aVar, a.C0097a aVar2, b bVar) {
        aVar.a(bVar);
        aVar2.a(bVar);
    }

    public static /* synthetic */ void d(b bVar) {
    }

    static C2262D e() {
        return new C2262D(f21685c, f21686d);
    }

    static C2262D f(b bVar) {
        return new C2262D((a.C0097a) null, bVar);
    }

    public void a(a.C0097a aVar) {
        b bVar;
        b bVar2;
        b bVar3 = this.f21688b;
        b bVar4 = f21686d;
        if (bVar3 != bVar4) {
            aVar.a(bVar3);
            return;
        }
        synchronized (this) {
            bVar = this.f21688b;
            if (bVar != bVar4) {
                bVar2 = bVar;
            } else {
                this.f21687a = new C2261C(this.f21687a, aVar);
                bVar2 = null;
            }
        }
        if (bVar2 != null) {
            aVar.a(bVar);
        }
    }

    /* access modifiers changed from: package-private */
    public void g(b bVar) {
        a.C0097a aVar;
        if (this.f21688b == f21686d) {
            synchronized (this) {
                aVar = this.f21687a;
                this.f21687a = null;
                this.f21688b = bVar;
            }
            aVar.a(bVar);
            return;
        }
        throw new IllegalStateException("provide() can be called only once.");
    }

    public Object get() {
        return this.f21688b.get();
    }
}
