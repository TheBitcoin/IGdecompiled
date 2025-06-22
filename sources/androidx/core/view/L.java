package androidx.core.view;

import d3.a;

public final /* synthetic */ class L implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f913a;

    public /* synthetic */ L(a aVar) {
        this.f913a = aVar;
    }

    public final void run() {
        ViewKt.postOnAnimationDelayed$lambda$1(this.f913a);
    }
}
