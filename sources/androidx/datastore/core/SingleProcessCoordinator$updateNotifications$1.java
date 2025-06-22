package androidx.datastore.core;

import R2.n;
import R2.s;
import V2.d;
import W2.b;
import d3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import r3.C1036f;

@f(c = "androidx.datastore.core.SingleProcessCoordinator$updateNotifications$1", f = "SingleProcessCoordinator.kt", l = {}, m = "invokeSuspend")
final class SingleProcessCoordinator$updateNotifications$1 extends l implements p {
    int label;

    SingleProcessCoordinator$updateNotifications$1(d dVar) {
        super(2, dVar);
    }

    public final d create(Object obj, d dVar) {
        return new SingleProcessCoordinator$updateNotifications$1(dVar);
    }

    public final Object invokeSuspend(Object obj) {
        b.c();
        if (this.label == 0) {
            n.b(obj);
            return s.f8222a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public final Object invoke(C1036f fVar, d dVar) {
        return ((SingleProcessCoordinator$updateNotifications$1) create(fVar, dVar)).invokeSuspend(s.f8222a);
    }
}
