package j$.time.temporal;

import com.mbridge.msdk.playercommon.exoplayer2.C;

public enum a implements q {
    NANO_OF_SECOND("NanoOfSecond", u.e(0, 999999999)),
    NANO_OF_DAY("NanoOfDay", u.e(0, 86399999999999L)),
    MICRO_OF_SECOND("MicroOfSecond", u.e(0, 999999)),
    MICRO_OF_DAY("MicroOfDay", u.e(0, 86399999999L)),
    MILLI_OF_SECOND("MilliOfSecond", u.e(0, 999)),
    MILLI_OF_DAY("MilliOfDay", u.e(0, 86399999)),
    SECOND_OF_MINUTE("SecondOfMinute", u.e(0, 59), 0),
    SECOND_OF_DAY("SecondOfDay", u.e(0, 86399)),
    MINUTE_OF_HOUR("MinuteOfHour", u.e(0, 59), 0),
    MINUTE_OF_DAY("MinuteOfDay", u.e(0, 1439)),
    HOUR_OF_AMPM("HourOfAmPm", u.e(0, 11)),
    CLOCK_HOUR_OF_AMPM("ClockHourOfAmPm", u.e(1, 12)),
    HOUR_OF_DAY("HourOfDay", u.e(0, 23), 0),
    CLOCK_HOUR_OF_DAY("ClockHourOfDay", u.e(1, 24)),
    AMPM_OF_DAY("AmPmOfDay", u.e(0, 1), 0),
    DAY_OF_WEEK("DayOfWeek", u.e(1, 7), 0),
    ALIGNED_DAY_OF_WEEK_IN_MONTH("AlignedDayOfWeekInMonth", u.e(1, 7)),
    ALIGNED_DAY_OF_WEEK_IN_YEAR("AlignedDayOfWeekInYear", u.e(1, 7)),
    DAY_OF_MONTH("DayOfMonth", u.f(28, 31), 0),
    DAY_OF_YEAR("DayOfYear", u.f(365, 366)),
    EPOCH_DAY("EpochDay", u.e(-365243219162L, 365241780471L)),
    ALIGNED_WEEK_OF_MONTH("AlignedWeekOfMonth", u.f(4, 5)),
    ALIGNED_WEEK_OF_YEAR("AlignedWeekOfYear", u.e(1, 53)),
    MONTH_OF_YEAR("MonthOfYear", u.e(1, 12), 0),
    PROLEPTIC_MONTH("ProlepticMonth", u.e(-11999999988L, 11999999999L)),
    YEAR_OF_ERA("YearOfEra", u.f(999999999, C.NANOS_PER_SECOND)),
    YEAR("Year", u.e(-999999999, 999999999), 0),
    ERA("Era", u.e(0, 1), 0),
    INSTANT_SECONDS("InstantSeconds", u.e(Long.MIN_VALUE, Long.MAX_VALUE)),
    OFFSET_SECONDS("OffsetSeconds", u.e(-64800, 64800));
    

    /* renamed from: a  reason: collision with root package name */
    public final String f5013a;

    /* renamed from: b  reason: collision with root package name */
    public final u f5014b;

    /* access modifiers changed from: public */
    a(String str, u uVar) {
        this.f5013a = str;
        this.f5014b = uVar;
    }

    /* access modifiers changed from: public */
    a(String str, u uVar, int i4) {
        this.f5013a = str;
        this.f5014b = uVar;
    }

    public final u j() {
        return this.f5014b;
    }

    public final boolean t() {
        return ordinal() >= DAY_OF_WEEK.ordinal() && ordinal() <= ERA.ordinal();
    }

    public final boolean C() {
        return ordinal() < DAY_OF_WEEK.ordinal();
    }

    public final void w(long j4) {
        this.f5014b.b(j4, this);
    }

    public final boolean m(n nVar) {
        return nVar.f(this);
    }

    public final u p(n nVar) {
        return nVar.n(this);
    }

    public final long k(n nVar) {
        return nVar.t(this);
    }

    public final m n(m mVar, long j4) {
        return mVar.d(j4, this);
    }

    public final String toString() {
        return this.f5013a;
    }
}
