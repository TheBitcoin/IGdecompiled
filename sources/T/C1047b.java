package t;

/* renamed from: t.b  reason: case insensitive filesystem */
public final class C1047b {

    /* renamed from: b  reason: collision with root package name */
    private static final C1047b f4429b = new a().a();

    /* renamed from: a  reason: collision with root package name */
    private final C1050e f4430a;

    /* renamed from: t.b$a */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private C1050e f4431a = null;

        a() {
        }

        public C1047b a() {
            return new C1047b(this.f4431a);
        }

        public a b(C1050e eVar) {
            this.f4431a = eVar;
            return this;
        }
    }

    C1047b(C1050e eVar) {
        this.f4430a = eVar;
    }

    public static a b() {
        return new a();
    }

    public C1050e a() {
        return this.f4430a;
    }
}
