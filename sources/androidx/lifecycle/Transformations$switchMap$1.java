package androidx.lifecycle;

import d3.l;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

final class Transformations$switchMap$1 extends n implements l {
    final /* synthetic */ C $liveData;
    final /* synthetic */ MediatorLiveData<Y> $result;
    final /* synthetic */ l $transform;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Transformations$switchMap$1(l lVar, C c5, MediatorLiveData<Y> mediatorLiveData) {
        super(1);
        this.$transform = lVar;
        this.$liveData = c5;
        this.$result = mediatorLiveData;
    }

    public final void invoke(X x4) {
        LiveData liveData = (LiveData) this.$transform.invoke(x4);
        Object obj = this.$liveData.f20968a;
        if (obj != liveData) {
            if (obj != null) {
                MediatorLiveData<Y> mediatorLiveData = this.$result;
                m.b(obj);
                mediatorLiveData.removeSource((LiveData) obj);
            }
            this.$liveData.f20968a = liveData;
            if (liveData != null) {
                MediatorLiveData<Y> mediatorLiveData2 = this.$result;
                m.b(liveData);
                final MediatorLiveData<Y> mediatorLiveData3 = this.$result;
                mediatorLiveData2.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new l() {
                    public final void invoke(Y y4) {
                        mediatorLiveData3.setValue(y4);
                    }
                }));
            }
        }
    }
}
