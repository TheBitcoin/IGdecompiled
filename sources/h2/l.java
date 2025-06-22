package H2;

import C3.f;
import E2.e;
import E2.s;
import R2.k;
import S2.C1601o;
import X3.w;
import androidx.lifecycle.ViewModel;
import b.c;
import e4.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.m;

public final class l extends ViewModel {

    /* renamed from: a  reason: collision with root package name */
    public final w f6676a;

    /* renamed from: b  reason: collision with root package name */
    public final s f6677b;

    /* renamed from: c  reason: collision with root package name */
    public final f f6678c;

    /* renamed from: d  reason: collision with root package name */
    public final e f6679d;

    /* renamed from: e  reason: collision with root package name */
    public final z3.l f6680e;

    /* renamed from: f  reason: collision with root package name */
    public final List f6681f;

    /* renamed from: g  reason: collision with root package name */
    public final List f6682g;

    /* renamed from: h  reason: collision with root package name */
    public final List f6683h;

    /* renamed from: i  reason: collision with root package name */
    public final List f6684i;

    /* renamed from: j  reason: collision with root package name */
    public j f6685j = j.ALL_VENDORS;

    /* renamed from: k  reason: collision with root package name */
    public boolean f6686k;

    /* renamed from: l  reason: collision with root package name */
    public int f6687l = 3;

    public l(w wVar, s sVar, f fVar, e eVar, z3.l lVar, List list, List list2, List list3, List list4) {
        m.e(wVar, "translationsTextRepository");
        m.e(sVar, "tcModel");
        m.e(fVar, "portalConfig");
        m.e(eVar, "googleVendorList");
        m.e(list, "vendorPurposeIds");
        m.e(list2, "vendorSpecialPurposeIds");
        m.e(list3, "vendorFeaturesIds");
        m.e(list4, "vendorSpecialFeaturesIds");
        this.f6676a = wVar;
        this.f6677b = sVar;
        this.f6678c = fVar;
        this.f6679d = eVar;
        this.f6680e = lVar;
        this.f6681f = list;
        this.f6682g = list2;
        this.f6683h = list3;
        this.f6684i = list4;
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
            E2.s r2 = r7.f6677b
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
            java.util.List r9 = r7.f6684i
            java.util.Set r9 = S2.C1601o.d0(r9)
            E2.s r2 = r7.f6677b
            z3.e r2 = r2.f6391a
            if (r2 != 0) goto L_0x0041
            goto L_0x0070
        L_0x0041:
            java.util.Map r2 = r2.f4806g
            goto L_0x0074
        L_0x0044:
            java.util.List r9 = r7.f6683h
            java.util.Set r9 = S2.C1601o.d0(r9)
            E2.s r2 = r7.f6677b
            z3.e r2 = r2.f6391a
            if (r2 != 0) goto L_0x0051
            goto L_0x0070
        L_0x0051:
            java.util.Map r2 = r2.f4805f
            goto L_0x0074
        L_0x0054:
            java.util.List r9 = r7.f6682g
            java.util.Set r9 = S2.C1601o.d0(r9)
            E2.s r2 = r7.f6677b
            z3.e r2 = r2.f6391a
            if (r2 != 0) goto L_0x0061
            goto L_0x0070
        L_0x0061:
            java.util.Map r2 = r2.f4804e
            goto L_0x0074
        L_0x0064:
            java.util.List r9 = r7.f6681f
            java.util.Set r9 = S2.C1601o.d0(r9)
            E2.s r2 = r7.f6677b
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
        throw new UnsupportedOperationException("Method not decompiled: H2.l.a(java.util.Set, H2.a):java.lang.String");
    }

    public final List b() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : this.f6679d.f6348a.entrySet()) {
            if (this.f6677b.f6385B.get(((E2.f) entry.getValue()).f6349a) != null) {
                arrayList.add(new d(((E2.f) entry.getValue()).a(), this.f6677b.f6385B.get(((E2.f) entry.getValue()).f6349a), (e4.f) null, e4.e.GOOGLE_VENDOR, false, (String) null, (Integer) null, 116));
            }
        }
        return arrayList;
    }

    public final List c(String str) {
        List list;
        d dVar;
        boolean z4;
        m.e(str, "search");
        int ordinal = this.f6685j.ordinal();
        if (ordinal == 0) {
            list = f();
            ArrayList arrayList = (ArrayList) list;
            arrayList.addAll(e());
            arrayList.addAll(b());
            z3.l lVar = this.f6680e;
            if (lVar == null) {
                dVar = null;
            } else {
                Boolean bool = this.f6677b.f6410t.get(lVar.f4812a);
                if (bool == null) {
                    z4 = false;
                } else {
                    z4 = bool.booleanValue();
                }
                dVar = new d(lVar, Boolean.valueOf(z4), (e4.f) null, e4.e.PUBLISHER_VENDOR, false, (String) null, (Integer) null, 116);
            }
            if (dVar != null) {
                arrayList.add(0, dVar);
            }
        } else if (ordinal == 1) {
            list = e();
        } else if (ordinal == 2) {
            list = f();
        } else if (ordinal == 3) {
            list = b();
        } else {
            throw new k();
        }
        list.add(0, new d((z3.f) null, (Boolean) null, e4.f.LABEL, (e4.e) null, false, this.f6676a.a().f24203d, (Integer) null, 91));
        ArrayList arrayList2 = new ArrayList();
        for (Object next : list) {
            if (m3.m.B(((d) next).f24631a.f4813b, str, true)) {
                arrayList2.add(next);
            }
        }
        return C1601o.b0(arrayList2);
    }

    public final void d(j jVar) {
        m.e(jVar, "<set-?>");
        this.f6685j = jVar;
    }

    public final List e() {
        Map map;
        ArrayList arrayList = new ArrayList();
        z3.e eVar = this.f6677b.f6391a;
        if (!(eVar == null || (map = eVar.f4808i) == null)) {
            for (Map.Entry entry : map.entrySet()) {
                if (this.f6677b.f6416z.get(((z3.l) entry.getValue()).f4812a) != null) {
                    Set set = ((z3.l) entry.getValue()).f4819d;
                    List list = this.f6678c.f170b.f135h;
                    if (!b.l.a(set) || !set.isEmpty()) {
                        Iterator it = set.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (c.a((Number) it.next(), list)) {
                                    arrayList.add(new d((z3.f) entry.getValue(), this.f6677b.f6416z.get(((z3.l) entry.getValue()).f4812a), (e4.f) null, (e4.e) null, false, (String) null, (Integer) null, 124));
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    arrayList.add(new d((z3.f) entry.getValue(), (Boolean) null, (e4.f) null, (e4.e) null, false, (String) null, (Integer) null, 124));
                }
            }
        }
        return arrayList;
    }

    public final List f() {
        ArrayList arrayList = new ArrayList();
        for (C3.d dVar : this.f6678c.f171c.f166a) {
            if (this.f6677b.f6384A.get(dVar.f159a) != null) {
                arrayList.add(new d(dVar.a(), this.f6677b.f6384A.get(dVar.f159a), (e4.f) null, e4.e.NON_IAB_VENDOR, false, (String) null, (Integer) null, 116));
            }
        }
        return arrayList;
    }
}
