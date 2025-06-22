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
import n1.C2164g;

/* renamed from: o1.l  reason: case insensitive filesystem */
public class C2184l extends C2174b {

    /* renamed from: d  reason: collision with root package name */
    public static int f21411d = 7;

    /* renamed from: e  reason: collision with root package name */
    public static int f21412e = 1;

    /* renamed from: f  reason: collision with root package name */
    public static String f21413f = "usnatv1";

    /* renamed from: c  reason: collision with root package name */
    private C2108c f21414c = new C2110e();

    public C2184l() {
        g();
    }

    private void g() {
        HashMap hashMap = new HashMap();
        this.f21379a = hashMap;
        hashMap.put(C2164g.f21306a, new f(6, Integer.valueOf(f21412e)));
        this.f21379a.put(C2164g.f21307b, new f(2, 0));
        this.f21379a.put(C2164g.f21308c, new f(2, 0));
        this.f21379a.put(C2164g.f21309d, new f(2, 0));
        this.f21379a.put(C2164g.f21310e, new f(2, 0));
        this.f21379a.put(C2164g.f21311f, new f(2, 0));
        this.f21379a.put(C2164g.f21312g, new f(2, 0));
        this.f21379a.put(C2164g.f21313h, new f(2, 0));
        this.f21379a.put(C2164g.f21314i, new f(2, 0));
        this.f21379a.put(C2164g.f21315j, new f(2, 0));
        this.f21379a.put(C2164g.f21316k, new g(2, Arrays.asList(new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0})));
        this.f21379a.put(C2164g.f21317l, new g(2, Arrays.asList(new Integer[]{0, 0})));
        this.f21379a.put(C2164g.f21318m, new f(2, 0));
        this.f21379a.put(C2164g.f21319n, new f(2, 0));
        this.f21379a.put(C2164g.f21320o, new f(2, 0));
        this.f21379a.put(C2164g.f21321p, new f(2, 0));
        this.f21379a.put(C2164g.f21322q, new f(2, 1));
        this.f21379a.put(C2164g.f21323r, new C2094b(Boolean.TRUE));
        this.f21379a.put(C2164g.f21324s, new C2094b(Boolean.FALSE));
        this.f21380b = new String[][]{new String[]{C2164g.f21306a, C2164g.f21307b, C2164g.f21308c, C2164g.f21309d, C2164g.f21310e, C2164g.f21311f, C2164g.f21312g, C2164g.f21313h, C2164g.f21314i, C2164g.f21315j, C2164g.f21316k, C2164g.f21317l, C2164g.f21318m, C2164g.f21319n, C2164g.f21320o, C2164g.f21321p}, new String[]{C2164g.f21322q, C2164g.f21324s}};
    }

    public String b() {
        List e5 = e();
        ArrayList arrayList = new ArrayList();
        if (e5.size() >= 1) {
            arrayList.add(this.f21414c.d((String) e5.get(0)));
            if (e5.size() >= 2 && ((Boolean) ((C2093a) this.f21379a.get(C2164g.f21323r)).c()).booleanValue()) {
                arrayList.add(this.f21414c.d((String) e5.get(1)));
            }
        }
        return (String) Collection$EL.stream(arrayList).collect(Collectors.joining("."));
    }

    public void f(String str) {
        String[] split = str.split("\\.");
        String[] strArr = new String[2];
        boolean z4 = false;
        for (int i4 = 0; i4 < split.length; i4++) {
            String c5 = this.f21414c.c(split[i4]);
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
        return f21411d;
    }

    public C2184l(String str) {
        g();
        if (str != null && str.length() > 0) {
            f(str);
        }
    }
}
