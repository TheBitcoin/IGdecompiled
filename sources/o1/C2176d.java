package o1;

import java.util.ArrayList;
import java.util.HashMap;
import k1.C2093a;
import k1.d;
import k1.f;
import l1.C2108c;
import l1.C2110e;
import n1.C2158a;

/* renamed from: o1.d  reason: case insensitive filesystem */
public class C2176d extends C2173a {

    /* renamed from: d  reason: collision with root package name */
    public static int f21381d = 3;

    /* renamed from: e  reason: collision with root package name */
    public static int f21382e = 1;

    /* renamed from: f  reason: collision with root package name */
    public static String f21383f = "header";

    /* renamed from: c  reason: collision with root package name */
    private C2108c f21384c = new C2110e();

    public C2176d() {
        h();
    }

    private void h() {
        HashMap hashMap = new HashMap();
        this.f21377a = hashMap;
        hashMap.put(C2158a.f21210a, new f(6, Integer.valueOf(f21381d)));
        this.f21377a.put(C2158a.f21211b, new f(6, Integer.valueOf(f21382e)));
        this.f21377a.put(C2158a.f21212c, new d(new ArrayList()));
        this.f21378b = new String[]{C2158a.f21210a, C2158a.f21211b, C2158a.f21212c};
    }

    public String b() {
        return this.f21384c.d(e());
    }

    public void f(String str) {
        d(this.f21384c.c(str));
    }

    public Integer g() {
        return (Integer) ((C2093a) this.f21377a.get(C2158a.f21211b)).c();
    }

    public int getId() {
        return f21381d;
    }

    public C2176d(String str) {
        h();
        if (str != null && str.length() > 0) {
            f(str);
        }
    }
}
