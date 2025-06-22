package y0;

import java.util.concurrent.atomic.AtomicInteger;

public final class N {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicInteger f22604a = new AtomicInteger();

    /* renamed from: b  reason: collision with root package name */
    private final AtomicInteger f22605b = new AtomicInteger();

    public void a() {
        this.f22605b.getAndIncrement();
    }

    public void b() {
        this.f22604a.getAndIncrement();
    }

    public void c() {
        this.f22605b.set(0);
    }
}
