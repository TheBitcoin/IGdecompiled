package j1;

import j$.util.Collection$EL;
import j$.util.stream.Collectors;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import m1.C2153b;
import m1.C2154c;
import o1.C2175c;
import o1.C2176d;
import o1.C2178f;
import o1.C2179g;
import o1.C2180h;
import o1.C2181i;
import o1.C2182j;
import o1.C2183k;
import o1.C2184l;
import o1.C2185m;
import o1.C2186n;
import o1.C2187o;

/* renamed from: j1.a  reason: case insensitive filesystem */
public class C2091a {

    /* renamed from: a  reason: collision with root package name */
    private Map f20918a = new HashMap();

    public C2091a() {
    }

    public void a(String str) {
        this.f20918a.clear();
        String[] split = str.split("~");
        C2176d dVar = new C2176d(split[0]);
        this.f20918a.put(C2176d.f21383f, dVar);
        List list = (List) dVar.c("SectionIds");
        for (int i4 = 0; i4 < list.size(); i4++) {
            if (((Integer) list.get(i4)).equals(Integer.valueOf(C2180h.f21393d))) {
                this.f20918a.put(C2180h.f21395f, new C2180h(split[i4 + 1]));
            } else if (((Integer) list.get(i4)).equals(Integer.valueOf(C2179g.f21387d))) {
                this.f20918a.put(C2179g.f21389f, new C2179g(split[i4 + 1]));
            } else if (((Integer) list.get(i4)).equals(Integer.valueOf(C2187o.f21423b))) {
                this.f20918a.put(C2187o.f21425d, new C2187o(split[i4 + 1]));
            } else if (((Integer) list.get(i4)).equals(Integer.valueOf(C2181i.f21399d))) {
                this.f20918a.put(C2181i.f21401f, new C2181i(split[i4 + 1]));
            } else if (((Integer) list.get(i4)).equals(Integer.valueOf(C2184l.f21411d))) {
                this.f20918a.put(C2184l.f21413f, new C2184l(split[i4 + 1]));
            } else if (((Integer) list.get(i4)).equals(Integer.valueOf(C2186n.f21419d))) {
                this.f20918a.put(C2186n.f21421f, new C2186n(split[i4 + 1]));
            } else if (((Integer) list.get(i4)).equals(Integer.valueOf(C2182j.f21403d))) {
                this.f20918a.put(C2182j.f21405f, new C2182j(split[i4 + 1]));
            } else if (((Integer) list.get(i4)).equals(Integer.valueOf(C2185m.f21415d))) {
                this.f20918a.put(C2185m.f21417f, new C2185m(split[i4 + 1]));
            } else if (((Integer) list.get(i4)).equals(Integer.valueOf(C2183k.f21407d))) {
                this.f20918a.put(C2183k.f21409f, new C2183k(split[i4 + 1]));
            }
        }
    }

    public void b(int i4) {
        c((String) C2178f.f21386b.get(Integer.valueOf(i4)));
    }

    public void c(String str) {
        if (this.f20918a.containsKey(str)) {
            this.f20918a.remove(str);
        }
    }

    public String d() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i4 = 0; i4 < C2178f.f21385a.size(); i4++) {
            String str = (String) C2178f.f21385a.get(i4);
            if (this.f20918a.containsKey(str)) {
                C2175c cVar = (C2175c) this.f20918a.get(str);
                arrayList.add(cVar.b());
                arrayList2.add(Integer.valueOf(cVar.getId()));
            }
        }
        C2176d dVar = new C2176d();
        try {
            dVar.a("SectionIds", h());
            arrayList.add(0, dVar.b());
            return (String) Collection$EL.stream(arrayList).collect(Collectors.joining("~"));
        } catch (C2154c e5) {
            throw new C2153b((Exception) e5);
        }
    }

    public C2176d e() {
        C2176d dVar = new C2176d();
        try {
            dVar.a("SectionIds", h());
        } catch (C2154c unused) {
        }
        return dVar;
    }

    public C2175c f(int i4) {
        return g((String) C2178f.f21386b.get(Integer.valueOf(i4)));
    }

    public C2175c g(String str) {
        if (this.f20918a.containsKey(str)) {
            return (C2175c) this.f20918a.get(str);
        }
        return null;
    }

    public List h() {
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < C2178f.f21385a.size(); i4++) {
            String str = (String) C2178f.f21385a.get(i4);
            if (this.f20918a.containsKey(str)) {
                arrayList.add(Integer.valueOf(((C2175c) this.f20918a.get(str)).getId()));
            }
        }
        return arrayList;
    }

    public boolean i(int i4) {
        return j((String) C2178f.f21386b.get(Integer.valueOf(i4)));
    }

    public boolean j(String str) {
        return this.f20918a.containsKey(str);
    }

    public void k(String str, String str2, Object obj) {
        C2175c cVar;
        if (this.f20918a.containsKey(str)) {
            cVar = (C2175c) this.f20918a.get(str);
        } else if (str.equals(C2179g.f21389f)) {
            cVar = new C2179g();
            this.f20918a.put(C2179g.f21389f, cVar);
        } else if (str.equals(C2180h.f21395f)) {
            cVar = new C2180h();
            this.f20918a.put(C2180h.f21395f, cVar);
        } else if (str.equals(C2187o.f21425d)) {
            cVar = new C2187o();
            this.f20918a.put(C2187o.f21425d, cVar);
        } else if (str.equals(C2184l.f21413f)) {
            cVar = new C2184l();
            this.f20918a.put(C2184l.f21413f, cVar);
        } else if (str.equals(C2181i.f21401f)) {
            cVar = new C2181i();
            this.f20918a.put(C2181i.f21401f, cVar);
        } else if (str.equals(C2186n.f21421f)) {
            cVar = new C2186n();
            this.f20918a.put(C2186n.f21421f, cVar);
        } else if (str.equals(C2182j.f21405f)) {
            cVar = new C2182j();
            this.f20918a.put(C2182j.f21405f, cVar);
        } else if (str.equals(C2185m.f21417f)) {
            cVar = new C2185m();
            this.f20918a.put(C2185m.f21417f, cVar);
        } else if (str.equals(C2183k.f21409f)) {
            cVar = new C2183k();
            this.f20918a.put(C2183k.f21409f, cVar);
        } else {
            cVar = null;
        }
        if (cVar != null) {
            cVar.a(str2, obj);
            return;
        }
        throw new C2154c(str + "." + str2 + " not found");
    }

    public C2091a(String str) {
        if (str != null && str.length() > 0) {
            a(str);
        }
    }
}
