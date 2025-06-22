package androidx.lifecycle;

import androidx.annotation.MainThread;
import d3.l;
import kotlin.jvm.internal.m;

public final class LiveDataKt {
    @MainThread
    public static final <T> Observer<T> observe(LiveData<T> liveData, LifecycleOwner lifecycleOwner, l lVar) {
        m.e(liveData, "<this>");
        m.e(lifecycleOwner, "owner");
        m.e(lVar, "onChanged");
        LiveDataKt$observe$wrappedObserver$1 liveDataKt$observe$wrappedObserver$1 = new LiveDataKt$observe$wrappedObserver$1(lVar);
        liveData.observe(lifecycleOwner, liveDataKt$observe$wrappedObserver$1);
        return liveDataKt$observe$wrappedObserver$1;
    }
}
