package androidx.appcompat.app;

import android.view.KeyEvent;
import androidx.core.view.KeyEventDispatcher;

public final /* synthetic */ class r implements KeyEventDispatcher.Component {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppCompatDialog f800a;

    public /* synthetic */ r(AppCompatDialog appCompatDialog) {
        this.f800a = appCompatDialog;
    }

    public final boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return this.f800a.superDispatchKeyEvent(keyEvent);
    }
}
