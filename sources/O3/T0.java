package o3;

import V2.g;

public final class T0 extends G {

    /* renamed from: a  reason: collision with root package name */
    public static final T0 f3674a = new T0();

    private T0() {
    }

    public void dispatch(g gVar, Runnable runnable) {
        X0 x02 = (X0) gVar.get(X0.f3681b);
        if (x02 != null) {
            x02.f3682a = true;
            return;
        }
        throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
    }

    public boolean isDispatchNeeded(g gVar) {
        return false;
    }

    public G limitedParallelism(int i4) {
        throw new UnsupportedOperationException("limitedParallelism is not supported for Dispatchers.Unconfined");
    }

    public String toString() {
        return "Dispatchers.Unconfined";
    }
}
