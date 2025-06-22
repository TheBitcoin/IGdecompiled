package r;

import java.util.Arrays;
import r.C1023f;

/* renamed from: r.a  reason: case insensitive filesystem */
final class C1018a extends C1023f {

    /* renamed from: a  reason: collision with root package name */
    private final Iterable f4110a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f4111b;

    /* renamed from: r.a$b */
    static final class b extends C1023f.a {

        /* renamed from: a  reason: collision with root package name */
        private Iterable f4112a;

        /* renamed from: b  reason: collision with root package name */
        private byte[] f4113b;

        b() {
        }

        public C1023f a() {
            String str = "";
            if (this.f4112a == null) {
                str = str + " events";
            }
            if (str.isEmpty()) {
                return new C1018a(this.f4112a, this.f4113b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public C1023f.a b(Iterable iterable) {
            if (iterable != null) {
                this.f4112a = iterable;
                return this;
            }
            throw new NullPointerException("Null events");
        }

        public C1023f.a c(byte[] bArr) {
            this.f4113b = bArr;
            return this;
        }
    }

    public Iterable b() {
        return this.f4110a;
    }

    public byte[] c() {
        return this.f4111b;
    }

    public boolean equals(Object obj) {
        byte[] bArr;
        if (obj == this) {
            return true;
        }
        if (obj instanceof C1023f) {
            C1023f fVar = (C1023f) obj;
            if (this.f4110a.equals(fVar.b())) {
                byte[] bArr2 = this.f4111b;
                if (fVar instanceof C1018a) {
                    bArr = ((C1018a) fVar).f4111b;
                } else {
                    bArr = fVar.c();
                }
                if (Arrays.equals(bArr2, bArr)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f4110a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f4111b);
    }

    public String toString() {
        return "BackendRequest{events=" + this.f4110a + ", extras=" + Arrays.toString(this.f4111b) + "}";
    }

    private C1018a(Iterable iterable, byte[] bArr) {
        this.f4110a = iterable;
        this.f4111b = bArr;
    }
}
