package androidx.core.widget;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ContentLoadingProgressBar f931a;

    public /* synthetic */ d(ContentLoadingProgressBar contentLoadingProgressBar) {
        this.f931a = contentLoadingProgressBar;
    }

    public final void run() {
        this.f931a.hideOnUiThread();
    }
}
