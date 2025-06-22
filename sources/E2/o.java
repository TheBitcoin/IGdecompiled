package E2;

import R2.s;
import d3.p;
import java.util.Map;
import kotlin.jvm.internal.n;
import z3.e;
import z3.l;

public final class o extends n implements p {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ s f6380a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o(s sVar) {
        super(2);
        this.f6380a = sVar;
    }

    public Object invoke(Object obj, Object obj2) {
        l lVar;
        Map map;
        int intValue = ((Number) obj).intValue();
        ((Boolean) obj2).getClass();
        e eVar = this.f6380a.f6391a;
        if (eVar == null || (map = eVar.f4808i) == null) {
            lVar = null;
        } else {
            lVar = (l) map.get(String.valueOf(intValue));
        }
        if (lVar != null && s.e(this.f6380a, lVar)) {
            this.f6380a.f6416z.set(intValue);
        }
        return s.f8222a;
    }
}
