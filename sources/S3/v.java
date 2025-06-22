package s3;

import V2.g;
import d3.p;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import o3.C1001s0;
import t3.B;

public abstract class v {

    static final class a extends n implements p {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ t f4410a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(t tVar) {
            super(2);
            this.f4410a = tVar;
        }

        public final Integer a(int i4, g.b bVar) {
            int i5;
            g.c key = bVar.getKey();
            g.b bVar2 = this.f4410a.f4403b.get(key);
            if (key != C1001s0.f3726k0) {
                if (bVar != bVar2) {
                    i5 = Integer.MIN_VALUE;
                } else {
                    i5 = i4 + 1;
                }
                return Integer.valueOf(i5);
            }
            C1001s0 s0Var = (C1001s0) bVar2;
            m.c(bVar, "null cannot be cast to non-null type kotlinx.coroutines.Job");
            C1001s0 b5 = v.b((C1001s0) bVar, s0Var);
            if (b5 == s0Var) {
                if (s0Var != null) {
                    i4++;
                }
                return Integer.valueOf(i4);
            }
            throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + b5 + ", expected child of " + s0Var + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a(((Number) obj).intValue(), (g.b) obj2);
        }
    }

    public static final void a(t tVar, g gVar) {
        if (((Number) gVar.fold(0, new a(tVar))).intValue() != tVar.f4404c) {
            throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + tVar.f4403b + ",\n\t\tbut emission happened in " + gVar + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
        }
    }

    public static final C1001s0 b(C1001s0 s0Var, C1001s0 s0Var2) {
        while (s0Var != null) {
            if (s0Var == s0Var2 || !(s0Var instanceof B)) {
                return s0Var;
            }
            s0Var = s0Var.getParent();
        }
        return null;
    }
}
