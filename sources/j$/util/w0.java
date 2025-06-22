package j$.util;

public abstract class w0 {

    /* renamed from: a  reason: collision with root package name */
    public static final s0 f5672a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static final q0 f5673b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public static final r0 f5674c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public static final p0 f5675d = new Object();

    public static void a(int i4, int i5, int i6) {
        if (i5 > i6) {
            throw new ArrayIndexOutOfBoundsException("origin(" + i5 + ") > fence(" + i6 + ")");
        } else if (i5 < 0) {
            throw new ArrayIndexOutOfBoundsException(i5);
        } else if (i6 > i4) {
            throw new ArrayIndexOutOfBoundsException(i6);
        }
    }
}
