package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.G7;
import com.google.android.gms.internal.measurement.J7;
import java.util.List;

final class N2 implements J7 {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ I2 f2657a;

    N2(I2 i22) {
        this.f2657a = i22;
    }

    public final void a(G7 g7, String str, List list, boolean z4, boolean z5) {
        C0835p2 p2Var;
        int i4 = O2.f2662a[g7.ordinal()];
        if (i4 == 1) {
            p2Var = this.f2657a.a().F();
        } else if (i4 != 2) {
            if (i4 != 3) {
                if (i4 != 4) {
                    p2Var = this.f2657a.a().J();
                } else {
                    p2Var = this.f2657a.a().K();
                }
            } else if (z4) {
                p2Var = this.f2657a.a().N();
            } else if (!z5) {
                p2Var = this.f2657a.a().M();
            } else {
                p2Var = this.f2657a.a().L();
            }
        } else if (z4) {
            p2Var = this.f2657a.a().I();
        } else if (!z5) {
            p2Var = this.f2657a.a().H();
        } else {
            p2Var = this.f2657a.a().G();
        }
        int size = list.size();
        if (size == 1) {
            p2Var.b(str, list.get(0));
        } else if (size == 2) {
            p2Var.c(str, list.get(0), list.get(1));
        } else if (size != 3) {
            p2Var.a(str);
        } else {
            p2Var.d(str, list.get(0), list.get(1), list.get(2));
        }
    }
}
