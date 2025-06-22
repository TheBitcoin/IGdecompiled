package androidx.browser.customtabs;

import android.os.Bundle;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EngagementSignalsCallback f808a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f809b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Bundle f810c;

    public /* synthetic */ b(EngagementSignalsCallback engagementSignalsCallback, boolean z4, Bundle bundle) {
        this.f808a = engagementSignalsCallback;
        this.f809b = z4;
        this.f810c = bundle;
    }

    public final void run() {
        this.f808a.onSessionEnded(this.f809b, this.f810c);
    }
}
