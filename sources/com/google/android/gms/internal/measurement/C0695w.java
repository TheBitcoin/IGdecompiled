package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: com.google.android.gms.internal.measurement.w  reason: case insensitive filesystem */
final class C0695w implements Iterator {

    /* renamed from: a  reason: collision with root package name */
    private int f2216a = 0;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ C0679u f2217b;

    C0695w(C0679u uVar) {
        this.f2217b = uVar;
    }

    public final boolean hasNext() {
        if (this.f2216a < this.f2217b.f2190a.length()) {
            return true;
        }
        return false;
    }

    public final /* synthetic */ Object next() {
        if (this.f2216a < this.f2217b.f2190a.length()) {
            String c5 = this.f2217b.f2190a;
            int i4 = this.f2216a;
            this.f2216a = i4 + 1;
            return new C0679u(String.valueOf(c5.charAt(i4)));
        }
        throw new NoSuchElementException();
    }
}
