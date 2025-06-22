package androidx.loader.app;

import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class LoaderManager {

    public interface LoaderCallbacks<D> {
        @MainThread
        @NonNull
        Loader<D> onCreateLoader(int i4, @Nullable Bundle bundle);

        @MainThread
        void onLoadFinished(@NonNull Loader<D> loader, D d5);

        @MainThread
        void onLoaderReset(@NonNull Loader<D> loader);
    }

    public static void enableDebugLogging(boolean z4) {
        LoaderManagerImpl.DEBUG = z4;
    }

    @NonNull
    public static <T extends LifecycleOwner & ViewModelStoreOwner> LoaderManager getInstance(@NonNull T t4) {
        return new LoaderManagerImpl(t4, ((ViewModelStoreOwner) t4).getViewModelStore());
    }

    @MainThread
    public abstract void destroyLoader(int i4);

    @Deprecated
    public abstract void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    @Nullable
    public abstract <D> Loader<D> getLoader(int i4);

    public boolean hasRunningLoaders() {
        return false;
    }

    @MainThread
    @NonNull
    public abstract <D> Loader<D> initLoader(int i4, @Nullable Bundle bundle, @NonNull LoaderCallbacks<D> loaderCallbacks);

    public abstract void markForRedelivery();

    @MainThread
    @NonNull
    public abstract <D> Loader<D> restartLoader(int i4, @Nullable Bundle bundle, @NonNull LoaderCallbacks<D> loaderCallbacks);
}
