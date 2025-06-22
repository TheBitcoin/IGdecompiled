package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class I7 extends C0623n {

    /* renamed from: c  reason: collision with root package name */
    private boolean f1499c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f1500d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ F7 f1501e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public I7(F7 f7, boolean z4, boolean z5) {
        super("log");
        this.f1501e = f7;
        this.f1499c = z4;
        this.f1500d = z5;
    }

    public final C0663s a(Z2 z22, List list) {
        C0690v2.k("log", 1, list);
        if (list.size() == 1) {
            this.f1501e.f1473c.a(G7.INFO, z22.b((C0663s) list.get(0)).E(), Collections.EMPTY_LIST, this.f1499c, this.f1500d);
            return C0663s.f2138b0;
        }
        G7 a5 = G7.a(C0690v2.i(z22.b((C0663s) list.get(0)).D().doubleValue()));
        String E4 = z22.b((C0663s) list.get(1)).E();
        if (list.size() == 2) {
            this.f1501e.f1473c.a(a5, E4, Collections.EMPTY_LIST, this.f1499c, this.f1500d);
            return C0663s.f2138b0;
        }
        ArrayList arrayList = new ArrayList();
        for (int i4 = 2; i4 < Math.min(list.size(), 5); i4++) {
            arrayList.add(z22.b((C0663s) list.get(i4)).E());
        }
        this.f1501e.f1473c.a(a5, E4, arrayList, this.f1499c, this.f1500d);
        return C0663s.f2138b0;
    }
}
