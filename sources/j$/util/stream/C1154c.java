package j$.util.stream;

/* renamed from: j$.util.stream.c  reason: case insensitive filesystem */
public abstract class C1154c {

    /* renamed from: a  reason: collision with root package name */
    public final int f5477a;

    /* renamed from: b  reason: collision with root package name */
    public int f5478b;

    /* renamed from: c  reason: collision with root package name */
    public int f5479c;

    /* renamed from: d  reason: collision with root package name */
    public long[] f5480d;

    public abstract void clear();

    public C1154c() {
        this.f5477a = 4;
    }

    public C1154c(int i4) {
        if (i4 >= 0) {
            this.f5477a = Math.max(4, 32 - Integer.numberOfLeadingZeros(i4 - 1));
            return;
        }
        throw new IllegalArgumentException("Illegal Capacity: " + i4);
    }

    public final long count() {
        int i4 = this.f5479c;
        if (i4 == 0) {
            return (long) this.f5478b;
        }
        return this.f5480d[i4] + ((long) this.f5478b);
    }
}
