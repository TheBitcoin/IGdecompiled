package G2;

import E2.s;
import d3.p;
import java.util.Map;
import kotlin.jvm.internal.n;
import z3.e;
import z3.l;

public final class i extends n implements p {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ s f6614a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(s sVar) {
        super(2);
        this.f6614a = sVar;
    }

    public Object invoke(Object obj, Object obj2) {
        l lVar;
        Map map;
        int intValue = ((Number) obj).intValue();
        boolean booleanValue = ((Boolean) obj2).booleanValue();
        e eVar = this.f6614a.f6391a;
        if (eVar == null || (map = eVar.f4808i) == null) {
            lVar = null;
        } else {
            lVar = (l) map.get(String.valueOf(intValue));
        }
        if (lVar == null || (booleanValue && lVar.f4819d.isEmpty())) {
            this.f6614a.f6416z.unset(intValue);
        }
        return R2.s.f8222a;
    }
}
