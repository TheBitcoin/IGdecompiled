package t3;

import V2.d;
import V2.g;
import W2.b;
import d3.l;
import kotlin.coroutines.jvm.internal.e;
import o3.C0965a;
import o3.E;

public class B extends C0965a implements e {

    /* renamed from: d  reason: collision with root package name */
    public final d f4461d;

    public B(g gVar, d dVar) {
        super(gVar, true, true);
        this.f4461d = dVar;
    }

    /* access modifiers changed from: protected */
    public void J(Object obj) {
        C1061k.c(b.b(this.f4461d), E.a(obj, this.f4461d), (l) null, 2, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void L0(Object obj) {
        d dVar = this.f4461d;
        dVar.resumeWith(E.a(obj, dVar));
    }

    public final e getCallerFrame() {
        d dVar = this.f4461d;
        if (dVar instanceof e) {
            return (e) dVar;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final boolean j0() {
        return true;
    }
}
