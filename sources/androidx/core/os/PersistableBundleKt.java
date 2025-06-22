package androidx.core.os;

import R2.l;
import android.os.PersistableBundle;
import androidx.annotation.RequiresApi;
import java.util.Map;

public final class PersistableBundleKt {
    @RequiresApi(21)
    public static final PersistableBundle persistableBundleOf(l... lVarArr) {
        PersistableBundle createPersistableBundle = PersistableBundleApi21ImplKt.createPersistableBundle(lVarArr.length);
        for (l lVar : lVarArr) {
            PersistableBundleApi21ImplKt.putValue(createPersistableBundle, (String) lVar.a(), lVar.b());
        }
        return createPersistableBundle;
    }

    @RequiresApi(21)
    public static final PersistableBundle toPersistableBundle(Map<String, ? extends Object> map) {
        PersistableBundle createPersistableBundle = PersistableBundleApi21ImplKt.createPersistableBundle(map.size());
        for (Map.Entry next : map.entrySet()) {
            PersistableBundleApi21ImplKt.putValue(createPersistableBundle, (String) next.getKey(), next.getValue());
        }
        return createPersistableBundle;
    }

    @RequiresApi(21)
    public static final PersistableBundle persistableBundleOf() {
        return PersistableBundleApi21ImplKt.createPersistableBundle(0);
    }
}
