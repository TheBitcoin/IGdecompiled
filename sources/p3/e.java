package p3;

import R2.m;
import R2.n;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import kotlin.jvm.internal.C2103g;

public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    public static final d f3937a;
    private static volatile Choreographer choreographer;

    static {
        Object obj;
        d dVar = null;
        try {
            m.a aVar = m.f8216a;
            obj = m.a(new c(a(Looper.getMainLooper(), true), (String) null, 2, (C2103g) null));
        } catch (Throwable th) {
            m.a aVar2 = m.f8216a;
            obj = m.a(n.a(th));
        }
        if (!m.c(obj)) {
            dVar = obj;
        }
        f3937a = dVar;
    }

    public static final Handler a(Looper looper, boolean z4) {
        if (!z4) {
            return new Handler(looper);
        }
        Class<Looper> cls = Looper.class;
        Class<Handler> cls2 = Handler.class;
        if (Build.VERSION.SDK_INT >= 28) {
            Object invoke = cls2.getDeclaredMethod("createAsync", new Class[]{cls}).invoke((Object) null, new Object[]{looper});
            kotlin.jvm.internal.m.c(invoke, "null cannot be cast to non-null type android.os.Handler");
            return (Handler) invoke;
        }
        try {
            return cls2.getDeclaredConstructor(new Class[]{cls, Handler.Callback.class, Boolean.TYPE}).newInstance(new Object[]{looper, null, Boolean.TRUE});
        } catch (NoSuchMethodException unused) {
            return new Handler(looper);
        }
    }
}
