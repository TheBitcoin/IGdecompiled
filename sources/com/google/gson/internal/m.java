package com.google.gson.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class m {

    /* renamed from: a  reason: collision with root package name */
    public static final m f11715a = c();

    class a extends m {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Method f11716b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Object f11717c;

        a(Method method, Object obj) {
            this.f11716b = method;
            this.f11717c = obj;
        }

        public Object d(Class cls) {
            m.b(cls);
            return this.f11716b.invoke(this.f11717c, new Object[]{cls});
        }
    }

    class b extends m {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Method f11718b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f11719c;

        b(Method method, int i4) {
            this.f11718b = method;
            this.f11719c = i4;
        }

        public Object d(Class cls) {
            m.b(cls);
            return this.f11718b.invoke((Object) null, new Object[]{cls, Integer.valueOf(this.f11719c)});
        }
    }

    class c extends m {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Method f11720b;

        c(Method method) {
            this.f11720b = method;
        }

        public Object d(Class cls) {
            m.b(cls);
            return this.f11720b.invoke((Object) null, new Object[]{cls, Object.class});
        }
    }

    class d extends m {
        d() {
        }

        public Object d(Class cls) {
            throw new UnsupportedOperationException("Cannot allocate " + cls + ". Usage of JDK sun.misc.Unsafe is enabled, but it could not be used. Make sure your runtime is configured correctly.");
        }
    }

    /* access modifiers changed from: private */
    public static void b(Class cls) {
        String a5 = c.a(cls);
        if (a5 != null) {
            throw new AssertionError("UnsafeAllocator is used for non-instantiable type: " + a5);
        }
    }

    private static m c() {
        Class<ObjectStreamClass> cls = ObjectStreamClass.class;
        Class<Class> cls2 = Class.class;
        try {
            Class<?> cls3 = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls3.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return new a(cls3.getMethod("allocateInstance", new Class[]{cls2}), declaredField.get((Object) null));
        } catch (Exception unused) {
            try {
                Method declaredMethod = cls.getDeclaredMethod("getConstructorId", new Class[]{cls2});
                declaredMethod.setAccessible(true);
                int intValue = ((Integer) declaredMethod.invoke((Object) null, new Object[]{Object.class})).intValue();
                Method declaredMethod2 = cls.getDeclaredMethod("newInstance", new Class[]{cls2, Integer.TYPE});
                declaredMethod2.setAccessible(true);
                return new b(declaredMethod2, intValue);
            } catch (Exception unused2) {
                try {
                    Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", new Class[]{cls2, cls2});
                    declaredMethod3.setAccessible(true);
                    return new c(declaredMethod3);
                } catch (Exception unused3) {
                    return new d();
                }
            }
        }
    }

    public abstract Object d(Class cls);
}
