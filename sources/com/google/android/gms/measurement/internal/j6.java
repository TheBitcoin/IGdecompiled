package com.google.android.gms.measurement.internal;

import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.A6;
import com.google.android.gms.internal.measurement.C0581i2;
import com.google.android.gms.internal.measurement.C0590j2;
import com.google.android.gms.internal.measurement.C0658r2;
import com.google.android.gms.internal.measurement.C0666s2;
import com.google.android.gms.internal.measurement.C0668s4;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Map;

final class j6 {

    /* renamed from: a  reason: collision with root package name */
    private String f3058a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f3059b;

    /* renamed from: c  reason: collision with root package name */
    private C0658r2 f3060c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public BitSet f3061d;

    /* renamed from: e  reason: collision with root package name */
    private BitSet f3062e;

    /* renamed from: f  reason: collision with root package name */
    private Map f3063f;

    /* renamed from: g  reason: collision with root package name */
    private Map f3064g;

    /* renamed from: h  reason: collision with root package name */
    private final /* synthetic */ h6 f3065h;

    /* access modifiers changed from: package-private */
    public final C0581i2 a(int i4) {
        ArrayList arrayList;
        List list;
        C0581i2.a J4 = C0581i2.J();
        J4.q(i4);
        J4.t(this.f3059b);
        C0658r2 r2Var = this.f3060c;
        if (r2Var != null) {
            J4.s(r2Var);
        }
        C0658r2.a A4 = C0658r2.R().t(Z5.O(this.f3061d)).A(Z5.O(this.f3062e));
        if (this.f3063f == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(this.f3063f.size());
            for (Integer num : this.f3063f.keySet()) {
                int intValue = num.intValue();
                Long l4 = (Long) this.f3063f.get(num);
                if (l4 != null) {
                    arrayList.add((C0590j2) ((C0668s4) C0590j2.J().q(intValue).r(l4.longValue()).m()));
                }
            }
        }
        if (arrayList != null) {
            A4.r(arrayList);
        }
        if (this.f3064g == null) {
            list = Collections.EMPTY_LIST;
        } else {
            ArrayList arrayList2 = new ArrayList(this.f3064g.size());
            for (Integer num2 : this.f3064g.keySet()) {
                C0666s2.a q4 = C0666s2.K().q(num2.intValue());
                List list2 = (List) this.f3064g.get(num2);
                if (list2 != null) {
                    Collections.sort(list2);
                    q4.r(list2);
                }
                arrayList2.add((C0666s2) ((C0668s4) q4.m()));
            }
            list = arrayList2;
        }
        A4.y(list);
        J4.r(A4);
        return (C0581i2) ((C0668s4) J4.m());
    }

    /* access modifiers changed from: package-private */
    public final void c(C0734b bVar) {
        int a5 = bVar.a();
        Boolean bool = bVar.f2861c;
        if (bool != null) {
            this.f3062e.set(a5, bool.booleanValue());
        }
        Boolean bool2 = bVar.f2862d;
        if (bool2 != null) {
            this.f3061d.set(a5, bool2.booleanValue());
        }
        if (bVar.f2863e != null) {
            Long l4 = (Long) this.f3063f.get(Integer.valueOf(a5));
            long longValue = bVar.f2863e.longValue() / 1000;
            if (l4 == null || longValue > l4.longValue()) {
                this.f3063f.put(Integer.valueOf(a5), Long.valueOf(longValue));
            }
        }
        if (bVar.f2864f != null) {
            List list = (List) this.f3064g.get(Integer.valueOf(a5));
            if (list == null) {
                list = new ArrayList();
                this.f3064g.put(Integer.valueOf(a5), list);
            }
            if (bVar.j()) {
                list.clear();
            }
            if (A6.a() && this.f3065h.b().H(this.f3058a, G.f2502q0) && bVar.i()) {
                list.clear();
            }
            if (!A6.a() || !this.f3065h.b().H(this.f3058a, G.f2502q0)) {
                list.add(Long.valueOf(bVar.f2864f.longValue() / 1000));
                return;
            }
            long longValue2 = bVar.f2864f.longValue() / 1000;
            if (!list.contains(Long.valueOf(longValue2))) {
                list.add(Long.valueOf(longValue2));
            }
        }
    }

    private j6(h6 h6Var, String str) {
        this.f3065h = h6Var;
        this.f3058a = str;
        this.f3059b = true;
        this.f3061d = new BitSet();
        this.f3062e = new BitSet();
        this.f3063f = new ArrayMap();
        this.f3064g = new ArrayMap();
    }

    private j6(h6 h6Var, String str, C0658r2 r2Var, BitSet bitSet, BitSet bitSet2, Map map, Map map2) {
        this.f3065h = h6Var;
        this.f3058a = str;
        this.f3061d = bitSet;
        this.f3062e = bitSet2;
        this.f3063f = map;
        this.f3064g = new ArrayMap();
        if (map2 != null) {
            for (Integer num : map2.keySet()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add((Long) map2.get(num));
                this.f3064g.put(num, arrayList);
            }
        }
        this.f3059b = false;
        this.f3060c = r2Var;
    }
}
