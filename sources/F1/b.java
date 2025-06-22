package F1;

import R2.m;
import R2.s;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final Context f6449a;

    /* renamed from: b  reason: collision with root package name */
    private final List f6450b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private a f6451c;

    /* renamed from: d  reason: collision with root package name */
    private ConnectivityManager.NetworkCallback f6452d;

    public interface a {
        void a();

        void b();
    }

    /* renamed from: F1.b$b  reason: collision with other inner class name */
    public static final class C0082b extends ConnectivityManager.NetworkCallback {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f6453a = new Handler(Looper.getMainLooper());

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f6454b;

        C0082b(b bVar) {
            this.f6454b = bVar;
        }

        /* access modifiers changed from: private */
        public static final void c(b bVar) {
            m.e(bVar, "this$0");
            for (a a5 : bVar.d()) {
                a5.a();
            }
        }

        /* access modifiers changed from: private */
        public static final void d(b bVar) {
            m.e(bVar, "this$0");
            for (a b5 : bVar.d()) {
                b5.b();
            }
        }

        public void onAvailable(Network network) {
            m.e(network, "network");
            this.f6453a.post(new c(this.f6454b));
        }

        public void onLost(Network network) {
            m.e(network, "network");
            this.f6453a.post(new d(this.f6454b));
        }
    }

    static final class c extends n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f6455a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(b bVar) {
            super(0);
            this.f6455a = bVar;
        }

        public final void invoke() {
            for (a a5 : this.f6455a.d()) {
                a5.a();
            }
        }
    }

    static final class d extends n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f6456a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(b bVar) {
            super(0);
            this.f6456a = bVar;
        }

        public final void invoke() {
            for (a b5 : this.f6456a.d()) {
                b5.b();
            }
        }
    }

    public b(Context context) {
        m.e(context, "context");
        this.f6449a = context;
    }

    private final void b(Context context) {
        C0082b bVar = new C0082b(this);
        this.f6452d = bVar;
        Object systemService = context.getSystemService("connectivity");
        m.c(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ((ConnectivityManager) systemService).registerDefaultNetworkCallback(bVar);
    }

    private final void c(Context context) {
        a aVar = new a(new c(this), new d(this));
        this.f6451c = aVar;
        context.registerReceiver(aVar, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public final void a() {
        if (Build.VERSION.SDK_INT >= 24) {
            ConnectivityManager.NetworkCallback networkCallback = this.f6452d;
            if (networkCallback != null) {
                Object systemService = this.f6449a.getSystemService("connectivity");
                m.c(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
                ((ConnectivityManager) systemService).unregisterNetworkCallback(networkCallback);
            } else {
                return;
            }
        } else {
            a aVar = this.f6451c;
            if (aVar != null) {
                try {
                    m.a aVar2 = R2.m.f8216a;
                    this.f6449a.unregisterReceiver(aVar);
                    R2.m.a(s.f8222a);
                } catch (Throwable th) {
                    m.a aVar3 = R2.m.f8216a;
                    R2.m.a(R2.n.a(th));
                }
            } else {
                return;
            }
        }
        this.f6450b.clear();
        this.f6452d = null;
        this.f6451c = null;
    }

    public final List d() {
        return this.f6450b;
    }

    public final void e() {
        if (Build.VERSION.SDK_INT >= 24) {
            b(this.f6449a);
        } else {
            c(this.f6449a);
        }
    }
}
