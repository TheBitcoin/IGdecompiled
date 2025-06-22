package o3;

import V2.a;
import V2.d;
import d3.l;
import java.util.concurrent.CancellationException;

public final class G0 extends a implements C1001s0 {

    /* renamed from: a  reason: collision with root package name */
    public static final G0 f3654a = new G0();

    private G0() {
        super(C1001s0.f3726k0);
    }

    public boolean A() {
        return false;
    }

    public Z E(boolean z4, boolean z5, l lVar) {
        return H0.f3657a;
    }

    public Object g(d dVar) {
        throw new UnsupportedOperationException("This job is always active");
    }

    public C1001s0 getParent() {
        return null;
    }

    public Z i(l lVar) {
        return H0.f3657a;
    }

    public boolean isActive() {
        return true;
    }

    public boolean isCancelled() {
        return false;
    }

    public C1000s k(C1004u uVar) {
        return H0.f3657a;
    }

    public CancellationException l() {
        throw new IllegalStateException("This job is always active");
    }

    public boolean start() {
        return false;
    }

    public String toString() {
        return "NonCancellable";
    }

    public void a(CancellationException cancellationException) {
    }
}
