package androidx.window.layout;

import android.app.Activity;
import d3.a;
import java.lang.reflect.Method;
import java.util.function.Consumer;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

final class SafeWindowLayoutComponentProvider$isWindowLayoutComponentValid$1 extends n implements a {
    final /* synthetic */ ClassLoader $classLoader;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SafeWindowLayoutComponentProvider$isWindowLayoutComponentValid$1(ClassLoader classLoader) {
        super(0);
        this.$classLoader = classLoader;
    }

    public final Boolean invoke() {
        SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = SafeWindowLayoutComponentProvider.INSTANCE;
        Class access$windowLayoutComponentClass = safeWindowLayoutComponentProvider.windowLayoutComponentClass(this.$classLoader);
        Class<Consumer> cls = Consumer.class;
        boolean z4 = false;
        Method method = access$windowLayoutComponentClass.getMethod("addWindowLayoutInfoListener", new Class[]{Activity.class, cls});
        Method method2 = access$windowLayoutComponentClass.getMethod("removeWindowLayoutInfoListener", new Class[]{cls});
        m.d(method, "addListenerMethod");
        if (safeWindowLayoutComponentProvider.isPublic(method)) {
            m.d(method2, "removeListenerMethod");
            if (safeWindowLayoutComponentProvider.isPublic(method2)) {
                z4 = true;
            }
        }
        return Boolean.valueOf(z4);
    }
}
