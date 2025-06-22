package G0;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public final b f6521a;

    /* renamed from: b  reason: collision with root package name */
    public final a f6522b;

    /* renamed from: c  reason: collision with root package name */
    public final long f6523c;

    /* renamed from: d  reason: collision with root package name */
    public final int f6524d;

    /* renamed from: e  reason: collision with root package name */
    public final int f6525e;

    /* renamed from: f  reason: collision with root package name */
    public final double f6526f;

    /* renamed from: g  reason: collision with root package name */
    public final double f6527g;

    /* renamed from: h  reason: collision with root package name */
    public final int f6528h;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f6529a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f6530b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f6531c;

        public a(boolean z4, boolean z5, boolean z6) {
            this.f6529a = z4;
            this.f6530b = z5;
            this.f6531c = z6;
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f6532a;

        /* renamed from: b  reason: collision with root package name */
        public final int f6533b;

        public b(int i4, int i5) {
            this.f6532a = i4;
            this.f6533b = i5;
        }
    }

    public d(long j4, b bVar, a aVar, int i4, int i5, double d5, double d6, int i6) {
        this.f6523c = j4;
        this.f6521a = bVar;
        this.f6522b = aVar;
        this.f6524d = i4;
        this.f6525e = i5;
        this.f6526f = d5;
        this.f6527g = d6;
        this.f6528h = i6;
    }

    public boolean a(long j4) {
        if (this.f6523c < j4) {
            return true;
        }
        return false;
    }
}
