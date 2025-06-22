package androidx.core.view;

import android.view.View;

/* renamed from: androidx.core.view.t  reason: case insensitive filesystem */
public final /* synthetic */ class C0472t implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DragStartHelper f920a;

    public /* synthetic */ C0472t(DragStartHelper dragStartHelper) {
        this.f920a = dragStartHelper;
    }

    public final boolean onLongClick(View view) {
        return this.f920a.onLongClick(view);
    }
}
