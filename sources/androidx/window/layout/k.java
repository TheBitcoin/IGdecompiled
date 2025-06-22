package androidx.window.layout;

import androidx.core.util.Consumer;
import q3.d;

public final /* synthetic */ class k implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f1041a;

    public /* synthetic */ k(d dVar) {
        this.f1041a = dVar;
    }

    public final void accept(Object obj) {
        WindowInfoTrackerImpl$windowLayoutInfo$1.m12invokeSuspend$lambda0(this.f1041a, (WindowLayoutInfo) obj);
    }
}
