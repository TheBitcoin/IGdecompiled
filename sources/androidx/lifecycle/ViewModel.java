package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.leanback.preference.LeanbackPreferenceDialogFragment;
import androidx.lifecycle.viewmodel.internal.ViewModelImpl;
import java.io.Closeable;
import java.util.Arrays;
import kotlin.jvm.internal.m;
import o3.J;

public abstract class ViewModel {
    private final ViewModelImpl impl;

    public ViewModel() {
        this.impl = new ViewModelImpl();
    }

    public final void addCloseable(String str, AutoCloseable autoCloseable) {
        m.e(str, LeanbackPreferenceDialogFragment.ARG_KEY);
        m.e(autoCloseable, "closeable");
        ViewModelImpl viewModelImpl = this.impl;
        if (viewModelImpl != null) {
            viewModelImpl.addCloseable(str, autoCloseable);
        }
    }

    @MainThread
    public final void clear$lifecycle_viewmodel_release() {
        ViewModelImpl viewModelImpl = this.impl;
        if (viewModelImpl != null) {
            viewModelImpl.clear();
        }
        onCleared();
    }

    public final <T extends AutoCloseable> T getCloseable(String str) {
        m.e(str, LeanbackPreferenceDialogFragment.ARG_KEY);
        ViewModelImpl viewModelImpl = this.impl;
        if (viewModelImpl != null) {
            return viewModelImpl.getCloseable(str);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
    }

    public void addCloseable(AutoCloseable autoCloseable) {
        m.e(autoCloseable, "closeable");
        ViewModelImpl viewModelImpl = this.impl;
        if (viewModelImpl != null) {
            viewModelImpl.addCloseable(autoCloseable);
        }
    }

    public ViewModel(J j4) {
        m.e(j4, "viewModelScope");
        this.impl = new ViewModelImpl(j4);
    }

    public /* synthetic */ void addCloseable(Closeable closeable) {
        m.e(closeable, "closeable");
        ViewModelImpl viewModelImpl = this.impl;
        if (viewModelImpl != null) {
            viewModelImpl.addCloseable(closeable);
        }
    }

    public ViewModel(AutoCloseable... autoCloseableArr) {
        m.e(autoCloseableArr, "closeables");
        this.impl = new ViewModelImpl((AutoCloseable[]) Arrays.copyOf(autoCloseableArr, autoCloseableArr.length));
    }

    public ViewModel(J j4, AutoCloseable... autoCloseableArr) {
        m.e(j4, "viewModelScope");
        m.e(autoCloseableArr, "closeables");
        this.impl = new ViewModelImpl(j4, (AutoCloseable[]) Arrays.copyOf(autoCloseableArr, autoCloseableArr.length));
    }

    public /* synthetic */ ViewModel(Closeable... closeableArr) {
        m.e(closeableArr, "closeables");
        this.impl = new ViewModelImpl((AutoCloseable[]) Arrays.copyOf(closeableArr, closeableArr.length));
    }
}
