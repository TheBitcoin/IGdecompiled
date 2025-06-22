package k1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;
import l1.C2114i;
import l1.C2115j;
import l1.C2117l;

public class k extends C2093a {
    public k(List list) {
        d(list);
    }

    public void a(String str) {
        if (str.charAt(16) == '1') {
            this.f20929a = C2117l.a(str.substring(17));
            return;
        }
        ArrayList arrayList = new ArrayList();
        List a5 = C2114i.a(str.substring(17));
        for (int i4 = 0; i4 < a5.size(); i4++) {
            if (((Boolean) a5.get(i4)).booleanValue()) {
                arrayList.add(Integer.valueOf(i4 + 1));
            }
        }
        this.f20929a = arrayList;
    }

    public String b() {
        int i4;
        if (((List) this.f20929a).size() > 0) {
            Object obj = this.f20929a;
            i4 = ((Integer) ((List) obj).get(((List) obj).size() - 1)).intValue();
        } else {
            i4 = 0;
        }
        String b5 = C2117l.b((List) this.f20929a);
        if (b5.length() <= i4) {
            return C2115j.b(i4, 16) + "1" + b5;
        }
        ArrayList arrayList = new ArrayList();
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            if (i6 == ((Integer) ((List) this.f20929a).get(i5)).intValue() - 1) {
                arrayList.add(Boolean.TRUE);
                i5++;
            } else {
                arrayList.add(Boolean.FALSE);
            }
        }
        return C2115j.b(i4, 16) + "0" + C2114i.b(arrayList, i4);
    }

    public void d(Object obj) {
        super.d(new ArrayList(new TreeSet((List) obj)));
    }

    public String e(String str, int i4) {
        int i5 = i4 + 16;
        int a5 = C2115j.a(str.substring(i4, i5));
        if (str.charAt(i5) != '1') {
            return str.substring(i4, i4 + 17 + a5);
        }
        StringBuilder sb = new StringBuilder();
        int i6 = i4 + 17;
        sb.append(str.substring(i4, i6));
        sb.append(new h().e(str, i6));
        return sb.toString();
    }

    /* renamed from: f */
    public List c() {
        return new ArrayList((Collection) super.c());
    }
}
