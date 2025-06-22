package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.function.Consumer$CC;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* renamed from: j$.util.stream.j1  reason: case insensitive filesystem */
public final class C1191j1 extends C1186i1 implements C1239v0 {
    public final /* synthetic */ void accept(double d5) {
        C1232t1.a();
        throw null;
    }

    public final /* synthetic */ void accept(int i4) {
        C1232t1.k();
        throw null;
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        i((Long) obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return a.f(this, longConsumer);
    }

    public final /* synthetic */ void i(Long l4) {
        C1232t1.i(this, l4);
    }

    public final /* synthetic */ boolean m() {
        return false;
    }

    public final C0 a() {
        int i4 = this.f5517b;
        long[] jArr = this.f5516a;
        if (i4 >= jArr.length) {
            return this;
        }
        throw new IllegalStateException(String.format("Current size %d is less than fixed size %d", new Object[]{Integer.valueOf(this.f5517b), Integer.valueOf(jArr.length)}));
    }

    public final void k(long j4) {
        long[] jArr = this.f5516a;
        if (j4 == ((long) jArr.length)) {
            this.f5517b = 0;
            return;
        }
        throw new IllegalStateException(String.format("Begin size %d is not equal to fixed size %d", new Object[]{Long.valueOf(j4), Integer.valueOf(jArr.length)}));
    }

    public final void accept(long j4) {
        int i4 = this.f5517b;
        long[] jArr = this.f5516a;
        if (i4 < jArr.length) {
            this.f5517b = 1 + i4;
            jArr[i4] = j4;
            return;
        }
        throw new IllegalStateException(String.format("Accept exceeded fixed size of %d", new Object[]{Integer.valueOf(jArr.length)}));
    }

    public final void j() {
        int i4 = this.f5517b;
        long[] jArr = this.f5516a;
        if (i4 < jArr.length) {
            throw new IllegalStateException(String.format("End size %d is less than fixed size %d", new Object[]{Integer.valueOf(this.f5517b), Integer.valueOf(jArr.length)}));
        }
    }

    public final String toString() {
        long[] jArr = this.f5516a;
        return String.format("LongFixedNodeBuilder[%d][%s]", new Object[]{Integer.valueOf(jArr.length - this.f5517b), Arrays.toString(jArr)});
    }
}
