package L3;

import M3.C2502c;
import M3.C2504e;
import android.os.Build;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.Security;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* renamed from: L3.a  reason: case insensitive filesystem */
class C2494a extends C2499f {

    /* renamed from: c  reason: collision with root package name */
    private final Class f23605c;

    /* renamed from: d  reason: collision with root package name */
    private final C2498e f23606d;

    /* renamed from: e  reason: collision with root package name */
    private final C2498e f23607e;

    /* renamed from: f  reason: collision with root package name */
    private final C2498e f23608f;

    /* renamed from: g  reason: collision with root package name */
    private final C2498e f23609g;

    /* renamed from: h  reason: collision with root package name */
    private final c f23610h = c.b();

    /* renamed from: L3.a$a  reason: collision with other inner class name */
    static final class C0284a extends C2502c {

        /* renamed from: a  reason: collision with root package name */
        private final Object f23611a;

        /* renamed from: b  reason: collision with root package name */
        private final Method f23612b;

        C0284a(Object obj, Method method) {
            this.f23611a = obj;
            this.f23612b = method;
        }

        public List a(List list, String str) {
            try {
                return (List) this.f23612b.invoke(this.f23611a, new Object[]{(X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str});
            } catch (InvocationTargetException e5) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e5.getMessage());
                sSLPeerUnverifiedException.initCause(e5);
                throw sSLPeerUnverifiedException;
            } catch (IllegalAccessException e6) {
                throw new AssertionError(e6);
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof C0284a;
        }

        public int hashCode() {
            return 0;
        }
    }

    /* renamed from: L3.a$b */
    static final class b implements C2504e {

        /* renamed from: a  reason: collision with root package name */
        private final X509TrustManager f23613a;

        /* renamed from: b  reason: collision with root package name */
        private final Method f23614b;

        b(X509TrustManager x509TrustManager, Method method) {
            this.f23614b = method;
            this.f23613a = x509TrustManager;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (!this.f23613a.equals(bVar.f23613a) || !this.f23614b.equals(bVar.f23614b)) {
                return false;
            }
            return true;
        }

        public X509Certificate findByIssuerAndSignature(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.f23614b.invoke(this.f23613a, new Object[]{x509Certificate});
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
            } catch (IllegalAccessException e5) {
                throw E3.c.a("unable to get issues and signature", e5);
            } catch (InvocationTargetException unused) {
            }
            return null;
        }

        public int hashCode() {
            return this.f23613a.hashCode() + (this.f23614b.hashCode() * 31);
        }
    }

    /* renamed from: L3.a$c */
    static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final Method f23615a;

        /* renamed from: b  reason: collision with root package name */
        private final Method f23616b;

        /* renamed from: c  reason: collision with root package name */
        private final Method f23617c;

        c(Method method, Method method2, Method method3) {
            this.f23615a = method;
            this.f23616b = method2;
            this.f23617c = method3;
        }

        static c b() {
            Method method;
            Method method2;
            Method method3 = null;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                Method method4 = cls.getMethod("get", (Class[]) null);
                method = cls.getMethod("open", new Class[]{String.class});
                method2 = cls.getMethod("warnIfOpen", (Class[]) null);
                method3 = method4;
            } catch (Exception unused) {
                method2 = null;
                method = null;
            }
            return new c(method3, method, method2);
        }

        /* access modifiers changed from: package-private */
        public Object a(String str) {
            Method method = this.f23615a;
            if (method != null) {
                try {
                    Object invoke = method.invoke((Object) null, (Object[]) null);
                    this.f23616b.invoke(invoke, new Object[]{str});
                    return invoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public boolean c(Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                this.f23617c.invoke(obj, (Object[]) null);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    C2494a(Class cls, C2498e eVar, C2498e eVar2, C2498e eVar3, C2498e eVar4) {
        this.f23605c = cls;
        this.f23606d = eVar;
        this.f23607e = eVar2;
        this.f23608f = eVar3;
        this.f23609g = eVar4;
    }

    private boolean r(String str, Class cls, Object obj) {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", (Class[]) null).invoke(obj, (Object[]) null)).booleanValue();
        } catch (NoSuchMethodException unused) {
            return super.n(str);
        }
    }

    private boolean s(String str, Class cls, Object obj) {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[]{String.class}).invoke(obj, new Object[]{str})).booleanValue();
        } catch (NoSuchMethodException unused) {
            return r(str, cls, obj);
        }
    }

    public static C2499f t() {
        Class<?> cls;
        C2498e eVar;
        C2498e eVar2;
        Class<byte[]> cls2 = byte[].class;
        try {
            cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
        } catch (ClassNotFoundException unused) {
            try {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            } catch (ClassNotFoundException unused2) {
                return null;
            }
        }
        Class<?> cls3 = cls;
        C2498e eVar3 = new C2498e((Class) null, "setUseSessionTickets", Boolean.TYPE);
        C2498e eVar4 = new C2498e((Class) null, "setHostname", String.class);
        if (u()) {
            eVar2 = new C2498e(cls2, "getAlpnSelectedProtocol", new Class[0]);
            eVar = new C2498e((Class) null, "setAlpnProtocols", cls2);
        } else {
            eVar2 = null;
            eVar = null;
        }
        return new C2494a(cls3, eVar3, eVar4, eVar2, eVar);
    }

    private static boolean u() {
        if (Security.getProvider("GMSCore_OpenSSL") != null) {
            return true;
        }
        try {
            Class.forName("android.net.Network");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public C2502c c(X509TrustManager x509TrustManager) {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            Class<String> cls2 = String.class;
            return new C0284a(cls.getConstructor(new Class[]{X509TrustManager.class}).newInstance(new Object[]{x509TrustManager}), cls.getMethod("checkServerTrusted", new Class[]{X509Certificate[].class, cls2, cls2}));
        } catch (Exception unused) {
            return super.c(x509TrustManager);
        }
    }

    public C2504e d(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[]{X509Certificate.class});
            declaredMethod.setAccessible(true);
            return new b(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.d(x509TrustManager);
        }
    }

    public void f(SSLSocket sSLSocket, String str, List list) {
        if (str != null) {
            this.f23606d.e(sSLSocket, Boolean.TRUE);
            this.f23607e.e(sSLSocket, str);
        }
        C2498e eVar = this.f23609g;
        if (eVar != null && eVar.g(sSLSocket)) {
            this.f23609g.f(sSLSocket, C2499f.e(list));
        }
    }

    public void g(Socket socket, InetSocketAddress inetSocketAddress, int i4) {
        try {
            socket.connect(inetSocketAddress, i4);
        } catch (AssertionError e5) {
            if (E3.c.w(e5)) {
                throw new IOException(e5);
            }
            throw e5;
        } catch (SecurityException e6) {
            IOException iOException = new IOException("Exception in connect");
            iOException.initCause(e6);
            throw iOException;
        } catch (ClassCastException e7) {
            if (Build.VERSION.SDK_INT == 26) {
                IOException iOException2 = new IOException("Exception in connect");
                iOException2.initCause(e7);
                throw iOException2;
            }
            throw e7;
        }
    }

    public String l(SSLSocket sSLSocket) {
        byte[] bArr;
        C2498e eVar = this.f23608f;
        if (eVar == null || !eVar.g(sSLSocket) || (bArr = (byte[]) this.f23608f.f(sSLSocket, new Object[0])) == null) {
            return null;
        }
        return new String(bArr, E3.c.f23251j);
    }

    public Object m(String str) {
        return this.f23610h.a(str);
    }

    public boolean n(String str) {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return s(str, cls, cls.getMethod("getInstance", (Class[]) null).invoke((Object) null, (Object[]) null));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.n(str);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e5) {
            throw E3.c.a("unable to determine cleartext support", e5);
        }
    }

    public void p(int i4, String str, Throwable th) {
        int min;
        int i5 = 5;
        if (i4 != 5) {
            i5 = 3;
        }
        if (th != null) {
            str = str + 10 + Log.getStackTraceString(th);
        }
        int length = str.length();
        int i6 = 0;
        while (i6 < length) {
            int indexOf = str.indexOf(10, i6);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i6 + 4000);
                Log.println(i5, "OkHttp", str.substring(i6, min));
                if (min >= indexOf) {
                    break;
                }
                i6 = min;
            }
            i6 = min + 1;
        }
    }

    public void q(String str, Object obj) {
        if (!this.f23610h.c(obj)) {
            p(5, str, (Throwable) null);
        }
    }
}
