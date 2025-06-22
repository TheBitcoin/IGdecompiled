package o1;

import java.util.HashMap;
import java.util.Map;
import m1.C2152a;
import m1.C2154c;
import n1.C2167j;

/* renamed from: o1.o  reason: case insensitive filesystem */
public class C2187o implements C2175c {

    /* renamed from: b  reason: collision with root package name */
    public static int f21423b = 6;

    /* renamed from: c  reason: collision with root package name */
    public static int f21424c = 1;

    /* renamed from: d  reason: collision with root package name */
    public static String f21425d = "uspv1";

    /* renamed from: a  reason: collision with root package name */
    protected Map f21426a;

    public C2187o() {
        e();
    }

    private void e() {
        HashMap hashMap = new HashMap();
        this.f21426a = hashMap;
        hashMap.put(C2167j.f21348a, Integer.valueOf(f21424c));
        this.f21426a.put(C2167j.f21349b, "-");
        this.f21426a.put(C2167j.f21350c, "-");
        this.f21426a.put(C2167j.f21351d, "-");
    }

    public void a(String str, Object obj) {
        if (this.f21426a.containsKey(str)) {
            this.f21426a.put(str, obj);
            return;
        }
        throw new C2154c(str + " not found");
    }

    public String b() {
        return ((("" + c(C2167j.f21348a)) + c(C2167j.f21349b)) + c(C2167j.f21350c)) + c(C2167j.f21351d);
    }

    public Object c(String str) {
        if (this.f21426a.containsKey(str)) {
            return this.f21426a.get(str);
        }
        return null;
    }

    public void d(String str) {
        try {
            a(C2167j.f21348a, Integer.valueOf(Integer.parseInt(String.valueOf(str.charAt(0)))));
            a(C2167j.f21349b, String.valueOf(str.charAt(1)));
            a(C2167j.f21350c, String.valueOf(str.charAt(2)));
            a(C2167j.f21351d, String.valueOf(str.charAt(3)));
        } catch (C2154c e5) {
            throw new C2152a((Exception) e5);
        }
    }

    public int getId() {
        return f21423b;
    }

    public C2187o(String str) {
        e();
        if (str != null && str.length() > 0) {
            d(str);
        }
    }
}
