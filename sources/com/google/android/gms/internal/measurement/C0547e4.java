package com.google.android.gms.internal.measurement;

import android.support.v4.media.a;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.measurement.e4  reason: case insensitive filesystem */
final class C0547e4 implements W5 {

    /* renamed from: a  reason: collision with root package name */
    private final C0520b4 f1886a;

    private C0547e4(C0520b4 b4Var) {
        C0520b4 b4Var2 = (C0520b4) C0684u4.f(b4Var, "output");
        this.f1886a = b4Var2;
        b4Var2.f1758a = this;
    }

    public static C0547e4 P(C0520b4 b4Var) {
        C0547e4 e4Var = b4Var.f1758a;
        if (e4Var != null) {
            return e4Var;
        }
        return new C0547e4(b4Var);
    }

    public final int A() {
        return 1;
    }

    public final void B(int i4, int i5) {
        this.f1886a.b0(i4, i5);
    }

    public final void C(int i4, List list, boolean z4) {
        int i5 = 0;
        if (list instanceof J4) {
            J4 j4 = (J4) list;
            if (z4) {
                this.f1886a.V(i4, 2);
                int i6 = 0;
                for (int i7 = 0; i7 < j4.size(); i7++) {
                    i6 += C0520b4.n0(j4.d(i7));
                }
                this.f1886a.U(i6);
                while (i5 < j4.size()) {
                    this.f1886a.N(j4.d(i5));
                    i5++;
                }
                return;
            }
            while (i5 < j4.size()) {
                this.f1886a.L(i4, j4.d(i5));
                i5++;
            }
        } else if (z4) {
            this.f1886a.V(i4, 2);
            int i8 = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                i8 += C0520b4.n0(((Long) list.get(i9)).longValue());
            }
            this.f1886a.U(i8);
            while (i5 < list.size()) {
                this.f1886a.N(((Long) list.get(i5)).longValue());
                i5++;
            }
        } else {
            while (i5 < list.size()) {
                this.f1886a.L(i4, ((Long) list.get(i5)).longValue());
                i5++;
            }
        }
    }

    public final void D(int i4, Object obj, C0638o5 o5Var) {
        C0520b4 b4Var = this.f1886a;
        b4Var.V(i4, 3);
        o5Var.f((Z4) obj, b4Var.f1758a);
        b4Var.V(i4, 4);
    }

    public final void E(int i4, List list, boolean z4) {
        int i5 = 0;
        if (list instanceof C0692v4) {
            C0692v4 v4Var = (C0692v4) list;
            if (z4) {
                this.f1886a.V(i4, 2);
                int i6 = 0;
                for (int i7 = 0; i7 < v4Var.size(); i7++) {
                    i6 += C0520b4.c0(v4Var.g(i7));
                }
                this.f1886a.U(i6);
                while (i5 < v4Var.size()) {
                    this.f1886a.k(v4Var.g(i5));
                    i5++;
                }
                return;
            }
            while (i5 < v4Var.size()) {
                this.f1886a.l(i4, v4Var.g(i5));
                i5++;
            }
        } else if (z4) {
            this.f1886a.V(i4, 2);
            int i8 = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                i8 += C0520b4.c0(((Integer) list.get(i9)).intValue());
            }
            this.f1886a.U(i8);
            while (i5 < list.size()) {
                this.f1886a.k(((Integer) list.get(i5)).intValue());
                i5++;
            }
        } else {
            while (i5 < list.size()) {
                this.f1886a.l(i4, ((Integer) list.get(i5)).intValue());
                i5++;
            }
        }
    }

    public final void F(int i4, Object obj, C0638o5 o5Var) {
        this.f1886a.p(i4, (Z4) obj, o5Var);
    }

    public final void G(int i4, List list, boolean z4) {
        int i5 = 0;
        if (list instanceof C0692v4) {
            C0692v4 v4Var = (C0692v4) list;
            if (z4) {
                this.f1886a.V(i4, 2);
                int i6 = 0;
                for (int i7 = 0; i7 < v4Var.size(); i7++) {
                    i6 += C0520b4.v0(v4Var.g(i7));
                }
                this.f1886a.U(i6);
                while (i5 < v4Var.size()) {
                    this.f1886a.U(v4Var.g(i5));
                    i5++;
                }
                return;
            }
            while (i5 < v4Var.size()) {
                this.f1886a.b0(i4, v4Var.g(i5));
                i5++;
            }
        } else if (z4) {
            this.f1886a.V(i4, 2);
            int i8 = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                i8 += C0520b4.v0(((Integer) list.get(i9)).intValue());
            }
            this.f1886a.U(i8);
            while (i5 < list.size()) {
                this.f1886a.U(((Integer) list.get(i5)).intValue());
                i5++;
            }
        } else {
            while (i5 < list.size()) {
                this.f1886a.b0(i4, ((Integer) list.get(i5)).intValue());
                i5++;
            }
        }
    }

    public final void H(int i4, List list, boolean z4) {
        int i5 = 0;
        if (list instanceof C0692v4) {
            C0692v4 v4Var = (C0692v4) list;
            if (z4) {
                this.f1886a.V(i4, 2);
                int i6 = 0;
                for (int i7 = 0; i7 < v4Var.size(); i7++) {
                    i6 += C0520b4.g0(v4Var.g(i7));
                }
                this.f1886a.U(i6);
                while (i5 < v4Var.size()) {
                    this.f1886a.H(v4Var.g(i5));
                    i5++;
                }
                return;
            }
            while (i5 < v4Var.size()) {
                this.f1886a.K(i4, v4Var.g(i5));
                i5++;
            }
        } else if (z4) {
            this.f1886a.V(i4, 2);
            int i8 = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                i8 += C0520b4.g0(((Integer) list.get(i9)).intValue());
            }
            this.f1886a.U(i8);
            while (i5 < list.size()) {
                this.f1886a.H(((Integer) list.get(i5)).intValue());
                i5++;
            }
        } else {
            while (i5 < list.size()) {
                this.f1886a.K(i4, ((Integer) list.get(i5)).intValue());
                i5++;
            }
        }
    }

    public final void I(int i4, List list) {
        int i5 = 0;
        if (list instanceof G4) {
            G4 g4 = (G4) list;
            while (i5 < list.size()) {
                Object a5 = g4.a(i5);
                if (a5 instanceof String) {
                    this.f1886a.q(i4, (String) a5);
                } else {
                    this.f1886a.n(i4, (K3) a5);
                }
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.f1886a.q(i4, (String) list.get(i5));
            i5++;
        }
    }

    public final void J(int i4, int i5) {
        this.f1886a.l(i4, i5);
    }

    public final void K(int i4, long j4) {
        this.f1886a.q0(i4, j4);
    }

    public final void L(int i4, List list, boolean z4) {
        if (list instanceof C0660r4) {
            a.a(list);
            if (z4) {
                this.f1886a.V(i4, 2);
                throw null;
            }
            throw null;
        }
        int i5 = 0;
        if (z4) {
            this.f1886a.V(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += C0520b4.d(((Float) list.get(i7)).floatValue());
            }
            this.f1886a.U(i6);
            while (i5 < list.size()) {
                this.f1886a.G(((Float) list.get(i5)).floatValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.f1886a.J(i4, ((Float) list.get(i5)).floatValue());
            i5++;
        }
    }

    public final void M(int i4, int i5) {
        this.f1886a.y0(i4, i5);
    }

    public final void N(int i4, long j4) {
        this.f1886a.L(i4, j4);
    }

    public final void O(int i4, List list) {
        for (int i5 = 0; i5 < list.size(); i5++) {
            this.f1886a.n(i4, (K3) list.get(i5));
        }
    }

    public final void a(int i4) {
        this.f1886a.V(i4, 4);
    }

    public final void b(int i4, boolean z4) {
        this.f1886a.r(i4, z4);
    }

    public final void c(int i4, List list, boolean z4) {
        int i5 = 0;
        if (list instanceof C0692v4) {
            C0692v4 v4Var = (C0692v4) list;
            if (z4) {
                this.f1886a.V(i4, 2);
                int i6 = 0;
                for (int i7 = 0; i7 < v4Var.size(); i7++) {
                    i6 += C0520b4.k0(v4Var.g(i7));
                }
                this.f1886a.U(i6);
                while (i5 < v4Var.size()) {
                    this.f1886a.k(v4Var.g(i5));
                    i5++;
                }
                return;
            }
            while (i5 < v4Var.size()) {
                this.f1886a.l(i4, v4Var.g(i5));
                i5++;
            }
        } else if (z4) {
            this.f1886a.V(i4, 2);
            int i8 = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                i8 += C0520b4.k0(((Integer) list.get(i9)).intValue());
            }
            this.f1886a.U(i8);
            while (i5 < list.size()) {
                this.f1886a.k(((Integer) list.get(i5)).intValue());
                i5++;
            }
        } else {
            while (i5 < list.size()) {
                this.f1886a.l(i4, ((Integer) list.get(i5)).intValue());
                i5++;
            }
        }
    }

    public final void d(int i4) {
        this.f1886a.V(i4, 3);
    }

    public final void e(int i4, List list, C0638o5 o5Var) {
        for (int i5 = 0; i5 < list.size(); i5++) {
            F(i4, list.get(i5), o5Var);
        }
    }

    public final void f(int i4, long j4) {
        this.f1886a.L(i4, j4);
    }

    public final void g(int i4, P4 p4, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            this.f1886a.V(i4, 2);
            this.f1886a.U(Q4.a(p4, entry.getKey(), entry.getValue()));
            Q4.b(this.f1886a, p4, entry.getKey(), entry.getValue());
        }
    }

    public final void h(int i4, int i5) {
        this.f1886a.l(i4, i5);
    }

    public final void i(int i4, List list, boolean z4) {
        if (list instanceof I3) {
            a.a(list);
            if (z4) {
                this.f1886a.V(i4, 2);
                throw null;
            }
            throw null;
        }
        int i5 = 0;
        if (z4) {
            this.f1886a.V(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += C0520b4.h(((Boolean) list.get(i7)).booleanValue());
            }
            this.f1886a.U(i6);
            while (i5 < list.size()) {
                this.f1886a.O(((Boolean) list.get(i5)).booleanValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.f1886a.r(i4, ((Boolean) list.get(i5)).booleanValue());
            i5++;
        }
    }

    public final void j(int i4, K3 k32) {
        this.f1886a.n(i4, k32);
    }

    public final void k(int i4, List list, boolean z4) {
        int i5 = 0;
        if (list instanceof J4) {
            J4 j4 = (J4) list;
            if (z4) {
                this.f1886a.V(i4, 2);
                int i6 = 0;
                for (int i7 = 0; i7 < j4.size(); i7++) {
                    i6 += C0520b4.a0(j4.d(i7));
                }
                this.f1886a.U(i6);
                while (i5 < j4.size()) {
                    this.f1886a.N(j4.d(i5));
                    i5++;
                }
                return;
            }
            while (i5 < j4.size()) {
                this.f1886a.L(i4, j4.d(i5));
                i5++;
            }
        } else if (z4) {
            this.f1886a.V(i4, 2);
            int i8 = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                i8 += C0520b4.a0(((Long) list.get(i9)).longValue());
            }
            this.f1886a.U(i8);
            while (i5 < list.size()) {
                this.f1886a.N(((Long) list.get(i5)).longValue());
                i5++;
            }
        } else {
            while (i5 < list.size()) {
                this.f1886a.L(i4, ((Long) list.get(i5)).longValue());
                i5++;
            }
        }
    }

    public final void l(int i4, List list, C0638o5 o5Var) {
        for (int i5 = 0; i5 < list.size(); i5++) {
            D(i4, list.get(i5), o5Var);
        }
    }

    public final void m(int i4, int i5) {
        this.f1886a.K(i4, i5);
    }

    public final void n(int i4, long j4) {
        this.f1886a.m(i4, j4);
    }

    public final void o(int i4, Object obj) {
        if (obj instanceof K3) {
            this.f1886a.M(i4, (K3) obj);
        } else {
            this.f1886a.o(i4, (Z4) obj);
        }
    }

    public final void p(int i4, List list, boolean z4) {
        int i5 = 0;
        if (list instanceof C0692v4) {
            C0692v4 v4Var = (C0692v4) list;
            if (z4) {
                this.f1886a.V(i4, 2);
                int i6 = 0;
                for (int i7 = 0; i7 < v4Var.size(); i7++) {
                    i6 += C0520b4.X(v4Var.g(i7));
                }
                this.f1886a.U(i6);
                while (i5 < v4Var.size()) {
                    this.f1886a.H(v4Var.g(i5));
                    i5++;
                }
                return;
            }
            while (i5 < v4Var.size()) {
                this.f1886a.K(i4, v4Var.g(i5));
                i5++;
            }
        } else if (z4) {
            this.f1886a.V(i4, 2);
            int i8 = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                i8 += C0520b4.X(((Integer) list.get(i9)).intValue());
            }
            this.f1886a.U(i8);
            while (i5 < list.size()) {
                this.f1886a.H(((Integer) list.get(i5)).intValue());
                i5++;
            }
        } else {
            while (i5 < list.size()) {
                this.f1886a.K(i4, ((Integer) list.get(i5)).intValue());
                i5++;
            }
        }
    }

    public final void q(int i4, List list, boolean z4) {
        int i5 = 0;
        if (list instanceof J4) {
            J4 j4 = (J4) list;
            if (z4) {
                this.f1886a.V(i4, 2);
                int i6 = 0;
                for (int i7 = 0; i7 < j4.size(); i7++) {
                    i6 += C0520b4.j0(j4.d(i7));
                }
                this.f1886a.U(i6);
                while (i5 < j4.size()) {
                    this.f1886a.r0(j4.d(i5));
                    i5++;
                }
                return;
            }
            while (i5 < j4.size()) {
                this.f1886a.q0(i4, j4.d(i5));
                i5++;
            }
        } else if (z4) {
            this.f1886a.V(i4, 2);
            int i8 = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                i8 += C0520b4.j0(((Long) list.get(i9)).longValue());
            }
            this.f1886a.U(i8);
            while (i5 < list.size()) {
                this.f1886a.r0(((Long) list.get(i5)).longValue());
                i5++;
            }
        } else {
            while (i5 < list.size()) {
                this.f1886a.q0(i4, ((Long) list.get(i5)).longValue());
                i5++;
            }
        }
    }

    public final void r(int i4, List list, boolean z4) {
        if (list instanceof C0538d4) {
            a.a(list);
            if (z4) {
                this.f1886a.V(i4, 2);
                throw null;
            }
            throw null;
        }
        int i5 = 0;
        if (z4) {
            this.f1886a.V(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += C0520b4.c(((Double) list.get(i7)).doubleValue());
            }
            this.f1886a.U(i6);
            while (i5 < list.size()) {
                this.f1886a.F(((Double) list.get(i5)).doubleValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.f1886a.I(i4, ((Double) list.get(i5)).doubleValue());
            i5++;
        }
    }

    public final void s(int i4, String str) {
        this.f1886a.q(i4, str);
    }

    public final void t(int i4, List list, boolean z4) {
        int i5 = 0;
        if (list instanceof J4) {
            J4 j4 = (J4) list;
            if (z4) {
                this.f1886a.V(i4, 2);
                int i6 = 0;
                for (int i7 = 0; i7 < j4.size(); i7++) {
                    i6 += C0520b4.f0(j4.d(i7));
                }
                this.f1886a.U(i6);
                while (i5 < j4.size()) {
                    this.f1886a.s(j4.d(i5));
                    i5++;
                }
                return;
            }
            while (i5 < j4.size()) {
                this.f1886a.m(i4, j4.d(i5));
                i5++;
            }
        } else if (z4) {
            this.f1886a.V(i4, 2);
            int i8 = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                i8 += C0520b4.f0(((Long) list.get(i9)).longValue());
            }
            this.f1886a.U(i8);
            while (i5 < list.size()) {
                this.f1886a.s(((Long) list.get(i5)).longValue());
                i5++;
            }
        } else {
            while (i5 < list.size()) {
                this.f1886a.m(i4, ((Long) list.get(i5)).longValue());
                i5++;
            }
        }
    }

    public final void u(int i4, List list, boolean z4) {
        int i5 = 0;
        if (list instanceof C0692v4) {
            C0692v4 v4Var = (C0692v4) list;
            if (z4) {
                this.f1886a.V(i4, 2);
                int i6 = 0;
                for (int i7 = 0; i7 < v4Var.size(); i7++) {
                    i6 += C0520b4.o0(v4Var.g(i7));
                }
                this.f1886a.U(i6);
                while (i5 < v4Var.size()) {
                    this.f1886a.x0(v4Var.g(i5));
                    i5++;
                }
                return;
            }
            while (i5 < v4Var.size()) {
                this.f1886a.y0(i4, v4Var.g(i5));
                i5++;
            }
        } else if (z4) {
            this.f1886a.V(i4, 2);
            int i8 = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                i8 += C0520b4.o0(((Integer) list.get(i9)).intValue());
            }
            this.f1886a.U(i8);
            while (i5 < list.size()) {
                this.f1886a.x0(((Integer) list.get(i5)).intValue());
                i5++;
            }
        } else {
            while (i5 < list.size()) {
                this.f1886a.y0(i4, ((Integer) list.get(i5)).intValue());
                i5++;
            }
        }
    }

    public final void v(int i4, int i5) {
        this.f1886a.K(i4, i5);
    }

    public final void w(int i4, long j4) {
        this.f1886a.m(i4, j4);
    }

    public final void x(int i4, double d5) {
        this.f1886a.I(i4, d5);
    }

    public final void y(int i4, float f4) {
        this.f1886a.J(i4, f4);
    }

    public final void z(int i4, List list, boolean z4) {
        int i5 = 0;
        if (list instanceof J4) {
            J4 j4 = (J4) list;
            if (z4) {
                this.f1886a.V(i4, 2);
                int i6 = 0;
                for (int i7 = 0; i7 < j4.size(); i7++) {
                    i6 += C0520b4.S(j4.d(i7));
                }
                this.f1886a.U(i6);
                while (i5 < j4.size()) {
                    this.f1886a.s(j4.d(i5));
                    i5++;
                }
                return;
            }
            while (i5 < j4.size()) {
                this.f1886a.m(i4, j4.d(i5));
                i5++;
            }
        } else if (z4) {
            this.f1886a.V(i4, 2);
            int i8 = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                i8 += C0520b4.S(((Long) list.get(i9)).longValue());
            }
            this.f1886a.U(i8);
            while (i5 < list.size()) {
                this.f1886a.s(((Long) list.get(i5)).longValue());
                i5++;
            }
        } else {
            while (i5 < list.size()) {
                this.f1886a.m(i4, ((Long) list.get(i5)).longValue());
                i5++;
            }
        }
    }
}
