package E2;

import C3.f;
import R2.s;
import b.c;
import b4.d;
import d3.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class n extends kotlin.jvm.internal.n implements p {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ s f6379a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n(s sVar) {
        super(2);
        this.f6379a = sVar;
    }

    public Object invoke(Object obj, Object obj2) {
        int intValue = ((Number) obj).intValue();
        ((Boolean) obj2).getClass();
        f j4 = d.f24465a.j();
        List list = j4.f171c.f166a;
        ArrayList arrayList = new ArrayList();
        for (Object next : list) {
            if (intValue == ((C3.d) next).f159a) {
                arrayList.add(next);
            }
        }
        s sVar = this.f6379a;
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj3 = arrayList.get(i4);
            i4++;
            List list2 = j4.f170b.f135h;
            List list3 = ((C3.d) obj3).f164f;
            if (!(list3 instanceof Collection) || !list3.isEmpty()) {
                Iterator it = list3.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (c.a((Number) it.next(), list2)) {
                            sVar.f6384A.set(intValue);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return s.f8222a;
    }
}
