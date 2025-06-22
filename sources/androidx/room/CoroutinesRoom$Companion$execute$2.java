package androidx.room;

import R2.n;
import R2.s;
import V2.d;
import W2.b;
import d3.p;
import java.util.concurrent.Callable;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import o3.J;

@f(c = "androidx.room.CoroutinesRoom$Companion$execute$2", f = "CoroutinesRoom.kt", l = {}, m = "invokeSuspend")
final class CoroutinesRoom$Companion$execute$2 extends l implements p {
    final /* synthetic */ Callable<R> $callable;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoroutinesRoom$Companion$execute$2(Callable<R> callable, d dVar) {
        super(2, dVar);
        this.$callable = callable;
    }

    public final d create(Object obj, d dVar) {
        return new CoroutinesRoom$Companion$execute$2(this.$callable, dVar);
    }

    public final Object invokeSuspend(Object obj) {
        b.c();
        if (this.label == 0) {
            n.b(obj);
            return this.$callable.call();
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public final Object invoke(J j4, d dVar) {
        return ((CoroutinesRoom$Companion$execute$2) create(j4, dVar)).invokeSuspend(s.f8222a);
    }
}
