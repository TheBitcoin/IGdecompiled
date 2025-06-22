package o3;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.internal.C2103g;

public class A {

    /* renamed from: b  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f3623b = AtomicIntegerFieldUpdater.newUpdater(A.class, "_handled");
    private volatile int _handled;

    /* renamed from: a  reason: collision with root package name */
    public final Throwable f3624a;

    public A(Throwable th, boolean z4) {
        this.f3624a = th;
        this._handled = z4 ? 1 : 0;
    }

    public final boolean a() {
        if (f3623b.get(this) != 0) {
            return true;
        }
        return false;
    }

    public final boolean b() {
        return f3623b.compareAndSet(this, 0, 1);
    }

    public String toString() {
        return N.a(this) + '[' + this.f3624a + ']';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ A(Throwable th, boolean z4, int i4, C2103g gVar) {
        this(th, (i4 & 2) != 0 ? false : z4);
    }
}
