package U0;

import com.google.firebase.installations.i;
import java.util.concurrent.TimeUnit;

class e {

    /* renamed from: d  reason: collision with root package name */
    private static final long f8386d = TimeUnit.HOURS.toMillis(24);

    /* renamed from: e  reason: collision with root package name */
    private static final long f8387e = TimeUnit.MINUTES.toMillis(30);

    /* renamed from: a  reason: collision with root package name */
    private final i f8388a = i.c();

    /* renamed from: b  reason: collision with root package name */
    private long f8389b;

    /* renamed from: c  reason: collision with root package name */
    private int f8390c;

    e() {
    }

    private synchronized long a(int i4) {
        if (!c(i4)) {
            return f8386d;
        }
        return (long) Math.min(Math.pow(2.0d, (double) this.f8390c) + ((double) this.f8388a.e()), (double) f8387e);
    }

    private static boolean c(int i4) {
        if (i4 == 429) {
            return true;
        }
        if (i4 < 500 || i4 >= 600) {
            return false;
        }
        return true;
    }

    private static boolean d(int i4) {
        if ((i4 >= 200 && i4 < 300) || i4 == 401 || i4 == 404) {
            return true;
        }
        return false;
    }

    private synchronized void e() {
        this.f8390c = 0;
    }

    public synchronized boolean b() {
        boolean z4;
        if (this.f8390c == 0 || this.f8388a.a() > this.f8389b) {
            z4 = true;
        } else {
            z4 = false;
        }
        return z4;
    }

    public synchronized void f(int i4) {
        if (d(i4)) {
            e();
            return;
        }
        this.f8390c++;
        this.f8389b = this.f8388a.a() + a(i4);
    }
}
