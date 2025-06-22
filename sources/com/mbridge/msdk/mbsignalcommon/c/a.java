package com.mbridge.msdk.mbsignalcommon.c;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.af;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static C0188a f14050a;

    /* renamed from: com.mbridge.msdk.mbsignalcommon.c.a$a  reason: collision with other inner class name */
    public interface C0188a {
        boolean a(b.C0189a aVar);
    }

    public static abstract class b {

        /* renamed from: com.mbridge.msdk.mbsignalcommon.c.a$b$a  reason: collision with other inner class name */
        public static class C0189a extends Throwable {

            /* renamed from: a  reason: collision with root package name */
            private Class<?> f14051a;

            /* renamed from: b  reason: collision with root package name */
            private String f14052b;

            public C0189a(String str) {
                super(str);
            }

            public final void a(Class<?> cls) {
                this.f14051a = cls;
            }

            public final String toString() {
                if (getCause() == null) {
                    return super.toString();
                }
                return C0189a.class.getName() + ": " + getCause();
            }

            public C0189a(Exception exc) {
                super(exc);
            }

            public final void a(String str) {
                this.f14052b = str;
            }
        }
    }

    public static class c<C> {

        /* renamed from: a  reason: collision with root package name */
        protected Class<C> f14053a;

        public c(Class<C> cls) {
            this.f14053a = cls;
        }

        public final d a(String str, Class<?>... clsArr) throws b.C0189a {
            return new d(this.f14053a, str, clsArr, 0);
        }
    }

    /* access modifiers changed from: private */
    public static void b(b.C0189a aVar) throws b.C0189a {
        C0188a aVar2 = f14050a;
        if (aVar2 == null || !aVar2.a(aVar)) {
            throw aVar;
        }
    }

    public static <T> c<T> a(ClassLoader classLoader, String str) throws b.C0189a {
        try {
            return new c<>(classLoader.loadClass(str));
        } catch (Exception e5) {
            b(new b.C0189a(e5));
            return new c<>((Class) null);
        }
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        protected final Method f14054a;

        d(Class<?> cls, String str, Class<?>[] clsArr, int i4) throws b.C0189a {
            Method method = null;
            Class<? super Object> cls2 = cls;
            if (cls == null) {
                this.f14054a = null;
                return;
            }
            while (true) {
                Class<Object> cls3 = Object.class;
                if (cls2 == cls3 || cls2 == null) {
                    break;
                }
                try {
                    method = cls2.getDeclaredMethod(str, clsArr);
                    break;
                } catch (NoSuchMethodException e5) {
                    if (MBridgeConstans.DEBUG && cls2.getSuperclass() == cls3) {
                        e5.printStackTrace();
                    }
                } catch (SecurityException e6) {
                    try {
                        if (MBridgeConstans.DEBUG && cls2.getSuperclass() == cls3) {
                            e6.printStackTrace();
                        }
                    } catch (Exception e7) {
                        b.C0189a aVar = new b.C0189a(e7);
                        aVar.a(cls2);
                        aVar.a(str);
                        a.b(aVar);
                    } catch (Throwable th) {
                        this.f14054a = null;
                        throw th;
                    }
                }
                cls2 = cls2.getSuperclass();
            }
            if (method != null) {
                if (i4 > 0 && (method.getModifiers() & i4) != i4) {
                    a.b(new b.C0189a(method + " does not match modifiers: " + i4));
                }
                method.setAccessible(true);
            }
            this.f14054a = method;
        }

        public final Object a(Object obj, Object... objArr) throws IllegalArgumentException, InvocationTargetException {
            Method method = this.f14054a;
            if (method == null) {
                return null;
            }
            try {
                return method.invoke(obj, objArr);
            } catch (Exception e5) {
                af.a("MappingedMethod", "invoke error:" + e5.getMessage());
                return null;
            }
        }

        public final Method a() {
            return this.f14054a;
        }
    }
}
