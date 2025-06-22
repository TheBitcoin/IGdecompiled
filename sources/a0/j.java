package A0;

import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.List;
import v0.g;

public class j {

    /* renamed from: a  reason: collision with root package name */
    private final List f5731a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final int f5732b;

    public j(int i4) {
        this.f5732b = i4;
    }

    public List a() {
        List b5 = b();
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < b5.size(); i4++) {
            arrayList.add(((i) b5.get(i4)).h());
        }
        return arrayList;
    }

    public synchronized List b() {
        return DesugarCollections.unmodifiableList(new ArrayList(this.f5731a));
    }

    public synchronized boolean c(List list) {
        this.f5731a.clear();
        if (list.size() > this.f5732b) {
            g f4 = g.f();
            f4.k("Ignored " + 0 + " entries when adding rollout assignments. Maximum allowable: " + this.f5732b);
            return this.f5731a.addAll(list.subList(0, this.f5732b));
        }
        return this.f5731a.addAll(list);
    }
}
