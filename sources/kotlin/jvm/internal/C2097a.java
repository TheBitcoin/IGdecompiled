package kotlin.jvm.internal;

import e3.a;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: kotlin.jvm.internal.a  reason: case insensitive filesystem */
final class C2097a implements Iterator, a {

    /* renamed from: a  reason: collision with root package name */
    private final Object[] f20972a;

    /* renamed from: b  reason: collision with root package name */
    private int f20973b;

    public C2097a(Object[] objArr) {
        m.e(objArr, "array");
        this.f20972a = objArr;
    }

    public boolean hasNext() {
        if (this.f20973b < this.f20972a.length) {
            return true;
        }
        return false;
    }

    public Object next() {
        try {
            Object[] objArr = this.f20972a;
            int i4 = this.f20973b;
            this.f20973b = i4 + 1;
            return objArr[i4];
        } catch (ArrayIndexOutOfBoundsException e5) {
            this.f20973b--;
            throw new NoSuchElementException(e5.getMessage());
        }
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
