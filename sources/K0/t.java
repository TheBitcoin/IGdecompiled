package k0;

import java.util.concurrent.ExecutionException;

final class t implements s {

    /* renamed from: a  reason: collision with root package name */
    private final Object f3500a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final int f3501b;

    /* renamed from: c  reason: collision with root package name */
    private final O f3502c;

    /* renamed from: d  reason: collision with root package name */
    private int f3503d;

    /* renamed from: e  reason: collision with root package name */
    private int f3504e;

    /* renamed from: f  reason: collision with root package name */
    private int f3505f;

    /* renamed from: g  reason: collision with root package name */
    private Exception f3506g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f3507h;

    public t(int i4, O o4) {
        this.f3501b = i4;
        this.f3502c = o4;
    }

    private final void c() {
        if (this.f3503d + this.f3504e + this.f3505f != this.f3501b) {
            return;
        }
        if (this.f3506g != null) {
            O o4 = this.f3502c;
            int i4 = this.f3504e;
            int i5 = this.f3501b;
            o4.q(new ExecutionException(i4 + " out of " + i5 + " underlying tasks failed", this.f3506g));
        } else if (this.f3507h) {
            this.f3502c.s();
        } else {
            this.f3502c.r((Object) null);
        }
    }

    public final void a(Object obj) {
        synchronized (this.f3500a) {
            this.f3503d++;
            c();
        }
    }

    public final void b() {
        synchronized (this.f3500a) {
            this.f3505f++;
            this.f3507h = true;
            c();
        }
    }

    public final void d(Exception exc) {
        synchronized (this.f3500a) {
            this.f3504e++;
            this.f3506g = exc;
            c();
        }
    }
}
