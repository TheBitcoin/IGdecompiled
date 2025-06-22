package m0;

import j$.util.Objects;
import l0.h;

class I extends C2147o {

    /* renamed from: e  reason: collision with root package name */
    static final C2147o f21052e = new I(new Object[0], 0);

    /* renamed from: c  reason: collision with root package name */
    final transient Object[] f21053c;

    /* renamed from: d  reason: collision with root package name */
    private final transient int f21054d;

    I(Object[] objArr, int i4) {
        this.f21053c = objArr;
        this.f21054d = i4;
    }

    /* access modifiers changed from: package-private */
    public int c(Object[] objArr, int i4) {
        System.arraycopy(this.f21053c, 0, objArr, i4, this.f21054d);
        return i4 + this.f21054d;
    }

    /* access modifiers changed from: package-private */
    public Object[] g() {
        return this.f21053c;
    }

    public Object get(int i4) {
        h.g(i4, this.f21054d);
        Object obj = this.f21053c[i4];
        Objects.requireNonNull(obj);
        return obj;
    }

    /* access modifiers changed from: package-private */
    public int h() {
        return this.f21054d;
    }

    /* access modifiers changed from: package-private */
    public int j() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public boolean k() {
        return false;
    }

    public int size() {
        return this.f21054d;
    }
}
