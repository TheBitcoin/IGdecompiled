package androidx.window.layout;

import d3.a;
import java.lang.reflect.Method;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

final class SafeWindowLayoutComponentProvider$isWindowLayoutProviderValid$1 extends n implements a {
    final /* synthetic */ ClassLoader $classLoader;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SafeWindowLayoutComponentProvider$isWindowLayoutProviderValid$1(ClassLoader classLoader) {
        super(0);
        this.$classLoader = classLoader;
    }

    public final Boolean invoke() {
        SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = SafeWindowLayoutComponentProvider.INSTANCE;
        Method declaredMethod = safeWindowLayoutComponentProvider.windowExtensionsProviderClass(this.$classLoader).getDeclaredMethod("getWindowExtensions", (Class[]) null);
        Class access$windowExtensionsClass = safeWindowLayoutComponentProvider.windowExtensionsClass(this.$classLoader);
        m.d(declaredMethod, "getWindowExtensionsMethod");
        m.d(access$windowExtensionsClass, "windowExtensionsClass");
        return Boolean.valueOf(safeWindowLayoutComponentProvider.doesReturn(declaredMethod, (Class<?>) access$windowExtensionsClass) && safeWindowLayoutComponentProvider.isPublic(declaredMethod));
    }
}
