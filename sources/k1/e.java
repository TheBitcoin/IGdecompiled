package k1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import l1.C2114i;

public class e extends C2093a {

    /* renamed from: b  reason: collision with root package name */
    private int f20930b;

    public e(List list) {
        this.f20930b = list.size();
        d(list);
    }

    public void a(String str) {
        this.f20929a = C2114i.a(str);
    }

    public String b() {
        return C2114i.b((List) this.f20929a, this.f20930b);
    }

    public void d(Object obj) {
        List arrayList = new ArrayList((List) obj);
        for (int size = arrayList.size(); size < this.f20930b; size++) {
            arrayList.add(Boolean.FALSE);
        }
        int size2 = arrayList.size();
        int i4 = this.f20930b;
        if (size2 > i4) {
            arrayList = arrayList.subList(0, i4);
        }
        super.d(arrayList);
    }

    public String e(String str, int i4) {
        return str.substring(i4, this.f20930b + i4);
    }

    /* renamed from: f */
    public List c() {
        return new ArrayList((Collection) super.c());
    }
}
