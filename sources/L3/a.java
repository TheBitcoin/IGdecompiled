package l3;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.m;

public final class a implements e {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReference f21024a;

    public a(e eVar) {
        m.e(eVar, "sequence");
        this.f21024a = new AtomicReference(eVar);
    }

    public Iterator iterator() {
        e eVar = (e) this.f21024a.getAndSet((Object) null);
        if (eVar != null) {
            return eVar.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
