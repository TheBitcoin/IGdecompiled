package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.function.Consumer$CC;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

public final class R0 extends Q0 implements C1231t0 {
    public final /* synthetic */ void accept(int i4) {
        C1232t1.k();
        throw null;
    }

    public final /* synthetic */ void accept(long j4) {
        C1232t1.l();
        throw null;
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        o((Double) obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return a.d(this, doubleConsumer);
    }

    public final /* synthetic */ boolean m() {
        return false;
    }

    public final /* synthetic */ void o(Double d5) {
        C1232t1.e(this, d5);
    }

    public final C1251y0 a() {
        int i4 = this.f5389b;
        double[] dArr = this.f5388a;
        if (i4 >= dArr.length) {
            return this;
        }
        throw new IllegalStateException(String.format("Current size %d is less than fixed size %d", new Object[]{Integer.valueOf(this.f5389b), Integer.valueOf(dArr.length)}));
    }

    public final void k(long j4) {
        double[] dArr = this.f5388a;
        if (j4 == ((long) dArr.length)) {
            this.f5389b = 0;
            return;
        }
        throw new IllegalStateException(String.format("Begin size %d is not equal to fixed size %d", new Object[]{Long.valueOf(j4), Integer.valueOf(dArr.length)}));
    }

    public final void accept(double d5) {
        int i4 = this.f5389b;
        double[] dArr = this.f5388a;
        if (i4 < dArr.length) {
            this.f5389b = 1 + i4;
            dArr[i4] = d5;
            return;
        }
        throw new IllegalStateException(String.format("Accept exceeded fixed size of %d", new Object[]{Integer.valueOf(dArr.length)}));
    }

    public final void j() {
        int i4 = this.f5389b;
        double[] dArr = this.f5388a;
        if (i4 < dArr.length) {
            throw new IllegalStateException(String.format("End size %d is less than fixed size %d", new Object[]{Integer.valueOf(this.f5389b), Integer.valueOf(dArr.length)}));
        }
    }

    public final String toString() {
        double[] dArr = this.f5388a;
        return String.format("DoubleFixedNodeBuilder[%d][%s]", new Object[]{Integer.valueOf(dArr.length - this.f5389b), Arrays.toString(dArr)});
    }
}
