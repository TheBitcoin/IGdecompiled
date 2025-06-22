package androidx.lifecycle;

import R2.n;
import R2.s;
import V2.d;
import W2.b;
import d3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import o3.J;

@f(c = "androidx.lifecycle.LiveDataScopeImpl$emitSource$2", f = "CoroutineLiveData.kt", l = {94}, m = "invokeSuspend")
final class LiveDataScopeImpl$emitSource$2 extends l implements p {
    final /* synthetic */ LiveData<T> $source;
    int label;
    final /* synthetic */ LiveDataScopeImpl<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LiveDataScopeImpl$emitSource$2(LiveDataScopeImpl<T> liveDataScopeImpl, LiveData<T> liveData, d dVar) {
        super(2, dVar);
        this.this$0 = liveDataScopeImpl;
        this.$source = liveData;
    }

    public final d create(Object obj, d dVar) {
        return new LiveDataScopeImpl$emitSource$2(this.this$0, this.$source, dVar);
    }

    public final Object invokeSuspend(Object obj) {
        Object c5 = b.c();
        int i4 = this.label;
        if (i4 == 0) {
            n.b(obj);
            CoroutineLiveData<T> target$lifecycle_livedata_release = this.this$0.getTarget$lifecycle_livedata_release();
            LiveData<T> liveData = this.$source;
            this.label = 1;
            Object emitSource$lifecycle_livedata_release = target$lifecycle_livedata_release.emitSource$lifecycle_livedata_release(liveData, this);
            if (emitSource$lifecycle_livedata_release == c5) {
                return c5;
            }
            return emitSource$lifecycle_livedata_release;
        } else if (i4 == 1) {
            n.b(obj);
            return obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object invoke(J j4, d dVar) {
        return ((LiveDataScopeImpl$emitSource$2) create(j4, dVar)).invokeSuspend(s.f8222a);
    }
}
