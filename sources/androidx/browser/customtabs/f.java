package androidx.browser.customtabs;

import android.os.Bundle;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EngagementSignalsCallback f820a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f821b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Bundle f822c;

    public /* synthetic */ f(EngagementSignalsCallback engagementSignalsCallback, int i4, Bundle bundle) {
        this.f820a = engagementSignalsCallback;
        this.f821b = i4;
        this.f822c = bundle;
    }

    public final void run() {
        this.f820a.onGreatestScrollPercentageIncreased(this.f821b, this.f822c);
    }
}
