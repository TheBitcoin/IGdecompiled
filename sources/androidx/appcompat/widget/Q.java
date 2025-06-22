package androidx.appcompat.widget;

public final /* synthetic */ class Q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Toolbar f801a;

    public /* synthetic */ Q(Toolbar toolbar) {
        this.f801a = toolbar;
    }

    public final void run() {
        this.f801a.collapseActionView();
    }
}
