package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.l  reason: case insensitive filesystem */
public final class C0605l implements C0663s {

    /* renamed from: a  reason: collision with root package name */
    private final C0663s f1979a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1980b;

    public C0605l(String str) {
        this.f1979a = C0663s.f2138b0;
        this.f1980b = str;
    }

    public final Boolean C() {
        throw new IllegalStateException("Control is not a boolean");
    }

    public final Double D() {
        throw new IllegalStateException("Control is not a double");
    }

    public final String E() {
        throw new IllegalStateException("Control is not a String");
    }

    public final Iterator F() {
        return null;
    }

    public final C0663s G(String str, Z2 z22, List list) {
        throw new IllegalStateException("Control does not have functions");
    }

    public final C0663s a() {
        return this.f1979a;
    }

    public final C0663s b() {
        return new C0605l(this.f1980b, this.f1979a.b());
    }

    public final String c() {
        return this.f1980b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0605l)) {
            return false;
        }
        C0605l lVar = (C0605l) obj;
        if (!this.f1980b.equals(lVar.f1980b) || !this.f1979a.equals(lVar.f1979a)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return (this.f1980b.hashCode() * 31) + this.f1979a.hashCode();
    }

    public C0605l(String str, C0663s sVar) {
        this.f1979a = sVar;
        this.f1980b = str;
    }
}
