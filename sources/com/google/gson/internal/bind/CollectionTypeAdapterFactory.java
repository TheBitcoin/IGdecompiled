package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.b;
import com.google.gson.internal.c;
import com.google.gson.internal.h;
import com.google.gson.r;
import com.google.gson.reflect.TypeToken;
import i1.C2079a;
import i1.C2080b;
import i1.C2081c;
import java.lang.reflect.Type;
import java.util.Collection;

public final class CollectionTypeAdapterFactory implements r {

    /* renamed from: a  reason: collision with root package name */
    private final c f11526a;

    private static final class Adapter<E> extends TypeAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final TypeAdapter f11527a;

        /* renamed from: b  reason: collision with root package name */
        private final h f11528b;

        public Adapter(Gson gson, Type type, TypeAdapter typeAdapter, h hVar) {
            this.f11527a = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.f11528b = hVar;
        }

        /* renamed from: e */
        public Collection b(C2079a aVar) {
            if (aVar.L() == C2080b.NULL) {
                aVar.H();
                return null;
            }
            Collection collection = (Collection) this.f11528b.a();
            aVar.a();
            while (aVar.u()) {
                collection.add(this.f11527a.b(aVar));
            }
            aVar.l();
            return collection;
        }

        /* renamed from: f */
        public void d(C2081c cVar, Collection collection) {
            if (collection == null) {
                cVar.x();
                return;
            }
            cVar.g();
            for (Object d5 : collection) {
                this.f11527a.d(cVar, d5);
            }
            cVar.l();
        }
    }

    public CollectionTypeAdapterFactory(c cVar) {
        this.f11526a = cVar;
    }

    public TypeAdapter a(Gson gson, TypeToken typeToken) {
        Type d5 = typeToken.d();
        Class c5 = typeToken.c();
        if (!Collection.class.isAssignableFrom(c5)) {
            return null;
        }
        Type h4 = b.h(d5, c5);
        return new Adapter(gson, h4, gson.k(TypeToken.b(h4)), this.f11526a.b(typeToken));
    }
}
