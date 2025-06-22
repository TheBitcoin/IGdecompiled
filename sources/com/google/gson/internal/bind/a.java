package com.google.gson.internal.bind;

import com.google.gson.d;
import com.google.gson.f;
import com.google.gson.h;
import com.google.gson.i;
import com.google.gson.k;
import i1.C2081c;
import j$.util.Objects;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public final class a extends C2081c {

    /* renamed from: p  reason: collision with root package name */
    private static final Writer f11659p = new C0169a();

    /* renamed from: q  reason: collision with root package name */
    private static final k f11660q = new k("closed");

    /* renamed from: m  reason: collision with root package name */
    private final List f11661m = new ArrayList();

    /* renamed from: n  reason: collision with root package name */
    private String f11662n;

    /* renamed from: o  reason: collision with root package name */
    private f f11663o = h.f11501a;

    /* renamed from: com.google.gson.internal.bind.a$a  reason: collision with other inner class name */
    class C0169a extends Writer implements AutoCloseable {
        C0169a() {
        }

        public void close() {
            throw new AssertionError();
        }

        public void flush() {
            throw new AssertionError();
        }

        public void write(char[] cArr, int i4, int i5) {
            throw new AssertionError();
        }
    }

    public a() {
        super(f11659p);
    }

    private f S() {
        List list = this.f11661m;
        return (f) list.get(list.size() - 1);
    }

    private void T(f fVar) {
        if (this.f11662n != null) {
            if (!fVar.k() || o()) {
                ((i) S()).n(this.f11662n, fVar);
            }
            this.f11662n = null;
        } else if (this.f11661m.isEmpty()) {
            this.f11663o = fVar;
        } else {
            f S4 = S();
            if (S4 instanceof d) {
                ((d) S4).n(fVar);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public C2081c K(double d5) {
        if (r() || (!Double.isNaN(d5) && !Double.isInfinite(d5))) {
            T(new k((Number) Double.valueOf(d5)));
            return this;
        }
        throw new IllegalArgumentException("JSON forbids NaN and infinities: " + d5);
    }

    public C2081c L(long j4) {
        T(new k((Number) Long.valueOf(j4)));
        return this;
    }

    public C2081c M(Boolean bool) {
        if (bool == null) {
            return x();
        }
        T(new k(bool));
        return this;
    }

    public C2081c N(Number number) {
        if (number == null) {
            return x();
        }
        if (!r()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        T(new k(number));
        return this;
    }

    public C2081c O(String str) {
        if (str == null) {
            return x();
        }
        T(new k(str));
        return this;
    }

    public C2081c P(boolean z4) {
        T(new k(Boolean.valueOf(z4)));
        return this;
    }

    public f R() {
        if (this.f11661m.isEmpty()) {
            return this.f11663o;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.f11661m);
    }

    public void close() {
        if (this.f11661m.isEmpty()) {
            this.f11661m.add(f11660q);
            return;
        }
        throw new IOException("Incomplete document");
    }

    public void flush() {
    }

    public C2081c g() {
        d dVar = new d();
        T(dVar);
        this.f11661m.add(dVar);
        return this;
    }

    public C2081c i() {
        i iVar = new i();
        T(iVar);
        this.f11661m.add(iVar);
        return this;
    }

    public C2081c l() {
        if (this.f11661m.isEmpty() || this.f11662n != null) {
            throw new IllegalStateException();
        } else if (S() instanceof d) {
            List list = this.f11661m;
            list.remove(list.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public C2081c n() {
        if (this.f11661m.isEmpty() || this.f11662n != null) {
            throw new IllegalStateException();
        } else if (S() instanceof i) {
            List list = this.f11661m;
            list.remove(list.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public C2081c v(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.f11661m.isEmpty() || this.f11662n != null) {
            throw new IllegalStateException();
        } else if (S() instanceof i) {
            this.f11662n = str;
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public C2081c x() {
        T(h.f11501a);
        return this;
    }
}
