package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.C1127b;
import j$.util.Objects;
import j$.util.c0;
import j$.util.l0;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

public class P2 extends R2 implements LongConsumer {
    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return a.f(this, longConsumer);
    }

    public final void r(Object obj, int i4, int i5, Object obj2) {
        long[] jArr = (long[]) obj;
        LongConsumer longConsumer = (LongConsumer) obj2;
        while (i4 < i5) {
            longConsumer.accept(jArr[i4]);
            i4++;
        }
    }

    public final int s(Object obj) {
        return ((long[]) obj).length;
    }

    public final void forEach(Consumer consumer) {
        if (consumer instanceof LongConsumer) {
            e((LongConsumer) consumer);
        } else if (!E3.f5280a) {
            C1127b.c((O2) spliterator(), consumer);
        } else {
            E3.a(getClass(), "{0} calling SpinedBuffer.OfLong.forEach(Consumer)");
            throw null;
        }
    }

    public final Object[] v() {
        return new long[8][];
    }

    public final Object c(int i4) {
        return new long[i4];
    }

    public void accept(long j4) {
        w();
        int i4 = this.f5478b;
        this.f5478b = i4 + 1;
        ((long[]) this.f5396e)[i4] = j4;
    }

    public final Iterator iterator() {
        c0 x4 = spliterator();
        Objects.requireNonNull(x4);
        return new l0(x4);
    }

    /* renamed from: x */
    public c0 spliterator() {
        return new O2(this, 0, this.f5479c, 0, this.f5478b);
    }

    public final String toString() {
        long[] jArr = (long[]) d();
        if (jArr.length < 200) {
            return String.format("%s[length=%d, chunks=%d]%s", new Object[]{getClass().getSimpleName(), Integer.valueOf(jArr.length), Integer.valueOf(this.f5479c), Arrays.toString(jArr)});
        }
        long[] copyOf = Arrays.copyOf(jArr, 200);
        return String.format("%s[length=%d, chunks=%d]%s...", new Object[]{getClass().getSimpleName(), Integer.valueOf(jArr.length), Integer.valueOf(this.f5479c), Arrays.toString(copyOf)});
    }
}
