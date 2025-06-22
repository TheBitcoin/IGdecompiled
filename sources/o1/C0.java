package O1;

import android.net.nsd.NsdServiceInfo;

public final /* synthetic */ class C0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ M0 f7821a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NsdServiceInfo f7822b;

    public /* synthetic */ C0(M0 m02, NsdServiceInfo nsdServiceInfo) {
        this.f7821a = m02;
        this.f7822b = nsdServiceInfo;
    }

    public final void run() {
        M0.c1(this.f7821a, this.f7822b);
    }
}
