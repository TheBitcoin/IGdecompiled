package j$.util.stream;

public abstract class G0 implements E0 {

    /* renamed from: a  reason: collision with root package name */
    public final E0 f5294a;

    /* renamed from: b  reason: collision with root package name */
    public final E0 f5295b;

    /* renamed from: c  reason: collision with root package name */
    public final long f5296c;

    public final int p() {
        return 2;
    }

    public G0(E0 e02, E0 e03) {
        this.f5294a = e02;
        this.f5295b = e03;
        this.f5296c = e03.count() + e02.count();
    }

    public final E0 b(int i4) {
        if (i4 == 0) {
            return this.f5294a;
        }
        if (i4 == 1) {
            return this.f5295b;
        }
        throw new IndexOutOfBoundsException();
    }

    public final long count() {
        return this.f5296c;
    }
}
