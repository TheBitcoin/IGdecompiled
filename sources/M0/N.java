package m0;

import l0.h;

final class N extends r {

    /* renamed from: c  reason: collision with root package name */
    final transient Object f21083c;

    N(Object obj) {
        this.f21083c = h.i(obj);
    }

    /* access modifiers changed from: package-private */
    public int c(Object[] objArr, int i4) {
        objArr[i4] = this.f21083c;
        return i4 + 1;
    }

    public boolean contains(Object obj) {
        return this.f21083c.equals(obj);
    }

    public final int hashCode() {
        return this.f21083c.hashCode();
    }

    /* access modifiers changed from: package-private */
    public boolean k() {
        return false;
    }

    public int size() {
        return 1;
    }

    public String toString() {
        String obj = this.f21083c.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 2);
        sb.append('[');
        sb.append(obj);
        sb.append(']');
        return sb.toString();
    }

    /* renamed from: w */
    public S iterator() {
        return w.c(this.f21083c);
    }
}
