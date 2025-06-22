package androidx.lifecycle;

import R2.n;
import V2.d;
import W2.b;
import androidx.lifecycle.Lifecycle;
import d3.a;
import d3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import q3.q;
import q3.s;

@f(c = "androidx.lifecycle.LifecycleKt$eventFlow$1", f = "Lifecycle.kt", l = {388}, m = "invokeSuspend")
final class LifecycleKt$eventFlow$1 extends l implements p {
    final /* synthetic */ Lifecycle $this_eventFlow;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LifecycleKt$eventFlow$1(Lifecycle lifecycle, d dVar) {
        super(2, dVar);
        this.$this_eventFlow = lifecycle;
    }

    /* access modifiers changed from: private */
    public static final void invokeSuspend$lambda$0(s sVar, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        sVar.B(event);
    }

    public final d create(Object obj, d dVar) {
        LifecycleKt$eventFlow$1 lifecycleKt$eventFlow$1 = new LifecycleKt$eventFlow$1(this.$this_eventFlow, dVar);
        lifecycleKt$eventFlow$1.L$0 = obj;
        return lifecycleKt$eventFlow$1;
    }

    public final Object invokeSuspend(Object obj) {
        Object c5 = b.c();
        int i4 = this.label;
        if (i4 == 0) {
            n.b(obj);
            s sVar = (s) this.L$0;
            final j jVar = new j(sVar);
            this.$this_eventFlow.addObserver(jVar);
            final Lifecycle lifecycle = this.$this_eventFlow;
            AnonymousClass1 r32 = new a() {
                public final void invoke() {
                    lifecycle.removeObserver(jVar);
                }
            };
            this.label = 1;
            if (q.a(sVar, r32, this) == c5) {
                return c5;
            }
        } else if (i4 == 1) {
            n.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return R2.s.f8222a;
    }

    public final Object invoke(s sVar, d dVar) {
        return ((LifecycleKt$eventFlow$1) create(sVar, dVar)).invokeSuspend(R2.s.f8222a);
    }
}
