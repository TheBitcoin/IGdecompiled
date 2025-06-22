package androidx.lifecycle;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DispatchQueue f956a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f957b;

    public /* synthetic */ d(DispatchQueue dispatchQueue, Runnable runnable) {
        this.f956a = dispatchQueue;
        this.f957b = runnable;
    }

    public final void run() {
        DispatchQueue.dispatchAndEnqueue$lambda$2$lambda$1(this.f956a, this.f957b);
    }
}
