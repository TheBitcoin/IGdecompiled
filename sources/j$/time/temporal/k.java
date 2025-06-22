package j$.time.temporal;

import j$.com.android.tools.r8.a;

public enum k implements q {
    JULIAN_DAY("JulianDay", 2440588),
    MODIFIED_JULIAN_DAY("ModifiedJulianDay", 40587),
    RATA_DIE("RataDie", 719163);
    
    private static final long serialVersionUID = -7501623920830201812L;

    /* renamed from: a  reason: collision with root package name */
    public final transient String f5026a;

    /* renamed from: b  reason: collision with root package name */
    public final transient u f5027b;

    /* renamed from: c  reason: collision with root package name */
    public final transient long f5028c;

    public final boolean t() {
        return true;
    }

    /* access modifiers changed from: public */
    k(String str, long j4) {
        this.f5026a = str;
        this.f5027b = u.e(-365243219162L + j4, 365241780471L + j4);
        this.f5028c = j4;
    }

    public final u j() {
        return this.f5027b;
    }

    public final boolean m(n nVar) {
        return nVar.f(a.EPOCH_DAY);
    }

    public final u p(n nVar) {
        if (nVar.f(a.EPOCH_DAY)) {
            return this.f5027b;
        }
        throw new RuntimeException("Unsupported field: " + this);
    }

    public final long k(n nVar) {
        return nVar.t(a.EPOCH_DAY) + this.f5028c;
    }

    public final m n(m mVar, long j4) {
        if (this.f5027b.d(j4)) {
            return mVar.d(a.C(j4, this.f5028c), a.EPOCH_DAY);
        }
        throw new RuntimeException("Invalid value: " + this.f5026a + " " + j4);
    }

    public final String toString() {
        return this.f5026a;
    }
}
