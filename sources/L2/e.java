package L2;

import C3.f;
import E2.s;
import S2.C1601o;
import X3.w;
import androidx.lifecycle.ViewModel;
import e4.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.m;
import z3.i;
import z3.j;
import z3.l;

public final class e extends ViewModel {

    /* renamed from: a  reason: collision with root package name */
    public final s f7380a;

    /* renamed from: b  reason: collision with root package name */
    public final f f7381b;

    /* renamed from: c  reason: collision with root package name */
    public final w f7382c;

    public e(s sVar, f fVar, w wVar) {
        m.e(sVar, "tcModel");
        m.e(fVar, "portalConfig");
        m.e(wVar, "translationsTextRepository");
        this.f7380a = sVar;
        this.f7381b = fVar;
        this.f7382c = wVar;
    }

    public final List a(int i4) {
        List c5 = c(i4);
        ((ArrayList) c5).addAll(d(i4));
        return c5;
    }

    public final Set b(int i4) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        List<d> c5 = c(i4);
        ((ArrayList) c5).addAll(d(i4));
        for (d dVar : c5) {
            Boolean bool = dVar.f24632b;
            if (bool != null) {
                linkedHashSet.add(bool);
            }
        }
        return linkedHashSet;
    }

    public final List c(int i4) {
        Map map;
        int i5;
        int i6;
        Map map2;
        int i7;
        Map map3;
        j jVar;
        List list;
        ArrayList arrayList = new ArrayList();
        z3.e eVar = this.f7380a.f6391a;
        if (!(eVar == null || (map = eVar.f4803d) == null)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : map.entrySet()) {
                if (this.f7380a.f6408r.contains(((i) entry.getValue()).f4812a)) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                z3.e eVar2 = this.f7380a.f6391a;
                if (!(eVar2 == null || (map3 = eVar2.f4809j) == null || (jVar = (j) map3.get(String.valueOf(i4))) == null || (list = jVar.f4816c) == null || !list.contains(Integer.valueOf(((i) entry2.getValue()).f4812a)))) {
                    linkedHashMap2.put(entry2.getKey(), entry2.getValue());
                }
            }
            for (Map.Entry entry3 : linkedHashMap2.entrySet()) {
                int i8 = ((i) entry3.getValue()).f4812a;
                z3.e eVar3 = this.f7380a.f6391a;
                if (eVar3 == null || (map2 = eVar3.f4808i) == null) {
                    i5 = 0;
                } else {
                    LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                    for (Map.Entry entry4 : map2.entrySet()) {
                        if (((l) entry4.getValue()).f4826k == null) {
                            linkedHashMap3.put(entry4.getKey(), entry4.getValue());
                        }
                    }
                    i5 = 0;
                    for (Map.Entry value : linkedHashMap3.entrySet()) {
                        Set<Number> set = ((l) value.getValue()).f4819d;
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
                        i5 += i7;
                    }
                }
                for (C3.d dVar : this.f7381b.f171c.f166a) {
                    List<Number> list2 = dVar.f164f;
                    if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                        i6 = 0;
                        for (Number intValue2 : list2) {
                            if (intValue2.intValue() == i8 && (i6 = i6 + 1) < 0) {
                                C1601o.n();
                            }
                        }
                    } else {
                        i6 = 0;
                    }
                    i5 += i6;
                }
                if (i5 > 0) {
                    arrayList.add(new d((z3.f) entry3.getValue(), this.f7380a.f6408r.get(((i) entry3.getValue()).f4812a), (e4.f) null, e4.e.PURPOSE, false, this.f7382c.a().f24203d, Integer.valueOf(i5), 20));
                }
            }
        }
        return arrayList;
    }

    public final List d(int i4) {
        Map map;
        int i5;
        Map map2;
        int i6;
        boolean z4;
        Map map3;
        j jVar;
        List list;
        ArrayList arrayList = new ArrayList();
        z3.e eVar = this.f7380a.f6391a;
        if (!(eVar == null || (map = eVar.f4806g) == null)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : map.entrySet()) {
                if (this.f7380a.f6407q.contains(((z3.d) entry.getValue()).f4812a)) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            Iterator it = linkedHashMap.entrySet().iterator();
            while (true) {
                boolean z5 = false;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry2 = (Map.Entry) it.next();
                z3.e eVar2 = this.f7380a.f6391a;
                if (!(eVar2 == null || (map3 = eVar2.f4809j) == null || (jVar = (j) map3.get(String.valueOf(i4))) == null || (list = jVar.f4817d) == null)) {
                    z5 = list.contains(Integer.valueOf(((z3.d) entry2.getValue()).f4812a));
                }
                if (z5) {
                    linkedHashMap2.put(entry2.getKey(), entry2.getValue());
                }
            }
            for (Map.Entry entry3 : linkedHashMap2.entrySet()) {
                int i7 = ((z3.d) entry3.getValue()).f4812a;
                z3.e eVar3 = this.f7380a.f6391a;
                if (eVar3 == null || (map2 = eVar3.f4808i) == null) {
                    i5 = 0;
                } else {
                    LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                    Iterator it2 = map2.entrySet().iterator();
                    while (true) {
                        boolean z6 = true;
                        if (!it2.hasNext()) {
                            break;
                        }
                        Map.Entry entry4 = (Map.Entry) it2.next();
                        if (((l) entry4.getValue()).f4826k != null) {
                            z6 = false;
                        }
                        if (z6) {
                            linkedHashMap3.put(entry4.getKey(), entry4.getValue());
                        }
                    }
                    i5 = 0;
                    for (Map.Entry value : linkedHashMap3.entrySet()) {
                        Set<Number> set = ((l) value.getValue()).f4824i;
                        if (!b.l.a(set) || !set.isEmpty()) {
                            i6 = 0;
                            for (Number intValue : set) {
                                if (intValue.intValue() == i7) {
                                    z4 = true;
                                } else {
                                    z4 = false;
                                }
                                if (z4 && (i6 = i6 + 1) < 0) {
                                    C1601o.n();
                                }
                            }
                        } else {
                            i6 = 0;
                        }
                        i5 += i6;
                    }
                }
                if (i5 > 0) {
                    arrayList.add(new d((z3.f) entry3.getValue(), this.f7380a.f6407q.get(((z3.d) entry3.getValue()).f4812a), (e4.f) null, e4.e.SPECIAL_FEATURE, false, this.f7382c.a().f24203d, Integer.valueOf(i5), 20));
                }
            }
        }
        return arrayList;
    }
}
