package androidx.core.util;

import android.util.Range;
import j3.a;

public final class RangeKt$toClosedRange$1 implements a {
    final /* synthetic */ Range<T> $this_toClosedRange;

    RangeKt$toClosedRange$1(Range<T> range) {
        this.$this_toClosedRange = range;
    }

    public boolean contains(T t4) {
        return a.C0258a.a(this, t4);
    }

    public T getEndInclusive() {
        return this.$this_toClosedRange.getUpper();
    }

    public T getStart() {
        return this.$this_toClosedRange.getLower();
    }

    public boolean isEmpty() {
        return a.C0258a.b(this);
    }
}
