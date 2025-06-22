package q;

import o.f;
import o.i;
import u.C1068a;

public abstract class l {
    public static void a(i iVar, f fVar) {
        if (iVar instanceof s) {
            u.c().e().l(((s) iVar).d().f(fVar), 1);
            return;
        }
        C1068a.g("ForcedSender", "Expected instance of `TransportImpl`, got `%s`.", iVar);
    }
}
