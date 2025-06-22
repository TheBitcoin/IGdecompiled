package H3;

import D3.C2457e;
import D3.C2460h;
import D3.C2467o;
import D3.C2471s;
import D3.x;
import D3.z;
import G3.c;
import java.util.List;

public final class g implements C2471s.a {

    /* renamed from: a  reason: collision with root package name */
    private final List f23378a;

    /* renamed from: b  reason: collision with root package name */
    private final G3.g f23379b;

    /* renamed from: c  reason: collision with root package name */
    private final C2484c f23380c;

    /* renamed from: d  reason: collision with root package name */
    private final c f23381d;

    /* renamed from: e  reason: collision with root package name */
    private final int f23382e;

    /* renamed from: f  reason: collision with root package name */
    private final x f23383f;

    /* renamed from: g  reason: collision with root package name */
    private final C2457e f23384g;

    /* renamed from: h  reason: collision with root package name */
    private final C2467o f23385h;

    /* renamed from: i  reason: collision with root package name */
    private final int f23386i;

    /* renamed from: j  reason: collision with root package name */
    private final int f23387j;

    /* renamed from: k  reason: collision with root package name */
    private final int f23388k;

    /* renamed from: l  reason: collision with root package name */
    private int f23389l;

    public g(List list, G3.g gVar, C2484c cVar, c cVar2, int i4, x xVar, C2457e eVar, C2467o oVar, int i5, int i6, int i7) {
        this.f23378a = list;
        this.f23381d = cVar2;
        this.f23379b = gVar;
        this.f23380c = cVar;
        this.f23382e = i4;
        this.f23383f = xVar;
        this.f23384g = eVar;
        this.f23385h = oVar;
        this.f23386i = i5;
        this.f23387j = i6;
        this.f23388k = i7;
    }

    public z a(x xVar) {
        return f(xVar, this.f23379b, this.f23380c, this.f23381d);
    }

    public C2457e b() {
        return this.f23384g;
    }

    public C2460h c() {
        return this.f23381d;
    }

    public int connectTimeoutMillis() {
        return this.f23386i;
    }

    public C2467o d() {
        return this.f23385h;
    }

    public C2484c e() {
        return this.f23380c;
    }

    public z f(x xVar, G3.g gVar, C2484c cVar, c cVar2) {
        if (this.f23382e < this.f23378a.size()) {
            this.f23389l++;
            if (this.f23380c != null && !this.f23381d.r(xVar.i())) {
                throw new IllegalStateException("network interceptor " + this.f23378a.get(this.f23382e - 1) + " must retain the same host and port");
            } else if (this.f23380c == null || this.f23389l <= 1) {
                g gVar2 = new g(this.f23378a, gVar, cVar, cVar2, this.f23382e + 1, xVar, this.f23384g, this.f23385h, this.f23386i, this.f23387j, this.f23388k);
                C2471s sVar = (C2471s) this.f23378a.get(this.f23382e);
                z a5 = sVar.a(gVar2);
                if (cVar != null && this.f23382e + 1 < this.f23378a.size() && gVar2.f23389l != 1) {
                    throw new IllegalStateException("network interceptor " + sVar + " must call proceed() exactly once");
                } else if (a5 == null) {
                    throw new NullPointerException("interceptor " + sVar + " returned null");
                } else if (a5.a() != null) {
                    return a5;
                } else {
                    throw new IllegalStateException("interceptor " + sVar + " returned a response with no body");
                }
            } else {
                throw new IllegalStateException("network interceptor " + this.f23378a.get(this.f23382e - 1) + " must call proceed() exactly once");
            }
        } else {
            throw new AssertionError();
        }
    }

    public G3.g g() {
        return this.f23379b;
    }

    public int readTimeoutMillis() {
        return this.f23387j;
    }

    public x request() {
        return this.f23383f;
    }

    public int writeTimeoutMillis() {
        return this.f23388k;
    }
}
