package com.google.android.gms.measurement.internal;

import M.C0335p;
import android.text.TextUtils;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.measurement.internal.c2  reason: case insensitive filesystem */
final class C0744c2 {

    /* renamed from: A  reason: collision with root package name */
    private Long f2882A;

    /* renamed from: B  reason: collision with root package name */
    private Long f2883B;

    /* renamed from: C  reason: collision with root package name */
    private long f2884C;

    /* renamed from: D  reason: collision with root package name */
    private String f2885D;

    /* renamed from: E  reason: collision with root package name */
    private int f2886E;

    /* renamed from: F  reason: collision with root package name */
    private int f2887F;

    /* renamed from: G  reason: collision with root package name */
    private long f2888G;

    /* renamed from: H  reason: collision with root package name */
    private String f2889H;

    /* renamed from: I  reason: collision with root package name */
    private byte[] f2890I;

    /* renamed from: J  reason: collision with root package name */
    private long f2891J;

    /* renamed from: K  reason: collision with root package name */
    private long f2892K;

    /* renamed from: L  reason: collision with root package name */
    private long f2893L;

    /* renamed from: M  reason: collision with root package name */
    private long f2894M;

    /* renamed from: N  reason: collision with root package name */
    private long f2895N;

    /* renamed from: O  reason: collision with root package name */
    private long f2896O;

    /* renamed from: P  reason: collision with root package name */
    private String f2897P;

    /* renamed from: Q  reason: collision with root package name */
    private boolean f2898Q;

    /* renamed from: R  reason: collision with root package name */
    private long f2899R;

    /* renamed from: S  reason: collision with root package name */
    private long f2900S;

    /* renamed from: a  reason: collision with root package name */
    private final S2 f2901a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2902b;

    /* renamed from: c  reason: collision with root package name */
    private String f2903c;

    /* renamed from: d  reason: collision with root package name */
    private String f2904d;

    /* renamed from: e  reason: collision with root package name */
    private String f2905e;

    /* renamed from: f  reason: collision with root package name */
    private String f2906f;

    /* renamed from: g  reason: collision with root package name */
    private long f2907g;

    /* renamed from: h  reason: collision with root package name */
    private long f2908h;

    /* renamed from: i  reason: collision with root package name */
    private long f2909i;

    /* renamed from: j  reason: collision with root package name */
    private String f2910j;

    /* renamed from: k  reason: collision with root package name */
    private long f2911k;

    /* renamed from: l  reason: collision with root package name */
    private String f2912l;

    /* renamed from: m  reason: collision with root package name */
    private long f2913m;

    /* renamed from: n  reason: collision with root package name */
    private long f2914n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f2915o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f2916p;

    /* renamed from: q  reason: collision with root package name */
    private String f2917q;

    /* renamed from: r  reason: collision with root package name */
    private Boolean f2918r;

    /* renamed from: s  reason: collision with root package name */
    private long f2919s;

    /* renamed from: t  reason: collision with root package name */
    private List f2920t;

    /* renamed from: u  reason: collision with root package name */
    private String f2921u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f2922v;

    /* renamed from: w  reason: collision with root package name */
    private long f2923w;

    /* renamed from: x  reason: collision with root package name */
    private long f2924x;

    /* renamed from: y  reason: collision with root package name */
    private int f2925y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f2926z;

    C0744c2(S2 s22, String str) {
        C0335p.l(s22);
        C0335p.f(str);
        this.f2901a = s22;
        this.f2902b = str;
        s22.f().k();
    }

    public final boolean A() {
        this.f2901a.f().k();
        return this.f2915o;
    }

    public final void A0(long j4) {
        boolean z4;
        boolean z5 = false;
        if (j4 >= 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        C0335p.a(z4);
        this.f2901a.f().k();
        boolean z6 = this.f2898Q;
        if (this.f2907g != j4) {
            z5 = true;
        }
        this.f2898Q = z6 | z5;
        this.f2907g = j4;
    }

    public final boolean B() {
        this.f2901a.f().k();
        return this.f2898Q;
    }

    public final long B0() {
        this.f2901a.f().k();
        return this.f2888G;
    }

    public final boolean C() {
        this.f2901a.f().k();
        return this.f2922v;
    }

    public final void C0(long j4) {
        boolean z4;
        this.f2901a.f().k();
        boolean z5 = this.f2898Q;
        if (this.f2908h != j4) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f2898Q = z5 | z4;
        this.f2908h = j4;
    }

    public final boolean D() {
        this.f2901a.f().k();
        return this.f2926z;
    }

    public final long D0() {
        this.f2901a.f().k();
        return this.f2909i;
    }

    public final byte[] E() {
        this.f2901a.f().k();
        return this.f2890I;
    }

    public final void E0(long j4) {
        boolean z4;
        this.f2901a.f().k();
        boolean z5 = this.f2898Q;
        if (this.f2924x != j4) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f2898Q = z5 | z4;
        this.f2924x = j4;
    }

    public final int F() {
        this.f2901a.f().k();
        return this.f2887F;
    }

    public final long F0() {
        this.f2901a.f().k();
        return this.f2907g;
    }

    public final void G(int i4) {
        boolean z4;
        this.f2901a.f().k();
        boolean z5 = this.f2898Q;
        if (this.f2887F != i4) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f2898Q = z5 | z4;
        this.f2887F = i4;
    }

    public final void G0(long j4) {
        boolean z4;
        this.f2901a.f().k();
        boolean z5 = this.f2898Q;
        if (this.f2923w != j4) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f2898Q = z5 | z4;
        this.f2923w = j4;
    }

    public final void H(long j4) {
        boolean z4;
        this.f2901a.f().k();
        boolean z5 = this.f2898Q;
        if (this.f2911k != j4) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f2898Q = z5 | z4;
        this.f2911k = j4;
    }

    public final long H0() {
        this.f2901a.f().k();
        return this.f2908h;
    }

    public final void I(Long l4) {
        this.f2901a.f().k();
        this.f2898Q |= !Objects.equals(this.f2883B, l4);
        this.f2883B = l4;
    }

    public final long I0() {
        this.f2901a.f().k();
        return this.f2924x;
    }

    public final void J(String str) {
        this.f2901a.f().k();
        this.f2898Q |= !Objects.equals(this.f2903c, str);
        this.f2903c = str;
    }

    public final long J0() {
        this.f2901a.f().k();
        return this.f2923w;
    }

    public final void K(boolean z4) {
        boolean z5;
        this.f2901a.f().k();
        boolean z6 = this.f2898Q;
        if (this.f2915o != z4) {
            z5 = true;
        } else {
            z5 = false;
        }
        this.f2898Q = z6 | z5;
        this.f2915o = z4;
    }

    public final Boolean K0() {
        this.f2901a.f().k();
        return this.f2918r;
    }

    public final int L() {
        this.f2901a.f().k();
        return this.f2886E;
    }

    public final Long L0() {
        this.f2901a.f().k();
        return this.f2882A;
    }

    public final void M(int i4) {
        boolean z4;
        this.f2901a.f().k();
        boolean z5 = this.f2898Q;
        if (this.f2886E != i4) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f2898Q = z5 | z4;
        this.f2886E = i4;
    }

    public final Long M0() {
        this.f2901a.f().k();
        return this.f2883B;
    }

    public final void N(long j4) {
        boolean z4;
        this.f2901a.f().k();
        boolean z5 = this.f2898Q;
        if (this.f2884C != j4) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f2898Q = z5 | z4;
        this.f2884C = j4;
    }

    public final void O(String str) {
        this.f2901a.f().k();
        this.f2898Q |= !Objects.equals(this.f2912l, str);
        this.f2912l = str;
    }

    public final void P(boolean z4) {
        boolean z5;
        this.f2901a.f().k();
        boolean z6 = this.f2898Q;
        if (this.f2922v != z4) {
            z5 = true;
        } else {
            z5 = false;
        }
        this.f2898Q = z6 | z5;
        this.f2922v = z4;
    }

    public final long Q() {
        this.f2901a.f().k();
        return 0;
    }

    public final void R(long j4) {
        boolean z4;
        this.f2901a.f().k();
        boolean z5 = this.f2898Q;
        if (this.f2899R != j4) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f2898Q = z5 | z4;
        this.f2899R = j4;
    }

    public final void S(String str) {
        this.f2901a.f().k();
        this.f2898Q |= !Objects.equals(this.f2910j, str);
        this.f2910j = str;
    }

    public final void T(boolean z4) {
        boolean z5;
        this.f2901a.f().k();
        boolean z6 = this.f2898Q;
        if (this.f2926z != z4) {
            z5 = true;
        } else {
            z5 = false;
        }
        this.f2898Q = z6 | z5;
        this.f2926z = z4;
    }

    public final long U() {
        this.f2901a.f().k();
        return this.f2911k;
    }

    public final void V(long j4) {
        boolean z4;
        this.f2901a.f().k();
        boolean z5 = this.f2898Q;
        if (this.f2894M != j4) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f2898Q = z5 | z4;
        this.f2894M = j4;
    }

    public final void W(String str) {
        this.f2901a.f().k();
        this.f2898Q |= !Objects.equals(this.f2906f, str);
        this.f2906f = str;
    }

    public final long X() {
        this.f2901a.f().k();
        return this.f2884C;
    }

    public final void Y(long j4) {
        boolean z4;
        this.f2901a.f().k();
        boolean z5 = this.f2898Q;
        if (this.f2895N != j4) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f2898Q = z5 | z4;
        this.f2895N = j4;
    }

    public final void Z(String str) {
        this.f2901a.f().k();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.f2898Q |= !Objects.equals(this.f2904d, str);
        this.f2904d = str;
    }

    public final int a() {
        this.f2901a.f().k();
        return this.f2925y;
    }

    public final long a0() {
        this.f2901a.f().k();
        return this.f2899R;
    }

    public final void b(int i4) {
        boolean z4;
        this.f2901a.f().k();
        boolean z5 = this.f2898Q;
        if (this.f2925y != i4) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f2898Q = z5 | z4;
        this.f2925y = i4;
    }

    public final void b0(long j4) {
        boolean z4;
        this.f2901a.f().k();
        boolean z5 = this.f2898Q;
        if (this.f2893L != j4) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f2898Q = z5 | z4;
        this.f2893L = j4;
    }

    public final void c(long j4) {
        this.f2901a.f().k();
        long j5 = this.f2907g + j4;
        if (j5 > 2147483647L) {
            this.f2901a.a().L().b("Bundle index overflow. appId", C0821n2.s(this.f2902b));
            j5 = j4 - 1;
        }
        long j6 = this.f2888G + 1;
        if (j6 > 2147483647L) {
            this.f2901a.a().L().b("Delivery index overflow. appId", C0821n2.s(this.f2902b));
            j6 = 0;
        }
        this.f2898Q = true;
        this.f2907g = j5;
        this.f2888G = j6;
    }

    public final void c0(String str) {
        this.f2901a.f().k();
        this.f2898Q |= !Objects.equals(this.f2897P, str);
        this.f2897P = str;
    }

    public final void d(Boolean bool) {
        this.f2901a.f().k();
        this.f2898Q |= !Objects.equals(this.f2918r, bool);
        this.f2918r = bool;
    }

    public final long d0() {
        this.f2901a.f().k();
        return this.f2894M;
    }

    public final void e(Long l4) {
        this.f2901a.f().k();
        this.f2898Q |= !Objects.equals(this.f2882A, l4);
        this.f2882A = l4;
    }

    public final void e0(long j4) {
        boolean z4;
        this.f2901a.f().k();
        boolean z5 = this.f2898Q;
        if (this.f2892K != j4) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f2898Q = z5 | z4;
        this.f2892K = j4;
    }

    public final void f(String str) {
        this.f2901a.f().k();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.f2898Q |= !Objects.equals(this.f2917q, str);
        this.f2917q = str;
    }

    public final void f0(String str) {
        this.f2901a.f().k();
        this.f2898Q |= !Objects.equals(this.f2905e, str);
        this.f2905e = str;
    }

    public final void g(List list) {
        ArrayList arrayList;
        this.f2901a.f().k();
        if (!Objects.equals(this.f2920t, list)) {
            this.f2898Q = true;
            if (list != null) {
                arrayList = new ArrayList(list);
            } else {
                arrayList = null;
            }
            this.f2920t = arrayList;
        }
    }

    public final long g0() {
        this.f2901a.f().k();
        return this.f2895N;
    }

    public final void h(boolean z4) {
        boolean z5;
        this.f2901a.f().k();
        boolean z6 = this.f2898Q;
        if (this.f2916p != z4) {
            z5 = true;
        } else {
            z5 = false;
        }
        this.f2898Q = z6 | z5;
        this.f2916p = z4;
    }

    public final void h0(long j4) {
        boolean z4;
        this.f2901a.f().k();
        boolean z5 = this.f2898Q;
        if (this.f2896O != j4) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f2898Q = z5 | z4;
        this.f2896O = j4;
    }

    public final void i(byte[] bArr) {
        boolean z4;
        this.f2901a.f().k();
        boolean z5 = this.f2898Q;
        if (this.f2890I != bArr) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f2898Q = z5 | z4;
        this.f2890I = bArr;
    }

    public final void i0(String str) {
        boolean z4;
        this.f2901a.f().k();
        boolean z5 = this.f2898Q;
        if (this.f2889H != str) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f2898Q = z5 | z4;
        this.f2889H = str;
    }

    public final String j() {
        this.f2901a.f().k();
        return this.f2917q;
    }

    public final long j0() {
        this.f2901a.f().k();
        return this.f2893L;
    }

    public final String k() {
        this.f2901a.f().k();
        String str = this.f2897P;
        c0((String) null);
        return str;
    }

    public final void k0(long j4) {
        boolean z4;
        this.f2901a.f().k();
        boolean z5 = this.f2898Q;
        if (this.f2891J != j4) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f2898Q = z5 | z4;
        this.f2891J = j4;
    }

    public final String l() {
        this.f2901a.f().k();
        return this.f2902b;
    }

    public final void l0(String str) {
        this.f2901a.f().k();
        this.f2898Q |= !Objects.equals(this.f2921u, str);
        this.f2921u = str;
    }

    public final String m() {
        this.f2901a.f().k();
        return this.f2903c;
    }

    public final long m0() {
        this.f2901a.f().k();
        return this.f2892K;
    }

    public final String n() {
        this.f2901a.f().k();
        return this.f2912l;
    }

    public final void n0(long j4) {
        boolean z4;
        this.f2901a.f().k();
        boolean z5 = this.f2898Q;
        if (this.f2914n != j4) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f2898Q = z5 | z4;
        this.f2914n = j4;
    }

    public final String o() {
        this.f2901a.f().k();
        return this.f2910j;
    }

    public final void o0(String str) {
        boolean z4;
        this.f2901a.f().k();
        boolean z5 = this.f2898Q;
        if (this.f2885D != str) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f2898Q = z5 | z4;
        this.f2885D = str;
    }

    public final String p() {
        this.f2901a.f().k();
        return this.f2906f;
    }

    public final long p0() {
        this.f2901a.f().k();
        return this.f2896O;
    }

    public final String q() {
        this.f2901a.f().k();
        return this.f2904d;
    }

    public final void q0(long j4) {
        boolean z4;
        this.f2901a.f().k();
        boolean z5 = this.f2898Q;
        if (this.f2919s != j4) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f2898Q = z5 | z4;
        this.f2919s = j4;
    }

    public final String r() {
        this.f2901a.f().k();
        return this.f2897P;
    }

    public final long r0() {
        this.f2901a.f().k();
        return this.f2891J;
    }

    public final String s() {
        this.f2901a.f().k();
        return this.f2905e;
    }

    public final void s0(long j4) {
        boolean z4;
        this.f2901a.f().k();
        boolean z5 = this.f2898Q;
        if (this.f2900S != j4) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f2898Q = z5 | z4;
        this.f2900S = j4;
    }

    public final String t() {
        this.f2901a.f().k();
        return this.f2889H;
    }

    public final long t0() {
        this.f2901a.f().k();
        return this.f2914n;
    }

    public final String u() {
        this.f2901a.f().k();
        return this.f2921u;
    }

    public final void u0(long j4) {
        boolean z4;
        this.f2901a.f().k();
        boolean z5 = this.f2898Q;
        if (this.f2913m != j4) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f2898Q = z5 | z4;
        this.f2913m = j4;
    }

    public final String v() {
        this.f2901a.f().k();
        return this.f2885D;
    }

    public final long v0() {
        this.f2901a.f().k();
        return this.f2919s;
    }

    public final List w() {
        this.f2901a.f().k();
        return this.f2920t;
    }

    public final void w0(long j4) {
        boolean z4;
        this.f2901a.f().k();
        boolean z5 = this.f2898Q;
        if (this.f2888G != j4) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f2898Q = z5 | z4;
        this.f2888G = j4;
    }

    public final void x() {
        this.f2901a.f().k();
        this.f2898Q = false;
    }

    public final long x0() {
        this.f2901a.f().k();
        return this.f2900S;
    }

    public final void y() {
        this.f2901a.f().k();
        long j4 = this.f2907g + 1;
        if (j4 > 2147483647L) {
            this.f2901a.a().L().b("Bundle index overflow. appId", C0821n2.s(this.f2902b));
            j4 = 0;
        }
        this.f2898Q = true;
        this.f2907g = j4;
    }

    public final void y0(long j4) {
        boolean z4;
        this.f2901a.f().k();
        boolean z5 = this.f2898Q;
        if (this.f2909i != j4) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.f2898Q = z5 | z4;
        this.f2909i = j4;
    }

    public final boolean z() {
        this.f2901a.f().k();
        return this.f2916p;
    }

    public final long z0() {
        this.f2901a.f().k();
        return this.f2913m;
    }
}
