package q3;

import V2.d;
import V2.g;
import W2.b;
import d3.l;
import java.util.concurrent.CancellationException;
import o3.A0;
import o3.C0965a;
import o3.C1003t0;

public abstract class e extends C0965a implements d {

    /* renamed from: d  reason: collision with root package name */
    private final d f4090d;

    public e(g gVar, d dVar, boolean z4, boolean z5) {
        super(gVar, z4, z5);
        this.f4090d = dVar;
    }

    public Object B(Object obj) {
        return this.f4090d.B(obj);
    }

    public boolean C() {
        return this.f4090d.C();
    }

    public void O(Throwable th) {
        CancellationException E02 = A0.E0(this, th, (String) null, 1, (Object) null);
        this.f4090d.a(E02);
        M(E02);
    }

    /* access modifiers changed from: protected */
    public final d Q0() {
        return this.f4090d;
    }

    public final void a(CancellationException cancellationException) {
        if (!isCancelled()) {
            if (cancellationException == null) {
                cancellationException = new C1003t0(R(), (Throwable) null, this);
            }
            O(cancellationException);
        }
    }

    public void f(l lVar) {
        this.f4090d.f(lVar);
    }

    public Object h() {
        return this.f4090d.h();
    }

    public f iterator() {
        return this.f4090d.iterator();
    }

    public Object j(d dVar) {
        Object j4 = this.f4090d.j(dVar);
        b.c();
        return j4;
    }

    public Object m(d dVar) {
        return this.f4090d.m(dVar);
    }

    public boolean s(Throwable th) {
        return this.f4090d.s(th);
    }

    public Object t(Object obj, d dVar) {
        return this.f4090d.t(obj, dVar);
    }

    public final d P0() {
        return this;
    }
}
