package v3;

import V2.g;
import V2.h;
import j3.e;
import java.util.concurrent.Executor;
import o3.C0982i0;
import o3.G;

public final class b extends C0982i0 implements Executor {

    /* renamed from: b  reason: collision with root package name */
    public static final b f4560b = new b();

    /* renamed from: c  reason: collision with root package name */
    private static final G f4561c = m.f4581a.limitedParallelism(I.e("kotlinx.coroutines.io.parallelism", e.a(64, t3.G.a()), 0, 0, 12, (Object) null));

    private b() {
    }

    public void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    public void dispatch(g gVar, Runnable runnable) {
        f4561c.dispatch(gVar, runnable);
    }

    public void dispatchYield(g gVar, Runnable runnable) {
        f4561c.dispatchYield(gVar, runnable);
    }

    public void execute(Runnable runnable) {
        dispatch(h.f8445a, runnable);
    }

    public G limitedParallelism(int i4) {
        return m.f4581a.limitedParallelism(i4);
    }

    public String toString() {
        return "Dispatchers.IO";
    }
}
