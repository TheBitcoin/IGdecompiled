package t3;

import V2.g;
import androidx.core.internal.view.SupportMenu;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import o3.I0;

public abstract class C extends C1055e implements I0 {

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f4462d = AtomicIntegerFieldUpdater.newUpdater(C.class, "cleanedAndPointers");

    /* renamed from: c  reason: collision with root package name */
    public final long f4463c;
    private volatile int cleanedAndPointers;

    public C(long j4, C c5, int i4) {
        super(c5);
        this.f4463c = j4;
        this.cleanedAndPointers = i4 << 16;
    }

    public boolean h() {
        if (f4462d.get(this) != n() || i()) {
            return false;
        }
        return true;
    }

    public final boolean m() {
        if (f4462d.addAndGet(this, SupportMenu.CATEGORY_MASK) != n() || i()) {
            return false;
        }
        return true;
    }

    public abstract int n();

    public abstract void o(int i4, Throwable th, g gVar);

    public final void p() {
        if (f4462d.incrementAndGet(this) == n()) {
            k();
        }
    }

    public final boolean q() {
        int i4;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f4462d;
        do {
            i4 = atomicIntegerFieldUpdater.get(this);
            if (i4 == n() && !i()) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i4, 65536 + i4));
        return true;
    }
}
