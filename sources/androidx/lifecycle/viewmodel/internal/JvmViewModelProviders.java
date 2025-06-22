package androidx.lifecycle.viewmodel.internal;

import androidx.lifecycle.ViewModel;
import kotlin.jvm.internal.m;

public final class JvmViewModelProviders {
    public static final JvmViewModelProviders INSTANCE = new JvmViewModelProviders();

    private JvmViewModelProviders() {
    }

    public final <T extends ViewModel> T createViewModel(Class<T> cls) {
        m.e(cls, "modelClass");
        try {
            T newInstance = cls.getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
            m.d(newInstance, "{\n            modelClass…).newInstance()\n        }");
            return (ViewModel) newInstance;
        } catch (NoSuchMethodException e5) {
            throw new RuntimeException("Cannot create an instance of " + cls, e5);
        } catch (InstantiationException e6) {
            throw new RuntimeException("Cannot create an instance of " + cls, e6);
        } catch (IllegalAccessException e7) {
            throw new RuntimeException("Cannot create an instance of " + cls, e7);
        }
    }
}
