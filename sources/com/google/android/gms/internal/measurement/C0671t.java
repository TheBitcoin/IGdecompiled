package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.t  reason: case insensitive filesystem */
public final class C0671t extends C0623n implements C0614m {

    /* renamed from: c  reason: collision with root package name */
    private final List f2166c;

    /* renamed from: d  reason: collision with root package name */
    private final List f2167d;

    /* renamed from: e  reason: collision with root package name */
    private Z2 f2168e;

    private C0671t(C0671t tVar) {
        super(tVar.f2065a);
        ArrayList arrayList = new ArrayList(tVar.f2166c.size());
        this.f2166c = arrayList;
        arrayList.addAll(tVar.f2166c);
        ArrayList arrayList2 = new ArrayList(tVar.f2167d.size());
        this.f2167d = arrayList2;
        arrayList2.addAll(tVar.f2167d);
        this.f2168e = tVar.f2168e;
    }

    public final C0663s a(Z2 z22, List list) {
        Z2 d5 = this.f2168e.d();
        for (int i4 = 0; i4 < this.f2166c.size(); i4++) {
            if (i4 < list.size()) {
                d5.e((String) this.f2166c.get(i4), z22.b((C0663s) list.get(i4)));
            } else {
                d5.e((String) this.f2166c.get(i4), C0663s.f2138b0);
            }
        }
        for (C0663s sVar : this.f2167d) {
            C0663s b5 = d5.b(sVar);
            if (b5 instanceof C0687v) {
                b5 = d5.b(sVar);
            }
            if (b5 instanceof C0605l) {
                return ((C0605l) b5).a();
            }
        }
        return C0663s.f2138b0;
    }

    public final C0663s b() {
        return new C0671t(this);
    }

    public C0671t(String str, List list, List list2, Z2 z22) {
        super(str);
        this.f2166c = new ArrayList();
        this.f2168e = z22;
        if (!list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                this.f2166c.add(((C0663s) it.next()).E());
            }
        }
        this.f2167d = new ArrayList(list2);
    }
}
