package B3;

import C2.b;
import C2.c;
import C3.f;
import S2.C1601o;
import b4.d;
import com.inmobi.cmp.core.model.mspa.USRegulationData;
import com.inmobi.cmp.data.storage.SharedStorage;
import com.inmobi.cmp.model.ChoiceError;
import j1.C2091a;
import java.util.List;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import n1.C2164g;
import o1.C2184l;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public C2091a f91a;

    /* renamed from: b  reason: collision with root package name */
    public final f f92b;

    /* renamed from: c  reason: collision with root package name */
    public final SharedStorage f93c;

    /* renamed from: d  reason: collision with root package name */
    public final USRegulationData f94d = new USRegulationData(0, (String) null, 0, 0, 0, 0, 0, 0, 0, 0, 0, (List) null, (List) null, 0, 0, 0, 0, 131071, (C2103g) null);

    public e() {
        d dVar = d.f24465a;
        this.f91a = dVar.g();
        this.f92b = dVar.j();
        this.f93c = dVar.m();
    }

    public final String a() {
        try {
            String d5 = this.f91a.d();
            m.d(d5, "{ gppModel.encode() }");
            return d5;
        } catch (Exception unused) {
            b.a(b.f6277a, ChoiceError.ERROR_WHILE_SAVING_CONSENT, (String) null, (String) null, c.CONSOLE, (Throwable) null, 22);
            return "";
        }
    }

    public String b(A3.b bVar) {
        m.e(bVar, "field");
        switch (bVar.ordinal()) {
            case 0:
                String str = C2164g.f21307b;
                m.d(str, "SHARING_NOTICE");
                return str;
            case 1:
                String str2 = C2164g.f21308c;
                m.d(str2, "SALE_OPT_OUT_NOTICE");
                return str2;
            case 2:
                String str3 = C2164g.f21309d;
                m.d(str3, "SHARING_OPT_OUT_NOTICE");
                return str3;
            case 3:
                String str4 = C2164g.f21310e;
                m.d(str4, "TARGETED_ADVERTISING_OPT_OUT_NOTICE");
                return str4;
            case 4:
                String str5 = C2164g.f21311f;
                m.d(str5, "SENSITIVE_DATA_PROCESSING_OPT_OUT_NOTICE");
                return str5;
            case 5:
                String str6 = C2164g.f21312g;
                m.d(str6, "SENSITIVE_DATA_LIMIT_USE_NOTICE");
                return str6;
            case 6:
                String str7 = C2164g.f21313h;
                m.d(str7, "SALE_OPT_OUT");
                return str7;
            case 7:
                String str8 = C2164g.f21314i;
                m.d(str8, "SHARING_OPT_OUT");
                return str8;
            case 8:
                String str9 = C2164g.f21315j;
                m.d(str9, "TARGETED_ADVERTISING_OPT_OUT");
                return str9;
            case 9:
                String str10 = C2164g.f21316k;
                m.d(str10, "SENSITIVE_DATA_PROCESSING");
                return str10;
            case 10:
                String str11 = C2164g.f21317l;
                m.d(str11, "KNOWN_CHILD_SENSITIVE_DATA_CONSENTS");
                return str11;
            case 11:
                String str12 = C2164g.f21318m;
                m.d(str12, "PERSONAL_DATA_CONSENTS");
                return str12;
            case 12:
                String str13 = C2164g.f21319n;
                m.d(str13, "MSPA_COVERED_TRANSACTION");
                return str13;
            case 13:
                String str14 = C2164g.f21320o;
                m.d(str14, "MSPA_OPT_OUT_OPTION_MODE");
                return str14;
            case 14:
                String str15 = C2164g.f21321p;
                m.d(str15, "MSPA_SERVICE_PROVIDER_MODE");
                return str15;
            default:
                return "";
        }
    }

    public final void c(A3.b bVar, Object obj) {
        m.e(bVar, "field");
        m.e(obj, "value");
        try {
            this.f91a.k(g(), b(bVar), obj);
        } catch (Exception unused) {
            b.a(b.f6277a, ChoiceError.ERROR_WHILE_SAVING_CONSENT, (String) null, (String) null, c.CONSOLE, (Throwable) null, 22);
        }
    }

    public void d(A3.b bVar, boolean z4) {
        List list;
        m.e(bVar, "field");
        if (z4) {
            list = C1601o.k(1, 1);
        } else {
            list = C1601o.k(2, 2);
        }
        c(bVar, list);
        this.f94d.setKnownChildSensitiveDataConsents(list);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: A3.e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: A3.e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v17, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: A3.e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v36, resolved type: A3.e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v26, resolved type: java.util.ArrayList} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e(java.util.List r20, boolean r21, d3.l r22) {
        /*
            r19 = this;
            r0 = r19
            r1 = r21
            r2 = 1
            java.lang.String r3 = "purposes"
            r4 = r20
            kotlin.jvm.internal.m.e(r4, r3)
            com.inmobi.cmp.data.storage.SharedStorage r3 = r0.f93c
            a4.a r5 = a4.a.SAVED_MSPA_SECTION_ID
            int r3 = r3.i(r5)
            java.lang.String r7 = java.lang.String.valueOf(r3)
            r9 = 4
            r10 = 0
            java.lang.String r5 = "IABGPP_[SectionID]_String"
            java.lang.String r6 = "[SectionID]"
            r8 = 0
            java.lang.String r5 = m3.m.w(r5, r6, r7, r8, r9, r10)
            com.inmobi.cmp.data.storage.SharedStorage r6 = r0.f93c
            java.lang.String r7 = ""
            r6.g(r5, r7)
            com.inmobi.cmp.data.storage.SharedStorage r5 = r0.f93c
            a4.a r6 = a4.a.HDR_SECTION_LIST
            java.lang.String r5 = r5.j(r6)
            r6 = 0
            org.json.JSONArray r8 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0068 }
            r8.<init>(r5)     // Catch:{ JSONException -> 0x0068 }
            int r5 = r8.length()     // Catch:{ JSONException -> 0x0068 }
            j3.d r5 = j3.e.i(r6, r5)     // Catch:{ JSONException -> 0x0068 }
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ JSONException -> 0x0068 }
            r10 = 10
            int r10 = S2.C1601o.p(r5, r10)     // Catch:{ JSONException -> 0x0068 }
            r9.<init>(r10)     // Catch:{ JSONException -> 0x0068 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ JSONException -> 0x0068 }
        L_0x004f:
            boolean r10 = r5.hasNext()     // Catch:{ JSONException -> 0x0068 }
            if (r10 == 0) goto L_0x006c
            r10 = r5
            S2.E r10 = (S2.E) r10     // Catch:{ JSONException -> 0x0068 }
            int r10 = r10.nextInt()     // Catch:{ JSONException -> 0x0068 }
            int r10 = r8.getInt(r10)     // Catch:{ JSONException -> 0x0068 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ JSONException -> 0x0068 }
            r9.add(r10)     // Catch:{ JSONException -> 0x0068 }
            goto L_0x004f
        L_0x0068:
            java.util.List r9 = S2.C1601o.h()
        L_0x006c:
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.Iterator r5 = r9.iterator()
        L_0x0075:
            boolean r8 = r5.hasNext()
            if (r8 == 0) goto L_0x008d
            java.lang.Object r8 = r5.next()
            r9 = r8
            java.lang.Number r9 = (java.lang.Number) r9
            int r9 = r9.intValue()
            if (r9 != r3) goto L_0x0089
            goto L_0x0075
        L_0x0089:
            r10.add(r8)
            goto L_0x0075
        L_0x008d:
            com.inmobi.cmp.data.storage.SharedStorage r5 = r0.f93c
            a4.a r8 = a4.a.HDR_SECTION_LIST
            java.lang.String r9 = r10.toString()
            r5.e(r8, r9)
            com.inmobi.cmp.data.storage.SharedStorage r5 = r0.f93c
            a4.a r8 = a4.a.HDR_SECTION_ID
            r17 = 62
            r18 = 0
            java.lang.String r11 = "_"
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            java.lang.String r9 = S2.C1601o.O(r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r5.e(r8, r9)
            j1.a r5 = r0.f91a
            r5.b(r3)
            java.lang.String r3 = r0.a()
            com.inmobi.cmp.data.storage.SharedStorage r5 = r0.f93c
            a4.a r8 = a4.a.GPP_STRING
            r5.e(r8, r3)
            java.util.Iterator r3 = r4.iterator()
        L_0x00c3:
            boolean r5 = r3.hasNext()
            r8 = 2
            if (r5 == 0) goto L_0x025d
            java.lang.Object r5 = r3.next()
            A3.e r5 = (A3.e) r5
            java.lang.Integer r9 = r5.f60a
            if (r9 != 0) goto L_0x00d5
            goto L_0x00c3
        L_0x00d5:
            int r9 = r9.intValue()
            switch(r9) {
                case 1: goto L_0x00ee;
                case 2: goto L_0x00eb;
                case 3: goto L_0x00e8;
                case 4: goto L_0x00e5;
                case 5: goto L_0x00e2;
                case 6: goto L_0x00df;
                default: goto L_0x00dc;
            }
        L_0x00dc:
            A3.b r9 = A3.b.NONE
            goto L_0x00f0
        L_0x00df:
            A3.b r9 = A3.b.KnownChildSensitiveDataConsents
            goto L_0x00f0
        L_0x00e2:
            A3.b r9 = A3.b.SensitiveDataProcessing
            goto L_0x00f0
        L_0x00e5:
            A3.b r9 = A3.b.PersonalDataConsents
            goto L_0x00f0
        L_0x00e8:
            A3.b r9 = A3.b.TargetedAdvertisingOptOut
            goto L_0x00f0
        L_0x00eb:
            A3.b r9 = A3.b.SaleOptOut
            goto L_0x00f0
        L_0x00ee:
            A3.b r9 = A3.b.SharingOptOut
        L_0x00f0:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r6)
            int r11 = r9.ordinal()
            switch(r11) {
                case 6: goto L_0x0220;
                case 7: goto L_0x01e2;
                case 8: goto L_0x01a7;
                case 9: goto L_0x013f;
                case 10: goto L_0x0133;
                case 11: goto L_0x00fc;
                default: goto L_0x00fb;
            }
        L_0x00fb:
            goto L_0x00c3
        L_0x00fc:
            java.lang.String r10 = r0.b(r9)
            int r10 = r10.length()
            if (r10 <= 0) goto L_0x00c3
            if (r1 == 0) goto L_0x0116
            java.lang.Boolean r10 = r5.f63d
            java.lang.Boolean r11 = java.lang.Boolean.TRUE
            boolean r10 = kotlin.jvm.internal.m.a(r10, r11)
            if (r10 == 0) goto L_0x0114
            r10 = 1
            goto L_0x0117
        L_0x0114:
            r10 = 2
            goto L_0x0117
        L_0x0116:
            r10 = 0
        L_0x0117:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            com.inmobi.cmp.core.model.mspa.USRegulationData r11 = r0.f94d
            if (r1 == 0) goto L_0x012b
            java.lang.Boolean r5 = r5.f63d
            java.lang.Boolean r12 = java.lang.Boolean.TRUE
            boolean r5 = kotlin.jvm.internal.m.a(r5, r12)
            if (r5 == 0) goto L_0x012c
            r8 = 1
            goto L_0x012c
        L_0x012b:
            r8 = 0
        L_0x012c:
            r11.setPersonalDataConsents(r8)
            r0.c(r9, r10)
            goto L_0x00c3
        L_0x0133:
            java.lang.Boolean r5 = r5.f63d
            java.lang.Boolean r8 = java.lang.Boolean.TRUE
            boolean r5 = kotlin.jvm.internal.m.a(r5, r8)
            r0.d(r9, r5)
            goto L_0x00c3
        L_0x013f:
            java.util.List r11 = r5.f66g
            if (r11 != 0) goto L_0x0144
            goto L_0x01a2
        L_0x0144:
            r0.h(r1)
            r0.f(r1)
            r10 = 12
            int[] r12 = new int[r10]
            r13 = 0
        L_0x014f:
            if (r13 >= r10) goto L_0x0155
            r12[r13] = r6
            int r13 = r13 + r2
            goto L_0x014f
        L_0x0155:
            java.util.Iterator r11 = r11.iterator()
        L_0x0159:
            boolean r13 = r11.hasNext()
            if (r13 == 0) goto L_0x0195
            java.lang.Object r13 = r11.next()
            A3.f r13 = (A3.f) r13
            java.lang.Integer r14 = r13.f68b
            if (r14 == 0) goto L_0x0159
            j3.d r14 = new j3.d
            r14.<init>(r2, r10)
            java.lang.Integer r15 = r13.f68b
            int r15 = r15.intValue()
            boolean r14 = r14.m(r15)
            if (r14 == 0) goto L_0x0159
            java.lang.Integer r14 = r13.f68b
            int r14 = r14.intValue()
            int r14 = r14 - r2
            java.lang.Boolean r13 = r13.f70d
            if (r13 != 0) goto L_0x0187
            java.lang.Boolean r13 = r5.f63d
        L_0x0187:
            java.lang.Boolean r15 = java.lang.Boolean.TRUE
            boolean r13 = kotlin.jvm.internal.m.a(r13, r15)
            if (r13 == 0) goto L_0x0191
            r13 = 1
            goto L_0x0192
        L_0x0191:
            r13 = 2
        L_0x0192:
            r12[r14] = r13
            goto L_0x0159
        L_0x0195:
            java.util.List r10 = S2.C1594h.H(r12)
            com.inmobi.cmp.core.model.mspa.USRegulationData r5 = r0.f94d
            java.util.List r8 = S2.C1594h.H(r12)
            r5.setSensitiveDataProcessing(r8)
        L_0x01a2:
            r0.c(r9, r10)
            goto L_0x00c3
        L_0x01a7:
            java.lang.String r10 = r0.b(r9)
            int r10 = r10.length()
            if (r10 <= 0) goto L_0x00c3
            r0.l(r1)
            if (r1 == 0) goto L_0x01c4
            java.lang.Boolean r10 = r5.f63d
            java.lang.Boolean r11 = java.lang.Boolean.TRUE
            boolean r10 = kotlin.jvm.internal.m.a(r10, r11)
            if (r10 == 0) goto L_0x01c2
            r10 = 1
            goto L_0x01c5
        L_0x01c2:
            r10 = 2
            goto L_0x01c5
        L_0x01c4:
            r10 = 0
        L_0x01c5:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            com.inmobi.cmp.core.model.mspa.USRegulationData r11 = r0.f94d
            if (r1 == 0) goto L_0x01d9
            java.lang.Boolean r5 = r5.f63d
            java.lang.Boolean r12 = java.lang.Boolean.TRUE
            boolean r5 = kotlin.jvm.internal.m.a(r5, r12)
            if (r5 == 0) goto L_0x01da
            r8 = 1
            goto L_0x01da
        L_0x01d9:
            r8 = 0
        L_0x01da:
            r11.setTargetedAdvertisingOptOut(r8)
            r0.c(r9, r10)
            goto L_0x00c3
        L_0x01e2:
            r0.j(r1)
            r0.k(r1)
            java.lang.String r10 = r0.b(r9)
            int r10 = r10.length()
            if (r10 <= 0) goto L_0x00c3
            if (r1 == 0) goto L_0x0202
            java.lang.Boolean r10 = r5.f63d
            java.lang.Boolean r11 = java.lang.Boolean.TRUE
            boolean r10 = kotlin.jvm.internal.m.a(r10, r11)
            if (r10 == 0) goto L_0x0200
            r10 = 1
            goto L_0x0203
        L_0x0200:
            r10 = 2
            goto L_0x0203
        L_0x0202:
            r10 = 0
        L_0x0203:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            com.inmobi.cmp.core.model.mspa.USRegulationData r11 = r0.f94d
            if (r1 == 0) goto L_0x0217
            java.lang.Boolean r5 = r5.f63d
            java.lang.Boolean r12 = java.lang.Boolean.TRUE
            boolean r5 = kotlin.jvm.internal.m.a(r5, r12)
            if (r5 == 0) goto L_0x0218
            r8 = 1
            goto L_0x0218
        L_0x0217:
            r8 = 0
        L_0x0218:
            r11.setSharingOptOut(r8)
            r0.c(r9, r10)
            goto L_0x00c3
        L_0x0220:
            if (r1 == 0) goto L_0x0224
            r10 = 1
            goto L_0x0225
        L_0x0224:
            r10 = 2
        L_0x0225:
            A3.b r11 = A3.b.SaleOptOutNotice
            java.lang.Integer r12 = java.lang.Integer.valueOf(r10)
            r0.c(r11, r12)
            com.inmobi.cmp.core.model.mspa.USRegulationData r11 = r0.f94d
            r11.setSaleOptOutNotice(r10)
            if (r1 == 0) goto L_0x0243
            java.lang.Boolean r10 = r5.f63d
            java.lang.Boolean r11 = java.lang.Boolean.TRUE
            boolean r10 = kotlin.jvm.internal.m.a(r10, r11)
            if (r10 == 0) goto L_0x0241
            r10 = 1
            goto L_0x0244
        L_0x0241:
            r10 = 2
            goto L_0x0244
        L_0x0243:
            r10 = 0
        L_0x0244:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            com.inmobi.cmp.core.model.mspa.USRegulationData r11 = r0.f94d
            java.lang.Boolean r5 = r5.f63d
            java.lang.Boolean r12 = java.lang.Boolean.TRUE
            boolean r5 = kotlin.jvm.internal.m.a(r5, r12)
            if (r5 == 0) goto L_0x0255
            r8 = 1
        L_0x0255:
            r11.setSaleOptOut(r8)
            r0.c(r9, r10)
            goto L_0x00c3
        L_0x025d:
            C3.f r1 = r0.f92b
            C3.a r1 = r1.f170b
            boolean r1 = r1.f119K
            if (r1 == 0) goto L_0x0267
            r1 = 1
            goto L_0x0268
        L_0x0267:
            r1 = 2
        L_0x0268:
            A3.b r3 = A3.b.MspaCoveredTransaction
            java.lang.Integer r5 = java.lang.Integer.valueOf(r1)
            r0.c(r3, r5)
            com.inmobi.cmp.core.model.mspa.USRegulationData r3 = r0.f94d
            r3.setMspaCoveredTransaction(r1)
            C3.f r1 = r0.f92b
            C3.a r1 = r1.f170b
            java.lang.String r1 = r1.f120L
            r3 = 0
            if (r1 != 0) goto L_0x0281
            r1 = r3
            goto L_0x02b3
        L_0x0281:
            java.lang.String r5 = "OPT_OUT"
            boolean r5 = kotlin.jvm.internal.m.a(r1, r5)
            if (r5 == 0) goto L_0x028b
            r5 = 1
            goto L_0x028c
        L_0x028b:
            r5 = 2
        L_0x028c:
            java.lang.String r9 = "SERVICE-PROVIDER"
            boolean r1 = kotlin.jvm.internal.m.a(r1, r9)
            if (r1 == 0) goto L_0x0295
            r8 = 1
        L_0x0295:
            A3.b r1 = A3.b.MspaOptOutOptionMode
            java.lang.Integer r9 = java.lang.Integer.valueOf(r5)
            r0.c(r1, r9)
            A3.b r1 = A3.b.MspaServiceProviderMode
            java.lang.Integer r9 = java.lang.Integer.valueOf(r8)
            r0.c(r1, r9)
            com.inmobi.cmp.core.model.mspa.USRegulationData r1 = r0.f94d
            r1.setMspaOptOutOptionMode(r5)
            com.inmobi.cmp.core.model.mspa.USRegulationData r1 = r0.f94d
            r1.setMspaServiceProviderMode(r8)
            R2.s r1 = R2.s.f8222a
        L_0x02b3:
            if (r1 != 0) goto L_0x02d1
            A3.b r1 = A3.b.MspaOptOutOptionMode
            java.lang.Integer r5 = java.lang.Integer.valueOf(r6)
            r0.c(r1, r5)
            A3.b r1 = A3.b.MspaServiceProviderMode
            java.lang.Integer r5 = java.lang.Integer.valueOf(r6)
            r0.c(r1, r5)
            com.inmobi.cmp.core.model.mspa.USRegulationData r1 = r0.f94d
            r1.setMspaOptOutOptionMode(r6)
            com.inmobi.cmp.core.model.mspa.USRegulationData r1 = r0.f94d
            r1.setMspaServiceProviderMode(r6)
        L_0x02d1:
            com.inmobi.cmp.core.model.Vector r1 = new com.inmobi.cmp.core.model.Vector
            r1.<init>(r3, r2, r3)
            java.util.Iterator r5 = r4.iterator()
        L_0x02da:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0301
            java.lang.Object r6 = r5.next()
            A3.e r6 = (A3.e) r6
            java.lang.Integer r8 = r6.f60a
            if (r8 != 0) goto L_0x02eb
            goto L_0x02da
        L_0x02eb:
            int r8 = r8.intValue()
            java.lang.Boolean r6 = r6.f63d
            java.lang.Boolean r9 = java.lang.Boolean.TRUE
            boolean r6 = kotlin.jvm.internal.m.a(r6, r9)
            if (r6 == 0) goto L_0x02fd
            r1.set((int) r8)
            goto L_0x02da
        L_0x02fd:
            r1.unset((int) r8)
            goto L_0x02da
        L_0x0301:
            com.inmobi.cmp.data.storage.SharedStorage r5 = r0.f93c
            a4.a r6 = a4.a.MSPA_PURPOSE_CONSENT
            r5.d(r6, r1)
            com.inmobi.cmp.core.model.Vector r1 = new com.inmobi.cmp.core.model.Vector
            r1.<init>(r3, r2, r3)
            java.util.Iterator r4 = r4.iterator()
        L_0x0311:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0330
            java.lang.Object r5 = r4.next()
            r6 = r5
            A3.e r6 = (A3.e) r6
            java.lang.Integer r6 = r6.f60a
            int[] r8 = A3.i.f83c
            int r8 = S2.C1594h.s(r8)
            if (r6 != 0) goto L_0x0329
            goto L_0x0311
        L_0x0329:
            int r6 = r6.intValue()
            if (r6 != r8) goto L_0x0311
            r3 = r5
        L_0x0330:
            A3.e r3 = (A3.e) r3
            if (r3 != 0) goto L_0x0335
            goto L_0x0365
        L_0x0335:
            java.util.List r3 = r3.f66g
            if (r3 != 0) goto L_0x033a
            goto L_0x0365
        L_0x033a:
            java.util.Iterator r3 = r3.iterator()
        L_0x033e:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0365
            java.lang.Object r4 = r3.next()
            A3.f r4 = (A3.f) r4
            java.lang.Integer r5 = r4.f68b
            if (r5 != 0) goto L_0x034f
            goto L_0x033e
        L_0x034f:
            int r5 = r5.intValue()
            java.lang.Boolean r4 = r4.f70d
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            boolean r4 = kotlin.jvm.internal.m.a(r4, r6)
            if (r4 == 0) goto L_0x0361
            r1.set((int) r5)
            goto L_0x033e
        L_0x0361:
            r1.unset((int) r5)
            goto L_0x033e
        L_0x0365:
            com.inmobi.cmp.data.storage.SharedStorage r3 = r0.f93c
            a4.a r4 = a4.a.MSPA_SENSITIVE_PURPOSE_CONSENT
            r3.d(r4, r1)
            b4.d r1 = b4.d.f24465a
            j1.a r1 = r0.f91a
            java.lang.String r3 = "gppModel"
            kotlin.jvm.internal.m.e(r1, r3)
            b4.d.f24479o = r1
            com.inmobi.cmp.core.model.mspa.USRegulationData r1 = r0.f94d
            java.lang.String r3 = r0.a()
            r1.setGppString(r3)
            com.inmobi.cmp.core.model.mspa.USRegulationData r1 = r0.f94d
            r1.setVersion(r2)
            com.inmobi.cmp.data.storage.SharedStorage r1 = r0.f93c
            a4.a r2 = a4.a.SAVED_MSPA_SECTION_ID
            int r3 = r0.i()
            r1.c(r2, r3)
            com.inmobi.cmp.data.storage.SharedStorage r1 = r0.f93c
            a4.a r2 = a4.a.HDR_GPP_VERSION
            j1.a r3 = r0.f91a
            o1.d r3 = r3.e()
            java.lang.Integer r3 = r3.g()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r1.e(r2, r3)
            com.inmobi.cmp.data.storage.SharedStorage r1 = r0.f93c
            a4.a r2 = a4.a.HDR_SECTION_LIST
            j1.a r3 = r0.f91a
            java.util.List r3 = r3.h()
            java.lang.String r3 = r3.toString()
            r1.e(r2, r3)
            com.inmobi.cmp.data.storage.SharedStorage r1 = r0.f93c
            a4.a r2 = a4.a.HDR_SECTION_ID
            j1.a r3 = r0.f91a
            java.util.List r8 = r3.h()
            java.lang.String r3 = "gppModel.sectionIds"
            kotlin.jvm.internal.m.d(r8, r3)
            r15 = 62
            r16 = 0
            java.lang.String r9 = "_"
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            java.lang.String r3 = S2.C1601o.O(r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r1.e(r2, r3)
            int r1 = r0.i()
            java.lang.String r10 = java.lang.String.valueOf(r1)
            r12 = 4
            java.lang.String r8 = "IABGPP_[SectionID]_String"
            java.lang.String r9 = "[SectionID]"
            r11 = 0
            java.lang.String r1 = m3.m.w(r8, r9, r10, r11, r12, r13)
            com.inmobi.cmp.data.storage.SharedStorage r2 = r0.f93c
            j1.a r3 = r0.f91a     // Catch:{ Exception -> 0x03ff }
            java.lang.String r4 = r0.g()     // Catch:{ Exception -> 0x03ff }
            o1.c r3 = r3.g(r4)     // Catch:{ Exception -> 0x03ff }
            java.lang.String r3 = r3.b()     // Catch:{ Exception -> 0x03ff }
            java.lang.String r4 = "{\n            gppModel.g…ction).encode()\n        }"
            kotlin.jvm.internal.m.d(r3, r4)     // Catch:{ Exception -> 0x03ff }
            r7 = r3
        L_0x03ff:
            r2.g(r1, r7)
            com.inmobi.cmp.data.storage.SharedStorage r1 = r0.f93c
            a4.a r2 = a4.a.HDR_GPP_STRING
            com.inmobi.cmp.core.model.mspa.USRegulationData r3 = r0.f94d
            java.lang.String r3 = r3.getGppString()
            r1.e(r2, r3)
            com.inmobi.cmp.data.storage.SharedStorage r1 = r0.f93c
            a4.a r2 = a4.a.SAVED_MSPA_JURISDICTION
            E2.h r3 = A3.d.f58h
            java.lang.String r3 = r3.f6357a
            r1.e(r2, r3)
            com.inmobi.cmp.data.storage.SharedStorage r1 = r0.f93c
            a4.a r2 = a4.a.SAVED_REGION
            java.lang.String r3 = b4.d.f24478n
            r1.e(r2, r3)
            com.inmobi.cmp.data.storage.SharedStorage r1 = r0.f93c
            a4.a r2 = a4.a.GPP_STRING
            com.inmobi.cmp.core.model.mspa.USRegulationData r3 = r0.f94d
            java.lang.String r3 = r3.getGppString()
            r1.e(r2, r3)
            com.inmobi.cmp.core.model.mspa.USRegulationData r1 = r0.f94d
            r2 = r22
            r2.invoke(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: B3.e.e(java.util.List, boolean, d3.l):void");
    }

    public void f(boolean z4) {
        int i4;
        if (z4) {
            i4 = 1;
        } else {
            i4 = 2;
        }
        c(A3.b.SensitiveDataLimitUseNotice, Integer.valueOf(i4));
        this.f94d.setSensitiveDataLimitUseNotice(i4);
    }

    public String g() {
        String str = C2184l.f21413f;
        m.d(str, "NAME");
        return str;
    }

    public void h(boolean z4) {
        int i4;
        if (z4) {
            i4 = 1;
        } else {
            i4 = 2;
        }
        c(A3.b.SensitiveDataProcessingOptOutNotice, Integer.valueOf(i4));
        this.f94d.setSensitiveDataProcessingOptOutNotice(i4);
    }

    public int i() {
        return C2184l.f21411d;
    }

    public void j(boolean z4) {
        int i4;
        if (z4) {
            i4 = 1;
        } else {
            i4 = 2;
        }
        c(A3.b.SharingNotice, Integer.valueOf(i4));
        this.f94d.setSharingNotice(i4);
    }

    public void k(boolean z4) {
        int i4;
        if (z4) {
            i4 = 1;
        } else {
            i4 = 2;
        }
        c(A3.b.SharingOptOutNotice, Integer.valueOf(i4));
        this.f94d.setSharingOptOutNotice(i4);
    }

    public void l(boolean z4) {
        int i4;
        if (z4) {
            i4 = 1;
        } else {
            i4 = 2;
        }
        c(A3.b.TargetedAdvertisingOptOutNotice, Integer.valueOf(i4));
        this.f94d.setTargetedAdvertisingOptOutNotice(i4);
    }
}
