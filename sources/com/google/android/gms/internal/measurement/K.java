package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Comparator;

final class K implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ C0623n f1512a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ Z2 f1513b;

    K(C0623n nVar, Z2 z22) {
        this.f1512a = nVar;
        this.f1513b = z22;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        C0663s sVar = (C0663s) obj;
        C0663s sVar2 = (C0663s) obj2;
        C0623n nVar = this.f1512a;
        Z2 z22 = this.f1513b;
        if (sVar instanceof C0719z) {
            if (!(sVar2 instanceof C0719z)) {
                return 1;
            }
            return 0;
        } else if (sVar2 instanceof C0719z) {
            return -1;
        } else {
            if (nVar == null) {
                return sVar.E().compareTo(sVar2.E());
            }
            return (int) C0690v2.a(nVar.a(z22, Arrays.asList(new C0663s[]{sVar, sVar2})).D().doubleValue());
        }
    }
}
