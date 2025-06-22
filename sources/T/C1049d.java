package t;

import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.List;

/* renamed from: t.d  reason: case insensitive filesystem */
public final class C1049d {

    /* renamed from: c  reason: collision with root package name */
    private static final C1049d f4446c = new a().a();

    /* renamed from: a  reason: collision with root package name */
    private final String f4447a;

    /* renamed from: b  reason: collision with root package name */
    private final List f4448b;

    /* renamed from: t.d$a */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private String f4449a = "";

        /* renamed from: b  reason: collision with root package name */
        private List f4450b = new ArrayList();

        a() {
        }

        public C1049d a() {
            return new C1049d(this.f4449a, DesugarCollections.unmodifiableList(this.f4450b));
        }

        public a b(List list) {
            this.f4450b = list;
            return this;
        }

        public a c(String str) {
            this.f4449a = str;
            return this;
        }
    }

    C1049d(String str, List list) {
        this.f4447a = str;
        this.f4448b = list;
    }

    public static a c() {
        return new a();
    }

    public List a() {
        return this.f4448b;
    }

    public String b() {
        return this.f4447a;
    }
}
