package com.google.android.gms.measurement.internal;

import M.C0335p;
import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.A6;
import com.google.android.gms.internal.measurement.C0576h6;
import com.google.android.gms.internal.measurement.C0581i2;
import com.google.android.gms.internal.measurement.C0590j2;
import com.google.android.gms.internal.measurement.C0599k2;
import com.google.android.gms.internal.measurement.C0658r2;
import com.google.android.gms.internal.measurement.C0666s2;
import com.google.android.gms.internal.measurement.C0668s4;
import com.google.android.gms.internal.measurement.J1;
import com.mbridge.msdk.MBridgeConstans;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class h6 extends E5 {

    /* renamed from: d  reason: collision with root package name */
    private String f3018d;

    /* renamed from: e  reason: collision with root package name */
    private Set f3019e;

    /* renamed from: f  reason: collision with root package name */
    private Map f3020f;

    /* renamed from: g  reason: collision with root package name */
    private Long f3021g;

    /* renamed from: h  reason: collision with root package name */
    private Long f3022h;

    h6(H5 h5) {
        super(h5);
    }

    private final boolean D(int i4, int i5) {
        j6 j6Var = (j6) this.f3020f.get(Integer.valueOf(i4));
        if (j6Var == null) {
            return false;
        }
        return j6Var.f3061d.get(i5);
    }

    private final List E() {
        ArrayList arrayList = new ArrayList();
        Set<Integer> keySet = this.f3020f.keySet();
        keySet.removeAll(this.f3019e);
        for (Integer num : keySet) {
            int intValue = num.intValue();
            j6 j6Var = (j6) this.f3020f.get(num);
            C0335p.l(j6Var);
            C0581i2 a5 = j6Var.a(intValue);
            arrayList.add(a5);
            C0797k n4 = n();
            String str = this.f3018d;
            C0658r2 M4 = a5.M();
            n4.r();
            n4.k();
            C0335p.f(str);
            C0335p.l(M4);
            byte[] i4 = M4.i();
            ContentValues contentValues = new ContentValues();
            contentValues.put(MBridgeConstans.APP_ID, str);
            contentValues.put("audience_id", num);
            contentValues.put("current_results", i4);
            try {
                if (n4.y().insertWithOnConflict("audience_filter_values", (String) null, contentValues, 5) == -1) {
                    n4.a().G().b("Failed to insert filter results (got -1). appId", C0821n2.s(str));
                }
            } catch (SQLiteException e5) {
                n4.a().G().c("Error storing filter results. appId", C0821n2.s(str), e5);
            }
        }
        return arrayList;
    }

    private final j6 v(Integer num) {
        if (this.f3020f.containsKey(num)) {
            return (j6) this.f3020f.get(num);
        }
        j6 j6Var = new j6(this, this.f3018d);
        this.f3020f.put(num, j6Var);
        return j6Var;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x010e, code lost:
        if (r7.O() == false) goto L_0x0118;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0110, code lost:
        r9 = java.lang.Integer.valueOf(r7.j());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0118, code lost:
        r5.c("Invalid property filter ID. appId, id", r6, java.lang.String.valueOf(r9));
        r7 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void y(java.util.List r14) {
        /*
            r13 = this;
            boolean r0 = r14.isEmpty()
            if (r0 == 0) goto L_0x0008
            goto L_0x012b
        L_0x0008:
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            java.util.Iterator r14 = r14.iterator()
        L_0x0011:
            boolean r1 = r14.hasNext()
            if (r1 == 0) goto L_0x012b
            java.lang.Object r1 = r14.next()
            com.google.android.gms.internal.measurement.t2 r1 = (com.google.android.gms.internal.measurement.C0674t2) r1
            java.lang.String r2 = r1.U()
            java.lang.Object r3 = r0.get(r2)
            java.util.Map r3 = (java.util.Map) r3
            if (r3 != 0) goto L_0x0036
            com.google.android.gms.measurement.internal.k r3 = r13.n()
            java.lang.String r4 = r13.f3018d
            java.util.Map r3 = r3.R0(r4, r2)
            r0.put(r2, r3)
        L_0x0036:
            java.util.Set r2 = r3.keySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x003e:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0011
            java.lang.Object r4 = r2.next()
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r5 = r4.intValue()
            java.util.Set r6 = r13.f3019e
            boolean r6 = r6.contains(r4)
            if (r6 == 0) goto L_0x0064
            com.google.android.gms.measurement.internal.n2 r1 = r13.a()
            com.google.android.gms.measurement.internal.p2 r1 = r1.K()
            java.lang.String r2 = "Skipping failed audience ID"
            r1.b(r2, r4)
            goto L_0x0011
        L_0x0064:
            java.lang.Object r6 = r3.get(r4)
            java.util.List r6 = (java.util.List) r6
            java.util.Iterator r6 = r6.iterator()
            r7 = 1
        L_0x006f:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x0122
            java.lang.Object r7 = r6.next()
            com.google.android.gms.internal.measurement.M1 r7 = (com.google.android.gms.internal.measurement.M1) r7
            com.google.android.gms.measurement.internal.n2 r8 = r13.a()
            r9 = 2
            boolean r8 = r8.z(r9)
            r9 = 0
            if (r8 == 0) goto L_0x00c5
            com.google.android.gms.measurement.internal.n2 r8 = r13.a()
            com.google.android.gms.measurement.internal.p2 r8 = r8.K()
            boolean r10 = r7.O()
            if (r10 == 0) goto L_0x009e
            int r10 = r7.j()
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            goto L_0x009f
        L_0x009e:
            r10 = r9
        L_0x009f:
            com.google.android.gms.measurement.internal.h2 r11 = r13.d()
            java.lang.String r12 = r7.K()
            java.lang.String r11 = r11.g(r12)
            java.lang.String r12 = "Evaluating filter. audience, filter, property"
            r8.d(r12, r4, r10, r11)
            com.google.android.gms.measurement.internal.n2 r8 = r13.a()
            com.google.android.gms.measurement.internal.p2 r8 = r8.K()
            com.google.android.gms.measurement.internal.Z5 r10 = r13.l()
            java.lang.String r10 = r10.L(r7)
            java.lang.String r11 = "Filter definition"
            r8.b(r11, r10)
        L_0x00c5:
            boolean r8 = r7.O()
            if (r8 == 0) goto L_0x00fc
            int r8 = r7.j()
            r10 = 256(0x100, float:3.59E-43)
            if (r8 <= r10) goto L_0x00d4
            goto L_0x00fc
        L_0x00d4:
            com.google.android.gms.measurement.internal.n6 r8 = new com.google.android.gms.measurement.internal.n6
            java.lang.String r9 = r13.f3018d
            r8.<init>(r13, r9, r5, r7)
            java.lang.Long r9 = r13.f3021g
            java.lang.Long r10 = r13.f3022h
            int r7 = r7.j()
            boolean r7 = r13.D(r5, r7)
            boolean r7 = r8.k(r9, r10, r1, r7)
            if (r7 == 0) goto L_0x00f6
            com.google.android.gms.measurement.internal.j6 r9 = r13.v(r4)
            r9.c(r8)
            goto L_0x006f
        L_0x00f6:
            java.util.Set r5 = r13.f3019e
            r5.add(r4)
            goto L_0x0122
        L_0x00fc:
            com.google.android.gms.measurement.internal.n2 r5 = r13.a()
            com.google.android.gms.measurement.internal.p2 r5 = r5.L()
            java.lang.String r6 = r13.f3018d
            java.lang.Object r6 = com.google.android.gms.measurement.internal.C0821n2.s(r6)
            boolean r8 = r7.O()
            if (r8 == 0) goto L_0x0118
            int r7 = r7.j()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r7)
        L_0x0118:
            java.lang.String r7 = java.lang.String.valueOf(r9)
            java.lang.String r8 = "Invalid property filter ID. appId, id"
            r5.c(r8, r6, r7)
            r7 = 0
        L_0x0122:
            if (r7 != 0) goto L_0x003e
            java.util.Set r5 = r13.f3019e
            r5.add(r4)
            goto L_0x003e
        L_0x012b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.h6.y(java.util.List):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0101  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void z(java.util.List r33, boolean r34) {
        /*
            r32 = this;
            r0 = r32
            boolean r1 = r33.isEmpty()
            if (r1 == 0) goto L_0x000a
            goto L_0x017c
        L_0x000a:
            com.google.android.gms.measurement.internal.m6 r1 = new com.google.android.gms.measurement.internal.m6
            r2 = 0
            r1.<init>(r0)
            androidx.collection.ArrayMap r3 = new androidx.collection.ArrayMap
            r3.<init>()
            java.util.Iterator r4 = r33.iterator()
        L_0x0019:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x017c
            java.lang.Object r5 = r4.next()
            com.google.android.gms.internal.measurement.k2 r5 = (com.google.android.gms.internal.measurement.C0599k2) r5
            java.lang.String r6 = r0.f3018d
            com.google.android.gms.internal.measurement.k2 r10 = r1.a(r6, r5)
            if (r10 == 0) goto L_0x0170
            com.google.android.gms.measurement.internal.k r6 = r0.n()
            java.lang.String r12 = r0.f3018d
            java.lang.String r7 = r10.U()
            java.lang.String r8 = r5.U()
            com.google.android.gms.measurement.internal.A r8 = r6.L0(r12, r8)
            if (r8 != 0) goto L_0x007d
            com.google.android.gms.measurement.internal.n2 r8 = r6.a()
            com.google.android.gms.measurement.internal.p2 r8 = r8.L()
            java.lang.Object r9 = com.google.android.gms.measurement.internal.C0821n2.s(r12)
            com.google.android.gms.measurement.internal.h2 r6 = r6.d()
            java.lang.String r6 = r6.c(r7)
            java.lang.String r7 = "Event aggregate wasn't created during raw event logging. appId, event"
            r8.c(r7, r9, r6)
            com.google.android.gms.measurement.internal.A r11 = new com.google.android.gms.measurement.internal.A
            java.lang.String r13 = r5.U()
            long r20 = r5.R()
            r26 = 0
            r27 = 0
            r14 = 1
            r16 = 1
            r18 = 1
            r22 = 0
            r24 = 0
            r25 = 0
            r11.<init>(r12, r13, r14, r16, r18, r20, r22, r24, r25, r26, r27)
            r30 = r1
            r29 = r3
            r13 = r11
            goto L_0x00b1
        L_0x007d:
            com.google.android.gms.measurement.internal.A r12 = new com.google.android.gms.measurement.internal.A
            java.lang.String r13 = r8.f2283a
            java.lang.String r14 = r8.f2284b
            long r5 = r8.f2285c
            r15 = 1
            long r5 = r5 + r15
            r29 = r3
            long r2 = r8.f2286d
            long r17 = r2 + r15
            long r2 = r8.f2287e
            long r19 = r2 + r15
            long r2 = r8.f2288f
            r30 = r1
            r21 = r2
            long r1 = r8.f2289g
            java.lang.Long r3 = r8.f2290h
            java.lang.Long r7 = r8.f2291i
            java.lang.Long r9 = r8.f2292j
            java.lang.Boolean r8 = r8.f2293k
            r23 = r1
            r25 = r3
            r15 = r5
            r26 = r7
            r28 = r8
            r27 = r9
            r12.<init>(r13, r14, r15, r17, r19, r21, r23, r25, r26, r27, r28)
            r13 = r12
        L_0x00b1:
            com.google.android.gms.measurement.internal.k r1 = r0.n()
            r1.U(r13)
            boolean r1 = com.google.android.gms.internal.measurement.C0576h6.a()
            if (r1 == 0) goto L_0x00d5
            com.google.android.gms.measurement.internal.g r1 = r0.b()
            com.google.android.gms.measurement.internal.b2 r2 = com.google.android.gms.measurement.internal.G.f2455Z0
            r3 = 0
            boolean r1 = r1.H(r3, r2)
            if (r1 == 0) goto L_0x00d6
            if (r34 != 0) goto L_0x00ce
            goto L_0x00d6
        L_0x00ce:
            r2 = r3
            r3 = r29
        L_0x00d1:
            r1 = r30
            goto L_0x0019
        L_0x00d5:
            r3 = 0
        L_0x00d6:
            long r11 = r13.f2285c
            java.lang.String r1 = r10.U()
            r2 = r29
            java.lang.Object r5 = r2.get(r1)
            java.util.Map r5 = (java.util.Map) r5
            if (r5 != 0) goto L_0x00f3
            com.google.android.gms.measurement.internal.k r5 = r0.n()
            java.lang.String r6 = r0.f3018d
            java.util.Map r5 = r5.P0(r6, r1)
            r2.put(r1, r5)
        L_0x00f3:
            java.util.Set r1 = r5.keySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x00fb:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L_0x016b
            java.lang.Object r6 = r1.next()
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r15 = r6.intValue()
            java.util.Set r7 = r0.f3019e
            boolean r7 = r7.contains(r6)
            if (r7 == 0) goto L_0x0121
            com.google.android.gms.measurement.internal.n2 r7 = r0.a()
            com.google.android.gms.measurement.internal.p2 r7 = r7.K()
            java.lang.String r8 = "Skipping failed audience ID"
            r7.b(r8, r6)
            goto L_0x00fb
        L_0x0121:
            java.lang.Object r7 = r5.get(r6)
            java.util.List r7 = (java.util.List) r7
            java.util.Iterator r16 = r7.iterator()
            r7 = 1
        L_0x012c:
            boolean r8 = r16.hasNext()
            if (r8 == 0) goto L_0x0163
            java.lang.Object r7 = r16.next()
            com.google.android.gms.internal.measurement.J1 r7 = (com.google.android.gms.internal.measurement.J1) r7
            com.google.android.gms.measurement.internal.l6 r8 = new com.google.android.gms.measurement.internal.l6
            java.lang.String r9 = r0.f3018d
            r8.<init>(r0, r9, r15, r7)
            r9 = r7
            r7 = r8
            java.lang.Long r8 = r0.f3021g
            r14 = r9
            java.lang.Long r9 = r0.f3022h
            int r14 = r14.J()
            boolean r14 = r0.D(r15, r14)
            boolean r8 = r7.k(r8, r9, r10, r11, r13, r14)
            if (r8 == 0) goto L_0x015d
            com.google.android.gms.measurement.internal.j6 r9 = r0.v(r6)
            r9.c(r7)
            r7 = r8
            goto L_0x012c
        L_0x015d:
            java.util.Set r7 = r0.f3019e
            r7.add(r6)
            r7 = r8
        L_0x0163:
            if (r7 != 0) goto L_0x00fb
            java.util.Set r7 = r0.f3019e
            r7.add(r6)
            goto L_0x00fb
        L_0x016b:
            r1 = r3
            r3 = r2
            r2 = r1
            goto L_0x00d1
        L_0x0170:
            r31 = r3
            r3 = r2
            r2 = r31
            r31 = r3
            r3 = r2
            r2 = r31
            goto L_0x0019
        L_0x017c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.h6.z(java.util.List, boolean):void");
    }

    /* access modifiers changed from: protected */
    public final boolean u() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final List w(String str, List list, List list2, Long l4, Long l5) {
        return x(str, list, list2, l4, l5, false);
    }

    /* access modifiers changed from: package-private */
    public final List x(String str, List list, List list2, Long l4, Long l5, boolean z4) {
        boolean z5;
        HashSet hashSet;
        ArrayMap arrayMap;
        List<J1> list3;
        boolean z6;
        Iterator it;
        Map map;
        C0658r2 r2Var;
        Iterator it2;
        Long l6;
        Iterator it3;
        Map map2;
        HashSet hashSet2;
        List list4 = list;
        List list5 = list2;
        boolean z7 = z4;
        C0335p.f(str);
        C0335p.l(list4);
        C0335p.l(list5);
        this.f3018d = str;
        this.f3019e = new HashSet();
        this.f3020f = new ArrayMap();
        this.f3021g = l4;
        this.f3022h = l5;
        Iterator it4 = list4.iterator();
        while (true) {
            if (it4.hasNext()) {
                if ("_s".equals(((C0599k2) it4.next()).U())) {
                    z5 = true;
                    break;
                }
            } else {
                z5 = false;
                break;
            }
        }
        boolean z8 = A6.a() && b().H(this.f3018d, G.f2502q0);
        boolean z9 = A6.a() && b().H(this.f3018d, G.f2500p0);
        if (z5) {
            C0797k n4 = n();
            String str2 = this.f3018d;
            n4.r();
            n4.k();
            C0335p.f(str2);
            ContentValues contentValues = new ContentValues();
            contentValues.put("current_session_count", 0);
            try {
                n4.y().update("events", contentValues, "app_id = ?", new String[]{str2});
            } catch (SQLiteException e5) {
                n4.a().G().c("Error resetting session-scoped event counts. appId", C0821n2.s(str2), e5);
            }
        }
        Map map3 = Collections.EMPTY_MAP;
        if (z9 && z8) {
            map3 = n().a1(this.f3018d);
        }
        Map Z02 = n().Z0(this.f3018d);
        if (!Z02.isEmpty()) {
            HashSet hashSet3 = new HashSet(Z02.keySet());
            if (z5) {
                String str3 = this.f3018d;
                Map b12 = n().b1(this.f3018d);
                C0335p.f(str3);
                C0335p.l(Z02);
                ArrayMap arrayMap2 = new ArrayMap();
                if (!Z02.isEmpty()) {
                    Iterator it5 = Z02.keySet().iterator();
                    while (it5.hasNext()) {
                        Integer num = (Integer) it5.next();
                        num.intValue();
                        C0658r2 r2Var2 = (C0658r2) Z02.get(num);
                        List list6 = (List) b12.get(num);
                        if (list6 == null || list6.isEmpty()) {
                            hashSet2 = hashSet3;
                            map2 = b12;
                            it3 = it5;
                            arrayMap2.put(num, r2Var2);
                        } else {
                            hashSet2 = hashSet3;
                            List P4 = l().P(r2Var2.V(), list6);
                            if (!P4.isEmpty()) {
                                C0658r2.a t4 = ((C0658r2.a) r2Var2.y()).s().t(P4);
                                t4.z().A(l().P(r2Var2.X(), list6));
                                ArrayList arrayList = new ArrayList();
                                for (C0590j2 j2Var : r2Var2.U()) {
                                    Map map4 = b12;
                                    Iterator it6 = it5;
                                    if (!list6.contains(Integer.valueOf(j2Var.j()))) {
                                        arrayList.add(j2Var);
                                    }
                                    b12 = map4;
                                    it5 = it6;
                                }
                                map2 = b12;
                                it3 = it5;
                                t4.q().r(arrayList);
                                ArrayList arrayList2 = new ArrayList();
                                for (C0666s2 s2Var : r2Var2.W()) {
                                    if (!list6.contains(Integer.valueOf(s2Var.J()))) {
                                        arrayList2.add(s2Var);
                                    }
                                }
                                t4.x().y(arrayList2);
                                arrayMap2.put(num, (C0658r2) ((C0668s4) t4.m()));
                            } else {
                                hashSet3 = hashSet2;
                            }
                        }
                        hashSet3 = hashSet2;
                        b12 = map2;
                        it5 = it3;
                    }
                }
                hashSet = hashSet3;
                arrayMap = arrayMap2;
            } else {
                hashSet = hashSet3;
                arrayMap = Z02;
            }
            Iterator it7 = hashSet.iterator();
            while (it7.hasNext()) {
                Integer num2 = (Integer) it7.next();
                num2.intValue();
                C0658r2 r2Var3 = (C0658r2) arrayMap.get(num2);
                BitSet bitSet = new BitSet();
                C0658r2 r2Var4 = r2Var3;
                BitSet bitSet2 = new BitSet();
                C0658r2 r2Var5 = r2Var4;
                ArrayMap arrayMap3 = new ArrayMap();
                if (!(r2Var5 == null || r2Var5.j() == 0)) {
                    Iterator it8 = r2Var5.U().iterator();
                    while (it8.hasNext()) {
                        C0590j2 j2Var2 = (C0590j2) it8.next();
                        if (j2Var2.M()) {
                            r2Var = r2Var5;
                            Integer valueOf = Integer.valueOf(j2Var2.j());
                            if (j2Var2.L()) {
                                Long valueOf2 = Long.valueOf(j2Var2.I());
                                it2 = it8;
                                l6 = valueOf2;
                            } else {
                                it2 = it8;
                                l6 = null;
                            }
                            arrayMap3.put(valueOf, l6);
                        } else {
                            r2Var = r2Var5;
                            it2 = it8;
                        }
                        it8 = it2;
                        r2Var5 = r2Var;
                    }
                }
                C0658r2 r2Var6 = r2Var5;
                ArrayMap arrayMap4 = new ArrayMap();
                if (!(r2Var6 == null || r2Var6.L() == 0)) {
                    Iterator it9 = r2Var6.W().iterator();
                    while (it9.hasNext()) {
                        Iterator it10 = it9;
                        C0666s2 s2Var2 = (C0666s2) it9.next();
                        if (!s2Var2.N() || s2Var2.j() <= 0) {
                            map = arrayMap;
                            it = it7;
                        } else {
                            map = arrayMap;
                            it = it7;
                            arrayMap4.put(Integer.valueOf(s2Var2.J()), Long.valueOf(s2Var2.G(s2Var2.j() - 1)));
                        }
                        it9 = it10;
                        arrayMap = map;
                        it7 = it;
                    }
                }
                Map map5 = arrayMap;
                Iterator it11 = it7;
                if (r2Var6 != null) {
                    int i4 = 0;
                    while (i4 < (r2Var6.O() << 6)) {
                        if (Z5.e0(r2Var6.X(), i4)) {
                            z6 = z8;
                            a().K().c("Filter already evaluated. audience ID, filter ID", num2, Integer.valueOf(i4));
                            bitSet2.set(i4);
                            if (Z5.e0(r2Var6.V(), i4)) {
                                bitSet.set(i4);
                                i4++;
                                z8 = z6;
                            }
                        } else {
                            z6 = z8;
                        }
                        arrayMap3.remove(Integer.valueOf(i4));
                        i4++;
                        z8 = z6;
                    }
                }
                boolean z10 = z8;
                C0658r2 r2Var7 = (C0658r2) Z02.get(num2);
                if (!(!z9 || !z10 || (list3 = (List) map3.get(num2)) == null || this.f3022h == null || this.f3021g == null)) {
                    for (J1 j12 : list3) {
                        int J4 = j12.J();
                        Map map6 = map3;
                        long longValue = this.f3022h.longValue() / 1000;
                        if (j12.Q()) {
                            longValue = this.f3021g.longValue() / 1000;
                        }
                        if (arrayMap3.containsKey(Integer.valueOf(J4))) {
                            arrayMap3.put(Integer.valueOf(J4), Long.valueOf(longValue));
                        }
                        if (arrayMap4.containsKey(Integer.valueOf(J4))) {
                            arrayMap4.put(Integer.valueOf(J4), Long.valueOf(longValue));
                        }
                        map3 = map6;
                    }
                }
                this.f3020f.put(num2, new j6(this, this.f3018d, r2Var7, bitSet, bitSet2, arrayMap3, arrayMap4));
                Z02 = Z02;
                z8 = z10;
                map3 = map3;
                arrayMap = map5;
                it7 = it11;
            }
        }
        if (!C0576h6.a() || !b().H((String) null, G.f2455Z0)) {
            z(list4, true);
            y(list5);
            return E();
        }
        z(list4, z7);
        if (z7) {
            return new ArrayList();
        }
        y(list5);
        return E();
    }
}
