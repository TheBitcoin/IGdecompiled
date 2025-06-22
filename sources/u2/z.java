package u2;

public final class z {

    /* renamed from: a  reason: collision with root package name */
    public static final z f21956a = new z();

    /* renamed from: b  reason: collision with root package name */
    private static boolean f21957b;

    /* renamed from: c  reason: collision with root package name */
    private static int f21958c;

    /* renamed from: d  reason: collision with root package name */
    private static int f21959d;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f21960e;

    private z() {
    }

    public final int a() {
        return f21958c;
    }

    public final int b() {
        return f21959d;
    }

    public final boolean c() {
        int i4 = f21958c;
        if (i4 == 0) {
            return true;
        }
        if (!f21957b) {
            return false;
        }
        if (f21960e || i4 >= 4300) {
            return true;
        }
        return false;
    }

    public final boolean d() {
        return f21957b;
    }

    public final boolean e() {
        if (!f21957b) {
            return false;
        }
        if (f21960e || f21959d >= 9152) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        return f21960e;
    }

    public final void g(int i4) {
        f21958c = i4;
    }

    public final void h(boolean z4) {
        f21957b = z4;
    }

    public final void i(int i4) {
        f21959d = i4;
    }

    public final void j(boolean z4) {
        f21960e = z4;
    }
}
