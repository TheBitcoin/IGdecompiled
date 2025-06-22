package kotlin.jvm.internal;

import S2.C1601o;
import S2.H;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import c3.C1704a;
import d3.b;
import d3.d;
import d3.e;
import d3.f;
import d3.g;
import d3.h;
import d3.i;
import d3.j;
import d3.k;
import d3.l;
import d3.n;
import d3.o;
import d3.p;
import d3.q;
import d3.r;
import d3.s;
import d3.t;
import d3.u;
import d3.v;
import d3.w;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import k3.c;
import m3.m;

/* renamed from: kotlin.jvm.internal.e  reason: case insensitive filesystem */
public final class C2101e implements c, C2100d {

    /* renamed from: b  reason: collision with root package name */
    public static final a f20975b = new a((C2103g) null);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final Map f20976c;

    /* renamed from: d  reason: collision with root package name */
    private static final HashMap f20977d;

    /* renamed from: e  reason: collision with root package name */
    private static final HashMap f20978e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final HashMap f20979f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final Map f20980g;

    /* renamed from: a  reason: collision with root package name */
    private final Class f20981a;

    /* renamed from: kotlin.jvm.internal.e$a */
    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        public final String a(Class cls) {
            String str;
            m.e(cls, "jClass");
            String str2 = null;
            if (cls.isAnonymousClass() || cls.isLocalClass()) {
                return null;
            }
            if (cls.isArray()) {
                Class<?> componentType = cls.getComponentType();
                if (componentType.isPrimitive() && (str = (String) C2101e.f20979f.get(componentType.getName())) != null) {
                    str2 = str + "Array";
                }
                if (str2 == null) {
                    return "kotlin.Array";
                }
                return str2;
            }
            String str3 = (String) C2101e.f20979f.get(cls.getName());
            if (str3 == null) {
                return cls.getCanonicalName();
            }
            return str3;
        }

        public final String b(Class cls) {
            String str;
            m.e(cls, "jClass");
            String str2 = null;
            if (cls.isAnonymousClass()) {
                return null;
            }
            if (cls.isLocalClass()) {
                String simpleName = cls.getSimpleName();
                Method enclosingMethod = cls.getEnclosingMethod();
                if (enclosingMethod != null) {
                    m.b(simpleName);
                    String r02 = m.r0(simpleName, enclosingMethod.getName() + '$', (String) null, 2, (Object) null);
                    if (r02 != null) {
                        return r02;
                    }
                }
                Constructor<?> enclosingConstructor = cls.getEnclosingConstructor();
                if (enclosingConstructor != null) {
                    m.b(simpleName);
                    return m.r0(simpleName, enclosingConstructor.getName() + '$', (String) null, 2, (Object) null);
                }
                m.b(simpleName);
                return m.q0(simpleName, '$', (String) null, 2, (Object) null);
            } else if (cls.isArray()) {
                Class<?> componentType = cls.getComponentType();
                if (componentType.isPrimitive() && (str = (String) C2101e.f20980g.get(componentType.getName())) != null) {
                    str2 = str + "Array";
                }
                if (str2 == null) {
                    return "Array";
                }
                return str2;
            } else {
                String str3 = (String) C2101e.f20980g.get(cls.getName());
                if (str3 == null) {
                    return cls.getSimpleName();
                }
                return str3;
            }
        }

        public final boolean c(Object obj, Class cls) {
            m.e(cls, "jClass");
            Map f4 = C2101e.f20976c;
            m.c(f4, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
            Integer num = (Integer) f4.get(cls);
            if (num != null) {
                return G.e(obj, num.intValue());
            }
            if (cls.isPrimitive()) {
                cls = C1704a.b(C1704a.c(cls));
            }
            return cls.isInstance(obj);
        }

        private a() {
        }
    }

    static {
        int i4 = 0;
        Iterable k4 = C1601o.k(d3.a.class, l.class, p.class, q.class, r.class, s.class, t.class, u.class, v.class, w.class, b.class, d3.c.class, d.class, e.class, f.class, g.class, h.class, i.class, j.class, k.class, d3.m.class, n.class, o.class);
        ArrayList arrayList = new ArrayList(C1601o.p(k4, 10));
        for (Object next : k4) {
            int i5 = i4 + 1;
            if (i4 < 0) {
                C1601o.o();
            }
            arrayList.add(R2.p.a((Class) next, Integer.valueOf(i4)));
            i4 = i5;
        }
        f20976c = H.p(arrayList);
        HashMap hashMap = new HashMap();
        hashMap.put(TypedValues.Custom.S_BOOLEAN, "kotlin.Boolean");
        hashMap.put("char", "kotlin.Char");
        hashMap.put("byte", "kotlin.Byte");
        hashMap.put("short", "kotlin.Short");
        hashMap.put("int", "kotlin.Int");
        hashMap.put(TypedValues.Custom.S_FLOAT, "kotlin.Float");
        hashMap.put("long", "kotlin.Long");
        hashMap.put("double", "kotlin.Double");
        f20977d = hashMap;
        HashMap hashMap2 = new HashMap();
        hashMap2.put("java.lang.Boolean", "kotlin.Boolean");
        hashMap2.put("java.lang.Character", "kotlin.Char");
        hashMap2.put("java.lang.Byte", "kotlin.Byte");
        hashMap2.put("java.lang.Short", "kotlin.Short");
        hashMap2.put("java.lang.Integer", "kotlin.Int");
        hashMap2.put("java.lang.Float", "kotlin.Float");
        hashMap2.put("java.lang.Long", "kotlin.Long");
        hashMap2.put("java.lang.Double", "kotlin.Double");
        f20978e = hashMap2;
        HashMap hashMap3 = new HashMap();
        hashMap3.put("java.lang.Object", "kotlin.Any");
        hashMap3.put("java.lang.String", "kotlin.String");
        hashMap3.put("java.lang.CharSequence", "kotlin.CharSequence");
        hashMap3.put("java.lang.Throwable", "kotlin.Throwable");
        hashMap3.put("java.lang.Cloneable", "kotlin.Cloneable");
        hashMap3.put("java.lang.Number", "kotlin.Number");
        hashMap3.put("java.lang.Comparable", "kotlin.Comparable");
        hashMap3.put("java.lang.Enum", "kotlin.Enum");
        hashMap3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        hashMap3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        hashMap3.put("java.util.Iterator", "kotlin.collections.Iterator");
        hashMap3.put("java.util.Collection", "kotlin.collections.Collection");
        hashMap3.put("java.util.List", "kotlin.collections.List");
        hashMap3.put("java.util.Set", "kotlin.collections.Set");
        hashMap3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        hashMap3.put("java.util.Map", "kotlin.collections.Map");
        hashMap3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        hashMap3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        hashMap3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        hashMap3.putAll(hashMap);
        hashMap3.putAll(hashMap2);
        Collection<String> values = hashMap.values();
        m.d(values, "<get-values>(...)");
        for (String str : values) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            m.b(str);
            sb.append(m.t0(str, '.', (String) null, 2, (Object) null));
            sb.append("CompanionObject");
            String sb2 = sb.toString();
            R2.l a5 = R2.p.a(sb2, str + ".Companion");
            hashMap3.put(a5.c(), a5.d());
        }
        for (Map.Entry entry : f20976c.entrySet()) {
            int intValue = ((Number) entry.getValue()).intValue();
            String name = ((Class) entry.getKey()).getName();
            hashMap3.put(name, "kotlin.Function" + intValue);
        }
        f20979f = hashMap3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(H.d(hashMap3.size()));
        for (Map.Entry entry2 : hashMap3.entrySet()) {
            linkedHashMap.put(entry2.getKey(), m.t0((String) entry2.getValue(), '.', (String) null, 2, (Object) null));
        }
        f20980g = linkedHashMap;
    }

    public C2101e(Class cls) {
        m.e(cls, "jClass");
        this.f20981a = cls;
    }

    public String a() {
        return f20975b.a(d());
    }

    public String b() {
        return f20975b.b(d());
    }

    public boolean c(Object obj) {
        return f20975b.c(obj, d());
    }

    public Class d() {
        return this.f20981a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C2101e) || !m.a(C1704a.b(this), C1704a.b((c) obj))) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return C1704a.b(this).hashCode();
    }

    public String toString() {
        return d().toString() + " (Kotlin reflection is not available)";
    }
}
