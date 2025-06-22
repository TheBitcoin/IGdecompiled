package j$.util.stream;

import j$.util.C1127b;
import j$.util.Objects;
import j$.util.f0;
import java.util.Comparator;

public abstract class Q2 implements f0 {

    /* renamed from: a  reason: collision with root package name */
    public int f5390a;

    /* renamed from: b  reason: collision with root package name */
    public final int f5391b;

    /* renamed from: c  reason: collision with root package name */
    public int f5392c;

    /* renamed from: d  reason: collision with root package name */
    public final int f5393d;

    /* renamed from: e  reason: collision with root package name */
    public Object f5394e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ R2 f5395f;

    public abstract void a(int i4, Object obj, Object obj2);

    public abstract f0 b(Object obj, int i4, int i5);

    public abstract f0 c(int i4, int i5, int i6, int i7);

    public final int characteristics() {
        return 16464;
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return C1127b.d(this);
    }

    public final /* synthetic */ boolean hasCharacteristics(int i4) {
        return C1127b.e(this, i4);
    }

    public final Comparator getComparator() {
        throw new IllegalStateException();
    }

    public Q2(R2 r22, int i4, int i5, int i6, int i7) {
        this.f5395f = r22;
        this.f5390a = i4;
        this.f5391b = i5;
        this.f5392c = i6;
        this.f5393d = i7;
        Object[] objArr = r22.f5397f;
        this.f5394e = objArr == null ? r22.f5396e : objArr[i4];
    }

    public final long estimateSize() {
        int i4 = this.f5390a;
        int i5 = this.f5393d;
        int i6 = this.f5391b;
        if (i4 == i6) {
            return ((long) i5) - ((long) this.f5392c);
        }
        long[] jArr = this.f5395f.f5480d;
        return ((jArr[i6] + ((long) i5)) - jArr[i4]) - ((long) this.f5392c);
    }

    public final boolean tryAdvance(Object obj) {
        Objects.requireNonNull(obj);
        int i4 = this.f5390a;
        int i5 = this.f5391b;
        if (i4 >= i5 && (i4 != i5 || this.f5392c >= this.f5393d)) {
            return false;
        }
        Object obj2 = this.f5394e;
        int i6 = this.f5392c;
        this.f5392c = i6 + 1;
        a(i6, obj2, obj);
        int i7 = this.f5392c;
        Object obj3 = this.f5394e;
        R2 r22 = this.f5395f;
        if (i7 == r22.s(obj3)) {
            this.f5392c = 0;
            int i8 = this.f5390a + 1;
            this.f5390a = i8;
            Object[] objArr = r22.f5397f;
            if (objArr != null && i8 <= i5) {
                this.f5394e = objArr[i8];
            }
        }
        return true;
    }

    public final void forEachRemaining(Object obj) {
        R2 r22;
        Objects.requireNonNull(obj);
        int i4 = this.f5390a;
        int i5 = this.f5393d;
        int i6 = this.f5391b;
        if (i4 < i6 || (i4 == i6 && this.f5392c < i5)) {
            int i7 = this.f5392c;
            while (true) {
                r22 = this.f5395f;
                if (i4 >= i6) {
                    break;
                }
                Object obj2 = r22.f5397f[i4];
                r22.r(obj2, i7, r22.s(obj2), obj);
                i4++;
                i7 = 0;
            }
            r22.r(this.f5390a == i6 ? this.f5394e : r22.f5397f[i6], i7, i5, obj);
            this.f5390a = i6;
            this.f5392c = i5;
        }
    }

    public final f0 trySplit() {
        int i4 = this.f5390a;
        int i5 = this.f5391b;
        if (i4 < i5) {
            int i6 = i5 - 1;
            int i7 = this.f5392c;
            R2 r22 = this.f5395f;
            f0 c5 = c(i4, i6, i7, r22.s(r22.f5397f[i6]));
            this.f5390a = i5;
            this.f5392c = 0;
            this.f5394e = r22.f5397f[i5];
            return c5;
        } else if (i4 != i5) {
            return null;
        } else {
            int i8 = this.f5392c;
            int i9 = (this.f5393d - i8) / 2;
            if (i9 == 0) {
                return null;
            }
            f0 b5 = b(this.f5394e, i8, i9);
            this.f5392c += i9;
            return b5;
        }
    }
}
