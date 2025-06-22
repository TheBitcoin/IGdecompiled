package D3;

import D3.C2475w;
import E3.c;
import android.support.v4.media.a;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: D3.m  reason: case insensitive filesystem */
public final class C2465m {

    /* renamed from: a  reason: collision with root package name */
    private int f23092a = 64;

    /* renamed from: b  reason: collision with root package name */
    private int f23093b = 5;

    /* renamed from: c  reason: collision with root package name */
    private Runnable f23094c;

    /* renamed from: d  reason: collision with root package name */
    private ExecutorService f23095d;

    /* renamed from: e  reason: collision with root package name */
    private final Deque f23096e = new ArrayDeque();

    /* renamed from: f  reason: collision with root package name */
    private final Deque f23097f = new ArrayDeque();

    /* renamed from: g  reason: collision with root package name */
    private final Deque f23098g = new ArrayDeque();

    private void d(Deque deque, Object obj, boolean z4) {
        int f4;
        Runnable runnable;
        synchronized (this) {
            try {
                if (deque.remove(obj)) {
                    if (z4) {
                        e();
                    }
                    f4 = f();
                    runnable = this.f23094c;
                } else {
                    throw new AssertionError("Call wasn't in-flight!");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (f4 == 0 && runnable != null) {
            runnable.run();
        }
    }

    private void e() {
        if (this.f23097f.size() < this.f23092a && !this.f23096e.isEmpty()) {
            Iterator it = this.f23096e.iterator();
            while (it.hasNext()) {
                a.a(it.next());
                if (g((C2475w.a) null) < this.f23093b) {
                    it.remove();
                    this.f23097f.add((Object) null);
                    b().execute((Runnable) null);
                }
                if (this.f23097f.size() >= this.f23092a) {
                    return;
                }
            }
        }
    }

    private int g(C2475w.a aVar) {
        Iterator it = this.f23097f.iterator();
        if (!it.hasNext()) {
            return 0;
        }
        a.a(it.next());
        throw null;
    }

    /* access modifiers changed from: package-private */
    public synchronized void a(C2475w wVar) {
        this.f23098g.add(wVar);
    }

    public synchronized ExecutorService b() {
        try {
            if (this.f23095d == null) {
                this.f23095d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), c.B("OkHttp Dispatcher", false));
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this.f23095d;
    }

    /* access modifiers changed from: package-private */
    public void c(C2475w wVar) {
        d(this.f23098g, wVar, false);
    }

    public synchronized int f() {
        return this.f23097f.size() + this.f23098g.size();
    }
}
