package androidx.core.widget;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ContentLoadingProgressBar f929a;

    public /* synthetic */ b(ContentLoadingProgressBar contentLoadingProgressBar) {
        this.f929a = contentLoadingProgressBar;
    }

    public final void run() {
        ContentLoadingProgressBar.c(this.f929a);
    }
}
