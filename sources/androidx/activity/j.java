package androidx.activity;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FullyDrawnReporter f781a;

    public /* synthetic */ j(FullyDrawnReporter fullyDrawnReporter) {
        this.f781a = fullyDrawnReporter;
    }

    public final void run() {
        FullyDrawnReporter.reportRunnable$lambda$2(this.f781a);
    }
}
