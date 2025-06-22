package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.function.Consumer$CC;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* renamed from: j$.util.stream.a1  reason: case insensitive filesystem */
public final class C1146a1 extends Z0 implements C1235u0 {
    public final /* synthetic */ void accept(double d5) {
        C1232t1.a();
        throw null;
    }

    public final /* synthetic */ void accept(long j4) {
        C1232t1.l();
        throw null;
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        l((Integer) obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return a.e(this, intConsumer);
    }

    public final /* synthetic */ void l(Integer num) {
        C1232t1.g(this, num);
    }

    public final /* synthetic */ boolean m() {
        return false;
    }

    public final A0 a() {
        int i4 = this.f5455b;
        int[] iArr = this.f5454a;
        if (i4 >= iArr.length) {
            return this;
        }
        throw new IllegalStateException(String.format("Current size %d is less than fixed size %d", new Object[]{Integer.valueOf(this.f5455b), Integer.valueOf(iArr.length)}));
    }

    public final void k(long j4) {
        int[] iArr = this.f5454a;
        if (j4 == ((long) iArr.length)) {
            this.f5455b = 0;
            return;
        }
        throw new IllegalStateException(String.format("Begin size %d is not equal to fixed size %d", new Object[]{Long.valueOf(j4), Integer.valueOf(iArr.length)}));
    }

    public final void accept(int i4) {
        int i5 = this.f5455b;
        int[] iArr = this.f5454a;
        if (i5 < iArr.length) {
            this.f5455b = 1 + i5;
            iArr[i5] = i4;
            return;
        }
        throw new IllegalStateException(String.format("Accept exceeded fixed size of %d", new Object[]{Integer.valueOf(iArr.length)}));
    }

    public final void j() {
        int i4 = this.f5455b;
        int[] iArr = this.f5454a;
        if (i4 < iArr.length) {
            throw new IllegalStateException(String.format("End size %d is less than fixed size %d", new Object[]{Integer.valueOf(this.f5455b), Integer.valueOf(iArr.length)}));
        }
    }

    public final String toString() {
        int[] iArr = this.f5454a;
        return String.format("IntFixedNodeBuilder[%d][%s]", new Object[]{Integer.valueOf(iArr.length - this.f5455b), Arrays.toString(iArr)});
    }
}
