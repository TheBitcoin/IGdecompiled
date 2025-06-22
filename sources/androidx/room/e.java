package androidx.room;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MultiInstanceInvalidationClient f987a;

    public /* synthetic */ e(MultiInstanceInvalidationClient multiInstanceInvalidationClient) {
        this.f987a = multiInstanceInvalidationClient;
    }

    public final void run() {
        MultiInstanceInvalidationClient.removeObserverRunnable$lambda$2(this.f987a);
    }
}
