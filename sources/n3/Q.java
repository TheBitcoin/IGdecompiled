package N3;

import O3.C2538d;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public final class Q implements Comparable {

    /* renamed from: b  reason: collision with root package name */
    public static final a f23639b = new a((C2103g) null);

    /* renamed from: c  reason: collision with root package name */
    public static final String f23640c;

    /* renamed from: a  reason: collision with root package name */
    private final C2517h f23641a;

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        public static /* synthetic */ Q d(a aVar, File file, boolean z4, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                z4 = false;
            }
            return aVar.a(file, z4);
        }

        public static /* synthetic */ Q e(a aVar, String str, boolean z4, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                z4 = false;
            }
            return aVar.b(str, z4);
        }

        public static /* synthetic */ Q f(a aVar, Path path, boolean z4, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                z4 = false;
            }
            return aVar.c(path, z4);
        }

        public final Q a(File file, boolean z4) {
            m.e(file, "<this>");
            String file2 = file.toString();
            m.d(file2, "toString()");
            return b(file2, z4);
        }

        public final Q b(String str, boolean z4) {
            m.e(str, "<this>");
            return C2538d.k(str, z4);
        }

        public final Q c(Path path, boolean z4) {
            m.e(path, "<this>");
            return b(path.toString(), z4);
        }

        private a() {
        }
    }

    static {
        String str = File.separator;
        m.d(str, "separator");
        f23640c = str;
    }

    public Q(C2517h hVar) {
        m.e(hVar, "bytes");
        this.f23641a = hVar;
    }

    /* renamed from: a */
    public int compareTo(Q q4) {
        m.e(q4, "other");
        return b().compareTo(q4.b());
    }

    public final C2517h b() {
        return this.f23641a;
    }

    public final Q c() {
        int h4 = C2538d.o(this);
        if (h4 == -1) {
            return null;
        }
        return new Q(b().I(0, h4));
    }

    public final List d() {
        ArrayList arrayList = new ArrayList();
        int h4 = C2538d.o(this);
        if (h4 == -1) {
            h4 = 0;
        } else if (h4 < b().G() && b().h(h4) == 92) {
            h4++;
        }
        int G4 = b().G();
        int i4 = h4;
        while (h4 < G4) {
            if (b().h(h4) == 47 || b().h(h4) == 92) {
                arrayList.add(b().I(i4, h4));
                i4 = h4 + 1;
            }
            h4++;
        }
        if (i4 < b().G()) {
            arrayList.add(b().I(i4, b().G()));
        }
        return arrayList;
    }

    public final boolean e() {
        if (C2538d.o(this) != -1) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Q) || !m.a(((Q) obj).b(), b())) {
            return false;
        }
        return true;
    }

    public final String f() {
        return g().M();
    }

    public final C2517h g() {
        int d5 = C2538d.l(this);
        if (d5 != -1) {
            return C2517h.J(b(), d5 + 1, 0, 2, (Object) null);
        }
        if (o() == null || b().G() != 2) {
            return b();
        }
        return C2517h.f23705e;
    }

    public final Q h() {
        return f23639b.b(toString(), true);
    }

    public int hashCode() {
        return b().hashCode();
    }

    public final Q i() {
        if (m.a(b(), C2538d.f23751d) || m.a(b(), C2538d.f23748a) || m.a(b(), C2538d.f23749b) || C2538d.n(this)) {
            return null;
        }
        int d5 = C2538d.l(this);
        if (d5 != 2 || o() == null) {
            if (d5 == 1 && b().H(C2538d.f23749b)) {
                return null;
            }
            if (d5 != -1 || o() == null) {
                if (d5 == -1) {
                    return new Q(C2538d.f23751d);
                }
                if (d5 == 0) {
                    return new Q(C2517h.J(b(), 0, 1, 1, (Object) null));
                }
                return new Q(C2517h.J(b(), 0, d5, 1, (Object) null));
            } else if (b().G() == 2) {
                return null;
            } else {
                return new Q(C2517h.J(b(), 0, 2, 1, (Object) null));
            }
        } else if (b().G() == 3) {
            return null;
        } else {
            return new Q(C2517h.J(b(), 0, 3, 1, (Object) null));
        }
    }

    public final Q j(Q q4) {
        m.e(q4, "other");
        if (m.a(c(), q4.c())) {
            List d5 = d();
            List d6 = q4.d();
            int min = Math.min(d5.size(), d6.size());
            int i4 = 0;
            while (i4 < min && m.a(d5.get(i4), d6.get(i4))) {
                i4++;
            }
            if (i4 == min && b().G() == q4.b().G()) {
                return a.e(f23639b, ".", false, 1, (Object) null);
            }
            if (d6.subList(i4, d6.size()).indexOf(C2538d.f23752e) == -1) {
                C2514e eVar = new C2514e();
                C2517h f4 = C2538d.m(q4);
                if (f4 == null && (f4 = C2538d.m(this)) == null) {
                    f4 = C2538d.s(f23640c);
                }
                int size = d6.size();
                for (int i5 = i4; i5 < size; i5++) {
                    eVar.G(C2538d.f23752e);
                    eVar.G(f4);
                }
                int size2 = d5.size();
                while (i4 < size2) {
                    eVar.G((C2517h) d5.get(i4));
                    eVar.G(f4);
                    i4++;
                }
                return C2538d.q(eVar, false);
            }
            throw new IllegalArgumentException(("Impossible relative path to resolve: " + this + " and " + q4).toString());
        }
        throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + this + " and " + q4).toString());
    }

    public final Q k(Q q4, boolean z4) {
        m.e(q4, "child");
        return C2538d.j(this, q4, z4);
    }

    public final Q l(String str) {
        m.e(str, "child");
        return C2538d.j(this, C2538d.q(new C2514e().writeUtf8(str), false), false);
    }

    public final File m() {
        return new File(toString());
    }

    public final Path n() {
        Path a5 = Paths.get(toString(), new String[0]);
        m.d(a5, "get(toString())");
        return a5;
    }

    public final Character o() {
        if (C2517h.p(b(), C2538d.f23748a, 0, 2, (Object) null) != -1 || b().G() < 2 || b().h(1) != 58) {
            return null;
        }
        char h4 = (char) b().h(0);
        if (('a' > h4 || h4 >= '{') && ('A' > h4 || h4 >= '[')) {
            return null;
        }
        return Character.valueOf(h4);
    }

    public String toString() {
        return b().M();
    }
}
