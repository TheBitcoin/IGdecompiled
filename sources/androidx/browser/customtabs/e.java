package androidx.browser.customtabs;

import android.os.Bundle;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EngagementSignalsCallback f817a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f818b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Bundle f819c;

    public /* synthetic */ e(EngagementSignalsCallback engagementSignalsCallback, boolean z4, Bundle bundle) {
        this.f817a = engagementSignalsCallback;
        this.f818b = z4;
        this.f819c = bundle;
    }

    public final void run() {
        this.f817a.onVerticalScrollEvent(this.f818b, this.f819c);
    }
}
