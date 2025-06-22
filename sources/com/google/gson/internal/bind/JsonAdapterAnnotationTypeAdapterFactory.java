package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.c;
import com.google.gson.r;
import com.google.gson.reflect.TypeToken;
import f1.C1998b;

public final class JsonAdapterAnnotationTypeAdapterFactory implements r {

    /* renamed from: a  reason: collision with root package name */
    private final c f11535a;

    public JsonAdapterAnnotationTypeAdapterFactory(c cVar) {
        this.f11535a = cVar;
    }

    public TypeAdapter a(Gson gson, TypeToken typeToken) {
        C1998b bVar = (C1998b) typeToken.c().getAnnotation(C1998b.class);
        if (bVar == null) {
            return null;
        }
        return b(this.f11535a, gson, typeToken, bVar);
    }

    /* access modifiers changed from: package-private */
    public TypeAdapter b(c cVar, Gson gson, TypeToken typeToken, C1998b bVar) {
        TypeAdapter typeAdapter;
        Object a5 = cVar.b(TypeToken.a(bVar.value())).a();
        boolean nullSafe = bVar.nullSafe();
        if (a5 instanceof TypeAdapter) {
            typeAdapter = (TypeAdapter) a5;
        } else if (a5 instanceof r) {
            typeAdapter = ((r) a5).a(gson, typeToken);
        } else {
            throw new IllegalArgumentException("Invalid attempt to bind an instance of " + a5.getClass().getName() + " as a @JsonAdapter for " + typeToken.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
        }
        if (typeAdapter == null || !nullSafe) {
            return typeAdapter;
        }
        return typeAdapter.a();
    }
}
