package k1;

import l1.C2119n;

public class i extends C2093a {

    /* renamed from: b  reason: collision with root package name */
    private int f20934b;

    public i(int i4, String str) {
        this.f20934b = i4;
        d(str);
    }

    public void a(String str) {
        this.f20929a = C2119n.a(str);
    }

    public String b() {
        return C2119n.b((String) this.f20929a, this.f20934b);
    }

    public String e(String str, int i4) {
        return str.substring(i4, (this.f20934b * 6) + i4);
    }
}
