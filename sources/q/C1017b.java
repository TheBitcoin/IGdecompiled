package q;

import java.util.Arrays;
import java.util.Map;
import q.i;

/* renamed from: q.b  reason: case insensitive filesystem */
final class C1017b extends i {

    /* renamed from: a  reason: collision with root package name */
    private final String f3960a;

    /* renamed from: b  reason: collision with root package name */
    private final Integer f3961b;

    /* renamed from: c  reason: collision with root package name */
    private final h f3962c;

    /* renamed from: d  reason: collision with root package name */
    private final long f3963d;

    /* renamed from: e  reason: collision with root package name */
    private final long f3964e;

    /* renamed from: f  reason: collision with root package name */
    private final Map f3965f;

    /* renamed from: g  reason: collision with root package name */
    private final Integer f3966g;

    /* renamed from: h  reason: collision with root package name */
    private final String f3967h;

    /* renamed from: i  reason: collision with root package name */
    private final byte[] f3968i;

    /* renamed from: j  reason: collision with root package name */
    private final byte[] f3969j;

    /* renamed from: q.b$b  reason: collision with other inner class name */
    static final class C0035b extends i.a {

        /* renamed from: a  reason: collision with root package name */
        private String f3970a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f3971b;

        /* renamed from: c  reason: collision with root package name */
        private h f3972c;

        /* renamed from: d  reason: collision with root package name */
        private Long f3973d;

        /* renamed from: e  reason: collision with root package name */
        private Long f3974e;

        /* renamed from: f  reason: collision with root package name */
        private Map f3975f;

        /* renamed from: g  reason: collision with root package name */
        private Integer f3976g;

        /* renamed from: h  reason: collision with root package name */
        private String f3977h;

        /* renamed from: i  reason: collision with root package name */
        private byte[] f3978i;

        /* renamed from: j  reason: collision with root package name */
        private byte[] f3979j;

        C0035b() {
        }

        public i d() {
            String str = "";
            if (this.f3970a == null) {
                str = str + " transportName";
            }
            if (this.f3972c == null) {
                str = str + " encodedPayload";
            }
            if (this.f3973d == null) {
                str = str + " eventMillis";
            }
            if (this.f3974e == null) {
                str = str + " uptimeMillis";
            }
            if (this.f3975f == null) {
                str = str + " autoMetadata";
            }
            if (str.isEmpty()) {
                return new C1017b(this.f3970a, this.f3971b, this.f3972c, this.f3973d.longValue(), this.f3974e.longValue(), this.f3975f, this.f3976g, this.f3977h, this.f3978i, this.f3979j);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        /* access modifiers changed from: protected */
        public Map e() {
            Map map = this.f3975f;
            if (map != null) {
                return map;
            }
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }

        /* access modifiers changed from: protected */
        public i.a f(Map map) {
            if (map != null) {
                this.f3975f = map;
                return this;
            }
            throw new NullPointerException("Null autoMetadata");
        }

        public i.a g(Integer num) {
            this.f3971b = num;
            return this;
        }

        public i.a h(h hVar) {
            if (hVar != null) {
                this.f3972c = hVar;
                return this;
            }
            throw new NullPointerException("Null encodedPayload");
        }

        public i.a i(long j4) {
            this.f3973d = Long.valueOf(j4);
            return this;
        }

        public i.a j(byte[] bArr) {
            this.f3978i = bArr;
            return this;
        }

        public i.a k(byte[] bArr) {
            this.f3979j = bArr;
            return this;
        }

        public i.a l(Integer num) {
            this.f3976g = num;
            return this;
        }

        public i.a m(String str) {
            this.f3977h = str;
            return this;
        }

        public i.a n(String str) {
            if (str != null) {
                this.f3970a = str;
                return this;
            }
            throw new NullPointerException("Null transportName");
        }

        public i.a o(long j4) {
            this.f3974e = Long.valueOf(j4);
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public Map c() {
        return this.f3965f;
    }

    public Integer d() {
        return this.f3961b;
    }

    public h e() {
        return this.f3962c;
    }

    public boolean equals(Object obj) {
        Integer num;
        Integer num2;
        String str;
        byte[] bArr;
        byte[] bArr2;
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            if (this.f3960a.equals(iVar.n()) && ((num = this.f3961b) != null ? num.equals(iVar.d()) : iVar.d() == null) && this.f3962c.equals(iVar.e()) && this.f3963d == iVar.f() && this.f3964e == iVar.o() && this.f3965f.equals(iVar.c()) && ((num2 = this.f3966g) != null ? num2.equals(iVar.l()) : iVar.l() == null) && ((str = this.f3967h) != null ? str.equals(iVar.m()) : iVar.m() == null)) {
                byte[] bArr3 = this.f3968i;
                boolean z4 = iVar instanceof C1017b;
                if (z4) {
                    bArr = ((C1017b) iVar).f3968i;
                } else {
                    bArr = iVar.g();
                }
                if (Arrays.equals(bArr3, bArr)) {
                    byte[] bArr4 = this.f3969j;
                    if (z4) {
                        bArr2 = ((C1017b) iVar).f3969j;
                    } else {
                        bArr2 = iVar.h();
                    }
                    if (Arrays.equals(bArr4, bArr2)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public long f() {
        return this.f3963d;
    }

    public byte[] g() {
        return this.f3968i;
    }

    public byte[] h() {
        return this.f3969j;
    }

    public int hashCode() {
        int i4;
        int i5;
        int hashCode = (this.f3960a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.f3961b;
        int i6 = 0;
        if (num == null) {
            i4 = 0;
        } else {
            i4 = num.hashCode();
        }
        long j4 = this.f3963d;
        long j5 = this.f3964e;
        int hashCode2 = (((((((((hashCode ^ i4) * 1000003) ^ this.f3962c.hashCode()) * 1000003) ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003) ^ ((int) (j5 ^ (j5 >>> 32)))) * 1000003) ^ this.f3965f.hashCode()) * 1000003;
        Integer num2 = this.f3966g;
        if (num2 == null) {
            i5 = 0;
        } else {
            i5 = num2.hashCode();
        }
        int i7 = (hashCode2 ^ i5) * 1000003;
        String str = this.f3967h;
        if (str != null) {
            i6 = str.hashCode();
        }
        return ((((i7 ^ i6) * 1000003) ^ Arrays.hashCode(this.f3968i)) * 1000003) ^ Arrays.hashCode(this.f3969j);
    }

    public Integer l() {
        return this.f3966g;
    }

    public String m() {
        return this.f3967h;
    }

    public String n() {
        return this.f3960a;
    }

    public long o() {
        return this.f3964e;
    }

    public String toString() {
        return "EventInternal{transportName=" + this.f3960a + ", code=" + this.f3961b + ", encodedPayload=" + this.f3962c + ", eventMillis=" + this.f3963d + ", uptimeMillis=" + this.f3964e + ", autoMetadata=" + this.f3965f + ", productId=" + this.f3966g + ", pseudonymousId=" + this.f3967h + ", experimentIdsClear=" + Arrays.toString(this.f3968i) + ", experimentIdsEncrypted=" + Arrays.toString(this.f3969j) + "}";
    }

    private C1017b(String str, Integer num, h hVar, long j4, long j5, Map map, Integer num2, String str2, byte[] bArr, byte[] bArr2) {
        this.f3960a = str;
        this.f3961b = num;
        this.f3962c = hVar;
        this.f3963d = j4;
        this.f3964e = j5;
        this.f3965f = map;
        this.f3966g = num2;
        this.f3967h = str2;
        this.f3968i = bArr;
        this.f3969j = bArr2;
    }
}
