package t;

import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.List;
import q.m;

/* renamed from: t.a  reason: case insensitive filesystem */
public final class C1046a {

    /* renamed from: e  reason: collision with root package name */
    private static final C1046a f4420e = new C0050a().b();

    /* renamed from: a  reason: collision with root package name */
    private final f f4421a;

    /* renamed from: b  reason: collision with root package name */
    private final List f4422b;

    /* renamed from: c  reason: collision with root package name */
    private final C1047b f4423c;

    /* renamed from: d  reason: collision with root package name */
    private final String f4424d;

    /* renamed from: t.a$a  reason: collision with other inner class name */
    public static final class C0050a {

        /* renamed from: a  reason: collision with root package name */
        private f f4425a = null;

        /* renamed from: b  reason: collision with root package name */
        private List f4426b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        private C1047b f4427c = null;

        /* renamed from: d  reason: collision with root package name */
        private String f4428d = "";

        C0050a() {
        }

        public C0050a a(C1049d dVar) {
            this.f4426b.add(dVar);
            return this;
        }

        public C1046a b() {
            return new C1046a(this.f4425a, DesugarCollections.unmodifiableList(this.f4426b), this.f4427c, this.f4428d);
        }

        public C0050a c(String str) {
            this.f4428d = str;
            return this;
        }

        public C0050a d(C1047b bVar) {
            this.f4427c = bVar;
            return this;
        }

        public C0050a e(f fVar) {
            this.f4425a = fVar;
            return this;
        }
    }

    C1046a(f fVar, List list, C1047b bVar, String str) {
        this.f4421a = fVar;
        this.f4422b = list;
        this.f4423c = bVar;
        this.f4424d = str;
    }

    public static C0050a e() {
        return new C0050a();
    }

    public String a() {
        return this.f4424d;
    }

    public C1047b b() {
        return this.f4423c;
    }

    public List c() {
        return this.f4422b;
    }

    public f d() {
        return this.f4421a;
    }

    public byte[] f() {
        return m.a(this);
    }
}
