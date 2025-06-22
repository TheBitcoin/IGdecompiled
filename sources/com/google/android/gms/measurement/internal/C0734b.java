package com.google.android.gms.measurement.internal;

import M.C0335p;
import com.google.android.gms.internal.measurement.L1;
import com.google.android.gms.internal.measurement.N1;
import j$.util.DesugarCollections;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* renamed from: com.google.android.gms.measurement.internal.b  reason: case insensitive filesystem */
abstract class C0734b {

    /* renamed from: a  reason: collision with root package name */
    String f2859a;

    /* renamed from: b  reason: collision with root package name */
    int f2860b;

    /* renamed from: c  reason: collision with root package name */
    Boolean f2861c;

    /* renamed from: d  reason: collision with root package name */
    Boolean f2862d;

    /* renamed from: e  reason: collision with root package name */
    Long f2863e;

    /* renamed from: f  reason: collision with root package name */
    Long f2864f;

    C0734b(String str, int i4) {
        this.f2859a = str;
        this.f2860b = i4;
    }

    static Boolean b(double d5, L1 l12) {
        try {
            return h(new BigDecimal(d5), l12, Math.ulp(d5));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    static Boolean c(long j4, L1 l12) {
        try {
            return h(new BigDecimal(j4), l12, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    static Boolean d(Boolean bool, boolean z4) {
        boolean z5;
        if (bool == null) {
            return null;
        }
        if (bool.booleanValue() != z4) {
            z5 = true;
        } else {
            z5 = false;
        }
        return Boolean.valueOf(z5);
    }

    static Boolean e(String str, L1 l12) {
        if (!Z5.g0(str)) {
            return null;
        }
        try {
            return h(new BigDecimal(str), l12, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private static Boolean f(String str, N1.b bVar, boolean z4, String str2, List list, String str3, C0821n2 n2Var) {
        int i4;
        if (str == null) {
            return null;
        }
        if (bVar == N1.b.IN_LIST) {
            if (list == null || list.isEmpty()) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z4 && bVar != N1.b.REGEXP) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (k6.f3089a[bVar.ordinal()]) {
            case 1:
                if (str3 == null) {
                    return null;
                }
                if (z4) {
                    i4 = 0;
                } else {
                    i4 = 66;
                }
                try {
                    return Boolean.valueOf(Pattern.compile(str3, i4).matcher(str).matches());
                } catch (PatternSyntaxException unused) {
                    if (n2Var != null) {
                        n2Var.L().b("Invalid regular expression in REGEXP audience filter. expression", str3);
                    }
                    return null;
                }
            case 2:
                return Boolean.valueOf(str.startsWith(str2));
            case 3:
                return Boolean.valueOf(str.endsWith(str2));
            case 4:
                return Boolean.valueOf(str.contains(str2));
            case 5:
                return Boolean.valueOf(str.equals(str2));
            case 6:
                if (list == null) {
                    return null;
                }
                return Boolean.valueOf(list.contains(str));
            default:
                return null;
        }
    }

    static Boolean g(String str, N1 n12, C0821n2 n2Var) {
        String J4;
        List list;
        String str2;
        C0335p.l(n12);
        if (str == null || !n12.O() || n12.G() == N1.b.UNKNOWN_MATCH_TYPE) {
            return null;
        }
        N1.b G4 = n12.G();
        N1.b bVar = N1.b.IN_LIST;
        if (G4 == bVar) {
            if (n12.j() == 0) {
                return null;
            }
        } else if (!n12.N()) {
            return null;
        }
        N1.b G5 = n12.G();
        boolean L4 = n12.L();
        if (L4 || G5 == N1.b.REGEXP || G5 == bVar) {
            J4 = n12.J();
        } else {
            J4 = n12.J().toUpperCase(Locale.ENGLISH);
        }
        String str3 = J4;
        if (n12.j() == 0) {
            list = null;
        } else {
            List<String> K4 = n12.K();
            if (!L4) {
                ArrayList arrayList = new ArrayList(K4.size());
                for (String upperCase : K4) {
                    arrayList.add(upperCase.toUpperCase(Locale.ENGLISH));
                }
                K4 = DesugarCollections.unmodifiableList(arrayList);
            }
            list = K4;
        }
        if (G5 == N1.b.REGEXP) {
            str2 = str3;
        } else {
            str2 = null;
        }
        return f(str, G5, L4, str3, list, str2, n2Var);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0080, code lost:
        if (r3 != null) goto L_0x0082;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Boolean h(java.math.BigDecimal r8, com.google.android.gms.internal.measurement.L1 r9, double r10) {
        /*
            M.C0335p.l(r9)
            boolean r0 = r9.N()
            r1 = 0
            if (r0 == 0) goto L_0x0114
            com.google.android.gms.internal.measurement.L1$b r0 = r9.G()
            com.google.android.gms.internal.measurement.L1$b r2 = com.google.android.gms.internal.measurement.L1.b.UNKNOWN_COMPARISON_TYPE
            if (r0 != r2) goto L_0x0014
            goto L_0x0114
        L_0x0014:
            com.google.android.gms.internal.measurement.L1$b r0 = r9.G()
            com.google.android.gms.internal.measurement.L1$b r2 = com.google.android.gms.internal.measurement.L1.b.BETWEEN
            if (r0 != r2) goto L_0x0029
            boolean r0 = r9.R()
            if (r0 == 0) goto L_0x0028
            boolean r0 = r9.Q()
            if (r0 != 0) goto L_0x0030
        L_0x0028:
            return r1
        L_0x0029:
            boolean r0 = r9.O()
            if (r0 != 0) goto L_0x0030
            return r1
        L_0x0030:
            com.google.android.gms.internal.measurement.L1$b r0 = r9.G()
            com.google.android.gms.internal.measurement.L1$b r3 = r9.G()
            if (r3 != r2) goto L_0x0065
            java.lang.String r3 = r9.L()
            boolean r3 = com.google.android.gms.measurement.internal.Z5.g0(r3)
            if (r3 == 0) goto L_0x0064
            java.lang.String r3 = r9.K()
            boolean r3 = com.google.android.gms.measurement.internal.Z5.g0(r3)
            if (r3 != 0) goto L_0x004f
            goto L_0x0064
        L_0x004f:
            java.math.BigDecimal r3 = new java.math.BigDecimal     // Catch:{ NumberFormatException -> 0x0064 }
            java.lang.String r4 = r9.L()     // Catch:{ NumberFormatException -> 0x0064 }
            r3.<init>(r4)     // Catch:{ NumberFormatException -> 0x0064 }
            java.math.BigDecimal r4 = new java.math.BigDecimal     // Catch:{ NumberFormatException -> 0x0064 }
            java.lang.String r9 = r9.K()     // Catch:{ NumberFormatException -> 0x0064 }
            r4.<init>(r9)     // Catch:{ NumberFormatException -> 0x0064 }
            r9 = r3
            r3 = r1
            goto L_0x007b
        L_0x0064:
            return r1
        L_0x0065:
            java.lang.String r3 = r9.J()
            boolean r3 = com.google.android.gms.measurement.internal.Z5.g0(r3)
            if (r3 != 0) goto L_0x0070
            return r1
        L_0x0070:
            java.math.BigDecimal r3 = new java.math.BigDecimal     // Catch:{ NumberFormatException -> 0x0114 }
            java.lang.String r9 = r9.J()     // Catch:{ NumberFormatException -> 0x0114 }
            r3.<init>(r9)     // Catch:{ NumberFormatException -> 0x0114 }
            r9 = r1
            r4 = r9
        L_0x007b:
            if (r0 != r2) goto L_0x0080
            if (r9 != 0) goto L_0x0082
            return r1
        L_0x0080:
            if (r3 == 0) goto L_0x0114
        L_0x0082:
            int[] r2 = com.google.android.gms.measurement.internal.k6.f3090b
            int r0 = r0.ordinal()
            r0 = r2[r0]
            r2 = 0
            r5 = 1
            if (r0 == r5) goto L_0x0106
            r6 = 2
            if (r0 == r6) goto L_0x00f8
            r7 = 3
            if (r0 == r7) goto L_0x00ae
            r10 = 4
            if (r0 == r10) goto L_0x0099
            goto L_0x0114
        L_0x0099:
            if (r9 != 0) goto L_0x009c
            return r1
        L_0x009c:
            int r9 = r8.compareTo(r9)
            if (r9 < 0) goto L_0x00a9
            int r8 = r8.compareTo(r4)
            if (r8 > 0) goto L_0x00a9
            r2 = 1
        L_0x00a9:
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r2)
            return r8
        L_0x00ae:
            if (r3 == 0) goto L_0x0114
            r0 = 0
            int r9 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r9 == 0) goto L_0x00ec
            java.math.BigDecimal r9 = new java.math.BigDecimal
            r9.<init>(r10)
            java.math.BigDecimal r0 = new java.math.BigDecimal
            r0.<init>(r6)
            java.math.BigDecimal r9 = r9.multiply(r0)
            java.math.BigDecimal r9 = r3.subtract(r9)
            int r9 = r8.compareTo(r9)
            if (r9 <= 0) goto L_0x00e7
            java.math.BigDecimal r9 = new java.math.BigDecimal
            r9.<init>(r10)
            java.math.BigDecimal r10 = new java.math.BigDecimal
            r10.<init>(r6)
            java.math.BigDecimal r9 = r9.multiply(r10)
            java.math.BigDecimal r9 = r3.add(r9)
            int r8 = r8.compareTo(r9)
            if (r8 >= 0) goto L_0x00e7
            r2 = 1
        L_0x00e7:
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r2)
            return r8
        L_0x00ec:
            int r8 = r8.compareTo(r3)
            if (r8 != 0) goto L_0x00f3
            r2 = 1
        L_0x00f3:
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r2)
            return r8
        L_0x00f8:
            if (r3 == 0) goto L_0x0114
            int r8 = r8.compareTo(r3)
            if (r8 <= 0) goto L_0x0101
            r2 = 1
        L_0x0101:
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r2)
            return r8
        L_0x0106:
            if (r3 == 0) goto L_0x0114
            int r8 = r8.compareTo(r3)
            if (r8 >= 0) goto L_0x010f
            r2 = 1
        L_0x010f:
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r2)
            return r8
        L_0x0114:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C0734b.h(java.math.BigDecimal, com.google.android.gms.internal.measurement.L1, double):java.lang.Boolean");
    }

    /* access modifiers changed from: package-private */
    public abstract int a();

    /* access modifiers changed from: package-private */
    public abstract boolean i();

    /* access modifiers changed from: package-private */
    public abstract boolean j();
}
