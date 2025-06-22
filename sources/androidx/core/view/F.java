package androidx.core.view;

import android.view.WindowInsetsController;
import androidx.core.view.SoftwareKeyboardControllerCompat;
import java.util.concurrent.atomic.AtomicBoolean;

public final /* synthetic */ class F implements WindowInsetsController.OnControllableInsetsChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f909a;

    public /* synthetic */ F(AtomicBoolean atomicBoolean) {
        this.f909a = atomicBoolean;
    }

    public final void onControllableInsetsChanged(WindowInsetsController windowInsetsController, int i4) {
        SoftwareKeyboardControllerCompat.Impl30.b(this.f909a, windowInsetsController, i4);
    }
}
