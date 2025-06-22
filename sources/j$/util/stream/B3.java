package j$.util.stream;

public final class B3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Runnable f5259a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f5260b;

    public B3(Runnable runnable, Runnable runnable2) {
        this.f5259a = runnable;
        this.f5260b = runnable2;
    }

    public final void run() {
        Runnable runnable = this.f5260b;
        try {
            this.f5259a.run();
            runnable.run();
            return;
        } catch (Throwable th) {
            try {
                th.addSuppressed(th);
            } catch (Throwable unused) {
            }
        }
        throw th;
    }
}
