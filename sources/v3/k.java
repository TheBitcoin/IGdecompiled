package v3;

import o3.N;

public final class k extends h {

    /* renamed from: c  reason: collision with root package name */
    public final Runnable f4572c;

    public k(Runnable runnable, long j4, i iVar) {
        super(j4, iVar);
        this.f4572c = runnable;
    }

    public void run() {
        try {
            this.f4572c.run();
        } finally {
            this.f4570b.a();
        }
    }

    public String toString() {
        return "Task[" + N.a(this.f4572c) + '@' + N.b(this.f4572c) + ", " + this.f4569a + ", " + this.f4570b + ']';
    }
}
