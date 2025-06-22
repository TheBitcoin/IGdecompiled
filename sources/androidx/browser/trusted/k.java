package androidx.browser.trusted;

import android.net.Uri;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TrustedWebActivityServiceConnectionPool f827a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Uri f828b;

    public /* synthetic */ k(TrustedWebActivityServiceConnectionPool trustedWebActivityServiceConnectionPool, Uri uri) {
        this.f827a = trustedWebActivityServiceConnectionPool;
        this.f828b = uri;
    }

    public final void run() {
        this.f827a.mConnections.remove(this.f828b);
    }
}
