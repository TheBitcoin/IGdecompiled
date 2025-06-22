package com.google.gson;

import com.google.gson.internal.f;
import j$.util.Objects;
import java.math.BigInteger;

public final class k extends f {

    /* renamed from: a  reason: collision with root package name */
    private final Object f11733a;

    public k(Boolean bool) {
        Objects.requireNonNull(bool);
        this.f11733a = bool;
    }

    private static boolean r(k kVar) {
        Object obj = kVar.f11733a;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        if ((number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k.class != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        if (this.f11733a == null) {
            if (kVar.f11733a == null) {
                return true;
            }
            return false;
        } else if (!r(this) || !r(kVar)) {
            Object obj2 = this.f11733a;
            if (!(obj2 instanceof Number) || !(kVar.f11733a instanceof Number)) {
                return obj2.equals(kVar.f11733a);
            }
            double doubleValue = o().doubleValue();
            double doubleValue2 = kVar.o().doubleValue();
            if (doubleValue == doubleValue2 || (Double.isNaN(doubleValue) && Double.isNaN(doubleValue2))) {
                return true;
            }
            return false;
        } else if (o().longValue() == kVar.o().longValue()) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        long doubleToLongBits;
        if (this.f11733a == null) {
            return 31;
        }
        if (r(this)) {
            doubleToLongBits = o().longValue();
        } else {
            Object obj = this.f11733a;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            doubleToLongBits = Double.doubleToLongBits(o().doubleValue());
        }
        return (int) ((doubleToLongBits >>> 32) ^ doubleToLongBits);
    }

    public boolean n() {
        if (q()) {
            return ((Boolean) this.f11733a).booleanValue();
        }
        return Boolean.parseBoolean(p());
    }

    public Number o() {
        Object obj = this.f11733a;
        if (obj instanceof Number) {
            return (Number) obj;
        }
        if (obj instanceof String) {
            return new f((String) obj);
        }
        throw new UnsupportedOperationException("Primitive is neither a number nor a string");
    }

    public String p() {
        Object obj = this.f11733a;
        if (obj instanceof String) {
            return (String) obj;
        }
        if (s()) {
            return o().toString();
        }
        if (q()) {
            return ((Boolean) this.f11733a).toString();
        }
        throw new AssertionError("Unexpected value type: " + this.f11733a.getClass());
    }

    public boolean q() {
        return this.f11733a instanceof Boolean;
    }

    public boolean s() {
        return this.f11733a instanceof Number;
    }

    public boolean t() {
        return this.f11733a instanceof String;
    }

    public k(Number number) {
        Objects.requireNonNull(number);
        this.f11733a = number;
    }

    public k(String str) {
        Objects.requireNonNull(str);
        this.f11733a = str;
    }
}
