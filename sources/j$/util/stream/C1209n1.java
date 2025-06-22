package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.i0;
import java.util.function.LongConsumer;

/* renamed from: j$.util.stream.n1  reason: case insensitive filesystem */
public final class C1209n1 extends C1217p1 implements C1182h2 {

    /* renamed from: h  reason: collision with root package name */
    public final long[] f5550h;

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        i((Long) obj);
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return a.f(this, longConsumer);
    }

    public final /* synthetic */ void i(Long l4) {
        C1232t1.i(this, l4);
    }

    public C1209n1(i0 i0Var, C1144a aVar, long[] jArr) {
        super(i0Var, aVar, jArr.length);
        this.f5550h = jArr;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C1209n1(j$.util.stream.C1209n1 r10, j$.util.i0 r11, long r12, long r14) {
        /*
            r9 = this;
            long[] r0 = r10.f5550h
            int r8 = r0.length
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r12
            r6 = r14
            r1.<init>(r2, r3, r4, r6, r8)
            long[] r10 = r2.f5550h
            r1.f5550h = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.C1209n1.<init>(j$.util.stream.n1, j$.util.i0, long, long):void");
    }

    public final C1217p1 b(i0 i0Var, long j4, long j5) {
        return new C1209n1(this, i0Var, j4, j5);
    }

    public final void accept(long j4) {
        int i4 = this.f5565f;
        if (i4 < this.f5566g) {
            long[] jArr = this.f5550h;
            this.f5565f = i4 + 1;
            jArr[i4] = j4;
            return;
        }
        throw new IndexOutOfBoundsException(Integer.toString(this.f5565f));
    }
}
