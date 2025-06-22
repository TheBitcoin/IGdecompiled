package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.J1;

final class l6 extends C0734b {

    /* renamed from: g  reason: collision with root package name */
    private J1 f3110g;

    /* renamed from: h  reason: collision with root package name */
    private final /* synthetic */ h6 f3111h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    l6(h6 h6Var, String str, int i4, J1 j12) {
        super(str, i4);
        this.f3111h = h6Var;
        this.f3110g = j12;
    }

    /* access modifiers changed from: package-private */
    public final int a() {
        return this.f3110g.J();
    }

    /* access modifiers changed from: package-private */
    public final boolean i() {
        return this.f3110g.S();
    }

    /* access modifiers changed from: package-private */
    public final boolean j() {
        return false;
    }

    /* JADX WARNING: type inference failed for: r6v3, types: [java.lang.Integer] */
    /* JADX WARNING: type inference failed for: r6v15, types: [java.lang.Integer] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x03ad  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x03b0  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x03b8 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x03b9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean k(java.lang.Long r15, java.lang.Long r16, com.google.android.gms.internal.measurement.C0599k2 r17, long r18, com.google.android.gms.measurement.internal.A r20, boolean r21) {
        /*
            r14 = this;
            boolean r0 = com.google.android.gms.internal.measurement.A6.a()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x001a
            com.google.android.gms.measurement.internal.h6 r0 = r14.f3111h
            com.google.android.gms.measurement.internal.g r0 = r0.b()
            java.lang.String r3 = r14.f2859a
            com.google.android.gms.measurement.internal.b2 r4 = com.google.android.gms.measurement.internal.G.f2502q0
            boolean r0 = r0.H(r3, r4)
            if (r0 == 0) goto L_0x001a
            r0 = 1
            goto L_0x001b
        L_0x001a:
            r0 = 0
        L_0x001b:
            com.google.android.gms.internal.measurement.J1 r3 = r14.f3110g
            boolean r3 = r3.R()
            if (r3 == 0) goto L_0x0028
            r3 = r20
            long r3 = r3.f2287e
            goto L_0x002a
        L_0x0028:
            r3 = r18
        L_0x002a:
            com.google.android.gms.measurement.internal.h6 r5 = r14.f3111h
            com.google.android.gms.measurement.internal.n2 r5 = r5.a()
            r6 = 2
            boolean r5 = r5.z(r6)
            r6 = 0
            if (r5 == 0) goto L_0x008c
            com.google.android.gms.measurement.internal.h6 r5 = r14.f3111h
            com.google.android.gms.measurement.internal.n2 r5 = r5.a()
            com.google.android.gms.measurement.internal.p2 r5 = r5.K()
            int r7 = r14.f2860b
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            com.google.android.gms.internal.measurement.J1 r8 = r14.f3110g
            boolean r8 = r8.T()
            if (r8 == 0) goto L_0x005b
            com.google.android.gms.internal.measurement.J1 r8 = r14.f3110g
            int r8 = r8.J()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            goto L_0x005c
        L_0x005b:
            r8 = r6
        L_0x005c:
            com.google.android.gms.measurement.internal.h6 r9 = r14.f3111h
            com.google.android.gms.measurement.internal.h2 r9 = r9.d()
            com.google.android.gms.internal.measurement.J1 r10 = r14.f3110g
            java.lang.String r10 = r10.N()
            java.lang.String r9 = r9.c(r10)
            java.lang.String r10 = "Evaluating filter. audience, filter, event"
            r5.d(r10, r7, r8, r9)
            com.google.android.gms.measurement.internal.h6 r5 = r14.f3111h
            com.google.android.gms.measurement.internal.n2 r5 = r5.a()
            com.google.android.gms.measurement.internal.p2 r5 = r5.K()
            com.google.android.gms.measurement.internal.h6 r7 = r14.f3111h
            com.google.android.gms.measurement.internal.Z5 r7 = r7.l()
            com.google.android.gms.internal.measurement.J1 r8 = r14.f3110g
            java.lang.String r7 = r7.K(r8)
            java.lang.String r8 = "Filter definition"
            r5.b(r8, r7)
        L_0x008c:
            com.google.android.gms.internal.measurement.J1 r5 = r14.f3110g
            boolean r5 = r5.T()
            if (r5 == 0) goto L_0x03fc
            com.google.android.gms.internal.measurement.J1 r5 = r14.f3110g
            int r5 = r5.J()
            r7 = 256(0x100, float:3.59E-43)
            if (r5 <= r7) goto L_0x00a0
            goto L_0x03fc
        L_0x00a0:
            com.google.android.gms.internal.measurement.J1 r5 = r14.f3110g
            boolean r5 = r5.P()
            com.google.android.gms.internal.measurement.J1 r7 = r14.f3110g
            boolean r7 = r7.Q()
            com.google.android.gms.internal.measurement.J1 r8 = r14.f3110g
            boolean r8 = r8.R()
            if (r5 != 0) goto L_0x00bb
            if (r7 != 0) goto L_0x00bb
            if (r8 == 0) goto L_0x00b9
            goto L_0x00bb
        L_0x00b9:
            r5 = 0
            goto L_0x00bc
        L_0x00bb:
            r5 = 1
        L_0x00bc:
            if (r21 == 0) goto L_0x00e8
            if (r5 != 0) goto L_0x00e8
            com.google.android.gms.measurement.internal.h6 r15 = r14.f3111h
            com.google.android.gms.measurement.internal.n2 r15 = r15.a()
            com.google.android.gms.measurement.internal.p2 r15 = r15.K()
            int r0 = r14.f2860b
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            com.google.android.gms.internal.measurement.J1 r1 = r14.f3110g
            boolean r1 = r1.T()
            if (r1 == 0) goto L_0x00e2
            com.google.android.gms.internal.measurement.J1 r1 = r14.f3110g
            int r1 = r1.J()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r1)
        L_0x00e2:
            java.lang.String r1 = "Event filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID"
            r15.c(r1, r0, r6)
            return r2
        L_0x00e8:
            com.google.android.gms.internal.measurement.J1 r7 = r14.f3110g
            java.lang.String r8 = r17.U()
            boolean r9 = r7.S()
            if (r9 == 0) goto L_0x010a
            com.google.android.gms.internal.measurement.L1 r9 = r7.M()
            java.lang.Boolean r3 = com.google.android.gms.measurement.internal.C0734b.c(r3, r9)
            if (r3 != 0) goto L_0x0100
            goto L_0x03a1
        L_0x0100:
            boolean r3 = r3.booleanValue()
            if (r3 != 0) goto L_0x010a
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            goto L_0x03a1
        L_0x010a:
            java.util.HashSet r3 = new java.util.HashSet
            r3.<init>()
            java.util.List r4 = r7.O()
            java.util.Iterator r4 = r4.iterator()
        L_0x0117:
            boolean r9 = r4.hasNext()
            if (r9 == 0) goto L_0x0150
            java.lang.Object r9 = r4.next()
            com.google.android.gms.internal.measurement.K1 r9 = (com.google.android.gms.internal.measurement.K1) r9
            java.lang.String r10 = r9.L()
            boolean r10 = r10.isEmpty()
            if (r10 == 0) goto L_0x0148
            com.google.android.gms.measurement.internal.h6 r3 = r14.f3111h
            com.google.android.gms.measurement.internal.n2 r3 = r3.a()
            com.google.android.gms.measurement.internal.p2 r3 = r3.L()
            com.google.android.gms.measurement.internal.h6 r4 = r14.f3111h
            com.google.android.gms.measurement.internal.h2 r4 = r4.d()
            java.lang.String r4 = r4.c(r8)
            java.lang.String r7 = "null or empty param name in filter. event"
            r3.b(r7, r4)
            goto L_0x03a1
        L_0x0148:
            java.lang.String r9 = r9.L()
            r3.add(r9)
            goto L_0x0117
        L_0x0150:
            androidx.collection.ArrayMap r4 = new androidx.collection.ArrayMap
            r4.<init>()
            java.util.List r9 = r17.V()
            java.util.Iterator r9 = r9.iterator()
        L_0x015d:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x01ea
            java.lang.Object r10 = r9.next()
            com.google.android.gms.internal.measurement.m2 r10 = (com.google.android.gms.internal.measurement.C0617m2) r10
            java.lang.String r11 = r10.W()
            boolean r11 = r3.contains(r11)
            if (r11 == 0) goto L_0x015d
            boolean r11 = r10.b0()
            if (r11 == 0) goto L_0x0191
            java.lang.String r11 = r10.W()
            boolean r12 = r10.b0()
            if (r12 == 0) goto L_0x018c
            long r12 = r10.S()
            java.lang.Long r10 = java.lang.Long.valueOf(r12)
            goto L_0x018d
        L_0x018c:
            r10 = r6
        L_0x018d:
            r4.put(r11, r10)
            goto L_0x015d
        L_0x0191:
            boolean r11 = r10.Z()
            if (r11 == 0) goto L_0x01af
            java.lang.String r11 = r10.W()
            boolean r12 = r10.Z()
            if (r12 == 0) goto L_0x01aa
            double r12 = r10.G()
            java.lang.Double r10 = java.lang.Double.valueOf(r12)
            goto L_0x01ab
        L_0x01aa:
            r10 = r6
        L_0x01ab:
            r4.put(r11, r10)
            goto L_0x015d
        L_0x01af:
            boolean r11 = r10.d0()
            if (r11 == 0) goto L_0x01c1
            java.lang.String r11 = r10.W()
            java.lang.String r10 = r10.X()
            r4.put(r11, r10)
            goto L_0x015d
        L_0x01c1:
            com.google.android.gms.measurement.internal.h6 r3 = r14.f3111h
            com.google.android.gms.measurement.internal.n2 r3 = r3.a()
            com.google.android.gms.measurement.internal.p2 r3 = r3.L()
            com.google.android.gms.measurement.internal.h6 r4 = r14.f3111h
            com.google.android.gms.measurement.internal.h2 r4 = r4.d()
            java.lang.String r4 = r4.c(r8)
            com.google.android.gms.measurement.internal.h6 r7 = r14.f3111h
            com.google.android.gms.measurement.internal.h2 r7 = r7.d()
            java.lang.String r8 = r10.W()
            java.lang.String r7 = r7.f(r8)
            java.lang.String r8 = "Unknown value for param. event, param"
            r3.c(r8, r4, r7)
            goto L_0x03a1
        L_0x01ea:
            java.util.List r3 = r7.O()
            java.util.Iterator r3 = r3.iterator()
        L_0x01f2:
            boolean r7 = r3.hasNext()
            if (r7 == 0) goto L_0x039f
            java.lang.Object r7 = r3.next()
            com.google.android.gms.internal.measurement.K1 r7 = (com.google.android.gms.internal.measurement.K1) r7
            boolean r9 = r7.N()
            if (r9 == 0) goto L_0x020c
            boolean r9 = r7.M()
            if (r9 == 0) goto L_0x020c
            r9 = 1
            goto L_0x020d
        L_0x020c:
            r9 = 0
        L_0x020d:
            java.lang.String r10 = r7.L()
            boolean r11 = r10.isEmpty()
            if (r11 == 0) goto L_0x0232
            com.google.android.gms.measurement.internal.h6 r3 = r14.f3111h
            com.google.android.gms.measurement.internal.n2 r3 = r3.a()
            com.google.android.gms.measurement.internal.p2 r3 = r3.L()
            com.google.android.gms.measurement.internal.h6 r4 = r14.f3111h
            com.google.android.gms.measurement.internal.h2 r4 = r4.d()
            java.lang.String r4 = r4.c(r8)
            java.lang.String r7 = "Event has empty param name. event"
            r3.b(r7, r4)
            goto L_0x03a1
        L_0x0232:
            java.lang.Object r11 = r4.get(r10)
            boolean r12 = r11 instanceof java.lang.Long
            if (r12 == 0) goto L_0x0281
            boolean r12 = r7.O()
            if (r12 != 0) goto L_0x0265
            com.google.android.gms.measurement.internal.h6 r3 = r14.f3111h
            com.google.android.gms.measurement.internal.n2 r3 = r3.a()
            com.google.android.gms.measurement.internal.p2 r3 = r3.L()
            com.google.android.gms.measurement.internal.h6 r4 = r14.f3111h
            com.google.android.gms.measurement.internal.h2 r4 = r4.d()
            java.lang.String r4 = r4.c(r8)
            com.google.android.gms.measurement.internal.h6 r7 = r14.f3111h
            com.google.android.gms.measurement.internal.h2 r7 = r7.d()
            java.lang.String r7 = r7.f(r10)
            java.lang.String r8 = "No number filter for long param. event, param"
            r3.c(r8, r4, r7)
            goto L_0x03a1
        L_0x0265:
            java.lang.Long r11 = (java.lang.Long) r11
            long r10 = r11.longValue()
            com.google.android.gms.internal.measurement.L1 r7 = r7.J()
            java.lang.Boolean r7 = com.google.android.gms.measurement.internal.C0734b.c(r10, r7)
            if (r7 != 0) goto L_0x0277
            goto L_0x03a1
        L_0x0277:
            boolean r7 = r7.booleanValue()
            if (r7 != r9) goto L_0x01f2
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            goto L_0x03a1
        L_0x0281:
            boolean r12 = r11 instanceof java.lang.Double
            if (r12 == 0) goto L_0x02cc
            boolean r12 = r7.O()
            if (r12 != 0) goto L_0x02b0
            com.google.android.gms.measurement.internal.h6 r3 = r14.f3111h
            com.google.android.gms.measurement.internal.n2 r3 = r3.a()
            com.google.android.gms.measurement.internal.p2 r3 = r3.L()
            com.google.android.gms.measurement.internal.h6 r4 = r14.f3111h
            com.google.android.gms.measurement.internal.h2 r4 = r4.d()
            java.lang.String r4 = r4.c(r8)
            com.google.android.gms.measurement.internal.h6 r7 = r14.f3111h
            com.google.android.gms.measurement.internal.h2 r7 = r7.d()
            java.lang.String r7 = r7.f(r10)
            java.lang.String r8 = "No number filter for double param. event, param"
            r3.c(r8, r4, r7)
            goto L_0x03a1
        L_0x02b0:
            java.lang.Double r11 = (java.lang.Double) r11
            double r10 = r11.doubleValue()
            com.google.android.gms.internal.measurement.L1 r7 = r7.J()
            java.lang.Boolean r7 = com.google.android.gms.measurement.internal.C0734b.b(r10, r7)
            if (r7 != 0) goto L_0x02c2
            goto L_0x03a1
        L_0x02c2:
            boolean r7 = r7.booleanValue()
            if (r7 != r9) goto L_0x01f2
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            goto L_0x03a1
        L_0x02cc:
            boolean r12 = r11 instanceof java.lang.String
            if (r12 == 0) goto L_0x0353
            boolean r12 = r7.Q()
            if (r12 == 0) goto L_0x02e7
            java.lang.String r11 = (java.lang.String) r11
            com.google.android.gms.internal.measurement.N1 r7 = r7.K()
            com.google.android.gms.measurement.internal.h6 r10 = r14.f3111h
            com.google.android.gms.measurement.internal.n2 r10 = r10.a()
            java.lang.Boolean r7 = com.google.android.gms.measurement.internal.C0734b.g(r11, r7, r10)
            goto L_0x02fd
        L_0x02e7:
            boolean r12 = r7.O()
            if (r12 == 0) goto L_0x032f
            java.lang.String r11 = (java.lang.String) r11
            boolean r12 = com.google.android.gms.measurement.internal.Z5.g0(r11)
            if (r12 == 0) goto L_0x030b
            com.google.android.gms.internal.measurement.L1 r7 = r7.J()
            java.lang.Boolean r7 = com.google.android.gms.measurement.internal.C0734b.e(r11, r7)
        L_0x02fd:
            if (r7 != 0) goto L_0x0301
            goto L_0x03a1
        L_0x0301:
            boolean r7 = r7.booleanValue()
            if (r7 != r9) goto L_0x01f2
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            goto L_0x03a1
        L_0x030b:
            com.google.android.gms.measurement.internal.h6 r3 = r14.f3111h
            com.google.android.gms.measurement.internal.n2 r3 = r3.a()
            com.google.android.gms.measurement.internal.p2 r3 = r3.L()
            com.google.android.gms.measurement.internal.h6 r4 = r14.f3111h
            com.google.android.gms.measurement.internal.h2 r4 = r4.d()
            java.lang.String r4 = r4.c(r8)
            com.google.android.gms.measurement.internal.h6 r7 = r14.f3111h
            com.google.android.gms.measurement.internal.h2 r7 = r7.d()
            java.lang.String r7 = r7.f(r10)
            java.lang.String r8 = "Invalid param value for number filter. event, param"
            r3.c(r8, r4, r7)
            goto L_0x03a1
        L_0x032f:
            com.google.android.gms.measurement.internal.h6 r3 = r14.f3111h
            com.google.android.gms.measurement.internal.n2 r3 = r3.a()
            com.google.android.gms.measurement.internal.p2 r3 = r3.L()
            com.google.android.gms.measurement.internal.h6 r4 = r14.f3111h
            com.google.android.gms.measurement.internal.h2 r4 = r4.d()
            java.lang.String r4 = r4.c(r8)
            com.google.android.gms.measurement.internal.h6 r7 = r14.f3111h
            com.google.android.gms.measurement.internal.h2 r7 = r7.d()
            java.lang.String r7 = r7.f(r10)
            java.lang.String r8 = "No filter for String param. event, param"
            r3.c(r8, r4, r7)
            goto L_0x03a1
        L_0x0353:
            if (r11 != 0) goto L_0x037b
            com.google.android.gms.measurement.internal.h6 r3 = r14.f3111h
            com.google.android.gms.measurement.internal.n2 r3 = r3.a()
            com.google.android.gms.measurement.internal.p2 r3 = r3.K()
            com.google.android.gms.measurement.internal.h6 r4 = r14.f3111h
            com.google.android.gms.measurement.internal.h2 r4 = r4.d()
            java.lang.String r4 = r4.c(r8)
            com.google.android.gms.measurement.internal.h6 r6 = r14.f3111h
            com.google.android.gms.measurement.internal.h2 r6 = r6.d()
            java.lang.String r6 = r6.f(r10)
            java.lang.String r7 = "Missing param for filter. event, param"
            r3.c(r7, r4, r6)
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            goto L_0x03a1
        L_0x037b:
            com.google.android.gms.measurement.internal.h6 r3 = r14.f3111h
            com.google.android.gms.measurement.internal.n2 r3 = r3.a()
            com.google.android.gms.measurement.internal.p2 r3 = r3.L()
            com.google.android.gms.measurement.internal.h6 r4 = r14.f3111h
            com.google.android.gms.measurement.internal.h2 r4 = r4.d()
            java.lang.String r4 = r4.c(r8)
            com.google.android.gms.measurement.internal.h6 r7 = r14.f3111h
            com.google.android.gms.measurement.internal.h2 r7 = r7.d()
            java.lang.String r7 = r7.f(r10)
            java.lang.String r8 = "Unknown param type. event, param"
            r3.c(r8, r4, r7)
            goto L_0x03a1
        L_0x039f:
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
        L_0x03a1:
            com.google.android.gms.measurement.internal.h6 r3 = r14.f3111h
            com.google.android.gms.measurement.internal.n2 r3 = r3.a()
            com.google.android.gms.measurement.internal.p2 r3 = r3.K()
            if (r6 != 0) goto L_0x03b0
            java.lang.String r4 = "null"
            goto L_0x03b1
        L_0x03b0:
            r4 = r6
        L_0x03b1:
            java.lang.String r7 = "Event filter result"
            r3.b(r7, r4)
            if (r6 != 0) goto L_0x03b9
            return r1
        L_0x03b9:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            r14.f2861c = r1
            boolean r3 = r6.booleanValue()
            if (r3 != 0) goto L_0x03c4
            return r2
        L_0x03c4:
            r14.f2862d = r1
            if (r5 == 0) goto L_0x03fb
            boolean r1 = r17.Y()
            if (r1 == 0) goto L_0x03fb
            long r3 = r17.R()
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            com.google.android.gms.internal.measurement.J1 r3 = r14.f3110g
            boolean r3 = r3.Q()
            if (r3 == 0) goto L_0x03ed
            if (r0 == 0) goto L_0x03e9
            com.google.android.gms.internal.measurement.J1 r0 = r14.f3110g
            boolean r0 = r0.S()
            if (r0 == 0) goto L_0x03e9
            goto L_0x03ea
        L_0x03e9:
            r15 = r1
        L_0x03ea:
            r14.f2864f = r15
            goto L_0x03fb
        L_0x03ed:
            if (r0 == 0) goto L_0x03f9
            com.google.android.gms.internal.measurement.J1 r15 = r14.f3110g
            boolean r15 = r15.S()
            if (r15 == 0) goto L_0x03f9
            r1 = r16
        L_0x03f9:
            r14.f2863e = r1
        L_0x03fb:
            return r2
        L_0x03fc:
            com.google.android.gms.measurement.internal.h6 r15 = r14.f3111h
            com.google.android.gms.measurement.internal.n2 r15 = r15.a()
            com.google.android.gms.measurement.internal.p2 r15 = r15.L()
            java.lang.String r0 = r14.f2859a
            java.lang.Object r0 = com.google.android.gms.measurement.internal.C0821n2.s(r0)
            com.google.android.gms.internal.measurement.J1 r2 = r14.f3110g
            boolean r2 = r2.T()
            if (r2 == 0) goto L_0x041e
            com.google.android.gms.internal.measurement.J1 r2 = r14.f3110g
            int r2 = r2.J()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r2)
        L_0x041e:
            java.lang.String r2 = java.lang.String.valueOf(r6)
            java.lang.String r3 = "Invalid event filter ID. appId, id"
            r15.c(r3, r0, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.l6.k(java.lang.Long, java.lang.Long, com.google.android.gms.internal.measurement.k2, long, com.google.android.gms.measurement.internal.A, boolean):boolean");
    }
}
