package p0;

import android.os.SystemClock;

public abstract class p {
    public static p a(long j4, long j5, long j6) {
        return new C2189a(j4, j5, j6);
    }

    public static p e() {
        return a(System.currentTimeMillis(), SystemClock.elapsedRealtime(), SystemClock.uptimeMillis());
    }

    public abstract long b();

    public abstract long c();

    public abstract long d();
}
