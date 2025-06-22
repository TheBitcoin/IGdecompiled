package androidx.lifecycle;

import V2.d;

public interface LiveDataScope<T> {
    Object emit(T t4, d dVar);

    Object emitSource(LiveData<T> liveData, d dVar);

    T getLatestValue();
}
