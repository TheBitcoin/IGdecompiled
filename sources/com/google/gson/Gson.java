package com.google.gson;

import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.NumberTypeAdapter;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.SerializationDelegatingTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.internal.c;
import com.google.gson.internal.f;
import com.google.gson.internal.l;
import com.google.gson.internal.sql.a;
import com.google.gson.reflect.TypeToken;
import i1.C2079a;
import i1.C2080b;
import i1.C2081c;
import i1.C2082d;
import j$.util.DesugarCollections;
import j$.util.Objects;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

public final class Gson {

    /* renamed from: A  reason: collision with root package name */
    static final c f11456A = b.IDENTITY;

    /* renamed from: B  reason: collision with root package name */
    static final q f11457B = p.DOUBLE;

    /* renamed from: C  reason: collision with root package name */
    static final q f11458C = p.LAZILY_PARSED_NUMBER;

    /* renamed from: z  reason: collision with root package name */
    static final String f11459z = null;

    /* renamed from: a  reason: collision with root package name */
    private final ThreadLocal f11460a;

    /* renamed from: b  reason: collision with root package name */
    private final ConcurrentMap f11461b;

    /* renamed from: c  reason: collision with root package name */
    private final c f11462c;

    /* renamed from: d  reason: collision with root package name */
    private final JsonAdapterAnnotationTypeAdapterFactory f11463d;

    /* renamed from: e  reason: collision with root package name */
    final List f11464e;

    /* renamed from: f  reason: collision with root package name */
    final Excluder f11465f;

    /* renamed from: g  reason: collision with root package name */
    final c f11466g;

    /* renamed from: h  reason: collision with root package name */
    final Map f11467h;

    /* renamed from: i  reason: collision with root package name */
    final boolean f11468i;

    /* renamed from: j  reason: collision with root package name */
    final boolean f11469j;

    /* renamed from: k  reason: collision with root package name */
    final boolean f11470k;

    /* renamed from: l  reason: collision with root package name */
    final boolean f11471l;

    /* renamed from: m  reason: collision with root package name */
    final boolean f11472m;

    /* renamed from: n  reason: collision with root package name */
    final boolean f11473n;

    /* renamed from: o  reason: collision with root package name */
    final boolean f11474o;

    /* renamed from: p  reason: collision with root package name */
    final boolean f11475p;

    /* renamed from: q  reason: collision with root package name */
    final String f11476q;

    /* renamed from: r  reason: collision with root package name */
    final int f11477r;

    /* renamed from: s  reason: collision with root package name */
    final int f11478s;

    /* renamed from: t  reason: collision with root package name */
    final n f11479t;

    /* renamed from: u  reason: collision with root package name */
    final List f11480u;

    /* renamed from: v  reason: collision with root package name */
    final List f11481v;

    /* renamed from: w  reason: collision with root package name */
    final q f11482w;

    /* renamed from: x  reason: collision with root package name */
    final q f11483x;

    /* renamed from: y  reason: collision with root package name */
    final List f11484y;

    static class FutureTypeAdapter<T> extends SerializationDelegatingTypeAdapter<T> {

        /* renamed from: a  reason: collision with root package name */
        private TypeAdapter f11489a = null;

        FutureTypeAdapter() {
        }

        private TypeAdapter f() {
            TypeAdapter typeAdapter = this.f11489a;
            if (typeAdapter != null) {
                return typeAdapter;
            }
            throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
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

        public void g(TypeAdapter typeAdapter) {
            if (this.f11489a == null) {
                this.f11489a = typeAdapter;
                return;
            }
            throw new AssertionError("Delegate is already set");
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Gson() {
        /*
            r22 = this;
            com.google.gson.internal.Excluder r1 = com.google.gson.internal.Excluder.f11503g
            com.google.gson.c r2 = f11456A
            java.util.Map r3 = java.util.Collections.EMPTY_MAP
            com.google.gson.n r12 = com.google.gson.n.DEFAULT
            java.lang.String r13 = f11459z
            java.util.List r16 = java.util.Collections.EMPTY_LIST
            com.google.gson.q r19 = f11457B
            com.google.gson.q r20 = f11458C
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 1
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 1
            r14 = 2
            r15 = 2
            r17 = r16
            r18 = r16
            r21 = r16
            r0 = r22
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.Gson.<init>():void");
    }

    private static void a(Object obj, C2079a aVar) {
        if (obj != null) {
            try {
                if (aVar.L() != C2080b.END_DOCUMENT) {
                    throw new m("JSON document was not fully consumed.");
                }
            } catch (C2082d e5) {
                throw new m((Throwable) e5);
            } catch (IOException e6) {
                throw new g((Throwable) e6);
            }
        }
    }

    private static TypeAdapter b(final TypeAdapter typeAdapter) {
        return new TypeAdapter() {
            /* renamed from: e */
            public AtomicLong b(C2079a aVar) {
                return new AtomicLong(((Number) TypeAdapter.this.b(aVar)).longValue());
            }

            /* renamed from: f */
            public void d(C2081c cVar, AtomicLong atomicLong) {
                TypeAdapter.this.d(cVar, Long.valueOf(atomicLong.get()));
            }
        }.a();
    }

    private static TypeAdapter c(final TypeAdapter typeAdapter) {
        return new TypeAdapter() {
            /* renamed from: e */
            public AtomicLongArray b(C2079a aVar) {
                ArrayList arrayList = new ArrayList();
                aVar.a();
                while (aVar.u()) {
                    arrayList.add(Long.valueOf(((Number) TypeAdapter.this.b(aVar)).longValue()));
                }
                aVar.l();
                int size = arrayList.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(size);
                for (int i4 = 0; i4 < size; i4++) {
                    atomicLongArray.set(i4, ((Long) arrayList.get(i4)).longValue());
                }
                return atomicLongArray;
            }

            /* renamed from: f */
            public void d(C2081c cVar, AtomicLongArray atomicLongArray) {
                cVar.g();
                int length = atomicLongArray.length();
                for (int i4 = 0; i4 < length; i4++) {
                    TypeAdapter.this.d(cVar, Long.valueOf(atomicLongArray.get(i4)));
                }
                cVar.l();
            }
        }.a();
    }

    static void d(double d5) {
        if (Double.isNaN(d5) || Double.isInfinite(d5)) {
            throw new IllegalArgumentException(d5 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private TypeAdapter e(boolean z4) {
        if (z4) {
            return TypeAdapters.f11634v;
        }
        return new TypeAdapter() {
            /* renamed from: e */
            public Double b(C2079a aVar) {
                if (aVar.L() != C2080b.NULL) {
                    return Double.valueOf(aVar.A());
                }
                aVar.H();
                return null;
            }

            /* renamed from: f */
            public void d(C2081c cVar, Number number) {
                if (number == null) {
                    cVar.x();
                    return;
                }
                double doubleValue = number.doubleValue();
                Gson.d(doubleValue);
                cVar.K(doubleValue);
            }
        };
    }

    private TypeAdapter f(boolean z4) {
        if (z4) {
            return TypeAdapters.f11633u;
        }
        return new TypeAdapter() {
            /* renamed from: e */
            public Float b(C2079a aVar) {
                if (aVar.L() != C2080b.NULL) {
                    return Float.valueOf((float) aVar.A());
                }
                aVar.H();
                return null;
            }

            /* renamed from: f */
            public void d(C2081c cVar, Number number) {
                if (number == null) {
                    cVar.x();
                    return;
                }
                float floatValue = number.floatValue();
                Gson.d((double) floatValue);
                if (!(number instanceof Float)) {
                    number = Float.valueOf(floatValue);
                }
                cVar.N(number);
            }
        };
    }

    private static TypeAdapter n(n nVar) {
        if (nVar == n.DEFAULT) {
            return TypeAdapters.f11632t;
        }
        return new TypeAdapter() {
            /* renamed from: e */
            public Number b(C2079a aVar) {
                if (aVar.L() != C2080b.NULL) {
                    return Long.valueOf(aVar.E());
                }
                aVar.H();
                return null;
            }

            /* renamed from: f */
            public void d(C2081c cVar, Number number) {
                if (number == null) {
                    cVar.x();
                } else {
                    cVar.O(number.toString());
                }
            }
        };
    }

    public Object g(C2079a aVar, TypeToken typeToken) {
        boolean v4 = aVar.v();
        aVar.Q(true);
        try {
            aVar.L();
            Object b5 = k(typeToken).b(aVar);
            aVar.Q(v4);
            return b5;
        } catch (EOFException e5) {
            if (1 != 0) {
                aVar.Q(v4);
                return null;
            }
            throw new m((Throwable) e5);
        } catch (IllegalStateException e6) {
            throw new m((Throwable) e6);
        } catch (IOException e7) {
            throw new m((Throwable) e7);
        } catch (AssertionError e8) {
            throw new AssertionError("AssertionError (GSON 2.10.1): " + e8.getMessage(), e8);
        } catch (Throwable th) {
            aVar.Q(v4);
            throw th;
        }
    }

    public Object h(Reader reader, TypeToken typeToken) {
        C2079a o4 = o(reader);
        Object g4 = g(o4, typeToken);
        a(g4, o4);
        return g4;
    }

    public Object i(String str, TypeToken typeToken) {
        if (str == null) {
            return null;
        }
        return h(new StringReader(str), typeToken);
    }

    public Object j(String str, Type type) {
        return i(str, TypeToken.b(type));
    }

    public TypeAdapter k(TypeToken typeToken) {
        boolean z4;
        Objects.requireNonNull(typeToken, "type must not be null");
        TypeAdapter typeAdapter = (TypeAdapter) this.f11461b.get(typeToken);
        if (typeAdapter != null) {
            return typeAdapter;
        }
        Map map = (Map) this.f11460a.get();
        if (map == null) {
            map = new HashMap();
            this.f11460a.set(map);
            z4 = true;
        } else {
            TypeAdapter typeAdapter2 = (TypeAdapter) map.get(typeToken);
            if (typeAdapter2 != null) {
                return typeAdapter2;
            }
            z4 = false;
        }
        try {
            FutureTypeAdapter futureTypeAdapter = new FutureTypeAdapter();
            map.put(typeToken, futureTypeAdapter);
            Iterator it = this.f11464e.iterator();
            TypeAdapter typeAdapter3 = null;
            while (true) {
                if (it.hasNext()) {
                    typeAdapter3 = ((r) it.next()).a(this, typeToken);
                    if (typeAdapter3 != null) {
                        futureTypeAdapter.g(typeAdapter3);
                        map.put(typeToken, typeAdapter3);
                        break;
                    }
                } else {
                    break;
                }
            }
            if (typeAdapter3 != null) {
                if (z4) {
                    this.f11461b.putAll(map);
                }
                return typeAdapter3;
            }
            throw new IllegalArgumentException("GSON (2.10.1) cannot handle " + typeToken);
        } finally {
            if (z4) {
                this.f11460a.remove();
            }
        }
    }

    public TypeAdapter l(Class cls) {
        return k(TypeToken.a(cls));
    }

    public TypeAdapter m(r rVar, TypeToken typeToken) {
        if (!this.f11464e.contains(rVar)) {
            rVar = this.f11463d;
        }
        boolean z4 = false;
        for (r rVar2 : this.f11464e) {
            if (z4) {
                TypeAdapter a5 = rVar2.a(this, typeToken);
                if (a5 != null) {
                    return a5;
                }
            } else if (rVar2 == rVar) {
                z4 = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + typeToken);
    }

    public C2079a o(Reader reader) {
        C2079a aVar = new C2079a(reader);
        aVar.Q(this.f11473n);
        return aVar;
    }

    public C2081c p(Writer writer) {
        if (this.f11470k) {
            writer.write(")]}'\n");
        }
        C2081c cVar = new C2081c(writer);
        if (this.f11472m) {
            cVar.G("  ");
        }
        cVar.F(this.f11471l);
        cVar.H(this.f11473n);
        cVar.I(this.f11468i);
        return cVar;
    }

    public String q(f fVar) {
        StringWriter stringWriter = new StringWriter();
        u(fVar, stringWriter);
        return stringWriter.toString();
    }

    public String r(Object obj) {
        if (obj == null) {
            return q(h.f11501a);
        }
        return s(obj, obj.getClass());
    }

    public String s(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        w(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public void t(f fVar, C2081c cVar) {
        boolean r4 = cVar.r();
        cVar.H(true);
        boolean p4 = cVar.p();
        cVar.F(this.f11471l);
        boolean o4 = cVar.o();
        cVar.I(this.f11468i);
        try {
            l.a(fVar, cVar);
            cVar.H(r4);
            cVar.F(p4);
            cVar.I(o4);
        } catch (IOException e5) {
            throw new g((Throwable) e5);
        } catch (AssertionError e6) {
            throw new AssertionError("AssertionError (GSON 2.10.1): " + e6.getMessage(), e6);
        } catch (Throwable th) {
            cVar.H(r4);
            cVar.F(p4);
            cVar.I(o4);
            throw th;
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.f11468i + ",factories:" + this.f11464e + ",instanceCreators:" + this.f11462c + "}";
    }

    public void u(f fVar, Appendable appendable) {
        try {
            t(fVar, p(l.b(appendable)));
        } catch (IOException e5) {
            throw new g((Throwable) e5);
        }
    }

    public void v(Object obj, Type type, C2081c cVar) {
        TypeAdapter k4 = k(TypeToken.b(type));
        boolean r4 = cVar.r();
        cVar.H(true);
        boolean p4 = cVar.p();
        cVar.F(this.f11471l);
        boolean o4 = cVar.o();
        cVar.I(this.f11468i);
        try {
            k4.d(cVar, obj);
            cVar.H(r4);
            cVar.F(p4);
            cVar.I(o4);
        } catch (IOException e5) {
            throw new g((Throwable) e5);
        } catch (AssertionError e6) {
            throw new AssertionError("AssertionError (GSON 2.10.1): " + e6.getMessage(), e6);
        } catch (Throwable th) {
            cVar.H(r4);
            cVar.F(p4);
            cVar.I(o4);
            throw th;
        }
    }

    public void w(Object obj, Type type, Appendable appendable) {
        try {
            v(obj, type, p(l.b(appendable)));
        } catch (IOException e5) {
            throw new g((Throwable) e5);
        }
    }

    Gson(Excluder excluder, c cVar, Map map, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, n nVar, String str, int i4, int i5, List list, List list2, List list3, q qVar, q qVar2, List list4) {
        boolean z12 = z10;
        boolean z13 = z11;
        List list5 = list4;
        this.f11460a = new ThreadLocal();
        this.f11461b = new ConcurrentHashMap();
        this.f11465f = excluder;
        this.f11466g = cVar;
        this.f11467h = map;
        c cVar2 = new c(map, z13, list5);
        this.f11462c = cVar2;
        this.f11468i = z4;
        this.f11469j = z5;
        this.f11470k = z6;
        this.f11471l = z7;
        this.f11472m = z8;
        this.f11473n = z9;
        this.f11474o = z12;
        this.f11475p = z13;
        n nVar2 = nVar;
        this.f11479t = nVar2;
        this.f11476q = str;
        this.f11477r = i4;
        this.f11478s = i5;
        this.f11480u = list;
        this.f11481v = list2;
        q qVar3 = qVar;
        this.f11482w = qVar3;
        q qVar4 = qVar2;
        this.f11483x = qVar4;
        this.f11484y = list5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(TypeAdapters.f11611W);
        arrayList.add(ObjectTypeAdapter.e(qVar3));
        arrayList.add(excluder);
        arrayList.addAll(list3);
        arrayList.add(TypeAdapters.f11591C);
        arrayList.add(TypeAdapters.f11625m);
        arrayList.add(TypeAdapters.f11619g);
        arrayList.add(TypeAdapters.f11621i);
        arrayList.add(TypeAdapters.f11623k);
        TypeAdapter n4 = n(nVar2);
        arrayList.add(TypeAdapters.b(Long.TYPE, Long.class, n4));
        TypeAdapter e5 = e(z12);
        arrayList.add(TypeAdapters.b(Double.TYPE, Double.class, e5));
        TypeAdapter f4 = f(z12);
        arrayList.add(TypeAdapters.b(Float.TYPE, Float.class, f4));
        arrayList.add(NumberTypeAdapter.e(qVar4));
        arrayList.add(TypeAdapters.f11627o);
        arrayList.add(TypeAdapters.f11629q);
        arrayList.add(TypeAdapters.a(AtomicLong.class, b(n4)));
        arrayList.add(TypeAdapters.a(AtomicLongArray.class, c(n4)));
        arrayList.add(TypeAdapters.f11631s);
        arrayList.add(TypeAdapters.f11636x);
        arrayList.add(TypeAdapters.f11593E);
        arrayList.add(TypeAdapters.f11595G);
        arrayList.add(TypeAdapters.a(BigDecimal.class, TypeAdapters.f11638z));
        arrayList.add(TypeAdapters.a(BigInteger.class, TypeAdapters.f11589A));
        arrayList.add(TypeAdapters.a(f.class, TypeAdapters.f11590B));
        arrayList.add(TypeAdapters.f11597I);
        arrayList.add(TypeAdapters.f11599K);
        arrayList.add(TypeAdapters.f11603O);
        arrayList.add(TypeAdapters.f11605Q);
        arrayList.add(TypeAdapters.f11609U);
        arrayList.add(TypeAdapters.f11601M);
        arrayList.add(TypeAdapters.f11616d);
        arrayList.add(DateTypeAdapter.f11529b);
        arrayList.add(TypeAdapters.f11607S);
        if (a.f11727a) {
            arrayList.add(a.f11731e);
            arrayList.add(a.f11730d);
            arrayList.add(a.f11732f);
        }
        arrayList.add(ArrayTypeAdapter.f11523c);
        arrayList.add(TypeAdapters.f11614b);
        arrayList.add(new CollectionTypeAdapterFactory(cVar2));
        arrayList.add(new MapTypeAdapterFactory(cVar2, z5));
        JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory = new JsonAdapterAnnotationTypeAdapterFactory(cVar2);
        this.f11463d = jsonAdapterAnnotationTypeAdapterFactory;
        arrayList.add(jsonAdapterAnnotationTypeAdapterFactory);
        arrayList.add(TypeAdapters.f11612X);
        c cVar3 = cVar2;
        arrayList.add(new ReflectiveTypeAdapterFactory(cVar3, cVar, excluder, jsonAdapterAnnotationTypeAdapterFactory, list5));
        this.f11464e = DesugarCollections.unmodifiableList(arrayList);
    }
}
