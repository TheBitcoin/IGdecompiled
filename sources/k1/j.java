package k1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.IntSupplier;
import l1.C2114i;

public class j extends C2093a {

    /* renamed from: b  reason: collision with root package name */
    private IntSupplier f20935b;

    public j(IntSupplier intSupplier, List list) {
        this.f20935b = intSupplier;
        d(list);
    }

    public void a(String str) {
        this.f20929a = C2114i.a(str);
    }

    public String b() {
        return C2114i.b((List) this.f20929a, this.f20935b.getAsInt());
    }

    public void d(Object obj) {
        int asInt = this.f20935b.getAsInt();
        List arrayList = new ArrayList((List) obj);
        for (int size = arrayList.size(); size < asInt; size++) {
            arrayList.add(Boolean.FALSE);
        }
        if (arrayList.size() > asInt) {
            arrayList = arrayList.subList(0, asInt);
        }
        super.d(arrayList);
    }

    public String e(String str, int i4) {
        return str.substring(i4, this.f20935b.getAsInt() + i4);
    }

    /* renamed from: f */
    public List c() {
        return new ArrayList((Collection) super.c());
    }
}
