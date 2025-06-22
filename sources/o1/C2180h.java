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
import k1.h;
import k1.i;
import k1.j;
import k1.k;
import l1.C2108c;
import l1.C2120o;
import m1.C2152a;
import n1.C2160c;

/* renamed from: o1.h  reason: case insensitive filesystem */
public class C2180h extends C2174b {

    /* renamed from: d  reason: collision with root package name */
    public static int f21393d = 2;

    /* renamed from: e  reason: collision with root package name */
    public static int f21394e = 2;

    /* renamed from: f  reason: collision with root package name */
    public static String f21395f = "tcfeuv2";

    /* renamed from: c  reason: collision with root package name */
    private C2108c f21396c = new C2120o();

    /* renamed from: o1.h$a */
    class a implements IntSupplier {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f21397a;

        a(f fVar) {
            this.f21397a = fVar;
        }

        public int getAsInt() {
            return ((Integer) this.f21397a.c()).intValue();
        }
    }

    public C2180h() {
        g();
    }

    private void g() {
        this.f21379a = new HashMap();
        ZonedDateTime now = ZonedDateTime.now();
        this.f21379a.put(C2160c.f21237a, new f(6, Integer.valueOf(f21394e)));
        this.f21379a.put(C2160c.f21238b, new C2095c(now));
        this.f21379a.put(C2160c.f21239c, new C2095c(now));
        this.f21379a.put(C2160c.f21240d, new f(12, 0));
        this.f21379a.put(C2160c.f21241e, new f(12, 0));
        this.f21379a.put(C2160c.f21242f, new f(6, 0));
        this.f21379a.put(C2160c.f21243g, new i(2, "EN"));
        this.f21379a.put(C2160c.f21244h, new f(12, 0));
        this.f21379a.put(C2160c.f21245i, new f(6, 2));
        Map map = this.f21379a;
        String str = C2160c.f21246j;
        Boolean bool = Boolean.FALSE;
        map.put(str, new C2094b(bool));
        this.f21379a.put(C2160c.f21247k, new C2094b(bool));
        this.f21379a.put(C2160c.f21248l, new e(Arrays.asList(new Boolean[]{bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool})));
        this.f21379a.put(C2160c.f21249m, new e(Arrays.asList(new Boolean[]{bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool})));
        this.f21379a.put(C2160c.f21250n, new e(Arrays.asList(new Boolean[]{bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool})));
        this.f21379a.put(C2160c.f21251o, new C2094b(bool));
        this.f21379a.put(C2160c.f21252p, new i(2, "AA"));
        this.f21379a.put(C2160c.f21253q, new k(new ArrayList()));
        this.f21379a.put(C2160c.f21254r, new k(new ArrayList()));
        this.f21379a.put(C2160c.f21255s, new h(new ArrayList()));
        this.f21379a.put(C2160c.f21256t, new f(3, 3));
        this.f21379a.put(C2160c.f21257u, new e(Arrays.asList(new Boolean[]{bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool})));
        this.f21379a.put(C2160c.f21258v, new e(Arrays.asList(new Boolean[]{bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool, bool})));
        f fVar = new f(6, 0);
        this.f21379a.put(C2160c.f21259w, fVar);
        a aVar = new a(fVar);
        this.f21379a.put(C2160c.f21260x, new j(aVar, new ArrayList()));
        this.f21379a.put(C2160c.f21261y, new j(aVar, new ArrayList()));
        this.f21379a.put(C2160c.f21262z, new f(3, 2));
        this.f21379a.put(C2160c.f21234A, new k(new ArrayList()));
        this.f21379a.put(C2160c.f21235B, new f(3, 1));
        this.f21379a.put(C2160c.f21236C, new k(new ArrayList()));
        this.f21380b = new String[][]{new String[]{C2160c.f21237a, C2160c.f21238b, C2160c.f21239c, C2160c.f21240d, C2160c.f21241e, C2160c.f21242f, C2160c.f21243g, C2160c.f21244h, C2160c.f21245i, C2160c.f21246j, C2160c.f21247k, C2160c.f21248l, C2160c.f21249m, C2160c.f21250n, C2160c.f21251o, C2160c.f21252p, C2160c.f21253q, C2160c.f21254r, C2160c.f21255s}, new String[]{C2160c.f21256t, C2160c.f21257u, C2160c.f21258v, C2160c.f21259w, C2160c.f21260x, C2160c.f21261y}, new String[]{C2160c.f21262z, C2160c.f21234A}, new String[]{C2160c.f21235B, C2160c.f21236C}};
    }

    public void a(String str, Object obj) {
        super.a(str, obj);
        if (!str.equals(C2160c.f21238b) && !str.equals(C2160c.f21239c)) {
            ZonedDateTime now = ZonedDateTime.now(ZoneId.of("UTC"));
            super.a(C2160c.f21238b, now);
            super.a(C2160c.f21239c, now);
        }
    }

    public String b() {
        List e5 = e();
        ArrayList arrayList = new ArrayList();
        if (e5.size() >= 1) {
            arrayList.add(this.f21396c.d((String) e5.get(0)));
            if (((Boolean) c(C2160c.f21246j)).booleanValue()) {
                if (e5.size() >= 2) {
                    arrayList.add(this.f21396c.d((String) e5.get(1)));
                }
            } else if (e5.size() >= 2) {
                arrayList.add(this.f21396c.d((String) e5.get(2)));
                if (e5.size() >= 3) {
                    arrayList.add(this.f21396c.d((String) e5.get(3)));
                }
            }
        }
        return (String) Collection$EL.stream(arrayList).collect(Collectors.joining("."));
    }

    public void f(String str) {
        String[] split = str.split("\\.");
        String[] strArr = new String[4];
        for (int i4 = 0; i4 < split.length; i4++) {
            String c5 = this.f21396c.c(split[i4]);
            String substring = c5.substring(0, 3);
            substring.getClass();
            char c6 = 65535;
            switch (substring.hashCode()) {
                case 47664:
                    if (substring.equals("000")) {
                        c6 = 0;
                        break;
                    }
                    break;
                case 47665:
                    if (substring.equals("001")) {
                        c6 = 1;
                        break;
                    }
                    break;
                case 47695:
                    if (substring.equals("010")) {
                        c6 = 2;
                        break;
                    }
                    break;
                case 47696:
                    if (substring.equals("011")) {
                        c6 = 3;
                        break;
                    }
                    break;
            }
            switch (c6) {
                case 0:
                    strArr[0] = c5;
                    break;
                case 1:
                    strArr[3] = c5;
                    break;
                case 2:
                    strArr[2] = c5;
                    break;
                case 3:
                    strArr[1] = c5;
                    break;
                default:
                    throw new C2152a("Unable to decode segment '" + split[i4] + "'");
            }
        }
        d(Arrays.asList(strArr));
    }

    public int getId() {
        return f21393d;
    }

    public C2180h(String str) {
        g();
        if (str != null && str.length() > 0) {
            f(str);
        }
    }
}
