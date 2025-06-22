package androidx.customview.poolingcontainer;

import S2.C1601o;
import java.util.ArrayList;
import kotlin.jvm.internal.m;

final class PoolingContainerListenerHolder {
    private final ArrayList<PoolingContainerListener> listeners = new ArrayList<>();

    public final void addListener(PoolingContainerListener poolingContainerListener) {
        m.e(poolingContainerListener, "listener");
        this.listeners.add(poolingContainerListener);
    }

    public final void onRelease() {
        for (int j4 = C1601o.j(this.listeners); -1 < j4; j4--) {
            this.listeners.get(j4).onRelease();
        }
    }

    public final void removeListener(PoolingContainerListener poolingContainerListener) {
        m.e(poolingContainerListener, "listener");
        this.listeners.remove(poolingContainerListener);
    }
}
