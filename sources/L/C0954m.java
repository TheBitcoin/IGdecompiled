package l;

import C3.e;
import C3.f;
import E2.s;
import H2.j;
import S2.C1601o;
import X3.w;
import androidx.lifecycle.ViewModel;
import e4.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.m;
import z3.i;
import z3.l;

/* renamed from: l.m  reason: case insensitive filesystem */
public final class C0954m extends ViewModel {

    /* renamed from: a  reason: collision with root package name */
    public final s f3548a;

    /* renamed from: b  reason: collision with root package name */
    public final f f3549b;

    /* renamed from: c  reason: collision with root package name */
    public final e f3550c;

    /* renamed from: d  reason: collision with root package name */
    public final w f3551d;

    /* renamed from: e  reason: collision with root package name */
    public final l f3552e;

    /* renamed from: f  reason: collision with root package name */
    public final List f3553f;

    /* renamed from: g  reason: collision with root package name */
    public final List f3554g;

    /* renamed from: h  reason: collision with root package name */
    public final List f3555h;

    /* renamed from: i  reason: collision with root package name */
    public final List f3556i;

    /* renamed from: j  reason: collision with root package name */
    public j f3557j = j.ALL_VENDORS;

    /* renamed from: k  reason: collision with root package name */
    public boolean f3558k;

    /* renamed from: l  reason: collision with root package name */
    public int f3559l = 4;

    public C0954m(s sVar, f fVar, e eVar, w wVar, l lVar, List list, List list2, List list3, List list4) {
        m.e(sVar, "tcModel");
        m.e(fVar, "portalConfig");
        m.e(eVar, "nonIabVendorsInfo");
        m.e(wVar, "translationsTextRepository");
        m.e(list, "vendorPurposeLegitimateInterestIds");
        m.e(list2, "vendorSpecialPurposeIds");
        m.e(list3, "vendorFeaturesIds");
        m.e(list4, "vendorSpecialFeaturesIds");
        this.f3548a = sVar;
        this.f3549b = fVar;
        this.f3550c = eVar;
        this.f3551d = wVar;
        this.f3552e = lVar;
        this.f3553f = list;
        this.f3554g = list2;
        this.f3555h = list3;
        this.f3556i = list4;
    }

    public static /* synthetic */ List c(C0954m mVar, String str, int i4) {
        String str2;
        if ((i4 & 1) != 0) {
            str2 = "";
        } else {
            str2 = null;
        }
        return mVar.b(str2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a(java.util.Set r8, H2.a r9) {
        /*
            r7 = this;
            r0 = 0
            r1 = 1
            java.lang.String r2 = "ids"
            kotlin.jvm.internal.m.e(r8, r2)
            java.lang.String r2 = "type"
            kotlin.jvm.internal.m.e(r9, r2)
            S2.N.d()
            int r9 = r9.ordinal()
            if (r9 == 0) goto L_0x0064
            if (r9 == r1) goto L_0x0054
            r2 = 2
            if (r9 == r2) goto L_0x0044
            r2 = 3
            if (r9 == r2) goto L_0x0034
            r2 = 4
            if (r9 != r2) goto L_0x002e
            java.util.Set r9 = S2.C1601o.d0(r8)
            E2.s r2 = r7.f3548a
            z3.e r2 = r2.f6391a
            if (r2 != 0) goto L_0x002b
            goto L_0x0070
        L_0x002b:
            java.util.Map r2 = r2.f4810k
            goto L_0x0074
        L_0x002e:
            R2.k r8 = new R2.k
            r8.<init>()
            throw r8
        L_0x0034:
            java.util.List r9 = r7.f3556i
            java.util.Set r9 = S2.C1601o.d0(r9)
            E2.s r2 = r7.f3548a
            z3.e r2 = r2.f6391a
            if (r2 != 0) goto L_0x0041
            goto L_0x0070
        L_0x0041:
            java.util.Map r2 = r2.f4806g
            goto L_0x0074
        L_0x0044:
            java.util.List r9 = r7.f3555h
            java.util.Set r9 = S2.C1601o.d0(r9)
            E2.s r2 = r7.f3548a
            z3.e r2 = r2.f6391a
            if (r2 != 0) goto L_0x0051
            goto L_0x0070
        L_0x0051:
            java.util.Map r2 = r2.f4805f
            goto L_0x0074
        L_0x0054:
            java.util.List r9 = r7.f3554g
            java.util.Set r9 = S2.C1601o.d0(r9)
            E2.s r2 = r7.f3548a
            z3.e r2 = r2.f6391a
            if (r2 != 0) goto L_0x0061
            goto L_0x0070
        L_0x0061:
            java.util.Map r2 = r2.f4804e
            goto L_0x0074
        L_0x0064:
            java.util.List r9 = r7.f3553f
            java.util.Set r9 = S2.C1601o.d0(r9)
            E2.s r2 = r7.f3548a
            z3.e r2 = r2.f6391a
            if (r2 != 0) goto L_0x0072
        L_0x0070:
            r2 = 0
            goto L_0x0074
        L_0x0072:
            java.util.Map r2 = r2.f4803d
        L_0x0074:
            java.util.SortedSet r8 = S2.C1601o.z(r8)
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Iterator r8 = r8.iterator()
        L_0x0081:
            boolean r4 = r8.hasNext()
            if (r4 == 0) goto L_0x0098
            java.lang.Object r4 = r8.next()
            r5 = r4
            java.lang.Integer r5 = (java.lang.Integer) r5
            boolean r5 = r9.contains(r5)
            if (r5 == 0) goto L_0x0081
            r3.add(r4)
            goto L_0x0081
        L_0x0098:
            int r8 = r3.size()
            java.lang.String r9 = ""
            r4 = 0
        L_0x009f:
            if (r4 >= r8) goto L_0x00e0
            java.lang.Object r5 = r3.get(r4)
            int r4 = r4 + r1
            java.lang.Integer r5 = (java.lang.Integer) r5
            if (r2 != 0) goto L_0x00ab
            goto L_0x009f
        L_0x00ab:
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.Object r5 = r2.get(r5)
            z3.f r5 = (z3.f) r5
            if (r5 != 0) goto L_0x00b8
            goto L_0x009f
        L_0x00b8:
            java.lang.StringBuilder r9 = A2.a.a(r9)
            kotlin.jvm.internal.F r6 = kotlin.jvm.internal.F.f20971a
            java.lang.String r5 = r5.f4813b
            java.lang.Object[] r6 = new java.lang.Object[r1]
            r6[r0] = r5
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r6, r1)
            java.lang.String r6 = "• %s."
            java.lang.String r5 = java.lang.String.format(r6, r5)
            java.lang.String r6 = "format(format, *args)"
            kotlin.jvm.internal.m.d(r5, r6)
            r9.append(r5)
            r5 = 10
            r9.append(r5)
            java.lang.String r9 = r9.toString()
            goto L_0x009f
        L_0x00e0:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: l.C0954m.a(java.util.Set, H2.a):java.lang.String");
    }

    public final List b(String str) {
        List list;
        int i4;
        int i5;
        z3.e eVar;
        Map map;
        int i6;
        String str2 = str;
        m.e(str2, "search");
        int ordinal = this.f3557j.ordinal();
        if (ordinal != 0) {
            list = ordinal != 1 ? ordinal != 2 ? new ArrayList() : g() : f();
        } else {
            list = g();
            ArrayList arrayList = (ArrayList) list;
            arrayList.addAll(f());
            d h4 = h();
            if (h4 != null) {
                arrayList.add(0, h4);
            }
        }
        String str3 = this.f3551d.e().f24150h;
        e4.f fVar = e4.f.LABEL;
        list.add(0, new d((z3.f) null, (Boolean) null, fVar, (e4.e) null, false, str3, (Integer) null, 91));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(0, new d((z3.f) null, (Boolean) null, fVar, (e4.e) null, false, this.f3551d.e().f24149g, (Integer) null, 91));
        Map i7 = i();
        if (i7 != null) {
            for (Map.Entry entry : i7.entrySet()) {
                int i8 = ((i) entry.getValue()).f4812a;
                j jVar = this.f3557j;
                if ((jVar != j.ALL_VENDORS && jVar != j.IAB_VENDORS) || (eVar = this.f3548a.f6391a) == null || (map = eVar.f4808i) == null) {
                    i4 = 0;
                } else {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Map.Entry entry2 : map.entrySet()) {
                        if (((l) entry2.getValue()).f4826k == null) {
                            linkedHashMap.put(entry2.getKey(), entry2.getValue());
                        }
                    }
                    i4 = 0;
                    for (Map.Entry value : linkedHashMap.entrySet()) {
                        Set<Number> set = ((l) value.getValue()).f4820e;
                        if (!b.l.a(set) || !set.isEmpty()) {
                            i6 = 0;
                            for (Number intValue : set) {
                                if (intValue.intValue() == i8 && (i6 = i6 + 1) < 0) {
                                    C1601o.n();
                                }
                            }
                        } else {
                            i6 = 0;
                        }
                        i4 += i6;
                    }
                }
                j jVar2 = this.f3557j;
                if (jVar2 == j.ALL_VENDORS || jVar2 == j.NON_IAB_VENDORS) {
                    for (C3.d dVar : this.f3549b.f171c.f166a) {
                        List<Number> list2 = dVar.f165g;
                        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                            i5 = 0;
                            for (Number intValue2 : list2) {
                                if (intValue2.intValue() == i8 && (i5 = i5 + 1) < 0) {
                                    C1601o.n();
                                }
                            }
                        } else {
                            i5 = 0;
                        }
                        i4 += i5;
                    }
                }
                if (i4 > 0) {
                    arrayList2.add(new d((z3.f) entry.getValue(), this.f3548a.f6409s.get(((i) entry.getValue()).f4812a), (e4.f) null, e4.e.PURPOSE, false, this.f3551d.a().f24203d, Integer.valueOf(i4), 4));
                }
            }
        }
        list.addAll(0, arrayList2);
        if (str2.length() <= 0) {
            return list;
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object next : list) {
            d dVar2 = (d) next;
            if (dVar2.f24634d != e4.e.PURPOSE && m3.m.B(dVar2.f24631a.f4813b, str2, true)) {
                arrayList3.add(next);
            }
        }
        return C1601o.b0(arrayList3);
    }

    public final Set d() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (d dVar : b("")) {
            Boolean bool = dVar.f24632b;
            if (bool != null) {
                linkedHashSet.add(bool);
            }
        }
        return linkedHashSet;
    }

    public final void e(j jVar) {
        m.e(jVar, "<set-?>");
        this.f3557j = jVar;
    }

    public final List f() {
        Map map;
        ArrayList arrayList = new ArrayList();
        z3.e eVar = this.f3548a.f6391a;
        if (!(eVar == null || (map = eVar.f4808i) == null)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : map.entrySet()) {
                if (((l) entry.getValue()).f4826k == null) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                if (!((l) entry2.getValue()).f4820e.isEmpty()) {
                    arrayList.add(new d((z3.f) entry2.getValue(), this.f3548a.f6386C.get(((l) entry2.getValue()).f4812a), (e4.f) null, (e4.e) null, false, (String) null, (Integer) null, 124));
                }
            }
        }
        return arrayList;
    }

    public final List g() {
        ArrayList arrayList = new ArrayList();
        for (C3.d dVar : this.f3550c.f166a) {
            if (!dVar.f165g.isEmpty()) {
                arrayList.add(new d(dVar.a(), this.f3548a.f6387D.get(dVar.f159a), (e4.f) null, e4.e.NON_IAB_VENDOR, false, (String) null, (Integer) null, 116));
            }
        }
        return arrayList;
    }

    public final d h() {
        boolean z4;
        l lVar = this.f3552e;
        if (lVar == null) {
            return null;
        }
        Boolean bool = this.f3548a.f6411u.get(lVar.f4812a);
        if (bool == null) {
            z4 = true;
        } else {
            z4 = bool.booleanValue();
        }
        return new d(lVar, Boolean.valueOf(z4), (e4.f) null, e4.e.PUBLISHER_VENDOR, false, (String) null, (Integer) null, 116);
    }

    public final Map i() {
        Map map;
        z3.e eVar = this.f3548a.f6391a;
        if (eVar == null || (map = eVar.f4803d) == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map.entrySet()) {
            if (this.f3548a.f6409s.contains(((i) entry.getValue()).f4812a)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        if (m.a(this.f3548a.f6398h, "DE")) {
            return linkedHashMap;
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            if (((i) entry2.getValue()).f4812a != 1) {
                linkedHashMap2.put(entry2.getKey(), entry2.getValue());
            }
        }
        return linkedHashMap2;
    }
}
