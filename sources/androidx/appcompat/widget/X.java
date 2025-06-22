package androidx.appcompat.widget;

public final /* synthetic */ class X implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TooltipCompatHandler f805a;

    public /* synthetic */ X(TooltipCompatHandler tooltipCompatHandler) {
        this.f805a = tooltipCompatHandler;
    }

    public final void run() {
        this.f805a.hide();
    }
}
