package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.g;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.c;
import com.google.gson.internal.h;
import com.google.gson.internal.k;
import com.google.gson.j;
import com.google.gson.m;
import com.google.gson.o;
import com.google.gson.r;
import com.google.gson.reflect.TypeToken;
import f1.C1998b;
import f1.C1999c;
import h1.C2068a;
import i1.C2079a;
import i1.C2080b;
import i1.C2081c;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class ReflectiveTypeAdapterFactory implements r {

    /* renamed from: a  reason: collision with root package name */
    private final c f11551a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.gson.c f11552b;

    /* renamed from: c  reason: collision with root package name */
    private final Excluder f11553c;

    /* renamed from: d  reason: collision with root package name */
    private final JsonAdapterAnnotationTypeAdapterFactory f11554d;

    /* renamed from: e  reason: collision with root package name */
    private final List f11555e;

    public static abstract class Adapter<T, A> extends TypeAdapter {

        /* renamed from: a  reason: collision with root package name */
        final Map f11556a;

        Adapter(Map map) {
            this.f11556a = map;
        }

        public Object b(C2079a aVar) {
            if (aVar.L() == C2080b.NULL) {
                aVar.H();
                return null;
            }
            Object e5 = e();
            try {
                aVar.d();
                while (aVar.u()) {
                    b bVar = (b) this.f11556a.get(aVar.F());
                    if (bVar != null) {
                        if (bVar.f11575e) {
                            g(e5, aVar, bVar);
                        }
                    }
                    aVar.V();
                }
                aVar.n();
                return f(e5);
            } catch (IllegalStateException e6) {
                throw new m((Throwable) e6);
            } catch (IllegalAccessException e7) {
                throw C2068a.e(e7);
            }
        }

        public void d(C2081c cVar, Object obj) {
            if (obj == null) {
                cVar.x();
                return;
            }
            cVar.i();
            try {
                for (b c5 : this.f11556a.values()) {
                    c5.c(cVar, obj);
                }
                cVar.n();
            } catch (IllegalAccessException e5) {
                throw C2068a.e(e5);
            }
        }

        /* access modifiers changed from: package-private */
        public abstract Object e();

        /* access modifiers changed from: package-private */
        public abstract Object f(Object obj);

        /* access modifiers changed from: package-private */
        public abstract void g(Object obj, C2079a aVar, b bVar);
    }

    private static final class FieldReflectionAdapter<T> extends Adapter<T, T> {

        /* renamed from: b  reason: collision with root package name */
        private final h f11557b;

        FieldReflectionAdapter(h hVar, Map map) {
            super(map);
            this.f11557b = hVar;
        }

        /* access modifiers changed from: package-private */
        public Object e() {
            return this.f11557b.a();
        }

        /* access modifiers changed from: package-private */
        public Object f(Object obj) {
            return obj;
        }

        /* access modifiers changed from: package-private */
        public void g(Object obj, C2079a aVar, b bVar) {
            bVar.b(aVar, obj);
        }
    }

    private static final class RecordAdapter<T> extends Adapter<T, Object[]> {

        /* renamed from: e  reason: collision with root package name */
        static final Map f11558e = j();

        /* renamed from: b  reason: collision with root package name */
        private final Constructor f11559b;

        /* renamed from: c  reason: collision with root package name */
        private final Object[] f11560c;

        /* renamed from: d  reason: collision with root package name */
        private final Map f11561d = new HashMap();

        RecordAdapter(Class cls, Map map, boolean z4) {
            super(map);
            Constructor i4 = C2068a.i(cls);
            this.f11559b = i4;
            if (z4) {
                ReflectiveTypeAdapterFactory.c((Object) null, i4);
            } else {
                C2068a.l(i4);
            }
            String[] j4 = C2068a.j(cls);
            for (int i5 = 0; i5 < j4.length; i5++) {
                this.f11561d.put(j4[i5], Integer.valueOf(i5));
            }
            Class[] parameterTypes = this.f11559b.getParameterTypes();
            this.f11560c = new Object[parameterTypes.length];
            for (int i6 = 0; i6 < parameterTypes.length; i6++) {
                this.f11560c[i6] = f11558e.get(parameterTypes[i6]);
            }
        }

        private static Map j() {
            HashMap hashMap = new HashMap();
            hashMap.put(Byte.TYPE, (byte) 0);
            hashMap.put(Short.TYPE, (short) 0);
            hashMap.put(Integer.TYPE, 0);
            hashMap.put(Long.TYPE, 0L);
            hashMap.put(Float.TYPE, Float.valueOf(0.0f));
            hashMap.put(Double.TYPE, Double.valueOf(0.0d));
            hashMap.put(Character.TYPE, 0);
            hashMap.put(Boolean.TYPE, Boolean.FALSE);
            return hashMap;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public Object[] e() {
            return (Object[]) this.f11560c.clone();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public Object f(Object[] objArr) {
            try {
                return this.f11559b.newInstance(objArr);
            } catch (IllegalAccessException e5) {
                throw C2068a.e(e5);
            } catch (IllegalArgumentException | InstantiationException e6) {
                throw new RuntimeException("Failed to invoke constructor '" + C2068a.c(this.f11559b) + "' with args " + Arrays.toString(objArr), e6);
            } catch (InvocationTargetException e7) {
                throw new RuntimeException("Failed to invoke constructor '" + C2068a.c(this.f11559b) + "' with args " + Arrays.toString(objArr), e7.getCause());
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: k */
        public void g(Object[] objArr, C2079a aVar, b bVar) {
            Integer num = (Integer) this.f11561d.get(bVar.f11573c);
            if (num != null) {
                bVar.a(aVar, num.intValue(), objArr);
                return;
            }
            throw new IllegalStateException("Could not find the index in the constructor '" + C2068a.c(this.f11559b) + "' for field with name '" + bVar.f11573c + "', unable to determine which argument in the constructor the field corresponds to. This is unexpected behavior, as we expect the RecordComponents to have the same names as the fields in the Java class, and that the order of the RecordComponents is the same as the order of the canonical constructor parameters.");
        }
    }

    class a extends b {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ boolean f11562f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ Method f11563g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ boolean f11564h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ TypeAdapter f11565i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ Gson f11566j;

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ TypeToken f11567k;

        /* renamed from: l  reason: collision with root package name */
        final /* synthetic */ boolean f11568l;

        /* renamed from: m  reason: collision with root package name */
        final /* synthetic */ boolean f11569m;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(String str, Field field, boolean z4, boolean z5, boolean z6, Method method, boolean z7, TypeAdapter typeAdapter, Gson gson, TypeToken typeToken, boolean z8, boolean z9) {
            super(str, field, z4, z5);
            this.f11562f = z6;
            this.f11563g = method;
            this.f11564h = z7;
            this.f11565i = typeAdapter;
            this.f11566j = gson;
            this.f11567k = typeToken;
            this.f11568l = z8;
            this.f11569m = z9;
        }

        /* access modifiers changed from: package-private */
        public void a(C2079a aVar, int i4, Object[] objArr) {
            Object b5 = this.f11565i.b(aVar);
            if (b5 != null || !this.f11568l) {
                objArr[i4] = b5;
                return;
            }
            throw new j("null is not allowed as value for record component '" + this.f11573c + "' of primitive type; at path " + aVar.getPath());
        }

        /* access modifiers changed from: package-private */
        public void b(C2079a aVar, Object obj) {
            Object b5 = this.f11565i.b(aVar);
            if (b5 != null || !this.f11568l) {
                if (this.f11562f) {
                    ReflectiveTypeAdapterFactory.c(obj, this.f11572b);
                } else if (this.f11569m) {
                    String g4 = C2068a.g(this.f11572b, false);
                    throw new g("Cannot set value of 'static final' " + g4);
                }
                this.f11572b.set(obj, b5);
            }
        }

        /* access modifiers changed from: package-private */
        public void c(C2081c cVar, Object obj) {
            Object obj2;
            TypeAdapter typeAdapter;
            if (this.f11574d) {
                if (this.f11562f) {
                    Method method = this.f11563g;
                    if (method == null) {
                        ReflectiveTypeAdapterFactory.c(obj, this.f11572b);
                    } else {
                        ReflectiveTypeAdapterFactory.c(obj, method);
                    }
                }
                Method method2 = this.f11563g;
                if (method2 != null) {
                    try {
                        obj2 = method2.invoke(obj, (Object[]) null);
                    } catch (InvocationTargetException e5) {
                        String g4 = C2068a.g(this.f11563g, false);
                        throw new g("Accessor " + g4 + " threw exception", e5.getCause());
                    }
                } else {
                    obj2 = this.f11572b.get(obj);
                }
                if (obj2 != obj) {
                    cVar.v(this.f11571a);
                    if (this.f11564h) {
                        typeAdapter = this.f11565i;
                    } else {
                        typeAdapter = new TypeAdapterRuntimeTypeWrapper(this.f11566j, this.f11565i, this.f11567k.d());
                    }
                    typeAdapter.d(cVar, obj2);
                }
            }
        }
    }

    static abstract class b {

        /* renamed from: a  reason: collision with root package name */
        final String f11571a;

        /* renamed from: b  reason: collision with root package name */
        final Field f11572b;

        /* renamed from: c  reason: collision with root package name */
        final String f11573c;

        /* renamed from: d  reason: collision with root package name */
        final boolean f11574d;

        /* renamed from: e  reason: collision with root package name */
        final boolean f11575e;

        protected b(String str, Field field, boolean z4, boolean z5) {
            this.f11571a = str;
            this.f11572b = field;
            this.f11573c = field.getName();
            this.f11574d = z4;
            this.f11575e = z5;
        }

        /* access modifiers changed from: package-private */
        public abstract void a(C2079a aVar, int i4, Object[] objArr);

        /* access modifiers changed from: package-private */
        public abstract void b(C2079a aVar, Object obj);

        /* access modifiers changed from: package-private */
        public abstract void c(C2081c cVar, Object obj);
    }

    public ReflectiveTypeAdapterFactory(c cVar, com.google.gson.c cVar2, Excluder excluder, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory, List list) {
        this.f11551a = cVar;
        this.f11552b = cVar2;
        this.f11553c = excluder;
        this.f11554d = jsonAdapterAnnotationTypeAdapterFactory;
        this.f11555e = list;
    }

    /* access modifiers changed from: private */
    public static void c(Object obj, AccessibleObject accessibleObject) {
        if (Modifier.isStatic(((Member) accessibleObject).getModifiers())) {
            obj = null;
        }
        if (!k.a(accessibleObject, obj)) {
            String g4 = C2068a.g(accessibleObject, true);
            throw new g(g4 + " is not accessible and ReflectionAccessFilter does not permit making it accessible. Register a TypeAdapter for the declaring type, adjust the access filter or increase the visibility of the element and its declaring type.");
        }
    }

    private b d(Gson gson, Field field, Method method, String str, TypeToken typeToken, boolean z4, boolean z5, boolean z6) {
        boolean z7;
        TypeAdapter typeAdapter;
        boolean z8;
        TypeToken typeToken2 = typeToken;
        boolean a5 = com.google.gson.internal.j.a(typeToken2.c());
        int modifiers = field.getModifiers();
        if (!Modifier.isStatic(modifiers) || !Modifier.isFinal(modifiers)) {
            z7 = false;
        } else {
            z7 = true;
        }
        Field field2 = field;
        C1998b bVar = (C1998b) field2.getAnnotation(C1998b.class);
        if (bVar != null) {
            typeAdapter = this.f11554d.b(this.f11551a, gson, typeToken2, bVar);
        } else {
            typeAdapter = null;
        }
        if (typeAdapter != null) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (typeAdapter == null) {
            typeAdapter = gson.k(typeToken2);
        }
        Field field3 = field2;
        return new a(str, field3, z4, z5, z6, method, z8, typeAdapter, gson, typeToken2, a5, z7);
    }

    private Map e(Gson gson, TypeToken typeToken, Class cls, boolean z4, boolean z5) {
        TypeToken typeToken2;
        int i4;
        int i5;
        boolean z6;
        int i6;
        Method method;
        ReflectiveTypeAdapterFactory reflectiveTypeAdapterFactory = this;
        Class cls2 = cls;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (!cls2.isInterface()) {
            TypeToken typeToken3 = typeToken;
            boolean z7 = z4;
            Class cls3 = cls2;
            while (cls3 != Object.class) {
                Field[] declaredFields = cls3.getDeclaredFields();
                boolean z8 = true;
                boolean z9 = false;
                if (cls3 != cls2 && declaredFields.length > 0) {
                    o b5 = k.b(reflectiveTypeAdapterFactory.f11555e, cls3);
                    if (b5 == o.BLOCK_ALL) {
                        throw new g("ReflectionAccessFilter does not permit using reflection for " + cls3 + " (supertype of " + cls2 + "). Register a TypeAdapter for this type or adjust the access filter.");
                    } else if (b5 == o.BLOCK_INACCESSIBLE) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                }
                boolean z10 = z7;
                int length = declaredFields.length;
                int i7 = 0;
                while (i7 < length) {
                    int i8 = i7;
                    Field field = declaredFields[i8];
                    boolean g4 = reflectiveTypeAdapterFactory.g(field, z8);
                    boolean g5 = reflectiveTypeAdapterFactory.g(field, z9);
                    if (g4 || g5) {
                        if (!z5) {
                            z6 = g5;
                            i6 = i8;
                            method = null;
                        } else if (Modifier.isStatic(field.getModifiers())) {
                            i6 = i8;
                            method = null;
                            z6 = false;
                        } else {
                            Method h4 = C2068a.h(cls3, field);
                            if (!z10) {
                                C2068a.l(h4);
                            }
                            Class cls4 = C1999c.class;
                            if (h4.getAnnotation(cls4) == null || field.getAnnotation(cls4) != null) {
                                boolean z11 = g5;
                                i6 = i8;
                                method = h4;
                                z6 = z11;
                            } else {
                                String g6 = C2068a.g(h4, z9);
                                throw new g("@SerializedName on " + g6 + " is not supported");
                            }
                        }
                        if (!z10 && method == null) {
                            C2068a.l(field);
                        }
                        Type o4 = com.google.gson.internal.b.o(typeToken3.d(), cls3, field.getGenericType());
                        List f4 = reflectiveTypeAdapterFactory.f(field);
                        int size = f4.size();
                        typeToken2 = typeToken3;
                        b bVar = null;
                        int i9 = 0;
                        while (i9 < size) {
                            String str = (String) f4.get(i9);
                            if (i9 != 0) {
                                g4 = false;
                            }
                            int i10 = i6;
                            List list = f4;
                            boolean z12 = g4;
                            String str2 = str;
                            int i11 = length;
                            b bVar2 = (b) linkedHashMap.put(str2, reflectiveTypeAdapterFactory.d(gson, field, method, str2, TypeToken.b(o4), z12, z6, z10));
                            if (bVar == null) {
                                bVar = bVar2;
                            }
                            i9++;
                            reflectiveTypeAdapterFactory = this;
                            g4 = z12;
                            length = i11;
                            i6 = i10;
                            f4 = list;
                        }
                        i5 = length;
                        i4 = i6;
                        if (bVar != null) {
                            throw new IllegalArgumentException("Class " + cls.getName() + " declares multiple JSON fields named '" + bVar.f11571a + "'; conflict is caused by fields " + C2068a.f(bVar.f11572b) + " and " + C2068a.f(field));
                        }
                    } else {
                        i5 = length;
                        i4 = i8;
                        typeToken2 = typeToken3;
                    }
                    i7 = i4 + 1;
                    reflectiveTypeAdapterFactory = this;
                    typeToken3 = typeToken2;
                    Class cls5 = cls;
                    length = i5;
                    z8 = true;
                    z9 = false;
                }
                typeToken3 = TypeToken.b(com.google.gson.internal.b.o(typeToken3.d(), cls3, cls3.getGenericSuperclass()));
                cls3 = typeToken3.c();
                reflectiveTypeAdapterFactory = this;
                cls2 = cls;
                z7 = z10;
            }
        }
        return linkedHashMap;
    }

    private List f(Field field) {
        C1999c cVar = (C1999c) field.getAnnotation(C1999c.class);
        if (cVar == null) {
            return Collections.singletonList(this.f11552b.a(field));
        }
        String value = cVar.value();
        String[] alternate = cVar.alternate();
        if (alternate.length == 0) {
            return Collections.singletonList(value);
        }
        ArrayList arrayList = new ArrayList(alternate.length + 1);
        arrayList.add(value);
        Collections.addAll(arrayList, alternate);
        return arrayList;
    }

    private boolean g(Field field, boolean z4) {
        if (this.f11553c.c(field.getType(), z4) || this.f11553c.f(field, z4)) {
            return false;
        }
        return true;
    }

    public TypeAdapter a(Gson gson, TypeToken typeToken) {
        boolean z4;
        Class c5 = typeToken.c();
        if (!Object.class.isAssignableFrom(c5)) {
            return null;
        }
        o b5 = k.b(this.f11555e, c5);
        if (b5 != o.BLOCK_ALL) {
            if (b5 == o.BLOCK_INACCESSIBLE) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (C2068a.k(c5)) {
                return new RecordAdapter(c5, e(gson, typeToken, c5, z4, true), z4);
            }
            TypeToken typeToken2 = typeToken;
            return new FieldReflectionAdapter(this.f11551a.b(typeToken2), e(gson, typeToken2, c5, z4, false));
        }
        throw new g("ReflectionAccessFilter does not permit using reflection for " + c5 + ". Register a TypeAdapter for this type or adjust the access filter.");
    }
}
