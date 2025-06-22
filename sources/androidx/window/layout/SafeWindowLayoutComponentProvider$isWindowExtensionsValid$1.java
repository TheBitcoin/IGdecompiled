package androidx.window.layout;

import d3.a;
import java.lang.reflect.Method;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

final class SafeWindowLayoutComponentProvider$isWindowExtensionsValid$1 extends n implements a {
    final /* synthetic */ ClassLoader $classLoader;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SafeWindowLayoutComponentProvider$isWindowExtensionsValid$1(ClassLoader classLoader) {
        super(0);
        this.$classLoader = classLoader;
    }

    public final Boolean invoke() {
        boolean z4;
        SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = SafeWindowLayoutComponentProvider.INSTANCE;
        Method method = safeWindowLayoutComponentProvider.windowExtensionsClass(this.$classLoader).getMethod("getWindowLayoutComponent", (Class[]) null);
        Class access$windowLayoutComponentClass = safeWindowLayoutComponentProvider.windowLayoutComponentClass(this.$classLoader);
        m.d(method, "getWindowLayoutComponentMethod");
        if (safeWindowLayoutComponentProvider.isPublic(method)) {
            m.d(access$windowLayoutComponentClass, "windowLayoutComponentClass");
            if (safeWindowLayoutComponentProvider.doesReturn(method, (Class<?>) access$windowLayoutComponentClass)) {
                z4 = true;
                return Boolean.valueOf(z4);
            }
        }
        z4 = false;
        return Boolean.valueOf(z4);
    }
}
