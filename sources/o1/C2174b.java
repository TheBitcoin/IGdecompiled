package o1;

import java.util.List;
import java.util.Map;
import k1.C2093a;
import m1.C2152a;
import m1.C2154c;

/* renamed from: o1.b  reason: case insensitive filesystem */
public abstract class C2174b implements C2175c {

    /* renamed from: a  reason: collision with root package name */
    protected Map f21379a;

    /* renamed from: b  reason: collision with root package name */
    protected String[][] f21380b;

    public void a(String str, Object obj) {
        if (this.f21379a.containsKey(str)) {
            ((C2093a) this.f21379a.get(str)).d(obj);
            return;
        }
        throw new C2154c(str + " not found");
    }

    public Object c(String str) {
        if (this.f21379a.containsKey(str)) {
            return ((C2093a) this.f21379a.get(str)).c();
        }
        return null;
    }

    public void d(List list) {
        int i4 = 0;
        while (i4 < this.f21380b.length && i4 < list.size()) {
            String str = (String) list.get(i4);
            if (str != null && str.length() > 0) {
                int i5 = 0;
                int i6 = 0;
                while (true) {
                    String[] strArr = this.f21380b[i4];
                    if (i5 >= strArr.length) {
                        continue;
                        break;
                    }
                    String str2 = strArr[i5];
                    if (this.f21379a.containsKey(str2)) {
                        try {
                            C2093a aVar = (C2093a) this.f21379a.get(str2);
                            String e5 = aVar.e(str, i6);
                            aVar.a(e5);
                            i6 += e5.length();
                            i5++;
                        } catch (Exception e6) {
                            throw new C2152a("Unable to decode " + str2, e6);
                        }
                    } else {
                        throw new C2152a("Field not found: '" + str2 + "'");
                    }
                }
            }
            i4++;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0072, code lost:
        r0.add(r3);
        r2 = r2 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List e() {
        /*
            r8 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            r2 = 0
        L_0x0007:
            java.lang.String[][] r3 = r8.f21380b
            int r3 = r3.length
            if (r2 >= r3) goto L_0x0078
            java.lang.String r3 = ""
            r4 = 0
        L_0x000f:
            java.lang.String[][] r5 = r8.f21380b
            r5 = r5[r2]
            int r6 = r5.length
            if (r4 >= r6) goto L_0x0072
            r5 = r5[r4]
            java.util.Map r6 = r8.f21379a
            boolean r6 = r6.containsKey(r5)
            if (r6 == 0) goto L_0x0056
            java.util.Map r6 = r8.f21379a     // Catch:{ Exception -> 0x003e }
            java.lang.Object r6 = r6.get(r5)     // Catch:{ Exception -> 0x003e }
            k1.a r6 = (k1.C2093a) r6     // Catch:{ Exception -> 0x003e }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x003e }
            r7.<init>()     // Catch:{ Exception -> 0x003e }
            r7.append(r3)     // Catch:{ Exception -> 0x003e }
            java.lang.String r3 = r6.b()     // Catch:{ Exception -> 0x003e }
            r7.append(r3)     // Catch:{ Exception -> 0x003e }
            java.lang.String r3 = r7.toString()     // Catch:{ Exception -> 0x003e }
            int r4 = r4 + 1
            goto L_0x000f
        L_0x003e:
            r0 = move-exception
            m1.b r1 = new m1.b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Unable to encode "
            r2.append(r3)
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2, r0)
            throw r1
        L_0x0056:
            m1.b r0 = new m1.b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Field not found: '"
            r1.append(r2)
            r1.append(r5)
            java.lang.String r2 = "'"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x0072:
            r0.add(r3)
            int r2 = r2 + 1
            goto L_0x0007
        L_0x0078:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: o1.C2174b.e():java.util.List");
    }
}
