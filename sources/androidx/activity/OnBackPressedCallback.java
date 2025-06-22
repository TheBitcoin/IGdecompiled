package androidx.activity;

import androidx.annotation.MainThread;
import d3.a;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.m;

public abstract class OnBackPressedCallback {
    private final CopyOnWriteArrayList<Cancellable> cancellables = new CopyOnWriteArrayList<>();
    private a enabledChangedCallback;
    private boolean isEnabled;

    public OnBackPressedCallback(boolean z4) {
        this.isEnabled = z4;
    }

    public final void addCancellable(Cancellable cancellable) {
        m.e(cancellable, "cancellable");
        this.cancellables.add(cancellable);
    }

    public final a getEnabledChangedCallback$activity_release() {
        return this.enabledChangedCallback;
    }

    @MainThread
    public void handleOnBackCancelled() {
    }

    @MainThread
    public abstract void handleOnBackPressed();

    @MainThread
    public void handleOnBackProgressed(BackEventCompat backEventCompat) {
        m.e(backEventCompat, "backEvent");
    }

    @MainThread
    public void handleOnBackStarted(BackEventCompat backEventCompat) {
        m.e(backEventCompat, "backEvent");
    }

    @MainThread
    public final boolean isEnabled() {
        return this.isEnabled;
    }

    @MainThread
    public final void remove() {
        for (Cancellable cancel : this.cancellables) {
            cancel.cancel();
        }
    }

    public final void removeCancellable(Cancellable cancellable) {
        m.e(cancellable, "cancellable");
        this.cancellables.remove(cancellable);
    }

    @MainThread
    public final void setEnabled(boolean z4) {
        this.isEnabled = z4;
        a aVar = this.enabledChangedCallback;
        if (aVar != null) {
            aVar.invoke();
        }
    }

    public final void setEnabledChangedCallback$activity_release(a aVar) {
        this.enabledChangedCallback = aVar;
    }
}
