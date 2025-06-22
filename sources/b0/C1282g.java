package B0;

import B0.F;
import java.util.Arrays;

/* renamed from: B0.g  reason: case insensitive filesystem */
final class C1282g extends F.d.b {

    /* renamed from: a  reason: collision with root package name */
    private final String f5979a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f5980b;

    /* renamed from: B0.g$b */
    static final class b extends F.d.b.a {

        /* renamed from: a  reason: collision with root package name */
        private String f5981a;

        /* renamed from: b  reason: collision with root package name */
        private byte[] f5982b;

        b() {
        }

        public F.d.b a() {
            byte[] bArr;
            String str = this.f5981a;
            if (str != null && (bArr = this.f5982b) != null) {
                return new C1282g(str, bArr);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f5981a == null) {
                sb.append(" filename");
            }
            if (this.f5982b == null) {
                sb.append(" contents");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public F.d.b.a b(byte[] bArr) {
            if (bArr != null) {
                this.f5982b = bArr;
                return this;
            }
            throw new NullPointerException("Null contents");
        }

        public F.d.b.a c(String str) {
            if (str != null) {
                this.f5981a = str;
                return this;
            }
            throw new NullPointerException("Null filename");
        }
    }

    public byte[] b() {
        return this.f5980b;
    }

    public String c() {
        return this.f5979a;
    }

    public boolean equals(Object obj) {
        byte[] bArr;
        if (obj == this) {
            return true;
        }
        if (obj instanceof F.d.b) {
            F.d.b bVar = (F.d.b) obj;
            if (this.f5979a.equals(bVar.c())) {
                byte[] bArr2 = this.f5980b;
                if (bVar instanceof C1282g) {
                    bArr = ((C1282g) bVar).f5980b;
                } else {
                    bArr = bVar.b();
                }
                if (Arrays.equals(bArr2, bArr)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f5979a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f5980b);
    }

    public String toString() {
        return "File{filename=" + this.f5979a + ", contents=" + Arrays.toString(this.f5980b) + "}";
    }

    private C1282g(String str, byte[] bArr) {
        this.f5979a = str;
        this.f5980b = bArr;
    }
}
