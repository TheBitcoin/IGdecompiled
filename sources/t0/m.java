package t0;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public enum m implements Executor {
    INSTANCE;
    

    /* renamed from: b  reason: collision with root package name */
    private static final Handler f21781b = null;

    static {
        f21781b = new Handler(Looper.getMainLooper());
    }

    public void execute(Runnable runnable) {
        f21781b.post(runnable);
    }
}
