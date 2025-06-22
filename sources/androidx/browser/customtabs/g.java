package androidx.browser.customtabs;

import android.os.Bundle;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EngagementSignalsCallback f823a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f824b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Bundle f825c;

    public /* synthetic */ g(EngagementSignalsCallback engagementSignalsCallback, boolean z4, Bundle bundle) {
        this.f823a = engagementSignalsCallback;
        this.f824b = z4;
        this.f825c = bundle;
    }

    public final void run() {
        this.f823a.onSessionEnded(this.f824b, this.f825c);
    }
}
