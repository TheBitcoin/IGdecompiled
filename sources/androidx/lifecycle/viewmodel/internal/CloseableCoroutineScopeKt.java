package androidx.lifecycle.viewmodel.internal;

import V2.g;
import V2.h;
import kotlin.jvm.internal.m;
import o3.C1001s0;
import o3.J;
import o3.P0;
import o3.Y;

public final class CloseableCoroutineScopeKt {
    public static final String VIEW_MODEL_SCOPE_KEY = "androidx.lifecycle.viewmodel.internal.ViewModelCoroutineScope.JOB_KEY";

    public static final CloseableCoroutineScope asCloseable(J j4) {
        m.e(j4, "<this>");
        return new CloseableCoroutineScope(j4);
    }

    public static final CloseableCoroutineScope createViewModelScope() {
        g gVar;
        try {
            gVar = Y.c().D();
        } catch (IllegalStateException unused) {
            gVar = h.f8445a;
        }
        return new CloseableCoroutineScope(gVar.plus(P0.b((C1001s0) null, 1, (Object) null)));
    }
}
