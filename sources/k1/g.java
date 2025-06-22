package k1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import l1.C2116k;

public class g extends C2093a {

    /* renamed from: b  reason: collision with root package name */
    private int f20932b;

    /* renamed from: c  reason: collision with root package name */
    private int f20933c;

    public g(int i4, List list) {
        this.f20932b = i4;
        this.f20933c = list.size();
        d(list);
    }

    public void a(String str) {
        this.f20929a = C2116k.a(str, this.f20932b, this.f20933c);
    }

    public String b() {
        return C2116k.b((List) this.f20929a, this.f20932b, this.f20933c);
    }

    public void d(Object obj) {
        List arrayList = new ArrayList((List) obj);
        for (int size = arrayList.size(); size < this.f20933c; size++) {
            arrayList.add(0);
        }
        int size2 = arrayList.size();
        int i4 = this.f20933c;
        if (size2 > i4) {
            arrayList = arrayList.subList(0, i4);
        }
        super.d(arrayList);
    }

    public String e(String str, int i4) {
        return str.substring(i4, (this.f20932b * this.f20933c) + i4);
    }

    /* renamed from: f */
    public List c() {
        return new ArrayList((Collection) super.c());
    }
}
