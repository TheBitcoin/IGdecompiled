package N0;

import java.io.OutputStream;

final class b extends OutputStream {

    /* renamed from: a  reason: collision with root package name */
    private long f7750a = 0;

    b() {
    }

    /* access modifiers changed from: package-private */
    public long a() {
        return this.f7750a;
    }

    public void write(int i4) {
        this.f7750a++;
    }

    public void write(byte[] bArr) {
        this.f7750a += (long) bArr.length;
    }

    public void write(byte[] bArr, int i4, int i5) {
        int i6;
        if (i4 < 0 || i4 > bArr.length || i5 < 0 || (i6 = i4 + i5) > bArr.length || i6 < 0) {
            throw new IndexOutOfBoundsException();
        }
        this.f7750a += (long) i5;
    }
}
