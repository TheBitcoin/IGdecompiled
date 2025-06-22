package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.i0;
import java.util.function.IntConsumer;

/* renamed from: j$.util.stream.m1  reason: case insensitive filesystem */
public final class C1205m1 extends C1217p1 implements C1177g2 {

    /* renamed from: h  reason: collision with root package name */
    public final int[] f5547h;

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        l((Integer) obj);
    }

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return a.e(this, intConsumer);
    }

    public final /* synthetic */ void l(Integer num) {
        C1232t1.g(this, num);
    }

    public C1205m1(i0 i0Var, C1144a aVar, int[] iArr) {
        super(i0Var, aVar, iArr.length);
        this.f5547h = iArr;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C1205m1(j$.util.stream.C1205m1 r10, j$.util.i0 r11, long r12, long r14) {
        /*
            r9 = this;
            int[] r0 = r10.f5547h
            int r8 = r0.length
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r12
            r6 = r14
            r1.<init>(r2, r3, r4, r6, r8)
            int[] r10 = r2.f5547h
            r1.f5547h = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.C1205m1.<init>(j$.util.stream.m1, j$.util.i0, long, long):void");
    }

    public final C1217p1 b(i0 i0Var, long j4, long j5) {
        return new C1205m1(this, i0Var, j4, j5);
    }

    public final void accept(int i4) {
        int i5 = this.f5565f;
        if (i5 < this.f5566g) {
            int[] iArr = this.f5547h;
            this.f5565f = i5 + 1;
            iArr[i5] = i4;
            return;
        }
        throw new IndexOutOfBoundsException(Integer.toString(this.f5565f));
    }
}
