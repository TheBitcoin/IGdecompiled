package q;

import android.content.Context;
import java.io.Closeable;
import y.C1094d;

abstract class v implements Closeable, AutoCloseable {

    interface a {
        a a(Context context);

        v build();
    }

    v() {
    }

    /* access modifiers changed from: package-private */
    public abstract C1094d a();

    public void close() {
        a().close();
    }

    /* access modifiers changed from: package-private */
    public abstract u d();
}
