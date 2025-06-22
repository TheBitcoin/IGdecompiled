package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.m;
import com.google.gson.p;
import com.google.gson.q;
import com.google.gson.r;
import com.google.gson.reflect.TypeToken;
import i1.C2079a;
import i1.C2080b;
import i1.C2081c;

public final class NumberTypeAdapter extends TypeAdapter {

    /* renamed from: b  reason: collision with root package name */
    private static final r f11542b = f(p.LAZILY_PARSED_NUMBER);

    /* renamed from: a  reason: collision with root package name */
    private final q f11543a;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f11545a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                i1.b[] r0 = i1.C2080b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f11545a = r0
                i1.b r1 = i1.C2080b.NULL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f11545a     // Catch:{ NoSuchFieldError -> 0x001d }
                i1.b r1 = i1.C2080b.NUMBER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f11545a     // Catch:{ NoSuchFieldError -> 0x0028 }
                i1.b r1 = i1.C2080b.STRING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.NumberTypeAdapter.a.<clinit>():void");
        }
    }

    private NumberTypeAdapter(q qVar) {
        this.f11543a = qVar;
    }

    public static r e(q qVar) {
        if (qVar == p.LAZILY_PARSED_NUMBER) {
            return f11542b;
        }
        return f(qVar);
    }

    private static r f(q qVar) {
        return new r() {
            public TypeAdapter a(Gson gson, TypeToken typeToken) {
                if (typeToken.c() == Number.class) {
                    return NumberTypeAdapter.this;
                }
                return null;
            }
        };
    }

    /* renamed from: g */
    public Number b(C2079a aVar) {
        C2080b L4 = aVar.L();
        int i4 = a.f11545a[L4.ordinal()];
        if (i4 == 1) {
            aVar.H();
            return null;
        } else if (i4 == 2 || i4 == 3) {
            return this.f11543a.a(aVar);
        } else {
            throw new m("Expecting number, got: " + L4 + "; at path " + aVar.getPath());
        }
    }

    /* renamed from: h */
    public void d(C2081c cVar, Number number) {
        cVar.N(number);
    }
}
