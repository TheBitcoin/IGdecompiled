package j$.time.zone;

import java.security.PrivilegedAction;
import java.util.ArrayList;

public final class h implements PrivilegedAction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArrayList f5081a;

    public h(ArrayList arrayList) {
        this.f5081a = arrayList;
    }

    public final Object run() {
        Class<i> cls = i.class;
        String property = System.getProperty("java.time.zone.DefaultZoneRulesProvider");
        if (property != null) {
            try {
                i cast = cls.cast(Class.forName(property, true, cls.getClassLoader()).newInstance());
                i.b(cast);
                this.f5081a.add(cast);
                return null;
            } catch (Exception e5) {
                throw new Error(e5);
            }
        } else {
            i.b(new i());
            return null;
        }
    }
}
