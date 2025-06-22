package R3;

import android.content.BroadcastReceiver;
import android.content.Context;
import org.matomo.sdk.extra.InstallReferrerReceiver;

/* renamed from: R3.e  reason: case insensitive filesystem */
public final /* synthetic */ class C2566e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f23925a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f23926b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ BroadcastReceiver.PendingResult f23927c;

    public /* synthetic */ C2566e(Context context, String str, BroadcastReceiver.PendingResult pendingResult) {
        this.f23925a = context;
        this.f23926b = str;
        this.f23927c = pendingResult;
    }

    public final void run() {
        InstallReferrerReceiver.a(this.f23925a, this.f23926b, this.f23927c);
    }
}
