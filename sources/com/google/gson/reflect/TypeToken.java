package com.google.gson.reflect;

import com.google.gson.internal.b;
import j$.util.Objects;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class TypeToken<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Class f11747a;

    /* renamed from: b  reason: collision with root package name */
    private final Type f11748b;

    /* renamed from: c  reason: collision with root package name */
    private final int f11749c;

    protected TypeToken() {
        Type e5 = e();
        this.f11748b = e5;
        this.f11747a = b.k(e5);
        this.f11749c = e5.hashCode();
    }

    public static TypeToken a(Class cls) {
        return new TypeToken(cls);
    }

    public static TypeToken b(Type type) {
        return new TypeToken(type);
    }

    private Type e() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        Class<TypeToken> cls = TypeToken.class;
        if (genericSuperclass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
            if (parameterizedType.getRawType() == cls) {
                return b.b(parameterizedType.getActualTypeArguments()[0]);
            }
        } else if (genericSuperclass == cls) {
            throw new IllegalStateException("TypeToken must be created with a type argument: new TypeToken<...>() {}; When using code shrinkers (ProGuard, R8, ...) make sure that generic signatures are preserved.");
        }
        throw new IllegalStateException("Must only create direct subclasses of TypeToken");
    }

    public final Class c() {
        return this.f11747a;
    }

    public final Type d() {
        return this.f11748b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof TypeToken) || !b.f(this.f11748b, ((TypeToken) obj).f11748b)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f11749c;
    }

    public final String toString() {
        return b.t(this.f11748b);
    }

    private TypeToken(Type type) {
        Objects.requireNonNull(type);
        Type b5 = b.b(type);
        this.f11748b = b5;
        this.f11747a = b.k(b5);
        this.f11749c = b5.hashCode();
    }
}
