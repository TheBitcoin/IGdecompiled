package androidx.browser.customtabs;

import android.os.Bundle;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EngagementSignalsCallback f811a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f812b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Bundle f813c;

    public /* synthetic */ c(EngagementSignalsCallback engagementSignalsCallback, int i4, Bundle bundle) {
        this.f811a = engagementSignalsCallback;
        this.f812b = i4;
        this.f813c = bundle;
    }

    public final void run() {
        this.f811a.onGreatestScrollPercentageIncreased(this.f812b, this.f813c);
    }
}
