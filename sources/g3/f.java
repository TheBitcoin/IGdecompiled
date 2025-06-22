package G3;

import D3.C2451B;
import D3.C2453a;
import D3.C2457e;
import D3.C2467o;
import D3.C2470r;
import E3.c;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private final C2453a f23346a;

    /* renamed from: b  reason: collision with root package name */
    private final d f23347b;

    /* renamed from: c  reason: collision with root package name */
    private final C2457e f23348c;

    /* renamed from: d  reason: collision with root package name */
    private final C2467o f23349d;

    /* renamed from: e  reason: collision with root package name */
    private List f23350e;

    /* renamed from: f  reason: collision with root package name */
    private int f23351f;

    /* renamed from: g  reason: collision with root package name */
    private List f23352g;

    /* renamed from: h  reason: collision with root package name */
    private final List f23353h = new ArrayList();

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List f23354a;

        /* renamed from: b  reason: collision with root package name */
        private int f23355b = 0;

        a(List list) {
            this.f23354a = list;
        }

        public List a() {
            return new ArrayList(this.f23354a);
        }

        public boolean b() {
            if (this.f23355b < this.f23354a.size()) {
                return true;
            }
            return false;
        }

        public C2451B c() {
            if (b()) {
                List list = this.f23354a;
                int i4 = this.f23355b;
                this.f23355b = i4 + 1;
                return (C2451B) list.get(i4);
            }
            throw new NoSuchElementException();
        }
    }

    public f(C2453a aVar, d dVar, C2457e eVar, C2467o oVar) {
        List list = Collections.EMPTY_LIST;
        this.f23350e = list;
        this.f23352g = list;
        this.f23346a = aVar;
        this.f23347b = dVar;
        this.f23348c = eVar;
        this.f23349d = oVar;
        h(aVar.l(), aVar.g());
    }

    static String b(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }

    private boolean d() {
        if (this.f23351f < this.f23350e.size()) {
            return true;
        }
        return false;
    }

    private Proxy f() {
        if (d()) {
            List list = this.f23350e;
            int i4 = this.f23351f;
            this.f23351f = i4 + 1;
            Proxy proxy = (Proxy) list.get(i4);
            g(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f23346a.l().k() + "; exhausted proxy configurations: " + this.f23350e);
    }

    private void g(Proxy proxy) {
        String str;
        int i4;
        this.f23352g = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            str = this.f23346a.l().k();
            i4 = this.f23346a.l().w();
        } else {
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                str = b(inetSocketAddress);
                i4 = inetSocketAddress.getPort();
            } else {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
        }
        if (i4 < 1 || i4 > 65535) {
            throw new SocketException("No route to " + str + ":" + i4 + "; port is out of range");
        } else if (proxy.type() == Proxy.Type.SOCKS) {
            this.f23352g.add(InetSocketAddress.createUnresolved(str, i4));
        } else {
            this.f23349d.j(this.f23348c, str);
            List lookup = this.f23346a.c().lookup(str);
            if (!lookup.isEmpty()) {
                this.f23349d.i(this.f23348c, str, lookup);
                int size = lookup.size();
                for (int i5 = 0; i5 < size; i5++) {
                    this.f23352g.add(new InetSocketAddress((InetAddress) lookup.get(i5), i4));
                }
                return;
            }
            throw new UnknownHostException(this.f23346a.c() + " returned no addresses for " + str);
        }
    }

    private void h(C2470r rVar, Proxy proxy) {
        List list;
        if (proxy != null) {
            this.f23350e = Collections.singletonList(proxy);
        } else {
            List<Proxy> select = this.f23346a.i().select(rVar.B());
            if (select == null || select.isEmpty()) {
                list = c.r(Proxy.NO_PROXY);
            } else {
                list = c.q(select);
            }
            this.f23350e = list;
        }
        this.f23351f = 0;
    }

    public void a(C2451B b5, IOException iOException) {
        if (!(b5.b().type() == Proxy.Type.DIRECT || this.f23346a.i() == null)) {
            this.f23346a.i().connectFailed(this.f23346a.l().B(), b5.b().address(), iOException);
        }
        this.f23347b.b(b5);
    }

    public boolean c() {
        if (d() || !this.f23353h.isEmpty()) {
            return true;
        }
        return false;
    }

    public a e() {
        if (c()) {
            ArrayList arrayList = new ArrayList();
            while (d()) {
                Proxy f4 = f();
                int size = this.f23352g.size();
                for (int i4 = 0; i4 < size; i4++) {
                    C2451B b5 = new C2451B(this.f23346a, f4, (InetSocketAddress) this.f23352g.get(i4));
                    if (this.f23347b.c(b5)) {
                        this.f23353h.add(b5);
                    } else {
                        arrayList.add(b5);
                    }
                }
                if (!arrayList.isEmpty()) {
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.addAll(this.f23353h);
                this.f23353h.clear();
            }
            return new a(arrayList);
        }
        throw new NoSuchElementException();
    }
}
