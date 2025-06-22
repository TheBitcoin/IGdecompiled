package com.google.android.gms.internal.measurement;

final class G5 extends E5 {
    G5() {
    }

    private static void m(Object obj, D5 d5) {
        ((C0668s4) obj).zzb = d5;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int a(Object obj) {
        return ((D5) obj).a();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object b(Object obj, Object obj2) {
        D5 d5 = (D5) obj;
        D5 d52 = (D5) obj2;
        if (D5.k().equals(d52)) {
            return d5;
        }
        if (D5.k().equals(d5)) {
            return D5.c(d5, d52);
        }
        return d5.b(d52);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void c(Object obj, int i4, K3 k32) {
        ((D5) obj).e((i4 << 3) | 2, k32);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void d(Object obj, W5 w5) {
        ((D5) obj).g(w5);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int e(Object obj) {
        return ((D5) obj).i();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void f(Object obj, int i4, long j4) {
        ((D5) obj).e(i4 << 3, Long.valueOf(j4));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void g(Object obj, W5 w5) {
        ((D5) obj).j(w5);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void h(Object obj, Object obj2) {
        m(obj, (D5) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object i(Object obj) {
        D5 d5 = ((C0668s4) obj).zzb;
        if (d5 != D5.k()) {
            return d5;
        }
        D5 l4 = D5.l();
        m(obj, l4);
        return l4;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void j(Object obj, Object obj2) {
        m(obj, (D5) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object k(Object obj) {
        return ((C0668s4) obj).zzb;
    }

    /* access modifiers changed from: package-private */
    public final void l(Object obj) {
        ((C0668s4) obj).zzb.m();
    }
}
