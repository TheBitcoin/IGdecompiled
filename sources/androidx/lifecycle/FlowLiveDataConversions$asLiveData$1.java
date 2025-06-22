package androidx.lifecycle;

import R2.n;
import R2.s;
import V2.d;
import W2.b;
import d3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import r3.C1035e;
import r3.C1036f;

@f(c = "androidx.lifecycle.FlowLiveDataConversions$asLiveData$1", f = "FlowLiveData.kt", l = {78}, m = "invokeSuspend")
final class FlowLiveDataConversions$asLiveData$1 extends l implements p {
    final /* synthetic */ C1035e $this_asLiveData;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowLiveDataConversions$asLiveData$1(C1035e eVar, d dVar) {
        super(2, dVar);
        this.$this_asLiveData = eVar;
    }

    public final d create(Object obj, d dVar) {
        FlowLiveDataConversions$asLiveData$1 flowLiveDataConversions$asLiveData$1 = new FlowLiveDataConversions$asLiveData$1(this.$this_asLiveData, dVar);
        flowLiveDataConversions$asLiveData$1.L$0 = obj;
        return flowLiveDataConversions$asLiveData$1;
    }

    public final Object invoke(LiveDataScope<T> liveDataScope, d dVar) {
        return ((FlowLiveDataConversions$asLiveData$1) create(liveDataScope, dVar)).invokeSuspend(s.f8222a);
    }

    public final Object invokeSuspend(Object obj) {
        Object c5 = b.c();
        int i4 = this.label;
        if (i4 == 0) {
            n.b(obj);
            final LiveDataScope liveDataScope = (LiveDataScope) this.L$0;
            C1035e eVar = this.$this_asLiveData;
            AnonymousClass1 r32 = new C1036f() {
                public final Object emit(T t4, d dVar) {
                    Object emit = liveDataScope.emit(t4, dVar);
                    if (emit == b.c()) {
                        return emit;
                    }
                    return s.f8222a;
                }
            };
            this.label = 1;
            if (eVar.collect(r32, this) == c5) {
                return c5;
            }
        } else if (i4 == 1) {
            n.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return s.f8222a;
    }
}
