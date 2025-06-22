package q;

import o.C0962c;
import o.C0963d;
import o.h;
import q.o;

final class c extends o {

    /* renamed from: a  reason: collision with root package name */
    private final p f3980a;

    /* renamed from: b  reason: collision with root package name */
    private final String f3981b;

    /* renamed from: c  reason: collision with root package name */
    private final C0963d f3982c;

    /* renamed from: d  reason: collision with root package name */
    private final h f3983d;

    /* renamed from: e  reason: collision with root package name */
    private final C0962c f3984e;

    static final class b extends o.a {

        /* renamed from: a  reason: collision with root package name */
        private p f3985a;

        /* renamed from: b  reason: collision with root package name */
        private String f3986b;

        /* renamed from: c  reason: collision with root package name */
        private C0963d f3987c;

        /* renamed from: d  reason: collision with root package name */
        private h f3988d;

        /* renamed from: e  reason: collision with root package name */
        private C0962c f3989e;

        b() {
        }

        public o a() {
            String str = "";
            if (this.f3985a == null) {
                str = str + " transportContext";
            }
            if (this.f3986b == null) {
                str = str + " transportName";
            }
            if (this.f3987c == null) {
                str = str + " event";
            }
            if (this.f3988d == null) {
                str = str + " transformer";
            }
            if (this.f3989e == null) {
                str = str + " encoding";
            }
            if (str.isEmpty()) {
                return new c(this.f3985a, this.f3986b, this.f3987c, this.f3988d, this.f3989e);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        /* access modifiers changed from: package-private */
        public o.a b(C0962c cVar) {
            if (cVar != null) {
                this.f3989e = cVar;
                return this;
            }
            throw new NullPointerException("Null encoding");
        }

        /* access modifiers changed from: package-private */
        public o.a c(C0963d dVar) {
            if (dVar != null) {
                this.f3987c = dVar;
                return this;
            }
            throw new NullPointerException("Null event");
        }

        /* access modifiers changed from: package-private */
        public o.a d(h hVar) {
            if (hVar != null) {
                this.f3988d = hVar;
                return this;
            }
            throw new NullPointerException("Null transformer");
        }

        public o.a e(p pVar) {
            if (pVar != null) {
                this.f3985a = pVar;
                return this;
            }
            throw new NullPointerException("Null transportContext");
        }

        public o.a f(String str) {
            if (str != null) {
                this.f3986b = str;
                return this;
            }
            throw new NullPointerException("Null transportName");
        }
    }

    public C0962c b() {
        return this.f3984e;
    }

    /* access modifiers changed from: package-private */
    public C0963d c() {
        return this.f3982c;
    }

    /* access modifiers changed from: package-private */
    public h e() {
        return this.f3983d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof o) {
            o oVar = (o) obj;
            if (!this.f3980a.equals(oVar.f()) || !this.f3981b.equals(oVar.g()) || !this.f3982c.equals(oVar.c()) || !this.f3983d.equals(oVar.e()) || !this.f3984e.equals(oVar.b())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public p f() {
        return this.f3980a;
    }

    public String g() {
        return this.f3981b;
    }

    public int hashCode() {
        return ((((((((this.f3980a.hashCode() ^ 1000003) * 1000003) ^ this.f3981b.hashCode()) * 1000003) ^ this.f3982c.hashCode()) * 1000003) ^ this.f3983d.hashCode()) * 1000003) ^ this.f3984e.hashCode();
    }

    public String toString() {
        return "SendRequest{transportContext=" + this.f3980a + ", transportName=" + this.f3981b + ", event=" + this.f3982c + ", transformer=" + this.f3983d + ", encoding=" + this.f3984e + "}";
    }

    private c(p pVar, String str, C0963d dVar, h hVar, C0962c cVar) {
        this.f3980a = pVar;
        this.f3981b = str;
        this.f3982c = dVar;
        this.f3983d = hVar;
        this.f3984e = cVar;
    }
}
