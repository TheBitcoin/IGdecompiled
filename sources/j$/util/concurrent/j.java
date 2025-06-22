package j$.util.concurrent;

import j$.util.C1127b;
import j$.util.i0;
import java.util.Comparator;
import java.util.function.Consumer;

public final class j extends p implements i0 {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f5147i;

    /* renamed from: j  reason: collision with root package name */
    public long f5148j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j(l[] lVarArr, int i4, int i5, int i6, long j4, int i7) {
        super(lVarArr, i4, i5, i6);
        this.f5147i = i7;
        this.f5148j = j4;
    }

    public final int characteristics() {
        switch (this.f5147i) {
            case 0:
                return 4353;
            default:
                return 4352;
        }
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        switch (this.f5147i) {
            case 0:
                return C1127b.d(this);
            default:
                return C1127b.d(this);
        }
    }

    public final /* synthetic */ boolean hasCharacteristics(int i4) {
        switch (this.f5147i) {
            case 0:
                return C1127b.e(this, i4);
            default:
                return C1127b.e(this, i4);
        }
    }

    public final Comparator getComparator() {
        switch (this.f5147i) {
            case 0:
                throw new IllegalStateException();
            default:
                throw new IllegalStateException();
        }
    }

    public final i0 trySplit() {
        switch (this.f5147i) {
            case 0:
                int i4 = this.f5165f;
                int i5 = this.f5166g;
                int i6 = (i4 + i5) >>> 1;
                if (i6 <= i4) {
                    return null;
                }
                l[] lVarArr = this.f5160a;
                this.f5166g = i6;
                long j4 = this.f5148j >>> 1;
                this.f5148j = j4;
                return new j(lVarArr, this.f5167h, i6, i5, j4, 0);
            default:
                int i7 = this.f5165f;
                int i8 = this.f5166g;
                int i9 = (i7 + i8) >>> 1;
                if (i9 <= i7) {
                    return null;
                }
                l[] lVarArr2 = this.f5160a;
                this.f5166g = i9;
                long j5 = this.f5148j >>> 1;
                this.f5148j = j5;
                return new j(lVarArr2, this.f5167h, i9, i8, j5, 1);
        }
    }

    public final void forEachRemaining(Consumer consumer) {
        switch (this.f5147i) {
            case 0:
                consumer.getClass();
                while (true) {
                    l a5 = a();
                    if (a5 != null) {
                        consumer.accept(a5.f5153b);
                    } else {
                        return;
                    }
                }
            default:
                consumer.getClass();
                while (true) {
                    l a6 = a();
                    if (a6 != null) {
                        consumer.accept(a6.f5154c);
                    } else {
                        return;
                    }
                }
        }
    }

    public final boolean tryAdvance(Consumer consumer) {
        switch (this.f5147i) {
            case 0:
                consumer.getClass();
                l a5 = a();
                if (a5 == null) {
                    return false;
                }
                consumer.accept(a5.f5153b);
                return true;
            default:
                consumer.getClass();
                l a6 = a();
                if (a6 == null) {
                    return false;
                }
                consumer.accept(a6.f5154c);
                return true;
        }
    }

    public final long estimateSize() {
        switch (this.f5147i) {
            case 0:
                return this.f5148j;
            default:
                return this.f5148j;
        }
    }
}
