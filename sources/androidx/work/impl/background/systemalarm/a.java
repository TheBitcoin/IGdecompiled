package androidx.work.impl.background.systemalarm;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DelayMetCommandHandler f1051a;

    public /* synthetic */ a(DelayMetCommandHandler delayMetCommandHandler) {
        this.f1051a = delayMetCommandHandler;
    }

    public final void run() {
        this.f1051a.stopWork();
    }
}
