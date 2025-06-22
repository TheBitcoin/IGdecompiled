package com.google.android.gms.internal.measurement;

import androidx.leanback.preference.LeanbackPreferenceDialogFragment;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.measurement.a5  reason: case insensitive filesystem */
abstract class C0512a5 {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f1749a;

    static {
        char[] cArr = new char[80];
        f1749a = cArr;
        Arrays.fill(cArr, ' ');
    }

    static String a(Z4 z4, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        c(z4, sb, 0);
        return sb.toString();
    }

    private static void b(int i4, StringBuilder sb) {
        int i5;
        while (i4 > 0) {
            char[] cArr = f1749a;
            if (i4 > cArr.length) {
                i5 = cArr.length;
            } else {
                i5 = i4;
            }
            sb.append(cArr, 0, i5);
            i4 -= i5;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0195, code lost:
        if (((java.lang.Boolean) r7).booleanValue() == false) goto L_0x0197;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01a8, code lost:
        if (((java.lang.Integer) r7).intValue() == 0) goto L_0x0197;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01ba, code lost:
        if (java.lang.Float.floatToRawIntBits(((java.lang.Float) r7).floatValue()) == 0) goto L_0x0197;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x01d0, code lost:
        if (java.lang.Double.doubleToRawLongBits(((java.lang.Double) r7).doubleValue()) == 0) goto L_0x0197;
     */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0208  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void c(com.google.android.gms.internal.measurement.Z4 r21, java.lang.StringBuilder r22, int r23) {
        /*
            r0 = r21
            r1 = r22
            r2 = r23
            java.util.HashSet r3 = new java.util.HashSet
            r3.<init>()
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            java.util.TreeMap r5 = new java.util.TreeMap
            r5.<init>()
            java.lang.Class r6 = r0.getClass()
            java.lang.reflect.Method[] r6 = r6.getDeclaredMethods()
            int r7 = r6.length
            r8 = 0
            r9 = 0
        L_0x0020:
            java.lang.String r10 = "get"
            java.lang.String r11 = "has"
            java.lang.String r12 = "set"
            r13 = 3
            if (r9 >= r7) goto L_0x0088
            r14 = r6[r9]
            int r15 = r14.getModifiers()
            boolean r15 = java.lang.reflect.Modifier.isStatic(r15)
            if (r15 != 0) goto L_0x0085
            java.lang.String r15 = r14.getName()
            int r15 = r15.length()
            if (r15 < r13) goto L_0x0085
            java.lang.String r13 = r14.getName()
            boolean r12 = r13.startsWith(r12)
            if (r12 == 0) goto L_0x0051
            java.lang.String r10 = r14.getName()
            r3.add(r10)
            goto L_0x0085
        L_0x0051:
            int r12 = r14.getModifiers()
            boolean r12 = java.lang.reflect.Modifier.isPublic(r12)
            if (r12 == 0) goto L_0x0085
            java.lang.Class[] r12 = r14.getParameterTypes()
            int r12 = r12.length
            if (r12 != 0) goto L_0x0085
            java.lang.String r12 = r14.getName()
            boolean r11 = r12.startsWith(r11)
            if (r11 == 0) goto L_0x0074
            java.lang.String r10 = r14.getName()
            r4.put(r10, r14)
            goto L_0x0085
        L_0x0074:
            java.lang.String r11 = r14.getName()
            boolean r10 = r11.startsWith(r10)
            if (r10 == 0) goto L_0x0085
            java.lang.String r10 = r14.getName()
            r5.put(r10, r14)
        L_0x0085:
            int r9 = r9 + 1
            goto L_0x0020
        L_0x0088:
            java.util.Set r6 = r5.entrySet()
            java.util.Iterator r6 = r6.iterator()
        L_0x0090:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x021d
            java.lang.Object r7 = r6.next()
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7
            java.lang.Object r9 = r7.getKey()
            java.lang.String r9 = (java.lang.String) r9
            java.lang.String r9 = r9.substring(r13)
            java.lang.String r14 = "List"
            boolean r15 = r9.endsWith(r14)
            if (r15 == 0) goto L_0x00e7
            java.lang.String r15 = "OrBuilderList"
            boolean r15 = r9.endsWith(r15)
            if (r15 != 0) goto L_0x00e7
            boolean r14 = r9.equals(r14)
            if (r14 != 0) goto L_0x00e7
            java.lang.Object r14 = r7.getValue()
            java.lang.reflect.Method r14 = (java.lang.reflect.Method) r14
            if (r14 == 0) goto L_0x00e7
            java.lang.Class r15 = r14.getReturnType()
            r16 = 3
            java.lang.Class<java.util.List> r13 = java.util.List.class
            boolean r13 = r15.equals(r13)
            if (r13 == 0) goto L_0x00e9
            int r7 = r9.length()
            int r7 = r7 + -4
            java.lang.String r7 = r9.substring(r8, r7)
            java.lang.Object[] r9 = new java.lang.Object[r8]
            java.lang.Object r9 = com.google.android.gms.internal.measurement.C0668s4.q(r14, r0, r9)
            d(r1, r2, r7, r9)
        L_0x00e5:
            r13 = 3
            goto L_0x0090
        L_0x00e7:
            r16 = 3
        L_0x00e9:
            java.lang.String r13 = "Map"
            boolean r14 = r9.endsWith(r13)
            if (r14 == 0) goto L_0x0131
            boolean r13 = r9.equals(r13)
            if (r13 != 0) goto L_0x0131
            java.lang.Object r13 = r7.getValue()
            java.lang.reflect.Method r13 = (java.lang.reflect.Method) r13
            if (r13 == 0) goto L_0x0131
            java.lang.Class r14 = r13.getReturnType()
            java.lang.Class<java.util.Map> r15 = java.util.Map.class
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x0131
            java.lang.Class<java.lang.Deprecated> r14 = java.lang.Deprecated.class
            boolean r14 = r13.isAnnotationPresent(r14)
            if (r14 != 0) goto L_0x0131
            int r14 = r13.getModifiers()
            boolean r14 = java.lang.reflect.Modifier.isPublic(r14)
            if (r14 == 0) goto L_0x0131
            int r7 = r9.length()
            int r7 = r7 + -3
            java.lang.String r7 = r9.substring(r8, r7)
            java.lang.Object[] r9 = new java.lang.Object[r8]
            java.lang.Object r9 = com.google.android.gms.internal.measurement.C0668s4.q(r13, r0, r9)
            d(r1, r2, r7, r9)
            goto L_0x00e5
        L_0x0131:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r12)
            r13.append(r9)
            java.lang.String r13 = r13.toString()
            boolean r13 = r3.contains(r13)
            if (r13 == 0) goto L_0x00e5
            java.lang.String r13 = "Bytes"
            boolean r13 = r9.endsWith(r13)
            if (r13 == 0) goto L_0x0167
            int r13 = r9.length()
            int r13 = r13 + -5
            java.lang.String r13 = r9.substring(r8, r13)
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>(r10)
            r14.append(r13)
            java.lang.String r13 = r14.toString()
            boolean r13 = r5.containsKey(r13)
            if (r13 != 0) goto L_0x00e5
        L_0x0167:
            java.lang.Object r7 = r7.getValue()
            java.lang.reflect.Method r7 = (java.lang.reflect.Method) r7
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r11)
            r13.append(r9)
            java.lang.String r13 = r13.toString()
            java.lang.Object r13 = r4.get(r13)
            java.lang.reflect.Method r13 = (java.lang.reflect.Method) r13
            if (r7 == 0) goto L_0x00e5
            java.lang.Object[] r14 = new java.lang.Object[r8]
            java.lang.Object r7 = com.google.android.gms.internal.measurement.C0668s4.q(r7, r0, r14)
            if (r13 != 0) goto L_0x020a
            boolean r13 = r7 instanceof java.lang.Boolean
            r14 = 1
            if (r13 == 0) goto L_0x019d
            r13 = r7
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r13 != 0) goto L_0x019a
        L_0x0197:
            r13 = 1
            goto L_0x0205
        L_0x019a:
            r13 = 0
            goto L_0x0205
        L_0x019d:
            boolean r13 = r7 instanceof java.lang.Integer
            if (r13 == 0) goto L_0x01ab
            r13 = r7
            java.lang.Integer r13 = (java.lang.Integer) r13
            int r13 = r13.intValue()
            if (r13 != 0) goto L_0x019a
            goto L_0x0197
        L_0x01ab:
            boolean r13 = r7 instanceof java.lang.Float
            if (r13 == 0) goto L_0x01bd
            r13 = r7
            java.lang.Float r13 = (java.lang.Float) r13
            float r13 = r13.floatValue()
            int r13 = java.lang.Float.floatToRawIntBits(r13)
            if (r13 != 0) goto L_0x019a
            goto L_0x0197
        L_0x01bd:
            boolean r13 = r7 instanceof java.lang.Double
            if (r13 == 0) goto L_0x01d3
            r13 = r7
            java.lang.Double r13 = (java.lang.Double) r13
            double r17 = r13.doubleValue()
            long r17 = java.lang.Double.doubleToRawLongBits(r17)
            r19 = 0
            int r13 = (r17 > r19 ? 1 : (r17 == r19 ? 0 : -1))
            if (r13 != 0) goto L_0x019a
            goto L_0x0197
        L_0x01d3:
            boolean r13 = r7 instanceof java.lang.String
            if (r13 == 0) goto L_0x01de
            java.lang.String r13 = ""
            boolean r13 = r7.equals(r13)
            goto L_0x0205
        L_0x01de:
            boolean r13 = r7 instanceof com.google.android.gms.internal.measurement.K3
            if (r13 == 0) goto L_0x01e9
            com.google.android.gms.internal.measurement.K3 r13 = com.google.android.gms.internal.measurement.K3.f1515b
            boolean r13 = r7.equals(r13)
            goto L_0x0205
        L_0x01e9:
            boolean r13 = r7 instanceof com.google.android.gms.internal.measurement.Z4
            if (r13 == 0) goto L_0x01f7
            r13 = r7
            com.google.android.gms.internal.measurement.Z4 r13 = (com.google.android.gms.internal.measurement.Z4) r13
            com.google.android.gms.internal.measurement.Z4 r13 = r13.b()
            if (r7 != r13) goto L_0x019a
            goto L_0x0197
        L_0x01f7:
            boolean r13 = r7 instanceof java.lang.Enum
            if (r13 == 0) goto L_0x019a
            r13 = r7
            java.lang.Enum r13 = (java.lang.Enum) r13
            int r13 = r13.ordinal()
            if (r13 != 0) goto L_0x019a
            goto L_0x0197
        L_0x0205:
            if (r13 != 0) goto L_0x0208
            goto L_0x0216
        L_0x0208:
            r14 = 0
            goto L_0x0216
        L_0x020a:
            java.lang.Object[] r14 = new java.lang.Object[r8]
            java.lang.Object r13 = com.google.android.gms.internal.measurement.C0668s4.q(r13, r0, r14)
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r14 = r13.booleanValue()
        L_0x0216:
            if (r14 == 0) goto L_0x00e5
            d(r1, r2, r9, r7)
            goto L_0x00e5
        L_0x021d:
            com.google.android.gms.internal.measurement.s4 r0 = (com.google.android.gms.internal.measurement.C0668s4) r0
            com.google.android.gms.internal.measurement.D5 r0 = r0.zzb
            if (r0 == 0) goto L_0x0226
            r0.h(r1, r2)
        L_0x0226:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.C0512a5.c(com.google.android.gms.internal.measurement.Z4, java.lang.StringBuilder, int):void");
    }

    static void d(StringBuilder sb, int i4, String str, Object obj) {
        if (obj instanceof List) {
            for (Object d5 : (List) obj) {
                d(sb, i4, str, d5);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry d6 : ((Map) obj).entrySet()) {
                d(sb, i4, str, d6);
            }
        } else {
            sb.append(10);
            b(i4, sb);
            if (!str.isEmpty()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(Character.toLowerCase(str.charAt(0)));
                for (int i5 = 1; i5 < str.length(); i5++) {
                    char charAt = str.charAt(i5);
                    if (Character.isUpperCase(charAt)) {
                        sb2.append("_");
                    }
                    sb2.append(Character.toLowerCase(charAt));
                }
                str = sb2.toString();
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                sb.append(A5.a(K3.l((String) obj)));
                sb.append('\"');
            } else if (obj instanceof K3) {
                sb.append(": \"");
                sb.append(A5.a((K3) obj));
                sb.append('\"');
            } else if (obj instanceof C0668s4) {
                sb.append(" {");
                c((C0668s4) obj, sb, i4 + 2);
                sb.append("\n");
                b(i4, sb);
                sb.append("}");
            } else if (obj instanceof Map.Entry) {
                sb.append(" {");
                Map.Entry entry = (Map.Entry) obj;
                int i6 = i4 + 2;
                d(sb, i6, LeanbackPreferenceDialogFragment.ARG_KEY, entry.getKey());
                d(sb, i6, "value", entry.getValue());
                sb.append("\n");
                b(i4, sb);
                sb.append("}");
            } else {
                sb.append(": ");
                sb.append(obj);
            }
        }
    }
}
