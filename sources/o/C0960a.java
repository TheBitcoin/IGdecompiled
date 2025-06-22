package o;

/* renamed from: o.a  reason: case insensitive filesystem */
final class C0960a extends C0963d {

    /* renamed from: a  reason: collision with root package name */
    private final Integer f3613a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f3614b;

    /* renamed from: c  reason: collision with root package name */
    private final f f3615c;

    /* renamed from: d  reason: collision with root package name */
    private final g f3616d;

    C0960a(Integer num, Object obj, f fVar, g gVar, C0964e eVar) {
        this.f3613a = num;
        if (obj != null) {
            this.f3614b = obj;
            if (fVar != null) {
                this.f3615c = fVar;
                this.f3616d = gVar;
                return;
            }
            throw new NullPointerException("Null priority");
        }
        throw new NullPointerException("Null payload");
    }

    public Integer a() {
        return this.f3613a;
    }

    public C0964e b() {
        return null;
    }

    public Object c() {
        return this.f3614b;
    }

    public f d() {
        return this.f3615c;
    }

    public g e() {
        return this.f3616d;
    }

    public boolean equals(Object obj) {
        g gVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof C0963d) {
            C0963d dVar = (C0963d) obj;
            Integer num = this.f3613a;
            if (num != null ? num.equals(dVar.a()) : dVar.a() == null) {
                if (this.f3614b.equals(dVar.c()) && this.f3615c.equals(dVar.d()) && ((gVar = this.f3616d) != null ? gVar.equals(dVar.e()) : dVar.e() == null)) {
                    dVar.b();
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int i4;
        Integer num = this.f3613a;
        int i5 = 0;
        if (num == null) {
            i4 = 0;
        } else {
            i4 = num.hashCode();
        }
        int hashCode = (((((i4 ^ 1000003) * 1000003) ^ this.f3614b.hashCode()) * 1000003) ^ this.f3615c.hashCode()) * 1000003;
        g gVar = this.f3616d;
        if (gVar != null) {
            i5 = gVar.hashCode();
        }
        return (hashCode ^ i5) * 1000003;
    }

    public String toString() {
        return "Event{code=" + this.f3613a + ", payload=" + this.f3614b + ", priority=" + this.f3615c + ", productData=" + this.f3616d + ", eventContext=" + null + "}";
    }
}
