package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.M1;

final class n6 extends C0734b {

    /* renamed from: g  reason: collision with root package name */
    private M1 f3151g;

    /* renamed from: h  reason: collision with root package name */
    private final /* synthetic */ h6 f3152h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    n6(h6 h6Var, String str, int i4, M1 m12) {
        super(str, i4);
        this.f3152h = h6Var;
        this.f3151g = m12;
    }

    /* access modifiers changed from: package-private */
    public final int a() {
        return this.f3151g.j();
    }

    /* access modifiers changed from: package-private */
    public final boolean i() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean j() {
        return true;
    }

    /* JADX WARNING: type inference failed for: r4v17, types: [java.lang.Integer] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean k(java.lang.Long r11, java.lang.Long r12, com.google.android.gms.internal.measurement.C0674t2 r13, boolean r14) {
        /*
            r10 = this;
            boolean r0 = com.google.android.gms.internal.measurement.A6.a()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x001a
            com.google.android.gms.measurement.internal.h6 r0 = r10.f3152h
            com.google.android.gms.measurement.internal.g r0 = r0.b()
            java.lang.String r3 = r10.f2859a
            com.google.android.gms.measurement.internal.b2 r4 = com.google.android.gms.measurement.internal.G.f2498o0
            boolean r0 = r0.H(r3, r4)
            if (r0 == 0) goto L_0x001a
            r0 = 1
            goto L_0x001b
        L_0x001a:
            r0 = 0
        L_0x001b:
            com.google.android.gms.internal.measurement.M1 r3 = r10.f3151g
            boolean r3 = r3.L()
            com.google.android.gms.internal.measurement.M1 r4 = r10.f3151g
            boolean r4 = r4.M()
            com.google.android.gms.internal.measurement.M1 r5 = r10.f3151g
            boolean r5 = r5.N()
            if (r3 != 0) goto L_0x0036
            if (r4 != 0) goto L_0x0036
            if (r5 == 0) goto L_0x0034
            goto L_0x0036
        L_0x0034:
            r3 = 0
            goto L_0x0037
        L_0x0036:
            r3 = 1
        L_0x0037:
            r4 = 0
            if (r14 == 0) goto L_0x0064
            if (r3 != 0) goto L_0x0064
            com.google.android.gms.measurement.internal.h6 r11 = r10.f3152h
            com.google.android.gms.measurement.internal.n2 r11 = r11.a()
            com.google.android.gms.measurement.internal.p2 r11 = r11.K()
            int r12 = r10.f2860b
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            com.google.android.gms.internal.measurement.M1 r13 = r10.f3151g
            boolean r13 = r13.O()
            if (r13 == 0) goto L_0x005e
            com.google.android.gms.internal.measurement.M1 r13 = r10.f3151g
            int r13 = r13.j()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r13)
        L_0x005e:
            java.lang.String r13 = "Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID"
            r11.c(r13, r12, r4)
            return r2
        L_0x0064:
            com.google.android.gms.internal.measurement.M1 r6 = r10.f3151g
            com.google.android.gms.internal.measurement.K1 r6 = r6.H()
            boolean r7 = r6.M()
            boolean r8 = r13.Y()
            if (r8 == 0) goto L_0x00ab
            boolean r8 = r6.O()
            if (r8 != 0) goto L_0x0099
            com.google.android.gms.measurement.internal.h6 r6 = r10.f3152h
            com.google.android.gms.measurement.internal.n2 r6 = r6.a()
            com.google.android.gms.measurement.internal.p2 r6 = r6.L()
            com.google.android.gms.measurement.internal.h6 r7 = r10.f3152h
            com.google.android.gms.measurement.internal.h2 r7 = r7.d()
            java.lang.String r8 = r13.U()
            java.lang.String r7 = r7.g(r8)
            java.lang.String r8 = "No number filter for long property. property"
            r6.b(r8, r7)
            goto L_0x0189
        L_0x0099:
            long r8 = r13.P()
            com.google.android.gms.internal.measurement.L1 r4 = r6.J()
            java.lang.Boolean r4 = com.google.android.gms.measurement.internal.C0734b.c(r8, r4)
            java.lang.Boolean r4 = com.google.android.gms.measurement.internal.C0734b.d(r4, r7)
            goto L_0x0189
        L_0x00ab:
            boolean r8 = r13.W()
            if (r8 == 0) goto L_0x00e8
            boolean r8 = r6.O()
            if (r8 != 0) goto L_0x00d6
            com.google.android.gms.measurement.internal.h6 r6 = r10.f3152h
            com.google.android.gms.measurement.internal.n2 r6 = r6.a()
            com.google.android.gms.measurement.internal.p2 r6 = r6.L()
            com.google.android.gms.measurement.internal.h6 r7 = r10.f3152h
            com.google.android.gms.measurement.internal.h2 r7 = r7.d()
            java.lang.String r8 = r13.U()
            java.lang.String r7 = r7.g(r8)
            java.lang.String r8 = "No number filter for double property. property"
            r6.b(r8, r7)
            goto L_0x0189
        L_0x00d6:
            double r8 = r13.G()
            com.google.android.gms.internal.measurement.L1 r4 = r6.J()
            java.lang.Boolean r4 = com.google.android.gms.measurement.internal.C0734b.b(r8, r4)
            java.lang.Boolean r4 = com.google.android.gms.measurement.internal.C0734b.d(r4, r7)
            goto L_0x0189
        L_0x00e8:
            boolean r8 = r13.a0()
            if (r8 == 0) goto L_0x016c
            boolean r8 = r6.Q()
            if (r8 != 0) goto L_0x0155
            boolean r8 = r6.O()
            if (r8 != 0) goto L_0x0118
            com.google.android.gms.measurement.internal.h6 r6 = r10.f3152h
            com.google.android.gms.measurement.internal.n2 r6 = r6.a()
            com.google.android.gms.measurement.internal.p2 r6 = r6.L()
            com.google.android.gms.measurement.internal.h6 r7 = r10.f3152h
            com.google.android.gms.measurement.internal.h2 r7 = r7.d()
            java.lang.String r8 = r13.U()
            java.lang.String r7 = r7.g(r8)
            java.lang.String r8 = "No string or number filter defined. property"
            r6.b(r8, r7)
            goto L_0x0189
        L_0x0118:
            java.lang.String r8 = r13.V()
            boolean r8 = com.google.android.gms.measurement.internal.Z5.g0(r8)
            if (r8 == 0) goto L_0x0133
            java.lang.String r4 = r13.V()
            com.google.android.gms.internal.measurement.L1 r6 = r6.J()
            java.lang.Boolean r4 = com.google.android.gms.measurement.internal.C0734b.e(r4, r6)
            java.lang.Boolean r4 = com.google.android.gms.measurement.internal.C0734b.d(r4, r7)
            goto L_0x0189
        L_0x0133:
            com.google.android.gms.measurement.internal.h6 r6 = r10.f3152h
            com.google.android.gms.measurement.internal.n2 r6 = r6.a()
            com.google.android.gms.measurement.internal.p2 r6 = r6.L()
            com.google.android.gms.measurement.internal.h6 r7 = r10.f3152h
            com.google.android.gms.measurement.internal.h2 r7 = r7.d()
            java.lang.String r8 = r13.U()
            java.lang.String r7 = r7.g(r8)
            java.lang.String r8 = r13.V()
            java.lang.String r9 = "Invalid user property value for Numeric number filter. property, value"
            r6.c(r9, r7, r8)
            goto L_0x0189
        L_0x0155:
            java.lang.String r4 = r13.V()
            com.google.android.gms.internal.measurement.N1 r6 = r6.K()
            com.google.android.gms.measurement.internal.h6 r8 = r10.f3152h
            com.google.android.gms.measurement.internal.n2 r8 = r8.a()
            java.lang.Boolean r4 = com.google.android.gms.measurement.internal.C0734b.g(r4, r6, r8)
            java.lang.Boolean r4 = com.google.android.gms.measurement.internal.C0734b.d(r4, r7)
            goto L_0x0189
        L_0x016c:
            com.google.android.gms.measurement.internal.h6 r6 = r10.f3152h
            com.google.android.gms.measurement.internal.n2 r6 = r6.a()
            com.google.android.gms.measurement.internal.p2 r6 = r6.L()
            com.google.android.gms.measurement.internal.h6 r7 = r10.f3152h
            com.google.android.gms.measurement.internal.h2 r7 = r7.d()
            java.lang.String r8 = r13.U()
            java.lang.String r7 = r7.g(r8)
            java.lang.String r8 = "User property has no value, property"
            r6.b(r8, r7)
        L_0x0189:
            com.google.android.gms.measurement.internal.h6 r6 = r10.f3152h
            com.google.android.gms.measurement.internal.n2 r6 = r6.a()
            com.google.android.gms.measurement.internal.p2 r6 = r6.K()
            if (r4 != 0) goto L_0x0198
            java.lang.String r7 = "null"
            goto L_0x0199
        L_0x0198:
            r7 = r4
        L_0x0199:
            java.lang.String r8 = "Property filter result"
            r6.b(r8, r7)
            if (r4 != 0) goto L_0x01a1
            return r1
        L_0x01a1:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            r10.f2861c = r1
            if (r5 == 0) goto L_0x01ae
            boolean r1 = r4.booleanValue()
            if (r1 != 0) goto L_0x01ae
            return r2
        L_0x01ae:
            if (r14 == 0) goto L_0x01b8
            com.google.android.gms.internal.measurement.M1 r14 = r10.f3151g
            boolean r14 = r14.L()
            if (r14 == 0) goto L_0x01ba
        L_0x01b8:
            r10.f2862d = r4
        L_0x01ba:
            boolean r14 = r4.booleanValue()
            if (r14 == 0) goto L_0x01ff
            if (r3 == 0) goto L_0x01ff
            boolean r14 = r13.Z()
            if (r14 == 0) goto L_0x01ff
            long r13 = r13.R()
            if (r11 == 0) goto L_0x01d2
            long r13 = r11.longValue()
        L_0x01d2:
            if (r0 == 0) goto L_0x01ea
            com.google.android.gms.internal.measurement.M1 r11 = r10.f3151g
            boolean r11 = r11.L()
            if (r11 == 0) goto L_0x01ea
            com.google.android.gms.internal.measurement.M1 r11 = r10.f3151g
            boolean r11 = r11.M()
            if (r11 != 0) goto L_0x01ea
            if (r12 == 0) goto L_0x01ea
            long r13 = r12.longValue()
        L_0x01ea:
            com.google.android.gms.internal.measurement.M1 r11 = r10.f3151g
            boolean r11 = r11.M()
            if (r11 == 0) goto L_0x01f9
            java.lang.Long r11 = java.lang.Long.valueOf(r13)
            r10.f2864f = r11
            goto L_0x01ff
        L_0x01f9:
            java.lang.Long r11 = java.lang.Long.valueOf(r13)
            r10.f2863e = r11
        L_0x01ff:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.n6.k(java.lang.Long, java.lang.Long, com.google.android.gms.internal.measurement.t2, boolean):boolean");
    }
}
