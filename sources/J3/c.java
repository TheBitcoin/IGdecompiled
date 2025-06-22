package j3;

import S2.E;
import java.util.NoSuchElementException;

public final class c extends E {

    /* renamed from: a  reason: collision with root package name */
    private final int f20923a;

    /* renamed from: b  reason: collision with root package name */
    private final int f20924b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f20925c;

    /* renamed from: d  reason: collision with root package name */
    private int f20926d;

    public c(int i4, int i5, int i6) {
        this.f20923a = i6;
        this.f20924b = i5;
        boolean z4 = false;
        if (i6 <= 0 ? i4 >= i5 : i4 <= i5) {
            z4 = true;
        }
        this.f20925c = z4;
        this.f20926d = !z4 ? i5 : i4;
    }

    public boolean hasNext() {
        return this.f20925c;
    }

    public int nextInt() {
        int i4 = this.f20926d;
        if (i4 != this.f20924b) {
            this.f20926d = this.f20923a + i4;
            return i4;
        } else if (this.f20925c) {
            this.f20925c = false;
            return i4;
        } else {
            throw new NoSuchElementException();
        }
    }
}
