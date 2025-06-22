package kotlin.coroutines.jvm.internal;

import V2.d;
import V2.g;
import V2.h;

public abstract class j extends a {
    public j(d dVar) {
        super(dVar);
        if (dVar != null && dVar.getContext() != h.f8445a) {
            throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext");
        }
    }

    public g getContext() {
        return h.f8445a;
    }
}
