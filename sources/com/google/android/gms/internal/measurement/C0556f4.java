package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.C0668s4;
import java.util.Collections;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.measurement.f4  reason: case insensitive filesystem */
public class C0556f4 {

    /* renamed from: b  reason: collision with root package name */
    private static volatile C0556f4 f1895b;

    /* renamed from: c  reason: collision with root package name */
    static final C0556f4 f1896c = new C0556f4(true);

    /* renamed from: a  reason: collision with root package name */
    private final Map f1897a = Collections.EMPTY_MAP;

    /* renamed from: com.google.android.gms.internal.measurement.f4$a */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Object f1898a;

        /* renamed from: b  reason: collision with root package name */
        private final int f1899b;

        a(Object obj, int i4) {
            this.f1898a = obj;
            this.f1899b = i4;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f1898a == aVar.f1898a && this.f1899b == aVar.f1899b) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.f1898a) * 65535) + this.f1899b;
        }
    }

    private C0556f4(boolean z4) {
    }

    public static C0556f4 a() {
        C0556f4 f4Var = f1895b;
        if (f4Var != null) {
            return f4Var;
        }
        synchronized (C0556f4.class) {
            try {
                C0556f4 f4Var2 = f1895b;
                if (f4Var2 != null) {
                    return f4Var2;
                }
                C0556f4 a5 = C0653q4.a(C0556f4.class);
                f1895b = a5;
                return a5;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final C0668s4.d b(Z4 z4, int i4) {
        android.support.v4.media.a.a(this.f1897a.get(new a(z4, i4)));
        return null;
    }
}
