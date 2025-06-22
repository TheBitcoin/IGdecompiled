package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import f0.p;
import java.util.EnumMap;
import java.util.Map;

public final class A3 {

    /* renamed from: c  reason: collision with root package name */
    public static final A3 f2299c = new A3((Boolean) null, (Boolean) null, 100);

    /* renamed from: a  reason: collision with root package name */
    private final EnumMap f2300a;

    /* renamed from: b  reason: collision with root package name */
    private final int f2301b;

    public enum a {
        AD_STORAGE("ad_storage"),
        ANALYTICS_STORAGE("analytics_storage"),
        AD_USER_DATA("ad_user_data"),
        AD_PERSONALIZATION("ad_personalization");
        

        /* renamed from: a  reason: collision with root package name */
        public final String f2307a;

        private a(String str) {
            this.f2307a = str;
        }
    }

    private A3(EnumMap enumMap, int i4) {
        EnumMap enumMap2 = new EnumMap(a.class);
        this.f2300a = enumMap2;
        enumMap2.putAll(enumMap);
        this.f2301b = i4;
    }

    static char a(p pVar) {
        if (pVar == null) {
            return '-';
        }
        int ordinal = pVar.ordinal();
        if (ordinal == 1) {
            return '+';
        }
        if (ordinal == 2) {
            return '0';
        }
        if (ordinal != 3) {
            return '-';
        }
        return '1';
    }

    public static A3 c(Bundle bundle, int i4) {
        if (bundle == null) {
            return new A3((Boolean) null, (Boolean) null, i4);
        }
        EnumMap enumMap = new EnumMap(a.class);
        for (a aVar : B3.STORAGE.f2330a) {
            enumMap.put(aVar, i(bundle.getString(aVar.f2307a)));
        }
        return new A3(enumMap, i4);
    }

    public static A3 e(p pVar, p pVar2, int i4) {
        EnumMap enumMap = new EnumMap(a.class);
        enumMap.put(a.AD_STORAGE, pVar);
        enumMap.put(a.ANALYTICS_STORAGE, pVar2);
        return new A3(enumMap, -10);
    }

    public static A3 f(String str, int i4) {
        EnumMap enumMap = new EnumMap(a.class);
        if (str == null) {
            str = "";
        }
        a[] a5 = B3.STORAGE.a();
        for (int i5 = 0; i5 < a5.length; i5++) {
            a aVar = a5[i5];
            int i6 = i5 + 2;
            if (i6 < str.length()) {
                enumMap.put(aVar, g(str.charAt(i6)));
            } else {
                enumMap.put(aVar, p.UNINITIALIZED);
            }
        }
        return new A3(enumMap, i4);
    }

    static p g(char c5) {
        if (c5 == '+') {
            return p.POLICY;
        }
        if (c5 == '0') {
            return p.DENIED;
        }
        if (c5 != '1') {
            return p.UNINITIALIZED;
        }
        return p.GRANTED;
    }

    static p h(Boolean bool) {
        if (bool == null) {
            return p.UNINITIALIZED;
        }
        if (bool.booleanValue()) {
            return p.GRANTED;
        }
        return p.DENIED;
    }

    static p i(String str) {
        if (str == null) {
            return p.UNINITIALIZED;
        }
        if (str.equals("granted")) {
            return p.GRANTED;
        }
        if (str.equals("denied")) {
            return p.DENIED;
        }
        return p.UNINITIALIZED;
    }

    static String j(int i4) {
        if (i4 == -30) {
            return "TCF";
        }
        if (i4 == -20) {
            return "API";
        }
        if (i4 == -10) {
            return "MANIFEST";
        }
        if (i4 == 0) {
            return "1P_API";
        }
        if (i4 == 30) {
            return "1P_INIT";
        }
        if (i4 == 90) {
            return "REMOTE_CONFIG";
        }
        if (i4 != 100) {
            return "OTHER";
        }
        return "UNKNOWN";
    }

    public static String k(Bundle bundle) {
        String string;
        a[] b5 = B3.STORAGE.f2330a;
        int length = b5.length;
        int i4 = 0;
        while (true) {
            Boolean bool = null;
            if (i4 >= length) {
                return null;
            }
            a aVar = b5[i4];
            if (bundle.containsKey(aVar.f2307a) && (string = bundle.getString(aVar.f2307a)) != null) {
                if (string.equals("granted")) {
                    bool = Boolean.TRUE;
                } else if (string.equals("denied")) {
                    bool = Boolean.FALSE;
                }
                if (bool == null) {
                    return string;
                }
            }
            i4++;
        }
    }

    public static boolean l(int i4, int i5) {
        if (i4 == -20 && i5 == -30) {
            return true;
        }
        return (i4 == -30 && i5 == -20) || i4 == i5 || i4 < i5;
    }

    public static A3 q(String str) {
        return f(str, 100);
    }

    static String r(p pVar) {
        int ordinal = pVar.ordinal();
        if (ordinal == 2) {
            return "denied";
        }
        if (ordinal != 3) {
            return null;
        }
        return "granted";
    }

    public final boolean A() {
        for (p pVar : this.f2300a.values()) {
            if (pVar != p.UNINITIALIZED) {
                return true;
            }
        }
        return false;
    }

    public final int b() {
        return this.f2301b;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.A3 d(com.google.android.gms.measurement.internal.A3 r9) {
        /*
            r8 = this;
            java.util.EnumMap r0 = new java.util.EnumMap
            java.lang.Class<com.google.android.gms.measurement.internal.A3$a> r1 = com.google.android.gms.measurement.internal.A3.a.class
            r0.<init>(r1)
            com.google.android.gms.measurement.internal.B3 r1 = com.google.android.gms.measurement.internal.B3.STORAGE
            com.google.android.gms.measurement.internal.A3$a[] r1 = r1.f2330a
            int r2 = r1.length
            r3 = 0
        L_0x000f:
            if (r3 >= r2) goto L_0x004d
            r4 = r1[r3]
            java.util.EnumMap r5 = r8.f2300a
            java.lang.Object r5 = r5.get(r4)
            f0.p r5 = (f0.p) r5
            java.util.EnumMap r6 = r9.f2300a
            java.lang.Object r6 = r6.get(r4)
            f0.p r6 = (f0.p) r6
            if (r5 != 0) goto L_0x0026
            goto L_0x0035
        L_0x0026:
            if (r6 != 0) goto L_0x0029
            goto L_0x0045
        L_0x0029:
            f0.p r7 = f0.p.UNINITIALIZED
            if (r5 != r7) goto L_0x002e
            goto L_0x0035
        L_0x002e:
            if (r6 != r7) goto L_0x0031
            goto L_0x0045
        L_0x0031:
            f0.p r7 = f0.p.POLICY
            if (r5 != r7) goto L_0x0037
        L_0x0035:
            r5 = r6
            goto L_0x0045
        L_0x0037:
            if (r6 != r7) goto L_0x003a
            goto L_0x0045
        L_0x003a:
            f0.p r7 = f0.p.DENIED
            if (r5 == r7) goto L_0x0044
            if (r6 != r7) goto L_0x0041
            goto L_0x0044
        L_0x0041:
            f0.p r5 = f0.p.GRANTED
            goto L_0x0045
        L_0x0044:
            r5 = r7
        L_0x0045:
            if (r5 == 0) goto L_0x004a
            r0.put(r4, r5)
        L_0x004a:
            int r3 = r3 + 1
            goto L_0x000f
        L_0x004d:
            com.google.android.gms.measurement.internal.A3 r9 = new com.google.android.gms.measurement.internal.A3
            r1 = 100
            r9.<init>(r0, r1)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.A3.d(com.google.android.gms.measurement.internal.A3):com.google.android.gms.measurement.internal.A3");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof A3)) {
            return false;
        }
        A3 a32 = (A3) obj;
        for (a aVar : B3.STORAGE.f2330a) {
            if (this.f2300a.get(aVar) != a32.f2300a.get(aVar)) {
                return false;
            }
        }
        if (this.f2301b == a32.f2301b) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i4 = this.f2301b * 17;
        for (p hashCode : this.f2300a.values()) {
            i4 = (i4 * 31) + hashCode.hashCode();
        }
        return i4;
    }

    public final boolean m(a aVar) {
        if (((p) this.f2300a.get(aVar)) == p.DENIED) {
            return false;
        }
        return true;
    }

    public final boolean n(A3 a32, a... aVarArr) {
        for (a aVar : aVarArr) {
            if (!a32.m(aVar) && m(aVar)) {
                return true;
            }
        }
        return false;
    }

    public final Bundle o() {
        Bundle bundle = new Bundle();
        for (Map.Entry entry : this.f2300a.entrySet()) {
            String r4 = r((p) entry.getValue());
            if (r4 != null) {
                bundle.putString(((a) entry.getKey()).f2307a, r4);
            }
        }
        return bundle;
    }

    public final A3 p(A3 a32) {
        EnumMap enumMap = new EnumMap(a.class);
        for (a aVar : B3.STORAGE.f2330a) {
            p pVar = (p) this.f2300a.get(aVar);
            if (pVar == p.UNINITIALIZED) {
                pVar = (p) a32.f2300a.get(aVar);
            }
            if (pVar != null) {
                enumMap.put(aVar, pVar);
            }
        }
        return new A3(enumMap, this.f2301b);
    }

    public final boolean s(A3 a32, a... aVarArr) {
        for (a aVar : aVarArr) {
            p pVar = (p) this.f2300a.get(aVar);
            p pVar2 = (p) a32.f2300a.get(aVar);
            p pVar3 = p.DENIED;
            if (pVar == pVar3 && pVar2 != pVar3) {
                return true;
            }
        }
        return false;
    }

    public final p t() {
        p pVar = (p) this.f2300a.get(a.AD_STORAGE);
        if (pVar == null) {
            return p.UNINITIALIZED;
        }
        return pVar;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("source=");
        sb.append(j(this.f2301b));
        for (a aVar : B3.STORAGE.f2330a) {
            sb.append(",");
            sb.append(aVar.f2307a);
            sb.append("=");
            p pVar = (p) this.f2300a.get(aVar);
            if (pVar == null) {
                pVar = p.UNINITIALIZED;
            }
            sb.append(pVar);
        }
        return sb.toString();
    }

    public final boolean u(A3 a32) {
        return s(a32, (a[]) this.f2300a.keySet().toArray(new a[0]));
    }

    public final p v() {
        p pVar = (p) this.f2300a.get(a.ANALYTICS_STORAGE);
        if (pVar == null) {
            return p.UNINITIALIZED;
        }
        return pVar;
    }

    public final String w() {
        int ordinal;
        StringBuilder sb = new StringBuilder("G1");
        for (a aVar : B3.STORAGE.a()) {
            p pVar = (p) this.f2300a.get(aVar);
            char c5 = '-';
            if (!(pVar == null || (ordinal = pVar.ordinal()) == 0)) {
                if (ordinal != 1) {
                    if (ordinal == 2) {
                        c5 = '0';
                    } else if (ordinal != 3) {
                    }
                }
                c5 = '1';
            }
            sb.append(c5);
        }
        return sb.toString();
    }

    public final String x() {
        StringBuilder sb = new StringBuilder("G1");
        for (a aVar : B3.STORAGE.a()) {
            sb.append(a((p) this.f2300a.get(aVar)));
        }
        return sb.toString();
    }

    public final boolean y() {
        return m(a.AD_STORAGE);
    }

    public final boolean z() {
        return m(a.ANALYTICS_STORAGE);
    }

    public A3(Boolean bool, Boolean bool2, int i4) {
        EnumMap enumMap = new EnumMap(a.class);
        this.f2300a = enumMap;
        enumMap.put(a.AD_STORAGE, h((Boolean) null));
        enumMap.put(a.ANALYTICS_STORAGE, h((Boolean) null));
        this.f2301b = i4;
    }
}
