package m0;

final class K extends r {

    /* renamed from: h  reason: collision with root package name */
    private static final Object[] f21069h;

    /* renamed from: i  reason: collision with root package name */
    static final K f21070i;

    /* renamed from: c  reason: collision with root package name */
    final transient Object[] f21071c;

    /* renamed from: d  reason: collision with root package name */
    private final transient int f21072d;

    /* renamed from: e  reason: collision with root package name */
    final transient Object[] f21073e;

    /* renamed from: f  reason: collision with root package name */
    private final transient int f21074f;

    /* renamed from: g  reason: collision with root package name */
    private final transient int f21075g;

    static {
        Object[] objArr = new Object[0];
        f21069h = objArr;
        f21070i = new K(objArr, 0, objArr, 0, 0);
    }

    K(Object[] objArr, int i4, Object[] objArr2, int i5, int i6) {
        this.f21071c = objArr;
        this.f21072d = i4;
        this.f21073e = objArr2;
        this.f21074f = i5;
        this.f21075g = i6;
    }

    /* access modifiers changed from: package-private */
    public int c(Object[] objArr, int i4) {
        System.arraycopy(this.f21071c, 0, objArr, i4, this.f21075g);
        return i4 + this.f21075g;
    }

    public boolean contains(Object obj) {
        Object[] objArr = this.f21073e;
        if (obj == null || objArr.length == 0) {
            return false;
        }
        int c5 = C2145m.c(obj);
        while (true) {
            int i4 = c5 & this.f21074f;
            Object obj2 = objArr[i4];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            c5 = i4 + 1;
        }
    }

    /* access modifiers changed from: package-private */
    public Object[] g() {
        return this.f21071c;
    }

    /* access modifiers changed from: package-private */
    public int h() {
        return this.f21075g;
    }

    public int hashCode() {
        return this.f21072d;
    }

    /* access modifiers changed from: package-private */
    public int j() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public boolean k() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public C2147o p() {
        return C2147o.m(this.f21071c, this.f21075g);
    }

    /* access modifiers changed from: package-private */
    public boolean q() {
        return true;
    }

    public int size() {
        return this.f21075g;
    }

    /* renamed from: w */
    public S iterator() {
        return l().iterator();
    }
}
