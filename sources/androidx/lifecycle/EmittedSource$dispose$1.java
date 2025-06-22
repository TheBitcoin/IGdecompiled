package androidx.lifecycle;

import R2.n;
import R2.s;
import V2.d;
import W2.b;
import d3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import o3.J;

@f(c = "androidx.lifecycle.EmittedSource$dispose$1", f = "CoroutineLiveData.kt", l = {}, m = "invokeSuspend")
final class EmittedSource$dispose$1 extends l implements p {
    int label;
    final /* synthetic */ EmittedSource this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EmittedSource$dispose$1(EmittedSource emittedSource, d dVar) {
        super(2, dVar);
        this.this$0 = emittedSource;
    }

    public final d create(Object obj, d dVar) {
        return new EmittedSource$dispose$1(this.this$0, dVar);
    }

    public final Object invokeSuspend(Object obj) {
        b.c();
        if (this.label == 0) {
            n.b(obj);
            this.this$0.removeSource();
            return s.f8222a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public final Object invoke(J j4, d dVar) {
        return ((EmittedSource$dispose$1) create(j4, dVar)).invokeSuspend(s.f8222a);
    }
}
