package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.A3;
import f0.p;
import j$.util.Objects;
import java.util.EnumMap;
import java.util.Map;

/* renamed from: com.google.android.gms.measurement.internal.v  reason: case insensitive filesystem */
public final class C0873v {

    /* renamed from: f  reason: collision with root package name */
    private static final C0873v f3254f = new C0873v((Boolean) null, 100);

    /* renamed from: a  reason: collision with root package name */
    private final int f3255a;

    /* renamed from: b  reason: collision with root package name */
    private final String f3256b;

    /* renamed from: c  reason: collision with root package name */
    private final Boolean f3257c;

    /* renamed from: d  reason: collision with root package name */
    private final String f3258d;

    /* renamed from: e  reason: collision with root package name */
    private final EnumMap f3259e;

    C0873v(Boolean bool, int i4) {
        this((Boolean) null, i4, (Boolean) null, (String) null);
    }

    public static C0873v b(Bundle bundle, int i4) {
        Boolean bool = null;
        if (bundle == null) {
            return new C0873v((Boolean) null, i4);
        }
        EnumMap enumMap = new EnumMap(A3.a.class);
        for (A3.a aVar : B3.DMA.a()) {
            enumMap.put(aVar, A3.i(bundle.getString(aVar.f2307a)));
        }
        if (bundle.containsKey("is_dma_region")) {
            bool = Boolean.valueOf(bundle.getString("is_dma_region"));
        }
        return new C0873v(enumMap, i4, bool, bundle.getString("cps_display_str"));
    }

    static C0873v c(p pVar, int i4) {
        EnumMap enumMap = new EnumMap(A3.a.class);
        enumMap.put(A3.a.AD_USER_DATA, pVar);
        return new C0873v(enumMap, -10, (Boolean) null, (String) null);
    }

    public static C0873v d(String str) {
        if (str == null || str.length() <= 0) {
            return f3254f;
        }
        String[] split = str.split(":");
        int parseInt = Integer.parseInt(split[0]);
        EnumMap enumMap = new EnumMap(A3.a.class);
        A3.a[] a5 = B3.DMA.a();
        int length = a5.length;
        int i4 = 1;
        int i5 = 0;
        while (i5 < length) {
            enumMap.put(a5[i5], A3.g(split[i4].charAt(0)));
            i5++;
            i4++;
        }
        return new C0873v(enumMap, parseInt, (Boolean) null, (String) null);
    }

    public static Boolean e(Bundle bundle) {
        p i4;
        if (bundle == null || (i4 = A3.i(bundle.getString("ad_personalization"))) == null) {
            return null;
        }
        int i5 = C0901z.f3312a[i4.ordinal()];
        if (i5 == 3) {
            return Boolean.FALSE;
        }
        if (i5 != 4) {
            return null;
        }
        return Boolean.TRUE;
    }

    private final String l() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f3255a);
        for (A3.a aVar : B3.DMA.a()) {
            sb.append(":");
            sb.append(A3.a((p) this.f3259e.get(aVar)));
        }
        return sb.toString();
    }

    public final int a() {
        return this.f3255a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C0873v)) {
            return false;
        }
        C0873v vVar = (C0873v) obj;
        if (this.f3256b.equalsIgnoreCase(vVar.f3256b) && Objects.equals(this.f3257c, vVar.f3257c)) {
            return Objects.equals(this.f3258d, vVar.f3258d);
        }
        return false;
    }

    public final Bundle f() {
        Bundle bundle = new Bundle();
        for (Map.Entry entry : this.f3259e.entrySet()) {
            String r4 = A3.r((p) entry.getValue());
            if (r4 != null) {
                bundle.putString(((A3.a) entry.getKey()).f2307a, r4);
            }
        }
        Boolean bool = this.f3257c;
        if (bool != null) {
            bundle.putString("is_dma_region", bool.toString());
        }
        String str = this.f3258d;
        if (str != null) {
            bundle.putString("cps_display_str", str);
        }
        return bundle;
    }

    public final p g() {
        p pVar = (p) this.f3259e.get(A3.a.AD_USER_DATA);
        if (pVar == null) {
            return p.UNINITIALIZED;
        }
        return pVar;
    }

    public final Boolean h() {
        return this.f3257c;
    }

    public final int hashCode() {
        int i4;
        int i5;
        Boolean bool = this.f3257c;
        if (bool == null) {
            i4 = 3;
        } else if (bool == Boolean.TRUE) {
            i4 = 7;
        } else {
            i4 = 13;
        }
        String str = this.f3258d;
        if (str == null) {
            i5 = 17;
        } else {
            i5 = str.hashCode();
        }
        return this.f3256b.hashCode() + (i4 * 29) + (i5 * 137);
    }

    public final String i() {
        return this.f3258d;
    }

    public final String j() {
        return this.f3256b;
    }

    public final boolean k() {
        for (p pVar : this.f3259e.values()) {
            if (pVar != p.UNINITIALIZED) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("source=");
        sb.append(A3.j(this.f3255a));
        for (A3.a aVar : B3.DMA.a()) {
            sb.append(",");
            sb.append(aVar.f2307a);
            sb.append("=");
            p pVar = (p) this.f3259e.get(aVar);
            if (pVar == null) {
                sb.append("uninitialized");
            } else {
                int i4 = C0901z.f3312a[pVar.ordinal()];
                if (i4 == 1) {
                    sb.append("uninitialized");
                } else if (i4 == 2) {
                    sb.append("eu_consent_policy");
                } else if (i4 == 3) {
                    sb.append("denied");
                } else if (i4 == 4) {
                    sb.append("granted");
                }
            }
        }
        if (this.f3257c != null) {
            sb.append(",isDmaRegion=");
            sb.append(this.f3257c);
        }
        if (this.f3258d != null) {
            sb.append(",cpsDisplayStr=");
            sb.append(this.f3258d);
        }
        return sb.toString();
    }

    C0873v(Boolean bool, int i4, Boolean bool2, String str) {
        EnumMap enumMap = new EnumMap(A3.a.class);
        this.f3259e = enumMap;
        enumMap.put(A3.a.AD_USER_DATA, A3.h(bool));
        this.f3255a = i4;
        this.f3256b = l();
        this.f3257c = bool2;
        this.f3258d = str;
    }

    private C0873v(EnumMap enumMap, int i4, Boolean bool, String str) {
        EnumMap enumMap2 = new EnumMap(A3.a.class);
        this.f3259e = enumMap2;
        enumMap2.putAll(enumMap);
        this.f3255a = i4;
        this.f3256b = l();
        this.f3257c = bool;
        this.f3258d = str;
    }
}
