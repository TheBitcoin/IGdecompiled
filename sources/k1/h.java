package k1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;
import l1.C2115j;
import l1.C2117l;

public class h extends C2093a {
    protected h() {
    }

    public void a(String str) {
        this.f20929a = C2117l.a(str);
    }

    public String b() {
        return C2117l.b((List) this.f20929a);
    }

    public void d(Object obj) {
        super.d(new ArrayList(new TreeSet((List) obj)));
    }

    public String e(String str, int i4) {
        int i5 = i4 + 12;
        int a5 = C2115j.a(str.substring(i4, i5));
        for (int i6 = 0; i6 < a5; i6++) {
            if (str.charAt(i5) == '1') {
                i5 += 33;
            } else {
                i5 += 17;
            }
        }
        return str.substring(i4, i5);
    }

    /* renamed from: f */
    public List c() {
        return new ArrayList((Collection) super.c());
    }

    public h(List list) {
        d(list);
    }
}
