package com.google.gson;

import j$.util.Objects;
import java.lang.reflect.Field;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final Field f11491a;

    public a(Field field) {
        Objects.requireNonNull(field);
        this.f11491a = field;
    }

    public String toString() {
        return this.f11491a.toString();
    }
}
