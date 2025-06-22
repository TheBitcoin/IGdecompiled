package androidx.lifecycle;

import d3.l;
import kotlin.jvm.internal.n;

final class Transformations$map$1 extends n implements l {
    final /* synthetic */ MediatorLiveData<Y> $result;
    final /* synthetic */ l $transform;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Transformations$map$1(MediatorLiveData<Y> mediatorLiveData, l lVar) {
        super(1);
        this.$result = mediatorLiveData;
        this.$transform = lVar;
    }

    public final void invoke(X x4) {
        this.$result.setValue(this.$transform.invoke(x4));
    }
}
