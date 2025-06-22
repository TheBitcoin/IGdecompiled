package B0;

import B0.F;
import java.util.List;

/* renamed from: B0.f  reason: case insensitive filesystem */
final class C1281f extends F.d {

    /* renamed from: a  reason: collision with root package name */
    private final List f5975a;

    /* renamed from: b  reason: collision with root package name */
    private final String f5976b;

    /* renamed from: B0.f$b */
    static final class b extends F.d.a {

        /* renamed from: a  reason: collision with root package name */
        private List f5977a;

        /* renamed from: b  reason: collision with root package name */
        private String f5978b;

        b() {
        }

        public F.d a() {
            List list = this.f5977a;
            if (list != null) {
                return new C1281f(list, this.f5978b);
            }
            throw new IllegalStateException("Missing required properties:" + " files");
        }

        public F.d.a b(List list) {
            if (list != null) {
                this.f5977a = list;
                return this;
            }
            throw new NullPointerException("Null files");
        }

        public F.d.a c(String str) {
            this.f5978b = str;
            return this;
        }
    }

    public List b() {
        return this.f5975a;
    }

    public String c() {
        return this.f5976b;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof F.d) {
            F.d dVar = (F.d) obj;
            if (!this.f5975a.equals(dVar.b()) || ((str = this.f5976b) != null ? !str.equals(dVar.c()) : dVar.c() != null)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i4;
        int hashCode = (this.f5975a.hashCode() ^ 1000003) * 1000003;
        String str = this.f5976b;
        if (str == null) {
            i4 = 0;
        } else {
            i4 = str.hashCode();
        }
        return hashCode ^ i4;
    }

    public String toString() {
        return "FilesPayload{files=" + this.f5975a + ", orgId=" + this.f5976b + "}";
    }

    private C1281f(List list, String str) {
        this.f5975a = list;
        this.f5976b = str;
    }
}
