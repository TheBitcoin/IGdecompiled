package j$.util.stream;

import j$.util.C1127b;
import j$.util.function.Consumer$CC;
import j$.util.i0;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import java.util.function.Predicate;

public final class J3 implements Consumer, i0 {

    /* renamed from: a  reason: collision with root package name */
    public final i0 f5347a;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicBoolean f5348b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f5349c = true;

    /* renamed from: d  reason: collision with root package name */
    public int f5350d;

    /* renamed from: e  reason: collision with root package name */
    public final Predicate f5351e;

    /* renamed from: f  reason: collision with root package name */
    public Object f5352f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f5353g;

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public final /* synthetic */ boolean hasCharacteristics(int i4) {
        return C1127b.e(this, i4);
    }

    public final void forEachRemaining(Consumer consumer) {
        do {
        } while (tryAdvance(consumer));
    }

    public J3(i0 i0Var, Predicate predicate, int i4) {
        this.f5353g = i4;
        this.f5347a = i0Var;
        this.f5348b = new AtomicBoolean();
        this.f5351e = predicate;
    }

    public J3(i0 i0Var, J3 j32, int i4) {
        this.f5353g = i4;
        this.f5347a = i0Var;
        this.f5348b = j32.f5348b;
        this.f5351e = j32.f5351e;
    }

    public final long estimateSize() {
        return this.f5347a.estimateSize();
    }

    public final int characteristics() {
        return this.f5347a.characteristics() & -16449;
    }

    public final long getExactSizeIfKnown() {
        return -1;
    }

    public final Comparator getComparator() {
        return this.f5347a.getComparator();
    }

    public final i0 b() {
        i0 trySplit = this.f5347a.trySplit();
        if (trySplit == null) {
            return null;
        }
        switch (this.f5353g) {
            case 0:
                return new J3(trySplit, this, 0);
            default:
                return new J3(trySplit, this, 1);
        }
    }

    public final void accept(Object obj) {
        this.f5350d = (this.f5350d + 1) & 63;
        this.f5352f = obj;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean tryAdvance(java.util.function.Consumer r8) {
        /*
            r7 = this;
            int r0 = r7.f5353g
            switch(r0) {
                case 0: goto L_0x0039;
                default: goto L_0x0005;
            }
        L_0x0005:
            boolean r0 = r7.f5349c
            java.util.concurrent.atomic.AtomicBoolean r1 = r7.f5348b
            r2 = 1
            if (r0 == 0) goto L_0x002e
            int r0 = r7.f5350d
            if (r0 != 0) goto L_0x0016
            boolean r0 = r1.get()
            if (r0 != 0) goto L_0x002e
        L_0x0016:
            j$.util.i0 r0 = r7.f5347a
            boolean r0 = r0.tryAdvance(r7)
            if (r0 == 0) goto L_0x002e
            java.util.function.Predicate r0 = r7.f5351e
            java.lang.Object r3 = r7.f5352f
            boolean r0 = r0.test(r3)
            if (r0 == 0) goto L_0x002f
            java.lang.Object r0 = r7.f5352f
            r8.accept(r0)
            goto L_0x0038
        L_0x002e:
            r0 = 1
        L_0x002f:
            r8 = 0
            r7.f5349c = r8
            if (r0 != 0) goto L_0x0037
            r1.set(r2)
        L_0x0037:
            r2 = 0
        L_0x0038:
            return r2
        L_0x0039:
            boolean r0 = r7.f5349c
            j$.util.i0 r1 = r7.f5347a
            if (r0 == 0) goto L_0x006e
            r0 = 0
            r7.f5349c = r0
        L_0x0042:
            boolean r2 = r1.tryAdvance(r7)
            java.util.concurrent.atomic.AtomicBoolean r3 = r7.f5348b
            r4 = 1
            if (r2 == 0) goto L_0x0061
            int r5 = r7.f5350d
            if (r5 != 0) goto L_0x0055
            boolean r5 = r3.get()
            if (r5 != 0) goto L_0x0061
        L_0x0055:
            java.util.function.Predicate r5 = r7.f5351e
            java.lang.Object r6 = r7.f5352f
            boolean r5 = r5.test(r6)
            if (r5 == 0) goto L_0x0061
            r0 = 1
            goto L_0x0042
        L_0x0061:
            if (r2 == 0) goto L_0x0072
            if (r0 == 0) goto L_0x0068
            r3.set(r4)
        L_0x0068:
            java.lang.Object r0 = r7.f5352f
            r8.accept(r0)
            goto L_0x0072
        L_0x006e:
            boolean r2 = r1.tryAdvance(r8)
        L_0x0072:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.J3.tryAdvance(java.util.function.Consumer):boolean");
    }

    public i0 trySplit() {
        switch (this.f5353g) {
            case 1:
                if (this.f5348b.get()) {
                    return null;
                }
                return b();
            default:
                return b();
        }
    }
}
