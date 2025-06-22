package androidx.core.view;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

/* renamed from: androidx.core.view.y  reason: case insensitive filesystem */
public final /* synthetic */ class C0481y implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f927a;

    public /* synthetic */ C0481y(View view) {
        this.f927a = view;
    }

    public final void run() {
        ((InputMethodManager) this.f927a.getContext().getSystemService("input_method")).showSoftInput(this.f927a, 0);
    }
}
