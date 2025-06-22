package androidx.emoji2.text;

import java.util.concurrent.ThreadFactory;

public final /* synthetic */ class b implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f938a;

    public /* synthetic */ b(String str) {
        this.f938a = str;
    }

    public final Thread newThread(Runnable runnable) {
        return ConcurrencyHelpers.a(this.f938a, runnable);
    }
}
