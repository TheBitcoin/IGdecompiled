package L3;

import E3.c;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* renamed from: L3.d  reason: case insensitive filesystem */
class C2497d extends C2499f {

    /* renamed from: c  reason: collision with root package name */
    private final Method f23620c;

    /* renamed from: d  reason: collision with root package name */
    private final Method f23621d;

    /* renamed from: e  reason: collision with root package name */
    private final Method f23622e;

    /* renamed from: f  reason: collision with root package name */
    private final Class f23623f;

    /* renamed from: g  reason: collision with root package name */
    private final Class f23624g;

    /* renamed from: L3.d$a */
    private static class a implements InvocationHandler {

        /* renamed from: a  reason: collision with root package name */
        private final List f23625a;

        /* renamed from: b  reason: collision with root package name */
        boolean f23626b;

        /* renamed from: c  reason: collision with root package name */
        String f23627c;

        a(List list) {
            this.f23625a = list;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = c.f23243b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.TRUE;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f23626b = true;
                return null;
            } else if (name.equals("protocols") && objArr.length == 0) {
                return this.f23625a;
            } else {
                if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1) {
                    Object obj2 = objArr[0];
                    if (obj2 instanceof List) {
                        List list = (List) obj2;
                        int size = list.size();
                        for (int i4 = 0; i4 < size; i4++) {
                            if (this.f23625a.contains(list.get(i4))) {
                                String str = (String) list.get(i4);
                                this.f23627c = str;
                                return str;
                            }
                        }
                        String str2 = (String) this.f23625a.get(0);
                        this.f23627c = str2;
                        return str2;
                    }
                }
                if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                    return method.invoke(this, objArr);
                }
                this.f23627c = (String) objArr[0];
                return null;
            }
        }
    }

    C2497d(Method method, Method method2, Method method3, Class cls, Class cls2) {
        this.f23620c = method;
        this.f23621d = method2;
        this.f23622e = method3;
        this.f23623f = cls;
        this.f23624g = cls2;
    }

    public static C2499f r() {
        Class<SSLSocket> cls = SSLSocket.class;
        try {
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN");
            Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$Provider");
            Class<?> cls4 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ClientProvider");
            Class<?> cls5 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ServerProvider");
            return new C2497d(cls2.getMethod("put", new Class[]{cls, cls3}), cls2.getMethod("get", new Class[]{cls}), cls2.getMethod("remove", new Class[]{cls}), cls4, cls5);
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }

    public void a(SSLSocket sSLSocket) {
        try {
            this.f23622e.invoke((Object) null, new Object[]{sSLSocket});
        } catch (IllegalAccessException | InvocationTargetException e5) {
            throw c.a("unable to remove alpn", e5);
        }
    }

    public void f(SSLSocket sSLSocket, String str, List list) {
        List b5 = C2499f.b(list);
        try {
            Object newProxyInstance = Proxy.newProxyInstance(C2499f.class.getClassLoader(), new Class[]{this.f23623f, this.f23624g}, new a(b5));
            this.f23620c.invoke((Object) null, new Object[]{sSLSocket, newProxyInstance});
        } catch (IllegalAccessException | InvocationTargetException e5) {
            throw c.a("unable to set alpn", e5);
        }
    }

    public String l(SSLSocket sSLSocket) {
        try {
            a aVar = (a) Proxy.getInvocationHandler(this.f23621d.invoke((Object) null, new Object[]{sSLSocket}));
            boolean z4 = aVar.f23626b;
            if (!z4 && aVar.f23627c == null) {
                C2499f.i().p(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
                return null;
            } else if (z4) {
                return null;
            } else {
                return aVar.f23627c;
            }
        } catch (InvocationTargetException e5) {
            e = e5;
            throw c.a("unable to get selected protocol", e);
        } catch (IllegalAccessException e6) {
            e = e6;
            throw c.a("unable to get selected protocol", e);
        }
    }
}
