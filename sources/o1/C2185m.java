package o1;

import java.util.Arrays;
import java.util.HashMap;
import k1.f;
import k1.g;
import l1.C2108c;
import l1.C2110e;
import n1.C2165h;

/* renamed from: o1.m  reason: case insensitive filesystem */
public class C2185m extends C2173a {

    /* renamed from: d  reason: collision with root package name */
    public static int f21415d = 11;

    /* renamed from: e  reason: collision with root package name */
    public static int f21416e = 1;

    /* renamed from: f  reason: collision with root package name */
    public static String f21417f = "usutv1";

    /* renamed from: c  reason: collision with root package name */
    private C2108c f21418c = new C2110e();

    public C2185m() {
        g();
    }

    private void g() {
        HashMap hashMap = new HashMap();
        this.f21377a = hashMap;
        hashMap.put(C2165h.f21325a, new f(6, Integer.valueOf(f21416e)));
        this.f21377a.put(C2165h.f21326b, new f(2, 0));
        this.f21377a.put(C2165h.f21327c, new f(2, 0));
        this.f21377a.put(C2165h.f21328d, new f(2, 0));
        this.f21377a.put(C2165h.f21329e, new f(2, 0));
        this.f21377a.put(C2165h.f21330f, new f(2, 0));
        this.f21377a.put(C2165h.f21331g, new f(2, 0));
        this.f21377a.put(C2165h.f21332h, new g(2, Arrays.asList(new Integer[]{0, 0, 0, 0, 0, 0, 0, 0})));
        this.f21377a.put(C2165h.f21333i, new f(2, 0));
        this.f21377a.put(C2165h.f21334j, new f(2, 0));
        this.f21377a.put(C2165h.f21335k, new f(2, 0));
        this.f21377a.put(C2165h.f21336l, new f(2, 0));
        this.f21378b = new String[]{C2165h.f21325a, C2165h.f21326b, C2165h.f21327c, C2165h.f21328d, C2165h.f21329e, C2165h.f21330f, C2165h.f21331g, C2165h.f21332h, C2165h.f21333i, C2165h.f21334j, C2165h.f21335k, C2165h.f21336l};
    }

    public String b() {
        return this.f21418c.d(e());
    }

    public void f(String str) {
        d(this.f21418c.c(str));
    }

    public int getId() {
        return f21415d;
    }

    public C2185m(String str) {
        g();
        if (str != null && str.length() > 0) {
            f(str);
        }
    }
}
