package h1;

import com.google.gson.g;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* renamed from: h1.a  reason: case insensitive filesystem */
public abstract class C2068a {

    /* renamed from: a  reason: collision with root package name */
    private static final b f20792a;

    /* renamed from: h1.a$b */
    private static abstract class b {
        private b() {
        }

        public abstract Method a(Class cls, Field field);

        /* access modifiers changed from: package-private */
        public abstract Constructor b(Class cls);

        /* access modifiers changed from: package-private */
        public abstract String[] c(Class cls);

        /* access modifiers changed from: package-private */
        public abstract boolean d(Class cls);
    }

    /* renamed from: h1.a$c */
    private static class c extends b {
        private c() {
            super();
        }

        public Method a(Class cls, Field field) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        /* access modifiers changed from: package-private */
        public Constructor b(Class cls) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        /* access modifiers changed from: package-private */
        public String[] c(Class cls) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        /* access modifiers changed from: package-private */
        public boolean d(Class cls) {
            return false;
        }
    }

    /* renamed from: h1.a$d */
    private static class d extends b {

        /* renamed from: a  reason: collision with root package name */
        private final Method f20793a;

        /* renamed from: b  reason: collision with root package name */
        private final Method f20794b;

        /* renamed from: c  reason: collision with root package name */
        private final Method f20795c;

        /* renamed from: d  reason: collision with root package name */
        private final Method f20796d;

        public Method a(Class cls, Field field) {
            try {
                return cls.getMethod(field.getName(), (Class[]) null);
            } catch (ReflectiveOperationException e5) {
                throw C2068a.d(e5);
            }
        }

        public Constructor b(Class cls) {
            try {
                Object[] objArr = (Object[]) this.f20794b.invoke(cls, (Object[]) null);
                Class[] clsArr = new Class[objArr.length];
                for (int i4 = 0; i4 < objArr.length; i4++) {
                    clsArr[i4] = (Class) this.f20796d.invoke(objArr[i4], (Object[]) null);
                }
                return cls.getDeclaredConstructor(clsArr);
            } catch (ReflectiveOperationException e5) {
                throw C2068a.d(e5);
            }
        }

        /* access modifiers changed from: package-private */
        public String[] c(Class cls) {
            try {
                Object[] objArr = (Object[]) this.f20794b.invoke(cls, (Object[]) null);
                String[] strArr = new String[objArr.length];
                for (int i4 = 0; i4 < objArr.length; i4++) {
                    strArr[i4] = (String) this.f20795c.invoke(objArr[i4], (Object[]) null);
                }
                return strArr;
            } catch (ReflectiveOperationException e5) {
                throw C2068a.d(e5);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean d(Class cls) {
            try {
                return ((Boolean) this.f20793a.invoke(cls, (Object[]) null)).booleanValue();
            } catch (ReflectiveOperationException e5) {
                throw C2068a.d(e5);
            }
        }

        private d() {
            super();
            Class<Class> cls = Class.class;
            this.f20793a = cls.getMethod("isRecord", (Class[]) null);
            Method method = cls.getMethod("getRecordComponents", (Class[]) null);
            this.f20794b = method;
            Class<?> componentType = method.getReturnType().getComponentType();
            this.f20795c = componentType.getMethod("getName", (Class[]) null);
            this.f20796d = componentType.getMethod("getType", (Class[]) null);
        }
    }

    static {
        b bVar;
        try {
            bVar = new d();
        } catch (NoSuchMethodException unused) {
            bVar = new c();
        }
        f20792a = bVar;
    }

    private static void b(AccessibleObject accessibleObject, StringBuilder sb) {
        Class[] clsArr;
        sb.append('(');
        if (accessibleObject instanceof Method) {
            clsArr = ((Method) accessibleObject).getParameterTypes();
        } else {
            clsArr = ((Constructor) accessibleObject).getParameterTypes();
        }
        for (int i4 = 0; i4 < clsArr.length; i4++) {
            if (i4 > 0) {
                sb.append(", ");
            }
            sb.append(clsArr[i4].getSimpleName());
        }
        sb.append(')');
    }

    public static String c(Constructor constructor) {
        StringBuilder sb = new StringBuilder(constructor.getDeclaringClass().getName());
        b(constructor, sb);
        return sb.toString();
    }

    /* access modifiers changed from: private */
    public static RuntimeException d(ReflectiveOperationException reflectiveOperationException) {
        throw new RuntimeException("Unexpected ReflectiveOperationException occurred (Gson 2.10.1). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", reflectiveOperationException);
    }

    public static RuntimeException e(IllegalAccessException illegalAccessException) {
        throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.10.1). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", illegalAccessException);
    }

    public static String f(Field field) {
        return field.getDeclaringClass().getName() + "#" + field.getName();
    }

    public static String g(AccessibleObject accessibleObject, boolean z4) {
        String str;
        if (accessibleObject instanceof Field) {
            str = "field '" + f((Field) accessibleObject) + "'";
        } else if (accessibleObject instanceof Method) {
            Method method = (Method) accessibleObject;
            StringBuilder sb = new StringBuilder(method.getName());
            b(method, sb);
            str = "method '" + method.getDeclaringClass().getName() + "#" + sb.toString() + "'";
        } else if (accessibleObject instanceof Constructor) {
            str = "constructor '" + c((Constructor) accessibleObject) + "'";
        } else {
            str = "<unknown AccessibleObject> " + accessibleObject.toString();
        }
        if (!z4 || !Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }

    public static Method h(Class cls, Field field) {
        return f20792a.a(cls, field);
    }

    public static Constructor i(Class cls) {
        return f20792a.b(cls);
    }

    public static String[] j(Class cls) {
        return f20792a.c(cls);
    }

    public static boolean k(Class cls) {
        return f20792a.d(cls);
    }

    public static void l(AccessibleObject accessibleObject) {
        try {
            accessibleObject.setAccessible(true);
        } catch (Exception e5) {
            String g4 = g(accessibleObject, false);
            throw new g("Failed making " + g4 + " accessible; either increase its visibility or write a custom TypeAdapter for its declaring type.", e5);
        }
    }

    public static String m(Constructor constructor) {
        try {
            constructor.setAccessible(true);
            return null;
        } catch (Exception e5) {
            return "Failed making constructor '" + c(constructor) + "' accessible; either increase its visibility or write a custom InstanceCreator or TypeAdapter for its declaring type: " + e5.getMessage();
        }
    }
}
