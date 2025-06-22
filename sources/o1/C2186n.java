package o1;

import java.util.Arrays;
import java.util.HashMap;
import k1.f;
import k1.g;
import l1.C2108c;
import l1.C2110e;
import n1.C2166i;

/* renamed from: o1.n  reason: case insensitive filesystem */
public class C2186n extends C2173a {

    /* renamed from: d  reason: collision with root package name */
    public static int f21419d = 9;

    /* renamed from: e  reason: collision with root package name */
    public static int f21420e = 1;

    /* renamed from: f  reason: collision with root package name */
    public static String f21421f = "usvav1";

    /* renamed from: c  reason: collision with root package name */
    private C2108c f21422c = new C2110e();

    public C2186n() {
        g();
    }

    private void g() {
        HashMap hashMap = new HashMap();
        this.f21377a = hashMap;
        hashMap.put(C2166i.f21337a, new f(6, Integer.valueOf(f21420e)));
        this.f21377a.put(C2166i.f21338b, new f(2, 0));
        this.f21377a.put(C2166i.f21339c, new f(2, 0));
        this.f21377a.put(C2166i.f21340d, new f(2, 0));
        this.f21377a.put(C2166i.f21341e, new f(2, 0));
        this.f21377a.put(C2166i.f21342f, new f(2, 0));
        this.f21377a.put(C2166i.f21343g, new g(2, Arrays.asList(new Integer[]{0, 0, 0, 0, 0, 0, 0, 0})));
        this.f21377a.put(C2166i.f21344h, new f(2, 0));
        this.f21377a.put(C2166i.f21345i, new f(2, 0));
        this.f21377a.put(C2166i.f21346j, new f(2, 0));
        this.f21377a.put(C2166i.f21347k, new f(2, 0));
        this.f21378b = new String[]{C2166i.f21337a, C2166i.f21338b, C2166i.f21339c, C2166i.f21340d, C2166i.f21341e, C2166i.f21342f, C2166i.f21343g, C2166i.f21344h, C2166i.f21345i, C2166i.f21346j, C2166i.f21347k};
    }

    public String b() {
        return this.f21422c.d(e());
    }

    public void f(String str) {
        d(this.f21422c.c(str));
    }

    public int getId() {
        return f21419d;
    }

    public C2186n(String str) {
        g();
        if (str != null && str.length() > 0) {
            f(str);
        }
    }
}
