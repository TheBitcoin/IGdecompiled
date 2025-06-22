package t3;

import java.util.Collection;
import java.util.ServiceLoader;
import l3.h;
import o3.H;

/* renamed from: t3.g  reason: case insensitive filesystem */
public abstract class C1057g {

    /* renamed from: a  reason: collision with root package name */
    private static final Collection f4493a;

    static {
        Class<H> cls = H.class;
        f4493a = h.o(h.c(ServiceLoader.load(cls, cls.getClassLoader()).iterator()));
    }

    public static final Collection a() {
        return f4493a;
    }

    public static final void b(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }
}
