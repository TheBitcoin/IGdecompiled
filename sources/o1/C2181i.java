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

/* renamed from: o1.i  reason: case insensitive filesystem */
public class C2181i extends C2174b {

    /* renamed from: d  reason: collision with root package name */
    public static int f21399d = 8;

    /* renamed from: e  reason: collision with root package name */
    public static int f21400e = 1;

    /* renamed from: f  reason: collision with root package name */
    public static String f21401f = "uscav1";

    /* renamed from: c  reason: collision with root package name */
    private C2108c f21402c = new C2110e();

    public C2181i() {
        g();
    }

    private void g() {
        HashMap hashMap = new HashMap();
        this.f21379a = hashMap;
        hashMap.put(C2161d.f21263a, new f(6, Integer.valueOf(f21400e)));
        this.f21379a.put(C2161d.f21264b, new f(2, 0));
        this.f21379a.put(C2161d.f21265c, new f(2, 0));
        this.f21379a.put(C2161d.f21266d, new f(2, 0));
        this.f21379a.put(C2161d.f21267e, new f(2, 0));
        this.f21379a.put(C2161d.f21268f, new f(2, 0));
        this.f21379a.put(C2161d.f21269g, new g(2, Arrays.asList(new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0})));
        this.f21379a.put(C2161d.f21270h, new g(2, Arrays.asList(new Integer[]{0, 0})));
        this.f21379a.put(C2161d.f21271i, new f(2, 0));
        this.f21379a.put(C2161d.f21272j, new f(2, 0));
        this.f21379a.put(C2161d.f21273k, new f(2, 0));
        this.f21379a.put(C2161d.f21274l, new f(2, 0));
        this.f21379a.put(C2161d.f21275m, new f(2, 1));
        this.f21379a.put(C2161d.f21276n, new C2094b(Boolean.TRUE));
        this.f21379a.put(C2161d.f21277o, new C2094b(Boolean.FALSE));
        this.f21380b = new String[][]{new String[]{C2161d.f21263a, C2161d.f21264b, C2161d.f21265c, C2161d.f21266d, C2161d.f21267e, C2161d.f21268f, C2161d.f21269g, C2161d.f21270h, C2161d.f21271i, C2161d.f21272j, C2161d.f21273k, C2161d.f21274l}, new String[]{C2161d.f21275m, C2161d.f21277o}};
    }

    public String b() {
        List e5 = e();
        ArrayList arrayList = new ArrayList();
        if (e5.size() >= 1) {
            arrayList.add(this.f21402c.d((String) e5.get(0)));
            if (e5.size() >= 2 && ((Boolean) ((C2093a) this.f21379a.get(C2161d.f21276n)).c()).booleanValue()) {
                arrayList.add(this.f21402c.d((String) e5.get(1)));
            }
        }
        return (String) Collection$EL.stream(arrayList).collect(Collectors.joining("."));
    }

    public void f(String str) {
        String[] split = str.split("\\.");
        String[] strArr = new String[2];
        boolean z4 = false;
        for (int i4 = 0; i4 < split.length; i4++) {
            String c5 = this.f21402c.c(split[i4]);
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
        return f21399d;
    }

    public C2181i(String str) {
        g();
        if (str != null && str.length() > 0) {
            f(str);
        }
    }
}
