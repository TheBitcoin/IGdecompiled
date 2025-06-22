package p3;

import V2.a;
import V2.g;
import android.os.Build;
import java.lang.Thread;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import o3.H;

public final class b extends a implements H {
    private volatile Object _preHandler = this;

    public b() {
        super(H.f3655j0);
    }

    private final Method D() {
        Object obj = this._preHandler;
        if (obj != this) {
            return (Method) obj;
        }
        Method method = null;
        try {
            Method declaredMethod = Thread.class.getDeclaredMethod("getUncaughtExceptionPreHandler", (Class[]) null);
            if (Modifier.isPublic(declaredMethod.getModifiers()) && Modifier.isStatic(declaredMethod.getModifiers())) {
                method = declaredMethod;
            }
        } catch (Throwable unused) {
        }
        this._preHandler = method;
        return method;
    }

    public void r(g gVar, Throwable th) {
        Object obj;
        int i4 = Build.VERSION.SDK_INT;
        if (26 <= i4 && i4 < 28) {
            Method D4 = D();
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = null;
            if (D4 != null) {
                obj = D4.invoke((Object) null, (Object[]) null);
            } else {
                obj = null;
            }
            if (obj instanceof Thread.UncaughtExceptionHandler) {
                uncaughtExceptionHandler = (Thread.UncaughtExceptionHandler) obj;
            }
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
            }
        }
    }
}
