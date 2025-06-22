package androidx.privacysandbox.ads.adservices.java.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import o3.Q;

public final /* synthetic */ class a implements CallbackToFutureAdapter.Resolver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Q f966a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f967b;

    public /* synthetic */ a(Q q4, Object obj) {
        this.f966a = q4;
        this.f967b = obj;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return CoroutineAdapterKt.asListenableFuture$lambda$0(this.f966a, this.f967b, completer);
    }
}
