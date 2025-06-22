package E2;

public abstract class v {

    /* renamed from: a  reason: collision with root package name */
    public static final a f6420a = new a();

    public static final class a {
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v29, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v2, resolved type: java.lang.String} */
        /* JADX WARNING: Code restructure failed: missing block: B:169:0x034f, code lost:
            r22 = r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:171:0x0361, code lost:
            r22 = r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:172:0x0363, code lost:
            r0 = r21;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:196:0x0435, code lost:
            r0 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:257:0x0591, code lost:
            r3 = kotlin.jvm.internal.m.m(r3, r0);
            r0 = r24;
            r1 = r25;
            r5 = r20;
            r6 = r22;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:256:0x058c A[LOOP:4: B:246:0x0566->B:256:0x058c, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:297:0x0588 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.String a(E2.s r24, G2.f r25) {
            /*
                r23 = this;
                r0 = r24
                r1 = r25
                r2 = 0
                r3 = 2
                r4 = 1
                java.lang.String r5 = "tcModel"
                kotlin.jvm.internal.m.e(r0, r5)
                java.lang.String r6 = "options"
                kotlin.jvm.internal.m.e(r1, r6)
                G2.j$a r6 = G2.j.f6615a
                kotlin.jvm.internal.m.e(r0, r5)
                z3.e r6 = r0.f6391a
                java.lang.String r7 = "g.j"
                if (r6 == 0) goto L_0x0622
                boolean r8 = r6.f4807h
                if (r8 == 0) goto L_0x0616
                java.lang.String r6 = r6.f4811l
                if (r6 != 0) goto L_0x0026
                r6 = 0
                goto L_0x0036
            L_0x0026:
                java.util.Locale r8 = java.util.Locale.ROOT
                java.lang.String r9 = "ROOT"
                kotlin.jvm.internal.m.d(r8, r9)
                java.lang.String r6 = r6.toUpperCase(r8)
                java.lang.String r8 = "this as java.lang.String).toUpperCase(locale)"
                kotlin.jvm.internal.m.d(r6, r8)
            L_0x0036:
                if (r6 != 0) goto L_0x003a
                java.lang.String r6 = "EN"
            L_0x003a:
                java.lang.String r8 = "<set-?>"
                kotlin.jvm.internal.m.e(r6, r8)
                r0.f6402l = r6
                if (r1 != 0) goto L_0x0044
                goto L_0x007d
            L_0x0044:
                java.lang.Integer r6 = r1.f6610b
                if (r6 != 0) goto L_0x0049
                goto L_0x007d
            L_0x0049:
                int r6 = r6.intValue()
                if (r6 >= r4) goto L_0x007b
                com.inmobi.cmp.core.model.Vector r8 = r0.f6409s
                r8.unset((int) r4)
                com.inmobi.cmp.core.model.Vector r8 = r0.f6386C
                G2.h r9 = new G2.h
                r9.<init>(r0)
                r8.forEach(r9)
                com.inmobi.cmp.core.model.Vector r8 = r0.f6416z
                G2.i r9 = new G2.i
                r9.<init>(r0)
                r8.forEach(r9)
                z3.e r8 = r0.f6391a
                if (r8 != 0) goto L_0x006d
                goto L_0x007b
            L_0x006d:
                java.util.Map r8 = r8.f4808i
                if (r8 != 0) goto L_0x0072
                goto L_0x007b
            L_0x0072:
                com.inmobi.cmp.core.model.Vector r9 = r0.f6388E
                java.util.Set r8 = r8.keySet()
                r9.set((java.util.Set<java.lang.String>) r8)
            L_0x007b:
                r0.f6399i = r6
            L_0x007d:
                java.util.List r6 = r1.f6611c
                if (r6 == 0) goto L_0x008b
                boolean r6 = r6.isEmpty()
                if (r6 == 0) goto L_0x0088
                goto L_0x008b
            L_0x0088:
                java.util.List r1 = r1.f6611c
                goto L_0x00d7
            L_0x008b:
                kotlin.jvm.internal.m.e(r0, r5)
                E2.l r6 = E2.l.CORE
                E2.l[] r8 = new E2.l[r4]
                r8[r2] = r6
                java.util.List r8 = S2.C1601o.l(r8)
                E2.l[] r9 = new E2.l[r4]
                r9[r2] = r6
                java.util.List r6 = S2.C1601o.l(r9)
                int r9 = r0.f6399i
                if (r9 != r3) goto L_0x00d6
                boolean r8 = r0.f6395e
                if (r8 == 0) goto L_0x00ae
                E2.l r1 = E2.l.PUBLISHER_TC
                r6.add(r1)
                goto L_0x00d4
            L_0x00ae:
                java.lang.Boolean r1 = r1.f6609a
                java.lang.Boolean r8 = java.lang.Boolean.TRUE
                kotlin.jvm.internal.m.a(r1, r8)
                E2.l r8 = E2.l.VENDORS_DISCLOSED
                r6.add(r8)
                if (r1 == 0) goto L_0x00d4
                boolean r1 = r1.booleanValue()
                if (r1 == 0) goto L_0x00d4
                com.inmobi.cmp.core.model.Vector r1 = r0.f6389F
                int r1 = r1.size()
                if (r1 <= 0) goto L_0x00cf
                E2.l r1 = E2.l.VENDORS_ALLOWED
                r6.add(r1)
            L_0x00cf:
                E2.l r1 = E2.l.PUBLISHER_TC
                r6.add(r1)
            L_0x00d4:
                r1 = r6
                goto L_0x00d7
            L_0x00d6:
                r1 = r8
            L_0x00d7:
                java.util.Iterator r6 = r1.iterator()
                java.lang.String r8 = ""
                r9 = r8
            L_0x00de:
                boolean r10 = r6.hasNext()
                if (r10 == 0) goto L_0x0615
                java.lang.Object r10 = r6.next()
                E2.l r10 = (E2.l) r10
                int r11 = r1.size()
                int r11 = r11 - r4
                java.lang.Object r11 = r1.get(r11)
                if (r10 == r11) goto L_0x00f8
                java.lang.String r11 = "."
                goto L_0x00f9
            L_0x00f8:
                r11 = r8
            L_0x00f9:
                java.lang.StringBuilder r9 = A2.a.a(r9)
                G2.g$a r12 = G2.g.f6612a
                kotlin.jvm.internal.m.e(r0, r5)
                java.lang.String r12 = "segment"
                kotlin.jvm.internal.m.e(r10, r12)
                int r12 = r0.f6399i
                java.lang.String r13 = "g.g"
                if (r12 == r4) goto L_0x013e
                if (r12 != r3) goto L_0x011a
                java.util.Map r12 = K2.a.f7284c
                java.lang.String r14 = r10.f6375a
                java.lang.Object r12 = r12.get(r14)
                java.lang.String[] r12 = (java.lang.String[]) r12
                goto L_0x0148
            L_0x011a:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r13)
                java.lang.String r2 = ": Unable to encode version: "
                r1.append(r2)
                int r0 = r0.f6399i
                r1.append(r0)
                java.lang.String r0 = ", segment: "
                r1.append(r0)
                r1.append(r10)
                java.lang.String r0 = r1.toString()
                G2.e r1 = new G2.e
                r1.<init>(r0)
                throw r1
            L_0x013e:
                java.util.Map r12 = K2.a.f7283b
                java.lang.String r14 = r10.f6375a
                java.lang.Object r12 = r12.get(r14)
                java.lang.String[] r12 = (java.lang.String[]) r12
            L_0x0148:
                E2.l r14 = E2.l.CORE
                if (r10 == r14) goto L_0x017f
                java.util.Map r14 = E2.m.f6378c
                java.lang.Object r14 = r14.get(r10)
                java.lang.Integer r14 = (java.lang.Integer) r14
                if (r14 != 0) goto L_0x015a
                r3 = 0
                r16 = 2
                goto L_0x017a
            L_0x015a:
                int r14 = r14.intValue()
                G2.c r15 = G2.c.f6592a
                r16 = 2
                G2.d r3 = G2.d.SEGMENT_TYPE
                java.lang.Integer r3 = r15.a(r3)
                I2.d$a r15 = I2.d.f6695a
                java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
                if (r3 != 0) goto L_0x0172
                r3 = 0
                goto L_0x0176
            L_0x0172:
                int r3 = r3.intValue()
            L_0x0176:
                java.lang.String r3 = r15.b(r14, r3)
            L_0x017a:
                java.lang.String r3 = java.lang.String.valueOf(r3)
                goto L_0x0182
            L_0x017f:
                r16 = 2
                r3 = r8
            L_0x0182:
                java.lang.String r14 = "0"
                if (r12 != 0) goto L_0x018e
            L_0x0186:
                r25 = r1
                r20 = r5
                r22 = r6
                goto L_0x05e6
            L_0x018e:
                int r15 = r12.length
                r7 = 0
            L_0x0190:
                if (r7 >= r15) goto L_0x0186
                r17 = 1
                r4 = r12[r7]
                int r7 = r7 + 1
                java.lang.String r2 = "version"
                boolean r2 = kotlin.jvm.internal.m.a(r4, r2)
                if (r2 == 0) goto L_0x01aa
                int r2 = r0.f6399i
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                r25 = r1
                goto L_0x030d
            L_0x01aa:
                java.lang.String r2 = "created"
                boolean r2 = kotlin.jvm.internal.m.a(r4, r2)
                if (r2 == 0) goto L_0x01bc
                r25 = r1
                long r1 = r0.f6392b
                java.lang.Long r2 = java.lang.Long.valueOf(r1)
                goto L_0x030d
            L_0x01bc:
                r25 = r1
                java.lang.String r1 = "lastUpdated"
                boolean r1 = kotlin.jvm.internal.m.a(r4, r1)
                if (r1 == 0) goto L_0x01ce
                long r1 = r0.f6393c
                java.lang.Long r2 = java.lang.Long.valueOf(r1)
                goto L_0x030d
            L_0x01ce:
                java.lang.String r1 = "cmpId"
                boolean r1 = kotlin.jvm.internal.m.a(r4, r1)
                if (r1 == 0) goto L_0x01de
                int r1 = r0.f6403m
                java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
                goto L_0x030d
            L_0x01de:
                java.lang.String r1 = "cmpVersion"
                boolean r1 = kotlin.jvm.internal.m.a(r4, r1)
                if (r1 == 0) goto L_0x01ee
                int r1 = r0.f6404n
                java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
                goto L_0x030d
            L_0x01ee:
                java.lang.String r1 = "consentScreen"
                boolean r1 = kotlin.jvm.internal.m.a(r4, r1)
                if (r1 == 0) goto L_0x01fe
                int r1 = r0.f6400j
                java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
                goto L_0x030d
            L_0x01fe:
                java.lang.String r1 = "consentLanguage"
                boolean r1 = kotlin.jvm.internal.m.a(r4, r1)
                if (r1 == 0) goto L_0x020a
                java.lang.String r2 = r0.f6402l
                goto L_0x030d
            L_0x020a:
                java.lang.String r1 = "vendorListVersion"
                boolean r1 = kotlin.jvm.internal.m.a(r4, r1)
                if (r1 == 0) goto L_0x0229
                z3.e r1 = r0.f6391a
                if (r1 != 0) goto L_0x0218
                r1 = 0
                goto L_0x021a
            L_0x0218:
                java.lang.Integer r1 = r1.f4801b
            L_0x021a:
                if (r1 != 0) goto L_0x021f
                int r1 = r0.f6405o
                goto L_0x0223
            L_0x021f:
                int r1 = r1.intValue()
            L_0x0223:
                java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
                goto L_0x030d
            L_0x0229:
                java.lang.String r1 = "policyVersion"
                boolean r1 = kotlin.jvm.internal.m.a(r4, r1)
                if (r1 == 0) goto L_0x023b
                int r1 = r0.f()
                java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
                goto L_0x030d
            L_0x023b:
                java.lang.String r1 = "isServiceSpecific"
                boolean r1 = kotlin.jvm.internal.m.a(r4, r1)
                if (r1 == 0) goto L_0x024b
                boolean r1 = r0.f6395e
                java.lang.Boolean r2 = java.lang.Boolean.valueOf(r1)
                goto L_0x030d
            L_0x024b:
                java.lang.String r1 = "useNonStandardStacks"
                boolean r1 = kotlin.jvm.internal.m.a(r4, r1)
                if (r1 == 0) goto L_0x025b
                boolean r1 = r0.f6396f
                java.lang.Boolean r2 = java.lang.Boolean.valueOf(r1)
                goto L_0x030d
            L_0x025b:
                java.lang.String r1 = "specialFeatureOptions"
                boolean r1 = kotlin.jvm.internal.m.a(r4, r1)
                if (r1 == 0) goto L_0x0267
                com.inmobi.cmp.core.model.Vector r2 = r0.f6407q
                goto L_0x030d
            L_0x0267:
                java.lang.String r1 = "purposeConsents"
                boolean r1 = kotlin.jvm.internal.m.a(r4, r1)
                if (r1 == 0) goto L_0x0273
                com.inmobi.cmp.core.model.Vector r2 = r0.f6408r
                goto L_0x030d
            L_0x0273:
                java.lang.String r1 = "purposeLegitimateInterests"
                boolean r1 = kotlin.jvm.internal.m.a(r4, r1)
                if (r1 == 0) goto L_0x027f
                com.inmobi.cmp.core.model.Vector r2 = r0.f6409s
                goto L_0x030d
            L_0x027f:
                java.lang.String r1 = "purposeOneTreatment"
                boolean r1 = kotlin.jvm.internal.m.a(r4, r1)
                if (r1 == 0) goto L_0x028f
                boolean r1 = r0.f6397g
                java.lang.Boolean r2 = java.lang.Boolean.valueOf(r1)
                goto L_0x030d
            L_0x028f:
                java.lang.String r1 = "publisherCountryCode"
                boolean r1 = kotlin.jvm.internal.m.a(r4, r1)
                if (r1 == 0) goto L_0x029b
                java.lang.String r2 = r0.f6398h
                goto L_0x030d
            L_0x029b:
                java.lang.String r1 = "vendorConsents"
                boolean r1 = kotlin.jvm.internal.m.a(r4, r1)
                if (r1 == 0) goto L_0x02a7
                com.inmobi.cmp.core.model.Vector r2 = r0.f6416z
                goto L_0x030d
            L_0x02a7:
                java.lang.String r1 = "vendorLegitimateInterests"
                boolean r1 = kotlin.jvm.internal.m.a(r4, r1)
                if (r1 == 0) goto L_0x02b2
                com.inmobi.cmp.core.model.Vector r2 = r0.f6386C
                goto L_0x030d
            L_0x02b2:
                java.lang.String r1 = "publisherRestrictions"
                boolean r1 = kotlin.jvm.internal.m.a(r4, r1)
                if (r1 == 0) goto L_0x02bd
                E2.j r2 = r0.f6390G
                goto L_0x030d
            L_0x02bd:
                java.lang.String r1 = "publisherConsents"
                boolean r1 = kotlin.jvm.internal.m.a(r4, r1)
                if (r1 == 0) goto L_0x02c8
                com.inmobi.cmp.core.model.Vector r2 = r0.f6412v
                goto L_0x030d
            L_0x02c8:
                java.lang.String r1 = "publisherLegitimateInterests"
                boolean r1 = kotlin.jvm.internal.m.a(r4, r1)
                if (r1 == 0) goto L_0x02d3
                com.inmobi.cmp.core.model.Vector r2 = r0.f6413w
                goto L_0x030d
            L_0x02d3:
                java.lang.String r1 = "numCustomPurposes"
                boolean r1 = kotlin.jvm.internal.m.a(r4, r1)
                if (r1 == 0) goto L_0x02e2
                int r1 = r0.f6406p
                java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
                goto L_0x030d
            L_0x02e2:
                java.lang.String r1 = "publisherCustomConsents"
                boolean r1 = kotlin.jvm.internal.m.a(r4, r1)
                if (r1 == 0) goto L_0x02ed
                com.inmobi.cmp.core.model.Vector r2 = r0.f6414x
                goto L_0x030d
            L_0x02ed:
                java.lang.String r1 = "publisherCustomLegitimateInterests"
                boolean r1 = kotlin.jvm.internal.m.a(r4, r1)
                if (r1 == 0) goto L_0x02f8
                com.inmobi.cmp.core.model.Vector r2 = r0.f6415y
                goto L_0x030d
            L_0x02f8:
                java.lang.String r1 = "vendorsAllowed"
                boolean r1 = kotlin.jvm.internal.m.a(r4, r1)
                if (r1 == 0) goto L_0x0303
                com.inmobi.cmp.core.model.Vector r2 = r0.f6389F
                goto L_0x030d
            L_0x0303:
                java.lang.String r1 = "vendorsDisclosed"
                boolean r1 = kotlin.jvm.internal.m.a(r4, r1)
                if (r1 == 0) goto L_0x05c5
                com.inmobi.cmp.core.model.Vector r2 = r0.f6388E
            L_0x030d:
                I2.b r1 = I2.b.f6692a
                java.lang.String r1 = "key"
                kotlin.jvm.internal.m.e(r4, r1)
                java.util.Map r1 = I2.b.f6693b
                java.lang.Object r1 = r1.get(r4)
                java.lang.String r1 = (java.lang.String) r1
                r18 = r2
                G2.c r2 = G2.c.f6592a
                java.lang.Integer r19 = r2.b(r4)
                r20 = r5
                if (r19 != 0) goto L_0x0336
                G2.g$a r5 = G2.g.f6612a
                boolean r5 = r5.a(r4)
                if (r5 == 0) goto L_0x0336
                int r5 = r0.f6406p
                java.lang.Integer r19 = java.lang.Integer.valueOf(r5)
            L_0x0336:
                if (r1 == 0) goto L_0x05a1
                int r5 = r1.hashCode()
                java.lang.String r21 = "1"
                java.lang.String r0 = "value"
                switch(r5) {
                    case -203882031: goto L_0x0520;
                    case 26410996: goto L_0x0507;
                    case 683778315: goto L_0x0483;
                    case 1045601125: goto L_0x0429;
                    case 1210305326: goto L_0x0392;
                    case 1255568750: goto L_0x0367;
                    case 1942709837: goto L_0x0345;
                    default: goto L_0x0343;
                }
            L_0x0343:
                goto L_0x05a1
            L_0x0345:
                java.lang.String r0 = "IntEncoder"
                boolean r0 = r1.equals(r0)
                if (r0 == 0) goto L_0x05a1
                if (r19 != 0) goto L_0x0353
            L_0x034f:
                r22 = r6
                goto L_0x0435
            L_0x0353:
                int r0 = r19.intValue()
                I2.d$a r1 = I2.d.f6695a
                r2 = r18
                java.lang.Integer r2 = (java.lang.Integer) r2
                java.lang.String r21 = r1.b(r2, r0)
            L_0x0361:
                r22 = r6
            L_0x0363:
                r0 = r21
                goto L_0x0591
            L_0x0367:
                java.lang.String r0 = "DateEncoder"
                boolean r0 = r1.equals(r0)
                if (r0 == 0) goto L_0x05a1
                if (r19 != 0) goto L_0x0372
                goto L_0x034f
            L_0x0372:
                int r0 = r19.intValue()
                I2.a$a r1 = I2.a.f6691a
                r2 = r18
                java.lang.Long r2 = (java.lang.Long) r2
                long r1 = r2.longValue()
                I2.d$a r4 = I2.d.f6695a
                r5 = 100
                r18 = r1
                long r1 = (long) r5
                long r1 = r18 / r1
                java.lang.Long r1 = java.lang.Long.valueOf(r1)
                java.lang.String r21 = r4.b(r1, r0)
                goto L_0x0361
            L_0x0392:
                java.lang.String r2 = "LangEncoder"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x05a1
                if (r19 != 0) goto L_0x039d
                goto L_0x034f
            L_0x039d:
                int r1 = r19.intValue()
                I2.e$a r2 = I2.e.f6696a
                r2 = r18
                java.lang.String r2 = (java.lang.String) r2
                kotlin.jvm.internal.m.e(r2, r0)
                java.util.Locale r0 = java.util.Locale.ROOT
                java.lang.String r0 = r2.toUpperCase(r0)
                java.lang.String r2 = "this as java.lang.String).toUpperCase(Locale.ROOT)"
                kotlin.jvm.internal.m.d(r0, r2)
                r5 = 0
                char r2 = r0.charAt(r5)
                int r2 = r2 + -65
                r4 = 1
                char r17 = r0.charAt(r4)
                int r5 = r17 + -65
                java.lang.String r4 = "h.e"
                if (r2 < 0) goto L_0x040f
                r22 = r6
                r6 = 25
                if (r2 > r6) goto L_0x040f
                if (r5 < 0) goto L_0x040f
                if (r5 > r6) goto L_0x040f
                int r0 = r1 % 2
                r6 = 1
                if (r0 == r6) goto L_0x03f0
                int r1 = r1 / 2
                I2.d$a r0 = I2.d.f6695a
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                java.lang.String r2 = r0.b(r2, r1)
                java.lang.Integer r4 = java.lang.Integer.valueOf(r5)
                java.lang.String r0 = r0.b(r4, r1)
                java.lang.String r21 = kotlin.jvm.internal.m.m(r2, r0)
                goto L_0x0363
            L_0x03f0:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r4)
                java.lang.String r2 = ": numBits must be even, "
                r0.append(r2)
                r0.append(r1)
                java.lang.String r1 = " is not valid"
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                G2.e r1 = new G2.e
                r1.<init>(r0)
                throw r1
            L_0x040f:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r4)
                java.lang.String r2 = ": invalid language code: "
                r1.append(r2)
                r1.append(r0)
                java.lang.String r0 = r1.toString()
                G2.e r1 = new G2.e
                r1.<init>(r0)
                throw r1
            L_0x0429:
                r22 = r6
                java.lang.String r2 = "FixedVectorEncoder"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x05a1
                if (r19 != 0) goto L_0x0438
            L_0x0435:
                r0 = 0
                goto L_0x0591
            L_0x0438:
                int r1 = r19.intValue()
                I2.c$a r2 = I2.c.f6694a
                r2 = r18
                com.inmobi.cmp.core.model.Vector r2 = (com.inmobi.cmp.core.model.Vector) r2
                kotlin.jvm.internal.m.e(r2, r0)
                int r0 = r2.size()
                if (r0 > r1) goto L_0x0475
                r4 = 1
                if (r4 > r1) goto L_0x0471
                r5 = r8
                r0 = 1
            L_0x0450:
                int r6 = r0 + 1
                java.lang.Boolean r4 = r2.get(r0)
                if (r4 != 0) goto L_0x045a
                r4 = 0
                goto L_0x045e
            L_0x045a:
                boolean r4 = r4.booleanValue()
            L_0x045e:
                if (r4 == 0) goto L_0x0463
                r4 = r21
                goto L_0x0464
            L_0x0463:
                r4 = r14
            L_0x0464:
                java.lang.String r5 = kotlin.jvm.internal.m.m(r5, r4)
                if (r0 != r1) goto L_0x046e
                r21 = r5
                goto L_0x0363
            L_0x046e:
                r0 = r6
                r4 = 1
                goto L_0x0450
            L_0x0471:
                r21 = r8
                goto L_0x0363
            L_0x0475:
                java.lang.String r0 = "h.c"
                java.lang.String r1 = ": bitfield encoding length mismatch"
                java.lang.String r0 = kotlin.jvm.internal.m.m(r0, r1)
                G2.e r1 = new G2.e
                r1.<init>(r0)
                throw r1
            L_0x0483:
                r22 = r6
                java.lang.String r0 = "PurposeRestrictionVectorEncoder"
                boolean r0 = r1.equals(r0)
                if (r0 == 0) goto L_0x05a1
                I2.g$a r0 = I2.g.f6698a
                r0 = r18
                E2.j r0 = (E2.j) r0
                java.lang.String r1 = "prVector"
                kotlin.jvm.internal.m.e(r0, r1)
                kotlin.jvm.internal.C r1 = new kotlin.jvm.internal.C
                r1.<init>()
                I2.d$a r4 = I2.d.f6695a
                java.util.Map r5 = r0.f6363c
                int r5 = r5.size()
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                G2.d r6 = G2.d.NUM_RESTRICTIONS
                java.lang.Integer r2 = r2.a(r6)
                if (r2 != 0) goto L_0x04b3
                r2 = 0
                goto L_0x04b7
            L_0x04b3:
                int r2 = r2.intValue()
            L_0x04b7:
                java.lang.String r2 = r4.b(r5, r2)
                r1.f20968a = r2
                java.util.Map r2 = r0.f6363c
                boolean r2 = r2.isEmpty()
                if (r2 != 0) goto L_0x04f1
                I2.f r2 = new I2.f
                r2.<init>(r1)
                java.lang.String r4 = "action"
                kotlin.jvm.internal.m.e(r2, r4)
                java.util.Map r0 = r0.f6363c
                java.util.Set r0 = r0.entrySet()
                java.util.Iterator r0 = r0.iterator()
            L_0x04d9:
                boolean r4 = r0.hasNext()
                if (r4 == 0) goto L_0x04ff
                java.lang.Object r4 = r0.next()
                java.util.Map$Entry r4 = (java.util.Map.Entry) r4
                java.lang.Object r5 = r4.getKey()
                java.lang.Object r4 = r4.getValue()
                r2.invoke(r5, r4)
                goto L_0x04d9
            L_0x04f1:
                java.lang.Object r0 = r1.f20968a
                java.lang.String r0 = (java.lang.String) r0
                r2 = 36
                r4 = 48
                java.lang.String r0 = m3.m.W(r0, r2, r4)
                r1.f20968a = r0
            L_0x04ff:
                java.lang.Object r0 = r1.f20968a
                r21 = r0
                java.lang.String r21 = (java.lang.String) r21
                goto L_0x0363
            L_0x0507:
                r22 = r6
                java.lang.String r0 = "BooleanEncoder"
                boolean r0 = r1.equals(r0)
                if (r0 == 0) goto L_0x05a1
                r2 = r18
                java.lang.Boolean r2 = (java.lang.Boolean) r2
                boolean r0 = r2.booleanValue()
                if (r0 == 0) goto L_0x051d
                goto L_0x0363
            L_0x051d:
                r0 = r14
                goto L_0x0591
            L_0x0520:
                r22 = r6
                java.lang.String r5 = "VendorVectorEncoder"
                boolean r1 = r1.equals(r5)
                if (r1 == 0) goto L_0x05a1
                I2.h$a r1 = I2.h.f6699a
                r1 = r18
                com.inmobi.cmp.core.model.Vector r1 = (com.inmobi.cmp.core.model.Vector) r1
                kotlin.jvm.internal.m.e(r1, r0)
                I2.d$a r0 = I2.d.f6695a
                int r4 = r1.getMaxId()
                java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
                G2.d r5 = G2.d.MAX_ID
                java.lang.Integer r2 = r2.a(r5)
                if (r2 != 0) goto L_0x0547
                r2 = 0
                goto L_0x054b
            L_0x0547:
                int r2 = r2.intValue()
            L_0x054b:
                java.lang.String r0 = r0.b(r4, r2)
                java.lang.String r0 = kotlin.jvm.internal.m.m(r8, r0)
                java.lang.String r0 = kotlin.jvm.internal.m.m(r0, r14)
                int r2 = r1.getMaxId()
                if (r2 != 0) goto L_0x055e
                goto L_0x0588
            L_0x055e:
                int r2 = r1.getMaxId()
                r6 = 1
                if (r6 > r2) goto L_0x0588
                r4 = 1
            L_0x0566:
                int r5 = r4 + 1
                boolean r17 = r1.contains(r4)
                if (r17 == 0) goto L_0x057f
                java.lang.Boolean r6 = r1.get(r4)
                r18 = r1
                java.lang.Boolean r1 = java.lang.Boolean.TRUE
                boolean r1 = kotlin.jvm.internal.m.a(r6, r1)
                if (r1 == 0) goto L_0x0581
                r1 = r21
                goto L_0x0582
            L_0x057f:
                r18 = r1
            L_0x0581:
                r1 = r14
            L_0x0582:
                java.lang.String r0 = kotlin.jvm.internal.m.m(r0, r1)
                if (r4 != r2) goto L_0x058c
            L_0x0588:
                r21 = r0
                goto L_0x0363
            L_0x058c:
                r4 = r5
                r1 = r18
                r6 = 1
                goto L_0x0566
            L_0x0591:
                java.lang.String r3 = kotlin.jvm.internal.m.m(r3, r0)
                r0 = r24
                r1 = r25
                r5 = r20
                r6 = r22
                r2 = 0
                r4 = 1
                goto L_0x0190
            L_0x05a1:
                G2.g$a r0 = G2.g.f6612a
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r13)
                java.lang.String r1 = ": Error encoding "
                r0.append(r1)
                r0.append(r10)
                java.lang.String r1 = "->"
                r0.append(r1)
                r0.append(r4)
                java.lang.String r0 = r0.toString()
                G2.e r1 = new G2.e
                r1.<init>(r0)
                throw r1
            L_0x05c5:
                G2.g$a r0 = G2.g.f6612a
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r13)
                java.lang.String r1 = ": Unable to find: "
                r0.append(r1)
                r0.append(r4)
                java.lang.String r1 = " field on TCModel"
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                G2.e r1 = new G2.e
                r1.<init>(r0)
                throw r1
            L_0x05e6:
                G2.a$a r0 = G2.a.f6588a
                int r1 = r3.length()
                int r1 = r1 % 8
                if (r1 == 0) goto L_0x05fa
                int r1 = 8 - r1
                java.lang.String r1 = m3.m.s(r14, r1)
                java.lang.String r3 = kotlin.jvm.internal.m.m(r3, r1)
            L_0x05fa:
                java.lang.String r0 = r0.b(r3)
                r9.append(r0)
                r9.append(r11)
                java.lang.String r9 = r9.toString()
                r0 = r24
                r1 = r25
                r5 = r20
                r6 = r22
                r2 = 0
                r3 = 2
                r4 = 1
                goto L_0x00de
            L_0x0615:
                return r9
            L_0x0616:
                java.lang.String r0 = ": Unable to encode TCModel tcModel.gvl.readyPromise is not resolved"
                java.lang.String r0 = kotlin.jvm.internal.m.m(r7, r0)
                G2.e r1 = new G2.e
                r1.<init>(r0)
                throw r1
            L_0x0622:
                java.lang.String r0 = ": Unable to encode TCModel without a GVL"
                java.lang.String r0 = kotlin.jvm.internal.m.m(r7, r0)
                G2.e r1 = new G2.e
                r1.<init>(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: E2.v.a.a(E2.s, G2.f):java.lang.String");
        }
    }
}
