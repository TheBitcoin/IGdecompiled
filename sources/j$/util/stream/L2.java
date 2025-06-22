package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.C1127b;
import j$.util.Objects;
import j$.util.W;
import j$.util.m0;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

public class L2 extends R2 implements DoubleConsumer {
    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return a.d(this, doubleConsumer);
    }

    public final void r(Object obj, int i4, int i5, Object obj2) {
        double[] dArr = (double[]) obj;
        DoubleConsumer doubleConsumer = (DoubleConsumer) obj2;
        while (i4 < i5) {
            doubleConsumer.accept(dArr[i4]);
            i4++;
        }
    }

    public final int s(Object obj) {
        return ((double[]) obj).length;
    }

    public final void forEach(Consumer consumer) {
        if (consumer instanceof DoubleConsumer) {
            e((DoubleConsumer) consumer);
        } else if (!E3.f5280a) {
            C1127b.a((K2) spliterator(), consumer);
        } else {
            E3.a(getClass(), "{0} calling SpinedBuffer.OfDouble.forEach(Consumer)");
            throw null;
        }
    }

    public final Object[] v() {
        return new double[8][];
    }

    public final Object c(int i4) {
        return new double[i4];
    }

    public void accept(double d5) {
        w();
        int i4 = this.f5478b;
        this.f5478b = i4 + 1;
        ((double[]) this.f5396e)[i4] = d5;
    }

    public final Iterator iterator() {
        W x4 = spliterator();
        Objects.requireNonNull(x4);
        return new m0(x4);
    }

    /* renamed from: x */
    public W spliterator() {
        return new K2(this, 0, this.f5479c, 0, this.f5478b);
    }

    public final String toString() {
        double[] dArr = (double[]) d();
        if (dArr.length < 200) {
            return String.format("%s[length=%d, chunks=%d]%s", new Object[]{getClass().getSimpleName(), Integer.valueOf(dArr.length), Integer.valueOf(this.f5479c), Arrays.toString(dArr)});
        }
        double[] copyOf = Arrays.copyOf(dArr, 200);
        return String.format("%s[length=%d, chunks=%d]%s...", new Object[]{getClass().getSimpleName(), Integer.valueOf(dArr.length), Integer.valueOf(this.f5479c), Arrays.toString(copyOf)});
    }
}
