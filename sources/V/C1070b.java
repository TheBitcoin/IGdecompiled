package v;

/* renamed from: v.b  reason: case insensitive filesystem */
public abstract class C1070b {
    public static Object a(int i4, Object obj, C1069a aVar, C1071c cVar) {
        Object apply;
        if (i4 < 1) {
            return aVar.apply(obj);
        }
        do {
            apply = aVar.apply(obj);
            obj = cVar.a(obj, apply);
            if (obj == null || i4 - 1 < 1) {
                return apply;
            }
            apply = aVar.apply(obj);
            obj = cVar.a(obj, apply);
            break;
        } while (i4 - 1 < 1);
        return apply;
    }
}
