package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.f;
import com.google.gson.internal.b;
import com.google.gson.internal.c;
import com.google.gson.internal.e;
import com.google.gson.internal.h;
import com.google.gson.internal.l;
import com.google.gson.k;
import com.google.gson.m;
import com.google.gson.r;
import com.google.gson.reflect.TypeToken;
import i1.C2079a;
import i1.C2080b;
import i1.C2081c;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

public final class MapTypeAdapterFactory implements r {

    /* renamed from: a  reason: collision with root package name */
    private final c f11536a;

    /* renamed from: b  reason: collision with root package name */
    final boolean f11537b;

    private final class Adapter<K, V> extends TypeAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final TypeAdapter f11538a;

        /* renamed from: b  reason: collision with root package name */
        private final TypeAdapter f11539b;

        /* renamed from: c  reason: collision with root package name */
        private final h f11540c;

        public Adapter(Gson gson, Type type, TypeAdapter typeAdapter, Type type2, TypeAdapter typeAdapter2, h hVar) {
            this.f11538a = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.f11539b = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter2, type2);
            this.f11540c = hVar;
        }

        private String e(f fVar) {
            if (fVar.m()) {
                k h4 = fVar.h();
                if (h4.s()) {
                    return String.valueOf(h4.o());
                }
                if (h4.q()) {
                    return Boolean.toString(h4.n());
                }
                if (h4.t()) {
                    return h4.p();
                }
                throw new AssertionError();
            } else if (fVar.k()) {
                return "null";
            } else {
                throw new AssertionError();
            }
        }

        /* renamed from: f */
        public Map b(C2079a aVar) {
            C2080b L4 = aVar.L();
            if (L4 == C2080b.NULL) {
                aVar.H();
                return null;
            }
            Map map = (Map) this.f11540c.a();
            if (L4 == C2080b.BEGIN_ARRAY) {
                aVar.a();
                while (aVar.u()) {
                    aVar.a();
                    Object b5 = this.f11538a.b(aVar);
                    if (map.put(b5, this.f11539b.b(aVar)) == null) {
                        aVar.l();
                    } else {
                        throw new m("duplicate key: " + b5);
                    }
                }
                aVar.l();
                return map;
            }
            aVar.d();
            while (aVar.u()) {
                e.f11681a.a(aVar);
                Object b6 = this.f11538a.b(aVar);
                if (map.put(b6, this.f11539b.b(aVar)) != null) {
                    throw new m("duplicate key: " + b6);
                }
            }
            aVar.n();
            return map;
        }

        /* renamed from: g */
        public void d(C2081c cVar, Map map) {
            boolean z4;
            if (map == null) {
                cVar.x();
            } else if (!MapTypeAdapterFactory.this.f11537b) {
                cVar.i();
                for (Map.Entry entry : map.entrySet()) {
                    cVar.v(String.valueOf(entry.getKey()));
                    this.f11539b.d(cVar, entry.getValue());
                }
                cVar.n();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                int i4 = 0;
                boolean z5 = false;
                for (Map.Entry entry2 : map.entrySet()) {
                    f c5 = this.f11538a.c(entry2.getKey());
                    arrayList.add(c5);
                    arrayList2.add(entry2.getValue());
                    if (c5.j() || c5.l()) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    z5 |= z4;
                }
                if (z5) {
                    cVar.g();
                    int size = arrayList.size();
                    while (i4 < size) {
                        cVar.g();
                        l.a((f) arrayList.get(i4), cVar);
                        this.f11539b.d(cVar, arrayList2.get(i4));
                        cVar.l();
                        i4++;
                    }
                    cVar.l();
                    return;
                }
                cVar.i();
                int size2 = arrayList.size();
                while (i4 < size2) {
                    cVar.v(e((f) arrayList.get(i4)));
                    this.f11539b.d(cVar, arrayList2.get(i4));
                    i4++;
                }
                cVar.n();
            }
        }
    }

    public MapTypeAdapterFactory(c cVar, boolean z4) {
        this.f11536a = cVar;
        this.f11537b = z4;
    }

    private TypeAdapter b(Gson gson, Type type) {
        if (type == Boolean.TYPE || type == Boolean.class) {
            return TypeAdapters.f11618f;
        }
        return gson.k(TypeToken.b(type));
    }

    public TypeAdapter a(Gson gson, TypeToken typeToken) {
        Type d5 = typeToken.d();
        Class c5 = typeToken.c();
        if (!Map.class.isAssignableFrom(c5)) {
            return null;
        }
        Type[] j4 = b.j(d5, c5);
        return new Adapter(gson, j4[0], b(gson, j4[0]), j4[1], gson.k(TypeToken.b(j4[1])), this.f11536a.b(typeToken));
    }
}
