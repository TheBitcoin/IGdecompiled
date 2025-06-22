package j$.util.stream;

import j$.util.C1127b;
import j$.util.Objects;
import j$.util.i0;
import j$.util.n0;
import java.util.Comparator;
import java.util.function.Consumer;

public final class J2 implements i0 {

    /* renamed from: a  reason: collision with root package name */
    public int f5341a;

    /* renamed from: b  reason: collision with root package name */
    public final int f5342b;

    /* renamed from: c  reason: collision with root package name */
    public int f5343c;

    /* renamed from: d  reason: collision with root package name */
    public final int f5344d;

    /* renamed from: e  reason: collision with root package name */
    public Object[] f5345e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ S2 f5346f;

    public final int characteristics() {
        return 16464;
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return C1127b.d(this);
    }

    public final /* synthetic */ boolean hasCharacteristics(int i4) {
        return C1127b.e(this, i4);
    }

    public J2(S2 s22, int i4, int i5, int i6, int i7) {
        this.f5346f = s22;
        this.f5341a = i4;
        this.f5342b = i5;
        this.f5343c = i6;
        this.f5344d = i7;
        Object[][] objArr = s22.f5403f;
        this.f5345e = objArr == null ? s22.f5402e : objArr[i4];
    }

    public final long estimateSize() {
        int i4 = this.f5341a;
        int i5 = this.f5344d;
        int i6 = this.f5342b;
        if (i4 == i6) {
            return ((long) i5) - ((long) this.f5343c);
        }
        long[] jArr = this.f5346f.f5480d;
        return ((jArr[i6] + ((long) i5)) - jArr[i4]) - ((long) this.f5343c);
    }

    public final boolean tryAdvance(Consumer consumer) {
        Objects.requireNonNull(consumer);
        int i4 = this.f5341a;
        int i5 = this.f5342b;
        if (i4 >= i5 && (i4 != i5 || this.f5343c >= this.f5344d)) {
            return false;
        }
        Object[] objArr = this.f5345e;
        int i6 = this.f5343c;
        this.f5343c = i6 + 1;
        consumer.accept(objArr[i6]);
        if (this.f5343c == this.f5345e.length) {
            this.f5343c = 0;
            int i7 = this.f5341a + 1;
            this.f5341a = i7;
            Object[][] objArr2 = this.f5346f.f5403f;
            if (objArr2 != null && i7 <= i5) {
                this.f5345e = objArr2[i7];
            }
        }
        return true;
    }

    public final void forEachRemaining(Consumer consumer) {
        S2 s22;
        Objects.requireNonNull(consumer);
        int i4 = this.f5341a;
        int i5 = this.f5344d;
        int i6 = this.f5342b;
        if (i4 < i6 || (i4 == i6 && this.f5343c < i5)) {
            int i7 = this.f5343c;
            while (true) {
                s22 = this.f5346f;
                if (i4 >= i6) {
                    break;
                }
                Object[] objArr = s22.f5403f[i4];
                while (i7 < objArr.length) {
                    consumer.accept(objArr[i7]);
                    i7++;
                }
                i4++;
                i7 = 0;
            }
            Object[] objArr2 = this.f5341a == i6 ? this.f5345e : s22.f5403f[i6];
            while (i7 < i5) {
                consumer.accept(objArr2[i7]);
                i7++;
            }
            this.f5341a = i6;
            this.f5343c = i5;
        }
    }

    public final i0 trySplit() {
        int i4 = this.f5341a;
        int i5 = this.f5342b;
        if (i4 < i5) {
            int i6 = i5 - 1;
            int i7 = this.f5343c;
            S2 s22 = this.f5346f;
            J2 j22 = new J2(s22, i4, i6, i7, s22.f5403f[i6].length);
            this.f5341a = i5;
            this.f5343c = 0;
            this.f5345e = s22.f5403f[i5];
            return j22;
        } else if (i4 != i5) {
            return null;
        } else {
            int i8 = this.f5343c;
            int i9 = (this.f5344d - i8) / 2;
            if (i9 == 0) {
                return null;
            }
            n0 x4 = C1127b.x(this.f5345e, i8, i8 + i9);
            this.f5343c += i9;
            return x4;
        }
    }

    public final Comparator getComparator() {
        throw new IllegalStateException();
    }
}
