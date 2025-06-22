package androidx.lifecycle;

import R2.n;
import R2.s;
import V2.d;
import W2.b;
import androidx.lifecycle.Lifecycle;
import d3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import o3.C0977g;
import o3.C1001s0;
import o3.J;

@f(c = "androidx.lifecycle.PausingDispatcherKt$whenStateAtLeast$2", f = "PausingDispatcher.jvm.kt", l = {205}, m = "invokeSuspend")
final class PausingDispatcherKt$whenStateAtLeast$2 extends l implements p {
    final /* synthetic */ p $block;
    final /* synthetic */ Lifecycle.State $minState;
    final /* synthetic */ Lifecycle $this_whenStateAtLeast;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PausingDispatcherKt$whenStateAtLeast$2(Lifecycle lifecycle, Lifecycle.State state, p pVar, d dVar) {
        super(2, dVar);
        this.$this_whenStateAtLeast = lifecycle;
        this.$minState = state;
        this.$block = pVar;
    }

    public final d create(Object obj, d dVar) {
        PausingDispatcherKt$whenStateAtLeast$2 pausingDispatcherKt$whenStateAtLeast$2 = new PausingDispatcherKt$whenStateAtLeast$2(this.$this_whenStateAtLeast, this.$minState, this.$block, dVar);
        pausingDispatcherKt$whenStateAtLeast$2.L$0 = obj;
        return pausingDispatcherKt$whenStateAtLeast$2;
    }

    public final Object invokeSuspend(Object obj) {
        LifecycleController lifecycleController;
        Object c5 = b.c();
        int i4 = this.label;
        if (i4 == 0) {
            n.b(obj);
            C1001s0 s0Var = (C1001s0) ((J) this.L$0).getCoroutineContext().get(C1001s0.f3726k0);
            if (s0Var != null) {
                PausingDispatcher pausingDispatcher = new PausingDispatcher();
                LifecycleController lifecycleController2 = new LifecycleController(this.$this_whenStateAtLeast, this.$minState, pausingDispatcher.dispatchQueue, s0Var);
                try {
                    p pVar = this.$block;
                    this.L$0 = lifecycleController2;
                    this.label = 1;
                    obj = C0977g.g(pausingDispatcher, pVar, this);
                    if (obj == c5) {
                        return c5;
                    }
                    lifecycleController = lifecycleController2;
                } catch (Throwable th) {
                    th = th;
                    lifecycleController = lifecycleController2;
                    lifecycleController.finish();
                    throw th;
                }
            } else {
                throw new IllegalStateException("when[State] methods should have a parent job");
            }
        } else if (i4 == 1) {
            lifecycleController = (LifecycleController) this.L$0;
            try {
                n.b(obj);
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        lifecycleController.finish();
        return obj;
    }

    public final Object invoke(J j4, d dVar) {
        return ((PausingDispatcherKt$whenStateAtLeast$2) create(j4, dVar)).invokeSuspend(s.f8222a);
    }
}
