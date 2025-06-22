package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.A3;
import java.util.EnumMap;

/* renamed from: com.google.android.gms.measurement.internal.h  reason: case insensitive filesystem */
final class C0776h {

    /* renamed from: a  reason: collision with root package name */
    private final EnumMap f3008a;

    C0776h() {
        this.f3008a = new EnumMap(A3.a.class);
    }

    public static C0776h a(String str) {
        EnumMap enumMap = new EnumMap(A3.a.class);
        if (str.length() >= A3.a.values().length) {
            int i4 = 0;
            if (str.charAt(0) == '1') {
                A3.a[] values = A3.a.values();
                int length = values.length;
                int i5 = 1;
                while (i4 < length) {
                    enumMap.put(values[i4], C0790j.b(str.charAt(i5)));
                    i4++;
                    i5++;
                }
                return new C0776h(enumMap);
            }
        }
        return new C0776h();
    }

    public final C0790j b(A3.a aVar) {
        C0790j jVar = (C0790j) this.f3008a.get(aVar);
        if (jVar == null) {
            return C0790j.UNSET;
        }
        return jVar;
    }

    public final void c(A3.a aVar, int i4) {
        C0790j jVar = C0790j.UNSET;
        if (i4 != -30) {
            if (i4 != -20) {
                if (i4 == -10) {
                    jVar = C0790j.MANIFEST;
                } else if (i4 != 0) {
                    if (i4 == 30) {
                        jVar = C0790j.INITIALIZATION;
                    }
                }
            }
            jVar = C0790j.API;
        } else {
            jVar = C0790j.TCF;
        }
        this.f3008a.put(aVar, jVar);
    }

    public final void d(A3.a aVar, C0790j jVar) {
        this.f3008a.put(aVar, jVar);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("1");
        for (A3.a aVar : A3.a.values()) {
            C0790j jVar = (C0790j) this.f3008a.get(aVar);
            if (jVar == null) {
                jVar = C0790j.UNSET;
            }
            sb.append(jVar.f3044a);
        }
        return sb.toString();
    }

    private C0776h(EnumMap enumMap) {
        EnumMap enumMap2 = new EnumMap(A3.a.class);
        this.f3008a = enumMap2;
        enumMap2.putAll(enumMap);
    }
}
