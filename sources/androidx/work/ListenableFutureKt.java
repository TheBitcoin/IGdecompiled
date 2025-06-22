package androidx.work;

import R2.s;
import V2.d;
import W2.b;
import androidx.annotation.RestrictTo;
import java.util.concurrent.ExecutionException;
import kotlin.coroutines.jvm.internal.h;
import kotlin.jvm.internal.l;
import o0.C2172d;
import o3.C0991n;

public final class ListenableFutureKt {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final <R> Object await(C2172d dVar, d dVar2) {
        if (dVar.isDone()) {
            try {
                return dVar.get();
            } catch (ExecutionException e5) {
                e = e5;
                Throwable cause = e.getCause();
                if (cause != null) {
                    e = cause;
                }
                throw e;
            }
        } else {
            C0991n nVar = new C0991n(b.b(dVar2), 1);
            nVar.z();
            dVar.addListener(new ListenableFutureKt$await$2$1(nVar, dVar), DirectExecutor.INSTANCE);
            nVar.q(new ListenableFutureKt$await$2$2(dVar));
            Object v4 = nVar.v();
            if (v4 == b.c()) {
                h.c(dVar2);
            }
            return v4;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    private static final <R> Object await$$forInline(C2172d dVar, d dVar2) {
        if (dVar.isDone()) {
            try {
                return dVar.get();
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
            C0991n nVar = new C0991n(b.b(dVar2), 1);
            nVar.z();
            dVar.addListener(new ListenableFutureKt$await$2$1(nVar, dVar), DirectExecutor.INSTANCE);
            nVar.q(new ListenableFutureKt$await$2$2(dVar));
            s sVar = s.f8222a;
            Object v4 = nVar.v();
            if (v4 == b.c()) {
                h.c(dVar2);
            }
            l.c(1);
            return v4;
        }
    }
}
