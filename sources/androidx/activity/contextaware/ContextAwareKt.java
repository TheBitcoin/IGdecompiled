package androidx.activity.contextaware;

import R2.s;
import V2.d;
import W2.b;
import android.content.Context;
import d3.l;
import kotlin.coroutines.jvm.internal.h;
import o3.C0991n;

public final class ContextAwareKt {
    public static final <R> Object withContextAvailable(ContextAware contextAware, l lVar, d dVar) {
        Context peekAvailableContext = contextAware.peekAvailableContext();
        if (peekAvailableContext != null) {
            return lVar.invoke(peekAvailableContext);
        }
        C0991n nVar = new C0991n(b.b(dVar), 1);
        nVar.z();
        ContextAwareKt$withContextAvailable$2$listener$1 contextAwareKt$withContextAvailable$2$listener$1 = new ContextAwareKt$withContextAvailable$2$listener$1(nVar, lVar);
        contextAware.addOnContextAvailableListener(contextAwareKt$withContextAvailable$2$listener$1);
        nVar.q(new ContextAwareKt$withContextAvailable$2$1(contextAware, contextAwareKt$withContextAvailable$2$listener$1));
        Object v4 = nVar.v();
        if (v4 == b.c()) {
            h.c(dVar);
        }
        return v4;
    }

    private static final <R> Object withContextAvailable$$forInline(ContextAware contextAware, l lVar, d dVar) {
        Context peekAvailableContext = contextAware.peekAvailableContext();
        if (peekAvailableContext != null) {
            return lVar.invoke(peekAvailableContext);
        }
        kotlin.jvm.internal.l.c(0);
        C0991n nVar = new C0991n(b.b(dVar), 1);
        nVar.z();
        ContextAwareKt$withContextAvailable$2$listener$1 contextAwareKt$withContextAvailable$2$listener$1 = new ContextAwareKt$withContextAvailable$2$listener$1(nVar, lVar);
        contextAware.addOnContextAvailableListener(contextAwareKt$withContextAvailable$2$listener$1);
        nVar.q(new ContextAwareKt$withContextAvailable$2$1(contextAware, contextAwareKt$withContextAvailable$2$listener$1));
        s sVar = s.f8222a;
        Object v4 = nVar.v();
        if (v4 == b.c()) {
            h.c(dVar);
        }
        kotlin.jvm.internal.l.c(1);
        return v4;
    }
}
