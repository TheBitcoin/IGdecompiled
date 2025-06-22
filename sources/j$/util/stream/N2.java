package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.C1127b;
import j$.util.Objects;
import j$.util.Z;
import j$.util.k0;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class N2 extends R2 implements IntConsumer {
    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return a.e(this, intConsumer);
    }

    public final void r(Object obj, int i4, int i5, Object obj2) {
        int[] iArr = (int[]) obj;
        IntConsumer intConsumer = (IntConsumer) obj2;
        while (i4 < i5) {
            intConsumer.accept(iArr[i4]);
            i4++;
        }
    }

    public final int s(Object obj) {
        return ((int[]) obj).length;
    }

    public final void forEach(Consumer consumer) {
        if (consumer instanceof IntConsumer) {
            e((IntConsumer) consumer);
        } else if (!E3.f5280a) {
            C1127b.b((M2) spliterator(), consumer);
        } else {
            E3.a(getClass(), "{0} calling SpinedBuffer.OfInt.forEach(Consumer)");
            throw null;
        }
    }

    public final Object[] v() {
        return new int[8][];
    }

    public final Object c(int i4) {
        return new int[i4];
    }

    public void accept(int i4) {
        w();
        int i5 = this.f5478b;
        this.f5478b = i5 + 1;
        ((int[]) this.f5396e)[i5] = i4;
    }

    public final Iterator iterator() {
        Z x4 = spliterator();
        Objects.requireNonNull(x4);
        return new k0(x4);
    }

    /* renamed from: x */
    public Z spliterator() {
        return new M2(this, 0, this.f5479c, 0, this.f5478b);
    }

    public final String toString() {
        int[] iArr = (int[]) d();
        if (iArr.length < 200) {
            return String.format("%s[length=%d, chunks=%d]%s", new Object[]{getClass().getSimpleName(), Integer.valueOf(iArr.length), Integer.valueOf(this.f5479c), Arrays.toString(iArr)});
        }
        int[] copyOf = Arrays.copyOf(iArr, 200);
        return String.format("%s[length=%d, chunks=%d]%s...", new Object[]{getClass().getSimpleName(), Integer.valueOf(iArr.length), Integer.valueOf(this.f5479c), Arrays.toString(copyOf)});
    }
}
