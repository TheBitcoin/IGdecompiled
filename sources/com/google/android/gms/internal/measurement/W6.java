package com.google.android.gms.internal.measurement;

import java.util.List;

final class W6 extends C0623n {

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ C0694v6 f1657c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    W6(C0685u5 u5Var, String str, C0694v6 v6Var) {
        super(str);
        this.f1657c = v6Var;
    }

    public final C0663s a(Z2 z22, List list) {
        C0690v2.g("getValue", 2, list);
        C0663s b5 = z22.b((C0663s) list.get(0));
        C0663s b6 = z22.b((C0663s) list.get(1));
        String c5 = this.f1657c.c(b5.E());
        if (c5 != null) {
            return new C0679u(c5);
        }
        return b6;
    }
}
