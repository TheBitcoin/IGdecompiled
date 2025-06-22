package n3;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f21363a = false;

    /* renamed from: b  reason: collision with root package name */
    private static final ThreadLocal[] f21364b;

    static {
        ThreadLocal[] threadLocalArr = new ThreadLocal[4];
        for (int i4 = 0; i4 < 4; i4++) {
            threadLocalArr[i4] = new ThreadLocal();
        }
        f21364b = threadLocalArr;
    }

    public static final boolean a() {
        return f21363a;
    }
}
