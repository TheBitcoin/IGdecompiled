package o0;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import l0.d;
import l0.h;

/* renamed from: o0.b  reason: case insensitive filesystem */
public abstract class C2170b extends C2171c {

    /* renamed from: o0.b$a */
    private static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final Future f21375a;

        /* renamed from: b  reason: collision with root package name */
        final C2169a f21376b;

        a(Future future, C2169a aVar) {
            this.f21375a = future;
            this.f21376b = aVar;
        }

        public void run() {
            try {
                this.f21376b.a(C2170b.b(this.f21375a));
            } catch (ExecutionException e5) {
                this.f21376b.b(e5.getCause());
            } catch (Error | RuntimeException e6) {
                this.f21376b.b(e6);
            }
        }

        public String toString() {
            return d.a(this).c(this.f21376b).toString();
        }
    }

    public static void a(C2172d dVar, C2169a aVar, Executor executor) {
        h.i(aVar);
        dVar.addListener(new a(dVar, aVar), executor);
    }

    public static Object b(Future future) {
        h.p(future.isDone(), "Future was expected to be done: %s", future);
        return e.a(future);
    }
}
