package N3;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public class a0 {

    /* renamed from: d  reason: collision with root package name */
    public static final b f23668d = new b((C2103g) null);

    /* renamed from: e  reason: collision with root package name */
    public static final a0 f23669e = new a();

    /* renamed from: a  reason: collision with root package name */
    private boolean f23670a;

    /* renamed from: b  reason: collision with root package name */
    private long f23671b;

    /* renamed from: c  reason: collision with root package name */
    private long f23672c;

    public static final class b {
        public /* synthetic */ b(C2103g gVar) {
            this();
        }

        private b() {
        }
    }

    public a0 a() {
        this.f23670a = false;
        return this;
    }

    public a0 b() {
        this.f23672c = 0;
        return this;
    }

    public long c() {
        if (this.f23670a) {
            return this.f23671b;
        }
        throw new IllegalStateException("No deadline");
    }

    public a0 d(long j4) {
        this.f23670a = true;
        this.f23671b = j4;
        return this;
    }

    public boolean e() {
        return this.f23670a;
    }

    public void f() {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException("interrupted");
        } else if (this.f23670a && this.f23671b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public a0 g(long j4, TimeUnit timeUnit) {
        m.e(timeUnit, "unit");
        if (j4 >= 0) {
            this.f23672c = timeUnit.toNanos(j4);
            return this;
        }
        throw new IllegalArgumentException(("timeout < 0: " + j4).toString());
    }

    public long h() {
        return this.f23672c;
    }

    public static final class a extends a0 {
        a() {
        }

        public a0 g(long j4, TimeUnit timeUnit) {
            m.e(timeUnit, "unit");
            return this;
        }

        public void f() {
        }

        public a0 d(long j4) {
            return this;
        }
    }
}
