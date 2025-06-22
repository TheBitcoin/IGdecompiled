package o1;

import j$.util.Collection$EL;
import j$.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import k1.C2093a;
import k1.C2094b;
import k1.f;
import k1.g;
import l1.C2108c;
import l1.C2110e;
import m1.C2152a;
import n1.C2161d;
import n1.C2162e;

/* renamed from: o1.j  reason: case insensitive filesystem */
public class C2182j extends C2174b {

    /* renamed from: d  reason: collision with root package name */
    public static int f21403d = 10;

    /* renamed from: e  reason: collision with root package name */
    public static int f21404e = 1;

    /* renamed from: f  reason: collision with root package name */
    public static String f21405f = "uscov1";

    /* renamed from: c  reason: collision with root package name */
    private C2108c f21406c = new C2110e();

    public C2182j() {
        g();
    }

    private void g() {
        HashMap hashMap = new HashMap();
        this.f21379a = hashMap;
        hashMap.put(C2162e.f21278a, new f(6, Integer.valueOf(f21404e)));
        this.f21379a.put(C2162e.f21279b, new f(2, 0));
        this.f21379a.put(C2162e.f21280c, new f(2, 0));
        this.f21379a.put(C2162e.f21281d, new f(2, 0));
        this.f21379a.put(C2162e.f21282e, new f(2, 0));
        this.f21379a.put(C2162e.f21283f, new f(2, 0));
        this.f21379a.put(C2162e.f21284g, new g(2, Arrays.asList(new Integer[]{0, 0, 0, 0, 0, 0, 0})));
        this.f21379a.put(C2162e.f21285h, new f(2, 0));
        this.f21379a.put(C2162e.f21286i, new f(2, 0));
        this.f21379a.put(C2162e.f21287j, new f(2, 0));
        this.f21379a.put(C2162e.f21288k, new f(2, 0));
        this.f21379a.put(C2162e.f21289l, new f(2, 1));
        this.f21379a.put(C2162e.f21290m, new C2094b(Boolean.TRUE));
        this.f21379a.put(C2162e.f21291n, new C2094b(Boolean.FALSE));
        this.f21380b = new String[][]{new String[]{C2162e.f21278a, C2162e.f21279b, C2162e.f21280c, C2162e.f21281d, C2162e.f21282e, C2162e.f21283f, C2162e.f21284g, C2162e.f21285h, C2162e.f21286i, C2162e.f21287j, C2162e.f21288k}, new String[]{C2162e.f21289l, C2162e.f21291n}};
    }

    public String b() {
        List e5 = e();
        ArrayList arrayList = new ArrayList();
        if (e5.size() >= 1) {
            arrayList.add(this.f21406c.d((String) e5.get(0)));
            if (e5.size() >= 2 && ((Boolean) ((C2093a) this.f21379a.get(C2162e.f21290m)).c()).booleanValue()) {
                arrayList.add(this.f21406c.d((String) e5.get(1)));
            }
        }
        return (String) Collection$EL.stream(arrayList).collect(Collectors.joining("."));
    }

    public void f(String str) {
        String[] split = str.split("\\.");
        String[] strArr = new String[2];
        boolean z4 = false;
        for (int i4 = 0; i4 < split.length; i4++) {
            String c5 = this.f21406c.c(split[i4]);
            String substring = c5.substring(0, 2);
            substring.getClass();
            if (substring.equals("00")) {
                strArr[0] = c5;
            } else if (substring.equals("01")) {
                strArr[1] = c5;
                z4 = true;
            } else {
                throw new C2152a("Unable to decode segment '" + split[i4] + "'");
            }
        }
        d(Arrays.asList(strArr));
        ((C2093a) this.f21379a.get(C2161d.f21276n)).d(Boolean.valueOf(z4));
    }

    public int getId() {
        return f21403d;
    }

    public C2182j(String str) {
        g();
        if (str != null && str.length() > 0) {
            f(str);
        }
    }
}
