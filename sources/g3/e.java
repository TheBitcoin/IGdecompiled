package G3;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class e extends RuntimeException {

    /* renamed from: b  reason: collision with root package name */
    private static final Method f23344b;

    /* renamed from: a  reason: collision with root package name */
    private IOException f23345a;

    static {
        Method method;
        Class<Throwable> cls = Throwable.class;
        try {
            method = cls.getDeclaredMethod("addSuppressed", new Class[]{cls});
        } catch (Exception unused) {
            method = null;
        }
        f23344b = method;
    }

    public e(IOException iOException) {
        super(iOException);
        this.f23345a = iOException;
    }

    private void b(IOException iOException, IOException iOException2) {
        Method method = f23344b;
        if (method != null) {
            try {
                method.invoke(iOException, new Object[]{iOException2});
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }

    public void a(IOException iOException) {
        b(iOException, this.f23345a);
        this.f23345a = iOException;
    }

    public IOException c() {
        return this.f23345a;
    }
}
