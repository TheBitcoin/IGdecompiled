package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.b;
import com.google.gson.r;
import com.google.gson.reflect.TypeToken;
import i1.C2079a;
import i1.C2080b;
import i1.C2081c;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

public final class ArrayTypeAdapter<E> extends TypeAdapter {

    /* renamed from: c  reason: collision with root package name */
    public static final r f11523c = new r() {
        public TypeAdapter a(Gson gson, TypeToken typeToken) {
            Type d5 = typeToken.d();
            if (!(d5 instanceof GenericArrayType) && (!(d5 instanceof Class) || !((Class) d5).isArray())) {
                return null;
            }
            Type g4 = b.g(d5);
            return new ArrayTypeAdapter(gson, gson.k(TypeToken.b(g4)), b.k(g4));
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final Class f11524a;

    /* renamed from: b  reason: collision with root package name */
    private final TypeAdapter f11525b;

    public ArrayTypeAdapter(Gson gson, TypeAdapter typeAdapter, Class cls) {
        this.f11525b = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, cls);
        this.f11524a = cls;
    }

    public Object b(C2079a aVar) {
        if (aVar.L() == C2080b.NULL) {
            aVar.H();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        aVar.a();
        while (aVar.u()) {
            arrayList.add(this.f11525b.b(aVar));
        }
        aVar.l();
        int size = arrayList.size();
        if (!this.f11524a.isPrimitive()) {
            return arrayList.toArray((Object[]) Array.newInstance(this.f11524a, size));
        }
        Object newInstance = Array.newInstance(this.f11524a, size);
        for (int i4 = 0; i4 < size; i4++) {
            Array.set(newInstance, i4, arrayList.get(i4));
        }
        return newInstance;
    }

    public void d(C2081c cVar, Object obj) {
        if (obj == null) {
            cVar.x();
            return;
        }
        cVar.g();
        int length = Array.getLength(obj);
        for (int i4 = 0; i4 < length; i4++) {
            this.f11525b.d(cVar, Array.get(obj, i4));
        }
        cVar.l();
    }
}
