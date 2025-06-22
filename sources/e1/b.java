package e1;

import com.google.firebase.components.ComponentRegistrar;
import java.util.ArrayList;
import java.util.List;
import s0.C2268c;
import s0.C2270e;
import s0.j;

public class b implements j {
    public static /* synthetic */ Object b(String str, C2268c cVar, C2270e eVar) {
        try {
            c.b(str);
            return cVar.h().a(eVar);
        } finally {
            c.a();
        }
    }

    public List a(ComponentRegistrar componentRegistrar) {
        ArrayList arrayList = new ArrayList();
        for (C2268c cVar : componentRegistrar.getComponents()) {
            String i4 = cVar.i();
            if (i4 != null) {
                cVar = cVar.r(new C1994a(i4, cVar));
            }
            arrayList.add(cVar);
        }
        return arrayList;
    }
}
