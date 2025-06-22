package y0;

import android.os.Process;

/* renamed from: y0.e  reason: case insensitive filesystem */
public abstract class C2415e implements Runnable {
    /* access modifiers changed from: protected */
    public abstract void a();

    public final void run() {
        Process.setThreadPriority(10);
        a();
    }
}
