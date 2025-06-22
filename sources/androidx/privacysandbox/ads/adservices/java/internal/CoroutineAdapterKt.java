package androidx.privacysandbox.ads.adservices.java.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import kotlin.jvm.internal.m;
import o0.C2172d;
import o3.Q;

public final class CoroutineAdapterKt {
    public static final <T> C2172d asListenableFuture(Q q4, Object obj) {
        m.e(q4, "<this>");
        C2172d future = CallbackToFutureAdapter.getFuture(new a(q4, obj));
        m.d(future, "getFuture { completer ->…        }\n    }\n    tag\n}");
        return future;
    }

    public static /* synthetic */ C2172d asListenableFuture$default(Q q4, Object obj, int i4, Object obj2) {
        if ((i4 & 1) != 0) {
            obj = "Deferred.asListenableFuture";
        }
        return asListenableFuture(q4, obj);
    }

    /* access modifiers changed from: private */
    public static final Object asListenableFuture$lambda$0(Q q4, Object obj, CallbackToFutureAdapter.Completer completer) {
        m.e(q4, "$this_asListenableFuture");
        m.e(completer, "completer");
        q4.i(new CoroutineAdapterKt$asListenableFuture$1$1(completer, q4));
        return obj;
    }
}
