package androidx.work.impl.utils;

import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import j$.time.Duration;
import kotlin.jvm.internal.m;

@RequiresApi(26)
public final class DurationApi26Impl {
    @DoNotInline
    public static final long toMillisCompat(Duration duration) {
        m.e(duration, "<this>");
        return duration.toMillis();
    }
}
