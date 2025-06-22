package K;

import L.l;
import M.C0335p;
import com.google.android.gms.common.api.Status;

public abstract class h {
    public static g a(j jVar, f fVar) {
        C0335p.m(jVar, "Result must not be null");
        C0335p.b(!jVar.getStatus().k(), "Status code must not be SUCCESS");
        m mVar = new m(fVar, jVar);
        mVar.f(jVar);
        return mVar;
    }

    public static g b(Status status, f fVar) {
        C0335p.m(status, "Result must not be null");
        l lVar = new l(fVar);
        lVar.f(status);
        return lVar;
    }
}
