package m0;

import java.util.NoSuchElementException;
import l0.h;

/* renamed from: m0.a  reason: case insensitive filesystem */
abstract class C2133a extends T {

    /* renamed from: a  reason: collision with root package name */
    private final int f21084a;

    /* renamed from: b  reason: collision with root package name */
    private int f21085b;

    protected C2133a(int i4, int i5) {
        h.k(i5, i4);
        this.f21084a = i4;
        this.f21085b = i5;
    }

    /* access modifiers changed from: protected */
    public abstract Object a(int i4);

    public final boolean hasNext() {
        if (this.f21085b < this.f21084a) {
            return true;
        }
        return false;
    }

    public final boolean hasPrevious() {
        if (this.f21085b > 0) {
            return true;
        }
        return false;
    }

    public final Object next() {
        if (hasNext()) {
            int i4 = this.f21085b;
            this.f21085b = i4 + 1;
            return a(i4);
        }
        throw new NoSuchElementException();
    }

    public final int nextIndex() {
        return this.f21085b;
    }

    public final Object previous() {
        if (hasPrevious()) {
            int i4 = this.f21085b - 1;
            this.f21085b = i4;
            return a(i4);
        }
        throw new NoSuchElementException();
    }

    public final int previousIndex() {
        return this.f21085b - 1;
    }
}
