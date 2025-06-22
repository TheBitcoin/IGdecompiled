package Q3;

import P3.C2546b;
import Y3.C2611a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.LinkedBlockingDeque;

/* renamed from: Q3.h  reason: case insensitive filesystem */
public class C2557h {

    /* renamed from: c  reason: collision with root package name */
    private static final String f23894c = C2546b.i(C2557h.class);

    /* renamed from: a  reason: collision with root package name */
    private final LinkedBlockingDeque f23895a = new LinkedBlockingDeque();

    /* renamed from: b  reason: collision with root package name */
    private final C2558i f23896b;

    public C2557h(C2558i iVar) {
        this.f23896b = iVar;
    }

    public void a(C2556g gVar) {
        this.f23895a.add(gVar);
    }

    public void b(List list) {
        this.f23895a.drainTo(list);
    }

    public boolean c() {
        if (!this.f23895a.isEmpty() || !this.f23896b.d()) {
            return false;
        }
        return true;
    }

    public void d(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.f23895a.offerFirst((C2556g) it.next());
        }
    }

    public boolean e(boolean z4) {
        if (z4) {
            List f4 = this.f23896b.f();
            ListIterator listIterator = f4.listIterator(f4.size());
            while (listIterator.hasPrevious()) {
                this.f23895a.offerFirst((C2556g) listIterator.previous());
            }
            C2611a.b(f23894c).a("Switched state to ONLINE, uncached %d events from disk.", Integer.valueOf(f4.size()));
        } else if (!this.f23895a.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            this.f23895a.drainTo(arrayList);
            this.f23896b.a(arrayList);
            C2611a.b(f23894c).a("Switched state to OFFLINE, caching %d events to disk.", Integer.valueOf(arrayList.size()));
        }
        if (!z4 || this.f23895a.isEmpty()) {
            return false;
        }
        return true;
    }
}
