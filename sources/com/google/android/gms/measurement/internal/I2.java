package com.google.android.gms.measurement.internal;

import M.C0335p;
import R.d;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import androidx.collection.LruCache;
import com.google.android.gms.internal.measurement.A2;
import com.google.android.gms.internal.measurement.B2;
import com.google.android.gms.internal.measurement.B4;
import com.google.android.gms.internal.measurement.C;
import com.google.android.gms.internal.measurement.C0543e0;
import com.google.android.gms.internal.measurement.C0668s4;
import com.google.android.gms.internal.measurement.J7;
import com.google.android.gms.internal.measurement.Q1;
import com.google.android.gms.internal.measurement.R1;
import com.google.android.gms.internal.measurement.S1;
import com.google.android.gms.internal.measurement.T1;
import com.google.android.gms.internal.measurement.X1;
import com.google.android.gms.measurement.internal.A3;
import f0.m;
import f0.p;
import f0.q;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public final class I2 extends E5 implements C0783i {
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final Map f2570d = new ArrayMap();

    /* renamed from: e  reason: collision with root package name */
    private final Map f2571e = new ArrayMap();

    /* renamed from: f  reason: collision with root package name */
    private final Map f2572f = new ArrayMap();

    /* renamed from: g  reason: collision with root package name */
    private final Map f2573g = new ArrayMap();

    /* renamed from: h  reason: collision with root package name */
    private final Map f2574h = new ArrayMap();

    /* renamed from: i  reason: collision with root package name */
    private final Map f2575i = new ArrayMap();

    /* renamed from: j  reason: collision with root package name */
    final LruCache f2576j = new K2(this, 20);

    /* renamed from: k  reason: collision with root package name */
    final J7 f2577k = new N2(this);

    /* renamed from: l  reason: collision with root package name */
    private final Map f2578l = new ArrayMap();

    /* renamed from: m  reason: collision with root package name */
    private final Map f2579m = new ArrayMap();

    /* renamed from: n  reason: collision with root package name */
    private final Map f2580n = new ArrayMap();

    I2(H5 h5) {
        super(h5);
    }

    private static Map D(T1 t12) {
        ArrayMap arrayMap = new ArrayMap();
        if (t12 != null) {
            for (X1 x12 : t12.V()) {
                arrayMap.put(x12.H(), x12.I());
            }
        }
        return arrayMap;
    }

    private final void F(String str, T1.a aVar) {
        HashSet hashSet = new HashSet();
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        if (aVar != null) {
            for (R1 H4 : aVar.z()) {
                hashSet.add(H4.H());
            }
            for (int i4 = 0; i4 < aVar.q(); i4++) {
                S1.a aVar2 = (S1.a) aVar.r(i4).y();
                if (aVar2.s().isEmpty()) {
                    a().L().a("EventConfig contained null event name");
                } else {
                    String s4 = aVar2.s();
                    String b5 = q.b(aVar2.s());
                    if (!TextUtils.isEmpty(b5)) {
                        aVar2 = aVar2.r(b5);
                        aVar.s(i4, aVar2);
                    }
                    if (aVar2.y() && aVar2.t()) {
                        arrayMap.put(s4, Boolean.TRUE);
                    }
                    if (aVar2.z() && aVar2.x()) {
                        arrayMap2.put(aVar2.s(), Boolean.TRUE);
                    }
                    if (aVar2.A()) {
                        if (aVar2.q() < 2 || aVar2.q() > 65535) {
                            a().L().c("Invalid sampling rate. Event name, sample rate", aVar2.s(), Integer.valueOf(aVar2.q()));
                        } else {
                            arrayMap3.put(aVar2.s(), Integer.valueOf(aVar2.q()));
                        }
                    }
                }
            }
        }
        this.f2571e.put(str, hashSet);
        this.f2572f.put(str, arrayMap);
        this.f2573g.put(str, arrayMap2);
        this.f2575i.put(str, arrayMap3);
    }

    private final void G(String str, T1 t12) {
        if (t12.j() == 0) {
            this.f2576j.remove(str);
            return;
        }
        a().K().b("EES programs found", Integer.valueOf(t12.j()));
        B2 b22 = (B2) t12.U().get(0);
        try {
            C c5 = new C();
            c5.c("internal.remoteConfig", new J2(this, str));
            c5.c("internal.appMetadata", new m(this, str));
            c5.c("internal.logger", new L2(this));
            c5.b(b22);
            this.f2576j.put(str, c5);
            a().K().c("EES program loaded for appId, activities", str, Integer.valueOf(b22.G().j()));
            for (A2 H4 : b22.G().I()) {
                a().K().b("EES program activity", H4.H());
            }
        } catch (C0543e0 unused) {
            a().G().b("Failed to load EES program. appId", str);
        }
    }

    private final void g0(String str) {
        r();
        k();
        C0335p.f(str);
        if (this.f2574h.get(str) == null) {
            C0804l O02 = n().O0(str);
            if (O02 == null) {
                this.f2570d.put(str, (Object) null);
                this.f2572f.put(str, (Object) null);
                this.f2571e.put(str, (Object) null);
                this.f2573g.put(str, (Object) null);
                this.f2574h.put(str, (Object) null);
                this.f2578l.put(str, (Object) null);
                this.f2579m.put(str, (Object) null);
                this.f2580n.put(str, (Object) null);
                this.f2575i.put(str, (Object) null);
                return;
            }
            T1.a aVar = (T1.a) x(str, O02.f3091a).y();
            F(str, aVar);
            this.f2570d.put(str, D((T1) ((C0668s4) aVar.m())));
            this.f2574h.put(str, (T1) ((C0668s4) aVar.m()));
            G(str, (T1) ((C0668s4) aVar.m()));
            this.f2578l.put(str, aVar.x());
            this.f2579m.put(str, O02.f3092b);
            this.f2580n.put(str, O02.f3093c);
        }
    }

    static /* synthetic */ C w(I2 i22, String str) {
        i22.r();
        C0335p.f(str);
        if (!i22.W(str)) {
            return null;
        }
        if (!i22.f2574h.containsKey(str) || i22.f2574h.get(str) == null) {
            i22.g0(str);
        } else {
            i22.G(str, (T1) i22.f2574h.get(str));
        }
        return (C) i22.f2576j.snapshot().get(str);
    }

    private final T1 x(String str, byte[] bArr) {
        Long l4;
        if (bArr == null) {
            return T1.O();
        }
        try {
            T1 t12 = (T1) ((C0668s4) ((T1.a) Z5.G(T1.M(), bArr)).m());
            C0835p2 K4 = a().K();
            String str2 = null;
            if (t12.Z()) {
                l4 = Long.valueOf(t12.K());
            } else {
                l4 = null;
            }
            if (t12.X()) {
                str2 = t12.Q();
            }
            K4.c("Parsed config. version, gmp_app_id", l4, str2);
            return t12;
        } catch (B4 e5) {
            a().L().c("Unable to merge remote config. appId", C0821n2.s(str), e5);
            return T1.O();
        } catch (RuntimeException e6) {
            a().L().c("Unable to merge remote config. appId", C0821n2.s(str), e6);
            return T1.O();
        }
    }

    private static A3.a y(Q1.e eVar) {
        int i4 = O2.f2663b[eVar.ordinal()];
        if (i4 == 1) {
            return A3.a.AD_STORAGE;
        }
        if (i4 == 2) {
            return A3.a.ANALYTICS_STORAGE;
        }
        if (i4 == 3) {
            return A3.a.AD_USER_DATA;
        }
        if (i4 != 4) {
            return null;
        }
        return A3.a.AD_PERSONALIZATION;
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

    /* access modifiers changed from: protected */
    public final boolean H(String str, byte[] bArr, String str2, String str3) {
        r();
        k();
        C0335p.f(str);
        T1.a aVar = (T1.a) x(str, bArr).y();
        if (aVar == null) {
            return false;
        }
        F(str, aVar);
        G(str, (T1) ((C0668s4) aVar.m()));
        this.f2574h.put(str, (T1) ((C0668s4) aVar.m()));
        this.f2578l.put(str, aVar.x());
        this.f2579m.put(str, str2);
        this.f2580n.put(str, str3);
        this.f2570d.put(str, D((T1) ((C0668s4) aVar.m())));
        n().c0(str, new ArrayList(aVar.y()));
        try {
            aVar.t();
            bArr = ((T1) ((C0668s4) aVar.m())).i();
        } catch (RuntimeException e5) {
            a().L().c("Unable to serialize reduced-size config. Storing full config instead. appId", C0821n2.s(str), e5);
        }
        C0797k n4 = n();
        C0335p.f(str);
        n4.k();
        n4.r();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        contentValues.put("config_last_modified_time", str2);
        contentValues.put("e_tag", str3);
        try {
            if (((long) n4.y().update("apps", contentValues, "app_id = ?", new String[]{str})) == 0) {
                n4.a().G().b("Failed to update remote config (got 0). appId", C0821n2.s(str));
            }
        } catch (SQLiteException e6) {
            n4.a().G().c("Error storing remote config. appId", C0821n2.s(str), e6);
        }
        this.f2574h.put(str, (T1) ((C0668s4) aVar.m()));
        return true;
    }

    /* access modifiers changed from: package-private */
    public final int I(String str, String str2) {
        Integer num;
        k();
        g0(str);
        Map map = (Map) this.f2575i.get(str);
        if (map == null || (num = (Integer) map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    /* access modifiers changed from: package-private */
    public final Q1 J(String str) {
        k();
        g0(str);
        T1 L4 = L(str);
        if (L4 == null || !L4.W()) {
            return null;
        }
        return L4.L();
    }

    /* access modifiers changed from: package-private */
    public final A3.a K(String str, A3.a aVar) {
        k();
        g0(str);
        Q1 J4 = J(str);
        if (J4 == null) {
            return null;
        }
        for (Q1.c cVar : J4.K()) {
            if (aVar == y(cVar.I())) {
                return y(cVar.H());
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final T1 L(String str) {
        r();
        k();
        C0335p.f(str);
        g0(str);
        return (T1) this.f2574h.get(str);
    }

    /* access modifiers changed from: package-private */
    public final boolean M(String str, A3.a aVar) {
        k();
        g0(str);
        Q1 J4 = J(str);
        if (J4 == null) {
            return false;
        }
        Iterator it = J4.J().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Q1.a aVar2 = (Q1.a) it.next();
            if (aVar == y(aVar2.I())) {
                if (aVar2.H() == Q1.d.GRANTED) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean N(String str, String str2) {
        Boolean bool;
        k();
        g0(str);
        if ("ecommerce_purchase".equals(str2) || "purchase".equals(str2) || "refund".equals(str2)) {
            return true;
        }
        Map map = (Map) this.f2573g.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: protected */
    public final String O(String str) {
        k();
        return (String) this.f2580n.get(str);
    }

    /* access modifiers changed from: package-private */
    public final boolean P(String str, String str2) {
        Boolean bool;
        k();
        g0(str);
        if (X(str) && d6.J0(str2)) {
            return true;
        }
        if (Z(str) && d6.K0(str2)) {
            return true;
        }
        Map map = (Map) this.f2572f.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: protected */
    public final String Q(String str) {
        k();
        return (String) this.f2579m.get(str);
    }

    /* access modifiers changed from: package-private */
    public final String R(String str) {
        k();
        g0(str);
        return (String) this.f2578l.get(str);
    }

    /* access modifiers changed from: package-private */
    public final Set S(String str) {
        k();
        g0(str);
        return (Set) this.f2571e.get(str);
    }

    /* access modifiers changed from: package-private */
    public final SortedSet T(String str) {
        k();
        g0(str);
        TreeSet treeSet = new TreeSet();
        Q1 J4 = J(str);
        if (J4 != null) {
            for (Q1.f H4 : J4.I()) {
                treeSet.add(H4.H());
            }
        }
        return treeSet;
    }

    /* access modifiers changed from: protected */
    public final void U(String str) {
        k();
        this.f2579m.put(str, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public final void V(String str) {
        k();
        this.f2574h.remove(str);
    }

    public final boolean W(String str) {
        T1 t12;
        if (TextUtils.isEmpty(str) || (t12 = (T1) this.f2574h.get(str)) == null || t12.j() == 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean X(String str) {
        return "1".equals(h(str, "measurement.upload.blacklist_internal"));
    }

    /* access modifiers changed from: package-private */
    public final boolean Y(String str) {
        k();
        g0(str);
        Q1 J4 = J(str);
        if (J4 != null && J4.N() && !J4.M()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean Z(String str) {
        return "1".equals(h(str, "measurement.upload.blacklist_public"));
    }

    public final /* bridge */ /* synthetic */ C0821n2 a() {
        return super.a();
    }

    /* access modifiers changed from: package-private */
    public final boolean a0(String str) {
        k();
        g0(str);
        if (this.f2571e.get(str) == null || !((Set) this.f2571e.get(str)).contains("app_instance_id")) {
            return false;
        }
        return true;
    }

    public final /* bridge */ /* synthetic */ C0769g b() {
        return super.b();
    }

    /* access modifiers changed from: package-private */
    public final boolean b0(String str) {
        k();
        g0(str);
        if (this.f2571e.get(str) == null) {
            return false;
        }
        if (((Set) this.f2571e.get(str)).contains("device_model") || ((Set) this.f2571e.get(str)).contains("device_info")) {
            return true;
        }
        return false;
    }

    public final /* bridge */ /* synthetic */ C0887x c() {
        return super.c();
    }

    /* access modifiers changed from: package-private */
    public final boolean c0(String str) {
        k();
        g0(str);
        if (this.f2571e.get(str) == null || !((Set) this.f2571e.get(str)).contains("enhanced_user_id")) {
            return false;
        }
        return true;
    }

    public final /* bridge */ /* synthetic */ C0779h2 d() {
        return super.d();
    }

    /* access modifiers changed from: package-private */
    public final boolean d0(String str) {
        k();
        g0(str);
        if (this.f2571e.get(str) == null || !((Set) this.f2571e.get(str)).contains("google_signals")) {
            return false;
        }
        return true;
    }

    public final /* bridge */ /* synthetic */ C0904z2 e() {
        return super.e();
    }

    /* access modifiers changed from: package-private */
    public final boolean e0(String str) {
        k();
        g0(str);
        if (this.f2571e.get(str) == null) {
            return false;
        }
        if (((Set) this.f2571e.get(str)).contains("os_version") || ((Set) this.f2571e.get(str)).contains("device_info")) {
            return true;
        }
        return false;
    }

    public final /* bridge */ /* synthetic */ P2 f() {
        return super.f();
    }

    /* access modifiers changed from: package-private */
    public final boolean f0(String str) {
        k();
        g0(str);
        if (this.f2571e.get(str) == null || !((Set) this.f2571e.get(str)).contains("user_id")) {
            return false;
        }
        return true;
    }

    public final /* bridge */ /* synthetic */ d6 g() {
        return super.g();
    }

    public final String h(String str, String str2) {
        k();
        g0(str);
        Map map = (Map) this.f2570d.get(str);
        if (map != null) {
            return (String) map.get(str2);
        }
        return null;
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

    public final /* bridge */ /* synthetic */ Z5 l() {
        return super.l();
    }

    public final /* bridge */ /* synthetic */ h6 m() {
        return super.m();
    }

    public final /* bridge */ /* synthetic */ C0797k n() {
        return super.n();
    }

    public final /* bridge */ /* synthetic */ I2 o() {
        return super.o();
    }

    public final /* bridge */ /* synthetic */ C0796j5 p() {
        return super.p();
    }

    public final /* bridge */ /* synthetic */ G5 q() {
        return super.q();
    }

    /* access modifiers changed from: protected */
    public final boolean u() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final long v(String str) {
        String h4 = h(str, "measurement.account.time_zone_offset_minutes");
        if (TextUtils.isEmpty(h4)) {
            return 0;
        }
        try {
            return Long.parseLong(h4);
        } catch (NumberFormatException e5) {
            a().L().c("Unable to parse timezone offset. appId", C0821n2.s(str), e5);
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    public final p z(String str, A3.a aVar) {
        k();
        g0(str);
        Q1 J4 = J(str);
        if (J4 == null) {
            return p.UNINITIALIZED;
        }
        for (Q1.a aVar2 : J4.L()) {
            if (y(aVar2.I()) == aVar) {
                int i4 = O2.f2664c[aVar2.H().ordinal()];
                if (i4 == 1) {
                    return p.DENIED;
                }
                if (i4 != 2) {
                    return p.UNINITIALIZED;
                }
                return p.GRANTED;
            }
        }
        return p.UNINITIALIZED;
    }
}
