package t3;

import java.util.ArrayList;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

/* renamed from: t3.l  reason: case insensitive filesystem */
public abstract class C1062l {
    public static /* synthetic */ Object b(Object obj, int i4, C2103g gVar) {
        if ((i4 & 1) != 0) {
            obj = null;
        }
        return a(obj);
    }

    public static final Object c(Object obj, Object obj2) {
        if (obj == null) {
            return a(obj2);
        }
        if (obj instanceof ArrayList) {
            m.c(obj, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
            ((ArrayList) obj).add(obj2);
            return a(obj);
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(obj2);
        return a(arrayList);
    }

    public static Object a(Object obj) {
        return obj;
    }
}
