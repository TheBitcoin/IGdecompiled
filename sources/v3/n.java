package v3;

import androidx.concurrent.futures.a;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.C;
import q3.i;

public final class n {

    /* renamed from: b  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f4582b;

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f4583c;

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f4584d;

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f4585e;

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReferenceArray f4586a = new AtomicReferenceArray(128);
    private volatile int blockingTasksInBuffer;
    private volatile int consumerIndex;
    private volatile Object lastScheduledTask;
    private volatile int producerIndex;

    static {
        Class<n> cls = n.class;
        f4582b = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "lastScheduledTask");
        f4583c = AtomicIntegerFieldUpdater.newUpdater(cls, "producerIndex");
        f4584d = AtomicIntegerFieldUpdater.newUpdater(cls, "consumerIndex");
        f4585e = AtomicIntegerFieldUpdater.newUpdater(cls, "blockingTasksInBuffer");
    }

    private final h b(h hVar) {
        if (d() == 127) {
            return hVar;
        }
        if (hVar.f4570b.b() == 1) {
            f4585e.incrementAndGet(this);
        }
        int i4 = f4583c.get(this) & ModuleDescriptor.MODULE_VERSION;
        while (this.f4586a.get(i4) != null) {
            Thread.yield();
        }
        this.f4586a.lazySet(i4, hVar);
        f4583c.incrementAndGet(this);
        return null;
    }

    private final void c(h hVar) {
        if (hVar != null && hVar.f4570b.b() == 1) {
            f4585e.decrementAndGet(this);
        }
    }

    private final int d() {
        return f4583c.get(this) - f4584d.get(this);
    }

    private final h i() {
        h hVar;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f4584d;
            int i4 = atomicIntegerFieldUpdater.get(this);
            if (i4 - f4583c.get(this) == 0) {
                return null;
            }
            int i5 = i4 & ModuleDescriptor.MODULE_VERSION;
            if (atomicIntegerFieldUpdater.compareAndSet(this, i4, i4 + 1) && (hVar = (h) this.f4586a.getAndSet(i5, (Object) null)) != null) {
                c(hVar);
                return hVar;
            }
        }
    }

    private final boolean j(d dVar) {
        h i4 = i();
        if (i4 == null) {
            return false;
        }
        dVar.a(i4);
        return true;
    }

    private final h k(boolean z4) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        h hVar;
        do {
            atomicReferenceFieldUpdater = f4582b;
            hVar = (h) atomicReferenceFieldUpdater.get(this);
            if (hVar != null) {
                boolean z5 = true;
                if (hVar.f4570b.b() != 1) {
                    z5 = false;
                }
                if (z5 == z4) {
                }
            }
            int i4 = f4584d.get(this);
            int i5 = f4583c.get(this);
            while (i4 != i5) {
                if (z4 && f4585e.get(this) == 0) {
                    return null;
                }
                i5--;
                h m4 = m(i5, z4);
                if (m4 != null) {
                    return m4;
                }
            }
            return null;
        } while (!a.a(atomicReferenceFieldUpdater, this, hVar, (Object) null));
        return hVar;
    }

    private final h l(int i4) {
        int i5 = f4584d.get(this);
        int i6 = f4583c.get(this);
        boolean z4 = true;
        if (i4 != 1) {
            z4 = false;
        }
        while (i5 != i6) {
            if (z4 && f4585e.get(this) == 0) {
                return null;
            }
            int i7 = i5 + 1;
            h m4 = m(i5, z4);
            if (m4 != null) {
                return m4;
            }
            i5 = i7;
        }
        return null;
    }

    private final h m(int i4, boolean z4) {
        int i5 = i4 & ModuleDescriptor.MODULE_VERSION;
        h hVar = (h) this.f4586a.get(i5);
        if (hVar != null) {
            boolean z5 = true;
            if (hVar.f4570b.b() != 1) {
                z5 = false;
            }
            if (z5 == z4 && i.a(this.f4586a, i5, hVar, (Object) null)) {
                if (z4) {
                    f4585e.decrementAndGet(this);
                }
                return hVar;
            }
        }
        return null;
    }

    private final long o(int i4, C c5) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        h hVar;
        do {
            atomicReferenceFieldUpdater = f4582b;
            hVar = (h) atomicReferenceFieldUpdater.get(this);
            if (hVar == null) {
                return -2;
            }
            int i5 = 1;
            if (hVar.f4570b.b() != 1) {
                i5 = 2;
            }
            if ((i5 & i4) == 0) {
                return -2;
            }
            long a5 = l.f4578f.a() - hVar.f4569a;
            long j4 = l.f4574b;
            if (a5 < j4) {
                return j4 - a5;
            }
        } while (!a.a(atomicReferenceFieldUpdater, this, hVar, (Object) null));
        c5.f20968a = hVar;
        return -1;
    }

    public final h a(h hVar, boolean z4) {
        if (z4) {
            return b(hVar);
        }
        h hVar2 = (h) f4582b.getAndSet(this, hVar);
        if (hVar2 == null) {
            return null;
        }
        return b(hVar2);
    }

    public final int e() {
        if (f4582b.get(this) != null) {
            return d() + 1;
        }
        return d();
    }

    public final void f(d dVar) {
        h hVar = (h) f4582b.getAndSet(this, (Object) null);
        if (hVar != null) {
            dVar.a(hVar);
        }
        do {
        } while (j(dVar));
    }

    public final h g() {
        h hVar = (h) f4582b.getAndSet(this, (Object) null);
        if (hVar == null) {
            return i();
        }
        return hVar;
    }

    public final h h() {
        return k(true);
    }

    public final long n(int i4, C c5) {
        h hVar;
        if (i4 == 3) {
            hVar = i();
        } else {
            hVar = l(i4);
        }
        if (hVar == null) {
            return o(i4, c5);
        }
        c5.f20968a = hVar;
        return -1;
    }
}
