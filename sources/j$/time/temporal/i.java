package j$.time.temporal;

import j$.com.android.tools.r8.a;

public enum i implements s {
    WEEK_BASED_YEARS("WeekBasedYears"),
    QUARTER_YEARS("QuarterYears");
    

    /* renamed from: a  reason: collision with root package name */
    public final String f5021a;

    /* access modifiers changed from: public */
    i(String str) {
        this.f5021a = str;
    }

    public final m j(m mVar, long j4) {
        int i4 = c.f5017a[ordinal()];
        if (i4 == 1) {
            h hVar = j.f5024c;
            return mVar.d(a.x((long) mVar.k(hVar), j4), hVar);
        } else if (i4 == 2) {
            return mVar.e(j4 / 4, b.YEARS).e((j4 % 4) * 3, b.MONTHS);
        } else {
            throw new IllegalStateException("Unreachable");
        }
    }

    public final String toString() {
        return this.f5021a;
    }
}
