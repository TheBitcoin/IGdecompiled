package androidx.lifecycle;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProcessLifecycleOwner f963a;

    public /* synthetic */ l(ProcessLifecycleOwner processLifecycleOwner) {
        this.f963a = processLifecycleOwner;
    }

    public final void run() {
        ProcessLifecycleOwner.delayedPauseRunnable$lambda$0(this.f963a);
    }
}
