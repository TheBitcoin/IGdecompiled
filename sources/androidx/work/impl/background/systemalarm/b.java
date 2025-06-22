package androidx.work.impl.background.systemalarm;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DelayMetCommandHandler f1052a;

    public /* synthetic */ b(DelayMetCommandHandler delayMetCommandHandler) {
        this.f1052a = delayMetCommandHandler;
    }

    public final void run() {
        this.f1052a.startWork();
    }
}
