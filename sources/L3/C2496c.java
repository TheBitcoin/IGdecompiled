package L3;

import E3.c;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* renamed from: L3.c  reason: case insensitive filesystem */
final class C2496c extends C2499f {

    /* renamed from: c  reason: collision with root package name */
    final Method f23618c;

    /* renamed from: d  reason: collision with root package name */
    final Method f23619d;

    C2496c(Method method, Method method2) {
        this.f23618c = method;
        this.f23619d = method2;
    }

    public static C2496c r() {
        try {
            return new C2496c(SSLParameters.class.getMethod("setApplicationProtocols", new Class[]{String[].class}), SSLSocket.class.getMethod("getApplicationProtocol", (Class[]) null));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public void f(SSLSocket sSLSocket, String str, List list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List b5 = C2499f.b(list);
            this.f23618c.invoke(sSLParameters, new Object[]{b5.toArray(new String[b5.size()])});
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e5) {
            throw c.a("unable to set ssl parameters", e5);
        }
    }

    public String l(SSLSocket sSLSocket) {
        try {
            String str = (String) this.f23619d.invoke(sSLSocket, (Object[]) null);
            if (str == null || str.equals("")) {
                return null;
            }
            return str;
        } catch (IllegalAccessException | InvocationTargetException e5) {
            throw c.a("unable to get selected protocols", e5);
        }
    }
}
