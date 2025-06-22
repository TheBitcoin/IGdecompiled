package androidx.lifecycle;

import R2.s;
import V2.d;
import V2.g;
import W2.b;
import androidx.annotation.MainThread;
import kotlin.jvm.internal.m;
import o3.C0977g;
import o3.C1001s0;
import o3.K;
import o3.L;
import o3.Y;
import o3.Z;

public final class EmittedSource implements Z {
    private boolean disposed;
    private final MediatorLiveData<?> mediator;
    private final LiveData<?> source;

    public EmittedSource(LiveData<?> liveData, MediatorLiveData<?> mediatorLiveData) {
        m.e(liveData, "source");
        m.e(mediatorLiveData, "mediator");
        this.source = liveData;
        this.mediator = mediatorLiveData;
    }

    /* access modifiers changed from: private */
    @MainThread
    public final void removeSource() {
        if (!this.disposed) {
            this.mediator.removeSource(this.source);
            this.disposed = true;
        }
    }

    public void dispose() {
        C1001s0 unused = C0981i.d(K.a(Y.c().D()), (g) null, (L) null, new EmittedSource$dispose$1(this, (d) null), 3, (Object) null);
    }

    public final Object disposeNow(d dVar) {
        Object g4 = C0977g.g(Y.c().D(), new EmittedSource$disposeNow$2(this, (d) null), dVar);
        if (g4 == b.c()) {
            return g4;
        }
        return s.f8222a;
    }
}
