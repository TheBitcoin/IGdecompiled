package j$.time.temporal;

public enum b implements s {
    NANOS("Nanos"),
    MICROS("Micros"),
    MILLIS("Millis"),
    SECONDS("Seconds"),
    MINUTES("Minutes"),
    HOURS("Hours"),
    HALF_DAYS("HalfDays"),
    DAYS("Days"),
    WEEKS("Weeks"),
    MONTHS("Months"),
    YEARS("Years"),
    DECADES("Decades"),
    CENTURIES("Centuries"),
    MILLENNIA("Millennia"),
    ERAS("Eras"),
    FOREVER("Forever");
    

    /* renamed from: a  reason: collision with root package name */
    public final String f5016a;

    /* access modifiers changed from: public */
    b(String str) {
        this.f5016a = str;
    }

    public final m j(m mVar, long j4) {
        return mVar.e(j4, this);
    }

    public final String toString() {
        return this.f5016a;
    }
}
