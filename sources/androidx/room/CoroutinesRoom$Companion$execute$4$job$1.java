package androidx.room;

import R2.m;
import R2.n;
import R2.s;
import V2.d;
import W2.b;
import d3.p;
import java.util.concurrent.Callable;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import o3.C0989m;
import o3.J;

@f(c = "androidx.room.CoroutinesRoom$Companion$execute$4$job$1", f = "CoroutinesRoom.kt", l = {}, m = "invokeSuspend")
final class CoroutinesRoom$Companion$execute$4$job$1 extends l implements p {
    final /* synthetic */ Callable<R> $callable;
    final /* synthetic */ C0989m $continuation;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoroutinesRoom$Companion$execute$4$job$1(Callable<R> callable, C0989m mVar, d dVar) {
        super(2, dVar);
        this.$callable = callable;
        this.$continuation = mVar;
    }

    public final d create(Object obj, d dVar) {
        return new CoroutinesRoom$Companion$execute$4$job$1(this.$callable, this.$continuation, dVar);
    }

    public final Object invokeSuspend(Object obj) {
        b.c();
        if (this.label == 0) {
            n.b(obj);
            try {
                this.$continuation.resumeWith(m.a(this.$callable.call()));
            } catch (Throwable th) {
                C0989m mVar = this.$continuation;
                m.a aVar = m.f8216a;
                mVar.resumeWith(m.a(n.a(th)));
            }
            return s.f8222a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public final Object invoke(J j4, d dVar) {
        return ((CoroutinesRoom$Companion$execute$4$job$1) create(j4, dVar)).invokeSuspend(s.f8222a);
    }
}
