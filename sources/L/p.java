package L;

import K.e;
import android.os.Looper;
import com.google.android.gms.common.api.internal.C0503b;

public final class p extends m {

    /* renamed from: c  reason: collision with root package name */
    private final e f400c;

    public p(e eVar) {
        super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
        this.f400c = eVar;
    }

    public final C0503b a(C0503b bVar) {
        return this.f400c.e(bVar);
    }

    public final Looper c() {
        return this.f400c.k();
    }
}
