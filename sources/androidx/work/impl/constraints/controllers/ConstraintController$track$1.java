package androidx.work.impl.constraints.controllers;

import R2.n;
import V2.d;
import W2.b;
import d3.a;
import d3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import q3.q;
import q3.s;

@f(c = "androidx.work.impl.constraints.controllers.ConstraintController$track$1", f = "ContraintControllers.kt", l = {55}, m = "invokeSuspend")
final class ConstraintController$track$1 extends l implements p {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ConstraintController<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConstraintController$track$1(ConstraintController<T> constraintController, d dVar) {
        super(2, dVar);
        this.this$0 = constraintController;
    }

    public final d create(Object obj, d dVar) {
        ConstraintController$track$1 constraintController$track$1 = new ConstraintController$track$1(this.this$0, dVar);
        constraintController$track$1.L$0 = obj;
        return constraintController$track$1;
    }

    public final Object invokeSuspend(Object obj) {
        Object c5 = b.c();
        int i4 = this.label;
        if (i4 == 0) {
            n.b(obj);
            s sVar = (s) this.L$0;
            final ConstraintController$track$1$listener$1 constraintController$track$1$listener$1 = new ConstraintController$track$1$listener$1(this.this$0, sVar);
            this.this$0.tracker.addListener(constraintController$track$1$listener$1);
            final ConstraintController<T> constraintController = this.this$0;
            AnonymousClass1 r32 = new a() {
                public final void invoke() {
                    constraintController.tracker.removeListener(constraintController$track$1$listener$1);
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
        return ((ConstraintController$track$1) create(sVar, dVar)).invokeSuspend(R2.s.f8222a);
    }
}
