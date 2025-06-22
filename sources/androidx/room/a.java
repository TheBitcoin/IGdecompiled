package androidx.room;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AutoCloser f983a;

    public /* synthetic */ a(AutoCloser autoCloser) {
        this.f983a = autoCloser;
    }

    public final void run() {
        AutoCloser.executeAutoCloser$lambda$0(this.f983a);
    }
}
