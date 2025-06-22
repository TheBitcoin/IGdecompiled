package F1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.m;

final class a extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private final d3.a f6447a;

    /* renamed from: b  reason: collision with root package name */
    private final d3.a f6448b;

    public a(d3.a aVar, d3.a aVar2) {
        m.e(aVar, "onNetworkAvailable");
        m.e(aVar2, "onNetworkUnavailable");
        this.f6447a = aVar;
        this.f6448b = aVar2;
    }

    public void onReceive(Context context, Intent intent) {
        m.e(context, "context");
        m.e(intent, "intent");
        if (e.b(context)) {
            this.f6447a.invoke();
        } else {
            this.f6448b.invoke();
        }
    }
}
