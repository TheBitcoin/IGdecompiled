package j$.util.stream;

import j$.util.i0;

/* renamed from: j$.util.stream.o1  reason: case insensitive filesystem */
public final class C1213o1 extends C1217p1 {

    /* renamed from: h  reason: collision with root package name */
    public final Object[] f5555h;

    public C1213o1(i0 i0Var, C1144a aVar, Object[] objArr) {
        super(i0Var, aVar, objArr.length);
        this.f5555h = objArr;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C1213o1(j$.util.stream.C1213o1 r10, j$.util.i0 r11, long r12, long r14) {
        /*
            r9 = this;
            java.lang.Object[] r0 = r10.f5555h
            int r8 = r0.length
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r12
            r6 = r14
            r1.<init>(r2, r3, r4, r6, r8)
            java.lang.Object[] r10 = r2.f5555h
            r1.f5555h = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.C1213o1.<init>(j$.util.stream.o1, j$.util.i0, long, long):void");
    }

    public final C1217p1 b(i0 i0Var, long j4, long j5) {
        return new C1213o1(this, i0Var, j4, j5);
    }

    public final void accept(Object obj) {
        int i4 = this.f5565f;
        if (i4 < this.f5566g) {
            Object[] objArr = this.f5555h;
            this.f5565f = i4 + 1;
            objArr[i4] = obj;
            return;
        }
        throw new IndexOutOfBoundsException(Integer.toString(this.f5565f));
    }
}
