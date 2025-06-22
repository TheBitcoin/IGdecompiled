package R;

import android.os.SystemClock;

public class g implements d {

    /* renamed from: a  reason: collision with root package name */
    private static final g f612a = new g();

    private g() {
    }

    public static d b() {
        return f612a;
    }

    public final long a() {
        return System.nanoTime();
    }

    public final long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public final long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }
}
