package q;

import java.util.Arrays;
import o.C0962c;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    private final C0962c f4011a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f4012b;

    public h(C0962c cVar, byte[] bArr) {
        if (cVar == null) {
            throw new NullPointerException("encoding is null");
        } else if (bArr != null) {
            this.f4011a = cVar;
            this.f4012b = bArr;
        } else {
            throw new NullPointerException("bytes is null");
        }
    }

    public byte[] a() {
        return this.f4012b;
    }

    public C0962c b() {
        return this.f4011a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (!this.f4011a.equals(hVar.f4011a)) {
            return false;
        }
        return Arrays.equals(this.f4012b, hVar.f4012b);
    }

    public int hashCode() {
        return ((this.f4011a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f4012b);
    }

    public String toString() {
        return "EncodedPayload{encoding=" + this.f4011a + ", bytes=[...]}";
    }
}
