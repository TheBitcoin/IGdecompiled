package E2;

import S2.C1601o;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.m;
import z3.e;
import z3.l;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public List f6361a;

    /* renamed from: b  reason: collision with root package name */
    public List f6362b;

    /* renamed from: c  reason: collision with root package name */
    public final Map f6363c;

    /* renamed from: d  reason: collision with root package name */
    public e f6364d;

    public j(e eVar, List list, List list2, Map map) {
        m.e(list, "consentRestrictionIds");
        m.e(list2, "liRestrictionIds");
        m.e(map, "map");
        this.f6361a = list;
        this.f6362b = list2;
        this.f6363c = map;
        this.f6364d = eVar;
    }

    public final int a() {
        int i4;
        int i5 = 0;
        for (Map.Entry value : this.f6363c.entrySet()) {
            Integer num = (Integer) C1601o.Q((Iterable) value.getValue());
            if (num == null) {
                i4 = 0;
            } else {
                i4 = num.intValue();
            }
            i5 = Math.max(i5, i4);
        }
        return i5;
    }

    public final List b(Integer num) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : this.f6363c.entrySet()) {
            if (num != null && ((Set) entry.getValue()).contains(num)) {
                arrayList.add(i.f6358c.a((String) entry.getKey()));
            }
        }
        return arrayList;
    }

    public final void c(int i4, i iVar) {
        m.e(iVar, "purposeRestriction");
        k kVar = iVar.f6360b;
        int i5 = iVar.f6359a;
        e eVar = this.f6364d;
        if (eVar != null) {
            l lVar = (l) eVar.f4808i.get(String.valueOf(i4));
            if (lVar != null) {
                if (kVar == k.NOT_ALLOWED) {
                    if (!lVar.f4820e.contains(Integer.valueOf(i5)) && !lVar.f4819d.contains(Integer.valueOf(i5))) {
                        return;
                    }
                } else if (!lVar.f4821f.isEmpty()) {
                    int ordinal = kVar.ordinal();
                    if (ordinal != 1) {
                        if (ordinal != 2 || !lVar.f4821f.contains(Integer.valueOf(i5)) || !lVar.f4819d.contains(Integer.valueOf(i5))) {
                            return;
                        }
                    } else if (!lVar.f4821f.contains(Integer.valueOf(i5)) || !lVar.f4820e.contains(Integer.valueOf(i5))) {
                        return;
                    }
                }
            } else {
                return;
            }
        }
        String a5 = iVar.a();
        m.e(a5, "hash");
        if (!this.f6363c.containsKey(a5)) {
            this.f6363c.put(a5, new LinkedHashSet());
        }
        ArrayList arrayList = (ArrayList) b(Integer.valueOf(i4));
        int size = arrayList.size();
        int i6 = 0;
        while (i6 < size) {
            Object obj = arrayList.get(i6);
            i6++;
            i iVar2 = (i) obj;
            if (iVar2.f6359a == iVar.f6359a) {
                String a6 = iVar2.a();
                Set set = (Set) this.f6363c.get(a6);
                if (set != null) {
                    set.remove(Integer.valueOf(i4));
                    if (set.isEmpty()) {
                        this.f6363c.remove(a6);
                    }
                }
            }
        }
        Set set2 = (Set) this.f6363c.get(a5);
        if (set2 != null) {
            set2.add(Integer.valueOf(i4));
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j(e eVar, List list, List list2, Map map, int i4) {
        this(eVar, (i4 & 2) != 0 ? C1601o.h() : null, (i4 & 4) != 0 ? C1601o.h() : null, (i4 & 8) != 0 ? new LinkedHashMap() : null);
    }
}
