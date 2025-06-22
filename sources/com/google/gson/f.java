package com.google.gson;

import com.google.gson.internal.l;
import i1.C2081c;
import java.io.IOException;
import java.io.StringWriter;

public abstract class f {
    public d c() {
        if (j()) {
            return (d) this;
        }
        throw new IllegalStateException("Not a JSON Array: " + this);
    }

    public i g() {
        if (l()) {
            return (i) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public k h() {
        if (m()) {
            return (k) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    public boolean j() {
        return this instanceof d;
    }

    public boolean k() {
        return this instanceof h;
    }

    public boolean l() {
        return this instanceof i;
    }

    public boolean m() {
        return this instanceof k;
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            C2081c cVar = new C2081c(stringWriter);
            cVar.H(true);
            l.a(this, cVar);
            return stringWriter.toString();
        } catch (IOException e5) {
            throw new AssertionError(e5);
        }
    }
}
