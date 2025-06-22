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
import n1.C2163f;

/* renamed from: o1.k  reason: case insensitive filesystem */
public class C2183k extends C2174b {

    /* renamed from: d  reason: collision with root package name */
    public static int f21407d = 12;

    /* renamed from: e  reason: collision with root package name */
    public static int f21408e = 1;

    /* renamed from: f  reason: collision with root package name */
    public static String f21409f = "usctv1";

    /* renamed from: c  reason: collision with root package name */
    private C2108c f21410c = new C2110e();

    public C2183k() {
        g();
    }

    private void g() {
        HashMap hashMap = new HashMap();
        this.f21379a = hashMap;
        hashMap.put(C2163f.f21292a, new f(6, Integer.valueOf(f21408e)));
        this.f21379a.put(C2163f.f21293b, new f(2, 0));
        this.f21379a.put(C2163f.f21294c, new f(2, 0));
        this.f21379a.put(C2163f.f21295d, new f(2, 0));
        this.f21379a.put(C2163f.f21296e, new f(2, 0));
        this.f21379a.put(C2163f.f21297f, new f(2, 0));
        this.f21379a.put(C2163f.f21298g, new g(2, Arrays.asList(new Integer[]{0, 0, 0, 0, 0, 0, 0, 0})));
        this.f21379a.put(C2163f.f21299h, new g(2, Arrays.asList(new Integer[]{0, 0, 0})));
        this.f21379a.put(C2163f.f21300i, new f(2, 0));
        this.f21379a.put(C2163f.f21301j, new f(2, 0));
        this.f21379a.put(C2163f.f21302k, new f(2, 0));
        this.f21379a.put(C2163f.f21303l, new f(2, 1));
        this.f21379a.put(C2163f.f21304m, new C2094b(Boolean.TRUE));
        this.f21379a.put(C2163f.f21305n, new C2094b(Boolean.FALSE));
        this.f21380b = new String[][]{new String[]{C2163f.f21292a, C2163f.f21293b, C2163f.f21294c, C2163f.f21295d, C2163f.f21296e, C2163f.f21297f, C2163f.f21298g, C2163f.f21299h, C2163f.f21300i, C2163f.f21301j, C2163f.f21302k}, new String[]{C2163f.f21303l, C2163f.f21305n}};
    }

    public String b() {
        List e5 = e();
        ArrayList arrayList = new ArrayList();
        if (e5.size() >= 1) {
            arrayList.add(this.f21410c.d((String) e5.get(0)));
            if (e5.size() >= 2 && ((Boolean) ((C2093a) this.f21379a.get(C2163f.f21304m)).c()).booleanValue()) {
                arrayList.add(this.f21410c.d((String) e5.get(1)));
            }
        }
        return (String) Collection$EL.stream(arrayList).collect(Collectors.joining("."));
    }

    public void f(String str) {
        String[] split = str.split("\\.");
        String[] strArr = new String[2];
        boolean z4 = false;
        for (int i4 = 0; i4 < split.length; i4++) {
            String c5 = this.f21410c.c(split[i4]);
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
        return f21407d;
    }

    public C2183k(String str) {
        g();
        if (str != null && str.length() > 0) {
            f(str);
        }
    }
}
