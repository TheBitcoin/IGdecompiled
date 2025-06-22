package com.google.android.gms.measurement.internal;

import M.C0335p;
import R.d;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.internal.measurement.G6;

/* renamed from: com.google.android.gms.measurement.internal.n2  reason: case insensitive filesystem */
public final class C0821n2 extends C0905z3 {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public char f3134c = 0;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public long f3135d = -1;

    /* renamed from: e  reason: collision with root package name */
    private String f3136e;

    /* renamed from: f  reason: collision with root package name */
    private final C0835p2 f3137f = new C0835p2(this, 6, false, false);

    /* renamed from: g  reason: collision with root package name */
    private final C0835p2 f3138g = new C0835p2(this, 6, true, false);

    /* renamed from: h  reason: collision with root package name */
    private final C0835p2 f3139h = new C0835p2(this, 6, false, true);

    /* renamed from: i  reason: collision with root package name */
    private final C0835p2 f3140i = new C0835p2(this, 5, false, false);

    /* renamed from: j  reason: collision with root package name */
    private final C0835p2 f3141j = new C0835p2(this, 5, true, false);

    /* renamed from: k  reason: collision with root package name */
    private final C0835p2 f3142k = new C0835p2(this, 5, false, true);

    /* renamed from: l  reason: collision with root package name */
    private final C0835p2 f3143l = new C0835p2(this, 4, false, false);

    /* renamed from: m  reason: collision with root package name */
    private final C0835p2 f3144m = new C0835p2(this, 3, false, false);

    /* renamed from: n  reason: collision with root package name */
    private final C0835p2 f3145n = new C0835p2(this, 2, false, false);

    C0821n2(S2 s22) {
        super(s22);
    }

    private static String E(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf != -1) {
            return str.substring(0, lastIndexOf);
        }
        if (!G6.a() || !((Boolean) G.f2419H0.a((Object) null)).booleanValue()) {
            return str;
        }
        return "";
    }

    private final String P() {
        String str;
        String str2;
        synchronized (this) {
            try {
                if (this.f3136e == null) {
                    if (this.f3273a.O() != null) {
                        str2 = this.f3273a.O();
                    } else {
                        str2 = "FA";
                    }
                    this.f3136e = str2;
                }
                C0335p.l(this.f3136e);
                str = this.f3136e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    protected static Object s(String str) {
        if (str == null) {
            return null;
        }
        return new C0828o2(str);
    }

    private static String t(boolean z4, Object obj) {
        String str;
        String className;
        String str2 = "";
        if (obj == null) {
            return str2;
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf((long) ((Integer) obj).intValue());
        }
        int i4 = 0;
        if (obj instanceof Long) {
            if (!z4) {
                return String.valueOf(obj);
            }
            Long l4 = (Long) obj;
            if (Math.abs(l4.longValue()) < 100) {
                return String.valueOf(obj);
            }
            if (String.valueOf(obj).charAt(0) == '-') {
                str2 = "-";
            }
            String valueOf = String.valueOf(Math.abs(l4.longValue()));
            long round = Math.round(Math.pow(10.0d, (double) (valueOf.length() - 1)));
            long round2 = Math.round(Math.pow(10.0d, (double) valueOf.length()) - 1.0d);
            return str2 + round + "..." + str2 + round2;
        } else if (obj instanceof Boolean) {
            return String.valueOf(obj);
        } else {
            if (obj instanceof Throwable) {
                Throwable th = (Throwable) obj;
                if (z4) {
                    str = th.getClass().getName();
                } else {
                    str = th.toString();
                }
                StringBuilder sb = new StringBuilder(str);
                String E4 = E(S2.class.getCanonicalName());
                StackTraceElement[] stackTrace = th.getStackTrace();
                int length = stackTrace.length;
                while (true) {
                    if (i4 >= length) {
                        break;
                    }
                    StackTraceElement stackTraceElement = stackTrace[i4];
                    if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null && E(className).equals(E4)) {
                        sb.append(": ");
                        sb.append(stackTraceElement);
                        break;
                    }
                    i4++;
                }
                return sb.toString();
            } else if (obj instanceof C0828o2) {
                return ((C0828o2) obj).f3160a;
            } else {
                if (z4) {
                    return "-";
                }
                return String.valueOf(obj);
            }
        }
    }

    static String u(boolean z4, String str, Object obj, Object obj2, Object obj3) {
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        String t4 = t(z4, obj);
        String t5 = t(z4, obj2);
        String t6 = t(z4, obj3);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(t4)) {
            sb.append(str2);
            sb.append(t4);
            str2 = str3;
        }
        if (!TextUtils.isEmpty(t5)) {
            sb.append(str2);
            sb.append(t5);
        } else {
            str3 = str2;
        }
        if (!TextUtils.isEmpty(t6)) {
            sb.append(str3);
            sb.append(t6);
        }
        return sb.toString();
    }

    public final /* bridge */ /* synthetic */ Context A() {
        return super.A();
    }

    public final /* bridge */ /* synthetic */ d B() {
        return super.B();
    }

    public final /* bridge */ /* synthetic */ C0741c C() {
        return super.C();
    }

    public final C0835p2 F() {
        return this.f3144m;
    }

    public final C0835p2 G() {
        return this.f3137f;
    }

    public final C0835p2 H() {
        return this.f3139h;
    }

    public final C0835p2 I() {
        return this.f3138g;
    }

    public final C0835p2 J() {
        return this.f3143l;
    }

    public final C0835p2 K() {
        return this.f3145n;
    }

    public final C0835p2 L() {
        return this.f3140i;
    }

    public final C0835p2 M() {
        return this.f3142k;
    }

    public final C0835p2 N() {
        return this.f3141j;
    }

    public final String O() {
        Pair a5;
        if (e().f3321f == null || (a5 = e().f3321f.a()) == null || a5 == C0904z2.f3316B) {
            return null;
        }
        String valueOf = String.valueOf(a5.second);
        return valueOf + ":" + ((String) a5.first);
    }

    public final /* bridge */ /* synthetic */ C0821n2 a() {
        return super.a();
    }

    public final /* bridge */ /* synthetic */ C0769g b() {
        return super.b();
    }

    public final /* bridge */ /* synthetic */ C0887x c() {
        return super.c();
    }

    public final /* bridge */ /* synthetic */ C0779h2 d() {
        return super.d();
    }

    public final /* bridge */ /* synthetic */ C0904z2 e() {
        return super.e();
    }

    public final /* bridge */ /* synthetic */ P2 f() {
        return super.f();
    }

    public final /* bridge */ /* synthetic */ d6 g() {
        return super.g();
    }

    public final /* bridge */ /* synthetic */ void i() {
        super.i();
    }

    public final /* bridge */ /* synthetic */ void j() {
        super.j();
    }

    public final /* bridge */ /* synthetic */ void k() {
        super.k();
    }

    /* access modifiers changed from: protected */
    public final boolean q() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final void v(int i4, String str) {
        Log.println(i4, P(), str);
    }

    /* access modifiers changed from: protected */
    public final void w(int i4, boolean z4, boolean z5, String str, Object obj, Object obj2, Object obj3) {
        int i5;
        if (!z4 && z(i4)) {
            v(i4, u(false, str, obj, obj2, obj3));
        }
        if (!z5 && i4 >= 5) {
            C0335p.l(str);
            P2 G4 = this.f3273a.G();
            if (G4 == null) {
                v(6, "Scheduler not set. Not logging error/warn");
            } else if (!G4.p()) {
                v(6, "Scheduler not initialized. Not logging error/warn");
            } else {
                if (i4 < 0) {
                    i4 = 0;
                }
                if (i4 >= 9) {
                    i5 = 8;
                } else {
                    i5 = i4;
                }
                G4.D(new C0814m2(this, i5, str, obj, obj2, obj3));
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean z(int i4) {
        return Log.isLoggable(P(), i4);
    }
}
