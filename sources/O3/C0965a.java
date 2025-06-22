package o3;

import V2.d;
import V2.g;
import d3.l;
import d3.p;

/* renamed from: o3.a  reason: case insensitive filesystem */
public abstract class C0965a extends A0 implements C1001s0, d, J {

    /* renamed from: c  reason: collision with root package name */
    private final g f3687c;

    public C0965a(g gVar, boolean z4, boolean z5) {
        super(z5);
        if (z4) {
            i0((C1001s0) gVar.get(C1001s0.f3726k0));
        }
        this.f3687c = gVar.plus(this);
    }

    /* access modifiers changed from: protected */
    public void L0(Object obj) {
        J(obj);
    }

    public final void O0(L l4, Object obj, p pVar) {
        l4.b(pVar, obj, this);
    }

    /* access modifiers changed from: protected */
    public String R() {
        return N.a(this) + " was cancelled";
    }

    public final g getContext() {
        return this.f3687c;
    }

    public g getCoroutineContext() {
        return this.f3687c;
    }

    public final void h0(Throwable th) {
        I.a(this.f3687c, th);
    }

    public boolean isActive() {
        return super.isActive();
    }

    public String q0() {
        String b5 = F.b(this.f3687c);
        if (b5 == null) {
            return super.q0();
        }
        return '\"' + b5 + "\":" + super.q0();
    }

    public final void resumeWith(Object obj) {
        Object o02 = o0(E.d(obj, (l) null, 1, (Object) null));
        if (o02 != B0.f3641b) {
            L0(o02);
        }
    }

    /* access modifiers changed from: protected */
    public final void v0(Object obj) {
        if (obj instanceof A) {
            A a5 = (A) obj;
            M0(a5.f3624a, a5.a());
            return;
        }
        N0(obj);
    }

    /* access modifiers changed from: protected */
    public void N0(Object obj) {
    }

    /* access modifiers changed from: protected */
    public void M0(Throwable th, boolean z4) {
    }
}
