package X0;

import com.google.firebase.messaging.K;

public final class b {

    /* renamed from: b  reason: collision with root package name */
    private static final b f8806b = new a().a();

    /* renamed from: a  reason: collision with root package name */
    private final a f8807a;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private a f8808a = null;

        a() {
        }

        public b a() {
            return new b(this.f8808a);
        }

        public a b(a aVar) {
            this.f8808a = aVar;
            return this;
        }
    }

    b(a aVar) {
        this.f8807a = aVar;
    }

    public static a b() {
        return new a();
    }

    public a a() {
        return this.f8807a;
    }

    public byte[] c() {
        return K.a(this);
    }
}
