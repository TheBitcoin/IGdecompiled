package z0;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import k0.C0937l;
import k0.C0940o;

/* renamed from: z0.e  reason: case insensitive filesystem */
public class C2444e implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private final ExecutorService f22846a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f22847b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private C0937l f22848c = C0940o.e((Object) null);

    C2444e(ExecutorService executorService) {
        this.f22846a = executorService;
    }

    public static /* synthetic */ C0937l b(Callable callable, C0937l lVar) {
        return (C0937l) callable.call();
    }

    public ExecutorService c() {
        return this.f22846a;
    }

    public C0937l d(Runnable runnable) {
        C0937l h4;
        synchronized (this.f22847b) {
            h4 = this.f22848c.h(this.f22846a, new C2443d(runnable));
            this.f22848c = h4;
        }
        return h4;
    }

    public C0937l e(Callable callable) {
        C0937l h4;
        synchronized (this.f22847b) {
            h4 = this.f22848c.h(this.f22846a, new C2442c(callable));
            this.f22848c = h4;
        }
        return h4;
    }

    public void execute(Runnable runnable) {
        this.f22846a.execute(runnable);
    }
}
