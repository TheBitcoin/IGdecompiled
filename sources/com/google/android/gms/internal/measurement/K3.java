package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;

public abstract class K3 implements Serializable, Iterable {

    /* renamed from: b  reason: collision with root package name */
    public static final K3 f1515b = new V3(C0684u4.f2197b);

    /* renamed from: c  reason: collision with root package name */
    private static final R3 f1516c = new U3();

    /* renamed from: a  reason: collision with root package name */
    private int f1517a = 0;

    static {
        new M3();
    }

    K3() {
    }

    static /* synthetic */ int h(byte b5) {
        return b5 & 255;
    }

    static int j(int i4, int i5, int i6) {
        int i7 = i5 - i4;
        if ((i4 | i5 | i7 | (i6 - i5)) >= 0) {
            return i7;
        }
        if (i4 < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i4 + " < 0");
        } else if (i5 < i4) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i4 + ", " + i5);
        } else {
            throw new IndexOutOfBoundsException("End index: " + i5 + " >= " + i6);
        }
    }

    public static K3 l(String str) {
        return new V3(str.getBytes(C0684u4.f2196a));
    }

    public static K3 m(byte[] bArr) {
        return n(bArr, 0, bArr.length);
    }

    public static K3 n(byte[] bArr, int i4, int i5) {
        j(i4, i4 + i5, bArr.length);
        return new V3(f1516c.a(bArr, i4, i5));
    }

    static T3 s(int i4) {
        return new T3(i4);
    }

    public abstract byte c(int i4);

    public abstract boolean equals(Object obj);

    /* access modifiers changed from: protected */
    public final int g() {
        return this.f1517a;
    }

    public final int hashCode() {
        int i4 = this.f1517a;
        if (i4 == 0) {
            int q4 = q();
            i4 = r(q4, 0, q4);
            if (i4 == 0) {
                i4 = 1;
            }
            this.f1517a = i4;
        }
        return i4;
    }

    public /* synthetic */ Iterator iterator() {
        return new N3(this);
    }

    public abstract K3 k(int i4, int i5);

    /* access modifiers changed from: package-private */
    public abstract void o(L3 l32);

    /* access modifiers changed from: package-private */
    public abstract byte p(int i4);

    public abstract int q();

    /* access modifiers changed from: protected */
    public abstract int r(int i4, int i5, int i6);

    public final String toString() {
        String str;
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        Integer valueOf = Integer.valueOf(q());
        if (q() <= 50) {
            str = A5.a(this);
        } else {
            str = A5.a(k(0, 47)) + "...";
        }
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", new Object[]{hexString, valueOf, str});
    }
}
