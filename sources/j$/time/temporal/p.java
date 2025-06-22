package j$.time.temporal;

public final /* synthetic */ class p implements o {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f5030a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f5031b;

    public /* synthetic */ p(int i4, int i5) {
        this.f5030a = i5;
        this.f5031b = i4;
    }

    public final m w(m mVar) {
        switch (this.f5030a) {
            case 0:
                int k4 = mVar.k(a.DAY_OF_WEEK);
                int i4 = this.f5031b;
                if (k4 == i4) {
                    return mVar;
                }
                int i5 = k4 - i4;
                return mVar.e((long) (i5 >= 0 ? 7 - i5 : -i5), b.DAYS);
            default:
                int k5 = mVar.k(a.DAY_OF_WEEK);
                int i6 = this.f5031b;
                if (k5 == i6) {
                    return mVar;
                }
                int i7 = i6 - k5;
                return mVar.j((long) (i7 >= 0 ? 7 - i7 : -i7), b.DAYS);
        }
    }
}
