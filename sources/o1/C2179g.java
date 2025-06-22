package o1;

import j$.time.ZoneId;
import j$.time.ZonedDateTime;
import j$.util.Collection$EL;
import j$.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.IntSupplier;
import k1.C2094b;
import k1.C2095c;
import k1.e;
import k1.f;
import k1.i;
import k1.j;
import k1.k;
import l1.C2108c;
import l1.C2110e;
import m1.C2152a;
import n1.C2159b;

/* renamed from: o1.g  reason: case insensitive filesystem */
public class C2179g extends C2174b {

    /* renamed from: d  reason: collision with root package name */
    public static int f21387d = 5;

    /* renamed from: e  reason: collision with root package name */
    public static int f21388e = 1;

    /* renamed from: f  reason: collision with root package name */
    public static String f21389f = "tcfcav1";

    /* renamed from: c  reason: collision with root package name */
    private C2108c f21390c = new C2110e();

    /* renamed from: o1.g$a */
    class a implements IntSupplier {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f21391a;

        a(f fVar) {
            this.f21391a = fVar;
        }

        public int getAsInt() {
            return ((Integer) this.f21391a.c()).intValue();
        }
    }

    public C2179g() {
        g();
    }

    private void g() {
        this.f21379a = new HashMap();
        ZonedDateTime now = ZonedDateTime.now();
        this.f21379a.put(C2159b.f21213a, new f(6, Integer.valueOf(f21388e)));
        this.f21379a.put(C2159b.f21214b, new C2095c(now));
        this.f21379a.put(C2159b.f21215c, new C2095c(now));
        this.f21379a.put(C2159b.f21216d, new f(12, 0));
        this.f21379a.put(C2159b.f21217e, new f(12, 0));
        this.f21379a.put(C2159b.f21218f, new f(6, 0));
        this.f21379a.put(C2159b.f21219g, new i(2, "EN"));
        this.f21379a.put(C2159b.f21220h, new f(12, 0));
        this.f21379a.put(C2159b.f21221i, new f(6, 2));
        Map map = this.f21379a;
        String str = C2159b.f21222j;
        Boolean bool = Boolean.FALSE;
        map.put(str, new C2094b(bool));
        this.f21379a.put(C2159b.f21223k, new e(Arrays.asList(new Boolean[]{bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool})));
        this.f21379a.put(C2159b.f21224l, new e(Arrays.asList(new Boolean[]{bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool})));
        this.f21379a.put(C2159b.f21225m, new e(Arrays.asList(new Boolean[]{bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool})));
        this.f21379a.put(C2159b.f21226n, new k(new ArrayList()));
        this.f21379a.put(C2159b.f21227o, new k(new ArrayList()));
        this.f21379a.put(C2159b.f21228p, new f(3, 3));
        this.f21379a.put(C2159b.f21229q, new e(Arrays.asList(new Boolean[]{bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool})));
        this.f21379a.put(C2159b.f21230r, new e(Arrays.asList(new Boolean[]{bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool})));
        f fVar = new f(6, 0);
        this.f21379a.put(C2159b.f21231s, fVar);
        a aVar = new a(fVar);
        this.f21379a.put(C2159b.f21232t, new j(aVar, new ArrayList()));
        this.f21379a.put(C2159b.f21233u, new j(aVar, new ArrayList()));
        this.f21380b = new String[][]{new String[]{C2159b.f21213a, C2159b.f21214b, C2159b.f21215c, C2159b.f21216d, C2159b.f21217e, C2159b.f21218f, C2159b.f21219g, C2159b.f21220h, C2159b.f21221i, C2159b.f21222j, C2159b.f21223k, C2159b.f21224l, C2159b.f21225m, C2159b.f21226n, C2159b.f21227o}, new String[]{C2159b.f21228p, C2159b.f21229q, C2159b.f21230r, C2159b.f21231s, C2159b.f21232t, C2159b.f21233u}};
    }

    public void a(String str, Object obj) {
        super.a(str, obj);
        if (!str.equals(C2159b.f21214b) && !str.equals(C2159b.f21215c)) {
            ZonedDateTime now = ZonedDateTime.now(ZoneId.of("UTC"));
            super.a(C2159b.f21214b, now);
            super.a(C2159b.f21215c, now);
        }
    }

    public String b() {
        List e5 = e();
        ArrayList arrayList = new ArrayList();
        if (e5.size() >= 1) {
            arrayList.add(this.f21390c.d((String) e5.get(0)));
            if (e5.size() >= 2) {
                arrayList.add(this.f21390c.d((String) e5.get(1)));
            }
        }
        return (String) Collection$EL.stream(arrayList).collect(Collectors.joining("."));
    }

    public void f(String str) {
        String[] split = str.split("\\.");
        String[] strArr = new String[4];
        for (int i4 = 0; i4 < split.length; i4++) {
            String c5 = this.f21390c.c(split[i4]);
            String substring = c5.substring(0, 3);
            substring.getClass();
            if (substring.equals("000")) {
                strArr[0] = c5;
            } else if (substring.equals("011")) {
                strArr[1] = c5;
            } else {
                throw new C2152a("Unable to decode segment '" + split[i4] + "'");
            }
        }
        d(Arrays.asList(strArr));
    }

    public int getId() {
        return f21387d;
    }

    public C2179g(String str) {
        g();
        if (str != null && str.length() > 0) {
            f(str);
        }
    }
}
