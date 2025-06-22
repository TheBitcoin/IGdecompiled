package androidx.lifecycle;

import S2.C1594h;
import S2.C1601o;
import android.app.Application;
import androidx.annotation.RestrictTo;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.m;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class SavedStateViewModelFactoryKt {
    /* access modifiers changed from: private */
    public static final List<Class<?>> ANDROID_VIEWMODEL_SIGNATURE;
    /* access modifiers changed from: private */
    public static final List<Class<?>> VIEWMODEL_SIGNATURE;

    static {
        Class<SavedStateHandle> cls = SavedStateHandle.class;
        ANDROID_VIEWMODEL_SIGNATURE = C1601o.k(Application.class, cls);
        VIEWMODEL_SIGNATURE = C1601o.e(cls);
    }

    public static final <T> Constructor<T> findMatchingConstructor(Class<T> cls, List<? extends Class<?>> list) {
        m.e(cls, "modelClass");
        m.e(list, "signature");
        Constructor<T>[] constructors = cls.getConstructors();
        m.d(constructors, "modelClass.constructors");
        int length = constructors.length;
        int i4 = 0;
        while (i4 < length) {
            Constructor<T> constructor = constructors[i4];
            Class[] parameterTypes = constructor.getParameterTypes();
            m.d(parameterTypes, "constructor.parameterTypes");
            List I4 = C1594h.I(parameterTypes);
            if (m.a(list, I4)) {
                m.c(constructor, "null cannot be cast to non-null type java.lang.reflect.Constructor<T of androidx.lifecycle.SavedStateViewModelFactoryKt.findMatchingConstructor>");
                return constructor;
            } else if (list.size() != I4.size() || !I4.containsAll(list)) {
                i4++;
            } else {
                throw new UnsupportedOperationException("Class " + cls.getSimpleName() + " must have parameters in the proper order: " + list);
            }
        }
        return null;
    }

    public static final <T extends ViewModel> T newInstance(Class<T> cls, Constructor<T> constructor, Object... objArr) {
        m.e(cls, "modelClass");
        m.e(constructor, "constructor");
        m.e(objArr, "params");
        try {
            return (ViewModel) constructor.newInstance(Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException e5) {
            throw new RuntimeException("Failed to access " + cls, e5);
        } catch (InstantiationException e6) {
            throw new RuntimeException("A " + cls + " cannot be instantiated.", e6);
        } catch (InvocationTargetException e7) {
            throw new RuntimeException("An exception happened in constructor of " + cls, e7.getCause());
        }
    }
}
