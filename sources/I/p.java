package I;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public final /* synthetic */ class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0295b f268a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Intent f269b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f270c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f271d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BroadcastReceiver.PendingResult f272e;

    public /* synthetic */ p(C0295b bVar, Intent intent, Context context, boolean z4, BroadcastReceiver.PendingResult pendingResult) {
        this.f268a = bVar;
        this.f269b = intent;
        this.f270c = context;
        this.f271d = z4;
        this.f272e = pendingResult;
    }

    public final void run() {
        this.f268a.d(this.f269b, this.f270c, this.f271d, this.f272e);
    }
}
