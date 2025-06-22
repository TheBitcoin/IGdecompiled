package androidx.lifecycle.viewmodel.internal;

import R2.s;
import S2.C1601o;
import androidx.annotation.MainThread;
import androidx.core.provider.c;
import androidx.leanback.preference.LeanbackPreferenceDialogFragment;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.m;
import o3.J;

public final class ViewModelImpl {
    /* access modifiers changed from: private */
    public final Set<AutoCloseable> closeables;
    private volatile boolean isCleared;
    /* access modifiers changed from: private */
    public final Map<String, AutoCloseable> keyToCloseables;
    private final SynchronizedObject lock;

    public ViewModelImpl() {
        this.lock = new SynchronizedObject();
        this.keyToCloseables = new LinkedHashMap();
        this.closeables = new LinkedHashSet();
    }

    /* access modifiers changed from: private */
    public final void closeWithRuntimeException(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                c.a(autoCloseable);
            } catch (Exception e5) {
                throw new RuntimeException(e5);
            }
        }
    }

    public final void addCloseable(String str, AutoCloseable autoCloseable) {
        AutoCloseable autoCloseable2;
        m.e(str, LeanbackPreferenceDialogFragment.ARG_KEY);
        m.e(autoCloseable, "closeable");
        if (this.isCleared) {
            closeWithRuntimeException(autoCloseable);
            return;
        }
        synchronized (this.lock) {
            autoCloseable2 = (AutoCloseable) this.keyToCloseables.put(str, autoCloseable);
        }
        closeWithRuntimeException(autoCloseable2);
    }

    @MainThread
    public final void clear() {
        if (!this.isCleared) {
            this.isCleared = true;
            synchronized (this.lock) {
                try {
                    for (AutoCloseable access$closeWithRuntimeException : this.keyToCloseables.values()) {
                        closeWithRuntimeException(access$closeWithRuntimeException);
                    }
                    for (AutoCloseable access$closeWithRuntimeException2 : this.closeables) {
                        closeWithRuntimeException(access$closeWithRuntimeException2);
                    }
                    this.closeables.clear();
                    s sVar = s.f8222a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final <T extends AutoCloseable> T getCloseable(String str) {
        T t4;
        m.e(str, LeanbackPreferenceDialogFragment.ARG_KEY);
        synchronized (this.lock) {
            t4 = (AutoCloseable) this.keyToCloseables.get(str);
        }
        return t4;
    }

    public ViewModelImpl(J j4) {
        m.e(j4, "viewModelScope");
        this.lock = new SynchronizedObject();
        this.keyToCloseables = new LinkedHashMap();
        this.closeables = new LinkedHashSet();
        addCloseable(CloseableCoroutineScopeKt.VIEW_MODEL_SCOPE_KEY, CloseableCoroutineScopeKt.asCloseable(j4));
    }

    public final void addCloseable(AutoCloseable autoCloseable) {
        m.e(autoCloseable, "closeable");
        if (this.isCleared) {
            closeWithRuntimeException(autoCloseable);
            return;
        }
        synchronized (this.lock) {
            this.closeables.add(autoCloseable);
            s sVar = s.f8222a;
        }
    }

    public ViewModelImpl(AutoCloseable... autoCloseableArr) {
        m.e(autoCloseableArr, "closeables");
        this.lock = new SynchronizedObject();
        this.keyToCloseables = new LinkedHashMap();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.closeables = linkedHashSet;
        C1601o.v(linkedHashSet, autoCloseableArr);
    }

    public ViewModelImpl(J j4, AutoCloseable... autoCloseableArr) {
        m.e(j4, "viewModelScope");
        m.e(autoCloseableArr, "closeables");
        this.lock = new SynchronizedObject();
        this.keyToCloseables = new LinkedHashMap();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.closeables = linkedHashSet;
        addCloseable(CloseableCoroutineScopeKt.VIEW_MODEL_SCOPE_KEY, CloseableCoroutineScopeKt.asCloseable(j4));
        C1601o.v(linkedHashSet, autoCloseableArr);
    }
}
