package J1;

import c2.C1692u;
import com.uptodown.activities.UserDeviceDetailsActivity;
import g2.V;

/* renamed from: J1.v5  reason: case insensitive filesystem */
public final /* synthetic */ class C1463v5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ V f7177a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C1692u f7178b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ UserDeviceDetailsActivity f7179c;

    public /* synthetic */ C1463v5(V v4, C1692u uVar, UserDeviceDetailsActivity userDeviceDetailsActivity) {
        this.f7177a = v4;
        this.f7178b = uVar;
        this.f7179c = userDeviceDetailsActivity;
    }

    public final void run() {
        UserDeviceDetailsActivity.t3(this.f7177a, this.f7178b, this.f7179c);
    }
}
