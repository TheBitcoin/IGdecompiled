package J3;

import E3.c;
import N3.C2517h;
import com.mbridge.msdk.thrid.okhttp.internal.http2.Header;

/* renamed from: J3.c  reason: case insensitive filesystem */
public final class C2488c {

    /* renamed from: d  reason: collision with root package name */
    public static final C2517h f23439d = C2517h.f(":");

    /* renamed from: e  reason: collision with root package name */
    public static final C2517h f23440e = C2517h.f(Header.RESPONSE_STATUS_UTF8);

    /* renamed from: f  reason: collision with root package name */
    public static final C2517h f23441f = C2517h.f(Header.TARGET_METHOD_UTF8);

    /* renamed from: g  reason: collision with root package name */
    public static final C2517h f23442g = C2517h.f(Header.TARGET_PATH_UTF8);

    /* renamed from: h  reason: collision with root package name */
    public static final C2517h f23443h = C2517h.f(Header.TARGET_SCHEME_UTF8);

    /* renamed from: i  reason: collision with root package name */
    public static final C2517h f23444i = C2517h.f(Header.TARGET_AUTHORITY_UTF8);

    /* renamed from: a  reason: collision with root package name */
    public final C2517h f23445a;

    /* renamed from: b  reason: collision with root package name */
    public final C2517h f23446b;

    /* renamed from: c  reason: collision with root package name */
    final int f23447c;

    public C2488c(String str, String str2) {
        this(C2517h.f(str), C2517h.f(str2));
    }

    public boolean equals(Object obj) {
        if (obj instanceof C2488c) {
            C2488c cVar = (C2488c) obj;
            if (!this.f23445a.equals(cVar.f23445a) || !this.f23446b.equals(cVar.f23446b)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((527 + this.f23445a.hashCode()) * 31) + this.f23446b.hashCode();
    }

    public String toString() {
        return c.o("%s: %s", this.f23445a.M(), this.f23446b.M());
    }

    public C2488c(C2517h hVar, String str) {
        this(hVar, C2517h.f(str));
    }

    public C2488c(C2517h hVar, C2517h hVar2) {
        this.f23445a = hVar;
        this.f23446b = hVar2;
        this.f23447c = hVar.G() + 32 + hVar2.G();
    }
}
