package D3;

import E3.c;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* renamed from: D3.j  reason: case insensitive filesystem */
public final class C2462j {

    /* renamed from: e  reason: collision with root package name */
    private static final C2459g[] f23066e;

    /* renamed from: f  reason: collision with root package name */
    public static final C2462j f23067f;

    /* renamed from: g  reason: collision with root package name */
    public static final C2462j f23068g;

    /* renamed from: h  reason: collision with root package name */
    public static final C2462j f23069h = new a(false).a();

    /* renamed from: a  reason: collision with root package name */
    final boolean f23070a;

    /* renamed from: b  reason: collision with root package name */
    final boolean f23071b;

    /* renamed from: c  reason: collision with root package name */
    final String[] f23072c;

    /* renamed from: d  reason: collision with root package name */
    final String[] f23073d;

    static {
        C2459g[] gVarArr = {C2459g.f22994Z0, C2459g.f23005d1, C2459g.f22996a1, C2459g.f23008e1, C2459g.f23026k1, C2459g.f23023j1, C2459g.f22964K0, C2459g.f22966L0, C2459g.f23019i0, C2459g.f23022j0, C2459g.f22955G, C2459g.f22963K, C2459g.f23024k};
        f23066e = gVarArr;
        a b5 = new a(true).b(gVarArr);
        C2452C c5 = C2452C.TLS_1_0;
        C2462j a5 = b5.e(C2452C.TLS_1_3, C2452C.TLS_1_2, C2452C.TLS_1_1, c5).d(true).a();
        f23067f = a5;
        f23068g = new a(a5).e(c5).d(true).a();
    }

    C2462j(a aVar) {
        this.f23070a = aVar.f23074a;
        this.f23072c = aVar.f23075b;
        this.f23073d = aVar.f23076c;
        this.f23071b = aVar.f23077d;
    }

    private C2462j e(SSLSocket sSLSocket, boolean z4) {
        String[] strArr;
        String[] strArr2;
        if (this.f23072c != null) {
            strArr = c.v(C2459g.f22997b, sSLSocket.getEnabledCipherSuites(), this.f23072c);
        } else {
            strArr = sSLSocket.getEnabledCipherSuites();
        }
        if (this.f23073d != null) {
            strArr2 = c.v(c.f23258q, sSLSocket.getEnabledProtocols(), this.f23073d);
        } else {
            strArr2 = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int s4 = c.s(C2459g.f22997b, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z4 && s4 != -1) {
            strArr = c.f(strArr, supportedCipherSuites[s4]);
        }
        return new a(this).c(strArr).f(strArr2).a();
    }

    /* access modifiers changed from: package-private */
    public void a(SSLSocket sSLSocket, boolean z4) {
        C2462j e5 = e(sSLSocket, z4);
        String[] strArr = e5.f23073d;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = e5.f23072c;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    public List b() {
        String[] strArr = this.f23072c;
        if (strArr != null) {
            return C2459g.b(strArr);
        }
        return null;
    }

    public boolean c(SSLSocket sSLSocket) {
        if (!this.f23070a) {
            return false;
        }
        String[] strArr = this.f23073d;
        if (strArr != null && !c.x(c.f23258q, strArr, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        String[] strArr2 = this.f23072c;
        if (strArr2 == null || c.x(C2459g.f22997b, strArr2, sSLSocket.getEnabledCipherSuites())) {
            return true;
        }
        return false;
    }

    public boolean d() {
        return this.f23070a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C2462j)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        C2462j jVar = (C2462j) obj;
        boolean z4 = this.f23070a;
        if (z4 != jVar.f23070a) {
            return false;
        }
        if (!z4 || (Arrays.equals(this.f23072c, jVar.f23072c) && Arrays.equals(this.f23073d, jVar.f23073d) && this.f23071b == jVar.f23071b)) {
            return true;
        }
        return false;
    }

    public boolean f() {
        return this.f23071b;
    }

    public List g() {
        String[] strArr = this.f23073d;
        if (strArr != null) {
            return C2452C.b(strArr);
        }
        return null;
    }

    public int hashCode() {
        if (this.f23070a) {
            return ((((527 + Arrays.hashCode(this.f23072c)) * 31) + Arrays.hashCode(this.f23073d)) * 31) + (this.f23071b ^ true ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        String str;
        if (!this.f23070a) {
            return "ConnectionSpec()";
        }
        String str2 = "[all enabled]";
        if (this.f23072c != null) {
            str = b().toString();
        } else {
            str = str2;
        }
        if (this.f23073d != null) {
            str2 = g().toString();
        }
        return "ConnectionSpec(cipherSuites=" + str + ", tlsVersions=" + str2 + ", supportsTlsExtensions=" + this.f23071b + ")";
    }

    /* renamed from: D3.j$a */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f23074a;

        /* renamed from: b  reason: collision with root package name */
        String[] f23075b;

        /* renamed from: c  reason: collision with root package name */
        String[] f23076c;

        /* renamed from: d  reason: collision with root package name */
        boolean f23077d;

        a(boolean z4) {
            this.f23074a = z4;
        }

        public C2462j a() {
            return new C2462j(this);
        }

        public a b(C2459g... gVarArr) {
            if (this.f23074a) {
                String[] strArr = new String[gVarArr.length];
                for (int i4 = 0; i4 < gVarArr.length; i4++) {
                    strArr[i4] = gVarArr[i4].f23057a;
                }
                return c(strArr);
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public a c(String... strArr) {
            if (!this.f23074a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            } else if (strArr.length != 0) {
                this.f23075b = (String[]) strArr.clone();
                return this;
            } else {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
        }

        public a d(boolean z4) {
            if (this.f23074a) {
                this.f23077d = z4;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public a e(C2452C... cArr) {
            if (this.f23074a) {
                String[] strArr = new String[cArr.length];
                for (int i4 = 0; i4 < cArr.length; i4++) {
                    strArr[i4] = cArr[i4].f22869a;
                }
                return f(strArr);
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public a f(String... strArr) {
            if (!this.f23074a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            } else if (strArr.length != 0) {
                this.f23076c = (String[]) strArr.clone();
                return this;
            } else {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
        }

        public a(C2462j jVar) {
            this.f23074a = jVar.f23070a;
            this.f23075b = jVar.f23072c;
            this.f23076c = jVar.f23073d;
            this.f23077d = jVar.f23071b;
        }
    }
}
