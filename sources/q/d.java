package q;

import java.util.Arrays;
import o.f;
import q.p;

final class d extends p {

    /* renamed from: a  reason: collision with root package name */
    private final String f3990a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f3991b;

    /* renamed from: c  reason: collision with root package name */
    private final f f3992c;

    static final class b extends p.a {

        /* renamed from: a  reason: collision with root package name */
        private String f3993a;

        /* renamed from: b  reason: collision with root package name */
        private byte[] f3994b;

        /* renamed from: c  reason: collision with root package name */
        private f f3995c;

        b() {
        }

        public p a() {
            String str = "";
            if (this.f3993a == null) {
                str = str + " backendName";
            }
            if (this.f3995c == null) {
                str = str + " priority";
            }
            if (str.isEmpty()) {
                return new d(this.f3993a, this.f3994b, this.f3995c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public p.a b(String str) {
            if (str != null) {
                this.f3993a = str;
                return this;
            }
            throw new NullPointerException("Null backendName");
        }

        public p.a c(byte[] bArr) {
            this.f3994b = bArr;
            return this;
        }

        public p.a d(f fVar) {
            if (fVar != null) {
                this.f3995c = fVar;
                return this;
            }
            throw new NullPointerException("Null priority");
        }
    }

    public String b() {
        return this.f3990a;
    }

    public byte[] c() {
        return this.f3991b;
    }

    public f d() {
        return this.f3992c;
    }

    public boolean equals(Object obj) {
        byte[] bArr;
        if (obj == this) {
            return true;
        }
        if (obj instanceof p) {
            p pVar = (p) obj;
            if (this.f3990a.equals(pVar.b())) {
                byte[] bArr2 = this.f3991b;
                if (pVar instanceof d) {
                    bArr = ((d) pVar).f3991b;
                } else {
                    bArr = pVar.c();
                }
                if (!Arrays.equals(bArr2, bArr) || !this.f3992c.equals(pVar.d())) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f3990a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f3991b)) * 1000003) ^ this.f3992c.hashCode();
    }

    private d(String str, byte[] bArr, f fVar) {
        this.f3990a = str;
        this.f3991b = bArr;
        this.f3992c = fVar;
    }
}
