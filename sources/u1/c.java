package U1;

import N1.k;
import T1.e;
import android.content.Context;
import android.net.nsd.NsdServiceInfo;
import android.os.Build;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Iterator;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public final class c {

    /* renamed from: g  reason: collision with root package name */
    public static final a f8407g = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private final i f8408a;

    /* renamed from: b  reason: collision with root package name */
    private final d f8409b;

    /* renamed from: c  reason: collision with root package name */
    private final a f8410c;

    /* renamed from: d  reason: collision with root package name */
    private Socket f8411d;

    /* renamed from: e  reason: collision with root package name */
    private Socket f8412e;

    /* renamed from: f  reason: collision with root package name */
    private e f8413f;

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    public c(i iVar, Context context) {
        m.e(iVar, "nsdListener");
        m.e(context, "context");
        this.f8408a = iVar;
        this.f8409b = new d(context, iVar, this);
        this.f8410c = new a(iVar, this);
    }

    private final void a() {
        try {
            Socket socket = this.f8411d;
            if (socket != null) {
                socket.close();
            }
            this.f8411d = null;
        } catch (IOException e5) {
            e5.printStackTrace();
        }
    }

    private final void b() {
        try {
            Socket socket = this.f8412e;
            if (socket != null) {
                socket.close();
            }
            this.f8412e = null;
        } catch (IOException e5) {
            e5.printStackTrace();
        }
    }

    private final void d(NsdServiceInfo nsdServiceInfo) {
        try {
            InetAddress host = nsdServiceInfo.getHost();
            if (Build.VERSION.SDK_INT >= 34) {
                Iterator it = nsdServiceInfo.getHostAddresses().iterator();
                while (true) {
                    if (it.hasNext()) {
                        InetAddress inetAddress = (InetAddress) it.next();
                        if (inetAddress != null) {
                            host = inetAddress;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            m(new Socket(host, nsdServiceInfo.getPort()));
            this.f8408a.z(nsdServiceInfo);
        } catch (ConnectException unused) {
            this.f8408a.c();
        } catch (IOException unused2) {
            this.f8408a.c();
        }
    }

    private final synchronized void n(Socket socket) {
        Socket socket2 = this.f8412e;
        if (socket2 != null && socket2.isConnected()) {
            try {
                Socket socket3 = this.f8412e;
                if (socket3 != null) {
                    socket3.close();
                }
            } catch (IOException e5) {
                e5.printStackTrace();
            }
        }
        this.f8412e = socket;
    }

    public final void c() {
        NsdServiceInfo nsdServiceInfo;
        h o4 = k.f7778g.o();
        if (o4 != null) {
            nsdServiceInfo = o4.e();
        } else {
            nsdServiceInfo = null;
        }
        if (nsdServiceInfo != null) {
            d(nsdServiceInfo);
        }
    }

    public final e e() {
        return this.f8413f;
    }

    public final Socket f() {
        return this.f8411d;
    }

    public final Socket g() {
        return this.f8412e;
    }

    public final a h() {
        return this.f8410c;
    }

    public final d i() {
        return this.f8409b;
    }

    public final boolean j() {
        Socket socket = this.f8411d;
        if (socket == null) {
            return false;
        }
        m.b(socket);
        if (!socket.isClosed()) {
            return true;
        }
        return false;
    }

    public final boolean k() {
        Socket socket = this.f8412e;
        if (socket == null) {
            return false;
        }
        m.b(socket);
        if (!socket.isClosed()) {
            return true;
        }
        return false;
    }

    public final void l(e eVar) {
        this.f8413f = eVar;
    }

    public final synchronized void m(Socket socket) {
        try {
            m.e(socket, "socket");
            Socket socket2 = this.f8411d;
            if (socket2 != null) {
                m.b(socket2);
                if (socket2.isConnected()) {
                    n(socket);
                }
            }
            this.f8411d = socket;
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    public final void o(boolean z4) {
        Socket socket = this.f8411d;
        if (socket != null) {
            m.b(socket);
            if (!socket.isClosed()) {
                this.f8410c.g(z4);
                return;
            }
        }
        this.f8408a.p("Socket to write OK is null or closed");
    }

    public final void p() {
        Socket socket = this.f8411d;
        if (socket != null) {
            m.b(socket);
            if (!socket.isClosed()) {
                this.f8410c.h(k.f7778g.p());
                return;
            }
        }
        this.f8408a.p("Socket to write ServiceName is null or closed");
    }

    public final void q(e eVar) {
        m.e(eVar, "fti");
        Socket socket = this.f8411d;
        if (socket != null) {
            m.b(socket);
            if (!socket.isClosed()) {
                this.f8410c.i(eVar);
                return;
            }
        }
        this.f8408a.p("Socket to write FTI is null or closed");
    }

    public final void r() {
        this.f8409b.p();
        b();
        a();
    }
}
