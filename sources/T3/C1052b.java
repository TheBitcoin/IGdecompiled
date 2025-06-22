package t3;

import androidx.concurrent.futures.a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: t3.b  reason: case insensitive filesystem */
public abstract class C1052b extends y {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f4487a = AtomicReferenceFieldUpdater.newUpdater(C1052b.class, Object.class, "_consensus");
    private volatile Object _consensus = C1051a.f4486a;

    private final Object c(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f4487a;
        Object obj2 = atomicReferenceFieldUpdater.get(this);
        Object obj3 = C1051a.f4486a;
        if (obj2 != obj3) {
            return obj2;
        }
        if (a.a(atomicReferenceFieldUpdater, this, obj3, obj)) {
            return obj;
        }
        return atomicReferenceFieldUpdater.get(this);
    }

    public final Object a(Object obj) {
        Object obj2 = f4487a.get(this);
        if (obj2 == C1051a.f4486a) {
            obj2 = c(d(obj));
        }
        b(obj, obj2);
        return obj2;
    }

    public abstract void b(Object obj, Object obj2);

    public abstract Object d(Object obj);
}
