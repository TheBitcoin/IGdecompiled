package D3;

import java.net.InetSocketAddress;
import java.net.Proxy;

/* renamed from: D3.B  reason: case insensitive filesystem */
public final class C2451B {

    /* renamed from: a  reason: collision with root package name */
    final C2453a f22860a;

    /* renamed from: b  reason: collision with root package name */
    final Proxy f22861b;

    /* renamed from: c  reason: collision with root package name */
    final InetSocketAddress f22862c;

    public C2451B(C2453a aVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (aVar == null) {
            throw new NullPointerException("address == null");
        } else if (proxy == null) {
            throw new NullPointerException("proxy == null");
        } else if (inetSocketAddress != null) {
            this.f22860a = aVar;
            this.f22861b = proxy;
            this.f22862c = inetSocketAddress;
        } else {
            throw new NullPointerException("inetSocketAddress == null");
        }
    }

    public C2453a a() {
        return this.f22860a;
    }

    public Proxy b() {
        return this.f22861b;
    }

    public boolean c() {
        if (this.f22860a.f22878i == null || this.f22861b.type() != Proxy.Type.HTTP) {
            return false;
        }
        return true;
    }

    public InetSocketAddress d() {
        return this.f22862c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C2451B)) {
            return false;
        }
        C2451B b5 = (C2451B) obj;
        if (!b5.f22860a.equals(this.f22860a) || !b5.f22861b.equals(this.f22861b) || !b5.f22862c.equals(this.f22862c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((527 + this.f22860a.hashCode()) * 31) + this.f22861b.hashCode()) * 31) + this.f22862c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f22862c + "}";
    }
}
