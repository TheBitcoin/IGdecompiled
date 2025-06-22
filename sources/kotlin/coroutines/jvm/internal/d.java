package kotlin.coroutines.jvm.internal;

import V2.e;
import V2.g;
import kotlin.jvm.internal.m;

public abstract class d extends a {
    private final g _context;
    private transient V2.d intercepted;

    public d(V2.d dVar, g gVar) {
        super(dVar);
        this._context = gVar;
    }

    public g getContext() {
        g gVar = this._context;
        m.b(gVar);
        return gVar;
    }

    public final V2.d intercepted() {
        V2.d dVar = this.intercepted;
        if (dVar == null) {
            e eVar = (e) getContext().get(e.f8442a0);
            if (eVar == null || (dVar = eVar.interceptContinuation(this)) == null) {
                dVar = this;
            }
            this.intercepted = dVar;
        }
        return dVar;
    }

    /* access modifiers changed from: protected */
    public void releaseIntercepted() {
        V2.d dVar = this.intercepted;
        if (!(dVar == null || dVar == this)) {
            g.b bVar = getContext().get(e.f8442a0);
            m.b(bVar);
            ((e) bVar).releaseInterceptedContinuation(dVar);
        }
        this.intercepted = c.f20959a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public d(V2.d dVar) {
        this(dVar, dVar != null ? dVar.getContext() : null);
    }
}
