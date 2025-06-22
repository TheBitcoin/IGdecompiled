package T2;

import S2.C1591e;
import java.util.Map;
import kotlin.jvm.internal.m;

public abstract class a extends C1591e {
    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        return h((Map.Entry) obj);
    }

    public final boolean h(Map.Entry entry) {
        m.e(entry, "element");
        return j(entry);
    }

    public abstract boolean j(Map.Entry entry);

    public abstract /* bridge */ boolean k(Map.Entry entry);

    public final /* bridge */ boolean remove(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        return k((Map.Entry) obj);
    }
}
