package D3;

import E3.c;
import N3.C2515f;

public abstract class y {

    class a extends y {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f23212a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ byte[] f23213b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f23214c;

        a(C2472t tVar, int i4, byte[] bArr, int i5) {
            this.f23212a = i4;
            this.f23213b = bArr;
            this.f23214c = i5;
        }

        public long a() {
            return (long) this.f23212a;
        }

        public C2472t b() {
            return null;
        }

        public void e(C2515f fVar) {
            fVar.write(this.f23213b, this.f23214c, this.f23212a);
        }
    }

    public static y c(C2472t tVar, byte[] bArr) {
        return d(tVar, bArr, 0, bArr.length);
    }

    public static y d(C2472t tVar, byte[] bArr, int i4, int i5) {
        if (bArr != null) {
            c.c((long) bArr.length, (long) i4, (long) i5);
            return new a(tVar, i5, bArr, i4);
        }
        throw new NullPointerException("content == null");
    }

    public abstract long a();

    public abstract C2472t b();

    public abstract void e(C2515f fVar);
}
