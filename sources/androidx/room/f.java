package androidx.room;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MultiInstanceInvalidationClient f988a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String[] f989b;

    public /* synthetic */ f(MultiInstanceInvalidationClient multiInstanceInvalidationClient, String[] strArr) {
        this.f988a = multiInstanceInvalidationClient;
        this.f989b = strArr;
    }

    public final void run() {
        MultiInstanceInvalidationClient$callback$1.onInvalidation$lambda$0(this.f988a, this.f989b);
    }
}
