package androidx.appcompat.widget;

public final /* synthetic */ class S implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Toolbar f802a;

    public /* synthetic */ S(Toolbar toolbar) {
        this.f802a = toolbar;
    }

    public final void run() {
        this.f802a.invalidateMenu();
    }
}
