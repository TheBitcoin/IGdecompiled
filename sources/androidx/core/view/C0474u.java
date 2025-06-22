package androidx.core.view;

import android.view.MotionEvent;
import android.view.View;

/* renamed from: androidx.core.view.u  reason: case insensitive filesystem */
public final /* synthetic */ class C0474u implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DragStartHelper f921a;

    public /* synthetic */ C0474u(DragStartHelper dragStartHelper) {
        this.f921a = dragStartHelper;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f921a.onTouch(view, motionEvent);
    }
}
