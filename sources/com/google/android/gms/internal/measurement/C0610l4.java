package com.google.android.gms.internal.measurement;

import android.support.v4.media.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.measurement.l4  reason: case insensitive filesystem */
final class C0610l4 {

    /* renamed from: d  reason: collision with root package name */
    private static final C0610l4 f1984d = new C0610l4(true);

    /* renamed from: a  reason: collision with root package name */
    final C0646p5 f1985a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f1986b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f1987c;

    private C0610l4() {
        this.f1985a = new C0669s5();
    }

    public static int b(C0628n4 n4Var, Object obj) {
        M5 B4 = n4Var.B();
        int A4 = n4Var.A();
        if (!n4Var.D()) {
            return c(B4, A4, obj);
        }
        List list = (List) obj;
        int size = list.size();
        int i4 = 0;
        if (!n4Var.C()) {
            int i5 = 0;
            while (i4 < size) {
                i5 += c(B4, A4, list.get(i4));
                i4++;
            }
            return i5;
        } else if (list.isEmpty()) {
            return 0;
        } else {
            int i6 = 0;
            while (i4 < size) {
                i6 += d(B4, list.get(i4));
                i4++;
            }
            return C0520b4.s0(A4) + i6 + C0520b4.v0(i6);
        }
    }

    static int c(M5 m5, int i4, Object obj) {
        int s02 = C0520b4.s0(i4);
        if (m5 == M5.GROUP) {
            C0684u4.g((Z4) obj);
            s02 <<= 1;
        }
        return s02 + d(m5, obj);
    }

    private static int d(M5 m5, Object obj) {
        switch (C0601k4.f1972b[m5.ordinal()]) {
            case 1:
                return C0520b4.c(((Double) obj).doubleValue());
            case 2:
                return C0520b4.d(((Float) obj).floatValue());
            case 3:
                return C0520b4.a0(((Long) obj).longValue());
            case 4:
                return C0520b4.n0(((Long) obj).longValue());
            case 5:
                return C0520b4.g0(((Integer) obj).intValue());
            case 6:
                return C0520b4.S(((Long) obj).longValue());
            case 7:
                return C0520b4.c0(((Integer) obj).intValue());
            case 8:
                return C0520b4.h(((Boolean) obj).booleanValue());
            case 9:
                return C0520b4.B((Z4) obj);
            case 10:
                return C0520b4.T((Z4) obj);
            case 11:
                if (obj instanceof K3) {
                    return C0520b4.A((K3) obj);
                }
                return C0520b4.C((String) obj);
            case 12:
                if (obj instanceof K3) {
                    return C0520b4.A((K3) obj);
                }
                return C0520b4.i((byte[]) obj);
            case 13:
                return C0520b4.v0(((Integer) obj).intValue());
            case 14:
                return C0520b4.k0(((Integer) obj).intValue());
            case 15:
                return C0520b4.f0(((Long) obj).longValue());
            case 16:
                return C0520b4.o0(((Integer) obj).intValue());
            case 17:
                return C0520b4.j0(((Long) obj).longValue());
            case 18:
                if (obj instanceof C0708x4) {
                    return C0520b4.X(((C0708x4) obj).A());
                }
                return C0520b4.X(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    private static int e(Map.Entry entry) {
        a.a(entry.getKey());
        entry.getValue();
        throw null;
    }

    private final void g(C0628n4 n4Var, Object obj) {
        if (!n4Var.D()) {
            j(n4Var, obj);
        } else if (obj instanceof List) {
            List list = (List) obj;
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i4 = 0; i4 < size; i4++) {
                Object obj2 = list.get(i4);
                j(n4Var, obj2);
                arrayList.add(obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        this.f1985a.put(n4Var, obj);
    }

    private final void h(Map.Entry entry) {
        a.a(entry.getKey());
        entry.getValue();
        throw null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0030, code lost:
        if ((r6 instanceof byte[]) == false) goto L_0x0018;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0044, code lost:
        if (r0 == false) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0046, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0074, code lost:
        throw new java.lang.IllegalArgumentException(java.lang.String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new java.lang.Object[]{java.lang.Integer.valueOf(r5.A()), r5.B().a(), r6.getClass().getName()}));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0018, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x001c, code lost:
        if ((r6 instanceof com.google.android.gms.internal.measurement.Z4) == false) goto L_0x0018;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001f, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0027, code lost:
        if ((r6 instanceof com.google.android.gms.internal.measurement.C0708x4) == false) goto L_0x0018;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void j(com.google.android.gms.internal.measurement.C0628n4 r5, java.lang.Object r6) {
        /*
            com.google.android.gms.internal.measurement.M5 r0 = r5.B()
            com.google.android.gms.internal.measurement.C0684u4.e(r6)
            int[] r1 = com.google.android.gms.internal.measurement.C0601k4.f1971a
            com.google.android.gms.internal.measurement.T5 r0 = r0.a()
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 1
            r2 = 0
            switch(r0) {
                case 1: goto L_0x0042;
                case 2: goto L_0x003f;
                case 3: goto L_0x003c;
                case 4: goto L_0x0039;
                case 5: goto L_0x0036;
                case 6: goto L_0x0033;
                case 7: goto L_0x002a;
                case 8: goto L_0x0021;
                case 9: goto L_0x001a;
                default: goto L_0x0018;
            }
        L_0x0018:
            r0 = 0
            goto L_0x0044
        L_0x001a:
            boolean r0 = r6 instanceof com.google.android.gms.internal.measurement.Z4
            if (r0 != 0) goto L_0x001f
            goto L_0x0018
        L_0x001f:
            r0 = 1
            goto L_0x0044
        L_0x0021:
            boolean r0 = r6 instanceof java.lang.Integer
            if (r0 != 0) goto L_0x001f
            boolean r0 = r6 instanceof com.google.android.gms.internal.measurement.C0708x4
            if (r0 == 0) goto L_0x0018
            goto L_0x001f
        L_0x002a:
            boolean r0 = r6 instanceof com.google.android.gms.internal.measurement.K3
            if (r0 != 0) goto L_0x001f
            boolean r0 = r6 instanceof byte[]
            if (r0 == 0) goto L_0x0018
            goto L_0x001f
        L_0x0033:
            boolean r0 = r6 instanceof java.lang.String
            goto L_0x0044
        L_0x0036:
            boolean r0 = r6 instanceof java.lang.Boolean
            goto L_0x0044
        L_0x0039:
            boolean r0 = r6 instanceof java.lang.Double
            goto L_0x0044
        L_0x003c:
            boolean r0 = r6 instanceof java.lang.Float
            goto L_0x0044
        L_0x003f:
            boolean r0 = r6 instanceof java.lang.Long
            goto L_0x0044
        L_0x0042:
            boolean r0 = r6 instanceof java.lang.Integer
        L_0x0044:
            if (r0 == 0) goto L_0x0047
            return
        L_0x0047:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            int r3 = r5.A()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            com.google.android.gms.internal.measurement.M5 r5 = r5.B()
            com.google.android.gms.internal.measurement.T5 r5 = r5.a()
            java.lang.Class r6 = r6.getClass()
            java.lang.String r6 = r6.getName()
            r4 = 3
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r4[r2] = r3
            r4[r1] = r5
            r5 = 2
            r4[r5] = r6
            java.lang.String r5 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r5 = java.lang.String.format(r5, r4)
            r0.<init>(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.C0610l4.j(com.google.android.gms.internal.measurement.n4, java.lang.Object):void");
    }

    private static boolean k(Map.Entry entry) {
        a.a(entry.getKey());
        throw null;
    }

    public final int a() {
        int a5 = this.f1985a.a();
        int i4 = 0;
        for (int i5 = 0; i5 < a5; i5++) {
            i4 += e(this.f1985a.f(i5));
        }
        for (Map.Entry e5 : this.f1985a.h()) {
            i4 += e(e5);
        }
        return i4;
    }

    public final /* synthetic */ Object clone() {
        C0610l4 l4Var = new C0610l4();
        int a5 = this.f1985a.a();
        for (int i4 = 0; i4 < a5; i4++) {
            Map.Entry f4 = this.f1985a.f(i4);
            a.a(f4.getKey());
            l4Var.g((C0628n4) null, f4.getValue());
        }
        for (Map.Entry entry : this.f1985a.h()) {
            a.a(entry.getKey());
            l4Var.g((C0628n4) null, entry.getValue());
        }
        l4Var.f1987c = this.f1987c;
        return l4Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0610l4)) {
            return false;
        }
        return this.f1985a.equals(((C0610l4) obj).f1985a);
    }

    public final void f(C0610l4 l4Var) {
        int a5 = l4Var.f1985a.a();
        for (int i4 = 0; i4 < a5; i4++) {
            h(l4Var.f1985a.f(i4));
        }
        for (Map.Entry h4 : l4Var.f1985a.h()) {
            h(h4);
        }
    }

    public final int hashCode() {
        return this.f1985a.hashCode();
    }

    /* access modifiers changed from: package-private */
    public final Iterator i() {
        if (this.f1985a.isEmpty()) {
            return Collections.emptyIterator();
        }
        if (this.f1987c) {
            return new F4(this.f1985a.l().iterator());
        }
        return this.f1985a.l().iterator();
    }

    public final Iterator l() {
        if (this.f1985a.isEmpty()) {
            return Collections.emptyIterator();
        }
        if (this.f1987c) {
            return new F4(this.f1985a.entrySet().iterator());
        }
        return this.f1985a.entrySet().iterator();
    }

    public final void m() {
        if (!this.f1986b) {
            int a5 = this.f1985a.a();
            for (int i4 = 0; i4 < a5; i4++) {
                Object value = this.f1985a.f(i4).getValue();
                if (value instanceof C0668s4) {
                    ((C0668s4) value).D();
                }
            }
            for (Map.Entry value2 : this.f1985a.h()) {
                Object value3 = value2.getValue();
                if (value3 instanceof C0668s4) {
                    ((C0668s4) value3).D();
                }
            }
            this.f1985a.m();
            this.f1986b = true;
        }
    }

    public final boolean n() {
        int a5 = this.f1985a.a();
        for (int i4 = 0; i4 < a5; i4++) {
            if (!k(this.f1985a.f(i4))) {
                return false;
            }
        }
        for (Map.Entry k4 : this.f1985a.h()) {
            if (!k(k4)) {
                return false;
            }
        }
        return true;
    }

    private C0610l4(C0646p5 p5Var) {
        this.f1985a = p5Var;
        m();
    }

    private C0610l4(boolean z4) {
        this((C0646p5) new C0669s5());
        m();
    }
}
