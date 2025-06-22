package androidx.window.core;

import android.util.Log;
import kotlin.jvm.internal.m;

public final class AndroidLogger implements Logger {
    public static final AndroidLogger INSTANCE = new AndroidLogger();

    private AndroidLogger() {
    }

    public void debug(String str, String str2) {
        m.e(str, "tag");
        m.e(str2, "message");
        Log.d(str, str2);
    }
}
