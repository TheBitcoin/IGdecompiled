package s3;

import V2.d;
import d3.q;
import kotlin.jvm.internal.G;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;
import r3.C1036f;

public abstract class u {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final q f4408a;

    /* synthetic */ class a extends k implements q {

        /* renamed from: a  reason: collision with root package name */
        public static final a f4409a = new a();

        a() {
            super(3, C1036f.class, "emit", "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        /* renamed from: d */
        public final Object invoke(C1036f fVar, Object obj, d dVar) {
            return fVar.emit(obj, dVar);
        }
    }

    static {
        a aVar = a.f4409a;
        m.c(aVar, "null cannot be cast to non-null type kotlin.Function3<kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>, kotlin.Any?, kotlin.coroutines.Continuation<kotlin.Unit>, kotlin.Any?>");
        f4408a = (q) G.b(aVar, 3);
    }
}
