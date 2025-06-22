package B2;

import C3.f;
import E2.e;
import E2.s;
import M2.c;
import S2.C1601o;
import S2.N;
import V3.p;
import X3.C2609e;
import X3.w;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.inmobi.cmp.core.model.portalconfig.PrivacyEncodingMode;
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
import z3.j;
import z3.l;

public final class k extends ViewModel {

    /* renamed from: a  reason: collision with root package name */
    public final s f6205a;

    /* renamed from: b  reason: collision with root package name */
    public final f f6206b;

    /* renamed from: c  reason: collision with root package name */
    public final e f6207c;

    /* renamed from: d  reason: collision with root package name */
    public final l f6208d;

    /* renamed from: e  reason: collision with root package name */
    public final C2609e f6209e;

    /* renamed from: f  reason: collision with root package name */
    public final w f6210f;

    /* renamed from: g  reason: collision with root package name */
    public final List f6211g;

    /* renamed from: h  reason: collision with root package name */
    public final List f6212h;

    /* renamed from: i  reason: collision with root package name */
    public final List f6213i;

    /* renamed from: j  reason: collision with root package name */
    public final List f6214j;

    /* renamed from: k  reason: collision with root package name */
    public final c f6215k;

    /* renamed from: l  reason: collision with root package name */
    public final int f6216l = 2;

    /* renamed from: m  reason: collision with root package name */
    public Set f6217m = new LinkedHashSet();

    /* renamed from: n  reason: collision with root package name */
    public Set f6218n = new LinkedHashSet();

    /* renamed from: o  reason: collision with root package name */
    public MutableLiveData f6219o = new MutableLiveData();

    public k(s sVar, f fVar, e eVar, l lVar, C2609e eVar2, w wVar, List list, List list2, List list3, List list4, Integer num, c cVar) {
        m.e(sVar, "tcModel");
        m.e(fVar, "portalConfig");
        m.e(eVar, "googleVendorList");
        m.e(eVar2, "consentRepository");
        m.e(wVar, "translationsTextRepository");
        m.e(list, "initScreenCustomLinks");
        m.e(list2, "vendorSpecialPurposeIds");
        m.e(list3, "vendorFeaturesIds");
        m.e(list4, "publisherStacksSelectedIds");
        m.e(cVar, "gbcPurposeResponse");
        this.f6205a = sVar;
        this.f6206b = fVar;
        this.f6207c = eVar;
        this.f6208d = lVar;
        this.f6209e = eVar2;
        this.f6210f = wVar;
        this.f6211g = list;
        this.f6212h = list2;
        this.f6213i = list3;
        this.f6214j = list4;
        this.f6215k = cVar;
    }

    public final d a(String str, Set set, int i4) {
        if (!m.a(str, "ALL_VENDORS") || this.f6208d == null || !set.contains(Integer.valueOf(i4))) {
            return null;
        }
        l lVar = this.f6208d;
        return new d(lVar, (Boolean) null, e4.f.NON_SWITCH, e4.e.PURPOSE_PARTNER, false, lVar.f4813b, (Integer) null, 82);
    }

    public final List b() {
        Map map;
        int i4;
        Map map2;
        int i5;
        Collection collection;
        Map map3;
        j jVar;
        Map map4;
        int i6;
        int i7;
        Map map5;
        int i8;
        Collection collection2;
        Map map6;
        j jVar2;
        ArrayList arrayList = new ArrayList();
        z3.e eVar = this.f6205a.f6391a;
        if (!(eVar == null || (map4 = eVar.f4803d) == null)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : map4.entrySet()) {
                if (this.f6205a.f6408r.contains(((i) entry.getValue()).f4812a)) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                Set set = this.f6217m;
                if (set == null || set.isEmpty()) {
                    Set set2 = this.f6217m;
                    for (Number intValue : this.f6214j) {
                        int intValue2 = intValue.intValue();
                        z3.e eVar2 = this.f6205a.f6391a;
                        if (eVar2 == null || (map6 = eVar2.f4809j) == null || (jVar2 = (j) map6.get(String.valueOf(intValue2))) == null) {
                            collection2 = null;
                        } else {
                            collection2 = jVar2.f4816c;
                        }
                        if (collection2 == null) {
                            collection2 = N.d();
                        }
                        set2.addAll(collection2);
                    }
                }
                if (!this.f6217m.contains(Integer.valueOf(((i) entry2.getValue()).f4812a))) {
                    linkedHashMap2.put(entry2.getKey(), entry2.getValue());
                }
            }
            for (Map.Entry entry3 : linkedHashMap2.entrySet()) {
                int i9 = ((i) entry3.getValue()).f4812a;
                z3.e eVar3 = this.f6205a.f6391a;
                if (eVar3 == null || (map5 = eVar3.f4808i) == null) {
                    i6 = 0;
                } else {
                    LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                    for (Map.Entry entry4 : map5.entrySet()) {
                        if (((l) entry4.getValue()).f4826k == null) {
                            linkedHashMap3.put(entry4.getKey(), entry4.getValue());
                        }
                    }
                    i6 = 0;
                    for (Map.Entry value : linkedHashMap3.entrySet()) {
                        Set<Number> set3 = ((l) value.getValue()).f4819d;
                        if (!b.l.a(set3) || !set3.isEmpty()) {
                            i8 = 0;
                            for (Number intValue3 : set3) {
                                if (intValue3.intValue() == i9 && (i8 = i8 + 1) < 0) {
                                    C1601o.n();
                                }
                            }
                        } else {
                            i8 = 0;
                        }
                        i6 += i8;
                    }
                }
                for (C3.d dVar : this.f6206b.f171c.f166a) {
                    List<Number> list = dVar.f164f;
                    if (!(list instanceof Collection) || !list.isEmpty()) {
                        i7 = 0;
                        for (Number intValue4 : list) {
                            if (intValue4.intValue() == i9 && (i7 = i7 + 1) < 0) {
                                C1601o.n();
                            }
                        }
                    } else {
                        i7 = 0;
                    }
                    i6 += i7;
                }
                for (Number intValue5 : this.f6206b.f170b.f146s) {
                    if (intValue5.intValue() == i9) {
                        i6++;
                    }
                }
                if (i6 > 0) {
                    arrayList.add(new d((z3.f) entry3.getValue(), this.f6205a.f6408r.get(((i) entry3.getValue()).f4812a), (e4.f) null, e4.e.PURPOSE, false, this.f6210f.a().f24203d, Integer.valueOf(i6), 20));
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        z3.e eVar4 = this.f6205a.f6391a;
        if (!(eVar4 == null || (map = eVar4.f4806g) == null)) {
            LinkedHashMap linkedHashMap4 = new LinkedHashMap();
            for (Map.Entry entry5 : map.entrySet()) {
                if (this.f6205a.f6407q.contains(((z3.d) entry5.getValue()).f4812a)) {
                    linkedHashMap4.put(entry5.getKey(), entry5.getValue());
                }
            }
            LinkedHashMap linkedHashMap5 = new LinkedHashMap();
            for (Map.Entry entry6 : linkedHashMap4.entrySet()) {
                Set set4 = this.f6218n;
                if (set4 == null || set4.isEmpty()) {
                    Set set5 = this.f6218n;
                    for (Number intValue6 : this.f6214j) {
                        int intValue7 = intValue6.intValue();
                        z3.e eVar5 = this.f6205a.f6391a;
                        if (eVar5 == null || (map3 = eVar5.f4809j) == null || (jVar = (j) map3.get(String.valueOf(intValue7))) == null) {
                            collection = null;
                        } else {
                            collection = jVar.f4817d;
                        }
                        if (collection == null) {
                            collection = N.d();
                        }
                        set5.addAll(collection);
                    }
                }
                if (!this.f6218n.contains(Integer.valueOf(((z3.d) entry6.getValue()).f4812a))) {
                    linkedHashMap5.put(entry6.getKey(), entry6.getValue());
                }
            }
            for (Map.Entry entry7 : linkedHashMap5.entrySet()) {
                int i10 = ((z3.d) entry7.getValue()).f4812a;
                z3.e eVar6 = this.f6205a.f6391a;
                if (eVar6 == null || (map2 = eVar6.f4808i) == null) {
                    i4 = 0;
                } else {
                    LinkedHashMap linkedHashMap6 = new LinkedHashMap();
                    for (Map.Entry entry8 : map2.entrySet()) {
                        if (((l) entry8.getValue()).f4826k == null) {
                            linkedHashMap6.put(entry8.getKey(), entry8.getValue());
                        }
                    }
                    i4 = 0;
                    for (Map.Entry value2 : linkedHashMap6.entrySet()) {
                        Set<Number> set6 = ((l) value2.getValue()).f4824i;
                        if (!b.l.a(set6) || !set6.isEmpty()) {
                            i5 = 0;
                            for (Number intValue8 : set6) {
                                if (intValue8.intValue() == i10 && (i5 = i5 + 1) < 0) {
                                    C1601o.n();
                                }
                            }
                        } else {
                            i5 = 0;
                        }
                        i4 += i5;
                    }
                }
                for (Number intValue9 : this.f6206b.f170b.f150w) {
                    if (intValue9.intValue() == i10) {
                        i4++;
                    }
                }
                if (i4 > 0) {
                    arrayList2.add(new d((z3.f) entry7.getValue(), this.f6205a.f6407q.get(((z3.d) entry7.getValue()).f4812a), (e4.f) null, e4.e.SPECIAL_FEATURE, false, this.f6210f.a().f24203d, Integer.valueOf(i4), 20));
                }
            }
        }
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    public final List c() {
        Map map;
        int i4;
        Map map2;
        int i5;
        Map map3;
        int i6;
        Map map4;
        int i7;
        ArrayList arrayList = new ArrayList();
        z3.e eVar = this.f6205a.f6391a;
        if (!(eVar == null || (map3 = eVar.f4804e) == null)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : map3.entrySet()) {
                if (this.f6212h.contains(Integer.valueOf(((i) entry.getValue()).f4812a)) || this.f6206b.f170b.f148u.contains(Integer.valueOf(((i) entry.getValue()).f4812a))) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                int i8 = ((i) entry2.getValue()).f4812a;
                z3.e eVar2 = this.f6205a.f6391a;
                if (eVar2 == null || (map4 = eVar2.f4808i) == null) {
                    i6 = 0;
                } else {
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    for (Map.Entry entry3 : map4.entrySet()) {
                        if (((l) entry3.getValue()).f4826k == null) {
                            linkedHashMap2.put(entry3.getKey(), entry3.getValue());
                        }
                    }
                    i6 = 0;
                    for (Map.Entry value : linkedHashMap2.entrySet()) {
                        Set<Number> set = ((l) value.getValue()).f4822g;
                        if (!b.l.a(set) || !set.isEmpty()) {
                            i7 = 0;
                            for (Number intValue : set) {
                                if (intValue.intValue() == i8 && (i7 = i7 + 1) < 0) {
                                    C1601o.n();
                                }
                            }
                        } else {
                            i7 = 0;
                        }
                        i6 += i7;
                    }
                }
                for (Number intValue2 : this.f6206b.f170b.f148u) {
                    if (intValue2.intValue() == i8) {
                        i6++;
                    }
                }
                if (i6 > 0) {
                    arrayList.add(new d((z3.f) entry2.getValue(), (Boolean) null, (e4.f) null, e4.e.SPECIAL_PURPOSE, false, this.f6210f.a().f24203d, Integer.valueOf(i6), 22));
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        z3.e eVar3 = this.f6205a.f6391a;
        if (!(eVar3 == null || (map = eVar3.f4805f) == null)) {
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            for (Map.Entry entry4 : map.entrySet()) {
                if (this.f6213i.contains(Integer.valueOf(((z3.d) entry4.getValue()).f4812a)) || this.f6206b.f170b.f149v.contains(Integer.valueOf(((z3.d) entry4.getValue()).f4812a))) {
                    linkedHashMap3.put(entry4.getKey(), entry4.getValue());
                }
            }
            for (Map.Entry entry5 : linkedHashMap3.entrySet()) {
                int i9 = ((z3.d) entry5.getValue()).f4812a;
                z3.e eVar4 = this.f6205a.f6391a;
                if (eVar4 == null || (map2 = eVar4.f4808i) == null) {
                    i4 = 0;
                } else {
                    LinkedHashMap linkedHashMap4 = new LinkedHashMap();
                    for (Map.Entry entry6 : map2.entrySet()) {
                        if (((l) entry6.getValue()).f4826k == null) {
                            linkedHashMap4.put(entry6.getKey(), entry6.getValue());
                        }
                    }
                    i4 = 0;
                    for (Map.Entry value2 : linkedHashMap4.entrySet()) {
                        Set<Number> set2 = ((l) value2.getValue()).f4823h;
                        if (!b.l.a(set2) || !set2.isEmpty()) {
                            i5 = 0;
                            for (Number intValue3 : set2) {
                                if (intValue3.intValue() == i9 && (i5 = i5 + 1) < 0) {
                                    C1601o.n();
                                }
                            }
                        } else {
                            i5 = 0;
                        }
                        i4 += i5;
                    }
                }
                for (Number intValue4 : this.f6206b.f170b.f149v) {
                    if (intValue4.intValue() == i9) {
                        i4++;
                    }
                }
                if (i4 > 0) {
                    arrayList2.add(new d((z3.f) entry5.getValue(), (Boolean) null, (e4.f) null, e4.e.FEATURES, false, this.f6210f.a().f24203d, Integer.valueOf(i4), 22));
                }
            }
        }
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    public final List d() {
        Map map;
        String str;
        Map map2;
        j jVar;
        boolean z4;
        boolean z5;
        Map map3;
        ArrayList arrayList = new ArrayList();
        z3.e eVar = this.f6205a.f6391a;
        if (!(eVar == null || (map = eVar.f4809j) == null)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : map.entrySet()) {
                if (this.f6214j.contains(Integer.valueOf(((j) entry.getValue()).f4812a))) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                boolean z6 = false;
                for (Number intValue : ((j) entry2.getValue()).f4816c) {
                    int intValue2 = intValue.intValue();
                    z3.e eVar2 = this.f6205a.f6391a;
                    if (!(eVar2 == null || (map3 = eVar2.f4808i) == null)) {
                        for (Map.Entry entry3 : map3.entrySet()) {
                            if (((l) entry3.getValue()).f4826k == null && ((l) entry3.getValue()).f4819d.contains(Integer.valueOf(intValue2))) {
                                z6 = true;
                            }
                        }
                    }
                }
                if (z6) {
                    int i4 = ((j) entry2.getValue()).f4812a;
                    String str2 = ((j) entry2.getValue()).f4813b;
                    int i5 = ((j) entry2.getValue()).f4812a;
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    z3.e eVar3 = this.f6205a.f6391a;
                    if (!(eVar3 == null || (map2 = eVar3.f4809j) == null || (jVar = (j) map2.get(String.valueOf(i5))) == null)) {
                        List list = jVar.f4816c;
                        ArrayList arrayList2 = new ArrayList();
                        for (Object next : list) {
                            if (this.f6205a.f6408r.contains(((Number) next).intValue())) {
                                arrayList2.add(next);
                            }
                        }
                        int size = arrayList2.size();
                        int i6 = 0;
                        while (i6 < size) {
                            Object obj = arrayList2.get(i6);
                            i6++;
                            Boolean bool = this.f6205a.f6408r.get(((Number) obj).intValue());
                            if (bool == null) {
                                z5 = false;
                            } else {
                                z5 = bool.booleanValue();
                            }
                            linkedHashSet.add(Boolean.valueOf(z5));
                        }
                        List list2 = jVar.f4817d;
                        ArrayList arrayList3 = new ArrayList();
                        for (Object next2 : list2) {
                            if (this.f6205a.f6407q.contains(((Number) next2).intValue())) {
                                arrayList3.add(next2);
                            }
                        }
                        int size2 = arrayList3.size();
                        int i7 = 0;
                        while (i7 < size2) {
                            Object obj2 = arrayList3.get(i7);
                            i7++;
                            Boolean bool2 = this.f6205a.f6407q.get(((Number) obj2).intValue());
                            if (bool2 == null) {
                                z4 = false;
                            } else {
                                z4 = bool2.booleanValue();
                            }
                            linkedHashSet.add(Boolean.valueOf(z4));
                        }
                    }
                    Boolean bool3 = Boolean.TRUE;
                    if (linkedHashSet.contains(bool3) && linkedHashSet.contains(Boolean.FALSE)) {
                        str = this.f6210f.f().f24180l;
                    } else if (linkedHashSet.contains(bool3)) {
                        str = this.f6210f.f().f24181m;
                    } else {
                        str = this.f6210f.f().f24179k;
                    }
                    arrayList.add(new p(i4, str2, str));
                }
            }
        }
        return arrayList;
    }

    public final void e() {
        String str = this.f6206b.f170b.f117I;
        if (str != null) {
            PrivacyEncodingMode privacyEncodingMode = PrivacyEncodingMode.GPP;
            if (str.equals(privacyEncodingMode.getValue())) {
                this.f6209e.a(privacyEncodingMode, true);
                return;
            }
        }
        String str2 = this.f6206b.f170b.f117I;
        if (str2 != null) {
            PrivacyEncodingMode privacyEncodingMode2 = PrivacyEncodingMode.TCF;
            if (str2.equals(privacyEncodingMode2.getValue())) {
                this.f6209e.a(privacyEncodingMode2, true);
                return;
            }
        }
        this.f6209e.a(PrivacyEncodingMode.TCF_AND_GPP, true);
    }
}
