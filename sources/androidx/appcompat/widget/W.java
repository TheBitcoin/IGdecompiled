package androidx.appcompat.widget;

public final /* synthetic */ class W implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TooltipCompatHandler f804a;

    public /* synthetic */ W(TooltipCompatHandler tooltipCompatHandler) {
        this.f804a = tooltipCompatHandler;
    }

    public final void run() {
        this.f804a.show(false);
    }
}
