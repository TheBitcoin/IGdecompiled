package p;

import java.util.Arrays;
import p.q;

final class g extends q {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f3820a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f3821b;

    static final class b extends q.a {

        /* renamed from: a  reason: collision with root package name */
        private byte[] f3822a;

        /* renamed from: b  reason: collision with root package name */
        private byte[] f3823b;

        b() {
        }

        public q a() {
            return new g(this.f3822a, this.f3823b);
        }

        public q.a b(byte[] bArr) {
            this.f3822a = bArr;
            return this;
        }

        public q.a c(byte[] bArr) {
            this.f3823b = bArr;
            return this;
        }
    }

    public byte[] b() {
        return this.f3820a;
    }

    public byte[] c() {
        return this.f3821b;
    }

    public boolean equals(Object obj) {
        byte[] bArr;
        byte[] bArr2;
        if (obj == this) {
            return true;
        }
        if (obj instanceof q) {
            q qVar = (q) obj;
            byte[] bArr3 = this.f3820a;
            boolean z4 = qVar instanceof g;
            if (z4) {
                bArr = ((g) qVar).f3820a;
            } else {
                bArr = qVar.b();
            }
            if (Arrays.equals(bArr3, bArr)) {
                byte[] bArr4 = this.f3821b;
                if (z4) {
                    bArr2 = ((g) qVar).f3821b;
                } else {
                    bArr2 = qVar.c();
                }
                if (Arrays.equals(bArr4, bArr2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return ((Arrays.hashCode(this.f3820a) ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f3821b);
    }

    public String toString() {
        return "ExperimentIds{clearBlob=" + Arrays.toString(this.f3820a) + ", encryptedBlob=" + Arrays.toString(this.f3821b) + "}";
    }

    private g(byte[] bArr, byte[] bArr2) {
        this.f3820a = bArr;
        this.f3821b = bArr2;
    }
}
