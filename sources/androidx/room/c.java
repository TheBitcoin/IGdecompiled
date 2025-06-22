package androidx.room;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InvalidationTracker f985a;

    public /* synthetic */ c(InvalidationTracker invalidationTracker) {
        this.f985a = invalidationTracker;
    }

    public final void run() {
        this.f985a.onAutoCloseCallback$room_runtime_release();
    }
}
