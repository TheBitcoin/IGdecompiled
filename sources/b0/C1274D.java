package B0;

import B0.G;

/* renamed from: B0.D  reason: case insensitive filesystem */
final class C1274D extends G.b {

    /* renamed from: a  reason: collision with root package name */
    private final int f5761a;

    /* renamed from: b  reason: collision with root package name */
    private final String f5762b;

    /* renamed from: c  reason: collision with root package name */
    private final int f5763c;

    /* renamed from: d  reason: collision with root package name */
    private final long f5764d;

    /* renamed from: e  reason: collision with root package name */
    private final long f5765e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f5766f;

    /* renamed from: g  reason: collision with root package name */
    private final int f5767g;

    /* renamed from: h  reason: collision with root package name */
    private final String f5768h;

    /* renamed from: i  reason: collision with root package name */
    private final String f5769i;

    C1274D(int i4, String str, int i5, long j4, long j5, boolean z4, int i6, String str2, String str3) {
        this.f5761a = i4;
        if (str != null) {
            this.f5762b = str;
            this.f5763c = i5;
            this.f5764d = j4;
            this.f5765e = j5;
            this.f5766f = z4;
            this.f5767g = i6;
            if (str2 != null) {
                this.f5768h = str2;
                if (str3 != null) {
                    this.f5769i = str3;
                    return;
                }
                throw new NullPointerException("Null modelClass");
            }
            throw new NullPointerException("Null manufacturer");
        }
        throw new NullPointerException("Null model");
    }

    public int a() {
        return this.f5761a;
    }

    public int b() {
        return this.f5763c;
    }

    public long d() {
        return this.f5765e;
    }

    public boolean e() {
        return this.f5766f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof G.b) {
            G.b bVar = (G.b) obj;
            if (this.f5761a == bVar.a() && this.f5762b.equals(bVar.g()) && this.f5763c == bVar.b() && this.f5764d == bVar.j() && this.f5765e == bVar.d() && this.f5766f == bVar.e() && this.f5767g == bVar.i() && this.f5768h.equals(bVar.f()) && this.f5769i.equals(bVar.h())) {
                return true;
            }
            return false;
        }
        return false;
    }

    public String f() {
        return this.f5768h;
    }

    public String g() {
        return this.f5762b;
    }

    public String h() {
        return this.f5769i;
    }

    public int hashCode() {
        int i4;
        long j4 = this.f5764d;
        long j5 = this.f5765e;
        int hashCode = (((((((((this.f5761a ^ 1000003) * 1000003) ^ this.f5762b.hashCode()) * 1000003) ^ this.f5763c) * 1000003) ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003) ^ ((int) (j5 ^ (j5 >>> 32)))) * 1000003;
        if (this.f5766f) {
            i4 = 1231;
        } else {
            i4 = 1237;
        }
        return ((((((hashCode ^ i4) * 1000003) ^ this.f5767g) * 1000003) ^ this.f5768h.hashCode()) * 1000003) ^ this.f5769i.hashCode();
    }

    public int i() {
        return this.f5767g;
    }

    public long j() {
        return this.f5764d;
    }

    public String toString() {
        return "DeviceData{arch=" + this.f5761a + ", model=" + this.f5762b + ", availableProcessors=" + this.f5763c + ", totalRam=" + this.f5764d + ", diskSpace=" + this.f5765e + ", isEmulator=" + this.f5766f + ", state=" + this.f5767g + ", manufacturer=" + this.f5768h + ", modelClass=" + this.f5769i + "}";
    }
}
