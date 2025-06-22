package k1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;
import l1.C2113h;
import l1.C2115j;

public class d extends C2093a {
    public d(List list) {
        d(list);
    }

    public void a(String str) {
        this.f20929a = C2113h.a(str);
    }

    public String b() {
        return C2113h.b((List) this.f20929a);
    }

    public void d(Object obj) {
        super.d(new ArrayList(new TreeSet((List) obj)));
    }

    public String e(String str, int i4) {
        int indexOf;
        int i5 = i4 + 12;
        int a5 = C2115j.a(str.substring(i4, i5));
        for (int i6 = 0; i6 < a5; i6++) {
            if (str.charAt(i5) == '1') {
                indexOf = str.indexOf("11", str.indexOf("11", i5 + 1) + 2);
            } else {
                indexOf = str.indexOf("11", i5 + 1);
            }
            i5 = indexOf + 2;
        }
        return str.substring(i4, i5);
    }

    /* renamed from: f */
    public List c() {
        return new ArrayList((Collection) super.c());
    }
}
