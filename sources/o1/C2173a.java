package o1;

import java.util.Map;
import k1.C2093a;
import m1.C2152a;
import m1.C2153b;
import m1.C2154c;

/* renamed from: o1.a  reason: case insensitive filesystem */
public abstract class C2173a implements C2175c {

    /* renamed from: a  reason: collision with root package name */
    protected Map f21377a;

    /* renamed from: b  reason: collision with root package name */
    protected String[] f21378b;

    public void a(String str, Object obj) {
        if (this.f21377a.containsKey(str)) {
            ((C2093a) this.f21377a.get(str)).d(obj);
            return;
        }
        throw new C2154c(str + " not found");
    }

    public Object c(String str) {
        if (this.f21377a.containsKey(str)) {
            return ((C2093a) this.f21377a.get(str)).c();
        }
        return null;
    }

    public void d(String str) {
        int i4 = 0;
        int i5 = 0;
        while (true) {
            String[] strArr = this.f21378b;
            if (i4 < strArr.length) {
                String str2 = strArr[i4];
                if (this.f21377a.containsKey(str2)) {
                    C2093a aVar = (C2093a) this.f21377a.get(str2);
                    String e5 = aVar.e(str, i5);
                    aVar.a(e5);
                    i5 += e5.length();
                    i4++;
                } else {
                    throw new C2152a("Field not found: '" + str2 + "'");
                }
            } else {
                return;
            }
        }
    }

    public String e() {
        String str = "";
        int i4 = 0;
        while (true) {
            String[] strArr = this.f21378b;
            if (i4 >= strArr.length) {
                return str;
            }
            String str2 = strArr[i4];
            if (this.f21377a.containsKey(str2)) {
                str = str + ((C2093a) this.f21377a.get(str2)).b();
                i4++;
            } else {
                throw new C2153b("Field not found: '" + str2 + "'");
            }
        }
    }
}
