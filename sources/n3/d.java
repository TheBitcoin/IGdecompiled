package n3;

import X2.b;
import java.util.concurrent.TimeUnit;

public enum d {
    NANOSECONDS(TimeUnit.NANOSECONDS),
    MICROSECONDS(TimeUnit.MICROSECONDS),
    MILLISECONDS(TimeUnit.MILLISECONDS),
    SECONDS(TimeUnit.SECONDS),
    MINUTES(TimeUnit.MINUTES),
    HOURS(TimeUnit.HOURS),
    DAYS(TimeUnit.DAYS);
    

    /* renamed from: a  reason: collision with root package name */
    private final TimeUnit f21374a;

    static {
        d[] a5;
        f21373j = b.a(a5);
    }

    private d(TimeUnit timeUnit) {
        this.f21374a = timeUnit;
    }

    public final TimeUnit b() {
        return this.f21374a;
    }
}
