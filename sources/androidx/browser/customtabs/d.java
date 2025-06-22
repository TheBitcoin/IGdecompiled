package androidx.browser.customtabs;

import android.os.Bundle;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EngagementSignalsCallback f814a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f815b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Bundle f816c;

    public /* synthetic */ d(EngagementSignalsCallback engagementSignalsCallback, boolean z4, Bundle bundle) {
        this.f814a = engagementSignalsCallback;
        this.f815b = z4;
        this.f816c = bundle;
    }

    public final void run() {
        this.f814a.onVerticalScrollEvent(this.f815b, this.f816c);
    }
}
