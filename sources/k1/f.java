package k1;

import l1.C2115j;

public class f extends C2093a {

    /* renamed from: b  reason: collision with root package name */
    private int f20931b;

    public f(int i4, Integer num) {
        this.f20931b = i4;
        d(num);
    }

    public void a(String str) {
        this.f20929a = Integer.valueOf(C2115j.a(str));
    }

    public String b() {
        return C2115j.b(((Integer) this.f20929a).intValue(), this.f20931b);
    }

    public String e(String str, int i4) {
        return str.substring(i4, this.f20931b + i4);
    }
}
