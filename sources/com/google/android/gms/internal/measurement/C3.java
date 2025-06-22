package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;

public abstract class C3 implements Z4 {
    protected int zza = 0;

    protected static void f(Iterable iterable, List list) {
        D3.g(iterable, list);
    }

    /* access modifiers changed from: package-private */
    public abstract int e(C0638o5 o5Var);

    /* access modifiers changed from: package-private */
    public abstract int g();

    /* access modifiers changed from: package-private */
    public abstract void h(int i4);

    public final byte[] i() {
        try {
            byte[] bArr = new byte[d()];
            C0520b4 D4 = C0520b4.D(bArr);
            a(D4);
            D4.E();
            return bArr;
        } catch (IOException e5) {
            String name = getClass().getName();
            throw new RuntimeException("Serializing " + name + " to a " + "byte array" + " threw an IOException (should never happen).", e5);
        }
    }
}
