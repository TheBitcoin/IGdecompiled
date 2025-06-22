package androidx.datastore.preferences.core;

import S2.C1594h;
import androidx.datastore.preferences.core.Preferences;
import d3.l;
import java.util.Map;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

final class MutablePreferences$toString$1 extends n implements l {
    public static final MutablePreferences$toString$1 INSTANCE = new MutablePreferences$toString$1();

    MutablePreferences$toString$1() {
        super(1);
    }

    public final CharSequence invoke(Map.Entry<Preferences.Key<?>, Object> entry) {
        String str;
        m.e(entry, "entry");
        Object value = entry.getValue();
        if (value instanceof byte[]) {
            str = C1594h.B((byte[]) value, ", ", "[", "]", 0, (CharSequence) null, (l) null, 56, (Object) null);
        } else {
            str = String.valueOf(entry.getValue());
        }
        return "  " + entry.getKey().getName() + " = " + str;
    }
}
