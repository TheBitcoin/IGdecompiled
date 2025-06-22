package androidx.browser.trusted;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class a implements CallbackToFutureAdapter.Resolver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConnectionHolder f826a;

    public /* synthetic */ a(ConnectionHolder connectionHolder) {
        this.f826a = connectionHolder;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return ConnectionHolder.a(this.f826a, completer);
    }
}
