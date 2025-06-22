package y1;

import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import y1.b;

public class c implements b.a {

    /* renamed from: a  reason: collision with root package name */
    private final BlockingQueue f22746a;

    /* renamed from: b  reason: collision with root package name */
    private final ThreadPoolExecutor f22747b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayDeque f22748c = new ArrayDeque();

    /* renamed from: d  reason: collision with root package name */
    private b f22749d = null;

    public c() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        this.f22746a = linkedBlockingQueue;
        this.f22747b = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, linkedBlockingQueue);
    }

    private void b() {
        b bVar = (b) this.f22748c.poll();
        this.f22749d = bVar;
        if (bVar != null) {
            bVar.b(this.f22747b);
        }
    }

    public void a(b bVar) {
        this.f22749d = null;
        b();
    }

    public void c(b bVar) {
        bVar.c(this);
        this.f22748c.add(bVar);
        if (this.f22749d == null) {
            b();
        }
    }
}
