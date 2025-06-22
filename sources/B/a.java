package B;

import android.util.SparseArray;
import java.util.HashMap;
import o.f;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private static SparseArray f88a = new SparseArray();

    /* renamed from: b  reason: collision with root package name */
    private static HashMap f89b;

    static {
        HashMap hashMap = new HashMap();
        f89b = hashMap;
        hashMap.put(f.DEFAULT, 0);
        f89b.put(f.VERY_LOW, 1);
        f89b.put(f.HIGHEST, 2);
        for (f fVar : f89b.keySet()) {
            f88a.append(((Integer) f89b.get(fVar)).intValue(), fVar);
        }
    }

    public static int a(f fVar) {
        Integer num = (Integer) f89b.get(fVar);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + fVar);
    }

    public static f b(int i4) {
        f fVar = (f) f88a.get(i4);
        if (fVar != null) {
            return fVar;
        }
        throw new IllegalArgumentException("Unknown Priority for value " + i4);
    }
}
