package j$.util.stream;

import j$.util.C1127b;
import j$.util.i0;
import java.util.ArrayDeque;
import java.util.Comparator;

/* renamed from: j$.util.stream.h1  reason: case insensitive filesystem */
public abstract class C1181h1 implements i0 {

    /* renamed from: a  reason: collision with root package name */
    public E0 f5509a;

    /* renamed from: b  reason: collision with root package name */
    public int f5510b;

    /* renamed from: c  reason: collision with root package name */
    public i0 f5511c;

    /* renamed from: d  reason: collision with root package name */
    public i0 f5512d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayDeque f5513e;

    public final int characteristics() {
        return 64;
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

    public C1181h1(E0 e02) {
        this.f5509a = e02;
    }

    public final ArrayDeque b() {
        ArrayDeque arrayDeque = new ArrayDeque(8);
        int p4 = this.f5509a.p();
        while (true) {
            p4--;
            if (p4 < this.f5510b) {
                return arrayDeque;
            }
            arrayDeque.addFirst(this.f5509a.b(p4));
        }
    }

    public static E0 a(ArrayDeque arrayDeque) {
        while (true) {
            E0 e02 = (E0) arrayDeque.pollFirst();
            if (e02 == null) {
                return null;
            }
            if (e02.p() != 0) {
                for (int p4 = e02.p() - 1; p4 >= 0; p4--) {
                    arrayDeque.addFirst(e02.b(p4));
                }
            } else if (e02.count() > 0) {
                return e02;
            }
        }
    }

    public final boolean c() {
        if (this.f5509a == null) {
            return false;
        }
        if (this.f5512d != null) {
            return true;
        }
        i0 i0Var = this.f5511c;
        if (i0Var == null) {
            ArrayDeque b5 = b();
            this.f5513e = b5;
            E0 a5 = a(b5);
            if (a5 != null) {
                this.f5512d = a5.spliterator();
                return true;
            }
            this.f5509a = null;
            return false;
        }
        this.f5512d = i0Var;
        return true;
    }

    public final i0 trySplit() {
        E0 e02 = this.f5509a;
        if (e02 == null || this.f5512d != null) {
            return null;
        }
        i0 i0Var = this.f5511c;
        if (i0Var != null) {
            return i0Var.trySplit();
        }
        if (this.f5510b < e02.p() - 1) {
            E0 e03 = this.f5509a;
            int i4 = this.f5510b;
            this.f5510b = i4 + 1;
            return e03.b(i4).spliterator();
        }
        E0 b5 = this.f5509a.b(this.f5510b);
        this.f5509a = b5;
        if (b5.p() == 0) {
            i0 spliterator = this.f5509a.spliterator();
            this.f5511c = spliterator;
            return spliterator.trySplit();
        }
        E0 e04 = this.f5509a;
        this.f5510b = 1;
        return e04.b(0).spliterator();
    }

    public final long estimateSize() {
        long j4 = 0;
        if (this.f5509a == null) {
            return 0;
        }
        i0 i0Var = this.f5511c;
        if (i0Var != null) {
            return i0Var.estimateSize();
        }
        for (int i4 = this.f5510b; i4 < this.f5509a.p(); i4++) {
            j4 += this.f5509a.b(i4).count();
        }
        return j4;
    }
}
