package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.e;
import com.google.gson.l;
import com.google.gson.r;
import com.google.gson.reflect.TypeToken;
import i1.C2079a;
import i1.C2081c;

public final class TreeTypeAdapter<T> extends SerializationDelegatingTypeAdapter<T> {

    /* renamed from: a  reason: collision with root package name */
    final Gson f11576a;

    /* renamed from: b  reason: collision with root package name */
    private final TypeToken f11577b;

    /* renamed from: c  reason: collision with root package name */
    private final r f11578c;

    /* renamed from: d  reason: collision with root package name */
    private final b f11579d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f11580e;

    /* renamed from: f  reason: collision with root package name */
    private volatile TypeAdapter f11581f;

    private static final class SingleTypeFactory implements r {

        /* renamed from: a  reason: collision with root package name */
        private final TypeToken f11582a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f11583b;

        /* renamed from: c  reason: collision with root package name */
        private final Class f11584c;

        public TypeAdapter a(Gson gson, TypeToken typeToken) {
            boolean z4;
            TypeToken typeToken2 = this.f11582a;
            if (typeToken2 == null) {
                z4 = this.f11584c.isAssignableFrom(typeToken.c());
            } else if (typeToken2.equals(typeToken) || (this.f11583b && this.f11582a.d() == typeToken.c())) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (!z4) {
                return null;
            }
            return new TreeTypeAdapter((l) null, (e) null, gson, typeToken, this);
        }
    }

    private final class b {
        private b() {
        }
    }

    public TreeTypeAdapter(l lVar, e eVar, Gson gson, TypeToken typeToken, r rVar, boolean z4) {
        this.f11579d = new b();
        this.f11576a = gson;
        this.f11577b = typeToken;
        this.f11578c = rVar;
        this.f11580e = z4;
    }

    private TypeAdapter f() {
        TypeAdapter typeAdapter = this.f11581f;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        TypeAdapter m4 = this.f11576a.m(this.f11578c, this.f11577b);
        this.f11581f = m4;
        return m4;
    }

    public Object b(C2079a aVar) {
        return f().b(aVar);
    }

    public void d(C2081c cVar, Object obj) {
        f().d(cVar, obj);
    }

    public TypeAdapter e() {
        return f();
    }

    public TreeTypeAdapter(l lVar, e eVar, Gson gson, TypeToken typeToken, r rVar) {
        this(lVar, eVar, gson, typeToken, rVar, true);
    }
}
