package androidx.lifecycle;

import d3.l;
import kotlin.jvm.internal.n;

final class Transformations$switchMap$2$onChanged$1 extends n implements l {
    final /* synthetic */ MediatorLiveData $result;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Transformations$switchMap$2$onChanged$1(MediatorLiveData mediatorLiveData) {
        super(1);
        this.$result = mediatorLiveData;
    }

    public final void invoke(Object obj) {
        this.$result.setValue(obj);
    }
}
