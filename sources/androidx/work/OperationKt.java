package androidx.work;

import R2.s;
import V2.d;
import W2.b;
import java.util.concurrent.ExecutionException;
import kotlin.coroutines.jvm.internal.h;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.m;
import o0.C2172d;
import o3.C0991n;

public final class OperationKt {
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object await(androidx.work.Operation r4, V2.d r5) {
        /*
            boolean r0 = r5 instanceof androidx.work.OperationKt$await$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            androidx.work.OperationKt$await$1 r0 = (androidx.work.OperationKt$await$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.work.OperationKt$await$1 r0 = new androidx.work.OperationKt$await$1
            r0.<init>(r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r4 = r0.L$0
            o0.d r4 = (o0.C2172d) r4
            R2.n.b(r5)
            goto L_0x0088
        L_0x002d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0035:
            R2.n.b(r5)
            o0.d r4 = r4.getResult()
            java.lang.String r5 = "result"
            kotlin.jvm.internal.m.d(r4, r5)
            boolean r5 = r4.isDone()
            if (r5 == 0) goto L_0x0056
            java.lang.Object r4 = r4.get()     // Catch:{ ExecutionException -> 0x004c }
            goto L_0x0089
        L_0x004c:
            r4 = move-exception
            java.lang.Throwable r5 = r4.getCause()
            if (r5 != 0) goto L_0x0054
            goto L_0x0055
        L_0x0054:
            r4 = r5
        L_0x0055:
            throw r4
        L_0x0056:
            r0.L$0 = r4
            r0.label = r3
            o3.n r5 = new o3.n
            V2.d r2 = W2.b.b(r0)
            r5.<init>(r2, r3)
            r5.z()
            androidx.work.ListenableFutureKt$await$2$1 r2 = new androidx.work.ListenableFutureKt$await$2$1
            r2.<init>(r5, r4)
            androidx.work.DirectExecutor r3 = androidx.work.DirectExecutor.INSTANCE
            r4.addListener(r2, r3)
            androidx.work.ListenableFutureKt$await$2$2 r2 = new androidx.work.ListenableFutureKt$await$2$2
            r2.<init>(r4)
            r5.q(r2)
            java.lang.Object r5 = r5.v()
            java.lang.Object r4 = W2.b.c()
            if (r5 != r4) goto L_0x0085
            kotlin.coroutines.jvm.internal.h.c(r0)
        L_0x0085:
            if (r5 != r1) goto L_0x0088
            return r1
        L_0x0088:
            r4 = r5
        L_0x0089:
            java.lang.String r5 = "result.await()"
            kotlin.jvm.internal.m.d(r4, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.OperationKt.await(androidx.work.Operation, V2.d):java.lang.Object");
    }

    private static final Object await$$forInline(Operation operation, d dVar) {
        Object obj;
        C2172d result = operation.getResult();
        m.d(result, "result");
        if (result.isDone()) {
            try {
                obj = result.get();
            } catch (ExecutionException e5) {
                e = e5;
                Throwable cause = e.getCause();
                if (cause != null) {
                    e = cause;
                }
                throw e;
            }
        } else {
            l.c(0);
            C0991n nVar = new C0991n(b.b(dVar), 1);
            nVar.z();
            result.addListener(new ListenableFutureKt$await$2$1(nVar, result), DirectExecutor.INSTANCE);
            nVar.q(new ListenableFutureKt$await$2$2(result));
            s sVar = s.f8222a;
            obj = nVar.v();
            if (obj == b.c()) {
                h.c(dVar);
            }
            l.c(1);
        }
        m.d(obj, "result.await()");
        return obj;
    }
}
