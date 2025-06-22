package androidx.window.layout;

import android.graphics.Rect;
import d3.a;
import java.lang.reflect.Method;
import kotlin.jvm.internal.D;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

final class SafeWindowLayoutComponentProvider$isFoldingFeatureValid$1 extends n implements a {
    final /* synthetic */ ClassLoader $classLoader;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SafeWindowLayoutComponentProvider$isFoldingFeatureValid$1(ClassLoader classLoader) {
        super(0);
        this.$classLoader = classLoader;
    }

    public final Boolean invoke() {
        boolean z4;
        SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = SafeWindowLayoutComponentProvider.INSTANCE;
        Class access$foldingFeatureClass = safeWindowLayoutComponentProvider.foldingFeatureClass(this.$classLoader);
        Method method = access$foldingFeatureClass.getMethod("getBounds", (Class[]) null);
        Method method2 = access$foldingFeatureClass.getMethod("getType", (Class[]) null);
        Method method3 = access$foldingFeatureClass.getMethod("getState", (Class[]) null);
        m.d(method, "getBoundsMethod");
        if (safeWindowLayoutComponentProvider.doesReturn(method, D.b(Rect.class)) && safeWindowLayoutComponentProvider.isPublic(method)) {
            m.d(method2, "getTypeMethod");
            Class cls = Integer.TYPE;
            if (safeWindowLayoutComponentProvider.doesReturn(method2, D.b(cls)) && safeWindowLayoutComponentProvider.isPublic(method2)) {
                m.d(method3, "getStateMethod");
                if (safeWindowLayoutComponentProvider.doesReturn(method3, D.b(cls)) && safeWindowLayoutComponentProvider.isPublic(method3)) {
                    z4 = true;
                    return Boolean.valueOf(z4);
                }
            }
        }
        z4 = false;
        return Boolean.valueOf(z4);
    }
}
