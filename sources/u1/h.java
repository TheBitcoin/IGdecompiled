package U1;

import N1.k;
import android.content.Context;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public final class h {

    /* renamed from: h  reason: collision with root package name */
    public static final a f8425h = new a((C2103g) null);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final i f8426a;

    /* renamed from: b  reason: collision with root package name */
    private final NsdManager f8427b;

    /* renamed from: c  reason: collision with root package name */
    private NsdManager.ResolveListener f8428c;

    /* renamed from: d  reason: collision with root package name */
    private NsdManager.ServiceInfoCallback f8429d;

    /* renamed from: e  reason: collision with root package name */
    private NsdManager.DiscoveryListener f8430e;

    /* renamed from: f  reason: collision with root package name */
    private NsdServiceInfo f8431f;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList f8432g = new ArrayList();

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        public final String a(String str, String str2, int i4) {
            m.e(str, "manufacturer");
            m.e(str2, "model");
            String str3 = str + ' ' + str2;
            if (str3.length() <= i4) {
                return str3;
            }
            String substring = str3.substring(0, i4 - 1);
            m.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }

        public final String b(String str) {
            m.e(str, "deviceId");
            if (str.length() > 16) {
                str = str.substring(0, 15);
                m.d(str, "this as java.lang.String…ing(startIndex, endIndex)");
            }
            String d5 = d();
            int length = (52 - str.length()) - d5.length();
            String str2 = Build.MANUFACTURER;
            m.d(str2, "MANUFACTURER");
            String str3 = Build.MODEL;
            m.d(str3, "MODEL");
            String a5 = a(str2, str3, length);
            return a5 + "_d:_" + str + "_:d__t:_" + d5;
        }

        public final String c(String str) {
            m.e(str, "serviceName");
            String str2 = str;
            String substring = str2.substring(0, m3.m.L(str2, "_d:_", 0, false, 6, (Object) null));
            m.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }

        public final String d() {
            return "0";
        }

        private a() {
        }
    }

    public static final class b implements NsdManager.DiscoveryListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f8433a;

        b(h hVar) {
            this.f8433a = hVar;
        }

        public void onDiscoveryStarted(String str) {
            m.e(str, "regType");
            this.f8433a.f8426a.s();
        }

        public void onDiscoveryStopped(String str) {
            m.e(str, "serviceType");
            this.f8433a.f8426a.g();
        }

        public void onServiceFound(NsdServiceInfo nsdServiceInfo) {
            m.e(nsdServiceInfo, NotificationCompat.CATEGORY_SERVICE);
            if (this.f8433a.l(nsdServiceInfo)) {
                this.f8433a.g().add(nsdServiceInfo);
            }
        }

        public void onServiceLost(NsdServiceInfo nsdServiceInfo) {
            m.e(nsdServiceInfo, NotificationCompat.CATEGORY_SERVICE);
            if (this.f8433a.g().size() > 0) {
                ArrayList g4 = this.f8433a.g();
                int size = g4.size();
                int i4 = 0;
                int i5 = 0;
                while (i5 < size) {
                    Object obj = g4.get(i5);
                    i5++;
                    if (m.a(((NsdServiceInfo) obj).getServiceName(), nsdServiceInfo.getServiceName())) {
                        break;
                    }
                    i4++;
                }
                if (i4 < this.f8433a.g().size()) {
                    this.f8433a.g().remove(i4);
                }
            }
        }

        public void onStartDiscoveryFailed(String str, int i4) {
            m.e(str, "serviceType");
        }

        public void onStopDiscoveryFailed(String str, int i4) {
            m.e(str, "serviceType");
        }
    }

    public static final class d implements NsdManager.ResolveListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f8435a;

        d(h hVar) {
            this.f8435a = hVar;
        }

        public void onResolveFailed(NsdServiceInfo nsdServiceInfo, int i4) {
            m.e(nsdServiceInfo, "serviceInfo");
        }

        public void onServiceResolved(NsdServiceInfo nsdServiceInfo) {
            m.e(nsdServiceInfo, "serviceInfo");
            this.f8435a.o(nsdServiceInfo);
        }
    }

    public h(Context context, i iVar) {
        m.e(context, "context");
        m.e(iVar, "nsdListener");
        this.f8426a = iVar;
        Object systemService = context.getSystemService("servicediscovery");
        m.c(systemService, "null cannot be cast to non-null type android.net.nsd.NsdManager");
        this.f8427b = (NsdManager) systemService;
    }

    private final void h() {
        if (Build.VERSION.SDK_INT >= 34) {
            if (this.f8429d == null) {
                this.f8429d = g.a(new c(this));
            }
        } else if (this.f8428c == null) {
            this.f8428c = new d(this);
        }
    }

    /* access modifiers changed from: private */
    public final boolean l(NsdServiceInfo nsdServiceInfo) {
        String serviceName = nsdServiceInfo.getServiceName();
        if (!m.a(nsdServiceInfo.getServiceType(), "_nsduptodown._tcp.") || serviceName == null || serviceName.length() == 0 || m3.m.p(serviceName, k.f7778g.p(), true)) {
            return false;
        }
        return true;
    }

    private final void n() {
        NsdManager.ServiceInfoCallback serviceInfoCallback;
        if (Build.VERSION.SDK_INT >= 34 && (serviceInfoCallback = this.f8429d) != null) {
            try {
                NsdManager nsdManager = this.f8427b;
                m.b(serviceInfoCallback);
                nsdManager.unregisterServiceInfoCallback(serviceInfoCallback);
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    public final void o(NsdServiceInfo nsdServiceInfo) {
        if (!m.a(nsdServiceInfo.getServiceName(), k.f7778g.p())) {
            this.f8431f = nsdServiceInfo;
            this.f8426a.a();
        }
    }

    public final void d() {
        if (this.f8430e == null) {
            b bVar = new b(this);
            this.f8430e = bVar;
            try {
                this.f8427b.discoverServices("_nsduptodown._tcp.", 1, bVar);
            } catch (IllegalArgumentException e5) {
                e5.printStackTrace();
                this.f8426a.e();
            }
        }
    }

    public final NsdServiceInfo e() {
        return this.f8431f;
    }

    public final NsdManager f() {
        return this.f8427b;
    }

    public final ArrayList g() {
        return this.f8432g;
    }

    public final void i(int i4, NsdManager.RegistrationListener registrationListener) {
        m.e(registrationListener, "mRegistrationListener");
        NsdServiceInfo nsdServiceInfo = new NsdServiceInfo();
        nsdServiceInfo.setPort(i4);
        nsdServiceInfo.setServiceName(k.f7778g.p());
        nsdServiceInfo.setServiceType("_nsduptodown._tcp.");
        try {
            this.f8427b.registerService(nsdServiceInfo, 1, registrationListener);
        } catch (Exception unused) {
            this.f8426a.i();
        }
    }

    public final void j() {
        m();
        n();
        this.f8432g.clear();
        this.f8431f = null;
    }

    public final void k(NsdServiceInfo nsdServiceInfo) {
        NsdManager.ServiceInfoCallback serviceInfoCallback;
        m.e(nsdServiceInfo, NotificationCompat.CATEGORY_SERVICE);
        h();
        if (Build.VERSION.SDK_INT >= 34) {
            ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
            if (newSingleThreadScheduledExecutor != null && (serviceInfoCallback = this.f8429d) != null) {
                NsdManager nsdManager = this.f8427b;
                m.b(serviceInfoCallback);
                nsdManager.registerServiceInfoCallback(nsdServiceInfo, newSingleThreadScheduledExecutor, serviceInfoCallback);
                return;
            }
            return;
        }
        this.f8427b.resolveService(nsdServiceInfo, this.f8428c);
    }

    public final void m() {
        NsdManager.DiscoveryListener discoveryListener = this.f8430e;
        if (discoveryListener != null) {
            try {
                this.f8427b.stopServiceDiscovery(discoveryListener);
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            this.f8430e = null;
        }
    }

    public static final class c implements NsdManager.ServiceInfoCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f8434a;

        c(h hVar) {
            this.f8434a = hVar;
        }

        public void onServiceUpdated(NsdServiceInfo nsdServiceInfo) {
            m.e(nsdServiceInfo, "serviceInfo");
            this.f8434a.o(nsdServiceInfo);
        }

        public void onServiceInfoCallbackUnregistered() {
        }

        public void onServiceLost() {
        }

        public void onServiceInfoCallbackRegistrationFailed(int i4) {
        }
    }
}
