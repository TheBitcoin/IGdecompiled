package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Iterator;

public abstract class H {
    private static C0560g a(C0560g gVar, Z2 z22, C0623n nVar) {
        return b(gVar, z22, nVar, (Boolean) null, (Boolean) null);
    }

    private static C0560g b(C0560g gVar, Z2 z22, C0623n nVar, Boolean bool, Boolean bool2) {
        C0560g gVar2 = new C0560g();
        Iterator s4 = gVar.s();
        while (s4.hasNext()) {
            int intValue = ((Integer) s4.next()).intValue();
            if (gVar.r(intValue)) {
                C0663s a5 = nVar.a(z22, Arrays.asList(new C0663s[]{gVar.k(intValue), new C0596k(Double.valueOf((double) intValue)), gVar}));
                if (a5.C().equals(bool)) {
                    break;
                } else if (bool2 == null || a5.C().equals(bool2)) {
                    gVar2.q(intValue, a5);
                }
            }
        }
        return gVar2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0097 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.measurement.C0663s c(com.google.android.gms.internal.measurement.C0560g r10, com.google.android.gms.internal.measurement.Z2 r11, java.util.List r12, boolean r13) {
        /*
            java.lang.String r0 = "reduce"
            r1 = 1
            com.google.android.gms.internal.measurement.C0690v2.k(r0, r1, r12)
            r2 = 2
            com.google.android.gms.internal.measurement.C0690v2.n(r0, r2, r12)
            r0 = 0
            java.lang.Object r3 = r12.get(r0)
            com.google.android.gms.internal.measurement.s r3 = (com.google.android.gms.internal.measurement.C0663s) r3
            com.google.android.gms.internal.measurement.s r3 = r11.b(r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.measurement.C0623n
            if (r4 == 0) goto L_0x00a0
            int r4 = r12.size()
            if (r4 != r2) goto L_0x0036
            java.lang.Object r12 = r12.get(r1)
            com.google.android.gms.internal.measurement.s r12 = (com.google.android.gms.internal.measurement.C0663s) r12
            com.google.android.gms.internal.measurement.s r12 = r11.b(r12)
            boolean r4 = r12 instanceof com.google.android.gms.internal.measurement.C0605l
            if (r4 != 0) goto L_0x002e
            goto L_0x003d
        L_0x002e:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r11 = "Failed to parse initial value"
            r10.<init>(r11)
            throw r10
        L_0x0036:
            int r12 = r10.n()
            if (r12 == 0) goto L_0x0098
            r12 = 0
        L_0x003d:
            com.google.android.gms.internal.measurement.n r3 = (com.google.android.gms.internal.measurement.C0623n) r3
            int r4 = r10.n()
            if (r13 == 0) goto L_0x0047
            r5 = 0
            goto L_0x0049
        L_0x0047:
            int r5 = r4 + -1
        L_0x0049:
            if (r13 == 0) goto L_0x004d
            int r4 = r4 - r1
            goto L_0x004e
        L_0x004d:
            r4 = 0
        L_0x004e:
            if (r13 == 0) goto L_0x0052
            r13 = 1
            goto L_0x0053
        L_0x0052:
            r13 = -1
        L_0x0053:
            if (r12 != 0) goto L_0x005a
            com.google.android.gms.internal.measurement.s r12 = r10.k(r5)
            goto L_0x0095
        L_0x005a:
            int r6 = r4 - r5
            int r6 = r6 * r13
            if (r6 < 0) goto L_0x0097
            boolean r6 = r10.r(r5)
            if (r6 == 0) goto L_0x0095
            com.google.android.gms.internal.measurement.s r6 = r10.k(r5)
            com.google.android.gms.internal.measurement.k r7 = new com.google.android.gms.internal.measurement.k
            double r8 = (double) r5
            java.lang.Double r8 = java.lang.Double.valueOf(r8)
            r7.<init>(r8)
            r8 = 4
            com.google.android.gms.internal.measurement.s[] r8 = new com.google.android.gms.internal.measurement.C0663s[r8]
            r8[r0] = r12
            r8[r1] = r6
            r8[r2] = r7
            r12 = 3
            r8[r12] = r10
            java.util.List r12 = java.util.Arrays.asList(r8)
            com.google.android.gms.internal.measurement.s r12 = r3.a(r11, r12)
            boolean r6 = r12 instanceof com.google.android.gms.internal.measurement.C0605l
            if (r6 != 0) goto L_0x008d
            goto L_0x0095
        L_0x008d:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "Reduce operation failed"
            r10.<init>(r11)
            throw r10
        L_0x0095:
            int r5 = r5 + r13
            goto L_0x005a
        L_0x0097:
            return r12
        L_0x0098:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "Empty array with no initial value error"
            r10.<init>(r11)
            throw r10
        L_0x00a0:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r11 = "Callback should be a method"
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.H.c(com.google.android.gms.internal.measurement.g, com.google.android.gms.internal.measurement.Z2, java.util.List, boolean):com.google.android.gms.internal.measurement.s");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01da, code lost:
        r1 = r15.k(r3);
        r15.q(r3, (com.google.android.gms.internal.measurement.C0663s) null);
        r4 = (r0 - 1) - r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01eb, code lost:
        if (r15.r(r4) == false) goto L_0x01f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01ed, code lost:
        r15.q(r3, r15.k(r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x01f4, code lost:
        r15.q(r4, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01fa, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01fd, code lost:
        return r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0209, code lost:
        return c(r25, r26, r27, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x020a, code lost:
        r15 = r25;
        r3 = r26;
        r0 = r27;
        com.google.android.gms.internal.measurement.C0690v2.n("slice", 2, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0218, code lost:
        if (r0.isEmpty() == false) goto L_0x021f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x021e, code lost:
        return r15.b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x021f, code lost:
        r4 = (double) r15.n();
        r6 = com.google.android.gms.internal.measurement.C0690v2.a(r3.b((com.google.android.gms.internal.measurement.C0663s) r0.get(0)).D().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x023c, code lost:
        if (r6 >= 0.0d) goto L_0x0246;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x023e, code lost:
        r6 = java.lang.Math.max(r6 + r4, 0.0d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0246, code lost:
        r6 = java.lang.Math.min(r6, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x024e, code lost:
        if (r0.size() != 2) goto L_0x0277;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0250, code lost:
        r0 = com.google.android.gms.internal.measurement.C0690v2.a(r3.b((com.google.android.gms.internal.measurement.C0663s) r0.get(1)).D().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x026b, code lost:
        if (r0 >= 0.0d) goto L_0x0273;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x026d, code lost:
        r4 = java.lang.Math.max(r4 + r0, 0.0d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0273, code lost:
        r4 = java.lang.Math.min(r4, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0277, code lost:
        r0 = new com.google.android.gms.internal.measurement.C0560g();
        r1 = (int) r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0280, code lost:
        if (((double) r1) >= r4) goto L_0x028c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x0282, code lost:
        r0.m(r15.k(r1));
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x028c, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x028d, code lost:
        r15 = r25;
        com.google.android.gms.internal.measurement.C0690v2.g("shift", 0, r27);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0299, code lost:
        if (r15.n() != 0) goto L_0x029e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x029d, code lost:
        return com.google.android.gms.internal.measurement.C0663s.f2138b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x029e, code lost:
        r0 = r15.k(0);
        r15.p(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x02a5, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x02a6, code lost:
        r15 = r25;
        r3 = r26;
        r0 = r27;
        com.google.android.gms.internal.measurement.C0690v2.g("every", 1, r0);
        r0 = r3.b((com.google.android.gms.internal.measurement.C0663s) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x02bd, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.C0671t) == false) goto L_0x02df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x02c3, code lost:
        if (r15.n() == 0) goto L_0x02dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x02d7, code lost:
        if (b(r15, r3, (com.google.android.gms.internal.measurement.C0671t) r0, java.lang.Boolean.FALSE, java.lang.Boolean.TRUE).n() == r15.n()) goto L_0x02dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x02db, code lost:
        return com.google.android.gms.internal.measurement.C0663s.f2144h0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x02de, code lost:
        return com.google.android.gms.internal.measurement.C0663s.f2143g0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x02e6, code lost:
        throw new java.lang.IllegalArgumentException(r18);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x02e7, code lost:
        r15 = r25;
        r3 = r26;
        r0 = r27;
        com.google.android.gms.internal.measurement.C0690v2.n("sort", 1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x02f5, code lost:
        if (r15.n() < 2) goto L_0x0340;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x02f7, code lost:
        r1 = r15.t();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x02ff, code lost:
        if (r0.isEmpty() != false) goto L_0x031b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0301, code lost:
        r0 = r3.b((com.google.android.gms.internal.measurement.C0663s) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x030e, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.C0623n) == false) goto L_0x0313;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x0310, code lost:
        r0 = (com.google.android.gms.internal.measurement.C0623n) r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x031a, code lost:
        throw new java.lang.IllegalArgumentException("Comparator should be a method");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x031b, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x031c, code lost:
        java.util.Collections.sort(r1, new com.google.android.gms.internal.measurement.K(r0, r3));
        r15.u();
        r0 = r1.iterator();
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x0330, code lost:
        if (r0.hasNext() == false) goto L_0x0340;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x0332, code lost:
        r15.q(r3, (com.google.android.gms.internal.measurement.C0663s) r0.next());
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x0340, code lost:
        return r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x0341, code lost:
        r15 = r25;
        r3 = r26;
        r0 = r27;
        r4 = r18;
        com.google.android.gms.internal.measurement.C0690v2.g("some", 1, r0);
        r0 = r3.b((com.google.android.gms.internal.measurement.C0663s) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x035a, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.C0623n) == false) goto L_0x03b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x0360, code lost:
        if (r15.n() == 0) goto L_0x03b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x0362, code lost:
        r0 = (com.google.android.gms.internal.measurement.C0623n) r0;
        r1 = r15.s();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x036c, code lost:
        if (r1.hasNext() == false) goto L_0x03b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x036e, code lost:
        r4 = ((java.lang.Integer) r1.next()).intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x037c, code lost:
        if (r15.r(r4) == false) goto L_0x03ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x03a9, code lost:
        if (r0.a(r3, java.util.Arrays.asList(new com.google.android.gms.internal.measurement.C0663s[]{r15.k(r4), new com.google.android.gms.internal.measurement.C0596k(java.lang.Double.valueOf((double) r4)), r15})).C().booleanValue() == false) goto L_0x0368;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x03ad, code lost:
        return com.google.android.gms.internal.measurement.C0663s.f2143g0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x03b2, code lost:
        return com.google.android.gms.internal.measurement.C0663s.f2144h0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x03b8, code lost:
        throw new java.lang.IllegalArgumentException(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x03b9, code lost:
        r15 = r25;
        r3 = r26;
        r0 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x03c3, code lost:
        if (r0.isEmpty() != false) goto L_0x03dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x03c5, code lost:
        r0 = r0.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x03cd, code lost:
        if (r0.hasNext() == false) goto L_0x03dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x03cf, code lost:
        r15.m(r3.b((com.google.android.gms.internal.measurement.C0663s) r0.next()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x03eb, code lost:
        return new com.google.android.gms.internal.measurement.C0596k(java.lang.Double.valueOf((double) r15.n()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x03ec, code lost:
        r15 = r25;
        r3 = r26;
        r0 = r27;
        com.google.android.gms.internal.measurement.C0690v2.n("join", 1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x03fa, code lost:
        if (r15.n() != 0) goto L_0x03ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x03fe, code lost:
        return com.google.android.gms.internal.measurement.C0663s.f2145i0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x0403, code lost:
        if (r0.isEmpty() != false) goto L_0x0421;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x0405, code lost:
        r0 = r3.b((com.google.android.gms.internal.measurement.C0663s) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0412, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.C0648q) != false) goto L_0x041e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x0416, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.C0719z) == false) goto L_0x0419;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x0419, code lost:
        r0 = r0.E();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x041e, code lost:
        r0 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x0421, code lost:
        r0 = ",";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x042c, code lost:
        return new com.google.android.gms.internal.measurement.C0679u(r15.o(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x042d, code lost:
        r15 = r25;
        com.google.android.gms.internal.measurement.C0690v2.g("pop", 0, r27);
        r0 = r15.n();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x0439, code lost:
        if (r0 != 0) goto L_0x043e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x043d, code lost:
        return com.google.android.gms.internal.measurement.C0663s.f2138b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x043e, code lost:
        r0 = r0 - 1;
        r1 = r15.k(r0);
        r15.p(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x0447, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:208:0x0448, code lost:
        r15 = r25;
        r3 = r26;
        r0 = r27;
        r4 = r18;
        com.google.android.gms.internal.measurement.C0690v2.g("map", 1, r0);
        r0 = r3.b((com.google.android.gms.internal.measurement.C0663s) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x0461, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.C0671t) == false) goto L_0x0476;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x0467, code lost:
        if (r15.n() != 0) goto L_0x046f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x046e, code lost:
        return new com.google.android.gms.internal.measurement.C0560g();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x0475, code lost:
        return a(r15, r3, (com.google.android.gms.internal.measurement.C0671t) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x047b, code lost:
        throw new java.lang.IllegalArgumentException(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x047c, code lost:
        r15 = r25;
        r3 = r26;
        r0 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x0486, code lost:
        if (r0.isEmpty() != false) goto L_0x04f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x0488, code lost:
        r1 = new com.google.android.gms.internal.measurement.C0560g();
        r0 = r0.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x0495, code lost:
        if (r0.hasNext() == false) goto L_0x04b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:0x0497, code lost:
        r2 = r3.b((com.google.android.gms.internal.measurement.C0663s) r0.next());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:0x04a3, code lost:
        if ((r2 instanceof com.google.android.gms.internal.measurement.C0605l) != false) goto L_0x04a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:0x04a5, code lost:
        r1.m(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x04b0, code lost:
        throw new java.lang.IllegalStateException("Argument evaluation failed");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x04b1, code lost:
        r0 = r1.n();
        r2 = r15.s();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x04bd, code lost:
        if (r2.hasNext() == false) goto L_0x04d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x04bf, code lost:
        r3 = (java.lang.Integer) r2.next();
        r1.q(r3.intValue() + r0, r15.k(r3.intValue()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x04d6, code lost:
        r15.u();
        r0 = r1.s();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:0x04e1, code lost:
        if (r0.hasNext() == false) goto L_0x04f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:235:0x04e3, code lost:
        r2 = (java.lang.Integer) r0.next();
        r15.q(r2.intValue(), r1.k(r2.intValue()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x0507, code lost:
        return new com.google.android.gms.internal.measurement.C0596k(java.lang.Double.valueOf((double) r15.n()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x0508, code lost:
        r15 = r25;
        r3 = r26;
        r0 = r27;
        r4 = r16;
        com.google.android.gms.internal.measurement.C0690v2.n("lastIndexOf", 2, r0);
        r1 = com.google.android.gms.internal.measurement.C0663s.f2138b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:0x0519, code lost:
        if (r0.isEmpty() != false) goto L_0x0526;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x051b, code lost:
        r1 = r3.b((com.google.android.gms.internal.measurement.C0663s) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:0x0526, code lost:
        r6 = (double) (r15.n() - 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x0531, code lost:
        if (r0.size() <= 1) goto L_0x056d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x0533, code lost:
        r0 = r3.b((com.google.android.gms.internal.measurement.C0663s) r0.get(1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:0x0549, code lost:
        if (java.lang.Double.isNaN(r0.D().doubleValue()) == false) goto L_0x0555;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:0x054b, code lost:
        r2 = (double) (r15.n() - 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:246:0x0551, code lost:
        r6 = r2;
        r19 = 0.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:0x0555, code lost:
        r2 = com.google.android.gms.internal.measurement.C0690v2.a(r0.D().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:0x0564, code lost:
        if (r6 >= 0.0d) goto L_0x056f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:0x0566, code lost:
        r6 = r6 + ((double) r15.n());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:251:0x056d, code lost:
        r19 = 0.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:253:0x0571, code lost:
        if (r6 >= r19) goto L_0x0579;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:255:0x0578, code lost:
        return new com.google.android.gms.internal.measurement.C0596k(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:256:0x0579, code lost:
        r0 = (int) java.lang.Math.min((double) r15.n(), r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:257:0x0583, code lost:
        if (r0 < 0) goto L_0x05a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:259:0x0589, code lost:
        if (r15.r(r0) == false) goto L_0x05a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:261:0x0593, code lost:
        if (com.google.android.gms.internal.measurement.C0690v2.h(r15.k(r0), r1) == false) goto L_0x05a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:263:0x059f, code lost:
        return new com.google.android.gms.internal.measurement.C0596k(java.lang.Double.valueOf((double) r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:264:0x05a0, code lost:
        r0 = r0 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:266:0x05a8, code lost:
        return new com.google.android.gms.internal.measurement.C0596k(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:267:0x05a9, code lost:
        r5 = r25;
        r3 = r26;
        r0 = r27;
        r4 = r18;
        com.google.android.gms.internal.measurement.C0690v2.g("forEach", 1, r0);
        r0 = r3.b((com.google.android.gms.internal.measurement.C0663s) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:268:0x05c2, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.C0671t) == false) goto L_0x05d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:270:0x05c8, code lost:
        if (r5.j() != 0) goto L_0x05cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:272:0x05cc, code lost:
        return com.google.android.gms.internal.measurement.C0663s.f2138b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:273:0x05cd, code lost:
        a(r5, r3, (com.google.android.gms.internal.measurement.C0671t) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:274:0x05d4, code lost:
        return com.google.android.gms.internal.measurement.C0663s.f2138b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:276:0x05da, code lost:
        throw new java.lang.IllegalArgumentException(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:277:0x05db, code lost:
        r5 = r25;
        r3 = r26;
        r0 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:278:0x05e5, code lost:
        if (r0.isEmpty() == false) goto L_0x05ed;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:280:0x05ec, code lost:
        return new com.google.android.gms.internal.measurement.C0560g();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:281:0x05ed, code lost:
        r4 = (int) com.google.android.gms.internal.measurement.C0690v2.a(r3.b((com.google.android.gms.internal.measurement.C0663s) r0.get(0)).D().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:282:0x0605, code lost:
        if (r4 >= 0) goto L_0x0611;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:283:0x0607, code lost:
        r4 = java.lang.Math.max(0, r4 + r5.n());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:285:0x0615, code lost:
        if (r4 <= r5.n()) goto L_0x061b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:286:0x0617, code lost:
        r4 = r5.n();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:287:0x061b, code lost:
        r1 = r5.n();
        r6 = new com.google.android.gms.internal.measurement.C0560g();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:288:0x0629, code lost:
        if (r0.size() <= 1) goto L_0x068f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:289:0x062b, code lost:
        r7 = java.lang.Math.max(0, (int) com.google.android.gms.internal.measurement.C0690v2.a(r3.b((com.google.android.gms.internal.measurement.C0663s) r0.get(1)).D().doubleValue()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:290:0x0647, code lost:
        if (r7 <= 0) goto L_0x0661;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:291:0x0649, code lost:
        r8 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:293:0x0650, code lost:
        if (r8 >= java.lang.Math.min(r1, r4 + r7)) goto L_0x0661;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:294:0x0652, code lost:
        r6.m(r5.k(r4));
        r5.p(r4);
        r8 = r8 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:296:0x0665, code lost:
        if (r0.size() <= 2) goto L_0x069f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:297:0x0667, code lost:
        r1 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:299:0x066c, code lost:
        if (r1 >= r0.size()) goto L_0x069f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x003b, code lost:
        r3 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:300:0x066e, code lost:
        r7 = r3.b((com.google.android.gms.internal.measurement.C0663s) r0.get(r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:301:0x067a, code lost:
        if ((r7 instanceof com.google.android.gms.internal.measurement.C0605l) != false) goto L_0x0687;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:302:0x067c, code lost:
        r5.l((r4 + r1) - 2, r7);
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:304:0x068e, code lost:
        throw new java.lang.IllegalArgumentException("Failed to parse elements to add");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:305:0x068f, code lost:
        if (r4 >= r1) goto L_0x069f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:306:0x0691, code lost:
        r6.m(r5.k(r4));
        r5.q(r4, (com.google.android.gms.internal.measurement.C0663s) null);
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:307:0x069f, code lost:
        return r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:309:0x06ab, code lost:
        return c(r25, r26, r27, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:310:0x06ac, code lost:
        r5 = r25;
        r3 = r26;
        r0 = r27;
        r4 = r18;
        com.google.android.gms.internal.measurement.C0690v2.g("filter", 1, r0);
        r0 = r3.b((com.google.android.gms.internal.measurement.C0663s) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:311:0x06c5, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.C0671t) == false) goto L_0x0704;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:313:0x06cb, code lost:
        if (r5.j() != 0) goto L_0x06d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:315:0x06d2, code lost:
        return new com.google.android.gms.internal.measurement.C0560g();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:316:0x06d3, code lost:
        r1 = (com.google.android.gms.internal.measurement.C0560g) r5.b();
        r0 = b(r5, r3, (com.google.android.gms.internal.measurement.C0671t) r0, (java.lang.Boolean) null, java.lang.Boolean.TRUE);
        r2 = new com.google.android.gms.internal.measurement.C0560g();
        r0 = r0.s();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:318:0x06ef, code lost:
        if (r0.hasNext() == false) goto L_0x0703;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:319:0x06f1, code lost:
        r2.m(r1.k(((java.lang.Integer) r0.next()).intValue()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:320:0x0703, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:322:0x0709, code lost:
        throw new java.lang.IllegalArgumentException(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:323:0x070a, code lost:
        r3 = r26;
        r0 = r27;
        r1 = (com.google.android.gms.internal.measurement.C0560g) r25.b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:324:0x071a, code lost:
        if (r0.isEmpty() != false) goto L_0x076b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:325:0x071c, code lost:
        r0 = r0.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:327:0x0724, code lost:
        if (r0.hasNext() == false) goto L_0x076b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:328:0x0726, code lost:
        r2 = r3.b((com.google.android.gms.internal.measurement.C0663s) r0.next());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:329:0x0732, code lost:
        if ((r2 instanceof com.google.android.gms.internal.measurement.C0605l) != false) goto L_0x0763;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:330:0x0734, code lost:
        r4 = r1.n();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:331:0x073a, code lost:
        if ((r2 instanceof com.google.android.gms.internal.measurement.C0560g) == false) goto L_0x075f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:332:0x073c, code lost:
        r2 = (com.google.android.gms.internal.measurement.C0560g) r2;
        r5 = r2.s();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:334:0x0746, code lost:
        if (r5.hasNext() == false) goto L_0x0720;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:335:0x0748, code lost:
        r6 = (java.lang.Integer) r5.next();
        r1.q(r6.intValue() + r4, r2.k(r6.intValue()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:336:0x075f, code lost:
        r1.q(r4, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:338:0x076a, code lost:
        throw new java.lang.IllegalStateException("Failed evaluation of arguments");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:339:0x076b, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:340:0x076c, code lost:
        com.google.android.gms.internal.measurement.C0690v2.g(r3, 0, r27);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:341:0x077d, code lost:
        return new com.google.android.gms.internal.measurement.C0679u(r25.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x003d, code lost:
        r0 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00ef, code lost:
        r3 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0125, code lost:
        switch(r0) {
            case 0: goto L_0x076c;
            case 1: goto L_0x070a;
            case 2: goto L_0x06ac;
            case 3: goto L_0x06a0;
            case 4: goto L_0x05db;
            case 5: goto L_0x05a9;
            case 6: goto L_0x0508;
            case 7: goto L_0x047c;
            case 8: goto L_0x0448;
            case 9: goto L_0x042d;
            case 10: goto L_0x03ec;
            case 11: goto L_0x03b9;
            case 12: goto L_0x0341;
            case 13: goto L_0x02e7;
            case 14: goto L_0x02a6;
            case 15: goto L_0x028d;
            case 16: goto L_0x020a;
            case 17: goto L_0x01fe;
            case 18: goto L_0x01c1;
            case 19: goto L_0x0130;
            default: goto L_0x0128;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x012f, code lost:
        throw new java.lang.IllegalArgumentException("Command not supported");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0130, code lost:
        r0 = r27;
        com.google.android.gms.internal.measurement.C0690v2.n("indexOf", 2, r0);
        r1 = com.google.android.gms.internal.measurement.C0663s.f2138b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x013b, code lost:
        if (r0.isEmpty() != false) goto L_0x014b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x013d, code lost:
        r3 = r26;
        r1 = r3.b((com.google.android.gms.internal.measurement.C0663s) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x014b, code lost:
        r3 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0152, code lost:
        if (r0.size() <= 1) goto L_0x0188;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0154, code lost:
        r2 = com.google.android.gms.internal.measurement.C0690v2.a(r3.b((com.google.android.gms.internal.measurement.C0663s) r0.get(1)).D().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0171, code lost:
        if (r2 < ((double) r25.n())) goto L_0x017b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x017a, code lost:
        return new com.google.android.gms.internal.measurement.C0596k(r16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x017b, code lost:
        r4 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x017f, code lost:
        if (r2 >= 0.0d) goto L_0x018c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0181, code lost:
        r2 = r2 + ((double) r25.n());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0188, code lost:
        r4 = r16;
        r2 = 0.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x018c, code lost:
        r0 = r25.s();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0194, code lost:
        if (r0.hasNext() == false) goto L_0x01bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0196, code lost:
        r5 = ((java.lang.Integer) r0.next()).intValue();
        r6 = (double) r5;
        r15 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01a5, code lost:
        if (r6 < r2) goto L_0x0190;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01af, code lost:
        if (com.google.android.gms.internal.measurement.C0690v2.h(r15.k(r5), r1) == false) goto L_0x0190;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01ba, code lost:
        return new com.google.android.gms.internal.measurement.C0596k(java.lang.Double.valueOf(r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01c0, code lost:
        return new com.google.android.gms.internal.measurement.C0596k(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01c1, code lost:
        r15 = r25;
        com.google.android.gms.internal.measurement.C0690v2.g("reverse", 0, r27);
        r0 = r15.n();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01cd, code lost:
        if (r0 == 0) goto L_0x01fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01cf, code lost:
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01d2, code lost:
        if (r3 >= (r0 / 2)) goto L_0x01fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01d8, code lost:
        if (r15.r(r3) == false) goto L_0x01f8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.measurement.C0663s d(java.lang.String r24, com.google.android.gms.internal.measurement.C0560g r25, com.google.android.gms.internal.measurement.Z2 r26, java.util.List r27) {
        /*
            r0 = r24
            java.lang.String r4 = "indexOf"
            java.lang.String r5 = "reverse"
            java.lang.String r6 = "slice"
            java.lang.String r7 = "shift"
            java.lang.String r8 = "every"
            java.lang.String r9 = "sort"
            java.lang.String r10 = "some"
            java.lang.String r11 = "join"
            java.lang.String r12 = "pop"
            java.lang.String r13 = "map"
            java.lang.String r14 = "lastIndexOf"
            java.lang.String r15 = "forEach"
            java.lang.String r1 = "filter"
            java.lang.String r2 = "toString"
            r0.getClass()
            r16 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            java.lang.Double r3 = java.lang.Double.valueOf(r16)
            r16 = r3
            java.lang.String r3 = "Callback should be a method"
            r17 = r2
            r18 = r3
            r19 = 0
            r2 = 2
            r22 = -1
            int r23 = r0.hashCode()
            switch(r23) {
                case -1776922004: goto L_0x011a;
                case -1354795244: goto L_0x010c;
                case -1274492040: goto L_0x0100;
                case -934873754: goto L_0x00f2;
                case -895859076: goto L_0x00e4;
                case -678635926: goto L_0x00da;
                case -467511597: goto L_0x00d0;
                case -277637751: goto L_0x00c4;
                case 107868: goto L_0x00b9;
                case 111185: goto L_0x00af;
                case 3267882: goto L_0x00a5;
                case 3452698: goto L_0x0099;
                case 3536116: goto L_0x008f;
                case 3536286: goto L_0x0084;
                case 96891675: goto L_0x0079;
                case 109407362: goto L_0x006e;
                case 109526418: goto L_0x0063;
                case 965561430: goto L_0x0056;
                case 1099846370: goto L_0x004b;
                case 1943291465: goto L_0x0040;
                default: goto L_0x003b;
            }
        L_0x003b:
            r3 = r17
        L_0x003d:
            r0 = -1
            goto L_0x0125
        L_0x0040:
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L_0x0047
            goto L_0x003b
        L_0x0047:
            r0 = 19
            goto L_0x00ef
        L_0x004b:
            boolean r0 = r0.equals(r5)
            if (r0 != 0) goto L_0x0052
            goto L_0x003b
        L_0x0052:
            r0 = 18
            goto L_0x00ef
        L_0x0056:
            java.lang.String r3 = "reduceRight"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x005f
            goto L_0x003b
        L_0x005f:
            r0 = 17
            goto L_0x00ef
        L_0x0063:
            boolean r0 = r0.equals(r6)
            if (r0 != 0) goto L_0x006a
            goto L_0x003b
        L_0x006a:
            r0 = 16
            goto L_0x00ef
        L_0x006e:
            boolean r0 = r0.equals(r7)
            if (r0 != 0) goto L_0x0075
            goto L_0x003b
        L_0x0075:
            r0 = 15
            goto L_0x00ef
        L_0x0079:
            boolean r0 = r0.equals(r8)
            if (r0 != 0) goto L_0x0080
            goto L_0x003b
        L_0x0080:
            r0 = 14
            goto L_0x00ef
        L_0x0084:
            boolean r0 = r0.equals(r9)
            if (r0 != 0) goto L_0x008b
            goto L_0x003b
        L_0x008b:
            r0 = 13
            goto L_0x00ef
        L_0x008f:
            boolean r0 = r0.equals(r10)
            if (r0 != 0) goto L_0x0096
            goto L_0x003b
        L_0x0096:
            r0 = 12
            goto L_0x00ef
        L_0x0099:
            java.lang.String r3 = "push"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x00a2
            goto L_0x003b
        L_0x00a2:
            r0 = 11
            goto L_0x00ef
        L_0x00a5:
            boolean r0 = r0.equals(r11)
            if (r0 != 0) goto L_0x00ac
            goto L_0x003b
        L_0x00ac:
            r0 = 10
            goto L_0x00ef
        L_0x00af:
            boolean r0 = r0.equals(r12)
            if (r0 != 0) goto L_0x00b6
            goto L_0x003b
        L_0x00b6:
            r0 = 9
            goto L_0x00ef
        L_0x00b9:
            boolean r0 = r0.equals(r13)
            if (r0 != 0) goto L_0x00c1
            goto L_0x003b
        L_0x00c1:
            r0 = 8
            goto L_0x00ef
        L_0x00c4:
            java.lang.String r3 = "unshift"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x00ce
            goto L_0x003b
        L_0x00ce:
            r0 = 7
            goto L_0x00ef
        L_0x00d0:
            boolean r0 = r0.equals(r14)
            if (r0 != 0) goto L_0x00d8
            goto L_0x003b
        L_0x00d8:
            r0 = 6
            goto L_0x00ef
        L_0x00da:
            boolean r0 = r0.equals(r15)
            if (r0 != 0) goto L_0x00e2
            goto L_0x003b
        L_0x00e2:
            r0 = 5
            goto L_0x00ef
        L_0x00e4:
            java.lang.String r3 = "splice"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x00ee
            goto L_0x003b
        L_0x00ee:
            r0 = 4
        L_0x00ef:
            r3 = r17
            goto L_0x0125
        L_0x00f2:
            java.lang.String r3 = "reduce"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x00fc
            goto L_0x003b
        L_0x00fc:
            r3 = r17
            r0 = 3
            goto L_0x0125
        L_0x0100:
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0108
            goto L_0x003b
        L_0x0108:
            r3 = r17
            r0 = 2
            goto L_0x0125
        L_0x010c:
            java.lang.String r3 = "concat"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x0116
            goto L_0x003b
        L_0x0116:
            r3 = r17
            r0 = 1
            goto L_0x0125
        L_0x011a:
            r3 = r17
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x0124
            goto L_0x003d
        L_0x0124:
            r0 = 0
        L_0x0125:
            switch(r0) {
                case 0: goto L_0x076c;
                case 1: goto L_0x070a;
                case 2: goto L_0x06ac;
                case 3: goto L_0x06a0;
                case 4: goto L_0x05db;
                case 5: goto L_0x05a9;
                case 6: goto L_0x0508;
                case 7: goto L_0x047c;
                case 8: goto L_0x0448;
                case 9: goto L_0x042d;
                case 10: goto L_0x03ec;
                case 11: goto L_0x03b9;
                case 12: goto L_0x0341;
                case 13: goto L_0x02e7;
                case 14: goto L_0x02a6;
                case 15: goto L_0x028d;
                case 16: goto L_0x020a;
                case 17: goto L_0x01fe;
                case 18: goto L_0x01c1;
                case 19: goto L_0x0130;
                default: goto L_0x0128;
            }
        L_0x0128:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Command not supported"
            r0.<init>(r1)
            throw r0
        L_0x0130:
            r0 = r27
            com.google.android.gms.internal.measurement.C0690v2.n(r4, r2, r0)
            com.google.android.gms.internal.measurement.s r1 = com.google.android.gms.internal.measurement.C0663s.f2138b0
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto L_0x014b
            r2 = 0
            java.lang.Object r1 = r0.get(r2)
            com.google.android.gms.internal.measurement.s r1 = (com.google.android.gms.internal.measurement.C0663s) r1
            r3 = r26
            com.google.android.gms.internal.measurement.s r1 = r3.b(r1)
            goto L_0x014d
        L_0x014b:
            r3 = r26
        L_0x014d:
            int r2 = r0.size()
            r4 = 1
            if (r2 <= r4) goto L_0x0188
            java.lang.Object r0 = r0.get(r4)
            com.google.android.gms.internal.measurement.s r0 = (com.google.android.gms.internal.measurement.C0663s) r0
            com.google.android.gms.internal.measurement.s r0 = r3.b(r0)
            java.lang.Double r0 = r0.D()
            double r2 = r0.doubleValue()
            double r2 = com.google.android.gms.internal.measurement.C0690v2.a(r2)
            int r0 = r25.n()
            double r4 = (double) r0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 < 0) goto L_0x017b
            com.google.android.gms.internal.measurement.k r0 = new com.google.android.gms.internal.measurement.k
            r4 = r16
            r0.<init>(r4)
            return r0
        L_0x017b:
            r4 = r16
            int r0 = (r2 > r19 ? 1 : (r2 == r19 ? 0 : -1))
            if (r0 >= 0) goto L_0x018c
            int r0 = r25.n()
            double r5 = (double) r0
            double r2 = r2 + r5
            goto L_0x018c
        L_0x0188:
            r4 = r16
            r2 = r19
        L_0x018c:
            java.util.Iterator r0 = r25.s()
        L_0x0190:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x01bb
            java.lang.Object r5 = r0.next()
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            double r6 = (double) r5
            int r8 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            r15 = r25
            if (r8 < 0) goto L_0x0190
            com.google.android.gms.internal.measurement.s r5 = r15.k(r5)
            boolean r5 = com.google.android.gms.internal.measurement.C0690v2.h(r5, r1)
            if (r5 == 0) goto L_0x0190
            com.google.android.gms.internal.measurement.k r0 = new com.google.android.gms.internal.measurement.k
            java.lang.Double r1 = java.lang.Double.valueOf(r6)
            r0.<init>(r1)
            return r0
        L_0x01bb:
            com.google.android.gms.internal.measurement.k r0 = new com.google.android.gms.internal.measurement.k
            r0.<init>(r4)
            return r0
        L_0x01c1:
            r15 = r25
            r0 = r27
            r1 = 0
            com.google.android.gms.internal.measurement.C0690v2.g(r5, r1, r0)
            int r0 = r15.n()
            if (r0 == 0) goto L_0x01fd
            r3 = 0
        L_0x01d0:
            int r1 = r0 / 2
            if (r3 >= r1) goto L_0x01fd
            boolean r1 = r15.r(r3)
            if (r1 == 0) goto L_0x01f8
            com.google.android.gms.internal.measurement.s r1 = r15.k(r3)
            r4 = 0
            r15.q(r3, r4)
            r23 = 1
            int r4 = r0 + -1
            int r4 = r4 - r3
            boolean r5 = r15.r(r4)
            if (r5 == 0) goto L_0x01f4
            com.google.android.gms.internal.measurement.s r5 = r15.k(r4)
            r15.q(r3, r5)
        L_0x01f4:
            r15.q(r4, r1)
            goto L_0x01fa
        L_0x01f8:
            r23 = 1
        L_0x01fa:
            int r3 = r3 + 1
            goto L_0x01d0
        L_0x01fd:
            return r15
        L_0x01fe:
            r15 = r25
            r3 = r26
            r0 = r27
            r1 = 0
            com.google.android.gms.internal.measurement.s r0 = c(r15, r3, r0, r1)
            return r0
        L_0x020a:
            r15 = r25
            r3 = r26
            r0 = r27
            r1 = 0
            com.google.android.gms.internal.measurement.C0690v2.n(r6, r2, r0)
            boolean r4 = r0.isEmpty()
            if (r4 == 0) goto L_0x021f
            com.google.android.gms.internal.measurement.s r0 = r15.b()
            return r0
        L_0x021f:
            int r4 = r15.n()
            double r4 = (double) r4
            java.lang.Object r1 = r0.get(r1)
            com.google.android.gms.internal.measurement.s r1 = (com.google.android.gms.internal.measurement.C0663s) r1
            com.google.android.gms.internal.measurement.s r1 = r3.b(r1)
            java.lang.Double r1 = r1.D()
            double r6 = r1.doubleValue()
            double r6 = com.google.android.gms.internal.measurement.C0690v2.a(r6)
            int r1 = (r6 > r19 ? 1 : (r6 == r19 ? 0 : -1))
            if (r1 >= 0) goto L_0x0246
            double r6 = r6 + r4
            r8 = r19
            double r6 = java.lang.Math.max(r6, r8)
            goto L_0x024a
        L_0x0246:
            double r6 = java.lang.Math.min(r6, r4)
        L_0x024a:
            int r1 = r0.size()
            if (r1 != r2) goto L_0x0277
            r1 = 1
            java.lang.Object r0 = r0.get(r1)
            com.google.android.gms.internal.measurement.s r0 = (com.google.android.gms.internal.measurement.C0663s) r0
            com.google.android.gms.internal.measurement.s r0 = r3.b(r0)
            java.lang.Double r0 = r0.D()
            double r0 = r0.doubleValue()
            double r0 = com.google.android.gms.internal.measurement.C0690v2.a(r0)
            r8 = 0
            int r2 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r2 >= 0) goto L_0x0273
            double r4 = r4 + r0
            double r4 = java.lang.Math.max(r4, r8)
            goto L_0x0277
        L_0x0273:
            double r4 = java.lang.Math.min(r4, r0)
        L_0x0277:
            com.google.android.gms.internal.measurement.g r0 = new com.google.android.gms.internal.measurement.g
            r0.<init>()
            int r1 = (int) r6
        L_0x027d:
            double r2 = (double) r1
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 >= 0) goto L_0x028c
            com.google.android.gms.internal.measurement.s r2 = r15.k(r1)
            r0.m(r2)
            r2 = 1
            int r1 = r1 + r2
            goto L_0x027d
        L_0x028c:
            return r0
        L_0x028d:
            r15 = r25
            r0 = r27
            r1 = 0
            com.google.android.gms.internal.measurement.C0690v2.g(r7, r1, r0)
            int r0 = r15.n()
            if (r0 != 0) goto L_0x029e
            com.google.android.gms.internal.measurement.s r0 = com.google.android.gms.internal.measurement.C0663s.f2138b0
            return r0
        L_0x029e:
            com.google.android.gms.internal.measurement.s r0 = r15.k(r1)
            r15.p(r1)
            return r0
        L_0x02a6:
            r15 = r25
            r3 = r26
            r0 = r27
            r1 = 0
            r2 = 1
            com.google.android.gms.internal.measurement.C0690v2.g(r8, r2, r0)
            java.lang.Object r0 = r0.get(r1)
            com.google.android.gms.internal.measurement.s r0 = (com.google.android.gms.internal.measurement.C0663s) r0
            com.google.android.gms.internal.measurement.s r0 = r3.b(r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.C0671t
            if (r1 == 0) goto L_0x02df
            int r1 = r15.n()
            if (r1 == 0) goto L_0x02dc
            com.google.android.gms.internal.measurement.t r0 = (com.google.android.gms.internal.measurement.C0671t) r0
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            com.google.android.gms.internal.measurement.g r0 = b(r15, r3, r0, r1, r2)
            int r0 = r0.n()
            int r1 = r15.n()
            if (r0 == r1) goto L_0x02dc
            com.google.android.gms.internal.measurement.s r0 = com.google.android.gms.internal.measurement.C0663s.f2144h0
            return r0
        L_0x02dc:
            com.google.android.gms.internal.measurement.s r0 = com.google.android.gms.internal.measurement.C0663s.f2143g0
            return r0
        L_0x02df:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r4 = r18
            r0.<init>(r4)
            throw r0
        L_0x02e7:
            r15 = r25
            r3 = r26
            r0 = r27
            r1 = 1
            com.google.android.gms.internal.measurement.C0690v2.n(r9, r1, r0)
            int r1 = r15.n()
            if (r1 < r2) goto L_0x0340
            java.util.List r1 = r15.t()
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto L_0x031b
            r2 = 0
            java.lang.Object r0 = r0.get(r2)
            com.google.android.gms.internal.measurement.s r0 = (com.google.android.gms.internal.measurement.C0663s) r0
            com.google.android.gms.internal.measurement.s r0 = r3.b(r0)
            boolean r2 = r0 instanceof com.google.android.gms.internal.measurement.C0623n
            if (r2 == 0) goto L_0x0313
            com.google.android.gms.internal.measurement.n r0 = (com.google.android.gms.internal.measurement.C0623n) r0
            goto L_0x031c
        L_0x0313:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Comparator should be a method"
            r0.<init>(r1)
            throw r0
        L_0x031b:
            r0 = 0
        L_0x031c:
            com.google.android.gms.internal.measurement.K r2 = new com.google.android.gms.internal.measurement.K
            r2.<init>(r0, r3)
            java.util.Collections.sort(r1, r2)
            r15.u()
            java.util.Iterator r0 = r1.iterator()
            r3 = 0
        L_0x032c:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0340
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.measurement.s r1 = (com.google.android.gms.internal.measurement.C0663s) r1
            r5 = 1
            int r2 = r3 + 1
            r15.q(r3, r1)
            r3 = r2
            goto L_0x032c
        L_0x0340:
            return r15
        L_0x0341:
            r15 = r25
            r3 = r26
            r0 = r27
            r4 = r18
            r5 = 1
            com.google.android.gms.internal.measurement.C0690v2.g(r10, r5, r0)
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            com.google.android.gms.internal.measurement.s r0 = (com.google.android.gms.internal.measurement.C0663s) r0
            com.google.android.gms.internal.measurement.s r0 = r3.b(r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.C0623n
            if (r1 == 0) goto L_0x03b3
            int r1 = r15.n()
            if (r1 == 0) goto L_0x03b0
            com.google.android.gms.internal.measurement.n r0 = (com.google.android.gms.internal.measurement.C0623n) r0
            java.util.Iterator r1 = r15.s()
        L_0x0368:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x03b0
            java.lang.Object r4 = r1.next()
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            boolean r5 = r15.r(r4)
            if (r5 == 0) goto L_0x03ae
            com.google.android.gms.internal.measurement.s r5 = r15.k(r4)
            com.google.android.gms.internal.measurement.k r6 = new com.google.android.gms.internal.measurement.k
            double r7 = (double) r4
            java.lang.Double r4 = java.lang.Double.valueOf(r7)
            r6.<init>(r4)
            r4 = 3
            com.google.android.gms.internal.measurement.s[] r7 = new com.google.android.gms.internal.measurement.C0663s[r4]
            r21 = 0
            r7[r21] = r5
            r23 = 1
            r7[r23] = r6
            r7[r2] = r15
            java.util.List r5 = java.util.Arrays.asList(r7)
            com.google.android.gms.internal.measurement.s r5 = r0.a(r3, r5)
            java.lang.Boolean r5 = r5.C()
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x0368
            com.google.android.gms.internal.measurement.s r0 = com.google.android.gms.internal.measurement.C0663s.f2143g0
            return r0
        L_0x03ae:
            r4 = 3
            goto L_0x0368
        L_0x03b0:
            com.google.android.gms.internal.measurement.s r0 = com.google.android.gms.internal.measurement.C0663s.f2144h0
            return r0
        L_0x03b3:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r4)
            throw r0
        L_0x03b9:
            r15 = r25
            r3 = r26
            r0 = r27
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x03dd
            java.util.Iterator r0 = r0.iterator()
        L_0x03c9:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x03dd
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.measurement.s r1 = (com.google.android.gms.internal.measurement.C0663s) r1
            com.google.android.gms.internal.measurement.s r1 = r3.b(r1)
            r15.m(r1)
            goto L_0x03c9
        L_0x03dd:
            com.google.android.gms.internal.measurement.k r0 = new com.google.android.gms.internal.measurement.k
            int r1 = r15.n()
            double r1 = (double) r1
            java.lang.Double r1 = java.lang.Double.valueOf(r1)
            r0.<init>(r1)
            return r0
        L_0x03ec:
            r15 = r25
            r3 = r26
            r0 = r27
            r1 = 1
            com.google.android.gms.internal.measurement.C0690v2.n(r11, r1, r0)
            int r1 = r15.n()
            if (r1 != 0) goto L_0x03ff
            com.google.android.gms.internal.measurement.s r0 = com.google.android.gms.internal.measurement.C0663s.f2145i0
            return r0
        L_0x03ff:
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x0421
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            com.google.android.gms.internal.measurement.s r0 = (com.google.android.gms.internal.measurement.C0663s) r0
            com.google.android.gms.internal.measurement.s r0 = r3.b(r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.C0648q
            if (r1 != 0) goto L_0x041e
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.C0719z
            if (r1 == 0) goto L_0x0419
            goto L_0x041e
        L_0x0419:
            java.lang.String r0 = r0.E()
            goto L_0x0423
        L_0x041e:
            java.lang.String r0 = ""
            goto L_0x0423
        L_0x0421:
            java.lang.String r0 = ","
        L_0x0423:
            com.google.android.gms.internal.measurement.u r1 = new com.google.android.gms.internal.measurement.u
            java.lang.String r0 = r15.o(r0)
            r1.<init>(r0)
            return r1
        L_0x042d:
            r15 = r25
            r0 = r27
            r1 = 0
            com.google.android.gms.internal.measurement.C0690v2.g(r12, r1, r0)
            int r0 = r15.n()
            if (r0 != 0) goto L_0x043e
            com.google.android.gms.internal.measurement.s r0 = com.google.android.gms.internal.measurement.C0663s.f2138b0
            return r0
        L_0x043e:
            r2 = 1
            int r0 = r0 - r2
            com.google.android.gms.internal.measurement.s r1 = r15.k(r0)
            r15.p(r0)
            return r1
        L_0x0448:
            r15 = r25
            r3 = r26
            r0 = r27
            r4 = r18
            r1 = 0
            r2 = 1
            com.google.android.gms.internal.measurement.C0690v2.g(r13, r2, r0)
            java.lang.Object r0 = r0.get(r1)
            com.google.android.gms.internal.measurement.s r0 = (com.google.android.gms.internal.measurement.C0663s) r0
            com.google.android.gms.internal.measurement.s r0 = r3.b(r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.C0671t
            if (r1 == 0) goto L_0x0476
            int r1 = r15.n()
            if (r1 != 0) goto L_0x046f
            com.google.android.gms.internal.measurement.g r0 = new com.google.android.gms.internal.measurement.g
            r0.<init>()
            return r0
        L_0x046f:
            com.google.android.gms.internal.measurement.t r0 = (com.google.android.gms.internal.measurement.C0671t) r0
            com.google.android.gms.internal.measurement.g r0 = a(r15, r3, r0)
            return r0
        L_0x0476:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r4)
            throw r0
        L_0x047c:
            r15 = r25
            r3 = r26
            r0 = r27
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x04f9
            com.google.android.gms.internal.measurement.g r1 = new com.google.android.gms.internal.measurement.g
            r1.<init>()
            java.util.Iterator r0 = r0.iterator()
        L_0x0491:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x04b1
            java.lang.Object r2 = r0.next()
            com.google.android.gms.internal.measurement.s r2 = (com.google.android.gms.internal.measurement.C0663s) r2
            com.google.android.gms.internal.measurement.s r2 = r3.b(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.measurement.C0605l
            if (r4 != 0) goto L_0x04a9
            r1.m(r2)
            goto L_0x0491
        L_0x04a9:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Argument evaluation failed"
            r0.<init>(r1)
            throw r0
        L_0x04b1:
            int r0 = r1.n()
            java.util.Iterator r2 = r15.s()
        L_0x04b9:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x04d6
            java.lang.Object r3 = r2.next()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r4 = r3.intValue()
            int r4 = r4 + r0
            int r3 = r3.intValue()
            com.google.android.gms.internal.measurement.s r3 = r15.k(r3)
            r1.q(r4, r3)
            goto L_0x04b9
        L_0x04d6:
            r15.u()
            java.util.Iterator r0 = r1.s()
        L_0x04dd:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x04f9
            java.lang.Object r2 = r0.next()
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r3 = r2.intValue()
            int r2 = r2.intValue()
            com.google.android.gms.internal.measurement.s r2 = r1.k(r2)
            r15.q(r3, r2)
            goto L_0x04dd
        L_0x04f9:
            com.google.android.gms.internal.measurement.k r0 = new com.google.android.gms.internal.measurement.k
            int r1 = r15.n()
            double r1 = (double) r1
            java.lang.Double r1 = java.lang.Double.valueOf(r1)
            r0.<init>(r1)
            return r0
        L_0x0508:
            r15 = r25
            r3 = r26
            r0 = r27
            r4 = r16
            com.google.android.gms.internal.measurement.C0690v2.n(r14, r2, r0)
            com.google.android.gms.internal.measurement.s r1 = com.google.android.gms.internal.measurement.C0663s.f2138b0
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto L_0x0526
            r2 = 0
            java.lang.Object r1 = r0.get(r2)
            com.google.android.gms.internal.measurement.s r1 = (com.google.android.gms.internal.measurement.C0663s) r1
            com.google.android.gms.internal.measurement.s r1 = r3.b(r1)
        L_0x0526:
            int r2 = r15.n()
            r5 = 1
            int r2 = r2 - r5
            double r6 = (double) r2
            int r2 = r0.size()
            if (r2 <= r5) goto L_0x056d
            java.lang.Object r0 = r0.get(r5)
            com.google.android.gms.internal.measurement.s r0 = (com.google.android.gms.internal.measurement.C0663s) r0
            com.google.android.gms.internal.measurement.s r0 = r3.b(r0)
            java.lang.Double r2 = r0.D()
            double r2 = r2.doubleValue()
            boolean r2 = java.lang.Double.isNaN(r2)
            if (r2 == 0) goto L_0x0555
            int r0 = r15.n()
            int r0 = r0 - r5
            double r2 = (double) r0
        L_0x0551:
            r6 = r2
            r19 = 0
            goto L_0x0562
        L_0x0555:
            java.lang.Double r0 = r0.D()
            double r2 = r0.doubleValue()
            double r2 = com.google.android.gms.internal.measurement.C0690v2.a(r2)
            goto L_0x0551
        L_0x0562:
            int r0 = (r6 > r19 ? 1 : (r6 == r19 ? 0 : -1))
            if (r0 >= 0) goto L_0x056f
            int r0 = r15.n()
            double r2 = (double) r0
            double r6 = r6 + r2
            goto L_0x056f
        L_0x056d:
            r19 = 0
        L_0x056f:
            int r0 = (r6 > r19 ? 1 : (r6 == r19 ? 0 : -1))
            if (r0 >= 0) goto L_0x0579
            com.google.android.gms.internal.measurement.k r0 = new com.google.android.gms.internal.measurement.k
            r0.<init>(r4)
            return r0
        L_0x0579:
            int r0 = r15.n()
            double r2 = (double) r0
            double r2 = java.lang.Math.min(r2, r6)
            int r0 = (int) r2
        L_0x0583:
            if (r0 < 0) goto L_0x05a3
            boolean r2 = r15.r(r0)
            if (r2 == 0) goto L_0x05a0
            com.google.android.gms.internal.measurement.s r2 = r15.k(r0)
            boolean r2 = com.google.android.gms.internal.measurement.C0690v2.h(r2, r1)
            if (r2 == 0) goto L_0x05a0
            com.google.android.gms.internal.measurement.k r1 = new com.google.android.gms.internal.measurement.k
            double r2 = (double) r0
            java.lang.Double r0 = java.lang.Double.valueOf(r2)
            r1.<init>(r0)
            return r1
        L_0x05a0:
            int r0 = r0 + -1
            goto L_0x0583
        L_0x05a3:
            com.google.android.gms.internal.measurement.k r0 = new com.google.android.gms.internal.measurement.k
            r0.<init>(r4)
            return r0
        L_0x05a9:
            r5 = r25
            r3 = r26
            r0 = r27
            r4 = r18
            r1 = 1
            com.google.android.gms.internal.measurement.C0690v2.g(r15, r1, r0)
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            com.google.android.gms.internal.measurement.s r0 = (com.google.android.gms.internal.measurement.C0663s) r0
            com.google.android.gms.internal.measurement.s r0 = r3.b(r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.C0671t
            if (r1 == 0) goto L_0x05d5
            int r1 = r5.j()
            if (r1 != 0) goto L_0x05cd
            com.google.android.gms.internal.measurement.s r0 = com.google.android.gms.internal.measurement.C0663s.f2138b0
            return r0
        L_0x05cd:
            com.google.android.gms.internal.measurement.t r0 = (com.google.android.gms.internal.measurement.C0671t) r0
            a(r5, r3, r0)
            com.google.android.gms.internal.measurement.s r0 = com.google.android.gms.internal.measurement.C0663s.f2138b0
            return r0
        L_0x05d5:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r4)
            throw r0
        L_0x05db:
            r5 = r25
            r3 = r26
            r0 = r27
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x05ed
            com.google.android.gms.internal.measurement.g r0 = new com.google.android.gms.internal.measurement.g
            r0.<init>()
            return r0
        L_0x05ed:
            r1 = 0
            java.lang.Object r4 = r0.get(r1)
            com.google.android.gms.internal.measurement.s r4 = (com.google.android.gms.internal.measurement.C0663s) r4
            com.google.android.gms.internal.measurement.s r4 = r3.b(r4)
            java.lang.Double r4 = r4.D()
            double r6 = r4.doubleValue()
            double r6 = com.google.android.gms.internal.measurement.C0690v2.a(r6)
            int r4 = (int) r6
            if (r4 >= 0) goto L_0x0611
            int r6 = r5.n()
            int r4 = r4 + r6
            int r4 = java.lang.Math.max(r1, r4)
            goto L_0x061b
        L_0x0611:
            int r1 = r5.n()
            if (r4 <= r1) goto L_0x061b
            int r4 = r5.n()
        L_0x061b:
            int r1 = r5.n()
            com.google.android.gms.internal.measurement.g r6 = new com.google.android.gms.internal.measurement.g
            r6.<init>()
            int r7 = r0.size()
            r8 = 1
            if (r7 <= r8) goto L_0x068f
            java.lang.Object r7 = r0.get(r8)
            com.google.android.gms.internal.measurement.s r7 = (com.google.android.gms.internal.measurement.C0663s) r7
            com.google.android.gms.internal.measurement.s r7 = r3.b(r7)
            java.lang.Double r7 = r7.D()
            double r7 = r7.doubleValue()
            double r7 = com.google.android.gms.internal.measurement.C0690v2.a(r7)
            int r7 = (int) r7
            r8 = 0
            int r7 = java.lang.Math.max(r8, r7)
            if (r7 <= 0) goto L_0x0661
            r8 = r4
        L_0x064a:
            int r9 = r4 + r7
            int r9 = java.lang.Math.min(r1, r9)
            if (r8 >= r9) goto L_0x0661
            com.google.android.gms.internal.measurement.s r9 = r5.k(r4)
            r6.m(r9)
            r5.p(r4)
            r23 = 1
            int r8 = r8 + 1
            goto L_0x064a
        L_0x0661:
            int r1 = r0.size()
            if (r1 <= r2) goto L_0x069f
            r1 = 2
        L_0x0668:
            int r7 = r0.size()
            if (r1 >= r7) goto L_0x069f
            java.lang.Object r7 = r0.get(r1)
            com.google.android.gms.internal.measurement.s r7 = (com.google.android.gms.internal.measurement.C0663s) r7
            com.google.android.gms.internal.measurement.s r7 = r3.b(r7)
            boolean r8 = r7 instanceof com.google.android.gms.internal.measurement.C0605l
            if (r8 != 0) goto L_0x0687
            int r8 = r4 + r1
            int r8 = r8 - r2
            r5.l(r8, r7)
            r23 = 1
            int r1 = r1 + 1
            goto L_0x0668
        L_0x0687:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Failed to parse elements to add"
            r0.<init>(r1)
            throw r0
        L_0x068f:
            if (r4 >= r1) goto L_0x069f
            com.google.android.gms.internal.measurement.s r0 = r5.k(r4)
            r6.m(r0)
            r0 = 0
            r5.q(r4, r0)
            r2 = 1
            int r4 = r4 + r2
            goto L_0x068f
        L_0x069f:
            return r6
        L_0x06a0:
            r5 = r25
            r3 = r26
            r0 = r27
            r2 = 1
            com.google.android.gms.internal.measurement.s r0 = c(r5, r3, r0, r2)
            return r0
        L_0x06ac:
            r5 = r25
            r3 = r26
            r0 = r27
            r4 = r18
            r2 = 1
            com.google.android.gms.internal.measurement.C0690v2.g(r1, r2, r0)
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            com.google.android.gms.internal.measurement.s r0 = (com.google.android.gms.internal.measurement.C0663s) r0
            com.google.android.gms.internal.measurement.s r0 = r3.b(r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.C0671t
            if (r1 == 0) goto L_0x0704
            int r1 = r5.j()
            if (r1 != 0) goto L_0x06d3
            com.google.android.gms.internal.measurement.g r0 = new com.google.android.gms.internal.measurement.g
            r0.<init>()
            return r0
        L_0x06d3:
            com.google.android.gms.internal.measurement.s r1 = r5.b()
            com.google.android.gms.internal.measurement.g r1 = (com.google.android.gms.internal.measurement.C0560g) r1
            com.google.android.gms.internal.measurement.t r0 = (com.google.android.gms.internal.measurement.C0671t) r0
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            r4 = 0
            com.google.android.gms.internal.measurement.g r0 = b(r5, r3, r0, r4, r2)
            com.google.android.gms.internal.measurement.g r2 = new com.google.android.gms.internal.measurement.g
            r2.<init>()
            java.util.Iterator r0 = r0.s()
        L_0x06eb:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0703
            java.lang.Object r3 = r0.next()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            com.google.android.gms.internal.measurement.s r3 = r1.k(r3)
            r2.m(r3)
            goto L_0x06eb
        L_0x0703:
            return r2
        L_0x0704:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r4)
            throw r0
        L_0x070a:
            r5 = r25
            r3 = r26
            r0 = r27
            com.google.android.gms.internal.measurement.s r1 = r5.b()
            com.google.android.gms.internal.measurement.g r1 = (com.google.android.gms.internal.measurement.C0560g) r1
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto L_0x076b
            java.util.Iterator r0 = r0.iterator()
        L_0x0720:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x076b
            java.lang.Object r2 = r0.next()
            com.google.android.gms.internal.measurement.s r2 = (com.google.android.gms.internal.measurement.C0663s) r2
            com.google.android.gms.internal.measurement.s r2 = r3.b(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.measurement.C0605l
            if (r4 != 0) goto L_0x0763
            int r4 = r1.n()
            boolean r5 = r2 instanceof com.google.android.gms.internal.measurement.C0560g
            if (r5 == 0) goto L_0x075f
            com.google.android.gms.internal.measurement.g r2 = (com.google.android.gms.internal.measurement.C0560g) r2
            java.util.Iterator r5 = r2.s()
        L_0x0742:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0720
            java.lang.Object r6 = r5.next()
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r7 = r6.intValue()
            int r7 = r7 + r4
            int r6 = r6.intValue()
            com.google.android.gms.internal.measurement.s r6 = r2.k(r6)
            r1.q(r7, r6)
            goto L_0x0742
        L_0x075f:
            r1.q(r4, r2)
            goto L_0x0720
        L_0x0763:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Failed evaluation of arguments"
            r0.<init>(r1)
            throw r0
        L_0x076b:
            return r1
        L_0x076c:
            r5 = r25
            r0 = r27
            r1 = 0
            com.google.android.gms.internal.measurement.C0690v2.g(r3, r1, r0)
            com.google.android.gms.internal.measurement.u r0 = new com.google.android.gms.internal.measurement.u
            java.lang.String r1 = r5.toString()
            r0.<init>(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.H.d(java.lang.String, com.google.android.gms.internal.measurement.g, com.google.android.gms.internal.measurement.Z2, java.util.List):com.google.android.gms.internal.measurement.s");
    }
}
