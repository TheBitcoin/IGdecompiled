package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import i1.C2079a;
import i1.C2081c;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

final class TypeAdapterRuntimeTypeWrapper<T> extends TypeAdapter {

    /* renamed from: a  reason: collision with root package name */
    private final Gson f11586a;

    /* renamed from: b  reason: collision with root package name */
    private final TypeAdapter f11587b;

    /* renamed from: c  reason: collision with root package name */
    private final Type f11588c;

    TypeAdapterRuntimeTypeWrapper(Gson gson, TypeAdapter typeAdapter, Type type) {
        this.f11586a = gson;
        this.f11587b = typeAdapter;
        this.f11588c = type;
    }

    private static Type e(Type type, Object obj) {
        if (obj == null) {
            return type;
        }
        if ((type instanceof Class) || (type instanceof TypeVariable)) {
            return obj.getClass();
        }
        return type;
    }

    private static boolean f(TypeAdapter typeAdapter) {
        TypeAdapter e5;
        while ((typeAdapter instanceof SerializationDelegatingTypeAdapter) && (e5 = ((SerializationDelegatingTypeAdapter) typeAdapter).e()) != typeAdapter) {
            typeAdapter = e5;
        }
        return typeAdapter instanceof ReflectiveTypeAdapterFactory.Adapter;
    }

    public Object b(C2079a aVar) {
        return this.f11587b.b(aVar);
    }

    public void d(C2081c cVar, Object obj) {
        TypeAdapter typeAdapter = this.f11587b;
        Type e5 = e(this.f11588c, obj);
        if (e5 != this.f11588c) {
            typeAdapter = this.f11586a.k(TypeToken.b(e5));
            if ((typeAdapter instanceof ReflectiveTypeAdapterFactory.Adapter) && !f(this.f11587b)) {
                typeAdapter = this.f11587b;
            }
        }
        typeAdapter.d(cVar, obj);
    }
}
