package S;

import android.os.Process;

final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final Runnable f634a;

    public b(Runnable runnable, int i4) {
        this.f634a = runnable;
    }

    public final void run() {
        Process.setThreadPriority(0);
        this.f634a.run();
    }
}
