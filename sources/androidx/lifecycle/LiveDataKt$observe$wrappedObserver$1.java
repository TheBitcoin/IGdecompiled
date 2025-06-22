package androidx.lifecycle;

import d3.l;

public final class LiveDataKt$observe$wrappedObserver$1<T> implements Observer {
    final /* synthetic */ l $onChanged;

    public LiveDataKt$observe$wrappedObserver$1(l lVar) {
        this.$onChanged = lVar;
    }

    public final void onChanged(T t4) {
        this.$onChanged.invoke(t4);
    }
}
