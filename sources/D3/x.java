package D3;

import D3.C2469q;
import H3.f;
import androidx.browser.trusted.sharing.ShareTarget;
import java.util.List;

public final class x {

    /* renamed from: a  reason: collision with root package name */
    final C2470r f23201a;

    /* renamed from: b  reason: collision with root package name */
    final String f23202b;

    /* renamed from: c  reason: collision with root package name */
    final C2469q f23203c;

    /* renamed from: d  reason: collision with root package name */
    final y f23204d;

    /* renamed from: e  reason: collision with root package name */
    final Object f23205e;

    /* renamed from: f  reason: collision with root package name */
    private volatile C2456d f23206f;

    x(a aVar) {
        this.f23201a = aVar.f23207a;
        this.f23202b = aVar.f23208b;
        this.f23203c = aVar.f23209c.d();
        this.f23204d = aVar.f23210d;
        Object obj = aVar.f23211e;
        this.f23205e = obj == null ? this : obj;
    }

    public y a() {
        return this.f23204d;
    }

    public C2456d b() {
        C2456d dVar = this.f23206f;
        if (dVar != null) {
            return dVar;
        }
        C2456d l4 = C2456d.l(this.f23203c);
        this.f23206f = l4;
        return l4;
    }

    public String c(String str) {
        return this.f23203c.a(str);
    }

    public C2469q d() {
        return this.f23203c;
    }

    public List e(String str) {
        return this.f23203c.g(str);
    }

    public boolean f() {
        return this.f23201a.l();
    }

    public String g() {
        return this.f23202b;
    }

    public a h() {
        return new a(this);
    }

    public C2470r i() {
        return this.f23201a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(this.f23202b);
        sb.append(", url=");
        sb.append(this.f23201a);
        sb.append(", tag=");
        Object obj = this.f23205e;
        if (obj == this) {
            obj = null;
        }
        sb.append(obj);
        sb.append('}');
        return sb.toString();
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        C2470r f23207a;

        /* renamed from: b  reason: collision with root package name */
        String f23208b;

        /* renamed from: c  reason: collision with root package name */
        C2469q.a f23209c;

        /* renamed from: d  reason: collision with root package name */
        y f23210d;

        /* renamed from: e  reason: collision with root package name */
        Object f23211e;

        public a() {
            this.f23208b = ShareTarget.METHOD_GET;
            this.f23209c = new C2469q.a();
        }

        public x a() {
            if (this.f23207a != null) {
                return new x(this);
            }
            throw new IllegalStateException("url == null");
        }

        public a b(C2456d dVar) {
            String dVar2 = dVar.toString();
            if (dVar2.isEmpty()) {
                return f("Cache-Control");
            }
            return c("Cache-Control", dVar2);
        }

        public a c(String str, String str2) {
            this.f23209c.h(str, str2);
            return this;
        }

        public a d(C2469q qVar) {
            this.f23209c = qVar.d();
            return this;
        }

        public a e(String str, y yVar) {
            if (str == null) {
                throw new NullPointerException("method == null");
            } else if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            } else if (yVar != null && !f.b(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            } else if (yVar != null || !f.e(str)) {
                this.f23208b = str;
                this.f23210d = yVar;
                return this;
            } else {
                throw new IllegalArgumentException("method " + str + " must have a request body.");
            }
        }

        public a f(String str) {
            this.f23209c.g(str);
            return this;
        }

        public a g(C2470r rVar) {
            if (rVar != null) {
                this.f23207a = rVar;
                return this;
            }
            throw new NullPointerException("url == null");
        }

        public a h(String str) {
            String str2;
            if (str != null) {
                String str3 = str;
                if (str3.regionMatches(true, 0, "ws:", 0, 3)) {
                    str2 = "http:" + str3.substring(3);
                } else if (str3.regionMatches(true, 0, "wss:", 0, 4)) {
                    str2 = "https:" + str3.substring(4);
                } else {
                    str2 = str3;
                }
                C2470r p4 = C2470r.p(str2);
                if (p4 != null) {
                    return g(p4);
                }
                throw new IllegalArgumentException("unexpected url: " + str2);
            }
            throw new NullPointerException("url == null");
        }

        a(x xVar) {
            this.f23207a = xVar.f23201a;
            this.f23208b = xVar.f23202b;
            this.f23210d = xVar.f23204d;
            this.f23211e = xVar.f23205e;
            this.f23209c = xVar.f23203c.d();
        }
    }
}
