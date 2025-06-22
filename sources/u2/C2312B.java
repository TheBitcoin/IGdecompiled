package u2;

import N1.k;
import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Build;
import com.uptodown.UptodownApp;
import com.uptodown.activities.C1826a;
import com.uptodown.activities.MainActivity;
import kotlin.jvm.internal.m;

/* renamed from: u2.B  reason: case insensitive filesystem */
public final class C2312B {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f21879a;

    /* renamed from: b  reason: collision with root package name */
    private final a f21880b = new a(this);

    /* renamed from: u2.B$a */
    public static final class a extends ConnectivityManager.NetworkCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2312B f21881a;

        a(C2312B b5) {
            this.f21881a = b5;
        }

        public void onAvailable(Network network) {
            m.e(network, "network");
            z zVar = z.f21956a;
            if (!zVar.d()) {
                zVar.h(true);
                Activity g4 = k.f7778g.g();
                if (g4 != null) {
                    UptodownApp.f17422D.e(this.f21881a.f21879a);
                    if (g4 instanceof C1826a) {
                        ((C1826a) g4).u2();
                    }
                    if (g4 instanceof MainActivity) {
                        MainActivity mainActivity = (MainActivity) g4;
                        if (mainActivity.a6()) {
                            mainActivity.runOnUiThread(new MainActivity.C1819c());
                        }
                    }
                }
            }
        }

        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            m.e(network, "network");
            m.e(networkCapabilities, "networkCapabilities");
            super.onCapabilitiesChanged(network, networkCapabilities);
            boolean hasTransport = networkCapabilities.hasTransport(1);
            z zVar = z.f21956a;
            boolean f4 = zVar.f();
            int linkDownstreamBandwidthKbps = networkCapabilities.getLinkDownstreamBandwidthKbps();
            int a5 = zVar.a();
            int b5 = zVar.b();
            zVar.j(hasTransport);
            zVar.g(networkCapabilities.getLinkDownstreamBandwidthKbps());
            zVar.i(networkCapabilities.getLinkUpstreamBandwidthKbps());
            if (a5 == 0 || b5 == 0) {
                UptodownApp.f17422D.e(this.f21881a.f21879a);
            } else if (f4 != hasTransport) {
                UptodownApp.a aVar = UptodownApp.f17422D;
                aVar.e(this.f21881a.f21879a);
                if (zVar.f()) {
                    UptodownApp.a.P0(aVar, this.f21881a.f21879a, false, 2, (Object) null);
                }
            } else {
                boolean b6 = this.f21881a.b(a5, linkDownstreamBandwidthKbps);
                if (!zVar.f() && b6) {
                    UptodownApp.f17422D.e(this.f21881a.f21879a);
                }
            }
        }

        public void onLost(Network network) {
            m.e(network, "network");
            z zVar = z.f21956a;
            zVar.h(false);
            zVar.j(false);
        }
    }

    public C2312B(Context context) {
        m.e(context, "context");
        this.f21879a = context;
    }

    public final boolean b(int i4, int i5) {
        if (4300 < i5) {
            if (i4 < 4300) {
                return true;
            }
            return false;
        } else if (i4 > 4300) {
            return true;
        } else {
            return false;
        }
    }

    public final void c() {
        Object systemService = this.f21879a.getSystemService("connectivity");
        m.c(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        NetworkRequest.Builder builder = new NetworkRequest.Builder();
        if (Build.VERSION.SDK_INT >= 24) {
            connectivityManager.registerDefaultNetworkCallback(this.f21880b);
        } else {
            connectivityManager.registerNetworkCallback(builder.build(), this.f21880b);
        }
    }

    public final void d() {
        Object systemService = this.f21879a.getSystemService("connectivity");
        m.c(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ((ConnectivityManager) systemService).unregisterNetworkCallback(new ConnectivityManager.NetworkCallback());
    }
}
