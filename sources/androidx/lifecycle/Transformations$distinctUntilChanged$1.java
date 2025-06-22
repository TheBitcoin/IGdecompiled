package androidx.lifecycle;

import d3.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import kotlin.jvm.internal.z;

final class Transformations$distinctUntilChanged$1 extends n implements l {
    final /* synthetic */ z $firstTime;
    final /* synthetic */ MediatorLiveData<X> $outputLiveData;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Transformations$distinctUntilChanged$1(MediatorLiveData<X> mediatorLiveData, z zVar) {
        super(1);
        this.$outputLiveData = mediatorLiveData;
        this.$firstTime = zVar;
    }

    public final void invoke(X x4) {
        X value = this.$outputLiveData.getValue();
        if (this.$firstTime.f20985a || ((value == null && x4 != null) || (value != null && !m.a(value, x4)))) {
            this.$firstTime.f20985a = false;
            this.$outputLiveData.setValue(x4);
        }
    }
}
