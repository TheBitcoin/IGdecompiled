package androidx.room;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MultiInstanceInvalidationClient f986a;

    public /* synthetic */ d(MultiInstanceInvalidationClient multiInstanceInvalidationClient) {
        this.f986a = multiInstanceInvalidationClient;
    }

    public final void run() {
        MultiInstanceInvalidationClient.setUpRunnable$lambda$1(this.f986a);
    }
}
