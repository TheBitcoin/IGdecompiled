package com.google.gson.internal;

import com.google.gson.reflect.TypeToken;
import h1.C2068a;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final Map f11664a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f11665b;

    /* renamed from: c  reason: collision with root package name */
    private final List f11666c;

    class a implements h {
        a() {
        }

        public Object a() {
            return new TreeSet();
        }
    }

    class b implements h {
        b() {
        }

        public Object a() {
            return new LinkedHashSet();
        }
    }

    /* renamed from: com.google.gson.internal.c$c  reason: collision with other inner class name */
    class C0170c implements h {
        C0170c() {
        }

        public Object a() {
            return new ArrayDeque();
        }
    }

    class d implements h {
        d() {
        }

        public Object a() {
            return new ArrayList();
        }
    }

    class e implements h {
        e() {
        }

        public Object a() {
            return new ConcurrentSkipListMap();
        }
    }

    class f implements h {
        f() {
        }

        public Object a() {
            return new ConcurrentHashMap();
        }
    }

    class g implements h {
        g() {
        }

        public Object a() {
            return new TreeMap();
        }
    }

    class h implements h {
        h() {
        }

        public Object a() {
            return new LinkedHashMap();
        }
    }

    class i implements h {
        i() {
        }

        public Object a() {
            return new g();
        }
    }

    class j implements h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Class f11667a;

        j(Class cls) {
            this.f11667a = cls;
        }

        public Object a() {
            try {
                return m.f11715a.d(this.f11667a);
            } catch (Exception e5) {
                throw new RuntimeException("Unable to create instance of " + this.f11667a + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e5);
            }
        }
    }

    class k implements h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f11669a;

        k(String str) {
            this.f11669a = str;
        }

        public Object a() {
            throw new com.google.gson.g(this.f11669a);
        }
    }

    class l implements h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f11671a;

        l(String str) {
            this.f11671a = str;
        }

        public Object a() {
            throw new com.google.gson.g(this.f11671a);
        }
    }

    class m implements h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f11673a;

        m(String str) {
            this.f11673a = str;
        }

        public Object a() {
            throw new com.google.gson.g(this.f11673a);
        }
    }

    class n implements h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Type f11675a;

        n(Type type) {
            this.f11675a = type;
        }

        public Object a() {
            Type type = this.f11675a;
            if (type instanceof ParameterizedType) {
                Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                if (type2 instanceof Class) {
                    return EnumSet.noneOf((Class) type2);
                }
                throw new com.google.gson.g("Invalid EnumSet type: " + this.f11675a.toString());
            }
            throw new com.google.gson.g("Invalid EnumSet type: " + this.f11675a.toString());
        }
    }

    class o implements h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Type f11676a;

        o(Type type) {
            this.f11676a = type;
        }

        public Object a() {
            Type type = this.f11676a;
            if (type instanceof ParameterizedType) {
                Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                if (type2 instanceof Class) {
                    return new EnumMap((Class) type2);
                }
                throw new com.google.gson.g("Invalid EnumMap type: " + this.f11676a.toString());
            }
            throw new com.google.gson.g("Invalid EnumMap type: " + this.f11676a.toString());
        }
    }

    class p implements h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f11677a;

        p(String str) {
            this.f11677a = str;
        }

        public Object a() {
            throw new com.google.gson.g(this.f11677a);
        }
    }

    class q implements h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f11678a;

        q(String str) {
            this.f11678a = str;
        }

        public Object a() {
            throw new com.google.gson.g(this.f11678a);
        }
    }

    class r implements h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Constructor f11679a;

        r(Constructor constructor) {
            this.f11679a = constructor;
        }

        public Object a() {
            try {
                return this.f11679a.newInstance((Object[]) null);
            } catch (InstantiationException e5) {
                throw new RuntimeException("Failed to invoke constructor '" + C2068a.c(this.f11679a) + "' with no args", e5);
            } catch (InvocationTargetException e6) {
                throw new RuntimeException("Failed to invoke constructor '" + C2068a.c(this.f11679a) + "' with no args", e6.getCause());
            } catch (IllegalAccessException e7) {
                throw C2068a.e(e7);
            }
        }
    }

    public c(Map map, boolean z4, List list) {
        this.f11664a = map;
        this.f11665b = z4;
        this.f11666c = list;
    }

    static String a(Class cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            return "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: " + cls.getName();
        } else if (!Modifier.isAbstract(modifiers)) {
            return null;
        } else {
            return "Abstract classes can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Class name: " + cls.getName();
        }
    }

    private static h c(Class cls, com.google.gson.o oVar) {
        String m4;
        if (Modifier.isAbstract(cls.getModifiers())) {
            return null;
        }
        try {
            Constructor declaredConstructor = cls.getDeclaredConstructor((Class[]) null);
            com.google.gson.o oVar2 = com.google.gson.o.ALLOW;
            if (oVar != oVar2 && (!k.a(declaredConstructor, (Object) null) || (oVar == com.google.gson.o.BLOCK_ALL && !Modifier.isPublic(declaredConstructor.getModifiers())))) {
                return new p("Unable to invoke no-args constructor of " + cls + "; constructor is not accessible and ReflectionAccessFilter does not permit making it accessible. Register an InstanceCreator or a TypeAdapter for this type, change the visibility of the constructor or adjust the access filter.");
            } else if (oVar != oVar2 || (m4 = C2068a.m(declaredConstructor)) == null) {
                return new r(declaredConstructor);
            } else {
                return new q(m4);
            }
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private static h d(Type type, Class cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                return new a();
            }
            if (Set.class.isAssignableFrom(cls)) {
                return new b();
            }
            if (Queue.class.isAssignableFrom(cls)) {
                return new C0170c();
            }
            return new d();
        } else if (!Map.class.isAssignableFrom(cls)) {
            return null;
        } else {
            if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
                return new e();
            }
            if (ConcurrentMap.class.isAssignableFrom(cls)) {
                return new f();
            }
            if (SortedMap.class.isAssignableFrom(cls)) {
                return new g();
            }
            if (type instanceof ParameterizedType) {
                if (!String.class.isAssignableFrom(TypeToken.b(((ParameterizedType) type).getActualTypeArguments()[0]).c())) {
                    return new h();
                }
            }
            return new i();
        }
    }

    private static h e(Type type, Class cls) {
        if (EnumSet.class.isAssignableFrom(cls)) {
            return new n(type);
        }
        if (cls == EnumMap.class) {
            return new o(type);
        }
        return null;
    }

    private h f(Class cls) {
        if (this.f11665b) {
            return new j(cls);
        }
        return new k("Unable to create instance of " + cls + "; usage of JDK Unsafe is disabled. Registering an InstanceCreator or a TypeAdapter for this type, adding a no-args constructor, or enabling usage of JDK Unsafe may fix this problem.");
    }

    public h b(TypeToken typeToken) {
        Type d5 = typeToken.d();
        Class c5 = typeToken.c();
        android.support.v4.media.a.a(this.f11664a.get(d5));
        android.support.v4.media.a.a(this.f11664a.get(c5));
        h e5 = e(d5, c5);
        if (e5 != null) {
            return e5;
        }
        com.google.gson.o b5 = k.b(this.f11666c, c5);
        h c6 = c(c5, b5);
        if (c6 != null) {
            return c6;
        }
        h d6 = d(d5, c5);
        if (d6 != null) {
            return d6;
        }
        String a5 = a(c5);
        if (a5 != null) {
            return new l(a5);
        }
        if (b5 == com.google.gson.o.ALLOW) {
            return f(c5);
        }
        return new m("Unable to create instance of " + c5 + "; ReflectionAccessFilter does not permit using reflection or Unsafe. Register an InstanceCreator or a TypeAdapter for this type or adjust the access filter to allow using reflection.");
    }

    public String toString() {
        return this.f11664a.toString();
    }
}
