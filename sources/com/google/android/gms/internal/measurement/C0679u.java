package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* renamed from: com.google.android.gms.internal.measurement.u  reason: case insensitive filesystem */
public final class C0679u implements C0663s, Iterable {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final String f2190a;

    public C0679u(String str) {
        if (str != null) {
            this.f2190a = str;
            return;
        }
        throw new IllegalArgumentException("StringValue cannot be null.");
    }

    public final Boolean C() {
        return Boolean.valueOf(!this.f2190a.isEmpty());
    }

    public final Double D() {
        if (this.f2190a.isEmpty()) {
            return Double.valueOf(0.0d);
        }
        try {
            return Double.valueOf(this.f2190a);
        } catch (NumberFormatException unused) {
            return Double.valueOf(Double.NaN);
        }
    }

    public final String E() {
        return this.f2190a;
    }

    public final Iterator F() {
        return new C0703x(this);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01bd, code lost:
        r2 = com.google.android.gms.internal.measurement.C0663s.f2138b0.E();
        r5 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01c6, code lost:
        r5 = r27;
        r2 = r5.b((com.google.android.gms.internal.measurement.C0663s) r1.get(0)).E();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x01dc, code lost:
        if (r1.size() >= 2) goto L_0x01e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01de, code lost:
        r14 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01e1, code lost:
        r14 = r5.b((com.google.android.gms.internal.measurement.C0663s) r1.get(1)).D().doubleValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0207, code lost:
        return new com.google.android.gms.internal.measurement.C0596k(java.lang.Double.valueOf((double) r0.indexOf(r2, (int) com.google.android.gms.internal.measurement.C0690v2.a(r14))));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0208, code lost:
        r3 = r25;
        r5 = r27;
        r1 = r28;
        com.google.android.gms.internal.measurement.C0690v2.n("replace", 2, r1);
        r0 = com.google.android.gms.internal.measurement.C0663s.f2138b0;
        r2 = r0.E();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x021c, code lost:
        if (r1.isEmpty() != false) goto L_0x023e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x021e, code lost:
        r2 = r5.b((com.google.android.gms.internal.measurement.C0663s) r1.get(0)).E();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0232, code lost:
        if (r1.size() <= 1) goto L_0x023e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0234, code lost:
        r0 = r5.b((com.google.android.gms.internal.measurement.C0663s) r1.get(1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x023e, code lost:
        r1 = r3.f2190a;
        r4 = r1.indexOf(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0244, code lost:
        if (r4 >= 0) goto L_0x0248;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x024a, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.C0623n) == false) goto L_0x0274;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x024c, code lost:
        r9 = 0;
        r0 = ((com.google.android.gms.internal.measurement.C0623n) r0).a(r5, java.util.Arrays.asList(new com.google.android.gms.internal.measurement.C0663s[]{new com.google.android.gms.internal.measurement.C0679u(r2), new com.google.android.gms.internal.measurement.C0596k(java.lang.Double.valueOf((double) r4)), r3}));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0274, code lost:
        r9 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x029d, code lost:
        return new com.google.android.gms.internal.measurement.C0679u(r1.substring(r9, r4) + r0.E() + r1.substring(r4 + r2.length()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x029e, code lost:
        r5 = r27;
        r1 = r28;
        com.google.android.gms.internal.measurement.C0690v2.n("substring", 2, r1);
        r0 = r25.f2190a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x02ae, code lost:
        if (r1.isEmpty() != false) goto L_0x02c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x02b0, code lost:
        r2 = (int) com.google.android.gms.internal.measurement.C0690v2.a(r5.b((com.google.android.gms.internal.measurement.C0663s) r1.get(0)).D().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x02c9, code lost:
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x02cf, code lost:
        if (r1.size() <= 1) goto L_0x02ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x02d1, code lost:
        r1 = (int) com.google.android.gms.internal.measurement.C0690v2.a(r5.b((com.google.android.gms.internal.measurement.C0663s) r1.get(1)).D().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x02ea, code lost:
        r1 = r0.length();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x02ef, code lost:
        r2 = java.lang.Math.min(java.lang.Math.max(r2, 0), r0.length());
        r1 = java.lang.Math.min(java.lang.Math.max(r1, 0), r0.length());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0318, code lost:
        return new com.google.android.gms.internal.measurement.C0679u(r0.substring(java.lang.Math.min(r2, r1), java.lang.Math.max(r2, r1)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0319, code lost:
        r3 = r25;
        r5 = r27;
        r1 = r28;
        com.google.android.gms.internal.measurement.C0690v2.n("split", 2, r1);
        r0 = r3.f2190a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0329, code lost:
        if (r0.length() != 0) goto L_0x0337;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0336, code lost:
        return new com.google.android.gms.internal.measurement.C0560g(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0337, code lost:
        r4 = new java.util.ArrayList();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x0341, code lost:
        if (r1.isEmpty() == false) goto L_0x0348;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0343, code lost:
        r4.add(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0348, code lost:
        r2 = r5.b((com.google.android.gms.internal.measurement.C0663s) r1.get(0)).E();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x035b, code lost:
        if (r1.size() <= 1) goto L_0x0374;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x035d, code lost:
        r5 = com.google.android.gms.internal.measurement.C0690v2.m(r5.b((com.google.android.gms.internal.measurement.C0663s) r1.get(1)).D().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0374, code lost:
        r5 = 2147483647L;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x037b, code lost:
        if (r5 != 0) goto L_0x0383;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0382, code lost:
        return new com.google.android.gms.internal.measurement.C0560g();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0383, code lost:
        r0 = r0.split(java.util.regex.Pattern.quote(r2), ((int) r5) + 1);
        r1 = r0.length;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0395, code lost:
        if (r2.isEmpty() == false) goto L_0x03b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0398, code lost:
        if (r0.length <= 0) goto L_0x03b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x039a, code lost:
        r9 = r0[0].isEmpty();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x03ab, code lost:
        if (r0[r0.length - 1].isEmpty() == false) goto L_0x03b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x03ad, code lost:
        r1 = r0.length - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x03b1, code lost:
        r9 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x03b6, code lost:
        if (((long) r0.length) <= r5) goto L_0x03ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x03b8, code lost:
        r1 = r1 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x03ba, code lost:
        if (r9 >= r1) goto L_0x03cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x03bc, code lost:
        r4.add(new com.google.android.gms.internal.measurement.C0679u(r0[r9]));
        r9 = r9 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x03d0, code lost:
        return new com.google.android.gms.internal.measurement.C0560g((java.util.List) r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x03d1, code lost:
        r5 = r27;
        r1 = r28;
        com.google.android.gms.internal.measurement.C0690v2.n("slice", 2, r1);
        r0 = r25.f2190a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x03e1, code lost:
        if (r1.isEmpty() != false) goto L_0x03f7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x03e3, code lost:
        r6 = r5.b((com.google.android.gms.internal.measurement.C0663s) r1.get(0)).D().doubleValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x03f7, code lost:
        r6 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x03f9, code lost:
        r6 = com.google.android.gms.internal.measurement.C0690v2.a(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x03ff, code lost:
        if (r6 >= r23) goto L_0x040e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x0401, code lost:
        r8 = java.lang.Math.max(((double) r0.length()) + r6, r23);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x040e, code lost:
        r8 = java.lang.Math.min(r6, (double) r0.length());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x0417, code lost:
        r2 = (int) r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x041d, code lost:
        if (r1.size() <= 1) goto L_0x0432;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x041f, code lost:
        r4 = r5.b((com.google.android.gms.internal.measurement.C0663s) r1.get(1)).D().doubleValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x0432, code lost:
        r4 = (double) r0.length();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x0437, code lost:
        r4 = com.google.android.gms.internal.measurement.C0690v2.a(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x043f, code lost:
        if (r4 >= 0.0d) goto L_0x044c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x0441, code lost:
        r4 = java.lang.Math.max(((double) r0.length()) + r4, 0.0d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x044c, code lost:
        r4 = java.lang.Math.min(r4, (double) r0.length());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x0466, code lost:
        return new com.google.android.gms.internal.measurement.C0679u(r0.substring(r2, java.lang.Math.max(0, ((int) r4) - r2) + r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x0467, code lost:
        r5 = r27;
        r1 = r28;
        com.google.android.gms.internal.measurement.C0690v2.n("match", 1, r1);
        r0 = r25.f2190a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x0477, code lost:
        if (r1.size() > 0) goto L_0x047c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x0479, code lost:
        r1 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x047c, code lost:
        r1 = r5.b((com.google.android.gms.internal.measurement.C0663s) r1.get(0)).E();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x048b, code lost:
        r0 = java.util.regex.Pattern.compile(r1).matcher(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x0497, code lost:
        if (r0.find() == false) goto L_0x04ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x04ad, code lost:
        return new com.google.android.gms.internal.measurement.C0560g(new com.google.android.gms.internal.measurement.C0679u(r0.group()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x04b0, code lost:
        return com.google.android.gms.internal.measurement.C0663s.f2139c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x04b1, code lost:
        com.google.android.gms.internal.measurement.C0690v2.g("toUpperCase", 0, r28);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x04c4, code lost:
        return new com.google.android.gms.internal.measurement.C0679u(r25.f2190a.trim());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x04c5, code lost:
        com.google.android.gms.internal.measurement.C0690v2.g("toUpperCase", 0, r28);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x04da, code lost:
        return new com.google.android.gms.internal.measurement.C0679u(r25.f2190a.toUpperCase(java.util.Locale.ENGLISH));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x04db, code lost:
        r5 = r27;
        r1 = r28;
        com.google.android.gms.internal.measurement.C0690v2.n("lastIndexOf", 2, r1);
        r0 = r25.f2190a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x04eb, code lost:
        if (r1.size() > 0) goto L_0x04f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x04ed, code lost:
        r2 = com.google.android.gms.internal.measurement.C0663s.f2138b0.E();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x04f4, code lost:
        r2 = r5.b((com.google.android.gms.internal.measurement.C0663s) r1.get(0)).E();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x0508, code lost:
        if (r1.size() >= 2) goto L_0x050d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x050a, code lost:
        r4 = Double.NaN;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x050d, code lost:
        r4 = r5.b((com.google.android.gms.internal.measurement.C0663s) r1.get(1)).D().doubleValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x0524, code lost:
        if (java.lang.Double.isNaN(r4) == false) goto L_0x0529;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x0526, code lost:
        r4 = Double.POSITIVE_INFINITY;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x0529, code lost:
        r4 = com.google.android.gms.internal.measurement.C0690v2.a(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x053c, code lost:
        return new com.google.android.gms.internal.measurement.C0596k(java.lang.Double.valueOf((double) r0.lastIndexOf(r2, (int) r4)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:208:0x053d, code lost:
        com.google.android.gms.internal.measurement.C0690v2.g("toLocaleUpperCase", 0, r28);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x0550, code lost:
        return new com.google.android.gms.internal.measurement.C0679u(r25.f2190a.toUpperCase());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x0551, code lost:
        r3 = r25;
        r5 = r27;
        r1 = r28;
        com.google.android.gms.internal.measurement.C0690v2.n("search", 1, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x0560, code lost:
        if (r1.isEmpty() != false) goto L_0x0571;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x0562, code lost:
        r0 = r5.b((com.google.android.gms.internal.measurement.C0663s) r1.get(0)).E();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x0571, code lost:
        r0 = com.google.android.gms.internal.measurement.C0663s.f2138b0.E();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x0577, code lost:
        r0 = java.util.regex.Pattern.compile(r0).matcher(r3.f2190a);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x0585, code lost:
        if (r0.find() == false) goto L_0x0596;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x0595, code lost:
        return new com.google.android.gms.internal.measurement.C0596k(java.lang.Double.valueOf((double) r0.start()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x05a1, code lost:
        return new com.google.android.gms.internal.measurement.C0596k(java.lang.Double.valueOf(-1.0d));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x05a2, code lost:
        com.google.android.gms.internal.measurement.C0690v2.g("toLowerCase", 0, r28);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:0x05b7, code lost:
        return new com.google.android.gms.internal.measurement.C0679u(r25.f2190a.toLowerCase(java.util.Locale.ENGLISH));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x05b8, code lost:
        r3 = r25;
        r5 = r27;
        r1 = r28;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:0x05c2, code lost:
        if (r1.isEmpty() == false) goto L_0x05c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:0x05c4, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:0x05c5, code lost:
        r0 = new java.lang.StringBuilder(r3.f2190a);
        r9 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x05d1, code lost:
        if (r9 >= r1.size()) goto L_0x05e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x05d3, code lost:
        r0.append(r5.b((com.google.android.gms.internal.measurement.C0663s) r1.get(r9)).E());
        r9 = r9 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x05f0, code lost:
        return new com.google.android.gms.internal.measurement.C0679u(r0.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x05f1, code lost:
        r3 = r25;
        r5 = r27;
        r1 = r28;
        com.google.android.gms.internal.measurement.C0690v2.n(r7, 1, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x05ff, code lost:
        if (r1.isEmpty() != false) goto L_0x061a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:233:0x0601, code lost:
        r9 = (int) com.google.android.gms.internal.measurement.C0690v2.a(r5.b((com.google.android.gms.internal.measurement.C0663s) r1.get(0)).D().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:0x061a, code lost:
        r9 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:235:0x061b, code lost:
        r0 = r3.f2190a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x061d, code lost:
        if (r9 < 0) goto L_0x0634;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x0623, code lost:
        if (r9 < r0.length()) goto L_0x0626;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x0633, code lost:
        return new com.google.android.gms.internal.measurement.C0679u(java.lang.String.valueOf(r0.charAt(r9)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x0636, code lost:
        return com.google.android.gms.internal.measurement.C0663s.f2145i0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x0637, code lost:
        com.google.android.gms.internal.measurement.C0690v2.g(r11, 0, r28);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:0x064a, code lost:
        return new com.google.android.gms.internal.measurement.C0679u(r25.f2190a.toLowerCase());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:0x064b, code lost:
        r3 = r25;
        com.google.android.gms.internal.measurement.C0690v2.g(r14, 0, r28);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:246:0x0653, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:0x0654, code lost:
        r1 = r28;
        com.google.android.gms.internal.measurement.C0690v2.g(r15, 1, r1);
        r0 = r25.f2190a;
        r1 = r27.b((com.google.android.gms.internal.measurement.C0663s) r1.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:248:0x0675, code lost:
        if ("length".equals(r1.E()) == false) goto L_0x067a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:0x0679, code lost:
        return com.google.android.gms.internal.measurement.C0663s.f2143g0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:251:0x067a, code lost:
        r1 = r1.D().doubleValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:252:0x0688, code lost:
        if (r1 != java.lang.Math.floor(r1)) goto L_0x0696;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:253:0x068a, code lost:
        r1 = (int) r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:254:0x068b, code lost:
        if (r1 < 0) goto L_0x0696;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:256:0x0691, code lost:
        if (r1 >= r0.length()) goto L_0x0696;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:258:0x0695, code lost:
        return com.google.android.gms.internal.measurement.C0663s.f2143g0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:260:0x0698, code lost:
        return com.google.android.gms.internal.measurement.C0663s.f2144h0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00bc, code lost:
        r15 = r20;
        r7 = r21;
        r14 = r22;
        r11 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00c4, code lost:
        r1 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00c5, code lost:
        r23 = 0.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x014c, code lost:
        r15 = r20;
        r7 = r21;
        r14 = r22;
        r11 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x019f, code lost:
        r1 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01a2, code lost:
        switch(r1) {
            case 0: goto L_0x0654;
            case 1: goto L_0x064b;
            case 2: goto L_0x0637;
            case 3: goto L_0x05f1;
            case 4: goto L_0x05b8;
            case 5: goto L_0x05a2;
            case 6: goto L_0x0551;
            case 7: goto L_0x053d;
            case 8: goto L_0x04db;
            case 9: goto L_0x04c5;
            case 10: goto L_0x04b1;
            case 11: goto L_0x0467;
            case 12: goto L_0x03d1;
            case 13: goto L_0x0319;
            case 14: goto L_0x029e;
            case 15: goto L_0x0208;
            case 16: goto L_0x01ad;
            default: goto L_0x01a5;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01ac, code lost:
        throw new java.lang.IllegalArgumentException("Command not supported");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01ad, code lost:
        r1 = r28;
        com.google.android.gms.internal.measurement.C0690v2.n("indexOf", 2, r1);
        r0 = r25.f2190a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01bb, code lost:
        if (r1.size() > 0) goto L_0x01c6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.measurement.C0663s G(java.lang.String r26, com.google.android.gms.internal.measurement.Z2 r27, java.util.List r28) {
        /*
            r25 = this;
            r1 = r26
            java.lang.String r6 = "trim"
            java.lang.String r7 = "concat"
            java.lang.String r11 = "charAt"
            boolean r12 = r11.equals(r1)
            java.lang.String r13 = "toLocaleUpperCase"
            java.lang.String r14 = "toString"
            java.lang.String r15 = "toLocaleLowerCase"
            r16 = -1
            java.lang.String r5 = "toLowerCase"
            java.lang.String r4 = "substring"
            r17 = 0
            java.lang.String r9 = "split"
            java.lang.String r8 = "slice"
            java.lang.String r10 = "search"
            r20 = r12
            java.lang.String r12 = "replace"
            java.lang.String r2 = "match"
            java.lang.String r0 = "lastIndexOf"
            java.lang.String r3 = "indexOf"
            r21 = r11
            java.lang.String r11 = "hasOwnProperty"
            r22 = r6
            java.lang.String r6 = "toUpperCase"
            if (r20 != 0) goto L_0x00aa
            boolean r20 = r7.equals(r1)
            if (r20 != 0) goto L_0x00aa
            boolean r20 = r11.equals(r1)
            if (r20 != 0) goto L_0x00aa
            boolean r20 = r3.equals(r1)
            if (r20 != 0) goto L_0x00aa
            boolean r20 = r0.equals(r1)
            if (r20 != 0) goto L_0x00aa
            boolean r20 = r2.equals(r1)
            if (r20 != 0) goto L_0x00aa
            boolean r20 = r12.equals(r1)
            if (r20 != 0) goto L_0x00aa
            boolean r20 = r10.equals(r1)
            if (r20 != 0) goto L_0x00aa
            boolean r20 = r8.equals(r1)
            if (r20 != 0) goto L_0x00aa
            boolean r20 = r9.equals(r1)
            if (r20 != 0) goto L_0x00aa
            boolean r20 = r4.equals(r1)
            if (r20 != 0) goto L_0x00aa
            boolean r20 = r5.equals(r1)
            if (r20 != 0) goto L_0x00aa
            boolean r20 = r15.equals(r1)
            if (r20 != 0) goto L_0x00aa
            boolean r20 = r14.equals(r1)
            if (r20 != 0) goto L_0x00aa
            boolean r20 = r6.equals(r1)
            if (r20 != 0) goto L_0x00aa
            boolean r20 = r13.equals(r1)
            if (r20 != 0) goto L_0x00aa
            r20 = r11
            r11 = r22
            boolean r22 = r11.equals(r1)
            if (r22 == 0) goto L_0x0099
            goto L_0x00ae
        L_0x0099:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "%s is not a String function"
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r17] = r1
            java.lang.String r1 = java.lang.String.format(r2, r3)
            r0.<init>(r1)
            throw r0
        L_0x00aa:
            r20 = r11
            r11 = r22
        L_0x00ae:
            r1.getClass()
            r22 = r14
            r23 = r15
            int r24 = r1.hashCode()
            switch(r24) {
                case -1789698943: goto L_0x018f;
                case -1776922004: goto L_0x017c;
                case -1464939364: goto L_0x0169;
                case -1361633751: goto L_0x0156;
                case -1354795244: goto L_0x0143;
                case -1137582698: goto L_0x0139;
                case -906336856: goto L_0x0130;
                case -726908483: goto L_0x0127;
                case -467511597: goto L_0x011d;
                case -399551817: goto L_0x0113;
                case 3568674: goto L_0x0109;
                case 103668165: goto L_0x00ff;
                case 109526418: goto L_0x00f5;
                case 109648666: goto L_0x00ea;
                case 530542161: goto L_0x00df;
                case 1094496948: goto L_0x00d4;
                case 1943291465: goto L_0x00c9;
                default: goto L_0x00bc;
            }
        L_0x00bc:
            r15 = r20
            r7 = r21
            r14 = r22
            r11 = r23
        L_0x00c4:
            r1 = -1
        L_0x00c5:
            r23 = 0
            goto L_0x01a2
        L_0x00c9:
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x00d0
            goto L_0x00bc
        L_0x00d0:
            r1 = 16
            goto L_0x014c
        L_0x00d4:
            boolean r1 = r1.equals(r12)
            if (r1 != 0) goto L_0x00db
            goto L_0x00bc
        L_0x00db:
            r1 = 15
            goto L_0x014c
        L_0x00df:
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x00e6
            goto L_0x00bc
        L_0x00e6:
            r1 = 14
            goto L_0x014c
        L_0x00ea:
            boolean r1 = r1.equals(r9)
            if (r1 != 0) goto L_0x00f1
            goto L_0x00bc
        L_0x00f1:
            r1 = 13
            goto L_0x014c
        L_0x00f5:
            boolean r1 = r1.equals(r8)
            if (r1 != 0) goto L_0x00fc
            goto L_0x00bc
        L_0x00fc:
            r1 = 12
            goto L_0x014c
        L_0x00ff:
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0106
            goto L_0x00bc
        L_0x0106:
            r1 = 11
            goto L_0x014c
        L_0x0109:
            boolean r1 = r1.equals(r11)
            if (r1 != 0) goto L_0x0110
            goto L_0x00bc
        L_0x0110:
            r1 = 10
            goto L_0x014c
        L_0x0113:
            boolean r1 = r1.equals(r6)
            if (r1 != 0) goto L_0x011a
            goto L_0x00bc
        L_0x011a:
            r1 = 9
            goto L_0x014c
        L_0x011d:
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x0124
            goto L_0x00bc
        L_0x0124:
            r1 = 8
            goto L_0x014c
        L_0x0127:
            boolean r1 = r1.equals(r13)
            if (r1 != 0) goto L_0x012e
            goto L_0x00bc
        L_0x012e:
            r1 = 7
            goto L_0x014c
        L_0x0130:
            boolean r1 = r1.equals(r10)
            if (r1 != 0) goto L_0x0137
            goto L_0x00bc
        L_0x0137:
            r1 = 6
            goto L_0x014c
        L_0x0139:
            boolean r1 = r1.equals(r5)
            if (r1 != 0) goto L_0x0141
            goto L_0x00bc
        L_0x0141:
            r1 = 5
            goto L_0x014c
        L_0x0143:
            boolean r1 = r1.equals(r7)
            if (r1 != 0) goto L_0x014b
            goto L_0x00bc
        L_0x014b:
            r1 = 4
        L_0x014c:
            r15 = r20
            r7 = r21
            r14 = r22
            r11 = r23
            goto L_0x00c5
        L_0x0156:
            r7 = r21
            boolean r1 = r1.equals(r7)
            r15 = r20
            r14 = r22
            r11 = r23
            if (r1 != 0) goto L_0x0166
            goto L_0x00c4
        L_0x0166:
            r1 = 3
            goto L_0x00c5
        L_0x0169:
            r7 = r21
            r11 = r23
            boolean r1 = r1.equals(r11)
            r15 = r20
            r14 = r22
            if (r1 != 0) goto L_0x0179
            goto L_0x00c4
        L_0x0179:
            r1 = 2
            goto L_0x00c5
        L_0x017c:
            r7 = r21
            r14 = r22
            r11 = r23
            r23 = 0
            boolean r1 = r1.equals(r14)
            r15 = r20
            if (r1 != 0) goto L_0x018d
            goto L_0x019f
        L_0x018d:
            r1 = 1
            goto L_0x01a2
        L_0x018f:
            r15 = r20
            r7 = r21
            r14 = r22
            r11 = r23
            r23 = 0
            boolean r1 = r1.equals(r15)
            if (r1 != 0) goto L_0x01a1
        L_0x019f:
            r1 = -1
            goto L_0x01a2
        L_0x01a1:
            r1 = 0
        L_0x01a2:
            switch(r1) {
                case 0: goto L_0x0654;
                case 1: goto L_0x064b;
                case 2: goto L_0x0637;
                case 3: goto L_0x05f1;
                case 4: goto L_0x05b8;
                case 5: goto L_0x05a2;
                case 6: goto L_0x0551;
                case 7: goto L_0x053d;
                case 8: goto L_0x04db;
                case 9: goto L_0x04c5;
                case 10: goto L_0x04b1;
                case 11: goto L_0x0467;
                case 12: goto L_0x03d1;
                case 13: goto L_0x0319;
                case 14: goto L_0x029e;
                case 15: goto L_0x0208;
                case 16: goto L_0x01ad;
                default: goto L_0x01a5;
            }
        L_0x01a5:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Command not supported"
            r0.<init>(r1)
            throw r0
        L_0x01ad:
            r1 = r28
            r0 = 2
            com.google.android.gms.internal.measurement.C0690v2.n(r3, r0, r1)
            r3 = r25
            java.lang.String r0 = r3.f2190a
            int r2 = r1.size()
            if (r2 > 0) goto L_0x01c6
            com.google.android.gms.internal.measurement.s r2 = com.google.android.gms.internal.measurement.C0663s.f2138b0
            java.lang.String r2 = r2.E()
            r5 = r27
            goto L_0x01d7
        L_0x01c6:
            r2 = 0
            java.lang.Object r2 = r1.get(r2)
            com.google.android.gms.internal.measurement.s r2 = (com.google.android.gms.internal.measurement.C0663s) r2
            r5 = r27
            com.google.android.gms.internal.measurement.s r2 = r5.b(r2)
            java.lang.String r2 = r2.E()
        L_0x01d7:
            int r4 = r1.size()
            r6 = 2
            if (r4 >= r6) goto L_0x01e1
            r14 = r23
            goto L_0x01f4
        L_0x01e1:
            r4 = 1
            java.lang.Object r1 = r1.get(r4)
            com.google.android.gms.internal.measurement.s r1 = (com.google.android.gms.internal.measurement.C0663s) r1
            com.google.android.gms.internal.measurement.s r1 = r5.b(r1)
            java.lang.Double r1 = r1.D()
            double r14 = r1.doubleValue()
        L_0x01f4:
            double r4 = com.google.android.gms.internal.measurement.C0690v2.a(r14)
            com.google.android.gms.internal.measurement.k r1 = new com.google.android.gms.internal.measurement.k
            int r4 = (int) r4
            int r0 = r0.indexOf(r2, r4)
            double r4 = (double) r0
            java.lang.Double r0 = java.lang.Double.valueOf(r4)
            r1.<init>(r0)
            return r1
        L_0x0208:
            r3 = r25
            r5 = r27
            r1 = r28
            r0 = 2
            com.google.android.gms.internal.measurement.C0690v2.n(r12, r0, r1)
            com.google.android.gms.internal.measurement.s r0 = com.google.android.gms.internal.measurement.C0663s.f2138b0
            java.lang.String r2 = r0.E()
            boolean r4 = r1.isEmpty()
            if (r4 != 0) goto L_0x023e
            r4 = 0
            java.lang.Object r2 = r1.get(r4)
            com.google.android.gms.internal.measurement.s r2 = (com.google.android.gms.internal.measurement.C0663s) r2
            com.google.android.gms.internal.measurement.s r2 = r5.b(r2)
            java.lang.String r2 = r2.E()
            int r4 = r1.size()
            r6 = 1
            if (r4 <= r6) goto L_0x023e
            java.lang.Object r0 = r1.get(r6)
            com.google.android.gms.internal.measurement.s r0 = (com.google.android.gms.internal.measurement.C0663s) r0
            com.google.android.gms.internal.measurement.s r0 = r5.b(r0)
        L_0x023e:
            java.lang.String r1 = r3.f2190a
            int r4 = r1.indexOf(r2)
            if (r4 >= 0) goto L_0x0248
            goto L_0x05c4
        L_0x0248:
            boolean r6 = r0 instanceof com.google.android.gms.internal.measurement.C0623n
            if (r6 == 0) goto L_0x0274
            com.google.android.gms.internal.measurement.n r0 = (com.google.android.gms.internal.measurement.C0623n) r0
            com.google.android.gms.internal.measurement.u r6 = new com.google.android.gms.internal.measurement.u
            r6.<init>(r2)
            com.google.android.gms.internal.measurement.k r7 = new com.google.android.gms.internal.measurement.k
            double r8 = (double) r4
            java.lang.Double r8 = java.lang.Double.valueOf(r8)
            r7.<init>(r8)
            r8 = 3
            com.google.android.gms.internal.measurement.s[] r8 = new com.google.android.gms.internal.measurement.C0663s[r8]
            r9 = 0
            r8[r9] = r6
            r19 = 1
            r8[r19] = r7
            r18 = 2
            r8[r18] = r3
            java.util.List r6 = java.util.Arrays.asList(r8)
            com.google.android.gms.internal.measurement.s r0 = r0.a(r5, r6)
            goto L_0x0275
        L_0x0274:
            r9 = 0
        L_0x0275:
            com.google.android.gms.internal.measurement.u r5 = new com.google.android.gms.internal.measurement.u
            java.lang.String r6 = r1.substring(r9, r4)
            java.lang.String r0 = r0.E()
            int r2 = r2.length()
            int r4 = r4 + r2
            java.lang.String r1 = r1.substring(r4)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r6)
            r2.append(r0)
            r2.append(r1)
            java.lang.String r0 = r2.toString()
            r5.<init>(r0)
            return r5
        L_0x029e:
            r3 = r25
            r5 = r27
            r1 = r28
            r0 = 2
            com.google.android.gms.internal.measurement.C0690v2.n(r4, r0, r1)
            java.lang.String r0 = r3.f2190a
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto L_0x02c9
            r2 = 0
            java.lang.Object r4 = r1.get(r2)
            com.google.android.gms.internal.measurement.s r4 = (com.google.android.gms.internal.measurement.C0663s) r4
            com.google.android.gms.internal.measurement.s r2 = r5.b(r4)
            java.lang.Double r2 = r2.D()
            double r6 = r2.doubleValue()
            double r6 = com.google.android.gms.internal.measurement.C0690v2.a(r6)
            int r2 = (int) r6
            goto L_0x02ca
        L_0x02c9:
            r2 = 0
        L_0x02ca:
            int r4 = r1.size()
            r6 = 1
            if (r4 <= r6) goto L_0x02ea
            java.lang.Object r1 = r1.get(r6)
            com.google.android.gms.internal.measurement.s r1 = (com.google.android.gms.internal.measurement.C0663s) r1
            com.google.android.gms.internal.measurement.s r1 = r5.b(r1)
            java.lang.Double r1 = r1.D()
            double r4 = r1.doubleValue()
            double r4 = com.google.android.gms.internal.measurement.C0690v2.a(r4)
            int r1 = (int) r4
        L_0x02e8:
            r4 = 0
            goto L_0x02ef
        L_0x02ea:
            int r1 = r0.length()
            goto L_0x02e8
        L_0x02ef:
            int r2 = java.lang.Math.max(r2, r4)
            int r5 = r0.length()
            int r2 = java.lang.Math.min(r2, r5)
            int r1 = java.lang.Math.max(r1, r4)
            int r4 = r0.length()
            int r1 = java.lang.Math.min(r1, r4)
            com.google.android.gms.internal.measurement.u r4 = new com.google.android.gms.internal.measurement.u
            int r5 = java.lang.Math.min(r2, r1)
            int r1 = java.lang.Math.max(r2, r1)
            java.lang.String r0 = r0.substring(r5, r1)
            r4.<init>(r0)
            return r4
        L_0x0319:
            r3 = r25
            r5 = r27
            r1 = r28
            r0 = 2
            com.google.android.gms.internal.measurement.C0690v2.n(r9, r0, r1)
            java.lang.String r0 = r3.f2190a
            int r2 = r0.length()
            if (r2 != 0) goto L_0x0337
            com.google.android.gms.internal.measurement.g r0 = new com.google.android.gms.internal.measurement.g
            r6 = 1
            com.google.android.gms.internal.measurement.s[] r1 = new com.google.android.gms.internal.measurement.C0663s[r6]
            r2 = 0
            r1[r2] = r3
            r0.<init>((com.google.android.gms.internal.measurement.C0663s[]) r1)
            return r0
        L_0x0337:
            r2 = 0
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            boolean r6 = r1.isEmpty()
            if (r6 == 0) goto L_0x0348
            r4.add(r3)
            goto L_0x03cb
        L_0x0348:
            java.lang.Object r6 = r1.get(r2)
            com.google.android.gms.internal.measurement.s r6 = (com.google.android.gms.internal.measurement.C0663s) r6
            com.google.android.gms.internal.measurement.s r2 = r5.b(r6)
            java.lang.String r2 = r2.E()
            int r6 = r1.size()
            r7 = 1
            if (r6 <= r7) goto L_0x0374
            java.lang.Object r1 = r1.get(r7)
            com.google.android.gms.internal.measurement.s r1 = (com.google.android.gms.internal.measurement.C0663s) r1
            com.google.android.gms.internal.measurement.s r1 = r5.b(r1)
            java.lang.Double r1 = r1.D()
            double r5 = r1.doubleValue()
            long r5 = com.google.android.gms.internal.measurement.C0690v2.m(r5)
            goto L_0x0377
        L_0x0374:
            r5 = 2147483647(0x7fffffff, double:1.060997895E-314)
        L_0x0377:
            r7 = 0
            int r1 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r1 != 0) goto L_0x0383
            com.google.android.gms.internal.measurement.g r0 = new com.google.android.gms.internal.measurement.g
            r0.<init>()
            return r0
        L_0x0383:
            java.lang.String r1 = java.util.regex.Pattern.quote(r2)
            int r7 = (int) r5
            r19 = 1
            int r7 = r7 + 1
            java.lang.String[] r0 = r0.split(r1, r7)
            int r1 = r0.length
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x03b1
            int r2 = r0.length
            if (r2 <= 0) goto L_0x03b1
            r17 = 0
            r2 = r0[r17]
            boolean r9 = r2.isEmpty()
            int r2 = r0.length
            int r2 = r2 + -1
            r2 = r0[r2]
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x03b2
            int r1 = r0.length
            int r1 = r1 + -1
            goto L_0x03b2
        L_0x03b1:
            r9 = 0
        L_0x03b2:
            int r2 = r0.length
            long r7 = (long) r2
            int r2 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r2 <= 0) goto L_0x03ba
            int r1 = r1 + -1
        L_0x03ba:
            if (r9 >= r1) goto L_0x03cb
            com.google.android.gms.internal.measurement.u r2 = new com.google.android.gms.internal.measurement.u
            r5 = r0[r9]
            r2.<init>(r5)
            r4.add(r2)
            r19 = 1
            int r9 = r9 + 1
            goto L_0x03ba
        L_0x03cb:
            com.google.android.gms.internal.measurement.g r0 = new com.google.android.gms.internal.measurement.g
            r0.<init>((java.util.List) r4)
            return r0
        L_0x03d1:
            r3 = r25
            r5 = r27
            r1 = r28
            r0 = 2
            com.google.android.gms.internal.measurement.C0690v2.n(r8, r0, r1)
            java.lang.String r0 = r3.f2190a
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto L_0x03f7
            r2 = 0
            java.lang.Object r4 = r1.get(r2)
            com.google.android.gms.internal.measurement.s r4 = (com.google.android.gms.internal.measurement.C0663s) r4
            com.google.android.gms.internal.measurement.s r2 = r5.b(r4)
            java.lang.Double r2 = r2.D()
            double r6 = r2.doubleValue()
            goto L_0x03f9
        L_0x03f7:
            r6 = r23
        L_0x03f9:
            double r6 = com.google.android.gms.internal.measurement.C0690v2.a(r6)
            int r2 = (r6 > r23 ? 1 : (r6 == r23 ? 0 : -1))
            if (r2 >= 0) goto L_0x040e
            int r2 = r0.length()
            double r8 = (double) r2
            double r8 = r8 + r6
            r6 = r23
            double r8 = java.lang.Math.max(r8, r6)
            goto L_0x0417
        L_0x040e:
            int r2 = r0.length()
            double r8 = (double) r2
            double r8 = java.lang.Math.min(r6, r8)
        L_0x0417:
            int r2 = (int) r8
            int r4 = r1.size()
            r6 = 1
            if (r4 <= r6) goto L_0x0432
            java.lang.Object r1 = r1.get(r6)
            com.google.android.gms.internal.measurement.s r1 = (com.google.android.gms.internal.measurement.C0663s) r1
            com.google.android.gms.internal.measurement.s r1 = r5.b(r1)
            java.lang.Double r1 = r1.D()
            double r4 = r1.doubleValue()
            goto L_0x0437
        L_0x0432:
            int r1 = r0.length()
            double r4 = (double) r1
        L_0x0437:
            double r4 = com.google.android.gms.internal.measurement.C0690v2.a(r4)
            r6 = 0
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 >= 0) goto L_0x044c
            int r1 = r0.length()
            double r8 = (double) r1
            double r8 = r8 + r4
            double r4 = java.lang.Math.max(r8, r6)
            goto L_0x0455
        L_0x044c:
            int r1 = r0.length()
            double r6 = (double) r1
            double r4 = java.lang.Math.min(r4, r6)
        L_0x0455:
            int r1 = (int) r4
            int r1 = r1 - r2
            r4 = 0
            int r1 = java.lang.Math.max(r4, r1)
            int r1 = r1 + r2
            com.google.android.gms.internal.measurement.u r4 = new com.google.android.gms.internal.measurement.u
            java.lang.String r0 = r0.substring(r2, r1)
            r4.<init>(r0)
            return r4
        L_0x0467:
            r3 = r25
            r5 = r27
            r1 = r28
            r6 = 1
            com.google.android.gms.internal.measurement.C0690v2.n(r2, r6, r1)
            java.lang.String r0 = r3.f2190a
            int r2 = r1.size()
            if (r2 > 0) goto L_0x047c
            java.lang.String r1 = ""
            goto L_0x048b
        L_0x047c:
            r2 = 0
            java.lang.Object r1 = r1.get(r2)
            com.google.android.gms.internal.measurement.s r1 = (com.google.android.gms.internal.measurement.C0663s) r1
            com.google.android.gms.internal.measurement.s r1 = r5.b(r1)
            java.lang.String r1 = r1.E()
        L_0x048b:
            java.util.regex.Pattern r1 = java.util.regex.Pattern.compile(r1)
            java.util.regex.Matcher r0 = r1.matcher(r0)
            boolean r1 = r0.find()
            if (r1 == 0) goto L_0x04ae
            com.google.android.gms.internal.measurement.g r1 = new com.google.android.gms.internal.measurement.g
            com.google.android.gms.internal.measurement.u r2 = new com.google.android.gms.internal.measurement.u
            java.lang.String r0 = r0.group()
            r2.<init>(r0)
            r6 = 1
            com.google.android.gms.internal.measurement.s[] r0 = new com.google.android.gms.internal.measurement.C0663s[r6]
            r4 = 0
            r0[r4] = r2
            r1.<init>((com.google.android.gms.internal.measurement.C0663s[]) r0)
            return r1
        L_0x04ae:
            com.google.android.gms.internal.measurement.s r0 = com.google.android.gms.internal.measurement.C0663s.f2139c0
            return r0
        L_0x04b1:
            r4 = 0
            r3 = r25
            r1 = r28
            com.google.android.gms.internal.measurement.C0690v2.g(r6, r4, r1)
            java.lang.String r0 = r3.f2190a
            com.google.android.gms.internal.measurement.u r1 = new com.google.android.gms.internal.measurement.u
            java.lang.String r0 = r0.trim()
            r1.<init>(r0)
            return r1
        L_0x04c5:
            r4 = 0
            r3 = r25
            r1 = r28
            com.google.android.gms.internal.measurement.C0690v2.g(r6, r4, r1)
            java.lang.String r0 = r3.f2190a
            com.google.android.gms.internal.measurement.u r1 = new com.google.android.gms.internal.measurement.u
            java.util.Locale r2 = java.util.Locale.ENGLISH
            java.lang.String r0 = r0.toUpperCase(r2)
            r1.<init>(r0)
            return r1
        L_0x04db:
            r3 = r25
            r5 = r27
            r1 = r28
            r6 = 2
            com.google.android.gms.internal.measurement.C0690v2.n(r0, r6, r1)
            java.lang.String r0 = r3.f2190a
            int r2 = r1.size()
            if (r2 > 0) goto L_0x04f4
            com.google.android.gms.internal.measurement.s r2 = com.google.android.gms.internal.measurement.C0663s.f2138b0
            java.lang.String r2 = r2.E()
            goto L_0x0503
        L_0x04f4:
            r2 = 0
            java.lang.Object r2 = r1.get(r2)
            com.google.android.gms.internal.measurement.s r2 = (com.google.android.gms.internal.measurement.C0663s) r2
            com.google.android.gms.internal.measurement.s r2 = r5.b(r2)
            java.lang.String r2 = r2.E()
        L_0x0503:
            int r4 = r1.size()
            r6 = 2
            if (r4 >= r6) goto L_0x050d
            r4 = 9221120237041090560(0x7ff8000000000000, double:NaN)
            goto L_0x0520
        L_0x050d:
            r6 = 1
            java.lang.Object r1 = r1.get(r6)
            com.google.android.gms.internal.measurement.s r1 = (com.google.android.gms.internal.measurement.C0663s) r1
            com.google.android.gms.internal.measurement.s r1 = r5.b(r1)
            java.lang.Double r1 = r1.D()
            double r4 = r1.doubleValue()
        L_0x0520:
            boolean r1 = java.lang.Double.isNaN(r4)
            if (r1 == 0) goto L_0x0529
            r4 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            goto L_0x052d
        L_0x0529:
            double r4 = com.google.android.gms.internal.measurement.C0690v2.a(r4)
        L_0x052d:
            com.google.android.gms.internal.measurement.k r1 = new com.google.android.gms.internal.measurement.k
            int r4 = (int) r4
            int r0 = r0.lastIndexOf(r2, r4)
            double r4 = (double) r0
            java.lang.Double r0 = java.lang.Double.valueOf(r4)
            r1.<init>(r0)
            return r1
        L_0x053d:
            r2 = 0
            r3 = r25
            r1 = r28
            com.google.android.gms.internal.measurement.C0690v2.g(r13, r2, r1)
            java.lang.String r0 = r3.f2190a
            com.google.android.gms.internal.measurement.u r1 = new com.google.android.gms.internal.measurement.u
            java.lang.String r0 = r0.toUpperCase()
            r1.<init>(r0)
            return r1
        L_0x0551:
            r3 = r25
            r5 = r27
            r1 = r28
            r2 = 0
            r6 = 1
            com.google.android.gms.internal.measurement.C0690v2.n(r10, r6, r1)
            boolean r0 = r1.isEmpty()
            if (r0 != 0) goto L_0x0571
            java.lang.Object r0 = r1.get(r2)
            com.google.android.gms.internal.measurement.s r0 = (com.google.android.gms.internal.measurement.C0663s) r0
            com.google.android.gms.internal.measurement.s r0 = r5.b(r0)
            java.lang.String r0 = r0.E()
            goto L_0x0577
        L_0x0571:
            com.google.android.gms.internal.measurement.s r0 = com.google.android.gms.internal.measurement.C0663s.f2138b0
            java.lang.String r0 = r0.E()
        L_0x0577:
            java.lang.String r1 = r3.f2190a
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)
            java.util.regex.Matcher r0 = r0.matcher(r1)
            boolean r1 = r0.find()
            if (r1 == 0) goto L_0x0596
            com.google.android.gms.internal.measurement.k r1 = new com.google.android.gms.internal.measurement.k
            int r0 = r0.start()
            double r4 = (double) r0
            java.lang.Double r0 = java.lang.Double.valueOf(r4)
            r1.<init>(r0)
            return r1
        L_0x0596:
            com.google.android.gms.internal.measurement.k r0 = new com.google.android.gms.internal.measurement.k
            r1 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            java.lang.Double r1 = java.lang.Double.valueOf(r1)
            r0.<init>(r1)
            return r0
        L_0x05a2:
            r2 = 0
            r3 = r25
            r1 = r28
            com.google.android.gms.internal.measurement.C0690v2.g(r5, r2, r1)
            java.lang.String r0 = r3.f2190a
            com.google.android.gms.internal.measurement.u r1 = new com.google.android.gms.internal.measurement.u
            java.util.Locale r2 = java.util.Locale.ENGLISH
            java.lang.String r0 = r0.toLowerCase(r2)
            r1.<init>(r0)
            return r1
        L_0x05b8:
            r3 = r25
            r5 = r27
            r1 = r28
            boolean r0 = r1.isEmpty()
            if (r0 == 0) goto L_0x05c5
        L_0x05c4:
            return r3
        L_0x05c5:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = r3.f2190a
            r0.<init>(r2)
            r9 = 0
        L_0x05cd:
            int r2 = r1.size()
            if (r9 >= r2) goto L_0x05e7
            java.lang.Object r2 = r1.get(r9)
            com.google.android.gms.internal.measurement.s r2 = (com.google.android.gms.internal.measurement.C0663s) r2
            com.google.android.gms.internal.measurement.s r2 = r5.b(r2)
            java.lang.String r2 = r2.E()
            r0.append(r2)
            r6 = 1
            int r9 = r9 + r6
            goto L_0x05cd
        L_0x05e7:
            com.google.android.gms.internal.measurement.u r1 = new com.google.android.gms.internal.measurement.u
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            return r1
        L_0x05f1:
            r3 = r25
            r5 = r27
            r1 = r28
            r6 = 1
            com.google.android.gms.internal.measurement.C0690v2.n(r7, r6, r1)
            boolean r0 = r1.isEmpty()
            if (r0 != 0) goto L_0x061a
            r2 = 0
            java.lang.Object r0 = r1.get(r2)
            com.google.android.gms.internal.measurement.s r0 = (com.google.android.gms.internal.measurement.C0663s) r0
            com.google.android.gms.internal.measurement.s r0 = r5.b(r0)
            java.lang.Double r0 = r0.D()
            double r0 = r0.doubleValue()
            double r0 = com.google.android.gms.internal.measurement.C0690v2.a(r0)
            int r9 = (int) r0
            goto L_0x061b
        L_0x061a:
            r9 = 0
        L_0x061b:
            java.lang.String r0 = r3.f2190a
            if (r9 < 0) goto L_0x0634
            int r1 = r0.length()
            if (r9 < r1) goto L_0x0626
            goto L_0x0634
        L_0x0626:
            com.google.android.gms.internal.measurement.u r1 = new com.google.android.gms.internal.measurement.u
            char r0 = r0.charAt(r9)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r1.<init>(r0)
            return r1
        L_0x0634:
            com.google.android.gms.internal.measurement.s r0 = com.google.android.gms.internal.measurement.C0663s.f2145i0
            return r0
        L_0x0637:
            r2 = 0
            r3 = r25
            r1 = r28
            com.google.android.gms.internal.measurement.C0690v2.g(r11, r2, r1)
            java.lang.String r0 = r3.f2190a
            com.google.android.gms.internal.measurement.u r1 = new com.google.android.gms.internal.measurement.u
            java.lang.String r0 = r0.toLowerCase()
            r1.<init>(r0)
            return r1
        L_0x064b:
            r2 = 0
            r3 = r25
            r1 = r28
            com.google.android.gms.internal.measurement.C0690v2.g(r14, r2, r1)
            return r3
        L_0x0654:
            r3 = r25
            r5 = r27
            r1 = r28
            r2 = 0
            r6 = 1
            com.google.android.gms.internal.measurement.C0690v2.g(r15, r6, r1)
            java.lang.String r0 = r3.f2190a
            java.lang.Object r1 = r1.get(r2)
            com.google.android.gms.internal.measurement.s r1 = (com.google.android.gms.internal.measurement.C0663s) r1
            com.google.android.gms.internal.measurement.s r1 = r5.b(r1)
            java.lang.String r2 = r1.E()
            java.lang.String r4 = "length"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x067a
            com.google.android.gms.internal.measurement.s r0 = com.google.android.gms.internal.measurement.C0663s.f2143g0
            return r0
        L_0x067a:
            java.lang.Double r1 = r1.D()
            double r1 = r1.doubleValue()
            double r4 = java.lang.Math.floor(r1)
            int r6 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x0696
            int r1 = (int) r1
            if (r1 < 0) goto L_0x0696
            int r0 = r0.length()
            if (r1 >= r0) goto L_0x0696
            com.google.android.gms.internal.measurement.s r0 = com.google.android.gms.internal.measurement.C0663s.f2143g0
            return r0
        L_0x0696:
            com.google.android.gms.internal.measurement.s r0 = com.google.android.gms.internal.measurement.C0663s.f2144h0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.C0679u.G(java.lang.String, com.google.android.gms.internal.measurement.Z2, java.util.List):com.google.android.gms.internal.measurement.s");
    }

    public final C0663s b() {
        return new C0679u(this.f2190a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0679u)) {
            return false;
        }
        return this.f2190a.equals(((C0679u) obj).f2190a);
    }

    public final int hashCode() {
        return this.f2190a.hashCode();
    }

    public final Iterator iterator() {
        return new C0695w(this);
    }

    public final String toString() {
        String str = this.f2190a;
        return "\"" + str + "\"";
    }
}
