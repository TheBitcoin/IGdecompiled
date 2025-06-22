package androidx.room;

import R2.m;
import R2.n;
import R2.s;
import V2.d;
import V2.e;
import V2.g;
import W2.b;
import d3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import o3.C0989m;
import o3.C1001s0;
import o3.J;

final class RoomDatabaseKt$acquireTransactionThread$2$2 implements Runnable {
    final /* synthetic */ C0989m $continuation;
    final /* synthetic */ C1001s0 $controlJob;

    @f(c = "androidx.room.RoomDatabaseKt$acquireTransactionThread$2$2$1", f = "RoomDatabaseExt.kt", l = {125}, m = "invokeSuspend")
    /* renamed from: androidx.room.RoomDatabaseKt$acquireTransactionThread$2$2$1  reason: invalid class name */
    static final class AnonymousClass1 extends l implements p {
        private /* synthetic */ Object L$0;
        int label;

        public final d create(Object obj, d dVar) {
            AnonymousClass1 r02 = new AnonymousClass1(mVar, s0Var, dVar);
            r02.L$0 = obj;
            return r02;
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = b.c();
            int i4 = this.label;
            if (i4 == 0) {
                n.b(obj);
                C0989m mVar = mVar;
                m.a aVar = m.f8216a;
                g.b bVar = ((J) this.L$0).getCoroutineContext().get(e.f8442a0);
                kotlin.jvm.internal.m.b(bVar);
                mVar.resumeWith(m.a(bVar));
                C1001s0 s0Var = s0Var;
                this.label = 1;
                if (s0Var.g(this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }

        public final Object invoke(J j4, d dVar) {
            return ((AnonymousClass1) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    RoomDatabaseKt$acquireTransactionThread$2$2(C0989m mVar, C1001s0 s0Var) {
        this.$continuation = mVar;
        this.$controlJob = s0Var;
    }

    public final void run() {
        final C0989m mVar = this.$continuation;
        final C1001s0 s0Var = this.$controlJob;
        Object unused = C0979h.b((g) null, new AnonymousClass1((d) null), 1, (Object) null);
    }
}
