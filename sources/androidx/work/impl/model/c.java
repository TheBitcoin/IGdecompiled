package androidx.work.impl.model;

import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.m;

public abstract /* synthetic */ class c {
    public static void a(WorkTagDao workTagDao, String str, Set set) {
        m.e(str, "id");
        m.e(set, "tags");
        Iterator it = set.iterator();
        while (it.hasNext()) {
            workTagDao.insert(new WorkTag((String) it.next(), str));
        }
    }
}
