package androidx.browser.customtabs;

import android.os.IBinder;
import androidx.browser.customtabs.CustomTabsService;

public final /* synthetic */ class a implements IBinder.DeathRecipient {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CustomTabsService.AnonymousClass1 f806a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CustomTabsSessionToken f807b;

    public /* synthetic */ a(CustomTabsService.AnonymousClass1 r12, CustomTabsSessionToken customTabsSessionToken) {
        this.f806a = r12;
        this.f807b = customTabsSessionToken;
    }

    public final void binderDied() {
        CustomTabsService.this.cleanUpSession(this.f807b);
    }
}
