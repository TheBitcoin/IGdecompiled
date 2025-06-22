package androidx.lifecycle;

import android.app.Application;
import androidx.annotation.MainThread;
import androidx.annotation.RestrictTo;
import androidx.leanback.preference.LeanbackPreferenceDialogFragment;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.ViewModelInitializer;
import androidx.lifecycle.viewmodel.ViewModelProviderImpl;
import androidx.lifecycle.viewmodel.internal.DefaultViewModelProviderFactory;
import androidx.lifecycle.viewmodel.internal.JvmViewModelProviders;
import androidx.lifecycle.viewmodel.internal.ViewModelProviders;
import c3.C1704a;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import k3.c;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public class ViewModelProvider {
    public static final Companion Companion = new Companion((C2103g) null);
    public static final CreationExtras.Key<String> VIEW_MODEL_KEY = ViewModelProviders.ViewModelKey.INSTANCE;
    private final ViewModelProviderImpl impl;

    public static final class Companion {
        public /* synthetic */ Companion(C2103g gVar) {
            this();
        }

        public static /* synthetic */ ViewModelProvider create$default(Companion companion, ViewModelStoreOwner viewModelStoreOwner, Factory factory, CreationExtras creationExtras, int i4, Object obj) {
            if ((i4 & 2) != 0) {
                factory = ViewModelProviders.INSTANCE.getDefaultFactory$lifecycle_viewmodel_release(viewModelStoreOwner);
            }
            if ((i4 & 4) != 0) {
                creationExtras = ViewModelProviders.INSTANCE.getDefaultCreationExtras$lifecycle_viewmodel_release(viewModelStoreOwner);
            }
            return companion.create(viewModelStoreOwner, factory, creationExtras);
        }

        public final ViewModelProvider create(ViewModelStoreOwner viewModelStoreOwner, Factory factory, CreationExtras creationExtras) {
            m.e(viewModelStoreOwner, "owner");
            m.e(factory, "factory");
            m.e(creationExtras, "extras");
            return new ViewModelProvider(viewModelStoreOwner.getViewModelStore(), factory, creationExtras);
        }

        private Companion() {
        }

        public final ViewModelProvider create(ViewModelStore viewModelStore, Factory factory, CreationExtras creationExtras) {
            m.e(viewModelStore, "store");
            m.e(factory, "factory");
            m.e(creationExtras, "extras");
            return new ViewModelProvider(viewModelStore, factory, creationExtras);
        }

        public static /* synthetic */ ViewModelProvider create$default(Companion companion, ViewModelStore viewModelStore, Factory factory, CreationExtras creationExtras, int i4, Object obj) {
            if ((i4 & 2) != 0) {
                factory = DefaultViewModelProviderFactory.INSTANCE;
            }
            if ((i4 & 4) != 0) {
                creationExtras = CreationExtras.Empty.INSTANCE;
            }
            return companion.create(viewModelStore, factory, creationExtras);
        }
    }

    public interface Factory {
        public static final Companion Companion = Companion.$$INSTANCE;

        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }

            public final Factory from(ViewModelInitializer<?>... viewModelInitializerArr) {
                m.e(viewModelInitializerArr, "initializers");
                return ViewModelProviders.INSTANCE.createInitializerFactory$lifecycle_viewmodel_release((ViewModelInitializer<?>[]) (ViewModelInitializer[]) Arrays.copyOf(viewModelInitializerArr, viewModelInitializerArr.length));
            }
        }

        <T extends ViewModel> T create(Class<T> cls);

        <T extends ViewModel> T create(Class<T> cls, CreationExtras creationExtras);

        <T extends ViewModel> T create(c cVar, CreationExtras creationExtras);
    }

    public static class NewInstanceFactory implements Factory {
        public static final Companion Companion = new Companion((C2103g) null);
        public static final CreationExtras.Key<String> VIEW_MODEL_KEY = ViewModelProviders.ViewModelKey.INSTANCE;
        /* access modifiers changed from: private */
        public static NewInstanceFactory _instance;

        public static final class Companion {
            public /* synthetic */ Companion(C2103g gVar) {
                this();
            }

            public static /* synthetic */ void getInstance$annotations() {
            }

            @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
            public final NewInstanceFactory getInstance() {
                if (NewInstanceFactory._instance == null) {
                    NewInstanceFactory._instance = new NewInstanceFactory();
                }
                NewInstanceFactory access$get_instance$cp = NewInstanceFactory._instance;
                m.b(access$get_instance$cp);
                return access$get_instance$cp;
            }

            private Companion() {
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final NewInstanceFactory getInstance() {
            return Companion.getInstance();
        }

        public <T extends ViewModel> T create(Class<T> cls) {
            m.e(cls, "modelClass");
            return JvmViewModelProviders.INSTANCE.createViewModel(cls);
        }

        public <T extends ViewModel> T create(Class<T> cls, CreationExtras creationExtras) {
            m.e(cls, "modelClass");
            m.e(creationExtras, "extras");
            return create(cls);
        }

        public <T extends ViewModel> T create(c cVar, CreationExtras creationExtras) {
            m.e(cVar, "modelClass");
            m.e(creationExtras, "extras");
            return create(C1704a.a(cVar), creationExtras);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class OnRequeryFactory {
        public void onRequery(ViewModel viewModel) {
            m.e(viewModel, "viewModel");
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ViewModelProvider(ViewModelStore viewModelStore, Factory factory) {
        this(viewModelStore, factory, (CreationExtras) null, 4, (C2103g) null);
        m.e(viewModelStore, "store");
        m.e(factory, "factory");
    }

    public static final ViewModelProvider create(ViewModelStore viewModelStore, Factory factory, CreationExtras creationExtras) {
        return Companion.create(viewModelStore, factory, creationExtras);
    }

    @MainThread
    public final <T extends ViewModel> T get(c cVar) {
        m.e(cVar, "modelClass");
        return ViewModelProviderImpl.getViewModel$lifecycle_viewmodel_release$default(this.impl, cVar, (String) null, 2, (Object) null);
    }

    public static class AndroidViewModelFactory extends NewInstanceFactory {
        public static final CreationExtras.Key<Application> APPLICATION_KEY = new ViewModelProvider$AndroidViewModelFactory$Companion$APPLICATION_KEY$1();
        public static final Companion Companion = new Companion((C2103g) null);
        /* access modifiers changed from: private */
        public static AndroidViewModelFactory _instance;
        private final Application application;

        public static final class Companion {
            public /* synthetic */ Companion(C2103g gVar) {
                this();
            }

            public final AndroidViewModelFactory getInstance(Application application) {
                m.e(application, MimeTypes.BASE_TYPE_APPLICATION);
                if (AndroidViewModelFactory._instance == null) {
                    AndroidViewModelFactory._instance = new AndroidViewModelFactory(application);
                }
                AndroidViewModelFactory access$get_instance$cp = AndroidViewModelFactory._instance;
                m.b(access$get_instance$cp);
                return access$get_instance$cp;
            }

            private Companion() {
            }
        }

        private AndroidViewModelFactory(Application application2, int i4) {
            this.application = application2;
        }

        public static final AndroidViewModelFactory getInstance(Application application2) {
            return Companion.getInstance(application2);
        }

        public <T extends ViewModel> T create(Class<T> cls, CreationExtras creationExtras) {
            m.e(cls, "modelClass");
            m.e(creationExtras, "extras");
            if (this.application != null) {
                return create(cls);
            }
            Application application2 = (Application) creationExtras.get(APPLICATION_KEY);
            if (application2 != null) {
                return create(cls, application2);
            }
            if (!AndroidViewModel.class.isAssignableFrom(cls)) {
                return super.create(cls);
            }
            throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
        }

        public AndroidViewModelFactory() {
            this((Application) null, 0);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public AndroidViewModelFactory(Application application2) {
            this(application2, 0);
            m.e(application2, MimeTypes.BASE_TYPE_APPLICATION);
        }

        public <T extends ViewModel> T create(Class<T> cls) {
            m.e(cls, "modelClass");
            Application application2 = this.application;
            if (application2 != null) {
                return create(cls, application2);
            }
            throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
        }

        private final <T extends ViewModel> T create(Class<T> cls, Application application2) {
            if (!AndroidViewModel.class.isAssignableFrom(cls)) {
                return super.create(cls);
            }
            try {
                T t4 = (ViewModel) cls.getConstructor(new Class[]{Application.class}).newInstance(new Object[]{application2});
                m.d(t4, "{\n                try {\n…          }\n            }");
                return t4;
            } catch (NoSuchMethodException e5) {
                throw new RuntimeException("Cannot create an instance of " + cls, e5);
            } catch (IllegalAccessException e6) {
                throw new RuntimeException("Cannot create an instance of " + cls, e6);
            } catch (InstantiationException e7) {
                throw new RuntimeException("Cannot create an instance of " + cls, e7);
            } catch (InvocationTargetException e8) {
                throw new RuntimeException("Cannot create an instance of " + cls, e8);
            }
        }
    }

    private ViewModelProvider(ViewModelProviderImpl viewModelProviderImpl) {
        this.impl = viewModelProviderImpl;
    }

    public static final ViewModelProvider create(ViewModelStoreOwner viewModelStoreOwner, Factory factory, CreationExtras creationExtras) {
        return Companion.create(viewModelStoreOwner, factory, creationExtras);
    }

    @MainThread
    public <T extends ViewModel> T get(Class<T> cls) {
        m.e(cls, "modelClass");
        return get(C1704a.c(cls));
    }

    @MainThread
    public final <T extends ViewModel> T get(String str, c cVar) {
        m.e(str, LeanbackPreferenceDialogFragment.ARG_KEY);
        m.e(cVar, "modelClass");
        return this.impl.getViewModel$lifecycle_viewmodel_release(cVar, str);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ViewModelProvider(ViewModelStore viewModelStore, Factory factory, CreationExtras creationExtras, int i4, C2103g gVar) {
        this(viewModelStore, factory, (i4 & 4) != 0 ? CreationExtras.Empty.INSTANCE : creationExtras);
    }

    @MainThread
    public <T extends ViewModel> T get(String str, Class<T> cls) {
        m.e(str, LeanbackPreferenceDialogFragment.ARG_KEY);
        m.e(cls, "modelClass");
        return this.impl.getViewModel$lifecycle_viewmodel_release(C1704a.c(cls), str);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ViewModelProvider(ViewModelStore viewModelStore, Factory factory, CreationExtras creationExtras) {
        this(new ViewModelProviderImpl(viewModelStore, factory, creationExtras));
        m.e(viewModelStore, "store");
        m.e(factory, "factory");
        m.e(creationExtras, "defaultCreationExtras");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ViewModelProvider(androidx.lifecycle.ViewModelStoreOwner r4) {
        /*
            r3 = this;
            java.lang.String r0 = "owner"
            kotlin.jvm.internal.m.e(r4, r0)
            androidx.lifecycle.ViewModelStore r0 = r4.getViewModelStore()
            androidx.lifecycle.viewmodel.internal.ViewModelProviders r1 = androidx.lifecycle.viewmodel.internal.ViewModelProviders.INSTANCE
            androidx.lifecycle.ViewModelProvider$Factory r2 = r1.getDefaultFactory$lifecycle_viewmodel_release(r4)
            androidx.lifecycle.viewmodel.CreationExtras r4 = r1.getDefaultCreationExtras$lifecycle_viewmodel_release(r4)
            r3.<init>(r0, r2, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.ViewModelProvider.<init>(androidx.lifecycle.ViewModelStoreOwner):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ViewModelProvider(ViewModelStoreOwner viewModelStoreOwner, Factory factory) {
        this(viewModelStoreOwner.getViewModelStore(), factory, ViewModelProviders.INSTANCE.getDefaultCreationExtras$lifecycle_viewmodel_release(viewModelStoreOwner));
        m.e(viewModelStoreOwner, "owner");
        m.e(factory, "factory");
    }
}
