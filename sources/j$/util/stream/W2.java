package j$.util.stream;

import j$.time.format.r;
import j$.util.C1127b;
import j$.util.i0;
import java.util.EnumMap;

public enum W2 {
    DISTINCT(0, r7),
    SORTED(1, r10),
    ORDERED(2, r11),
    SIZED(3, r13),
    SHORT_CIRCUIT(12, r13);
    

    /* renamed from: f  reason: collision with root package name */
    public static final int f5421f = 0;

    /* renamed from: g  reason: collision with root package name */
    public static final int f5422g = 0;

    /* renamed from: h  reason: collision with root package name */
    public static final int f5423h = 0;

    /* renamed from: i  reason: collision with root package name */
    public static final int f5424i = 0;

    /* renamed from: j  reason: collision with root package name */
    public static final int f5425j = 0;

    /* renamed from: k  reason: collision with root package name */
    public static final int f5426k = 0;

    /* renamed from: l  reason: collision with root package name */
    public static final int f5427l = 0;

    /* renamed from: m  reason: collision with root package name */
    public static final int f5428m = 0;

    /* renamed from: n  reason: collision with root package name */
    public static final int f5429n = 0;

    /* renamed from: o  reason: collision with root package name */
    public static final int f5430o = 0;

    /* renamed from: p  reason: collision with root package name */
    public static final int f5431p = 0;

    /* renamed from: q  reason: collision with root package name */
    public static final int f5432q = 0;

    /* renamed from: r  reason: collision with root package name */
    public static final int f5433r = 0;

    /* renamed from: s  reason: collision with root package name */
    public static final int f5434s = 0;

    /* renamed from: t  reason: collision with root package name */
    public static final int f5435t = 0;

    /* renamed from: u  reason: collision with root package name */
    public static final int f5436u = 0;

    /* renamed from: a  reason: collision with root package name */
    public final EnumMap f5438a;

    /* renamed from: b  reason: collision with root package name */
    public final int f5439b;

    /* renamed from: c  reason: collision with root package name */
    public final int f5440c;

    /* renamed from: d  reason: collision with root package name */
    public final int f5441d;

    /* renamed from: e  reason: collision with root package name */
    public final int f5442e;

    static {
        V2 v22;
        V2 v23;
        V2 v24;
        V2 v25;
        V2 v26;
        int i4;
        f5421f = k(v22);
        f5422g = k(v23);
        f5423h = k(v24);
        k(v25);
        k(v26);
        for (W2 w22 : values()) {
            i4 |= w22.f5442e;
        }
        f5424i = i4;
        int i5 = f5422g;
        f5425j = i5;
        int i6 = i5 << 1;
        f5426k = i6;
        f5427l = i5 | i6;
        W2 w23 = DISTINCT;
        f5428m = w23.f5440c;
        f5429n = w23.f5441d;
        W2 w24 = SORTED;
        f5430o = w24.f5440c;
        f5431p = w24.f5441d;
        W2 w25 = ORDERED;
        f5432q = w25.f5440c;
        f5433r = w25.f5441d;
        W2 w26 = SIZED;
        f5434s = w26.f5440c;
        f5435t = w26.f5441d;
        f5436u = SHORT_CIRCUIT.f5440c;
    }

    public static r p(V2 v22) {
        r rVar = new r(11, new EnumMap(V2.class));
        rVar.c(v22);
        return rVar;
    }

    /* access modifiers changed from: public */
    W2(int i4, r rVar) {
        V2[] values = V2.values();
        int length = values.length;
        int i5 = 0;
        while (true) {
            EnumMap enumMap = (EnumMap) rVar.f4970b;
            if (i5 < length) {
                C1127b.v(enumMap, values[i5], 0);
                i5++;
            } else {
                this.f5438a = enumMap;
                int i6 = i4 * 2;
                this.f5439b = i6;
                this.f5440c = 1 << i6;
                this.f5441d = 2 << i6;
                this.f5442e = 3 << i6;
                return;
            }
        }
    }

    public final boolean n(int i4) {
        return (i4 & this.f5442e) == this.f5440c;
    }

    public static int k(V2 v22) {
        int i4 = 0;
        for (W2 w22 : values()) {
            i4 |= ((Integer) w22.f5438a.get(v22)).intValue() << w22.f5439b;
        }
        return i4;
    }

    public static int j(int i4, int i5) {
        int i6;
        if (i4 == 0) {
            i6 = f5424i;
        } else {
            i6 = ~(((f5425j & i4) << 1) | i4 | ((f5426k & i4) >> 1));
        }
        return i4 | (i5 & i6);
    }

    public static int m(i0 i0Var) {
        int characteristics = i0Var.characteristics();
        int i4 = characteristics & 4;
        int i5 = f5421f;
        return (i4 == 0 || i0Var.getComparator() == null) ? characteristics & i5 : characteristics & i5 & -5;
    }
}
