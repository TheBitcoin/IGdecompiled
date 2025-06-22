package l;

import android.view.View;
import android.widget.PopupWindow;

/* renamed from: l.h  reason: case insensitive filesystem */
public final /* synthetic */ class C0949h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PopupWindow f3527a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C0951j f3528b;

    public /* synthetic */ C0949h(PopupWindow popupWindow, C0951j jVar) {
        this.f3527a = popupWindow;
        this.f3528b = jVar;
    }

    public final void onClick(View view) {
        C0951j.p(this.f3527a, this.f3528b, view);
    }
}
