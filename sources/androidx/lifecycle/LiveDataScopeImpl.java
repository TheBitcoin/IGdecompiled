package androidx.lifecycle;

import R2.s;
import V2.d;
import V2.g;
import W2.b;
import android.annotation.SuppressLint;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.jvm.internal.m;
import o3.C0977g;
import o3.Y;

public final class LiveDataScopeImpl<T> implements LiveDataScope<T> {
    private final g coroutineContext;
    private CoroutineLiveData<T> target;

    public LiveDataScopeImpl(CoroutineLiveData<T> coroutineLiveData, g gVar) {
        m.e(coroutineLiveData, TypedValues.AttributesType.S_TARGET);
        m.e(gVar, "context");
        this.target = coroutineLiveData;
        this.coroutineContext = gVar.plus(Y.c().D());
    }

    @SuppressLint({"NullSafeMutableLiveData"})
    public Object emit(T t4, d dVar) {
        Object g4 = C0977g.g(this.coroutineContext, new LiveDataScopeImpl$emit$2(this, t4, (d) null), dVar);
        if (g4 == b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    public Object emitSource(LiveData<T> liveData, d dVar) {
        return C0977g.g(this.coroutineContext, new LiveDataScopeImpl$emitSource$2(this, liveData, (d) null), dVar);
    }

    public T getLatestValue() {
        return this.target.getValue();
    }

    public final CoroutineLiveData<T> getTarget$lifecycle_livedata_release() {
        return this.target;
    }

    public final void setTarget$lifecycle_livedata_release(CoroutineLiveData<T> coroutineLiveData) {
        m.e(coroutineLiveData, "<set-?>");
        this.target = coroutineLiveData;
    }
}
